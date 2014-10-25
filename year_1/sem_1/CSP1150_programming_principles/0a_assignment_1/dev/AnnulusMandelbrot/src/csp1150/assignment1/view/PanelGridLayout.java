package csp1150.assignment1.view;

// the layout manager
import java.awt.GridLayout;

// inherit from JPanel
import javax.swing.JPanel;

/**
 * This class inherits from JPanel and creates panels that use GridLayout manager.
 * The constructor accepts GridLayout constraints parameters which are stored in theGridLayout.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.3.1
 * @since 20141024
 */
@SuppressWarnings("serial")
public class PanelGridLayout extends JPanel {
	
	// create GridLayout object with default constraints
	private GridLayout theGridLayout = new GridLayout(2, 1, 20, 5);
	
	/**
	 * Default constructor for inheritance.
	 * 
	 * @param args unused.
	 */
	public PanelGridLayout() {
		
	}
	
	/**
	 * The panel constructor. 
	 * Used for panels that are direct children of CalculatorFrame.
	 * 
	 * @param int rows - GridLayout constraints: How many rows in grid.
	 * @param int cols - GridLayout constraints: How many columns in grid.
	 * @param int hgap - GridLayout constraints: Horizontal padding, pixels.
	 * @param int vgap - GridLayout constraints: Vertical padding, pixels.
	 */
	public PanelGridLayout(int rows, int cols, int hgap, int vgap) {
		
		// set the rows, columns and padding
		setGridLayoutConstraints(rows, cols, hgap, vgap);
		
		// use the layout
		setLayout(theGridLayout);
	}
	
	/**
	 * This method sets the GridLayout constraints.
	 * 
	 * @param int rows - GridLayout constraints: How many rows in grid.
	 * @param int cols - GridLayout constraints: How many columns in grid.
	 * @param int hgap - GridLayout constraints: Horizontal padding, pixels.
	 * @param int vgap - GridLayout constraints: Vertical padding, pixels.
	 */
	protected final void setGridLayoutConstraints(int rows, int cols, int hgap, int vgap) {
		
		theGridLayout.setRows(rows);
		theGridLayout.setColumns(cols);
		theGridLayout.setHgap(hgap);
		theGridLayout.setVgap(vgap);
	}
	
	/**
	 * This method returns the GridLayout object.
	 * 
	 * @param args unused.
	 * @return GridLayout theGridLayout.
	 */
	protected final GridLayout getGridLayout() {
		
		return theGridLayout;
	}
}
