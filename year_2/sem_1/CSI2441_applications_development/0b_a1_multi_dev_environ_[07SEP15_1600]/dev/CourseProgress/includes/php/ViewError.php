<?php

namespace includes;

class ViewError extends View {

    private $h2StudentErrors = "Student details errors";
    private $h2UnitErrors = "Unit details errors";
    private $h2LogicErrors = "Logical errors";

    private $theValidator;

    function __construct($h1Header, Validator $theValidator) {

        $this->$h1Header = $h1Header;
        $this->theValidator = $theValidator;

        $this->backButton = "<input type=\"button\" name=\"Back\" value=\"Back\" onClick=\"history.go(-1);return true;\">";
        $this->printTitle("h1", $this->h1Header, true);

        $this->startView();

        echo($this->br);
        echo($this->backButton);
    }
}

?>