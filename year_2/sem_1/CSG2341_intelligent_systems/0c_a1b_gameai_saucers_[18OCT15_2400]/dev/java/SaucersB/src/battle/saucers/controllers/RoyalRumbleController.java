package battle.saucers.controllers;

import au.edu.ecu.is.fuzzy.FuzzyException;
import au.edu.ecu.is.fuzzy.FuzzySet;
import au.edu.ecu.is.fuzzy.FuzzyVariable;
import au.edu.ecu.is.fuzzy.SugenoRuleSet;
import battle.Constants;
import battle.sensors.SensorData;

import java.awt.*;
import java.util.ArrayList;

/**
 * RoyalRumble fuzzy controller.
 *
 * @author Martin Ponce, 10371381
 * @version 20150911
 */
public class RoyalRumbleController implements SaucerController, Constants {

    // saucer config
    private static final String NAME = "royalRumble";
    private static final Color BASE = Color.yellow;
    private static final Color ARROW = Color.black;
    private static final double FIRE_PROB = 0.01;
    private static boolean isLastTarget;
    private static boolean isLastTwoTargets;
    private static boolean isPowerUpNear;

    private SensorData nearestTarget;
    private SensorData nearestBlast;
    private SensorData nearestPowerUp;

    // linguistic input variables

    // me
    private double energy;
    private FuzzyVariable myEnergy;
    private FuzzySet[] myEnergySets = new FuzzySet[2];

    // target
    private FuzzyVariable targetDist;
    private FuzzyVariable targetAspect;
    private FuzzyVariable targetAngleOff;
    private FuzzyVariable targetEnergyDiff;

    // target sets
    private FuzzySet[] targetDistSets = new FuzzySet[3];
    private FuzzySet[] targetAspectSets = new FuzzySet[9];
    private FuzzySet[] targetAngleOffSets = new FuzzySet[9];
    private FuzzySet[] targetEnergyDiffSets = new FuzzySet[2];

    // blast
    private FuzzyVariable blastDist;
    private FuzzyVariable blastAspect;
    private FuzzyVariable blastAngleOff;

    // blast sets
    private FuzzySet[] blastDistSets = new FuzzySet[2];
    private FuzzySet[] blastAspectSets = new FuzzySet[9];
    private FuzzySet[] blastAngleOffSets = new FuzzySet[9];

    // powerup
    private FuzzyVariable powerUpDist;
    private FuzzyVariable powerUpAspect;

    // powerup sets
    private FuzzySet[] powerUpDistSets = new FuzzySet[3];
    private FuzzySet[] powerUpAspectSets = new FuzzySet[9];

    // linguistic output variables
    private FuzzyVariable defensiveTurn;
    private FuzzyVariable offensiveTurn;
    private FuzzyVariable getPowerUpTurn;
    private FuzzyVariable defensiveSpeed;
    private FuzzyVariable offensiveSpeed;
    private FuzzyVariable firePower;
    // this needs to be boolean
    private FuzzyVariable shield;

    // the rules
    private SugenoRuleSet rules;

    // constant cardinal dir
    private final double LEFT_TWELVE = 360.0;
    private final double LEFT_THREE = 270.0;
    private final double LEFT_SIX = 180.0;
    private final double LEFT_NINE = 90.0;
    private final double TWELVE = 0.0;
    private final double RIGHT_THREE = -90.0;
    private final double RIGHT_SIX = -180.0;
    private final double RIGHT_NINE = -270.0;
    private final double RIGHT_TWELVE = -360.0;

    // aspect fuzzy sets
    private FuzzySet rightTwelve;
    private FuzzySet rightNine;
    private FuzzySet rightSix;
    private FuzzySet rightThree;
    private FuzzySet twelve;
    private FuzzySet leftNine;
    private FuzzySet leftSix;
    private FuzzySet leftThree;
    private FuzzySet leftTwelve;

    // angle-off fuzzy sets
    private FuzzySet rightZero;
    private FuzzySet right270;
    private FuzzySet rightMerge;
    private FuzzySet right90;
    private FuzzySet zero;
    private FuzzySet left90;
    private FuzzySet leftMerge;
    private FuzzySet left270;
    private FuzzySet leftZero;

