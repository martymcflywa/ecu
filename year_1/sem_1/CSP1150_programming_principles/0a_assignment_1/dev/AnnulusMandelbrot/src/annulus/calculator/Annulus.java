/**
 * Defines Annulus class. Includes getters/setters and other methods used for calculation.
 * Executes from AnnulusCalculator
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140814
 */
package annulus.calculator;

class Annulus {

	private double annRadius1,
			annRadius2;
	
	/**
	 * @return get annRadius1
	 */
	double getAnnRadius1() {
		return annRadius1;
	}
	/**
	 * @param set annRadius1
	 */
	void setAnnRadius1(double annRadius1) {
		this.annRadius1 = annRadius1;
	}
	/**
	 * @return get annRadius2
	 */
	double getAnnRadius2() {
		return annRadius2;
	}
	/**
	 * @param set annRadius2
	 */
	void setAnnRadius2(double annRadius2) {
		this.annRadius2 = annRadius2;
	}
	
	/**
	 * @return get annRadius1 squared
	 */
	double rad1Sq() {
		return annRadius1 * annRadius1;
	}
	
	/**
	 * @return get annRadius2 squared
	 */
	double rad2Sq() {
		return annRadius2 * annRadius2;
	}
}
