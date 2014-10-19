package csp1150.assignment1.view;

// the layout manager
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

// inherit from JPanel
import javax.swing.JPanel;

/**
 * This class inherits from JPanel. The constructor is overloaded to accept
 * gridbag constraints parameters which are stored in gbc_panel.
 * These parameters are used for gridbag layout.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.1.0
 * @since 20141011
 */
@SuppressWarnings("serial")
public class PanelGridBagLayout extends JPanel {
	
	// declare gridbaglayout
	protected GridBagLayout gbl_panel;
	
	// declare gridbag constraints
	protected GridBagConstraints gbc_panel;
	
	/**
	 * The panel constructor, using GridBagLayout.
	 * To be used for calculator panels.
	 * 
	 * @param args unused.
	 */
	public PanelGridBagLayout() {
		
		// create gridbag constraints
		gbl_panel = new GridBagLayout();
		
		// use these gridbaglayout parameters
		gbl_panel.columnWidths = new int[]{0, 0};
		gbl_panel.rowHeights = new int[]{0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};	
	}
	
	/**
	 * Overloading the constructor, to be used for border panels.
	 * 
	 * @param int insetTop - GridBagConstraints: Padding top.
	 * @param int insetLeft - GridBagConstraints: Padding left.
	 * @param int insetRight - GridBagConstraints: Padding right.
	 * @param int insetBottom - GridBagConstraints: Padding bottom.
	 * @param int gridx - GridBagConstraints: The column position.
	 * @param int gridy - GridBagConstraints: The row position.
	 */
	public PanelGridBagLayout(int insetTop, int insetLeft, int insetRight, int insetBottom, int gridx, int gridy) {
		
		// create gridbag constraints
		gbc_panel = new GridBagConstraints();
		
		// define gridbag constraints parameters
		gbc_panel.insets = new Insets(insetTop, insetLeft, insetRight, insetBottom);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = gridx;
		gbc_panel.gridy = gridy;
		
		// create gridbaglayout
		gbl_panel = new GridBagLayout();
		
		// use these gridbaglayout parameters
		gbl_panel.columnWidths = new int[] {30, 30, 30, 30, 30};
		gbl_panel.rowHeights = new int[]{30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30, 30};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
	}
}
