import au.edu.ecu.is.fuzzy.*;

/**
 * A fuzzy pendulum controller
 *
 * @author (phi)
 * @version (2006/2)
 */
public class MyPendulumControllerCompleted implements PendulumController
{
    public MyPendulumControllerCompleted() throws FuzzyException
    {
        // create fuzzy variable for pendulum angle
        theta = new FuzzyVariable("theta", "radians", -90.0, 90.0, 2);
        FuzzySet hardLeft = new FuzzySet("hard left", -90.0, -90.0, -60.0, -30.0);
        FuzzySet left = new FuzzySet("left", -60.0, -60.0, -30.0, -15.0);
        FuzzySet slightlyLeft = new FuzzySet("slightly left", -15.0, -8.0, -8.0, 0.0);
        FuzzySet straight = new FuzzySet("straight", -3.0, -3.0, 3.0, 3.0);
        FuzzySet slightlyRight = new FuzzySet("slightly right", 0.0, 8.0, 8.0, 15.0);
        FuzzySet right = new FuzzySet("right", 15.0, 30.0, 60.0, 60.0);
        FuzzySet hardRight = new FuzzySet("hard right", 30.0, 60.0, 90.0, 90.0);
        theta.add(hardLeft);
        theta.add(left);
        theta.add(slightlyLeft);
        theta.add(straight);
        theta.add(slightlyRight);
        theta.add(right);
        theta.add(hardRight);
        theta.checkGaps();
        
        // and one for the rate of change of the angle
        double maxLeft = -2500.0;
        double maxRight = 2500.0;
        dtheta = new FuzzyVariable("dtheta", "radians/sec", maxLeft, maxRight, 2);
        FuzzySet fastLeft = new FuzzySet("fast left", maxLeft, maxLeft, 0.5*maxLeft, 0.25*maxLeft);
        FuzzySet slowLeft = new FuzzySet("slow left", 0.3*maxLeft, 0.1*maxLeft, 0.0, 0.0);
        FuzzySet still = new FuzzySet("still", 0.1*maxLeft, 0.0, 0.0, 0.1*maxRight);
        FuzzySet slowRight = new FuzzySet("slow right", 0.0, 0.0, 0.1*maxRight, 0.3*maxRight);
        FuzzySet fastRight = new FuzzySet("fast right", 0.25*maxRight, 0.5*maxRight, maxRight, maxRight);
        dtheta.add(fastLeft);
        dtheta.add(slowLeft);
        dtheta.add(still);
        dtheta.add(slowRight);
        dtheta.add(fastRight);
        dtheta.checkGaps();
        
        // and create a fuzzy variable to represent the control variable - force to apply
        final double MAX = 1.5;
        force = new FuzzyVariable("force", "newtons", -MAX, MAX, 2);
        
        // now construct a matrix of fuzzy sugeno-type rules
        rules = new SugenoRuleSet();
        
        FuzzySet[] dthetaSets = {fastLeft, slowLeft, still, slowRight, fastRight};
        FuzzySet[] thetaSets = {hardLeft, left, slightlyLeft, straight, slightlyRight, right, hardRight};
        
        double[][] forces =
        {
            {-MAX,      -MAX,     -0.5*MAX,  -0.25*MAX,    0.0,        0.0,     0.05*MAX},
            {-MAX,      -MAX,     -0.25*MAX, -0.125*MAX,   0.0,        0.5*MAX, MAX},
            {-MAX,      -MAX,     -0.25*MAX, 0.0,          0.25*MAX,   MAX,     MAX},
            {-MAX,      -0.5*MAX, 0.0,       0.125*MAX,    0.25*MAX,   MAX,     MAX},
            {-0.05*MAX,  0.0,     0.0,       0.25*MAX,     0.5*MAX,    MAX,     MAX}
        };
        
        rules.addRuleMatrix(
                dtheta, dthetaSets,
                theta, thetaSets,
                force, forces);
    }
    
    // access methods for the fuzzy objects
    
    public FuzzyRuleSet getRuleSet()
    {
        return rules;
    }
    
    public FuzzyVariable getTheta()
    {
        return theta;
    }
    
    public FuzzyVariable getDtheta()
    {
        return dtheta;
    }
    
    public FuzzyVariable getForce()
    {
        return force;
    }

    // and a method to compute the right force to apply
    public double computeForce(double theta, double dtheta)
    {
        try
        {
            this.theta.setValue(theta);
            this.dtheta.setValue(dtheta);
            
            rules.update();
            
            return force.getValue();
        }
        catch(FuzzyException e)
        {
            System.out.println(e.getMessage());
            return 0.0;
        }
    }
    
    private SugenoRuleSet rules;
    private FuzzyVariable theta;
    private FuzzyVariable dtheta;
    private FuzzyVariable force;
}
