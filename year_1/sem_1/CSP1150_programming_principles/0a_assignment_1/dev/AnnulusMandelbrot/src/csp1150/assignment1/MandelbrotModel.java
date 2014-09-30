package csp1150.assignment1;

/**
 * Subclass of CalculatorModel.
 * The mandelbrot's attributes are saved here,
 * with modified max-min values and overrides
 * CalculatorModel's isInside() method.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 4.0.0
 * @since 20140930
 */
public class MandelbrotModel extends CalculatorModel {
	
	// declaring constant
	private final int MAX_STEPS = 255;
	
	/**
	 * This constructor modifies the max-min values,
	 * so that it can be used to calculate an area
	 * of a mandelbrot.
	 */
	public MandelbrotModel() {
		this.maxX = 2;
		this.minX = -2;
		this.maxY = 2;
		this.minY = -2;
	}
	
	/**
	 * This method checks if hitpoints are within shape perimeter.
	 * Overriding CalculatorModel's original method.
	 * @param double x - The x-axis value.
	 * @param double y - The y-axis value.
	 * @return boolean inside
	 */
	protected boolean isInside(double x, double y) {
		
		boolean inside = true;
		
		int steps = 0;
		
		double px = 0;
		double py = 0;
		
		while(steps < MAX_STEPS && inside) {
			inside = px * px + py * py < 4.0;
			
			double py1 = 2 * px * py + y;
			px = px * px - py * py + x;
			py = py1;
			
			steps++;
		}
		
		return inside;
	}
}
