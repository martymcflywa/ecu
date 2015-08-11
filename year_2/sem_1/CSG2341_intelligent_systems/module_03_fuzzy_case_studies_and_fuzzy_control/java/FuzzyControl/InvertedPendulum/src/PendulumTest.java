import au.edu.ecu.is.fuzzy.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * A class to test a pendulum controller
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PendulumTest extends JPanel
{
    public PendulumTest(InvertedPendulum pendulum, PendulumController controller)
    {
        this.pendulum = pendulum;
        this.controller = controller;
        
        setLayout(new BorderLayout());
        
        add(new PendulumPanel(this.pendulum), BorderLayout.NORTH);
        
        JPanel rulePanel = new FuzzyRuleMatrixPanel(controller.getRuleSet(), controller.getDtheta(),
                controller.getTheta(), controller.getForce());
        add(rulePanel, BorderLayout.CENTER);
        
        controlPanel = new ControlPanel();
        add(controlPanel, BorderLayout.SOUTH);
        
        runner = new Runner();
    }
    
    public static void main(String[] args)
    {
        try
        {
            PendulumTest tester = new PendulumTest(new InvertedPendulum(1.0, 0.05, 20), new MyPendulumController());
            tester.display();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
            System.exit(0);
        }
    }
    
    public void display()
    {
        JFrame viewer = new JFrame("Inverted Pendulum");
        viewer.getContentPane().add(new JScrollPane(this));
        
        // note the next line causes an error if executed in BlueJ
        viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        viewer.pack();
        viewer.show();
    }
    
    private class Runner implements Runnable
    {
        public void run()
        {
            pendulum.tap(Math.toDegrees(-0.5 + random.nextDouble()));
            running = true;
            while(!stop && !pendulum.isStopped())
            {
                try
                {
                    Thread.sleep((long)(10000*TICK));
                }
                catch(InterruptedException e)
                {}
                
                if(stepping || !paused)
                {
                    pendulum.update(controller.computeForce(pendulum.getTheta(), pendulum.getDtheta()), TICK);
                    if(stepping)
                    {
                        controlPanel.setPaused(true);
                        stepping = false;
                    }
                }
            }
            running = false;
        }
    }
    
    private class ControlPanel extends JPanel implements ActionListener
    {
        public ControlPanel()
        {
            tap = new JButton("tap");
            tap.addActionListener(this);
            add(tap);
            
            pause = new JButton("pause");
            pause.addActionListener(this);
            add(pause);
            
            step = new JButton("step");
            step.addActionListener(this);
            add(step);
        }
        
        public void actionPerformed(ActionEvent e)
        {
            if(e.getSource() == tap)
            {
                stop();
                setPaused(false);
                stepping = false;
                
                new Thread(runner).start();
            }
            else if(e.getSource() == pause)
            {
                if(running)
                {
                    setPaused(!paused);
                    stepping = false;
                }
            }
            else if(e.getSource() == step)
            {
                setPaused(false);
                stepping = true;
                if(!running)
                {
                    new Thread(runner).start();
                }
            }
        }
        
        private void setPaused(boolean newPaused)
        {
            paused = newPaused;
            if(paused)
            {
                pause.setText("resume");
            }
            else
            {
                pause.setText("pause");
            }
        }
        
        private void stop()
        {
            stop = true;
            while(running)
            {
                try
                {
                    Thread.sleep((long)(200));
                }
                catch(InterruptedException ie)
                {}
            }
            stop = false;
        }
        
        private JButton tap;
        private JButton pause;
        private JButton step;
    }
    
    private static final double TICK = 0.001;    // seconds
    private InvertedPendulum pendulum;
    private PendulumController controller;
    private ControlPanel controlPanel;
    private Runner runner;
    private boolean stop = false;
    private boolean paused = false;
    private boolean stepping = false;
    private boolean running = false;
    private Random random = new Random();
}
