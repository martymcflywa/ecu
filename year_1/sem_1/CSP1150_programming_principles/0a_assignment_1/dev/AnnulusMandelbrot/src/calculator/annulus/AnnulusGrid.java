package calculator.annulus;

/**
 * AnnulusGrid static class
 * Contains attributes and methods that assist in calculating Annulus area.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 2.2.0
 * @since 20140911
 */

public class AnnulusGrid {
	
	// declare constants SIZE and SAMPLES
	private static final int SIZE = 600;
	private static final int SAMPLES = 100;
	
	// declare grid max/mins for X and Y co-ordinates
	private static double maxX;
	private static double minX;
	private static double maxY;
	private static double minY;
	
	// declare column/row deltas
	private static double deltaX;
	private static double deltaY;
	
	// declare 2d array for monte carlo estimation
	private static double[][] hits = new double[SIZE][SIZE];
	
	/**
	 * This method sets the max/min X and Y coordinates for the grid.
	 * @param double maxRad - Pass outer radius as arg to set max/mins.
	 */
	public static void setMaxMin(double maxRad){
		
		// init declared variables with max/min values
		maxX = maxRad;
		maxY = maxRad;
		minX = -maxRad;
		minY = -maxRad;
	}
	
	/**
	 * This method calculates the column and row deltas.
	 * @param args unused
	 */
	public static void setDelta() {
		
		// init declared variables with delta values
		deltaX = maxX - minX;
		deltaY = maxY - minY;
	}
	
	/**
	 * This method allows other classes to get SIZE value.
	 * @param args unused.
	 * @return int SIZE.
	 */
	public static int gridSize() {
		return SIZE;
	}
	
	/**
	 * This method allows other classes to get SAMPLES value.
	 * @param args unused.
	 * @return int SAMPLES.
	 */
	public static int getSamples() {
		return SAMPLES;
	}
	
	/**
	 * This method calculates the center of either the column or row.
	 * The arg char axis determines whether to calculate for x or y.
	 * @param char axis - Expected args either chars 'x' or 'y'.
	 * @param int iteration - Expected args current col/row iteration.
	 * @return double center - The center point of the column or row.
	 */
	public static double getCenter(char axis, int iteration) {
		
		// declare center
		double center = 0.0;
		
		// if statement determines whether to calculate x or y center
		if(axis == 'x') {
			center = minX + (iteration + 0.5) * (deltaX / SIZE);
		} else if(axis == 'y') {
			center = minY + (iteration + 0.5) * (deltaY / SIZE);
		}
		
		// return center
		return center;
	}
	
	/**
	 * This method calculates random sample hits for either the column or row.
	 * The arg char axis determines whether to calculate for x or y.
	 * @param char axis - Expected args either chars 'x' or 'y'.
	 * @param int iteration - Expected args current col/row iteration.
	 * @return double randomHits - The random hits used for monte carlo estimation
	 */
	public static double getHits(char axis, int iteration) {
		
		// declare randomHits
		double randomHits = 0.0;
		
		// if statement determines whether to calculate for x or y
		if(axis == 'x') {
			randomHits = minX + (iteration + Math.random()) * (deltaX / SIZE);
		} else if(axis == 'y') {
			randomHits = minY + (iteration + Math.random()) * (deltaY / SIZE);
		}
		
		// return randomHits
		return randomHits;
	}
	
	/**
	 * This method returns the hits array to be used for the viewer.
	 * @param args unused.
	 * @return double[][] hits.
	 */
	public static double[][] returnHits() {
		return hits;
	}
	
	/**
	 * This method calculates the delta for either the column or row.
	 * The arg char axis determines whether to calculate for x or y.
	 * @param char axis - Expected args either chars 'x' or 'y'.
	 * @return double delta - The delta value for either x or y.
	 */
	public static double getDelta(char axis) {
		
		// declare delta
		double delta = 0.0;
		
		// if statement determines whether to calculate x or y delta
		if(axis == 'x') {
			delta = deltaX;
		} else if(axis == 'y') {
			delta = deltaY;
		}
		
		// return delta
		return delta;
	}
	
	/**
	 * This method calculates the square of SIZE.
	 * @param args unused.
	 * @return double - SIZE * SIZE.
	 */
	public static double sizeSq() {
		
		// return SIZE * SIZE
		return SIZE * SIZE;
	}
	
	/**
	 * This method sets the current array cell value to 1.
	 * @param int currentCol - Current column iteration.
	 * @param int currentRow - Current row iteration.
	 * @param int n - integer to store in array.
	 */
	public static void setArray(int currentCol, int currentRow, int n) {
		hits[currentCol][currentRow] = n;
	}
	
	/**
	 * This method divides array sum by SAMPLES.
	 * @param double sum - Pass arraySum as arg to divide by SAMPLES.
	 * @return double - Returns division result.
	 */
	public static double divideBySamples(double sum) {
		return sum / SAMPLES;
	}
	
	/**
	 * This method allows other classes to get array values.
	 * @param int currentCol - Current column iteration.
	 * @param int currentRow - Current row iteration.
	 * @return double - Get hits value for the current col/row.
	 */
	public static double getArray(int currentCol, int currentRow) {
		return hits[currentCol][currentRow];
	}
}
