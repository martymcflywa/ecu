package NegExample;

/**
 * A class representing the first example problem in Negnevitsky Ch 7.3
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class NegExampleProblem
{
    /**
     * Constructor for a problem similar to the first example.
     * Since that example is a bit boring, a parameter has been added
     * so that different problems of a similar type can be added.
     * 
     * @param number the problem number
     */
    public NegExampleProblem(int number)
    {
        this.number = number;
    }
    
    /**
     * Find the value of the function being maximised at the given "x" value
     * 
     * @param arg the "x" value
     * 
     */
    public double evaluate(int arg)
    {
        double result;
        
        if(number == 0)
        {
            result = 15*arg - arg*arg;
        }
        else if(number == 1)
        {
            result = Math.sin(arg/10000.0);
        }
        else if(number == 2)
        {
            result = 100*arg - arg*arg + 10*arg*arg*arg;
        }
        else
        {
            result = 0.0;
        }
        
        return result > 0.0? result: 0.0;
    }
    
    /**
     * Get the number of bits to use to represent solutions
     * 
     */
    public int getNBits()
    {
        if(number == 0)
        {
            return 4;
        }
        else if(number == 1)
        {
            return 16;
        }
        else if(number == 2)
        {
            return 8;
        }
        else
        {
            return 1;
        }
    }
    
    private int number;
}
