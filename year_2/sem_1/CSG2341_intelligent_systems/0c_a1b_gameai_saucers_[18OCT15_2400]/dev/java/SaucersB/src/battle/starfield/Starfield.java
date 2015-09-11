/*
 * Starfield.java
 *
 * Created on 17 March 2008, 13:59
 *
 */

package battle.starfield;

import battle.blasts.Blast;
import battle.blasts.BlastManager;
import battle.explosions.ExplosionManager;
import battle.powerups.PowerUpManager;
import battle.saucers.Saucer;
import battle.saucers.SaucerManager;
import battle.sensors.SensorData;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author phingsto
 */
public class Starfield
{
    private static final Random random = new Random();
    
    private double width;
    private double height;
 
    private SaucerManager saucerManager;
    private BlastManager blastManager;
    private ExplosionManager explosionManager;
    private PowerUpManager powerUpManager;
    
    /** Creates a new instance of Starfield */
    public Starfield(double width, double height, int nPowerUps)
    {
        this.width = width;
        this.height = height;
        
        saucerManager = new SaucerManager();
        explosionManager = new ExplosionManager();
        blastManager = new BlastManager(explosionManager);
        powerUpManager = new PowerUpManager(this, nPowerUps);
    }

    public void addSaucer(Saucer saucer)
    {
        saucer.init(this);
        saucer.setLocation(width*random.nextDouble(), height*random.nextDouble());
        saucer.setHeading(2*Math.PI*random.nextDouble());
        saucerManager.addSaucer(saucer);
   }
    
    public void adviseSaucerDeath(Saucer saucer)
    {
        saucer.setPlacing(1+saucerManager.numberAlive());
    }
    
    public void finalisePlacings()
    {
        saucerManager.finalisePlacings();
    }
    
    public void fire(double x, double y, double heading, double power, int ownerID)
    {
        blastManager.add(new Blast(this, x, y, heading, power, ownerID));
    }
    
    public ArrayList<SensorData> getSaucerSensorData(Saucer saucer)
    {
        return saucerManager.getSensorData(saucer);
    }

    public ArrayList<SensorData> getPowerUpSensorData(Saucer saucer)
    {
        return powerUpManager.getSensorData(saucer);
    }
    
    public ArrayList<SensorData> getBlastSensorData(Saucer saucer)
    {
        return blastManager.getSensorData(saucer);
    }
    
    public void update(double seconds) throws Exception
    {
        saucerManager.update(seconds);
        powerUpManager.update(seconds);
        powerUpManager.doHits(saucerManager.getSaucers());
        blastManager.update(seconds);
        blastManager.doHits(saucerManager.getSaucers());
        explosionManager.update(seconds);
    }
    
    public void updateExplosions(double seconds)
    {
        explosionManager.update(seconds);
    }

    public int numberOfExplosions()
    {
        return explosionManager.numberOfExplosions();
    }
    
    public double getWidth()
    {
        return width;
    }
    
    public double getHeight()
    {
        return height;
    }  
    
    public ArrayList<Saucer> getSaucers()
    {
        return saucerManager.getSaucers();
    }
    
    public SaucerManager getSaucerManager()
    {
        return saucerManager;
    }

    public BlastManager getBlastManager()
    {
        return blastManager;
    }
    
    public ExplosionManager getExplosionManager()
    {
        return explosionManager;
    }
    
    public PowerUpManager getPowerUpManager()
    {
        return powerUpManager;
    }
}
