package csp1150.assignment1.model;

/**
 * Subclass of ShapeModel. Defines the Annulus shape.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.1.0
 * @since 20141011
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
	 * @param double minX - The min X coordinate.
	 * @param double minY - The min Y coordinate.
	 * @param double maxX - The max X coordinate.
	 * @param double maxY - The max Y coordinate.
	 */
	public final void calcMonte() {
		
		// declare counter
		double counter = 0.0;
		
		// declare arraySum
		double arraySum = 0.0;
		
		// iterate through columns
		for(int col = 0; col < this.GRIDSIZE - 1; col++) {
			
			// iterate through rows
			for(int row = 0; row < this.GRIDSIZE - 1; row++) {
				
				// reset current cell value to 0
				this.hits[col][row] = 0;
				
				// iterate through samples
				for(int i = 0; i < SAMPLES; i++) {
					
					// generate random scatter points per cell
					double x = this.minX + (col + Math.random()) * ((this.maxX - this.minX) / this.GRIDSIZE);
					double y = this.minY + (row + Math.random()) * ((this.maxY - this.minY) / this.GRIDSIZE);
					
					// if test pass, set counter + 1
					if(isInside(x, y)) {
						this.hits[col][row] = 1;
						arraySum++;
					}
				}
			}
		}
		
		// divide sum of array to samples
		arraySum = arraySum / this.SAMPLES;
		
		// add sum of array to counter
		counter = counter + arraySum;
		
		// calculate area
		this.areaMonte = (this.maxX - this.minX) * (this.maxY - this.minY) * counter / Math.pow(this.GRIDSIZE, 2);
	}
}
