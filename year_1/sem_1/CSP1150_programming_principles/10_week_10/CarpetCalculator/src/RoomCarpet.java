/**
 * This class performs the calculation for CarpetCalculator.
 * See p. 556.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20141017
 */
public class RoomCarpet {

	// declare the RoomDimension object
	private RoomDimension theDimension;
	
	// declare calculated carpetCost
	private double carpetCost;
	
	/**
	 * The constructor. Sets the imported object and cost
	 * to their respective fields.
	 * 
	 * @param RoomDimension theDimension - The imported object.
	 * @param double cost - The cost per sq meter.
	 */
	public RoomCarpet(RoomDimension theDimension, double cost) {
		
		this.theDimension = theDimension;
		this.carpetCost = theDimension.getArea() * cost;
	}
	
	/**
	 * This method returns the calculated carpetCost.
	 * Bypassed by RoomCarpet constructor.
	 * 
	 * @return double dimension * carpetCost
	 */
	public final double getTotalCost() {
		
		return theDimension.getArea() * carpetCost;
	}
	
	/**
	 * This method overrides toString to print the result to console.
	 * 
	 * @param args unused
	 */
	@Override
	public String toString() {
		
		String str = "===================\nA " + theDimension.getArea() + " sq meter room will cost $" + carpetCost + " to lay carpet.";
		
		return str;
	}
}
