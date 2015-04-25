package com.martinponce.csp2348.a2.arrayprogramming;

/**
 * This class defines the winning numbers for Array Programming task.
 *
 * @author Martin Ponce ID 10371381
 * @version 0.1.0
 * @since 20150426
 */
public class WinningNumbers {

    private int maxPicks;
    private int range;

    private int[] winningNumbersArray;

    /**
     * Constructor.
     *
     * @param maxPicks int - Maximum number of picks a player can have.
     * @param range int - The range of numbers picked for lotto game.
     */
    public WinningNumbers(int maxPicks, int range) {
        this.maxPicks = maxPicks;
        this.range = range;

        // create array
        winningNumbersArray = new int[maxPicks];
        // randomize
        Randomizer.getRandomArray(winningNumbersArray, maxPicks, range);
    }

    /**
     * Overriding toString.
     *
     * @return output String.
     */
    @Override
    public String toString() {

        String output = "Winning Numbers:   ";
        String pad1 = "0";

        for(int i = 0; i < maxPicks; i++) {

            output += "[";

            if(winningNumbersArray[i] < 10) {
                output += pad1;
            }

            output += winningNumbersArray[i] + "]";
        }
        output += "\n";

        return output;
    }

    /**
     * Method sets each index for winningNumbersArray.
     * To be used for manual input.
     * TODO: Add manual input in main.
     *
     * @param a int - Winning number at index 0.
     * @param b int - Winning number at index 1.
     * @param c int - Winning number at index 2.
     * @param d int - Winning number at index 3.
     * @param e int - Winning number at index 4.
     * @param f int - Winning number at index 5.
     */
    public void setArray(int a, int b, int c, int d, int e, int f) {
        winningNumbersArray[0] = a;
        winningNumbersArray[1] = b;
        winningNumbersArray[2] = c;
        winningNumbersArray[3] = d;
        winningNumbersArray[4] = e;
        winningNumbersArray[5] = f;
    }

    /**
     * Returns the winning numbers array.
     *
     * @return winningNumbersArray int.
     */
    public int[] getArray() {
        return winningNumbersArray;
    }
}
