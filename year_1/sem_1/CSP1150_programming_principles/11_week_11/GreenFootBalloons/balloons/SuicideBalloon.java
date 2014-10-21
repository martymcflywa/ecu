import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Subclass of Balloon. SuicideBalloon explodes and takes other balloons with it.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20141021
 */
public class SuicideBalloon extends Balloon {
    
    /**
     * Ballon explodes when popped.
     * 
     * @param args unused
     */
    @Override
    public void pop() {
        
        explode();
        super.pop();
    }
    
    /**
     * Defines how the balloon explodes.
     * Copy of Bomb's method, without call to removeObject.
     */
    private void explode() {
    
        BalloonWorld w;
        List balloons = getWorld().getObjects(Balloon.class);
        
        getWorld().addObject(new Explosion(), getX(), getY());
    }
}