    private double maxDistance = Math.sqrt(
            STARFIELD_WIDTH * STARFIELD_WIDTH +
            STARFIELD_HEIGHT * STARFIELD_HEIGHT
    );

    double[][][] blastDodge = {

            // x = blast aspect
            // y = blast angle-off
            // z = blast distance

            // close
            {
                    // right twelve,    right nine,     right six,      right three,    twelve,         left nine,      left six,       left three,     left twelve
                    {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         RIGHT_THREE,      TWELVE,         TWELVE},        // right zero
                    {RIGHT_THREE,       TWELVE,         RIGHT_THREE,    LEFT_SIX,       LEFT_NINE,      TWELVE,         RIGHT_THREE,      LEFT_SIX,       LEFT_NINE},     // right 270
                    {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         RIGHT_THREE,      TWELVE,         TWELVE},        // right merge
                    {RIGHT_THREE,       RIGHT_SIX,      RIGHT_THREE,    TWELVE,         RIGHT_THREE,    RIGHT_SIX,      RIGHT_THREE,      TWELVE,         LEFT_NINE},     // right 90
                    {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         RIGHT_THREE,      TWELVE,         TWELVE},        // zero
                    {RIGHT_THREE,       TWELVE,         RIGHT_THREE,    LEFT_SIX,       LEFT_NINE,      TWELVE,         RIGHT_THREE,      LEFT_SIX,       LEFT_NINE},     // left 90
                    {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         RIGHT_THREE,      TWELVE,         TWELVE},        // left merge
                    {RIGHT_THREE,       RIGHT_SIX,      RIGHT_THREE,    TWELVE,         RIGHT_THREE,    RIGHT_SIX,      RIGHT_THREE,      TWELVE,         LEFT_NINE},     // left 270
                    {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         RIGHT_THREE,      TWELVE,         TWELVE}         // left zero
            },
            // far
            {
                    // right twelve,    right nine,     right six,      right three,    twelve,         left nine,      left six,       left three,     left twelve
                    {RIGHT_SIX,         TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         LEFT_SIX}, // right zero
                    {TWELVE,            TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE}, // right 270
                    {TWELVE,            TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE}, // right merge
                    {TWELVE,            TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE}, // right 90
                    {RIGHT_SIX,         TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         LEFT_SIX}, // zero
                    {TWELVE,            TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE}, // left 90
                    {TWELVE,            TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE}, // left merge
                    {TWELVE,            TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE}, // left 270
                    {RIGHT_SIX,         TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         LEFT_SIX} // left zero
            }
    };

    /**
     * Constructor.
     */
    public RoyalRumbleController() throws FuzzyException {

        // fuzzy variables, rules here
        rules = new SugenoRuleSet();

        this.energy = SAUCER_START_ENERGY;
        isLastTarget = false;
        isPowerUpNear = false;

        // aspect
        rightTwelve = new FuzzySet("right twelve", RIGHT_TWELVE, RIGHT_TWELVE, RIGHT_TWELVE, RIGHT_NINE);
        rightNine = new FuzzySet("right nine", RIGHT_TWELVE, RIGHT_NINE, RIGHT_NINE, RIGHT_SIX);
        rightSix = new FuzzySet("right six", RIGHT_NINE, RIGHT_SIX, RIGHT_SIX, RIGHT_THREE);
        rightThree = new FuzzySet("right three", RIGHT_SIX, RIGHT_THREE, RIGHT_THREE, TWELVE);
        twelve = new FuzzySet("twelve", RIGHT_THREE, TWELVE, TWELVE, LEFT_NINE);
        leftNine = new FuzzySet("left nine", TWELVE, LEFT_NINE, LEFT_NINE, LEFT_SIX);
        leftSix = new FuzzySet("left six", LEFT_NINE, LEFT_SIX, LEFT_SIX, LEFT_THREE);
        leftThree = new FuzzySet("left three", LEFT_SIX, LEFT_THREE, LEFT_THREE, LEFT_TWELVE);
        leftTwelve = new FuzzySet("left twelve", LEFT_THREE, LEFT_TWELVE, LEFT_TWELVE, LEFT_TWELVE);

        // angle-off
        rightZero = new FuzzySet("right zero", RIGHT_TWELVE, RIGHT_TWELVE, RIGHT_TWELVE, RIGHT_NINE);
        right270 = new FuzzySet("right 270", RIGHT_TWELVE, RIGHT_NINE, RIGHT_NINE, RIGHT_SIX);
        rightMerge = new FuzzySet("right merge", RIGHT_NINE, RIGHT_SIX, RIGHT_SIX, RIGHT_THREE);
        right90 = new FuzzySet("right 90", RIGHT_SIX, RIGHT_THREE, RIGHT_THREE, TWELVE);
        zero = new FuzzySet("zero", RIGHT_THREE, TWELVE, TWELVE, LEFT_NINE);
        left90 = new FuzzySet("left 90", TWELVE, LEFT_NINE, LEFT_NINE, LEFT_SIX);
        leftMerge = new FuzzySet("left merge", LEFT_NINE, LEFT_SIX, LEFT_SIX, LEFT_THREE);
        left270 = new FuzzySet("left 270", LEFT_SIX, LEFT_THREE, LEFT_THREE, LEFT_TWELVE);
        leftZero = new FuzzySet("left zero", LEFT_THREE, LEFT_TWELVE, LEFT_TWELVE, LEFT_TWELVE);

        // setup inputs
        setupMyEnergy();
        setupTarget();
        setupBlast();
        setupPowerUp();

        // setup outputs
        setupDefensiveTurn();
        setupOffensiveTurn();
        setupGetPowerUpTurn();
        setupDefensiveSpeed();
        setupOffensiveSpeed();
        setupFirePower();
        setupShield();
    }

