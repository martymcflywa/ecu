import au.edu.ecu.is.fuzzy.*;

/**
 * Write a description of class PendulumController here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public interface PendulumController
{
    public FuzzyRuleSet getRuleSet();

    public FuzzyVariable getTheta();
    
    public FuzzyVariable getDtheta();
    
    public FuzzyVariable getForce();
    
    public double computeForce(double theta, double dtheta);
}
