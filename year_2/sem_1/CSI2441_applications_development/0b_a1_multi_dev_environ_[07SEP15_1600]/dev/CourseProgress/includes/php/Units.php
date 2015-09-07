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

    private $filledRows;

    private $unitDetails = array();
    private $highestMark = array();

    /**
     * The constructor for the Units class.
     */
    function __construct() {

        // init some default values
        $this->isPopulated = false;
        $this->filledRows = 0;
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

        // loop over post items
        for($i = 0; $i < $this::UNIT_ROWS; $i++) {

            $j = $i + 1;

            $this->retrieveField("UnitCode_", $this::UC, $i, $j);
            $this->retrieveField("CP_", $this::CP, $i, $j);
            $this->retrieveField("YS_", $this::YS, $i, $j);
            $this->retrieveField("UM_", $this::UM, $i, $j);
            // store empty string for grade, will be populated correctly by BusinessRules
            $this->unitDetails[$i][$this::GR] = "";
        }
    }

    /**
     * This function retrieves an individual unit field from the form.
     * If the form field is empty, it will store an empty string in the array.
     * Else it will store the data into the array, and update isPopulated.
     *
     * To be used inside a for loop, @see retrieveUnitDetails().
     *
     * @param String $postID - The ID 0of the post item to retrieve.
     * @param int $col - The current array column.
     * @param int $arrayRow - The current array row.
     * @param int $formRow - The current form row.
     */
    private function retrieveField($postID, $col, $arrayRow, $formRow) {
        if($_POST[$postID . $formRow] != "") {
            $this->unitDetails[$arrayRow][$col] = $_POST[$postID . $formRow];
            $this->isPopulated = true;
        } else {
            $this->unitDetails[$arrayRow][$col] = "";
        }
    }

    /**
     * This function retrieves unit data from the form.
     * TODO: DELETE THIS FUNCTION AFTER REWRITE!
     */
    private function retrieveUnitDetailsDELETE() {

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

            } else {
                // else make an empty row
                $this->unitDetails[$i][$this::UC] = "";
                $this->unitDetails[$i][$this::CP] = "";
                $this->unitDetails[$i][$this::YS] = "";
                $this->unitDetails[$i][$this::UM] = "";
                $this->unitDetails[$i][$this::GR] = "";
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
     * This function returns filledRows.
     *
     * @return int filledRows - How many rows have been filled in the array.
     */
    public function getFilledRows() {
        return $this->filledRows;
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