package test;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;

public class CalculatorView extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Defining labels, fields and buttons for panel.
	 */
	
	// label: outer radius
	private JLabel labelOutRadius = new JLabel("Outer Radius:");
	
	// text field: outer radius input
	private JTextField fieldOutRadius = new JTextField(5);
	
	// label: inner radius
	private JLabel labelInRadius = new JLabel("Inner Radius:");
	
	// text field: inner radius input
	private JTextField fieldInRadius = new JTextField(5);
	
	// button: calc button
	private JButton calcButton = new JButton("Calculate");
	
	// label: approximate area
	private JLabel labelApproxArea = new JLabel("Approximate Area:");
	
	// text field: approximate area result
	private JTextField approxAreaResult = new JTextField(15);
	
	// label: monte carlo area
	private JLabel labelMonteArea = new JLabel("Monte Carlo Area:");
	
	// text field: monte carlo area result
	private JTextField monteAreaResult = new JTextField(15);
	
	/**
	 * The view constructor.
	 * Configuring frame and panel parameters here.
	 */
	CalculatorView() {
		
		// create panel
		JPanel theWindow = new JPanel();
		
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
		theWindow.add(labelOutRadius);
		theWindow.add(fieldOutRadius);
		theWindow.add(labelInRadius);
		theWindow.add(fieldInRadius);
		theWindow.add(calcButton);
		theWindow.add(labelApproxArea);
		theWindow.add(approxAreaResult);
		theWindow.add(labelMonteArea);
		theWindow.add(monteAreaResult);
		
		// adding panel to frame
		this.add(theWindow);
		
		// set up border
		Border calcBorder = BorderFactory.createTitledBorder("Annulus Calculator");
		theWindow.setBorder(calcBorder);
	}
	
	/**
	 * Gets outer radius user input.
	 * @return double - Outer radius.
	 */
	public double getOutRadius() {
		return Double.parseDouble(fieldOutRadius.getText());
	}
	
	/**
	 * Gets inner radius user input.
	 * @return double - Inner radius.
	 */
	public double getInRadius() {
		return Double.parseDouble(fieldInRadius.getText());
	}
	
	/**
	 * Gets calculated area.
	 * @return double - Area.
	 */
	public double getAreaCalc() {
		return Double.parseDouble(approxAreaResult.getText());
	}
	
	/**
	 * Sets area by controller.
	 * @param double area.
	 */
	public void setAreaCalc(double area) {
		approxAreaResult.setText(Double.toString(area));
	}
	
	public void setMonteCalc(double area) {
		monteAreaResult.setText(Double.toString(area));
	}
	
	/**
	 * Adds listener for the calculate button.
	 * @param listenForCalcButton.
	 */
	void addCalcListener(ActionListener listenForCalcButton) {
		calcButton.addActionListener(listenForCalcButton);
	}
	
	/**
	 * Displays error message for incorrect user input,
	 * as JOptionPane window.
	 * @param String errorMessage.
	 */
	void displayErrorMessage(String errorMessage) {
		JOptionPane.showMessageDialog(this, errorMessage);
	}
}
