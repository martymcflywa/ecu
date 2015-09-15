/*
 * Dozer.java
 *
 * Created on 27 July 2006, 09:54
 *
 */

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.geom.AffineTransform;
import java.awt.Rectangle;

/**
 *
 * @author phingsto
 */
public class Dozer
{
    private DozerHeading heading;
    
    /** Creates a new instance of Dozer */
    public Dozer()
    {
        heading = DozerHeading.getRandomHeading();
    }
    
    public void setHeading(DozerHeading heading)
    {
        this.heading = heading;
    }
    
    public DozerHeading getHeading()
    {
        return heading;
    }
    
    public void turnRight()
    {
        heading = heading.turnRight();
    }

    public void turnLeft()
    {
        heading = heading.turnLeft();
    }
    
    public void draw(Graphics2D g, Rectangle rect)
    {
        g.setColor(Color.BLUE);
        
        AffineTransform old = g.getTransform();
        
        g.translate(rect.x, rect.y);
        g.scale(rect.width/100.0, rect.height/100.0);
        
        g.rotate(Math.toRadians(heading.getRotation()+90), 50, 50);
        
        // now draw within (0,0)-(100,100)
        g.fillRect(30, 30, 50, 40);
        
        g.fillRect(35, 27, 30, 3);
        g.fillRect(35, 70, 30, 3);
        
        g.drawLine(25, 50, 30, 50);
        
        g.drawLine(25, 32, 25, 68);
        
        g.drawLine(20, 27, 25, 32);
        g.drawLine(20, 73, 25, 68);
        
        g.setTransform(old);
    }
}
