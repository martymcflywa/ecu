package StringSearch;

import au.edu.ecu.is.evolution.Evaluator;
import au.edu.ecu.is.evolution.Evolvable;

/**
 * Fitness calculation for a possible solution to a string search problem
 * 
 * @author phi - Intelligent Systems 2015/2
 */
public class StringSearchEvaluator extends Evaluator
{
    // The problem that is being solved
    private StringSearchProblem problem;
    
    /**
     * Construct an evaluator for a string search problem
     * 
     * @param problem - the problem 
     */
    public StringSearchEvaluator(StringSearchProblem problem)
    {
        this.problem = problem;
    }

    /**
     * Calculate the fitness of a potential solution
     * 
     * @param evlvbl - the solution
     * @return - the fitness
     */
    @Override
    public double evaluate(Evolvable evlvbl)
    {
        StringSearchEvolvable sse = (StringSearchEvolvable)evlvbl;
        
        double matches = 1;
        
        String target = problem.getTarget();
        String solution = sse.getString();
        for(int i = 0; i < target.length(); i++)
        {
            if(solution.charAt(i) == target.charAt(i)) matches++;
        }
        
        return matches;
    }
    
    /**
     * Get the max possible fitness for this problem (i.e. for a perfect match)
     * 
     * @return - fitness of a perfect match 
     */
    public double maxFitness()
    {
        double length = problem.getTarget().length();
        
        return (1+length);
    }
}
