package csp1150.assignment1.view;

// import action listener
import java.awt.event.*;

// import swing components
import javax.swing.*;
import javax.swing.border.*;

/**
 * This class ties all the view classes together to generate the view.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.1.0
 * @since 20141011
 */
@SuppressWarnings("serial")
public class CalculatorView extends JFrame {
	
	// declare gridsize, will get from model
	private int gridSize;
	
	// declare the frame
	private CalculatorFrame theFrame;
	
	// declare the left panel
	private PanelGridLayout panelLeft;
	
	// and the calculator containers
	private PanelGridBagLayout panelAnnulusCalc;
	private PanelGridBagLayout panelAnnulusBorder;
	private PanelGridBagLayout panelMandelbrotCalc;
	private PanelGridBagLayout panelMandelbrotBorder;
	
	// declare the right panel
	private PanelGridLayout panelRight;
	
	// and the image containers
	private PanelGridLayout panelAnnulusImageContainer;
	private PanelGridLayout panelMandelbrotImageContainer;
	private HitViewerGreyscale panelAnnulusImage;
	private HitViewerColour panelMandelbrotImage;
	
	// declare annulus calculator labels
	private CalculatorLabel labelAnnulusCalcInstructions;
	private CalculatorLabel labelAnnulusOutRadius;
	private CalculatorLabel labelAnnulusInRadius;
	private CalculatorLabel labelAnnulusApproxTitle;
	private CalculatorLabel labelAnnulusApproxOutput;
	private CalculatorLabel labelAnnulusMonteTitle;
	private CalculatorLabel labelAnnulusMonteOutput;
	private CalculatorLabel labelAnnulusZoom;
	
	// declare mandelbrot calculator labels
	private CalculatorLabel labelMandelbrotCalcInstructions;
	private CalculatorLabel labelMandelbrotMonteTitle;
	private CalculatorLabel labelMandelbrotMonteOutput;
	private CalculatorLabel labelMandelbrotZoom;
	
	// declare annulus calculator user controls
	private CalculatorTextField textFieldAnnulusOutRadius;
	private CalculatorTextField textFieldAnnulusInRadius;
	private CalculatorButton buttonAnnulusCalculate;
	private CalculatorButtonCustom buttonAnnulusZoomIn;
	private CalculatorButton buttonAnnulusResetImage;
	private CalculatorButton buttonAnnulusSave;
	
	// declare mandelbrot radio buttons
	private CalculatorRadioButton radioMandelbrotCalculate;
	private CalculatorRadioButton radioMandelbrotViewImage;
	
	// declare and create a group for the radio buttons
	private final ButtonGroup GROUP_MANDELBROT_RADIOS = new ButtonGroup();
	
	// declare other mandelbrot calculator user controls
	private CalculatorButtonCustom buttonMandelbrotOK;
	private CalculatorCheckBox checkBoxMandelbrotRandomColour;
	private CalculatorButtonCustom buttonMandelbrotZoomIn;
	private CalculatorButton buttonMandelbrotResetImage;
	private CalculatorButton buttonMandelbrotSave;
	
	// declare boolean
	private boolean mandelbrotColourImageExists = false;
	
	/**
	 * The CalculatorView constructor.
	 * Set the gridsize at construction,
	 * to be used by the hitviewers.
	 * 
	 * @param int gridSize - The model's gridsize.
	 */
	public CalculatorView(int gridSize) {
		
		// set the gridsize
		this.gridSize = gridSize;
		
		// create the frame and panels
		initFrame();
		
		// create the labels
		initLabels();
		
		// create the user input controls
		initControls();
		
		// set frame visible AFTER everything is added
		theFrame.setVisible(true);
	}
	
