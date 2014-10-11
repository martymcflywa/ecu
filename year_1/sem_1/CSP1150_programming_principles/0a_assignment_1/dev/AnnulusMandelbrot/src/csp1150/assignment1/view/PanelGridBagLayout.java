package csp1150.assignment1.view;

// the layout manager
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

// inherit from JPanel
import javax.swing.JPanel;

/**
 * This class creates a JPanel. The constructor is overloaded to accept
 * gridbag constraints parameters which are stored in gbc_panel.
 * These paramters are used for gridbag layout.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.1.0
 * @since 20141011
 */
@SuppressWarnings("serial")
public class PanelGridBagLayout extends JPanel {
	
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
		
		// create gridbag constraints
		this.gbl_panel = new GridBagLayout();
		
		// use these gridbaglayout parameters
		this.gbl_panel.columnWidths = new int[]{0, 0};
		this.gbl_panel.rowHeights = new int[]{0, 0};
		this.gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		this.gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};	
	}
	
	/**
	 * Overloading the constructor, to be used for border panels.
	 * 
	 * @param int insetTop - Padding top.
	 * @param int insetLeft - Padding left.
	 * @param int insetRight - Padding right.
	 * @param int insetBottom - Padding bottom.
	 * @param int gridx - The column position.
	 * @param int gridy - The row position.
	 */
	public PanelGridBagLayout(int insetTop, int insetLeft, int insetRight, int insetBottom, int gridx, int gridy) {
		
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
		this.gbl_panel.columnWidths = new int[] {30, 30, 30, 30, 30};
		this.gbl_panel.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		this.gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	}
}
