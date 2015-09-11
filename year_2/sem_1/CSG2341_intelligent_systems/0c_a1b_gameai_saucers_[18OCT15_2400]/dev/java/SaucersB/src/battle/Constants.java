/*
 * Constants.java
 *
 * Created on 19 March 2008, 08:45
 *
 */

package battle;

/**
 *
 * @author phingsto
 */
public interface Constants
{
    public final double SECONDS = 0.05; // controls apparent speed
    public final double TIME_LIMIT = 500.0;
    
    // collect together lots of constants here
    // to make it simpler to adjust the balance of the game
    
    // size of battle area
    public final double STARFIELD_WIDTH = 3750.0;
    public final double STARFIELD_HEIGHT = 3000.0;
    
    public final int STARFIELD_N_POWERUPS = 5;
   
    public final double SAUCER_START_ENERGY = 10000.0; 
    public final double SAUCER_MAX_POWER = 100.0;  // of a blast  
    public final double SAUCER_MIN_SPEED = 50;
    public final double SAUCER_MAX_SPEED = 125;
    public final double SAUCER_HIT_FACTOR = 6;  // damage to opponent relative to energy of blast    
    public final double SAUCER_COOL_TIME = 1;   // how long between shots
    public final double SAUCER_TURN_COST = 0.005;
    public final double SAUCER_BURN_RATE = 0.001/SECONDS;
    public final double SAUCER_SHIELD_BURN_RATE = 0.1/SECONDS;

    public final double BLAST_SPEED = 1.5*SAUCER_MAX_SPEED;
    public final double BLAST_DECAY = 0.02; // how much power is lost per second
    
    public final double SHIELD_EFFECT = 0.1; // blast reduced by this factor
    
    public final double POWERUP_POWER = 1000;
    public final double POWERUP_SHOW_PROB = 0.01;   // probability of appearing per second
    public final double POWERUP_HIDE_PROB = 0.02;   // probability of disappearing per second
    public final double POWERUP_MAXSPEED = 10;    
}
