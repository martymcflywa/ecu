package rewrite.view;

// for debugging only
import java.awt.Color;


// import gui component classes
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
	private PanelGridLayout panelMandelbrotImage;
	
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
	
	// declare annulus calculator user controls
	private CalculatorTextField textFieldAnnulusOutRadius;
	private CalculatorTextField textFieldAnnulusInRadius;
	private CalculatorButton buttonAnnulusCalculate;
	private CalculatorButton buttonAnnulusSave;
	
	/**
	 * The CalculatorView constructor.
	 * 
	 * @param args unused
	 */
	public CalculatorView() {
		
		// create the frame and panels
		initFrame();
		
		// create the labels
		initLabels();
		
		// create the user input controls
		initControls();
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
		this.panelRight.add(this.panelAnnulusImage = new HitViewerGreyscale(444, 444, 0, 1, 0, 0));
		
		// create panelMandelbrotImage container and add to panelRight
		this.panelRight.add(this.panelMandelbrotImage = new PanelGridLayout(0, 1, 0, 0));
	}
	
	/**
	 * This method initializes the labels of the view.
	 * 
	 * @param args unused
	 */
	private final void initLabels() {
		
		/*
		 * Create annulus calculator labels
		 */
		
		// create labelAnnulusCalcInstructions
		this.labelAnnulusCalcInstructions = new CalculatorLabel("Enter the outer and inner radius.", "west", 8, 0, 40, 5, 5, 0, 1);

		// create labelAnnulusOutRadius
		this.labelAnnulusOutRadius = new CalculatorLabel("Outer radius:", "west", 1, 0, 40, 5, 5, 0, 3);

		// create labelAnnulusInRadius
		this.labelAnnulusInRadius = new CalculatorLabel("Inner radius:", "west", 1, 0, 40, 5, 5, 0, 4);
		
		// create labelAnnulusApproxTitle
		this.labelAnnulusApproxTitle = new CalculatorLabel("Approximate area:", "west", 2, 0, 40, 5, 5, 0, 7);
		
		// create labelAnnulusApproxOutput
		this.labelAnnulusApproxOutput = new CalculatorLabel("---", "none", 5, 0, 0, 5, 0, 0, 8);
		
		// create labelAnnulusMonteTitle
		this.labelAnnulusMonteTitle = new CalculatorLabel("Monte Carlo estimate:", "west", 2, 0, 40, 5, 5, 0, 9);
		
		// create labelAnnulusMonteOutput
		this.labelAnnulusMonteOutput = new CalculatorLabel("---", "none", 5, 0, 0, 5, 0, 0, 10);
		
		/*
		 * Add annulus calculator labels to container panel
		 */
		
		// add labelAnnulusCalcInstructions to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusCalcInstructions, this.labelAnnulusCalcInstructions.gbc_label);
		
		// add labelAnnulusOutRadius to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusOutRadius, this.labelAnnulusOutRadius.gbc_label);
		
		// add labelAnnulusInRadius to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusInRadius, this.labelAnnulusInRadius.gbc_label);
		
		// add labelAnnulusApproxTitle to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusApproxTitle, this.labelAnnulusApproxTitle.gbc_label);
		
		// add labelAnnulusApproxOutput to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusApproxOutput, this.labelAnnulusApproxOutput.gbc_label);
		
		// add labelAnnulusMonteTitle to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusMonteTitle, this.labelAnnulusMonteTitle.gbc_label);
		
		// add labelAnnulusMonteOutput to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusMonteOutput, this.labelAnnulusMonteOutput.gbc_label);
	}
	
	/**
	 * This method initializes the user input controls for the view.
	 * 
	 * @param args unused
	 */
	private final void initControls() {
		
		/*
		 * Create annulus calculator controls
		 */
		
		this.textFieldAnnulusOutRadius = new CalculatorTextField(200, 1, 3);
		
		this.textFieldAnnulusInRadius = new CalculatorTextField(200, 1, 4);
		
		this.buttonAnnulusCalculate = new CalculatorButton("Calculate", 1, 5);
		
		/*
		 * Add annulus calculator controls to container panel
		 */
		
		this.panelAnnulusBorder.add(textFieldAnnulusOutRadius, this.textFieldAnnulusOutRadius.gbc_textField);
		
		this.panelAnnulusBorder.add(textFieldAnnulusInRadius, this.textFieldAnnulusInRadius.gbc_textField);
		
		this.panelAnnulusBorder.add(this.buttonAnnulusCalculate, this.buttonAnnulusCalculate.gbc_button);
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
}
