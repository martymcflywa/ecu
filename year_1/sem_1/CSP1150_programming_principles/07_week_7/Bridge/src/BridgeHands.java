import java.util.Random;

/**
 * A class for dealing Bridge hands. In the card game Bridge, there are four players
 * who are each dealt a hand of 13 cards from a shuffled deck.
 * 
 * @author phi, Martin Ponce ID# 10371381
 * @version 20140917
 */
public class BridgeHands {
	
	public static void main(String[] args) {
		dealHands();
	}

	/**
	 * Method to deal out 4 Bridge hands
	 */
	public static void dealHands() {
		
		// some useful constants
		// number of suits in a standard deck
		final int SUITS = 4;
		// number of cards in each suit
		final int CARDS_PER_SUIT = 13;
		// number of cards in a standard deck
		final int CARDS = SUITS * CARDS_PER_SUIT;
		
		// create two arrays to represent a deck of cards
		
		// one for values
		int[] values = new int[CARDS];
		// one for suits
		int[] suits = new int[CARDS];
		
		/*
         * the arrays should be filled like this:
         * values = [ 1, 2, ..., 13, 1, 2, ..., 13, 1, 2, ..., 13, 1, 2, ..., 13 ]
         * suits = [ 0, 0, ..., 0,  1, 1, ..., 1,  2, 2, ..., 2,  3, 3, ..., 3  ]
         * where 0 means spades, 1 means clubs, 2 means diamonds and 3 means hearts
         * 
         * So the deck starts with all the spades first, then all the clubs etc.
         * The first card in the deck has value = 1 and suit = 0 i.e. it is the ace of spades
         * The last card in the deck has value 13 and suit 3, i.e. it is the king of hearts
         * 
         * This can be done using nested for loops
         */
		
		/*********** insert your code here to fill the arrays ***************/
		
		// iterate every card, value and suit
		for(int indexCount = 0, valCount = 0, suitCount = 0; indexCount < values.length && valCount < CARDS_PER_SUIT + 1 && suitCount < SUITS + 1; indexCount++, valCount++, suitCount++) {
			
			// if valCount is equal to CARDS_PER_SUIT, set valCount to 0
			if(valCount == CARDS_PER_SUIT) {
				valCount = 0;
			
			// else if suitCount is equal to SUITS, set suitCount to 0
			} else if(suitCount == SUITS) {
				suitCount = 0;
			}
			
			// over every card iteration, set values and suits to counter value + 1
			values[indexCount] += valCount + 1;
			suits[indexCount] += suitCount + 1;
		}
		
		/*
         *  shuffle the deck into randomised order
         *  here is some pseudocode
         *       
         *         Set count To 52
         *         RepeatWhile (count > 1)
         *         BEGIN
         *             randomly choose one of the first count cards of the deck
         *             swap this card with the one at index count-1
         *             Set count To (count - 1)
         *         END
         *         
         *   Hint: to swap the card at location x with the card at location y, for example
         *   
         *   int keepValue = value[x];
         *   value[x] = value[y];
         *   value[y] = keepValue;
         *   
         *   int keepSuit = suit[x];
         *   suit[x] = suit[y];
         *   suit[y] = keepSuit;
         *   
         *   Your code should look similar (but it won't be x and y), and it
         *   should be in a loop.
         */
		
		// first create a random number generator
		Random random = new Random();
		
		// now the shuffle
		
		/************** insert your code here to shuffle the deck *************/
		
		// set count to 52
		int count = 52;
		
		// repeat while count > 1
		while(count > 1) {
			random.nextInt()
		}
		
	}
}
