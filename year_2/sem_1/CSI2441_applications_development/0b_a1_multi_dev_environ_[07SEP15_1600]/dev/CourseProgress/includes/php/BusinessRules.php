<?php
namespace includes;

/**
 * Class BusinessRules contains all the business related logic to
 * provide a summary of a student's progress, and validate user input.
 *
 * @package includes
 */
class BusinessRules {

    // constants used to validate business rules
    const CT_UNDERGRAD = 1;
    const CT_UNDERGRAD_DOUBLE = 2;
    const CT_GRAD_DIPLOMA = 3;
    const CT_MASTERS_COURSE = 4;
    const CT_MASTERS_RESEARCH = 5;

    const CP_UNDERGRAD = 360;
    const CP_UNDERGRAD_DOUBLE = 480;
    const CP_GRAD_DIPLOMA = 120;
    const CP_MASTERS_COURSE = 180;
    const CP_MASTERS_RESEARCH = 240;

    const CP_FULLTIME = 60;
    const CP_PARTTIME = 30;

    const MARK_PASS = 50;
    const MARK_SUP_MIN = 45;
    const MARK_SUP_MAX = 49;

    // TODO: Define the constructor
    function __construct() {

    }

    /**
     * Function determines the grade of a mark.
     *
     * @param $mark int - The mark to grade.
     * @return string - The grade.
     */
    public function getGrade($mark) {

        switch($mark) {
            case $mark >= 80:
                return "HD";
            case $mark >= 70:
                return "D";
            case $mark >= 60:
                return "CR";
            case $mark >= 50:
                return "C";
            case $mark >= 0:
                return "N";
        }
    }
}

?>