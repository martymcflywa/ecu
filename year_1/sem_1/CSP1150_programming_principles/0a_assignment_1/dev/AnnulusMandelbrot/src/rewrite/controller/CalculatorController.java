package rewrite.controller;

// the event listener
import java.awt.event.*;

// import the rest of the project
import rewrite.*;
import rewrite.model.*;
import rewrite.view.*;

/**
 * This super class defines the calculator controller,
 * which communicates the information from the view
 * to the model and vice versa. This class also
 * defines the action listeners and exceptions.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.0.0
 * @since 20141004
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
