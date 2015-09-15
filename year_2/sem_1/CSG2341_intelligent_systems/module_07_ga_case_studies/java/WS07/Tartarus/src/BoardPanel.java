/*
 * BoardPanel.java
 *
 * Created on 27 July 2006, 12:33
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author phingsto
 */
public class BoardPanel extends JPanel
{
    private Board board;
    private BoardView view;
    
    /** Creates a new instance of BoardPanel */
    public BoardPanel(Board board)
    {
        setBoard(board);
        view = BoardView.ALL;
    }
    
    public void setBoard(Board board)
    {
        this.board = board;
    }
    
    public void setView(BoardView view)
    {
        this.view = view;
        repaint();
    }
    
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;

        g2.setColor(Color.DARK_GRAY);
        g2.fill(getBounds());

        Rectangle rect = getBounds();
        int size = (int)(0.95*Math.min(rect.width, rect.height));
        rect.x += (rect.width-size)/2;
        rect.y += (rect.height-size)/2;
        rect.width = size;
        rect.height = size;
        
        switch(view)
        {
            case ALL:
                board.drawAll(g2, rect);
                break;
            case LOCAL:
                board.drawLocal(g2, rect);
                break;
            case EGO:
                board.drawDozerView(g2, rect);
                break;
        }
    }    
}
