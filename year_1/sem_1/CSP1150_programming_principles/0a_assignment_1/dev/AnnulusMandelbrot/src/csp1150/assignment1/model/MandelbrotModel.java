package csp1150.assignment1.model;

/**
 * Subclass of ShapeModel. Defines the Mandelbrot shape.
 * Declares default max-min fields, and overrides ShapeModel's
 * isInside() method.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.1.0
 * @since 20141011
 */
public class MandelbrotModel extends ShapeModel {
	
	// declaring constant, defines rgb max value for escapeTime
	private final int MAX_STEPS = 255;
	
	// declare 2d array
	private int[][] escapeArray = new int[GRIDSIZE][GRIDSIZE];
	
	/**
	 * The Mandelbrot Model constructor.
	 */
	public MandelbrotModel() {
		
		// default values for max-min, without user input
		this.maxX = 2;
		this.maxY = 2;
		this.minX = -2;
		this.minY = -2;
	}
	
	/**
	 * Overloading ShapeModel's calcMonte method, removed args.
	 * This method calculates the area using monte carlo estimation
	 * for the mandelbrot.
	 * 
	 * @param args unused
	 */
	public final void calcMonte() {
		
		// declare counter
		double counter = 0.0;
		
		// declare arraySum
		double arraySum = 0.0;
		
		// iterate through columns
		for(int col = 0; col < GRIDSIZE - 1; col++) {
			
			// iterate through rows
			for(int row = 0; row < GRIDSIZE - 1; row++) {
				
				// reset current cell value to 0
				hits[col][row] = 0;
				
				// iterate through samples
				for(int i = 0; i < SAMPLES; i++) {
					
					// generate random scatter points per cell
					double x = minX + (col + Math.random()) * ((maxX - minX) / GRIDSIZE);
					double y = minY + (row + Math.random()) * ((maxY - minY) / GRIDSIZE);
					
					// if test pass, set counter + 1
					if(isInside(x, y)) {
						hits[col][row] = 1;
						arraySum++;
					}
				}
			}
		}
		
		// divide sum of array to samples
		arraySum = arraySum / SAMPLES;
		
		// add sum of array to counter
		counter = counter + arraySum;
		
		// calculate area
		this.areaMonte = (maxX - minX) * (maxY - minY) * counter / Math.pow(GRIDSIZE, 2);
	}
	
	/**
	 * This method checks if hitpoints are within shape perimeter.
	 * Overriding ShapeModel's original method, adapted to
	 * calculate Mandelbrot area.
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
	 * This method calculates the the area of a mandelbrot
	 * using the escape time method.
	 * 
	 * @param args unused
	 */
	public final void calcEscape() {
		
		// iterate through columns
		for(int col = 0; col < GRIDSIZE - 1; col++) {
			
			// iterate through rows
			for(int row = 0; row < GRIDSIZE - 1; row++) {
				
				// reset current cell value to 0
				hits[col][row] = 0;
				
				// iterate through samples
				for(int i = 0; i < SAMPLES; i++) {
					
					// generate random scatter points per cell
					double x = minX + (col + Math.random()) * ((maxX - minX) / GRIDSIZE);
					double y = minY + (row + Math.random()) * ((maxY - minY) / GRIDSIZE);
					
					// calculate escape time for each cell
					getEscapeTime(x, y, col, row);
				}
			}
		}
	}
	
	/**
	 * This method calculates the escape time for each whileloop.
	 * Results are stored in escapeArray.
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
}
