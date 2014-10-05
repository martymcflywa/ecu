package rewrite.view;

// for debugging only
import java.awt.Color;

import java.awt.GridBagConstraints;
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
	 */
	public CalculatorView() {
		
		// call initView to display the frame and panels
		initView();
		initLabels();
	}
	
	/**
	 * This method initializes the frames and panels of the view.
	 * 
	 * @param args unused
	 */
	private final void initView() {
		
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
		
		// **might still need this, if panelAnnulusBorder.gbc_panel is still null** 
		//this.panelAnnulusBorder = new PanelGridBagLayout(20, 20, 10, 0, 0, 0);

		// create panelAnnulusBorder (use overloading constructor) and add to panelAnnulusCalc
		this.panelAnnulusCalc.add(this.panelAnnulusBorder = new PanelGridBagLayout(20, 20, 10, 0, 0, 0), this.panelAnnulusBorder.gbc_panel);
		
		// add titled border to panelAnnulusBorder
		addBorder(this.panelAnnulusBorder, "Annulus Calculator");
		
		// add panelAnnulusBorder to panelAnnulusCalc container with its constraints
		this.panelAnnulusCalc.add(this.panelAnnulusBorder, this.panelAnnulusBorder.gbc_panel);
		
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
	 */
	private final void initLabels() {
		
		// create labelAnnulusCalcInstructions
		this.labelAnnulusCalcInstructions = new CalculatorLabel("Enter the outer and inner radius.", "west", 2, 20, 40, 5, 5, 0, 0);
		
		// add labelAnnulusCalcInstructions to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusCalcInstructions.getLabel(), this.labelAnnulusCalcInstructions.gbc_label);
		
		// create labelAnnulusOutRadius
		this.labelAnnulusOutRadius = new CalculatorLabel("Outer radius:", "west", 1, 20, 40, 5, 5, 0, 2);
		
		// add labelAnnulusOutRadius to panelAnnulusBorder
		this.panelAnnulusBorder.add(this.labelAnnulusOutRadius.getLabel(), this.labelAnnulusOutRadius.gbc_label);
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
