// import Scanner, getting user input
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
	
	private static double presentValue;
	private static double futureValue;
	private static double interestRate;
	private static double years;
	
	public static void main(String[] args) {
		getUserInput();
		getCalculation(futureValue, interestRate, years);
		printCalculation(futureValue, interestRate, years, presentValue);
		
//		if(years > 0) {
//			printCalculation(futureValue, interestRate, years, presentValue);
//		} else {
//			printZeroYears(years);
//		}
	}
	
	private static void getUserInput() {
		
		// create Scanner object
		Scanner kb = new Scanner(System.in);
		
		// print title
		System.out.println("Bank Deposit Calculation: \n-----------------------");
		
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
	
	private static void getCalculation(double fValue, double intRate, double years) {
		
		intRate = intRate + 1;
		presentValue = fValue / Math.pow(intRate, years);

	}
	
	private static void printCalculation(double fValue, double intRate, double years, double pValue) {
		System.out.println("If you want to earn " + fValue + " and can only wait " + years + " years...");
		System.out.println("You need to deposit $" + pValue + " into Marty's bank account right now!");
	}
	
	private static void printZeroYears(double years) {
		System.out.println("You can't wait even a year?...");
		System.out.println("You could try robbing the bank instead...");
	}
}
