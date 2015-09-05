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

    // constants used to calculate summary according to business rules
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
    const MAX_FAILS = 3;

    const EXCLUDED = "Excluded";
    const GOOD_STANDING = "Good standing";
    const GOOD_STANDING_SUP = "Good standing, pending supp";

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
    private $isComplete;

    // fails
    private $failedUnitsTally;
    private $failedUnitsCP;
    // supplementary
    private $matchedFailedTally;
    private $supFirstSemTally;
    private $supLastSemTally;

    // TODO: Define the constructor
    function __construct() {

        $this->isComplete = false;
    }

    public final function calculateSummary() {
        // call all the things
        $this->setSemTotal();
        //$this->iterateUnitDetails();
        $this->setCPDelta();
        $this->setIsComplete();
        $this->setMarkAverage();
        $this->setProgressionStatus();
        $this->setSemRemaining();
        $this->setSupUnit();
    }

    private final function iterateUnitDetails() {

        $currentSem = "";
        $semUnits = "";
        $semFails = "";

        for($i = 0; $i < Units::$filledRows; $i++) {

            $this->incrementUnitAttemptTotal();

            // if student passed unit
            if($this->unitDetailsArray[$i][Units::UM] >= $this::MARK_PASS) {
                $this->setPassedCPTotal($i);
                $this->incrementUnitsPassed();
                $this->setMarkTotal($i);
            } else {
                $this->calculateProgression($i);
            }
        }
    }

    /**
     * Function increments unitAttemptTotal.
     */
    private final function incrementUnitAttemptTotal() {
        $this->unitAttemptTotal++;
    }

    /**
     * Function sums passedCPTotal from unitDetailsArray.
     * To be used inside for loop, @see iterateUnitDetails().
     *
     * @param int $index - The current array index.
     */
    private final function setPassedCPTotal($index) {
        $this->passedCPTotal += $this->unitDetailsArray[$index][Units::CP];
    }

    /**
     * Function increments unitsPassed.
     */
    private final function incrementUnitsPassed() {
        $this->unitsPassed++;
    }

    /**
     * Function sums markTotal from unitDetailsArray.
     * To be used inside for loop, @see iterateUnitDetails().
     *
     * @param int $index - The current array index.
     */
    private final function setMarkTotal($index) {
        $this->markTotal += $this->unitDetailsArray[$index][Units::UM];
    }

    /**
     * Function calculates student's progression.
     * To be used inside for loop, @see iterateUnitDetails().
     *
     * @param int $index - The current array index.
     */
    private final function calculateProgression($index) {

        $currentUnitCode = $this->unitDetailsArray[$index][Units::UC];
        $this->failedUnitsTally++;

        // loop from current index + 1 to remaining entries
        for($i = $index + 1; $i < Units::$filledRows; $i++) {
            // if unitcodes match and unit is failed,
            if($currentUnitCode == $this->unitDetailsArray[$index][Units::UC] &&
                    $this->unitDetailsArray[$index][Units::UM] < $this::MARK_PASS) {
                // increment matchFailedTally
                $this->matchedFailedTally++;
            }
        }
    }

    /**
     * Function sets the total number of semesters a student requires to complete for their course.
     * Student course type / Student enrolment type.
     */
    private final function setSemTotal() {
        $this->semTotal = $this->studentDetailsArray[Student::CT] / $this->studentDetailsArray[Student::ET];
    }

    /**
     * Function sets the required credit points to complete course.
     * Already stored course type value in studentDetails array,
     * so just subtract passedCPTotal from it.
     *
     * TODO: Remember to convert asp's implementation to this much simpler version as well.
     */
    private final function setCPDelta() {
        $this->cpDelta = $this->studentDetailsArray[Student::CT] - $this->passedCPTotal;
    }

    /**
     * Function sets isComplete, the complete status for a student.
     * If passedCPTotal >= student's course type, then isComplete = true.
     *
     * TODO: Remember to convert asp's implementation to this much simpler version as well.
     */
    private final function setIsComplete() {
        if($this->passedCPTotal >= $this->studentDetailsArray[Student::CT]) {
            $this->isComplete = true;
        } else {
            $this->isComplete = false;
        }
    }

    /**
     * Function calculates average mark over total units attempted.
     * Also sets the grade for the average.
     */
    private final function setMarkAverage() {
        $this->markAverage = $this->markTotal / $this->unitAttemptTotal;
        // go set the grade too
        $this->gradeAverage = $this->getGrade($this->markAverage);
    }

    /**
     * Function sets the progression status.
     * If student fails same unit 3 times or more,
     * status is "Excluded".
     */
    private final function setProgressionStatus() {
        if($this->matchedFailedTally >= $this::MAX_FAILS) {
            $this->progressionStatus = $this::EXCLUDED;
        } else {
            $this->progressionStatus = $this::GOOD_STANDING;
        }
    }

    /**
     * Function sets the number of semesters remaining for a student.
     * If student has no failed units: Divide remaining CP required by student's enrolment type value.
     * Else student has failed a unit: Add remaining CP to failedUnitsCP, then divide by student's enrolment type value.
     *
     * TODO: Remember to convert asp's implementation to this much simpler version as well.
     */
    private final function setSemRemaining() {
        if($this->failedUnitsTally == 0) {
            $this->semRemaining = $this->cpDelta / $this->studentDetailsArray[Student::ET];
        } else {
            $this->semRemaining = ($this->cpDelta + $this->failedUnitsCP) / $this->studentDetailsArray[Student::ET];
        }
    }

    /**
     * Function implements business rule:
     * If a student does more than one unit in a given semester,
     * and fails only one unit with a mark in the range of 45-49,
     * and is in the first or last semester of their course,
     * then the grade for that unit should read "S?" for possible
     * supplementary assessment.
     *
     * !! ASSUMPTIONS/LIMITATIONS !!
     * 1. Only considers 15 CP per unit, not 20
     * 2. User input must be in correct order according to semester!
     *
     * TODO:    Managed to reduce conditional code for fulltime/parttime
     * TODO:    students by pre-calculating the lastSemStart and unitsPerSem.
     * TODO:    Remember to update asp with this change.
     */
    private final function setSupUnit() {

        // assuming user will enter their first sem FIRST!
        $firstSem = $this->unitDetailsArray[0][Units::YS];
        $lastSemStart = 0;
        $lastSem = "";

        $fullTimeUnits = 4;
        $partTimeUnits = 2;
        $unitsPerSem = 0;

        $firstSemFails = 0;
        $lastSemFails = 0;

        $isSup = false;
        $isMultiFirstSem = false;
        $isMultiLastSem = false;

        // work out what the lastSem and unitsPerSem values will be
        // this saves conditional code for fulltime/parttime students
        if($this->studentDetailsArray[Student::ET] == BusinessRules::CP_FULLTIME) {
            $lastSemStart = ($this->semTotal * $fullTimeUnits) - $fullTimeUnits;
            $unitsPerSem = $fullTimeUnits;
        } else {
            $lastSemStart = ($this->semTotal * $partTimeUnits) - $partTimeUnits;
            $unitsPerSem = $partTimeUnits;
        }

        /*************
         * FIRST SEM *
         *************/

        // if student has attempted a unit during first sem,
        if($this->unitAttemptTotal > 0) {
            // first loop sets the flags used for testing
            for($i = 0; $i < $unitsPerSem; $i++) {
                // test for more than one units attempted during first semester
                if($firstSem == $this->unitDetailsArray[$i][Units::YS]) {
                    $isMultiFirstSem = true;
                }
                // test for more than one fails during first semester
                if($this->unitDetailsArray[$i][Units::UM] < $this::MARK_PASS) {
                    $firstSemFails++;
                }
            }
            // second loop uses flags to determine if eligible for "S?" grade
            for($i = 0; $i < $unitsPerSem; $i++) {
                if($isMultiFirstSem && $firstSemFails < 2 &&
                        $this->unitDetailsArray[$i][Units::UM] >= $this::MARK_SUP_MIN &&
                        $this->unitDetailsArray[$i][Units::UM] <= $this::MARK_SUP_MAX) {
                    $this->unitDetailsArray[$i][Units::GR] = "S?";
                    $isSup = true;
                }
            }
        }

        /************
         * LAST SEM *
         ************/

        // if student has attempted a unit during last sem,
        if($this->unitAttemptTotal >= $lastSemStart) {
            // set the last sem as the last input from the user
            $lastSem = $this->unitDetailsArray[$this->unitAttemptTotal - 1][Units::YS];
            // first loop sets the flags used for testing
            for($i = $lastSemStart + 1; $i < Units::$filledRows; $i++) {
                // test for more than one units attempted during last semester
                if($lastSem == $this->unitDetailsArray[$i - 1][Units::YS]) {
                    $isMultiLastSem = true;
                }
                // test for more than one fails during last semester
                if($this->unitDetailsArray[$i][Units::UM] < $this::MARK_PASS) {
                    $lastSemFails++;
                }
            }
            // second loop uses flags to determine if eligible for "S?" grade
            for($i = $lastSemStart; $i < Units::$filledRows; $i++) {
                if($isMultiLastSem && $lastSemFails < 2 &&
                        $this->unitDetailsArray[$i][Units::UM] >= $this::MARK_SUP_MIN &&
                        $this->unitDetailsArray[$i][Units::UM] <= $this::MARK_SUP_MAX) {
                    $this->unitDetailsArray[$i][Units::GR] = "S?";
                    $isSup = true;
                }
            }
        }

        /*************************
         * POST S? DETERMINATION *
         *************************/

        // if same unit has x3 fails, but are supp, then student is still in good standing
        if($isSup && $this->progressionStatus = $this::EXCLUDED) {
            $this->progressionStatus = $this::GOOD_STANDING_SUP;
        }
    }

    /**
     * Function determines the grade of a mark.
     *
     * @param int $mark - The mark to grade.
     * @return string - The grade.
     */
    public function getGrade($mark) {

        $grade = "";

        switch($mark) {
            case $mark >= 80:
                $grade = "HD";
                break;
            case $mark >= 70:
                $grade = "D";
                break;
            case $mark >= 60:
                $grade = "CR";
                break;
            case $mark >= 50:
                $grade = "C";
                break;
            case $mark >= 0:
                $grade = "N";
                break;
        }

        return $grade;
    }

    /**
     * This function imports the input arrays from the Student and Units class.
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