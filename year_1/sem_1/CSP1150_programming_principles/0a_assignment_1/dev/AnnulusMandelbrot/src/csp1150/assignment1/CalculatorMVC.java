package csp1150.assignment1;

//import greyscale view
import view.*;

/**
 * This class instantiates all the calculator MVC classes together
 * and executes the program to calculate the area of
 * an annulus and mandelbrot.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 3.2.0
 * @since 20140930
 */
public class CalculatorMVC {

	/**
	 * The main method.
	 * @param args
	 */
	public static void main(String[] args) {
		
		// create the model object
		CalculatorModel theModel = new CalculatorModel();
		
		// create a greyscaleview object for the annulus
		GreyscaleHitViewerPanel greyScaleAnnulus = new GreyscaleHitViewerPanel(theModel.getGridSize(), theModel.getGridSize());
		
		// create the view object
		CalculatorView theView = new CalculatorView(greyScaleAnnulus);
		
		// create the controller object
		CalculatorController theController = new CalculatorController(theView, theModel, greyScaleAnnulus);
	}
}