	/**
	 * This method initializes the frames and panels of the view.
	 * 
	 * @param args unused
	 */
	private final void initFrame() {
		
		// create frame
		theFrame = new CalculatorFrame();
		
		// create panelLeft and add to the frame
		theFrame.getContentPane().add(panelLeft = new PanelGridLayout(2, 1, 20, 5));
		
		// set panelLeft layout
		panelLeft.setLayout(panelLeft.theGridLayout);
		
		// create panelRight and add to the frame
		theFrame.getContentPane().add(panelRight = new PanelGridLayout(2, 1, 20, 5));
		
		// set panelRight layout
		panelRight.setLayout(panelRight.theGridLayout);
		
		// create panelAnnulusCalc container and add to panelLeft
		panelLeft.add(panelAnnulusCalc = new PanelGridBagLayout());
		
		// set panelAnnulusCalc layout
		panelAnnulusCalc.setLayout(panelAnnulusCalc.gbl_panel);

		// create panelAnnulusBorder (use overloading constructor) and add to panelAnnulusCalc
		panelAnnulusCalc.add(panelAnnulusBorder = new PanelGridBagLayout(20, 20, 10, 0, 0, 0), panelAnnulusBorder.gbc_panel);
		
		// add titled border to panelAnnulusBorder
		addBorder(panelAnnulusBorder, "Annulus Calculator");
		
		// set panelAnnulusBorder layout
		panelAnnulusBorder.setLayout(panelAnnulusBorder.gbl_panel);
		
		// add panelMandelbrotCalc to panelLeft
		panelLeft.add(panelMandelbrotCalc = new PanelGridBagLayout());
		
		// set panelMandelbrotCalc layout
		panelMandelbrotCalc.setLayout(panelMandelbrotCalc.gbl_panel);
		
		// create panelMandelbrotBorder (use overloading constructor) and add to panelMandelbrotCalc
		panelMandelbrotCalc.add(panelMandelbrotBorder = new PanelGridBagLayout(10, 20, 10, 0, 0, 0), panelMandelbrotBorder.gbc_panel);
		
		// add titled border to panelMandelbrotBorder
		addBorder(panelMandelbrotBorder, "Mandelbrot Calculator");
		
		// set panelMandelbrotBorder layout
		panelMandelbrotBorder.setLayout(panelMandelbrotBorder.gbl_panel);
		
		// create panelAnnulusImageContaianer and add to panelRight
		panelRight.add(panelAnnulusImageContainer = new PanelGridLayout(0, 1, 0, 0));
		
		// create panelMandelbrotImageContainer and add to panelRight
		panelRight.add(panelMandelbrotImageContainer = new PanelGridLayout(0, 1, 0, 0));
		
		// create panelAnnulusImage and add to panelAnnulusImageContainer
		panelAnnulusImageContainer.add(panelAnnulusImage = new HitViewerGreyscale(gridSize, gridSize, 0, 1, 0, 0));
		
		// create panelMandelbrotImage container and add to panelMandelbrotImageContainer
		panelMandelbrotImageContainer.add(panelMandelbrotImage = new HitViewerColour(gridSize, gridSize, 0, 1, 0, 0));
	}
	
