import java.util.Scanner;

/**
 * A IPD player that is human
 * 
 * @author CSP1150
 * @version 1
 */
public class HumanPlayer {
	
	private Scanner scanner = new Scanner(System.in);

	/**
	 * Get the first move for this player
	 * 
	 * @return the move
	 */
	public char getFirstMove() {
		
		System.out.print("Enter your move: ");
		String input = scanner.next().trim();

		return input.charAt(0);
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
		
		System.out.println("You played " + myLastMove
				+ " and the opponent played " + otherLastMove);
		
		System.out.print("Enter your move: ");
		String input = scanner.next().trim();

		return input.charAt(0);
	}

	/**
	 * Represents the player as a String
	 * 
	 * @return a description of the player
	 */
	public String toString() {
		return "Human";
	}
}
