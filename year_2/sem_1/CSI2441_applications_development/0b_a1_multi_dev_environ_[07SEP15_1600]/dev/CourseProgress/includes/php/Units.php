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
    private $highestMark = array();

    /**
     * The constructor for the Units class.
     */
    function __construct() {

        // init some default values
        $this->isPopulated = false;
        $this->setHighestMark( "", 0, "", 0, "");
    }

    /**
     * This function kicks off Units.
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

            // if any unit form posts are not blank, store them in array
            if ($_POST["UnitCode_" . $j] != "" ||
                $_POST["CP_" . $j] != "" ||
                $_POST["YS_" . $j] != "" ||
                $_POST["UM_" . $j] != ""
            ) {
                $this->unitDetails[$i][$this::UC] = $_POST["UnitCode_" . $j];
                $this->unitDetails[$i][$this::CP] = $_POST["CP_" . $j];
                $this->unitDetails[$i][$this::YS] = $_POST["YS_" . $j];
                $this->unitDetails[$i][$this::UM] = $_POST["UM_" . $j];
                $this->unitDetails[$i][$this::GR] = "";

                $this->isPopulated = true;
            }
        }
    }

    /**
     * This function sets the credit point for an entry in the input array.
     * Casts credit points as int.
     *
     * @param int $index - The array index, where to set the credit points.
     * @param int $cp - The credit points to set.
     */
    public function setCreditPoints($index, $cp) {
        $this->unitDetails[$index][$this::CP] = (int) $cp;
    }

    /**
     * This function sets the unit mark for an entry in the input array.
     * Casts unit mark as int.
     *
     * @param $index - The array index, where to set the credit points.
     * @param int $mark - The unit mark to set.
     */
    public function setUnitMark($index, $mark) {
        $this->unitDetails[$index][$this::UM] = (int) $mark;
    }

    /**
     * This function sets the unit grade for an entry in the input array.
     *
     * @param int $index - The array index, where to set the grade.
     * @param String $grade - The grade to set.
     */
    public function setUnitGrade($index, $grade) {
        $this->unitDetails[$index][$this::GR] = $grade;
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