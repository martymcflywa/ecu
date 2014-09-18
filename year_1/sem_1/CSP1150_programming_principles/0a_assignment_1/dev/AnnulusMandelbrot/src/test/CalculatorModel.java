package test;

import calculator.annulus.Annulus;

public class CalculatorModel {

	// declare grid size, samples
	private final int GRIDSIZE = 600;
	private final int SAMPLES = 100;
	
	// declare 2d array
	private double[][] hits = new double[GRIDSIZE][GRIDSIZE];
	
	// save user input here
	private double outRad;
	private double inRad;
	
	// save calculated area here
	private double areaApprox;
	private double areaMonte;
	
	/**
	 * Gets the area calculated using approximate estimation.
	 * @return double areaApprox
	 */
	public double getAreaApprox() {
		return areaApprox;
	}
	
	/**
	 * Calculates area of shape using approximate estimation.
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
		for(int col = 0; col < GRIDSIZE - 1; col++) {
			
			// calculate column center
			double x = minX + (col + 0.5) * ((maxX - minX) / GRIDSIZE);
			
			// iterate through rows
			for(int row = 0; row < GRIDSIZE - 1; row++) {
				
				// calculate row center
				double y = minY + (row + 0.5) * ((maxY - minY) / GRIDSIZE);
				
				// calculate test value
				double test = x * x + y * y;
				
				// if test pass, set counter + 1
				if(test < r1 * r1 && test > r2 * r2) {
					counter ++;
				}
				
				/*
				 * Something wrong with isInside()
				 * Isn't passing the boolean value when called,
				 * resulting in counter not being incremented
				 * 
				 * // if test pass, set counter + 1
				 * if(isInside(x, y)) {
				 * 		counter++;
				 * }
				 * 
				 */

			}
		}
		
		// calculate area
		areaApprox = (maxX - minX) * (maxY - minY) * counter / (GRIDSIZE * GRIDSIZE);
	}
	
	/**
	 * Checks if center of cell, or hitpoints are within shape perimeter.
	 * @param double x - The x-axis value.
	 * @param double y - The y-axis value.
	 * @return boolean testBool
	 */
	private boolean isInside(double x, double y) {
		
		// calculate test value
		double test = x * x + y * y;
		
		// declare boolean variable to be returned
		boolean testBool;
		
		// if test value less than outer radius squared and greater than inner radius squared
		if(test < outRad * outRad && test > inRad * inRad) {
			
			// set boolean to true
			testBool = true;
			
		// else set boolean value to false
		} else {
			testBool = false;
		}
		
		// return boolean value
		return testBool;
	}
}
