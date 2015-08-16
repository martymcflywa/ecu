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

        final double MIN_SPEED = -15.0;
        final double MAX_SPEED = 15.0;

        // fuzzy variable and sets for speedError
        speedError = new FuzzyVariable("speed error", "m/s", -15.0, 15.0, 2);

        FuzzySet verySlow = new FuzzySet("very slow", MIN_SPEED, MIN_SPEED, 0.5*MIN_SPEED, 0.25*MIN_SPEED);
        FuzzySet slow = new FuzzySet("slow", 0.3*MIN_SPEED, 0.1*MIN_SPEED, 0.0, 0.0);
        FuzzySet medium = new FuzzySet("medium", 0.1*MIN_SPEED, 0.0, 0.0, 0.1*MAX_SPEED);
        FuzzySet fast = new FuzzySet("fast", 0.0, 0.0, 0.1*MAX_SPEED, 0.3*MAX_SPEED);
        FuzzySet veryFast = new FuzzySet("very fast", 0.25*MAX_SPEED, 0.5*MAX_SPEED, MAX_SPEED, MAX_SPEED);

        speedError.add(verySlow);
        speedError.add(slow);
        speedError.add(medium);
        speedError.add(fast);
        speedError.add(veryFast);

        speedError.checkGaps();
        speedError.display();

        // fuzzy variable and sets for acceleration
        acceleration = new FuzzyVariable("acceleration", "m/s", -20.0, 20.0, 2);

        FuzzySet hardReverse = new FuzzySet("hard reverse", -20.0, -20.0, -13.4, -6.7);
        FuzzySet reverse = new FuzzySet("reverse", -13.4, -13.4, -6.7, -3.4);
        FuzzySet slightReverse = new FuzzySet("slight reverse", -5.0, -2.5, -2.5, 0.0);
        FuzzySet neutral = new FuzzySet("neutral", -0.7, -0.7, 0.7, 0.7);
        FuzzySet slightForward = new FuzzySet("slight forward", 0.0, 2.5, 2.5, 5.0);
        FuzzySet forward = new FuzzySet("forward", 3.4, 6.7, 13.4, 13.4);
        FuzzySet hardForward = new FuzzySet("hard forward", 6.7, 13.4, 20.0, 20.0);

        acceleration.add(hardReverse);
        acceleration.add(reverse);
        acceleration.add(slightReverse);
        acceleration.add(neutral);
        acceleration.add(slightForward);
        acceleration.add(forward);
        acceleration.add(hardForward);

        acceleration.checkGaps();
        acceleration.display();

        // fuzzy variable for control
        final double MAX_ACCEL = 7000;
        forceChange = new FuzzyVariable("force", "", -MAX_ACCEL, MAX_ACCEL, 2);

        // define rules
        rules = new SugenoRuleSet();

        FuzzySet[] speedErrorSets = {verySlow, slow, medium, fast, veryFast};
        FuzzySet[] accelerationSets = {hardReverse, reverse, slightReverse, neutral, slightForward, forward, hardForward};

        double[][] forces = {
                {MAX_ACCEL, MAX_ACCEL, 0.5*MAX_ACCEL, 0.25*MAX_ACCEL, 0.0, 0.0, -0.5*MAX_ACCEL},
                {MAX_ACCEL, MAX_ACCEL, 0.35*MAX_ACCEL, 0.125*MAX_ACCEL, -0.125*MAX_ACCEL, -0.5*MAX_ACCEL, -MAX_ACCEL},
                {MAX_ACCEL, MAX_ACCEL, 0.25*MAX_ACCEL, 0.0, -0.25*MAX_ACCEL, -MAX_ACCEL, -MAX_ACCEL},
                {MAX_ACCEL, 0.5*MAX_ACCEL, -0.125*MAX_ACCEL, -0.125*MAX_ACCEL, -0.35*MAX_ACCEL, -MAX_ACCEL, -MAX_ACCEL},
                {0.5*MAX_ACCEL, 0.0, 0.0, -0.25*MAX_ACCEL, -0.5*MAX_ACCEL, -MAX_ACCEL, -MAX_ACCEL}
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
