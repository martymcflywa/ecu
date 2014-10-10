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
	private AnnulusModel theAnnulus;
	private MandelbrotModel theMandelbrot;
	
	// declare the view
	private CalculatorView theView;

	/**
	 * The controller constructor.
	 * 
	 * @param CalculatorView theView - Import the view.
	 * @param AnnulusModel theAnnulus - Import the annulus model.
	 * @param MandelbrotModel theMandelbrot - Import the mandelbrot model.
	 */
	public CalculatorController(CalculatorView theView, AnnulusModel theAnnulus, MandelbrotModel theMandelbrot) {
		
		// assign the imported objects to their respective fields
		this.theView = theView;
		this.theAnnulus = theAnnulus;
		this.theMandelbrot = theMandelbrot;
		
		// add the listeners
		this.theView.addTheListeners(new CalculatorListener(this.theView, this.theAnnulus));
	}
}
