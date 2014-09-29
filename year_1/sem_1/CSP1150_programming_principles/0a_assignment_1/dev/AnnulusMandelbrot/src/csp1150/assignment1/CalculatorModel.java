package csp1150.assignment1;

/**
 * This class defines the calculator model.
 * The shape's attributes are saved here,
 * and all calculation is handled by the methods
 * in this class.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 3.1.0
 * @since 20140922
 */
public class CalculatorModel {

	// declare constant grid size & samples
	private final int GRIDSIZE = 400;
	private final int SAMPLES = 100;
	
	// declare 2d array
	private double[][] hits = new double[GRIDSIZE][GRIDSIZE];
	
	// these variables hold user input values
	private double outRadius;
	private double inRadius;
	
	// these variables hold the max-min values
	private double maxX;
	private double minX;
	private double maxY;
	private double minY;
	
	// these variables hold the calculated values
	private double areaApprox;
	private double areaMonte;
	
	/**
	 * This method sets the radius.
	 * @param double r1 - The outer radius.
	 * @param double r2 - The inner radius.
	 */
	public void setRadius(double r1, double r2) {
		
		// set incoming radius values to their respective variables
		outRadius = r1;
		inRadius = r2;
		
		// set incoming radius values to their respective max-min variables
		maxX = r1;
		minX = -r1;
		maxY = r1;
		minY = -r1;
		
		// do Area calculation
		calcApprox(outRadius, inRadius);
		
		// do Monte calculation
		calcMonte(outRadius, inRadius);
	}
	
	/**
	 * This method returns the area calculated using approximate estimation.
	 * @return double areaApprox
	 */
	public double getAreaCalc() {
		return areaApprox;
	}
	
	/**
	 * This method returns the area calculated using monte carlo method.
	 * @return double areaMonte
	 */
	public double getMonteCalc() {
		return areaMonte;
	}
	
	/**
	 * This method calculates the annulus area using approximate estimation.
	 * @param double r1 - The outer radius. 
	 * @param double r2 - The inner radius.
	 */
	public void calcApprox(double r1, double r2) {
		
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
	
	// monte carlo estimation method
	public void calcMonte(double r1, double r2) {
		
		// declare counter
		double counter = 0.0;
		
		// declare arraySum
		double arraySum = 0.0;
		
		// iterate through columns
		for(int col = 0; col < GRIDSIZE - 1; col++) {
			
			// iterate through rows
			for(int row = 0; row < GRIDSIZE - 1; row++) {
				
				// iterate through samples
				for(int i = 0; i < this.SAMPLES; i++) {
					
					// generate random scatter points per cell
					double x = minX + (col + Math.random()) * ((maxX - minX) / GRIDSIZE);
					double y = minY + (row + Math.random()) * ((maxY - minY) / GRIDSIZE);
					
					// if test pass, set counter + 1
					if(isInside(x, y)) {
						this.hits[col][row] = 1;
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
	 * @param double x - The x-axis value.
	 * @param double y - The y-axis value.
	 * @return boolean testBool
	 */
	protected boolean isInside(double x, double y) {
		
		// calculate test value
		double test = x * x + y * y;
		
		// declare boolean variable to be returned
		boolean testBool;
		
		// if test value less than outer radius squared and greater than inner radius squared
		if(test < outRadius * outRadius && test > inRadius * inRadius) {
			
			// set boolean to true
			testBool = true;
			
		// else set boolean value to false
		} else {
			testBool = false;
		}
		
		// return boolean value
		return testBool;
	}
	
	/**
	 * This method returns the hits array to be used for the viewer.
	 * @param args unused.
	 * @return double[][] hits.
	 */
	public double[][] returnHits() {
		return hits;
	}
	
	/**
	 * This method returns the GRIDSIZE constant.
	 * @return int GRIDSIZE.
	 */
	public int getGridSize() {
		return GRIDSIZE;
	}
}