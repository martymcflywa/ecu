<?php

namespace includes;

/**
 * Class ValidateData contains data and functions to perform validation
 * on Student and Unit data.
 *
 * @author Martin Ponce, 10371381
 * @version 20150904
 * @package includes
 */
class Validator {

    // import references to student/unit/rules objects
    private $theStudent;
    private $theUnits;
    private $theRules;

    // import references to student/unitDetails arrays
    // note: avoid shadowing variable names for arrays, causes array to string conversion error
    private $studentDetailsArray;
    private $unitDetailsArray;

    // error tallies and arrays
    private $studentErrorTally;
    private $studentErrorMessage;
    private $unitErrorTally;
    private $unitErrorMessage;
    private $logicErrorTally;
    private $logicErrorMessage;

    // column index for student/unitErrorMessage
    const E_ROW = 0;
    const E_FIELD = 1;
    const E_ECODE = 2;

    // student/unitErrorMessage
    // | 0   | 1     | 2     |
    // | row | field | ecode |

    // column index for logicErrorMessage
    const LE_FIELD = 0;
    const LE_ECODE = 1;
    const LE_SEM = 2;
    const LE_ROW_1 = 3;
    const LE_ROW_2 = 4;

    // logicErrorMessage
    // | 0     | 1     | 2   | 3    | 4    |
    // | field | ecode | sem | row1 | row2 |

    // regex dictionary and error codes
    private $regExDict;
    private $errorCode;

    /**
     * The constructor for ValidateData class.
     *
     * @param Student $theStudent - An instance of the Student class.
     * @param Units $theUnits - An instance of the Units class
     * @param BusinessRules $theRules - An instance of the BusinessRules class.
     */
    function __construct(Student $theStudent, Units $theUnits, BusinessRules $theRules) {

        // import student/unit/rules classes
        $this->theStudent = $theStudent;
        $this->theUnits = $theUnits;
        $this->theRules = $theRules;

        // build regex and error code definitions
        $this->buildRegExDict();
        $this->buildErrorCode();

        // then call the methods to validate received data
        //$this->validateStudentDetails();
        //$this->validateUnitDetails();
    }

    /**
     * This function initiates the validation for
     * student and unit input, as well as logical.
     */
    private final function startValidation() {
        $this->validateStudentDetails();
        $this->validateUnitDetails();
        $this->validateLogic();
    }

    /**
     * This function validates student details.
     * Tests each array index for population before proceeding.
     */
    private final function validateStudentDetails() {

        // validate names
        if(strlen($this->studentDetailsArray[Student::FN]) > 0) {
            if(!preg_match($this->regExDict["name"], $this->studentDetailsArray[Student::FN])) {
                $this->validateError("student", -1, "Firstname", 1);
            }
        }

        if(strlen($this->studentDetailsArray[Student::SN]) > 0) {
            if(!preg_match($this->regExDict["name"], $this->studentDetailsArray[Student::SN])) {
                $this->validateError("student", -1, "Surname", 1);
            }
        }

        // validate student id
        if(strlen($this->studentDetailsArray[Student::ID]) > 0) {
            if(!preg_match($this->regExDict["studentID"], $this->studentDetailsArray[Student::ID])) {
                $this->validateError("student", -1, "Surname", 1);
            }
        }
    }

