<?php

namespace includes;

/**
 * Class BusinessRules contains all the business related logic to
 * calculate the summary of a student's course progress.
 *
 * @author Martin Ponce, 10371381
 * @version 20150906
 * @package includes
 */
class BusinessRules {

    // import the controller
    private $theValidator;

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

    /**
     * The BusinessRules constructor.
     */
    function __construct() {

        // init variables with defaults
        $this->passedCPTotal = 0;
        $this->cpDelta = 0;

        $this->unitAttemptTotal = 0;
        $this->unitsPassed = 0;
        $this->semRemaining = 0;
        $this->semTotal = 0;

        $this->markTotal = 0;
        $this->markAverage = 0;
        $this->gradeAverage = "";

        $this->progressionStatus = "";
        $this->isComplete = false;

        $this->failedUnitsTally = 0;
        $this->failedUnitsCP = 0;
        $this->matchedFailedTally = 0;
    }

    /**
     * This function sets the controller.
     * Can't do it at construction because chicken or the egg problem.
     *
     * @param Validator $theValidator - The controller.
     */
    public function setController(Validator $theValidator) {
        $this->theValidator = $theValidator;
    }

    /**
     * This function initiates the calculation of a student's summary.
     */
    public final function calculateSummary() {

        // call all the things
        $this->setSemTotal();
        $this->iterateUnitDetails();
        $this->setCPDelta();
        $this->setIsComplete();
        $this->setMarkAverage();
        $this->setProgressionStatus();
        $this->setSemRemaining();
        $this->setSupUnit();
    }

    /**
     * This function iterates through the unitDetails array,
     * and performs calculations at each iteration.
     * Some called functions may also perform their own iteration.
     */
    private final function iterateUnitDetails() {

        for($i = 0; $i < sizeof($this->theValidator->getUnitDetails()); $i++) {

            $this->incrementUnitAttemptTotal();

            // set the grade for this mark
            $this->theValidator->setUnitGrade($i, $this->getGrade($this->theValidator->getUnitDetails()[$i][Units::UM]));

            // then store the highest mark found in theUnits->highestMark array
            if($this->theValidator->getUnitDetails()[$i][Units::UM] > $this->theValidator->getHighestMark()[Units::UM]) {
                $this->theValidator->setHighestMark(
                    $this->theValidator->getUnitDetails()[$i][Units::UC],
                    $this->theValidator->getUnitDetails()[$i][Units::CP],
                    $this->theValidator->getUnitDetails()[$i][Units::YS],
                    $this->theValidator->getUnitDetails()[$i][Units::UM],
                    $this->theValidator->getUnitDetails()[$i][Units::GR]
                );
            }

            // if student passed unit
            if($this->theValidator->getUnitDetails()[$i][Units::UM] >= $this::MARK_PASS) {
                $this->setPassedCPTotal($i);
                $this->incrementUnitsPassed();
                $this->setMarkTotal($i);

            } else {
                $this->calculateProgression($i);
            }
        }
    }

    /**
     * This function increments unitAttemptTotal.
     */
    private final function incrementUnitAttemptTotal() {
        $this->unitAttemptTotal++;
    }

    /**
     * This function sums passedCPTotal from unitDetailsArray.
     * To be used inside for loop, @see iterateUnitDetails().
     *
     * @param int $index - The current array index.
     */
    private final function setPassedCPTotal($index) {
        $this->passedCPTotal += $this->theValidator->getUnitDetails()[$index][Units::CP];
    }

    /**
     * This function increments unitsPassed.
     */
    private final function incrementUnitsPassed() {
        $this->unitsPassed++;
    }

    /**
     * This function sums markTotal from unitDetailsArray.
     * To be used inside for loop, @see iterateUnitDetails().
     *
     * @param int $index - The current array index.
     */
    private final function setMarkTotal($index) {
        $this->markTotal += $this->theValidator->getUnitDetails()[$index][Units::UM];
    }

