package annulus.calculator;

/**
 * Test class, experimenting with multidimensional array.
 * 		
 * 		To do:
 * 			- resolve issue line 118
 * 			- add user input
 * 			- split attributes and methods to separate classes
 * 			- add javadocs
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140908 
 */

public class AnnulusTestCalc {

	// declare grid size, samples
	static int gridSize = 100;
	static int samples = 100;
	
	// declare 2d array
	static double[][] hits = new double[gridSize][gridSize];
	
	// placeholder predefined radius values while testing - to be replaced with user input
	static double outRad = 20.0;
	static double inRad = 10.0;
	
	public static void main(String[] args) {
		
		// print placeholder values and manual calculation for testing
		System.out.println("Outer radius: 20");
		System.out.println("Inner radius: 10");
		System.out.println("Manual calculation: 942.477796077");
		System.out.println("---------------------------------");
		
		// call methods to calculate area, pass outRad/inRad as arguments
		calcApprox(outRad, inRad);
		calcMonte(outRad, inRad);
	}
	
	// approximate estimation method
	static void calcApprox(double r1, double r2) {
		
		// declare counter
		int counter = 0;
		
		// declare grid max/mins
		double maxX = r1;
		double minX = -r1;
		double maxY = r1;
		double minY = -r1;
		
		// iterate through columns
		for(int col = 0; col < gridSize - 1; col++) {
			
			// calculate column center
			double x = minX + (col + 0.5) * ((maxX - minX) / gridSize);
			
			// iterate through rows
			for(int row = 0; row < gridSize - 1; row++) {
				
				// calculate row center
				double y = minY + (row + 0.5) * ((maxY - minY) / gridSize);
				
				// calculate test value
				double test = x * x + y * y;
				
				// if test pass, set counter + 1
				if(test < r1 * r1 && test > r2 * r2) {
					counter ++;
				}
			}
		}
		
		// calculate area
		double area = (maxX - minX) * (maxY - minY) * counter / (gridSize * gridSize);
		
		// print area value
		System.out.println("Approximate Estimation: " + area);
	}
	
	// monte carlo estimation method
	static void calcMonte(double r1, double r2) {
		
		// declare counter
		double counter = 0.0;
		
		// declare grid max/mins
		double maxX = r1;
		double minX = -r1;
		double maxY = r1;
		double minY = -r1;
		
		// iterate through columns
		for(int col = 0; col < gridSize - 1; col++) {
			
			// iterate through rows
			for(int row = 0; row < gridSize - 1; row++) {
				
				// iterate through samples
				for(int i = 0; i < samples; i++) {
					
					// generate random scatter points per cell
					double x = minX + (col + Math.random()) * ((maxX - minX) / gridSize);
					double y = minY + (row + Math.random()) * ((maxY - minY) /  gridSize);
					
					// calculate test value
					double test = x * x + y * y;
					
					// if test pass, set current cell value to 1
					if(test < outRad * outRad && test > inRad * inRad) {
						hits[col][row] = 1;
					}
					
				// divide each cell by samples
				hits[col][row] = hits[col][row] / samples;
				
				// add cell value to counter
				counter = counter + hits[col][row];
				}
			}
		}
		
		// calculate area
		double area = (maxX - minX) * (maxY - minY) * counter / (gridSize * gridSize);
		
		// print area value
		System.out.println("Monte Carlo Estimation: " + area);
	}
}
