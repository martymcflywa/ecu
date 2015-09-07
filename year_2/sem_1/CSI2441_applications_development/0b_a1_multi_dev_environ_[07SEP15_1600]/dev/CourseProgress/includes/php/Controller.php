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

        // go get user input
        $this->retrieveStudentDetails();
        $this->retrieveUnitDetails();

        // validate the input
        $this->theValidator->validateStudentDetails();
        $this->theValidator->validateUnitDetails();
        $this->theValidator->validateLogic();
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

    /**
     * This function retrieves unit data from the form.
     */
    private function retrieveUnitDetails() {

        for($i = 0; $i < Units::UNIT_ROWS; $i++) {

            $j = $i + 1;

            // if row is partially/fully populated, store it in unitDetails array.
            if ($_POST["UnitCode_" . $j] != "" ||
                $_POST["CP_" . $j] != "" ||
                $_POST["YS_" . $j] != "" ||
                $_POST["UM_" . $j] != ""
            ) {
                $this->theUnits->setUnitDetailsAt($i, Units::UC, $_POST["UnitCode_" . $j]);
                $this->theUnits->setUnitDetailsAt($i, Units::CP, $_POST["CP_" . $j]);
                $this->theUnits->setUnitDetailsAt($i, Units::YS, $_POST["YS_" . $j]);
                $this->theUnits->setUnitDetailsAt($i, Units::UM, $_POST["UM_" . $j]);
                // make grade blank for now
                $this->theUnits->setUnitDetailsAt($i, Units::GR, "");
                $this->theUnits->unitsIsPopulated();
            }
        }
    }
}

?>