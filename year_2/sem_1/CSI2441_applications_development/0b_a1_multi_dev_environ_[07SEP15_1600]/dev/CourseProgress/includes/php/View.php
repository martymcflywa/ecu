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

    function __construct($h1Header, array $studentDetails, array $unitDetails) {

        $this->h1Header = $h1Header;

        $this->studentDetailsArray = $studentDetails;
        $this->unitDetailsArray = $unitDetails;

        $this->backButton = "<input type=\"button\" name=\"Back\" value=\"Back\" onClick=\"history.go(-1);return true;\">";

        echo($this->printTitle("h1", $this->h1Header, true));
        $this->startView();
        echo($this->backButton);
    }

    protected function startView() {

    }

    /**
     * This function prints titles.
     *
     * @param String $hType - The heading type, only accepts "h1", "h2", "h3", "h4".
     * @param String $title - The title to print.
     * @param bool $isRuled - Want a rule underneath?
     * @return String - The final string to print.
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

        return $toPrint;
    }

    /**
     * This function prints the back button.
     */
    protected final function printBackButton() {
        echo($this->backButton);
    }
}



?>