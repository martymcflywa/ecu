/**
 * A IPD player that is grim
 * 
 * @author CSP1150
 * @version 1
 */
public class Grim {
	
	// has the other player ever played 'd' ?
	private boolean otherPlayedD = false;

	/**
	 * Get the first move for this player
	 * 
	 * @return 'c'
	 */
	public char getFirstMove() {
		otherPlayedD = false;

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
		
		otherPlayedD = otherPlayedD || otherLastMove == 'd';

		char move = otherPlayedD ? 'd' : 'c';

		return move;
	}

	/**
	 * Represents the player as a String
	 * 
	 * @return a description of the player
	 */
	public String toString() {
		
		return "Grim";
	}
}
