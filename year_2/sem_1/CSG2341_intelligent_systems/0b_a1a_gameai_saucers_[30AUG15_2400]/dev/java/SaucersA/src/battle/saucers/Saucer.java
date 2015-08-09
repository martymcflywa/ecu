package battle.saucers;

import battle.blasts.Blast;
import battle.moving.Mover;
import battle.saucers.controllers.SaucerController;
import battle.starfield.Starfield;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.Polygon;
import java.awt.geom.AffineTransform;
import java.text.NumberFormat;

/**
 * Represents a saucer
 * 
 * @author phi
 */
public class Saucer extends Mover
{
    public static final double START_ENERGY = 10000.0; 
    public static final double MAX_POWER = 100.0;  // of a blast  

    public static final double RADIUS = 40;  

    public static final double MIN_SPEED = 50;
    public static final double MAX_SPEED = 125;
    private static final double HIT_FACTOR = 2.4;  // controls damage to opponent relative to cost    
    private static final double COOL_TIME = 1.5;     // controls how long between shots
    private static final double TURN_COST = 0.025;
    private static final double BURN_RATE = 0.01;

    private static final NumberFormat format = NumberFormat.getNumberInstance();     
    static
    {
        format.setMaximumFractionDigits(2);
    }

    private Starfield field;
    private SaucerController controller;
    private Saucer opponent;
    private double energy;
    private double timeSinceFiring;
        
    /** Creates a new instance of Saucer */
    public Saucer(Starfield field, SaucerController controller)
    {
        super(field, MIN_SPEED, MAX_SPEED, RADIUS);
        this.controller = controller;
        
        init(field);
    }
    
    public void init(Starfield field)
    {
        this.field = field;
        energy = START_ENERGY;
        timeSinceFiring = COOL_TIME;        
    }
    
    public void setOpponent(Saucer opponent)
    {
        this.opponent = opponent;
    }
    
    public boolean isAlive()
    {
        return energy > 0;
    }
    
    public void hit(double power)
    {
        energy -= HIT_FACTOR*power;
        if(energy < 0.0) energy = 0.0;
    }
    
    public void update(double seconds) throws Exception
    {
        double opponentDistance = distance(opponent);
        double opponentDirection = Math.toDegrees(Math.atan2(opponent.y-y, opponent.x-x) - getHeading());
        
        controller.sensorUpdate(opponentDistance, opponentDirection, opponent.energy, energy);
        double speed = controller.getSpeed();
        double turn = controller.getTurn();
        double firePower = controller.getFirePower();
        
        if(energy >= turn*TURN_COST) // should have Math.abs()
        {
            turnDegrees(turn);
            // should have energy -= Math.abs(turn)*TURN_COST;
        }
        
        setSpeed(speed);
        if(energy >= speed*BURN_RATE)
        {
            step(seconds);
            energy -= speed*BURN_RATE;
        }
        else
        {
            energy = 0;
        }

        if(opponent.isAlive())
        {
            fire(firePower, opponent);
        } 
        
        timeSinceFiring += seconds;
    }
    
    private static final int BODY_X = (int)(-RADIUS);
    private static final int BODY_Y = (int)(-RADIUS);
    private static final int BODY_W = (int)(2*RADIUS);
    private static final int BODY_H = (int)(2*RADIUS);
    private static final int BODY1_X = (int)(-0.7*RADIUS);
    private static final int BODY1_Y = (int)(-RADIUS);
    private static final int BODY1_W = (int)(2*0.7*RADIUS);
    private static final int BODY1_H = (int)(2*RADIUS);
    private static final int TURRET_X = (int)(-0.35*RADIUS);
    private static final int TURRET_Y = (int)(-0.35*RADIUS);
    private static final int TURRET_W = (int)(0.7*RADIUS);
    private static final int TURRET_H = (int)(0.7*RADIUS);
    private static final int BARREL_L = (int)(0.9*RADIUS);
    private static final int BARREL_W = (int)(0.3*RADIUS);
    private static final int PROW_L = (int)(1.6*RADIUS);
    private static final int[] PROW_X = {-1, -1, PROW_L};
    private static final int[] PROW_Y = {BODY_Y, BODY_Y+BODY_H, BODY_Y+BODY_H/2};
    
