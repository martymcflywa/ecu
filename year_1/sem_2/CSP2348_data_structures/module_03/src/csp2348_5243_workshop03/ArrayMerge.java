package csp2348_5243_workshop03;

public class ArrayMerge {

    public static void main(String[] args) {
        int[] a1 = {1, 2, 4, 6, 8, 9, 11, 12};
        int[] a2 = {3, 5, 7, 10};
        int[] a3 = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        ArrayMerge arrayM = new ArrayMerge();
        arrayM.merge(a1, 0, 7, a2, 0, 3, a3, 0);
        System.out.print("a1 = ");
        arrayM.print(a1);
        System.out.print("a2 = ");
        arrayM.print(a2);
        System.out.print("a3 = ");
        arrayM.print(a3);
    }

    public void merge(int[] a1, int l1, int r1, int[] a2, int l2, int r2, int[] a3, int l3) { 
        //merge existing a1[l1,...,r1] and existing a2[l2,...,r2]
        //into existing a3[l3], where a1 and a2 are sorted
        int i = l1, j = l2, k = l3;
        while (i <= r1 && j <= r2) {
            if (a1[i] <= a2[j]) {
                a3[k++] = a1[i++];
            } else {
                a3[k++] = a2[j++];
            }
        }
        while (i <= r1) {
            a3[k++] = a1[i++];
        }
        while (j <= r2) {
            a3[k++] = a2[j++];
        }
    }

    public void print(int[] a) {
        System.out.print("{ " + a[0]);
        for (int i = 1; i < a.length; i++) {
            System.out.print(", " + a[i]);
        }
        System.out.println(" }");
    }
}