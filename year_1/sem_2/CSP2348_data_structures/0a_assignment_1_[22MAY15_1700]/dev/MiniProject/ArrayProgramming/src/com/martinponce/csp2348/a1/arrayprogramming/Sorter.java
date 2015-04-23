package com.martinponce.csp2348.a1.arrayprogramming;

/**
 * Helper class to sort random numbers for player picks and winning numbers.
 *
 * @author Martin Ponce ID 10371381
 * @version 0.0.1
 * @since 20150423
 */
public class Sorter {

    /**
     * Method to initiate sorting of player picks.
     *
     * @param array int[][] - The array to randomize.
     * @return
     */
    public static int[][] sortArray(int[][] array) {

        for(int i = 0; i < array.length; i++) {
            insertionSort(array[i]);
        }

        return array;
    }

    public static int[] sortArray(int[] array) {

        for(int i = 0; i < array.length; i++) {
            insertionSort(array);
        }

        return array;
    }

    /**
     * Insertion sort algorithm.
     * To sort a[left...right] into ascending order:
     *
     * O(n^2): Performs the following comparisons
     * = (right - left + 1) / 2
     * = 2 / 2 + 3 / 2 + ... + n / 2
     * = (2 + 3 + 4 + ... + n) / 2
     * = (n - 1)(n - 2) / 4
     * = (n^2 + n - 2) / 4
     * = O(n^2)
     *
     * @param array int[]
     * @return int[]
     */
    private static int[] insertionSort(int[] array) {

        // 1.0 For r = left+1, ..., right, repeat:
        for(int i = 1; i < array.length; i++) {

            // 1.1 Let val = a[r] (replaced with key)
            int key = array[i];

            // 1.2 Insert val into a[left...r] in such a way that the subarray is sorted

            // j is tracking the sorted subarray
            int j = i - 1;

            // while j >= 0 and array[j] > key,
            while(j >= 0 && array[j] > key) {

                // set array[j + 1] to array[j]
                array[j + 1] = array[j];
                // decrement j
                j--;
            }

            // after inner loop, set array[j + 1] to key
            array[j + 1] = key;
        }

        return array;
    }
}
