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

    public static void main(String[] args) {

        System.out.println(thePlayerPicks);
        System.out.println(theWinningNumbers);
    }
}
