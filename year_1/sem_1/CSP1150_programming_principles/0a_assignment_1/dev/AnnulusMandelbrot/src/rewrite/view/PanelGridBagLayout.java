package rewrite.view;

// for debugging only
import java.awt.Color;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;


@SuppressWarnings("serial")
public class PanelGridBagLayout extends PanelGridLayout {
	
	// declare panel
	protected JPanel panel;
	
	// store the gridbaglayout in this variable
	protected GridBagLayout gbl_panel;
	
	// store the gridbagconstraints in this variable
	protected GridBagConstraints gbc_panel;
	
	/**
	 * The panel constructor, using GridBagLayout.
	 * To be used for calculator panels.
	 * 
	 * @param args unused.
	 */
	public PanelGridBagLayout() {
		
		// create panel
		this.panel = new JPanel();
		
		// **DEBUGGING**
		this.panel.setBackground(Color.ORANGE);
		
		// create gridbag constraints
		this.gbl_panel = new GridBagLayout();
		
		// use these gridbaglayout parameters
		this.gbl_panel.columnWidths = new int[]{0, 0};
		this.gbl_panel.rowHeights = new int[]{0, 0};
		this.gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		this.gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};	
	}
	
	/**
	 * Overloading the panel constructor, to be used for border panels.
	 * 
	 * @param int insetTop - Padding top.
	 * @param int insetLeft - Padding left.
	 * @param int insetRight - Padding right.
	 * @param int insetBottom - Padding bottom.
	 * @param int gridx - The column position.
	 * @param int gridy - The row position.
	 */
	public PanelGridBagLayout(int insetTop, int insetLeft, int insetRight, int insetBottom, int gridx, int gridy) {
		
		// create panel
		this.panel = new JPanel();
		
		// create gridbag constraints
		this.gbc_panel = new GridBagConstraints();
		
		// define gridbag constraints parameters
		this.gbc_panel.insets = new Insets(insetTop, insetLeft, insetRight, insetBottom);
		this.gbc_panel.fill = GridBagConstraints.BOTH;
		this.gbc_panel.gridx = gridx;
		this.gbc_panel.gridy = gridy;
		
		// create gridbaglayout
		this.gbl_panel = new GridBagLayout();
		
		// use these gridbaglayout parameters
		this.gbl_panel.columnWidths = new int[] {0, 0, 0, 0, 0};
		this.gbl_panel.rowHeights = new int[]{20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20, 20};
		this.gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	}
}
