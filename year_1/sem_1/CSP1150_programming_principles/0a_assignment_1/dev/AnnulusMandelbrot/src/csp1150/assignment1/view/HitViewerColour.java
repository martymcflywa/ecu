package csp1150.assignment1.view;

// for random colours
import java.util.Random;

/**
 * This class inherits from HitViewer and generates COLOUR images of the shapes.
 * Implements mouse listeners so the user can draw rectangles on the image and zoom in on the desired area. 
 * Uses GridLayout manager.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.3.0
 * @since 20141022
 */
@SuppressWarnings("serial")
public class HitViewerColour extends HitViewer {
	
	// create random object
	private Random randomRGB = new Random();
	
	// declare random RGB fields
	private static int randomR;
	private static int randomG;
	private static int randomB;

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
	 * @param boolean zooming - Check this before generating new random colours.
	 */
	public HitViewerColour(int width, int height, int rows, int cols, int hgap, int vgap, int[][] escapeArray, boolean zooming) {
		
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
		viewHitsRandomColour(escapeArray, zooming);
	}
	
	/**
	 * This method generates a random coloured image.
	 * 
	 * @param int[][] escapeArray
	 */
	protected final void viewHitsRandomColour(int[][] escapeArray, boolean zooming) {
		
		// if not zooming, 
		if(!zooming) {
			
			// go get random values
			getRandomRGB();
		}
		
		for(int x = 0; x < this.getImageWidth(); x++) {
			
			for(int y = 0; y < this.getImageHeight(); y++) {
                
				// set pixel to current escapetime value, add some randomness
				int pixelR = escapeArray[x][y] * randomR / 25;
				int pixelG = escapeArray[x][y] * randomG / 25;
				int pixelB = escapeArray[x][y] * randomB / 25;
				
				// call setPixel to draw, use randomized rgb values
				setPixel(x, y, pixelR, pixelG, pixelB);
            }
        }
		
		// ** DEBUGGING
		System.out.println("DEBUG randomValues | randomR: " + randomR + " | randomG: " + randomG + " | randomB: " + randomB);
	}
	
	/**
	 * This method generates random numbers,
	 * to be used for randomizing rgb values.
	 * 
	 * @param args unused
	 */
	private final void getRandomRGB() {
		
		randomR = randomRGB.nextInt(255 - 0) + 1;
		randomG = randomRGB.nextInt(255 - 0) + 1;
		randomB = randomRGB.nextInt(255 - 0) + 1;
	}
}
