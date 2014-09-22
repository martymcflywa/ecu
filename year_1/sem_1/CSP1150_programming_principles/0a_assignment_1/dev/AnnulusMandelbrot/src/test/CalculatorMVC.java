package test;

/**
 * This class instantiates all the calculator MVC classes together
 * and executes the program to calculate the area of
 * an annulus and mandelbrot.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 3.1.0
 * @since 20140922
 */
public class CalculatorMVC {

	/**
	 * The main method.
	 * @param args
	 */
	public static void main(String[] args) {
		
		// instantiate the view
		CalculatorView theView = new CalculatorView();
		
		// instantiate the model
		CalculatorModel theModel = new CalculatorModel();
		
		// instantiate the controller
		CalculatorController theController = new CalculatorController(theView, theModel);
	}
}
