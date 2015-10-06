import au.edu.ecu.is.evolution.*;

import java.util.Random;

/**
 * An example genetic programming application -
 * evolving a controller for a simulated robot
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class EvolveRobot
{
    public static void main(String[] args)
    {
        EvolveRobot evolver = new EvolveRobot();
        
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
               
        Object[] constructorParams = {random};
        
        // create problem instance
        RobotProblem problem = new RobotProblem(SIZE, OBSTACLES, random);
        
        // create a GP algorithm to solve this problem
        GeneticProgrammingAlgorithm gp = new GeneticProgrammingAlgorithm
            (
                random,
                MAXSIZE,
                problem.getFunctions(),
                problem.getReturnType(),
                POP,
                MUTATIONPROB,
                CROSSOVERPROB,
                new RobotEvaluator(problem, NSTEPS, NRUNS), // finds the average number of positions visited in a run
                new GenerationsTerminator(GEN),
                new TournamentSelector(random, 3)
            );

        // create a window for visualising the evolved control programs
        (new RobotViewer(gp, problem, NSTEPS)).display();
        
        // the usual display and control for the GP algorithm
        gp.display();
    }
 
    // problem parameters
    private static final int SIZE = 10;         // the field is size x size
    private static final int OBSTACLES = 25;    // the number of obstacles on the field
    private static final int NSTEPS = 100;      // the number of actions the robot takes in a run
    private static final int NRUNS = 12;        // the number of runs to average over
    
    // algorithm parameters
    private static final int POP = 250;                 // population size
    private static final int GEN = 100;                 // number of generations
    private static final int MAXSIZE = 20;              // maximum number of nodes in the expression trees
    private static final double MUTATIONPROB = 0.6;     // mutation and crossover probabilities
    private static final double CROSSOVERPROB = 0.4;
}
