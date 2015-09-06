<?php

namespace includes;

/**
 * Class View is the super class of ViewSummary and ViewError.
 *
 * @package includes
 */
class View {

    // the main title of the view
    protected $h1Header;
    protected $backButton;

    // import the arrays
    protected $studentDetailsArray;
    protected $unitDetailsArray;

    // import the rules
    protected $theRules;

    // time to convert enrolment/course type back from value to meaning
    protected $enrolmentType;
    protected $courseType;

    // some shortcuts
    protected $br = "<br />";

    /**
     * The View constructor.
     * Provide a h1Header for the title of this view,
     * pass in student/unitDetails array and theRules object.
     *
     * @param String $h1Header
     * @param array $studentDetails
     * @param array $unitDetails
     * @param BusinessRules $theRules
     */
    function __construct($h1Header, array $studentDetails, array $unitDetails, BusinessRules $theRules) {

        $this->h1Header = $h1Header;

        $this->studentDetailsArray = $studentDetails;
        $this->unitDetailsArray = $unitDetails;

        $this->convertEnrolmentType();
        $this->convertCourseType();

        $this->backButton = "<input type=\"button\" name=\"Back\" value=\"Back\" onClick=\"history.go(-1);return true;\">";

        $this->printTitle("h1", $this->h1Header, true);
        $this->startView();

        echo($this->br);
        echo($this->backButton);
    }

    /**
     * This function converts the enrolment type value to its actual meaning.
     */
    protected final function convertEnrolmentType() {
        switch($this->studentDetailsArray[Student::ET]) {
            case BusinessRules::CP_FULLTIME:
                $this->enrolmentType = "Full time";
                break;
            case BusinessRules::CP_PARTTIME:
                $this->enrolmentType = "Part time";
                break;
        }
    }

    /**
     * This function converts the course type value to its actual meaning.
     */
    protected final function convertCourseType() {
        switch($this->studentDetailsArray[Student::CT]) {
            case BusinessRules::CP_UNDERGRAD:
                $this->courseType = "Undergraduate degree (" . $this->studentDetailsArray[Student::CT] . " CP)";
                break;
            case BusinessRules::CP_UNDERGRAD_DOUBLE:
                $this->courseType = "Undergraduate double degree (" . $this->studentDetailsArray[Student::CT] . " CP)";
                break;
            case BusinessRules::CP_GRAD_DIPLOMA:
                $this->courseType = "Graduate diploma (" . $this->studentDetailsArray[Student::CT] . " CP)";
                break;
            case BusinessRules::CP_MASTERS_COURSE:
                $this->courseType = "Masters by coursework (" . $this->studentDetailsArray[Student::CT] . " CP)";
                break;
            case BusinessRules::CP_MASTERS_RESEARCH:
                $this->courseType = "Masters by research (" . $this->studentDetailsArray[Student::CT] . " CP)";
                break;
        }
    }

    /**
     * Override me!
     */
    protected function startView() {
        // add what you want to do here
        // it is called at construction
    }

    /**
     * This function prints titles.
     *
     * @param String $hType - The heading type, only accepts "h1", "h2", "h3", "h4".
     * @param String $title - The title to print.
     * @param bool $isRuled - Want a rule underneath?
     * @return String - The string to print.
     */
    protected final function printTitle($hType, $title, $isRuled) {

        $toPrint = "";

        switch($hType) {
            case "h1":
                $toPrint = "<h1>" . $title . "</h1>";
                break;
            case "h2":
                $toPrint = "<h2>" . $title . "</h2>";
                break;
            case "h3":
                $toPrint = "<h3>" . $title . "</h3>";
                break;
            case "h4":
                $toPrint = "<h4>" . $title . "</h4>";
                break;
        }

        if($isRuled) {
            $toPrint = $toPrint . "\n<hr />\n";
        }

        echo($toPrint);
    }

    /**
     * This function performs a shortcut to make the font bold in html.
     *
     * @param String $string - The string you want to show up as bold.
     * @return String - The string in bold.
     */
    protected final function bold($string) {
        return "<strong>" . $string . "</strong>";
    }

    /**
     * This function prints the back button.
     */
    protected final function printBackButton() {
        echo($this->backButton);
    }
}



?>