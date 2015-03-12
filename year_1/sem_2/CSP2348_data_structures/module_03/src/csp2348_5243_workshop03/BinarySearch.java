package csp2348_5243_workshop03;

public class BinarySearch {

    public static void main(String[] args) {
        int[] a = {12, 23, 34, 45, 56, 67, 78, 89};
        BinarySearch binarySearch = new BinarySearch();
        System.out.println("search(a," + 78 + "): " + binarySearch.search(a, 78));
        System.out.println("search(a," + 10 + "): " + binarySearch.search(a, 10));
    }

    public int search(int[] a, int x) {
        int p = 0, q = a.length - 1;
        while (p <= q) {// search the segment a[p,...,q]
            int i = (p + q) / 2;         // index of element in the middle
            if (a[i] == x) {
                return i; // found target
            }
            if (a[i] < x) {
                p = i + 1;   // search upper half
            } else {
                q = i - 1;            // search lower half
            }
        }
        return -1;                 // target not found
    }
}