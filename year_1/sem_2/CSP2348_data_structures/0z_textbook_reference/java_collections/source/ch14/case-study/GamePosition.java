import java.awt.*;

public class GamePosition {

    private byte[] board;
    private byte player;
    private int score;
    private int move;
    private boolean isTerminalPosition;

    private static char[] symbols = {'X', 'O'};

    public static final byte EMPTY = 0, COMPUTER_PLAYER = 1, HUMAN_PLAYER = 2;

    private static final byte[][] winningLines = new byte[][] {
    	new byte[] {0, 1, 2},	// Horizontal lines
    	new byte[] {3, 4, 5},
    	new byte[] {6, 7, 8},
    	new byte[] {0, 3, 6},	// Vertical lines
    	new byte[] {1, 4, 7},
    	new byte[] {2, 5, 8},
    	new byte[] {0, 4, 8},	// Diagonal lines
    	new byte[] {2, 4, 6}
    };


    //////////// Constructor ////////////

    public GamePosition (byte player) {
        this.board = new byte[9];
        this.player = player;
        this.move = 0;
        this.score = 0;
        this.isTerminalPosition = false;
        if (player == COMPUTER_PLAYER)
            symbols = new char[] {'X', 'O'};
        else
            symbols = new char[] {'O', 'X'};
    }

    private GamePosition (byte[] board, byte player, int move) {
    	this.board = board;
    	this.player = player;
    	this.move = move;
    	evaluate();
    	isTerminalPosition = isWinner(COMPUTER_PLAYER) ||
    	        isWinner(HUMAN_PLAYER) || numMovesLeft() == 0;
    }

    //////////// Accessors ////////////

    public static byte other (byte player) {
    // Given the current player, return the other player.
        return (player == COMPUTER_PLAYER) ?
                HUMAN_PLAYER : COMPUTER_PLAYER;
    }

    public int getScore () {
    // Return the score associated with this position.
        return score;
    }

    public int getMove () {
    // Return the move associated with this position.
        return move;
    }

    public boolean isValidMove (int move) {
    // Return true if and only if move is valid in this position.
        return (move >= 0 && move <= 8 && board[move] == EMPTY);
    }

    public boolean isTerminalPosition () {
    // Return true if and only if this position represents a terminal
    // position in the game, i.e., a player has won or it is a draw.
        return isTerminalPosition;
    }

    public void drawBoard (Panel panel) {
    // Draw a representation of the board on the given panel.
        Graphics g = panel.getGraphics();
        Dimension d = panel.getSize();
        g.setColor(Color.white);
        g.fillRect(0, 0, d.width, d.height);
        g.setColor(Color.black);
        g.fillRect(  0,  98, 300,   4);
        g.fillRect(  0, 198, 300,   4);
        g.fillRect( 98,   0,   4, 300);
        g.fillRect(198,   0,   4, 300);
        for (int i = 0; i < 9; i++) {
            int x = (i % 3) * 100 + 5;
            int y = (i / 3) * 100 + 5;
            if (board[i] == COMPUTER_PLAYER)
                drawSymbol(g, symbols[0], x, y);
            else if (board[i] == HUMAN_PLAYER)
                drawSymbol(g, symbols[1], x, y);
        }
    }

    private void drawSymbol (Graphics g, char symbol, int x, int y) {
    	if (symbol == 'X') {
    	    Polygon p1 = new Polygon (
    	        new int[] {x, x + 80, x + 90, x + 10},
    	        new int[] {y + 5, y + 85, y + 85, y + 5},
    	        4);
    	    Polygon p2 = new Polygon (
    	        new int[] {x + 80, x, x + 10, x + 90},
    	        new int[] {y + 5, y + 85, y + 85, y + 5},
    	        4);
    	    g.setColor(Color.red);
    	    g.fillPolygon(p1);
    	    g.fillPolygon(p2);
        } else if (symbol == 'O') {
            g.setColor(Color.blue);
            g.fillOval(x + 10, y + 5, 70, 80);
            g.setColor(Color.white);
            g.fillOval(x + 17, y + 12, 56, 66);
        }
    }

