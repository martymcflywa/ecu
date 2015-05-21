import WattBrown.*;
import java.util.Iterator;
import java.awt.Panel;

public class GameTree {

    private Tree gameTree;
    private Tree.Node currentNode;

    //////////// Constructors ////////////

    public GameTree (byte player) {
    // Construct a new game tree containing the opening position
    // with player as the starting player.
        gameTree = new LinkedUnorderedTree();
        GamePosition pos = new GamePosition(player);
        gameTree.makeRoot(pos);
        currentNode = gameTree.root();
    }

    //////////// Accessors ////////////

    public boolean isOver () {
    // Return true if and only if the game is over.
    	GamePosition pos = (GamePosition) currentNode.getElement();
    	return pos.isTerminalPosition();
    }

    public byte getWinner () {
    // Return the identity of the winning player, or 0 if it is a draw.
        GamePosition pos = (GamePosition) currentNode.getElement();
        if (pos.isWinner(GamePosition.COMPUTER_PLAYER))
            return GamePosition.COMPUTER_PLAYER;
        else if (pos.isWinner(GamePosition.HUMAN_PLAYER))
            return GamePosition.HUMAN_PLAYER;
        else
            return 0;
    }

    public boolean isValidMove (int move) {
    // Return true iff move is a valid move in the current position.
        GamePosition pos = (GamePosition) currentNode.getElement();
        return pos.isValidMove(move);
    }

    public void drawBoard (Panel panel) {
    // Draw a representation of the board in the current position on the
    // given panel.
        GamePosition pos = (GamePosition) currentNode.getElement();
        pos.drawBoard(panel);
    }

    public String toString () {
    	return ((LinkedUnorderedTree )gameTree).toString(currentNode);
    }

    //////////// Transformers ////////////

    public void calculateScore (byte player, int ply) {
    // Calculate the score for a move by player using the current position
    // stored in the game tree. Look up to ply moves ahead.
        calculateScore(currentNode, player, ply);
    }

    public void playBestMove () {
    // Play the best move from the current node, and update the
    // current node. Sibling nodes of the chosen node are removed.
	GamePosition pos = (GamePosition) currentNode.getElement();
	int bestScore = pos.getScore();

	// Flag indicating if we have found a move that ends the game.
	boolean foundEndMove = false;
	Iterator iter = gameTree.children(currentNode);
	currentNode = null;
	while (iter.hasNext()) {
	    Tree.Node nextNode = (Tree.Node) iter.next();
	    GamePosition nextPos = (GamePosition) nextNode.getElement();
	    if (nextPos.getScore() == bestScore && ! foundEndMove) {
	        // Decide if this is the best move, prefer an end move to any
                // other.
		if (nextPos.isTerminalPosition()) {
		    // This node represents an end move, so remove any previous
		    // node, and choose it.
	            if (currentNode != null)
			gameTree.remove(currentNode);
		    currentNode = nextNode;
		    foundEndMove = true;
		} else {
		    // If another move has not already been chosen, choose this
		    // node, otherwise remove it.
		    if (currentNode == null)
		        currentNode = nextNode;
		    else
		        iter.remove();
		}
	    } else {
		// Either this position does not have the best score, or we have
		// already found an end move.
		iter.remove();
	    }
	}
    }

    public void playMove (byte player, int move) {
    // Play the given move in the current position, and update the
    // current position.
        GamePosition pos = (GamePosition) currentNode.getElement();
        Iterator iter = gameTree.children(currentNode);
        boolean played = false;
        while (iter.hasNext()) {
            Tree.Node nextNode = (Tree.Node) iter.next();
            GamePosition nextPos = (GamePosition) nextNode.getElement();
            if (nextPos.getMove() != move)
                iter.remove();
            else {
            	currentNode = nextNode;
            	played = true;
            }
        }
        if (! played) {
            GamePosition nextPos = pos.playMove(player, move);
            currentNode = gameTree.addChild(currentNode, nextPos);
        }
    }

    //////////// Auxiliary methods ////////////

    private void calculateScore (Tree.Node node, byte player, int ply) {
    // Calculate the score for a move by player given the position
    // stored in node. Look up to ply moves ahead.
    	GamePosition pos = (GamePosition) node.getElement();
    	if (! pos.isTerminalPosition()) {
            if (gameTree.childCount(node) == 0) {
    	        // Create children for this game position.
    	        GamePosition[] positions = pos.playAllMoves(player);
    	        for (int i = 0; i < positions.length; i++) {
    	            Tree.Node newNode = gameTree.addChild(node, positions[i]);
    	            if (ply > 1)
    	                calculateScore(newNode, GamePosition.other(player),
    	                        ply-1);
    	        }
    	    } else if (ply > 1) {
    	    	Iterator iter = gameTree.children(node);
    	    	while (iter.hasNext()) {
    	    	    Tree.Node newNode = (Tree.Node) iter.next();
    	    	    calculateScore(newNode, GamePosition.other(player), ply-1);
    	    	}
    	    }
    	    int bestScore = (player == GamePosition.COMPUTER_PLAYER) ?
    	            maximize(node) : minimize(node);
   	    pos.setScore(bestScore);
    	}
    }

    private int maximize (Tree.Node node) {
    	int score = Integer.MIN_VALUE; // ... smaller than any valid score.
    	Iterator iter = gameTree.children(node);
    	while (iter.hasNext()) {
    	    Tree.Node curr = (Tree.Node) iter.next();
    	    GamePosition pos = (GamePosition) curr.getElement();
    	    int newScore = pos.getScore();
    	    if (newScore > score)  score = newScore;
    	}
    	return score;
    }

    private int minimize (Tree.Node node) {
    	int score = Integer.MAX_VALUE; // ... larger than any valid score.
    	Iterator iter = gameTree.children(node);
    	while (iter.hasNext()) {
    	    Tree.Node curr = (Tree.Node) iter.next();
    	    GamePosition pos = (GamePosition) curr.getElement();
    	    int newScore = pos.getScore();
    	    if (newScore < score)  score = newScore;
    	}
    	return score;
    }
}