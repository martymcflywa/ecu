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
 * @since 20140922
 */
public class CalculatorController {

	// instantiate the view
	private CalculatorView theView;
	
	// instantiate the model
	private CalculatorModel theModel;
	
	// instantiate annulus greyscale for hitviewer method
	private GreyscaleHitViewerPanel greyScaleAnnulus;
	
	/**
	 * This defines the CalculatorController constructor
	 * @param theView
	 * @param theModel
	 * @param greyScaleAnnulus
	 */
	public CalculatorController(CalculatorView theView, CalculatorModel theModel, GreyscaleHitViewerPanel greyScaleAnnulus) {
		this.theView = theView;
		this.theModel = theModel;
		this.greyScaleAnnulus = greyScaleAnnulus;
		
		// create listener for the calculate button
		this.theView.addCalcListener(new CalcListener());
	}
	
	/**
	 * This class defines exception handling
	 * when the calculate button is pressed
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
				
				// get the radius values
				outRadius = theView.getOutRadius();
				inRadius = theView.getInRadius();
				
				// set radius to the model
				theModel.setRadius(outRadius, inRadius);
				
				// call the model's approximate calculation method
				theModel.calcApprox(outRadius, inRadius);
				
				// call the model's monte carlo calculation method
				theModel.calcMonte(outRadius, inRadius);
				
				// get the calculated area approximate value from the model
				theView.setAreaCalc(theModel.getAreaCalc());
				
				// get the calculated monte carlo estimate value from the model
				theView.setMonteCalc(theModel.getMonteCalc());
				
				theView.showGreyScaleAnnulus(greyScaleAnnulus);
				
				// call viewhits to get data from array
				greyScaleAnnulus.viewHits(theModel.returnHits());
			}
			
			// if no values are set, display error message
			catch(NumberFormatException exception1) {
				theView.displayErrorMessage("Enter two values.");
			}
			
			// todo: add catch when outer radius is lower than inner radius
		}
	}
}
