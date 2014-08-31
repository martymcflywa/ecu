/**
 * Prints patterns using for loops.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20140831
 */
public class ForLoopPatterns {

// declare constants for pattern size and position of cross
// cross is at 3rd row and 3rd column but index is at 0, so CROSS_POS = 2
static final int BASE_SIZE = 5;
static final int CROSS_POS = 2;
	
	public static void main(String[] args) {
		
		// main calls pattern methods
		patternA();
		patternB();
		patternC();
		patternD();
	}
	
	// patternA method
	static void patternA() {
				
		System.out.println("Pattern A\n");
		
		// iterate each row of BASE_SIZE
		for(int row = 0; row < BASE_SIZE; row++) {
			
			// print "*" for each column iteration of BASE_SIZE
			for(int col = 0; col < BASE_SIZE; col++) {
				System.out.print("*");
			}
			
		// return cursor to next line for each row of BASE_SIZE
		System.out.println();
		}
		
		// spacer for next pattern
		System.out.println();
	}
	
	// patternB method
	static void patternB() {
		
		System.out.println("Pattern B\n");
		
		// iterate each row of BASE_SIZE
		for(int row = 0; row < BASE_SIZE; row++) {
			
			// iterate each column of BASE_SIZE
			for(int col = 0; col < BASE_SIZE; col++) {
				
				// if row == CROSS_POS, print "+"
				if(row == CROSS_POS) {
					System.out.print("+");
					
				// else print "*"
				} else {
					System.out.print("*");
				}
			}
			
		// return cursor to next line for each row of BASE_SIZE
		System.out.println();
		}
		
		// spacer for next pattern
		System.out.println();
	}
	
	// patternC method
	static void patternC() {
		
		System.out.println("Pattern C\n");
		
		// iterate each row of BASE_SIZE
		for(int row = 0; row < BASE_SIZE; row++) {
			
			// iterate each column of BASE_SIZE
			for(int col = 0; col < BASE_SIZE; col++) {
				
				// if row == CROSS_POS, print "+"
				if(col == CROSS_POS) {
					System.out.print("+");
					
				// else print "*"
				} else {
					System.out.print("*");
				}
			}
			
		// return cursor to next line for each row of BASE_SIZE
		System.out.println();
		}
	
		// spacer for next pattern
		System.out.println();
	}
	
	// patternD method
	static void patternD() {
		
		System.out.println("Pattern D\n");
		
		// iterate each row of BASE_SIZE
		for(int row = 0; row < BASE_SIZE; row++) {
			
			// iterate each column of BASE_SIZE
			for(int col = 0; col < BASE_SIZE; col++) {
				
				// if row OR col == CROSS_POS, print "+"
				if(row == CROSS_POS || col == CROSS_POS) {
					System.out.print("+");
				
				// else print "*"
				} else {
					System.out.print("*");
				}
			}
			
		// return cursor to next line for each row of BASE_SIZE
		System.out.println();
		}
	}	
}
