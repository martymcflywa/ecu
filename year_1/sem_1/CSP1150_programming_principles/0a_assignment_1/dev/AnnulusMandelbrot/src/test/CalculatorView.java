package test;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorView extends JFrame {
	
//	// only for testing
//	public static void main(String[] args) {
//		new CalculatorView();
//	}
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel labelOutRadius = new JLabel("Outer Radius:");
	private JTextField fieldOutRadius = new JTextField(10);
	private JLabel labelInRadius = new JLabel("Inner Radius:");
	private JTextField fieldInRadius = new JTextField(10);
	private JButton calcButton = new JButton("Calculate");
	private JLabel labelArea = new JLabel("Approximate Area:");
	private JTextField fieldAreaApprox = new JTextField(10);
	
	/**
	 * The view constructor
	 */
	CalculatorView() {
		JPanel calcPanel = new JPanel();
		this.setTitle("Annulus and Mandelbrot Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		
//		// only for testing
//		this.setVisible(true);
		
		calcPanel.add(labelOutRadius);
		calcPanel.add(fieldOutRadius);
		calcPanel.add(labelInRadius);
		calcPanel.add(fieldInRadius);
		calcPanel.add(calcButton);
		calcPanel.add(labelArea);
		calcPanel.add(fieldAreaApprox);
		
		this.add(calcPanel);
	}
	
	/**
	 * Gets outer radius user input.
	 * @return double - Outer radius
	 */
	public double getOutRadius() {
		return Double.parseDouble(fieldOutRadius.getText());
	}
	
	/**
	 * Gets inner radius user input.
	 * @return double - Inner radius
	 */
	public double getInRadius() {
		return Double.parseDouble(fieldInRadius.getText());
	}
	
	/**
	 * Gets calculated area.
	 * @return double - Area.
	 */
	public double getAreaApprox() {
		return Double.parseDouble(fieldAreaApprox.getText());
	}
	
	/**
	 * Sets area by controller
	 * @param double area
	 */
	public void setAreaApprox(double area) {
		fieldAreaApprox.setText(Double.toString(area));
	}
	
	/**
	 * Adds listener for the calculate button 
	 * @param listenForCalcButton
	 */
	void addCalcListener(ActionListener listenForCalcButton) {
		calcButton.addActionListener(listenForCalcButton);
	}
	
	/**
	 * Displays error message for incorrect user input
	 * @param errorMessage
	 */
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
