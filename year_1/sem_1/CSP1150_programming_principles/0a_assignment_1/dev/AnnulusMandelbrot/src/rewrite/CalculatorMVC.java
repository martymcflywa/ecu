package rewrite;

import rewrite.model.*;
import rewrite.view.*;
import rewrite.controller.*;

public class CalculatorMVC {
	
	public static void main(String[] args) {
		
		// create the models
		AnnulusModel theAnnulus = new AnnulusModel();
		MandelbrotModel theMandelbrot = new MandelbrotModel();
		
		// create the view
		CalculatorView theView = new CalculatorView(theAnnulus.getGridSize());
		
		// create the controller
		CalculatorController theController = new CalculatorController(theView, theAnnulus, theMandelbrot);
	}
}
