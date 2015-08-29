package battle.saucers.controllers;

import au.edu.ecu.is.fuzzy.FuzzyException;
import au.edu.ecu.is.fuzzy.FuzzySet;
import au.edu.ecu.is.fuzzy.FuzzyVariable;
import au.edu.ecu.is.fuzzy.SugenoRuleSet;
import battle.Constants;
import battle.saucers.Saucer;

import java.awt.*;

/**
 * checkSix fuzzy controller.
 * @author Martin Ponce 10371381
 * @version 20150828
 */
public class EvilCheckSixController implements SaucerController {

    // saucer config
    private static final String NAME = "evilCheckSix";
    private static final Color BASE = Color.black;
    private static final Color ARROW = Color.black;

    // linguistic input variables
    private FuzzyVariable distance;
    private FuzzyVariable energyDifference;
    private FuzzyVariable headingAngle;

    // linguistic output variables
    private FuzzyVariable turn;
    private FuzzyVariable speed;
    private FuzzyVariable firePower;

    // fuzzy sets
    private FuzzySet[] distanceSets = new FuzzySet[3];
    private FuzzySet[] energyDiffSets = new FuzzySet[3];
    private FuzzySet[] headingAngleSets = new FuzzySet[9];

    // the ruleset
    private SugenoRuleSet rules;

    // constants for cardinal directions, left goes counterclockwise
    private final double LEFT_TWELVE = 360.0;
    private final double LEFT_NINE = LEFT_TWELVE - 90.0; // 270
    private final double LEFT_SIX = LEFT_NINE - 90.0; // 180
    private final double LEFT_THREE = LEFT_SIX - 90.0; // 90

    private final double TWELVE = 0.0;

    // east/west cardinals reversed, right goes clockwise
    private final double RIGHT_THREE = -LEFT_THREE; // -90
    private final double RIGHT_SIX = -LEFT_SIX; // -180
    private final double RIGHT_NINE = -LEFT_NINE; // -270
    private final double RIGHT_TWELVE = -LEFT_TWELVE; // -360

    public EvilCheckSixController() throws FuzzyException {

        // instantiate rule
        rules = new SugenoRuleSet();

        // set up fuzzy variables
        setupDistanceInput();
        setupEnergyDifferenceInput();
        setupHeadingAngleInput();

        // setup rules for output
        setupTurnOutput();
        setupSpeedOutput();
        setupFirePowerOutput();

    }

    /**
     * This function sets up the distance linguistic variable and fuzzy sets.
     *
     * @throws FuzzyException
     */
    private void setupDistanceInput() throws FuzzyException {

        final double maxDistance = Math.sqrt(
                Constants.STARFIELD_WIDTH * Constants.STARFIELD_WIDTH +
                        Constants.STARFIELD_HEIGHT * Constants.STARFIELD_HEIGHT
        );

        final double ramp1 = 0.05 * maxDistance;
        final double ramp2 = 0.10 * maxDistance;
        final double ramp3 = 0.15 * maxDistance;
        final double ramp4 = 0.25 * maxDistance;

        distance = new FuzzyVariable("distance to target", "m", 0.0, maxDistance, 2);

        FuzzySet close = new FuzzySet("close", 0.0, 0.0, 0.0, ramp2);
        FuzzySet near = new FuzzySet("near", ramp1, ramp3, ramp3, ramp4);
        FuzzySet far = new FuzzySet("far", ramp3, ramp4, maxDistance, maxDistance);

        distance.add(close);
        distance.add(near);
        distance.add(far);

        distance.checkGaps();
        distance.display();

        distanceSets[0] = close;
        distanceSets[1] = near;
        distanceSets[2] = far;
    }

    /**
     * This method sets up the energy difference linguistic variable and fuzzy sets.
     *
     * @throws FuzzyException
     */
    private void setupEnergyDifferenceInput() throws FuzzyException {

        final double maxDiff = Saucer.START_ENERGY;
        final double minDiff = -maxDiff;

        final double ramp1 = maxDiff * 0.05;
        final double ramp2 = maxDiff * 0.02;
        final double ramp3 = maxDiff * 0.01;

        energyDifference = new FuzzyVariable("energy difference", "J", minDiff, maxDiff, 2);

        FuzzySet losing = new FuzzySet("losing", minDiff, minDiff, -ramp1, 0.0);
        FuzzySet even = new FuzzySet("even", -ramp2, -ramp2, ramp2, ramp2);
        FuzzySet winning = new FuzzySet("winning", 0.0, ramp1, maxDiff, maxDiff);

        energyDifference.add(losing);
        energyDifference.add(even);
        energyDifference.add(winning);

        energyDifference.checkGaps();
        energyDifference.display();

        energyDiffSets[0] = losing;
        energyDiffSets[1] = even;
        energyDiffSets[2] = winning;
    }


