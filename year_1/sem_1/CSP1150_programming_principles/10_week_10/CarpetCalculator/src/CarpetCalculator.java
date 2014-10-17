import java.util.Scanner;

/**
 * This class contains the user input methods and main method for CarpetCalculator.
 * See p. 556.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20141017
 */
public class CarpetCalculator {

	// declare the objects
	private RoomDimension theRoom;
	private RoomCarpet theCarpet;
	
	// declare the room dimensions and cost per sq meter.
	private double length;
	private double width;
	private double price;
	
	/**
	 * The constructor. Calls methods to get
	 * user input, perform calculation and print result.
	 * 
	 * @param args unused
	 */
	public CarpetCalculator() {
		
		getUserInput();
		setArea(length, width);
		setTotalCost(theRoom, price);
	}
	
	/**
	 * The main method. Program executes here.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		CarpetCalculator theCalculator = new CarpetCalculator();
	}
	
	/**
	 * This method gets user input for room width,
	 * length and cost per sq meter.
	 * 
	 * @param args unused
	 */
	private final void getUserInput() {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Carpet Cost Calculator:\n-------------------\n");
		
		System.out.print("Enter the room length: ");
		length = sc.nextDouble();
		
		System.out.print("Enter the room width: ");
		width = sc.nextDouble();
		
		System.out.print("Enter the price (per square meter): ");
		price = sc.nextDouble();
		
		sc.close();
	}
	
	/**
	 * This method sets the area to RoomDimension object.
	 * 
	 * @param double length - The room length.
	 * @param double width - The room width.
	 */
	private final void setArea(double length, double width) {
		
		theRoom = new RoomDimension(length, width);
	}
	
	/**
	 * This method sets the total cost to RoomCarpet object.
	 * 
	 * @param RoomDimension theRoom - The room object.
	 * @param double price - The price per sq meter.
	 */
	private final void setTotalCost(RoomDimension theRoom, double price) {
		
		theCarpet = new RoomCarpet(theRoom, price);
		theCarpet.getTotalCost(); 
		System.out.println(this.theCarpet.toString());
	}
}
