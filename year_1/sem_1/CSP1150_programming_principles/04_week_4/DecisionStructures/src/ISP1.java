import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
 * Calculates customer's monthly bill
 * depending on chosen package and usage
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140817
 */
public class ISP1 {
	
// declare constants
static final double A_MONTHLY = 9.95;
static final double A_HOURLY = 2.0;
static final double B_MONTHLY = 13.95;
static final double B_HOURLY = 1.0;
static final double C_MONTHLY = 19.95;

static String plan;
static double hours;

// define decimal format
static String decimalPattern = "###,###.##";
static DecimalFormat decimalFormat = new DecimalFormat(decimalPattern);
	
	// main
	public static void main(String[] args) {
		
		// calls getPlanInput() to find out which plan the user purchased
		getPlanInput();
		
		// exception handling for invalid user input
		if(plan.equalsIgnoreCase("a") || plan.equalsIgnoreCase("b") || plan.equalsIgnoreCase("c")) {
			// if input is valid, continue with program
			getHoursInput();
			comparePlan(plan);
		}
		else {
			// else input is incorrect, start again
			JOptionPane.showMessageDialog(null, "You have entered an invalid character, please start again and enter either A,B or C.");
			getPlanInput();
			getHoursInput();
			comparePlan(plan);
		}
	}
	
	// asks for user input for purchased plan
	static void getPlanInput() {
		String inputPlan = JOptionPane.showInputDialog("Which internet plan did you purchase - A,B or C?");
		plan = inputPlan;
	}
	
	// asks for user input for how many hours used
	static void getHoursInput() {
		String inputHours = JOptionPane.showInputDialog("How many hours have you used this month?");
		double hours = Double.parseDouble(inputHours);
		ISP1.hours = hours;
	}
	
	// determines total cost for month depending which plan is purchased, output result to JOptionPane
	static void comparePlan(String chosenPlan) {
		switch(chosenPlan) {
			case "a":
				if(hours > 10) {
					double extraA = hours * A_HOURLY;
					double totalA = extraA + A_MONTHLY;
					String totalAFormat = decimalFormat.format(totalA);
					JOptionPane.showMessageDialog(null, "You have chosen Plan A, and your total bill for the month is: $" + totalAFormat);
				}
				else {
					JOptionPane.showMessageDialog(null, "You have chosen Plan A, and your total bill for the month is: $" + A_MONTHLY);
				}
				break;
			case "b":
				if(hours > 20) {
					double extraB = hours * B_HOURLY;
					double totalB = extraB + B_MONTHLY;
					String totalBFormat = decimalFormat.format(totalB);
					JOptionPane.showMessageDialog(null, "You have chosen Plan B, and your total bill for the month is: $" + totalBFormat);
				}
				else {
					JOptionPane.showMessageDialog(null, "You have chosen Plan B, and your total bill for the month is: $" + B_MONTHLY);
				}
				break;
			case "c":
				JOptionPane.showMessageDialog(null, "You have chosen plan C, and your total bill for the month is: $" + C_MONTHLY);
				break;
		}
	}
}