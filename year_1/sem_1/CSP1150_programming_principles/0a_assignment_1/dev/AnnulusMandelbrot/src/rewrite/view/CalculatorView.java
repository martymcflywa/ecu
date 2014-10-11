package rewrite.view;

// import action listener
import java.awt.event.*;

// import swing components
import javax.swing.*;
import javax.swing.border.*;

/**
 * This class ties all the view classes together to generate the view.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.0.0
 * @since 20141004
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
	private CalculatorButton buttonAnnulusZoomReset;
	private CalculatorButton buttonAnnulusSave;
	
	// declare mandelbrot radio buttons
	private CalculatorRadioButton radioMandelbrotCalculate;
	private CalculatorRadioButton radioMandelbrotViewImage;
	
	// declare the group for the radio buttons
	private final ButtonGroup GROUP_MANDELBROT_RADIOS = new ButtonGroup();
	
	// declare other mandelbrot calculator user controls
	private CalculatorButtonCustom buttonMandelbrotOK;
	private CalculatorCheckBox checkBoxMandelbrotRandomColour;
	private CalculatorButtonCustom buttonMandelbrotZoomIn;
	private CalculatorButton buttonMandelbrotZoomReset;
	private CalculatorButton buttonMandelbrotSave;
	
	/**
	 * The CalculatorView constructor.
	 * Set the gridsize at construction,
	 * to be used by the hitviewers.
	 * 
	 * @param int gridSize - The model's gridsize.
	 */
	public CalculatorView(int gridSize) {
		
		//
		this.gridSize = gridSize;
		
		// create the frame and panels
		initFrame();
		
		// create the labels
		initLabels();
		
		// create the user input controls
		initControls();
		
		// set frame visible AFTER everything is added
		this.theFrame.setVisible(true);
	}
	
	/**
	 * This method initializes the frames and panels of the view.
	 * 
	 * @param args unused
	 */
	private final void initFrame() {
		
		// create frame
		this.theFrame = new CalculatorFrame();
		
		// create panelLeft and add to the frame
		this.theFrame.getContentPane().add(this.panelLeft = new PanelGridLayout(2, 1, 20, 5));
		
		// set panelLeft layout
		this.panelLeft.setLayout(this.panelLeft.theGridLayout);
		
		// create panelRight and add to the frame
		this.theFrame.getContentPane().add(this.panelRight = new PanelGridLayout(2, 1, 20, 5));
		
		// set panelRight layout
		this.panelRight.setLayout(this.panelRight.theGridLayout);
		
		// create panelAnnulusCalc container and add to panelLeft
		this.panelLeft.add(this.panelAnnulusCalc = new PanelGridBagLayout());
		
		// set panelAnnulusCalc layout
		this.panelAnnulusCalc.setLayout(this.panelAnnulusCalc.gbl_panel);

		// create panelAnnulusBorder (use overloading constructor) and add to panelAnnulusCalc
		this.panelAnnulusCalc.add(this.panelAnnulusBorder = new PanelGridBagLayout(20, 20, 10, 0, 0, 0), this.panelAnnulusBorder.gbc_panel);
		
		// add titled border to panelAnnulusBorder
		addBorder(this.panelAnnulusBorder, "Annulus Calculator");
		
		// set panelAnnulusBorder layout
		this.panelAnnulusBorder.setLayout(this.panelAnnulusBorder.gbl_panel);
		
		// add panelMandelbrotCalc to panelLeft
		this.panelLeft.add(this.panelMandelbrotCalc = new PanelGridBagLayout());
		
		// set panelMandelbrotCalc layout
		this.panelMandelbrotCalc.setLayout(this.panelMandelbrotCalc.gbl_panel);
		
		// create panelMandelbrotBorder (use overloading constructor) and add to panelMandelbrotCalc
		this.panelMandelbrotCalc.add(this.panelMandelbrotBorder = new PanelGridBagLayout(10, 20, 10, 0, 0, 0), this.panelMandelbrotBorder.gbc_panel);
		
		// add titled border to panelMandelbrotBorder
		addBorder(this.panelMandelbrotBorder, "Mandelbrot Calculator");
		
		// set panelMandelbrotBorder layout
		this.panelMandelbrotBorder.setLayout(this.panelMandelbrotBorder.gbl_panel);
		
		// create panelAnnulusImage container and add to panelRight
		// **NEED TO USE 444 as GRIDSIZE** fits exactly in the panel
		this.panelRight.add(this.panelAnnulusImage = new HitViewerGreyscale(this.gridSize, this.gridSize, 0, 1, 0, 0));
		
		// create panelMandelbrotImage container and add to panelRight
		this.panelRight.add(this.panelMandelbrotImage = new HitViewerColour(this.gridSize, this.gridSize, 0, 1, 0, 0));
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
		this.panelAnnulusBorder.add(this.labelAnnulusCalcInstructions = new CalculatorLabel("Enter the outer and inner radius.", "west", 8, 0, 40, 5, 5, 0, 1), this.labelAnnulusCalcInstructions.gbc_label);
		
		// add titles for input textFields
		this.panelAnnulusBorder.add(this.labelAnnulusOutRadius = new CalculatorLabel("Outer radius:", "west", 1, 0, 40, 5, 5, 0, 3), this.labelAnnulusOutRadius.gbc_label);
		this.panelAnnulusBorder.add(this.labelAnnulusInRadius = new CalculatorLabel("Inner radius:", "west", 1, 0, 40, 5, 5, 0, 4), this.labelAnnulusInRadius.gbc_label);
		
		// add titles for output
		this.panelAnnulusBorder.add(this.labelAnnulusApproxTitle = new CalculatorLabel("Approximate area:", "west", 2, 0, 40, 5, 5, 0, 6), this.labelAnnulusApproxTitle.gbc_label);
		this.panelAnnulusBorder.add(this.labelAnnulusMonteTitle = new CalculatorLabel("Monte Carlo estimate:", "west", 2, 0, 40, 5, 5, 0, 8), this.labelAnnulusMonteTitle.gbc_label);
		
		// add the labels that will show the output
		this.panelAnnulusBorder.add(this.labelAnnulusApproxOutput = new CalculatorLabel("---", "none", 5, 0, 0, 5, 0, 0, 7), this.labelAnnulusApproxOutput.gbc_label);
		this.panelAnnulusBorder.add(this.labelAnnulusMonteOutput = new CalculatorLabel("---", "none", 5, 0, 0, 5, 0, 0, 9), this.labelAnnulusMonteOutput.gbc_label);
		
		// add zoom instructions
		this.panelAnnulusBorder.add(this.labelAnnulusZoom = new CalculatorLabel("Left click and drag on image to set zoom area", "west", 5, 0, 40, 5, 0, 0, 10), this.labelAnnulusZoom.gbc_label);
		
		/*
		 * Add mandelbrot calculator labels to the container panel
		 */
		
		// add instructions
		this.panelMandelbrotBorder.add(this.labelMandelbrotCalcInstructions = new CalculatorLabel("Select calculate or view image.", "west", 8, 0, 40, 5, 5, 0, 1), this.labelMandelbrotCalcInstructions.gbc_label);
		
		// add title for output
		this.panelMandelbrotBorder.add(this.labelMandelbrotMonteTitle = new CalculatorLabel("Monte Carlo estimate:", "west", 3, 0, 40, 5, 5, 0, 8), this.labelMandelbrotMonteTitle.gbc_label);
		
		// add the label that will show the output
		this.panelMandelbrotBorder.add(this.labelMandelbrotMonteOutput = new CalculatorLabel("---", "none", 5, 0, 0, 5, 0, 0, 9), this.labelMandelbrotMonteOutput.gbc_label);
		
		// add zoom instructions
		this.panelMandelbrotBorder.add(this.labelMandelbrotZoom = new CalculatorLabel("Left click and drag on image to set zoom area", "west", 5, 0, 40, 5, 0, 0, 10), this.labelMandelbrotZoom.gbc_label);
		
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
		this.panelAnnulusBorder.add(this.textFieldAnnulusOutRadius = new CalculatorTextField(10, 1, 3), this.textFieldAnnulusOutRadius.gbc_textField);
		this.panelAnnulusBorder.add(this.textFieldAnnulusInRadius = new CalculatorTextField(10, 1, 4), this.textFieldAnnulusInRadius.gbc_textField);
		
		// add buttons to the panel
		this.panelAnnulusBorder.add(this.buttonAnnulusCalculate = new CalculatorButton("Calculate", 1, 5), this.buttonAnnulusCalculate.gbc_button);
		this.panelAnnulusBorder.add(this.buttonAnnulusZoomIn = new CalculatorButtonCustom("Zoom In", 0, 12), this.buttonAnnulusZoomIn.gbc_button);
		this.panelAnnulusBorder.add(this.buttonAnnulusZoomReset = new CalculatorButton("Reset Zoom", 1, 12), this.buttonAnnulusZoomReset.gbc_button);
		this.panelAnnulusBorder.add(this.buttonAnnulusSave = new CalculatorButton("Save Image", 2, 12), this.buttonAnnulusSave.gbc_button);
		
		/*
		 * Add mandelbrot calculator controls to container panel
		 */
		
		// add radioButtons to the panel
		this.panelMandelbrotBorder.add(this.radioMandelbrotCalculate = new CalculatorRadioButton("Calculate area", 0, 3), this.radioMandelbrotCalculate.gbc_radioButton);
		this.panelMandelbrotBorder.add(this.radioMandelbrotViewImage = new CalculatorRadioButton("View image", 0, 4), this.radioMandelbrotViewImage.gbc_radioButton);
		
		// add radioButtons to a group, so only one can be selected at a time
		this.GROUP_MANDELBROT_RADIOS.add(this.radioMandelbrotCalculate);
		this.GROUP_MANDELBROT_RADIOS.add(this.radioMandelbrotViewImage);
		
		// set calculate radio to be default selection
		this.radioMandelbrotCalculate.setSelected(true);
		
		// add checkBox to the panel
		this.panelMandelbrotBorder.add(this.checkBoxMandelbrotRandomColour = new CalculatorCheckBox("Random colour", 0, 5), this.checkBoxMandelbrotRandomColour.gbc_checkBox);
		
		// add buttons to the panel
		this.panelMandelbrotBorder.add(this.buttonMandelbrotOK = new CalculatorButtonCustom("OK", 0, 6), this.buttonMandelbrotOK.gbc_button);
		this.panelMandelbrotBorder.add(this.buttonMandelbrotZoomIn = new CalculatorButtonCustom("Zoom In", 0, 12), this.buttonMandelbrotZoomIn.gbc_button);
		this.panelMandelbrotBorder.add(this.buttonMandelbrotZoomReset = new CalculatorButton("Reset Zoom", 1, 12), this.buttonMandelbrotZoomReset.gbc_button);
		this.panelMandelbrotBorder.add(this.buttonMandelbrotSave = new CalculatorButton("Save Image", 2, 12), this.buttonMandelbrotSave.gbc_button);
	}
	
	/**
	 * This method refreshes the annulus image. Removes current image panels
	 * from the parent container, then creates a new image, passing 
	 * hits array as an argument along with gridlayout constraints.
	 * 
	 * @param double[][] hits
	 */
	public final void refreshAnnulusImage(double[][] hits) {
		
		// remove both image panels from parent container, otherwise image will be added below,
		// since the mandelbrot image will shift up, and take the space of the annulus image
		// ** TODO: create separate containers so only one needs to be removed
		this.panelRight.remove(this.panelAnnulusImage);
		this.panelRight.remove(this.panelMandelbrotImage);
		
		// create new image, pass gridsize, grid constraints and hits array as arguments
		this.panelRight.add(this.panelAnnulusImage = new HitViewerGreyscale(this.gridSize, this.gridSize, 0, 1, 0, 0, hits));
	}
	
	/**
	 * This method refreshes the greyscale mandelbrot image. Removes current image panels
	 * from the parent container, then creates a new image, passing
	 * hits array as an argument along with gridlayout constraints.
	 * 
	 * @param double[][] hits
	 */
	public final void refreshMandelbrotImage(double[][] hits) {
		
		this.panelRight.remove(this.panelMandelbrotImage);
		this.panelRight.add(this.panelMandelbrotImage = new HitViewerColour(this.gridSize, this.gridSize, 0, 1, 0, 0, hits));
	}
	
	/**
	 * This method refreshes the colour mandelbrot image. Removes current image panels
	 * from the parent container, then creates a new image, passing
	 * escapeArrau as an argument along with gridlayout constraints.
	 * 
	 * @param double[][] escapeArray
	 */
	public final void refreshMandelbrotImage(int[][] escapeArray) {
		
		this.panelRight.remove(this.panelMandelbrotImage);
		this.panelRight.add(this.panelMandelbrotImage = new HitViewerColour(this.gridSize, this.gridSize, 0, 1, 0, 0, escapeArray));
	}
	
	/**
	 * This method adds a titled, etched border to the panel.
	 * 
	 * @param JPanel thePanel - The panel which requires the border
	 * @param String borderTitle - The title of the border
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
	 * @return double - Area of annulus.
	 */
	public final double getAnnulusAreaCalc() {
		
		return Double.parseDouble(labelAnnulusApproxOutput.getText());
	}
	
	/**
	 * This method sets the annulus approx area result to the view
	 * from the controller, parse as String.
	 * 
	 * @param double area.
	 */
	public final void setAnnulusAreaCalc(double area) {
		
		this.labelAnnulusApproxOutput.setText(Double.toString(area));
	}
	
	/**
	 * This method sets the annulus monte carlo result to the view
	 * from the controller, parse as String.
	 * 
	 * @param double area.
	 */
	public final void setAnnulusMonteCalc(double area) {
		
		this.labelAnnulusMonteOutput.setText(Double.toString(area));
	}
	
	/**
	 * This method sets the monte carlo result to the view
	 * from the controller, parse as String.
	 * 
	 * @param double area.
	 */
	public final void setMandelbrotMonteCalc(double area) {
		
		this.labelMandelbrotMonteOutput.setText(Double.toString(area));
	}
	
	/**
	 * This method returns the annulus image.
	 * 
	 * @return HitViewerGreyscale panelAnnulusImage.
	 */
	public HitViewerGreyscale getPanelAnnulusImage() {
		
		return this.panelAnnulusImage;
	}
	
	/**
	 * This method adds action listeners to the buttons.
	 * 
	 * @param ActionListener theListener
	 */
	public final void addCalculatorListener(ActionListener theListener) {
		
		// add listener to annulus calculator buttons
		this.buttonAnnulusCalculate.addActionListener(theListener);
		this.buttonAnnulusZoomIn.addActionListener(theListener);
		this.buttonAnnulusZoomReset.addActionListener(theListener);
		this.buttonAnnulusSave.addActionListener(theListener);
		
		// add listener to mandelbrot calculator buttons
		this.buttonMandelbrotOK.addActionListener(theListener);
		this.buttonMandelbrotZoomIn.addActionListener(theListener);
		this.buttonMandelbrotZoomReset.addActionListener(theListener);
		this.buttonMandelbrotSave.addActionListener(theListener);
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
	 * This method displays an error message for incorrect user input.
	 * Message displayed on JOptionPane window.
	 * 
	 * @param String errorMessage - The error message.
	 */
	public final void displayErrorMessage(String errorMessage) {
		
		JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
