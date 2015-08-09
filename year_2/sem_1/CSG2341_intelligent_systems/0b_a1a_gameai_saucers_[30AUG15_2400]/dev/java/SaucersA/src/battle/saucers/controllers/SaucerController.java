package battle.saucers.controllers;

import java.awt.Color;

/**
 * Interface for a controller to control a saucer
 * 
 * @author phi
 */
public interface SaucerController
{
    // this one is called in each game tick
    public void sensorUpdate
    (
        double opponentDistance,
        double opponentDirection, // relative to me, in degrees, 0 = straight ahead
        double opponentEnergy,
        double energy
    ) throws Exception;
    
    // then these are called to get the saucer's actions
    public double getFirePower() throws Exception;
    
    public double getSpeed() throws Exception;
    
    public double getTurn() throws Exception; // in degrees
    
    // these used for graphics and reporting
    public String getName();
    
    public Color getBaseColor();
    
    public Color getTurretColor();
}
