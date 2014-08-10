/**
 * Asks for user input and manipulates string
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140810
 */
import javax.swing.JOptionPane;

public class StringManipulator {

	public static void main(String[] args) {
		String cityName = JOptionPane.showInputDialog("What is your favourite city?");
		int cityLength = cityName.length();
		String cityUpper = cityName.toUpperCase();
		String cityLower = cityName.toLowerCase();
		char cityFirst = cityName.charAt(0);
		
		JOptionPane.showMessageDialog(null, cityName + " is " + cityLength + " characters long.");
		JOptionPane.showMessageDialog(null, cityUpper + " IN UPPERCASE.");
		JOptionPane.showMessageDialog(null, cityLower + " in lowercase.");
		JOptionPane.showMessageDialog(null, "The first letter of " + cityName + " is " + cityFirst + ".");
		
		System.exit(0);
	}
}
