package csp1150.assignment1.view;

// import layout manager
import java.awt.GridBagConstraints;
import java.awt.Insets;

// import swing components
import javax.swing.*;

/**
 * This class creates the buttons for the view. The constructor accepts
 * gridbag constraints parameters gridx and gridy which are stored in gbc_label.
 * These values are used for gridbag layout.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.1.0
 * @since 20141011
 */
@SuppressWarnings("serial")
public class CalculatorButton extends JButton {
	
	// declare the gridbag constraints
	protected GridBagConstraints gbc_button;
	
	/**
	 * The default constructor for inheritance.
	 */
	public CalculatorButton() {
		
	}
	
	/**
	 * The constructor for JButtons.
	 * 
	 * @param String theWords - What the button will say.
	 * @param int gridx - The column position.
	 * @param int gridy - The row position.
	 */
	public CalculatorButton(String theWords, int gridx, int gridy) {
		
		// create button
		this.setText(theWords);
		
		// create gridbag constraints
		this.gbc_button = new GridBagConstraints();
		
		// use these values as constraints
		this.gbc_button.anchor = GridBagConstraints.WEST;
		this.gbc_button.insets = new Insets(0, 20, 5, 5);
		
		// set the column and row positions
		this.gbc_button.gridx = gridx;
		this.gbc_button.gridy = gridy;
	}
}
