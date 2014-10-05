package rewrite.view;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.*;

@SuppressWarnings("serial")
public class CalculatorTextField extends CalculatorComponent {

	// declare theTextField
	protected JTextField theTextField;
	
	// declare the gridbag constraints
	protected GridBagConstraints gbc_textField;
	
	public CalculatorTextField(int length, int gridx, int gridy) {
		
		// create textfield
		this.theTextField = new JTextField();
		
		// set textfield length
		this.theTextField.setColumns(length);
		
		// create gridbag constraints
		this.gbc_textField = new GridBagConstraints();
		
		// use these values as constraints
		this.gbc_textField.anchor = GridBagConstraints.WEST;
		this.gbc_textField.fill = GridBagConstraints.BOTH;
		this.gbc_textField.gridwidth = 2;
		this.gbc_textField.insets = new Insets(0, 20, 5, 5);
		
		// set the column and row positions
		this.gbc_textField.gridx = gridx;
		this.gbc_textField.gridy = gridy;
	}
}
