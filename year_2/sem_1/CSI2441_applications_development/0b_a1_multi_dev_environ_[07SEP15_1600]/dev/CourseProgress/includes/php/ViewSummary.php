<?php

namespace includes;


class ViewSummary extends View {

    private $h2StudentDetails = "Student details";
    private $h2ProgressSummary = "Progression summary";

    private $progressionStatus;
    private $isComplete;
    private $passedCPTotal;
    private $cpDelta;
    private $unitAttemptTotal;
    private $semRemaining;
    private $markAverage;

    private $highestMark;




    /**
     * @Override
     * Customizing startView for ViewSummary.
     */
    protected function startView() {

        global $theRules;

        $this->setRuleValues(
            $theRules->getProgressionStatus(),
            $theRules->isComplete(),
            $theRules->getPassedCP(),
            $theRules->getCPDelta(),
            $theRules->getUnitsAttempted(),
            $theRules->getSemRemaining(),
            $theRules->getMarkAverage()
        );

        $this->printStudentDetails();
        $this->printProgressionSummary();

//        $this->printCreditPointSummary();
//        $this->printHighestMark();
//        $this->printTranscript();
    }

    protected final function setRuleValues($progressionStatus,
                                           $isComplete,
                                           $passedCPTotal,
                                           $cpDelta,
                                           $unitAttemptTotal,
                                           $semRemaining,
                                           $markAverage) {
        $this->progressionStatus = $progressionStatus;
        $this->isComplete = $isComplete;
        $this->passedCPTotal = $passedCPTotal;
        $this->cpDelta = $cpDelta;
        $this->unitAttemptTotal = $unitAttemptTotal;
        $this->semRemaining = $semRemaining;
        $this->markAverage = $markAverage;
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

        echo($this->printTitle("h2", $this->h2ProgressSummary, false));
        echo("<p>");

        // make the status red if anything other than good standing
        echo($this->bold("Progression status: "));
        if($this->progressionStatus != BusinessRules::GOOD_STANDING) {
            echo("<font color=\"red\">");
            echo($this->progressionStatus);
            echo("</font>" . $this->br);
        } else {
            echo($this->progressionStatus . $this->br);
        }

        // choose between true or false
        echo($this->bold("Course requirements complete: "));
        switch($this->isComplete) {
            case true:
                echo("Yes");
                break;
            case false:
                echo("No");
                break;
        }

        echo("</p>");
    }
}

?>