package old.csp1150.assignment1;

// import mouse adapter to listen for mouse events
import java.awt.event.MouseAdapter;

import java.awt.event.MouseEvent;

// import JPanel, adding mouse listeners to JLabels containing graphics
import javax.swing.JLabel;

/**
 * This class extends MouseAdapter to listen for
 * mouse events on the image JPanels.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 4.0.0
 * @since 20140930
 */
public class CalculatorMouseAdapter extends MouseAdapter {
	
	private JLabel imageAnnulus;
	private JLabel imageMandelbrot;
	
	public CalculatorMouseAdapter(JLabel imageAnnulus, JLabel imageMandelbrot) {
		
		this.imageAnnulus = imageAnnulus;
		this.imageMandelbrot = imageMandelbrot;
		
		this.imageAnnulus.addMouseListener(this);
		this.imageAnnulus.addMouseMotionListener(this);
		
		this.imageMandelbrot.addMouseListener(this);
		this.imageMandelbrot.addMouseMotionListener(this);
	}
	
	public void mouseDragged(MouseEvent e) {
		
	}
}
