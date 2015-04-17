/**
 * Created by marty on 14/04/2015.
 */
public class ArraySorting {

    private int[] dataArray;
    private int[] helperArray;
    private int length;

    /**
     * Constructor.
     */
    public ArraySorting() {

    }

    /**
     * Selection sort algorithm
     * To sort a[left...right] into ascending order:
     *
     * O(n^2): Performs the following comparisons
     * = (right - left) + ... + 2 + 1
     * = (n - 1) + ... + 2 + 1
     * = (n - 1)(1 + (n - 1)) / 2
     * = (n - 1) * n / 2
     * = (n^2 - n) / 2
     *
     * @param array int[]
     * @return int[]
     */
    public int[] selectionSort(int[] array) {

        // 1.0 For l = left, ..., right - 1, repeat:
        for(int i = 0; i < array.length - 1; i++) {

            // 1.1 Set p such that a[p] is the least of a[l...right]
            int p = i;

            // 1.1 inner loop iterates looking for the lowest value
            for(int j = i + 1; j < array.length; j++) {

                // 1.1 if current iteration j is less than current lowest value,
                if(array[j] < array[p]) {

                    // 1.1 set p to j
                    p = j;
                }
            }

            // 1.2 after inner iteration, set temp to lowest value found
            int temp = array[p];
            // 1.2 If p != l, swap a[p] and a[l]
            array[p] = array[i];
            array[i] = temp;
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
    public int[] insertionSort(int[] array) {

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
     * Bubble sort algorithm.
     * To sort a[left...right]:
     *
     * O(n^2): Inner loop performs (n - 1) + (n - 2) + (n - 3) + ... + 1 comparisons
     * = n * ((n - 1) + 1) / 2
     * = n^2 / 2
     * = O(n^2)
     *
     * @param array int[]
     * @return int[]
     */
    public int[] bubbleSort(int[] array) {

        // 1.0 For i = 0, ..., right - 1, repeat:
        for (int i = 0; i < array.length - 1; i++) {

            // 1.1 For j = left, ..., right - i - 1, repeat:
            for (int j = 0; j < array.length - i - 1; j++) {

                // 1.1.1 If a[j] is greater than a[j + 1],
                if(array[j] < array[j + 1]) {

                    // 1.1.1 Swap a[j] and a[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * This method initialises the merge sort algorithm.
     *
     * @param array int[]
     */
    public void mergeSortInit(int[] array) {

        // assign data array and length
        dataArray = array;
        length = array.length;

        // create helper array, will store sorted array
        helperArray = new int[length];

        // call mergeSort()
        mergeSort(0, length - 1);
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
     * @param low int
     * @param high int
     */
    public void mergeSort(int low, int high) {

        // 1.0 If left < right
        if(low < high) {

            // 1.1 Let m be an integer about midway between left and right
            int middle = low + (high - low) / 2;

            // 1.2 Sort a[left...m] into ascending order
            mergeSort(low, middle);

            // 1.3 Sort a[m+1...right] into ascending order
            mergeSort(middle + 1, high);

            // 1.5 Merge a[left...m] and a[m+1...right] into auxiliary array b
            // call merge() which is O(n)
            merge(low, middle, high);
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
     * @param low int
     * @param middle int
     * @param high int
     */
    private void merge(int low, int middle, int high) {

        // iterate from low through to high
        for(int i = low; i <= high; i++) {

            // copy each dataArray element into helperArray
            helperArray[i] = dataArray[i];
        }

        // 1.0 Set i = low, set j = middle + 1, set k = low
        int i = low;
        int j = middle + 1;
        int k = low;

        // 2.0 While i <= middle AND j <= high, repeat:
        while(i <= middle && j <= high) {

            // 2.1 If helperArray[i] <= helperArray[j],
            if(helperArray[i] <= helperArray[j]) {

                // 2.1.1 Copy helperArray[i] into datArray[k], then increment i and k
                dataArray[k] = helperArray[i];
                i++;

                // 2.2 If helperArray[i] > helperArray[j],
            } else {

                // 2.2.1 Copy helperArray[j] into dataArray[k], then increment j and k
                dataArray[k] = helperArray[j];
                j++;
            }
            k++;
        }

        // 3.0 While i <= middle,
        while(i <= middle) {

            // 3.1 Copy helperArray[i] into dataArray[k], then increment i and k
            dataArray[k] = helperArray[i];
            k++;
            i++;
        }
    }

    /**
     * This method initialises the quick sort algorithm.
     *
     * @param array int[]
     */
    public void quickSortInit(int[] array) {

        // check if array is null, or length is 0
        if(array == null || array.length == 0) {

            // end process
            return;
        }

        // set array, length and call quickSort()
        dataArray = array;
        length = array.length;
        quickSort(0, length - 1);
    }

    /**
     * Quick sort algorithm.
     *
     * To sort a[left...right] into ascending order:
     *
     * O(n log n):  Best case, if pivot is median value in array.
     *              Both subarrays are around n / 2 in length.
     * O(n^2):      Worst case, if pivot is min/max value in array.
     *              Where one subarray has length n - 1,
     *              and the other is length 0.
     *
     * @param low int
     * @param high int
     */
    private void quickSort(int low, int high) {

        // declare low and high
        int i = low;
        int j = high;

        // determine pivot (mid) point
        int pivot = dataArray[low + (high - low) / 2];

        // 1.0 If left < right: (i = left, j = right, using while instead of if)
        while(i <= j) {

            // 1.1 Partition a[left...right] such that,

            // 1.1.1 a[left...p-1] are all less than or equal to a[p]
            while(dataArray[i] < pivot) {
                i++;
            }

            // 1.1.2 a[p + 1...right] are all greater than or equal to a[p]
            while(dataArray[j] > pivot) {
                j--;
            }

            // if a value in left subarray is larger than pivot,
            // and if a value in right subarray is smaller than pivot,
            // swap them using swapHelper() and increment/decrement i and j
            if(i <= j) {
                swapHelper(i, j);
                i++;
                j--;
            }
        }

        // 1.2 Sort a[left...p-1] into ascending order
        if(low < j) {
            quickSort(low, j);
        }

        // 1.3 Sort a[p+1...right] into ascending order
        if(i < high) {
            quickSort(i, high);
        }
    }

    /**
     * Swap helper method.
     *
     * @param i int
     * @param j int
     */
    private void swapHelper(int i, int j) {

        // copy dataArray[i] into temp
        int temp = dataArray[i];

        // set dataArray[i] as dataArray[j]
        dataArray[i] = dataArray[j];
        // set dataArray[j] to temp, completing the swap
        dataArray[j] = temp;
    }

    /**
     * Returns this complete array as String.
     *
     * @param array int[]
     * @return String
     */
    public String getString(int[] array) {
        String output = "";

        for(int i = 0; i < array.length; i++) {
            output += "[" + array[i] + "]";
        }

        return output;
    }
}
