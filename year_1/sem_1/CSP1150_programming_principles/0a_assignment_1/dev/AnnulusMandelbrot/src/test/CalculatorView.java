package test;
import java.awt.*;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	// defining labels, fields and buttons for panel
	private JLabel labelOutRadius = new JLabel("Outer Radius:");
	private JTextField fieldOutRadius = new JTextField(5);
	private JLabel labelInRadius = new JLabel("Inner Radius:");
	private JTextField fieldInRadius = new JTextField(5);
	private JButton calcButton = new JButton("Calculate");
	private JLabel labelArea = new JLabel("Approximate Area:");
	private JTextField fieldAreaApprox = new JTextField(15);
	
	/**
	 * The view constructor.
	 * Configuring frame and panel parameters here.
	 */
	CalculatorView() {
		
		// create panel
		JPanel calcPanel = new JPanel();
		// set title
		this.setTitle("Annulus and Mandelbrot Calculator");
		// set default action on close
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// set size
		this.setSize(600, 600);
		// set window location
		this.setLocationRelativeTo(null);
		// cannot resize window
		this.setResizable(false);
		
		// adding labels and fields to panel
		calcPanel.add(labelOutRadius);
		calcPanel.add(fieldOutRadius);
		calcPanel.add(labelInRadius);
		calcPanel.add(fieldInRadius);
		calcPanel.add(calcButton);
		calcPanel.add(labelArea);
		calcPanel.add(fieldAreaApprox);
		
		// adding panel to frame
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
