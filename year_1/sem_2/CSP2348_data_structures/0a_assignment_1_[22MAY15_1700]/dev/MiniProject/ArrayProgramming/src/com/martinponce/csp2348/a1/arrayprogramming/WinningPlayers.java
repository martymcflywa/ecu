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

    private int class1;
    private int class2;
    private int class3;
    private int class4;

    /**
     * Method to find lotto winners, uses binary search.
     * @param playerPicksArray int[][] - The array of player lotto picks.
     * @param winningNumbersArray - The array of winning numbers.
     */
    public void getWinners(int[][] playerPicksArray, int[] winningNumbersArray) {

        for(int i = 0; i < playerPicksArray.length; i++) {
            int matches = 0;
            for(int j = 0; j < winningNumbersArray.length; j++) {
                if(binarySearch(playerPicksArray[i], winningNumbersArray[j]) >= 0) {
                    matches++;
                }
            }

            switch(matches) {
                case 6:
                    class1++;
                    break;
                case 5:
                    class2++;
                    break;
                case 4:
                    class3++;
                    break;
                case 3:
                    class4++;
                    break;
                default:
                    break;
            }
        }

        printWinnerClasses();
    }

    /**
     * Binary search algorithm.
     * To find which (if any) component of the sorted (sub)array a[left...right] equals target:
     *
     * @param array int[] - The array to be searched.
     * @param target int - The target to be searched.
     * @return int - Value if target found, -1 if target not found
     */
    private int binarySearch(int[] array, int target) {

        // 1.0 Set l = left, and r = right (substituted with low and high respectively)
        int low = 0;
        int high = array.length - 1;

        // 2.0 While l <= r, repeat:
        while(low <= high) {

            // 2.1 Let m (mid) be an integer about midway between l and r
            int mid = low + (high - low) / 2;

            // 2.2 If target equals a[m], terminate with answer m
            if(target == array[mid]) {
                return mid;

            // 2.3 If target is less than a[m], set r = m - 1
            } else if(target < array[mid]) {
                high = mid - 1;

            // 2.4 If target is greater than a[m], set l = m + 1
            } else {
                low = mid + 1;
            }
        }

        // 3.0 Terminate
        return -1;
    }

    /**
     * Method prints each winner class.
     *
     * 1st class = 6 matches
     * 2nd class =
     */
    private final void printWinnerClasses() {
        System.out.println("1st class winners: " + class1);
        System.out.println("2nd class winners: " + class2);
        System.out.println("3rd class winners: " + class3);
        System.out.println("4th class winners: " + class4);
    }
}
