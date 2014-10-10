package rewrite.view;

// the graphic elements
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

// the event listener
import java.awt.event.*;

/**
 * This class generates GREYSCALE images of the shapes. Uses mouse listeners so the user
 * can draw rectangles on the image and zoom in on the desired area. Uses gridlayout manager.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.0.0
 * @since 20141004
 */
@SuppressWarnings("serial")
public class HitViewerGreyscale extends HitViewer implements MouseListener, MouseMotionListener {
	
	/**
	 * Construct the panel which contains the image.
	 * Using this constructor to create empty placeholder at the start.
	 * 
	 * @param int width - The grid width.
	 * @param int height - The grid height.
	 * @param int rows - How many rows in the grid.
	 * @param int cols - How many columns in the grid.
	 * @param int hgap - Horizontal padding, pixels.
	 * @param int vgap - Vertical padding, pixels.
	 */
	public HitViewerGreyscale(int width, int height, int rows, int cols, int hgap, int vgap) {
		
		this.width = width;
		this.height = height;
		
		// construct a BufferedImage of the right size and type
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		// make it all white to start with
		Graphics2D g2 = image.createGraphics();
		g2 = image.createGraphics();
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, width, height);
		
		// add mouse listeners
		addMouseListener(this);
		addMouseMotionListener(this);
		
		// use gridlayout, set the rows, columns and padding
		this.setLayout(this.theGridLayout = new GridLayout(rows, cols, hgap, vgap));
	}
	
	/**
	 * Overloading to accept hits array.
	 * Construct the panel which contains the image.
	 * 
	 * @param int width - The grid width.
	 * @param int height - The grid height.
	 * @param int rows - How many rows in the grid.
	 * @param int cols - How many columns in the grid.
	 * @param int hgap - Horizontal padding, pixels.
	 * @param int vgap - Vertical padding, pixels.
	 * @param double[][] hits - The hits array.
	 */
	public HitViewerGreyscale(int width, int height, int rows, int cols, int hgap, int vgap, double[][] hits) {
		
		this.width = width;
		this.height = height;
		
		// construct a BufferedImage of the right size and type
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		// make it all white to start with
		Graphics2D g2 = image.createGraphics();
		g2 = image.createGraphics();
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, width, height);
		
		// add mouse listeners
		addMouseListener(this);
		addMouseMotionListener(this);
		
		// use gridlayout, set the rows, columns and padding
		this.setLayout(this.theGridLayout = new GridLayout(rows, cols, hgap, vgap));
		
		viewHits(hits);
	}
}
