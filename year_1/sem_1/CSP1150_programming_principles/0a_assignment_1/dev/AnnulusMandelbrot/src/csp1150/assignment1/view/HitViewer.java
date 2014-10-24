package csp1150.assignment1.view;

// the graphic elements
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

// for mouse position
import java.awt.Point;

// the event listener
import java.awt.event.*;

// identifies which mouse button is pressed
import javax.swing.SwingUtilities;

/**
 * This class inherits from PanelGridLayout and generates images of the shapes.
 * Implements mouse listeners so the user can draw rectangles on the image and zoom in on the desired area.
 * Uses GridLayout manager.
 * 
 * @author Martin Ponce ID# 10371381 & Prof. Hingston
 * @version 5.3.0
 * @since 20141022
 */

@SuppressWarnings("serial")
public class HitViewer extends PanelGridLayout implements MouseListener, MouseMotionListener {

	// declare image
	private BufferedImage image;
	
	// declare image width and height
	private int width;
	private int height;
	
	// declare the mouse position
	private Point mousePt = new Point(width / 2, width / 2);
	
	// declare rectangle to be drawn
	private Rectangle mouseRect = new Rectangle();
	
	// declare boolean, static to stop it resetting whenever a new instance is created
	private static boolean zooming = false;
	
	// declare pixelZoom array to hold values - index: 0 = minX, 1 = minY, 2 = maxX (width), 3 = maxY (height)
	private double[] pixelZoom = new double[4];
	
	/**
	 * Default constructor for inheritance.
	 */
	public HitViewer() {
		
	}
	
	/**
	 * Construct the panel which contains the image.
	 * 
	 * @param int width - The grid width.
	 * @param int height - The grid height.
	 * @param int rows - GridLayoutConstraints: How many rows in the grid.
	 * @param int cols - GridLayoutConstraints: How many columns in the grid.
	 * @param int hgap - GridLayoutConstraints: Horizontal padding, pixels.
	 * @param int vgap - GridLayoutConstraints: Vertical padding, pixels.
	 */
	public HitViewer(int width, int height, int rows, int cols, int hgap, int vgap) {
		
		// init the image
		initImage(width, height);
		
		// add mouse listeners to the panel
		addMouseListener(this);
		addMouseMotionListener(this);
		
		// set the rows, columns and padding
		setGridConstraints(rows, cols, hgap, vgap);
		
		// use the layout
		this.setLayout(getGridLayout());
	}
	
	/**
	 * This method initializes the image.
	 * 
	 * @param int width - The image width.
	 * @param int height - The image height.
	 */
	protected final void initImage(int width, int height) {
		
		// set the width and height
		this.width = width;
		this.height = height;
		
		// construct a BufferedImage of the right size and type
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		
		// make it all white to start with
		Graphics2D g2 = image.createGraphics();
		g2 = image.createGraphics();
		g2.setColor(Color.WHITE);
		g2.fillRect(0, 0, width, height);
	}
	
	/**
	 * Change the greyscale values in the image using the values from an array.
	 * 
	 * @param double[][] hits - The array.
	 */
	public void viewHits(double[][] hits) {
		
		for(int x = 0; x < this.width; x++) {
			
			for(int y = 0; y < this.height; y++) {
				
				float grey = (float)(1.0 - hits[x][y]);
				setPixel(x, y, grey);
			}
		}
	}
	
	/**
	 * Set one pixel in the image using integer RGB values.
	 * 
	 * @param int x - The column number.
	 * @param int y - The row number.
	 * @param int red - 0-255.
	 * @param int green - 0-255.
	 * @param int blue - 0-255.
	 */
	protected void setPixel(int x, int y, int red, int green, int blue) {
		
		int pixel = (blue << 0) | (green << 8) | (red << 16) | (255 << 24);
		
		// height-y-1 because the y-axis coordinates are inverted(0 is at the top)
		this.image.setRGB(x, this.height-y-1, pixel);
	}
	
	/**
	 * Set one pixel in the image using a greyscale value.
	 * 
	 * @param int x - The column number.
	 * @param int y - The row number.
	 * @param float grey - 0-1.0.
	 */
	private void setPixel(int x, int y, float grey) {
		
		// convert to integer RGB values
		int greyByte = (int)(255 * grey);
		
		setPixel(x, y, greyByte, greyByte, greyByte);
	}
	
	/**
	 * Overriding paintComponent, the world gets drawn here.
	 * 
	 * @param Graphics g
	 */
	@Override
	public void paintComponent(Graphics g) {
		
		super.paintComponent(g);
		g.drawImage(this.image, 0, 0, null);
	}
	
