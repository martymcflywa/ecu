import javax.swing.JOptionPane;
import java.text.DecimalFormat;

/**
 * Calculates customer's monthly bill depending on chosen package and usage.
 * Also notifies customer of possible savings on other plan/s.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140817
 */
public class ISP2 {
	
// declare constants
static final double A_MONTHLY = 9.95;
static final double A_HOURLY = 2.0;
static final double B_MONTHLY = 13.95;
static final double B_HOURLY = 1.0;
static final double C_MONTHLY = 19.95;

// declare plan, stores user input for chosen plan
static String plan;
// declare hours, stores user input for hours used
static double hours;

// define decimalPattern and create decimalFormat object
static String decimalPattern = "###,###.##";
static DecimalFormat decimalFormat = new DecimalFormat(decimalPattern);
	
	// main
	public static void main(String[] args) {

		// calls getPlanInput() to find out which plan the user purchased
		getPlanInput();
		
		// exception handling for invalid user input, ignores case
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
		hours = Double.parseDouble(inputHours);
	}
	
	// determines total cost for month depending which plan is purchased, output result to JOptionPane
	static void comparePlan(String chosenPlan) {
		switch(chosenPlan) {
			case "a":
				// for plan A, if usage is over 10 hours, calculate how much extra to pay and display total
				if(hours > 10) {
					double extraHoursA = hours - 10;
					double extraCostA = extraHoursA * A_HOURLY;
					double totalA = extraCostA + A_MONTHLY;
					String totalAFormat = decimalFormat.format(totalA);
					JOptionPane.showMessageDialog(null, "You have chosen Plan A, and your total bill for the month is: $" + totalAFormat);
					// calls compareAToBAndC() to determine if savings are possible on another plan
					compareAToBAndC(totalA);
				}
				// otherwise just show the monthly fee as total
				else {
					JOptionPane.showMessageDialog(null, "You have chosen Plan A, and your total bill for the month is: $" + A_MONTHLY);
				}
				break;
			case "b":
				// for plan B, if usage is over 20 hours, calculate how much extra to pay
				if(hours > 20) {
					double extraHoursB = hours - 20;
					double extraCostB = extraHoursB * B_HOURLY;
					double totalB = extraCostB + B_MONTHLY;
					String totalBFormat = decimalFormat.format(totalB);
					JOptionPane.showMessageDialog(null, "You have chosen Plan B, and your total bill for the month is: $" + totalBFormat);
					// calls compareBToC() to determine if savings are possible on another plan
					compareBToC(totalB);
				}
				// otherwise just show the monthly fee as total
				else {
					JOptionPane.showMessageDialog(null, "You have chosen Plan B, and your total bill for the month is: $" + B_MONTHLY);
				}
				break;
			case "c":
				// for plan C, show the monthly fee as total
				JOptionPane.showMessageDialog(null, "You have chosen plan C, and your total bill for the month is: $" + C_MONTHLY);
				break;
		}
	}
	
	// compares cost from plan A with plan B and C
	static void compareAToBAndC(double totalA) {
		// calculate total if user chose plan B
		double totalB = B_MONTHLY + ((hours - 20) * B_HOURLY);
		// get delta between plan A and plan B
		double deltaAB = totalA - totalB;
		// get delta between plan A and plan C
		double deltaAC = totalA - C_MONTHLY;
		// format deltas with decimalFormat
		String deltaABFormat = decimalFormat.format(deltaAB);
		String deltaACFormat = decimalFormat.format(deltaAC);
		
		// if plan B results in more savings, show how much user can save
		if(deltaAB > deltaAC) {
			JOptionPane.showMessageDialog(null, "You could have saved $" + deltaABFormat + " if you were on Plan B!");
			JOptionPane.showMessageDialog(null, "Call Failstra or Noptus to switch plans today!");
		}
		// if plan C results in more savings, show how much user can save
		else if(deltaAC > deltaAB) {
			JOptionPane.showMessageDialog(null, "You could have saved $" + deltaACFormat + " if you were on Plan C!");
			JOptionPane.showMessageDialog(null, "Call Failstra or Noptus to switch plans today!");
		}
	}
	
	// compares cost from plan B with plan C
	static void compareBToC(double totalB) {
		// get delta between plan B and plan C
		double deltaBC = totalB - C_MONTHLY;
		String deltaBCFormat = decimalFormat.format(deltaBC);
		
		// if plan C results in savings over $0, show how much user can save
		if(deltaBC > 0) {
			JOptionPane.showMessageDialog(null, "You could have saved $" + deltaBCFormat + " if you were on Plan C!");
			JOptionPane.showMessageDialog(null, "Call Failstra or Noptus to switch plans today!");
		}
	}
}