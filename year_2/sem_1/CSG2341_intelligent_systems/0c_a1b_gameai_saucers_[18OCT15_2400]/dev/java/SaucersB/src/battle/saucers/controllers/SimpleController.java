/*
 * SimpleController.java
 *
 * Created on 17 March 2008, 17:18
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
 * 
 * SimpleController
 *  - cruises at a moderate speed
 *  - tries to dodge close photon blasts (also uses shields if has lots of energy)
 *  - otherwise always tries to get to the closest power-up at max speed
 *  - fires 1% of the time, always at closest enemy
 *  - if there is no power-up or nearby photon blast, turns random amounts at random intervals
 * 
 */
public class SimpleController implements SaucerController, Constants
{
    private static final String NAME = "simple";
    private static final Color BASE = Color.blue;
    private static final Color ARROW = Color.red;
    private static final double FIRE_PROB = 0.01;
    private static final double TURN = 3.0;
    private static final double FIRE_POWER = SAUCER_MAX_POWER;
    private static final int TIME_BETWEEN_TURNS = 30;
    
    private SensorData target;
    private SensorData nearestBlast;
    private double energy;
    private boolean dodgeBlast = false;
    private boolean powerUpOn;
    private double nearestPowerUpDirection;
    private double timeUntilNextTurn = TIME_BETWEEN_TURNS;

    // Declare your FuzzyVariables and rule set(s) here
    
    public SimpleController() 
    {
        // Create your FuzzyVariables and rule set(s) here
    }
        
    public void senseSaucers(ArrayList<SensorData> data) 
    {
        // This is where you get told about enemies
        // save whatever information you need in suitable member variables
        
        // find the closest enemy to target - this will be used later in getTarget()
        if(data.size() > 0)
        {
            double closest = data.get(0).distance;
            target = data.get(0);
            for(SensorData thisData: data)
            {
                if(thisData.distance < closest)
                {
                    target = thisData;
                    closest = thisData.distance;
                }
            }
        }
        else
        {
            target = null;
        }
    }

    public void sensePowerUps(ArrayList<SensorData> data) 
    {
        // This is where you get told about power-ups
        // save whatever information you need in suitable member variables
        
        // find the closest powerUp
        powerUpOn = data.size() > 0;
        if(powerUpOn)
        {
            double closest = data.get(0).distance;
            nearestPowerUpDirection = data.get(0).direction;
            for(SensorData thisData: data)
            {
                if(thisData.distance < closest)
                {
                    nearestPowerUpDirection = thisData.direction;
                    closest = thisData.distance;
                }
            }
        }
    }

     public void senseBlasts(ArrayList<SensorData> data) 
    {
        // This is where you get told about photon blasts
        // save whatever information you need in suitable member variables
        
        // find the closest blast
        if(data.size() > 0)
        {
            double closest = data.get(0).distance;
            nearestBlast = data.get(0);
            for(SensorData thisData: data)
            {
                if(thisData.distance < closest)
                {
                    nearestBlast = thisData;
                    closest = thisData.distance;
                }
            }
            
            dodgeBlast = closest < STARFIELD_WIDTH/10;            
        }
        else
        {
            nearestBlast = null;
            dodgeBlast = false;
        }
    }
     
    public void senseEnergy(double energy)
    {
        // This is where you get told what your own energy level is
        // Save this information if you need it
        
       this.energy = energy;
    }
    
    // methods below determine what your saucer does

    // fires at random intervals
    public SensorData getTarget() 
    {        
        if(Math.random() < FIRE_PROB)
        {
            return target;
        }
        else
        {
            return null;
        }
    }

    // always uses max power if it fires
    public double getFirePower()
    {
        return FIRE_POWER;
    }
    
    // turns a random amount between -3 and +3 degrees each turn
    // or heads for the nearest powerUp
    public double getTurn()
    {
        if(dodgeBlast)
        {
            timeUntilNextTurn = TIME_BETWEEN_TURNS;
            return this.nearestBlast.direction + 135; // run away at an angle
        }
        else if(powerUpOn) // go for the power up !!
        {
            timeUntilNextTurn = TIME_BETWEEN_TURNS;
            return nearestPowerUpDirection;
        }
        else
        {
            timeUntilNextTurn--;
            if(timeUntilNextTurn == 0)
            {
                timeUntilNextTurn = TIME_BETWEEN_TURNS;
                double deviation = Math.random()*2*TURN - TURN;
                return deviation;
            }
            else
            {
                return 0.0;
            }
        }
    }
    
    public double getSpeed()
    {
        if(powerUpOn)
        {
            return SAUCER_MAX_SPEED;
        }
        else
        {
            return SAUCER_MIN_SPEED+0.25*(SAUCER_MAX_SPEED-SAUCER_MIN_SPEED);
        }
    }
    
    public boolean getShields()
    {
        return dodgeBlast && energy > SAUCER_START_ENERGY/2;
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
