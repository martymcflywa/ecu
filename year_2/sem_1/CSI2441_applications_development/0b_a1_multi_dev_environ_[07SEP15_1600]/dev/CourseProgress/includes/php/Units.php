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

    private $theValidator;

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

        // go get unit details from the form
        $this->retrieveUnitDetails();
    }

    /**
     * Function retrieves unit data from the form.
     */
    private function retrieveUnitDetails() {

        global $filledRows;

        for($i = 0; $i < $this::UNIT_ROWS; $i++) {

            if(Helpers::isPopulated("UnitCode_" . $i++) ||
                    Helpers::isPopulated("CP_" . $i++) ||
                    Helpers::isPopulated("YS_" . $i++) ||
                    Helpers::isPopulated("UM_" . $i++)) {
                $this->unitDetails[$i][$this::UC] = $_POST["UnitCode_" . $i++];
                $this->unitDetails[$i][$this::CP] = $_POST["CP_" . $i++];
                $this->unitDetails[$i][$this::YS] = $_POST["YS_" . $i++];
                $this->unitDetails[$i][$this::UM] = $_POST["UM_" . $i++];

                $filledRows++;
                $this->isPopulated = true;
            }
        }
    }

    /**
     * Function sets the highestMark array.
     *
     * @param $unitCode String.
     * @param $creditPoints int.
     * @param $sem String.
     * @param $mark int.
     * @param $grade String.
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
     * @param $index - The desired index of the array.
     * @return mixed $highestMark;
     */
    public function getHighestMark($index) {
        return $this->highestMark[$index];
    }

    /**
     * Function imports the Validator class.
     *
     * @param $theValidator
     */
    public function setTheValidator($theValidator) {
        $this->theValidator = $theValidator;
    }

    /**
     * Function returns unitDetails array.
     *
     * @return mixed $unitDetails - Unit details array.
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