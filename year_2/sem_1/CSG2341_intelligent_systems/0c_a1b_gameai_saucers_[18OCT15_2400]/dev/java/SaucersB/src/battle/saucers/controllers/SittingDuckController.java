/*
 * SittingDuckController.java
 *
 * Created on 20 April 2008, 21:10
 *
 */

package battle.saucers.controllers;

import battle.Constants;
import battle.sensors.SensorData;
import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author phingsto
 */
public class SittingDuckController implements SaucerController, Constants
{
    private static final String NAME = "sitting duck";
    private static final Color BASE = Color.green;
    private static final Color ARROW = Color.yellow;
    
    public SittingDuckController() 
    {
    }
        
    // doesn't take any notice of sensors
    public void senseSaucers(ArrayList<SensorData> data)
    {
    }

    public void sensePowerUps(ArrayList<SensorData> data) 
    {
    }
    
     public void senseBlasts(ArrayList<SensorData> data) 
    {
    }
     
    public void senseEnergy(double energy) 
    {
    }

    // doesn't shoot
    public SensorData getTarget() 
    {        
        return null;
    }
    public double getFirePower()
    {
        return 0;
    }
    
    // doesn't turn
    public double getTurn()
    {
        return 0;
    }
    
    // doesn't speed
    public double getSpeed()
    {
        return SAUCER_MIN_SPEED;
    }
    
    // doesn't use shields
    public boolean getShields()
    {
        return false;
    }
    
    public String getName()
    {
        return NAME;
    }
    
    public Color getBaseColor()
    {
        return BASE;
    }
    
    public Color getTurretColor()
    {
        return ARROW;
    }
}
