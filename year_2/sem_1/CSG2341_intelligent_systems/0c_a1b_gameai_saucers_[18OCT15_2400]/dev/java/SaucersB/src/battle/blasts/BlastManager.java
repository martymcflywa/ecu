/*
 * BlastManager.java
 *
 * Created on 17 March 2008, 16:51
 *
 */

package battle.blasts;

import battle.Constants;
import battle.explosions.Explosion;
import battle.explosions.ExplosionManager;
import battle.powerups.PowerUp;
import battle.saucers.Saucer;
import battle.sensors.SensorData;
import battle.sounds.Sounds;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author phingsto
 */
public class BlastManager implements Constants
{
    private ArrayList<Blast> blasts;
    private ExplosionManager explosionManager;
    
    /** Creates a new instance of BlastManager */
    public BlastManager(ExplosionManager explosionManager)
    {
        blasts = new ArrayList<Blast>();
        this.explosionManager = explosionManager;
    }
    
    public synchronized void update(double seconds)
    {
        ArrayList<Blast> deadBlasts = new ArrayList<Blast>();
        
        for(Blast blast: blasts)
        {
            blast.update(seconds);
            if(blast.isDead())
            {
                deadBlasts.add(blast);
            }
        }
        
        for(Blast blast: deadBlasts)
        {
            blasts.remove(blast);
        }
    }
    
    public synchronized void doHits(ArrayList<Saucer> saucers)
    {
        ArrayList<Blast> deadBlasts = new ArrayList<Blast>();
        
        for(Blast blast: blasts)
        {
            for(Saucer saucer: saucers)
            {
                if(saucer.isAlive() && blast.hits(saucer))
                {
                    double power = blast.getPower();
                    
                    if(saucer.getShields())
                    {
                        power *= SHIELD_EFFECT;
                    }
                    
                    saucer.hit(power);
                    Sounds.playHit();
                    explosionManager.add(new Explosion(blast.x, blast.y, 20));
                    
                    if(!saucer.isAlive())
                    {
                        Sounds.playExplode();
                        explosionManager.add(new Explosion(saucer.x, saucer.y, 100));
                    }
                    
                    deadBlasts.add(blast);
                    break;
                }
            }
        }
        
        for(Blast blast: deadBlasts)
        {
            blasts.remove(blast);
        }
    }
    
    public synchronized void drawBlasts(Graphics2D g2)
    {
        for(Blast blast: blasts)
        {
            blast.draw(g2);
        }
    }
    
    public synchronized void add(Blast blast)
    {
        blasts.add(blast);
        Sounds.playShot();
    }
    
    public synchronized void die(Blast blast)
    {
        blasts.remove(blast);
    }
    
    public ArrayList<SensorData> getSensorData(Saucer saucer)
    {
        ArrayList<SensorData> data = new ArrayList<SensorData>();
        
        for(Blast blast: blasts)
        {
            if(!blast.isDead() && blast.getOwnerID()!=saucer.getID())
            {
                double distance = blast.distance(saucer);
                double direction = Math.toDegrees(Math.atan2(blast.y-saucer.y, blast.x-saucer.x) - saucer.getHeading());
                double heading = Math.toDegrees(wrap(blast.getHeading() - saucer.getHeading()));
                double speed = blast.getSpeed();
                double energy = blast.getPower();
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
