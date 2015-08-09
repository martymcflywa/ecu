/*
 * SimpleController.java
 *
 * Created on 17 March 2008, 17:18
 *
 */

package battle.saucers.controllers;

import battle.saucers.*;
import java.awt.Color;

/**
 *
 * @author phingsto
 */
public class SimpleController implements SaucerController
{
    private static final String NAME = "simple";
    private static final Color BASE = Color.blue;
    private static final Color ARROW = Color.red;
    private static final double FIRE_PROB = 0.01;
    private static final double TURN = 3.0;
    private static final double FIRE_POWER = Saucer.MAX_POWER;

    // Declare your FuzzyVariables and rule set here
    // See FuzzyController.java for an example
    
    public SimpleController() throws Exception
    {
        // Create your fuzzy variables and rules here
        // See FuzzyController.java for an example
    }
    
    public void sensorUpdate
        (
            double opponentDistance,
            double opponentDirection,
            double opponentEnergy,
            double energy
         )
    {
    }
    
    // fires full blast at random intervals
    public double getFirePower()
    {
        if(Math.random() < FIRE_PROB)
        {
            return FIRE_POWER;
        }
        else
        {
            return 0.0;
        }
    }
    
    // turns a random amount between -TURN and +TURN degrees each turn
    public double getTurn()
    {
        return Math.random()*2*TURN - TURN;
    }
    
    // goes at 25% above MIN
    public double getSpeed()
    {
        return Saucer.MIN_SPEED+0.25*(Saucer.MAX_SPEED - Saucer.MIN_SPEED);
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
