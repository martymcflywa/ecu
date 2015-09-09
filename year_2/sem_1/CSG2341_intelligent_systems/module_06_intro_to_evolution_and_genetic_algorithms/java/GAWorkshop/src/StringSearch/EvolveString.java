package StringSearch;

import au.edu.ecu.is.evolution.*;
import java.util.*;

/**
 * A driver program for the genetic algorithm solution to a string search problem
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class EvolveString
{
    private static final int POP = 10;
    private static final double MUTATION_FACTOR = 0.5;
    private static final double CROSSOVER_PROB = 0.8;
    
    public static void main(String[] args)
    {
        EvolveString evolver = new EvolveString();
        StringSearchProblem problem = new StringSearchProblem("Hail to thee blithe spirit");
        String target = problem.getTarget();
       
        try
        {            
            evolver.go(problem, MUTATION_FACTOR/target.length(), CROSSOVER_PROB);
        }
        catch(Exception e)
        {
            e.printStackTrace(System.out);
        }
    }
    
    public void go(StringSearchProblem problem, double mutationProb, double crossoverProb) throws EvolutionException
    {
        Random random = new Random();
        
        Object[] constructorParams = 
            {
                random,
                new Integer(problem.getTarget().length())
            };
        
        StringSearchEvaluator eval = new StringSearchEvaluator(problem);
        
        GeneticAlgorithm ga = new GeneticAlgorithm
            (
                StringSearchEvolvable.class, // this is the class that represents a genome
                constructorParams, // these are used to construct genomes (passed to the constructor)
                POP, // population size
                random, // a random number generator to use
                mutationProb, // probability of mutating a gene
                crossoverProb, // probability of crossing two parents
                eval, // the fitness function
                new FitnessTerminator(eval.maxFitness()), // the termination critereon
                new StochasticUniformSelector(random), // the selector
                true // whether to use elitism : true for yes, false for no
            );

        // uncomment the line below to test out mutation and crossover operations
        ga.test();
        
        // uncomment the line below to run the GA via the GUI interface
        //ga.display();
        
        // uncomment to measure average number of generations
        //double total = 0;
        //for(int i = 0; i < 30; i++)
        //{
        //    ga.run();
        //    total += ga.getGeneration();
        //}
        //
        //
        //System.out.println("Mean number of probes = " + POP*total/30);        
    }
}
