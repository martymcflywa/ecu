/*
 * Board.java
 *
 * Created on 27 July 2006, 09:30
 *
 */

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;

/**
 *
 * @author phingsto
 */
public class Board
{
    private int size;
    private Cell cells[][];
    private Dozer dozer;
    private int dozerI, dozerJ;
    
    /** Creates a new instance of Board */
    public Board(int size, int boxes)
    {
        this.size = size;
        
        // create an empty board
        cells = new Cell[size][size];
        
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                cells[i][j] = new Cell();
            }
        }
        
        // place boxes
        for(int b = 0; b < boxes; b++)
        {
            boolean found = false;
            int i=0, j=0;
            while(!found)
            {
                i = (int)(size*Math.random());
                j = (int)(size*Math.random());
                
                found = cells[i][j].getState() == CellState.EMPTY;
            }
            
            cells[i][j].setState(CellState.BOX);
        }
        
        // place dozer
        boolean found = false;
        while(!found)
        {
            dozerI = (int)(size*Math.random());
            dozerJ = (int)(size*Math.random());

            found = cells[dozerI][dozerJ].getState() == CellState.EMPTY;
        }
        
        dozer = new Dozer();
    }
    
    public Board(int position[][])
    {
        this.size = position.length;
        
        // create an empty board
        cells = new Cell[size][size];
        
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                cells[i][j] = new Cell();
            }
        }
        
        dozer = new Dozer();
        
        setPosition(position);
    }
    
    public void setPosition(int position[][])
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                int cell = position[i][j];
                
                if(cell == 0)
                {
                    cells[i][j].setState(CellState.EMPTY);
                }
                else if(cell == 1)
                {
                    cells[i][j].setState(CellState.BOX);
                }                
                else if(cell == 2)
                {
                    cells[i][j].setState(CellState.WALL); // not used yet
                }
                else
                {
                    cells[i][j].setState(CellState.EMPTY);
                    dozerI = i;
                    dozerJ = j;
                    dozer.setHeading(DozerHeading.getHeading(cell-3));
                }
            }
        }
    }
    
    public int getScore()
    {
        int score = 0;
        
        if(cells[0][0].getState() == CellState.BOX) score += 2;
        if(cells[0][size-1].getState() == CellState.BOX) score += 2;
        if(cells[size-1][0].getState() == CellState.BOX) score += 2;
        if(cells[size-1][size-1].getState() == CellState.BOX) score += 2;
        
        for(int i = 1; i < size-1; i++)
        {
            if(cells[0][i].getState() == CellState.BOX) score++;
            if(cells[size-1][i].getState() == CellState.BOX) score++;
            if(cells[i][0].getState() == CellState.BOX) score++;
            if(cells[i][size-1].getState() == CellState.BOX) score++;
        }
        
        return score;
    }
    
    // dozer attempts to move forward
    public boolean forward()
    {
        // calculate next cell i and j
        DozerHeading heading = dozer.getHeading();
        
        int nextI = dozerI + heading.getDI();
        int nextJ = dozerJ + heading.getDJ();
        
        if(nextI < 0 || nextI >= size || nextJ < 0 || nextJ >= size) return false;
        
        if(cells[nextI][nextJ].getState() == CellState.BOX)
        {
            // it's a box
            int boxNextI = nextI + heading.getDI();
            int boxNextJ = nextJ + heading.getDJ();

            if(boxNextI < 0 || boxNextI >= size || boxNextJ < 0 || boxNextJ >= size) return false;

            if(cells[boxNextI][boxNextJ].getState() == CellState.EMPTY)
            {
                cells[boxNextI][boxNextJ].setState(CellState.BOX);
                cells[nextI][nextJ].setState(CellState.EMPTY);
            }
            else
            {
                return false;
            }
        }
        
        // assume it's empty then

        dozerI = nextI;
        dozerJ = nextJ;
        
        return true;
    }
    
    public void right()
    {
        dozer.turnRight();
    }
    
    public void left()
    {
        dozer.turnLeft();
    }

    public void drawAll(Graphics2D g, Rectangle rect)
    {
        for(int i = 0; i < size; i++)
        {
            for(int j = 0; j < size; j++)
            {
                cells[i][j].draw(g, getGridRectangle(rect, i, j));
            }
        }
        
        dozer.draw(g, getGridRectangle(rect, dozerI, dozerJ));
    }

    public void drawLocal(Graphics2D g, Rectangle rect)
    {
        g.clearRect(rect.x, rect.y, rect.width, rect.height);
        
        AffineTransform old = g.getTransform();
        
        Rectangle dozerRect = getGridRectangle(rect, dozerI, dozerJ);
               
        for(int i = -1; i <= 1; i++)
        {
            for(int j = -1; j <= 1; j++)
            {
                int cellI = dozerI+i;
                int cellJ = dozerJ+j;
                getCell(cellI, cellJ).draw(g, getGridRectangle(rect, cellI, cellJ));
            }
        }
        
        dozer.draw(g, getGridRectangle(rect, dozerI, dozerJ));

        g.setTransform(old);
    }
    
    public void drawDozerView(Graphics2D g, Rectangle rect)
    {
        g.clearRect(rect.x, rect.y, rect.width, rect.height);
        
        AffineTransform old = g.getTransform();
        
        Rectangle dozerRect = getGridRectangle(rect, dozerI, dozerJ);
        
        // move centre of dozer cell to centre of display and rotate
        int centreX = rect.x + rect.width/2;
        int centreY = rect.y + rect.height/2;
        g.rotate(Math.toRadians(-dozer.getHeading().getRotation()), centreX, centreY);
        g.translate(
                (centreX - dozerRect.x - dozerRect.width/2),
                (centreY - dozerRect.y - dozerRect.height/2)
                );
        
        for(int i = -1; i <= 1; i++)
        {
            for(int j = -1; j <= 1; j++)
            {
                int cellI = dozerI+i;
                int cellJ = dozerJ+j;
                getCell(cellI, cellJ).draw(g, getGridRectangle(rect, cellI, cellJ));
            }
        }
        
        dozer.draw(g, getGridRectangle(rect, dozerI, dozerJ));

        g.setTransform(old);
    }
    
    private Cell getCell(int i, int j)
    {
        if(i >= 0 && i < size && j >= 0 && j < size)
        {
            return cells[i][j];
        }
        else
        {
            return Cell.WallCell;
        }
    }
    
    private Rectangle getGridRectangle(Rectangle rect, int i, int j)
    {
        double cellWidth = rect.width/(double)size;
        double cellHeight = rect.height/(double)size;
        
        return new Rectangle(rect.x + (int)(i*cellWidth), rect.y + (int)((size-1-j)*cellHeight), (int)cellWidth, (int)(cellHeight));
    }
}
