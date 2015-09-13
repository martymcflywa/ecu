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
//    private FuzzyVariable blastSpeed;

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

        // use shared setDistance for now
        setDist(blastDist, "blast");
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
    }

    /**
     * This method sets up speed output rules.
     * @throws FuzzyException
     */
    private void setupSpeed() throws FuzzyException {
        // TODO: define here
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
    private void setDist(FuzzyVariable theVariable, String object) throws FuzzyException {

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

        // TODO: add to set, will need set object as param
    }

    /**
     * This method sets up a common direction variable/set
     * @param theVariable FuzzyVariable.
     * @param object String.
     * @throws FuzzyException
     */
    private void setDir(FuzzyVariable theVariable, String object) throws FuzzyException {

        theVariable = new FuzzyVariable("dir to " + object, "*", RIGHT_TWELVE, LEFT_TWELVE, 2);

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

        // TODO: add to set, will need set object as param
    }

    private void setHead(FuzzyVariable theVariable, String object) throws FuzzyException {

        theVariable = new FuzzyVariable(object + "'s heading", "*", RIGHT_TWELVE, LEFT_TWELVE, 2);


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