    /**
     * This function validates unit details.
     * Tests each array index for population before proceeding.
     */
    private final function validateUnitDetails() {

        // iterate each row
        for($i = 0; $i < sizeof($this->unitDetailsArray); $i++) {

            /*************
             * UNIT CODE *
             *************/

            if(strlen($this->unitDetailsArray[$i][Units::UC]) == 0) {
                $this->missingInputError("unit", $i + 1, "Unit Code");
            } else {
                $this->validateUnitCode($i);
            }

            /*****************
             * CREDIT POINTS *
             *****************/

            if(strlen($this->unitDetailsArray[$i][Units::CP]) == 0) {
                $this->missingInputError("unit", $i + 1, "Credit Points");
            } else {
                $this->validateCreditPoints($i);
            }

            /**************
             * YEAR / SEM *
             **************/

            if(strlen($this->unitDetailsArray[$i][Units::YS]) == 0) {
                $this->missingInputError("unit", $i + 1, "Year / Semester");
            } else {
                $this->validateYearSem($i);
            }

            /*************
             * UNIT MARK *
             *************/

            if(strlen($this->unitDetailsArray[$i][Units::UM]) == 0) {
                $this->missingInputError("units", $i + 1, "Unit Mark");
            } else {
                $this->validateUnitMark($i);
            }
        }
    }

    /**
     * This function validates Unit Code using regex, @see buildRegExDict().
     * To be used inside for loop, @see validateUnitDetails().
     *
     * @param int $index - The current array index.
     */
    private final function validateUnitCode($index) {

        // if unit code is valid
        if(preg_match($this->regExDict["unitCode"], $this->unitDetailsArray[$index][Units::UC])) {

            // test course type against unit code (wow this is a mouthful in php!)
            if(($this->studentDetailsArray[Student::CT] == BusinessRules::CT_UNDERGRAD ||
                    $this->studentDetailsArray[Student::CT] == BusinessRules::CT_UNDERGRAD_DOUBLE) &&
                    (preg_grep($this->regExDict["unitCodeSuffix"], $this->unitDetailsArray[$index][Units::UC]) >= 6000)) {

                $this->validateError("unit", $index + 1, "Unit Code", 3);
            }

        } else {
            $this->validateError("unit", $index + 1, "Unit Code", 4);
        }
    }

    /**
     * This function validates Credit Points using regex, @see buildRegExDict().
     * To be used inside for loop, @see validateUnitDetails().
     *
     * @param int $index - The current array index.
     */
    private final function validateCreditPoints($index) {

        // if credit points is valid
        if(preg_match($this->regExDict["creditPoints"], $this->unitDetailsArray[$index][Units::CP])) {
            // cast to int so we can do math with it
            $this->unitDetailsArray[$index][Units::CP] = intval($this->unitDetailsArray[$index][Units::CP]);
        } else {
            $this->validateError("unit", $index + 1, "Credit Points", 5);
        }
    }

    /**
     * This function validates Year / Sem using regex, @see buildRegExDict().
     * To be used inside for loop, @see validateUnitDetails().
     *
     * @param int $index - The current array index.
     */
    private final function validateYearSem($index) {

        if(!preg_match($this->regExDict["yearSem"], $this->unitDetailsArray[$index][Units::YS])) {
            $this->validateError("unit", $index + 1, "Year / Semester", 6);
        }
    }

    /**
     * This function validates Unit Mark using regex, @see buildRegExDict().
     * To be used inside for loop, @see validateUnitDetails().
     *
     * @param int $index - The current array index.
     */
    private final function validateUnitMark($index) {

        global $theRules;
        global $theUnits;

        $minMark = 0;
        $maxMark = 100;

        // if unit mark is valid
        if(preg_match($this->regExDict["mark"], $this->unitDetailsArray[$index][Units::UM])) {
            // test unit mark against min/max range
            if(intval($this->unitDetailsArray[$index][Units::UM] < $minMark || intval($this->unitDetailsArray[$index][Units::UM]) > $maxMark)) {
                $this->validateError("unit", $index + 1, "Unit Mark", 7);
            } else {
                // cast to int so we can do math with it
                $this->unitDetailsArray[$index][Units::UM] = intval($this->unitDetailsArray[$index][Units::UM]);
                // get the grade for this mark
                $this->unitDetailsArray[$index][Units::GR] = $theRules->getGrade($this->unitDetailsArray[$index][Units::UM]);
                // then store the highest mark found in theUnits->highestMark array
                if($this->unitDetailsArray[$index][Units::UM] > $theUnits->getHighestMark(Units::UM)) {
                    $theUnits->setHighestMark(
                        $this->unitDetailsArray[$index][Units::UC],
                        $this->unitDetailsArray[$index][Units::CP],
                        $this->unitDetailsArray[$index][Units::YS],
                        $this->unitDetailsArray[$index][Units::UM],
                        $this->unitDetailsArray[$index][Units::GR]
                    );
                }
            }
        } else {
            $this->validateError("unit", $index + 1, "Unit Mark", 8);
        }
    }