    /**
     * This function calculates student's progression.
     * To be used inside for loop, @see iterateUnitDetails().
     *
     * @param int $index - The current array index.
     */
    private final function calculateProgression($index) {

        $currentUnitCode = $this->theValidator->getUnitDetails()[$index][Units::UC];
        $this->failedUnitsTally++;

        // loop from current index + 1 to remaining entries
        for($i = $index + 1; $i < sizeof($this->theValidator->getUnitDetails()); $i++) {
            // if unitcodes match and unit is failed,
            if ($currentUnitCode == $this->theValidator->getUnitDetails()[$i][Units::UC] &&
                $this->theValidator->getUnitDetails()[$index][Units::UM] < $this::MARK_PASS
            ) {
                // increment matchFailedTally
                $this->matchedFailedTally++;

            }
        }
    }

    /**
     * This function sets the total number of semesters a student requires to complete for their course.
     * Student course type / Student enrolment type.
     */
    private final function setSemTotal() {
        $this->semTotal = $this->theValidator->getStudentDetails()[Student::CT] / $this->theValidator->getStudentDetails()[Student::ET];
    }

    /**
     * This function sets the required credit points to complete course.
     * Already stored course type value in studentDetails array,
     * so just subtract passedCPTotal from it.
     *
     * TODO: If there's time, remember to convert asp's implementation to this much simpler version as well.
     */
    private final function setCPDelta() {
        // limit cpDelta to >= 0, to avoid showing negative int when student has passed more than required units for their course
        // also implies semRemaining >= 0
        $this->cpDelta = max(0, $this->theValidator->getStudentDetails()[Student::CT] - $this->passedCPTotal);
    }

    /**
     * This function sets isComplete, the complete status for a student.
     * If passedCPTotal >= student's course type, then isComplete = true.
     *
     * TODO: If there's time, remember to convert asp's implementation to this much simpler version as well.
     */
    private final function setIsComplete() {
        if($this->passedCPTotal >= $this->theValidator->getStudentDetails()[Student::CT]) {
            $this->isComplete = true;
        } else {
            $this->isComplete = false;
        }
    }

    /**
     * This function calculates average mark over total units attempted.
     * Also sets the grade for the average.
     */
    private final function setMarkAverage() {
        $this->markAverage = $this->markTotal / $this->unitAttemptTotal;
        // go set the grade too
        $this->gradeAverage = $this->getGrade($this->markAverage);
    }

    /**
     * This function sets the progression status.
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
     * This function sets the number of semesters remaining for a student.
     * If student has no failed units: Divide remaining CP required by student's enrolment type value.
     * Else student has failed a unit: Add remaining CP to failedUnitsCP, then divide by student's enrolment type value.
     *
     * TODO: If there's time, remember to convert asp's implementation to this much simpler version as well.
     */
    private final function setSemRemaining() {
        if($this->failedUnitsTally == 0) {
            $this->semRemaining = $this->cpDelta / $this->theValidator->getStudentDetails()[Student::ET];
        } else {
            $this->semRemaining = ($this->cpDelta + $this->failedUnitsCP) / $this->theValidator->getStudentDetails()[Student::ET];
        }
    }

