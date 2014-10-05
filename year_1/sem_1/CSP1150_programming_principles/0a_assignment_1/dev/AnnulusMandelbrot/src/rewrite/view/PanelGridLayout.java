package rewrite.view;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class PanelGridLayout extends JPanel {
	
	// declare panel
	protected JPanel panel = new JPanel();
	
	// declare GridLayout
	protected GridLayout theGridLayout;
	
	/**
	 * The default constructor.
	 */
	public PanelGridLayout() {
		
	}
	
	/**
	 * The panel constructor, to be used for panels
	 * that are direct children of JFrame.
	 * 
	 * @param JFrame theFrame - The parent frame.
	 * @param int rows - How many rows in grid.
	 * @param int cols - How many columns in grid.
	 * @param int hgap - Horizontal padding, pixels.
	 * @param int vgap - Vertical padding, pixels.
	 */
	public PanelGridLayout(int rows, int cols, int hgap, int vgap) {
		
		// create panel
		this.panel = new JPanel();
		
		// **DEBUGGING**
		this.panel.setBackground(Color.WHITE);
		
		// use gridlayout, set the rows, columns and gaps
		this.panel.setLayout(this.theGridLayout = new GridLayout(rows, cols, hgap, vgap));
	}
	
	/**
	 * Overloading the panel constructor, to be used for panels
	 * that are children of other JPanels.
	 * 
	 * @param thePanel
	 * @param rows
	 * @param cols
	 * @param hgap
	 * @param vgap
	 */
	public PanelGridLayout(JPanel thePanel, int rows, int cols, int hgap, int vgap) {
		
		// create panel
		this.panel = new JPanel();
		
		// **DEBUGGING**
		this.panel.setBackground(Color.BLUE);
		
		// use gridlayout, set the rows, columns and gaps
		this.panel.setLayout(this.theGridLayout = new GridLayout(rows, cols, hgap, vgap));
		
		// add panel to the parent panel **might need to delete this**
		thePanel.add(this.panel);
		
	}
	
	/**
	 * This method returns the panel.
	 * @return JPanel panel
	 */
	public JPanel getPanel() {
		return panel;
	}
}
