package csp1150.assignment1.view;

// the layout manager
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * This class inherits from CalculatorButton and creates the zoom buttons for the view.
 * These buttons need different gridbag constraints parameters which are modified in this subclass.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.3.0
 * @since 20141022
 */
@SuppressWarnings("serial")
public class CalculatorButtonCustom extends CalculatorButton {
	
	/**
	 * The constructor.
	 * 
	 * @param String buttonName - The button name.
	 * @param int gridx - GridBagConstraints: The column position.
	 * @param int gridy - GridBagConstraints: The row position.
	 */
	public CalculatorButtonCustom(String buttonName, int gridx, int gridy) {
		
		// set the button text
		this.setText(buttonName);
		
		// use these values as constraints
		this.getConstraints().anchor = GridBagConstraints.WEST;
		this.getConstraints().insets = new Insets(0, 40, 5, 5);
		
		// set the column and row positions
		this.getConstraints().gridx = gridx;
		this.getConstraints().gridy = gridy;
	}
}
