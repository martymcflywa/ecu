package csp1150.assignment1.view;

// import layout manager
import java.awt.GridBagConstraints;
import java.awt.Insets;

// import gui components
import javax.swing.*;

/**
 * This class inherits from JRadioButton and creates radiobuttons for the view.
 * The constructor accepts gridbag constraints parameters gridx and gridy which are stored in gbc_radioButton.
 * These values are used for gridbag layout.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.3.1
 * @since 20141024
 */
@SuppressWarnings("serial")
public class CalculatorRadioButton extends JRadioButton implements ConstraintsInterface {

	// declare the gridbag constraints
	private GridBagConstraints gbc_radioButton;
	
	/**
	 * The constructor.
	 * 
	 * @param String buttonName - The button name.
	 * @param int gridx - GridBagConstraints: The column position.
	 * @param int gridy - GridBagConstraints: The row position.
	 */
	public CalculatorRadioButton(String buttonName, int gridx, int gridy) {
		
		// set the button text
		this.setText(buttonName);
		
		// create gridbag constraints
		gbc_radioButton = new GridBagConstraints();
		
		// use these values as constraints
		gbc_radioButton.anchor = GridBagConstraints.WEST;
		gbc_radioButton.gridwidth = 2;
		gbc_radioButton.insets = new Insets(0, 40, 5, 5);
		
		// set the column and row positions
		gbc_radioButton.gridx = gridx;
		gbc_radioButton.gridy = gridy;
	}
	
	/**
	 * Implements interface.
	 * 
	 * This method returns the GridBagConstraints reference.
	 * 
	 * @param args unused.
	 * @return GridBagConstraints gbc_radioButton.
	 */
	public final GridBagConstraints getConstraints() {
		
		return gbc_radioButton;
	}
}
