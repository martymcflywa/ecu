package NegExample2;

import au.edu.ecu.is.evolution.*;

/**
 * A class to evaluate possible solutions for the second problem in Neg. Ch 7.3
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class NegExampleEvaluator2 extends Evaluator
{
    public double evaluate(Evolvable evolvable)
    {
        NegExampleEvolvable2 example = (NegExampleEvolvable2)evolvable;
        
        double x = example.getX();
        double y = example.getY();
        
        return NegExampleProblem2.evaluate(x, y);
    }
}
