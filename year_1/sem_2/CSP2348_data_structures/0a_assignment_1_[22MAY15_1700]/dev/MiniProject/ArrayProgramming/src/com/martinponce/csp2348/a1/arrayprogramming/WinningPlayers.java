package com.martinponce.csp2348.a1.arrayprogramming;

/**
 * This class defines a winner of the lotto game.
 * Contains search methods to determine the winner.
 *
 * @author Martin Ponce ID 10371381
 * @version 0.0.1
 * @since 20150423
 */
public class WinningPlayers {

    private int matches;
    private int winnerClass;

    private int[][] playerPicksArray;
    private int[] winningNumbersArray;

    public WinningPlayers(int[][] playerPicksArray, int[] winningNumbersArray) {

        matches = 0;
        winnerClass = 0;

        this.playerPicksArray = playerPicksArray;
        this.winningNumbersArray = winningNumbersArray;

        getWinners();
    }

    /**
     * Method to find lotto winners, uses binary search.
     * TODO: Broken, needs attention. Halts when binary search finds a match.
     * TODO: May need to have binarySearch return something else other than boolean.
     */
    private void getWinners() {

        for(int i = 0; i < playerPicksArray.length; i++) {
            for(int j = 0; j < winningNumbersArray.length; j++) {
                if(binarySearch(playerPicksArray[i], winningNumbersArray[j])) {
                    matches++;
                }
            }
        }

        System.out.println(matches);
    }
    /**
     * Binary search algorithm.
     * To find which (if any) component of the sorted (sub)array a[left...right] equals target:
     *
     * @param array int[] - The array to be searched.
     * @param target int - The target to be searched.
     * @return boolean.
     */
    private boolean binarySearch(int[] array, int target) {

        // 1.0 Set l = left, and r = right (substituted with low and high respectively)
        int low = 0;
        int high = array.length - 1;

        // method will return boolean
        boolean match = false;

        // 2.0 While l <= r, repeat:
        while(low <= high) {

            // 2.1 Let m (mid) be an integer about midway between l and r
            int mid = low + (high - low) / 2;

            // 2.2 If target equals a[m], terminate with answer m
            if(target == array[mid]) {
                match = true;

            // 2.3 If target is less than a[m], set r = m - 1
            } else if(target < array[mid]) {
                high = mid - 1;

            // 2.4 If target is greater than a[m], set l = m + 1
            } else {
                low = mid + 1;
            }
        }

        // 3.0 Terminate
        return match;
    }
}