    /**
     * This function initiates logic validation.
     */
    private final function validateLogic() {
        $this->getUnitMatches($this->unitDetailsArray);
    }

    /**
     * This function searches array for matched Unit Codes,
     * then validates them for passed matching units, and semester matching units.
     *
     * @param array $theArray - The array to search.
     */
    private final function getUnitMatches(array $theArray) {

        $currentUnitCode = "";
        $currentSem = "";

        for($i = 0; $i < sizeof($this->unitDetailsArray); $i++) {

            if(strlen($theArray[$i][Units::UC]) > 0) {

                $currentUnitCode = $theArray[$i][Units::UC];
                $currentSem = $theArray[$i][Units::YS];

                for($j = $i + 1; $j <  sizeof($this->unitDetailsArray); $j++) {
                    $this->validatePassMatchUnits($currentUnitCode, $theArray, $i, $j);
                    $this->validateSemMatchUnits($currentUnitCode, $currentSem, $theArray, $i, $j);
                }
            }
        }
    }

    /**
     * This function implements business rule:
     * A unit cannot appear as passed more than once.
     * To be used inside for loop, @see getUnitMatches().
     *
     * @param String $currentUnitCode - The current unit code during iteration.
     * @param array $theArray - The array with data being validated.
     * @param int $indexI - The current index during iteration.
     * @param int $indexJ - The current index + 1.
     */
    private final function validatePassMatchUnits($currentUnitCode, array $theArray, $indexI, $indexJ) {

        $isWrite = true;

        // main test to validate business rule
        if($currentUnitCode == $theArray[$indexJ][Units::UC] && $theArray[$indexJ][Units::UM] >= BusinessRules::MARK_PASS) {

            // if there are more than one entries in logicErrorMessage
            if($this->logicErrorTally > 0) {
                // loop over logic errors to find matches before storing new entry
                for($k = 0; $k < $this->logicErrorTally; $k++) {
                    // if a match is found,
                    if($currentUnitCode == $this->logicErrorMessage[$k][$this::LE_FIELD] &&
                            $this->logicErrorMessage[$k][$this::LE_ECODE] == 9 &&
                            $this->logicErrorMessage[$k][$this::LE_ROW_1] == $indexI + 1) {
                        // set isWrite to false
                        $isWrite = false;
                    }
                }
                // only write error if isWrite is true
                if($isWrite) {
                    $this->logicError($theArray[$indexI][Units::UC], 9, $theArray[$indexI][Units::YS], $indexI + 1, $indexJ + 1);
                }
            } else {
                // else this is the first entry, post it up
                $this->logicError($theArray[$indexI][Units::UC], 9, $theArray[$indexI][Units::YS], $indexI + 1, $indexJ + 1);
            }
        }
    }

