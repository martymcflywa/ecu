/*
 * SaucerManager.java
 *
 * Created on 17 March 2008, 12:48
 *
 */
package battle.saucers;

import battle.sensors.SensorData;
import java.util.ArrayList;

/**
 *
 * @author phingsto
 */
public class SaucerManager
{
    private ArrayList<Saucer> saucers;
    
    /** Creates a new instance of SaucerManager */
    public SaucerManager()
    {
        saucers = new ArrayList<Saucer>();
    }
    
    public void addSaucer(Saucer saucer)
    {
        saucer.setID(saucers.size());
        saucers.add(saucer);
    }
    
    public void update(double seconds) throws Exception
    {
        for(Saucer saucer: saucers)
        {
            if(saucer.isAlive())
            {
                saucer.update(seconds);
            }
        }
        
        // now check for collisions
        for(int i = 0; i < saucers.size(); i++)
        {
            Saucer me = saucers.get(i);
            if(me.isAlive())
            {
                for(int j = i+1; j < saucers.size(); j++)
                {
                    Saucer you = saucers.get(j);

                    if(you.isAlive())
                    {
                        if(me.collidesWith(you))
                        {
                            me.bounceOff(you);
                        }
                    }
                }
            }
        }
    }
    
    public int numberAlive()
    {
        int saucersAlive = 0;

        for(Saucer saucer: saucers)
        {
            if(saucer.isAlive())
            {
                saucersAlive++;
            }
        }
        
        return saucersAlive;
    }
    
    public ArrayList<Saucer> getSaucers()
    {
        return saucers;
    }
    
    public void finalisePlacings()
    {
        int nAlive = numberAlive();
        
        for(Saucer saucer: saucers)
        {
            if(saucer.isAlive())
            {
                saucer.setPlacing(nAlive);
            }
        }
    }

    public ArrayList<SensorData> getSensorData(Saucer saucer)
    {
        ArrayList<SensorData> data = new ArrayList<SensorData>();
        
        for(Saucer other: saucers)
        {
            if(other.isAlive() && other != saucer)
            {
                double distance = other.distance(saucer);
                double direction = Math.toDegrees(Math.atan2(other.y-saucer.y, other.x-saucer.x) - saucer.getHeading());
                double heading = Math.toDegrees(wrap(other.getHeading() - saucer.getHeading()));
                double speed = other.getSpeed();
                double energy = other.getEnergy();
                int ID = other.getID();
                SensorData thisData = new SensorData(distance, direction, heading, speed, energy, ID);
                
                data.add(thisData);
            }
        }

        return data;
    }
    
    private static double wrap(double heading)
    {
        while(heading > Math.PI) heading -= 2*Math.PI;
        while(heading < -Math.PI) heading += 2*Math.PI;
        
        return heading;
    }
}
