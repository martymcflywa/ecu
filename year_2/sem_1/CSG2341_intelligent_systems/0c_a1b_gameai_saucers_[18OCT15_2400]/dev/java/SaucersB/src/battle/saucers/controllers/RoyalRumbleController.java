package battle.saucers.controllers;

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

    @Override
    public void senseSaucers(ArrayList<SensorData> data) throws Exception {

    }

    @Override
    public void sensePowerUps(ArrayList<SensorData> data) throws Exception {

    }

    @Override
    public void senseBlasts(ArrayList<SensorData> data) throws Exception {

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
