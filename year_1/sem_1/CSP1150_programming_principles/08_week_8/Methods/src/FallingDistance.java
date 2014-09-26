/**
 * This class calculates the distance travelled
 * during freefall in Earth's gravity.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140926
 */
public class FallingDistance {
	
	// initialized seconds, will be incremented to 10
	private static int seconds = 1;
	
	/**
	 * This is the main method. It contains a loop, counting up to 10.
	 * @param args
	 */
	public static void main(String[] args) {
		
		// print an introductory sentence
		System.out.println("You jumped off a cliff and...");
		
		// while seconds is less than or equal to 10,
		while(seconds <= 10) {
			
			// call printDistance, pass fallingDistance and seconds as args
			printDistance(fallingDistance(seconds), seconds);
			
			// add 1 to seconds
			seconds++;
		}
	}
	
	/**
	 * This method calculates the distance fallen.
	 * @param int time - The seconds falling.
	 * @return double distance - The calculated result.
	 */
	private static double fallingDistance(int time) {
		
		// initializing distance
		double distance = 0.0;
		
		// initializing half
		double half = 0.5;
		
		// initializing value for gravity
		double gravity = 9.8;
		
		// calculating distance
		distance = half * gravity * Math.pow(time, 2);
		
		// return calculated distance
		return distance;
	}
	
	/**
	 * This method prints the calculated distance.
	 * Using Math.round() to round the result.
	 * @param double result - The calculated distance.
	 * @param int seconds - The current current seconds iteration.
	 */
	private static void printDistance(double result, int seconds) {
		
		// if seconds == 1, print this line
		if(seconds == 1) {
			System.out.println("travelled " + Math.round(result * 100) / 100.0 + " meters in " + seconds + " second.");
			
		// else print this line
		} else {
			System.out.println("travelled " + Math.round(result * 100) / 100.0 + " meters in " + seconds + " seconds.");
		}
	}
}
