<?php

namespace includes;

/**
 * Class Units contains data and functions related to the units.
 *
 * @author Martin Ponce, 10371381
 * @version 20150904
 * @package includes
 */
class Units {

    // unitDetails array index
    const UC = 0;
    const CP = 1;
    const YS = 2;
    const UM = 3;
    const GR = 4;

    const UNIT_ROWS = 30;

    private $isPopulated = false;
    public static $filledRows;

    private $unitDetails;
    private $highestMark;

    /**
     * The constructor for the Units class.
     */
    function __construct() {

        global $filledRows;

        // init some default values
        $this->isPopulated = false;
        $filledRows = 0;
        // fill highestMark with zeros for now
        $this->highestMark = array(
            0,
            0,
            0,
            0,
            0
        );
    }

    /**
     * Function kicks off Units.
     * Can't call these functions until theValidator is imported,
     * so rather than calling them from the constructor, call startUnits AFTER
     * theValidator has been imported.
     */
    public function startUnits() {
        $this->retrieveUnitDetails();
    }

    /**
     * Function retrieves unit data from the form.
     */
    private function retrieveUnitDetails() {

        global $filledRows;

        for($i = 0; $i < $this::UNIT_ROWS - 1; $i++) {

            if(strlen($_POST["UnitCode_" . ++$i] > 0) ||
                    strlen($_POST["CP_" . ++$i] > 0) ||
                    strlen($_POST["YS_" . ++$i] > 0) ||
                    strlen($_POST["UM_" . ++$i] > 0)) {
                $this->unitDetails[$i][$this::UC] = $_POST["UnitCode_" . ++$i];
                $this->unitDetails[$i][$this::CP] = $_POST["CP_" . ++$i];
                $this->unitDetails[$i][$this::YS] = $_POST["YS_" . ++$i];
                $this->unitDetails[$i][$this::UM] = $_POST["UM_" . ++$i];

                $filledRows++;
                $this->isPopulated = true;
            }
        }
    }

    /**
     * Function sets the highestMark array.
     *
     * @param String $unitCode.
     * @param int $creditPoints.
     * @param String $sem.
     * @param int $mark.
     * @param String $grade.
     */
    public function setHighestMark($unitCode, $creditPoints, $sem, $mark, $grade) {

        $this->highestMark = array(
            $unitCode,
            $creditPoints,
            $sem,
            $mark,
            $grade
        );
    }

    /**
     * Function returns the highestMark array.
     *
     * @param int $index - The desired index of the array.
     * @return int $highestMark[$index] - The highest mark.
     */
    public function getHighestMark($index) {
        return $this->highestMark[$index];
    }

    /**
     * Function returns unitDetails array.
     *
     * @return array $unitDetails - Unit details array.
     */
    public function getUnitDetails() {
        return $this->unitDetails;
    }

    /**
     * Function returns isPopulated boolean.
     *
     * @return bool $isPopulated.
     */
    public function isUnitsPopulated() {
        return $this->isPopulated;
    }
}

?>