import WattBrown.*;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class RecordGUI extends JFrame
	implements WindowListener, ActionListener {

    private StudentRecordSystem system;

    private JTextArea output;
    private JComboBox courseBox, degreeBox;

    //////////// Constructor ////////////

    public RecordGUI (StudentRecordSystem system) {
    	this.system = system;
    	constructGUI();
    }

    private void constructGUI () {

    	courseBox = new JComboBox();
    	system.addCourses(courseBox);

    	degreeBox = new JComboBox();
    	system.addDegrees(degreeBox);

    	JPanel p = new JPanel(new GridBagLayout());
        JLabel l1 = new JLabel("Select a course to view:");
        JLabel l2 = new JLabel("Select a degree to view:");
    	addToGridBag(p, l1,        0, 0, 1, 1, 0.0, 0.0);
    	addToGridBag(p, courseBox, 0, 1, 1, 1, 0.0, 0.0);
    	addToGridBag(p, l2,        0, 2, 1, 1, 0.0, 0.0);
    	addToGridBag(p, degreeBox, 0, 3, 1, 1, 0.0, 0.0);
        int rem = GridBagConstraints.REMAINDER;
        addToGridBag(p, new JLabel(""), 0, 4, 1, rem, 0.0, 1.0);
        getContentPane().add(p, "East");
    	courseBox.setSelectedIndex(0);

    	output = new JTextArea("", 10, 30);
    	JScrollPane sp = new JScrollPane(output,
    		JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
    		JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    	getContentPane().add(sp, "Center");

    	setTitle("Simple Student Record System");
    	addWindowListener(this);

        degreeBox.addActionListener(this);
    	degreeBox.setEditable(false);
        courseBox.addActionListener(this);
    	courseBox.setEditable(false);

    	pack();

    }


    private static void addToGridBag(JPanel panel, Component comp,
            int x, int y, int w, int h, double weightx, double weighty) {

        GridBagLayout gbl = (GridBagLayout) panel.getLayout();
        GridBagConstraints c = new GridBagConstraints();
        c.fill = GridBagConstraints.BOTH;
        c.gridx = x;
        c.gridy = y;
        c.gridwidth = w;
        c.gridheight = h;
        c.weightx = weightx;
        c.weighty = weighty;
        panel.add(comp);
        gbl.setConstraints(comp, c);
    }

///////////////////////////////////////////////////////////////////////////////

    public void actionPerformed (ActionEvent e) {
    	JComboBox cb = (JComboBox) e.getSource();
    	if (cb == courseBox) {
    	    String courseID = (String) cb.getSelectedItem();
    	    Set courseIDs = new BSTSet();  courseIDs.add(courseID);
    	    system.displayCourses(output, courseIDs);
    	} else if (cb == degreeBox) {
    	    String degreeID = (String) cb.getSelectedItem();
    	    Set degreeIDs = new BSTSet();  degreeIDs.add(degreeID);
    	    system.displayDegrees(output, degreeIDs);
    	}
    }

///////////////////////////////////////////////////////////////////////////////

    public void windowOpened      (WindowEvent e) { }
    public void windowClosed      (WindowEvent e) { }
    public void windowClosing     (WindowEvent e) { System.exit(0); }
    public void windowIconified   (WindowEvent e) { }
    public void windowDeiconified (WindowEvent e) { }
    public void windowActivated   (WindowEvent e) { }
    public void windowDeactivated (WindowEvent e) { }
}