	/**
	 * This method initializes the labels of the view.
	 * 
	 * @param args unused
	 */
	private final void initLabels() {
		
		/*
		 * Add annulus calculator labels to the container panel
		 */
		
		// add instructions
		panelAnnulusBorder.add(labelAnnulusCalcInstructions = new CalculatorLabel("Enter the outer and inner radius.", "west", 8, 0, 40, 5, 5, 0, 1), labelAnnulusCalcInstructions.gbc_label);
		
		// add titles for input textFields
		panelAnnulusBorder.add(labelAnnulusOutRadius = new CalculatorLabel("Outer radius:", "west", 1, 0, 40, 5, 5, 0, 3), labelAnnulusOutRadius.gbc_label);
		panelAnnulusBorder.add(labelAnnulusInRadius = new CalculatorLabel("Inner radius:", "west", 1, 0, 40, 5, 5, 0, 4), labelAnnulusInRadius.gbc_label);
		
		// add titles for output
		panelAnnulusBorder.add(labelAnnulusApproxTitle = new CalculatorLabel("Approximate area:", "west", 2, 0, 40, 5, 5, 0, 6), labelAnnulusApproxTitle.gbc_label);
		panelAnnulusBorder.add(labelAnnulusMonteTitle = new CalculatorLabel("Monte Carlo estimate:", "west", 2, 0, 40, 5, 5, 0, 8), labelAnnulusMonteTitle.gbc_label);
		
		// add the labels that will show the output
		panelAnnulusBorder.add(labelAnnulusApproxOutput = new CalculatorLabel("---", "none", 5, 0, 0, 5, 0, 0, 7), labelAnnulusApproxOutput.gbc_label);
		panelAnnulusBorder.add(labelAnnulusMonteOutput = new CalculatorLabel("---", "none", 5, 0, 0, 5, 0, 0, 9), labelAnnulusMonteOutput.gbc_label);
		
		// add zoom instructions
		panelAnnulusBorder.add(labelAnnulusZoom = new CalculatorLabel("Left click and drag on image to set zoom area", "west", 5, 0, 40, 5, 0, 0, 10), labelAnnulusZoom.gbc_label);
		
		/*
		 * Add mandelbrot calculator labels to the container panel
		 */
		
		// add instructions
		panelMandelbrotBorder.add(labelMandelbrotCalcInstructions = new CalculatorLabel("Calculate area first, then view image.", "west", 8, 0, 40, 5, 5, 0, 1), labelMandelbrotCalcInstructions.gbc_label);
		
		// add title for output
		panelMandelbrotBorder.add(labelMandelbrotMonteTitle = new CalculatorLabel("Monte Carlo estimate:", "west", 3, 0, 40, 5, 5, 0, 8), labelMandelbrotMonteTitle.gbc_label);
		
		// add the label that will show the output
		panelMandelbrotBorder.add(labelMandelbrotMonteOutput = new CalculatorLabel("---", "none", 5, 0, 0, 5, 0, 0, 9), labelMandelbrotMonteOutput.gbc_label);
		
		// add zoom instructions
		panelMandelbrotBorder.add(labelMandelbrotZoom = new CalculatorLabel("Left click and drag on image to set zoom area", "west", 5, 0, 40, 5, 0, 0, 10), labelMandelbrotZoom.gbc_label);
		
	}
	
