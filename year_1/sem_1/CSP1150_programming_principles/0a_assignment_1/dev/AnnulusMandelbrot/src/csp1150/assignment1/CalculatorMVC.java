package csp1150.assignment1;

// import the project
import csp1150.assignment1.model.*;
import csp1150.assignment1.controller.*;
import csp1150.assignment1.view.*;

/**
 * This class contains the main method where the program is executed,
 * and creates the model, view and controller objects.
 * 
 * The program calculates the area of an Annulus and Mandelbrot, and can display an image of either shape.
 * The user can left click and drag over the images to set a zoom area, and then zoom into the image.
 * The user can also reset the image if they wish, and revert back to original zoom and colour.
 * The user can also save the images in any state as .png.
 * 
 * The area of an Annulus is calculated by accepting user input for outer and inner radius,
 * and performs two calculations: approximate area and monte carlo estimation.
 * 
 * The area of the Mandelbrot is calculated with monte carlo estimation. No user input is required,
 * however the user may choose to view the image with random colours.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.3.0
 * @since 20141022
 */
public class CalculatorMVC {
	
	public static void main(String[] args) {
		
		// create the models, experimenting with polymorphism
		ShapeModel theAnnulusModel = new AnnulusModel();
		ShapeModel theMandelbrotModel = new MandelbrotModel();
		
		// create the view
		CalculatorView theView = new CalculatorView(theAnnulusModel.getGridSize());
		
		// create the controller
		CalculatorController theController = new CalculatorController(theAnnulusModel, theMandelbrotModel, theView);
	}
}