    /**
     * This method sets up the heading angle linguistic variable and fuzzy sets.
     *
     * @throws FuzzyException
     */
    private void setupHeadingAngleInput() throws FuzzyException {

        headingAngle = new FuzzyVariable("heading angle", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);

        FuzzySet revRightFront = new FuzzySet("reverse right front", RIGHT_TWELVE, RIGHT_TWELVE, RIGHT_TWELVE, RIGHT_NINE);
        FuzzySet rightLeft = new FuzzySet("right left", RIGHT_TWELVE, RIGHT_NINE, RIGHT_NINE, RIGHT_SIX);
        FuzzySet rightRear = new FuzzySet("right rear", RIGHT_NINE, RIGHT_SIX, RIGHT_SIX, RIGHT_THREE);
        FuzzySet rightFront = new FuzzySet("right front", RIGHT_SIX, RIGHT_THREE, RIGHT_THREE, TWELVE);
        FuzzySet front = new FuzzySet("front", RIGHT_THREE, TWELVE, TWELVE, LEFT_THREE);
        FuzzySet leftFront = new FuzzySet("left front", TWELVE, LEFT_THREE, LEFT_THREE, LEFT_SIX);
        FuzzySet leftRear = new FuzzySet("left rear", LEFT_THREE, LEFT_SIX, LEFT_SIX, LEFT_NINE);
        FuzzySet leftRight = new FuzzySet("left right", LEFT_SIX, LEFT_NINE, LEFT_NINE, LEFT_TWELVE);
        FuzzySet revLeftFront = new FuzzySet("reverse left front", LEFT_NINE, LEFT_TWELVE, LEFT_TWELVE, LEFT_TWELVE);

        headingAngle.add(revRightFront);
        headingAngle.add(rightLeft);
        headingAngle.add(rightRear);
        headingAngle.add(rightFront);
        headingAngle.add(front);
        headingAngle.add(leftFront);
        headingAngle.add(leftRear);
        headingAngle.add(leftRight);
        headingAngle.add(revLeftFront);

        headingAngle.checkGaps();
        headingAngle.display();

        headingAngleSets[0] = revRightFront;
        headingAngleSets[1] = rightLeft;
        headingAngleSets[2] = rightRear;
        headingAngleSets[3] = rightFront;
        headingAngleSets[4] = front;
        headingAngleSets[5] = leftFront;
        headingAngleSets[6] = leftRear;
        headingAngleSets[7] = leftRight;
        headingAngleSets[8] = revLeftFront;
    }

    /**
     * This method sets up the turn linguistic variables and fuzzy sets.
     *
     * @throws FuzzyException
     */
    private void setupTurnOutput() throws FuzzyException {

        turn = new FuzzyVariable("turn", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);

        double[][] turnOutput = {
                // losing even winning
                {LEFT_SIX, TWELVE, TWELVE}, // revRightFront
                {RIGHT_THREE, LEFT_THREE, LEFT_THREE}, // rightLeft
                {RIGHT_TWELVE, RIGHT_SIX, RIGHT_SIX}, // rightRear
                {LEFT_NINE, RIGHT_THREE, RIGHT_THREE}, // rightFront
                {RIGHT_SIX, TWELVE, TWELVE}, // front
                {RIGHT_THREE, LEFT_THREE, LEFT_THREE}, // leftFront
                {RIGHT_TWELVE, LEFT_SIX, LEFT_SIX}, // leftRear
                {LEFT_NINE, RIGHT_THREE, RIGHT_THREE}, // leftRight
                {RIGHT_SIX, TWELVE, TWELVE} // revLeftFront
        };

        rules.addRuleMatrix(
                headingAngle, headingAngleSets,
                energyDifference, energyDiffSets,
                turn, turnOutput
        );

        rules.displayRuleMatrix(
                headingAngle, headingAngleSets,
                energyDifference, energyDiffSets,
                turn
        );
    }

    /**
     * This method sets up the linguistic variable for speed and rules for output.
     *
     * @throws FuzzyException
     */
    private void setupSpeedOutput() throws FuzzyException {

        final double minSpeed = Saucer.MIN_SPEED;
        final double midSpeed = Saucer.MAX_SPEED - Saucer.MIN_SPEED * 0.5;
        final double maxSpeed = Saucer.MAX_SPEED;

        speed = new FuzzyVariable("speed", "J", Saucer.MIN_SPEED, Saucer.MAX_SPEED, 2);

        double[][] speedLevels = {
                // losing even winning
                {maxSpeed, minSpeed, minSpeed}, // close
                {midSpeed, minSpeed, midSpeed}, // near
                {minSpeed, midSpeed, maxSpeed}, // far
        };

        rules.addRuleMatrix(
                distance, distanceSets,
                energyDifference, energyDiffSets,
                speed, speedLevels
        );

        rules.displayRuleMatrix(
                distance, distanceSets,
                energyDifference, energyDiffSets,
                speed
        );
    }

    /**
     * This method sets up the linguistic variable for fire power and rules for output.
     *
     * @throws FuzzyException
     */
    private void setupFirePowerOutput() throws FuzzyException {

        final double maxPower = Saucer.MAX_POWER;
        final double midPower = maxPower * 0.5;

        firePower = new FuzzyVariable("firepower", "J", -maxPower, maxPower, 2);

        double[][] firePowerLevels = {
                // losing even winning
                {midPower, maxPower, maxPower}, // close
                {0.0, maxPower, maxPower}, // near
                {0.0, 0.0, 0.0} // far
        };

        rules.addRuleMatrix(
                distance, distanceSets,
                energyDifference, energyDiffSets,
                firePower, firePowerLevels
        );

        rules.displayRuleMatrix(
                distance, distanceSets,
                energyDifference, energyDiffSets,
                firePower
        );
    }

    @Override
    public void sensorUpdate(double opponentDistance, double opponentDirection, double opponentEnergy, double energy) throws FuzzyException {

        // clear previous values
        rules.clearVariables();

        distance.setValue(opponentDistance);
        energyDifference.setValue(energy -  opponentEnergy);
        headingAngle.setValue(opponentDirection);

        rules.update();
    }

    /**
     * @return
     * @throws Exception
     */
    @Override
    public double getFirePower() throws Exception {
        return firePower.getValue();
    }

    /**
     * @return
     * @throws Exception
     */
    @Override
    public double getSpeed() throws Exception {
        return speed.getValue();
    }

    /**
     * @return
     * @throws Exception
     */
    @Override
    public double getTurn() throws Exception {
        return turn.getValue();
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
