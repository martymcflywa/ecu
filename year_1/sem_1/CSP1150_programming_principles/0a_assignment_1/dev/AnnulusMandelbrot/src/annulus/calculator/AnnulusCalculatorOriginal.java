/**
 * Calculates area of Annulus using grid system after asking for user input.
 * Uses methods from Annulus and AnnulusGrid classes for some calculation.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140814
 * 
 * @param inRadius1			radius1 input from user
 * @param inRadius2			radius2 input from user
 * @param outRadius1		radius1 parsed as double
 * @param outRadius2		radius2 parsed as double
 * @param counter			calls AnnulusGrid.iterator to determine counter value
 */
package annulus.calculator;

import javax.swing.JOptionPane;

public class AnnulusCalculatorOriginal {

	public static void main(String[] args) {
		
		// get user input for radius1 and radius2 via JOptionPane and parse as double
		String inRadius1 = JOptionPane.showInputDialog("Enter the OUTER radius:");
		double outRadius1 = Double.parseDouble(inRadius1);
		String inRadius2 = JOptionPane.showInputDialog("Enter the INNER radius:");
		double outRadius2 = Double.parseDouble(inRadius2);
		
		// calls Annulus.setRadius1() and .setRadius2() to set radius to Annulus class
		AnnulusOriginal.setRadius1(outRadius1);
		AnnulusOriginal.setRadius2(outRadius2);
		
		// calls AnnulusGrid.setMin() and .setMax() to set max/min grid values to AnnulusGrid class
		AnnulusGridOriginal.setMin(outRadius1);
		AnnulusGridOriginal.setMax(outRadius1);
		
		// calls AnnulusGrid.iterator() to perform grid iteration and stores result to counter
		int counter = AnnulusGridOriginal.iterator();
		
		// calls Annuls.areaCalc and passes counter as arg to perform area calculation and print result
		AnnulusOriginal.areaCalc(counter);
		
		// part 2, calls hitsCounter **not working**
		double hitsCounter = AnnulusGridOriginal.hitsIterator();
		
		// calls Annuls.areaCalc and passes counter as arg to perform area calculation and print result
		AnnulusOriginal.areaCalc(hitsCounter);
		
		// ensures JOptionPane is closed
		System.exit(0);
	}
}
