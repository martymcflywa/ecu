<?php

namespace includes;
require 'includes/php/BusinessRules.php';
use includes\BusinessRules;

class Student {

    private $firstName;
    private $surname;
    private $enrolmentType;
    private $studentID;
    private $courseType;

    // studentDetails array index
    const FN = 0;
    const SN = 1;
    const ET = 2;
    const ID = 3;
    const CT = 4;

    private $studentErrorCount;
    private $isPopulated;

    private $studentDetails = array();
    private $studentErrorMessage = array(array());

    public static $studentDetailsTally = 5;

    /**
     * The constructor.
     */
    function __construct() {

        $this->retrieveStudentDetails();
        $this->packStudentDetails();
    }

    /**
     * Function increments private $studentErrorCount.
     */
    public static function incrementStudentErrorCount() {
        global $studentErrorCount;
        $studentErrorCount++;
    }

    /**
     * Function retrieves student data from the form.
     */
    private function retrieveStudentDetails() {

        global $firstName;
        global $surname;
        global $enrolmentType;
        global $studentID;
        global $courseType;
        global $isPopulated;

        /**
         * Test fields are populated before retrieving them.
         */

        if(Helpers::isPopulated("Firstname")) {
            $firstName = $_POST["Firstname"];
            $isPopulated = true;
        } else {
            Helpers::missingInputError("student", -1, "Firstname");
        }

        if(Helpers::isPopulated("Surname")) {
            $surname = $_POST["Surname"];
            $isPopulated = true;
        } else {
            Helpers::missingInputError("student", -1, "Surname");
        }

        switch(intval($_POST["EnrolmentType"])) {
            case 1:
                $enrolmentType = BusinessRules::CP_FULLTIME;
                break;
            case 2:
                $enrolmentType = BusinessRules::CP_PARTTIME;
                break;
        }

        if(Helpers::isPopulated("StudentID")) {
            $studentID = $_POST["StudentID"];
            $isPopulated = true;
        } else {
            Helpers::missingInputError("student", -1, "StudentID");
        }

        switch(intval($_POST["CourseType"])) {
            case 1:
                $courseType = BusinessRules::CP_UNDERGRAD;
                break;
            case 2:
                $courseType = BusinessRules::CP_UNDERGRAD_DOUBLE;
                break;
            case 3:
                $courseType = BusinessRules::CP_GRAD_DIPLOMA;
                break;
            case 4:
                $courseType = BusinessRules::CP_MASTERS_COURSE;
                break;
            case 5:
                $courseType = BusinessRules::CP_MASTERS_RESEARCH;
                break;
        }
    }

    /**
     * Function packs student details into an array.
     */
    private function packStudentDetails() {

        global $studentDetails;
        global $firstName;
        global $surname;
        global $enrolmentType;
        global $studentID;
        global $courseType;

        $studentDetails[Student::FN] = $firstName;
        $studentDetails[Student::SN] = $surname;
        $studentDetails[Student::ET] = $enrolmentType;
        $studentDetails[Student::ID] = $studentID;
        $studentDetails[Student::CT] = $courseType;
    }

    /**
     * Function returns $studentDetails array.
     *
     * @return mixed $studentDetails - Student details array.
     */
    public function getStudentDetails() {
        global $studentDetails;
        return $studentDetails;
    }
}

?>