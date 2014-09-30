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
	private CalculatorModel theModel;
	
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
		
		// assign this class view to the incoming view
		this.theView = theView;
		
		// assign this class model to the incoming model
		this.theModel = theAnnulus;
		
		// assign this mandelmodel to the incoming model
		this.theMandelbrot = theMandelbrot;
		
		// assign this class greyScaleAnnulus to the incoming greyScaleAnnulus
		this.greyscaleAnnulus = greyscaleAnnulus;
		
		// create listener for the calculate button
		this.theView.addCalcListener(new CalcListener());
	}
	
	/**
	 * This class defines exception handling
	 * when the calculate button is pressed.
	 * 
	 * @author Martin Ponce
	 */
	class CalcListener implements ActionListener {
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
				theModel.setRadius(outRadius, inRadius);

				// get the calculated area approximate value from the model
				theView.setAreaCalc(theModel.getAreaCalc());
				
				// get the calculated monte carlo estimate value from the model
				theView.setMonteCalc(theModel.getMonteCalc());
				
				// call viewhits to get data from array
				greyscaleAnnulus.viewHits(theModel.returnHits());
				
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
}
