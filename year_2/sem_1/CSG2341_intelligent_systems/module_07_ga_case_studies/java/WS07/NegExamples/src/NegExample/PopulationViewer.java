package NegExample;

import au.edu.ecu.is.evolution.*;

import java.awt.*;

import javax.swing.*;

/**
 * Write a description of class PopulationViewer here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PopulationViewer  extends JPanel implements EAListener
{
    /**
     * Constructor for a Panel that shows a population
     * of solutions for the first example for Neg.
     * 
     */
    public PopulationViewer(NegExampleProblem problem, EvolutionaryAlgorithm algorithm)
    {
        this.problem = problem;
        this.algorithm = algorithm;
        
        // calculate x and y ranges
        // these are used to draw graphs of the function
        // being maximised and the population of solutions
        maxX = Math.pow(2, problem.getNBits());
        maxY = minY = problem.evaluate(0);
        for(int i = 1; i < maxX; i++)
        {
            double y = problem.evaluate(i); 
            maxY = Math.max(maxY, y);
            minY = Math.min(minY, y);
        }
        
        setPreferredSize(new Dimension(400, 400));
        
        algorithm.addListener(this);
    }
    
    public void adviseInit()
    {
        running = true;
    }
    
    public void adviseUpdate()
    {
        repaint();
    }
    
    public void adviseDone()
    {
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        if(running)
        {
            Evolvable[] population = algorithm.getPopulation();
            Rectangle viewport = new Rectangle(0, 0, getWidth(), getHeight());
            int prevX = toX(0, viewport);
            int prevY = toY(problem.evaluate(0), viewport);
            
            g.setColor(Color.black);
            for(int i = 1; i < maxX; i++)
            {
                int x = toX(i, viewport);
                int y = toY(problem.evaluate(i), viewport);
                
                g.drawLine(prevX, prevY, x, y);
                
                prevX = x;
                prevY = y;
            }
            
            g.setColor(Color.cyan);
            for(int i = 0; i < population.length; i++)
            {
                NegExampleEvolvable neg = (NegExampleEvolvable)population[i];
                
                int x = neg.getValue();
                double y = problem.evaluate(x);
                
                g.fillOval(toX(x, viewport) - 3, (int)Math.round(toY(y, viewport) - 3), 7, 7);
            }
            
            NegExampleEvolvable neg = (NegExampleEvolvable)population[0];
            g.setColor(Color.red);
            g.fillOval(toX(neg.getValue(), viewport) - 5, (int)Math.round(toY(problem.evaluate(neg.getValue()), viewport) - 5), 11, 11);
        }
    }
    
    public void display()
    {
        JFrame viewer = new JFrame("Population Viewer");
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(this, BorderLayout.CENTER);
        viewer.getContentPane().add(new JScrollPane(container));
        viewer.pack();
        viewer.show();
    }

    // a couple of utility functions to help draw the graph
    private int toX(int i, Rectangle viewport)
    {
        return (int)Math.round(viewport.x + GAP + (viewport.width - 2*GAP)*i/maxX);
    }
    
    private int toY(double y, Rectangle viewport)
    {
        return (int)Math.round(viewport.y + viewport.height - GAP - (viewport.height - 2*GAP)*(y - minY)/(maxY - minY));
    }
    
    private double maxX;
    private double maxY;
    private double minY;
    private NegExampleProblem problem;
    private EvolutionaryAlgorithm algorithm;
    private boolean running;

    private static final int GAP = 10;
}
