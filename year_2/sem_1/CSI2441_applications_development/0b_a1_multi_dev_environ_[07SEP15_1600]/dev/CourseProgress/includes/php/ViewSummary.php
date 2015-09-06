<?php

namespace includes;

/**
 * Class ViewSummary is a subclass of View.
 * This class prints a student's progression summary to screen,
 * when user input is validated, and a summary is calculated.
 * It also provides the user with a transcript of their marks.
 *
 * @author Martin Ponce, 10371381
 * @version 20150906
 * @package includes
 */
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
    private $gradeAverage;

    private $tableConfig = "border=\"1\" cellpadding=\"10\" style=\"border-collapse:collapse;\"";

    /**
     * @Override
     * This function initiates the summary view.
     * It retrieves values calculated by BusinessRule,
     * and prints them to screen, along with a table
     * of the highestMark, and the student transcript.
     */
    protected function startView() {

        $this->setRuleValues(
            $this->theValidator->getProgressionStatus(),
            $this->theValidator->isComplete(),
            $this->theValidator->getPassedCP(),
            $this->theValidator->getCPDelta(),
            $this->theValidator->getUnitsAttempted(),
            $this->theValidator->getUnitsPassed(),
            $this->theValidator->getSemRemaining(),
            $this->theValidator->getMarkAverage(),
            $this->theValidator->getGradeAverage()
        );

        $this->printStudentDetails();
        $this->printProgressionSummary();
        $this->printCreditPointSummary();
        $this->printHighestMark();
        $this->printTranscript();
    }

    /**
     * This function retrieves all the data calculated from theRules,
     * and sets them to the associated class field so they can be used
     * for printing.
     *
     * @param String $progressionStatus.
     * @param bool $isComplete.
     * @param int $passedCPTotal.
     * @param int $cpDelta.
     * @param int $unitAttemptTotal.
     * @param int $unitsPassed.
     * @param float $semRemaining.
     * @param float $markAverage.
     * @param String $gradeAverage.
     */
    protected final function setRuleValues($progressionStatus,
                                           $isComplete,
                                           $passedCPTotal,
                                           $cpDelta,
                                           $unitAttemptTotal,
                                           $unitsPassed,
                                           $semRemaining,
                                           $markAverage,
                                           $gradeAverage)
    {
        $this->progressionStatus = $progressionStatus;
        $this->isComplete = $isComplete;
        $this->passedCPTotal = $passedCPTotal;
        $this->cpDelta = $cpDelta;
        $this->unitAttemptTotal = $unitAttemptTotal;
        $this->unitsPassed = $unitsPassed;
        $this->semRemaining = $semRemaining;
        $this->markAverage = $markAverage;
        $this->gradeAverage = $gradeAverage;
    }

    /**
     * This function prints the student details.
     */
    private final function printStudentDetails() {

        // print the title
        $this->printTitle("h2", $this->h2StudentDetails, false);

        // print student details
        echo("<p>");
        echo($this->bold("Name: ") . $this->theValidator->getStudentDetails()[Student::FN] . " " . $this->theValidator->getStudentDetails()[Student::SN] . $this->br);
        echo($this->bold("Student ID: ") . $this->theValidator->getStudentDetails()[Student::ID] . $this->br);
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

        // test isComplete, ie. is student completed their course
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

    /**
     * This function prints the progression summary.
     */
    private final function printCreditPointSummary() {
        // print the title
        $this->printTitle("h2", $this->h2CreditPointSummary, false);

        // print credit point summary
        echo("<p>");
        echo($this->bold("Total achieved credit points: ") . $this->passedCPTotal . $this->br);
        echo($this->bold("Additional credit points required for completion: ") . $this->cpDelta . $this->br);
        echo($this->bold("Units attempted: ") . $this->unitAttemptTotal . $this->br);
        echo($this->bold("Units passed: ") . $this->unitsPassed . $this->br);
        echo($this->bold("Semesters remaining: ") . $this->semRemaining . $this->br);
        echo($this->bold("Average mark: ") . $this->markAverage . " " . $this->gradeAverage . $this->br);
        echo("</p>");
    }

    /**
     * This function prints the highest mark as a table.
     */
    private final function printHighestMark() {

        // print the title
        $this->printTitle("h2", $this->h2HighestMark, false);

        // print the highest mark
        echo("<table $this->tableConfig>");
        $this->printTableHeaders();

        echo("<tr>");
        echo("<td>");
        echo($this->theValidator->getHighestMark()[Units::UC]);
        echo("</td>");
        echo("<td align=\"center\">");
        echo($this->theValidator->getHighestMark()[Units::CP]);
        echo("</td>");
        echo("<td align=\"center\">");
        echo($this->theValidator->getHighestMark()[Units::YS]);
        echo("</td>");
        echo("<td align=\"right\">");
        echo($this->theValidator->getHighestMark()[Units::UM]);
        echo("</td>");
        echo("<td>");
        echo($this->theValidator->getHighestMark()[Units::GR]);
        echo("</td>");
        echo("</tr>");
        echo("</table>");
    }

    /**
     * This function prints the transcript table.
     */
    private final function printTranscript() {

        // print the title
        $this->printTitle("h2", $this->h2Transcript, false);

        // print the transcript
        echo("<table $this->tableConfig>");
        $this->printTableHeaders();

        for($i = 0; $i < sizeof($this->theValidator->getUnitDetails()); $i++) {
            echo("<tr>");
            echo("<td>");
            echo($this->theValidator->getUnitDetails()[$i][Units::UC]);
            echo("</td>");
            echo("<td align=\"center\">");
            echo($this->theValidator->getUnitDetails()[$i][Units::CP]);
            echo("</td>");
            echo("<td align=\"center\">");
            echo($this->theValidator->getUnitDetails()[$i][Units::YS]);
            echo("</td>");
            echo("<td align=\"right\">");

            // show any mark less than pass as red
            if($this->theValidator->getUnitDetails()[$i][Units::UM] < BusinessRules::MARK_PASS) {
                $this->printRed($this->theValidator->getUnitDetails()[$i][Units::UM]);
                echo("</td>");
                echo("<td>");
                $this->printRed($this->theValidator->getUnitDetails()[$i][Units::GR]);
            } else {
                echo($this->theValidator->getUnitDetails()[$i][Units::UM]);
                echo("</td>");
                echo("<td>");
                echo($this->theValidator->getUnitDetails()[$i][Units::GR]);
            }

            echo("</td>");
            echo("</tr>");
        }
        // close the table
        echo("</table>");
        echo($this->br);
    }

    /**
     * This function prints the table headers.
     * Added as function since used more than once.
     */
    private final function printTableHeaders() {
        echo("<tr>");
        echo("<th>UnitCode</th>");
        echo("<th>CreditPoints</th>");
        echo("<th>Year/Sem</th>");
        echo("<th>Mark</th>");
        echo("<th>Grade</th>");
        echo("</tr>");
    }

    /**
     * This function prints a string in red color.
     *
     * @param $string - The string to print in red.
     */
    private final function printRed($string) {
        echo("<font color=\"red\"> $string </font>");
    }
}

?>