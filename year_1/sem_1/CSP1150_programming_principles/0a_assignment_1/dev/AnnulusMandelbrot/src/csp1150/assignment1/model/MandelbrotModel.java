package csp1150.assignment1.model;

/**
 * Subclass of ShapeModel. Defines the Mandelbrot shape.
 * Uses independent default min-max fields, overrides ShapeModel's
 * isInside, resetImage and pixel-to-grid conversion methods.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.3.1
 * @since 20141024
 */
public class MandelbrotModel extends ShapeModel {
	
	// declare constant MAX_STEPS
	private final int MAX_STEPS = 255;
	
	// declare 2d array
	private int[][] escapeArray = new int[getGridSize()][getGridSize()];
	
	// declare constant default zoom values, since there is no outer radius to fall back on when resetting
	private final double DEFAULT_MINX = -2;
	private final double DEFAULT_MINY = -2;
	private final double DEFAULT_MAXX = 2;
	private final double DEFAULT_MAXY = 2;
	
	/**
	 * The Mandelbrot Model constructor.
	 * 
	 * @param args unused.
	 */
	public MandelbrotModel() {
		
		// default values for min-max, without user input
		setMinX(DEFAULT_MINX);
		setMinY(DEFAULT_MINY);
		setMaxX(DEFAULT_MAXX);
		setMaxY(DEFAULT_MAXY);
	}
	
	/**
	 * Overloading ShapeModel's calcMonte method, removed args.
	 * 
	 * This method calculates the area using monte carlo estimation
	 * for the mandelbrot.
	 * 
	 * @param args unused.
	 */
	public final void calcMonte() {
		
		// declare counter
		double counter = 0.0;
		
		// declare arraySum
		double arraySum = 0.0;
		
		// iterate through columns
		for(int col = 0; col < getGridSize() - 1; col++) {
			
			// iterate through rows
			for(int row = 0; row < getGridSize() - 1; row++) {
				
				// reset current cell value to 0
				getHitsArray()[col][row] = 0;
				
				// iterate through samples
				for(int i = 0; i < getSamples(); i++) {
					
					// generate random hit points per cell
					double x = getMinX() + (col + Math.random()) * ((getMaxX() - getMinX()) / getGridSize());
					double y = getMinY() + (row + Math.random()) * ((getMaxY() - getMinY()) / getGridSize());
					
					// if test pass, set counter + 1
					if(isInside(x, y)) {
						
						getHitsArray()[col][row] = 1;
						arraySum++;
					}
				}
			}
		}
		
		// divide sum of array to samples
		arraySum = arraySum / getSamples();
		
		// add sum of array to counter
		counter = counter + arraySum;
		
		// calculate area
		setMonteCalc(counter);
	}
	
	/**
	 * Overriding ShapeModel's isInside method, adapted for mandelbrot.
	 * 
	 * This method checks if hitpoints are within shape perimeter.
	 * 
	 * @param double x - The x-axis value.
	 * @param double y - The y-axis value.
	 * @return boolean inside - Is the hitpoint inside the shape perimeter.
	 */
	@Override
	protected boolean isInside(double x, double y) {
		
		boolean inside = true;
		
		int steps = 0;
		
		double px = 0;
		double py = 0;
		
		while(steps < MAX_STEPS && inside) {
			
			inside = px * px + py * py < 4.0;
			
			double py1 = 2 * px * py + y;
			px = px * px - py * py + x;
			py = py1;
			
			steps++;
		}
		
		return inside;
	}
	
	/**
	 * This method calculates the the area of a mandelbrot,
	 * using the escape time method.
	 * 
	 * @param args unused.
	 */
	public final void calcEscape() {
		
		// iterate through columns
		for(int col = 0; col < getGridSize() - 1; col++) {
			
			// iterate through rows
			for(int row = 0; row < getGridSize() - 1; row++) {
				
				// reset current cell value to 0
				getHitsArray()[col][row] = 0;
				
				// iterate through samples
				for(int i = 0; i < getSamples(); i++) {
					
					// generate random scatter points per cell
					double x = getMinX() + (col + Math.random()) * ((getMaxX() - getMinX()) / getGridSize());
					double y = getMinY() + (row + Math.random()) * ((getMaxY() - getMinY()) / getGridSize());
					
					// calculate escape time for each cell
					getEscapeTime(x, y, col, row);
				}
			}
		}
	}
	