	/**
	 * This method initializes the user input controls for the view.
	 * 
	 * @param args unused
	 */
	private final void initControls() {
		
		/*
		 * Add annulus calculator controls to container panel
		 */
		
		// add input textFields to the panel
		panelAnnulusBorder.add(textFieldAnnulusOutRadius = new CalculatorTextField(10, 1, 3), textFieldAnnulusOutRadius.gbc_textField);
		panelAnnulusBorder.add(textFieldAnnulusInRadius = new CalculatorTextField(10, 1, 4), textFieldAnnulusInRadius.gbc_textField);
		
		// add buttons to the panel
		panelAnnulusBorder.add(buttonAnnulusCalculate = new CalculatorButton("Calculate", 1, 5), buttonAnnulusCalculate.gbc_button);
		panelAnnulusBorder.add(buttonAnnulusZoomIn = new CalculatorButtonCustom("Zoom In", 0, 12), buttonAnnulusZoomIn.gbc_zoomButton);
		panelAnnulusBorder.add(buttonAnnulusResetImage = new CalculatorButton("Reset Image", 1, 12), buttonAnnulusResetImage.gbc_button);
		panelAnnulusBorder.add(buttonAnnulusSave = new CalculatorButton("Save Image", 2, 12), buttonAnnulusSave.gbc_button);
		
		/*
		 * Add mandelbrot calculator controls to container panel
		 */
		
		// add radioButtons to the panel
		panelMandelbrotBorder.add(radioMandelbrotCalculate = new CalculatorRadioButton("Calculate area", 0, 3), radioMandelbrotCalculate.gbc_radioButton);
		panelMandelbrotBorder.add(radioMandelbrotViewImage = new CalculatorRadioButton("View image", 0, 4), radioMandelbrotViewImage.gbc_radioButton);
		
		// add radioButtons to a group, so only one can be selected at a time
		GROUP_MANDELBROT_RADIOS.add(radioMandelbrotCalculate);
		GROUP_MANDELBROT_RADIOS.add(radioMandelbrotViewImage);
		
		// set calculate radio to be default selection
		radioMandelbrotCalculate.setSelected(true);
		
		// add checkBox to the panel
		panelMandelbrotBorder.add(checkBoxMandelbrotRandomColour = new CalculatorCheckBox("Random colour", 0, 5), checkBoxMandelbrotRandomColour.gbc_checkBox);
		
		// add buttons to the panel
		panelMandelbrotBorder.add(buttonMandelbrotOK = new CalculatorButtonCustom("OK", 0, 6), buttonMandelbrotOK.gbc_zoomButton);
		panelMandelbrotBorder.add(buttonMandelbrotZoomIn = new CalculatorButtonCustom("Zoom In", 0, 12), buttonMandelbrotZoomIn.gbc_zoomButton);
		panelMandelbrotBorder.add(buttonMandelbrotResetImage = new CalculatorButton("Reset Image", 1, 12), buttonMandelbrotResetImage.gbc_button);
		panelMandelbrotBorder.add(buttonMandelbrotSave = new CalculatorButton("Save Image", 2, 12), buttonMandelbrotSave.gbc_button);
	}
	
	/**
	 * This method refreshes the annulus image. Removes current image panels
	 * from the parent container, then creates a new image, passing 
	 * hits array as an argument along with gridlayout constraints.
	 * 
	 * @param double[][] hits - The hits array.
	 */
	public final void refreshAnnulusImage(double[][] hits) {
		
		// remove panel from parent container
		panelAnnulusImageContainer.remove(panelAnnulusImage);
		
		// create new image, pass gridsize, grid constraints and hits array as arguments
		panelAnnulusImageContainer.add(panelAnnulusImage = new HitViewerGreyscale(gridSize, gridSize, 0, 1, 0, 0, hits));
		
		// repaint the image panel
		panelAnnulusImage.revalidate();
		panelAnnulusImage.repaint();
	}
	
	/**
	 * This method refreshes the greyscale mandelbrot image. Removes current image panel
	 * from the parent container, then creates a new image, passing
	 * hits array as an argument along with gridlayout constraints.
	 * 
	 * @param double[][] hits - The hits array.
	 */
	public final void refreshMandelbrotImage(double[][] hits) {
		
		// remove panel from parent container
		panelMandelbrotImageContainer.remove(panelMandelbrotImage);
		
		// create new greyscale image, pass gridsize, grid constraints and hits array as arguments
		panelMandelbrotImageContainer.add(panelMandelbrotImage = new HitViewerColour(gridSize, gridSize, 0, 1, 0, 0, hits));
		
		// repaint the image panel
		panelMandelbrotImage.revalidate();
		panelMandelbrotImage.repaint();
	}
	
	/**
	 * Overloading refreshMandelbrotImage to accept escapeArray as argument.
	 * 
	 * This method refreshes the colour mandelbrot image. Removes current image panels
	 * from the parent container, then creates a new image, passing
	 * escapeArray as an argument along with gridlayout constraints.
	 * 
	 * @param double[][] escapeArray - The escapeArray.
	 */
	public final void refreshMandelbrotImage(int[][] escapeArray) {
		
		// remove panel from parent container
		panelMandelbrotImageContainer.remove(panelMandelbrotImage);
		
		// create new colour image, pass gridsize, grid constraints and escapeArray as arguments
		panelMandelbrotImageContainer.add(panelMandelbrotImage = new HitViewerColour(gridSize, gridSize, 0, 1, 0, 0, escapeArray));
		
		// repaint the image panel
		panelMandelbrotImage.revalidate();
		panelMandelbrotImage.repaint();
	}
	
