package csp1150.assignment1.view;

// the graphic elements
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.awt.Rectangle;

// for mouse position
import java.awt.Point;

// the layout manager
import java.awt.GridLayout;

// the event listener
import java.awt.event.*;

// identifies which mouse button is pressed
import javax.swing.SwingUtilities;

/**
 * This class inherits from PanelGridLayout and generates images of the shapes.
 * Uses mouse listeners so the user can draw rectangles on the image and zoom in on the desired area.
 * Uses GridLayout manager.
 * 
 * @author Martin Ponce ID# 10371381 & Prof. Hingston
 * @version 5.1.0
 * @since 20141011
 */

@SuppressWarnings("serial")
public class HitViewer extends PanelGridLayout implements MouseListener, MouseMotionListener {

	// declare image
	protected BufferedImage image;
	
	// declare image width and height
	protected int width;
	protected int height;
	
	// declare the mouse position
	protected Point mousePt = new Point(width / 2, width / 2);
	
	// declare rectangle to be drawn
	protected Rectangle mouseRect = new Rectangle();
	
	// declare boolean
	protected boolean zooming = false;
	
	// declare pixel zoom array to hold values - index: 0 = minX, 1 = minY, 2 = maxX, 3 = maxY
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
		
		// add mouse listeners to the panel
		addMouseListener(this);
		addMouseMotionListener(this);
		
		// use gridlayout, set the rows, columns and padding
		this.setLayout(this.theGridLayout = new GridLayout(rows, cols, hgap, vgap));
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
	 * This method defines the action to take when the mouse button is released.
	 * 
	 * @param MouseEvent me - The mouse event.
	 */
	public void mouseReleased(MouseEvent me) {
		
		// if left mouse button is released
		if(SwingUtilities.isLeftMouseButton(me)) {
		
			// set zooming to false
			this.zooming = false;
		}
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
			this.zooming = true;
			
			// get location where mouse button is pressed
			this.mousePt = me.getPoint();
			
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
		
			// set zooming to true
			this.zooming = true;
			
			// set the rectangle bounds
			// **USE THESE VALUES** to determine zoom
			this.mouseRect.setBounds(
					Math.min(this.mousePt.x, me.getX()),
					Math.min(this.mousePt.y, me.getY()),
					Math.abs(this.mousePt.x - me.getX()),
					Math.abs(this.mousePt.y - me.getY())
			);
			
			// set pixel max-min values to mouse position
			this.pixelZoom[0] = Math.min(this.mousePt.x, me.getX());
			this.pixelZoom[1] = this.height - Math.min(this.mousePt.y, me.getY());
			this.pixelZoom[2] = Math.abs(this.mousePt.x - me.getX());
			this.pixelZoom[3] = Math.abs(this.mousePt.y - me.getY());
			
			// ** DEBUGGING
			System.out.println("startX: " + pixelZoom[0] + " | startY: " + pixelZoom[1] + " | width: " + pixelZoom[2] + " | height: " + pixelZoom[3]);
			
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
			
			// set zooming to false
			this.zooming = false;
			
			// reset rectangle bounds
			this.mouseRect.setBounds(0, 0, 0, 0);
			
			// reset pixelZoom values to 0
			for(int i = 0; i < this.pixelZoom.length; i++) {
				this.pixelZoom[i] = 0;
			}
			
			// ** DEBUGGING
			//System.out.println(pixelZoom[0] + " | " + pixelZoom[1] + " | " + pixelZoom[2] + " | " + pixelZoom[3]);
			
			// repaint
			me.getComponent().repaint();
		}
	}
	
	/**
	 * This method returns pixelZoom array.
	 * 
	 * @return int[] pixelZoom.
	 */
	public final double[] getPixelZoom() {
		return this.pixelZoom;
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
