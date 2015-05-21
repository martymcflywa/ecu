import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TrafficSimulator extends JApplet implements ChangeListener {

    private String[] streetnames = new String[] {
            "Byres Road North",
            "University Avenue",
            "Byres Road South",
            "Highburgh Road"
        };

    private StreetIntersection theIntersection;
    private JSlider[] theSliders;
    private JTextField[] theTextFields;
    private TrafficGraph theGraph;

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

    public void createGUI () {

        theSliders = new JSlider[5];
        theTextFields = new JTextField[5];

        JPanel input = new JPanel(new GridBagLayout());
        for (int i = 0; i < 4; i++) {
            JLabel l = new JLabel(streetnames[i]);
            addToGridBag(input, l, 0, i, 1, 1, 0.0, 0.0);

            theSliders[i] = new JSlider(1, 50);
            theSliders[i].addChangeListener(this);
            addToGridBag(input, theSliders[i], 1, i, 1, 1, 0.0, 0.0);

            theTextFields[i] = new JTextField(3);
            theTextFields[i].setEnabled(false);
            addToGridBag(input, theTextFields[i], 2, i, 1, 1, 0.0, 0.0);
        }

        JLabel l = new JLabel ("Lights duration");
        addToGridBag(input, l, 0, 4, 1, 1, 0.0, 0.0);
        theSliders[4] = new JSlider(50, 150);
        theSliders[4].addChangeListener(this);
        addToGridBag(input, theSliders[4], 1, 4, 1, 1, 0.0, 0.0);
        theTextFields[4] = new JTextField(3);
        theTextFields[4].setEnabled(false);
        addToGridBag(input, theTextFields[4], 2, 4, 1, 1, 0.0, 0.0);

        theGraph = new TrafficGraph(streetnames);
        theGraph.setPreferredSize(new Dimension(350, 100));

        getContentPane().add(input, "North");
        getContentPane().add(theGraph, "Center");
    }

    public void stateChanged (ChangeEvent e) {
        JSlider slider = (JSlider) e.getSource();
        for (int i = 0; i < theSliders.length; i++) {
            if (slider == theSliders[i]) {
                int v = slider.getValue();
                theTextFields[i].setText("" + v);
                if (i < 4)
                    theIntersection.setMeanArrivalPeriod(i, v);
                else
                    theIntersection.setLightsDuration(v);
                break;
            }
        }
    }

///////////////////////////////////////////////////////////////////////////////

    public void init () {
        createGUI();

        theIntersection = new StreetIntersection(this, theGraph);
        for (int i = 0; i < StreetIntersection.NUM_STREETS; i++) {
            int arrivalPeriod = theIntersection.getMeanArrivalPeriod(i);
            theSliders[i].setValue(arrivalPeriod);
            theTextFields[i].setText("" + arrivalPeriod);
        }

        int lightsDuration = theIntersection.getLightsDuration();
        theSliders[4].setValue(lightsDuration);
        theTextFields[4].setText("" + lightsDuration);
        theGraph.setValues(theIntersection.getQueueLengths());
        theGraph.setCurrentValue(theIntersection.getCurrentStreetNum());
        repaint();
    }

    public void start () {
        theIntersection.start();
    }

    public void stop () {
        theIntersection.stop();
    }
}
