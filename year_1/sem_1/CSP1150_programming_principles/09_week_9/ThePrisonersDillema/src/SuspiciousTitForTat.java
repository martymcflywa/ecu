/**
 * A IPD player that plays uses tit-for-tat, starting with 'd'
 * 
 * @author CSP1150
 * @version 1
 */
public class SuspiciousTitForTat {
	
	/**
	 * Get the first move for this player
	 * 
	 * @return 'd'
	 */
	public char getFirstMove() {
		
		return 'd';
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
		
		return otherLastMove;
	}

	/**
	 * Represents the player as a String
	 * 
	 * @return a description of the player
	 */
	public String toString() {
		
		return "SuspiciousTitForTat";
	}
}
