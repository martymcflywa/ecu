package rewrite.controller;

import java.awt.*;
import java.awt.event.*;

import rewrite.model.*;
import rewrite.view.*;

public class CalculatorListener implements ActionListener {

	private CalculatorView theView;
	private AnnulusModel theAnnulusModel;
	private MandelbrotModel theMandelbrotModel;
	
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
	 * @param ShapeModel theModel - Import the model.
	 */
	public CalculatorListener(CalculatorView theView, AnnulusModel theAnnulusModel, MandelbrotModel theMandelbrotModel) {
		
		this.theView = theView;
		this.theAnnulusModel = theAnnulusModel;
		this.theMandelbrotModel = theMandelbrotModel;
	}
	
	public void actionPerformed(ActionEvent e) {
		
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
				outRadius = this.theView.getAnnulusOutRadius();
				inRadius = this.theView.getAnnulusInRadius();
				
				// if outer radius < inner radius,
				if(outRadius < inRadius) {
					
					// display error message
					this.theView.displayErrorMessage("Outer radius must be greater than inner radius!");
					
				// else,
				} else {
					
					// set input radius to the model
					this.theAnnulusModel.setRadius(outRadius, inRadius);
					
					// get calculated approx area from the model, show it in the view
					this.theView.setAnnulusAreaCalc(theAnnulusModel.getAreaCalc());
					
					// get calculated monte carlo area from the model, show it in the view
					this.theView.setAnnulusMonteCalc(theAnnulusModel.getMonteCalc());
					
					// refresh the greyscasle image
					this.theView.refreshAnnulusImage(this.theAnnulusModel.getHitsArray());
				}
			}
			
			// if no values are set, display error message
			catch(NumberFormatException ex) {
				
				this.theView.displayErrorMessage("Enter two values.");
			}
			
		/**
		 * Else if Mandelbrot OK button is clicked...
		 */
			
		} else if(e.getSource() == theView.getButtonMandelbrotOK()) {
			
			// if calculate radio is selected,
			if(theView.getRadioMandelbrotCalculate().isSelected()) {
				
				// do the monte calculation
				this.theMandelbrotModel.calcMonte();
				
				// get the monte calculation, add it to the view
				this.theView.setMandelbrotMonteCalc(this.theMandelbrotModel.getMonteCalc());
				
			// else if view image radio is selected,	
			} else if(theView.getRadioMandelbrotViewImage().isSelected()) {
				
				// if random colour checkbox is ticked,
				if(theView.getCheckBoxMandelbrotRandomColour().isSelected()) {
					
					// calculate area using escape time
					this.theMandelbrotModel.calcEscape();
					
					// refresh the colour image
					this.theView.refreshMandelbrotImage(this.theMandelbrotModel.getEscapeArray());
					
				// else random colour checkbox is not ticked,	
				} else {
				
					// refresh the greyscale image
					this.theView.refreshMandelbrotImage(this.theMandelbrotModel.getHitsArray());
				}
			}
		}
	}
}
