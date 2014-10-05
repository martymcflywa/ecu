package rewrite.view;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.*;

/**
 * This class creates the user input fields, buttons and labels
 * for the view.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.0.0
 * @since 20141004
 */
@SuppressWarnings("serial")
public class CalculatorLabel extends CalculatorUserControl {

	protected JLabel theLabel;
	protected GridBagConstraints gbc_label;
	
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
	public CalculatorLabel(String theWords, String theAnchor, int gridwidth, int insetTop, int insetLeft, int insetRight, int insetBottom, int gridx, int gridy) {
		
		this.theLabel = new JLabel(theWords);
		this.gbc_label = new GridBagConstraints();
		
		if(theAnchor.equalsIgnoreCase("north")) {
			this.gbc_label.anchor = GridBagConstraints.NORTH;
		} else if(theAnchor.equalsIgnoreCase("south")) {
			this.gbc_label.anchor = GridBagConstraints.SOUTH;
		} else if(theAnchor.equalsIgnoreCase("west")) {
			this.gbc_label.anchor = GridBagConstraints.WEST;
		} else if(theAnchor.equalsIgnoreCase("east")) {
			this.gbc_label.anchor = GridBagConstraints.EAST;
		}
		
		this.gbc_label.gridwidth = gridwidth;
		this.gbc_label.insets = new Insets(insetTop, insetLeft, insetRight, insetBottom);
		this.gbc_label.gridx = gridx;
		this.gbc_label.gridy = gridy;
	}
	
	/**
	 * This method returns the JLabel.
	 * 
	 * @return JLabel theLabel;
	 */
	public final JLabel getLabel() {
		return theLabel;
	}
}
