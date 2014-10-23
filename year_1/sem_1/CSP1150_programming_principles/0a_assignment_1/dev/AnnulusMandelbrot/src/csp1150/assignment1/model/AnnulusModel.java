package csp1150.assignment1.model;

/**
 * Subclass of ShapeModel. Defines the Annulus shape.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.3.0
 * @since 20141022
 */
public class AnnulusModel extends ShapeModel {
	
	/**
	 * The default constructor.
	 */
	public AnnulusModel() {
		
	}
	
	/**
	 * Overloading ShapeModel's calcMonte method, to accept no args.
	 * Used for recalculating image for zooming in and out.
	 * 
	 * This method calculates the area using monte carlo estimation.
	 * Max-min values control how zoomed in the shape is.
	 * 
	 * @param args unused
	 */
	public final void calcMonte() {
		
		// declare counter
		double counter = 0.0;
		
		// declare arraySum
		double arraySum = 0.0;
		
		// iterate through columns
		for(int col = 0; col < this.getGridSize() - 1; col++) {
			
			// iterate through rows
			for(int row = 0; row < this.getGridSize() - 1; row++) {
				
				// reset current cell value to 0
				hits[col][row] = 0;
				
				// iterate through samples
				for(int i = 0; i < SAMPLES; i++) {
					
					// generate random scatter points per cell
					double x = minX + (col + Math.random()) * ((maxX - minX) / this.getGridSize());
					double y = minY + (row + Math.random()) * ((maxY - minY) / this.getGridSize());
					
					// if test pass, set counter + 1
					if(isInside(x, y)) {
						
						hits[col][row] = 1;
						arraySum++;
					}
				}
			}
		}
		
		// divide sum of array to samples
		arraySum = arraySum / SAMPLES;
		
		// add sum of array to counter
		counter = counter + arraySum;
		
		// calculate area
		areaMonte = (maxX - minX) * (maxY - minY) * counter / Math.pow(this.getGridSize(), 2);
	}
}
