/*
 * Tournament.java
 *
 * Created on 19 March 2008, 13:22
 *
 */

package battle;

import battle.saucers.Saucer;
import battle.saucers.controllers.*;
import battle.starfield.Starfield;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author phingsto
 */
public class Tournament implements Constants
{
    private static final Random random = new Random();
    private static final int ROUNDS = 10;
    private static final int CONTROLLERS_PER_ROUND = 12;
    
    // Here are the controllers used in each battle : replace some of the SimpleControllers for testing
    private static SaucerController[] controllers;   
    static
    {
        try
        {
            controllers = new SaucerController[]
            {
                new SimpleController(),
                new SimpleController(),
                new SimpleController(),
                new SimpleController(),
                new SimpleController(),
                new SimpleController(),
                new SittingDuckController(),
                new SittingDuckController(),
                new SittingDuckController(),
                new SittingDuckController(),
                new SittingDuckController(),
                new SittingDuckController()
            };
        }
        catch(Exception e)
        {
            System.err.println("Unable to create controllers");
            e.printStackTrace(System.err);
            System.exit(0);
        }
    }
    
    private int[][] results;
    private int[] rounds;
    
    public Tournament()
    {
        results = new int[controllers.length][ROUNDS];
        rounds = new int[controllers.length];
    }
    
    public static void main(String[] args) throws Exception
    {
        new Tournament().run(ROUNDS);
    }
    
    private int nextSelected()
    {
        // find least number of selections so far
        int least = rounds[0];
        for(int i = 1; i < rounds.length; i++)
        {
            if(rounds[i] < least) least = rounds[i];
        }
        
        // find a controller that has been selected least number of times
        int index = random.nextInt(rounds.length);
        boolean found = rounds[index] == least;
        while(!found)
        {
            index = (index+1)%rounds.length;
            found = rounds[index] == least;
        }
            
        return index;
    }
    
    private void run(int runs) throws Exception
    {
        for(int i = 0; i < runs; i++)
        {
            Starfield field = new Starfield(STARFIELD_WIDTH, STARFIELD_HEIGHT, STARFIELD_N_POWERUPS);
            int indexes[] = new int[CONTROLLERS_PER_ROUND]; 
            
            for(int j = 0; j < CONTROLLERS_PER_ROUND; j++)
            {
                int index = nextSelected();
                indexes[j] = index;
                rounds[index]++;
                
                field.addSaucer(new Saucer(field, controllers[index]));
            }
        
            run(field);
            
            ArrayList<Saucer> saucers = field.getSaucers();
            for(int j = 0; j < saucers.size(); j++)
            {
                results[indexes[j]][i] = saucers.get(j).getPlacing();
            }
        }

        System.out.println();
        for(int i = 0; i < controllers.length; i++)
        {
            System.out.print(controllers[i].getName());
            double total = 0;
            int n = 0;
            for(int j = 0; j < runs; j++)
            {
                System.out.print("\t" + results[i][j]);
                if(results[i][j] != 0)
                {
                    n++;
                    total += results[i][j];
                }
            }
            System.out.println("\t" + total/n);
        }
        System.out.println();
    }
    
    public void run(Starfield field) throws Exception
    {
        double time = 0;
        while(field.getSaucerManager().numberAlive() > 1 && time < TIME_LIMIT)
        {
            time += SECONDS;
            field.update(SECONDS);
        }
        field.finalisePlacings();
    }    
}