	/**
	 * Overriding paint to draw rectangles over the image.
	 * 
	 * @param Graphics g
	 */
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		g.setColor(Color.DARK_GRAY);
		g.drawRect(this.mouseRect.x, this.mouseRect.y, this.mouseRect.width, this.mouseRect.height);
	}
	
	/**
	 * This method defines the action to take when the mouse button is held down.
	 * 
	 * @param MouseEvent me - The mouse event.
	 */
	public void mousePressed(MouseEvent me) {
		
		// if left mouse button is pressed
		if(SwingUtilities.isLeftMouseButton(me)) {
		
			// set zooming to true
			zooming = true;
			
			// get location where mouse button is pressed
			mousePt = me.getPoint();
			
			// repaint
			me.getComponent().repaint();
		}		
	}
	
	/**
	 * This method defines the action to take when the mouse is dragged.
	 * TODO: Needs to reset if mouseDragged exits panel.
	 * 
	 * @param MouseEvent me - The mouse event.
	 */
	public void mouseDragged(MouseEvent me) {
		
		// if mouse is dragged with left mouse button
		if(SwingUtilities.isLeftMouseButton(me)) {
			
			// set the rectangle bounds
			mouseRect.setBounds(
					Math.min(mousePt.x, me.getX()),
					Math.min(mousePt.y, me.getY()),
					Math.abs(mousePt.x - me.getX()),
					Math.abs(mousePt.y - me.getY())
			);
			
			// set pixel max-min values to mouse position
			pixelZoom[0] = Math.min(mousePt.x, me.getX());
			pixelZoom[1] = Math.min(mousePt.y, me.getY());
			pixelZoom[2] = Math.abs(mousePt.x - me.getX());
			
			// cheating here, using width as height to make sure zoom selection is always 1:1 aspect ratio
			pixelZoom[3] = Math.abs(mousePt.x - me.getX());
			
			// ** DEBUGGING
			System.out.println("DEBUG pixelZoom | minX: " + pixelZoom[0] + " | minY: " + pixelZoom[1] + " | width: " + pixelZoom[2] + " | height: " + pixelZoom[3]);
			
			// set zooming to true
			zooming = true;
			
			// repaint
			me.getComponent().repaint();
		}
	}
	
	/**
	 * This method defines the action to take when the left mouse button is clicked.
	 * 
	 * @param MouseEvent me.
	 */
	public void mouseClicked(MouseEvent me) {
		
		// if left mouse button is clicked
		if(SwingUtilities.isLeftMouseButton(me)) {
			
			// reset rectangle bounds
			mouseRect.setBounds(0, 0, 0, 0);
			
			// reset pixelZoom values to 0
			for(int i = 0; i < pixelZoom.length; i++) {
				
				pixelZoom[i] = 0;
			}
			
			// set zooming to false
			zooming = false;
			
			// repaint
			me.getComponent().repaint();
		}
	}

	/**
	 * This method returns the image width.
	 * 
	 * @param args unused
	 * @return int width.
	 */
	protected final int getImageWidth() {
		
		return width;
	}
	
	/**
	 * This method returns the image height.
	 * 
	 * @param args unused
	 * @return int height.
	 */
	protected final int getImageHeight() {
		
		return height;
	}
	
	/**
	 * This method returns pixelZoom array.
	 * 
	 * @return int[] pixelZoom.
	 */
	public final double[] getPixelZoom() {
		
		return pixelZoom;
	}
	
	/**
	 * This static method returns static zooming boolean.
	 * 
	 * @return boolean zooming.
	 */
	public static final boolean getZoomBool() {
		
		return zooming;
	}
	
	/**
	 * This static method sets the static zooming boolean.
	 * 
	 * @param boolean trueOrFalse.
	 */
	public static final void setZoomBool(boolean trueOrFalse) {
		
		zooming = trueOrFalse; 
	}
	
	/**
	 * Unused mouse event.
	 * 
	 * @param args unused
	 */
	public void mouseReleased(MouseEvent me) {
		
	}
	
	/**
	 * Unused mouse event.
	 * 
	 * @param args unused
	 */
	public void mouseEntered(MouseEvent me) {
		
	}
	
	/**
	 * Unused mouse event.
	 * 
	 * @param args unused
	 */
	public void mouseMoved(MouseEvent me) {
		
	}
	
	/**
	 * Unused mouse event.
	 * 
	 * @param args unused
	 */
	public void mouseExited(MouseEvent me) {
		
	}
}
