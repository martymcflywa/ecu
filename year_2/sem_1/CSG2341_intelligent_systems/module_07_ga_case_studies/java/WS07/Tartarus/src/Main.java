/*
 * Main.java
 *
 * Created on 27 July 2006, 09:29
 *
 * Driver for an application that evolves solutions to Tartarus problems
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.text.NumberFormat;

import au.edu.ecu.is.evolution.*;

/**
 *
 * @author phingsto
 */
public class Main implements Runnable
{
    private JFrame frame;
    private Board board;
    private BoardPanel boardPanel;
    private TestCase[] cases;
    private ControlPanel controlPanel;
    private TestCase test;
    private NumberFormat format;
    
    /** Creates a new instance of Main */
    public Main() throws Exception
    {
        format = NumberFormat.getInstance();
        format.setMaximumFractionDigits(3);
        
        board = new Board(6, 6);
        boardPanel = new BoardPanel(board);
        cases = TestCase.getCases();
        controlPanel = new ControlPanel(this);
        
        frame = new JFrame("Tartarus");
        
        frame.setLocation(100, 100);
        frame.setSize(600, 700);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.add(boardPanel, BorderLayout.CENTER);
        frame.add(controlPanel, BorderLayout.SOUTH);
        
        frame.setVisible(true);

        setCase(cases[0]);
        controlPanel.updateInfo();
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception
    {
        Main main = new Main();        
    }

    public void run()
    {
        DozerPlan best = test.getBestPlan();
        
        best.begin();
        while(!best.isDone())
        {
            try
            {
                Thread.sleep(500);
            }
            catch(InterruptedException e){}
            
            DozerMove move = best.next();
            switch(move)
            {
                case FORWARD:
                    board.forward();
                    break;
                case LEFT:
                    board.left();
                    break;
                case RIGHT:
                    board.right();
                    break;
            }

            test.move(move, board.getScore());
    
            boardPanel.repaint();
            controlPanel.updateInfo();
        }
        
        enableButtons();
    }
    
    public double evaluate(TestCase test, DozerPlan plan)
    {
        this.test = test;
        test.reload();
        board.setPosition(test.getPosition());
        
        double best = test.getTotal();
        
        plan.begin();
        while(!plan.isDone())
        {
            DozerMove move = plan.next();
            boolean ignored = false;
            
            switch(move)
            {
                case FORWARD:
                    ignored = !board.forward();
                    //board.forward();
                    break;
                case LEFT:
                    board.left();
                    break;
                case RIGHT:
                    board.right();
                    break;
            }
            
            if(ignored)
            {
                // remove invalid attempts to move forward
                plan.ignore();
            }
            else
            {
                test.move(move, board.getScore());
                if(test.getTotal() > best) best = test.getTotal();
            }
        }
        
        controlPanel.updateInfo();
        
        return best;
    }
    
    public void setCase(TestCase test)
    {
        this.test = test;
        
        test.reload();
        
        board.setPosition(test.getPosition());
        
        boardPanel.repaint();
        controlPanel.updateInfo();
    }
    
    public void disableButtons()
    {
        controlPanel.disableButtons();
    }

    public void enableButtons()
    {
        controlPanel.enableButtons();
    }
    
    public class ControlPanel extends JPanel
    {
        private TestCasePanel[] panels;
        private JTextArea scoreInfo;
        
        public ControlPanel(Main owner) throws Exception
        {
            JPanel casesPanel = new JPanel();
            casesPanel.setLayout(new GridLayout(1, cases.length));
        
            panels = new TestCasePanel[cases.length];
            for(int i = 0; i < cases.length; i++)
            {
                panels[i] = new TestCasePanel(owner, cases[i], i);
                casesPanel.add(panels[i]);
            }
            
            add(casesPanel);
            
            scoreInfo = new JTextArea();
            add(scoreInfo);
        }
        
        public void disableButtons()
        {
            for(int i = 0; i < cases.length; i++)
            {
                panels[i].disableButtons();
            }
        }
        
        public void enableButtons()
        {
            for(int i = 0; i < cases.length; i++)
            {
                panels[i].enableButtons();
            }
        }
        
        public void updateInfo()
        {
            double score = 0.0;
            
            for(int i = 0; i < cases.length; i++)
            {
                score += panels[i].updateInfo();
            }
            
            scoreInfo.setText("Overall total = " + format.format(score));
        }
    }
    
    public class TestCasePanel extends JPanel implements ActionListener, EAListener
    {
        private Main owner;
        private TestCase test;
        private JLabel testCaseLabel;
        private JButton replayButton;
        private JButton evolveButton;
        private JProgressBar progressBar;
        private JTextArea info;
        
        private GeneticAlgorithm ga = null;
        private PlanEvaluator eval;
        
        private static final int POPULATION = 250;
        private static final int GENERATIONS = 250;
        
        public TestCasePanel(Main owner, TestCase test, int no) throws Exception
        {
            eval = new PlanEvaluator();
            Object[] params = {new Integer(100)};
            
            ga = new GeneticAlgorithm
                    (
                        DozerPlan.class,
                        params,
                        POPULATION,
                        new java.util.Random(),
                        0.015, // mutation probability
                        0.05,  // no crossover
                        eval,
                        new GenerationsTerminator(GENERATIONS),
                        new StochasticUniformSelector(new java.util.Random()),
                        true
                    );           
            
            ga.addListener(this);
            
            this.owner = owner;
            this.test = test;
            
            this.setLayout(new GridLayout(2, 0));
            
            JPanel inner = new JPanel(new GridLayout(4, 0));
            
            testCaseLabel = new JLabel("Problem " + no);
            
            replayButton = new JButton("Replay best");
            replayButton.setEnabled(false);
            replayButton.addActionListener(this);
            
            evolveButton = new JButton("Evolve");
            evolveButton.addActionListener(this);
            
            progressBar = new JProgressBar(0, GENERATIONS);
            progressBar.setValue(0);
            progressBar.setStringPainted(true);
            
            inner.add(testCaseLabel);
            inner.add(replayButton);
            inner.add(evolveButton);
            inner.add(progressBar);
            
            info = new JTextArea("");
            info.setEditable(false);
            
            add(inner);
            add(info);
        }
        
        public void actionPerformed(ActionEvent event)
        {
            owner.setCase(test);

            owner.disableButtons();
            
            if(event.getSource() == replayButton)
            {
                (new Thread(owner)).start();
            }
            else if(event.getSource() == evolveButton)
            {
                (new Thread(ga)).start();
            }
        }
        
        public void disableButtons()
        {
            replayButton.setEnabled(false);
            evolveButton.setEnabled(false);
        }
        
        public void enableButtons()
        {
            replayButton.setEnabled(true);
            evolveButton.setEnabled(true);
        }
                        
        public void adviseInit()
        {
            progressBar.setValue(0);
        }

        public void adviseUpdate()
        {
            progressBar.setValue(ga.getGeneration());
        }

        public void adviseDone()
        {
            owner.enableButtons();
        }

        public double updateInfo()
        {
            info.setText(
                    "best moves: " + test.getBestMoves() + "\n" +
                    "best score: " + test.getBestScore() + "\n" +
                    "best total: " + format.format(test.getBestTotal())
                    );
            
            return test.getBestTotal();
        }
        
        // the ga needs an evaluator
        public class PlanEvaluator extends Evaluator
        {
            public double evaluate(Evolvable evolvable)
            {
                DozerPlan plan = (DozerPlan)evolvable;
                
                return owner.evaluate(test, plan);
            }
        }
    }
}    
