<?php

namespace includes;


class ViewSummary extends View {

    private $h2StudentDetails = "Student details";
    private $h2ProgressSummary = "Progression summary";

    private $progressionStatus;
    private $isComplete;
    private $passedCPTotal;
    private $cpDelta;
    private $unitsAttempted;




    /**
     * @Override
     * Customizing startView for ViewSummary.
     */
    protected function startView() {

        global $theRules;

        $this->setRuleValues($theRules->getProgressionStatus(), $theRules->isComplete());

        $this->printStudentDetails();

        $this->printCreditPointSummary();
        $this->printHighestMark();
        $this->printTranscript();
    }

    protected final function setRuleValues($progressionStatus, $isComplete, $) {

    }

    /**
     * This function prints the student details to screen.
     */
    protected final function printStudentDetails() {
        // print the title
        echo($this->printTitle("h2", $this->h2StudentDetails, false));
        // print student details
        echo("<p>");
        echo($this->bold("Name: ") . $this->studentDetailsArray[Student::FN] . " " . $this->studentDetailsArray[Student::SN] . $this->br);
        echo($this->bold("Student ID: ") . $this->studentDetailsArray[Student::ID] . $this->br);
        echo($this->bold("Enrolment type: ") . $this->enrolmentType . $this->br);
        echo($this->bold("Course type: ") . $this->courseType . $this->br);
        echo("</p>");
    }

    protected final function printProgressionSummary() {


    }
}

?>