<?php

namespace includes;

/**
 * Class ViewSummary is a subclass of View.
 * This class prints a student's progression summary to screen, when user input is validated, and a summary is calculated.
 *
 * It also provides the user with a table of their highest mark and transcript.
 *
 * @author Martin Ponce, 10371381
 * @version 20150908
 * @package includes
 */
class ViewSummary extends View {

    private $h2StudentDetails = "Student details";
    private $h2ProgressSummary = "Progression summary";
    private $h2CreditPointSummary = "Credit point summary";
    private $h2HighestMark = "Highest mark";
    private $h2Transcript = "Transcript";

    // store relevant details from theRules here
    private $progressionStatus;
    private $isComplete;
    private $passedCPTotal;
    private $cpDelta;
    private $unitAttemptTotal;
    private $unitsPassed;
    private $semRemaining;
    private $markAverage;
    private $gradeAverage;

    // only copies of these arrays stored here, not reference to the objects, so we have "read only" access
    // note: don't shadow array names here, otherwise may cause data loss
    private $studentDetailsArray;
    private $unitDetailsArray;
    private $highestMarkArray;

    // configure table design here
    private $tableConfig = "border=\"1\" cellpadding=\"10\" style=\"border-collapse:collapse;\"";

    /**
     * The ViewSummary constructor.
     *
     * @param String $h1Header - The main title of this view
     * @param String $progressionStatus - The Student's progression status.
     * @param bool $isComplete - Has Student completed course?
     * @param int $passedCPTotal - Credit points Student has earned.
     * @param int $cpDelta - Credit points Student has remaining to finish course.
     * @param int $unitAttemptTotal - How many Units the Student has attempted.
     * @param int $unitsPassed - How many Units the Student has passed.
     * @param int $semRemaining - How many semesters the Student has remaining.
     * @param int $markAverage - Student's average mark.
     * @param int $gradeAverage - Student's average grade.
     * @param array $studentDetails - studentDetails array.
     * @param array $unitDetails - unitDetails array.
     * @param array $highestMark - highestMark array.
     */
    function __construct($h1Header, $progressionStatus,
                         $isComplete, $passedCPTotal,
                         $cpDelta, $unitAttemptTotal,
                         $unitsPassed, $semRemaining,
                         $markAverage, $gradeAverage,
                         array $studentDetails, array $unitDetails,
                         array $highestMark
    ) {
        // call super constructor
        parent::__construct($h1Header);

        // set all the incoming params
        $this->progressionStatus = $progressionStatus;
        $this->isComplete = $isComplete;
        $this->passedCPTotal = $passedCPTotal;
        $this->cpDelta = $cpDelta;
        $this->unitAttemptTotal = $unitAttemptTotal;
        $this->unitsPassed = $unitsPassed;
        $this->semRemaining = $semRemaining;
        $this->markAverage = $markAverage;
        $this->gradeAverage = $gradeAverage;
        $this->studentDetailsArray = $studentDetails;
        $this->unitDetailsArray = $unitDetails;
        $this->highestMarkArray = $highestMark;

        // convert some student values to their meaning
        $this->convertEnrolmentType($this->studentDetailsArray[Student::ET]);
        $this->convertCourseType($this->studentDetailsArray[Student::CT]);

        // time to print stuff to screen
        $this->printStudentDetails();
        $this->printProgressionSummary();
        $this->printCreditPointSummary();
        $this->printHighestMark();
        $this->printTranscript();

        // print the back button
        echo($this->backButton);
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
     * This function prints the credit point summary.
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
        echo($this->highestMarkArray[Units::UC]);
        echo("</td>");
        echo("<td align=\"center\">");
        echo($this->highestMarkArray[Units::CP]);
        echo("</td>");
        echo("<td align=\"center\">");
        echo($this->highestMarkArray[Units::YS]);
        echo("</td>");
        echo("<td align=\"right\">");
        echo($this->highestMarkArray[Units::UM]);
        echo("</td>");
        echo("<td>");
        echo($this->highestMarkArray[Units::GR]);
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

        for($i = 0; $i < sizeof($this->unitDetailsArray); $i++) {
            echo("<tr>");
            echo("<td>");
            echo($this->unitDetailsArray[$i][Units::UC]);
            echo("</td>");
            echo("<td align=\"center\">");
            echo($this->unitDetailsArray[$i][Units::CP]);
            echo("</td>");
            echo("<td align=\"center\">");
            echo($this->unitDetailsArray[$i][Units::YS]);
            echo("</td>");
            echo("<td align=\"right\">");

            // show any mark less than pass as red
            if($this->unitDetailsArray[$i][Units::UM] < BusinessRules::MARK_PASS) {
                $this->printRed($this->unitDetailsArray[$i][Units::UM]);
                echo("</td>");
                echo("<td>");
                $this->printRed($this->unitDetailsArray[$i][Units::GR]);
            } else {
                echo($this->unitDetailsArray[$i][Units::UM]);
                echo("</td>");
                echo("<td>");
                echo($this->unitDetailsArray[$i][Units::GR]);
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