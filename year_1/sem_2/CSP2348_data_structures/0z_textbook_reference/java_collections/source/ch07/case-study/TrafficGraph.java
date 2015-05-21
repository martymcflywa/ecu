import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class TrafficGraph extends JPanel {

////////////////////////////////////////////////////////////////////////////

    private String[] theNames;
    private int[] theValues;
    private int theCurrentValue;

    private Image theBuffer;

    public void paintComponent (Graphics g) {

	Dimension d = getSize();
	if (theBuffer == null)
	    theBuffer = createImage(d.width - 6, d.height - 6);

	Graphics g2 = theBuffer.getGraphics();

	g2.setColor(Color.white);
	g2.fillRect(0, 0, d.width, d.height);

	for (int i = 0; i < theNames.length; i++) {
            int y  = 20 + (i * 20);
            int l  = theValues[i];
            int b1 = Math.min(l, 15);
            int b2 = Math.min(l - 15, 10);
            int b3 = Math.min(Math.max(0, l - 25), 10);

	        g2.setColor(Color.black);
	        g2.drawString(theNames[i] + ":", 10, y);

	        g2.setColor(Color.green);
	        g2.fillRect(120, y - 10, b1 * 5, 10);
	        g2.setColor(Color.yellow);
	        g2.fillRect(195, y - 10, b2 * 5, 10);
	        g2.setColor(Color.red);
	        g2.fillRect(245, y - 10, b3 * 5, 10);
            g2.setColor(theCurrentValue == i ? Color.green : Color.red);
	        g2.fillOval(350, y - 10, 10, 10);
	        g2.setColor(Color.black);
            g2.drawString("" + theValues[i], 300, y);
            g2.drawOval(350, y - 10, 10, 10);
	    }

        g.drawImage(theBuffer, 2, 2, this);

    }

    public TrafficGraph (String[] names) {
    	theNames = new String[names.length];
    	theValues = new int[names.length];

    	for (int i = 0; i < names.length; i++) {
    	    theNames[i]  = new String(names[i]);
    	    theValues[i] = 0;
    	}
    	theCurrentValue = 0;
    }

    public void setValues (int[] values) {
    	for (int i = 0; i < values.length; i++) {
    	    if (i < theValues.length)
    	        theValues[i] = values[i];
    	}
    }

    public void setCurrentValue (int value) {
    	theCurrentValue = value;
    }
}
