/*
 * Cell.java
 *
 * Created on 27 July 2006, 09:34
 *
 */

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;

/**
 *
 * @author phingsto
 */
public class Cell
{
    private CellState state;
    
    /** Creates a new instance of Cell */
    public Cell()
    {
        state = CellState.EMPTY;
    }
    
    public CellState getState()
    {
        return state;
    }
    
    public void setState(CellState newState)
    {
        state = newState;
    }
    
    public void draw(Graphics2D g, Rectangle rect)
    {
        switch(state)
        {
            case EMPTY:
                g.setColor(Color.LIGHT_GRAY);
                break;
            case BOX:
                g.setColor(Color.RED);
                break;
            case WALL:
                g.setColor(Color.DARK_GRAY);
                break;
        }
        
        g.fill(rect);
        
        g.setColor(Color.BLACK);
        g.draw(rect);
    }
    
    public static final Cell WallCell = new Cell();
    static
    {
        WallCell.setState(CellState.WALL);
    }
}
