import au.edu.ecu.is.evolution.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * A class to watch the robot do its thing.
 * 
 * @author (phi) 
 * @version (2003/2)
 */
public class RobotViewer extends JPanel implements EAListener, Runnable
{
    public RobotViewer(EvolutionaryAlgorithm algorithm, RobotProblem problem, int nSteps)
    {
        this.algorithm = algorithm;
        this.problem = problem;
        this.nSteps = nSteps;
        
        running = false;
     
        setPreferredSize(new Dimension(400, 400));
        controlPanel = new ControlPanel();
        
        algorithm.addListener(this);
    }
    
    public void adviseInit()
    {
        stop = true;
    }
    
    public void adviseUpdate()
    {
    }
    
    public void adviseDone()
    {
        (new Thread(this)).start();
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        if(running)
        {
            Rectangle viewport = new Rectangle(GAP, GAP, getWidth() - 2*GAP, getHeight() - 2*GAP);
            problem.draw(g, viewport);
            robot.draw(g, viewport);
        }
    }

    public void run()
    {
        robot = problem.getRobot();
        EvolvableExpressionTree tree = (EvolvableExpressionTree)algorithm.getBestEver();

       if(tree != null)
       {
           running = true;
           stop = false;
            
            robot.initialise();
            
            for(int i = 0; i < nSteps && !stop; i++)
            {
                repaint();
                
                try { Thread.sleep(100); } catch(Exception e) {}
                
                RobotAction action = (RobotAction)tree.evaluate();
                
                robot.doAction(action);
            }
            
            running = false;
        }
    }
    
    public void display()
    {
        JFrame viewer = new JFrame("Robot Viewer");
        JPanel container = new JPanel();
        container.setLayout(new BorderLayout());
        container.add(this, BorderLayout.CENTER);
        container.add(controlPanel, BorderLayout.SOUTH);
        viewer.getContentPane().add(new JScrollPane(container));
        viewer.pack();
        viewer.setVisible(true);
    }
    
    private class ControlPanel extends JPanel implements ActionListener
    {
        public ControlPanel()
        {
            go = new JButton("run");
            go.addActionListener(this);
            add(go);
        }
        
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == go)
            {
                if(!stop)
                {
                    stop = true;
                    while(running)
                    {
                        try { Thread.sleep(25); } catch(Exception exc){}
                    }
                    adviseDone();
                }
            }
        }
        
        private JButton go;
    }

    private EvolutionaryAlgorithm algorithm;
    private RobotProblem problem;
    private int nSteps;
    
    private boolean running;
    private boolean stop;
    private Robot robot;
    
    private ControlPanel controlPanel;
    
    private static final int GAP = 10;
}
