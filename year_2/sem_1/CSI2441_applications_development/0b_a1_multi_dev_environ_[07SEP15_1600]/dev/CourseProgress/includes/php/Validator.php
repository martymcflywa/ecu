<?php

namespace includes;

/**
 * Class ValidateData contains data and functions to perform validation on Student and Unit data.
 * It also functions as a pseudo controller, although I now realise that it has too many responsibilities
 * and would prefer to create an actual controller and refactor everything. However, time is almost over.
 *
 * @author Martin Ponce, 10371381
 * @version 20150906
 * @package includes
 */
class Validator {

    // import reference to objects
    private $theStudent;
    private $theUnits;
    private $theRules;

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
     * The constructor for Validator class.
     * Validator will act as the controller, passing data around from
     * models to view, so import the model references.
     *
     * @param Student $theStudent
     * @param Units $theUnits
     * @param BusinessRules $theRules
     */
    function __construct(Student $theStudent, Units $theUnits, BusinessRules $theRules) {

        $this->theStudent = $theStudent;
        $this->theUnits = $theUnits;
        $this->theRules = $theRules;

        // build regex and error code definitions
        $this->buildRegExDict();
        $this->buildErrorCode();
    }

    /**
     * This function initiates the validation for
     * student and unit input, as well as logical errors.
     */
    public final function startValidator() {
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
        if(!empty($this->theStudent->getStudentDetails()[Student::FN])) {
            if(!preg_match($this->regExDict["name"], $this->theStudent->getStudentDetails()[Student::FN])) {
                $this->validateError("student", -1, "Firstname", 1);
            }
        }

        if(!empty($this->theStudent->getStudentDetails()[Student::SN])) {
            if(!preg_match($this->regExDict["name"], $this->theStudent->getStudentDetails()[Student::SN])) {
                $this->validateError("student", -1, "Surname", 1);
            }
        }

        // validate student id
        if(!empty($this->theStudent->getStudentDetails()[Student::ID])) {
            if(!preg_match($this->regExDict["studentID"], $this->theStudent->getStudentDetails()[Student::ID])) {
                $this->validateError("student", -1, "Student ID", 2);
            }
        }
    }

