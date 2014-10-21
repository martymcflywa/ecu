import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Subclass of Balloon. ShowerBalloons release a shower of spikes when popped.
 * The spikes fall downwards and will pop any balloons that they hit on the way down.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20141021
 */
public class ShowerBalloon extends Balloon {

    /**
     * Pop this balloon. Spikes shoot downward.
     * 
     * @param args unused
     */
    @Override
    public void pop() {
    
        for(int xSpeed = -3; xSpeed <= 3; xSpeed++) {
        
            Spike spike = new Spike(xSpeed, 0);
            getWorld().addObject(spike, getX(), getY());
        }
        
        super.pop();
    }
}
