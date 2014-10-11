package csp1150.assignment1.controller;

// import the project
import csp1150.assignment1.model.*;
import csp1150.assignment1.view.*;


/**
 * This class defines the calculator controller,
 * which communicates the information from the view
 * to the model and vice versa.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.1.0
 * @since 20141011
 */
public class CalculatorController {

	// declare the model/s
	private AnnulusModel theAnnulusModel;
	private MandelbrotModel theMandelbrotModel;
	
	// declare the view
	private CalculatorView theView;

	/**
	 * The controller constructor.
	 * 
	 * @param CalculatorView theView - Import the view.
	 * @param AnnulusModel theAnnulus - Import the annulus model.
	 * @param MandelbrotModel theMandelbrot - Import the mandelbrot model.
	 */
	public CalculatorController(CalculatorView theView, AnnulusModel theAnnulusModel, MandelbrotModel theMandelbrotModel) {
		
		// assign the imported objects to their respective fields
		this.theView = theView;
		this.theAnnulusModel = theAnnulusModel;
		this.theMandelbrotModel = theMandelbrotModel;
		
		// add the listeners
		this.theView.addCalculatorListener(new CalculatorListener(this.theView, this.theAnnulusModel, this.theMandelbrotModel));
	}
}
