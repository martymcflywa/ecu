package NegExample;

import au.edu.ecu.is.evolution.*;

import java.util.*;
import java.awt.*;

/**
 * A class to represent possible solutions to the first problem in Neg. Ch 7.3
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class NegExampleEvolvable extends BinaryEvolvable
{
    /**
     * Constructor for possible solutions
     * 
     * @param random a random number generator
     * @param problem the problem instance
     * @param crossoverType the crossover type - 1 or 2 point
     */
    public NegExampleEvolvable(Random random, NegExampleProblem problem, Integer crossoverType)
    {
        super(random, problem.getNBits(), crossoverType.intValue());
        
        this.problem = problem;
    }
    
    /**
     * Calculate the value represented by the genome
     * 
     */
    public void develop()
    {
        value = 0;
        
        int pow2 = 1;
        for(int i = 0; i < chromosome.length; i++)
        {
            if(chromosome[chromosome.length-1-i]) value += pow2;
            pow2 *= 2;
        }
    }

    public String toString()
    {
        String result = "";
        for(int i = 0; i < chromosome.length; i++)
        {
            result += chromosome[i]? "1 ": "0 ";
        }

        result += "= " + value;
        
        return result;
    }
    
    /**
     * Access method to get the integer value being represented
     * 
     * @returns the value
     */
    public int getValue()
    {
        return value;
    }
    
    private int value;
    private NegExampleProblem problem;
}
