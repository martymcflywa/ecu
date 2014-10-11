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
 * @version 5.1.0
 * @since 20141011
 */
@SuppressWarnings("serial")
public class CalculatorRadioButton extends JRadioButton {

	// declare the gridbag constraints
	protected GridBagConstraints gbc_radioButton;
	
	/**
	 * The constructor.
	 * 
	 * @param String theWords - What the button will say.
	 * @param int gridx - GridBagConstraints: The column position.
	 * @param int gridy - GridBagConstraints: The row position.
	 */
	public CalculatorRadioButton(String theWords, int gridx, int gridy) {
		
		// create button
		this.setText(theWords);
		
		// create gridbag constraints
		this.gbc_radioButton = new GridBagConstraints();
		
		// use these values as constraints
		this.gbc_radioButton.anchor = GridBagConstraints.WEST;
		this.gbc_radioButton.gridwidth = 2;
		this.gbc_radioButton.insets = new Insets(0, 40, 5, 5);
		
		// set the column and row positions
		this.gbc_radioButton.gridx = gridx;
		this.gbc_radioButton.gridy = gridy;
	}
}
