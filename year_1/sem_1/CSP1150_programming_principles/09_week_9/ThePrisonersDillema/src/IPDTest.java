/**
 * A program to test some IPD players
 * 
 * The players are in different classes
 * 
 * @author CSP1150
 * @version 1
 */
public class IPDTest {
	
	/** main method plays this many games */
	private static final int NUMBER_OF_GAMES = 10;

	/** This is the first player */
	// private static HumanPlayer player0 = new HumanPlayer();
	// private static TitForTat player0 = new TitForTat();
	private static SuspiciousTitForTat player0 = new SuspiciousTitForTat();
	// private static Grim player0 = new Grim();
	// private static Pavlov player0 = new Pavlov();

	/** This is the second player */
	// private static HumanPlayer player1 = new HumanPlayer();
	// private static TitForTat player1 = new TitForTat();
	// private static SuspiciousTitForTat player1 = new SuspiciousTitForTat();
	private static Grim player1 = new Grim();

	// private static Pavlov player1 = new Pavlov();

	public static void main(String[] args) {
		
		char lastMove0 = '?';
		char lastMove1 = '?';
		int total0 = 0;
		int total1 = 0;

		// player NUMBER_OF_GAMES rounds
		for (int game = 0; game < NUMBER_OF_GAMES; game++) {
			
			char move0, move1;

			if (game == 0) {
				
				// choose a move : first player
				move0 = player0.getFirstMove();
				// choose a move : second player
				move1 = player1.getFirstMove();
				
			} else {
				
				// choose a move : first player
				move0 = player0.getNextMove(lastMove0, lastMove1);
				// choose a move : second player
				move1 = player1.getNextMove(lastMove1, lastMove0);
			}

			int score0 = IPD.getScore(move0, move1);
			int score1 = IPD.getScore(move1, move0);

			total0 += score0;
			total1 += score1;

			lastMove0 = move0;
			lastMove1 = move1;
		}

		// Announce the overall winner
		if (total0 > total1) {
			
			System.out.println(player0 + " beats " + player1);
			System.out.println("\t" + total0 + " dollars to " + total1);
			
		} else if (total1 > total0) {
			
			System.out.print(player1 + " beats " + player0);
			System.out.println("\t" + total1 + " dollars to " + total0);
			
		} else {
			
			System.out.println("It's a tie: " + total0 + " dollars each");
		}
	}
}