    /**
     * This function implements business rule:
     * If a student does more than one unit in a given semester,
     * and fails only one unit with a mark in the range of 45-49,
     * and is in the first or last semester of their course,
     * then the grade for that unit should read "S?" for possible
     * supplementary assessment.
     *
     * !! ASSUMPTIONS/LIMITATIONS !!
     * 1. Only considers 15 CP per unit, not 20
     * 2. User input must be in correct order according to semester!
     * 3. @see *POST S? DETERMINATION*, in function below.
     *
     * TODO:    Managed to reduce conditional code for fulltime/parttime
     * TODO:    students by pre-calculating the lastSemStart and unitsPerSem.
     * TODO:    If there's time, remember to update asp with this implementation.
     */
    private final function setSupUnit() {

        // assuming user will enter their first sem FIRST!
        $firstSem = $this->theValidator->getUnitDetails()[0][Units::YS];
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
        if($this->theValidator->getStudentDetails()[Student::ET] == BusinessRules::CP_FULLTIME) {
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
                if($firstSem == $this->theValidator->getUnitDetails()[$i][Units::YS]) {
                    $isMultiFirstSem = true;
                }
                // test for more than one fails during first semester
                if($this->theValidator->getUnitDetails()[$i][Units::UM] < $this::MARK_PASS) {
                    $firstSemFails++;
                }
            }
            // second loop uses flags to determine if eligible for "S?" grade
            for($i = 0; $i < $unitsPerSem; $i++) {
                if($isMultiFirstSem && $firstSemFails < 2 &&
                        $this->theValidator->getUnitDetails()[$i][Units::UM] >= $this::MARK_SUP_MIN &&
                        $this->theValidator->getUnitDetails()[$i][Units::UM] <= $this::MARK_SUP_MAX) {

                    $this->theValidator->setUnitGrade($i, "S?");
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
            $lastSem = $this->theValidator->getUnitDetails()[$this->unitAttemptTotal - 1][Units::YS];
            // first loop sets the flags used for testing
            for($i = $lastSemStart + 1; $i < sizeof($this->theValidator->getUnitDetails()); $i++) {
                // test for more than one units attempted during last semester
                if($lastSem == $this->theValidator->getUnitDetails()[$i - 1][Units::YS]) {
                    $isMultiLastSem = true;
                }
                // test for more than one fails during last semester
                if($this->theValidator->getUnitDetails()[$i][Units::UM] < $this::MARK_PASS) {
                    $lastSemFails++;
                }
            }
            // second loop uses flags to determine if eligible for "S?" grade
            for($i = $lastSemStart; $i < sizeof($this->theValidator->getUnitDetails()); $i++) {
                if($isMultiLastSem && $lastSemFails < 2 &&
                        $this->theValidator->getUnitDetails()[$i][Units::UM] >= $this::MARK_SUP_MIN &&
                        $this->theValidator->getUnitDetails()[$i][Units::UM] <= $this::MARK_SUP_MAX) {

                    $this->theValidator->setUnitGrade($i, "S?");
                    $isSup = true;
                }
            }
        }

        /*************************
         * POST S? DETERMINATION *
         *************************/

        // problem with this if statement:
        // if student has S?, N, S? for one unit, and also fails a different unit three times during course,
        // the if statement below will negate exclusion.

        // if same unit has x3 fails, but have supp, then student is still in good standing
        if($isSup && $this->progressionStatus == $this::EXCLUDED) {
            $this->progressionStatus = $this::GOOD_STANDING_SUP;
        }
    }

    /**
     * This function determines the grade of a mark.
     *
     * @param int $mark - The mark to grade.
     * @return string - The grade.
     */
    public function getGrade($mark) {

        $grade = "";
        // make sure its int
        $test = (int) $mark;

        switch($test) {
            case $test < 50:
                $grade = "N";
                break;
            case $test < 60:
                $grade = "C";
                break;
            case $test < 70:
                $grade = "CR";
                break;
            case $test < 80:
                $grade = "D";
                break;
            case $test <= 100:
                $grade = "HD";
                break;
            default:
                $grade = "N";
        }

        return $grade;
    }

    /**
     * This function returns the student's progression status.
     *
     * @return string progressionStatus.
     */
    public function getProgressionStatus() {
        return $this->progressionStatus;
    }

    /**
     * This function returns the boolean isComplete.
     * Finished course == true,
     * Not finished course == false
     *
     * @return bool isComplete.
     */
    public function isComplete() {
        return $this->isComplete;
    }

    /**
     * This function returns passedCPTotal.
     *
     * @return int passedCPTotal.
     */
    public function getPassedCP() {
        return $this->passedCPTotal;
    }

    /**
     * This function returns cpDelta.
     *
     * @return int cpDelta.
     */
    public function getCPDelta() {
        return $this->cpDelta;
    }

    /**
     * This function returns unitAttemptTotal.
     *
     * @return int unitAttemptTotal.
     */
    public function getUnitsAttempted() {
        return $this->unitAttemptTotal;
    }

    /**
     * This function returns unitsPassed.
     *
     * @return int unitsPassed.
     */
    public function getUnitsPassed() {
        return $this->unitsPassed;
    }

    /**
     * This function returns semRemaining.
     *
     * @return int semRemaining.
     */
    public function getSemRemaining() {
        return $this->semRemaining;
    }

    /**
     * This function returns markAverage.
     *
     * @return int markAverage.
     */
    public function getMarkAverage() {
        return $this->markAverage;
    }

    /**
     * This function returns gradeAverage.
     *
     * @return String gradeAverage.
     */
    public function getGradeAverage() {
        return $this->gradeAverage;
    }
}

?>