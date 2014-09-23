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

	// declare grid size, samples
	private final int GRIDSIZE = 600;
	private final int SAMPLES = 100;
	
	// declare 2d array
	private double[][] hits = new double[GRIDSIZE][GRIDSIZE];
	
	// save user input here
	private double outRadius;
	private double inRadius;
	
	// save calculated area here
	private double areaApprox;
	private double areaMonte;
	
	/**
	 * This method sets the radius.
	 * @param double r1 - The outer radius.
	 * @param double r2 - The inner radius.
	 */
	public void setRadius(double r1, double r2) {
		this.outRadius = r1;
		this.inRadius = r2;
	}
	
	/**
	 * This method returns the area calculated using approximate estimation.
	 * @return double areaApprox
	 */
	public double getAreaCalc() {
		return this.areaApprox;
	}
	
	public double getMonteCalc() {
		return this.areaMonte;
	}
	
	/**
	 * This method calculates the annulus area using approximate estimation.
	 * @param double r1 - The outer radius. 
	 * @param double r2 - The inner radius.
	 */
	public void calcApprox(double r1, double r2) {
		
		// declare counter
		int counter = 0;
		
		// declare grid max/mins
		double maxX = r1;
		double minX = -r1;
		double maxY = r1;
		double minY = -r1;
		
		// iterate through columns
		for(int col = 0; col < this.GRIDSIZE - 1; col++) {
			
			// calculate column center
			double x = minX + (col + 0.5) * ((maxX - minX) / this.GRIDSIZE);
			
			// iterate through rows
			for(int row = 0; row < this.GRIDSIZE - 1; row++) {
				
				// calculate row center
				double y = minY + (row + 0.5) * ((maxY - minY) / this.GRIDSIZE);
				
				 // if test pass, set counter + 1
				 if(isInside(x, y)) {
				  		counter++;
				 }
			}
		}
		
		// set calculated area to areaApprox
		this.areaApprox = (maxX - minX) * (maxY - minY) * counter / (this.GRIDSIZE * this.GRIDSIZE);
	}
	
	// monte carlo estimation method
	public void calcMonte(double r1, double r2) {
		
		// declare counter
		double counter = 0.0;
		
		// declare arraySum
		double arraySum = 0.0;
		
		// declare grid max/mins
		double maxX = r1;
		double minX = -r1;
		double maxY = r1;
		double minY = -r1;
		
		// iterate through columns
		for(int col = 0; col < this.GRIDSIZE - 1; col++) {
			
			// iterate through rows
			for(int row = 0; row < this.GRIDSIZE - 1; row++) {
				
				// iterate through samples
				for(int i = 0; i < this.SAMPLES; i++) {
					
					// generate random scatter points per cell
					double x = minX + (col + Math.random()) * ((maxX - minX) / this.GRIDSIZE);
					double y = minY + (row + Math.random()) * ((maxY - minY) /  this.GRIDSIZE);
					
					// if test pass, set counter + 1
					if(isInside(x, y)) {
						this.hits[col][row] = 1;
						arraySum++;
					}
				}
			}
		}
		
		// divide sum of array to samples
		arraySum = arraySum / this.SAMPLES;
		
		// add sum of array to counter
		counter = counter + arraySum;
		
		// calculate area
		this.areaMonte = (maxX - minX) * (maxY - minY) * counter / (this.GRIDSIZE * this.GRIDSIZE);
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
		if(test < this.outRadius * this.outRadius && test > this.inRadius * this.inRadius) {
			
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
}
