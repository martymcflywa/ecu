/*
 * SensorData.java
 *
 * Created on 20 April 2008, 15:10
 *
 */

package battle.sensors;

/**
 *
 * @author phingsto
 */
public class SensorData
{
    public double distance;
    public double direction; // degrees
    public double heading;  // degrees
    public double speed;
    public double energy;
    public int ID;

    public SensorData(double distance, double direction, double heading, double speed, double energy, int ID)
    {
        this.distance = distance;
        this.direction = direction;
        this.heading = heading;
        this.speed = speed;
        this.energy = energy;
        this.ID = ID;
    }
    
    public static double distanceBetween(SensorData radar1, SensorData radar2)
    {
        return Math.abs
            (
                Math.sqrt
                (
                    radar1.distance*radar1.distance +
                    radar2.distance*radar2.distance -
                    2.0 * radar1.distance * radar2.distance * Math.cos(Math.toRadians(radar2.direction - radar1.direction))
                )
            );
    }
}
