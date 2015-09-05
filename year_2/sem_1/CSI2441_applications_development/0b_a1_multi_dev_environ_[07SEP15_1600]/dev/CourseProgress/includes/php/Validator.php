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

    // import references to student/unit/rules class
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
     * @param $theStudent Student - An instance of the Student class.
     * @param $theUnits Units - An instance of the Units class
     * @param $theRules BusinessRules - An instance of the BusinessRules class.
     */
    function __construct(Student $theStudent, Units $theUnits, BusinessRules $theRules) {

        // import student/unit/rules classes
        $this->theStudent = $theStudent;
        $this->theUnits = $theUnits;
        $this->theRules = $theRules;

        // import student/unitDetails arrays
        //$this->studentDetails = $theStudent->getStudentDetails();
        //$this->unitDetails = $theUnits->getUnitDetails();

        // build regex and error code definitions
        $this->buildRegExDict();
        $this->buildErrorCode();

        // then call the methods to validate received data
        //$this->validateStudentDetails();
        //$this->validateUnitDetails();
    }

    /**
     * Function validates student details.
     * Tests each array index for population before proceeding.
     */
    private function validateStudentDetails() {

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
     * Function validates unit details.
     * Tests each array index for population before proceeding.
     */
    private function validateUnitDetails() {

        // iterate each row
        for($i = 0; $i < Units::$filledRows; $i++) {

            /*************
             * UNIT CODE *
             *************/

            if(strlen($this->unitDetailsArray[$i][Units::UC]) > 0) {
                $this->missingInputError("unit", $i + 1, "Unit Code");
            } else {
                $this->validateUnitCode($i);
            }

            /*****************
             * CREDIT POINTS *
             *****************/

            if(strlen($this->unitDetailsArray[$i][Units::CP]) > 0) {
                $this->missingInputError("unit", $i + 1, "Credit Points");
            } else {
                $this->validateCreditPoints($i);
            }

            /**************
             * YEAR / SEM *
             **************/

            if(strlen($this->unitDetailsArray[$i][Units::YS]) > 0) {
                $this->missingInputError("unit", $i + 1, "Year / Semester");
            } else {
                $this->validateYearSem($i);
            }

            /*************
             * UNIT MARK *
             *************/

            if(strlen($this->unitDetailsArray[$i][Units::UM]) > 0) {
                $this->missingInputError("units", $i + 1, "Unit Mark");
            } else {
                $this->validateUnitMark($i);
            }
        }
    }

    /**
     * Function validates Unit Code using regex, @see buildRegExDict.
     * To be used inside for loop, @see validateUnitDetails().
     *
     * @param $index int - The current array index.
     */
    private function validateUnitCode($index) {

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
     * Function validates Credit Points using regex, @see buildRegExDict.
     * To be used inside for loop, @see validateUnitDetails().
     *
     * @param $index int - The current array index.
     */
    private function validateCreditPoints($index) {

        // if credit points is valid
        if(preg_match($this->regExDict["creditPoints"], $this->unitDetailsArray[$index][Units::CP])) {
            // cast to int so we can do math with it
            $this->unitDetailsArray[$index][Units::CP] = intval($this->unitDetailsArray[$index][Units::CP]);
        } else {
            $this->validateError("unit", $index + 1, "Credit Points", 5);
        }
    }

    /**
     * Function validates Year / Sem using regex, @see buildRegExDict.
     * To be used inside for loop, @see validateUnitDetails().
     *
     * @param $index int - The current array index.
     */
    private function validateYearSem($index) {

        if(!preg_match($this->regExDict["yearSem"], $this->unitDetailsArray[$index][Units::YS])) {
            $this->validateError("unit", $index + 1, "Year / Semester", 6);
        }
    }

    /**
     * Function validates Unit Mark using regex, @see buildRegExDict.
     * To be used inside for loop, @see validateUnitDetails().
     *
     * @param $index int - The current array index.
     */
    private function validateUnitMark($index) {

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
     * Function populates student/unitErrorMessage when input is missing from the form.
     *
     * @param $data String - Either "student" or "unit".
     * @param $row int - The partially filled row, use -1 if $data == "student".
     * @param $field String - The missing value.
     */
    public function missingInputError($data, $row, $field) {

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
     * Function populates student/unitErrorMessage with appropriate validation code.
     * Note to self: Could have probably just overloaded with missingInputError().
     *
     * @param $data String - Either "student" or "unit"
     * @param $row int - The affected row.
     * @param $field String - The field that failed validation.
     * @param $code int - The error code, @see buildErrorCode().
     */
    public function validateError($data, $row, $field, $code) {

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
     * Function populates logicErrorMessage array with error messages.
     *
     * @param $field String - The field that failed validation.
     * @param $code int - The error code, @see buildErrorCode().
     * @param $sem String - The affected semester.
     * @param $row1 int - The first row affected.
     * @param $row2 int - The second row affected.
     */
    public function logicError($field, $code, $sem, $row1, $row2) {
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
    private function buildRegExDict() {

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
    private function buildErrorCode() {

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
     * This function imports the input arrays from the Student and Units class.
     * This must occur post construction of theStudent and theUnits,
     * otherwise, their input arrays will be empty.
     *
     * @param array $studentDetails
     * @param array $unitDetails
     */
    public function setInputArrays(array $studentDetails, array $unitDetails) {
        $this->studentDetailsArray = $studentDetails;
        $this->unitDetailsArray = $unitDetails;
    }
}

?>