package rewrite.view;

import javax.swing.JButton;

public class CalculatorView {
	
	private CalculatorFrame theFrame;
	private PanelGridLayout panelLeft;
	private PanelGridLayout panelRight;
	private PanelGridBagLayout panelAnnulusCalc;
	private PanelGridBagLayout panelAnnulusBorder;

	public CalculatorView() {
		
		// create frame
		this.theFrame = new CalculatorFrame();
		
		// create panelLeft
		this.panelLeft = new PanelGridLayout(this.theFrame, 2, 1, 20, 5);
		
		// add panelAnnulusCalc to panelLeft
		this.panelLeft.add(this.panelAnnulusCalc = new PanelGridBagLayout());
		
		//this.theFrame.getContentPane().add(panelAnnulusCalc);
		
		// **DEBUGGING**
		JButton test = new JButton ("test");
		this.panelAnnulusCalc.add(test);
		
		// add panelMandelbrotCalc to panelLeft
		this.panelLeft.add(this.panelAnnulusBorder = new PanelGridBagLayout("Annulus calculator", 20, 20, 10, 0, 0, 0));
		
		// create panelRight
		//this.panelRight = new PanelGridLayout(this.theFrame, 2, 1, 20, 5);
	}
}
