/*
 * Saucer.java
 *
 * Created on 17 March 2008, 12:50
 *
 */

package battle.saucers;

import battle.Constants;
import battle.moving.Mover;
import battle.saucers.controllers.SaucerController;
import battle.sensors.SensorData;
import battle.starfield.Starfield;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.text.NumberFormat;

/**
 *
 * @author phingsto
 */
public class Saucer extends Mover implements Constants
{
    public static final double RADIUS = 40;  
    private static final NumberFormat format = NumberFormat.getNumberInstance(); 
    static
    {
        format.setMaximumFractionDigits(2);
    }

    private Starfield field;
    private SaucerController controller;
    private double energy;
    private double timeSinceFiring;
    private boolean shieldsUp = true;
    private int placing;
    private int ID;
        
    /** Creates a new instance of Saucer */
    public Saucer(Starfield field, SaucerController controller)
    {
        super(field, SAUCER_MIN_SPEED, SAUCER_MAX_SPEED, RADIUS);
        this.controller = controller;
        
        init(field);
    }
    
    /**
     * Place the saucer in a Starfield at the beginning of a battle
     * 
     * @param field the Starfield
     */
    public final void init(Starfield field)
    {
        this.field = field;
        energy = SAUCER_START_ENERGY;
        timeSinceFiring = SAUCER_COOL_TIME;   
        shieldsUp = true;
    }
    
    public void setID(int ID)
    {
        this.ID = ID;
    }
    
    public int getID()
    {
        return ID;
    }
    
    private void setEnergy(double newEnergy)
    {
        energy = Math.max(0, Math.min(SAUCER_START_ENERGY, newEnergy));
        
        if(energy == 0)
        {
            field.adviseSaucerDeath(this);
        }
    }
    
    public boolean isAlive()
    {
        return energy > 0;
    }
    
    public void hit(double power)
    {
        setEnergy(energy-SAUCER_HIT_FACTOR*power);
    }
    
    public void powerUp(double extraEnergy)
    {
        setEnergy(energy+extraEnergy);
    }
    
    public void setPlacing(int placing)
    {
        this.placing = placing;
    }
    
    public int getPlacing()
    {
        return placing;
    }
    
    public boolean getShields()
    {
        return shieldsUp;
    }

    public void update(double seconds) throws Exception
    {        
        double speed;
        double turn;
        SensorData target;
        double firePower;

        try
        {
            controller.senseSaucers(field.getSaucerSensorData(this));
            controller.sensePowerUps(field.getPowerUpSensorData(this));
            controller.senseBlasts(field.getBlastSensorData(this));
            controller.senseEnergy(energy);

            speed = controller.getSpeed();
            turn = controller.getTurn();
            target = controller.getTarget();
            firePower = controller.getFirePower();
            shieldsUp = controller.getShields();
        }
        catch(Exception e)
        {
            System.err.println("Controller " + controller.getName() + " has thrown an error and is disqualified from this battle!");
            e.printStackTrace(System.err);
            setEnergy(0);
            return;
        }

        if(target != null && !shieldsUp)
        {
            fire(firePower, target);
        }

        if(energy >= Math.abs(turn)*SAUCER_TURN_COST) 
        {
            turnDegrees(turn);
            setEnergy(energy-Math.abs(turn)*SAUCER_TURN_COST);
        }
        
        setSpeed(speed);
        double burnRate = shieldsUp?SAUCER_SHIELD_BURN_RATE:SAUCER_BURN_RATE;
        if(energy >= getSpeed()*seconds*burnRate)
        {
            step(seconds);
            setEnergy(energy-getSpeed()*seconds*burnRate);
        }
        else
        {
            setEnergy(0);
        }
        
        timeSinceFiring += seconds;
    }
    
    private static final int BODY_X = (int)(-RADIUS);
    private static final int BODY_Y = (int)(-RADIUS);
    private static final int BODY_W = (int)(2*RADIUS);
    private static final int BODY_H = (int)(2*RADIUS);
    private static final int SHIELD_X = (int)(-1.7*RADIUS);
    private static final int SHIELD_Y = (int)(-1.7*RADIUS);
    private static final int SHIELD_W = (int)(3.4*RADIUS);
    private static final int SHIELD_H = (int)(3.4*RADIUS);
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
    
    private static final Color SHIELD_COLOR = new Color(0, 0, 255, 100);
    
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
        
        if(shieldsUp)
        {
            g2.setColor(SHIELD_COLOR);
            g2.fillOval(SHIELD_X, SHIELD_Y, SHIELD_W, SHIELD_H);
            g2.setColor(Color.WHITE);
            g2.drawOval(SHIELD_X, SHIELD_Y, SHIELD_W, SHIELD_H);
        }
     
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
    
    private void fire(double power, SensorData target)
    {
        power = Math.max(0.0, Math.min(SAUCER_MAX_POWER, power));
        
        if(power == 0) return;
        
        double direction = Math.toRadians(target.direction);
        double heading = Math.toRadians(target.heading);
        double angleToIntercept = 
                getHeading() +
                direction + 
                Math.asin(target.speed * Math.sin(Math.PI - heading + direction) / BLAST_SPEED);
        // using sine rule
        last_firing_direction = direction;
        
        if(power <= energy && timeSinceFiring >= SAUCER_COOL_TIME)
        {
            energy -= power;
            field.fire
            (
                x, y,
                angleToIntercept,
                power,
                ID
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
