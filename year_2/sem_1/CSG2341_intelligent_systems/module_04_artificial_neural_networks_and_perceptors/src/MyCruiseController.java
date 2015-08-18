import au.edu.ecu.is.fuzzy.*;

/**
* Example solution for a fuzzy controller for cruise control.
 * 
 * Other solutions (maybe simpler and better) are possible
 * 
 * @author phi 
 * @version 1
 */
public class MyCruiseController implements CruiseController
{
    public MyCruiseController() throws FuzzyException
    {
        // create fuzzy variable for speed error
        final double maxSpeedError = TARGET_SPEED;   // something has gone wrong if the error is larger than this
        final double speedRamp1 = 0.1*maxSpeedError;
        final double speedRamp2 = 0.03*maxSpeedError;
        final double speedRamp3 = 0.015*maxSpeedError;
        speedError = new FuzzyVariable("speed error", "m/s", -maxSpeedError, maxSpeedError, 2);
        FuzzySet tooSlow = new FuzzySet("too slow", -maxSpeedError, -maxSpeedError, -speedRamp1, -speedRamp3);
        FuzzySet speedOK = new FuzzySet("OK", -speedRamp2, 0.0, 0.0, speedRamp2);
        FuzzySet tooFast = new FuzzySet("too fast", speedRamp3, speedRamp1, maxSpeedError, maxSpeedError);
        speedError.add(tooSlow);
        speedError.add(speedOK);
        speedError.add(tooFast);
        
        // create fuzzy variable for acceleration
        final double accRamp1 = 0.1*MAX_ACC;
        final double accRamp2 = 0.03*MAX_ACC;
        final double accRamp3 = 0.015*MAX_ACC;
        acceleration = new FuzzyVariable("acceleration", "m/s2", -MAX_ACC, MAX_ACC, 2);
        FuzzySet slowingDown = new FuzzySet("slowing down", -MAX_ACC, -MAX_ACC, -accRamp1, -accRamp3);
        FuzzySet constantSpeed = new FuzzySet("constant speed", -accRamp2, 0.0, 0.0, accRamp2);
        FuzzySet speedingUp = new FuzzySet("speeding up", accRamp3, accRamp1, MAX_ACC, MAX_ACC);
        acceleration.add(slowingDown);
        acceleration.add(constantSpeed);
        acceleration.add(speedingUp);

        // create fuzzy variable for force change
        final int NSTEPS = 3;
        forceChange = new FuzzyVariable("force change", "n", -MAX_FORCE, MAX_FORCE, 2);
                
        // now construct a matrix of fuzzy sugeno-type rules
        rules = new SugenoRuleSet();
        
        FuzzySet[] speedSets = {tooSlow, speedOK, tooFast};
        FuzzySet[] accSets = {slowingDown, constantSpeed, speedingUp};
        
        double[][] forceChanges =
            {
                {MAX_FORCE/NSTEPS, MAX_FORCE/NSTEPS, 0.0},
                {MAX_FORCE/(2*NSTEPS), 0.0, -MAX_FORCE/(2*NSTEPS)},
                {0.0, -MAX_FORCE/NSTEPS, -MAX_FORCE/NSTEPS}
            };
       
       rules.addRuleMatrix(
            speedError, speedSets,
            acceleration, accSets,
            forceChange, forceChanges);            
    }
    
    public FuzzyRuleSet getRuleSet()
    {
        return rules;
    }

    public FuzzyVariable getSpeedError()
    {
        return speedError;
    }
    
    public FuzzyVariable getAcceleration()
    {
        return acceleration;
    }
    
    public FuzzyVariable getForceChange()
    {
        return forceChange;
    }
    
    public double computeForceChange(double speedError, double acceleration)
    {
        try
        {
            this.speedError.setValue(speedError);
            this.acceleration.setValue(acceleration);
            
            rules.update();
            
            return forceChange.getValue();
        }
        catch (Exception e)
        {
            e.printStackTrace(System.out);
            return 0.0;
        }
    }
    
    private SugenoRuleSet rules;
    private FuzzyVariable speedError;
    private FuzzyVariable acceleration;
    private FuzzyVariable forceChange;
    
    private double TARGET_SPEED = 15.0;
    private double MAX_ACC = 20.0;
    private double MAX_FORCE = 7000.0;
}
