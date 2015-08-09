package battle.saucers.controllers;

import au.edu.ecu.is.fuzzy.FuzzyException;
import au.edu.ecu.is.fuzzy.SugenoRuleSet;

import java.awt.*;

/**
 * Created by marty on 9/08/2015.
 */
public class MartyController implements SaucerController {

    private static final String NAME = "marty";
    private static final Color BASE = Color.yellow;
    private static final Color ARROW = Color.black;

    private SugenoRuleSet rules;

    public MartyController() {

        // TODO: define fuzzy variables

        // TODO: define rules

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
