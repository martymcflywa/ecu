package com.martinponce.csp2348.a2.arrayprogramming;

import java.util.Random;

/**
 * Helper class to generate random numbers for player picks and winning numbers.
 * Static class, should not be instantiated.
 *
 * @author Martin Ponce ID 10371381
 * @version 0.1.1
 * @since 20150426
 */
public class Randomizer {

    /**
     * Private constructor.
     * Do not instantiate.
     */
    private Randomizer() {

    }

    /**
     * Method to initiate player picks random generation.
     *
     * @param array int[][] - The array to randomize.
     * @param maxPlayers int - Max number of players.
     * @param maxPicks int - Max number of picks per player.
     * @param range int - The range of random numbers starting from 1.
     */
    public static final void getRandomArray(int[][] array, int maxPlayers, int maxPicks, int range) {

        for(int i = 0; i < maxPlayers; i++) {
            randomize(array[i], maxPicks, range);
        }
    }

    /**
     * Overloaded method to initiate winning numbers random generation.
     *
     * @param array int[] - The array to randomize.
     * @param maxPicks int - Max number of picks per player.
     * @param range int - The range of random numbers starting from 1.
     */
    public static final void getRandomArray(int[] array, int maxPicks, int range) {

        for(int i = 0; i < array.length; i++) {
            randomize(array, maxPicks, range);
        }
    }

    /**
     * Method to generate random picks and winning numbers.
     *
     * @param array int[] - The array, either player picks or winning numbers.
     * @param maxPicks int - Max number of picks allowed for game.
     * @param range int - The range of numbers, starting from 1.
     */
    private static final void randomize(int[] array, int maxPicks, int range) {

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
