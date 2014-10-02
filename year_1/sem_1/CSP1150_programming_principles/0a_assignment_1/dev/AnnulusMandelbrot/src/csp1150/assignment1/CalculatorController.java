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
	
	// create reference to greyscaleAnnulus;
	private HitViewerGenerator greyscaleAnnulus;
	
	// create reference to greyscaleMandelbrot
	private HitViewerGenerator greyscaleMandelbrot;
	
	// create reference to colourMandelbrot
	private ColourHitViewer colourMandelbrot;
		
	/**
	 * This defines the CalculatorController constructor.
	 * 
	 * @param theView
	 * @param theAnnulus
	 * @param theMandelbrot
	 * @param greyscaleAnnulus
	 * @param greyscaleMandelbrot
	 * @param colourMandelbrot
	 */
	public CalculatorController(CalculatorView theView, CalculatorModel theAnnulus, MandelbrotModel theMandelbrot, HitViewerGenerator greyscaleAnnulus, HitViewerGenerator greyscaleMandelbrot, ColourHitViewer colourMandelbrot) {
		
		// assign this view object to the incoming view
		this.theView = theView;
		
		// assign this model object to the incoming model
		this.theAnnulus = theAnnulus;
		
		// assign this model object to the incoming model
		this.theMandelbrot = theMandelbrot;
		
		// assign this image object to the incoming image
		this.greyscaleAnnulus = greyscaleAnnulus;
		
		// assign this image object to the incoming image
		this.greyscaleMandelbrot = greyscaleMandelbrot;
		
		// assign this image object to the incoming image
		this.colourMandelbrot = colourMandelbrot;
		
		// create listener for the annulus calculate button
		this.theView.addAnnulusCalcListener(new AnnulusCalcListener());
		
		// create listener for the mandelbrot view button
		this.theView.addMandelbrotCalcListener(new MandelbrotCalcListener());
	}
	
	/**
	 * This class defines the listener for
	 * the Annulus Calculator calculate button.
	 * 
	 * @author Martin Ponce
	 */
	class AnnulusCalcListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			// declare default values for input fields
			double outRadius = 0.0;
			double inRadius = 0.0;
			
			// if values are entered, do the following
			try {
				
				// get the radius values from the view
				outRadius = theView.getOutRadius();
				inRadius = theView.getInRadius();
				
				// if outer radius < inner radius,
				if(outRadius < inRadius) {
					
					// display error message
					theView.displayErrorMessage("Outer radius must be greater than inner radius!");
					
				// else,
				} else {
					
					// set radius to the model
					theAnnulus.setRadius(outRadius, inRadius);

					// get the calculated area approximate value from the model
					theView.setAnnulusAreaCalc(theAnnulus.getAreaCalc());
					
					// get the calculated monte carlo estimate value from the model
					theView.setAnnulusMonteCalc(theAnnulus.getMonteCalc());
					
					// call viewhits to get data from array
					greyscaleAnnulus.viewHits(theAnnulus.returnHits());
					
					// get the view to display greyscale annulus image
					theView.showAnnulusImage(greyscaleAnnulus);
				}
			}
			
			// if no values are set, display error message
			catch(NumberFormatException exception1) {
				theView.displayErrorMessage("Enter two values.");
			}
		}
	}
	
	/**
	 * This class defines the listener for
	 * the Mandelbrot Calculator view button. 
	 * 
	 * @author Martin Ponce
	 */
	class MandelbrotCalcListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			// if normal view is selected
			if(theView.radioMandCalculate.isSelected()) {
				
				// do the monte calculation
				theMandelbrot.calcMonte();
				
				// set the result in the view
				theView.setMandMonteCalc(theMandelbrot.getMonteCalc());
				
				// generate image with viewhits
				greyscaleMandelbrot.viewHits(theMandelbrot.returnHits());
				
				// show the image in the view
				theView.showMandelbrotImage(greyscaleMandelbrot);
				
			// else if back to the 60s view is selected	
			} else if(theView.radioMandViewImage.isSelected()) {
				
				// do the monte calculation
				//theMandelbrot.calcMonte();
				
				// do the escape time calculation
				theMandelbrot.calcEscape();
				
				// set the monte result in the view
				//theView.setMandMonteCalc(theMandelbrot.getMonteCalc());
				
				// generate image with viewhits, use escapearray values instead
				colourMandelbrot.viewHitsRandomColour(theMandelbrot.returnEscapeArray());
				
				// show image in the view
				theView.showMandelbrotImage(colourMandelbrot);
			}
		}
	}
}
