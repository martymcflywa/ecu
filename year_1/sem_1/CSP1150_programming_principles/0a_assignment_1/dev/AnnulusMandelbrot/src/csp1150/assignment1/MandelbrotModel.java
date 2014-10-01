package csp1150.assignment1;

/**
 * Subclass of CalculatorModel.
 * The mandelbrot's attributes are saved here,
 * with modified max-min values and overrides
 * CalculatorModel's isInside() method.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 4.0.0
 * @since 20140930
 */
public class MandelbrotModel extends CalculatorModel {
	
	// declaring constant
	private final int MAX_STEPS = 255;
	
	// declare 2d array
	private int[][] escapeArray = new int[GRIDSIZE][GRIDSIZE];
	
	/**
	 * This constructor modifies the max-min values,
	 * so that it can be used to calculate an area
	 * of a mandelbrot.
	 */
	public MandelbrotModel() {
		this.maxX = 2;
		this.minX = -2;
		this.maxY = 2;
		this.minY = -2;
	}
	
	/**
	 * This method checks if hitpoints are within shape perimeter.
	 * Overriding CalculatorModel's original method.
	 * 
	 * @param double x - The x-axis value.
	 * @param double y - The y-axis value.
	 * @return boolean inside
	 */
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
	 * This method checks if hitpoints are within shape perimeter.
	 * Overriding CalculatorModel's original method.
	 * 
	 * @param double x - The x-axis value.
	 * @param double y - The y-axis value.
	 * @return boolean inside
	 */
	private void getEscapeTime(double x, double y, int col, int row) {
		
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
		
		escapeArray[col][row] = steps;
	}
	
	/**
	 * This method calculates the escape time using monte carlo estimation.
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
	 * This method returns the escape array.
	 * 
	 * @return int[][] escapeArray.
	 */
	public int[][] returnEscapeArray() {
		return escapeArray;
	}
}
