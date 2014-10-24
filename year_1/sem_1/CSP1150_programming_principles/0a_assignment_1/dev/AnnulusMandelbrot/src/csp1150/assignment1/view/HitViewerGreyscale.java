package csp1150.assignment1.view;

/**
 * This class inherits from HitViewer and generates GREYSCALE images of the shapes.
 * Implements mouse listeners so the user can draw rectangles on the image and zoom in on the desired area. 
 * Uses GridLayout manager.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.3.1
 * @since 20141024
 */
@SuppressWarnings("serial")
public class HitViewerGreyscale extends HitViewer {
	
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
	public HitViewerGreyscale(int width, int height, int rows, int cols, int hgap, int vgap) {

		// init the image
		initImage(width, height);
		
		// add mouse listeners
		addMouseListener(this);
		addMouseMotionListener(this);
		
		// set the rows, columns and padding
		setGridConstraints(rows, cols, hgap, vgap);
		
		// use the layout
		setLayout(getGridLayout());
	}
	
	/**
	 * Overloading constructor to accept hits array.
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
	 * @param double[][] hits - The hits array.
	 */
	public HitViewerGreyscale(int width, int height, int rows, int cols, int hgap, int vgap, double[][] hits) {
		
		// init the image
		initImage(width, height);
		
		// add mouse listeners
		addMouseListener(this);
		addMouseMotionListener(this);
		
		// set the rows, columns and padding
		setGridConstraints(rows, cols, hgap, vgap);
		
		// use the layout
		setLayout(getGridLayout());
		
		// call viewHits to generate the image
		viewHits(hits);
	}
}