    public void draw(Graphics2D g2)
    {
        AffineTransform saveAT = g2.getTransform();
        Color color1 = controller.getBaseColor();
        Color color2 = controller.getTurretColor();
        Color lighter_color1 = color1.brighter();
        Color darker_color1 = color1.darker();
        Color lighter_color2 = color2.brighter();
        Color darker_color2 = color2.darker();
        GradientPaint paint;
        
        g2.translate(x, y);
        g2.rotate(getHeading());
        
        // body and prow
        g2.setColor(darker_color1);
        g2.fillArc(BODY_X, BODY_Y, BODY_W, BODY_H, 90, 180);
        g2.setColor(color1);
        g2.fillArc(BODY1_X, BODY1_Y, BODY1_W, BODY1_H, 90, 180);
        paint = new GradientPaint(0, 0, color1, PROW_L, 0, darker_color1, true);
        g2.setPaint(paint);
        g2.fillPolygon(PROW_X, PROW_Y, 3);
        
        // turret
        g2.setColor(color2);
        g2.fillOval(TURRET_X, TURRET_Y, TURRET_W, TURRET_H);
        
        // barrel
        g2.rotate(last_firing_direction);
        paint = new GradientPaint(0, 0, color1, PROW_L, 0, color2, true);
        g2.setPaint(paint);
        g2.fillRoundRect(0, -BARREL_W/2, BARREL_L, BARREL_W, BARREL_W/2, BARREL_W/2);
     
        g2.setTransform(saveAT);
    }
    
    // drawn separately because we don't want the text scaled
    public void drawInfo(Graphics2D g2, double height, double scaleX, double scaleY)
    {
        double screen_x = x*scaleX;
        double screen_y = height-y*scaleY;
        
        g2.setColor(Color.WHITE);
        g2.drawString(controller.getName(), (float)(screen_x-20.0), (float)(screen_y-20.0));
        g2.drawString(format.format(energy), (float)(screen_x-20.0), (float)(screen_y+30.0));
    }
    
    public String getControllerName()
    {
        return controller.getName();
    }
    
    public String getEnergyString()
    {
        return format.format(energy);
    }
    
    public double getEnergy()
    {
        return energy;
    }

    private double last_firing_direction = 0;
    
    private void fire(double power, Saucer target)
    {
        power = Math.max(0.0, Math.min(MAX_POWER, power));
        
        if(power == 0) return;
        
        double direction = Math.atan2(target.y-y, target.x-x);
        double angleToIntercept = direction + 
                Math.asin(target.getSpeed() * Math.sin(Math.PI - target.getHeading() + direction) / Blast.SPEED);
        // using sine rule
        last_firing_direction = angleToIntercept-getHeading();
        
        if(power <= energy && timeSinceFiring >= COOL_TIME)
        {
            energy -= power;
            field.fire
            (
                x, y,
                angleToIntercept,
                power
             ); // aim to hit unless opponent changes direction
             timeSinceFiring = 0.0;
        }
    }
    
    public boolean collidesWith(Saucer other)
    {
        return distance(other) <= 2*Saucer.RADIUS;
    }
    
    public void bounceOff(Saucer other)
    {
        double distance = distance(other);
        
        // (dx, dy) is unit vector in direction of other
        double dx = (other.x-x)/distance;
        double dy = (other.y-y)/distance;
        
        double adjust = 2.1*Saucer.RADIUS - distance;
        
        x -= adjust*dx;
        y -= adjust*dy;
        other.x += adjust*dx;
        other.y += adjust*dy;
        
        double otherHeading = other.getHeading();
        other.setHeading(getHeading());
        setHeading(otherHeading);
    }
}
