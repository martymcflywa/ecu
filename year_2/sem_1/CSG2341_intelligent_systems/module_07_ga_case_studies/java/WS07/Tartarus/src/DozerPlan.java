/*
 * DozerPlan.java
 *
 * Created on 4 August 2006, 22:43
 *
 * Class represents a plan of movements to solve a Tartarus problem.
 *
 * We have created mutate, crossover etc so that we can evolve plans.
 */

import au.edu.ecu.is.evolution.*;

/**
 *
 * @author phingsto
 */
public class DozerPlan extends Evolvable
{
    private String moves;
    private int cursor;
    
    private static final double CLEANUP_PROB = 0.3;
    
    /** Creates a new instance of DozerPlan */
    public DozerPlan()
    {
        moves = "";
        cursor = 0;
    }
    
    // generate a random plan
    public DozerPlan(Integer length)
    {
        int l = length.intValue();
        
        moves = "";
        for(int i = 0; i < l; i++)
        {
            // initially try for equal numbers of forward moves and turning
            moves += (Math.random() < 0.5)? "F": (Math.random() < 0.5)? "R":"L";
        }
        cursor = 0;
    }
    
    public DozerPlan clone()
    {
        DozerPlan clone = new DozerPlan();
        clone.moves = moves;
        clone.cursor = cursor;
        
        return clone;
    }

    // these methods needed for a plan to be Evolvable
    
    public void copy(Evolvable other)
    {
        DozerPlan otherPlan = (DozerPlan)other;
        moves = otherPlan.moves;
    }
    
    // This is a simple one-point crossover
    // - it probably is not very useful for this problem, because
    // the second half of one plan is unlikely to match well with
    // the first half of a different plan (the board will be in
    // a different state after the first halves  of the two plans
    // have been executed.
    public void crossover(Evolvable other)
    {
        DozerPlan otherPlan = (DozerPlan)other;
        int point = (int)(moves.length()*Math.random());
        moves = moves.substring(0, point);
        moves += otherPlan.moves.substring(point);
    }
    
    // When a new plan is created by an evolutionary algorithm, this method is called.
    // The idea is that the genotype contains the DNA, and this is used to create the
    // organism's body (phenotype).
    // Most of the time we don't distinguish between teh two, so this method does nothing.
    //
    // One of the workshop tasks is to complete this method with something (hopefully) useful.
    public void develop()
    {
    }
    
    // This is the mutate operation.
    // We run along the string, possibly mutating each move (with low probability)
    public void mutate(double prob)
    {
        for(int i = 0; i < moves.length(); i++)
        {
            if(Math.random() < prob)
            {
                char c = moves.charAt(i);
                if(c == 'F' && Math.random() < 0.5) // favour keeping F's a little
                {
                    moves = moves.substring(0, i)
                        + moves.substring(i+1)
                        + "F";
                }
                else
                {
                    moves = moves.substring(0, i)
                        + mutate(moves.charAt(i))
                        + moves.substring(i+1);
                }
            }
        }
    }
    
    // utility method used during mutation of a plan
    
    private static char mutate(char c)
    {
        char newc = 'F';
        
        do
        {
            int index = (int)(2*Math.random());
            newc = index == 0? 'F': index == 1? 'R': 'L';
        }while(newc == c);
        
        return newc;
    }

    // a utility method for debugging
    
    public String toString()
    {
        return "\""+moves+"\"";
    }
    
    // methods used when executing a plan
    
    public void begin()
    {
        cursor = 0;
    }
    
    public void move(DozerMove aMove)
    {
        moves += toChar(aMove);
    }
    
    public boolean isDone()
    {
        return cursor == moves.length();
    }
    
    public DozerMove next()
    {
        return toMove(moves.charAt(cursor++));
    }

    // method to be completed in workshop
    public void ignore()
    {
    }
    
    private static char toChar(DozerMove move)
    {
        switch(move)
        {
            case FORWARD:
                return 'F';
            case LEFT:
                return 'L';
            case RIGHT:
                return 'R';
        }
        
        return '?';
    }

    private static DozerMove toMove(char c)
    {
        switch(c)
        {
            case 'F':
                return DozerMove.FORWARD;
            case 'L':
                return DozerMove.LEFT;
            case 'R':
                return DozerMove.RIGHT;
        }
        
        return DozerMove.FORWARD;
    }
}