	/**
	 * This method calculates the escape time for each whileloop.
	 * Results stored in escapeArray.
	 * 
	 * @param double x - The x-axis value.
	 * @param double y - The y-axis value.
	 * @param int col - The current column.
	 * @param int row - The current row.
	 */
	private final void getEscapeTime(double x, double y, int col, int row) {
		
		boolean inside = true;
		
		int steps = 0;
		
		double px = 0;
		double py = 0;
		
		while(steps < MAX_STEPS && inside) {
			inside = px * px + py * py < 4.0;
			
			double py1 = 2 * px * py + y;
			px = px * px - py * py + x;
			py = py1;
			
			steps++;
		}
		
		// store value of steps in escapeArray's current cell
		escapeArray[col][row] = steps;
	}
	
	/**
	 * This method returns escapeArray.
	 * 
	 * @return int[][] escapeArray.
	 */
	public final int[][] getEscapeArray() {
		
		return escapeArray;
	}
	
	/**
	 * Overriding ShapeModel's resetImage method, adapted for mandelbrot.
	 * Using DEFAULT_* instead of outRadius.
	 * 
	 * This method resets the zoom values back to default values.
	 * 
	 * @param args unused.
	 */
	@Override
	public void resetImage() {
		
		setMinX(DEFAULT_MINX);
		setMinY(DEFAULT_MINY);
		setMaxX(DEFAULT_MAXX);
		setMaxY(DEFAULT_MAXY);
	}
	
	/**
	 * Overriding ShapeModel's method, using DEFAULT_MAXX instead of outRadius.
	 * 
	 * This method converts the minX pixel position to the grid position.
	 * 
	 * @param double pixelMinX - The pixel minX position.
	 * @return double - The converted grid position.
	 */
	@Override
	protected double minXPixelToGrid(double pixelMinX) {
		
		return (pixelMinX / getGridSize()) * (DEFAULT_MAXX * 2.0) - DEFAULT_MAXX;
	}
	
	/**
	 * Overriding ShapeModel's method, using DEFAULT_MAXX instead of outRadius.
	 * 
	 * This method converts the minY pixel position to the grid position.
	 * Calculations are reversed for y-axis, since since maxY appears to be setting the top-left corner.
	 * 
	 * @param double pixelMinY - The pixel minY position.
	 * @param double pixelHeight - The height of the drawn rectangle.
	 * @return double - The converted grid position.
	 */
	@Override
	protected double minYPixelToGrid(double pixelMinY, double pixelHeight) {
		
		return ((getGridSize() - (pixelMinY + pixelHeight)) / getGridSize()) * (DEFAULT_MAXX * 2.0) - DEFAULT_MAXX;
	}
	
	/**
	 * Overriding ShapeModel's method, using DEFAULT_MAXX instead of outRadius.
	 * 
	 * This method converts the maxX (width) pixel position to the grid position.
	 * 
	 * @param double pixelMinX - The pixel maxX position.
	 * @param double pixelWidth - The width of the drawn rectangle.
	 * @return double - The converted grid position.
	 */
	@Override
	protected double maxXPixelToGrid(double pixelMinX, double pixelWidth) {
		
		return ((pixelMinX + pixelWidth) / getGridSize()) * (DEFAULT_MAXX * 2.0) - DEFAULT_MAXX; 
	}
	
	/**
	 * Overriding ShapeModel's method, using DEFAULT_MAXX instead of outRadius.
	 * 
	 * This method converts the maxY (height) pixel position to the grid position.
	 * Calculations are reversed for y-axis, since maxY appears to be setting the top-left corner.
	 * 
	 * @param double pixelMinY - The pixel minY position.
	 * @return double - The converted grid position.
	 */
	protected double maxYPixelToGrid(double pixelMinY) {
		
		return ((getGridSize() - pixelMinY) / getGridSize()) * (DEFAULT_MAXX * 2.0) - DEFAULT_MAXX;
	}
}
