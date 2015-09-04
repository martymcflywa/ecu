<?php

namespace includes;

/**
 * Class ValidateData contains
 * @package includes
 */
class ValidateData {

    // import references to student/unit class
    private $theStudent;
    private $theUnits;

    // import references to student and unit details
    private $studentDetails;
    private $unitDetails;

    // error tallies and arrays
    private $studentErrorTally;
    private $studentErrorMessage = array(array());
    private $unitErrorTally;
    private $unitErrorMessage = array(array());
    private $logicErrorTally;
    private $logicErrorMessage = array(array());

    // column index for student/unitErrorMessage
    const E_ROW = 0;
    const E_FIELD = 1;
    const E_ECODE = 2;

    // column index for logicErrorMessage
    const LE_FIELD = 0;
    const LE_ECODE = 1;
    const LE_SEM = 2;
    const LE_ROW_1 = 3;
    const LE_ROW_2 = 4;

    private $regExDict;
    private $errorCode = array();

    /**
     * The constructor for ValidateData class.
     *
     * @param $theStudent Student - An instance of the Student class.
     * @param $theUnits Units - An instance of the Units class
     * @param $studentDetails array - The student details array.
     * @param $unitDetails array - The unit details array.
     */
    function __construct($theStudent, $theUnits, $studentDetails, $unitDetails) {

        $this->$studentDetails = $studentDetails;
        $this->$unitDetails = $unitDetails;
        $this->buildRegExDict();
        $this->buildErrorCode();
        // then call methods to validate received data
    }

    private function validateStudentDetails() {

    }

    /**
     * This function builds the regExDict(ionary),
     * which will be used for input validation.
     */
    private function buildRegExDict() {

        global $regExDict;

        $regExDict = array(
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

        global $errorCode;

        // names
        $errorCode[0] = "is missing.";
        $errorCode[1] = "must be a name.";
        // studentid
        $errorCode[2] = "must be eight digits.";
        // unitcode
        $errorCode[3] = "is invalid for undergraduate students. Must be a unit code less than 6000 level.";
        $errorCode[4] = "must follow the format: ABC1234.";
        // creditpoints
        $errorCode[5] = "must only be either 15 or 20.";
        // year/sem
        $errorCode[6] = "must follow the format \"YYS\". For example, 151. Semester must only be 1 or 2.";
        // unitmark
        $errorCode[7] = "can't be less than 0 or greater than 100.";
        $errorCode[8] = "must be between 1 and 3 digits.";
        // passMatchUnits
        $errorCode[9] = "is passed more than once at rows "; // then state the rows
        // semMatchUnits
        $errorCode[10] = "appears more than once in semester "; // then state sem and rows
    }
}

?>