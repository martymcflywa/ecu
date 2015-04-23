package com.martinponce.csp2348.a1.arrayprogramming;

import java.util.Random;

/**
 * Helper class to generate random numbers for player picks and winning numbers.
 *
 * @author Martin Ponce ID 10371381
 * @version 0.0.1
 * @since 20150423
 */
public class Randomizer {

    /**
     * Method to generate player picks array,
     * calls randomize().
     *
     * @param array int[][] - The array to randomize.
     * @param maxPlayers int - Max number of players.
     * @param maxPicks int - Max number of picks per player.
     * @param range int - The range of random numbers starting from 1.
     */
    public static void getRandomArray(int[][] array, int maxPlayers, int maxPicks, int range) {

        for(int i = 0; i < maxPlayers; i++) {
            randomize(array[i], maxPicks, range);
        }
    }

    /**
     * Overloaded method to generate winning numbers array.
     *
     * @param array int[] - The array to randomize.
     * @param maxPicks int - Max number of picks per player.
     * @param range int - The range of random numbers starting from 1.
     */
    public static void getRandomArray(int[] array, int maxPicks, int range) {

        for(int i = 0; i < array.length; i++) {
            randomize(array, maxPicks, range);
        }
    }

    /**
     * Method to generate random picks.
     *
     * @param array
     * @param maxPicks
     * @param range
     */
    private static void randomize(int[] array, int maxPicks, int range) {

        int x = 0;
        int k = 0;
        int j = 0;
        int y = 0;

        Random randomGenerator = new Random();

        array[0] = randomGenerator.nextInt(range) + 1;

        for(int i = 1; i < maxPicks; i++) {
            y = 0;

            while(y == 0) {
                x = randomGenerator.nextInt(range) + 1;
                k = 0;

                for(j = 0; j < i; j++) {
                    if(x != array[j]) {
                        k++;
                    }
                }
                if(k == i) {
                    array[i] = x;
                    y++;
                }
            }
        }
    }
}
