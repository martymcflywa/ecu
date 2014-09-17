import java.util.Random;

/**
 * A class for dealing Bridge hands. In the card game Bridge, there are four players
 * who are each dealt a hand of 13 cards from a shuffled deck.
 * 
 * @author phi 
 * @version starter code
 */
public class BridgeHands
{
    /**
     * Method to deal out 4 Bridge hands
     */
    public static void dealHands()
    {
        // some useful constants
        final int SUITS = 4;                    // number of suits in a standard deck
        final int CARDS_PER_SUIT = 13;          // number of cards in each suit
        final int CARDS = SUITS*CARDS_PER_SUIT; // number of cards in a standard deck
        
        // create two arrays to represent a deck of cards
        // one for the values and one for the suits
    
        int[] values = new int[CARDS]; // one for values
        int[] suits = new int[CARDS];  // one for suits
        
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
        
        // "deal" them out

        // some useful constants
        final int HANDS = 4;
        final int CARDS_PER_HAND = CARDS/HANDS;
        
        // to do this, loop over hands
            // and for each hand, loop over cards in the hand
            
        /************** insert your code here to deal out the hands (print them out) ****/
        
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
