import java.util.Scanner;
import java.util.ArrayList;

/**
 * Identifies the largest and smallest integers input by user and displays result.
 * Stores user input in numberArray, sorts user input and prints highest and lowest integers.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140831
 */

// see page 224, 268
public class LargestAndSmallest {
	
// declare sentinel constant
static final int SENTINEL = -99;

// create Scanner object, accepts user input
static Scanner sc = new Scanner(System.in);

// create ArrayList object, stores integers from user input
static ArrayList<Integer> numberArray = new ArrayList<Integer>();

	public static void main(String[] args) {
		
		// call getUserInput() to begin program
		getUserInput();
		
		// if loop checking if numberArray is empty
		if(numberArray.isEmpty()) {
			
			// numberArray is empty as user entered SENTINEL as first input, program ends and asks user to start again
			System.out.println("You entered -99 as your first integer and there are no numbers to sort. Restart the program.");
			
		// else numberArray is not empty, continue with sortUserInput() method
		} else {
			sortUserInput();
		}
	}
	
	// user input
	static void getUserInput() {
		
		System.out.println("This program will identify the highest and lowest integer you have entered");
		System.out.println("Please enter a series of integers. Enter -99 when finished.");
		
		// store user input as integer
		int userInt = sc.nextInt();
		
		// while loop, stores user input to numberArray ArrayList 
		while (userInt != SENTINEL) {
			numberArray.add(userInt);
			userInt = sc.nextInt();
		}
		
		// user enters SENTINEL, while loop ends, close Scanner object
		sc.close();
	}
	
	// sorts user input with ArrayList method .sort(), prints last and first items in array
	static void sortUserInput() {
		numberArray.sort(null);
		System.out.println("------------------------------------------");
		System.out.println("The highest integer you entered is: " + numberArray.get(numberArray.size() - 1));
		System.out.println("The lowest integer you entered is: " + numberArray.get(0));
	}
}
