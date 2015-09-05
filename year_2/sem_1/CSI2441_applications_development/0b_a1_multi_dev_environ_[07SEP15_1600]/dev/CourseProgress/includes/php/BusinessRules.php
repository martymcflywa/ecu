<?php
namespace includes;

/**
 * Class BusinessRules contains all the business related logic to
 * calculate a summary of a student's course progress.
 *
 * @package includes
 */
class BusinessRules {

    // import references to student/unitDetails arrays
    // note: avoid shadowing variable names for arrays, causes array to string conversion error
    private $studentDetailsArray;
    private $unitDetailsArray;

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

    // variables for calculating summary

    // credit points
    private $passedCPTotal;
    private $cpDelta;

    // units/semesters
    private $unitAttemptTotal;
    private $unitsPassed;
    private $semRemaining;
    private $semTotal;

    // marks/grades
    private $markTotal;
    private $markAverage;
    private $gradeAverage;

    // progression/complete status
    private $progressionStatus;
    private $completeStatus;

    // fails
    private $failedUnitsTally;
    private $failedUnitsCP;
    // supplementary
    private $matchedFailedTally;
    private $supFirstSemTally;
    private $supLastSemTally;

    // TODO: Define the constructor
    function __construct() {

    }

    public final function calculateSummary() {
        // call all the things
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

    /**
     * This function imports the input arrays from the Student and Units class.@deprecated
     * This must occur post validation by Validator.
     *
     * Once input arrays have been imported, it will kick off calculation of the summary.
     *
     * @param array $studentDetails
     * @param array $unitDetails
     */
    public final function setInputArrays(array $studentDetails, array $unitDetails) {
        $this->studentDetailsArray = $studentDetails;
        $this->unitDetailsArray = $unitDetails;
        // now that we have all the input data, we can start validation
        //$this->calculateSummary();
    }
}

?>