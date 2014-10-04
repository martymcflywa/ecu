package rewrite.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Demo {

	private JFrame frame;

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
		panelImageAnnulus.setLayout(new GridLayout(1, 0, 0, 0));
		
		JButton imageAnnulus = new JButton("Annulus image");
		panelImageAnnulus.add(imageAnnulus);
		
		JPanel panelImageMandelbrot = new JPanel();
		panelRight.add(panelImageMandelbrot);
		panelImageMandelbrot.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton imageMandelbrot = new JButton("Mandelbrot Image");
		panelImageMandelbrot.add(imageMandelbrot);
	}

}
