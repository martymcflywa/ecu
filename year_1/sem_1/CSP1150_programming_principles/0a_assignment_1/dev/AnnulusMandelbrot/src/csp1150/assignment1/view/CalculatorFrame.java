package csp1150.assignment1.view;

// the layout manager
import java.awt.GridLayout;

// inherit from JFrame
import javax.swing.JFrame;

/**
 * This class inherits from JFrame and defines the Calculator Frame.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 5.3.1
 * @since 20141024
 */
@SuppressWarnings("serial")
public class CalculatorFrame extends JFrame {
	
	/**
	 * The constructor.
	 * 
	 * @param args unused.
	 */
	public CalculatorFrame() {
		
		// set frame title
		super("Annulus & Mandelbrot Calculator: Martin Ponce ID# 10371381");
		
		// set frame size
		this.setBounds(100, 100, 920, 940);
		
		// disable frame resize
		this.setResizable(false);
		
		// set default action when window is closed
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set frame to appear in the center of the desktop
		this.setLocationRelativeTo(null);
		
		// use gridlayout to divide frame into 2 columns with 5px padding
		this.getContentPane().setLayout(new GridLayout(0, 2, 5, 5));
	}
}
