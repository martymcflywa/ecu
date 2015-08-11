package net.sky.csg2341.ponce.ws03;

/**
 * A class that represents a car under cruise control.
 *
 * @author phi
 * @version 1
 */
public class Car {
    public Car(double mass, double friction) {
        this.mass = mass;
        this.friction = friction;

        x = 0;
        v = 0;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setV(double v) {
        this.v = v;
    }

    public void update(double force, double theta, double tick) {
        double newX = x + Math.cos(theta) * v * tick;
        double newV = v + ((force - friction * v) / mass - G * Math.sin(theta)) * tick;

        x = newX;
        v = newV;
    }

    public double getX() {
        return x;
    }

    public double getV() {
        return v;
    }

    public double getMass() {
        return mass;
    }

    public double getFriction() {
        return friction;
    }

    public double getConstantSpeedForce(double theta, double target) {
        return mass * G * Math.sin(theta) + friction * target;
    }

    public double getMaxForce(double target) {
        return getConstantSpeedForce(Math.PI / 4, target);
    }

    public double getMaxAcceleration(double target) {
        return 2.0 * G;
    }

    private double x;
    private double v;

    private double mass; // kg
    private double friction; // n/(m/s)
    private static double G = 9.8; // m/s2
}
