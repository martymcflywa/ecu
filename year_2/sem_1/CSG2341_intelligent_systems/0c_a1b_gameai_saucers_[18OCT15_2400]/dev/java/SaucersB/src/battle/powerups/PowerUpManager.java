/*
 * PowerUpManager.java
 *
 * Created on 20 April 2008, 12:11
 *
 */

package battle.powerups;

import battle.saucers.Saucer;
import battle.sensors.SensorData;
import battle.sounds.Sounds;
import battle.starfield.Starfield;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author phingsto
 */
public class PowerUpManager
{
    private ArrayList<PowerUp> powerUps;
    
    /** Creates a new instance of PowerUpManager */
    public PowerUpManager(Starfield field, int nPowerUps)
    {
        powerUps = new ArrayList<PowerUp>();
        
        for(int i = 0; i < nPowerUps; i++)
        {
            powerUps.add(new PowerUp(field));
        }
    }
    
    public void update(double seconds)
    {
        for(PowerUp powerUp: powerUps)
        {
            powerUp.update(seconds);
        }
    }
    
    public void doHits(ArrayList<Saucer> saucers)
    {
        for(PowerUp powerUp: powerUps)
        {
            for(Saucer saucer: saucers)
            {
                if(saucer.isAlive() && powerUp.isActive() && powerUp.hits(saucer))
                {
                    saucer.powerUp(powerUp.getPower());
                    powerUp.deactivate();
                    Sounds.playPowerUp();
                    break;
                }
            }
        }
    }
    
    public void drawPowerUps(Graphics2D g2)
    {
        for(PowerUp powerUp: powerUps)
        {
            if(powerUp.isActive())
            {
                powerUp.draw(g2);
            }
        }
    }

    public ArrayList<SensorData> getSensorData(Saucer saucer)
    {
        ArrayList<SensorData> data = new ArrayList<SensorData>();
        
        for(PowerUp powerUp: powerUps)
        {
            if(powerUp.isActive())
            {
                double distance = powerUp.distance(saucer);
                double direction = Math.toDegrees(Math.atan2(powerUp.y-saucer.y, powerUp.x-saucer.x) - saucer.getHeading());
                double heading = Math.toDegrees(wrap(powerUp.getHeading() - saucer.getHeading()));
                double speed = powerUp.getSpeed();
                double energy = powerUp.getPower();
                SensorData thisData = new SensorData(distance, direction, heading, speed, energy, 0);
                
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
