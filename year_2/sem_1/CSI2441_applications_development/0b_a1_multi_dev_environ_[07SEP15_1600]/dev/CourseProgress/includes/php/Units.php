<?php

namespace includes;

/**
 * Class Units contains data and functions related to the units.
 * It retrieves unit data from the form. It does not perform any validation.
 * This class also knows about the highestMark.
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

    // $filledRows not working for me like in asp,
    // getting NULL when referred statically,

    // public static $filledRows;

    // so using this instead: sizeof(unitDetailsArray)

    private $unitDetails = array();
    private $highestMark;

    /**
     * The constructor for the Units class.
     */
    function __construct() {

        // init some default values
        $this->isPopulated = false;

    }

    /**
     * This function kicks off Units.
     * Can't call these functions until theValidator is imported,
     * so rather than calling them from the constructor, call startUnits AFTER
     * theValidator has been imported.
     */
    public function startUnits() {
        $this->retrieveUnitDetails();
    }

    /**
     * This function retrieves unit data from the form.
     */
    private function retrieveUnitDetails() {

        for($i = 0; $i < $this::UNIT_ROWS; $i++) {

            $j = $i + 1;

            if(strlen($_POST["UnitCode_" . $j] > 0) ||
                    strlen($_POST["CP_" . $j] > 0) ||
                    strlen($_POST["YS_" . $j] > 0) ||
                    strlen($_POST["UM_" . $j] > 0)) {

                $this->unitDetails[$i][$this::UC] = $_POST["UnitCode_" . $j];
                $this->unitDetails[$i][$this::CP] = $_POST["CP_" . $j];
                $this->unitDetails[$i][$this::YS] = $_POST["YS_" . $j];
                $this->unitDetails[$i][$this::UM] = $_POST["UM_" . $j];

                $this->isPopulated = true;
            }
        }
    }

    /**
     * This function sets the highestMark array.
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
     * This function returns the highestMark array.
     *
     * @return int $highestMark - The highest mark array.
     */
    public function getHighestMark() {
        return $this->highestMark;
    }

    /**
     * This function returns the unitDetails array.
     *
     * @return array $unitDetails - Unit details array.
     */
    public function getUnitDetails() {
        return $this->unitDetails;
    }

    /**
     * This function returns the isPopulated boolean.
     *
     * @return bool $isPopulated.
     */
    public function isUnitsPopulated() {
        return $this->isPopulated;
    }
}

?>