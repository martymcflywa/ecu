public class Sorting {

    public static void selectionSort (Comparable[] a, int left, int right,
            boolean tracing) {
    // Sort a[left...right].
        if (tracing)  trace("\nInitially:      ", a, left, right);
        for (int l = left; l < right; l++) {
            int p = l;  Comparable least = a[p];
            // ... least will always contain the value of a[p].
            for (int k = l+1; k <= right; k++) {
                int comp = a[k].compareTo(least);
                if (comp < 0) {
                    p = k;  least = a[p];
                }
            }
            if (p != l) {
                a[p] = a[l];  a[l] = least;
            }
            if (tracing)  trace("Iteration l = " + l + ":", a, left, right);
        }
        if (tracing)  trace("Selection sort: ", a, left, right);
    }


    public static void insertionSort (Comparable[] a, int left, int right,
            boolean tracing) {
    // Sort a[left...right].
        if (tracing)  trace("\nInitially:      ", a, left, right);
        for (int r = left+1; r <= right; r++) {
            Comparable val = a[r];  int p = r;
            while (p > left && val.compareTo(a[p-1]) < 0) {
                a[p] = a[p-1];  p--;
            }
            a[p] = val;
            if (tracing)  trace("Iteration r = " + r + ":", a, left, right);
        }
        if (tracing)  trace("Insertion sort: ", a, left, right);
    }


    public static void mergeSort (Comparable[] a, int left, int right,
            boolean tracing) {
    // Sort a[left...right].
        if (tracing)  trace("\nInitially:      ", a, left, right);
        if (left < right) {
            int m = (left + right)/2;
            mergeSort(a, left, m, false);
            if (tracing)  trace("Left sorted:    ", a, left, right);
            mergeSort(a, m+1, right, false);
            if (tracing)  trace("Right sorted:   ", a, left, right);
            Comparable[] b = new Comparable[right-left+1];
            merge(a, left, m, a, m+1, right, b, 0);
            for (int k = left; k <= right; k++)
                a[k] = b[k-left];
            if (tracing)  trace("Merged:         ", a, left, right);
        }
        if (tracing)  trace("Merge-sort:     ", a, left, right);
    }


    public static void merge
                (Comparable[] a1, int left1, int right1,
                 Comparable[] a2, int left2, int right2,
                 Comparable[] a, int left) {
    // Merge a1[left1...right1] and a2[left2...right2]into
    // a[left...]  (where both a1 and a2 are sorted).
        int i = left1, j = left2, k = left;
        while (i <= right1 && j <= right2) {
            int comp = a1[i].compareTo(a2[j]);
            if (comp <= 0)
                a[k++] = a1[i++];
            else
                a[k++] = a2[j++];
        }
        while (i <= right1)
            a[k++] = a1[i++];
        while (j <= right2)
            a[k++] = a2[j++];
    }


    public static void quickSort (Comparable[] a, int left, int right,
            boolean tracing) {
    // Sort a[left...right].
        if (tracing)  trace("\nInitially:      ", a, left, right);
        if (left < right) {
            int p = partition(a, left, right);
            if (tracing)  trace("Partitioned:    ", a, left, right);
            quickSort(a, left, p-1, false);
            if (tracing)  trace("Left sorted:    ", a, left, right);
            quickSort(a, p+1, right, false);
            if (tracing)  trace("Right sorted:   ", a, left, right);
        }
        if (tracing)  trace("Quick-sort:     ", a, left, right);
    }


    private static int partition (Comparable[] a, int left, int right) {
    // Partition a[left...right] such that
    // a[left...p-1] are all less than or equal to a[p] and
    // a[p+1...right] are all greater than or equal to a[p].
        Comparable pivot = a[left];  int p = left;
        for (int r = left+1; r <= right; r++) {
            int comp = a[r].compareTo(pivot);
            if (comp < 0) {
                a[p] = a[r];  a[r] = a[p+1];  a[p+1] = pivot;
                p++;
            }
        }
        return p;
    }



    public static void shellSort (Comparable[] a, int left, int right,
                            boolean tracing) {
    // Sort a[left...right].
        int gap = right - left + 1;
        do {
            gap = gap / 2;
            if ((gap % 2) == 0)  gap++;
            for (int i = gap; i <= right; i++) {
            	Comparable current = a[i];
            	int j;
            	for (j = i - gap; j >= left; j -= gap) {
            	    if (current.compareTo(a[j]) >= 0)  break;
            	    a[j+gap] = a[j];
            	}
            	a[j+gap] = current;
            }
            if (tracing)
                trace("Shell short, gap is " + gap + ":", a, left, right);
        } while (gap > 1);
    }


    private static void trace (String caption, Comparable[] a,
	    int left, int right) {
        System.out.print(caption + " {");
        for (int k = left; k <= right; k++)
            System.out.print(" " + a[k]);
        System.out.println(" }");
    }


    public static void main (String[] args) {
        String[] words1 = {"fox", "cow", "pig", "cat", "rat", "lio",
		"tig", "goa", "dog"};
        String[] words2;
        int left = 0, right = words1.length - 1;

        words2 = (String[]) words1.clone();
        selectionSort(words2, left, right, true);

        //words2 = (String[]) words1.clone();
        //insertionSort(words2, left, right, true);

        //words2 = (String[]) words1.clone();
        //mergeSort(words2, left, right, true);

        //words2 = (String[]) words1.clone();
        //quickSort(words2, left, right, true);

        //words2 = (String[]) words1.clone();
        //shellSort(words2, left, right, true);
    }

}
