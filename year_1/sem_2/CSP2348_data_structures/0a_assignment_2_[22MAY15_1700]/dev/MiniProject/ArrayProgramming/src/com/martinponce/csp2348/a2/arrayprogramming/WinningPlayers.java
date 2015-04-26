package com.martinponce.csp2348.a2.arrayprogramming;

/**
 * This class defines a winner of the lotto game.
 * Contains search methods to determine the winner.
 *
 * @author Martin Ponce ID 10371381
 * @version 1.0.0
 * @since 20150426
 */
public class WinningPlayers {

    // winner classes
    private int class1;
    private int class2;
    private int class3;
    private int class4;

    // counter to determine winner class
    private int classMatchTally;

    // counter to determine player score
    private int playerMatchTally;

    // tracks players picks that match the winning numbers
    private String playerMatchString;

    /**
     * Method finds total lotto winners for each winner class.
     * Uses binary search.
     *
     * @param allPlayerTickets int[][] - The two-dimensional array of all player tickets.
     * @param winningNumbers int[] - The array of winning numbers.
     */
    public final void getWinnerClassesBinary(int[][] allPlayerTickets, int[] winningNumbers) {

        // iterate through each player index
        for(int i = 0; i < allPlayerTickets.length; i++) {

            // reset classMatchTally for each iteration
            classMatchTally = 0;

            // iterate through each winning number index
            for(int j = 0; j < winningNumbers.length; j++) {

                // if a match is found via binary search,
                if(binarySearch(allPlayerTickets[i], winningNumbers[j]) >= 0) {

                    // increment classMatchTally
                    classMatchTally++;
                }
            }

            setWinClass();
        }

        // print each winner class with their results
        printWinnerClasses();
    }

    /**
     * Method finds total lotto winners for each winner class.
     * Uses binary search.
     * Assumes input will be a player number between 1 - 1000 inclusive. Not array index!
     *
     * @param playerNumber int - The player number, between 1 - 1000 inclusive. Not array index!
     * @param allPlayerTickets int[][] - The two-dimensional array of all player tickets.
     * @param winningNumbers int[] - The array of winning numbers.
     */
    public final void checkTicketBinary(int playerNumber, int[][] allPlayerTickets, int[] winningNumbers) {

        // reset counter and string
        playerMatchTally = 0;
        playerMatchString = "";
        resetWinnerClasses();

        // iterate over each item in the winning numbers array
        for(int i = 0; i < winningNumbers.length; i++) {

            // if a winning number is found in the player's picks,
            if(binarySearch(allPlayerTickets[playerNumber - 1], winningNumbers[i]) >= 0) {

                // update playerMatchString with matching array value
                playerMatchString += "[";

                // formatting: if value is less than 10, pad with leading zero
                if(winningNumbers[i] < 10) {
                    playerMatchString += "0";
                }

                // complete the rest of the string
                playerMatchString += winningNumbers[i] + "]";
                // update the counter, determines the win class
                playerMatchTally++;
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
     * Method finds total lotto winners for each winner class.
     * Uses merge search.
     *
     * @param allPlayerPicks int[][] - The two-dimensional array of all player tickets.
     * @param winningNumbers int[] - The winning numbers array.
     */
    public final void getWinnerClassesMerge(int[][] allPlayerPicks, int[] winningNumbers) {

        resetWinnerClasses();

        // iterate through each player index
        for(int i = 0; i < allPlayerPicks.length; i++) {

            // reset classMatchTally for each iteration
            classMatchTally = 0;
            playerMatchString = "";

            // set classMatchTally to mergeSearch result
            classMatchTally = mergeSearch(allPlayerPicks[i], winningNumbers);

            setWinClass();
        }

        printWinnerClasses();
    }

    /**
     * Method checks individual player lotto ticket for winning numbers.
     * Uses merge search.
     * Assumes input will be a player number between 1 - 1000 inclusive. Not array index!
     *
     * @param playerNumber int - The player number, between 1 - 1000 inclusive. Not array index!
     * @param allPlayerTickets int[][] - The two-dimensional array of all player tickets.
     * @param winningNumbers int[] - The array of winning numbers.
     */
    public final void checkTicketMerge(int playerNumber, int[][] allPlayerTickets, int[] winningNumbers) {

        // reset counter and string
        playerMatchTally = 0;
        playerMatchString = "";

        // set playerMatchTally to mergeSearch result
        playerMatchTally = mergeSearch(allPlayerTickets[playerNumber - 1], winningNumbers);

        // print the result line
        playerMatchString += "\n";
        System.out.println(playerTitleString(playerNumber) + " " + playerResultString());
    }

    /**
     * Merge search algorithm:
     * Adaptation of merge array algorithm, used to find matches between winning numbers and player ticket numbers.
     *
     * To find which (if any) component of the sorted (sub)array a[left...right] equals target:
     * O(n): Merge search algorithm performs n - 1 max comparisons.
     *
     * @param playerTicket int[] - The individual player picks array.
     * @param winningNumbers int[] - The winning numbers array, target.
     */
    private int mergeSearch(int[] playerTicket, int[] winningNumbers) {

        // 1.0 Set i = l1, set j = l2

        // i tracks playerTicket left
        int i = 0;
        // j tracks winningNumbers left
        int j = 0;
        // tracks how many matches found in loop
        int matchTally = 0;

        //  2.0 While i <= r1 AND j <= r2, repeat:
        while(i < playerTicket.length && j < winningNumbers.length) {

            // 2.1 If a1[i] < a2[j]:
            if(playerTicket[i] < winningNumbers[j]) {

                // 2.1.1 Increment i
                i++;

                // 2.2 If a1[i] > a2[j]:
            } else if(playerTicket[i] > winningNumbers[j]) {

                // 2.2.1 Increment j
                j++;

                // 2.3 If a1[i] == a2[j]
            } else {

                // 2.3.1 Increment matchTally
                matchTally++;

                // playerMatchString for checking individual ticket

                // update playerMatchString with matching array value
                playerMatchString += "[";

                // formatting: if value is less than 10, pad with leading zero
                if(winningNumbers[i] < 10) {
                    playerMatchString += "0";
                }

                // complete the rest of the string
                playerMatchString += playerTicket[i] + "]";

                // increment i
                i++;
            }
        }

        // 3.0 Terminate
        return matchTally;
    }

    /**
     * Method determines which class to increment.
     */
    private final void setWinClass() {

        // switch case for classMatchTally, determines which class to increment
        switch(classMatchTally) {
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
     * Assumes input will be a player number between 1 - 1000 inclusive. Not array index!
     *
     * @param playerNumber int - The player number, between 1 - 1000 inclusive. Not array index!
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

        // switch case for playerMatchTally to determine the player's win class
        switch(playerMatchTally) {
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
     * Method prints total winners for each winner class.
     *
     * 1st class = 6 classMatchTally
     * 2nd class = 5 classMatchTally
     * 3rd class = 4 classMatchTally
     * 4th class = 3 classMatchTally
     */
    private final void printWinnerClasses() {
        System.out.println("1st class winners: " + class1);
        System.out.println("2nd class winners: " + class2);
        System.out.println("3rd class winners: " + class3);
        System.out.println("4th class winners: " + class4);
        System.out.println();
    }

    /**
     * Method resets each winner class back to 0.
     */
    private final void resetWinnerClasses() {

        class1 = 0;
        class2 = 0;
        class3 = 0;
        class4 = 0;
    }
}
