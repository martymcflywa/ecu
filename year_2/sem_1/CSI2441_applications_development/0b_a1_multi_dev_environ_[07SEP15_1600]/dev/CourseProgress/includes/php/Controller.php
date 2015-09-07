<?php

namespace includes;

class Controller {

    private $theStudent;
    private $theUnits;
    private $theRules;
    private $theValidator;
    private $theSummaryView;
    private $theErrorView;

    function __construct(Student $theStudent, Units $theUnits,
                         BusinessRules $theRules,
                         Validator $theValidator, View $theSummaryView,
                         View $theErrorView)
    {
        // import all the things
        $this->theStudent = $theStudent;
        $this->theUnits = $theUnits;
        $this->theRules = $theRules;
        $this->theValidator = $theValidator;
        $this->theSummaryView = $theSummaryView;
        $this->theErrorView = $theErrorView;

        // go get student details
        $this->retrieveStudentDetails();
    }

    /**
     * This function retrieves student data from the form.
     */
    private final function retrieveStudentDetails() {

        /**
         * Test the fields are populated before retrieving them.
         * Requires Validator reference to call missingInputError().
         */

        if(strlen($_POST["Firstname"]) > 0) {
            $this->theStudent->setStudentDetailsAt(Student::FN, $_POST["Firstname"]);
            $this->theStudent->studentIsPopulated();
        } else {
            $this->theValidator->missingInputError("student", -1, "Firstname");
        }

        if(strlen($_POST["Surname"]) > 0) {
            $this->theStudent->setStudentDetailsAt(Student::SN, $_POST["Surname"]);
            $this->theStudent->studentIsPopulated();
        } else {
            $this->theValidator->missingInputError("student", -1, "Surname");
        }

        // convert from code definition to actual value
        switch(intval($_POST["EnrolmentType"])) {
            case 1:
                $this->theStudent->setEnrolmentType(BusinessRules::CP_FULLTIME);
                break;
            case 2:
                $this->theStudent->setEnrolmentType(BusinessRules::CP_PARTTIME);
                break;
        }

        if(strlen($_POST["StudentID"]) > 0) {
            $this->theStudent->setStudentDetailsAt(Student::ID, $_POST["StudentID"]);
            $this->theStudent->studentIsPopulated();
        } else {
            $this->theValidator->missingInputError("student", -1, "StudentID");
        }

        // convert from code definition to actual value
        switch(intval($_POST["CourseType"])) {
            case 1:
                $this->theStudent->setCourseType(BusinessRules::CP_UNDERGRAD);
                break;
            case 2:
                $this->theStudent->setCourseType(BusinessRules::CP_UNDERGRAD_DOUBLE);
                break;
            case 3:
                $this->theStudent->setCourseType(BusinessRules::CP_GRAD_DIPLOMA);
                break;
            case 4:
                $this->theStudent->setCourseType(BusinessRules::CP_MASTERS_COURSE);
                break;
            case 5:
                $this->theStudent->setCourseType(BusinessRules::CP_MASTERS_RESEARCH);
                break;
        }
    }

    // get unit data
    private function startUnits() {
        $this->theUnits->startUnits();
    }
}

?>