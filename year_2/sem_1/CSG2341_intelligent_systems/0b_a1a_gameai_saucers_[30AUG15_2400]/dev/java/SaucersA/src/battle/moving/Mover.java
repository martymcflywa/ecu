package battle.moving;

import battle.starfield.Starfield;
import java.awt.geom.Point2D;

/**
 * A generic class for things that move at a certain heading and speed
 * 
 * @author phi
 */
public class Mover extends Point2D.Double
{
    // inherits x, y from Point2D.Double
    
    private double heading;
    private double speed;
    private double speed_x;
    private double speed_y;

    private double fieldWidth;
    private double fieldHeight;
    private double hitRadius;
    private double minSpeed;
    private double maxSpeed;
    
    /** Creates a new instance of Mover */
    public Mover(Starfield field, double minSpeed, double maxSpeed, double hitRadius)
    {
        fieldWidth = field.getWidth();
        fieldHeight = field.getHeight();
        
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.hitRadius = hitRadius;
        heading = 0;
        setSpeed(minSpeed);
        x = 0;
        y = 0;
    }
    
    public double getHitRadius()
    {
        return hitRadius;
    }
    
    public double getSpeed()
    {
        return speed;
    }
    
    public double getHeading()
    {
        return heading;
    }
    
    public void setLocation(double x, double y)
    {
        this.x = Math.max(0, Math.min(fieldWidth, x));
        this.y = Math.max(0, Math.min(fieldHeight, y));
    }
    
    public void setSpeed(double speed)
    {
        this.speed = Math.max(minSpeed, Math.min(maxSpeed, speed));
        
        speed_x = this.speed*Math.cos(heading);
        speed_y = this.speed*Math.sin(heading);
    }
    
    public void setHeading(double heading)
    {
        this.heading = wrap(heading);

        speed_x = this.speed*Math.cos(heading);
        speed_y = this.speed*Math.sin(heading);
    }
    
    public void turnDegrees(double degrees)
    {
        setHeading(heading + Math.toRadians(degrees));
    }
    
    public void step(double seconds)
    {
        x += speed_x*seconds;
        y += speed_y*seconds;
        
        if(x < 0.0)
        {
            x = -x;
            setHeading(-heading+Math.PI);
        }
        else if(x >= fieldWidth)
        {
            x = 2*fieldWidth-x;
            setHeading(-heading+Math.PI);
        }

        if(y < 0.0)
        {
            y = -y;
            setHeading(-heading);
        }
        else if(y >= fieldHeight)
        {
            y = 2*fieldHeight-y;
            setHeading(-heading);
        }
   }
    
    public static double wrap(double heading)
    {
        while(heading > Math.PI) heading -= 2*Math.PI;
        while(heading < -Math.PI) heading += 2*Math.PI;
        
        return heading;
    }
}
