import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends JApplet implements MouseListener, Runnable {

    private Thread gameThread;
    private GameTree game;
    private byte currentPlayer, currentStartingPlayer;
    private int move;
    private boolean moveEntered;

    public void init () {
    	this.addMouseListener(this);
    	gameThread = new Thread(this);
    	currentStartingPlayer = GamePosition.COMPUTER_PLAYER;
     	currentPlayer = currentStartingPlayer;
   	game = new GameTree(currentStartingPlayer);
    }

    public void start () {
    	gameThread.start();
    }

    public void stop () {
    	gameThread = null;
    }

    public void run () {
    	while (Thread.currentThread() == gameThread) {
            game.drawBoard(this);
            if (game.isOver()) {
            	displayResult();
    	        // currentPlayer = GamePosition.COMPUTER_PLAYER;
    	        currentStartingPlayer =
    	                GamePosition.other(currentStartingPlayer);
    	        currentPlayer = currentStartingPlayer;
    	        game = new GameTree(currentStartingPlayer);
    	    	game.drawBoard(this);
    	    } else {
                playAMove();
            }
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) { }
        }

    }

    private void playAMove () {
        if (currentPlayer == GamePosition.COMPUTER_PLAYER) {
            game.calculateScore(currentPlayer, 2);
            game.playBestMove();
        } else {
            getValidMove();
            game.playMove(currentPlayer, move);
        }
        currentPlayer = GamePosition.other(currentPlayer);
    }

    private void displayResult () {
    	String message;
        switch (game.getWinner()) {
            case GamePosition.COMPUTER_PLAYER:
                message = "Bad luck!\nThe computer has won.";
                break;
            case GamePosition.HUMAN_PLAYER:
                message = "Congratulations!\nYou have won.";
                break;
            default:
                message = "It is a draw!";
                break;
        }
        JOptionPane.showMessageDialog(null, message, "Game Over",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void getValidMove () {
    	boolean valid;
    	do {
    	    moveEntered = false;
    	    while (! moveEntered)
    	        try {
    	            Thread.sleep(10);
    	        } catch (InterruptedException e) { }
    	    valid = game.isValidMove(move);
    	} while (! valid);
    }

    public void mouseClicked  (MouseEvent e) {
    	int x = e.getX() / 100;
    	int y = e.getY() / 100;
    	if (! moveEntered) {
    	    move = y * 3 + x;
    	    moveEntered = true;
    	}
    }

    public void mouseEntered  (MouseEvent e) { }
    public void mouseExited   (MouseEvent e) { }
    public void mouseDragged  (MouseEvent e) { }
    public void mouseMoved    (MouseEvent e) { }
    public void mousePressed  (MouseEvent e) { }
    public void mouseReleased (MouseEvent e) { }

    public void paint (Graphics g) {
    	if (game != null)  game.drawBoard(this);
    }
}