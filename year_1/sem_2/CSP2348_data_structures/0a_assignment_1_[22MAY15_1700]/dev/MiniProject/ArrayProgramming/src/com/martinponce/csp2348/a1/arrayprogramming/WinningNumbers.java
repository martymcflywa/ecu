package com.martinponce.csp2348.a1.arrayprogramming;

/**
 * This class defines the winning numbers for Array Programming task.
 *
 * @author Martin Ponce ID 10371381
 * @version 0.0.1
 * @since 20150423
 */
public class WinningNumbers {

    private int maxPicks;
    private int range;

    private int[] winningNumbersArray;

    public WinningNumbers(int maxPicks, int range) {
        this.maxPicks = maxPicks;
        this.range = range;

        // create new array
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
        String pad2 = "00";
        String pad3 = "000";

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
}