    /*********
     * INPUT *
     *********/

    private void setupMyEnergy() throws FuzzyException {
        final double maxEnergy = SAUCER_START_ENERGY;
        final double mid = maxEnergy * 0.5;

        myEnergy = new FuzzyVariable("my energy", "j", 0.0, maxEnergy, 2);

        FuzzySet lowEnergy = new FuzzySet("low energy", 0.0, 0.0, mid - maxEnergy * 0.05, mid + maxEnergy * 0.05);
        FuzzySet highEnergy = new FuzzySet("high energy", mid - maxEnergy * 0.05, mid + maxEnergy * 0.05, maxEnergy, maxEnergy);

        myEnergy.add(lowEnergy);
        myEnergy.add(highEnergy);

        myEnergySets[0] = lowEnergy;
        myEnergySets[1] = highEnergy;

        myEnergy.checkGaps();

        // set default value
        myEnergy.setValue(SAUCER_START_ENERGY);
    }

    /**
     * This method sets up linguistic variables and fuzzy sets for target input.
     * @throws FuzzyException
     */
    private void setupTarget() throws FuzzyException {

        // distance
        final double distR1 = 0.05 * maxDistance;
        final double distR2 = 0.10 * maxDistance;
        final double distR3 = 0.15 * maxDistance;
        final double distR4 = 0.25 * maxDistance;

        targetDist = new FuzzyVariable("dist to target", "m", 0.0, maxDistance, 2);

        FuzzySet close = new FuzzySet("close", 0.0, 0.0, 0.0, distR2);
        FuzzySet near = new FuzzySet("near", distR1, distR3, distR3, distR4);
        FuzzySet far = new FuzzySet("far", distR3, distR4, maxDistance, maxDistance);

        targetDist.add(close);
        targetDist.add(near);
        targetDist.add(far);

        targetDistSets[0] = close;
        targetDistSets[1] = near;
        targetDistSets[2] = far;

        // aspect
        targetAspect = new FuzzyVariable("target aspect", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);
        targetAspect.add(rightTwelve);
        targetAspect.add(rightNine);
        targetAspect.add(rightSix);
        targetAspect.add(rightThree);
        targetAspect.add(twelve);
        targetAspect.add(leftNine);
        targetAspect.add(leftSix);
        targetAspect.add(leftThree);
        targetAspect.add(leftTwelve);

        targetAspectSets[0] = rightTwelve;
        targetAspectSets[1] = rightNine;
        targetAspectSets[2] = rightSix;
        targetAspectSets[3] = rightThree;
        targetAspectSets[4] = twelve;
        targetAspectSets[5] = leftNine;
        targetAspectSets[6] = leftSix;
        targetAspectSets[7] = leftThree;
        targetAspectSets[8] = leftTwelve;

        // angle-off
        targetAngleOff = new FuzzyVariable("target angle-off", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);
        targetAngleOff.add(rightZero);
        targetAngleOff.add(right270);
        targetAngleOff.add(rightMerge);
        targetAngleOff.add(right90);
        targetAngleOff.add(zero);
        targetAngleOff.add(left90);
        targetAngleOff.add(leftMerge);
        targetAngleOff.add(left270);
        targetAngleOff.add(leftZero);

        targetAngleOffSets[0] = rightZero;
        targetAngleOffSets[1] = right270;
        targetAngleOffSets[2] = rightMerge;
        targetAngleOffSets[3] = right90;
        targetAngleOffSets[4] = zero;
        targetAngleOffSets[5] = left90;
        targetAngleOffSets[6] = leftMerge;
        targetAngleOffSets[7] = left270;
        targetAngleOffSets[8] = leftZero;

        // energy difference
        final double maxDiff = SAUCER_START_ENERGY;
        final double minDiff = -maxDiff;
        final double diffR1 = maxDiff * 0.02;

        targetEnergyDiff = new FuzzyVariable("target energy difference", "j", minDiff, maxDiff, 2);
        FuzzySet losing = new FuzzySet("losing", minDiff, minDiff, -diffR1, diffR1);
        FuzzySet winning = new FuzzySet("winning", -diffR1, diffR1, maxDiff, maxDiff);

        targetEnergyDiff.add(losing);
        targetEnergyDiff.add(winning);

        targetEnergyDiffSets[0] = losing;
        targetEnergyDiffSets[1] = winning;
    }

