/*
 * PowerUp.java
 *
 * Created on 20 April 2008, 12:11
 *
 */

package battle.powerups;

import battle.Constants;
import battle.moving.Mover;
import battle.saucers.Saucer;
import battle.starfield.Starfield;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.Random;

/**
 *
 * @author phingsto
 */
public class PowerUp extends Mover implements Constants
{
    private static final Random random = new Random();
    
    private static final double CORE_RADIUS = 10;
    private static final double EXPANSION = 40;
    private static final double RADIUS = CORE_RADIUS+EXPANSION;
    
    private static final int CYCLEMAX = 100;
    private static Color[] colors;   
    static
    {
        colors = new Color[CYCLEMAX];
        
        for(int i = 0; i < CYCLEMAX/2; i++)
        {
            colors[i] = new Color((float)(2.0*i)/CYCLEMAX, (float)0.1, (float)0.0, (float)(2.0*i)/CYCLEMAX);
        }
        for(int i = CYCLEMAX/2; i < CYCLEMAX; i++)
        {
            colors[i] = new Color((float)(2.0*(CYCLEMAX-i))/CYCLEMAX, (float)1.0, (float)0.0, (float)(2.0*(CYCLEMAX-i))/CYCLEMAX);
        }
    }
    
   private int cycle = 0;
   private boolean active = false;
   private double fieldWidth;
   private double fieldHeight;
    
    /** Creates a new instance of PowerUp */
    public PowerUp(Starfield field)
    {
        super(field, 2*(random.nextDouble()-0.5)*POWERUP_MAXSPEED,
                2*(random.nextDouble()-0.5)*POWERUP_MAXSPEED, RADIUS);
        fieldWidth = field.getWidth();
        fieldHeight = field.getHeight();
    }    
    
    public void update(double seconds)
    {
        if(active) 
        {
            step(seconds);
            cycle++;
            cycle = cycle%CYCLEMAX;
            if(Math.random() < POWERUP_HIDE_PROB*seconds)
            {
                active = false;
            }
        }
        else if(Math.random() < POWERUP_SHOW_PROB*seconds)
        {
            x = random.nextDouble()*fieldWidth;
            y = random.nextDouble()*fieldHeight;
            setLocation(x, y);
            active = true;
        }
    }
    
    public boolean hits(Saucer saucer)
    {
        return distance(saucer) < RADIUS+Saucer.RADIUS;
    }
    
    public boolean isActive()
    {
        return active;
    }
    
    public void deactivate()
    {
        active = false;
    }
    public double getPower()
    {
        return POWERUP_POWER;
    }
    
    public void draw(Graphics2D graphic)
    {
        double rad = (CORE_RADIUS + (cycle*EXPANSION)/CYCLEMAX);

        AffineTransform saveAT = graphic.getTransform();
        graphic.translate(x, y);

        graphic.setColor(colors[cycle]);
        graphic.fillArc(-(int)rad, -(int)rad, (int)(2*rad), (int)(2*rad), 0, 360);   
        
        graphic.setTransform(saveAT);
    }
}
