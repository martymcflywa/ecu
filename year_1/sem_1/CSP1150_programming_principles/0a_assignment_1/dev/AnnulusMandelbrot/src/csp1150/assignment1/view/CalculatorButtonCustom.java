package csp1150.assignment1.view;

// the layout manager
import java.awt.GridBagConstraints;
import java.awt.Insets;

/**
 * This class inherits from CalculatorButton and creates the zoom buttons for the view.
 * They need custom gridbag constraints parameters which are modified in this subclass.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.1.0
 * @since 20141011
 */
@SuppressWarnings("serial")
public class CalculatorButtonCustom extends CalculatorButton {

	// declare the gridbag constraints
	protected GridBagConstraints gbc_zoomButton;
	
	/**
	 * The constructor.
	 * 
	 * @param String theWords - What the button will say.
	 * @param int gridx - GridBagConstraints: The column position.
	 * @param int gridy - GridBagConstraints: The row position.
	 */
	public CalculatorButtonCustom(String theWords, int gridx, int gridy) {
		
		// create button
		this.setText(theWords);
		
		// create gridbag constraints
		this.gbc_button = new GridBagConstraints();
		
		// use these values as constraints
		this.gbc_button.anchor = GridBagConstraints.WEST;
		this.gbc_button.insets = new Insets(0, 40, 5, 5);
		
		// set the column and row positions
		this.gbc_button.gridx = gridx;
		this.gbc_button.gridy = gridy;
	}
}