    /**
     * This function validates unit details.
     * Tests each array index for population before proceeding.
     */
    private final function validateUnitDetails() {

        // iterate each row
        for($i = 0; $i < sizeof($this->theUnits->getUnitDetails()); $i++) {

            /*************
             * UNIT CODE *
             *************/

            if(empty($this->theUnits->getUnitDetails()[$i][Units::UC])) {
                $this->missingInputError("unit", $i + 1, "Unit Code");
            } else {
                $this->validateUnitCode($i);
            }

            /*****************
             * CREDIT POINTS *
             *****************/

            if(empty($this->theUnits->getUnitDetails()[$i][Units::CP])) {
                $this->missingInputError("unit", $i + 1, "Credit Points");
            } else {
                $this->validateCreditPoints($i);
            }

            /**************
             * YEAR / SEM *
             **************/

            if(empty($this->theUnits->getUnitDetails()[$i][Units::YS])) {
                $this->missingInputError("unit", $i + 1, "Year / Semester");
            } else {
                $this->validateYearSem($i);
            }

            /*************
             * UNIT MARK *
             *************/

            if(!isset($this->theUnits->getUnitDetails()[$i][Units::UM])) {
                $this->missingInputError("unit", $i + 1, "Unit Mark");
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
        if(preg_match($this->regExDict["unitCode"], $this->theUnits->getUnitDetails()[$index][Units::UC])) {

            $suffix = array();
            // stores matched regex (last 4 digits of unit code) in $suffix, test $suffix[0] >= 6000
            preg_match($this->regExDict["unitCodeSuffix"], $this->theUnits->getUnitDetails()[$index][Units::UC], $suffix);

            // test course type against unit code
            if(($this->theStudent->getStudentDetails()[Student::CT] == BusinessRules::CP_UNDERGRAD ||
                    $this->theStudent->getStudentDetails()[Student::CT] == BusinessRules::CP_UNDERGRAD_DOUBLE) &&
                $suffix[0] >= 6000
            ) {
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
        if(preg_match($this->regExDict["creditPoints"], $this->theUnits->getUnitDetails()[$index][Units::CP])) {
            // cast to int so we can do math with it
            $this->theUnits->setCreditPoints($index, $this->theUnits->getUnitDetails()[$index][Units::CP]);
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

        if(!preg_match($this->regExDict["yearSem"], $this->theUnits->getUnitDetails()[$index][Units::YS])) {
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

        $minMark = 0;
        $maxMark = 100;

        // if unit mark is valid
        if(preg_match($this->regExDict["mark"], $this->theUnits->getUnitDetails()[$index][Units::UM])) {
            // test unit mark against min/max range
            if(intval($this->theUnits->getUnitDetails()[$index][Units::UM] < $minMark ||
                intval($this->theUnits->getUnitDetails()[$index][Units::UM]) > $maxMark)) {

                $this->validateError("unit", $index + 1, "Unit Mark", 7);
            } else {
                // cast to int so we can do math with it
                $this->theUnits->setUnitMark($index, $this->theUnits->getUnitDetails()[$index][Units::UM]);
            }
        } else {
            $this->validateError("unit", $index + 1, "Unit Mark", 8);
        }
    }

    /**
     * This function initiates logic validation.
     */
    private final function validateLogic() {
        $this->getUnitMatches($this->theUnits->getUnitDetails());
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

        for($i = 0; $i < sizeof($theArray); $i++) {

            // test if array index issset(), preempting undefined offset in validatePass/SemMatchUnits()
            // @see error_reporting() in cpa_analyser.php
            if(isset($theArray[$i][Units::UC])) {
                if(preg_match($this->regExDict["unitCode"], $theArray[$i][Units::UC])) {

                    $currentUnitCode = $theArray[$i][Units::UC];
                    $currentSem = $theArray[$i][Units::YS];

                    for($j = $i + 1; $j < sizeof($theArray); $j++) {
                        $this->validatePassMatchUnits($currentUnitCode, $theArray, $i, $j);
                        $this->validateSemMatchUnits($currentUnitCode, $currentSem, $theArray, $i, $j);
                    }
                }
            }
        }
    }

    /**
     * This function implements business rule:
     * A unit cannot appear as passed more than once.
     * To be used inside for loop, @see getUnitMatches().
     *
     * Preempting undefined offset by testing isset($theArray) before calling this function.
     * However, notices still generate if being displayed.
     * @see error_reporting() in cpa_analyser.php
     *
     * @param String $currentUnitCode - The current unit code during iteration.
     * @param array $theArray - The array with data being validated.
     * @param int $indexI - The current index during iteration.
     * @param int $indexJ - The current index + 1.
     */
    private final function validatePassMatchUnits($currentUnitCode, array $theArray, $indexI, $indexJ) {

        $isWrite = true;

        // main test to validate business rule, also text existence of current array key
        if ($currentUnitCode == $theArray[$indexJ][Units::UC] &&
            $theArray[$indexJ][Units::UM] >= BusinessRules::MARK_PASS
        ) {
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

                    $this->logicError(
                        $theArray[$indexI][Units::UC],
                        9,
                        $theArray[$indexI][Units::YS],
                        $indexI + 1,
                        $indexJ + 1
                    );
                }
            } else {

                // else this is the first entry, post it up
                $this->logicError(
                    $theArray[$indexI][Units::UC],
                    9,
                    $theArray[$indexI][Units::YS],
                    $indexI + 1,
                    $indexJ + 1
                );
            }
        }
    }

    /**
     * This function implements business rule:
     * A unit cannot appear more than once in the same semester.
     * To be used inside for loop, @see getUnitMatches().
     *
     * Preempting undefined offset by testing isset($theArray) before calling this function.
     * However, notices still generate if being displayed.
     * @see error_reporting() in cpa_analyser.php
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

                    $this->logicError(
                        $theArray[$indexI][Units::UC],
                        10,
                        $theArray[$indexI][Units::YS],
                        $indexI + 1,
                        $indexJ + 1
                    );
                }
            } else {
                // else this is the first entry, post it up
                $this->logicError(
                    $theArray[$indexI][Units::UC],
                    10,
                    $theArray[$indexI][Units::YS],
                    $indexI + 1,
                    $indexJ + 1
                );
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
                $this->studentErrorMessage[$this->studentErrorTally - 1][$this::E_ROW] = $row;
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

    /*******************
     * OWN GET/SETTERS *
     *******************/

    /**
     * This function converts an error code to its string message.
     *
     * @param int $index - The error code.
     * @return String - The error message.
     */
    public final function getErrorCode($index) {
        return $this->errorCode[$index];
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

    /***********************
     * STUDENT GET/SETTERS *
     ***********************/

    /**
     * This function returns isPopulated from Student.
     *
     * @return bool isStudentPopulated.
     */
    public final function isStudentPopulated() {
        return $this->theStudent->isStudentPopulated();
    }

    /**
     * This function returns studentDetails array from Student.
     *
     * @return array studentDetails.
     */
    public final function getStudentDetails() {
        return $this->theStudent->getStudentDetails();
    }

    /********************
     * UNIT GET/SETTERS *
     ********************/

    /**
     * This function returns isPopulated from Units.
     *
     * @return bool isUnitsPopulated.
     */
    public final function isUnitsPopulated() {
        return $this->theUnits->isUnitsPopulated();
    }

    /**
     * This function returns the unitDetails array from Units.
     *
     * @return array $unitDetails - Unit details array.
     */
    public function getUnitDetails() {
        return $this->theUnits->getUnitDetails();
    }

    /**
     * This function returns the highestMark array at Units.
     *
     * @return int $highestMark - The highest mark array.
     */
    public function getHighestMark() {
        return $this->theUnits->getHighestMark();
    }

    /**
     * This function sets the credit point for an entry in the input array at Units.
     * Casts credit points as int.
     *
     * @param int $index - The array index, where to set the credit points.
     * @param int $cp - The credit points to set.
     */
    public function setCreditPoints($index, $cp) {
        $this->theUnits->setCreditPoints($index, $cp);
    }

    /**
     * This function sets the unit mark for an entry in the input array at Units.
     * Casts unit mark as int.
     *
     * @param $index - The array index, where to set the credit points.
     * @param int $mark - The unit mark to set.
     */
    public function setUnitMark($index, $mark) {
        $this->theUnits->setUnitMark($index, $mark);
    }

    /**
     * This function sets the unit grade for an entry in the input array at Units.
     *
     * @param int $index - The array index, where to set the grade.
     * @param String $grade - The grade to set.
     */
    public function setUnitGrade($index, $grade) {
        $this->theUnits->setUnitGrade($index, $grade);
    }

    /**
     * This function sets the highestMark array at Units.
     *
     * @param String $unitCode.
     * @param int $creditPoints.
     * @param String $sem.
     * @param int $mark.
     * @param String $grade.
     */
    public function setHighestMark($unitCode, $creditPoints, $sem, $mark, $grade) {
        $this->theUnits->setHighestMark($unitCode, $creditPoints, $sem, $mark, $grade);
    }

    /*********************
     * RULES GET/SETTERS *
     *********************/

    /**
     * This function returns progressionStatus from BusinessRules.
     *
     * @return string progressionStatus.
     */
    public final function getProgressionStatus() {
        return $this->theRules->getProgressionStatus();
    }

    /**
     * This function returns the completion status from BusinessRules.
     * Finished course == true;
     * Not finished course == false;
     *
     * @return bool isComplete.
     */
    public final function isComplete() {
        return $this->theRules->isComplete();
    }

    /**
     * This function returns passedCPTotal from BusinessRules.
     *
     * @return int passedCPTotal.
     */
    public final function getPassedCP() {
        return $this->theRules->getPassedCP();
    }

    /**
     * This function returns cpDelta from BusinessRules.
     *
     * @return int cpDelta.
     */
    public function getCPDelta() {
        return $this->theRules->getCPDelta();
    }

    /**
     * This function returns unitAttemptTotal from BusinessRules.
     *
     * @return int unitAttemptTotal.
     */
    public function getUnitsAttempted() {
        return $this->theRules->getUnitsAttempted();
    }

    /**
     * This function returns unitsPassed from BusinessRules.
     *
     * @return int unitsPassed.
     */
    public function getUnitsPassed() {
        return $this->theRules->getUnitsPassed();
    }

    /**
     * This function returns semRemaining from BusinessRules.
     *
     * @return int semRemaining.
     */
    public function getSemRemaining() {
        return $this->theRules->getSemRemaining();
    }

    /**
     * This function returns markAverage from BusinessRules.
     *
     * @return int markAverage.
     */
    public function getMarkAverage() {
        return $this->theRules->getMarkAverage();
    }

    /**
     * This function returns gradeAverage from BusinessRules.
     *
     * @return string gradeAverage.
     */
    public function getGradeAverage() {
        return $this->theRules->getGradeAverage();
    }
}

?>