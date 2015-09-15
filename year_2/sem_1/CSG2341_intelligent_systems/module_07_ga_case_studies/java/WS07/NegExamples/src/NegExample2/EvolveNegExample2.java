package NegExample2;

import au.edu.ecu.is.evolution.*;
import java.util.*;

/**
 * A driver class for a genetic algorithm to solve the second problem fron Neg. Ch 7.3
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class EvolveNegExample2
{
    public static void main(String[] args)
    {
        EvolveNegExample2 evolver = new EvolveNegExample2();
        
        try
        {
            evolver.go();
        }
        catch(Exception e)
        {
            e.printStackTrace(System.out);
        }
    }
    
    public void go() throws EvolutionException
    {
        Random random = new Random();
                       
        Object[] constructorParams = 
            {
                random,
                new Integer(EvolutionaryAlgorithm.ONEPOINT)
            };
        
        GeneticAlgorithm ga = new GeneticAlgorithm
            (
                NegExampleEvolvable2.class,
                constructorParams,
                POP,
                random,
                MUTATIONPROB,
                CROSSOVERPROB,
                new NegExampleEvaluator2(),
                new GenerationsTerminator(GENERATIONS),
                //new RouletteWheelSelector(random),
                new StochasticUniformSelector(random),
                true//false
            );
        
        //ga.test();
        
        ga.display();
    }
    
    private static final int GENERATIONS = 200;
    private static final int POP = 50;
    private static final double CROSSOVERPROB = 0.7;
    private static final double MUTATIONPROB = 0.03;
}
