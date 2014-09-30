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
 * @version 4.0.0
 * @since 20140930
 */

@SuppressWarnings("serial")
public class CalculatorView extends JFrame {
	
	// declare boolean that tests if image exists
	private static boolean imageExists = false;
	
	// reference to GreyscaleHitViewerPanel for greyscale annulus
	private GreyscaleHitViewerPanel greyscaleAnnulus;
	
	// gbc: annulus greyscale image
	private GridBagConstraints gbc_greyscaleAnnulus;
	
	/**
	 * Defining Annulus Calculator user controls.
	 */
	
	// label: annulus calculator instructions
	private JLabel labelAnnulusInstructions;
	
	// label: annulus outer radius user input title
	private JLabel labelOutRadius;
	
	// text field: annulus outer radius user input field
	private JTextField fieldOutRadius;
	
	// label: annulus inner radius user input title
	private JLabel labelInRadius;
	
	// text field: annulus inner radius user input field
	private JTextField fieldInRadius;
	
	// button: annulus calculate
	private JButton buttonCalcAnnulus;
	
	// label: annulus approx area result title
	private JLabel labelAnnulusApproxArea;
	
	// label: annulus approx area result output
	private JLabel resultAnnulusApproxArea;
	
	// label: annulus monte area result title
	private JLabel labelAnnulusMonteArea;
	
	// label: annulus monte area result output
	private JLabel resultAnnulusMonteArea;
		
	// label: greyscale annulus displays as label
	private JLabel imageAnnulus;
	
	/**
	 * Defining Mandelbrot Calculator controls.
	 */
	
	// label: mandelbrot instructions part 1
	private JLabel labelMandInstructA;
	
	// label: mandelbrot instructions part 2
	private JLabel labelMandInstructB;
	
	// button group: mandelbrot radio buttons
	private final ButtonGroup GROUP_MAND_RADIOS = new ButtonGroup();
	
	// label: mandelbrot radio button normal view
	private JRadioButton radioMandNormalView;
	
	// label: mandelbrot radio button trippy view
	private JRadioButton radioMandTrippyView;
	
	// button: mandelbrot view image button
	private JButton buttonMandView;
	
	// label: mandelbrot monte area result title
	private JLabel labelMandMonteArea;
	
	// label: mandelbrot monte area result output
	private JLabel resultMandMonteArea;
	
	// label: mandelbrot zoom instruction part 1
	private JLabel labelMandZoomInstructA;
	
	// label: mandelbrot zoom instruction part 2
	private JLabel labelMandZoomInstructB;
	
	/**
	 * Defining left side panels.
	 */
	
	// panel: left side container
	private JPanel panelParentLeft;
	
	// panel: annulus calculator container
	private JPanel panelAnnulusCalculator;
	
	// panel: annulus calculator border
	private JPanel borderAnnulusCalculator;
	
	// panel: mandelbrot calculator container
	private JPanel panelMandelbrotCalculator;
	
	// panel: mandelbrot calculator border
	private JPanel borderMandelbrotCalculator;
	
	/**
	 * Defining right side panels.
	 */
	
	// panel: right side container
	private JPanel panelParentRight;
	
	// panel: annulus graphic container
	private JPanel panelAnnulusGraphic;
	
	/**
	 * The view constructor.
	 * Calls various init* methods to create the view.
	 * @param greyscaleAnnulus - The greyscale image object
	 */
	CalculatorView(GreyscaleHitViewerPanel greyscaleAnnulus) {
		this.greyscaleAnnulus = greyscaleAnnulus;
		initFrame();
		initLeftPanel();
		initAnnulusCalcPanel();
		initMandCalcPanel();
		initRightPanel();
	}
	
