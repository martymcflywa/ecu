package csp1150.assignment1;

//import greyscale view
import view.*;

/**
 * This class instantiates all the calculator MVC classes together
 * and executes the program to calculate the area of
 * an annulus and mandelbrot.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 4.0.0
 * @since 20140930
 */
public class CalculatorMVC {

	/**
	 * The main method.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		// create the annulus model object
		CalculatorModel theAnnulus = new CalculatorModel();
		
		// create the mandelbrot model object
		MandelbrotModel theMandelbrot = new MandelbrotModel();
		
		// create annulus greyscaleview object
		GreyscaleHitViewerPanel greyscaleAnnulus = new GreyscaleHitViewerPanel(theAnnulus.getGridSize(), theAnnulus.getGridSize());
		
		// create mandelbrot greyscaleview object
		GreyscaleHitViewerPanel greyscaleMandelbrot = new GreyscaleHitViewerPanel(theMandelbrot.getGridSize(), theMandelbrot.getGridSize());
		
		// create mandelbrot colourview object
		ColourHitViewerPanel colourMandelbrot = new ColourHitViewerPanel(theMandelbrot.getGridSize(), theMandelbrot.getGridSize());
		
		// create the view object
		CalculatorView theView = new CalculatorView(greyscaleAnnulus, greyscaleMandelbrot, colourMandelbrot);
		
		// create the controller object
		CalculatorController theController = new CalculatorController(theView, theAnnulus, theMandelbrot, greyscaleAnnulus, greyscaleMandelbrot, colourMandelbrot);
	}
}
