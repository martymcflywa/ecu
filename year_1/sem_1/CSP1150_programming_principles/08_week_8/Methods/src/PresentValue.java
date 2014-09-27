// import Scanner for console user input
import java.util.Scanner;

/**
 * This class calculates the present value
 * for a bank deposit left to accumulate interest
 * for 10 years.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140926
 */
public class PresentValue {
	
	// store calculated present value here
	private static double presentValue;
	
	// store user input for futuer value here
	private static double futureValue;
	
	// store user input for interest rate here
	private static double interestRate;
	
	// store user input for years here
	private static double years;
	
	/**
	 * This is the main method.
	 * @param args
	 */
	public static void main(String[] args) {
		
		// get user input
		getUserInput();
		
		// get calculation using user input values
		getCalculation(futureValue, interestRate, years);

		// if years > 0,
		if(years > 0) {
			
			// call printCalculation method to print result
			printCalculation(futureValue, interestRate, years, presentValue);
			
		// else, 
		} else {
			
			// call printZeroYears if they can't wait for at least a year
			printZeroYears(years);
		}
	}
	
	/**
	 * This void method gets user input and
	 * stores them to the declared variables.
	 * @param args unused.
	 */
	private static void getUserInput() {
		
		// create Scanner object
		Scanner kb = new Scanner(System.in);
		
		// print title
		System.out.println("Future Value Calculator: \n-----------------------");
		
		// get user input for desired bank balance
		System.out.println("How much would you like your bank balance to be?");
		futureValue = kb.nextDouble();
		
		// get user input for interest rate
		System.out.println("How much is your bank's annual interest rate?");
		interestRate = kb.nextDouble();
		
		// get user input for length of time
		System.out.println("How many years can you stop yourself from withdrawing from your account?");
		years = kb.nextDouble();
		
		// close Scanner object
		kb.close();
	}
	
	/**
	 * This method performs the present value calculation.
	 * All args are doubles, including years since Math.pow only
	 * accepts doubles.
	 * @param double fValue - User input future value.
	 * @param double intRate - User input interest rate.
	 * @param double years - User input years.
	 */
	private static void getCalculation(double fValue, double intRate, double years) {
		
		// convert interest rate to usable format + 1
		intRate = intRate / 100 + 1;
		
		// assign presentValue with calculated result
		presentValue = fValue / Math.pow(intRate, years);
	}
	
	/**
	 * This method prints the result to console.
	 * Uses printf to format numbers.
	 * @param double fValue - User input future value.
	 * @param double intRate - User input interest rate.
	 * @param double years - User input years.
	 * @param double pValue - Calculated present value.
	 */
	private static void printCalculation(double fValue, double intRate, double years, double pValue) {
		System.out.println("-----------------------");
		System.out.printf("If you want to earn $%.0f and can only wait %.0f years...\n", fValue, years);
		System.out.printf("you should deposit $%.2f into Marty's bank account right now!", pValue);
	}
	
	/**
	 * This method prints a message if user inputs zero as years.
	 * @param double years
	 */
	private static void printZeroYears(double years) {
		System.out.println("You can't wait even a year?...");
		System.out.println("You could try robbing the bank instead...");
	}
}
