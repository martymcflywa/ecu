import java.awt.*;
import javax.swing.*;

/**
 * Write a description of class PendulumPanel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PendulumPanel extends JPanel implements PendulumListener
{
    public PendulumPanel(InvertedPendulum pendulum)
    {
        setPreferredSize(new Dimension(100, 80));
        setBackground(Color.white);
        
        width = pendulum.getWidth();
        
        pendulum.addListener(this);
    }
    
    public void update(double x, double theta)
    {
        this.x = x;
        this.theta = theta;
        
        repaint();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        
        int xpos = (int)((0.5 + x/width)*getWidth());
        int ypos = getHeight() - 5;
        int height = getHeight() - 10;
        double radians = Math.toRadians(theta);
        int xpos2 = (int)(xpos + height*Math.sin(radians));
        int ypos2 = (int)(ypos - height*Math.cos(radians));
        
        g.setColor(Color.black);
        g.drawLine(xpos, ypos, xpos2, ypos2);
 
        g.setColor(Color.red);
        g.fillOval(xpos2 - 5, ypos2 - 5, 11, 11);
    }
    
    public void display()
    {
        JFrame viewer = new JFrame("Inverted Pendulum");
        viewer.getContentPane().add(new JScrollPane(this));
        viewer.pack();
        viewer.show();
    }
    
    private double x;
    private double theta;
    private double width;
}
