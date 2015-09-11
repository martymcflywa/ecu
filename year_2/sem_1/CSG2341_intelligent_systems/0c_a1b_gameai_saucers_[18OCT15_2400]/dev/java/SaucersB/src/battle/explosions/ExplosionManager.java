/*
 * ExplosionManager.java
 *
 * Created on 18 March 2008, 10:28
 *
 */

package battle.explosions;

import java.awt.Graphics2D;
import java.util.ArrayList;

/**
 *
 * @author phingsto
 */
public class ExplosionManager
{
    private ArrayList<Explosion> explosions;
    
    /** Creates a new instance of ExplosionManager */
    public ExplosionManager()
    {
        explosions = new ArrayList<Explosion>();
    }

    public synchronized void update(double seconds)
    {
        ArrayList<Explosion> deadExplosions = new ArrayList<Explosion>();
        
        for(Explosion explosion: explosions)
        {
            explosion.update(seconds);
            if(explosion.allDone())
            {
                deadExplosions.add(explosion);
            }
        }
        
        for(Explosion explosion: deadExplosions)
        {
            explosions.remove(explosion);
        }
    }
    
    
    public synchronized void drawExplosions(Graphics2D g2)
    {
        for(Explosion explosion: explosions)
        {
            explosion.draw(g2);
        }
    }
    
    public synchronized void add(Explosion explosion)
    {
        explosions.add(explosion);
    }
    
    public int numberOfExplosions()
    {
        return explosions.size();
    }
}