    /**
     * This method sets up linguistic variables and fuzzy sets for blast input.
     * @throws FuzzyException
     */
    private void setupBlast() throws FuzzyException {

        // distance
        final double ramp1 = 0.05 * maxDistance;
        final double ramp2 = 0.15 * maxDistance;

        blastDist = new FuzzyVariable("dist to blast", "m", 0.0, maxDistance, 2);

        FuzzySet close = new FuzzySet("close", 0.0, 0.0, ramp1, ramp2);
        FuzzySet far = new FuzzySet("far", ramp1, ramp2, maxDistance, maxDistance);

        blastDist.add(close);
        blastDist.add(far);

        blastDist.checkGaps();

        blastDistSets[0] = close;
        blastDistSets[1] = far;

        // aspect
        blastAspect = new FuzzyVariable("blast aspect", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);
        blastAspect.add(rightTwelve);
        blastAspect.add(rightNine);
        blastAspect.add(rightSix);
        blastAspect.add(rightThree);
        blastAspect.add(twelve);
        blastAspect.add(leftNine);
        blastAspect.add(leftSix);
        blastAspect.add(leftThree);
        blastAspect.add(leftTwelve);

        blastAspectSets[0] = rightTwelve;
        blastAspectSets[1] = rightNine;
        blastAspectSets[2] = rightSix;
        blastAspectSets[3] = rightThree;
        blastAspectSets[4] = twelve;
        blastAspectSets[5] = leftNine;
        blastAspectSets[6] = leftSix;
        blastAspectSets[7] = leftThree;
        blastAspectSets[8] = leftTwelve;

        // set up angle-off
        blastAngleOff = new FuzzyVariable("blast angle-off", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);
        blastAngleOff.add(rightZero);
        blastAngleOff.add(right270);
        blastAngleOff.add(rightMerge);
        blastAngleOff.add(right90);
        blastAngleOff.add(zero);
        blastAngleOff.add(left90);
        blastAngleOff.add(leftMerge);
        blastAngleOff.add(left270);
        blastAngleOff.add(leftZero);

        blastAngleOffSets[0] = rightZero;
        blastAngleOffSets[1] = right270;
        blastAngleOffSets[2] = rightMerge;
        blastAngleOffSets[3] = right90;
        blastAngleOffSets[4] = zero;
        blastAngleOffSets[5] = left90;
        blastAngleOffSets[6] = leftMerge;
        blastAngleOffSets[7] = left270;
        blastAngleOffSets[8] = leftZero;

        // set default value since there aren't any blasts yet
        blastDist.setValue(maxDistance);
        blastAspect.setValue(TWELVE);
        blastAngleOff.setValue(TWELVE);
    }

