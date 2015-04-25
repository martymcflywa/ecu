package com.martinponce.csp2348.a2.arrayprogramming;

/**
 * This class defines the player lotto picks for Array Programming task.
 *
 * @author Martin Ponce ID 10371381
 * @version 0.0.1
 * @since 20150423
 */
public class PlayerTickets {

    private int maxPlayers;
    private int maxPicks;
    private int range;

    private int[][] playerTicketsArray;

    /**
     * Constructor.
     *
     * @param maxPlayers int - Max number of players.
     * @param maxPicks int - Max number of picks per player.
     * @param range int - The range of random numbers starting from 1.
     */
    public PlayerTickets(int maxPlayers, int maxPicks, int range) {

        this.maxPlayers = maxPlayers;
        this.maxPicks = maxPicks;
        this.range = range;

        // create array
        playerTicketsArray = new int[maxPlayers][maxPicks];
        // randomize
        Randomizer.getRandomArray(playerTicketsArray, maxPlayers, maxPicks, range);
    }

    /**
     * Override toString.
     * Prints entire array, padding zeros to align elements.
     * @return output String - Customized string.
     */
    @Override
    public String toString() {

        String output = "";

        String pad1 = "0";
        String pad2 = "00";
        String pad3 = "000";

        for(int i = 0; i < maxPlayers; i++) {

            output += "Player ";

            if(i < 9) {
                output += pad3;
            } else if(i < 99) {
                output += pad2;
            } else if(i < 999) {
                output += pad1;
            }

            output += (i + 1) + " picks: ";

            for(int j = 0; j < maxPicks; j++) {
                //output += "[" + playerTicketsArray[i][j] + "]";
                output += "[";

                if(playerTicketsArray[i][j] < 10) {
                    output += pad1;
                }

                output += playerTicketsArray[i][j] + "]";
            }
            output += "\n";
        }

        return output;
    }

    /**
     * Returns the array.
     *
     * @return int[][] playerTicketsArray.
     */
    public int[][] getArray() {
        return playerTicketsArray;
    }

    /**
     * Overloaded method, returns a row of 2d array.
     *
     * @param index int - The index of the row.
     * @return int[] - Return the row.
     */
    public int[] getArray(int index) {
        return playerTicketsArray[index];
    }

    /**
     * Returns maxPlayers.
     *
     * @return maxPlayers int.
     */
    public int getMaxPlayers() {
        return maxPlayers;
    }

    /**
     * Returns maxPicks.
     *
     * @return maxPicks int.
     */
    public int getMaxPicks() {
        return maxPicks;
    }
}
