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

    // winner classes
    private int class1;
    private int class2;
    private int class3;
    private int class4;

    // counter to determine winner class
    private int classMatchSum;

    // counter to determine player score
    private int playerMatchSum;

    // tracks players picks that match the winning numbers
    private String playerMatchString;

    /**
     * Method to find total lotto winners, uses binary search.
     * @param playerPicksArray int[][] - The array of player lotto picks.
     * @param winningNumbersArray - The array of winning numbers.
     */
    public void getWinnerClasses(int[][] playerPicksArray, int[] winningNumbersArray) {

        // iterate through each player index
        for(int i = 0; i < playerPicksArray.length; i++) {

            // reset classMatchSum for each iteration
            classMatchSum = 0;

            // iterate through each winning number index
            for(int j = 0; j < winningNumbersArray.length; j++) {

                // if a match is found via binary search,
                if(binarySearch(playerPicksArray[i], winningNumbersArray[j]) >= 0) {

                    // increment classMatchSum
                    classMatchSum++;
                }
            }

            setWinClass();
        }

        // print each winner class with their results
        printWinnerClasses();
    }

    /**
     * Method checks a particular player's lotto ticket for winning numbers.
     * Assumes input will be a player number starting from 1, not array index.
     *
     * @param playerNumber int - The player number, > 0, not array index!
     * @param array int[][] - The array of player picks.
     * @param winningNumbersArray int[] - The array of winning numbers.
     */
    public void checkTicket(int playerNumber, int[][] array, int[] winningNumbersArray) {

        // reset counters and string
        playerMatchSum = 0;
        playerMatchString = "";

        // iterate over each item in the winning numbers array
        for(int i = 0; i < winningNumbersArray.length; i++) {

            // if a winning number is found in the player's picks,
            if(binarySearch(array[playerNumber - 1], winningNumbersArray[i]) >= 0) {

                // update playerMatchString with matching array value
                playerMatchString += "[";

                // formatting: if value is less than 10, pad with leading zero
                if(winningNumbersArray[i] < 10) {
                    playerMatchString += "0";
                }

                // complete the rest of the string
                playerMatchString += winningNumbersArray[i] + "]";
                // update the counter, determines the win class
                playerMatchSum++;
            }
        }

        // print the result line
        playerMatchString += "\n";
        System.out.println(playerTitleString(playerNumber) + " " + playerResultString());
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
     * Method determines which class to increment.
     */
    private final void setWinClass() {

        // switch case for classMatchSum, determines which class to increment
        switch(classMatchSum) {
            case 6:     class1++;
                        break;
            case 5:     class2++;
                        break;
            case 4:     class3++;
                        break;
            case 3:     class4++;
                        break;
            default:    break;
        }
    }

    /**
     * Method returns a player title string.
     * Used when printing results.
     * Assumes player number is > 0, or array index + 1.
     *
     * @param playerNumber int - The player number, not array index!
     * @return String output.
     */
    private final String playerTitleString(int playerNumber) {

        String output = "Player ";

        String pad1 = "0";
        String pad2 = "00";
        String pad3 = "000";

        if(playerNumber < 10) {
            output += pad3;
        } else if(playerNumber < 100) {
            output += pad2;
        } else if(playerNumber < 1000) {
            output += pad1;
        }

        output += playerNumber;

        return output;
    }

    /**
     * Method returns the player's lotto results.
     *
     * @return String output.
     */
    private final String playerResultString() {

        String output = "";

        // switch case for playerMatchSum to determine the player's win class
        switch(playerMatchSum) {
            case 6:     output += "is a 1st class winner!\n"
                            + "Your winning numbers are: " + playerMatchString;
                        break;
            case 5:     output += "is a 2nd class winner!\n"
                            + "Your winning numbers are: " + playerMatchString;
                        break;
            case 4:     output += "is a 3rd class winner!\n"
                            + "Your winning numbers are: " + playerMatchString;
                        break;
            case 3:     output += "is a 4th class winner!\n"
                            + "Your winning numbers are: " + playerMatchString;
                        break;
            default:    output += "did not win. Thanks for playing lotto. \nBetter luck next time!\n";
                        break;
        }

        return output;
    }

    /**
     * Method prints each winner class with their results.
     *
     * 1st class = 6 classMatchSum
     * 2nd class = 5 classMatchSum
     * 3rd class = 4 classMatchSum
     * 4th class = 3 classMatchSum
     */
    private final void printWinnerClasses() {
        System.out.println("1st class winners: " + class1);
        System.out.println("2nd class winners: " + class2);
        System.out.println("3rd class winners: " + class3);
        System.out.println("4th class winners: " + class4);
        System.out.println();
    }
}