    /**
     * This method sets up linguistic variables and fuzzy sets for powerup input.
     * @throws FuzzyException
     */
    private void setupPowerUp() throws FuzzyException {

        // distance
        final double ramp1 = 0.05 * maxDistance;
        final double ramp2 = 0.10 * maxDistance;
        final double ramp3 = 0.15 * maxDistance;
        final double ramp4 = 0.25 * maxDistance;

        powerUpDist = new FuzzyVariable("dist to powerup", "m", 0.0, maxDistance, 2);

        FuzzySet close = new FuzzySet("close", 0.0, 0.0, 0.0, ramp2);
        FuzzySet near = new FuzzySet("near", ramp1, ramp3, ramp3, ramp4);
        FuzzySet far = new FuzzySet("far", ramp3, ramp4, maxDistance, maxDistance);

        powerUpDist.add(close);
        powerUpDist.add(near);
        powerUpDist.add(far);

        powerUpDist.checkGaps();

        powerUpDistSets[0] = close;
        powerUpDistSets[1] = near;
        powerUpDistSets[2] = far;

        // aspect
        powerUpAspect = new FuzzyVariable("powerup aspect", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);
        powerUpAspect.add(rightTwelve);
        powerUpAspect.add(rightNine);
        powerUpAspect.add(rightSix);
        powerUpAspect.add(rightThree);
        powerUpAspect.add(twelve);
        powerUpAspect.add(leftNine);
        powerUpAspect.add(leftSix);
        powerUpAspect.add(leftThree);
        powerUpAspect.add(leftTwelve);

        powerUpAspectSets[0] = rightTwelve;
        powerUpAspectSets[1] = rightNine;
        powerUpAspectSets[2] = rightSix;
        powerUpAspectSets[3] = rightThree;
        powerUpAspectSets[4] = twelve;
        powerUpAspectSets[5] = leftNine;
        powerUpAspectSets[6] = leftSix;
        powerUpAspectSets[7] = leftThree;
        powerUpAspectSets[8] = leftTwelve;

        // set default value while there isn't any power ups yet
        powerUpDist.setValue(maxDistance);
        powerUpAspect.setValue(TWELVE);
    }

    /**********
     * OUTPUT *
     **********/

    /**
     * This method sets up defensiveTurn output rules.
     * @throws FuzzyException
     */
    private void setupDefensiveTurn() throws FuzzyException {

        defensiveTurn = new FuzzyVariable("defensive turn", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);

        /***************
         * DODGE BLAST *
         ***************/

        // see blastDodge
        rules.add3DRuleMatrix(
                blastDist, blastDistSets,
                blastAngleOff, blastAngleOffSets,
                blastAspect, blastAspectSets,
                defensiveTurn, blastDodge
        );
        rules.display3DRuleMatrix(
                blastDist, blastDistSets,
                blastAngleOff, blastAngleOffSets,
                blastAspect, blastAspectSets,
                defensiveTurn
        );
    }

