package csp1150.assignment1;

// import event listeners
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import greyscale view
import view.*;

/**
 * This class defines the calculator controller,
 * and communicates the information from the view
 * to the model and vice versa. This class also
 * handles exceptions.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 4.0.0
 * @since 20140930
 */
public class CalculatorController {

	// create reference to theView
	private CalculatorView theView;
	
	// create reference to theModel
	private CalculatorModel theAnnulus;
	
	// create reference to the mandelbrot model
	private MandelbrotModel theMandelbrot;
	
	// create reference to greyScaleAnnulus;
	private GreyscaleHitViewerPanel greyscaleAnnulus;
		
	/**
	 * This defines the CalculatorController constructor
	 * @param theView
	 * @param theAnnulus
	 * @param theMandelbrot
	 * @param greyscaleAnnulus
	 */
	public CalculatorController(CalculatorView theView, CalculatorModel theAnnulus, MandelbrotModel theMandelbrot, GreyscaleHitViewerPanel greyscaleAnnulus) {
		
		// assign this view object to the incoming view
		this.theView = theView;
		
		// assign this model object to the incoming model
		this.theAnnulus = theAnnulus;
		
		// assign this model object to the incoming model
		this.theMandelbrot = theMandelbrot;
		
		// assign this image object to the incoming image
		this.greyscaleAnnulus = greyscaleAnnulus;
		
		// create listener for the annulus calculate button
		this.theView.addAnnulusCalcListener(new AnnulusCalcListener());
		
		// create listener for the mandelbrot view button
		this.theView.addMandelbrotViewListener(new MandelbrotCalcListener());
	}
	
	/**
	 * This class defines the listener for
	 * the Annulus Calculator calculate button.
	 * @author Martin Ponce
	 * 
	 */
	class AnnulusCalcListener implements ActionListener {
		
		public void actionPerformed(ActionEvent arg0) {
			
			// declare default values for input fields
			double outRadius = 0.0;
			double inRadius = 0.0;
			
			// if values are entered, do the following
			try {
				
				// get the radius values from the view
				outRadius = theView.getOutRadius();
				inRadius = theView.getInRadius();
				
				// set radius to the model
				theAnnulus.setRadius(outRadius, inRadius);

				// get the calculated area approximate value from the model
				theView.setAnnulusAreaCalc(theAnnulus.getAreaCalc());
				
				// get the calculated monte carlo estimate value from the model
				theView.setAnnulusMonteCalc(theAnnulus.getMonteCalc());
				
				// call viewhits to get data from array
				greyscaleAnnulus.viewHits(theAnnulus.returnHits());
				
				// get the view to display greyscale annulus image
				theView.showGreyscaleAnnulus(greyscaleAnnulus);
			}
			
			// if no values are set, display error message
			catch(NumberFormatException exception1) {
				theView.displayErrorMessage("Enter two values.");
			}
			
			// todo: add catch when outer radius is lower than inner radius
		}
	}
	
	/**
	 * This class defines the listener for
	 * the Mandelbrot Calculator view button. 
	 * @author Martin Ponce
	 *
	 */
	class MandelbrotCalcListener implements ActionListener {
		
		public void actionPerformed(ActionEvent arg1) {
			
			// do the mandelbrot calculation
			theMandelbrot.calcMonte();
			
			// set the result in the view
			theView.setMandMonteCalc(theMandelbrot.getMonteCalc());
		}
	}
}
