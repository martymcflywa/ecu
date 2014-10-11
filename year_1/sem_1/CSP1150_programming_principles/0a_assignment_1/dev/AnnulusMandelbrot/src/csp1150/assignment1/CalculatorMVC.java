package csp1150.assignment1;

// import the project
import csp1150.assignment1.model.*;
import csp1150.assignment1.controller.*;
import csp1150.assignment1.view.*;

/**
 * This class contains the main method,
 * where the program is executed.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.1.0
 * @since 20141011
 */
public class CalculatorMVC {
	
	public static void main(String[] args) {
		
		// create the models
		AnnulusModel theAnnulusModel = new AnnulusModel();
		MandelbrotModel theMandelbrotModel = new MandelbrotModel();
		
		// create the view
		CalculatorView theView = new CalculatorView(theAnnulusModel.getGridSize());
		
		// create the controller
		CalculatorController theController = new CalculatorController(theView, theAnnulusModel, theMandelbrotModel);
	}
}
