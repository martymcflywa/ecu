package net.sky.csg2341.ponce.ws03;

import java.awt.*;
import java.awt.geom.*;

/**
 * A class to represent a hill on the road
 *
 * @author phi
 * @version 1
 */
public class Hill {
    public Hill(double startX, double amplitude, double length) {
        this.startX = startX;
        this.amplitude = amplitude;
        this.length = length;

        startY = -amplitude;
        height = 2.0 * amplitude;

        window = new Rectangle2D.Double(startX, startY, length, height);
    }

    public void setStartX(double startX) {
        this.startX = startX;
        window.x = startX;
    }

    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
        startY = -amplitude;
        height = 2.0 * amplitude;
        window.y = startY;
        window.height = height;
    }

    public void setLength(double length) {
        this.length = length;
        window.width = length;
    }

    public double getStartX() {
        return startX;
    }

    public double getLength() {
        return length;
    }

    private double getY(double x) {
        return amplitude * Math.sin(2.0 * Math.PI * (x - startX) / length);
    }

    public double getTheta(double x) {
        return Math.atan(amplitude * 2.0 * Math.PI * Math.cos(2.0 * Math.PI * (x - startX) / length) / length);
    }

    private Color GRASS = new Color(0, 128, 0);

    public void draw(Graphics2D g, Rectangle2D.Double viewport, double carX, double bottom) {
        double prevX = startX;
        double prevY = getY(prevX);
        for (double x = startX + stepX; x < startX + length; x += stepX) {
            double y = getY(x);
            Polygon poly = new Polygon();
            poly.addPoint((int) (viewport.x + viewport.width * (prevX - startX) / length), (int) (viewport.y - viewport.height * (prevY - startY) / height));
            poly.addPoint((int) (0.5 + viewport.x + viewport.width * (x - startX) / length), (int) (viewport.y - viewport.height * (y - startY) / height));
            poly.addPoint((int) (0.5 + viewport.x + viewport.width * (x - startX) / length), (int) (bottom));
            poly.addPoint((int) (viewport.x + viewport.width * (prevX - startX) / length), (int) (bottom));
            g.setColor(GRASS);
            g.fill(poly);
            g.setColor(Color.black);
            g.drawLine((int) (viewport.x + viewport.width * (prevX - startX) / length),
                    (int) (viewport.y - viewport.height * (prevY - startY) / height),
                    (int) (viewport.x + viewport.width * (x - startX) / length),
                    (int) (viewport.y - viewport.height * (y - startY) / height));
            prevX = x;
            prevY = y;
        }

        if (carX >= startX && carX <= startX + length) {
            int xpos = (int) (viewport.x + viewport.width * (carX - startX) / length);
            int ypos = (int) (viewport.y - viewport.height * (getY(carX) - startY) / height);
            g.setColor(Color.red);
            g.fillOval(xpos - 5, ypos - 5, 11, 11);
        }
    }

    public Rectangle2D.Double getWindow() {
        return window;
    }

    private double startX;
    private double amplitude;
    private double length;
    private double startY;
    private double height;

    private Rectangle2D.Double window;

    private static final double stepX = 1.0;
}
