package rewrite.view;

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
 * This class generates images of the shapes. Uses mouse listeners so the user
 * can draw rectangles on the image and zoom in on the desired area.
 * 
 * @author Martin Ponce ID# 10371381 & Prof. Hingston
 * @version 5.0.0
 * @since 20141004
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
	
	/**
	 * Default constructor for inheritance.
	 */
	public HitViewer() {
		
	}
	
	/**
	 * Construct the panel.
	 * 
	 * @param width
	 * @param height
	 */
	public HitViewer(int width, int height, int rows, int cols, int hgap, int vgap) {
		
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
	 * Change the greyscale values in the image using the values from an array.
	 * 
	 * @param double[][] hits - The array.
	 */
	public void viewHits(double[][] hits) {
		
		for(int x = 0; x < width; x++) {
			
			for(int y = 0; y < height; y++) {
				
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
		image.setRGB(x, height-y-1, pixel);
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
	 * @param args unused
	 */
	@Override
	public void paintComponent(Graphics g) {
		
		// **NEEDS TESTING** with annulus image
		
		// seems to remove the image underneath
		super.paintComponent(g);
		
		if(zooming) {
			g.setColor(Color.DARK_GRAY);
			g.drawRect(mouseRect.x, mouseRect.y, mouseRect.width, mouseRect.height);
		} else {
			g.drawImage(image, 0, 0, null);
		}
		
		// the original lines - may need this again
//		super.paintComponent(g);
//		g.drawImage(image, 0, 0, null);
	}
	
	// **MAY NEED THIS AGAIN** doesn't replace the image
//	public void paint(Graphics g) {
//		super.paint(g);
//		g.setColor(Color.DARK_GRAY);
//		g.drawRect(mouseRect.x, mouseRect.y, mouseRect.width, mouseRect.height);
//	}
	
	/**
	 * This method defines the action to take when the mouse button is released.
	 * 
	 * @param MouseEvent me - The mouse event.
	 */
	public void mouseReleased(MouseEvent me) {
		
		// if left mouse button is released
		if(SwingUtilities.isLeftMouseButton(me)) {
		
			// set zooming to false
			zooming = false;
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
			zooming = true;
			
			// get location where mouse button is pressed
			mousePt = me.getPoint();
			
			// repaint
			me.getComponent().repaint();
		}		
	}
	
	/**
	 * This method defines the action to take when the mouse is dragged.
	 * 
	 * @param MouseEvent me - The mouse event.
	 */
	public void mouseDragged(MouseEvent me) {
		
		// if mouse is dragged with left mouse button
		if(SwingUtilities.isLeftMouseButton(me)) {
		
			// set zooming to true
			zooming = true;
			
			// set the rectangle bounds
			// **USE THESE VALUES** to determine zoom
			mouseRect.setBounds(
					Math.min(mousePt.x, me.getX()),
					Math.min(mousePt.y, me.getY()),
					Math.abs(mousePt.x - me.getX()),
					Math.abs(mousePt.y - me.getY())
				);
			
			// repaint
			me.getComponent().repaint();
		}
	}
	
	/**
	 * This method defines the action to take when the left mouse button is clicked.
	 * 
	 * @param args unused
	 */
	public void mouseClicked(MouseEvent me) {
		
		// if left mouse button is clicked
		if(SwingUtilities.isLeftMouseButton(me)) {
			
			// set zooming to false
			zooming = false;
			
			// reset rectangle bounds
			mouseRect.setBounds(0, 0, 0, 0);
			
			// repaint
			me.getComponent().repaint();
		}
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
