package rewrite.view;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class PanelGridBagLayout extends JPanel{

	// declare border title
	protected String borderTitle;
	
	// declare panel and layout manager
	protected JPanel panel;
	protected GridBagLayout gbl_panel;
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
		this.panel.setBackground(Color.GREEN);
		
		// create gridbag constraints
		this.gbl_panel = new GridBagLayout();
		
		// use these gridbaglayout parameters
		this.gbl_panel.columnWidths = new int[]{0, 0};
		this.gbl_panel.rowHeights = new int[]{0, 0};
		this.gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		this.gbl_panel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		
		// set the panel's layout to gbl
		this.panel.setLayout(this.gbl_panel);
	}
	
	/**
	 * Overloading the panel constructor, to be used for border panels.
	 * 
	 * @param String borderTitle - What appears as the border title.
	 * @param int insetTop - Padding top.
	 * @param int insetLeft - Padding left.
	 * @param int insetRight - Padding right.
	 * @param int insetBottom - Padding bottom.
	 * @param int gridx - The column position.
	 * @param int gridy - The row position.
	 */
	public PanelGridBagLayout(String borderTitle, int insetTop, int insetLeft, int insetRight, int insetBottom, int gridx, int gridy) {
		
		// create panel
		this.panel = new JPanel();
		
		// set String borderTitle
		this.borderTitle = borderTitle;
		
		// **DEBUGGING**
		this.panel.setBackground(Color.GRAY);
		this.panel.setOpaque(true);
		
		// set up titleborder
		this.panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null), borderTitle, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		// create gridbag constraints
		this.gbc_panel = new GridBagConstraints();
		
		// define gbl parameters, gbcSettings array holding values
		this.gbc_panel.insets = new Insets(insetTop, insetLeft, insetRight, insetBottom);
		this.gbc_panel.fill = GridBagConstraints.BOTH;
		this.gbc_panel.gridx = gridx;
		this.gbc_panel.gridy = gridy;
		
		// **NEED TO TEST THIS** add panel and gbc to parent
		//this.panel.getParent().add(this.panel, this.gbc_panel);
		System.out.println(this.panel.getParent());
		
		this.gbl_panel = new GridBagLayout();
		
		// use these gridbaglayout parameters
		this.gbl_panel.columnWidths = new int[] {0, 0, 0, 0, 0};
		this.gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		this.gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		this.gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		
		// set the panel's layout to gbl
		this.panel.setLayout(this.gbl_panel);
	}
}
