package csp1150.assignment1.view;

// import layout manager
import java.awt.GridBagConstraints;
import java.awt.Insets;

// import swing components
import javax.swing.*;

/**
 * This class creates the textfields for the view. The constructor accepts
 * gridbag constraints parameters and stores them in gbc_textField.
 * These values are used for gridbag layout.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.1.0
 * @since 20141011
 */
@SuppressWarnings("serial")
public class CalculatorTextField extends JTextField {
	
	// declare the gridbag constraints
	protected GridBagConstraints gbc_textField;
	
	public CalculatorTextField(int length, int gridx, int gridy) {

		// set textfield length
		this.setColumns(length);
		
		// create gridbag constraints
		this.gbc_textField = new GridBagConstraints();
		
		// use these values as constraints
		this.gbc_textField.anchor = GridBagConstraints.WEST;
		this.gbc_textField.fill = GridBagConstraints.BOTH;
		this.gbc_textField.gridwidth = 1;
		this.gbc_textField.insets = new Insets(0, 20, 5, 5);
		
		// set the column and row positions
		this.gbc_textField.gridx = gridx;
		this.gbc_textField.gridy = gridy;
	}
}