	/**
	 * This method adds a titled, etched border to the panel.
	 * 
	 * @param JPanel thePanel - The panel which requires the border.
	 * @param String borderTitle - The title of the border.
	 */
	private final void addBorder(JPanel thePanel, String borderTitle) {
		
		thePanel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), borderTitle, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}
	
	/**
	 * This method returns user input for outer radius
	 * from the view, parse as double.
	 * 
	 * @param args unused
	 * @return double - Outer radius.
	 */
	public final double getAnnulusOutRadius() {
		
		return Double.parseDouble(textFieldAnnulusOutRadius.getText());
	}
	
	/**
	 * This method returns user input for inner radius
	 * from the view, parse as double.
	 * 
	 * @param args unused
	 * @return double - Inner radius.
	 */
	public final double getAnnulusInRadius() {
		
		return Double.parseDouble(textFieldAnnulusInRadius.getText());
	}
	
	/**
	 * This method returns the annulus approx area result
	 * from the view, parse as double.
	 * 
	 * @param args unused
	 * @return double - The calculated approximate area of the annulus.
	 */
	public final double getAnnulusAreaCalc() {
		
		return Double.parseDouble(labelAnnulusApproxOutput.getText());
	}
	
	/**
	 * This method sets the annulus approx area result to the view
	 * from the controller, parse as String.
	 * 
	 * @param double area - The calculated approximate area of the annulus.
	 */
	public final void setAnnulusAreaCalc(double area) {
		
		labelAnnulusApproxOutput.setText(Double.toString(area));
	}
	
	/**
	 * This method sets the annulus monte carlo result to the view
	 * from the controller, parse as String.
	 * 
	 * @param double area - The calculated monte carlo area of the annulus.
	 */
	public final void setAnnulusMonteCalc(double area) {
		
		labelAnnulusMonteOutput.setText(Double.toString(area));
	}
	
	/**
	 * This method sets the monte carlo result to the view
	 * from the controller, parse as String.
	 * 
	 * @param double area - The calculated monte carlo area of the mandelbrot.
	 */
	public final void setMandelbrotMonteCalc(double area) {
		
		labelMandelbrotMonteOutput.setText(Double.toString(area));
	}
	
	/**
	 * This method returns the annulus image.
	 * 
	 * @return HitViewerGreyscale panelAnnulusImage.
	 */
	public final HitViewerGreyscale getPanelAnnulusImage() {
		
		return panelAnnulusImage;
	}
	
	/**
	 * This method adds action listeners to the buttons.
	 * 
	 * @param ActionListener theListener.
	 */
	public final void addCalculatorListener(ActionListener theListener) {
		
		// add listener to annulus calculator buttons
		buttonAnnulusCalculate.addActionListener(theListener);
		buttonAnnulusZoomIn.addActionListener(theListener);
		buttonAnnulusResetImage.addActionListener(theListener);
		buttonAnnulusSave.addActionListener(theListener);
		
		// add listener to mandelbrot calculator buttons
		buttonMandelbrotOK.addActionListener(theListener);
		buttonMandelbrotZoomIn.addActionListener(theListener);
		buttonMandelbrotResetImage.addActionListener(theListener);
		buttonMandelbrotSave.addActionListener(theListener);
	}
	
	/**
	 * This method returns the annulus calculate button.
	 * 
	 * @return CalculatorButton buttonAnnulusCalculate.
	 */
	public final CalculatorButton getButtonAnnulusCalculate() {
		
		return buttonAnnulusCalculate;
	}
	
	/**
	 * This method returns the annulus zoom in button.
	 * 
	 * @return CalculatorButtonCustom buttonAnnulusZoomIn.
	 */
	public final CalculatorButtonCustom getButtonAnnulusZoomIn() {
		
		return buttonAnnulusZoomIn;
	}
	
	/**
	 * This method returns the annulus zoom reset button.
	 * 
	 * @return CalculatorButton buttonAnnulusZoomReset.
	 */
	public final CalculatorButton getButtonAnnulusZoomReset() {
		
		return buttonAnnulusResetImage;
	}
	
	/**
	 * This method returns the annulus save button.
	 * 
	 * @return CalculatorButton buttonAnnulusSave.
	 */
	public final CalculatorButton getButtonAnnulusSave() {
		
		return buttonAnnulusSave;
	}
	
	/**
	 * This method returns the mandelbrot OK button.
	 * 
	 * @return CalculatorButton buttonMandelbrotOK.
	 */
	public final CalculatorButton getButtonMandelbrotOK() {
		
		return buttonMandelbrotOK;
	}
	
	/**
	 * This method returns the mandelbrot calculate radio button.
	 * 
	 * @return CalculatorRadioButton radioMandelbrotCalculate.
	 */
	public final CalculatorRadioButton getRadioMandelbrotCalculate() {
		
		return radioMandelbrotCalculate;
	}
	
	/**
	 * This method returns the mandelbrot view image radio button.
	 * 
	 * @return CalculatorRadioButton radioMandelbrotViewImage.
	 */
	public final CalculatorRadioButton getRadioMandelbrotViewImage() {
		
		return radioMandelbrotViewImage;
	}
	
	/**
	 * This method returns the mandelbrot checkbox button.
	 * 
	 * @return CalculatorCheckBox checkBoxMandelbrotRandomColour.
	 */
	public final CalculatorCheckBox getCheckBoxMandelbrotRandomColour() {

		return checkBoxMandelbrotRandomColour;
	}
	
	/**
	 * This method returns the mandelbrot zoom in button.
	 * 
	 * @return CalculatorButtonCustom buttonAnnulusZoomIn.
	 */
	public final CalculatorButtonCustom getButtonMandelbrotZoomIn() {
		
		return buttonMandelbrotZoomIn;
	}
	
	/**
	 * This method returns the mandelbrot zoom reset button.
	 * 
	 * @return CalculatorButton buttonMandelbrotResetImage.
	 */
	public final CalculatorButton getButtonMandelbrotZoomReset() {
		
		return buttonMandelbrotResetImage;
	}
	
	/**
	 * This method returns the mandelbrot save button.
	 * 
	 * @return CalculatorButton buttonMandelbrotSave.
	 */
	public final CalculatorButton getButtonMandelbrotSave() {
		
		return buttonMandelbrotSave;
	}
	
	/**
	 * This method returns the annulus pixel zoom array.
	 * 
	 * @return double[] pixelZoom.
	 */
	public final double[] getPixelZoomAnnulus() {
		
			return panelAnnulusImage.getPixelZoom();
	}
	
	/**
	 * This method returns the mandelbrot pixel zoom array.
	 * 
	 * @return double[] pixelZoom.
	 */
	public final double[] getPixelZoomMandelbrot() {
		
		return panelMandelbrotImage.getPixelZoom();
	}
	
	/**
	 * This method returns boolean mandelbrotColourImageExists;
	 * 
	 * @return boolean mandelbrotColourImageExists.
	 */
	public final boolean getMandelbrotColourImageExists() {
	
		return mandelbrotColourImageExists;
	}
	
	/**
	 * This method sets mandelbrotColourImageExists field.
	 * 
	 * @param boolean trueOrFalse.
	 */
	public final void setMandelbrotColourImageExists(boolean trueOrFalse) {
		
		mandelbrotColourImageExists = trueOrFalse;
	}
	
	/**
	 * This method displays an error message for incorrect user input.
	 * Message displayed on JOptionPane window.
	 * 
	 * @param String errorMessage - The error message.
	 */
	public final void displayErrorMessage(String errorMessage) {
		
		JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