    private void setupOffensiveTurn() throws FuzzyException {
        offensiveTurn = new FuzzyVariable("offensive turn", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);

        double[][][] turnTarget = {
                // x = target aspect
                // y = target energy difference
                // z = target distance

                // close
                {
                        // right twelve,    right nine,     right six,      right three,    twelve,         left nine,      left six,   left three,     left twelve
                        {LEFT_SIX,          RIGHT_THREE,    TWELVE,         LEFT_NINE,      RIGHT_SIX,      RIGHT_THREE,    TWELVE,     LEFT_NINE,      RIGHT_SIX},   // losing
                        {TWELVE,            LEFT_NINE,      RIGHT_SIX,      RIGHT_THREE,    TWELVE,         LEFT_NINE,      LEFT_SIX,   RIGHT_THREE,    TWELVE}       // winning
                },
                // near
                {
                        // right twelve,    right nine,     right six,      right three,    twelve,         left nine,      left six,   left three,     left twelve
                        {LEFT_SIX,          TWELVE,         TWELVE,         TWELVE,         RIGHT_SIX,      TWELVE,         TWELVE,     TWELVE,         RIGHT_SIX},   // losing
                        {TWELVE,            LEFT_NINE,      RIGHT_SIX,      RIGHT_THREE,    TWELVE,         LEFT_NINE,      LEFT_SIX,   RIGHT_THREE,    TWELVE}       // winning
                },
                // far
                {
                        // right twelve,    right nine,     right six,      right three,    twelve,         left nine,      left six,   left three,     left twelve
                        {TWELVE,            TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,     TWELVE,         TWELVE},   // losing
                        {TWELVE,            LEFT_NINE,      RIGHT_SIX,      RIGHT_THREE,    TWELVE,         LEFT_NINE,      LEFT_SIX,   RIGHT_THREE,    TWELVE}       // winning
                }
        };

        rules.add3DRuleMatrix(
                targetDist, targetDistSets,
                targetEnergyDiff, targetEnergyDiffSets,
                targetAspect, targetAspectSets,
                offensiveTurn, turnTarget
        );

        rules.display3DRuleMatrix(
                targetDist, targetDistSets,
                targetEnergyDiff, targetEnergyDiffSets,
                targetAspect, targetAspectSets,
                offensiveTurn
        );

        // see blastDodge
        rules.add3DRuleMatrix(
                blastDist, blastDistSets,
                blastAngleOff, blastAngleOffSets,
                blastAspect, blastAspectSets,
                offensiveTurn, blastDodge
        );

        rules.display3DRuleMatrix(
                blastDist, blastDistSets,
                blastAngleOff, blastAngleOffSets,
                blastAspect, blastAspectSets,
                offensiveTurn
        );
    }

    private void setupGetPowerUpTurn() throws FuzzyException {
        getPowerUpTurn =  new FuzzyVariable("get powerup turn", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);

        double[][] headToPowerUp = {

                // x = powerup distance
                // y = powerup aspect

                // close,       near,           far
                {TWELVE,        TWELVE,         TWELVE},           // right twelve
                {LEFT_NINE,     LEFT_NINE,      TWELVE},     // right nine
                {RIGHT_SIX,     RIGHT_SIX,      TWELVE},     // right six
                {RIGHT_THREE,   RIGHT_THREE,    TWELVE}, // right three
                {TWELVE,        TWELVE,         TWELVE},           // twelve
                {LEFT_NINE,     LEFT_NINE,      TWELVE},     // left nine
                {LEFT_SIX,      LEFT_SIX,       TWELVE},       // left six
                {RIGHT_THREE,   RIGHT_THREE,    TWELVE},   // left three
                {TWELVE,        TWELVE,         TWELVE}            // left twelve
        };

        rules.addRuleMatrix(
                powerUpAspect, powerUpAspectSets,
                powerUpDist, powerUpDistSets,
                getPowerUpTurn, headToPowerUp
        );
    }

    /**
     * This method sets up defensiveSpeed output rules.
     * @throws FuzzyException
     */
    private void setupDefensiveSpeed() throws FuzzyException {

        final double midSpeed = 75.0;

        defensiveSpeed = new FuzzyVariable("defensive speed", "", SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, 2);

        /***************
         * DODGE BLAST *
         ***************/

        double[][][] dodgeSpeed = {

                // x = aspect
                // y = angle-off
                // z = distance

                // close
                {
                        // right twelve,   right nine,       right six,        right three,      twelve,           left nine,        left six,         left three,       left twelve
                        {SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED}, // right zero
                        {SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED}, // right 270
                        {SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED}, // right merge
                        {SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED}, // right 90
                        {SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED}, // zero
                        {SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED}, // left 90
                        {SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED}, // left merge
                        {SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED}, // left 270
                        {SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED}  // left zero
                },

                // far
                {
                        // right twelve,   right nine,       right six,        right three,      twelve,           left nine,        left six,         left three,       left twelve
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // right zero
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED}, // right 270
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // right merge
                        {SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // right 90
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // zero
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED}, // left 90
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // left merge
                        {SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // left 270
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}  // left zero
                },

        };

        rules.add3DRuleMatrix(
                blastDist, blastDistSets,
                blastAngleOff, blastAngleOffSets,
                blastAspect, blastAspectSets,
                defensiveSpeed, dodgeSpeed
        );

        /***************
         * GET POWERUP *
         ***************/

