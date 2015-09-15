/*
 * TestCase.java
 *
 * This class describes an instance of the Tartarus problem -
 * i.e. an arrangement of blocks and initial position and orientation for the dozer.
 *
 * It also provides methods for testing dozer plans.
 *
 * Created on 27 July 2006, 15:32
 *
 */

/**
 *
 * @author phingsto
 */
public class TestCase
{
    // this array describes the initial board position
    private int[][] position;
    
    // these are used when evaluating a plan
    private DozerPlan bestPlan;
    private int bestMoves;
    private int bestScore;
    private DozerPlan plan;
    private int moves;
    private int score;
    
    private static final int[][] pos1 = 
    {
        {0,0,0,0,0,0},
        {0,0,1,0,0,0}, // 0's are empty squares: 1's are blocks
        {0,1,5,0,1,0}, // 3,4,5,6 are dozers facing in different directions
        {0,0,0,0,1,0},
        {0,0,1,1,0,0},
        {0,0,0,0,0,0}
    };

    private static final int[][] pos2 = 
    {
        {0,0,0,0,0,0},
        {0,0,0,1,1,0},
        {0,0,0,1,0,0},
        {0,1,1,6,0,0},
        {0,1,0,0,0,0},
        {0,0,0,0,0,0}        
    };
    
    private static final int[][] pos3 = 
    {
        {0,0,0,0,0,0},
        {0,0,1,6,0,0},
        {0,1,0,0,1,0},
        {0,1,0,1,0,0},
        {0,0,0,0,1,0},
        {0,0,0,0,0,0}
    };
    
    // some example test cases
    private static final TestCase[] cases =
    {
          new TestCase(pos1),
          new TestCase(pos2),
          new TestCase(pos3)
    };

    /** Creates a new instance of TestCase */
    public TestCase(int[][] position)
    {
        this.position = position;
        bestPlan = new DozerPlan();
        bestMoves = 0;
        bestScore = 0;
        plan = new DozerPlan();
        moves = 0;
        score = 0;
    }
    
    public static TestCase[] getCases()
    {
        return cases;
    }
    
    public void reload()
    {
        plan = new DozerPlan();
        moves = 0;
        score = 0;
    }

    public void move(DozerMove aMove, int score)
    {
        plan.move(aMove);
        moves++;
        this.score = score;
        
        if(calcTotal(moves, score) > calcTotal(bestMoves, bestScore))
        {
            bestPlan = plan.clone();
            bestMoves = moves;
            bestScore = score;
        }
    }
    
    public int[][] getPosition()
    {
        return position;
    }
    
    public DozerPlan getBestPlan()
    {
        return bestPlan;
    }
    
    public int getBestMoves()
    {
        return bestMoves;
    }
    
    public int getBestScore()
    {
        return bestScore;
    }
    
    public double getBestTotal()
    {
        return calcTotal(bestMoves, bestScore);
    }

    public int getMoves()
    {
        return moves;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public double getTotal()
    {
        return calcTotal(moves, score);
    }
    
    // This function is used to determine the "fitness" of a plan
    // The values of move and score are calculated while testing the plan
    // (see the method "evaluate" in Main.java)
    private static double calcTotal(int moves, int score)
    {
        return score-moves/7.0;
    }
}
