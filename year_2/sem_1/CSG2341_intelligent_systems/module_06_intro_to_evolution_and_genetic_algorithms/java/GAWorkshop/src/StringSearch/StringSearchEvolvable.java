package StringSearch;

import au.edu.ecu.is.evolution.*;
import java.util.Random;

/**
 * An Evolvable object representing a solution for a string search problem
 * 
 * @author phi - Intelligent Systems 2015/2
 */
public class StringSearchEvolvable extends Evolvable
{
    // a guess at the target string
    private String solution;
    // a random number generator
    private Random random;
    
    // the letters that can be used
    private static final String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ abcdefghijklmnopqrstuvwxyz";
    
    /**
     * Construct a random possible solution
     * 
     * @param random - a random number generator to use
     * @param length - a string of this length is required
     */
    public StringSearchEvolvable(Random random, Integer length)
    {
        this.random = random;
        
        solution = "";
        for(int i = 0; i < length; i++)
        {
            solution += randomLetter();
        }

        // breakpoint
//        System.out.println("constructor: " + solution);
    }
    
    /**
     * Constructs a copy of a solution - used in crossover
     * 
     * @param random - a random number generator
     * @param solution - the string to base this solution on
     */
    private StringSearchEvolvable(Random random, String solution)
    {
        this.random = random;
        this.solution = solution;
    }
    
    /**
     * Get a random letter from the legal letters
     * 
     * @return - a random letter 
     */
    private char randomLetter()
    {
        return LETTERS.charAt(random.nextInt(LETTERS.length()));
    }

    /**
     * Get the string represented by this solution
     * 
     * @return - the string 
     */
    public String getString()
    {
        return solution;
    }
    
    /**
     * Create a copy of this solution
     * 
     * @param evlvbl - the solution to copy
     * @throws EvolutionException 
     */
    @Override
    public void copy(Evolvable evlvbl) throws EvolutionException
    {
        StringSearchEvolvable source = (StringSearchEvolvable)evlvbl;
        
        this.random = source.random;
        this.solution = source.solution;
    }

    /**
     * Mutate this solution
     * 
     * @param d - probability of mutation per letter
     * @throws EvolutionException 
     */
    @Override
    public void mutate(double d) throws EvolutionException
    {
        String mutant = "";
        
        for(int i = 0; i < solution.length(); i++)
        {
            if(random.nextDouble() <= d)
            {
                mutant += randomLetter();
            }
            else
            {
                mutant += solution.charAt(i);
            }
        }
        
        solution = mutant;
        // breakpoint
//        System.out.println("mutate: " + solution);
    }

    /**
     * Perform one point crossover with another solution
     * 
     * @param evlvbl - the other solution to cross with
     * @throws EvolutionException 
     */
    @Override
    public void crossover(Evolvable evlvbl) throws EvolutionException
    {
        StringSearchEvolvable other = (StringSearchEvolvable)evlvbl;

        int pt = random.nextInt(solution.length());
        
        String child1 = solution.substring(0,pt) + other.solution.substring(pt, solution.length());
        String child2 = other.solution.substring(0,pt) + solution.substring(pt, solution.length());
        
        solution = child1;
        other.solution = child2;

        // breakpoint
//        System.out.println("crossover 1: " + child1);
//        System.out.println("crossover 2: " + child2);
    }

    /**
     * No need to develop
     * 
     * @throws EvolutionException 
     */
    @Override
    public void develop() throws EvolutionException {
    }
    
    /**
     * Represent as a string
     * 
     * @return the string 
     */
    public String toString()
    {
        return solution;
    }
    
}