        // if close then mid defensiveSpeed
        rules.addRule(powerUpDist, powerUpDistSets[0], defensiveSpeed, SAUCER_MAX_SPEED);
        // if near then max defensiveSpeed
        rules.addRule(powerUpDist, powerUpDistSets[1], defensiveSpeed, SAUCER_MAX_SPEED);
        // if far then min defensiveSpeed
        rules.addRule(powerUpDist, powerUpDistSets[2], defensiveSpeed, SAUCER_MIN_SPEED);
    }

    private void setupOffensiveSpeed() throws FuzzyException {
        final double midSpeed = 75.0;
        offensiveSpeed = new FuzzyVariable("offensive speed", "", SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, 2);

        double[][] chaseSpeed = {

                // x = target energy difference
                // y = target distance

                // losing, winning
                {SAUCER_MAX_SPEED, SAUCER_MIN_SPEED}, // close
                {midSpeed, midSpeed}, // near
                {SAUCER_MIN_SPEED, SAUCER_MAX_SPEED} // far
        };

        rules.addRuleMatrix(
                targetDist, targetDistSets,
                targetEnergyDiff, targetEnergyDiffSets,
                offensiveSpeed, chaseSpeed
        );

        double[][][] dodgeSpeed = {

                // x = aspect
                // y = angle-off
                // z = distance

                // close
                {
                        // right twelve,   right nine,       right six,        right three,      twelve,           left nine,        left six,         left three,       left twelve
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // right zero
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED}, // right 270
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // right merge
                        {SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // right 90
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // zero
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED}, // left 90
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // left merge
                        {SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // left 270
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}  // left zero
                },

                // far
                {
                        // right twelve,   right nine,       right six,        right three,      twelve,           left nine,        left six,         left three,       left twelve
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // right zero
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED}, // right 270
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // right merge
                        {SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // right 90
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // zero
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED}, // left 90
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // left merge
                        {SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}, // left 270
                        {SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, SAUCER_MIN_SPEED, midSpeed,         SAUCER_MIN_SPEED, SAUCER_MIN_SPEED}  // left zero
                },

        };

        rules.add3DRuleMatrix(
                blastDist, blastDistSets,
                blastAngleOff, blastAngleOffSets,
                blastAspect, blastAspectSets,
                offensiveSpeed, dodgeSpeed
        );

        // if close then mid defensiveSpeed
        rules.addRule(powerUpDist, powerUpDistSets[0], offensiveSpeed, SAUCER_MAX_SPEED);
        // if near then max defensiveSpeed
        rules.addRule(powerUpDist, powerUpDistSets[1], offensiveSpeed, SAUCER_MAX_SPEED);
        // if far then min defensiveSpeed
        rules.addRule(powerUpDist, powerUpDistSets[2], offensiveSpeed, SAUCER_MAX_SPEED);


    }

    /**
     * This method sets up firepower output rules.
     * @throws FuzzyException
     */
    private void setupFirePower() throws FuzzyException {

        firePower = new FuzzyVariable("firepower", "j", 0.0, SAUCER_MAX_POWER, 2);

        // if close then max power
        rules.addRule(targetDist, targetDistSets[0], firePower, SAUCER_MAX_POWER);
        // if near then max power
        rules.addRule(targetDist, targetDistSets[1], firePower, SAUCER_MAX_POWER);
        // if far then no power
        rules.addRule(targetDist, targetDistSets[2], firePower, 0.0);
    }

    /**
     * This method sets up shield output rules. MUST BE BOOLEAN!
     * @throws FuzzyException
     */
    private void setupShield() throws FuzzyException {

        final double maxShield = 1.0;

        shield = new FuzzyVariable("shield", "", 0.0, maxShield, 2);

        double[][][] shieldUp = {

                // x = blast distance
                // y = my energy
                // z = powerup distance

                // close
                {
                        // close, far
                        {maxShield, 0.0}, // low
                        {maxShield, 0.0}  // high
                },
                // near
                {
                        // close, far
                        {0.0, 0.0}, // low
                        {maxShield, 0.0} // high
                },
                // far
                {
                        // close, far
                        {0.0, 0.0}, // low
                        {0.0, 0.0} // high
                }

        };

        rules.add3DRuleMatrix(
                powerUpDist, powerUpDistSets,
                myEnergy, myEnergySets,
                blastDist, blastDistSets,
                shield, shieldUp
        );
    }

    /****************
     * SENSOR INPUT *
     ****************/

    @Override
    public void senseSaucers(ArrayList<SensorData> data) throws Exception {

        isLastTarget = false;
        isLastTwoTargets = false;

        // get nearest enemy
        if(data.size() > 0) {
            double closest = data.get(0).distance;
            nearestTarget = data.get(0);

            for(SensorData thisData : data) {
                if(thisData.distance < closest) {
                    nearestTarget = thisData;
                    closest = thisData.distance;
                }
            }
            targetDist.setValue(nearestTarget.distance);
            targetAspect.setValue(nearestTarget.direction);
            targetAngleOff.setValue(nearestTarget.heading);
        } else {
            nearestTarget = null;
        }

        // be aggressive when there are 1-2 enemies left
        if(data.size() > 0 && data.size() < 3) {
            isLastTwoTargets = true;
        }
        if(data.size() > 0 && data.size() < 2) {
            targetEnergyDiff.setValue(energy - nearestTarget.energy);
            isLastTarget = true;
        } else {
            targetEnergyDiff.setValue(-SAUCER_START_ENERGY);
        }

        rules.update();
    }

    @Override
    public void sensePowerUps(ArrayList<SensorData> data) throws Exception {

        isPowerUpNear = false;

        boolean isPowerUp = data.size() > 0;

        // if any powerUp's exist, get nearest
        if(isPowerUp) {
            double closest = data.get(0).distance;
            nearestPowerUp = data.get(0);

            for(SensorData thisData : data) {
                if(thisData.distance < closest) {
                    nearestPowerUp = thisData;
                    closest = thisData.distance;
                }
            }
            powerUpDist.setValue(nearestPowerUp.distance);
            powerUpAspect.setValue(nearestPowerUp.direction);

            if(nearestPowerUp.distance < maxDistance * 0.25) {
                isPowerUpNear = true;
            }
        } else {
            powerUpDist.setValue(maxDistance);
            powerUpAspect.setValue(TWELVE);
        }
        rules.update();
    }

    @Override
    public void senseBlasts(ArrayList<SensorData> data) throws Exception {
        // get nearest blast
        if(data.size() > 0) {
            double closest = data.get(0).distance;
            nearestBlast = data.get(0);

            for(SensorData thisData : data) {
                if(thisData.distance < closest) {
                    nearestBlast = thisData;
                    closest = thisData.distance;
                }
            }
            blastDist.setValue(nearestBlast.distance);
            blastAspect.setValue(nearestBlast.direction);
            blastAngleOff.setValue(nearestBlast.heading);
        } else {
            nearestBlast = null;
        }
        rules.update();
    }

    @Override
    public void senseEnergy(double energy) throws Exception {
        myEnergy.setValue(energy);
        this.energy = energy;
        rules.update();
    }

    @Override
    public SensorData getTarget() throws Exception {
        return nearestTarget;
    }

    @Override
    public double getFirePower() throws Exception {

        if(isLastTarget || isPowerUpNear) {
            return firePower.getValue();
        } else if(isLastTwoTargets) {
            if(Math.random() < 0.05) {
                return firePower.getValue();
            } else {
                return 0.0;
            }
        } else {
            if(Math.random() < FIRE_PROB) {
                return firePower.getValue();
            } else {
                return 0.0;
            }
        }
    }

    @Override
    public double getSpeed() throws Exception {
        if(isLastTarget) {
            return offensiveSpeed.getValue();
        } else  {
            return defensiveSpeed.getValue();
        }
    }

    @Override
    public double getTurn() throws Exception {

        if(isPowerUpNear) {
            return getPowerUpTurn.getValue();
        }

        if(isLastTarget || isLastTwoTargets) {
            return offensiveTurn.getValue();
        } else {
            return defensiveTurn.getValue();
        }
    }

    @Override
    public boolean getShields() throws Exception {
        if(isPowerUpNear) {
            return shield.getValue() > 0.5;
        } else {
            return false;
        }
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public Color getBaseColor() {
        return BASE;
    }

    @Override
    public Color getTurretColor() {
        return ARROW;
    }
}
