<?php

namespace includes;


class ViewSummary extends View {

    private $h2StudentDetails = "Student details";
    private $h2ProgressSummary = "Progression summary";
    private $h2CreditPointSummary = "Credit point summary";
    private $h2HighestMark = "Highest mark";
    private $h2Transcript = "Transcript";

    private $progressionStatus;
    private $isComplete;
    private $passedCPTotal;
    private $cpDelta;
    private $unitAttemptTotal;
    private $unitsPassed;
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
            $theRules->getUnitsPassed(),
            $theRules->getSemRemaining(),
            $theRules->getMarkAverage()
        );

        $this->printStudentDetails();
        $this->printProgressionSummary();

        $this->printCreditPointSummary();
//        $this->printHighestMark();
//        $this->printTranscript();
    }

    /**
     * This function retrieves all the data calculated from theRules,
     * and sets them to the associated class field so they can be used
     * for printing.
     *
     * @param String $progressionStatus.
     * @param bool $isComplete
     * @param int $passedCPTotal
     * @param int $cpDelta
     * @param int $unitAttemptTotal
     * @param int $unitsPassed
     * @param double $semRemaining
     * @param double $markAverage
     */
    protected final function setRuleValues($progressionStatus,
                                           $isComplete,
                                           $passedCPTotal,
                                           $cpDelta,
                                           $unitAttemptTotal,
                                           $unitsPassed,
                                           $semRemaining,
                                           $markAverage) {
        $this->progressionStatus = $progressionStatus;
        $this->isComplete = $isComplete;
        $this->passedCPTotal = $passedCPTotal;
        $this->cpDelta = $cpDelta;
        $this->unitAttemptTotal = $unitAttemptTotal;
        $this->unitsPassed = $unitsPassed;
        $this->semRemaining = $semRemaining;
        $this->markAverage = $markAverage;
    }

    /**
     * This function prints the student details.
     */
    private final function printStudentDetails() {
        // print the title
        $this->printTitle("h2", $this->h2StudentDetails, false);

        // print student details
        echo("<p>");
        echo($this->bold("Name: ") . $this->studentDetailsArray[Student::FN] . " " . $this->studentDetailsArray[Student::SN] . $this->br);
        echo($this->bold("Student ID: ") . $this->studentDetailsArray[Student::ID] . $this->br);
        echo($this->bold("Enrolment type: ") . $this->enrolmentType . $this->br);
        echo($this->bold("Course type: ") . $this->courseType . $this->br);
        echo("</p>");
    }

    /**
     * This function prints the progression summary.
     */
    private final function printProgressionSummary() {
        // print the title
        $this->printTitle("h2", $this->h2ProgressSummary, false);

        // print progression summary
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

    private final function printCreditPointSummary() {
        // print the title
        $this->printTitle("h2", $this->h2CreditPointSummary, false);

        // print credit point summary
        echo($this->bold("Total achieved credit points: ") . $this->passedCPTotal . $this->br);
        echo($this->bold("Additional credit points required for completion: ") . $this->cpDelta . $this->br);
        echo($this->bold("Units attempted: ") . $this->unitAttemptTotal . $this->br);
        echo($this->bold("Units passed: ") . $this->unitsPassed . $this->br);
        echo($this->bold("Semesters remaining: ") . $this->semRemaining . $this->br);
        echo($this->bold("Average mark: ") . $this->markAverage . $this->br);
        echo("</p>");
    }
}

?>