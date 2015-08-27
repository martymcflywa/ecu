package battle;

import battle.saucers.Saucer;
import battle.saucers.controllers.*;
import battle.starfield.Starfield;
import java.util.ArrayList;

/**
 * Run a tournament without the GUI
 *
 * @author phi
 */
public class Tournament
{
    private static final double SECONDS = 0.05; // controls apparent speed
    
    private Starfield field;
    private ArrayList<Saucer> saucers;
    
    private static final int RUNS = 10;
    
    public static void main(String[] args) throws Exception
    {
        new Tournament().run(RUNS);
    }
    
    private void run(int runs) throws Exception
    {
        saucers = new ArrayList<Saucer>();
        
        field = new Starfield(Constants.STARFIELD_WIDTH, Constants.STARFIELD_HEIGHT);
        
        // list the combatants here
        //saucers.add(new Saucer(field, new SimpleController()));
        saucers.add(new Saucer(field, new SimpleController()));
        saucers.add(new Saucer(field, new FuzzyController()));
        saucers.add(new Saucer(field, new CheckSixController()));
        
        double[] scores = new double[saucers.size()];
        
        for(int i = 0; i < saucers.size(); i++)
        {
            for(int j = i+1; j < saucers.size(); j++)
            {
                for(int k = 0; k < runs; k++)
                {
                    field = new Starfield(Constants.STARFIELD_WIDTH, Constants.STARFIELD_HEIGHT);

                    Saucer saucer1 = saucers.get(i);
                    Saucer saucer2 = saucers.get(j);

                    saucer1.setOpponent(saucer2);
                    saucer2.setOpponent(saucer1);
                    field.addSaucer(saucer1);
                    field.addSaucer(saucer2);

                    System.out.println(saucer1.getControllerName() + " vs " + saucer2.getControllerName());
                    run();
                    for(Saucer saucer: field.getSaucers())
                    {
                        System.out.println(saucer.getControllerName()+"\t\t"+saucer.getEnergyString());
                    }
                    scores[i] += saucer1.getEnergy();
                    scores[j] += saucer2.getEnergy();
                }
            }
        }

        System.out.println();
        System.out.println("Averages:");
        for(int i = 0; i < saucers.size(); i++)
        {
            System.out.println(saucers.get(i).getControllerName() + "\t" + (scores[i]/(runs*(saucers.size()-1))));
        }
        System.out.println();
    }
    
    public void run() throws Exception
    {
        while(field.getSaucerManager().numberAlive() > 1)
        {
            field.update(SECONDS);
        }
    }
    
}
