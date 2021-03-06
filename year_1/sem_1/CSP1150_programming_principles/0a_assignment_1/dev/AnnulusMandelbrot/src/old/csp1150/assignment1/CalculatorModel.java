package old.csp1150.assignment1;

/**
 * This super class defines the calculator model.
 * The shape's attributes are saved here,
 * and all calculation is handled by the methods
 * in this class.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 4.0.0
 * @since 20140930
 */
public class CalculatorModel {

	// declare constant grid size & samples
	protected final int GRIDSIZE = 400;
	protected final int SAMPLES = 100;
	
	// declare 2d array
	protected double[][] hits = new double[GRIDSIZE][GRIDSIZE];
	
	// these variables hold user input values
	private double outRadius;
	private double inRadius;
	
	// these variables hold the max-min values
	protected double maxX;
	protected double minX;
	protected double maxY;
	protected double minY;
	
	// these variables hold the calculated values
	private double areaApprox;
	protected double areaMonte;
	
	/**
	 * This method sets the radius.
	 * 
	 * @param double r1 - The outer radius.
	 * @param double r2 - The inner radius.
	 */
	public final void setRadius(double r1, double r2) {
		
		// set incoming radius values to their respective variables
		outRadius = r1;
		inRadius = r2;
		
		// set incoming radius values to their respective max-min variables
		maxX = r1;
		minX = -r1;
		maxY = r1;
		minY = -r1;
		
		// do Area calculation
		calcApprox();
		
		// do Monte calculation
		calcMonte();
	}
	
	/**
	 * This method returns the area calculated using approximate estimation.
	 * 
	 * @param args unused
	 * @return double areaApprox
	 */
	public final double getAreaCalc() {
		return areaApprox;
	}
	
	/**
	 * This method returns the area calculated using monte carlo method.
	 * 
	 * @param args unused
	 * @return double areaMonte
	 */
	public final double getMonteCalc() {
		return areaMonte;
	}
	
	/**
	 * This method calculates the area using approximate estimation.
	 * 
	 * @param args unused
	 */
	private final void calcApprox() {
		
		// declare counter
		int counter = 0;
		
		// iterate through columns
		for(int col = 0; col < GRIDSIZE - 1; col++) {
			
			// calculate column center
			double x = minX + (col + 0.5) * ((maxX - minX) / GRIDSIZE);
			
			// iterate through rows
			for(int row = 0; row < GRIDSIZE - 1; row++) {
				
				// calculate row center
				double y = minY + (row + 0.5) * ((maxY - minY) / GRIDSIZE);
				
				 // if test pass, set counter + 1
				 if(isInside(x, y)) {
				  		counter++;
				 }
			}
		}
		
		// set calculated area to areaApprox
		areaApprox = (maxX - minX) * (maxY - minY) * counter / Math.pow(GRIDSIZE, 2);
	}
	
	/**
	 * This method calculates the area using monte carlo estimation.
	 * 
	 * @param args unused
	 */
	protected final void calcMonte() {
		
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
		areaMonte = (maxX - minX) * (maxY - minY) * counter / Math.pow(GRIDSIZE, 2);
	}
	
	/**
	 * This method checks if center of cell, or hitpoints are within shape perimeter.
	 * 
	 * @param double x - The x-axis value.
	 * @param double y - The y-axis value.
	 * @return boolean inside.
	 */
	protected boolean isInside(double x, double y) {
		
		// calculate test value
		double test = x * x + y * y;
		
		// declare boolean variable to be returned
		boolean inside;
		
		// if test value less than outer radius squared and greater than inner radius squared
		if(test < outRadius * outRadius && test > inRadius * inRadius) {
			
			// set boolean to true
			inside = true;
			
		// else set boolean value to false
		} else {
			inside = false;
		}
		
		// return boolean value
		return inside;
	}
	
	/**
	 * This method returns the hits array to be used for the viewer.
	 * 
	 * @param args unused
	 * @return double[][] hits.
	 */
	public final double[][] returnHits() {
		return hits;
	}
	
	/**
	 * This method returns the GRIDSIZE constant.
	 * 
	 * @param args unused
	 * @return int GRIDSIZE.
	 */
	public final int getGridSize() {
		return GRIDSIZE;
	}
}