    /**
     * This function implements business rule:
     * A unit cannot appear more than once in the same semester.
     * To be used inside for loop, @see getUnitMatches().
     *
     * @param String $currentUnitCode - The current unit code during iteration.
     * @param String $currentSem - The current semester during iteration.
     * @param array $theArray - The array with data being validated.
     * @param int $indexI - The current index during iteration.
     * @param int $indexJ - The current index + 1.
     */
    private final function validateSemMatchUnits($currentUnitCode, $currentSem, array $theArray, $indexI, $indexJ) {

        $isWrite = true;

        // main test to validate business rule
        if($currentUnitCode == $theArray[$indexJ][Units::UC] && $currentSem == $theArray[$indexJ][Units::YS]) {

            // if there are more than one entries in logicErrorMessage
            if($this->logicErrorTally > 0) {
                // loop over logic errors to find matches before storing entry
                for($k = 0; $k < $this->logicErrorTally; $k++) {
                    // if a match is found
                    if($currentUnitCode == $this->logicErrorMessage[$k][$this::LE_FIELD] &&
                            $currentSem == $this->logicErrorMessage[$k][$this::LE_SEM] &&
                            $this->logicErrorMessage[$k][$this::LE_ECODE] ==  10 &&
                            $this->logicErrorMessage[$k][$this::LE_ROW_1] == $indexI + 1) {
                        // set isWrite to false
                        $isWrite = false;
                    }
                }
                // only write error if isWrite is true
                if($isWrite) {
                    $this->logicError($theArray[$indexI][Units::UC], 10, $theArray[$indexI][Units::YS], $indexI + 1, $indexJ + 1);
                }
            } else {
                // else this is the first entry, post it up
                $this->logicError($theArray[$indexI][Units::UC], 10, $theArray[$indexI][Units::YS], $indexI + 1, $indexJ + 1);
            }
        }
    }

    /**
     * This function populates student/unitErrorMessage when input is missing from the form.
     *
     * @param String $data - Either "student" or "unit".
     * @param int $row - The partially filled row, use -1 if $data == "student".
     * @param String $field - The missing value.
     */
    public final function missingInputError($data, $row, $field) {

        switch($data) {
            case "student":
                $this->studentErrorTally++;
                $this->studentErrorMessage[$this->studentErrorTally - 1][$this::E_ROW] = $row;
                $this->studentErrorMessage[$this->studentErrorTally - 1][$this::E_FIELD] = $field;
                $this->studentErrorMessage[$this->studentErrorTally - 1][$this::E_ECODE] = 0;
                break;
            case "unit":
                $this->unitErrorTally++;
                $this->unitErrorMessage[$this->unitErrorTally - 1][$this::E_ROW] = $row;
                $this->unitErrorMessage[$this->unitErrorTally - 1][$this::E_FIELD] = $field;
                $this->unitErrorMessage[$this->unitErrorTally - 1][$this::E_ECODE] = 0;
                break;
        }
    }

    /**
     * This function populates student/unitErrorMessage with appropriate validation code.
     * Note to self: Could have probably just overloaded with missingInputError().
     *
     * @param String $data - Either "student" or "unit"
     * @param int $row - The affected row.
     * @param String $field - The field that failed validation.
     * @param int $code - The error code, @see buildErrorCode().
     */
    public final function validateError($data, $row, $field, $code) {

        switch($data) {
            case "student":
                $this->studentErrorTally++;
                $this->studentErrorMessage[$this->studentErrorTally -1][$this::E_ROW] = $row;
                $this->studentErrorMessage[$this->studentErrorTally - 1][$this::E_FIELD] = $field;
                $this->studentErrorMessage[$this->studentErrorTally - 1][$this::E_ECODE] = $code;
                break;
            case "unit":
                $this->unitErrorTally++;
                $this->unitErrorMessage[$this->unitErrorTally - 1][$this::E_ROW] = $row;
                $this->unitErrorMessage[$this->unitErrorTally - 1][$this::E_FIELD] = $field;
                $this->unitErrorMessage[$this->unitErrorTally - 1][$this::E_ECODE] = $code;
                break;
        }
    }

