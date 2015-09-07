<?php

namespace includes;

/**
 * Class ViewError is a subclass of View.
 * This class prints error messages to screen,
 * when user input is invalidated.
 *
 * @author Martin Ponce, 10371381
 * @version 20150906
 * @package includes
 */
class ViewError extends View {

    private $h2StudentErrors = "Student details errors";
    private $h2UnitErrors = "Unit details errors";
    private $h2LogicErrors = "Logical errors";
    private $footer = "Please return to the form, resolve the errors and try again.";

    private $isFormEmpty;
    private $isOnlyStudent;
    private $isOnlyUnits;

    private $messageEmptyForm = "<p>The form is empty. You must provide student and unit details.</p>";
    private $messageEmptyStudent = "<p>No student details were provided.</p>";
    private $messageEmptyUnits = "<p>No unit details were provided.</p>";

    // only copies of these arrays stored here,
    // not the reference, so we have "read only" access
    // note: don't shadow array names here, otherwise may cause data loss
    private $studentErrorMessageArray;
    private $unitErrorMessageArray;
    private $logicErrorMessageArray;

    // import the tallies
    private $studentErrorTally;
    private $unitErrorTally;
    private $logicErrorTally;

    // get the error code array
    private $errorCode;

    function __construct($h1Header, array $studentErrorMessage,
                         array $unitErrorMessage, array $logicErrorMessage,
                         $studentErrorTally, $unitErrorTally,
                         $logicErrorTally, $isStudentPopulated,
                         $isUnitPopulated, array $errorCode
    ) {
        // call super constructor
        parent::__construct($this->h1Header);
        // then set all the incoming params
        $this->studentErrorMessageArray = $studentErrorMessage;
        $this->unitErrorMessageArray = $unitErrorMessage;
        $this->logicErrorMessageArray = $logicErrorMessage;
        $this->studentErrorTally = $studentErrorTally;
        $this->unitErrorTally = $unitErrorTally;
        $this->logicErrorTally = $logicErrorTally;
        $this->errorCode = $errorCode;

        // set some states to test before printing
        $this->isFormEmpty = !$isStudentPopulated && !$isUnitPopulated;
        $this->isOnlyStudent = $isStudentPopulated && !$isUnitPopulated;
        $this->isOnlyUnits = !$isStudentPopulated && $isUnitPopulated;

        // TODO: FIX THIS! NOT WORKING CORRECTLY
        echo("BREAKPOINT: " . var_dump($this->isOnlyUnits));

        // test the states to determine what to print
        if ($this->isFormEmpty) {
            echo($this->messageEmptyForm);
            echo($this->br);
        } else if ($this->isOnlyStudent) {
            $this->printStudentErrors();
            $this->printEmptyUnits();
        } else if ($this->isOnlyUnits) {
            $this->printEmptyStudent();
            $this->printUnitErrors();
            $this->printLogicErrors();
        } else {
            // print all the things
            $this->printStudentErrors();
            $this->printUnitErrors();
            $this->printLogicErrors();
        }

        echo("<p> $this->footer </p>");
        echo($this->backButton);
    }

    /**
     * This function prints student errors.
     * Only executes if errors exist.
     */
    private function printStudentErrors() {

        if($this->studentErrorTally > 0) {
            // print the title
            $this->printTitle("h2", $this->h2StudentErrors, false);
            // start an unordered list
            echo("<ul>");

            // loop through the student error message array
            for($i = 0; $i < sizeof($this->studentErrorMessageArray); $i++) {
                // print each as a list item
                echo("<li>");
                echo($this->bold($this->studentErrorMessageArray[$i][Validator::E_FIELD]));
                echo(" ");
                // convert the code to a message string
                echo($this->getErrorCode($this->studentErrorMessageArray[$i][Validator::E_ECODE]));
                echo("</li>");
            }
            // close the list
            echo("</ul>");
        }
    }

    /**
     * This function prints unit errors.
     * Only executes if errors exist.
     */
    private function printUnitErrors() {

        $currentRow = 0;
        $rowTitle = "Error/s on Row ";

        if($this->unitErrorTally > 0) {
            // print the title
            $this->printTitle("h2", $this->h2UnitErrors, false);

            for($i = 0; $i < sizeof($this->unitErrorMessageArray); $i++) {

                // if current rows match, just add to the existing list
                if($currentRow == $this->unitErrorMessageArray[$i][Validator::E_ROW]) {
                    echo("<li>");
                    echo($this->bold($this->unitErrorMessageArray[$i][Validator::E_FIELD]));
                    echo(" ");
                    // this line converts the error code in the array, to a string
                    echo($this->getErrorCode($this->unitErrorMessageArray[$i][Validator::E_ECODE]));
                    echo("</li>");
                // else they don't match, so start a new list for the new row
                } else {
                    $currentRow = $this->unitErrorMessageArray[$i][Validator::E_ROW];
                    echo("</ul>");
                    // start new list
                    echo($rowTitle . $this->bold($this->unitErrorMessageArray[$i][Validator::E_ROW] . ":"));
                    echo("<ul>");
                    echo("<li>");
                    echo($this->bold($this->unitErrorMessageArray[$i][Validator::E_FIELD]));
                    echo(" ");
                    echo($this->getErrorCode($this->unitErrorMessageArray[$i][Validator::E_ECODE]));
                    echo("</li>");
                }
            }
            echo("</ul>");
        }
    }

    /**
     * This function prints logic errors.
     * Only executes if errors exist.
     */
    private function printLogicErrors() {

        if($this->logicErrorTally > 0) {
            // print the title
            $this->printTitle("h2", $this->h2LogicErrors, false);
            // start the list
            echo("<ul>");

            for($i = 0; $i < sizeof($this->logicErrorMessageArray); $i++) {

                echo("<li>");
                // print the field
                echo($this->bold($this->logicErrorMessageArray)[$i][Validator::LE_FIELD]);
                echo(" ");
                // convert code to message
                echo($this->getErrorCode($this->logicErrorMessageArray[$i][Validator::LE_ECODE]));

                // decide whether to display semester or not
                switch($this->logicErrorMessageArray[$i][Validator::LE_ECODE]) {
                    case 9:
                        echo($this->logicErrorMessageArray[$i][Validator::LE_ROW_1]);
                        echo(" and ");
                        echo($this->logicErrorMessageArray[$i][Validator::LE_ROW_2]);
                        break;
                    case 10:
                        echo($this->logicErrorMessageArray[$i][Validator::LE_SEM]);
                        echo(" at rows ");
                        echo($this->logicErrorMessageArray[$i][Validator::LE_ROW_1]);
                        echo(" and ");
                        echo($this->logicErrorMessageArray[$i][Validator::LE_ROW_2]);
                        break;
                }
            }
            // close the list
            echo("</ul>");
        }
    }

    /**
     * This function converts an error code to its string message.
     *
     * @param int $index - The error code.
     * @return String - The error message.
     */
    public final function getErrorCode($index) {
        return $this->errorCode[$index];
    }

    /**
     * This function prints a message when no student details are provided.
     */
    private function printEmptyStudent() {
        $this->printTitle("h2", $this->h2StudentErrors, false);
        echo($this->messageEmptyStudent);
    }

    /**
     * This function prints a message when no unit details are provided.
     */
    private function printEmptyUnits() {
        $this->printTitle("h2", $this->h2UnitErrors, false);
        echo($this->messageEmptyUnits);
    }

}

?>