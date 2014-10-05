package rewrite.view;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.*;

/**
 * The super class for calculator user controls.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.0.0
 * @since 20141004
 */
@SuppressWarnings("serial")
public class CalculatorComponent extends JComponent {

	protected JLabel theLabel;
	private GridBagConstraints gbc_userControls;
	
	public CalculatorComponent() {

	}
	
	/**
	 * The constructor for JLabels. 
	 * 
	 * @param String theLabel - Determines which constructor to use.
	 * @param String theWords - What the label will say.
	 * @param String theAnchor - Possible values: north, south, west, east.
	 * @param int gridwidth - The number of columns the label spans, use 1 as default.
	 * @param int insetTop - Padding top.
	 * @param int insetLeft - Padding left.
	 * @param int insetRight - Padding right.
	 * @param int insetBottom - Padding bottom.
	 * @param int gridx - The column position.
	 * @param int gridy - The row position.
	 */
	public CalculatorComponent(String theWords, String theAnchor, int gridwidth, int insetTop, int insetLeft, int insetRight, int insetBottom, int gridx, int gridy) {
		
		this.theLabel = new JLabel(theWords);
		this.gbc_userControls = new GridBagConstraints();
		
		if(theAnchor.equalsIgnoreCase("north")) {
			this.gbc_userControls.anchor = GridBagConstraints.NORTH;
		} else if(theAnchor.equalsIgnoreCase("south")) {
			this.gbc_userControls.anchor = GridBagConstraints.SOUTH;
		} else if(theAnchor.equalsIgnoreCase("west")) {
			this.gbc_userControls.anchor = GridBagConstraints.WEST;
		} else if(theAnchor.equalsIgnoreCase("east")) {
			this.gbc_userControls.anchor = GridBagConstraints.EAST;
		}
		
		this.gbc_userControls.gridwidth = gridwidth;
		this.gbc_userControls.insets = new Insets(insetTop, insetLeft, insetRight, insetBottom);
		this.gbc_userControls.gridx = gridx;
		this.gbc_userControls.gridy = gridy;
	}
}
