package csp1150.assignment1.view;

// the layout manager
import java.awt.GridBagConstraints;
import java.awt.Insets;

// swing components
import javax.swing.*;

/**
 * This class inherits from JCheckBox and creates the checkboxes for the view.
 * The constructor accepts gridbag constraints parameters gridx and gridy which are stored in gbc_checkBox.
 * These values are used for gridbag layout.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.2.0
 * @since 20141020
 */
@SuppressWarnings("serial")
public class CalculatorCheckBox extends JCheckBox {

	// declare the gridbag constraints
	protected GridBagConstraints gbc_checkBox;
	
	/**
	 * The constructor.
	 * 
	 * @param String buttonName - The button name.
	 * @param int gridx - GridBagConstraints: The column position.
	 * @param int gridy - GridBagConstraints: The row position.
	 */
	public CalculatorCheckBox(String buttonName, int gridx, int gridy) {
		
		// set the button text
		this.setText(buttonName);
		
		// create gridbag constraints
		gbc_checkBox = new GridBagConstraints();
		
		// use these values as constraints
		gbc_checkBox.anchor = GridBagConstraints.WEST;
		gbc_checkBox.gridwidth = 2;
		gbc_checkBox.insets = new Insets(0, 40, 5, 5);
		
		// set the column and row positions
		gbc_checkBox.gridx = gridx;
		gbc_checkBox.gridy = gridy;
	}
}
