package battle.saucers.controllers;

import au.edu.ecu.is.fuzzy.*;
import battle.Constants;
import battle.saucers.Saucer;

import java.awt.*;

/**
 * Created by marty on 9/08/2015.
 */
public class MartyController implements SaucerController {

    // saucer visual config
    private static final String NAME = "marty";
    private static final Color BASE = Color.yellow;
    private static final Color ARROW = Color.black;

    // input variables
    private FuzzyVariable distance;
    private FuzzyVariable energyDifference;
    private FuzzyVariable firePower;
    private FuzzyVariable turn;

    // the ruleset
    private SugenoRuleSet rules;

    public MartyController() throws FuzzyException {

        // TODO: define fuzzy variables

        /**
         * Distance fuzzy variable.
         */
        setupDistance();
        setupEnergyDifference();

        // TODO: define rules

    }

    /**
     * This function sets up the distance variables and sets.
     *
     * @throws FuzzyException
     */
    private void setupDistance() throws FuzzyException {

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
    }

    private void setupEnergyDifference() throws FuzzyException {

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
    }

    @Override
    public void sensorUpdate(double opponentDistance, double opponentDirection, double opponentEnergy, double energy) throws FuzzyException {

        // clear previous values
        //rules.clearVariables();

        // TODO: set new rules

        // TODO: fire rules

    }

    /**
     * TODO: Use fuzzy inference to generate firepower.
     * @return
     * @throws Exception
     */
    @Override
    public double getFirePower() throws Exception {
        return 0;
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
        return 0;
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
