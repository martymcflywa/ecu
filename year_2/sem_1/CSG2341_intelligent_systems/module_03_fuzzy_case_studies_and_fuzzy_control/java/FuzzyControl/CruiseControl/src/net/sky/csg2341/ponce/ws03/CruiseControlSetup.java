package net.sky.csg2341.ponce.ws03;

import java.util.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * A class to describe a cruise control problem.
 *
 * @author phi
 * @version 1
 */
public class CruiseControlSetup {
    public CruiseControlSetup(double carMass, double carFriction, double minHillAmplitude, double maxHillAmplitude,
                              double minHillLength, double maxHillLength, double width, double targetSpeed) {
        random = new Random();

        car = new Car(carMass, carFriction);
        maxForce = car.getConstantSpeedForce(Math.PI / 4, targetSpeed);
        minForce = car.getConstantSpeedForce(-Math.PI / 4, targetSpeed);

        this.minHillAmplitude = minHillAmplitude;
        this.maxHillAmplitude = maxHillAmplitude;
        this.minHillLength = minHillLength;
        this.maxHillLength = maxHillLength;

        this.width = width;
        this.height = 2.0 * maxHillAmplitude;

        nHills = (int) (0.5 + width / minHillLength);
        hills = new Hill[nHills];
        for (int i = 0; i < nHills; i++) {
            hills[i] = new Hill(0.0, 0.0, 0.0);
        }

        this.targetSpeed = targetSpeed;

        listeners = new ArrayList<CruiseListener>();

        init();
    }

    public final void init() {
        double startX = -width / 2.0;
        for (int i = 0; i < nHills; i++) {
            startX = configureHill(hills[i], startX);
        }

        car.setX(0.0);
        car.setV(targetSpeed);
        force = car.getConstantSpeedForce(getTheta(car.getX()), targetSpeed);
        acceleration = 0.0;

        nVals = 0;
        addVal();
    }

    public Car getCar() {
        return car;
    }

    public double getX() {
        return car.getX();
    }

    public double getV() {
        return car.getV();
    }

    public double getSpeedError() {
        return car.getV() - targetSpeed;
    }

    public double getA() {
        return acceleration;
    }

    public double getTarget() {
        return targetSpeed;
    }

    public void update(double forceChange, double tick) {
        for (CruiseListener cl : listeners) {
            cl.update();
        }

        force += forceChange;

        double v = car.getV();
        car.update(force, getTheta(car.getX()), tick);
        acceleration = (car.getV() - v) / tick;

        while (hills[0].getStartX() + hills[0].getLength() < car.getX() - width / 2) {
            addHill();
        }

        addVal();
    }

    private void addVal() {
        synchronized (this) {
            if (nVals == MAXVALS) {
                System.arraycopy(xVals, 1, xVals, 0, MAXVALS - 1);
                System.arraycopy(vVals, 1, vVals, 0, MAXVALS - 1);
                System.arraycopy(fVals, 1, fVals, 0, MAXVALS - 1);

                nVals--;
            }

            xVals[nVals] = car.getX();
            vVals[nVals] = car.getV();
            fVals[nVals] = force;

            nVals++;
        }
    }

    private void addHill() {
        synchronized (this) {
            Hill save = hills[0];

            System.arraycopy(hills, 1, hills, 0, nHills - 1);

            configureHill(save, hills[nHills - 1].getStartX() + hills[nHills - 1].getLength());
            hills[nHills - 1] = save;
        }
    }

    private double getTheta(double x) {
        synchronized (this) {
            // find right hill
            int i = 0;
            while (x > hills[i].getStartX() + hills[i].getLength()) i++;

            return hills[i].getTheta(x);
        }
    }

    private double configureHill(Hill hill, double hillStart) {
        hill.setStartX(hillStart);
        hill.setAmplitude(minHillAmplitude + random.nextDouble() * (maxHillAmplitude - minHillAmplitude));
        hill.setLength(minHillLength + random.nextDouble() * (maxHillLength - minHillLength));

        return hillStart + hill.getLength();
    }

