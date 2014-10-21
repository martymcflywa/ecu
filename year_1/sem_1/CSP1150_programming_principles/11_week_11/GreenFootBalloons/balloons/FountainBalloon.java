import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Subclass of Balloon. FountainBalloons release fountain of spikes when popped.
 * The spikes shoot upwards before falling downwards.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20141021
 */
public class FountainBalloon extends Balloon {

    /**
     * Pop this balloon. Spikes shoot upward.
     * 
     * @param args unused
     */
    @Override
    public void pop() {
    
        for(int xSpeed = -3; xSpeed <= 3; xSpeed++) {
        
            Spike spike = new Spike(xSpeed, -20);
            getWorld().addObject(spike, getX(), getY());
        }
        
        super.pop();
    }
}
