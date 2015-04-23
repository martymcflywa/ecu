package com.martinponce.csp2348.a1.arrayprogramming;

/**
 * This is the executable class for the Array Programming task.
 *
 * @author Martin Ponce ID 10371381
 * @version 0.0.1
 * @since 20150423
 */
public class Main {

    private static final int MAX_PLAYERS = 1000;
    private static final int MAX_PICKS = 6;
    private static final int RANGE = 45;

    private static PlayerPicks thePlayerPicks = new PlayerPicks(MAX_PLAYERS, MAX_PICKS, RANGE);
    private static WinningNumbers theWinningNumbers = new WinningNumbers(MAX_PICKS, RANGE);
    private static WinningPlayers theWinningPlayers = new WinningPlayers();

    private static final String UNSORTED_TITLE = "***********************"
            + "\n*** UNSORTED ARRAYS ***"
            + "\n***********************\n";

    private static final String SORTED_TITLE = "***********************"
            + "\n**** SORTED ARRAYS ****"
            + "\n***********************\n";

    public static void main(String[] args) {

        System.out.println(UNSORTED_TITLE);

        System.out.println(thePlayerPicks);
        System.out.println(theWinningNumbers);

        System.out.println(SORTED_TITLE);

        Sorter.sortArray(thePlayerPicks.getArray());
        System.out.println(thePlayerPicks);

        Sorter.sortArray(theWinningNumbers.getArray());
        System.out.println(theWinningNumbers);

        theWinningPlayers.getWinners(thePlayerPicks.getArray(), theWinningNumbers.getArray());
    }
}
