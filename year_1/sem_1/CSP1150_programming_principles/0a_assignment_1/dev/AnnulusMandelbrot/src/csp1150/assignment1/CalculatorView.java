package csp1150.assignment1;

// importing action listener, java swing, and layout classes
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.*;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.border.TitledBorder;

import java.awt.Insets;


// import greyscale view
import view.*;

/**
 * This class defines the calculator view
 * and extends JFrame. Everything relating
 * to the GUI is defined here.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 3.2.0
 * @since 20140929
 */

@SuppressWarnings("serial")
public class CalculatorView extends JFrame {
	
	private static boolean imageExists = false;
	
	/**
	 * Defining labels, fields and buttons.
	 */
	
	// label: annulus calculator instructions
	private JLabel labelAnnulusInstructions;
	
	// label: outer radius user input title
	private JLabel labelOutRadius;
	
	// text field: outer radius user input field
	private JTextField fieldOutRadius = new JTextField();
	
	// label: inner radius user input title
	private JLabel labelInRadius;
	
	// text field: inner radius user input field
	private JTextField fieldInRadius = new JTextField();
	
	// button: calculate
	private JButton calcButton = new JButton("Calculate");
	
	// label: approx area result title
	private JLabel labelApproxArea;
	
	// label: approx area result output
	private JLabel approxAreaResult = new JLabel("---");
	
	// label: monte area result title
	private JLabel labelMonteArea;
	
	// label: monte area result output
	private JLabel monteAreaResult = new JLabel("---");
		
	// label: greyscale annulus displays as label
	private JLabel imageAnnulus;
	
	/**
	 * Defining left side panels.
	 */
	
	// panel: left side container
	private JPanel panelParentLeft;
	
	// panel: annulus calculator container
	private JPanel panelAnnulusCalculator;
	
	// panel: annulus calculator border
	private JPanel borderAnnulusCalculator;
	
	/**
	 * Defining right side panels.
	 */
	
	// panel: right side container
	private JPanel panelParentRight = new JPanel();
	
	// panel: annulus graphic container
	private JPanel panelAnnulusGraphic;
	
	// reference to GreyscaleHitViewerPanel for greyscale annulus
	private GreyscaleHitViewerPanel greyScaleAnnulus;
	
	/**
	 * Defining GridBagLayout and GridBagConstraints
	 */
	
	// gbc: annulus calculator instructions
	private GridBagConstraints gbc_labelAnnulusInstructions;
	
	// gbc: outer radius user input title
	private GridBagConstraints gbc_labelOutRadius;
	
	// gbc: outer radius user input field
	private GridBagConstraints gbc_fieldOutRadius;
	
	// gbc: inner radius user input title
	private GridBagConstraints gbc_labelInRadius;
	
	// gbc: inner radius user input field
	private GridBagConstraints gbc_fieldInRadius;
	
	// gbc: calculate button
	private GridBagConstraints gbc_calcButton;
	
	// gbc: approx area result title
	private GridBagConstraints gbc_labelApproxArea;
	
	// gbc: approx area result output
	private GridBagConstraints gbc_approxAreaResult;
	
	// gbc: monte area result title
	private GridBagConstraints gbc_labelMonteArea;
	
	// gbc: monte area result output
	private GridBagConstraints gbc_monteAreaResult;
	
	// gbc: left side container
	private GridBagConstraints gbc_panelParentLeft;
	
	// gbl: left side container
	private GridBagLayout gbl_panelParentLeft;
	
	// gbc: annulus calculator
	private GridBagConstraints gbc_panelAnnulusCalculator;
	
	// gbl: annulus calculator
	private GridBagLayout gbl_panelAnnulusCalculator;
	
	// gbc: annulus calculator border
	private GridBagConstraints gbc_borderAnnulus;
	
	// gbl: annulus calculator border
	private GridBagLayout gbl_borderAnnulus;
	
	// gbc: right side container
	private GridBagConstraints gbc_panelParentRight;
	
	// gbc: annulus greyscale container
	private GridBagConstraints gbc_panelAnnulusGraphic;
	
