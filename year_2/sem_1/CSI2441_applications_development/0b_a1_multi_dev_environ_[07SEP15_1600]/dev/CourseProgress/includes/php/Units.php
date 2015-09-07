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

    private $unitDetails;
    private $highestMark;

    /**
     * The constructor for the Units class.
     */
    function __construct() {

        // init some default values
        $this->isPopulated = false;
        $this->setHighestMark( "", 0, "", 0, "");
        $this->unitDetails = array();
        $this->highestMark = array();
    }

    /**
     * This function stores a value at the specified
     * row and column of unitDetails array.
     *
     * @param int $row - The row where to store the value.
     * @param int $col - The column where to store the value.
     * @param String $value - The value to store
     */
    public function setUnitDetailsAt($row, $col, $value) {
        $this->unitDetails[$row][$col] = $value;
    }

    /**
     * This function sets the credit point for an entry in the input array.
     * Casts credit points as int.
     *
     * @param int $index - The array index, where to set the credit points.
     * @param int $cp - The credit points to set.
     * @deprecated by setUnitDetailsAt(). TODO: delete
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
     * @deprecated by setUnitDetailsAt(). TODO: delete
     */
    public function setUnitMark($index, $mark) {
        $this->unitDetails[$index][$this::UM] = (int) $mark;
    }

    /**
     * This function sets the unit grade for an entry in the input array.
     *
     * @param int $index - The array index, where to set the grade.
     * @param String $grade - The grade to set.
     * @deprecated by setUnitDetailsAt(). TODO: delete
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
     * This function sets the isPopulated boolean to true.
     */
    public function unitsIsPopulated() {
        $this->isPopulated = true;
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