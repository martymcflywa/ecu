package annulus.calculator;
import javax.swing.JOptionPane;

/**
 * AnnulusCalc static class
 * This program calculates an Annulus' area using two methods:
 * Approximate area and monte carlo estimation.
 * The program executes from this class.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 2.0.0
 * @since 20140909 
 */

public class AnnulusCalc {
	
	public static void main(String[] args) {
		getUserInput();
	}
	
	/**
	 * This method gets user input for Annulus radius.
	 * Uses if statement to catch erroneous user input.
	 * @param args unused.
	 */
	static void getUserInput() {
		
		// get user input using JOptionPane
		String rawInputOutRad = JOptionPane.showInputDialog("Enter the OUTER radius:");
		String rawInputInRad = JOptionPane.showInputDialog("Enter the INNER radius:");
		
		// sets radius values to Annulus class
		Annulus.setRadius(rawInputOutRad, rawInputInRad);
		
		// if outer radius is greater than inner radius, continue execution
		if(Annulus.getOutRad() > Annulus.getInRad()) {
			
			// set AnnulusGrid max/min grid values
			AnnulusGrid.setMaxMin(Annulus.getOutRad());
			
			// set AnnulusGrid max/min deltas
			AnnulusGrid.setDelta();
			
			// start approximate area grid iteration
			iterateApprox();
			
			// start monte carlo estimation grid iteration
			iterateMonte();
		
		// else outer radius is less than inner radius, display error message and recall method
		} else {
			
			// notify user of input error
			JOptionPane.showMessageDialog(null, "Input error. OUTER radius MUST BE GREATER than INNER radius!");
			
			// ask user to try again with correct values
			JOptionPane.showMessageDialog(null, "Try again. Make sure the OUTER radius is GREATER than the INNER radius.");
			
			// restart method
			getUserInput();
		}
	}
	
	/**
	 * This method performs the grid iteration for the approximate area calculation.
	 * @param args unused.
	 */
	static void iterateApprox() {
		
		// init counter
		int counter = 0;
		
		// iterate columns
		for(int col = 0; col < AnnulusGrid.gridSize() - 1; col++) {
			
			// set x to column center
			double x = AnnulusGrid.getCenter('x', col);
			
			// iterate rows
			for(int row = 0; row < AnnulusGrid.gridSize() - 1; row++) {
				
				// set y to row center
				double y = AnnulusGrid.getCenter('y', row);
				
				// if cell center is within Annulus perimeter, set counter + 1
				if(isInside(x, y)) {
					counter++;
				}
			}
		}
		
		// set Annulus area, pass counter as arg for calculation
		Annulus.setArea(counter);
		
		// call method to display approximate area
		calcApprox();
	}
	
	/**
	 * This method tests current cell center is within Annulus perimeter.
	 * @param double x - The center value of row.
	 * @param double y - The center value of column.
	 * @return boolean testBool - State whether grid center is within Annulus perimeter.
	 */
	static boolean isInside(double x, double y) {
		
		// calculate test value
		double test = x * x + y * y;
		
		// declare boolean variable to be returned
		boolean testBool;
		
		// if test value less than outer radius squared and greater than inner radius squared
		if(test < Annulus.outRadSq() && test > Annulus.inRadSq()) {
			
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
	 * This method prints approximate area result via JOptionPane.
	 */
	static void calcApprox() {
				
		// display approximate area result
		JOptionPane.showMessageDialog(null, "The Approximate Area of the Annulus is: " + Annulus.getArea());
	}
	
	/**
	 * This method performs the grid iteration for monte carlo estimate calculation.
	 * @param args unused.
	 */
	static void iterateMonte() {
		
		// declare counter
		double counter = 0.0;
		
		// iterate columns
		for(int col = 0; col < AnnulusGrid.gridSize() - 1; col++) {
			
			// iterate rows
			for(int row = 0; row < AnnulusGrid.gridSize() - 1; row++) {
				
				// iterate samples
				for(int s = 0; s < AnnulusGrid.getSamples(); s++) {
					
					// set x to random hitpoints for current cell
					double x = AnnulusGrid.getHits('x', col);
					
					// set y to random hitpoints for current cell
					double y = AnnulusGrid.getHits('y', row);
					
					// if random hitpoints are within Annulus perimeter, set current array cell to 1
					if(isInside(x, y)) {
						AnnulusGrid.setArray(col, row);
					}
					
					// divide array current cell value by SAMPLES
					AnnulusGrid.divideArray(col, row);
					
					// add array current cell value to counter
					counter = counter + AnnulusGrid.getArray(col, row);
				}
			}
		}
		
		// set Annulus area, pass counter as arg for calculation
		Annulus.setArea(counter);
		
		// call method to display monte carlo estimation
		calcMonte();
	}
	
	/**
	 * This method prints monte carlo estimation result via JOptionPane.
	 */
	static void calcMonte() {
		
		// display monte carlo estimation result
		JOptionPane.showMessageDialog(null, "The Monte Carlo Estimated area of the Annulus is: " + Annulus.getArea());
	}
}
