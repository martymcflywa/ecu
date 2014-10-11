/**
 * A utility class for IPD games
 * 
 * @author CSP1150 & Martin Ponce ID# 10371381
 * @version 20141011
 */
public class IPD {
	
	/**
	 * How many dollars for the first player?
	 * 
	 * @param firstMove the first move
	 * @param secondMove the second move
	 * 
	 * @return the payout for the first player
	 */
	public static int getScore(char firstMove, char secondMove) {
		
		// initialize score
		int score = 0;
		
		// Rule 1: firstMove = c, secondMove = c - get $3 each
		if(firstMove == 'c' && secondMove == 'c') {
			score = 3;
		
		// Rule 2: firstMove = d, secondMove = d - get $1 each
		} else if(firstMove == 'd' && secondMove == 'd') {
			score = 1;
		
		// Rule 3 part 1: firstMove = c, secondMove = d - c gets 0
		} else if(firstMove == 'c' && secondMove == 'd') {
			score = 0;
			
		// Rule 3 part 2: firstMove = d, secondMove = c - d gets 5
		} else if(firstMove == 'd' && secondMove == 'c') {
			score = 5;
		}
		
		// return the score
		return score;
	}
}
