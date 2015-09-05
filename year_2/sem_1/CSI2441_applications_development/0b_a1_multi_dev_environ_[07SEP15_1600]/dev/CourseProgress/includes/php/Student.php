<?php

namespace includes;

/**
 * Class Student contains data and functions related to a student.
 * It retrieves student data from the form, and performs light validation
 * on empty form fields.
 *
 * @author Martin Ponce, 10371381
 * @version 20150904
 * @package includes
 */
class Student {

    // storing student details as individual variables
    private $firstName;
    private $surname;
    private $enrolmentType;
    private $studentID;
    private $courseType;

    // and in an array to pass around easier
    private $studentDetails = array();

    // studentDetails array index
    const FN = 0;
    const SN = 1;
    const ET = 2;
    const ID = 3;
    const CT = 4;

    // is true if studentDetails populated
    private $isPopulated;

    // how many student details we are expecting
    const STUDENT_DETAILS_TALLY = 5;

    // object ref to theValidator, created at main in cpa_analyser.php
    // don't want to create a new Validator here, just pass the reference around
    private $theValidator;

    /**
     * The constructor for the Student class.
     */
    function __construct() {
        $this->isPopulated = false;
    }

    /**
     * This function imports theValidator object.
     *
     * @param $theValidator Validator - An instance of the Validator class.
     */
    public final function setValidator(Validator $theValidator) {
        $this->theValidator = $theValidator;
    }

    /**
     * This function kicks off the Student.
     * Can't call these functions until theValidator is imported, so rather
     * than calling them from the constructor, call startStudent() AFTER
     * theValidator has been imported.
     */
    public final function startStudent() {
        $this->retrieveStudentDetails();
        $this->packStudentDetails();
    }

    /**
     * This function retrieves student data from the form.
     */
    private final function retrieveStudentDetails() {

        global $theValidator;

        /**
         * Test the fields are populated before retrieving them.
         * Requires Validator reference to call missingInputError().
         */

        if(strlen($_POST["Firstname"]) > 0) {
            $this->firstName = $_POST["Firstname"];
            $this->isPopulated = true;
        } else {
            $theValidator->missingInputError("student", -1, "Firstname");
        }

        if(strlen($_POST["Surname"]) > 0) {
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

        if(strlen($_POST["StudentID"]) > 0) {
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
     * This function packs student details into an array.
     */
    private final function packStudentDetails() {
        $this->studentDetails[Student::FN] = $this->firstName;
        $this->studentDetails[Student::SN] = $this->surname;
        $this->studentDetails[Student::ET] = $this->enrolmentType;
        $this->studentDetails[Student::ID] = $this->studentID;
        $this->studentDetails[Student::CT] = $this->courseType;

    }

    /**
     * This function returns the studentDetails array.
     *
     * @return array $studentDetails - Student details array.
     */
    public final function getStudentDetails() {
        return $this->studentDetails;
    }

    /**
     * This function returns the isPopulated boolean.
     *
     * @return bool $isPopulated.
     */
    public final function isStudentPopulated() {
        return $this->isPopulated;
    }
}

?>