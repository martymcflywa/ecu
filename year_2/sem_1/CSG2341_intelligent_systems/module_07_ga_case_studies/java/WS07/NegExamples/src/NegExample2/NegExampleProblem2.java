package NegExample2;

/**
 * A class representing the second problem from Neg Ch 7.3
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class NegExampleProblem2
{
    public static double evaluate(double x, double y)
    {
        double result = (1 - x)*(1 - x)*Math.exp(-x*x-(y + 1)*(y + 1))
            -(x - x*x*x - y*y*y)*Math.exp(-x*x-y*y) + Math.sin(x-3)*Math.cos(y-x);

        return result > 0.0? result: 0.0;
    }
    
    public static final int nVars = 2;
    public static final int nBits = 16;
    public static final double range = Math.pow(2, nBits) - 1;
    public static final double minX = -10;
    public static final double maxX = 10;
    public static final double minY = -3;
    public static final double maxY = 3;
}
