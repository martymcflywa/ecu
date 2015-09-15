package NegExample2;

import au.edu.ecu.is.evolution.*;
import java.util.*;

/**
 * A class representing solutions for the second problem in Neg. Ch 7.3
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class NegExampleEvolvable2 extends BinaryEvolvable
{
    // it would be neater to pass a problem instance as a parameter
    // a few corners cut here!
    public NegExampleEvolvable2(Random random, Integer crossoverType)
    {
        super(random, NegExampleProblem2.nBits*NegExampleProblem2.nVars, crossoverType.intValue());        
    }
    
    // convert the binary array into a real number pair as on p226 of Negnevistky
    public void develop()
    {
        int pow2;
        
        x = 0;
        
        pow2 = 1;
        for(int i = 0; i < NegExampleProblem2.nBits; i++)
        {
            if(chromosome[NegExampleProblem2.nBits-1-i]) x += pow2;
            pow2 *= 2;
        }
        x = NegExampleProblem2.minX + x*(NegExampleProblem2.maxX - NegExampleProblem2.minX)/NegExampleProblem2.range;
        
        y = 0;
        pow2 = 1;
        for(int i = 0; i < NegExampleProblem2.nBits; i++)
        {
            if(chromosome[NegExampleProblem2.nBits+NegExampleProblem2.nBits-1-i]) y += pow2;
            pow2 *= 2;
        }
        y = NegExampleProblem2.minY + y*(NegExampleProblem2.maxY - NegExampleProblem2.minY)/NegExampleProblem2.range;
    }

    // a textual description, so we can understand the answer!!
    public String toString()
    {
        String result = "";
        for(int i = 0; i < chromosome.length; i++)
        {
            result += chromosome[i]? "1 ": "0 ";
            if(i == NegExampleProblem2.nBits-1) result += " | ";
        }
        result += "= " + x + " | " + y;
        
        return result;
    }
        
    // access methods used by the evaluator
    public double getX()
    {
        return x;
    }
    
    public double getY()
    {
        return y;
    }
    
    private double x;
    private double y;
}