    public boolean isWinner (byte player) {
    // Determine if player is the winner of the game.
        for (int i = 0; i < winningLines.length; i++) {
            byte[] line = winningLines[i];
            if (board[line[0]] == player && board[line[1]] == player &&
                    board[line[2]] == player)
                return true;
        }
        return false;
    }

    public String getBoard () {
        String output = "";
        for (int i = 0; i < 9; i++) {
            switch (board[i]) {
            	case EMPTY:            output += " "; break;
            	case COMPUTER_PLAYER:  output += symbols[0]; break;
            	case HUMAN_PLAYER:     output += symbols[1]; break;
            	default:               output += "?"; break;
            }
            switch (i % 3) {
                case 0:
                case 1: output += "|"; break;
                case 2: if (i < 8)  output += "\n-----\n"; break;
            }
         }
         return (output + "\n");
    }

    public String toString () {
    // Convert this game position to a string.
         return (getBoard() + " Score: " + score + " Player: " + player +
                 " Move: " + move + "\n");
    }

    //////////// Transformers ////////////

    public void setScore (int score) {
    // Set the score of this game position.
        this.score = score;
    }

    public GamePosition playMove (byte player, int move) {
    // Return a new game position that is the result of playing the given
    // move in this game position.
        return new GamePosition (createBoard(player, move),
                other(player), move);
    }

    public GamePosition[] playAllMoves (byte player) {
    // Return an array of game positions by making all possible valid moves
    // for the given player.
        GamePosition[] positions = new GamePosition[numMovesLeft()];
        int pos = 0;
        for (int i = 0; i < 9; i++) {
            if (board[i] == EMPTY)
                positions[pos++] =
                        new GamePosition(createBoard(player, i), player, i);
        }
        return positions;
    }

    //////////// Auxiliary methods ////////////

   private void evaluate () {
    // Evaluate this game position, and set its score accordingly.
        byte playerLines[]   = countLines(player);
        byte opponentLines[] = countLines(other(player));
        if (opponentLines[3] > 0)
	    // The opponent has won.
	    score = - Integer.MAX_VALUE + 1;
	else if (playerLines[3] > 0)
	    // The player has won.
	    score = Integer.MAX_VALUE - 1;
	else
	    // Rank the opportunities and threats.
	    score = -1000 * opponentLines[2] + 100 *
	            playerLines[2] - 10 * opponentLines[1] + playerLines[1];
	// The sign of the score is reversed for the human player.
	if (player == HUMAN_PLAYER)  score = -score;
    }

    private byte[] countLines (byte currPlayer) {
    // Count the number of lines for currPlayer consisting of 1, 2, and 3
    // symbols.
        byte[] numLines = new byte [4];

        // For each possible winning line determine whether it represents
        // a line of 3 squares, a line of 2 squares, or a line of 1 square.
	for (int i = 0; i < winningLines.length; i++) {
	    byte[] line = winningLines[i];
	    int matched = 0, empty = 0;
	    for (int j = 0; j < line.length; j++) {
		if (board[line[j]] == currPlayer)
		    matched++;
		else if (board[line[j]] == EMPTY)
		    empty++;
	    }
	    if (matched == 3)
		numLines[3]++;
	    else if (matched == 2 && empty == 1)
		numLines[2]++;
	    else if (matched == 1 && empty == 2)
		numLines[1]++;
	}
	return numLines;
    }

    private int numMovesLeft () {
    // Return the number of empty squares on the board.
        int total = 0;
        for (int i = 0; i < 9; i++)
            if (board[i] == EMPTY)  total++;
        return total;
    }

    private byte[] createBoard (byte player, int pos) {
    // Create a new board that is the result of player playing at
    // position pos.
    	byte[] result = new byte[9];
    	System.arraycopy(board, 0, result, 0, 9);
        result[pos] = player;
    	return result;
    }
}