    public void draw(Graphics oldG, Rectangle2D.Double viewport) {
        Graphics2D g = (Graphics2D) oldG;

        g.setPaint
                (new GradientPaint(
                                0f, (float) (viewport.y - viewport.height), Color.BLUE,
                                0f, (float) (viewport.y - viewport.height / 2), Color.WHITE, true
                        )
                );
        g.fillRect((int) viewport.x, (int) (viewport.y - viewport.height), (int) viewport.width, (int) viewport.height);

        Rectangle2D.Double subViewport = new Rectangle2D.Double(0.0, 0.0, 0.0, 0.0);
        double carX = car.getX();

        synchronized (this) {
            for (int i = 0; i < nHills; i++) {
                // draw the hill (and car if it's here)
                Rectangle2D.Double window = hills[i].getWindow();

                subViewport.x = viewport.x + viewport.width * (window.x - carX + width / 2) / width;
                subViewport.y = viewport.y - viewport.height / 2 - viewport.height * (window.y + maxHillAmplitude) / (2 * height);
                subViewport.width = viewport.width * window.width / width;
                subViewport.height = viewport.height * window.height / (2 * height);

                hills[i].draw(g, subViewport, carX, viewport.height / 2);

                // draw the instrument readout in the bottom half
                g.setColor(Color.WHITE);
                g.fillRect((int) viewport.x, (int) (viewport.y - viewport.height / 2), (int) viewport.width, (int) (viewport.height / 2));

                // target speed
                g.setColor(Color.ORANGE);
                g.drawLine((int) (viewport.x),
                        (int) (viewport.y - viewport.height / 4),
                        (int) (viewport.x + viewport.width),
                        (int) (viewport.y - viewport.height / 4));

                double prevX = xVals[0];
                double prevV = vVals[0];
                double prevF = fVals[0];
                for (int j = 1; j < nVals; j++) {
                    // speed
                    g.setColor(Color.BLUE);
                    g.drawLine((int) (viewport.x + viewport.width * (prevX - carX + width / 2) / width),
                            (int) (viewport.y - viewport.height * (prevV) / (4 * targetSpeed)),
                            (int) (viewport.x + viewport.width * (xVals[j] - carX + width / 2) / width),
                            (int) (viewport.y - viewport.height * (vVals[j]) / (4 * targetSpeed)));
                    // force
                    g.setColor(Color.GREEN);
                    g.drawLine((int) (viewport.x + viewport.width * (prevX - carX + width / 2) / width),
                            (int) (viewport.y - viewport.height * (prevF - minForce) / (2 * (maxForce - minForce))),
                            (int) (viewport.x + viewport.width * (xVals[j] - carX + width / 2) / width),
                            (int) (viewport.y - viewport.height * (fVals[j] - minForce) / (2 * (maxForce - minForce))));
                    prevX = xVals[j];
                    prevV = vVals[j];
                    prevF = fVals[j];
                }
            }
        }

        g.setColor(Color.ORANGE);
        g.drawString("Orange = target speed", (float) (viewport.x + viewport.width - 150), (float) (viewport.y - 20));
        g.setColor(Color.BLUE);
        g.drawString("Blue = speed", (float) (viewport.x + viewport.width - 150), (float) (viewport.y - 40));
        g.setColor(Color.GREEN);
        g.drawString("Green = force", (float) (viewport.x + viewport.width - 150), (float) (viewport.y - 60));
    }

    public void addListener(CruiseListener listener) {
        listeners.add(listener);
    }

    private Car car;
    private Hill[] hills;
    private int nHills;
    private double minHillAmplitude;
    private double maxHillAmplitude;
    private double minHillLength;
    private double maxHillLength;
    private double width;
    private double height;
    private double targetSpeed;
    private double maxForce;
    private double minForce;

    private Random random;

    private static final int MAXVALS = 200;
    private double[] xVals = new double[MAXVALS];
    private double[] vVals = new double[MAXVALS];
    private double[] fVals = new double[MAXVALS];
    private int nVals = 0;
    private double acceleration;

    private ArrayList<CruiseListener> listeners;

    private double force;
}
