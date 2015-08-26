package battle.saucers.controllers;

import au.edu.ecu.is.fuzzy.*;
import battle.Constants;
import battle.saucers.Saucer;
import java.awt.Color;
import java.util.Random;

/**
 * A simple controller that uses a little bit of fuzzy reasoning
 * @author phingsto
 */
public class FuzzyController implements SaucerController
{
    // This will be the rule set
    private SugenoRuleSet rules;
    
    // These will be the input variables
    private FuzzyVariable distance;
    private FuzzyVariable energyDifference;
    private FuzzyVariable firePower;
    
    private static final Random random = new Random();
    private static final String NAME = "fuzzy";
    private static final Color BASE = Color.gray;
    private static final Color ARROW = Color.cyan;
    private static final double FIRE_PROB = 0.01;
    private static final double TURN = 3.0;
    
    public FuzzyController() throws FuzzyException
    {
        // create fuzzy variable for distance
        final double maxDistance =
                Math.sqrt(Constants.STARFIELD_WIDTH*Constants.STARFIELD_WIDTH+
                    Constants.STARFIELD_HEIGHT*Constants.STARFIELD_HEIGHT);
        final double distRamp1 = 0.05*maxDistance;
        final double distRamp2 = 0.2*maxDistance;
        distance = new FuzzyVariable("distance to target", "m", 0.0, maxDistance, 2);
        FuzzySet close = new FuzzySet("close", 0.0, 0.0, distRamp1, distRamp2);
        FuzzySet far = new FuzzySet("far", distRamp1, distRamp2, maxDistance, maxDistance);
        distance.add(close);
        distance.add(far);
        
        // create fuzzy variable for energy difference
        final double maxDiff = Saucer.START_ENERGY;
        final double minDiff = -maxDiff;
        final double diffRamp1 = 0.1*maxDiff;
        final double diffRamp2 = 0.2*maxDiff;
        final double diffRamp3 = -0.2*maxDiff;
        final double diffRamp4 = -0.1*maxDiff;
        energyDifference = new FuzzyVariable("energy difference", "J", minDiff, maxDiff, 2);
        FuzzySet losing = new FuzzySet("losing", minDiff, minDiff, diffRamp3, diffRamp4);
        FuzzySet even = new FuzzySet("even", diffRamp3, 0.0, 0.0, diffRamp2);
        FuzzySet winning = new FuzzySet("winning", diffRamp1, diffRamp2, maxDiff, maxDiff);
        energyDifference.add(losing);
        energyDifference.add(even);
        energyDifference.add(winning);
        
        // create fuzzy variable for fire power
        final double maxPower = Saucer.MAX_POWER;
        final double midPower = maxPower/5.0;
        final double lowPower = maxPower/20.0;
        firePower = new FuzzyVariable("fire power", "J", -maxPower, maxPower, 2);
        
        // now construct a matrix of fuzzy sugeno-type rules
        rules = new SugenoRuleSet();
        
        FuzzySet[] distanceSets = {close, far};
        FuzzySet[] diffSets = {losing, even, winning};
        
        double[][] firePowerLevels =
        {
            // losing   even     winning
            {lowPower, midPower, midPower}, // close
            {0.0,      0.0,      maxPower}  // far
        };
        
        rules.addRuleMatrix(
                distance, distanceSets,
                energyDifference, diffSets,
                firePower, firePowerLevels);

        // use "pause" to see which rules are firing etc
        // comment this out this when not needed
//        rules.displayRuleMatrix(
//                distance, distanceSets,
//                energyDifference, diffSets,
//                firePower);
    }
       
    // Here is where the sensor data comes in
    public void sensorUpdate
            (
            double opponentDistance,
            double opponentDirection,
            double opponentEnergy,
            double energy
            ) throws FuzzyException
    {
        // clear out previous values
        rules.clearVariables();
        
        // Set fuzzy input variable values
        distance.setValue(opponentDistance);
        energyDifference.setValue(energy-opponentEnergy);
        
        // fire rules to compute power
        rules.update();
    }
    
    public double getFirePower() throws Exception
    {
        return firePower.getValue();
    }
    
    public double getTurn()
    {
        // Replace the code in this block with something fuzzy
        // that uses the values of your fuzzy output variables

        return Math.random()*2*TURN - TURN;

    }
    
    public double getSpeed()
    {
        // Replace the code in this block with something fuzzy
        // that uses the values of your fuzzy output variables
        
        return Saucer.MIN_SPEED+0.25*(Saucer.MIN_SPEED+Saucer.MAX_SPEED);
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