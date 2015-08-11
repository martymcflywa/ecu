package net.sky.csg2341.ponce.ws03;

import au.edu.ecu.is.fuzzy.*;

/**
 * My solution for a fuzzy cruise controller.
 * Vehicle must hold average speed of 30 m/s.
 * @author Martin Ponce 10371381
 * @version 20150811
 */
public class MyCruiseController implements CruiseController {

    private SugenoRuleSet rules;
    private FuzzyVariable speedError;
    private FuzzyVariable acceleration;
    private FuzzyVariable forceChange;

    public MyCruiseController() throws FuzzyException {

        // fuzzy variable and sets for speedError
        speedError = new FuzzyVariable("speed error", "m/s", -15.0, 15.0, 2);
        FuzzySet verySlow = new FuzzySet("very slow", -15.0, -15.0, -10.0, -5.0);
        FuzzySet slow = new FuzzySet("slow", -10.0, -5.0, -5.0, 0.0);
        FuzzySet medium = new FuzzySet("medium", -5.0, 0.0, 0.0, 5.0);
        FuzzySet fast = new FuzzySet("fast", 0.0, 5.0, 5.0, 10.0);
        FuzzySet veryFast = new FuzzySet("very fast", 5.0, 10.0, 15.0, 15.0);

        speedError.add(verySlow);
        speedError.add(slow);
        speedError.add(medium);
        speedError.add(fast);
        speedError.add(veryFast);

        speedError.checkGaps();
        speedError.display();

        // fuzzy variable and sets for acceleration
        acceleration = new FuzzyVariable("acceleration", "m/s", -20.0, 20.0, 2);
        FuzzySet hardReverse = new FuzzySet("hard reverse", -20.0, -20.0, -13.0, -3.0);
        FuzzySet reverse = new FuzzySet("reverse", -13.0, -3.0, -3.0, 0.0);
        FuzzySet neutral = new FuzzySet("neutral", -3.0, 0.0, 0.0, 3.0);
        FuzzySet forward = new FuzzySet("forward", 0.0, 3.0, 3.0, 13.0);
        FuzzySet hardForward = new FuzzySet("hard forward", 3.0, 13.0, 20.0, 20.0);

        acceleration.add(hardReverse);
        acceleration.add(reverse);
        acceleration.add(neutral);
        acceleration.add(forward);
        acceleration.add(hardForward);

        acceleration.checkGaps();
        acceleration.display();

        // fuzzy variable for control
        final double MAX_FORCE = 7000;
        forceChange = new FuzzyVariable("force", "", -MAX_FORCE, MAX_FORCE, 2);

        // define rules
        rules = new SugenoRuleSet();

        FuzzySet[] speedErrorSets = {verySlow, slow, medium, fast, veryFast};
        FuzzySet[] accelerationSets = {hardReverse, reverse, neutral, forward, hardForward};

        double[][] forces = {
                {7000.0, 7000.0, 5000.0, 3000.0, 1500.0},
                {7000.0, 5000.0, 5000.0, 3000.0, 1000.0},
                {3000.0, 1000.0, 0.0, -1000.0, -3000.0},
                {-1000.0, -1000.0, -1500.0, -5000.0, -7000.0},
                {-1000.0, -1500.0, -3000.0, -7000.0, -7000.0}
        };

        rules.addRuleMatrix(
                speedError, speedErrorSets,
                acceleration, accelerationSets,
                forceChange, forces
        );

        rules.displayRuleMatrix(
                speedError, speedErrorSets,
                acceleration, accelerationSets,
                forceChange
        );
    }

    @Override
    public FuzzyRuleSet getRuleSet() {
        return rules;
    }

    @Override
    public FuzzyVariable getSpeedError() {
        return speedError;
    }

    @Override
    public FuzzyVariable getAcceleration() {
        return acceleration;
    }

    @Override
    public FuzzyVariable getForceChange() {
        return forceChange;
    }

    @Override
    public double computeForceChange(double speedError, double acceleration) {
        try {
            this.speedError.setValue(speedError);
            this.acceleration.setValue(acceleration);
            rules.update();
            return forceChange.getValue();
        } catch(Exception e) {
            e.printStackTrace(System.out);
            return 0.0;
        }
    }
}
