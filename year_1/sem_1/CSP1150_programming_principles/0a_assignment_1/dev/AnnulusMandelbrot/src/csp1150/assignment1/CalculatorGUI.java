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
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class CalculatorGUI {

	private JFrame frame;
	private JTextField fieldOutRadius;
	private JTextField fieldInRadius;
	private final ButtonGroup buttonGroup = new ButtonGroup();

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
		gridBagLayout.rowHeights = new int[]{437, 0, 0};
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
		gbl_panelParentLeft.rowHeights = new int[]{300, 37, 0, 0};
		gbl_panelParentLeft.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelParentLeft.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panelParentLeft.setLayout(gbl_panelParentLeft);
		
		JPanel panelAnnulus = new JPanel();
		GridBagConstraints gbc_panelAnnulus = new GridBagConstraints();
		gbc_panelAnnulus.insets = new Insets(0, 0, 5, 0);
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
		
		JLabel labelAnnulusZoomInstructA = new JLabel("Left click and drag on annulus image to zoom in,");
		GridBagConstraints gbc_labelAnnulusZoomInstructA = new GridBagConstraints();
		gbc_labelAnnulusZoomInstructA.anchor = GridBagConstraints.WEST;
		gbc_labelAnnulusZoomInstructA.gridwidth = 5;
		gbc_labelAnnulusZoomInstructA.insets = new Insets(0, 15, 5, 5);
		gbc_labelAnnulusZoomInstructA.gridx = 0;
		gbc_labelAnnulusZoomInstructA.gridy = 10;
		borderAnnulus.add(labelAnnulusZoomInstructA, gbc_labelAnnulusZoomInstructA);
		
		JLabel labelAnnulusZoomInstructB = new JLabel("Right click to zoom out to original size.");
		GridBagConstraints gbc_labelAnnulusZoomInstructB = new GridBagConstraints();
		gbc_labelAnnulusZoomInstructB.anchor = GridBagConstraints.WEST;
		gbc_labelAnnulusZoomInstructB.gridwidth = 5;
		gbc_labelAnnulusZoomInstructB.insets = new Insets(0, 15, 5, 5);
		gbc_labelAnnulusZoomInstructB.gridx = 0;
		gbc_labelAnnulusZoomInstructB.gridy = 11;
		borderAnnulus.add(labelAnnulusZoomInstructB, gbc_labelAnnulusZoomInstructB);
		
		JCheckBox cboxSaveAnnulusImage = new JCheckBox("Save Image");
		GridBagConstraints gbc_cboxSaveAnnulusImage = new GridBagConstraints();
		gbc_cboxSaveAnnulusImage.gridwidth = 2;
		gbc_cboxSaveAnnulusImage.insets = new Insets(0, 0, 5, 5);
		gbc_cboxSaveAnnulusImage.gridx = 0;
		gbc_cboxSaveAnnulusImage.gridy = 13;
		borderAnnulus.add(cboxSaveAnnulusImage, gbc_cboxSaveAnnulusImage);
		
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
		
		JPanel panelMandelbrot = new JPanel();
		GridBagConstraints gbc_panelMandelbrot = new GridBagConstraints();
		gbc_panelMandelbrot.fill = GridBagConstraints.BOTH;
		gbc_panelMandelbrot.gridx = 0;
		gbc_panelMandelbrot.gridy = 2;
		panelParentLeft.add(panelMandelbrot, gbc_panelMandelbrot);
		GridBagLayout gbl_panelMandelbrot = new GridBagLayout();
		gbl_panelMandelbrot.columnWidths = new int[]{0, 0};
		gbl_panelMandelbrot.rowHeights = new int[]{0, 0};
		gbl_panelMandelbrot.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelMandelbrot.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelMandelbrot.setLayout(gbl_panelMandelbrot);
		
		JPanel borderMandelbrot = new JPanel();
		borderMandelbrot.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Mandelbrot Calculator", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		GridBagConstraints gbc_borderMandelbrot = new GridBagConstraints();
		gbc_borderMandelbrot.insets = new Insets(15, 15, 15, 0);
		gbc_borderMandelbrot.fill = GridBagConstraints.BOTH;
		gbc_borderMandelbrot.gridx = 0;
		gbc_borderMandelbrot.gridy = 0;
		panelMandelbrot.add(borderMandelbrot, gbc_borderMandelbrot);
		GridBagLayout gbl_borderMandelbrot = new GridBagLayout();
		gbl_borderMandelbrot.columnWidths = new int[]{57, 22, 28, 64, 77, -39, 0};
		gbl_borderMandelbrot.rowHeights = new int[]{44, 20, 23, 31, 14, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0};
		gbl_borderMandelbrot.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 4.9E-324, Double.MIN_VALUE};
		gbl_borderMandelbrot.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		borderMandelbrot.setLayout(gbl_borderMandelbrot);
		
		JLabel labelMandInstructA = new JLabel("What is a mandelbrot?");
		GridBagConstraints gbc_labelMandInstructA = new GridBagConstraints();
		gbc_labelMandInstructA.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelMandInstructA.gridwidth = 4;
		gbc_labelMandInstructA.insets = new Insets(0, 20, 5, 5);
		gbc_labelMandInstructA.gridx = 0;
		gbc_labelMandInstructA.gridy = 1;
		borderMandelbrot.add(labelMandInstructA, gbc_labelMandInstructA);
		
		JLabel labelMandInstructB = new JLabel("Click view to find out.");
		GridBagConstraints gbc_labelMandInstructB = new GridBagConstraints();
		gbc_labelMandInstructB.fill = GridBagConstraints.HORIZONTAL;
		gbc_labelMandInstructB.gridwidth = 4;
		gbc_labelMandInstructB.insets = new Insets(0, 20, 5, 5);
		gbc_labelMandInstructB.gridx = 0;
		gbc_labelMandInstructB.gridy = 2;
		borderMandelbrot.add(labelMandInstructB, gbc_labelMandInstructB);
		
		JRadioButton radioMandNormalView = new JRadioButton("Normal view");
		buttonGroup.add(radioMandNormalView);
		radioMandNormalView.setSelected(true);
		GridBagConstraints gbc_radioMandNormalView = new GridBagConstraints();
		gbc_radioMandNormalView.anchor = GridBagConstraints.WEST;
		gbc_radioMandNormalView.gridwidth = 2;
		gbc_radioMandNormalView.insets = new Insets(0, 20, 5, 5);
		gbc_radioMandNormalView.gridx = 0;
		gbc_radioMandNormalView.gridy = 3;
		borderMandelbrot.add(radioMandNormalView, gbc_radioMandNormalView);
		
		JRadioButton radioMandTrippyView = new JRadioButton("Back to the 60s");
		buttonGroup.add(radioMandTrippyView);
		GridBagConstraints gbc_radioMandTrippyView = new GridBagConstraints();
		gbc_radioMandTrippyView.anchor = GridBagConstraints.WEST;
		gbc_radioMandTrippyView.gridwidth = 3;
		gbc_radioMandTrippyView.insets = new Insets(0, 20, 5, 5);
		gbc_radioMandTrippyView.gridx = 0;
		gbc_radioMandTrippyView.gridy = 4;
		borderMandelbrot.add(radioMandTrippyView, gbc_radioMandTrippyView);
		
		JButton buttonMandView = new JButton("View");
		GridBagConstraints gbc_buttonMandView = new GridBagConstraints();
		gbc_buttonMandView.anchor = GridBagConstraints.EAST;
		gbc_buttonMandView.insets = new Insets(0, 0, 5, 5);
		gbc_buttonMandView.gridx = 3;
		gbc_buttonMandView.gridy = 4;
		borderMandelbrot.add(buttonMandView, gbc_buttonMandView);
		
		JLabel labelMandZoomInstructA = new JLabel("Left click and drag on mandelbrot image to zoom in,");
		GridBagConstraints gbc_labelMandZoomInstructA = new GridBagConstraints();
		gbc_labelMandZoomInstructA.anchor = GridBagConstraints.WEST;
		gbc_labelMandZoomInstructA.gridwidth = 6;
		gbc_labelMandZoomInstructA.insets = new Insets(0, 20, 5, 0);
		gbc_labelMandZoomInstructA.gridx = 0;
		gbc_labelMandZoomInstructA.gridy = 8;
		borderMandelbrot.add(labelMandZoomInstructA, gbc_labelMandZoomInstructA);
		
		JLabel labelMandZoomInstructB = new JLabel("Right click to zoom out to original size.");
		GridBagConstraints gbc_labelMandZoomInstructB = new GridBagConstraints();
		gbc_labelMandZoomInstructB.gridwidth = 6;
		gbc_labelMandZoomInstructB.anchor = GridBagConstraints.WEST;
		gbc_labelMandZoomInstructB.insets = new Insets(0, 20, 5, 0);
		gbc_labelMandZoomInstructB.gridx = 0;
		gbc_labelMandZoomInstructB.gridy = 9;
		borderMandelbrot.add(labelMandZoomInstructB, gbc_labelMandZoomInstructB);
		
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
		
		JButton greyscaleAnnulus = new JButton("New button");
		GridBagConstraints gbc_greyscaleAnnulus = new GridBagConstraints();
		gbc_greyscaleAnnulus.fill = GridBagConstraints.BOTH;
		gbc_greyscaleAnnulus.gridx = 0;
		gbc_greyscaleAnnulus.gridy = 0;
		panelAnnulusGraphic.add(greyscaleAnnulus, gbc_greyscaleAnnulus);
		
		JPanel panelMandelbrotGraphic = new JPanel();
		GridBagConstraints gbc_panelMandelbrotGraphic = new GridBagConstraints();
		gbc_panelMandelbrotGraphic.fill = GridBagConstraints.BOTH;
		gbc_panelMandelbrotGraphic.gridx = 0;
		gbc_panelMandelbrotGraphic.gridy = 1;
		panelParentRight.add(panelMandelbrotGraphic, gbc_panelMandelbrotGraphic);
		GridBagLayout gbl_panelMandelbrotGraphic = new GridBagLayout();
		gbl_panelMandelbrotGraphic.columnWidths = new int[]{0, 0};
		gbl_panelMandelbrotGraphic.rowHeights = new int[]{0, 0};
		gbl_panelMandelbrotGraphic.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panelMandelbrotGraphic.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelMandelbrotGraphic.setLayout(gbl_panelMandelbrotGraphic);
		
		JButton greyscaleMandelbrot = new JButton("New button");
		GridBagConstraints gbc_greyscaleMandelbrot = new GridBagConstraints();
		gbc_greyscaleMandelbrot.fill = GridBagConstraints.BOTH;
		gbc_greyscaleMandelbrot.gridx = 0;
		gbc_greyscaleMandelbrot.gridy = 0;
		panelMandelbrotGraphic.add(greyscaleMandelbrot, gbc_greyscaleMandelbrot);
	}

}
