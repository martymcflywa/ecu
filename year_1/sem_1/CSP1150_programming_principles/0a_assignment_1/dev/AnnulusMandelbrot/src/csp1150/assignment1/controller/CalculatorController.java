package csp1150.assignment1.controller;

// import component
import java.awt.Component;

// import bufferedimage
import java.awt.image.BufferedImage;

// import io
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
 * @version 5.2.0
 * @since 20141020
 */
public class CalculatorController {

	// declare the model/s
	private AnnulusModel theAnnulusModel;
	private MandelbrotModel theMandelbrotModel;
	
	// declare the view
	private CalculatorView theView;
	
	// some booleans for checking
	private boolean mandelbrotIsCalculated = false;

	/**
	 * The controller constructor.
	 * 
	 * @param CalculatorView theView - Import the view.
	 * @param AnnulusModel theAnnulusModel - Import the annulus model.
	 * @param MandelbrotModel theMandelbrotModel - Import the mandelbrot model.
	 */
	public CalculatorController(AnnulusModel theAnnulusModel, MandelbrotModel theMandelbrotModel, CalculatorView theView) {
		
		// assign the imported objects to their respective fields
		this.theAnnulusModel = theAnnulusModel;
		this.theMandelbrotModel = theMandelbrotModel;
		this.theView = theView;
		
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
			
			// set boolean to true
			mandelbrotIsCalculated = true;
			
		// else if view image radio is selected,	
		} else if(theView.getRadioMandelbrotViewImage().isSelected()) {
			
			// if mandelbrot area already calculated,
			if(mandelbrotIsCalculated) {
			
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
			
			// else tell user to calculate first
			} else {
				
				theView.displayErrorMessage("Calculate Mandelbrot area first!");
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
	 * TODO: try consolidating getComponentImage and saveComponentImage as one method, and one BufferedImage.
	 * 
	 * @param Component c - The component to capture.
	 * @return BufferedImage theImage - returns image of captured component.
	 */
	public final BufferedImage getComponentImage(Component c) {
		
		// create new buffered image, use component width and height minus padding
		BufferedImage theImage = new BufferedImage(c.getWidth() - 10, c.getHeight() - 10, BufferedImage.TYPE_INT_ARGB);
		
		// paint component image on to theImage
		c.paint(theImage.getGraphics());
		
		// return the image
		return theImage;
	}
	
	/**
	 * This method saves the captured component image to project root.
	 * TODO: use JFileChooser instead of hardcoded directory/filename.
	 * 
	 * @param Component c - The component to save.
	 * @throws Exception
	 */
	public final void saveComponentImage(Component c, String filename) throws Exception {
		
		// create new buffered image, call getComponentImage
		BufferedImage savedImage = getComponentImage(c);
		
		// create new file
		File theFile = new File(filename);
		
		// write buffered image to file
		ImageIO.write(savedImage, "png", theFile);
		
		// tell user where file is saved
		theView.displayInfoMessage("The image has been saved to " + theFile.getAbsolutePath());
	}
}
