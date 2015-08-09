package battle.blasts;

import battle.moving.Mover;
import battle.saucers.Saucer;
import battle.starfield.Starfield;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;

/**
 * A photon blast
 * 
 * @author phi
 */
public class Blast extends Mover
{
    public static final double SPEED = 1.2*Saucer.MAX_SPEED;
    public static final double RADIUS = 0.15*Saucer.RADIUS;
    private static final double DECAY = 0.02;
 
    private double power;
    
    /** Creates a new instance of Blast */
    public Blast(Starfield field, double x, double y, double heading, double power)
    {
        super(field, SPEED, SPEED, RADIUS);
        setLocation(x + 1.2*Saucer.RADIUS*Math.cos(heading),
                y + 1.2*Saucer.RADIUS*Math.sin(heading));
        setHeading(heading);
        this.power = power;
    }  
    
    public void update(double seconds)
    {
        step(seconds);
        
        power -= SPEED*DECAY*seconds;
    }
    
    public double getPower()
    {
        return power;
    }

    public boolean isDead()
    {
        return power <= 0;
    }
    
    public boolean hits(Saucer saucer)
    {
        return distance(saucer) < RADIUS+Saucer.RADIUS;
    }
    
    private static final int R_X = (int)(-RADIUS*9);
    private static final int R_Y = (int)(-RADIUS);
    private static final int R_W = (int)(RADIUS*10);
    private static final int R_H = (int)(2*RADIUS);
    private static final int R_H_A = (int)(RADIUS);
    private static final int R_V_A = (int)(RADIUS);
    private static final int O_X = (int)(-RADIUS);
    private static final int O_Y = (int)(-RADIUS);
    private static final int O_W = (int)(2*RADIUS);
    private static final int O_H = (int)(2*RADIUS);
    
    public void draw(Graphics2D g2)
    {
        int level = 127+(int)(128*power/Saucer.MAX_POWER);
        Color ovalColor = new Color(level, level, level);
        Color rectColor1 = new Color(0, level, 0);
        Color rectColor2 = new Color(50, 50, 50);
        
        AffineTransform saveAT = g2.getTransform();
        
        g2.translate(x, y);
        g2.rotate(getHeading());

        GradientPaint paint = new GradientPaint(0, 0, rectColor1, R_W, 0, rectColor2, true);
        g2.setPaint(paint);
        g2.fillRoundRect(R_X, R_Y, R_W, R_H, R_H_A, R_V_A);
        
        g2.setColor(ovalColor);
        g2.fillOval(O_X, O_Y, O_W, O_H);

        g2.setTransform(saveAT);
    }
}