	// gbl: annulus greyscale container
	private GridBagLayout gbl_panelAnnulusGraphic;
	
	// gbc: annulus greyscale image
	private GridBagConstraints gbc_greyScaleAnnulus;
	
	/**
	 * The view constructor.
	 * Calls initialize to create the frame and set the layout.
	 * Then createLeftElement and createRightElement
	 * to create the panels inside the frame.
	 */
	CalculatorView(GreyscaleHitViewerPanel greyScaleAnnulus) {
		this.greyScaleAnnulus = greyScaleAnnulus;
		initialize();
		createLeftElement();
		createRightElement();
	}
	
	/**
	 * Initialize the contents of the frame.
	 * Using gridBagLayout to create layout.
	 */
	private void initialize() {
		
		
		/**
		 * Define JFrame parameters.
		 */
		setBounds(100, 100, 800, 900);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setLocationRelativeTo(null);
		setTitle("Annulus & Mandelbrot Calculator: Martin Ponce");
		
		// create GridBagLayout object
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		/**
		 * Define gridBagLayout parameters.
		 */
		gridBagLayout.columnWidths = new int[]{300, 0, 0};
		gridBagLayout.rowHeights = new int[]{434, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		
		// set frame's layout manager to gridBagLayout
		getContentPane().setLayout(gridBagLayout);
	}
	
	/**
	 * This method creates the layout for greyscale annulus image,
	 * and adds it to the frame.
	 * @param greyScaleAnnulus
	 */
	public void showGreyScaleAnnulus(GreyscaleHitViewerPanel greyScaleAnnulus) {
		
		// setting up the parent panel for greyscale annulus image
		panelAnnulusGraphic = new JPanel();
		
		// create gridbag constraints for parent panel
		gbc_panelAnnulusGraphic = new GridBagConstraints();
		
		// define gridbag constraints parameters for parent panel
		gbc_panelAnnulusGraphic.insets = new Insets(0, 0, 5, 0);
		gbc_panelAnnulusGraphic.fill = GridBagConstraints.BOTH;
		gbc_panelAnnulusGraphic.gridx = 0;
		gbc_panelAnnulusGraphic.gridy = 0;
		
		// add parent panel and gridbag constraints to container panel
		panelParentRight.add(panelAnnulusGraphic, gbc_panelAnnulusGraphic);
		
		// create gridbag layout
		gbl_panelAnnulusGraphic = new GridBagLayout();
		gbl_panelAnnulusGraphic.columnWidths = new int[]{0};
		gbl_panelAnnulusGraphic.rowHeights = new int[]{0};
		gbl_panelAnnulusGraphic.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelAnnulusGraphic.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		
		// set layout to parent panel for greyscale annulus image
		panelAnnulusGraphic.setLayout(gbl_panelAnnulusGraphic);
		
		// create gridbag constraints
		gbc_greyScaleAnnulus = new GridBagConstraints();
		gbc_greyScaleAnnulus.gridx = 0;
		gbc_greyScaleAnnulus.gridy = 0;

		// if image exists,
		if(imageExists) {
			
			/* 
			 * remove image and panel from parent panel,
			 * stops image from showing up multiple times
			 * whenever calcButton is pressed
			 */
			getContentPane().remove(imageAnnulus);
			panelParentRight.remove(panelAnnulusGraphic);
		}
		
		// get the image
		repaint();
		BufferedImage image = greyScaleAnnulus.getImage();
		
		// image will be displayed as JLabel
		imageAnnulus = new JLabel(new ImageIcon(image));
		
		// get content pane
		getContentPane().add(imageAnnulus, gbc_greyScaleAnnulus);
		
		// add to panelAnnulusGraphic panel
		panelAnnulusGraphic.add(imageAnnulus);
		
		// set imageExists to true
		imageExists = true;
	}
	
	/**
	 * This method creates the left side of the GUI,
	 * which contains all the user input fields and controls.
	 * @param args unused
	 */
	private void createLeftElement() {
		
		/**
		 * Defining UI elements here, using GridBagLayout to manage layout.
		 */
	
		// create left parent panel
		panelParentLeft = new JPanel();
		
		// create gridbag constraints for left parent panel
		gbc_panelParentLeft = new GridBagConstraints();
		
		// define gridbag constraints parameters for left parent panel
		gbc_panelParentLeft.gridheight = 2;
		gbc_panelParentLeft.insets = new Insets(0, 0, 5, 5);
		gbc_panelParentLeft.fill = GridBagConstraints.BOTH;
		gbc_panelParentLeft.gridx = 0;
		gbc_panelParentLeft.gridy = 0;
		
		// add left parent panel and gridbag constraints to frame
		getContentPane().add(panelParentLeft, gbc_panelParentLeft);
		
		// define gridbag layout parameters for left parent panel
		gbl_panelParentLeft = new GridBagLayout();
		gbl_panelParentLeft.columnWidths = new int[]{283, 0};
		gbl_panelParentLeft.rowHeights = new int[]{300, 0};
		gbl_panelParentLeft.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelParentLeft.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		
		// set left parent panel's layout manager to gridbag layout
		panelParentLeft.setLayout(gbl_panelParentLeft);
		
		// create annulus calculator panel, goes inside left parent panel
		panelAnnulusCalculator = new JPanel();
		
		// create gridbag constraints for annulus calculator panel
		gbc_panelAnnulusCalculator = new GridBagConstraints();
		
		// define gridbag constraints parameters for annulus calculator panel
		gbc_panelAnnulusCalculator.fill = GridBagConstraints.BOTH;
		gbc_panelAnnulusCalculator.gridx = 0;
		gbc_panelAnnulusCalculator.gridy = 0;
		
		// add annulus calculator panel and gridbag constraints to left parent panel
		panelParentLeft.add(panelAnnulusCalculator, gbc_panelAnnulusCalculator);
		
		// create gridbag layout for annulus calculator panel
		gbl_panelAnnulusCalculator = new GridBagLayout();
		
		// define gridbag layout parameters for annulus calculator panel
		gbl_panelAnnulusCalculator.columnWidths = new int[]{18, 0, 0};
		gbl_panelAnnulusCalculator.rowHeights = new int[]{21, 294, 0};
		gbl_panelAnnulusCalculator.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelAnnulusCalculator.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		
		// set annulus calculator panel's layout manager as gridbag layout
		panelAnnulusCalculator.setLayout(gbl_panelAnnulusCalculator);
		
		// create annulus calculator panel's border
		borderAnnulusCalculator = new JPanel();
		
		// define annulus calculator panel's border parameters
		borderAnnulusCalculator.setBorder(new TitledBorder(null, "Annulus Calculator", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		// create gridbag constraints for annulus calculator border panel
		gbc_borderAnnulus = new GridBagConstraints();
		
		// define gridbag constraints parameters for annulus calculator border panel
		gbc_borderAnnulus.insets = new Insets(0, 0, 0, 0);
		gbc_borderAnnulus.anchor = GridBagConstraints.WEST;
		gbc_borderAnnulus.fill = GridBagConstraints.VERTICAL;
		gbc_borderAnnulus.gridx = 1;
		gbc_borderAnnulus.gridy = 1;
		
		// add annulus calculator border panel and gridbag constraints to annulus calculator border panel
		panelAnnulusCalculator.add(borderAnnulusCalculator, gbc_borderAnnulus);
		
		// create gridbag layout for annulus calculator panel
		gbl_borderAnnulus = new GridBagLayout();
		
		// define gridbag layout parameters for annulus calculator border panel
		gbl_borderAnnulus.columnWidths = new int[]{63, 22, 39, 47, 77, 0};
		gbl_borderAnnulus.rowHeights = new int[]{44, 20, 23, 31, 14, 1, 1, 1, 0, 0};
		gbl_borderAnnulus.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_borderAnnulus.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		// set annulus calculator border panel's layout manager to gridbag layout
		borderAnnulusCalculator.setLayout(gbl_borderAnnulus);
		
		// create label for instructions
		labelAnnulusInstructions = new JLabel("Enter the outer and inner radius:");
		
		// create gridbag constraints for instructions
		gbc_labelAnnulusInstructions = new GridBagConstraints();
		
		// define gridbag constraints parameters for instructions
		gbc_labelAnnulusInstructions.fill = GridBagConstraints.BOTH;
		gbc_labelAnnulusInstructions.insets = new Insets(0, 15, 5, 5);
		gbc_labelAnnulusInstructions.gridwidth = 5;
		gbc_labelAnnulusInstructions.gridx = 0;
		gbc_labelAnnulusInstructions.gridy = 0;
		
		// add instructions and gridbag constraints parameters to annulus calculator border panel
		borderAnnulusCalculator.add(labelAnnulusInstructions, gbc_labelAnnulusInstructions);
		
		// create label for outer radius user input field
		labelOutRadius = new JLabel("Outer Radius");
		
		// create gridbag constraints for outer radius label
		gbc_labelOutRadius = new GridBagConstraints();
		
		// define gridbag constraints parameters for outer radius label
		gbc_labelOutRadius.anchor = GridBagConstraints.WEST;
		gbc_labelOutRadius.insets = new Insets(0, 15, 5, 5);
		gbc_labelOutRadius.gridx = 0;
		gbc_labelOutRadius.gridy = 1;
		
		// add outer radius label and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(labelOutRadius, gbc_labelOutRadius);
		
		// create gridbag constraints for outer radius input field
		gbc_fieldOutRadius = new GridBagConstraints();
		
		// define gridbag constraints parameters for outer radius input field
		gbc_fieldOutRadius.anchor = GridBagConstraints.NORTH;
		gbc_fieldOutRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldOutRadius.insets = new Insets(0, 0, 5, 5);
		gbc_fieldOutRadius.gridwidth = 3;
		gbc_fieldOutRadius.gridx = 1;
		gbc_fieldOutRadius.gridy = 1;
		
		// add outer radius input field and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(fieldOutRadius, gbc_fieldOutRadius);
		
		// set input character limit for outer radius input field
		fieldOutRadius.setColumns(10);
		
		// create label for inner radius input field
		labelInRadius = new JLabel("Inner Radius");
		
		// create gridbag constraints for inner radius input field
		gbc_labelInRadius = new GridBagConstraints();
		
		// define gridbag constraints parameters for inner radius input field
		gbc_labelInRadius.anchor = GridBagConstraints.WEST;
		gbc_labelInRadius.insets = new Insets(0, 15, 5, 5);
		gbc_labelInRadius.gridx = 0;
		gbc_labelInRadius.gridy = 2;
		
		// add inner radius input field and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(labelInRadius, gbc_labelInRadius);
		
		// create gridbag constraints for inner radius input field
		gbc_fieldInRadius = new GridBagConstraints();
		
		// define gridbag constraints parameters for inner radius input field
		gbc_fieldInRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldInRadius.insets = new Insets(0, 0, 5, 5);
		gbc_fieldInRadius.gridwidth = 3;
		gbc_fieldInRadius.gridx = 1;
		gbc_fieldInRadius.gridy = 2;
		
		// add inner radius input field and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(fieldInRadius, gbc_fieldInRadius);
		fieldInRadius.setColumns(10);
		
		// create gridbag constraints for calculate button
		gbc_calcButton = new GridBagConstraints();
		
		// define gridbag constraints parameters for calculate button
		gbc_calcButton.anchor = GridBagConstraints.EAST;
		gbc_calcButton.gridwidth = 3;
		gbc_calcButton.insets = new Insets(0, 0, 5, 5);
		gbc_calcButton.gridx = 1;
		gbc_calcButton.gridy = 3;
		
		// add calculate button and gridbag constraints to annulus calculator calculator border panel
		borderAnnulusCalculator.add(calcButton, gbc_calcButton);
		
		// create approximate area result label
		labelApproxArea = new JLabel("Approximate Area:");
		
		// create gridbag constraints parameters for approximate area result label
		gbc_labelApproxArea = new GridBagConstraints();
		gbc_labelApproxArea.anchor = GridBagConstraints.WEST;
		gbc_labelApproxArea.insets = new Insets(20, 15, 5, 5);
		gbc_labelApproxArea.gridwidth = 2;
		gbc_labelApproxArea.gridx = 0;
		gbc_labelApproxArea.gridy = 4;
		
		// add approximate area result label and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(labelApproxArea, gbc_labelApproxArea);
		
		// create gridbag constraints for approximate area result output
		gbc_approxAreaResult = new GridBagConstraints();
		
		// define gridbag constraints parameters for approximate area result output
		gbc_approxAreaResult.gridwidth = 5;
		gbc_approxAreaResult.insets = new Insets(0, 0, 5, 5);
		gbc_approxAreaResult.gridx = 0;
		gbc_approxAreaResult.gridy = 5;
		
		// add approximate area result output and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(approxAreaResult, gbc_approxAreaResult);
		
		// create monte carlo result label
		labelMonteArea = new JLabel("Monte Carlo Estimation:");
		
		// create gridbag constraints for monte carlo result label
		gbc_labelMonteArea = new GridBagConstraints();
		gbc_labelMonteArea.insets = new Insets(0, 15, 5, 5);
		gbc_labelMonteArea.anchor = GridBagConstraints.NORTH;
		gbc_labelMonteArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelMonteArea.gridwidth = 5;
		gbc_labelMonteArea.gridx = 0;
		gbc_labelMonteArea.gridy = 7;
		
		// add monte carlo result label and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(labelMonteArea, gbc_labelMonteArea);
		
		// create gridbag constraints for monte carlo result output
		gbc_monteAreaResult = new GridBagConstraints();
		
		// define gridbag constraints parameters for monte carlo result output
		gbc_monteAreaResult.insets = new Insets(0, 0, 5, 5);
		gbc_monteAreaResult.gridwidth = 6;
		gbc_monteAreaResult.anchor = GridBagConstraints.NORTH;
		gbc_monteAreaResult.gridx = 0;
		gbc_monteAreaResult.gridy = 8;
		
		// add monte carlo result output and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(monteAreaResult, gbc_monteAreaResult);
	}
	
	/**
	 * This method creates the right side of the GUI,
	 * which contains the greyscale images.
	 */
	private void createRightElement() {
		
		// create right parent panel, container for graphics
		gbc_panelParentRight = new GridBagConstraints();
		gbc_panelParentRight.gridheight = 2;
		gbc_panelParentRight.insets = new Insets(0, 0, 5, 5);
		gbc_panelParentRight.fill = GridBagConstraints.BOTH;
		gbc_panelParentRight.gridx = 1;
		gbc_panelParentRight.gridy = 0;
		getContentPane().add(panelParentRight, gbc_panelParentRight);
	}
	
	/**
	 * This method returns user input for outer radius
	 * from the view, parse as double.
	 * @return double - Outer radius.
	 */
	public double getOutRadius() {
		return Double.parseDouble(fieldOutRadius.getText());
	}
	
	/**
	 * This method returns user input for inner radius
	 * from the view, parse as double.
	 * @return double - Inner radius.
	 */
	public double getInRadius() {
		return Double.parseDouble(fieldInRadius.getText());
	}
	
	/**
	 * This method returns the approx area result
	 * from the view, parse as double.
	 * @return double - Area of annulus.
	 */
	public double getAreaCalc() {
		return Double.parseDouble(approxAreaResult.getText());
	}
	
	/**
	 * This method sets the approx area result to the view
	 * from the controller, parse as String.
	 * @param double area.
	 */
	public void setAreaCalc(double area) {
		approxAreaResult.setText(Double.toString(area));
	}
	
	/**
	 * This method sets the monte carlo result to the view
	 * from the controller, parse as String.
	 * @param area
	 */
	public void setMonteCalc(double area) {
		monteAreaResult.setText(Double.toString(area));
	}
	
	/**
	 * This method adds an action listener for the calculate button.
	 * @param listenForCalcButton.
	 */
	void addCalcListener(ActionListener listenForCalcButton) {
		calcButton.addActionListener(listenForCalcButton);
	}
	
	/**
	 * This method displays an error message for incorrect user input,
	 * as JOptionPane window.
	 * @param String errorMessage.
	 */
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
