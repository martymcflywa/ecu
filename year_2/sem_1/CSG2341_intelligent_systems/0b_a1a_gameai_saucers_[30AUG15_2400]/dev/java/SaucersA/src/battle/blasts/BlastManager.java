package battle.blasts;

import battle.explosions.Explosion;
import battle.explosions.ExplosionManager;
import battle.saucers.Saucer;
import battle.sounds.Sounds;
import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 * Manage the photon blasts
 * 
 * @author phi
 */
public class BlastManager
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
                    saucer.hit(blast.getPower());
                    Sounds.playHit();
                    explosionManager.add(new Explosion(saucer.x, saucer.y, 20));
                    
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
}
