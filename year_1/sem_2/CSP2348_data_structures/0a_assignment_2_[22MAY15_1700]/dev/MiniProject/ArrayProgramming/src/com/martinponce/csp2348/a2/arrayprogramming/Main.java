package com.martinponce.csp2348.a2.arrayprogramming;

import java.util.Scanner;

/**
 * This is the executable class for the Array Programming task.
 *
 * @author Martin Ponce ID 10371381
 * @version 0.1.1
 * @since 20150426
 */
public class Main {

    // final instance variables
    private final int MAX_PLAYERS = 1000;
    private final int MAX_PICKS = 6;
    private final int RANGE = 45;

    // lotto objects
    private PlayerTickets thePlayerTickets;
    private WinningNumbers theWinningNumbers;
    private WinningPlayers theWinningPlayers;

    // final title strings
    private final String UNSORTED_TITLE = "***********************"
            + "\n*** UNSORTED ARRAYS ***"
            + "\n***********************\n";
    private final String SORTED_TITLE = "***********************"
            + "\n**** SORTED ARRAYS ****"
            + "\n***********************\n";
    private final String USER_INPUT_TITLE = "************************"
            + "\n****** USER INPUT ******"
            + "\n************************\n";
    private final String BINARY_TITLE = "***********************"
            + "\n**** BINARY METHOD ****"
            + "\n***********************\n";
    private final String MERGE_TITLE = "***********************"
            + "\n**** MERGE METHOD *****"
            + "\n***********************\n";
    private final String TEST_TITLE = "***************************"
            + "\n** TICKET CHECKING TESTS **\n"
            + "***************************\n";

    // user input variables
    private int playerNumber;

    /**
     * Constructor.
     */
    public Main() {

        // instantiate player picks, winning numbers and winning players
        thePlayerTickets = new PlayerTickets(MAX_PLAYERS, MAX_PICKS, RANGE);
        theWinningNumbers = new WinningNumbers(MAX_PICKS, RANGE);
        theWinningPlayers = new WinningPlayers();

        // execute program
        run();
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
    private final void run() {

        // print unsorted title
        System.out.println(UNSORTED_TITLE);

        // print unsorted player picks, winning numbers
        System.out.println(thePlayerTickets);
        System.out.println(theWinningNumbers);

        // print sorted title
        System.out.println(SORTED_TITLE);

        // sort player picks with merge sort
        //Sorter.insertionSortArray(thePlayerTickets.getArray());
        Sorter.mergeSortArray(thePlayerTickets.getArray());
        // print sorted player picks
        System.out.println(thePlayerTickets);

        // sort winning numbers with merge sort
        //Sorter.insertionSortArray(theWinningNumbers.getArray());
        Sorter.mergeSortArray(theWinningNumbers.getArray());
        // print sorted winning numbers
        System.out.println(theWinningNumbers);

        // print binary title
        System.out.println(BINARY_TITLE);

        // get winner classes via binary method and print
        theWinningPlayers.getWinnerClassesBinary(thePlayerTickets.getArray(), theWinningNumbers.getArray());

        // print merge title
        System.out.println(MERGE_TITLE);

        // get winner classes via merge method and print
        theWinningPlayers.getWinnerClassesMerge(thePlayerTickets.getArray(), theWinningNumbers.getArray());

        System.out.println(TEST_TITLE);

        System.out.println("** BINARY TICKET CHECKING **\n");

        theWinningPlayers.checkTicketBinary(5, thePlayerTickets.getArray(), theWinningNumbers.getArray());
        theWinningPlayers.checkTicketBinary(500, thePlayerTickets.getArray(), theWinningNumbers.getArray());
        theWinningPlayers.checkTicketBinary(564, thePlayerTickets.getArray(), theWinningNumbers.getArray());
        theWinningPlayers.checkTicketBinary(897, thePlayerTickets.getArray(), theWinningNumbers.getArray());

        System.out.println("** MERGE TICKET CHECKING **\n");

        theWinningPlayers.checkTicketBinary(5, thePlayerTickets.getArray(), theWinningNumbers.getArray());
        theWinningPlayers.checkTicketBinary(500, thePlayerTickets.getArray(), theWinningNumbers.getArray());
        theWinningPlayers.checkTicketBinary(564, thePlayerTickets.getArray(), theWinningNumbers.getArray());
        theWinningPlayers.checkTicketBinary(897, thePlayerTickets.getArray(), theWinningNumbers.getArray());

        // get user input
        getUserInput();
    }

    /**
     * Method to get user input for player number, uses binary search.
     * Player number used to check if player's ticket contains winning numbers.
     */
    private final void getUserInput() {

        Scanner sc = new Scanner(System.in);

        System.out.println(USER_INPUT_TITLE);

        System.out.println("ENTER YOUR PLAYER NUMBER TO CHECK IF YOU HAVE A WINNING TICKET:");
        playerNumber =  sc.nextInt();

        if(playerNumber > MAX_PLAYERS || playerNumber < 1) {
            throw new ArrayIndexOutOfBoundsException("Player does not exist! Try again.");
        }

        sc.close();

        System.out.println("** BINARY METHOD TICKET CHECK **");
        theWinningPlayers.checkTicketBinary(playerNumber, thePlayerTickets.getArray(), theWinningNumbers.getArray());

        System.out.println("** MERGE METHOD TICKET CHECK **");
        theWinningPlayers.checkTicketMerge(playerNumber, thePlayerTickets.getArray(), theWinningNumbers.getArray());
    }
}
