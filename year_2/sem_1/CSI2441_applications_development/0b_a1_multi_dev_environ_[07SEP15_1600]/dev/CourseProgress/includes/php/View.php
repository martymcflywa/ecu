<?php

namespace includes;

class View {

    protected $h1Header;
    protected $backButton;

    function __const($h1Header) {

        $this->h1Header = $h1Header;
        $this->backButton = "<input type=\"button\" name=\"Back\" value=\"Back\" onClick=\"history.go(-1);return true;\">";

    }

    protected final function printH1Header() {
        echo($this->h1Header);
    }

    protected final function printBackButton() {
        echo($this->backButton);
    }
}

?>