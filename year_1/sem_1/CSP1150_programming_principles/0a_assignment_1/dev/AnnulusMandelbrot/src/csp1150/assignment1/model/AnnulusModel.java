package csp1150.assignment1.model;

/**
 * Subclass of ShapeModel. Defines the Annulus shape.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.3.1
 * @since 20141024
 */
public class AnnulusModel extends ShapeModel {
	
	/**
	 * The default constructor.
	 */
	public AnnulusModel() {
		
	}
	
	/**
	 * Overloading ShapeModel's calcMonte method, removed args.
	 * Used for recalculating image for zooming in and out.
	 * 
	 * This method calculates the area using monte carlo estimation.
	 * Min-max values control how zoomed in the shape is.
	 * 
	 * @param args unused.
	 */
	public final void calcMonte() {
		
		// declare counter
		double counter = 0.0;
		
		// declare arraySum
		double arraySum = 0.0;
		
		// iterate through columns
		for(int col = 0; col < getGridSize() - 1; col++) {
			
			// iterate through rows
			for(int row = 0; row < getGridSize() - 1; row++) {
				
				// reset current cell value to 0
				getHitsArray()[col][row] = 0;
				
				// iterate through samples
				for(int i = 0; i < this.getSamples(); i++) {
					
					// generate random scatter points per cell
					double x = getMinX() + (col + Math.random()) * ((getMaxX() - getMinX()) / getGridSize());
					double y = getMinY() + (row + Math.random()) * ((getMaxY() - getMinY()) / getGridSize());
					
					// if test pass, set counter + 1
					if(isInside(x, y)) {
						
						getHitsArray()[col][row] = 1;
						arraySum++;
					}
				}
			}
		}
		
		// divide sum of array to samples
		arraySum = arraySum / getSamples();
		
		// add sum of array to counter
		counter = counter + arraySum;
		
		// calculate area
		setMonteCalc(counter);
	}
}
