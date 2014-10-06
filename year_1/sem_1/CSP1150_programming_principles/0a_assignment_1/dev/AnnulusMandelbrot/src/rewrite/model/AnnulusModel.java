package rewrite.model;

/**
 * Subclass of ShapeModel. Defines the Annulus shape.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.0.0
 * @since 20141004
 */
public class AnnulusModel extends ShapeModel {
	
	public AnnulusModel() {
		
	}

	// probably don't need this constructor
//	/**
//	 * This Annulus Model constructor.
//	 * 
//	 * @param double outRadius - The outer radius.
//	 * @param double inRadius - The inner radius.
//	 */
//	public AnnulusModel(double outRadius, double inRadius) {
//		
//		// set incoming radius values to their respective variables
//		this.outRadius = outRadius;
//		this.inRadius = inRadius;
//		
//		// set incoming radius values to their respective max-min variables
//		this.maxX = this.outRadius;
//		this.maxY = this.outRadius;
//		this.minX = -this.outRadius;
//		this.minY = -this.outRadius;
//		
//		// do Area calculation
//		calcApprox(this.maxX, this.maxY, this.minX, this.minY);
//		
//		// do Monte calculation
//		calcMonte(this.maxX, this.maxY, this.minX, this.minY);
//	}
}
