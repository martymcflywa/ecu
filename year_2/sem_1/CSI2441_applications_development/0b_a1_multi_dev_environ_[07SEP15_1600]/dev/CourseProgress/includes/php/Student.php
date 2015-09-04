<?php

namespace includes;
use includes\Validator;

/**
 * Class Student contains data and functions related to a student.
 *
 * @author Martin Ponce, 10371381
 * @version 20150904
 * @package includes
 */
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

    private $isPopulated;

    private $studentDetails = array();

    const STUDENT_DETAILS_TALLY = 5;

    private $theValidator;

    /**
     * The constructor for the Student class.
     */
    function __construct() {

        $this->isPopulated = false;

        $this->retrieveStudentDetails();
        $this->packStudentDetails();
    }

    /**
     * Function retrieves student data from the form.
     */
    private function retrieveStudentDetails() {

        global $theValidator;

        /**
         * Test the fields are populated before retrieving them.
         * TODO: Might remove Helpers, isPopulated can easily be replaced.
         * TODO: Most of Helper functions from classic ASP is now in Validator class.
         */

        if(Helpers::isPopulated("Firstname")) {
            $this->firstName = $_POST["Firstname"];
            $this->isPopulated = true;
        } else {
            $theValidator->missingInputError("student", -1, "Firstname");
        }

        if(Helpers::isPopulated("Surname")) {
            $this->surname = $_POST["Surname"];
            $this->isPopulated = true;
        } else {
            $theValidator->missingInputError("student", -1, "Surname");
        }

        // convert from code definition to actual value
        switch(intval($_POST["EnrolmentType"])) {
            case 1:
                $this->enrolmentType = BusinessRules::CP_FULLTIME;
                break;
            case 2:
                $this->enrolmentType = BusinessRules::CP_PARTTIME;
                break;
        }

        if(Helpers::isPopulated("StudentID")) {
            $this->studentID = $_POST["StudentID"];
            $this->isPopulated = true;
        } else {
            $theValidator->missingInputError("student", -1, "StudentID");
        }

        // convert from code definition to actual value
        switch(intval($_POST["CourseType"])) {
            case 1:
                $this->courseType = BusinessRules::CP_UNDERGRAD;
                break;
            case 2:
                $this->courseType = BusinessRules::CP_UNDERGRAD_DOUBLE;
                break;
            case 3:
                $this->courseType = BusinessRules::CP_GRAD_DIPLOMA;
                break;
            case 4:
                $this->courseType = BusinessRules::CP_MASTERS_COURSE;
                break;
            case 5:
                $this->courseType = BusinessRules::CP_MASTERS_RESEARCH;
                break;
        }
    }

    /**
     * Function packs student details into an array.
     */
    private function packStudentDetails() {
        $this->studentDetails[Student::FN] = $this->firstName;
        $this->studentDetails[Student::SN] = $this->surname;
        $this->studentDetails[Student::ET] = $this->enrolmentType;
        $this->studentDetails[Student::ID] = $this->studentID;
        $this->studentDetails[Student::CT] = $this->courseType;
    }

    /**
     * Function imports the Validator class.
     *
     * @param $theValidator
     */
    public function setTheValidator($theValidator) {
        $this->theValidator = $theValidator;
    }

    /**
     * Function returns $studentDetails array.
     *
     * @return mixed $studentDetails - Student details array.
     */
    public function getStudentDetails() {
        return $this->studentDetails;
    }

    /**
     * Function returns $isPopulated boolean.
     *
     * @return bool $isPopulated.
     */
    public function isStudentPopulated() {
        return $this->isPopulated;
    }
}

?>