package net.sky.csg2341.ponce.ws03;

import au.edu.ecu.is.fuzzy.*;

/**
 * Interface for a cruise controller
 *
 * @author phi
 * @version 1
 */
public interface CruiseController {
    public FuzzyRuleSet getRuleSet();

    public FuzzyVariable getSpeedError();

    public FuzzyVariable getAcceleration();

    public FuzzyVariable getForceChange();

    public double computeForceChange(double speedError, double acceleration);
}