package com.martinponce.csp2348.a1.arrayprogramming;

import java.util.Scanner;

/**
 * This is the executable class for the Array Programming task.
 *
 * @author Martin Ponce ID 10371381
 * @version 0.0.1
 * @since 20150423
 */
public class Main {

    // final instance variables
    private final int MAX_PLAYERS = 1000;
    private final int MAX_PICKS = 6;
    private final int RANGE = 45;

    // lotto objects
    private PlayerPicks thePlayerPicks;
    private WinningNumbers theWinningNumbers;
    private WinningPlayers theWinningPlayers;

    // final title strings
    private final String UNSORTED_TITLE = "***********************"
            + "\n*** UNSORTED ARRAYS ***"
            + "\n***********************\n";
    private final String SORTED_TITLE = "***********************"
            + "\n**** SORTED ARRAYS ****"
            + "\n***********************\n";
    private final String USER_INPUT_TITLE = "***********************"
            + "\n****** USERINPUT ******"
            + "\n***********************\n";

    // user input variables
    private int playerNumber;

    /**
     * Constructor.
     */
    public Main() {

        // instantiate player picks, winning numbers and winning players
        thePlayerPicks = new PlayerPicks(MAX_PLAYERS, MAX_PICKS, RANGE);
        theWinningNumbers = new WinningNumbers(MAX_PICKS, RANGE);
        theWinningPlayers = new WinningPlayers();

        // execute program
        initialize();
        getUserInput();
    }

    /**
     * Main method.
     *
     * @param args String[]
     */
    public static void main(String[] args) {

        // instantiate main class
        Main execute = new Main();
    }

    /**
     * Method to init program.
     */
    private final void initialize() {

        // print unsorted title
        System.out.println(UNSORTED_TITLE);

        // print unsorted player picks, winning numbers
        System.out.println(thePlayerPicks);
        System.out.println(theWinningNumbers);

        // print sorted title
        System.out.println(SORTED_TITLE);

        // sort player picks with insertion sort
        Sorter.sortArray(thePlayerPicks.getArray());
        // print sorted player picks
        System.out.println(thePlayerPicks);

        // sort winning numbers with insertion sort
        Sorter.sortArray(theWinningNumbers.getArray());
        // print sorted winning numbers
        System.out.println(theWinningNumbers);

        // get winner classes and print
        theWinningPlayers.getWinnerClassesBinary(thePlayerPicks.getArray(), theWinningNumbers.getArray());

        theWinningPlayers.checkTicketBinary(5, thePlayerPicks.getArray(), theWinningNumbers.getArray());
        theWinningPlayers.checkTicketBinary(500, thePlayerPicks.getArray(), theWinningNumbers.getArray());
        theWinningPlayers.checkTicketBinary(564, thePlayerPicks.getArray(), theWinningNumbers.getArray());
        theWinningPlayers.checkTicketBinary(897, thePlayerPicks.getArray(), theWinningNumbers.getArray());
    }

    /**
     * Method to get user input for player number.
     * Player number used to check if player's ticket contains winning numbers.
     */
    private final void getUserInput() {

        Scanner sc = new Scanner(System.in);

        System.out.println(USER_INPUT_TITLE);

        System.out.println("Enter your player number to check if you have a winning ticket:");
        playerNumber =  sc.nextInt();

        if(playerNumber > MAX_PLAYERS || playerNumber < 1) {
            throw new ArrayIndexOutOfBoundsException("Player does not exist! Try again");
        }

        sc.close();

        theWinningPlayers.checkTicketBinary(playerNumber, thePlayerPicks.getArray(), theWinningNumbers.getArray());
    }
}
