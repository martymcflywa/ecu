package csp1150.assignment1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class CalculatorGUI {

	private JFrame frame;
	private JTextField fieldOutRadius;
	private JTextField fieldInRadius;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CalculatorGUI window = new CalculatorGUI();
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
	public CalculatorGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 800, 900);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{300, 0, 0};
		gridBagLayout.rowHeights = new int[]{456, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		frame.getContentPane().setLayout(gridBagLayout);
		
		JPanel panelParentLeft = new JPanel();
		GridBagConstraints gbc_panelParentLeft = new GridBagConstraints();
		gbc_panelParentLeft.gridheight = 2;
		gbc_panelParentLeft.insets = new Insets(0, 0, 5, 5);
		gbc_panelParentLeft.fill = GridBagConstraints.BOTH;
		gbc_panelParentLeft.gridx = 0;
		gbc_panelParentLeft.gridy = 0;
		frame.getContentPane().add(panelParentLeft, gbc_panelParentLeft);
		GridBagLayout gbl_panelParentLeft = new GridBagLayout();
		gbl_panelParentLeft.columnWidths = new int[]{283, 0};
		gbl_panelParentLeft.rowHeights = new int[]{300, 0};
		gbl_panelParentLeft.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelParentLeft.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelParentLeft.setLayout(gbl_panelParentLeft);
		
		JPanel panelAnnulus = new JPanel();
		GridBagConstraints gbc_panelAnnulus = new GridBagConstraints();
		gbc_panelAnnulus.fill = GridBagConstraints.BOTH;
		gbc_panelAnnulus.gridx = 0;
		gbc_panelAnnulus.gridy = 0;
		panelParentLeft.add(panelAnnulus, gbc_panelAnnulus);
		GridBagLayout gbl_panelAnnulus = new GridBagLayout();
		gbl_panelAnnulus.columnWidths = new int[]{0, 0};
		gbl_panelAnnulus.rowHeights = new int[]{391, 0};
		gbl_panelAnnulus.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panelAnnulus.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		panelAnnulus.setLayout(gbl_panelAnnulus);
		
		JPanel borderAnnulus = new JPanel();
		borderAnnulus.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Annulus Calculator", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_borderAnnulus = new GridBagConstraints();
		gbc_borderAnnulus.insets = new Insets(15, 15, 0, 0);
		gbc_borderAnnulus.anchor = GridBagConstraints.WEST;
		gbc_borderAnnulus.fill = GridBagConstraints.VERTICAL;
		gbc_borderAnnulus.gridx = 0;
		gbc_borderAnnulus.gridy = 0;
		panelAnnulus.add(borderAnnulus, gbc_borderAnnulus);
		GridBagLayout gbl_borderAnnulus = new GridBagLayout();
		gbl_borderAnnulus.columnWidths = new int[]{63, 22, 39, 47, 77, 0};
		gbl_borderAnnulus.rowHeights = new int[]{44, 20, 23, 31, 14, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
		gbl_borderAnnulus.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_borderAnnulus.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		borderAnnulus.setLayout(gbl_borderAnnulus);
		
		JLabel labelAnnulusInstructions = new JLabel("Enter the outer and inner radius:");
		GridBagConstraints gbc_labelAnnulusInstructions = new GridBagConstraints();
		gbc_labelAnnulusInstructions.fill = GridBagConstraints.BOTH;
		gbc_labelAnnulusInstructions.insets = new Insets(0, 15, 5, 5);
		gbc_labelAnnulusInstructions.gridwidth = 5;
		gbc_labelAnnulusInstructions.gridx = 0;
		gbc_labelAnnulusInstructions.gridy = 0;
		borderAnnulus.add(labelAnnulusInstructions, gbc_labelAnnulusInstructions);
		
		JLabel labelOutRadius = new JLabel("Outer Radius");
		GridBagConstraints gbc_labelOutRadius = new GridBagConstraints();
		gbc_labelOutRadius.anchor = GridBagConstraints.WEST;
		gbc_labelOutRadius.insets = new Insets(0, 15, 5, 5);
		gbc_labelOutRadius.gridx = 0;
		gbc_labelOutRadius.gridy = 1;
		borderAnnulus.add(labelOutRadius, gbc_labelOutRadius);
		
		fieldOutRadius = new JTextField();
		GridBagConstraints gbc_fieldOutRadius = new GridBagConstraints();
		gbc_fieldOutRadius.anchor = GridBagConstraints.NORTH;
		gbc_fieldOutRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldOutRadius.insets = new Insets(0, 0, 5, 5);
		gbc_fieldOutRadius.gridwidth = 3;
		gbc_fieldOutRadius.gridx = 1;
		gbc_fieldOutRadius.gridy = 1;
		borderAnnulus.add(fieldOutRadius, gbc_fieldOutRadius);
		fieldOutRadius.setColumns(10);
		
		JLabel labelInRadius = new JLabel("Inner Radius");
		GridBagConstraints gbc_labelInRadius = new GridBagConstraints();
		gbc_labelInRadius.anchor = GridBagConstraints.WEST;
		gbc_labelInRadius.insets = new Insets(0, 15, 5, 5);
		gbc_labelInRadius.gridx = 0;
		gbc_labelInRadius.gridy = 2;
		borderAnnulus.add(labelInRadius, gbc_labelInRadius);
		
		fieldInRadius = new JTextField();
		GridBagConstraints gbc_fieldInRadius = new GridBagConstraints();
		gbc_fieldInRadius.fill = GridBagConstraints.HORIZONTAL;
		gbc_fieldInRadius.insets = new Insets(0, 0, 5, 5);
		gbc_fieldInRadius.gridwidth = 3;
		gbc_fieldInRadius.gridx = 1;
		gbc_fieldInRadius.gridy = 2;
		borderAnnulus.add(fieldInRadius, gbc_fieldInRadius);
		fieldInRadius.setColumns(10);
		
		JButton buttonCalcAnnulus = new JButton("Calculate");
		GridBagConstraints gbc_buttonCalcAnnulus = new GridBagConstraints();
		gbc_buttonCalcAnnulus.anchor = GridBagConstraints.EAST;
		gbc_buttonCalcAnnulus.gridwidth = 3;
		gbc_buttonCalcAnnulus.insets = new Insets(0, 0, 5, 5);
		gbc_buttonCalcAnnulus.gridx = 1;
		gbc_buttonCalcAnnulus.gridy = 3;
		borderAnnulus.add(buttonCalcAnnulus, gbc_buttonCalcAnnulus);
		
		JLabel labelApproxArea = new JLabel("Approximate Area:");
		GridBagConstraints gbc_labelApproxArea = new GridBagConstraints();
		gbc_labelApproxArea.anchor = GridBagConstraints.WEST;
		gbc_labelApproxArea.insets = new Insets(0, 15, 5, 5);
		gbc_labelApproxArea.gridwidth = 2;
		gbc_labelApproxArea.gridx = 0;
		gbc_labelApproxArea.gridy = 4;
		borderAnnulus.add(labelApproxArea, gbc_labelApproxArea);
		
		JLabel approxAreaResult = new JLabel("---");
		GridBagConstraints gbc_approxAreaResult = new GridBagConstraints();
		gbc_approxAreaResult.gridwidth = 5;
		gbc_approxAreaResult.insets = new Insets(0, 0, 5, 5);
		gbc_approxAreaResult.gridx = 0;
		gbc_approxAreaResult.gridy = 5;
		borderAnnulus.add(approxAreaResult, gbc_approxAreaResult);
		
		JLabel labelMonteArea = new JLabel("Monte Carlo Estimation:");
		GridBagConstraints gbc_labelMonteArea = new GridBagConstraints();
		gbc_labelMonteArea.insets = new Insets(0, 15, 5, 5);
		gbc_labelMonteArea.anchor = GridBagConstraints.NORTH;
		gbc_labelMonteArea.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelMonteArea.gridwidth = 5;
		gbc_labelMonteArea.gridx = 0;
		gbc_labelMonteArea.gridy = 7;
		borderAnnulus.add(labelMonteArea, gbc_labelMonteArea);
		
		JLabel monteAreaResult = new JLabel("---");
		GridBagConstraints gbc_monteAreaResult = new GridBagConstraints();
		gbc_monteAreaResult.insets = new Insets(0, 0, 5, 0);
		gbc_monteAreaResult.gridwidth = 6;
		gbc_monteAreaResult.anchor = GridBagConstraints.NORTH;
		gbc_monteAreaResult.gridx = 0;
		gbc_monteAreaResult.gridy = 8;
		borderAnnulus.add(monteAreaResult, gbc_monteAreaResult);
		
		JLabel labelAnnulusImageInstructionsA = new JLabel("Left click and drag on annulus image to zoom in,");
		GridBagConstraints gbc_labelAnnulusImageInstructionsA = new GridBagConstraints();
		gbc_labelAnnulusImageInstructionsA.anchor = GridBagConstraints.WEST;
		gbc_labelAnnulusImageInstructionsA.gridwidth = 5;
		gbc_labelAnnulusImageInstructionsA.insets = new Insets(0, 15, 5, 5);
		gbc_labelAnnulusImageInstructionsA.gridx = 0;
		gbc_labelAnnulusImageInstructionsA.gridy = 10;
		borderAnnulus.add(labelAnnulusImageInstructionsA, gbc_labelAnnulusImageInstructionsA);
		
		JLabel lblRightClickTo = new JLabel("Right click to zoom out to original size.");
		GridBagConstraints gbc_lblRightClickTo = new GridBagConstraints();
		gbc_lblRightClickTo.anchor = GridBagConstraints.WEST;
		gbc_lblRightClickTo.gridwidth = 5;
		gbc_lblRightClickTo.insets = new Insets(0, 15, 5, 5);
		gbc_lblRightClickTo.gridx = 0;
		gbc_lblRightClickTo.gridy = 11;
		borderAnnulus.add(lblRightClickTo, gbc_lblRightClickTo);
		
		JCheckBox cbSaveAnnulusImage = new JCheckBox("Save Image");
		GridBagConstraints gbc_cbSaveAnnulusImage = new GridBagConstraints();
		gbc_cbSaveAnnulusImage.gridwidth = 2;
		gbc_cbSaveAnnulusImage.insets = new Insets(0, 0, 5, 5);
		gbc_cbSaveAnnulusImage.gridx = 0;
		gbc_cbSaveAnnulusImage.gridy = 13;
		borderAnnulus.add(cbSaveAnnulusImage, gbc_cbSaveAnnulusImage);
		
		JButton buttonSaveAnnulusImage = new JButton("Save");
		buttonSaveAnnulusImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_buttonSaveAnnulusImage = new GridBagConstraints();
		gbc_buttonSaveAnnulusImage.anchor = GridBagConstraints.EAST;
		gbc_buttonSaveAnnulusImage.gridwidth = 2;
		gbc_buttonSaveAnnulusImage.insets = new Insets(0, 0, 5, 5);
		gbc_buttonSaveAnnulusImage.gridx = 2;
		gbc_buttonSaveAnnulusImage.gridy = 13;
		borderAnnulus.add(buttonSaveAnnulusImage, gbc_buttonSaveAnnulusImage);
		
		JPanel panelParentRight = new JPanel();
		GridBagConstraints gbc_panelParentRight = new GridBagConstraints();
		gbc_panelParentRight.gridheight = 2;
		gbc_panelParentRight.insets = new Insets(0, 0, 5, 0);
		gbc_panelParentRight.fill = GridBagConstraints.BOTH;
		gbc_panelParentRight.gridx = 1;
		gbc_panelParentRight.gridy = 0;
		frame.getContentPane().add(panelParentRight, gbc_panelParentRight);
		GridBagLayout gbl_panelParentRight = new GridBagLayout();
		gbl_panelParentRight.columnWidths = new int[]{0, 0};
		gbl_panelParentRight.rowHeights = new int[]{0, 0, 0};
		gbl_panelParentRight.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelParentRight.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panelParentRight.setLayout(gbl_panelParentRight);
		
		JPanel panelAnnulusGraphic = new JPanel();
		GridBagConstraints gbc_panelAnnulusGraphic = new GridBagConstraints();
		gbc_panelAnnulusGraphic.insets = new Insets(0, 0, 5, 0);
		gbc_panelAnnulusGraphic.fill = GridBagConstraints.BOTH;
		gbc_panelAnnulusGraphic.gridx = 0;
		gbc_panelAnnulusGraphic.gridy = 0;
		panelParentRight.add(panelAnnulusGraphic, gbc_panelAnnulusGraphic);
		GridBagLayout gbl_panelAnnulusGraphic = new GridBagLayout();
		gbl_panelAnnulusGraphic.columnWidths = new int[]{0, 0};
		gbl_panelAnnulusGraphic.rowHeights = new int[]{0, 0};
		gbl_panelAnnulusGraphic.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelAnnulusGraphic.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelAnnulusGraphic.setLayout(gbl_panelAnnulusGraphic);
		
		JButton greyScaleAnnulus = new JButton("New button");
		GridBagConstraints gbc_greyScaleAnnulus = new GridBagConstraints();
		gbc_greyScaleAnnulus.fill = GridBagConstraints.BOTH;
		gbc_greyScaleAnnulus.gridx = 0;
		gbc_greyScaleAnnulus.gridy = 0;
		panelAnnulusGraphic.add(greyScaleAnnulus, gbc_greyScaleAnnulus);
		
		JPanel panelMandelbrotGraphic = new JPanel();
		GridBagConstraints gbc_panelMandelbrotGraphic = new GridBagConstraints();
		gbc_panelMandelbrotGraphic.fill = GridBagConstraints.BOTH;
		gbc_panelMandelbrotGraphic.gridx = 0;
		gbc_panelMandelbrotGraphic.gridy = 1;
		panelParentRight.add(panelMandelbrotGraphic, gbc_panelMandelbrotGraphic);
	}

}
