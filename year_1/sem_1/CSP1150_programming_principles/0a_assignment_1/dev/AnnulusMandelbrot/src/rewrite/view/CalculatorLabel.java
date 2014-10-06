package rewrite.view;

import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.*;

/**
 * This class creates the labels for the view. The constructor accepts
 * gridbag constraints parameters and stores them in gbc_label.
 * These values are used for gridbag layout.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.0.0
 * @since 20141004
 */
@SuppressWarnings("serial")
public class CalculatorLabel extends JLabel {
	
	// declare the gridbag constraints
	protected GridBagConstraints gbc_label;
	
	/**
	 * The constructor for JLabels. 
	 * 
	 * @param String theWords - What the label will say.
	 * @param String theAnchor - Possible values: north, south, west, east. Using "none" for labels that do not use anchor.
	 * @param int gridwidth - The number of columns the label spans, use 1 as default.
	 * @param int insetTop - Padding top.
	 * @param int insetLeft - Padding left.
	 * @param int insetRight - Padding right.
	 * @param int insetBottom - Padding bottom.
	 * @param int gridx - The column position.
	 * @param int gridy - The row position.
	 */
	public CalculatorLabel(String theWords, String theAnchor, int gridwidth, int insetTop, int insetLeft, int insetRight, int insetBottom, int gridx, int gridy) {
		
		// set the label text
		this.setText(theWords);
		
		// create gridbag constraints
		this.gbc_label = new GridBagConstraints();
		
		// if theAnchor == north
		if(theAnchor.equalsIgnoreCase("north")) {
			
			// set gbc anchor north
			this.gbc_label.anchor = GridBagConstraints.NORTH;
		
		// else if theAnchor == south
		} else if(theAnchor.equalsIgnoreCase("south")) {
			
			// set gbc anchor south
			this.gbc_label.anchor = GridBagConstraints.SOUTH;
		
		// else if theAnchor == west
		} else if(theAnchor.equalsIgnoreCase("west")) {
			
			// set gbc anchor west
			this.gbc_label.anchor = GridBagConstraints.WEST;
		
		// else if theAnchor == east
		} else if(theAnchor.equalsIgnoreCase("east")) {
			
			// set gbc anchor east
			this.gbc_label.anchor = GridBagConstraints.EAST;
		}
		
		// set gbc gridwidth
		this.gbc_label.gridwidth = gridwidth;
		
		// set the inset values
		this.gbc_label.insets = new Insets(insetTop, insetLeft, insetRight, insetBottom);
		
		// set the column and row positions
		this.gbc_label.gridx = gridx;
		this.gbc_label.gridy = gridy;
	}
	
	/**
	 * This method returns the JLabel.
	 * 
	 * @return JLabel theLabel;
	 */
	public final JLabel getLabel() {
		return this;
	}
}
