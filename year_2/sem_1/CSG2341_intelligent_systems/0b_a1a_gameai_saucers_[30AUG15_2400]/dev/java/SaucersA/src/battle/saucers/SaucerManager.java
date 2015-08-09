package battle.saucers;

import java.util.ArrayList;

/**
 * Manage the saucers
 * 
 * @author phi
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
}
