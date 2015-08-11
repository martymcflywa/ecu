package net.sky.csg2341.ponce.ws03;

import au.edu.ecu.is.fuzzy.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Test driver for the cruise control problem
 *
 * @author phi
 * @version 1
 */
public class CruiseControlTest extends JPanel
{
    public CruiseControlTest(CruiseControlSetup setup, CruiseController controller)
    {
        this.setup = setup;
        this.controller = controller;
        
        setLayout(new BorderLayout());
        
        add(new CruiseControlPanel(this.setup), BorderLayout.NORTH);
        
        if(controller.getRuleSet() != null)
        {
            JPanel rulePanel = new FuzzyRuleMatrixPanel(controller.getRuleSet(), controller.getSpeedError(),
                    controller.getAcceleration(), controller.getForceChange());
            add(rulePanel, BorderLayout.CENTER);
        }
        
        controlPanel = new ControlPanel();
        add(controlPanel, BorderLayout.SOUTH);
        
        runner = new Runner();
    }
    
    public static void main(String[] args)
    {
        final double MASS = 2000.0;//1000.0;
        final double FRICTION = 5.0;//10.0;
        final double MINH = 3.0;
        final double MAXH = 30.0;
        final double MINL = 300.0;
        final double MAXL = 500.0;
        final double WINDOWWIDTH = 1200.0;
        final double TARGET = 25.0; //15.0;
        
        try
        {
            CruiseControlSetup setup = new CruiseControlSetup(MASS, FRICTION, MINH, MAXH, MINL, MAXL, WINDOWWIDTH, TARGET);
            CruiseController controller;
                     
            controller = new MyCruiseController(); 
            
            CruiseControlTest tester = new CruiseControlTest(setup, controller);
            
            tester.display();
            
            new Thread(tester.runner).start();
        }
        catch(Exception e)
        {
            e.printStackTrace(System.err);
            System.exit(0);
        }
    }
    
    public void display()
    {
        JFrame viewer = new JFrame("CruiseControl");
        viewer.getContentPane().add(new JScrollPane(this));
        
        viewer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        viewer.pack();
        viewer.setVisible(true);
    }
    
    private class Runner implements Runnable
    {
        public void run()
        {
            setup.init();
            running = true;
            while(!stop)
            {
                try
                {
                    Thread.sleep((long)(500*TICK));
                }
                catch(InterruptedException e)
                {}
                
                if(stepping || !paused)
                {
                    setup.update(controller.computeForceChange(setup.getSpeedError(), setup.getA()), TICK);
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
            tap = new JButton("restart");
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
            else
                if(e.getSource() == pause)
                {
                if(running)
                {
                    setPaused(!paused);
                    stepping = false;
                }
                }
                else
                    if(e.getSource() == step)
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
    
    private CruiseControlSetup setup;
    private CruiseController controller;
    private ControlPanel controlPanel;
    private Runner runner;
    private boolean stop = false;
    private boolean paused = false;
    private boolean stepping = false;
    private boolean running = false;
    private static final double TICK = 0.5;
}
