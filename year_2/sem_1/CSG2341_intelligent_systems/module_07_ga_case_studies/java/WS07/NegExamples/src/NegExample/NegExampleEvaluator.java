package NegExample;

import au.edu.ecu.is.evolution.*;

/**
 * A class to evaluate possible solutions for the first problem in Neg. Ch 7.3
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class NegExampleEvaluator extends Evaluator
{
    /**
     * Constructor for the evaluator
     * 
     * @param problem the problem instance to solve
     */
    public NegExampleEvaluator(NegExampleProblem problem)
    {
        this.problem = problem;
    }
    
    /**
     * Calculate the fitness values for a possible solution.
     * 
     * @param evolvable a possible solution
     */
    public double evaluate(Evolvable evolvable)
    {
        NegExampleEvolvable example = (NegExampleEvolvable)evolvable;
        
        int value = example.getValue();
        
        return problem.evaluate(value);
    }
    
    private NegExampleProblem problem;
}
