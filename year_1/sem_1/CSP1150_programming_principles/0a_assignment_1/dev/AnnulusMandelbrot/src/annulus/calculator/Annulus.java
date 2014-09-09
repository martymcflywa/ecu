package annulus.calculator;

/**
 * Annulus static class
 * Contains attributes and methods related to the Annulus itself.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 2.0.0
 * @since 20140909 
 */

public class Annulus {
	
	// declare variables to store outer and inner radius of annulus
	private static double outRad;
	private static double inRad;
	
	// declare area
	private static double area;
	
	/**
	 * This method passes user input radius values as args,
	 * parses them as double, then stores as variables.
	 * @param String r1 - Parse String user input for outer radius value as double.
	 * @param String r2 - Parse String user input for inner radius value as double.
	 */
	static void setRadius(String r1, String r2) {
		
		// store args to private variables
		outRad = Double.parseDouble(r1);
		inRad = Double.parseDouble(r2);;
	}
	
	/**
	 * This method allows other classes to get outRad value.
	 * @return double outRad - The outer radius.
	 */
	static double getOutRad() {
		return outRad;
	}
	
	/**
	 * This method allows other classes to get private variable inRad value.
	 * @return double inRad - The inner radius.
	 */
	static double getInRad() {
		return inRad;
	}
	
	/**
	 * This method squares outer radius value.
	 * @return double - Outer radius * Outer radius.
	 */
	static double outRadSq() {
		return outRad * outRad;
	}
	
	/**
	 * This method squares inner radius value.
	 * @return double - Inner radius * inner radius.
	 */
	static double inRadSq() {
		return inRad * inRad;
	}
	
	/**
	 * This method sets the area of the Annulus.
	 * @param counter - Pass counter value from iterations as arg.
	 */
	static void setArea(double counter) {
		area = AnnulusGrid.getDelta('x') * AnnulusGrid.getDelta('y') * counter / AnnulusGrid.sizeSq();
	}
	
	/**
	 * This method allows other classes to get private variable area.
	 * @return double area
	 */
	static double getArea() {
		return area;
	}
}
