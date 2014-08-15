/**
 * Defines Annulus class. Includes getters/setters and other methods used for calculation.
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
 */
package annulus.calculator;

class Annulus {

	private static double annRadius1,
			annRadius2;
	
	static void setRadius1(double annRadius1) {
		Annulus.annRadius1 = annRadius1;
	}
	
	static void setRadius2(double annRadius2) {
		Annulus.annRadius2 = annRadius2;
	}
	
	static double getRadius1() {
		return annRadius1;
	}
	
	static double getRadius2() {
		return annRadius2;
	}

	static double rad1Sq() {
		return annRadius1 * annRadius1;
	}
	
	static double rad2Sq() {
		return annRadius2 * annRadius2;
	}
}
