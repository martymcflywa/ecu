import java.util.*;

/**
 * Bare bones of a class for trying out solutions to the mystery problem.
 * 
 * @author phi 
 * @version 2004/2
 */
public class MysteryTester
{
    // main method just creates an instance and calls its go() method
    public static void main(String[] args) throws Exception
    {
        MysteryTester tester = new MysteryTester();
        
        tester.go();
    }
    
    // example method that tries out a possible solution to the Mystery problem
    // solutions must be an integer array containing the integers 0..24 in any order
    // the method prints out the cost of the solution
    public void go() throws Exception
    {
        Mystery mystery = new Mystery();
        
        // first solution to try
        int solution[] = new int[]
            {
                0, 1, 2, 3, 4,
                5, 6, 7, 8, 9,
                10, 11, 12, 13, 14,
                15, 16, 17, 18, 19,
                20, 21, 22, 23, 24
            };
            
        try
        {
            Random random = new Random();
            int tries = 0;
            double best = 1E6;
            // try TRIES random solutions
            do
            {
                double cost = mystery.evaluate(solution);
                // report when a better solution is found
                if(cost < best)
                {
                    System.out.println("The cost of solution < " + solutionString(solution) + " > is " + cost);
                    best = cost;
                }
                // scramble the current solution
                for(int i = 0; i < solution.length; i++)
                {
                    int index = random.nextInt(solution.length-i);
                    int swap = solution[solution.length-i-1];
                    solution[solution.length-i-1] = solution[index];
                    solution[index] = swap;
                }
                tries++;
            } while(tries < TRIES);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    
    public String solutionString(int[] solution)
    {
        String result = "";
        
        for(int i = 0; i < solution.length; i++)
        {
            result += solution[i];
            if(i < solution.length-1) result += ", ";
        }
        
        return result;
    }

    static private final int TRIES = 100;
}
