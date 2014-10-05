package rewrite.view;

import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class CalculatorView extends JFrame {
	
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
		this.panelAnnulusCalc = new PanelGridBagLayout(this.theFrame, this.panelLeft);
		this.panelAnnulusBorder = new PanelGridBagLayout(this.theFrame, this.panelAnnulusCalc, "Annulus calculator", 20, 20, 10, 0, 0, 0);
		
		//this.theFrame.getContentPane().add(panelAnnulusBorder);
		
		//this.theFrame.getContentPane().add(panelAnnulusCalc);
		
		// **DEBUGGING**
		//JButton test = new JButton ("test");
		//this.panelAnnulusBorder.add(test);
		
		// add panelMandelbrotCalc to panelLeft
		
		
		// create panelRight
		//this.panelRight = new PanelGridLayout(this.theFrame, 2, 1, 20, 5);
	}
}
