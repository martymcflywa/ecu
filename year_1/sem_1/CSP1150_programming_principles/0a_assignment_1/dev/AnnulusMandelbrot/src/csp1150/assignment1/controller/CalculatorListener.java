package csp1150.assignment1.controller;

// import event listener
import java.awt.event.*;

// import the view
import csp1150.assignment1.view.*;

/**
 * This class defines what actions the listener performs
 * when buttons are pressed.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.3.1
 * @since 20141024
 */
public class CalculatorListener implements ActionListener {

	// declare the view and controller
	private CalculatorView theView;
	private CalculatorController theController;
	
	/**
	 * The listener constructor.
	 * 
	 * @param CalculatorView theView - The view object.
	 * @param CalculatorController theController - the controller object.
	 */
	public CalculatorListener(CalculatorView theView, CalculatorController theController) {
		
		// set objects to their reference variables
		this.theView = theView;
		this.theController = theController;
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
			
			theController.calculateAnnulus();
		
		/**
		 * Else if Annulus Zoom In button is clicked...
		 */
		
		} else if(e.getSource() == theView.getButtonAnnulusZoomIn()) {
			
			theController.zoomInAnnulus();
			
		/**
		 * Else if Annulus Reset Image button is clicked...
		 */
			
		} else if(e.getSource() == theView.getButtonAnnulusZoomReset()) {
			
			theController.resetAnnulusImage();
			
		/**
		 * Else if Annulus Save Image button is clicked...
		 */
		} else if(e.getSource() == theView.getButtonAnnulusSave()) {
			
			// try saving image first,
			try {
			
				theController.saveImage(theView.getPanelAnnulusImage(), "AnnulusImage.png");
			
			// if exception thrown,
			} catch(Exception ex) {
				
				// show error message
				theView.displayErrorMessage("Error saving image, try again.");
			}
			
		/**
		 * Else if Mandelbrot OK button is clicked...
		 */
			
		} else if(e.getSource() == theView.getButtonMandelbrotOK()) {
			
			theController.calculateMandelbrot();
		
		/**
		 * Else if Mandelbrot Zoom In button is clicked...	
		 */
			
		} else if(e.getSource() == theView.getButtonMandelbrotZoomIn()) {
			
			theController.zoomInMandelbrot();
			
		/**
		 * Else if Mandelbrot Reset Image button is clicked...
		 */
			
		} else if(e.getSource() == theView.getButtonMandelbrotZoomReset()) {
			
			theController.resetMandelbrotImage();
		
		/**
		 * Else if Mandelbrot Save Image button is clicked...
		 */
		
		} else if(e.getSource() ==  theView.getButtonMandelbrotSave()) {
			
			// try saving image first,
			try {
			
				theController.saveImage(theView.getPanelMandelbrotImage(), "MandelbrotImage.png");
			
			// if exception thrown,
			} catch(Exception ex) {
				
				// show error message
				theView.displayErrorMessage("Error saving image, try again.");
			}
		}
	}
}
