package rewrite.view;

// for debugging only
import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

// import gui component classes
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

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
	private PanelGridLayout panelAnnulusImage;
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
	

	/**
	 * The CalculatorView constructor.
	 * 
	 * @param args unused
	 */
	public CalculatorView() {
		
		// call initView to display the frame and panels
		initFrame();
		initLabels();
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
		this.panelRight.add(this.panelAnnulusImage = new PanelGridLayout(0, 1, 0, 0));
		
		// create panelMandelbrotImage container and add to panelRight
		this.panelRight.add(this.panelMandelbrotImage = new PanelGridLayout(0, 1, 0, 0));
		
		// **DEBUG**
		this.panelAnnulusImage.setBackground(Color.ORANGE);
		this.panelMandelbrotImage.setBackground(Color.ORANGE);
	}
	
	/**
	 * This method initializes the user controls of the view.
	 * 
	 * @param args unused
	 */
	private final void initLabels() {
		
		/*
		 * Create labels
		 */
		
		// create labelAnnulusCalcInstructions
		this.labelAnnulusCalcInstructions = new CalculatorLabel("Enter the outer and inner radius.", "west", 2, 0, 40, 5, 5, 0, 1);

		// create labelAnnulusOutRadius
		this.labelAnnulusOutRadius = new CalculatorLabel("Outer radius:", "west", 1, 0, 40, 5, 5, 0, 3);

		// create labelAnnulusInRadius
		this.labelAnnulusInRadius = new CalculatorLabel("Inner radius:", "west", 1, 0, 40, 5, 5, 0, 4);
		
		// create labelAnnulusApproxTitle
		this.labelAnnulusApproxTitle = new CalculatorLabel("Approximate area:", "west", 2, 0, 40, 5, 5, 0, 6);
		
		// create labelAnnulusApproxOutput
		this.labelAnnulusApproxOutput = new CalculatorLabel("---", "none", 5, 0, 0, 5, 0, 0, 7);
		
		// create labelAnnulusMonteTitle
		this.labelAnnulusMonteTitle = new CalculatorLabel("Monte Carlo estimate:", "west", 2, 0, 40, 5, 5, 0, 8);
		
		// create labelAnnulusMonteOutput
		this.labelAnnulusMonteOutput = new CalculatorLabel("---", "none", 5, 0, 0, 5, 0, 0, 9);
		
		/*
		 * Add labels to container panel
		 */
		
		// add labelAnnulusCalcInstructions to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusCalcInstructions.theLabel, this.labelAnnulusCalcInstructions.gbc_label);
		
		// add labelAnnulusOutRadius to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusOutRadius.theLabel, this.labelAnnulusOutRadius.gbc_label);
		
		// add labelAnnulusInRadius to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusInRadius.theLabel, this.labelAnnulusInRadius.gbc_label);
		
		// add labelAnnulusApproxTitle to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusApproxTitle.theLabel, this.labelAnnulusApproxTitle.gbc_label);
		
		// add labelAnnulusApproxOutput to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusApproxOutput.theLabel, this.labelAnnulusApproxOutput.gbc_label);
		
		// add labelAnnulusMonteTitle to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusMonteTitle.theLabel, this.labelAnnulusMonteTitle.gbc_label);
		
		// add labelAnnulusMonteOutput to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusMonteOutput.theLabel, this.labelAnnulusMonteOutput.gbc_label);
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
