import java.util.*;

/**
 * A class to represent an inverted pendulum
 *
 * @author (phi)
 * @version (2006/2)
 */
public class InvertedPendulum
{
    // design details of this pendulum
    private final double length;  // m
    private final double mass;    // kG
    private final double width;   // m
    
    // current state of the pendulum
    private double theta;   // degrees
    private double dtheta;  // degrees/second
    private double x;       // meters
    private double dx;      // meters/second
    
    private boolean stopped;
    
    // physical constants
    private final double G = 9.8;        // meters/second^2
    private final double SMALL = 0.1;
    
    // who's listening to this pendulum?
    private Vector listeners;
    
    public InvertedPendulum(double length, double mass, double width)
    {
        this.length = length;
        this.mass = mass;
        this.width = width;
        
        theta = 0.0;
        dtheta = 0.0;
        
        x = 0.0;
        dx = 0.0;
        
        listeners = new Vector();
        
        stopped = true;
    }
    
    public void display()
    {
        (new PendulumPanel(this)).display();
    }
    
    public void update(double force, double tick)
    {
        updateListeners();
        
        double d2x;
        double d2theta;
        
        // apply equations of motion for this physical system
        double radians = Math.toRadians(theta);
        double dradians = Math.toRadians(dtheta);
        if(Math.abs(radians) < 0.05)  // avoid numerical instability problem
        {
            d2x = 0.0;
            d2theta = 0.0;
        }
        else
        {
            d2x = (force/(mass*Math.sin(radians)) - G*Math.cos(radians) + length*dradians*dradians)/Math.sin(radians);
            d2theta = Math.toDegrees((G*Math.sin(radians) - d2x*Math.cos(radians))/length);
        }
        
        x += dx*tick;
        dx += d2x*tick;
        
        theta += dtheta*tick;
        dtheta += d2theta*tick;
        
        // have we fallen over or gone off the page?
        if(theta > 90.0)
        {
            stopped = true;
            theta = 90.0;
        }
        else if(theta < -90.0)
        {
            stopped = true;
            theta = -90.0;
        }
        else if(Math.abs(theta) < SMALL && Math.abs(dtheta) < SMALL && Math.abs(dx) < SMALL)
        {
            theta = 0;
            stopped = true;
        }
        else if(Math.abs(x) > width/2)
        {
            stopped = true;
        }
        
        if(stopped)
        {
            updateListeners();
        }
    }
    
    private void updateListeners()
    {
        Enumeration e = listeners.elements();
        while(e.hasMoreElements())
        {
            PendulumListener listener = (PendulumListener)e.nextElement();
            
            listener.update(x, theta);
        }
    }
    
    public void tap(double theta)
    {
        this.theta = theta;
        dtheta = 0.0;
        
        x = 0.0;
        dx = 0.0;
        
        stopped = false;
    }
    
    public void addListener(PendulumListener listener)
    {
        listeners.add(listener);
    }
    
    public double getLength()
    {
        return length;
    }
    
    public double getMass()
    {
        return mass;
    }
    
    public double getTheta()
    {
        return theta;
    }
    
    public double getX()
    {
        return x;
    }
    
    public double getDx()
    {
        return dx;
    }
    
    public double getDtheta()
    {
        return dtheta;
    }
    
    public double getWidth()
    {
        return width;
    }
    
    public boolean isStopped()
    {
        return stopped;
    }
}
