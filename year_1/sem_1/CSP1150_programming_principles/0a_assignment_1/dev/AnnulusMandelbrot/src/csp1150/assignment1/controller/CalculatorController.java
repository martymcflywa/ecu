package csp1150.assignment1.controller;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;



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
	 * @param AnnulusModel theAnnulusModel - Import the annulus model.
	 * @param MandelbrotModel theMandelbrotModel - Import the mandelbrot model.
	 */
	public CalculatorController(CalculatorView theView, AnnulusModel theAnnulusModel, MandelbrotModel theMandelbrotModel) {
		
		// assign the imported objects to their respective fields
		this.theView = theView;
		this.theAnnulusModel = theAnnulusModel;
		this.theMandelbrotModel = theMandelbrotModel;
		
		// add the listeners
		this.theView.addCalculatorListener(new CalculatorListener(this.theView, this));
	}
	
	/**
	 * This method defines actions when annulus calculate button is clicked.
	 * 
	 * @param args unused.
	 */
	public final void calculateAnnulus() {
		
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
	}
	
	/**
	 * This method defines actions when annulus zoom in button is clicked.
	 * 
	 * @param args unused.
	 */
	public final void zoomInAnnulus() {
		
		// set new max-mins to the model
		theAnnulusModel.setZoom(theView.getPixelZoomAnnulus());
		
		// recalculate using new max-mins
		theAnnulusModel.calcMonte();
		
		// refresh the greyscale image
		theView.refreshAnnulusImage(theAnnulusModel.getHitsArray());
	}
	
	/**
	 * This method defines actions when annulus reset image button is clicked.
	 * 
	 * @param args unused.
	 */
	public final void resetAnnulusImage() {
		
		// reset max-min to outer radius
		theAnnulusModel.resetImage();
		
		// recalculate using default max-mins
		theAnnulusModel.calcMonte();
		
		// refresh the greyscale image
		theView.refreshAnnulusImage(theAnnulusModel.getHitsArray());
	}
	
	/**
	 * This method defines actions when mandelbrot OK button is clicked.
	 * Also defines actions when radio buttons and checkbox is selected.
	 * 
	 * @param args unused.
	 */
	public final void calculateMandelbrot() {
		
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
				theView.setMandelbrotColourImageExists(true);
				
			// else random colour checkbox is not ticked,	
			} else {
			
				// if mandelbrot colour image is already shown,
				if(theView.getMandelbrotColourImageExists()) {
					
					// recalculate monte to refill values in hits array
					theMandelbrotModel.calcMonte();
					
					// refresh greyscale image
					theView.refreshMandelbrotImage(theMandelbrotModel.getHitsArray());
					
					// set boolean to false
					theView.setMandelbrotColourImageExists(false);
					
				// else
				} else {
					
					// refresh the greyscale image
					theView.refreshMandelbrotImage(theMandelbrotModel.getHitsArray());
				}
			}
		}
	}
	
	/**
	 * This method defines actions when mandelbrot zoom in button is clicked.
	 * 
	 * @param args unused.
	 */
	public final void zoomInMandelbrot() {
		
		// set new max-mins to the model
		theMandelbrotModel.setZoom(theView.getPixelZoomMandelbrot());
		
		// if random colour checkbox is ticked,
		if(theView.getCheckBoxMandelbrotRandomColour().isSelected()) {
			
			// calculate area using escape time
			theMandelbrotModel.calcEscape();
			
			// refresh the colour image
			theView.refreshMandelbrotImage(theMandelbrotModel.getEscapeArray());
			
			// set boolean to true
			theView.setMandelbrotColourImageExists(true);;
		
		// else random colour checkbox is not ticked,
		} else {
			
			// recalculate monte to refill values in hits array
			theMandelbrotModel.calcMonte();
			
			// refresh greyscale image
			theView.refreshMandelbrotImage(this.theMandelbrotModel.getHitsArray());
			
			// set boolean to false
			theView.setMandelbrotColourImageExists(false);;
		}
	}
	
	/**
	 * This method defines actions when mandelbrot reset image button is clicked.
	 * 
	 * @param args unused.
	 */
	public final void resetMandelbrotImage() {
		
		// reset max-min to outer radius
		theMandelbrotModel.resetImage();
		
		// recalculate using default max-mins
		theMandelbrotModel.calcMonte();
		
		// refresh the greyscale image
		theView.refreshMandelbrotImage(this.theMandelbrotModel.getHitsArray());
	}
	
	/**
	 * This method captures an image of a component.
	 * 
	 * @param Component c - The component to capture.
	 * @return BufferedImage theImage - returns image of captured component.
	 */
	public final BufferedImage getComponentImage(Component c) {
		
		BufferedImage theImage = new BufferedImage(c.getWidth(), c.getHeight(), BufferedImage.TYPE_INT_ARGB);
		c.paint(theImage.getGraphics());
		
		return theImage;
	}
	
	public final void saveComponentImage(Component c) throws Exception {
		
		BufferedImage savedImage = getComponentImage(c);
		ImageIO.write(savedImage, "png", new File("/Users/marty/Desktop/test.png"));
	}
}
