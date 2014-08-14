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
		Annulus annulus = new Annulus();
		AnnulusGrid annulusGrid = new AnnulusGrid();
		
		// get user input for annRadius1 and annRadius2
		String inputRadius1 = JOptionPane.showInputDialog("Enter the OUTER radius:");
		double annRadius1 = Double.parseDouble(inputRadius1);
		String inputRadius2 = JOptionPane.showInputDialog("Enter the INNER radius:");
		double annRadius2 = Double.parseDouble(inputRadius2);
		
		// set annRadius1 and annRadius2 to annulus object
		annulus.setAnnRadius1(annRadius1);
		annulus.setAnnRadius2(annRadius2);
		
		// set annRadius1 to minX, maxX, minY and maxY to annulusGrid object
		annulusGrid.setMinX(annRadius1);
		annulusGrid.setMaxX(annRadius1);
		annulusGrid.setMinY(annRadius1);
		annulusGrid.setMaxY(annRadius1);
		
		// declare counter
		double counter = 0.0;
		
		// nested for loops and conditional to calculate area for annulus using grid, calls methods from annulus and annulusGrid
		for(double column = 0.0; column < annulusGrid.getGridSize(); column ++){
			double x = annulusGrid.getColumn(column);
			
			for(double row = 0.0; row < annulusGrid.getGridSize(); row ++) {
				double y = annulusGrid.getRow(row);
				double test = x * x + y * y;
				
				if(test < annulus.rad1Sq() && test > annulus.rad2Sq()) {
					counter ++;
				}
			}
		}

		// calculates annulus area from for loop results, also calls methods from annulusGrid
		double area = annulusGrid.columnDelta() * annulusGrid.rowDelta() * counter / annulusGrid.gridSizeSq();
		JOptionPane.showMessageDialog(null, "The area of the Annulus is: " + area);
		
		// ensures JOptionPane is closed
		System.exit(0);
	}
}
