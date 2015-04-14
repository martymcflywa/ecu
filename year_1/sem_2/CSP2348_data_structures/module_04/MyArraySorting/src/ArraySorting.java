/**
 * Created by marty on 14/04/2015.
 */
public class ArraySorting {

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
     * Insertion sort algorithm
     * To sort a[left...right] into ascending order:
     *
     * O(n^2): Performs the following comparisons
     * = (right - left + 1) / 2
     * = 2 / 2 + 3 / 2 + ... + n / 2
     * = (2 + 3 + 4 + ... + n) / 2
     * = (n - 1)(n - 2) / 4
     * = (n^2 + n - 2) / 4
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


    public int[] mergeSort(int[] array) {
        return array;
    }

    /**
     *
     * @param array
     * @return
     */
    public String getString(int[] array) {
        String output = "";

        for(int i = 0; i < array.length; i++) {
            output += "[" + array[i] + "]";
        }

        return output;
    }
}
