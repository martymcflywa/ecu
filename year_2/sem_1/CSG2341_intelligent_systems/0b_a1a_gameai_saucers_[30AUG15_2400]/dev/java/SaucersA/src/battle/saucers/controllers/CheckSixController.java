package battle.saucers.controllers;

import au.edu.ecu.is.fuzzy.*;
import battle.Constants;
import battle.saucers.Saucer;

import java.awt.*;

/**
 * Created by marty on 9/08/2015.
 */
public class CheckSixController implements SaucerController {

    // saucer config
    private static final String NAME = "checkSix";
    private static final Color BASE = Color.yellow;
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

    public CheckSixController() throws FuzzyException {

        // instantiate rule
        rules = new SugenoRuleSet();

        // set up fuzzy variables
        setupDistanceInput();
        setupEnergyDifferenceInput();
        setupHeadingAngleInput();

        // rules are set up here
        setupTurnOutput();
        setupSpeedOutput();
        setupFirePowerOutput();

    }

    /**
     * This function sets up the distance variables and sets.
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

        FuzzySet close = new FuzzySet("close", 0.0, 0.0, ramp1, ramp2);
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
     * This method sets up the energy difference fuzzy variables and sets.
     *
     * @throws FuzzyException
     */
    private void setupEnergyDifferenceInput() throws FuzzyException {

        final double maxDiff = Saucer.START_ENERGY;
        final double minDiff = -maxDiff;

        final double ramp1 = maxDiff * 0.08;
        final double ramp2 = maxDiff * 0.05;
        final double ramp3 = maxDiff * 0.02;

        energyDifference = new FuzzyVariable("energy difference", "J", minDiff, maxDiff, 2);

        FuzzySet losing = new FuzzySet("losing", minDiff, minDiff, -ramp1, -ramp3);
        FuzzySet even = new FuzzySet("even", -ramp2, 0.0, 0.0, ramp2);
        FuzzySet winning = new FuzzySet("winning", ramp3, ramp1, maxDiff, maxDiff);

        energyDifference.add(losing);
        energyDifference.add(even);
        energyDifference.add(winning);

        energyDifference.checkGaps();
        energyDifference.display();

        energyDiffSets[0] = losing;
        energyDiffSets[1] = even;
        energyDiffSets[2] = winning;
    }

    private void setupHeadingAngleInput() throws FuzzyException {

        final double maxLeft = 360.0;
        final double maxRight = -maxLeft;

        final double ramp1 = 330.0;
        final double ramp2 = 280.0;
        final double ramp3 = 225.0;
        final double ramp4 = 170.0;
        final double ramp5 = 90.0;
        final double ramp6 = 40.0;
        final double ramp7 = 20.0;

        headingAngle = new FuzzyVariable("heading angle", "*", maxRight, maxLeft, 2);

        FuzzySet rearRight = new FuzzySet("rear right", maxRight, maxRight, maxRight, -ramp2);
        FuzzySet hardRight = new FuzzySet("hard right", -ramp1, -ramp2, -ramp3, -ramp4);
        FuzzySet right = new FuzzySet("right", -ramp3, -ramp4, -ramp5, -ramp6);
        FuzzySet smallRight = new FuzzySet("small right", -ramp5, -ramp6, -ramp6, 0.0);

        FuzzySet straightAhead = new FuzzySet("straight ahead", -ramp7, 0.0, 0.0, ramp7);

        FuzzySet smallLeft = new FuzzySet("small left", 0.0, ramp6, ramp6, ramp5);
        FuzzySet left = new FuzzySet("left", ramp6, ramp5, ramp4, ramp3);
        FuzzySet hardLeft = new FuzzySet("hard left", ramp4, ramp3, ramp2, ramp1);
        FuzzySet rearLeft = new FuzzySet("rear left", ramp2, maxLeft, maxLeft, maxLeft);

        headingAngle.add(rearRight);
        headingAngle.add(hardRight);
        headingAngle.add(right);
        headingAngle.add(smallRight);
        headingAngle.add(straightAhead);
        headingAngle.add(smallLeft);
        headingAngle.add(left);
        headingAngle.add(hardLeft);
        headingAngle.add(rearLeft);

        headingAngle.checkGaps();
        headingAngle.display();

        headingAngleSets[0] = rearRight;
        headingAngleSets[1] = hardRight;
        headingAngleSets[2] = right;
        headingAngleSets[3] = smallRight;

        headingAngleSets[4] = straightAhead;

        headingAngleSets[5] = smallLeft;
        headingAngleSets[6] = left;
        headingAngleSets[7] = hardLeft;
        headingAngleSets[8] = rearLeft;
    }

    /**
     * This method sets up the turn fuzzy variables and sets.
     *
     * @throws FuzzyException
     */

    private void setupTurnOutput() throws FuzzyException {

        final double straight = 0.0;
        final double slightLeft = 10.0;
        final double frontLeft = 45.0;
        final double left = 240.0;
        final double rearLeft = 360.0;

        final double rearRight = -rearLeft;
        final double right = -left;
        final double frontRight = -frontLeft;
        final double slightRight = -slightLeft;

        turn = new FuzzyVariable("turn", "*", -360.0, 360.0, 2);

        double[][] turnOutput = {
                // losing even winning
                {frontLeft, right, rearRight}, // rearRight
                {slightLeft, frontRight, right}, // hardRight
                {20.0, slightRight, frontRight}, // right
                {160.0, slightRight, slightRight}, // smallRight
                {180.0, straight, straight}, // straightAhead
                {-160.0, slightLeft, slightLeft}, // smallLeft
                {-20.0, slightLeft, frontLeft}, // left
                {slightRight, frontLeft, left}, // hardLeft
                {frontRight, left, rearLeft} // rearLeft
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

    private void setupSpeedOutput() throws FuzzyException {

        final double minSpeed = Saucer.MIN_SPEED;
        final double midSpeed = Saucer.MAX_SPEED - Saucer.MIN_SPEED * 0.5;
        final double maxSpeed = Saucer.MAX_SPEED;

        speed = new FuzzyVariable("speed", "J", Saucer.MIN_SPEED, Saucer.MAX_SPEED, 2);

        double[][] speedLevels = {
                // losing even winning
                {maxSpeed, minSpeed, minSpeed}, // close
                {midSpeed, minSpeed, maxSpeed}, // near
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
     *
     * @throws FuzzyException
     */
    private void setupFirePowerOutput() throws FuzzyException {

        final double maxPower = Saucer.MAX_POWER;
        final double midPower = maxPower * 0.5;

        firePower = new FuzzyVariable("firepower", "J", -maxPower, maxPower, 2);

        double[][] firePowerLevels = {
                // losing even winning
                {0.0, midPower, maxPower}, // close
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
