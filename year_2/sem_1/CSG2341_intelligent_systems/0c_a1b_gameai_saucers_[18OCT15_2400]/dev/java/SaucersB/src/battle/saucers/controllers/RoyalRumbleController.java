package battle.saucers.controllers;

import au.edu.ecu.is.fuzzy.FuzzyException;
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

    private double myEnergy;
    private boolean isPowerUp;

    // linguistic input variables
    private FuzzyVariable targetDist;
    private FuzzyVariable targetDir;
    private FuzzyVariable targetHead;
    private FuzzyVariable targetSpeed;
    private FuzzyVariable targetEnergy;

    private FuzzyVariable blastDist;
    private FuzzyVariable blastDir;
    private FuzzyVariable blastHead;
    private FuzzyVariable blastSpeed;

    private FuzzyVariable powerUpDist;
    private FuzzyVariable powerUpDir;

    // TODO: create sets

    // linguistic output variables
    private FuzzyVariable turn;
    private FuzzyVariable speed;
    private FuzzyVariable firePower;
    // this needs to be boolean
    private FuzzyVariable shield;

    // the rules
    private SugenoRuleSet rules;

    /**
     * Constructor.
     */
    public RoyalRumbleController() throws FuzzyException {

        // fuzzy variables, rules here
        rules = new SugenoRuleSet();

        // setup inputs
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

    /**
     * This function sets up linguistic variables and fuzzy sets for target input.
     * @throws FuzzyException
     */
    private void setupTarget() throws FuzzyException {
        // TODO: define here
    }

    /**
     * This function sets up linguistic variables and fuzzy sets for blast input.
     * @throws FuzzyException
     */
    private void setupBlast() throws FuzzyException {
        // TODO: define here
    }

    /**
     * This function sets up linguistic variables and fuzzy sets for powerup input.
     * @throws FuzzyException
     */
    private void setupPowerUp() throws FuzzyException {
        // TODO: define here
    }

    /**********
     * OUTPUT *
     **********/

    /**
     * This function sets up turn output rules.
     * @throws FuzzyException
     */
    private void setupTurn() throws FuzzyException {
        // TODO: define here
    }

    /**
     * This function sets up speed output rules.
     * @throws FuzzyException
     */
    private void setupSpeed() throws FuzzyException {

    }

    /**
     * This function sets up firepower output rules.
     * @throws FuzzyException
     */
    private void setupFirePower() throws FuzzyException {
        // TODO: define here
    }

    /**
     * This function sets up shield output rules. MUST BE BOOLEAN!
     * @throws FuzzyException
     */
    private void setupShield() throws FuzzyException {
        // TODO: define here
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
        } else {
            nearestBlast = null;
        }
    }

    @Override
    public void senseEnergy(double energy) throws Exception {
        this.myEnergy = energy;
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
        return 0;
    }

    @Override
    public double getTurn() throws Exception {
        return 0;
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
