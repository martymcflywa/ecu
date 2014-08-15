/**
 * Defines static Annulus class. Includes getters/setters and other methods used for calculation.
 * Executes from AnnulusCalculator
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140814
 * 
 * @param setAnnRadius1		set outer radius
 * @param setAnnRadius2		set inner radius
 * 
 * @return getAnnRadius1	get outer radius
 * @return getAnnRadius2	get inner radius
 * @return rad1Sq			calculate outer radius squared
 * @return rad2Sq			calculate inner radius squared
 * 
 * @void areaCalc			calculate area of annulus with counter as arg, prints results
 */
package annulus.calculator;

import javax.swing.JOptionPane;

class Annulus {

	private static double radius1,
			radius2;
	
	static void setRadius1(double radius1) {
		Annulus.radius1 = radius1;
	}
	
	static void setRadius2(double radius2) {
		Annulus.radius2 = radius2;
	}
	
	static double getRadius1() {
		return radius1;
	}
	
	static double getRadius2() {
		return radius2;
	}

	static double rad1Sq() {
		return radius1 * radius1;
	}
	
	static double rad2Sq() {
		return radius2 * radius2;
	}
	
	static void areaCalc(double counter) {
		double area = AnnulusGrid.colDelta() * AnnulusGrid.rowDelta() * counter / AnnulusGrid.gridSizeSq();
		JOptionPane.showMessageDialog(null, "The area of the Annulus is: " + area);
	}
}