    /**
     * This function populates logicErrorMessage array with error messages.
     *
     * @param String $field - The field that failed validation.
     * @param int $code - The error code, @see buildErrorCode().
     * @param String $sem - The affected semester.
     * @param int $row1 - The first row affected.
     * @param int $row2 - The second row affected.
     */
    public final function logicError($field, $code, $sem, $row1, $row2) {
        $this->logicErrorTally++;
        $this->logicErrorMessage[$this->logicErrorTally - 1][$this::LE_FIELD] = $field;
        $this->logicErrorMessage[$this->logicErrorTally - 1][$this::LE_ECODE] = $code;
        $this->logicErrorMessage[$this->logicErrorTally - 1][$this::LE_SEM] = $sem;
        $this->logicErrorMessage[$this->logicErrorTally - 1][$this::LE_ROW_1] = $row1;
        $this->logicErrorMessage[$this->logicErrorTally - 1][$this::LE_ROW_2] = $row2;
    }

    /**
     * This function builds the regExDict(ionary),
     * which will be used for input validation.
     */
    private final function buildRegExDict() {

        $this->regExDict = array(
            "name" => "(^[a-zA-Z]+$)",
            "studentID" => "(^[0-9]{8}$)",
            "unitCode" => "([A-Z]{3}[0-9]{4})",
            "unitCodeSuffix" => "([0-9]{4})",
            "creditPoints" => "(15|20)",
            "yearSem" => "([0-9]{2}[1|2])",
            "mark" => "(^[0-9]+$)",
        );
    }

    /**
     * This function builds the errorCode array
     * with preset error messages. Using indexes here
     * so that each message's index is more visible.
     */
    private final function buildErrorCode() {

        // names
        $this->errorCode[0] = "is missing.";
        $this->errorCode[1] = "must be a name.";
        // studentid
        $this->errorCode[2] = "must be eight digits.";
        // unitcode
        $this->errorCode[3] = "is invalid for undergraduate students. Must be a unit code less than 6000 level.";
        $this->errorCode[4] = "must follow the format: ABC1234.";
        // creditpoints
        $this->errorCode[5] = "must only be either 15 or 20.";
        // year/sem
        $this->errorCode[6] = "must follow the format \"YYS\". For example, 151. Semester must only be 1 or 2.";
        // unitmark
        $this->errorCode[7] = "can't be less than 0 or greater than 100.";
        $this->errorCode[8] = "must be between 1 and 3 digits.";
        // passMatchUnits
        $this->errorCode[9] = "is passed more than once at rows "; // then state the rows
        // semMatchUnits
        $this->errorCode[10] = "appears more than once in semester "; // then state sem and rows
    }

    /**
     * This function returns studentErrorTally.
     *
     * @return int studentErrorTally.
     */
    public final function getStudentErrorTally() {
        return $this->studentErrorTally;
    }

    /**
     * This function returns the studentErrorMessage array.
     *
     * @return array studentErrorMessage.
     */
    public final function getStudentErrorMessage() {
        return $this->studentErrorMessage;
    }

    /**
     * This function returns unitErrorTally.
     *
     * @return int unitErrorTally.
     */
    public final function getUnitErrorTally() {
        return $this->unitErrorTally;
    }

    /**
     * This function returns the unitErrorMessage array.
     *
     * @return array unitErrorMessage.
     */
    public final function getUnitErrorMessage() {
        return $this->unitErrorMessage;
    }

    /**
     * This function returns logicErrorTally.
     *
     * @return int logicErrorTally.
     */
    public final function getLogicErrorTally() {
        return $this->logicErrorTally;
    }

    /**
     * This function returns the logicErrorMessage array.
     *
     * @return array logicErrorMessage.
     */
    public final function getLogicErrorMessage() {
        return $this->logicErrorMessage;
    }

    /**
     * This function imports the input arrays from the Student and Units class.
     * This must occur post construction of theStudent and theUnits,
     * otherwise, their input arrays will be empty.
     *
     * Once input arrays have been imported, it will kick off validation.
     *
     * @param array $studentDetails
     * @param array $unitDetails
     */
    public final function setInputArrays(array $studentDetails, array $unitDetails) {
        $this->studentDetailsArray = $studentDetails;
        $this->unitDetailsArray = $unitDetails;
        // now that we have all the input data, we can start validation
        $this->startValidation();
    }
}

?>