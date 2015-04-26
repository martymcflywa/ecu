package com.martinponce.csp2348.a2.arrayprogramming;

/**
 * Helper class to sort random numbers for player picks and winning numbers.
 * Static class, should not be instantiated.
 *
 * @author Martin Ponce ID 10371381
 * @version 0.1.1
 * @since 20150426
 */
public class Sorter {

    private static int[] mergeArrayToSort;
    private static int[] mergeTempArray;

    /**
     * Private constructor.
     * Do not instantiate.
     */
    private Sorter() {

    }

    /**
     * Method initiates sorting of two-dimensional array of all player tickets.
     * Uses insertion sort algorithm.
     *
     * @param array int[][] - The two-dimensional array of all player tickets.
     * @return int[][] - The two-dimensional array of all player tickets.
     */
    public static final int[][] insertionSortArray(int[][] array) {

        for(int i = 0; i < array.length; i++) {
            insertionSort(array[i]);
        }

        return array;
    }

    /**
     * Overloaded method initiates sorting of one-dimensional array of an individual player ticket.
     * Uses insertion sort algorithm.
     *
     * @param array int[] - The one-dimensional array of an individual player ticket.
     * @return int[] - The one-dimensional array of an individual player ticket.
     */
    public static final int[] insertionSortArray(int[] array) {

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
     * @param array int[] - The array to sort.
     * @return int[] - The sorted array.
     */
    private static final int[] insertionSort(int[] array) {

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

    /**
     * Method initiates sorting of two-dimensional array of all player tickets.
     * Uses merge sort algorithm.
     *
     * @param array int[][] - The two-dimensional array of all player tickets.
     */
    public static void mergeSortArray(int[][] array) {

        for(int i = 0; i < array.length; i++) {

            // assign data array and length
            mergeArrayToSort = array[i];
            //int length = array[i].length;

            // create helper array, will store sorted array
            mergeTempArray = new int[array[i].length];

            // call mergeSort()
            mergeSort(0, array[i].length - 1);
        }
    }

    /**
     * Method initiates sorting of one-dimensional array of individual player ticket.
     * Uses merge sort algorithm.
     *
     * @param array int[] - The one-dimensional array of an individual player ticket.
     */
    public static void mergeSortArray(int[] array) {

        for(int i = 0; i < array.length; i++) {

            mergeArrayToSort = array;

            mergeTempArray = new int[array.length];

            mergeSort(0, array.length - 1);
        }
    }

    /**
     * Merge sort algorithm.
     *
     * To sort a[left...right] into ascending order:
     *
     * O(n log n):
     * = 2^iC(n / 2^i) + i * n 0 (2^i - 1)
     * = n * 1 + log(n) * n - n + 1
     * = O(n * log(n))
     * O(n) for merge algorithm * O(log n) mergeSort algorithm.
     *
     * @param low int - Left.
     * @param high int - Right.
     */
    private static void mergeSort(int low, int high) {

        // 1.0 If left (low) < right (high)
        if(low < high) {

            // 1.1 Let m (mid) be an integer about midway between left and right
            int mid = low + (high - low) / 2;

            // 1.2 Sort a[left...m] into ascending order
            mergeSort(low, mid);

            // 1.3 Sort a[m+1...right] into ascending order
            mergeSort(mid + 1, high);

            // 1.5 Merge a[left...m] and a[m+1...right] into auxiliary array b
            // call merge() which is O(n)
            merge(low, mid, high);
        }
    }

    /**
     * Merge algorithm.
     *
     * To merge a1[l1...r1] and a2[l2...r2] into a3[l3...r3], where a1 and a2 are sorted:
     *
     * O(n): Each component of a1 is copied once, and each component of a2 is copied once.
     * Number of copies = n_1 + n_2 = n.
     *
     * @param low int - Left.
     * @param mid int - Middle.
     * @param high int - Right.
     */
    private static void merge(int low, int mid, int high) {

        // iterate from low through to high
        for(int i = low; i <= high; i++) {

            // copy each element from the array to sort, to each element into temp array
            mergeTempArray[i] = mergeArrayToSort[i];
        }

        // 1.0 Set i = low, set j = mid + 1, set k = low
        int i = low;
        int j = mid + 1;
        int k = low;

        // 2.0 While i <= mid AND j <= high, repeat:
        while(i <= mid && j <= high) {

            // 2.1 If mergeTempArray[i] <= mergeTempArray[j],
            if(mergeTempArray[i] <= mergeTempArray[j]) {

                // 2.1.1 Copy mergeTempArray[i] into mergeArrayToSort[k], then increment i and k
                mergeArrayToSort[k] = mergeTempArray[i];
                i++;

                // 2.2 If mergeTempArray[i] > mergeTempArray[j],
            } else {

                // 2.2.1 Copy mergeTempArray[j] into mergeArrayToSort[k], then increment j and k
                mergeArrayToSort[k] = mergeTempArray[j];
                j++;
            }
            k++;
        }

        // 3.0 While i <= mid,
        while(i <= mid) {

            // 3.1 Copy mergeTempArray[i] into mergeArrayToSort[k], then increment i and k
            mergeArrayToSort[k] = mergeTempArray[i];
            k++;
            i++;
        }
    }
}
