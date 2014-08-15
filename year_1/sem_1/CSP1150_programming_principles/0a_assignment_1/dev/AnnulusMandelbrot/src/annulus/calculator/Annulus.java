/**
 * Defines Annulus class. Includes getters/setters and other methods used for calculation.
 * Executes from AnnulusCalculator
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140814
 * 
 * @param setAnnRadius1		set the outer radius for annulus
 * @param setAnnRadius2		set the inner radius for annulus
 * @return getAnnRadius1	get outer radius
 * @return getAnnRadius2	get inner radius
 * @return rad1Sq			calculate outer radius squared
 * @return rad2Sq			calculate inner radius squared
 */
package annulus.calculator;

class Annulus {

	private double annRadius1,
			annRadius2;
	
	void setAnnRadius1(double annRadius1) {
		this.annRadius1 = annRadius1;
	}
	
	void setAnnRadius2(double annRadius2) {
		this.annRadius2 = annRadius2;
	}
	
	double getAnnRadius1() {
		return annRadius1;
	}
	
	double getAnnRadius2() {
		return annRadius2;
	}

	double rad1Sq() {
		return annRadius1 * annRadius1;
	}
	
	double rad2Sq() {
		return annRadius2 * annRadius2;
	}
}
