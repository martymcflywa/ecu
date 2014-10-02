package csp1150.assignment1;

// import action listener
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

// import swing gui components
import javax.swing.*;
import javax.swing.border.TitledBorder;

// import layout componenets
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
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
	
	// declare boolean to test if annulus image exists
	private static boolean annulusImageExists = false;
	
	// declare boolean to test if mandelbrot image exists
	private static boolean mandelbrotImageExists = false;
	
	// reference to GreyscaleHitViewerPanel for greyscale annulus
	private HitViewerGenerator greyscaleAnnulus;
	
	// reference to GreyscaleHitViewerPanel for greyscale mandelbrot
	private HitViewerGenerator greyscaleMandelbrot;
	
	// reference to ColourHitViewerPanel for colour mandelbrot
	private ColourHitViewer colourMandelbrot;
	
	// gbc: annulus image
	private GridBagConstraints gbc_imageAnnulus;
	
	// gbc: mandelbrot image
	private GridBagConstraints gbc_imageMandelbrot;
	
	/**
	 * Defining Annulus Calculator user controls.
	 */
	
	// label: annulus calculator instructions
	private JLabel labelAnnulusInstructions = new JLabel("Enter the outer and inner radius:");
	
	// label: annulus outer radius user input title
	private JLabel labelOutRadius = new JLabel("Outer Radius");
	
	// text field: annulus outer radius user input field
	private JTextField fieldOutRadius = new JTextField();
	
	// label: annulus inner radius user input title
	private JLabel labelInRadius = new JLabel("Inner Radius");
	
	// text field: annulus inner radius user input field
	private JTextField fieldInRadius = new JTextField();
	
	// button: annulus calculate
	private JButton buttonCalcAnnulus = new JButton("Calculate");
	
	// label: annulus approx area result title
	private JLabel labelAnnulusApproxArea = new JLabel("Approximate Area:");
	
	// label: annulus approx area result output
	private JLabel resultAnnulusApproxArea = new JLabel("---");
	
	// label: annulus monte area result title
	private JLabel labelAnnulusMonteArea = new JLabel("Monte Carlo Estimation:");
	
	// label: annulus monte area result output
	private JLabel resultAnnulusMonteArea = new JLabel("---");
	
	/**
	 * The Annulus image
	 */
	
	// label: greyscale annulus displays as label
	private JLabel imageAnnulus;
	
	/**
	 * Defining Mandelbrot Calculator user controls.
	 */
	
	// label: mandelbrot instructions part 1
	private JLabel labelMandInstruct = new JLabel("Select calculate or view image.");
	
	// label: mandelbrot instructions part 2
	//private JLabel labelMandInstructB = new JLabel("or view image.");
	
	// button group: mandelbrot radio buttons, so only one of two can be selected at a time
	private final ButtonGroup GROUP_MAND_RADIOS = new ButtonGroup();
	
	// label: mandelbrot radio button normal view
	protected JRadioButton radioMandCalculate = new JRadioButton("Calculate Area");
	
	// label: mandelbrot radio button trippy view
	protected JRadioButton radioMandViewImage = new JRadioButton("View Image");
	
	// button: mandelbrot view image button
	private JButton buttonMandOK = new JButton("OK");
	
	// label: mandelbrot monte area result title
	private JLabel labelMandMonteArea = new JLabel("Monte Carlo Estimation:");
	
	// label: mandelbrot monte area result output
	private JLabel resultMandMonteArea = new JLabel("---");
	
	// label: mandelbrot zoom instruction part 1
	private JLabel labelMandZoomInstructA;
	
	// label: mandelbrot zoom instruction part 2
	private JLabel labelMandZoomInstructB;
	
	/**
	 * The Mandelbrot image
	 */
	
	// label: greyscale mandelbrot displays as label
	private JLabel imageMandelbrot;
	
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
	
	// panel: mandelbrot graphic container
	private JPanel panelMandelbrotGraphic;
	
	/**
	 * The view constructor.
	 * Calls various init* methods to create the view.
	 * 
	 * @param greyscaleAnnulus - The greyscale annulus image object
	 * @param greyscaleMandelbrot - The greyscale mandelbrot image object
	 * @param colourMandelbrot - The colour mandelbrot image object
	 */
	CalculatorView(HitViewerGenerator greyscaleAnnulus, HitViewerGenerator greyscaleMandelbrot, ColourHitViewer colourMandelbrot) {
		
		// assign this greyscale annulus to incoming object
		this.greyscaleAnnulus = greyscaleAnnulus;
		
		// assign this greyscale mandelbrot to incoming object
		this.greyscaleMandelbrot = greyscaleMandelbrot;
		
		// assign this colour mandelbrot to incoming object
		this.colourMandelbrot = colourMandelbrot;
		
		// set up frame
		initFrame();
		
		// set up left panel
		initLeftPanel();
		
		// set up annulus calculator panels
		initAnnulusCalcPanel();
		
		// set up mandelbrot calculator panels
		initMandCalcPanel();
		
		// set up right panel 
		initRightPanel();
		
		// show empty annulus image
		showAnnulusImage(greyscaleAnnulus);
		
		// show empty mandelbrot image
		showMandelbrotImage(colourMandelbrot);
	}
	
	/**
	 * This method creates the frame and sets up the layout
	 * with GridBagLayout.
	 * 
	 * @param args unused
	 */
	private void initFrame() {
		
		/*
		 * Defining JFrame global parameters
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
		 * Defining GridBagLayout global parameters
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
	 * adds it to the parent frame, and displays image.
	 * 
	 * @param greyscaleAnnulus - The greyscale image object.
	 */
	public void showAnnulusImage(HitViewerGenerator greyscaleAnnulus) {
		
		// create the parent panel for greyscale annulus image
		initAnnulusImagePanel();
		
		// resetImagePanel if image exists
		resetImagePanel(annulusImageExists, greyscaleAnnulus, panelParentRight, panelAnnulusGraphic);
		
		// get the image
		BufferedImage image = greyscaleAnnulus.getImage();
		
		// image will be displayed as JLabel
		imageAnnulus = new JLabel(new ImageIcon(image));
		
		// get content pane
		getContentPane().add(imageAnnulus, gbc_imageAnnulus);
		
		// add to panelAnnulusGraphic panel
		panelAnnulusGraphic.add(imageAnnulus);
		
		// set annulusImageExists to true
		annulusImageExists = true;
		
		imageAnnulus.validate();
		imageAnnulus.repaint();
	}
	
	/**
	 * This method creates the layout for greyscale mandelbrot image,
	 * adds it to the parent frame, and displays image.
	 * 
	 * @param greyscaleMandelbrot - The greyscale image object.
	 */
	public void showMandelbrotImage(HitViewerGenerator theImage) {
		
		// create the parent panel for mandelbrot image
		initMandelbrotImagePanel();
		
		// resetImagePanel if image exists
		resetImagePanel(mandelbrotImageExists, theImage, panelParentRight, panelMandelbrotGraphic);
		
		// get the image
		BufferedImage image = theImage.getImage();
		
		// image will be displayed as JLabel
		imageMandelbrot = new JLabel(new ImageIcon(image));

		// get content pane
		getContentPane().add(imageMandelbrot, gbc_imageMandelbrot);
		
		// add to panelMandelbrotGraphic panel
		panelMandelbrotGraphic.add(imageMandelbrot, gbc_imageMandelbrot);
		
		// set mandelbrotImageExists to true
		mandelbrotImageExists = true;
		
		imageMandelbrot.validate();
		imageMandelbrot.repaint();
	}
	
	/**
	 * This method checks if the image exists,
	 * if it does, it removes the image and the panel from the parent panel
	 * so the image doesn't appear multiple times in the frame when they are drawn.
	 * 
	 * @param thisImageExists - Either annulusImageExists or mandelbrotImageExists.
	 * @param theImage - Any object from GreyscaleHitViewerPanel or its subclasses.
	 * @param theParentPanel - The parent panel that contains the image panel.
	 * @param theChildPanel - The child panel that contains the image.
	 */
	private void resetImagePanel(boolean thisImageExists, HitViewerGenerator theImage, JPanel theParentPanel, JPanel theChildPanel) {
		
		if(thisImageExists) {
			getContentPane().remove(theImage);
			theParentPanel.remove(theChildPanel);
			theParentPanel.validate();
			theParentPanel.repaint();
		}
	}
	
	/**
	 * This method creates the left container of the GUI,
	 * which contains all the user input fields and controls
	 * for both the Annulus and Mandelbrot calculator.
	 * 
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
	 * 
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
		
		// create gridbag constraints for inner radius input field
		GridBagConstraints gbc_labelInRadius = new GridBagConstraints();
		
		// define gridbag constraints parameters for inner radius input field
		gbc_labelInRadius.anchor = GridBagConstraints.WEST;
		gbc_labelInRadius.insets = new Insets(0, 15, 5, 5);
		gbc_labelInRadius.gridx = 0;
		gbc_labelInRadius.gridy = 2;
		
		// add inner radius input field and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(labelInRadius, gbc_labelInRadius);
		
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
		
		// create gridbag constraints for approximate area result output
		GridBagConstraints gbc_resultAnnulusApproxArea = new GridBagConstraints();
		
		// define gridbag constraints parameters for approximate area result output
		gbc_resultAnnulusApproxArea.gridwidth = 5;
		gbc_resultAnnulusApproxArea.insets = new Insets(0, 0, 5, 5);
		gbc_resultAnnulusApproxArea.gridx = 0;
		gbc_resultAnnulusApproxArea.gridy = 5;
		
		// add approximate area result output and gridbag constraints to annulus calculator border panel
		borderAnnulusCalculator.add(resultAnnulusApproxArea, gbc_resultAnnulusApproxArea);
		
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
	 * 
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

		// create gridbag constraints for mandelbrot calculator instructions part 1
		GridBagConstraints gbc_labelMandInstruct = new GridBagConstraints();
		
		// define gridbag constraints parameters for mandelbrot calculator instructions part 1
		gbc_labelMandInstruct.fill = GridBagConstraints.BOTH;
		gbc_labelMandInstruct.insets = new Insets(0, 15, 5, 5);
		gbc_labelMandInstruct.gridwidth = 5;
		gbc_labelMandInstruct.gridx = 0;
		gbc_labelMandInstruct.gridy = 0;
		
		// add instructions and gridbag constraints parameters to mandelbrot calculator border panel
		borderMandelbrotCalculator.add(labelMandInstruct, gbc_labelMandInstruct);
		
		// make this button the default selection
		radioMandCalculate.setSelected(true);
		
		// add radio button to group
		GROUP_MAND_RADIOS.add(radioMandCalculate);
		
		// create gridbag constraints for mandelbrot normal view radio button
		GridBagConstraints gbc_radioMandCalculate = new GridBagConstraints();
		
		// define gridbag constraints parameters for mandelbrot normal view radio button
		gbc_radioMandCalculate.anchor = GridBagConstraints.WEST;
		gbc_radioMandCalculate.insets = new Insets(0, 15, 5, 5);
		gbc_radioMandCalculate.gridwidth = 2;
		gbc_radioMandCalculate.gridx = 0;
		gbc_radioMandCalculate.gridy = 1;
		
		// add mandelbrot normal view radio button and gridbag constraints to mandelbrot calculator border panel
		borderMandelbrotCalculator.add(radioMandCalculate, gbc_radioMandCalculate);
		
		// add radio button to group
		GROUP_MAND_RADIOS.add(radioMandViewImage);
		
		// create gridbag constraints for mandelbrot trippy view radio button
		GridBagConstraints gbc_radioMandViewImage = new GridBagConstraints();
		
		// define gridbag constraints parameters for mandelbrot trippy view radio button
		gbc_radioMandViewImage.anchor = GridBagConstraints.WEST;
		gbc_radioMandViewImage.insets = new Insets(0, 15, 5, 5);
		gbc_radioMandViewImage.gridwidth = 5;
		gbc_radioMandViewImage.gridx = 0;
		gbc_radioMandViewImage.gridy = 2;
		
		// add mandelbrot trippy view radio button and gridbag constraints to mandelbrot calculator border panel
		borderMandelbrotCalculator.add(radioMandViewImage, gbc_radioMandViewImage);
		
		// create gridbag constraints for mandelbrot view button
		GridBagConstraints gbc_buttonMandOK = new GridBagConstraints();
		
		// define gridbag constraints parameters for mandelbrot view button
		gbc_buttonMandOK.anchor = GridBagConstraints.EAST;
		gbc_buttonMandOK.gridwidth = 2;
		gbc_buttonMandOK.insets = new Insets(0, 0, 5, 5);
		gbc_buttonMandOK.gridx = 2;
		gbc_buttonMandOK.gridy = 3;
		
		// add mandelbrot view button and gridbag constraints to mandelbrot calculator border panel
		borderMandelbrotCalculator.add(buttonMandOK, gbc_buttonMandOK);

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
	}
	
	/**
	 * This method creates the right container of the GUI,
	 * which contains the greyscale images.
	 * 
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
	 * 
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
		
		// define gridbag layout for greyscale annulus container panel
		gbl_panelAnnulusGraphic.columnWidths = new int[]{0};
		gbl_panelAnnulusGraphic.rowHeights = new int[]{0};
		gbl_panelAnnulusGraphic.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelAnnulusGraphic.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		
		// set layout to parent panel for greyscale annulus image
		panelAnnulusGraphic.setLayout(gbl_panelAnnulusGraphic);
		
		// create gridbag constraints for the image itself
		gbc_imageAnnulus = new GridBagConstraints();
		gbc_imageAnnulus.gridx = 0;
		gbc_imageAnnulus.gridy = 0;
	}
	
	/**
	 * This method creates the Mandelbrot image panel,
	 * which is inside the right container.
	 * 
	 * @param args unused
	 */
	
	private void initMandelbrotImagePanel() {
		
		// setting up parent panel for greyscale mandelbrot image
		panelMandelbrotGraphic = new JPanel();
		
		// create gridbag constraints for the parent panel
		GridBagConstraints gbc_panelMandelbrotGraphic = new GridBagConstraints();
		
		// define gridbag constraints parameters for parent panel
		gbc_panelMandelbrotGraphic.insets = new Insets(0, 0, 5, 0);
		gbc_panelMandelbrotGraphic.fill = GridBagConstraints.BOTH;
		gbc_panelMandelbrotGraphic.gridx = 0;
		gbc_panelMandelbrotGraphic.gridy = 1;
		
		// add parent panel and gridbag constraints to container panel
		panelParentRight.add(panelMandelbrotGraphic, gbc_panelMandelbrotGraphic);
		
		// create gridbag layout
		GridBagLayout gbl_panelMandelbrotGraphic = new GridBagLayout();
		
		// define gridbag layout for greyscale mandelbrot container panel
		gbl_panelMandelbrotGraphic.columnWidths = new int[]{0};
		gbl_panelMandelbrotGraphic.rowHeights = new int[]{0};
		gbl_panelMandelbrotGraphic.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelMandelbrotGraphic.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		
		// set layout to parent panel for greyscale annulus image
		panelMandelbrotGraphic.setLayout(gbl_panelMandelbrotGraphic);
		
		// create gridbag constraints for the image itself
		gbc_imageMandelbrot = new GridBagConstraints();
		gbc_imageMandelbrot.gridx = 0;
		gbc_imageMandelbrot.gridy = 0;
	}
	
	/**
	 * This method returns user input for outer radius
	 * from the view, parse as double.
	 * 
	 * @param args unused
	 * @return double - Outer radius.
	 */
	public double getOutRadius() {
		return Double.parseDouble(fieldOutRadius.getText());
	}
	
	/**
	 * This method returns user input for inner radius
	 * from the view, parse as double.
	 * 
	 * @param args unused
	 * @return double - Inner radius.
	 */
	public double getInRadius() {
		return Double.parseDouble(fieldInRadius.getText());
	}
	
	/**
	 * This method returns the approx area result
	 * from the view, parse as double.
	 * 
	 * @param args unused
	 * @return double - Area of annulus.
	 */
	public double getAnnulusAreaCalc() {
		return Double.parseDouble(resultAnnulusApproxArea.getText());
	}
	
	/**
	 * This method sets the approx area result to the view
	 * from the controller, parse as String.
	 * 
	 * @param double area.
	 */
	public void setAnnulusAreaCalc(double area) {
		resultAnnulusApproxArea.setText(Double.toString(area));
	}
	
	/**
	 * This method sets the monte carlo result to the view
	 * from the controller, parse as String.
	 * 
	 * @param double area.
	 */
	public void setAnnulusMonteCalc(double area) {
		resultAnnulusMonteArea.setText(Double.toString(area));
	}
	
	/**
	 * This method sets the monte carlo result to the view
	 * from the controller, parse as String.
	 * 
	 * @param double area.
	 */
	public void setMandMonteCalc(double area) {
		resultMandMonteArea.setText(Double.toString(area));
	}
	
	/**
	 * This method adds an action listener for the calculate button.
	 * 
	 * @param theListener.
	 */
	public void addAnnulusCalcListener(ActionListener theListener) {
		buttonCalcAnnulus.addActionListener(theListener);
	}
	
	/**
	 * This method adds an action listener for the view button.
	 * 
	 * @param theListener.
	 */
	public void addMandelbrotCalcListener(ActionListener theListener) {
		buttonMandOK.addActionListener(theListener);
	}
	
	/**
	 * This method displays an error message for incorrect user input,
	 * as JOptionPane window.
	 * 
	 * @param String errorMessage.
	 */
	public void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage, "Error", JOptionPane.ERROR_MESSAGE);
	}
}
