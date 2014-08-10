/**
 * Play a word game
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140810
 */
import javax.swing.JOptionPane;

public class WordGame {
	public static void main(String[] args) {
		String name = JOptionPane.showInputDialog("What is your name?");
		String age = JOptionPane.showInputDialog("How old are you?");
		String city = JOptionPane.showInputDialog("Which city do you live in?");
		String uni = JOptionPane.showInputDialog("Which University do attend?");
		String profession = JOptionPane.showInputDialog("What is your dream profession?");
		String animal = JOptionPane.showInputDialog("What kind of pet do you have?");
		String petName = JOptionPane.showInputDialog("What is your pet's name?");
		
		JOptionPane.showMessageDialog(null, "There once was a person named " + name + " who lived in " + city + ".");
		JOptionPane.showMessageDialog(null,"At the age of " + age + ", " + name + " went to uni at " + uni + ".");
		JOptionPane.showMessageDialog(null, name + " graduated and went to work as a " + profession + ".");
		JOptionPane.showMessageDialog(null, "Then, " + name + " adopted a(n) " + animal + " named " + petName + ".");
		JOptionPane.showMessageDialog(null, "They both lived happily ever after.");
		
		System.exit(0);
	}
}