	/**
	 * This method creates the frame and sets up the layout
	 * with GridBagLayout.
	 * @param args unused
	 */
	private void initFrame() {
		
		
		/*
		 * Defining JFrame parameters
		 */
		
		// set frame size
		setBounds(100, 100, 800, 900);
		
		// disable frame resize
		setResizable(false);
		
		// set default action when window is closed
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set frame to visible
		setVisible(true);
		
		// set frame to appear in the center of the desktop
		setLocationRelativeTo(null);
		
		// set frame's title
		setTitle("Annulus & Mandelbrot Calculator: Martin Ponce ID# 10371381");
		
		// create GridBagLayout object
		GridBagLayout gridBagLayout = new GridBagLayout();
		
		/*
		 * Defining gridBagLayout parameters
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
	 * and adds it to the parent frame.
	 * @param greyscaleAnnulus - The greyscale image object
	 */
	public void showGreyscaleAnnulus(GreyscaleHitViewerPanel greyscaleAnnulus) {
		
		// create the panels for the right side
		initAnnulusImagePanel();

		// if image exists,
		if(imageExists) {
			
			/* 
			 * remove image and panel from parent panel,
			 * stops image from showing up multiple times
			 * whenever buttonCalcAnnulus is pressed
			 */
			getContentPane().remove(imageAnnulus);
			panelParentRight.remove(panelAnnulusGraphic);
		}
		
		// get the image
		repaint();
		BufferedImage image = greyscaleAnnulus.getImage();
		
		// image will be displayed as JLabel
		imageAnnulus = new JLabel(new ImageIcon(image));
		
		// get content pane
		getContentPane().add(imageAnnulus, gbc_greyscaleAnnulus);
		
		// add to panelAnnulusGraphic panel
		panelAnnulusGraphic.add(imageAnnulus);
		
		// set imageExists to true
		imageExists = true;
	}
	
	/**
	 * This method creates the left container of the GUI,
	 * which contains all the user input fields and controls
	 * for both the Annulus and Mandelbrot calculator.
	 * @param args unused
	 */
	private void initLeftPanel() {
	
		// create left parent panel
		panelParentLeft = new JPanel();
		
		// create gridbag constraints for left parent panel
		GridBagConstraints gbc_panelParentLeft = new GridBagConstraints();
		
		// define gridbag constraints parameters for left parent panel
		gbc_panelParentLeft.gridheight = 2;
		gbc_panelParentLeft.insets = new Insets(0, 0, 5, 5);
		gbc_panelParentLeft.fill = GridBagConstraints.BOTH;
		gbc_panelParentLeft.gridx = 0;
		gbc_panelParentLeft.gridy = 0;
		
		// add left parent panel and gridbag constraints to frame
		getContentPane().add(panelParentLeft, gbc_panelParentLeft);
		
		// create gridbag layout for left parent panel
		GridBagLayout gbl_panelParentLeft = new GridBagLayout();
		
		// define gridbag layout parameters for left parent panel
		gbl_panelParentLeft.columnWidths = new int[]{283, 0};
		gbl_panelParentLeft.rowHeights = new int[]{300, 0};
		gbl_panelParentLeft.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelParentLeft.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		
		// set left parent panel's layout manager to gridbag layout
		panelParentLeft.setLayout(gbl_panelParentLeft);
	}
	
	/**
	 * This method creates the Annulus Calculator panel,
	 * which is inside the left container. Also sets up
	 * the user controls.
	 * @param args unused
	 */
	private void initAnnulusCalcPanel() {
		
		// create annulus calculator panel, goes inside left parent panel
		panelAnnulusCalculator = new JPanel();
		
		// create gridbag constraints for annulus calculator panel
		GridBagConstraints gbc_panelAnnulusCalculator = new GridBagConstraints();
		
		// define gridbag constraints parameters for annulus calculator panel
		gbc_panelAnnulusCalculator.fill = GridBagConstraints.BOTH;
		gbc_panelAnnulusCalculator.gridx = 0;
		gbc_panelAnnulusCalculator.gridy = 0;
		
		// add annulus calculator panel and gridbag constraints to left parent panel
		panelParentLeft.add(panelAnnulusCalculator, gbc_panelAnnulusCalculator);
		
		// create gridbag layout for annulus calculator panel
		GridBagLayout gbl_panelAnnulusCalculator = new GridBagLayout();
		
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
		GridBagConstraints gbc_borderAnnulusCalculator = new GridBagConstraints();
		
		// define gridbag constraints parameters for annulus calculator border panel
		gbc_borderAnnulusCalculator.insets = new Insets(0, 0, 0, 0);
		gbc_borderAnnulusCalculator.anchor = GridBagConstraints.WEST;
		gbc_borderAnnulusCalculator.fill = GridBagConstraints.VERTICAL;
		gbc_borderAnnulusCalculator.gridx = 1;
		gbc_borderAnnulusCalculator.gridy = 1;
		
		// add annulus calculator border panel and gridbag constraints to annulus calculator border panel
		panelAnnulusCalculator.add(borderAnnulusCalculator, gbc_borderAnnulusCalculator);
		
		// create gridbag layout for annulus calculator panel
		GridBagLayout gbl_borderAnnulusCalculator = new GridBagLayout();
		
		// define gridbag layout parameters for annulus calculator border panel
		gbl_borderAnnulusCalculator.columnWidths = new int[]{63, 22, 39, 47, 77, 0};
		gbl_borderAnnulusCalculator.rowHeights = new int[]{44, 20, 23, 31, 14, 1, 1, 1, 0, 0};
		gbl_borderAnnulusCalculator.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_borderAnnulusCalculator.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		// set annulus calculator border panel's layout manager to gridbag layout
		borderAnnulusCalculator.setLayout(gbl_borderAnnulusCalculator);
		
		// create label for instructions
		labelAnnulusInstructions = new JLabel("Enter the outer and inner radius:");
		
		// create gridbag constraints for instructions
		GridBagConstraints gbc_labelAnnulusInstructions = new GridBagConstraints();
		
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
		GridBagConstraints gbc_labelOutRadius = new GridBagConstraints();
		
		// define gridbag constraints parameters for outer radius label
		gbc_labelOutRadius.anchor = GridBagConstraints.WEST;
		gbc_labelOutRadius.insets = new Insets(0, 15, 5, 5);
		gbc_labelOutRadius.gridx = 0;
		gbc_labelOutRadius.gridy = 1;
		
		// add outer radius label and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(labelOutRadius, gbc_labelOutRadius);
		
		// create outer radius input field
		fieldOutRadius = new JTextField();
		
		// create gridbag constraints for outer radius input field
		GridBagConstraints gbc_fieldOutRadius = new GridBagConstraints();
		
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
		GridBagConstraints gbc_labelInRadius = new GridBagConstraints();
		
		// define gridbag constraints parameters for inner radius input field
		gbc_labelInRadius.anchor = GridBagConstraints.WEST;
		gbc_labelInRadius.insets = new Insets(0, 15, 5, 5);
		gbc_labelInRadius.gridx = 0;
		gbc_labelInRadius.gridy = 2;
		
		// add inner radius input field and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(labelInRadius, gbc_labelInRadius);
		
		// create inner radius input field
		fieldInRadius = new JTextField();
		
		// create gridbag constraints for inner radius input field
		GridBagConstraints gbc_fieldInRadius = new GridBagConstraints();
		
		// define gridbag constraints parameters for inner radius input field
		gbc_fieldInRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldInRadius.insets = new Insets(0, 0, 5, 5);
		gbc_fieldInRadius.gridwidth = 3;
		gbc_fieldInRadius.gridx = 1;
		gbc_fieldInRadius.gridy = 2;
		
		// add inner radius input field and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(fieldInRadius, gbc_fieldInRadius);
		fieldInRadius.setColumns(10);
		
		// create annulus calculate button
		buttonCalcAnnulus = new JButton("Calculate");
		
		// create gridbag constraints for annulus calculate button
		GridBagConstraints gbc_buttonCalcAnnulus = new GridBagConstraints();
		
		// define gridbag constraints parameters for calculate button
		gbc_buttonCalcAnnulus.anchor = GridBagConstraints.EAST;
		gbc_buttonCalcAnnulus.gridwidth = 3;
		gbc_buttonCalcAnnulus.insets = new Insets(0, 0, 5, 5);
		gbc_buttonCalcAnnulus.gridx = 1;
		gbc_buttonCalcAnnulus.gridy = 3;
		
		// add annulus calculate button and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(buttonCalcAnnulus, gbc_buttonCalcAnnulus);
		
		// create approximate area result label
		labelAnnulusApproxArea = new JLabel("Approximate Area:");
		
		// create gridbag constraints parameters for approximate area result label
		GridBagConstraints gbc_labelAnnulusApproxArea = new GridBagConstraints();
		
		// define gridbag constraints parameters for approximate area result label
		gbc_labelAnnulusApproxArea.anchor = GridBagConstraints.WEST;
		gbc_labelAnnulusApproxArea.insets = new Insets(20, 15, 5, 5);
		gbc_labelAnnulusApproxArea.gridwidth = 2;
		gbc_labelAnnulusApproxArea.gridx = 0;
		gbc_labelAnnulusApproxArea.gridy = 4;
		
		// add approximate area result label and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(labelAnnulusApproxArea, gbc_labelAnnulusApproxArea);
		
		// create approximate area result output
		resultAnnulusApproxArea = new JLabel("---");
		
		// create gridbag constraints for approximate area result output
		GridBagConstraints gbc_resultAnnulusApproxArea = new GridBagConstraints();
		
		// define gridbag constraints parameters for approximate area result output
		gbc_resultAnnulusApproxArea.gridwidth = 5;
		gbc_resultAnnulusApproxArea.insets = new Insets(0, 0, 5, 5);
		gbc_resultAnnulusApproxArea.gridx = 0;
		gbc_resultAnnulusApproxArea.gridy = 5;
		
		// add approximate area result output and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(resultAnnulusApproxArea, gbc_resultAnnulusApproxArea);
		
		// create monte carlo result label
		labelAnnulusMonteArea = new JLabel("Monte Carlo Estimation:");
		
		// create gridbag constraints for monte carlo result label
		GridBagConstraints gbc_labelAnnulusMonteArea = new GridBagConstraints();
		
		// define gridbag constraints parameters for monte carlo result label
		gbc_labelAnnulusMonteArea.insets = new Insets(0, 15, 5, 5);
		gbc_labelAnnulusMonteArea.anchor = GridBagConstraints.NORTH;
		gbc_labelAnnulusMonteArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelAnnulusMonteArea.gridwidth = 5;
		gbc_labelAnnulusMonteArea.gridx = 0;
		gbc_labelAnnulusMonteArea.gridy = 7;
		
		// add monte carlo result label and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(labelAnnulusMonteArea, gbc_labelAnnulusMonteArea);
		
		// create annulus monte carlo result output
		resultAnnulusMonteArea = new JLabel("---");
		
		// create gridbag constraints for monte carlo result output
		GridBagConstraints gbc_resultAnnulusMonteArea = new GridBagConstraints();
		
		// define gridbag constraints parameters for monte carlo result output
		gbc_resultAnnulusMonteArea.insets = new Insets(0, 0, 5, 5);
		gbc_resultAnnulusMonteArea.gridwidth = 6;
		gbc_resultAnnulusMonteArea.anchor = GridBagConstraints.NORTH;
		gbc_resultAnnulusMonteArea.gridx = 0;
		gbc_resultAnnulusMonteArea.gridy = 8;
		
		// add monte carlo result output and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(resultAnnulusMonteArea, gbc_resultAnnulusMonteArea);
	}
	
	/**
	 * This method creates the Mandelbrot Calculator panel,
	 * which is inside the left container. Also sets up
	 * the user controls.
	 * @param args unused
	 */
	private void initMandCalcPanel() {
		
		// create mandelbrot calculator panel, goes inside left parent panel
		panelMandelbrotCalculator = new JPanel();
				
		// create gridbag constraints for mandelbrot calculator panel
		GridBagConstraints gbc_panelMandelbrotCalculator = new GridBagConstraints();
		
		// define gridbag constraints parameters for mandelbrot calculator panel
		gbc_panelMandelbrotCalculator.fill = GridBagConstraints.BOTH;
		gbc_panelMandelbrotCalculator.insets = new Insets(100, 0, 0, 0);
		gbc_panelMandelbrotCalculator.gridx = 0;
		gbc_panelMandelbrotCalculator.gridy = 1;
		
		// add mandelbrot calculator panel and gridbag constraints to left parent pane
		panelParentLeft.add(panelMandelbrotCalculator, gbc_panelMandelbrotCalculator);
		
		// create gridbag layout for mandelbrot calculator panel
		GridBagLayout gbl_panelMandelbrotCalculator = new GridBagLayout();
		
		// define gridbag layout parameters for mandelbrot calculator panel
		gbl_panelMandelbrotCalculator.columnWidths = new int[]{18, 0, 0};
		gbl_panelMandelbrotCalculator.rowHeights = new int[]{21, 294, 0};
		gbl_panelMandelbrotCalculator.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelMandelbrotCalculator.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		
		// set mandelbrot calculator panel's layout manager as gridbag layout
		panelMandelbrotCalculator.setLayout(gbl_panelMandelbrotCalculator);
		
		// create mandelbrot calculator panel's border
		borderMandelbrotCalculator = new JPanel();
		
		// define mandelbrot calculator panel's border parameters
		borderMandelbrotCalculator.setBorder(new TitledBorder(null, "Mandelbrot Calculator", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		// create gridbag constraints for mandelbrot calculator border panel
		GridBagConstraints gbc_borderMandelbrotCalculator = new GridBagConstraints();
		
		// define gridbag constraints parameters for mandelbrot calculator border panel
		gbc_borderMandelbrotCalculator.insets = new Insets(0, 0, 0, 0);
		gbc_borderMandelbrotCalculator.anchor = GridBagConstraints.WEST;
		gbc_borderMandelbrotCalculator.fill = GridBagConstraints.VERTICAL;
		gbc_borderMandelbrotCalculator.gridx = 1;
		gbc_borderMandelbrotCalculator.gridy = 1;
		
		// add mandelbrot calculator border panel and gridbag constraints to mandelbrot calculator border panel
		panelMandelbrotCalculator.add(borderMandelbrotCalculator, gbc_borderMandelbrotCalculator);
		
		// create gridbag layout for mandelbrot calculator panel
		GridBagLayout gbl_borderMandelbrotCalculator = new GridBagLayout();
		
		// define gridbag layout parameters for mandelbrot calculator border panel
		gbl_borderMandelbrotCalculator.columnWidths = new int[]{63, 22, 39, 47, 77, 0};
		gbl_borderMandelbrotCalculator.rowHeights = new int[]{44, 20, 23, 31, 14, 1, 1, 1, 0, 0};
		gbl_borderMandelbrotCalculator.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_borderMandelbrotCalculator.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		// set mandelbrot calculator border panel's layout manager to gridbag layout
		borderMandelbrotCalculator.setLayout(gbl_borderMandelbrotCalculator);
		
		// create label for mandelbrot calculator instructions part 1
		labelMandInstructA = new JLabel("What is a mandelbrot?");
		
		// create gridbag constraints for mandelbrot calculator instructions part 1
		GridBagConstraints gbc_labelMandInstructA = new GridBagConstraints();
		
		// define gridbag constraints parameters for mandelbrot calculator instructions part 1
		gbc_labelMandInstructA.fill = GridBagConstraints.BOTH;
		gbc_labelMandInstructA.insets = new Insets(0, 15, 5, 5);
		gbc_labelMandInstructA.gridwidth = 5;
		gbc_labelMandInstructA.gridx = 0;
		gbc_labelMandInstructA.gridy = 0;
		
		// add instructions and gridbag constraints parameters to mandelbrot calculator border panel
		borderMandelbrotCalculator.add(labelMandInstructA, gbc_labelMandInstructA);
		
		// create label for mandelbrot calculator instructions part 2
		labelMandInstructB = new JLabel("Click view to find out.");
		
		// create gridbag constraints for mandelbrot calculator instructions part 2
		GridBagConstraints gbc_labelMandInstructB = new GridBagConstraints();
		
		// define gridbag constraints parameters for mandelbrot calculator instructions part 2
		gbc_labelMandInstructB.anchor = GridBagConstraints.WEST;
		gbc_labelMandInstructB.insets = new Insets(0, 15, 5, 5);
		gbc_labelMandInstructB.gridwidth = 5;
		gbc_labelMandInstructB.gridx = 0;
		gbc_labelMandInstructB.gridy = 1;
		
		// add mandelbrot calculator instructions part 2 and gridbag constraints to mandelbrot calculator border panel
		borderMandelbrotCalculator.add(labelMandInstructB, gbc_labelMandInstructB);
		
		// create mandelbrot normal view radio button
		radioMandNormalView = new JRadioButton("Normal view");
		
		// make this button the default selection
		radioMandNormalView.setSelected(true);
		
		// add radio button to group
		GROUP_MAND_RADIOS.add(radioMandNormalView);
		
		// create gridbag constraints for mandelbrot normal view radio button
		GridBagConstraints gbc_radioMandNormalView = new GridBagConstraints();
		
		// define gridbag constraints parameters for mandelbrot normal view radio button
		gbc_radioMandNormalView.anchor = GridBagConstraints.WEST;
		gbc_radioMandNormalView.insets = new Insets(15, 15, 5, 5);
		gbc_radioMandNormalView.gridx = 0;
		gbc_radioMandNormalView.gridy = 2;
		
		// add mandelbrot normal view radio button and gridbag constraints to mandelbrot calculator border panel
		borderMandelbrotCalculator.add(radioMandNormalView, gbc_radioMandNormalView);
		
		// create mandelbrot trippy view radio button
		radioMandTrippyView = new JRadioButton("Back to the 60s");
		
		// add radio button to group
		GROUP_MAND_RADIOS.add(radioMandTrippyView);
		
		// create gridbag constraints for mandelbrot trippy view radio button
		GridBagConstraints gbc_radioMandTrippyView = new GridBagConstraints();
		
		// define gridbag constraints parameters for mandelbrot trippy view radio button
		gbc_radioMandTrippyView.anchor = GridBagConstraints.WEST;
		gbc_radioMandTrippyView.insets = new Insets(0, 15, 5, 5);
		gbc_radioMandTrippyView.gridwidth = 5;
		gbc_radioMandTrippyView.gridx = 0;
		gbc_radioMandTrippyView.gridy = 3;
		
		// add mandelbrot trippy view radio button and gridbag constraints to mandelbrot calculator border panel
		borderMandelbrotCalculator.add(radioMandTrippyView, gbc_radioMandTrippyView);
		
		// create mandelbrot view button
		buttonMandView = new JButton("View");
		
		// create gridbag constraints for mandelbrot view button
		GridBagConstraints gbc_buttonMandView = new GridBagConstraints();
		
		// define gridbag constraints parameters for mandelbrot view button
		gbc_buttonMandView.anchor = GridBagConstraints.WEST;
		gbc_buttonMandView.gridwidth = 3;
		gbc_buttonMandView.insets = new Insets(0, 0, 5, 5);
		gbc_buttonMandView.gridx = 2;
		gbc_buttonMandView.gridy = 3;
		
		// add mandelbrot view button and gridbag constraints to mandelbrot calculator border panel
		borderMandelbrotCalculator.add(buttonMandView, gbc_buttonMandView);
		
		// create mandelbrot monte carlo result label
		labelMandMonteArea = new JLabel("Monte Carlo Estimation:");
		
		// create gridbag constraints for mandelbrot monte carlo result label
		GridBagConstraints gbc_labelMandMonteArea = new GridBagConstraints();
		
		// define gridbag constraints parameters for mandelbrot monte carlo result label
		gbc_labelMandMonteArea.insets = new Insets(0, 15, 5, 5);
		gbc_labelMandMonteArea.anchor = GridBagConstraints.NORTH;
		gbc_labelMandMonteArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelMandMonteArea.gridwidth = 5;
		gbc_labelMandMonteArea.gridx = 0;
		gbc_labelMandMonteArea.gridy = 7;
		
		// add mandelbrot monte carlo result label and gridbag constraints to mandelbrot calculator border panel
		borderMandelbrotCalculator.add(labelMandMonteArea, gbc_labelMandMonteArea);
		
		// create mandelbrot monte carlo result output
		resultMandMonteArea = new JLabel("---");
		
		// create gridbag constraints for mandelbrot monte carlo result output
		GridBagConstraints gbc_resultMandMonteArea = new GridBagConstraints();
		
		// define gridbag constraints parameters for mandelbrot monte carlo result output
		gbc_resultMandMonteArea.insets = new Insets(0, 0, 5, 5);
		gbc_resultMandMonteArea.gridwidth = 6;
		gbc_resultMandMonteArea.anchor = GridBagConstraints.NORTH;
		gbc_resultMandMonteArea.gridx = 0;
		gbc_resultMandMonteArea.gridy = 8;
		
		// add mandelbrot monte carlo result output and gridbag constraints to mandelbrot calculator border panel
		borderMandelbrotCalculator.add(resultMandMonteArea, gbc_resultMandMonteArea);
		
		/************/
	}
	
	/**
	 * This method creates the right container of the GUI,
	 * which contains the greyscale images.
	 * @param args unused
	 */
	private void initRightPanel() {
		
		// create right parent panel, container for graphics
		panelParentRight = new JPanel();
		
		// create gridbag constraints for right parent panel
		GridBagConstraints gbc_panelParentRight = new GridBagConstraints();
		
		// define gridbag constraints parameters for right parent panel
		gbc_panelParentRight.gridheight = 2;
		gbc_panelParentRight.insets = new Insets(0, 0, 5, 5);
		gbc_panelParentRight.fill = GridBagConstraints.BOTH;
		gbc_panelParentRight.gridx = 1;
		gbc_panelParentRight.gridy = 0;
		getContentPane().add(panelParentRight, gbc_panelParentRight);
	}
	
	/**
	 * This method creates the Annulus image panel,
	 * which is inside the right container.
	 * @param args unused
	 */
	private void initAnnulusImagePanel() {
		
		// setting up the parent panel for greyscale annulus image
		panelAnnulusGraphic = new JPanel();
		
		// create gridbag constraints for parent panel
		GridBagConstraints gbc_panelAnnulusGraphic = new GridBagConstraints();
		
		// define gridbag constraints parameters for parent panel
		gbc_panelAnnulusGraphic.insets = new Insets(0, 0, 5, 0);
		gbc_panelAnnulusGraphic.fill = GridBagConstraints.BOTH;
		gbc_panelAnnulusGraphic.gridx = 0;
		gbc_panelAnnulusGraphic.gridy = 0;
		
		// add parent panel and gridbag constraints to container panel
		panelParentRight.add(panelAnnulusGraphic, gbc_panelAnnulusGraphic);
		
		// create gridbag layout
		GridBagLayout gbl_panelAnnulusGraphic = new GridBagLayout();
		
		// define gridbag layout for greyscale annulus image panel
		gbl_panelAnnulusGraphic.columnWidths = new int[]{0};
		gbl_panelAnnulusGraphic.rowHeights = new int[]{0};
		gbl_panelAnnulusGraphic.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelAnnulusGraphic.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		
		// set layout to parent panel for greyscale annulus image
		panelAnnulusGraphic.setLayout(gbl_panelAnnulusGraphic);
		
		// create gridbag constraints
		gbc_greyscaleAnnulus = new GridBagConstraints();
		gbc_greyscaleAnnulus.gridx = 0;
		gbc_greyscaleAnnulus.gridy = 0;
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
		return Double.parseDouble(resultAnnulusApproxArea.getText());
	}
	
	/**
	 * This method sets the approx area result to the view
	 * from the controller, parse as String.
	 * @param double area.
	 */
	public void setAreaCalc(double area) {
		resultAnnulusApproxArea.setText(Double.toString(area));
	}
	
	/**
	 * This method sets the monte carlo result to the view
	 * from the controller, parse as String.
	 * @param area
	 */
	public void setMonteCalc(double area) {
		resultAnnulusMonteArea.setText(Double.toString(area));
	}
	
	/**
	 * This method adds an action listener for the calculate button.
	 * @param listenForButtonCalcAnnulus.
	 */
	public void addCalcListener(ActionListener listenForButtonCalcAnnulus) {
		buttonCalcAnnulus.addActionListener(listenForButtonCalcAnnulus);
	}
	
	/**
	 * This method displays an error message for incorrect user input,
	 * as JOptionPane window.
	 * @param String errorMessage.
	 */
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
