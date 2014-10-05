package rewrite.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class CalculatorView extends JFrame {
	
	private CalculatorFrame theFrame;
	//private PanelGridLayout panelLeft;
	private PanelGridLayout panelRight;
	private PanelGridBagLayout panelAnnulusCalc;
	private PanelGridBagLayout panelAnnulusBorder;

	public CalculatorView() {
		
		// create frame
		this.theFrame = new CalculatorFrame();
		
//		// create panelLeft
//		this.panelLeft = new PanelGridLayout(this.theFrame, 2, 1, 20, 5);
//		
//		// create panelRight
//		this.panelRight = new PanelGridLayout(this.theFrame, 2, 1, 20, 5);
//		
//		this.panelLeft.add(this.panelAnnulusCalc = new PanelGridBagLayout(this.theFrame, this.panelLeft));
		
		JPanel panelLeft = new JPanel();
		panelLeft.setBackground(Color.WHITE);
		panelLeft.setLayout(new GridLayout(2, 1, 20, 5));
		this.theFrame.getContentPane().add(panelLeft);
		
		JPanel panelRight = new JPanel();
		panelRight.setBackground(Color.WHITE);
		panelRight.setLayout(new GridLayout(2, 1, 20, 5));
		this.theFrame.getContentPane().add(panelRight);
		
		JPanel panelAnnulusCalc = new JPanel();
		panelAnnulusCalc.setBackground(Color.ORANGE);
		panelLeft.add(panelAnnulusCalc);
		GridBagLayout gbl_panelAnnulusCalc = new GridBagLayout();
		gbl_panelAnnulusCalc.columnWidths = new int[]{0, 0};
		gbl_panelAnnulusCalc.rowHeights = new int[]{0, 0};
		gbl_panelAnnulusCalc.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelAnnulusCalc.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelAnnulusCalc.setLayout(gbl_panelAnnulusCalc);
		
		JPanel panelAnnulusBorder = new JPanel();
		panelAnnulusBorder.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Annulus Calculator", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelAnnulusBorder = new GridBagConstraints();
		gbc_panelAnnulusBorder.insets = new Insets(20, 20, 10, 0);
		gbc_panelAnnulusBorder.fill = GridBagConstraints.BOTH;
		gbc_panelAnnulusBorder.gridx = 0;
		gbc_panelAnnulusBorder.gridy = 0;
		panelAnnulusCalc.add(panelAnnulusBorder, gbc_panelAnnulusBorder);
		GridBagLayout gbl_panelAnnulusBorder = new GridBagLayout();
		gbl_panelAnnulusBorder.columnWidths = new int[]{0, 0, 0, 0, 0};
		gbl_panelAnnulusBorder.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panelAnnulusBorder.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelAnnulusBorder.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panelAnnulusBorder.setLayout(gbl_panelAnnulusBorder);
		
		
		JPanel panelMandelbrotCalc = new JPanel();
		panelMandelbrotCalc.setBackground(Color.ORANGE);
		panelLeft.add(panelMandelbrotCalc);
		
		JPanel panelAnnulusImage = new JPanel();
		panelAnnulusImage.setBackground(Color.ORANGE);
		panelRight.add(panelAnnulusImage);
		
		JPanel panelMandelbrotImage = new JPanel();
		panelMandelbrotImage.setBackground(Color.ORANGE);
		panelRight.add(panelMandelbrotImage);
	}
}
