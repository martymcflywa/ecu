package csp2348_5243_workshop03;

public class LinearSearch {

    public static void main(String[] args) {
        int[] a = {66, 44, 99, 33, 55, 22, 88, 77};
        LinearSearch LS = new LinearSearch();
        System.out.println("search(a," + 55 + "): " + LS.search(a, 55));
        System.out.println("search(a," + 50 + "): " + LS.search(a, 50));
    }

    public int search(int[] a, int target) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == target) {
                return i;
            }
        }
        return -a.length;
    }
}