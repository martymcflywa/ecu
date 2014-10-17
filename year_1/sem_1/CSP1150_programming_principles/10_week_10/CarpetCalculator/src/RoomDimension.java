/**
 * This class defines the room dimension for CarpetCalculator.
 * See p. 556.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20141017
 */
public class RoomDimension {

	// declare length and width
	private double length;
	private double width;
	
	/**
	 * The constructor. Sets the length and width arguments
	 * to their respective fields.
	 * 
	 * @param double length - The room length.
	 * @param double width - The room width.
	 */
	public RoomDimension(double length, double width) {
		
		this.length = length;
		this.width = width;
	}
	
	/**
	 * This method returns the calculated room area.
	 * 
	 * @return double length * width.
	 */
	public final double getArea() {
		
		return length * width;
	}
}
