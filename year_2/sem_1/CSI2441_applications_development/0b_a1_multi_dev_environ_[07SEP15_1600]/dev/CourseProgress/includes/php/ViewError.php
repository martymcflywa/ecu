<?php

namespace includes;

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

//    function __construct($h1Header, Validator $theValidator) {
//
//        //parent::__construct($h1Header, );
//
//        $this->$h1Header = $h1Header;
//        $this->theValidator = $theValidator;
//
//        $this->printTitle("h1", $this->h1Header, true);
//
//
//
//        $this->startView();
//
//        echo($this->br);
//        echo("</p>");
//        echo("<p> $this->footer </p>");
//        echo($this->backButton);
//
//    }

    protected function startView() {

        // some states to test before printing
        $this->isFormEmpty = $this->theValidator->isStudentPopulated() && $this->theValidator->isUnitsPopulated();
        $this->isOnlyStudent = $this->theValidator->isStudentPopulated() && !$this->theValidator->isUnitsPopulated();
        $this->isOnlyUnits = !$this->theValidator->isStudentPopulated() && $this->theValidator->isUnitsPopulated();

        if($this->isFormEmpty) {
            echo($this->messageEmptyForm);
            echo($this->br);
        } else if($this->isOnlyStudent) {
            $this->printStudentErrors();
            $this->printEmptyUnits();
        } else if($this->isOnlyUnits) {
            $this->printEmptyStudent();
            $this->printUnitErrors();
            $this->printLogicErrors();
        } else {
            // print all the things
            $this->printStudentErrors();
            $this->printUnitErrors();
            $this->printLogicErrors();
        }
    }

    /**
     * This function prints student errors.
     * Only executes if errors exist.
     */
    private function printStudentErrors() {

        if($this->theValidator->getStudentErrorTally() > 0) {
            // print the title
            $this->printTitle("h2", $this->h2StudentErrors, false);
            // start an unordered list
            echo("<ul>");

            // loop through the student error message array
            for($i = 0; $i < sizeof($this->theValidator->getStudentErrorMessage()); $i++) {
                // print each as a list item
                echo("<li>");
                echo($this->bold($this->theValidator->getStudentErrorMessage()[$i][Validator::E_FIELD]));
                echo(" ");
                // convert the code to a message string
                echo($this->theValidator->getErrorCode($this->theValidator->getStudentErrorMessage()[$i][Validator::E_ECODE]));
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

        if($this->theValidator->getUnitErrorTally() > 0) {
            // print the title
            $this->printTitle("h2", $this->h2UnitErrors, false);
            // start the list
            echo("<ul>");

            for($i = 0; $i < sizeof($this->theValidator->getUnitErrorMessage()); $i++) {

                // if current rows match, just add to the existing list
                if($currentRow == $this->theValidator->getUnitErrorMessage()[$i][Validator::E_ROW]) {
                    echo("<li>");
                    echo($this->bold($this->theValidator->getUnitErrorMessage()[$i][Validator::E_FIELD]));
                    echo(" ");
                    // this line converts the error code in the array, to a string
                    echo($this->theValidator->getErrorCode($this->theValidator->getUnitErrorMessage()[$i][Validator::E_ECODE]));
                    echo("</li>");
                // else they don't match, so start a new list for the new row
                } else {
                    // if this isn't the first entry, close the previous list
                    if($i != 0) {
                        echo("</ul>");
                    }
                    // start new list
                    echo($rowTitle . $this->bold($this->theValidator->getUnitErrorMessage()[$i][Validator::E_ROW] . ":"));
                    echo("<ul>");
                    echo("<li>");
                    echo($this->bold($this->theValidator->getUnitErrorMessage()[$i][Validator::E_FIELD]));
                    echo(" ");
                    echo($this->theValidator->getErrorCode($this->theValidator->getUnitErrorMessage()[$i][Validator::E_ECODE]));
                    echo("</li>");
                }
            }
        }
    }

    /**
     * This function prints logic errors.
     * Only executes if errors exist.
     */
    private function printLogicErrors() {

        if($this->theValidator->getLogicErrorTally() > 0) {
            // print the title
            $this->printTitle("h2", $this->h2LogicErrors, false);
            // start the list
            echo("<ul>");

            for($i = 0; $i < sizeof($this->theValidator->getLogicErrorMessage()); $i++) {

                echo("<li>");
                // print the field
                echo($this->bold($this->theValidator->getLogicErrorMessage()[$i][Validator::E_FIELD]));
                echo(" ");
                // convert code to message
                echo($this->theValidator->getErrorCode($this->theValidator->getLogicErrorMessage()[$i][Validator::E_ECODE]));

                // decide whether to display semester or not
                switch($this->theValidator->getLogicErrorMessage()[$i][Validator::E_ECODE]) {
                    case 9:
                        echo($this->theValidator->getLogicErrorMessage()[$i][Validator::LE_ROW_1]);
                        echo(" and ");
                        echo($this->theValidator->getLogicErrorMessage()[$i][Validator::LE_ROW_2]);
                        break;
                    case 10:
                        echo($this->theValidator->getLogicErrorMessage()[$i][Validator::LE_SEM]);
                        echo(" at rows ");
                        echo($this->theValidator->getLogicErrorMessage()[$i][Validator::LE_ROW_1]);
                        echo(" and ");
                        echo($this->theValidator->getLogicErrorMessage()[$i][Validator::LE_ROW_2]);
                        break;
                }
            }
            // close the list
            echo("</ul>");
        }
    }

    /**
     * This function prints a message when no student details are provided.
     */
    private function printEmptyStudent() {
        $this->printTitle("h2", $this->h2StudentErrors, false);
        echo($this->messageEmptyStudent);
        echo($this->br);
    }

    /**
     * This function prints a message when no unit details are provided.
     */
    private function printEmptyUnits() {
        $this->printTitle("h2", $this->h2UnitErrors, false);
        echo($this->messageEmptyUnits);
        echo($this->br);
    }

}

?>