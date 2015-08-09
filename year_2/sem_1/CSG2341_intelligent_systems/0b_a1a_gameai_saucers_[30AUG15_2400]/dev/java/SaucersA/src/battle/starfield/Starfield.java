package battle.starfield;

import battle.blasts.Blast;
import battle.blasts.BlastManager;
import battle.explosions.ExplosionManager;
import battle.saucers.Saucer;
import battle.saucers.SaucerManager;
import java.util.ArrayList;
import java.util.Random;

/**
 * Battles take place within a "starfield"
 * 
 * @author phi
 */
public class Starfield
{
    private static final Random random = new Random();
    
    private double width;
    private double height;
 
    private SaucerManager saucerManager;
    private BlastManager blastManager;
    private ExplosionManager explosionManager;
    
    /** Creates a new instance of Starfield */
    public Starfield(double width, double height)
    {
        this.width = width;
        this.height = height;
        
        saucerManager = new SaucerManager();
        explosionManager = new ExplosionManager();
        blastManager = new BlastManager(explosionManager);
    }

    public void addSaucer(Saucer saucer)
    {
        saucer.init(this);
        saucer.setLocation(width*random.nextDouble(), height*random.nextDouble());
        saucer.setHeading(2*Math.PI*random.nextDouble());
        saucerManager.addSaucer(saucer);
   }
    
    public void fire(double x, double y, double heading, double power)
    {
        blastManager.add(new Blast(this, x, y, heading, power));
    }
    
    public void update(double seconds) throws Exception
    {
        saucerManager.update(seconds);
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
}
