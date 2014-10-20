package csp1150.assignment1.controller;

// import event listener
import java.awt.event.*;

// import imageio
import javax.imageio.ImageIO;

// import the project
import csp1150.assignment1.model.*;
import csp1150.assignment1.view.*;

/**
 * This class defines what actions the listener performs
 * when buttons are pressed.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.1.0
 * @since 20141011
 */
public class CalculatorListener implements ActionListener {

	// declare the view and the models
	private CalculatorView theView;
	private AnnulusModel theAnnulusModel;
	private MandelbrotModel theMandelbrotModel;
	
	// declare boolean
	private boolean mandelbrotColourImageExists = false;
	
	/**
	 * The default constructor for inheritance.
	 * 
	 * @param args unused
	 */
	public CalculatorListener() {
		
	}
	
	/**
	 * The listener constructor.
	 * 
	 * @param CalculatorView theView - Import the view.
	 * @param AnnulusModel theAnnulusModel - Import the annulus model.
	 * @param MandelbrotModel theMandelbrotModel - Impor the mandelbrot model.
	 */
	public CalculatorListener(CalculatorView theView, AnnulusModel theAnnulusModel, MandelbrotModel theMandelbrotModel) {
		
		// import the view and the models
		this.theView = theView;
		this.theAnnulusModel = theAnnulusModel;
		this.theMandelbrotModel = theMandelbrotModel;
	}
	
	/**
	 * Implements from ActionListener.
	 * 
	 * This method defines the actions to take when
	 * a button from the view is clicked. 
	 * 
	 * @param ActionEvent e
	 */
	public final void actionPerformed(ActionEvent e) {
		
		/**
		 * If Annulus Calculate Button is clicked...
		 */
		
		if(e.getSource() == theView.getButtonAnnulusCalculate()) {
			
			// init default values for annulus input fields
			double outRadius = 0.0;
			double inRadius = 0.0;
			
			// if values are entered, do the following
			try {
				
				// get the annulus radius values from the view
				outRadius = theView.getAnnulusOutRadius();
				inRadius = theView.getAnnulusInRadius();
				
				// if outer radius < inner radius,
				if(outRadius < inRadius) {
					
					// display error message
					theView.displayErrorMessage("Outer radius must be greater than inner radius!");
					
				// else,
				} else {
					
					// set input radius to the model
					theAnnulusModel.setRadius(outRadius, inRadius);
					
					// get calculated approx area from the model, show it in the view
					theView.setAnnulusAreaCalc(theAnnulusModel.getAreaCalc());
					
					// get calculated monte carlo area from the model, show it in the view
					theView.setAnnulusMonteCalc(theAnnulusModel.getMonteCalc());
					
					// refresh the greyscale image
					theView.refreshAnnulusImage(this.theAnnulusModel.getHitsArray());
				}
			}
			
			// if no values are set, display error message
			catch(NumberFormatException ex) {
				
				theView.displayErrorMessage("Enter two values.");
			}
		
		/**
		 * Else if Annulus Zoom In button is clicked...
		 */
		
		} else if(e.getSource() == theView.getButtonAnnulusZoomIn()) {
			
			// set new max-mins to the model
			theAnnulusModel.setZoom(theView.getPixelZoomAnnulus());
			
			// recalculate using new max-mins
			theAnnulusModel.calcMonte();
			
			// refresh the greyscale image
			theView.refreshAnnulusImage(theAnnulusModel.getHitsArray());
			
		/**
		 * Else if Annulus Reset Zoom button is clicked...
		 */
			
		} else if(e.getSource() == theView.getButtonAnnulusZoomReset()) {
			
			// reset max-min to outer radius
			theAnnulusModel.resetImage();
			
			// recalculate using default max-mins
			theAnnulusModel.calcMonte();
			
			// refresh the greyscale image
			theView.refreshAnnulusImage(theAnnulusModel.getHitsArray());
			
		/**
		 * Else if Annulus Save button is clicked...
		 * TODO: Define save button here.
		 */
		} else if(e.getSource() == theView.getButtonAnnulusSave()) {
			
			// **TESTING save
			
		/**
		 * Else if Mandelbrot OK button is clicked...
		 */
			
		} else if(e.getSource() == theView.getButtonMandelbrotOK()) {
			
			// if calculate radio is selected,
			if(theView.getRadioMandelbrotCalculate().isSelected()) {
				
				// do the monte calculation
				theMandelbrotModel.calcMonte();
				
				// get the monte calculation, add it to the view
				theView.setMandelbrotMonteCalc(this.theMandelbrotModel.getMonteCalc());
				
			// else if view image radio is selected,	
			} else if(theView.getRadioMandelbrotViewImage().isSelected()) {
				
				// if random colour checkbox is ticked,
				if(theView.getCheckBoxMandelbrotRandomColour().isSelected()) {
					
					// calculate area using escape time
					theMandelbrotModel.calcEscape();
					
					// refresh the colour image
					theView.refreshMandelbrotImage(this.theMandelbrotModel.getEscapeArray());
					
					// set boolean to true
					mandelbrotColourImageExists = true;
					
				// else random colour checkbox is not ticked,	
				} else {
				
					// if mandelbrot colour image is already shown,
					if(mandelbrotColourImageExists) {
						
						// recalculate monte to refill values in hits array
						theMandelbrotModel.calcMonte();
						
						// refresh greyscale image
						theView.refreshMandelbrotImage(theMandelbrotModel.getHitsArray());
						
						// set boolean to false
						mandelbrotColourImageExists = false;
						
					// else
					} else {
						
						// refresh the greyscale image
						theView.refreshMandelbrotImage(theMandelbrotModel.getHitsArray());
					}
				}
			}
		
		/**
		 * Else if Mandelbrot Zoom In button is clicked...	
		 */
			
		} else if(e.getSource() == theView.getButtonMandelbrotZoomIn()) {
			
			// set new max-mins to the model
			theMandelbrotModel.setZoom(theView.getPixelZoomMandelbrot());
			
			// if random colour checkbox is ticked,
			if(theView.getCheckBoxMandelbrotRandomColour().isSelected()) {
				
				// calculate area using escape time
				theMandelbrotModel.calcEscape();
				
				// refresh the colour image
				theView.refreshMandelbrotImage(theMandelbrotModel.getEscapeArray());
				
				// set boolean to true
				mandelbrotColourImageExists = true;
			
			// else random colour checkbox is not ticked,
			} else {
				
				// recalculate monte to refill values in hits array
				theMandelbrotModel.calcMonte();
				
				// refresh greyscale image
				theView.refreshMandelbrotImage(this.theMandelbrotModel.getHitsArray());
				
				// set boolean to false
				mandelbrotColourImageExists = false;
			}
			
		/**
		 * Else if Mandelbrot Reset Image button is clicked...
		 */
			
		} else if(e.getSource() == theView.getButtonMandelbrotZoomReset()) {
			
			// reset max-min to outer radius
			theMandelbrotModel.resetImage();
			
			// recalculate using default max-mins
			theMandelbrotModel.calcMonte();
			
			// refresh the greyscale image
			theView.refreshMandelbrotImage(this.theMandelbrotModel.getHitsArray());
		}
		
		/**
		 * Else if...
		 * TODO: Define the rest of the buttons. 
		 */
	}
}
