/**
 * A IPD player that plays uses Pavlov.
 * 
 * Pavlov strategy:
 * 
 * Start with c. If both players
 * played the same move previously,
 * play c, else play d.
 * 
 * @author Martin Ponce ID# 10371381
 * @version 20141011
 */
public class Pavlov {

	/**
	 * Get the first move for this player
	 * 
	 * @return 'c'
	 */
	public char getFirstMove() {
		return 'c';
	}
	
	/**
	 * Get the next move
	 * 
	 * @param myLastMove this player's last move
	 * @param otherLastMove the other player's previous move
	 * 
	 * @return this players next move
	 */
	public char getNextMove(char myLastMove, char otherLastMove) {
		
		// init myNextMove
		char myNextMove = '?';
		
		// if myLastMove is equal to otherLastMove,
		if(myLastMove == otherLastMove) {
			
			// myNextMove will be c
			myNextMove = 'c';
		
		// else
		} else {
			
			// myNextMove will be d
			myNextMove = 'd';
		}
		
		// return myNextMove
		return myNextMove;
	}
	
	/**
	 * Represents the player as a String
	 * 
	 * @return a description of the player
	 */
	public String toString() {
		
		return "Mmmm... Pavlova...";
	}
}
