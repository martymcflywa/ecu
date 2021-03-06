package csp1150.assignment1.view;

// the layout manager
import java.awt.GridBagConstraints;
import java.awt.Insets;

// swing components
import javax.swing.*;

/**
 * This class inherits from JTextField and creates the textfields for the view.
 * The constructor accepts gridbag constraints parameters and stores them in gbc_textField.
 * These values are used for gridbag layout.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.3.1
 * @since 20141024
 */
@SuppressWarnings("serial")
public class CalculatorTextField extends JTextField implements ConstraintsInterface {
	
	// declare the gridbag constraints
	private GridBagConstraints gbc_textField;
	
	/**
	 * The constructor.
	 * 
	 * @param int length - How many characters the textfield can hold.
	 * @param int gridx - GridBagConstraints: The column position.
	 * @param int gridy -GridBagConstraints: The row position.
	 */
	public CalculatorTextField(int length, int gridx, int gridy) {

		// set textfield length
		setColumns(length);
		
		// create gridbag constraints
		gbc_textField = new GridBagConstraints();
		
		// use these values as constraints
		gbc_textField.anchor = GridBagConstraints.WEST;
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.gridwidth = 1;
		gbc_textField.insets = new Insets(0, 20, 5, 5);
		
		// set the column and row positions
		gbc_textField.gridx = gridx;
		gbc_textField.gridy = gridy;
	}
	
	/**
	 * Implements interface.
	 * 
	 * This method returns the GridBagConstraints reference.
	 * 
	 * @param args unused.
	 * @return GridBagConstraints gbc_textField.
	 */
	public final GridBagConstraints getConstraints() {
		
		return gbc_textField;
	}
}
