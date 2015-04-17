package csp2348_5243_workshop04;

/**
 * Test selection and insertion sorting algorithms.
 */
public class WS0401 {

    /**
     *  0   1   2   3   4   <--- index
     *  9   3   2   8   5   <--- original elements
     *  2   3   5   8   9   <--- sorted elements
     *          l           <--- outer loop
     *                  k   <--- inner loop
     *                  p   <--- compared with a[k]
     *
     *
     *  least / a[p]    = 5
     *  comp            = -1
     *
     * @param a
     * @param left
     * @param right
     * @param tracing
     */
    public static void selectionSort(Comparable[] a, int left, int right, boolean tracing) {

        // Sort a[left...right].
        if (tracing) {
            trace("\nInitially:      ", a, left, right);
        }

        for (int l = left; l < right; l++) {

            int p = l;

            // ... least will always contain the value of a[p].
            Comparable least = a[p];

            for (int k = l + 1; k <= right; k++) {
                int comp = a[k].compareTo(least);
                if (comp < 0) {
                    p = k;
                    least = a[p];
                }
            }

            if (p != l) {
                a[p] = a[l];
                a[l] = least;
            }

            if (tracing) {
                trace("Iteration l = " + l + ":", a, left, right);
            }
        }

        if (tracing) {
            trace("Selection sort: ", a, left, right);
        }
    }

    /**
     *  0   1   2   3   4   <--- index
     *  9   3   2   8   5   <--- original elements
     *  2   3   5   8   9   <--- sorted elements
     *                  r   <--- outer loop
     *          p           <--- p while
     *
     *
     *  val / a[r]                  = 5
     *
     *  WHILE:
     *  val.compareTo(a[p - 1])     = -1
     *
     *  left                        = 0
     *  right                       = 5
     *
     * @param a
     * @param left
     * @param right
     * @param tracing
     */
    public static void insertionSort(Comparable[] a, int left, int right, boolean tracing) {

        // Sort a[left...right].
        if (tracing) {
            trace("\nInitially:      ", a, left, right);
        }

        for (int r = left + 1; r <= right; r++) {
            Comparable val = a[r];
            int p = r;
            while (p > left && val.compareTo(a[p - 1]) < 0) {
                a[p] = a[p - 1];
                p--;
            }

            a[p] = val;

            if (tracing) {
                trace("Iteration r = " + r + ":", a, left, right);
            }
        }

        if (tracing) {
            trace("Insertion sort: ", a, left, right);
        }
    }

    private static void trace(String caption, Comparable[] a, int left, int right) {

        System.out.print(caption + " {");

        for (int k = left; k <= right; k++) {
            System.out.print(" " + a[k]);
        }

        System.out.println(" }");
    }

    /**
     *  0   1   2   3   4   <--- index
     *  9   3   2   8   5   <--- original elements
     *  2   3   5   8   9   <--- sorted elements
     *                  i   <--- outer loop
     *  j                   <--- inner loop
     *
     *  tmp                     = 8
     *  array.length - i - 1    = 0
     *
     * @param array
     * @return
     */
    public int[] bubbleSort(int[] array) {

        // 1.0 For i = 0, ..., right - 1, repeat:
        for (int i = 0; i < array.length - 1; i++) {

            // 1.1 For j = left, ..., right - i - 1, repeat:
            for (int j = 0; j < array.length - i - 1; j++) {

                // 1.1.1 If a[j] is greater than a[j + 1],
                if(array[j] > array[j + 1]) {

                    // 1.1.1 Swap a[j] and a[j + 1]
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        String[] words1 = {"fox", "cow", "pig", "cat", "rat", "lio", "tig", "goa", "dog"};
        String[] words2;

        int left = 0, right = words1.length - 1;

        words2 = words1.clone();
        selectionSort(words2, left, right, true);

        words2 = words1.clone();
        insertionSort(words2, left, right, true);
    }
}
