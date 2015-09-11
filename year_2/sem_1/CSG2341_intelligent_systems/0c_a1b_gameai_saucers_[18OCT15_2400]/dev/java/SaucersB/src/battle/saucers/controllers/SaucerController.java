/*
 * SaucerController.java
 *
 * Created on 17 March 2008, 17:13
 *
 */

package battle.saucers.controllers;

import battle.sensors.SensorData;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author phingsto
 */
public interface SaucerController
{
    public void senseSaucers(ArrayList<SensorData> data) throws Exception;
    
    public void sensePowerUps(ArrayList<SensorData> data) throws Exception;
   
    public void senseBlasts(ArrayList<SensorData> data) throws Exception;

    public void senseEnergy(double energy) throws Exception;
    
    public SensorData getTarget() throws Exception;

    public double getFirePower() throws Exception;
    
    public double getSpeed() throws Exception;
    
    public double getTurn() throws Exception; // in degrees
    
    public boolean getShields() throws Exception;
    
    public String getName();
    
    public Color getBaseColor();
    
    public Color getTurretColor();
}
