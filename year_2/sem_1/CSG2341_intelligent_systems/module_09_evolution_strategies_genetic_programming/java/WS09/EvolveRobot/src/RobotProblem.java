import au.edu.ecu.is.evolution.*;

import java.util.Random;
import java.awt.*;

/**
 * A class describing problems for the robot to try.
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class RobotProblem 
{
    public RobotProblem(int size, int obstaclesWanted, Random random)
    {
        this.size = size;
        this.random = random;
        
        // create the room
        room = new boolean[size][size];
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                room[i][j] = true;
            }
        }
        
        // place obstacles randomly
        int nObstacles = 0;
        while(nObstacles < obstaclesWanted)
        {
            int i = random.nextInt(size);
            int j = random.nextInt(size);
            
            if(room[i][j])
            {
                room[i][j] = false;
                nObstacles++;
            }
        }
        
        // create the robot
        robot = new Robot(room, random);

        // creates function set for robot control programs
        
        intTerminal = new IntegerTerminal(0, size-1, random);
        
        functions = new PrimitiveFunction[]
                        {
                            free, intTerminal,    // integers
                            north, south, east, west,  // directions
                            flip, and, or, not, equals, lessThan, greaterThan, isGood, // booleans                           
                            ifElse, forward, backwards, left, right // actions
                        };
    }
    
    public Robot getRobot()
    {
        return robot;
    }

    public void draw(Graphics g, Rectangle viewport)
    {
        Graphics2D g2 = (Graphics2D)g;
        
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                if(room[i][j])
                {
                    g2.setColor(Color.white);
                    g2.fill(getSquare(viewport, size, i, j));
                }
            }
        }
    }
    
    public static Rectangle getSquare(Rectangle viewport, int size, int i, int j)
    {
        int squareSize = Math.min
                            (
                                (int)Math.round(viewport.width/(double)size),
                                (int)Math.round(viewport.height/(double)size)
                             );
                             
        return new Rectangle(viewport.x + i*squareSize, viewport.y + j*squareSize, squareSize, squareSize);
    }
    
    public PrimitiveFunction[] getFunctions()
    {
        return functions;
    }
    
    public Class getReturnType()
    {
        return RobotAction.class;
    }
       
    private PrimitiveFunction isGood = new PrimitiveFunction("isGood", new Class[]{RobotDirection.class}, Boolean.class)
        {
            public Object evaluate(Object[] args)
            {
                return new Boolean(robot.isGood((RobotDirection)args[0]));
            }
        };
        
    private PrimitiveFunction free = new PrimitiveFunction("free", new Class[]{RobotDirection.class}, Integer.class)
        {
            public Object evaluate(Object[] args)
            {
                return new Integer(robot.free((RobotDirection)args[0]));
            }
        };
        
    private PrimitiveFunction flip = new PrimitiveFunction("flip", null, Boolean.class)
        {
            public Object evaluate(Object[] args)
            {
                return (random.nextDouble() < 0.5)? new Boolean(true): new Boolean(false);
            }
        };

    private IntegerTerminal intTerminal;

    private PrimitiveFunction[] functions;
    
    private int size;
    private Random random;
    private boolean room[][];
    private Robot robot;
    
    private static PrimitiveFunction ifElse = new PrimitiveFunction("if", new Class[]{Boolean.class, RobotAction.class, RobotAction.class}, RobotAction.class)
        {
            public Object evaluate(Object[] args)
            {
                boolean condition = ((Boolean)args[0]).booleanValue();
                
                return (RobotAction)(condition? args[1]: args[2]);
            }
        };

    private static PrimitiveFunction equals = new PrimitiveFunction("=", new Class[]{Integer.class, Integer.class}, Boolean.class)
        {
            public Object evaluate(Object[] args)
            {
                int arg0 = ((Integer)args[0]).intValue();
                int arg1 = ((Integer)args[1]).intValue();
                return new Boolean(arg0 == arg1);
            }
        };
        
    private static PrimitiveFunction lessThan = new PrimitiveFunction("<", new Class[]{Integer.class, Integer.class}, Boolean.class)
        {
            public Object evaluate(Object[] args)
            {
                int arg0 = ((Integer)args[0]).intValue();
                int arg1 = ((Integer)args[1]).intValue();
                return new Boolean(arg0 < arg1);
            }
        };
        
    private static PrimitiveFunction greaterThan = new PrimitiveFunction(">", new Class[]{Integer.class, Integer.class}, Boolean.class)
        {
            public Object evaluate(Object[] args)
            {
                int arg0 = ((Integer)args[0]).intValue();
                int arg1 = ((Integer)args[1]).intValue();
                return new Boolean(arg0 > arg1);
            }
        };
        
    private static PrimitiveFunction or = new PrimitiveFunction("or", new Class[]{Boolean.class, Boolean.class}, Boolean.class)
        {
            public Object evaluate(Object[] args)
            {
                return new Boolean(((Boolean)args[0]).booleanValue() || ((Boolean)args[1]).booleanValue());
            }
        };
        
    private static PrimitiveFunction and = new PrimitiveFunction("and", new Class[]{Boolean.class, Boolean.class}, Boolean.class)
        {
            public Object evaluate(Object[] args)
            {
                return new Boolean(((Boolean)args[0]).booleanValue() && ((Boolean)args[1]).booleanValue());
            }
        };
        
    private static PrimitiveFunction not = new PrimitiveFunction("not", new Class[]{Boolean.class}, Boolean.class)
        {
            public Object evaluate(Object[] args)
            {
                return new Boolean(!((Boolean)args[0]).booleanValue());
            }
        };
        
    private static ConstantTerminal forward = new ConstantTerminal("forward", RobotAction.FORWARD);
    private static ConstantTerminal backwards = new ConstantTerminal("backwards", RobotAction.BACKWARDS);
    private static ConstantTerminal left = new ConstantTerminal("left", RobotAction.LEFT);
    private static ConstantTerminal right = new ConstantTerminal("right", RobotAction.RIGHT);

    private static ConstantTerminal north = new ConstantTerminal("north", RobotDirection.NORTH);
    private static ConstantTerminal south = new ConstantTerminal("south", RobotDirection.SOUTH);
    private static ConstantTerminal east = new ConstantTerminal("east", RobotDirection.EAST);
    private static ConstantTerminal west = new ConstantTerminal("west", RobotDirection.WEST);
}
