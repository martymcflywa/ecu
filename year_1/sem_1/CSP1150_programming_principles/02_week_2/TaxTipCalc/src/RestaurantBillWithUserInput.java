/**
 * Calculates tax and tip for an expensive dinner date
 * Also rounds result to two decimal places
 * Added user input
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140802.2
 */

// import Scanner
import java.util.Scanner;

public class RestaurantBillWithUserInput {

// creating method that rounds result to two decimals
private static double roundTwo(double a) {
	return Math.round(a * 100.0) / 100.0;
}

	public static void main(String[] args) {
		
		// declare tax and tip constants
		final double TAX_RATE = 6.75 / 100.00,
					TIP_RATE = 15.00 / 100.00;
		
		// open Scanner
		Scanner sc = new Scanner(System.in);
		
		// ask for user input
		System.out.print("How much was dinner? $");
		
		// converts input to double
		double meal = sc.nextDouble();
		
		// close Scanner
		sc.close();
		
		// declare meal, will try to add Scanner input here	
		// double meal = 100;
		
		// calculate tax
		double tax = meal * TAX_RATE;
		
		// calculate tip
		double tip = (meal + tax) * TIP_RATE;
		
		// calculate total
		double total = meal + tax + tip;
		
		// print results, calls roundTwo() to do the rounding
		System.out.println("Meal: $" + roundTwo(meal));
		System.out.println("Tax: $" + roundTwo(tax));
		System.out.println("Tip: $" + roundTwo(tip));
		System.out.println("Total: $" + roundTwo(total));
		
	}
}
