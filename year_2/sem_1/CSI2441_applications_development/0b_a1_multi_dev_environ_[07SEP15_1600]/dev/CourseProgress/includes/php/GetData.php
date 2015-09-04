<?php

namespace includes;
require 'includes/php/Student.php';
use includes\Student;

class GetData {

    private $isStudentPopulated = false;
    private $isUnitPopulated = false;

    private $totalFieldCount;
    private $unitFieldCount;
    private $unitRows;

    const UNIT_COLS = 4;
    public static $filledRows = 0;

    function __construct() {
        $this->setupArrays();
    }

    public function setupArrays() {

        global $totalFieldCount;
        global $unitFieldCount;
        global $totalFieldCount;
        global $unitRows;
        global $unitFieldCount;

        foreach($_POST as $key => $value) {
            $this->$totalFieldCount++;
        }

        $this->unitFieldCount = $this->$totalFieldCount - Student::$studentDetailsTally + 1;
        $this->$unitRows = $this->$unitFieldCount / $this::UNIT_COLS;
    }
}

?>