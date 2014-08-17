import java.util.Scanner;

/**
 * Asks for user input for three names then sorts those names in alphabetical order.
 * Note: case ignored
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140817
 */
public class SortedNames {
	public static void main(String[] args) {
		
		// calls userInput() which asks for names from user, then calls nameSort()
		userInput();		
	}
	
	static void userInput() {
		
		// ask user for three names
		Scanner sc = new Scanner(System.in);
		System.out.println("Let's sort three names in alphabetical order...");
		System.out.print("Enter the first name:");
		String name1 = sc.nextLine();
		System.out.print("Enter the second name:");
		String name2 = sc.nextLine();
		System.out.print("Enter the third name:");
		String name3 = sc.nextLine();
		sc.close();
		
		// calls nameSort() to sort names and send output to console
		SortedNames.nameSort(name1, name2, name3);
	}
	
	// nameSort() performs sorting and sends output to console
	static void nameSort(String name1, String name2, String name3) {
		if(name1.compareToIgnoreCase(name2) < 0 && name2.compareToIgnoreCase(name3) < 0) {
			System.out.println(name1);
			System.out.println(name2);
			System.out.println(name3);
		}
		else if(name1.compareToIgnoreCase(name3) < 0 && name3.compareToIgnoreCase(name2) < 0) {
			System.out.println(name1);
			System.out.println(name3);
			System.out.println(name2);
		}
		else if(name2.compareToIgnoreCase(name1) < 0 && name1.compareToIgnoreCase(name3) < 0) {
			System.out.println(name2);
			System.out.println(name1);
			System.out.println(name3);
		}
		else if(name2.compareToIgnoreCase(name3) < 0 && name3.compareToIgnoreCase(name1) < 0) {
			System.out.println(name2);
			System.out.println(name3);
			System.out.println(name1);
		}
		else if(name3.compareToIgnoreCase(name1) < 0 && name1.compareToIgnoreCase(name2) < 0) {
			System.out.println(name3);
			System.out.println(name1);
			System.out.println(name2);
		}
		else {
			System.out.println(name3);
			System.out.println(name2);
			System.out.println(name1);
		}
	}
}
