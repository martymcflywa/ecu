package csp1150.assignment1.view;

// the graphic elements
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;

// the event listener
import java.awt.event.*;

// for random colours
import java.util.Random;

/**
 * This class inherits from HitViewer and generates COLOUR images of the shapes.
 * Uses mouse listeners so the user can draw rectangles on the image and zoom in on the desired area. 
 * Uses GridLayout manager.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.1.0
 * @since 20141011
 */
@SuppressWarnings("serial")
public class HitViewerColour extends HitViewer implements MouseListener, MouseMotionListener {

	/**
	 * Construct the panel which contains the image.
	 * Using this constructor to create empty placeholder at the start.
	 * 
	 * @param int width - The grid width.
	 * @param int height - The grid height.
	 * @param int rows - GridLayoutConstraints: How many rows in the grid.
	 * @param int cols - GridLayoutConstraints: How many columns in the grid.
	 * @param int hgap - GridLayoutConstraints: Horizontal padding, pixels.
	 * @param int vgap - GridLayoutConstraints: Vertical padding, pixels.
	 */
	public HitViewerColour(int width, int height, int rows, int cols, int hgap, int vgap) {
		
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
	 * Overloading constructor to accept hits array as argument.
	 * 
	 * Construct the panel which contains the image.
	 * 
	 * @param int width - The grid width.
	 * @param int height - The grid height.
	 * @param int rows - GridLayoutConstraints: How many rows in the grid.
	 * @param int cols - GridLayoutConstraints: How many columns in the grid.
	 * @param int hgap - GridLayoutConstraints: Horizontal padding, pixels.
	 * @param int vgap - GridLayoutConstraints: Vertical padding, pixels.
	 * @param double[][] hits - The hits array.
	 */
	public HitViewerColour(int width, int height, int rows, int cols, int hgap, int vgap, double[][] hits) {
		
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
		
		// call viewHits to generate the image
		viewHits(hits);
	}
	
	/**
	 * Overloading constructor to accept escapeArray as argument.
	 * 
	 * Construct the panel which contains the image,
	 * then generate image.
	 * 
	 * @param int width - The grid width.
	 * @param int height - The grid height.
	 * @param int rows - GridLayoutConstraints: How many rows in the grid.
	 * @param int cols - GridLayoutConstraints: How many columns in the grid.
	 * @param int hgap - GridLayoutConstraints: Horizontal padding, pixels.
	 * @param int vgap - GridLayoutConstraints: Vertical padding, pixels.
	 * @param int[][] escapeArray - The escapeArray.
	 */
	public HitViewerColour(int width, int height, int rows, int cols, int hgap, int vgap, int[][] escapeArray) {
		
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
		
		// call viewHits to generate the image
		viewHitsRandomColour(escapeArray);
	}
	
	/**
	 * This method generates a random coloured image.
	 * 
	 * @param int[][] escapeArray
	 */
	public void viewHitsRandomColour(int[][] escapeArray) {
		
		// create Random object
		Random randomRGB = new Random();
		
		// get a random number for red, green and blue
		int randomRed = randomRGB.nextInt(255 - 0) + 1;
		int randomGreen = randomRGB.nextInt(255 - 0) + 1;
		int randomBlue = randomRGB.nextInt(255 - 0) + 1;
		
		for(int x = 0; x < width; x++) {
			
			for(int y = 0; y < height; y++) {
                
				// set pixel to current escapetime value
				int pixel = escapeArray[x][y];
				
				// call setPixel to draw, using random numbers generated
				setPixel(x, y, pixel * randomRed / 25, pixel * randomGreen / 25, pixel * randomBlue / 25);
            }
        }
	}
}
