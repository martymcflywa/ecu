import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * This class defines the spikes that shoot out of
 * FountainBalloon and ShowerBalloon.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20141021
 */
public class Spike extends Actor {
    private int xSpeed;
    private int ySpeed;
    
    /**
     * The Spike constructor.
     * 
     * @param args unused
     */
    public Spike(int xSpeed, int ySpeed) {
    
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    
    /**
     * Act - do whatever the Spike wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() {
        // call move
        move();
        
        // detect collision
        checkBalloons();
        
        // clear spikes
        if(getY() == getWorld().getHeight() - 1) {
            getWorld().removeObject(this);
        }
    }
    
    /**
     * This method defines how the spikes move.
     * 
     * @param args unused
     */
    private final void move() {
        // calculate next loc
        int x = getX() + xSpeed;
        int y = getY() + ySpeed;
        
        // adjust so that the spike doesn't go off the screen
        
        int width = getWorld().getWidth();
        int height = getWorld().getHeight();
        
        // bounce off the left
        if(x < 0) {
            x = 0;
            xSpeed = -xSpeed;
            
            // bounce off the right
        } else if(x > width - 1) {
            x = width - 1;
            xSpeed = -xSpeed;
        }
        
        // bounce off the bottom
        if(y < 0) {
            y = 0;
            ySpeed = -ySpeed;
            
            // bounce off the top
        } else if(y > height - 1) {
            y = height - 1;
            ySpeed = -ySpeed;
        }
        
        // now move it
        setLocation(x, y);
        
        // make it fall faster next time
        ySpeed += 1;
    }
    
    /**
     * This method detects Spike collision with Balloons.
     * 
     * @param args unused
     */
    private final void checkBalloons() {
        
        Actor balloon = getOneObjectAtOffset(0, 0, Balloon.class);
        
        if(balloon == null) {
            balloon = getOneObjectAtOffset(0, 0, FountainBalloon.class);
        }
        
        if(balloon == null) {
            balloon = getOneObjectAtOffset(0, 0, ShowerBalloon.class);
        }
        
        if(balloon != null) {
            ((Balloon)balloon).pop();
        }
    }
}
