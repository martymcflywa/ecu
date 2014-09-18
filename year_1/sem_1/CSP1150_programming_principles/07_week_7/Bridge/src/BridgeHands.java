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
		
		// card index counter
		int cardIndexFill = 0;
		// suit counter
		int suitIndexFill = 0;
		
		// iterate over suits
		for(int loopSuits = 0; loopSuits < SUITS; loopSuits++) {
			
			// iterate over cards
			for(int loopCards = 0; loopCards < CARDS_PER_SUIT; loopCards++) {
				
				// set current values[] to loopCards + 1
				values[cardIndexFill] = loopCards + 1;
				
				// set current suits[] to suit counter + 1
				suits[cardIndexFill] = suitIndexFill + 1;
				
				// add 1 to card counter
				cardIndexFill++;
				
				// if suit counter == SUITS
				if(suitIndexFill == SUITS - 1) {
					
					// set suit counter to 0
					suitIndexFill = 0;
				
				// else if suit counter < SUITS
				} else if(suitIndexFill < SUITS) {
					
					// add 1 to suit counter
					suitIndexFill++;
				}
			}
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
			
			// generate random position integers within values.length
			int randomIndex1 = random.nextInt(values.length);
			int randomIndex2 = random.nextInt(values.length);
			
			// swap values with random positions
			int keepValues = values[randomIndex1];
			values[randomIndex1] = values[randomIndex2];
			values[randomIndex2] = keepValues;
			
			// swap suits with random positions
			int keepSuits = suits[randomIndex1];
			suits[randomIndex1] = suits[randomIndex2];
			suits[randomIndex2] = keepSuits;
			
			// decrease count by 1
			count--;
		}
		
		// deal the cards
		
		// some useful constants
		final int HANDS = 4;
		final int CARDS_PER_HAND = CARDS / HANDS;
		
		// to do this, loop over hands
		// and for each hand, loop over cards in the hand
		
		/************** insert your code here to deal out the hands (print them out) ****/
		
		// declare the cardIndex for dealing
		int cardIndexDeal = 0;
		
		// iterate over HANDS
		for(int handIndex = 0; handIndex < HANDS; handIndex++) {
			
			// set playerNumber
			int playerNumber = handIndex + 1;
			
			// print each playerNumber before printing cards
			if(playerNumber == 1) {
				System.out.println("Player " + playerNumber + "'s hand:");
				System.out.println("=================");
			} else {
				System.out.println("\nPlayer " + playerNumber + "'s hand:");
				System.out.println("=================");
			}
			
			// iterate CARDS_PER_HAND
			for(int cardsPerHandIndex = 0; cardsPerHandIndex < CARDS_PER_HAND; cardsPerHandIndex++) {
				
				// set dealValues and dealSuits to cardIndexDeal
				int dealValues = values[cardIndexDeal];
				// minus 1 for dealSuits to account for ArrayIndexOutOfBoundsException in SUIT_NAMES[]
				int dealSuits = suits[cardIndexDeal] - 1;
				
				// add 1 to dealCardIndex
				cardIndexDeal++;
				
				// print each card, call cardName() to convert array values to card names
				if(cardsPerHandIndex == CARDS_PER_HAND - 1) {
					System.out.println(cardName(dealSuits, dealValues));
					System.out.println("-----------------");
				} else {
					System.out.println(cardName(dealSuits, dealValues));
				}
				
			}
		}
	}
	
    /**
     * Helper method to get the name of a card
     * 
     * @param suit - the suit 0 = spades, 1 = clubs, 2 = diamonds, 3 = hearts
     * @param value - 1 up to 13, 11 is jack, 12 is queen, 13 is king
     * 
     * @return the name of the card e.g. "ace of diamonds"
     */
    public static String cardName(int suit, int value)
    {
        final String[] CARD_NAMES =
            {"not used", "ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};
        final String[] SUIT_NAMES = 
            {"spades", "clubs", "diamonds", "hearts"};
            
        return CARD_NAMES[value] + " of " + SUIT_NAMES[suit];
    }
}
