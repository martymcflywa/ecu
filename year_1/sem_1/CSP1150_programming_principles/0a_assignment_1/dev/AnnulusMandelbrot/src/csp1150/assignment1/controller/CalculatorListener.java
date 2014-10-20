package csp1150.assignment1.controller;

// import event listener
import java.awt.event.*;
import java.io.File;

// import imageio
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


// import the project
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

	// declare the view and controller
	private CalculatorView theView;
	private CalculatorController theController;
	
//	// declare boolean ** MOVED TO VIEW
//	private boolean mandelbrotColourImageExists = false;
	
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
	 * @param CalculatorController theController - Import the controller.
	 */
	public CalculatorListener(CalculatorView theView, CalculatorController theController) {
		
		// import the view and controller
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
		 * Else if Annulus Reset Zoom button is clicked...
		 */
			
		} else if(e.getSource() == theView.getButtonAnnulusZoomReset()) {
			
			theController.resetAnnulusImage();
			
		/**
		 * Else if Annulus Save button is clicked...
		 * TODO: Define save button here.
		 */
		} else if(e.getSource() == theView.getButtonAnnulusSave()) {
			
			// **TESTING save
			//ImageIO.write((BufferedImage), "png", new File("Users/marty/Desktop/test.png"));
			
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
		}
		
		/**
		 * Else if...
		 * TODO: Define the rest of the buttons. 
		 */
	}
}
