package csp2348_5243_workshop04;

/**
 * Test selection and insertion sorting algorithms.
 */
public class WS0401 {

    public static void selectionSort(Comparable[] a, int left, int right, boolean tracing) {

        // Sort a[left...right].
        if (tracing) {
            trace("\nInitially:      ", a, left, right);
        }

        for (int l = left; l < right; l++) {

            int p = l;
            Comparable least = a[p];

            // ... least will always contain the value of a[p].
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
