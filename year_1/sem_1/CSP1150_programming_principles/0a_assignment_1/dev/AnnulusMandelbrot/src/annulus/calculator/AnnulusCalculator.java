/**
 * Calculates area of Annulus using grid system after asking for user input.
 * Uses methods from Annulus and AnnulusGrid classes for some calculation.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140814
 */
package annulus.calculator;

import javax.swing.JOptionPane;

public class AnnulusCalculator {

	public static void main(String[] args) {
		
		// instantiate new annulus and annulusGrid objects
		Annulus annObj = new Annulus();
		AnnulusGrid annGridObj = new AnnulusGrid();
		
		// get user input for annRadius1 and annRadius2 via JOptionPane
		String inputRadius1 = JOptionPane.showInputDialog("Enter the OUTER radius:");
		double annRadius1 = Double.parseDouble(inputRadius1);
		String inputRadius2 = JOptionPane.showInputDialog("Enter the INNER radius:");
		double annRadius2 = Double.parseDouble(inputRadius2);
		
		// set annRadius1 and annRadius2 to annulus object
		annObj.setAnnRadius1(annRadius1);
		annObj.setAnnRadius2(annRadius2);
		
		// set annRadius1 to minX, maxX, minY and maxY to annulusGrid object
		annGridObj.setMinX(annRadius1);
		annGridObj.setMaxX(annRadius1);
		annGridObj.setMinY(annRadius1);
		annGridObj.setMaxY(annRadius1);
		
		// declare counter
		double counter = 0.0;
		
		// nested for loops and conditional to calculate area for annulus using grid, calls methods from annulus and annulusGrid
		for(int col = 0; col < annGridObj.getGridSize(); col ++){
			double x = annGridObj.getCol(col);
			
			for(int row = 0; row < annGridObj.getGridSize(); row ++) {
				double y = annGridObj.getRow(row);
				double test = x * x + y * y;
				
				if(test < annObj.rad1Sq() && test > annObj.rad2Sq()) {
					counter ++;
				}
			}
		}

		// calculates annulus area from for loop results, also calls methods from annulusGrid
		double area = annGridObj.colDelta() * annGridObj.rowDelta() * counter / annGridObj.gridSizeSq();
		
		// prints results via JOptionPane
		JOptionPane.showMessageDialog(null, "The area of the Annulus is: " + area);
		
		// ensures JOptionPane is closed
		System.exit(0);
	}
}
