import au.edu.ecu.is.evolution.*;

import java.awt.*;
import javax.swing.*;

/**
 * A class to evaluate robots
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class RobotEvaluator extends Evaluator
{
    public RobotEvaluator(RobotProblem problem, int nSteps, int nRuns)
    {
        this.problem = problem;
        this.nSteps = nSteps;
        this.nRuns = nRuns;
    }
        
    public double evaluate(Evolvable evolvable)
    {
        EvolvableExpressionTree tree = (EvolvableExpressionTree)evolvable;
        Robot robot = problem.getRobot();
        int total = 0;
        
        for(int r = 0; r < nRuns; r++)
        {
            robot.initialise();
            
            for(int i = 0; i < nSteps; i++)
            {
                RobotAction action = (RobotAction)tree.evaluate();
                
                robot.doAction(action);
            }
            
            total += robot.getNVisited();
        }
        
        return total/(double)nRuns;
    }

    private RobotProblem problem;    
    private int nSteps;
    private int nRuns;
}
