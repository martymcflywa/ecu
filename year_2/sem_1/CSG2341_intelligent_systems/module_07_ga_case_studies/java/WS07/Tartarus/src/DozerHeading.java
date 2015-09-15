/*
 * DozerHeading.java
 *
 * Created on 27 July 2006, 09:56
 *
 */

/**
 *
 * @author phingsto
 */
public class DozerHeading
{
    private int dI;
    private int dJ;
    private double rotation;
    private DozerHeading right;
    private DozerHeading left;
    
    /** Creates a new instance of DozerHeading */
    private DozerHeading(int dI, int dJ, double rotation)
    {
        this.dI = dI;
        this.dJ = dJ;
        this.rotation = rotation;
    }
    
    private void setRight(DozerHeading right)
    {
        this.right = right;
    }
    
    private void setLeft(DozerHeading left)
    {
        this.left = left;
    }
    
    public static DozerHeading getRandomHeading()
    {
        return getHeading((int)(4*Math.random()));
    }
    
    public static DozerHeading getHeading(int heading)
    {
        switch(heading)
        {
            case 0:
                return UP;
            case 1:
                return DOWN;
            case 2:
                return RIGHT;
            case 3:
                return LEFT;
        }
        
        return null;
    }
    
    public int getDI()
    {
        return dI;
    }
    
    public int getDJ()
    {
        return dJ;
    }
    
    public double getRotation()
    {
        return rotation;
    }
    
    public DozerHeading turnRight()
    {
        return right;
    }

    public DozerHeading turnLeft()
    {
        return left;
    }
    
    private static final DozerHeading UP = new DozerHeading(0, 1, 0);
    private static final DozerHeading DOWN = new DozerHeading(0, -1, 180);
    private static final DozerHeading RIGHT = new DozerHeading(1, 0, 90);
    private static final DozerHeading LEFT = new DozerHeading(-1, 0, -90);
    
    static
    {
        UP.setRight(RIGHT); UP.setLeft(LEFT);
        DOWN.setRight(LEFT); DOWN.setLeft(RIGHT);
        RIGHT.setRight(DOWN); RIGHT.setLeft(UP);
        LEFT.setRight(UP); LEFT.setLeft(DOWN);
    }
}
