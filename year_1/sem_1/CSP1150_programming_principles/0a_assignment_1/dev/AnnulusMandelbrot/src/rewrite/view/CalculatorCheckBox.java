package rewrite.view;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.*;

/**
 * This class creates the buttons for the view. The constructor accepts
 * gridbag constraints parameters gridx and gridy which are stored in gbc_label.
 * These values are used for gridbag layout.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.0.0
 * @since 20141004
 */
@SuppressWarnings("serial")
public class CalculatorCheckBox extends JCheckBox {

	// declare the gridbag constraints
	protected GridBagConstraints gbc_checkBox;
	
	/**
	 * The constructor for JRadioButtons.
	 * 
	 * @param String theWords - What the checkbox will say.
	 * @param int gridx - The column position.
	 * @param int gridy - The row position.
	 */
	public CalculatorCheckBox(String theWords, int gridx, int gridy) {
		
		// create button
		this.setText(theWords);
		
		// create gridbag constraints
		this.gbc_checkBox = new GridBagConstraints();
		
		// use these values as constraints
		this.gbc_checkBox.anchor = GridBagConstraints.WEST;
		this.gbc_checkBox.gridwidth = 2;
		this.gbc_checkBox.insets = new Insets(0, 40, 5, 5);
		
		// set the column and row positions
		this.gbc_checkBox.gridx = gridx;
		this.gbc_checkBox.gridy = gridy;
	}
}
