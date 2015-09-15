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
    private static final String NAME = "RoyalRumble";
    private static final Color BASE = Color.yellow;
    private static final Color ARROW = Color.black;

    private SensorData nearestTarget;
    private SensorData nearestBlast;
    private SensorData nearestPowerUp;

//    private double myEnergy;
    private boolean isPowerUp;

    // linguistic input variables

    // me
    private FuzzyVariable myEnergy;
    private FuzzySet[] myEnergySets = new FuzzySet[3];

    // target
    private FuzzyVariable targetDist;
    private FuzzyVariable targetAspect;
    private FuzzyVariable targetAngleOff;
    private FuzzyVariable targetSpeed;
    private FuzzyVariable targetEnergy;

    // target sets
    private FuzzySet[] targetDistSets;
    private FuzzySet[] targetAspectSets;
    private FuzzySet[] targetAngleOffSets;
    private FuzzySet[] targetSpeedSets;

    // blast
    private FuzzyVariable blastDist;
    private FuzzyVariable blastAspect;
    private FuzzyVariable blastAngleOff;

    // blast sets
    private FuzzySet[] blastDistSets = new FuzzySet[3];
    private FuzzySet[] blastAspectSets = new FuzzySet[9];
    private FuzzySet[] blastAngleOffSets = new FuzzySet[9];

    // powerup
    private FuzzyVariable powerUpDist;
    private FuzzyVariable powerUpAspect;

    // powerup sets
    private FuzzySet[] powerUpDistSets;
    private FuzzySet[] powerUpAspectSets;

    // TODO: create sets

    // linguistic output variables
    private FuzzyVariable turn;
    private FuzzyVariable speed;
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

    private double maxDistance = Math.sqrt(
            STARFIELD_WIDTH * STARFIELD_WIDTH +
            STARFIELD_HEIGHT * STARFIELD_HEIGHT
    );

    /**
     * Constructor.
     */
    public RoyalRumbleController() throws FuzzyException {

        // fuzzy variables, rules here
        rules = new SugenoRuleSet();
        System.out.println(rules);

        // setup inputs
        setupMyEnergy();
        setupTarget();
        setupBlast();
        setupPowerUp();

        // setup outputs
        setupTurn();
        setupSpeed();
        setupFirePower();
        setupShield();
    }

    /*********
     * INPUT *
     *********/

    private void setupMyEnergy() throws FuzzyException {

        final double maxEnergy = SAUCER_START_ENERGY;

        final double ramp1 = maxEnergy * 0.70;
        final double ramp2 = maxEnergy * 0.725;
        final double ramp3 = maxEnergy * 0.75;
        final double ramp4 = maxEnergy * 0.80;
        final double ramp5 = maxEnergy * 0.85;
        final double ramp6 = maxEnergy * 0.875;
        final double ramp7 = maxEnergy * 0.90;

        myEnergy = new FuzzyVariable("my energy", "j", 0.0, maxEnergy, 2);

        FuzzySet lowEnergy = new FuzzySet("low energy", 0.0, 0.0, ramp1, ramp3);
        FuzzySet mediumEnergy = new FuzzySet("medium energy", ramp2, ramp4, ramp4, ramp6);
        FuzzySet highEnergy = new FuzzySet("high energy", ramp5, ramp7, maxEnergy, maxEnergy);

        myEnergy.add(lowEnergy);
        myEnergy.add(mediumEnergy);
        myEnergy.add(highEnergy);

        myEnergy.checkGaps();
        myEnergy.display();

        myEnergySets[0] = lowEnergy;
        myEnergySets[1] = mediumEnergy;
        myEnergySets[2] = highEnergy;
    }

    /**
     * This method sets up linguistic variables and fuzzy sets for target input.
     * @throws FuzzyException
     */
    private void setupTarget() throws FuzzyException {
        // TODO: define here
    }

    /**
     * This method sets up linguistic variables and fuzzy sets for blast input.
     * @throws FuzzyException
     */
    private void setupBlast() throws FuzzyException {

//        setDist(blastDist, "blast", blastDistSets);
//        setAspect(blastAspect, "blast", blastAspectSets);
//        setAngleOff(blastAngleOff, "blast", blastAngleOffSets);

        // set up distance

        final double ramp1 = 0.05 * maxDistance;
        final double ramp2 = 0.10 * maxDistance;
        final double ramp3 = 0.15 * maxDistance;
        final double ramp4 = 0.25 * maxDistance;

        blastDist = new FuzzyVariable("dist to blast", "m", 0.0, maxDistance, 2);

        FuzzySet close = new FuzzySet("close", 0.0, 0.0, 0.0, ramp2);
        FuzzySet near = new FuzzySet("near", ramp1, ramp3, ramp3, ramp4);
        FuzzySet far = new FuzzySet("far", ramp3, ramp4, maxDistance, maxDistance);

        blastDist.add(close);
        blastDist.add(near);
        blastDist.add(far);

        blastDist.checkGaps();
        blastDist.display();

        blastDistSets[0] = close;
        blastDistSets[1] = near;
        blastDistSets[2] = far;

        // set up aspect
        blastAspect = new FuzzyVariable("blast aspect", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);

        FuzzySet rightTwelve = new FuzzySet("right twelve", RIGHT_TWELVE, RIGHT_TWELVE, RIGHT_TWELVE, RIGHT_NINE);
        FuzzySet rightNine = new FuzzySet("right nine", RIGHT_TWELVE, RIGHT_NINE, RIGHT_NINE, RIGHT_SIX);
        FuzzySet rightSix = new FuzzySet("right six", RIGHT_NINE, RIGHT_SIX, RIGHT_SIX, RIGHT_THREE);
        FuzzySet rightThree = new FuzzySet("right three", RIGHT_SIX, RIGHT_THREE, RIGHT_THREE, TWELVE);
        FuzzySet twelve = new FuzzySet("twelve", RIGHT_THREE, TWELVE, TWELVE, LEFT_NINE);
        FuzzySet leftNine = new FuzzySet("left nine", TWELVE, LEFT_NINE, LEFT_NINE, LEFT_SIX);
        FuzzySet leftSix = new FuzzySet("left six", LEFT_NINE, LEFT_SIX, LEFT_SIX, LEFT_THREE);
        FuzzySet leftThree = new FuzzySet("left three", LEFT_SIX, LEFT_THREE, LEFT_THREE, LEFT_TWELVE);
        FuzzySet leftTwelve = new FuzzySet("left twelve", LEFT_THREE, LEFT_TWELVE, LEFT_TWELVE, LEFT_TWELVE);

        blastAspect.add(rightTwelve);
        blastAspect.add(rightNine);
        blastAspect.add(rightSix);
        blastAspect.add(rightThree);
        blastAspect.add(twelve);
        blastAspect.add(leftNine);
        blastAspect.add(leftSix);
        blastAspect.add(leftThree);
        blastAspect.add(leftTwelve);

        blastAspect.checkGaps();
        blastAspect.display();

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

        FuzzySet rightZero = new FuzzySet("right zero", RIGHT_TWELVE, RIGHT_TWELVE, RIGHT_TWELVE, RIGHT_NINE);
        FuzzySet right270 = new FuzzySet("right 270", RIGHT_TWELVE, RIGHT_NINE, RIGHT_NINE, RIGHT_SIX);
        FuzzySet rightMerge = new FuzzySet("right merge", RIGHT_NINE, RIGHT_SIX, RIGHT_SIX, RIGHT_THREE);
        FuzzySet right90 = new FuzzySet("right 90", RIGHT_SIX, RIGHT_THREE, RIGHT_THREE, TWELVE);
        FuzzySet zero = new FuzzySet("zero", RIGHT_THREE, TWELVE, TWELVE, LEFT_NINE);
        FuzzySet left90 = new FuzzySet("left 90", TWELVE, LEFT_NINE, LEFT_NINE, LEFT_SIX);
        FuzzySet leftMerge = new FuzzySet("left merge", LEFT_NINE, LEFT_SIX, LEFT_SIX, LEFT_THREE);
        FuzzySet left270 = new FuzzySet("left 270", LEFT_SIX, LEFT_THREE, LEFT_THREE, LEFT_TWELVE);
        FuzzySet leftZero = new FuzzySet("left zero", LEFT_THREE, LEFT_TWELVE, LEFT_TWELVE, LEFT_TWELVE);

        blastAngleOff.add(rightZero);
        blastAngleOff.add(right270);
        blastAngleOff.add(rightMerge);
        blastAngleOff.add(right90);
        blastAngleOff.add(zero);
        blastAngleOff.add(left90);
        blastAngleOff.add(leftMerge);
        blastAngleOff.add(left270);
        blastAngleOff.add(leftZero);

        blastAngleOff.checkGaps();
        blastAngleOff.display();

        blastAngleOffSets[0] = rightZero;
        blastAngleOffSets[1] = right270;
        blastAngleOffSets[2] = rightMerge;
        blastAngleOffSets[3] = right90;
        blastAngleOffSets[4] = zero;
        blastAngleOffSets[5] = left90;
        blastAngleOffSets[6] = leftMerge;
        blastAngleOffSets[7] = left270;
        blastAngleOffSets[8] = leftZero;
    }

    /**
     * This method sets up linguistic variables and fuzzy sets for powerup input.
     * @throws FuzzyException
     */
    private void setupPowerUp() throws FuzzyException {
        // TODO: define here
    }

    /**********
     * OUTPUT *
     **********/

    /**
     * This method sets up turn output rules.
     * @throws FuzzyException
     */
    private void setupTurn() throws FuzzyException {
        // TODO: define here
        turn = new FuzzyVariable("turn", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);

        // ORIGINAL
//        double[][] turnOutput = {
//                // right twelve,    right nine,     right six,      right three,    twelve,         left nine,      left six,       left three,     left twelve
//                {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE},        // right zero
//                {LEFT_NINE,         TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE,         TWELVE,         LEFT_NINE},     // right 270
//                {RIGHT_THREE,       TWELVE,         TWELVE,         TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         RIGHT_THREE},   // right merge
//                {LEFT_NINE,         TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE,         TWELVE,         LEFT_NINE},     // right 90
//                {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE},        // zero
//                {RIGHT_THREE,       TWELVE,         TWELVE,         TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         RIGHT_THREE},   // left 90
//                {LEFT_NINE,         TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE,         TWELVE,         LEFT_NINE},     // left merge
//                {RIGHT_THREE,       TWELVE,         TWELVE,         TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         RIGHT_THREE},   // left 270
//                {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE}         // left zero
//        };

//        double[][] turnOutput = {
//                // right twelve,    right nine,     right six,      right three,    twelve,         left nine,      left six,       left three,     left twelve
//                {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE},        // right zero
//                {LEFT_NINE,         TWELVE,         TWELVE,         LEFT_NINE,      LEFT_NINE,      TWELVE,         TWELVE,         TWELVE,         LEFT_NINE},     // right 270
//                {TWELVE,            TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE},        // right merge
//                {LEFT_NINE,         TWELVE,         TWELVE,         TWELVE,         RIGHT_THREE,    RIGHT_THREE,    TWELVE,         TWELVE,         LEFT_NINE},     // right 90
//                {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE},        // zero
//                {RIGHT_THREE,       TWELVE,         TWELVE,         LEFT_NINE,      LEFT_NINE,      TWELVE,         TWELVE,         TWELVE,         RIGHT_THREE},   // left 90
//                {TWELVE,            TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE},        // left merge
//                {RIGHT_THREE,       TWELVE,         TWELVE,         TWELVE,         RIGHT_THREE,    RIGHT_THREE,    TWELVE,         TWELVE,         RIGHT_THREE},   // left 270
//                {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE}         // left zero
//        };

//        rules.addRuleMatrix(
//                blastAngleOff, blastAngleOffSets,
//                blastAspect, blastAspectSets,
//                turn, turnOutput
//        );
//
//        rules.displayRuleMatrix(
//                blastAngleOff, blastAngleOffSets,
//                blastAspect, blastAspectSets,
//                turn
//        );

        double[][][] turnOutput = {

                // x = blast aspect
                // y = blast angle-off
                // z = close near far

                // close
                {
                        // right twelve,    right nine,     right six,      right three,    twelve,         left nine,      left six,       left three,     left twelve
                        {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE},        // right zero
                        {LEFT_NINE,         TWELVE,         TWELVE,         LEFT_NINE,      LEFT_NINE,      TWELVE,         TWELVE,         RIGHT_THREE,    LEFT_NINE},     // right 270
                        {TWELVE,            TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE},        // right merge
                        {LEFT_NINE,         LEFT_SIX,       TWELVE,         TWELVE,         RIGHT_THREE,    RIGHT_SIX,      TWELVE,         TWELVE,         LEFT_NINE},     // right 90
                        {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE},        // zero
                        {RIGHT_THREE,       TWELVE,         TWELVE,         LEFT_NINE,      LEFT_NINE,      TWELVE,         TWELVE,         RIGHT_THREE,    RIGHT_THREE},   // left 90
                        {TWELVE,            TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE},        // left merge
                        {RIGHT_THREE,       LEFT_SIX,       TWELVE,         TWELVE,         RIGHT_THREE,    RIGHT_SIX,      TWELVE,         TWELVE,         RIGHT_THREE},   // left 270
                        {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE}         // left zero
                },
                // near
                {
                        // right twelve,    right nine,     right six,      right three,    twelve,         left nine,      left six,       left three,     left twelve
                        {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE},        // right zero
                        {LEFT_NINE,         TWELVE,         TWELVE,         LEFT_NINE,      LEFT_NINE,      TWELVE,         TWELVE,         RIGHT_THREE,    LEFT_NINE},     // right 270
                        {TWELVE,            TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE},        // right merge
                        {LEFT_NINE,         LEFT_SIX,       TWELVE,         TWELVE,         RIGHT_THREE,    RIGHT_SIX,      TWELVE,         TWELVE,         LEFT_NINE},     // right 90
                        {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE},        // zero
                        {RIGHT_THREE,       TWELVE,         TWELVE,         LEFT_NINE,      LEFT_NINE,      TWELVE,         TWELVE,         RIGHT_THREE,    RIGHT_THREE},   // left 90
                        {TWELVE,            TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE,         TWELVE},        // left merge
                        {RIGHT_THREE,       LEFT_SIX,       TWELVE,         TWELVE,         RIGHT_THREE,    RIGHT_SIX,      TWELVE,         TWELVE,         RIGHT_THREE},   // left 270
                        {TWELVE,            TWELVE,         RIGHT_THREE,    TWELVE,         TWELVE,         TWELVE,         LEFT_NINE,      TWELVE,         TWELVE}         // left zero
                },
                // far
                {
                        // right twelve, right nine, right six, right three, twelve, left nine, left six, left three, left twelve
                        {TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE}, // right zero
                        {TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE}, // right 270
                        {TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE}, // right merge
                        {TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE}, // right 90
                        {TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE}, // zero
                        {TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE}, // left 90
                        {TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE}, // left merge
                        {TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE}, // left 270
                        {TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE, TWELVE} // left zero
                }
        };

        rules.add3DRuleMatrix(
                blastDist, blastDistSets,
                blastAngleOff, blastAngleOffSets,
                blastAspect, blastAspectSets,
                turn, turnOutput
        );

        rules.display3DRuleMatrix(
                blastDist, blastDistSets,
                blastAngleOff, blastAngleOffSets,
                blastAspect, blastAspectSets,
                turn
        );
    }

    /**
     * This method sets up speed output rules.
     * @throws FuzzyException
     */
    private void setupSpeed() throws FuzzyException {

        final double midSpeed = 75.0;

        speed = new FuzzyVariable("speed", "", SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, 2);

        double[][] speedOutput = {
                // right twelve,    right nine,         right six,          right three,        twelve,             left nine,          left six,           left three,         left twelve
                {SAUCER_MIN_SPEED,  SAUCER_MIN_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED}, // right zero
                {SAUCER_MIN_SPEED,  SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED}, // right 270
                {SAUCER_MIN_SPEED,  SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED}, // right merge
                {SAUCER_MIN_SPEED,  SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED}, // right 90
                {SAUCER_MIN_SPEED,  SAUCER_MIN_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED}, // zero
                {SAUCER_MIN_SPEED,  SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED}, // left 90
                {SAUCER_MIN_SPEED,  SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED}, // left merge
                {SAUCER_MIN_SPEED,  SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED}, // left 270
                {SAUCER_MIN_SPEED,  SAUCER_MIN_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MAX_SPEED,   SAUCER_MIN_SPEED,   SAUCER_MIN_SPEED}  // left zero
        };

        rules.addRuleMatrix(
                blastAngleOff, blastAngleOffSets,
                blastAspect, blastAspectSets,
                speed, speedOutput
        );
    }

    /**
     * This method sets up firepower output rules.
     * @throws FuzzyException
     */
    private void setupFirePower() throws FuzzyException {
        // TODO: define here
    }

    /**
     * This method sets up shield output rules. MUST BE BOOLEAN!
     * @throws FuzzyException
     */
    private void setupShield() throws FuzzyException {
        // TODO: define here
    }

    /**********
     * COMMON *
     **********/

    /**
     * This method sets up a common distance variable/set.
     *
     * @param theVariable FuzzyVariable.
     * @param object String.
     * @throws FuzzyException
     */
    private void setDist(FuzzyVariable theVariable, String object, FuzzySet[] theSet) throws FuzzyException {

        final double maxDistance = Math.sqrt(
                STARFIELD_WIDTH * STARFIELD_WIDTH +
                        STARFIELD_HEIGHT * STARFIELD_HEIGHT
        );

        final double ramp1 = 0.05 * maxDistance;
        final double ramp2 = 0.10 * maxDistance;
        final double ramp3 = 0.15 * maxDistance;
        final double ramp4 = 0.25 * maxDistance;

        theVariable = new FuzzyVariable("dist to " + object, "m", 0.0, maxDistance, 2);

        FuzzySet close = new FuzzySet("close", 0.0, 0.0, 0.0, ramp2);
        FuzzySet near = new FuzzySet("near", ramp1, ramp3, ramp3, ramp4);
        FuzzySet far = new FuzzySet("far", ramp3, ramp4, maxDistance, maxDistance);

        theVariable.add(close);
        theVariable.add(near);
        theVariable.add(far);

        theVariable.checkGaps();
        theVariable.display();

        theSet[0] = close;
        theSet[1] = near;
        theSet[2] = far;
    }

    /**
     * This method sets up a common aspect variable/set
     * @param theVariable FuzzyVariable.
     * @param object String.
     * @throws FuzzyException
     */
    private void setAspect(FuzzyVariable theVariable, String object, FuzzySet[] theSet) throws FuzzyException {

        theVariable = new FuzzyVariable(object + "'s aspect", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);

        FuzzySet rightTwelve = new FuzzySet("right twelve", RIGHT_TWELVE, RIGHT_TWELVE, RIGHT_TWELVE, RIGHT_NINE);
        FuzzySet rightNine = new FuzzySet("right nine", RIGHT_TWELVE, RIGHT_NINE, RIGHT_NINE, RIGHT_SIX);
        FuzzySet rightSix = new FuzzySet("right six", RIGHT_NINE, RIGHT_SIX, RIGHT_SIX, RIGHT_THREE);
        FuzzySet rightThree = new FuzzySet("right three", RIGHT_SIX, RIGHT_THREE, RIGHT_THREE, TWELVE);
        FuzzySet twelve = new FuzzySet("twelve", RIGHT_THREE, TWELVE, TWELVE, LEFT_NINE);
        FuzzySet leftNine = new FuzzySet("left nine", TWELVE, LEFT_NINE, LEFT_NINE, LEFT_SIX);
        FuzzySet leftSix = new FuzzySet("left six", LEFT_NINE, LEFT_SIX, LEFT_SIX, LEFT_THREE);
        FuzzySet leftThree = new FuzzySet("left three", LEFT_SIX, LEFT_THREE, LEFT_THREE, LEFT_TWELVE);
        FuzzySet leftTwelve = new FuzzySet("left twelve", LEFT_THREE, LEFT_TWELVE, LEFT_TWELVE, LEFT_TWELVE);

        theVariable.add(rightTwelve);
        theVariable.add(rightNine);
        theVariable.add(rightSix);
        theVariable.add(rightThree);
        theVariable.add(twelve);
        theVariable.add(leftNine);
        theVariable.add(leftSix);
        theVariable.add(leftThree);
        theVariable.add(leftTwelve);

        theVariable.checkGaps();
        theVariable.display();

        theSet[0] = rightTwelve;
        theSet[1] = rightNine;
        theSet[2] = rightSix;
        theSet[3] = rightThree;
        theSet[4] = twelve;
        theSet[5] = leftNine;
        theSet[6] = leftSix;
        theSet[7] = leftThree;
        theSet[8] = leftTwelve;
    }

    /**
     * This method sets up a common angle-off variable/set.
     * @param theVariable FuzzyVariable.
     * @param object String.
     * @throws FuzzyException
     */
    private void setAngleOff(FuzzyVariable theVariable, String object, FuzzySet[] theSet) throws FuzzyException {

        theVariable = new FuzzyVariable(object + "'s angle-off", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);

        FuzzySet rightZero = new FuzzySet("right zero", RIGHT_TWELVE, RIGHT_TWELVE, RIGHT_TWELVE, RIGHT_NINE);
        FuzzySet right270 = new FuzzySet("right 270", RIGHT_TWELVE, RIGHT_NINE, RIGHT_NINE, RIGHT_SIX);
        FuzzySet rightMerge = new FuzzySet("right merge", RIGHT_NINE, RIGHT_SIX, RIGHT_SIX, RIGHT_THREE);
        FuzzySet right90 = new FuzzySet("right 90", RIGHT_SIX, RIGHT_THREE, RIGHT_THREE, TWELVE);
        FuzzySet zero = new FuzzySet("zero", RIGHT_THREE, TWELVE, TWELVE, LEFT_NINE);
        FuzzySet left90 = new FuzzySet("left 90", TWELVE, LEFT_NINE, LEFT_NINE, LEFT_SIX);
        FuzzySet leftMerge = new FuzzySet("left merge", LEFT_NINE, LEFT_SIX, LEFT_SIX, LEFT_THREE);
        FuzzySet left270 = new FuzzySet("left 270", LEFT_SIX, LEFT_THREE, LEFT_THREE, LEFT_TWELVE);
        FuzzySet leftZero = new FuzzySet("left zero", LEFT_THREE, LEFT_TWELVE, LEFT_TWELVE, LEFT_TWELVE);

        theVariable.add(rightZero);
        theVariable.add(right270);
        theVariable.add(rightMerge);
        theVariable.add(right90);
        theVariable.add(zero);
        theVariable.add(left90);
        theVariable.add(leftMerge);
        theVariable.add(left270);
        theVariable.add(leftZero);

        theVariable.checkGaps();
        theVariable.display();

        theSet[0] = rightZero;
        theSet[1] = right270;
        theSet[2] = rightMerge;
        theSet[3] = right90;
        theSet[4] = zero;
        theSet[5] = left90;
        theSet[6] = leftMerge;
        theSet[7] = left270;
        theSet[8] = leftZero;
    }

    /****************
     * SENSOR INPUT *
     ****************/

    @Override
    public void senseSaucers(ArrayList<SensorData> data) throws Exception {
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
        } else {
            nearestTarget = null;
        }
    }

    @Override
    public void sensePowerUps(ArrayList<SensorData> data) throws Exception {

        isPowerUp = data.size() > 0;

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
        } else {
            nearestPowerUp = null;
        }
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
            rules.clearVariables();
            blastDist.setValue(nearestBlast.distance);
            blastAspect.setValue(nearestBlast.direction);
            blastAngleOff.setValue(nearestBlast.heading);
            rules.update();
        } else {
            nearestBlast = null;
            turn.setValue(0.0);
            speed.setValue(50.0);
        }
    }

    @Override
    public void senseEnergy(double energy) throws Exception {

    }

    @Override
    public SensorData getTarget() throws Exception {
        return null;
    }

    @Override
    public double getFirePower() throws Exception {
        return 0;
    }

    @Override
    public double getSpeed() throws Exception {
//        return 0;
        return speed.getValue();
    }

    @Override
    public double getTurn() throws Exception {
//        return 0;
        return turn.getValue();
    }

    @Override
    public boolean getShields() throws Exception {
        return false;
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
