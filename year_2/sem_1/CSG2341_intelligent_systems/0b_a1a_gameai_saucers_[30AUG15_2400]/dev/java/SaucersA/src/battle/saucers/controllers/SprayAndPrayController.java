package battle.saucers.controllers;

import au.edu.ecu.is.fuzzy.*;
import battle.Constants;
import battle.saucers.Saucer;

import java.awt.*;

/**
 * Created by marty on 9/08/2015.
 */
public class SprayAndPrayController implements SaucerController {

    // just testing opponent direction here
    private double opDir;

    // saucer visual config
    private static final String NAME = "spray and pray";
    private static final Color BASE = Color.yellow;
    private static final Color ARROW = Color.black;

    // input variables
    private FuzzyVariable distance;
    private FuzzyVariable energyDifference;
    private FuzzyVariable turn;

    // output variables
    private FuzzyVariable firePower;

    // fuzzy sets
    private FuzzySet[] distanceSets = new FuzzySet[3];
    private FuzzySet[] energyDiffSets = new FuzzySet[3];
    private FuzzySet[] turnSets = new FuzzySet[3];

    // the ruleset
    private SugenoRuleSet rules;

    public SprayAndPrayController() throws FuzzyException {

        // instantiate rule
        rules = new SugenoRuleSet();

        // TODO: define fuzzy variables

        // set up fuzzy variables
        setupDistanceInput();
        setupEnergyDifferenceInput();
        setupTurnInput();

        setupFirePowerOutput();


        // TODO: define rules

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

        final double ramp1 = 0.25 * maxDistance;
        final double ramp2 = 0.50 * maxDistance;
        final double ramp3 = 0.75 * maxDistance;

        distance = new FuzzyVariable("distance to target", "m", 0.0, maxDistance, 2);

        FuzzySet close = new FuzzySet("close", 0.0, 0.0, ramp1, ramp2);
        FuzzySet near = new FuzzySet("near", ramp1, ramp2, ramp2, ramp3);
        FuzzySet far = new FuzzySet("far", ramp2, ramp3, maxDistance, maxDistance);

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

        final double ramp1 = 0.1 * maxDiff;
        final double ramp2 = 0.2 * maxDiff;
        final double ramp3 = -0.2 * maxDiff;
        final double ramp4 = -0.1 * maxDiff;

        energyDifference = new FuzzyVariable("energy difference", "J", minDiff, maxDiff, 2);

        FuzzySet losing = new FuzzySet("losing", minDiff, minDiff, ramp3, ramp4);
        FuzzySet even = new FuzzySet("even", ramp3, 0.0, 0.0, ramp2);
        FuzzySet winning = new FuzzySet("winning", ramp1, ramp2, maxDiff, maxDiff);

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
     * This method sets up the turn fuzzy variables and sets.
     *
     * @throws FuzzyException
     */
    private void setupTurnInput() throws FuzzyException {

        final double maxLeft = 360.0;
        final double maxRight = -maxLeft;

        final double ramp1 = 0.1 * maxLeft;
        final double ramp2 = 0.2 * maxLeft;
        final double ramp3 = 0.2 * maxRight;
        final double ramp4 = 0.1 * maxRight;

        turn = new FuzzyVariable("turn", "*", maxRight, maxLeft, 2);

        FuzzySet right = new FuzzySet("right", maxRight, maxRight, ramp3, ramp4);
        FuzzySet straight = new FuzzySet("straight", ramp3, 0.0, 0.0, ramp2);
        FuzzySet left = new FuzzySet("left", ramp1, ramp2, maxLeft, maxLeft);

        turn.add(right);
        turn.add(straight);
        turn.add(left);

        turn.checkGaps();
        turn.display();

        turnSets[0] = right;
        turnSets[1] = straight;
        turnSets[2] = left;
    }

    /**
     *
     * @throws FuzzyException
     */
    private void setupFirePowerOutput() throws FuzzyException {

        final double maxPower = Saucer.MAX_POWER;
        final double highPower = maxPower * 0.4;
        final double midPower = maxPower * 0.2;
        final double lowPower = maxPower * 0.05;

        firePower = new FuzzyVariable("firepower", "J", -maxPower, maxPower, 2);

        double[][] firePowerLevels = {
                // losing even winning
                {lowPower, midPower, highPower}, // close
                {0.0, 0.0, highPower}, // near
                {0.0, 0.0, lowPower} // far
        };

        rules.addRuleMatrix(
                distance, distanceSets,
                energyDifference, energyDiffSets,
                firePower, firePowerLevels
        );

        // TODO: delete after testing
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

        // TODO: set new rules
        distance.setValue(opponentDistance);
        energyDifference.setValue(energy -  opponentEnergy);

        // TODO: fire rules
        rules.update();

        // testing
        System.out.println(opponentDirection);
        opDir = opponentDirection;

    }

    /**
     * TODO: Use fuzzy inference to generate firepower.
     * @return
     * @throws Exception
     */
    @Override
    public double getFirePower() throws Exception {
        return firePower.getValue();
    }

    /**
     * TODO: Use fuzzy inference to generate speed.
     * @return
     * @throws Exception
     */
    @Override
    public double getSpeed() throws Exception {
        return 0;
    }

    /**
     * TODO: Use fuzzy inference to generate turn.
     * @return
     * @throws Exception
     */
    @Override
    public double getTurn() throws Exception {

        // just testing here.
        return opDir;
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
