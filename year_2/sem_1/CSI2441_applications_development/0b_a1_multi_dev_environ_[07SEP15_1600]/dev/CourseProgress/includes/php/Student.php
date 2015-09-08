<?php

namespace includes;

/**
 * Class Student contains the studentDetails array and defines the constant index for its elements.
 * It also defines getters/setters to manipulate data from Student.
 *
 * @author Martin Ponce, 10371381
 * @version 20150908
 * @package includes
 */
class Student {

    // and in an array to pass around easier
    private $studentDetails;

    // studentDetails array index
    const FN = 0;
    const SN = 1;
    const ET = 2;
    const ID = 3;
    const CT = 4;

    // is true if studentDetails populated
    private $isPopulated;

    /**
     * The constructor for the Student class.
     */
    function __construct() {
        $this->isPopulated = false;
        $this->studentDetails = array();
    }

    /**
     * This function stores a value at the specified index of
     * the studentDetails array.
     *
     * @param int $index - Where to store the value.
     * @param String $value - The value to store
     */
    public final function setStudentDetailsAt($index, $value) {
        $this->studentDetails[$index] = $value;
    }

    /**
     * This function sets the isPopulated boolean to true.
     */
    public final function studentIsPopulated() {
        $this->isPopulated = true;
    }

    /**
     * This function returns the studentDetails array.
     *
     * @return array $studentDetails - Student details array.
     */
    public final function getStudentDetails() {
        return $this->studentDetails;
    }

    /**
     * This function returns the isPopulated boolean.
     *
     * @return bool $isPopulated.
     */
    public final function isStudentPopulated() {
        return $this->isPopulated;
    }
}

?>