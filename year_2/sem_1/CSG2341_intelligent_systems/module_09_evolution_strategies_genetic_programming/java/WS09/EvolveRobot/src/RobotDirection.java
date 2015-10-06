
/**
 * A class for directions the robot can use/take
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class RobotDirection
{
    private RobotDirection(String name, int index, int dx, int dy)
    {
        this.name = name;
        this.index = index;
        this.DX = dx;
        this.DY = dy;
    }
    
    public RobotDirection left()
    {
        return leftOf[this.index];
    }
    
    public RobotDirection right()
    {
        return rightOf[this.index];
    }
    
    public RobotDirection robotToWorld(RobotDirection robot)
    {
        if(this == NORTH)
        {
            return robot;
        }
        else if(this == WEST)
        {
            return robot.left();
        }
        else if(this == EAST)
        {
            return robot.right();
        }
        else // if(facing == SOUTH)
        {
            return robot.left().left();
        }
    }
    
    public String toString()
    {
        return name;
    }

    private int index;
    private String name;
    public final int DX;
    public final int DY;

    public static final RobotDirection NORTH = new RobotDirection("north", 0, 0, -1);
    public static final RobotDirection SOUTH = new RobotDirection("south", 1, 0, 1);
    public static final RobotDirection EAST = new RobotDirection("east", 2, 1, 0);
    public static final RobotDirection WEST = new RobotDirection("west", 3, -1, 0);
    
    public static RobotDirection DIRECTIONS[] = {NORTH, SOUTH, EAST, WEST};

    private static RobotDirection[] leftOf = {WEST, EAST, NORTH, SOUTH};
    private static RobotDirection[] rightOf = {EAST, WEST, SOUTH, NORTH};    
}
