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
 * @version 5.1.0
 * @since 20141011
 */
@SuppressWarnings("serial")
public class CalculatorCheckBox extends JCheckBox {

	// declare the gridbag constraints
	protected GridBagConstraints gbc_checkBox;
	
	/**
	 * The constructor.
	 * 
	 * @param String theWords - What the checkbox will say.
	 * @param int gridx - GridBagConstraints: The column position.
	 * @param int gridy - GridBagConstraints: The row position.
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
