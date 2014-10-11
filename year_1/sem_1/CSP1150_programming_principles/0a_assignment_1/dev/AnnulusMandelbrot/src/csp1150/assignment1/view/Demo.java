package csp1150.assignment1.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JCheckBox;

public class Demo {

	private JFrame frame;
	private JTextField textFieldAnnulusOutRadius;
	private JTextField textFieldAnnulusInRadius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Demo window = new Demo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Demo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(100, 100, 900, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.getContentPane().setLayout(new GridLayout(0, 2, 5, 5));
		
		JPanel panelLeft = new JPanel();
		frame.getContentPane().add(panelLeft);
		panelLeft.setLayout(new GridLayout(2, 1, 20, 5));
		
		JPanel panelAnnulusCalc = new JPanel();
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
		
		JLabel labelAnnulusCalcInstructions = new JLabel("Enter the outer and inner radius.");
		GridBagConstraints gbc_labelAnnulusCalcInstructions = new GridBagConstraints();
		gbc_labelAnnulusCalcInstructions.gridwidth = 2;
		gbc_labelAnnulusCalcInstructions.anchor = GridBagConstraints.WEST;
		gbc_labelAnnulusCalcInstructions.insets = new Insets(20, 40, 5, 5);
		gbc_labelAnnulusCalcInstructions.gridx = 0;
		gbc_labelAnnulusCalcInstructions.gridy = 0;
		panelAnnulusBorder.add(labelAnnulusCalcInstructions, gbc_labelAnnulusCalcInstructions);
		
		JLabel labelAnnulusOutRadius = new JLabel("Outer radius:");
		GridBagConstraints gbc_labelAnnulusOutRadius = new GridBagConstraints();
		gbc_labelAnnulusOutRadius.insets = new Insets(0, 40, 5, 5);
		gbc_labelAnnulusOutRadius.anchor = GridBagConstraints.WEST;
		gbc_labelAnnulusOutRadius.gridx = 0;
		gbc_labelAnnulusOutRadius.gridy = 2;
		panelAnnulusBorder.add(labelAnnulusOutRadius, gbc_labelAnnulusOutRadius);
		
		textFieldAnnulusOutRadius = new JTextField();
		GridBagConstraints gbc_textFieldAnnulusOutRadius = new GridBagConstraints();
		gbc_textFieldAnnulusOutRadius.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAnnulusOutRadius.anchor = GridBagConstraints.WEST;
		gbc_textFieldAnnulusOutRadius.gridx = 1;
		gbc_textFieldAnnulusOutRadius.gridy = 2;
		panelAnnulusBorder.add(textFieldAnnulusOutRadius, gbc_textFieldAnnulusOutRadius);
		textFieldAnnulusOutRadius.setColumns(10);
		
		JLabel labelAnnulusInRadius = new JLabel("Inner Radius:");
		GridBagConstraints gbc_labelAnnulusInRadius = new GridBagConstraints();
		gbc_labelAnnulusInRadius.anchor = GridBagConstraints.WEST;
		gbc_labelAnnulusInRadius.insets = new Insets(0, 40, 5, 5);
		gbc_labelAnnulusInRadius.gridx = 0;
		gbc_labelAnnulusInRadius.gridy = 3;
		panelAnnulusBorder.add(labelAnnulusInRadius, gbc_labelAnnulusInRadius);
		
		textFieldAnnulusInRadius = new JTextField();
		GridBagConstraints gbc_textFieldAnnulusInRadius = new GridBagConstraints();
		gbc_textFieldAnnulusInRadius.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldAnnulusInRadius.anchor = GridBagConstraints.WEST;
		gbc_textFieldAnnulusInRadius.gridx = 1;
		gbc_textFieldAnnulusInRadius.gridy = 3;
		panelAnnulusBorder.add(textFieldAnnulusInRadius, gbc_textFieldAnnulusInRadius);
		textFieldAnnulusInRadius.setColumns(10);
		
		JButton buttonAnnulusCalculate = new JButton("Calculate");
		GridBagConstraints gbc_buttonAnnulusCalculate = new GridBagConstraints();
		gbc_buttonAnnulusCalculate.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAnnulusCalculate.anchor = GridBagConstraints.WEST;
		gbc_buttonAnnulusCalculate.gridx = 1;
		gbc_buttonAnnulusCalculate.gridy = 4;
		panelAnnulusBorder.add(buttonAnnulusCalculate, gbc_buttonAnnulusCalculate);
		
		JCheckBox checkboxAnnulusRandomColour = new JCheckBox("Random colour");
		GridBagConstraints gbc_checkboxAnnulusRandomColour = new GridBagConstraints();
		gbc_checkboxAnnulusRandomColour.insets = new Insets(0, 0, 5, 5);
		gbc_checkboxAnnulusRandomColour.gridx = 2;
		gbc_checkboxAnnulusRandomColour.gridy = 4;
		panelAnnulusBorder.add(checkboxAnnulusRandomColour, gbc_checkboxAnnulusRandomColour);
		
		JLabel labelAnnulusApproxTitle = new JLabel("Approximate area:");
		GridBagConstraints gbc_labelAnnulusApproxTitle = new GridBagConstraints();
		gbc_labelAnnulusApproxTitle.anchor = GridBagConstraints.WEST;
		gbc_labelAnnulusApproxTitle.gridwidth = 2;
		gbc_labelAnnulusApproxTitle.insets = new Insets(0, 40, 5, 5);
		gbc_labelAnnulusApproxTitle.gridx = 0;
		gbc_labelAnnulusApproxTitle.gridy = 6;
		panelAnnulusBorder.add(labelAnnulusApproxTitle, gbc_labelAnnulusApproxTitle);
		
		JLabel labelAnnulusApproxOutput = new JLabel("---");
		GridBagConstraints gbc_labelAnnulusApproxOutput = new GridBagConstraints();
		gbc_labelAnnulusApproxOutput.gridwidth = 4;
		gbc_labelAnnulusApproxOutput.insets = new Insets(0, 40, 5, 0);
		gbc_labelAnnulusApproxOutput.gridx = 0;
		gbc_labelAnnulusApproxOutput.gridy = 7;
		panelAnnulusBorder.add(labelAnnulusApproxOutput, gbc_labelAnnulusApproxOutput);
		
		JLabel labelAnnulusMonteTitle = new JLabel("Monte Carlo estimate:");
		GridBagConstraints gbc_labelAnnulusMonteTitle = new GridBagConstraints();
		gbc_labelAnnulusMonteTitle.anchor = GridBagConstraints.WEST;
		gbc_labelAnnulusMonteTitle.gridwidth = 2;
		gbc_labelAnnulusMonteTitle.insets = new Insets(0, 40, 5, 5);
		gbc_labelAnnulusMonteTitle.gridx = 0;
		gbc_labelAnnulusMonteTitle.gridy = 9;
		panelAnnulusBorder.add(labelAnnulusMonteTitle, gbc_labelAnnulusMonteTitle);
		
		JLabel labelAnnulusMonteOutput = new JLabel("---");
		GridBagConstraints gbc_labelAnnulusMonteOutput = new GridBagConstraints();
		gbc_labelAnnulusMonteOutput.gridwidth = 4;
		gbc_labelAnnulusMonteOutput.insets = new Insets(0, 40, 5, 0);
		gbc_labelAnnulusMonteOutput.gridx = 0;
		gbc_labelAnnulusMonteOutput.gridy = 10;
		panelAnnulusBorder.add(labelAnnulusMonteOutput, gbc_labelAnnulusMonteOutput);
		
		JCheckBox cboxAnnulusSaveImage = new JCheckBox("Save image");
		GridBagConstraints gbc_cboxAnnulusSaveImage = new GridBagConstraints();
		gbc_cboxAnnulusSaveImage.insets = new Insets(0, 40, 5, 5);
		gbc_cboxAnnulusSaveImage.anchor = GridBagConstraints.WEST;
		gbc_cboxAnnulusSaveImage.gridx = 0;
		gbc_cboxAnnulusSaveImage.gridy = 12;
		panelAnnulusBorder.add(cboxAnnulusSaveImage, gbc_cboxAnnulusSaveImage);
		
		JButton buttonAnnulusSave = new JButton("Save");
		GridBagConstraints gbc_buttonAnnulusSave = new GridBagConstraints();
		gbc_buttonAnnulusSave.insets = new Insets(0, 0, 5, 5);
		gbc_buttonAnnulusSave.anchor = GridBagConstraints.WEST;
		gbc_buttonAnnulusSave.gridx = 1;
		gbc_buttonAnnulusSave.gridy = 12;
		panelAnnulusBorder.add(buttonAnnulusSave, gbc_buttonAnnulusSave);
		
		JLabel labelAnnulusZoom = new JLabel("Left click and drag on image to zoom in.");
		GridBagConstraints gbc_labelAnnulusZoom = new GridBagConstraints();
		gbc_labelAnnulusZoom.anchor = GridBagConstraints.WEST;
		gbc_labelAnnulusZoom.gridwidth = 3;
		gbc_labelAnnulusZoom.insets = new Insets(15, 40, 0, 5);
		gbc_labelAnnulusZoom.gridx = 0;
		gbc_labelAnnulusZoom.gridy = 13;
		panelAnnulusBorder.add(labelAnnulusZoom, gbc_labelAnnulusZoom);
		
		JPanel panelMandelbrotCalc = new JPanel();
		panelLeft.add(panelMandelbrotCalc);
		GridBagLayout gbl_panelMandelbrotCalc = new GridBagLayout();
		gbl_panelMandelbrotCalc.columnWidths = new int[]{0, 0};
		gbl_panelMandelbrotCalc.rowHeights = new int[]{0, 0};
		gbl_panelMandelbrotCalc.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelMandelbrotCalc.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelMandelbrotCalc.setLayout(gbl_panelMandelbrotCalc);
		
		JPanel panelMandelbrotBorder = new JPanel();
		panelMandelbrotBorder.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), "Mandelbrot Calculator", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GridBagConstraints gbc_panelMandelbrotBorder = new GridBagConstraints();
		gbc_panelMandelbrotBorder.insets = new Insets(10, 20, 10, 0);
		gbc_panelMandelbrotBorder.fill = GridBagConstraints.BOTH;
		gbc_panelMandelbrotBorder.gridx = 0;
		gbc_panelMandelbrotBorder.gridy = 0;
		panelMandelbrotCalc.add(panelMandelbrotBorder, gbc_panelMandelbrotBorder);
		
		JPanel panelRight = new JPanel();
		frame.getContentPane().add(panelRight);
		panelRight.setLayout(new GridLayout(2, 1, 20, 5));
		
		JPanel panelImageAnnulus = new JPanel();
		panelRight.add(panelImageAnnulus);
		panelImageAnnulus.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton imageAnnulus = new JButton("Annulus image");
		panelImageAnnulus.add(imageAnnulus);
		
		JPanel panelImageMandelbrot = new JPanel();
		panelRight.add(panelImageMandelbrot);
		panelImageMandelbrot.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton imageMandelbrot = new JButton("Mandelbrot Image");
		panelImageMandelbrot.add(imageMandelbrot);
	}

}
