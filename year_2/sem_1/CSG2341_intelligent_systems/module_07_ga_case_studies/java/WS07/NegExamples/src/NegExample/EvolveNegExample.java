package NegExample;

import au.edu.ecu.is.evolution.*;

import java.util.*;

/**
 * A driver program for the genetic algorithm solution to the first problem in Neg. Ch 7.3
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class EvolveNegExample
{
    public static void main(String[] args)
    {
        EvolveNegExample evolver = new EvolveNegExample();
        
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
               
        NegExampleProblem problem = new NegExampleProblem(PROBLEM);
        
        Object[] constructorParams = 
            {
                random,
                problem,
                new Integer(EvolutionaryAlgorithm.ONEPOINT)
            };
        
        GeneticAlgorithm ga = new GeneticAlgorithm
            (
                NegExampleEvolvable.class,
                constructorParams,
                POP,
                random,
                1.0/problem.getNBits(),
                CROSSOVERPROB,
                new NegExampleEvaluator(problem),
                new GenerationsTerminator(GENERATIONS),
                new StochasticUniformSelector(random),
                //new TournamentSelector(random, 5),
                true
            );
        
        // an added extra - displays all solutions on a graph
        (new PopulationViewer(problem, ga)).display();

        //ga.test();        
        ga.display();
    }
    
    private static final int PROBLEM = 1;   // change to 1 or 2 for different problems
    private static final int GENERATIONS = 200;
    private static final int POP = 10;
    private static final double CROSSOVERPROB = 0.2;
}
