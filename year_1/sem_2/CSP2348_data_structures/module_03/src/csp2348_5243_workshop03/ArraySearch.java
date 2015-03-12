package csp2348_5243_workshop03;

import java.util.Arrays;

public class ArraySearch {

    public static void main(String[] args) {
        ArraySearch arraysch = new ArraySearch();
        char[] a = new char[64];
        Arrays.fill(a, 'H');
        String s = new String(a);
        System.out.println("s = \"" + s + "\"");
        Object[] objects = new Object[8];
        Arrays.fill(objects, 2, 5, "Java");
        System.out.println("objects = " + Arrays.asList(objects));
        int[] x = {77, 44, 99, 88, 22, 33, 66, 55};
        int[] y = x.clone();
        System.out.print("x = ");
        arraysch.print(x);
        System.out.print("y = ");
        arraysch.print(y);
        System.out.println("Arrays.equals(x, y) = " + Arrays.equals(x, y));
        System.out.println("y.equals(x) = " + y.equals(x));
        y[4] = 0;
        System.out.print("y = ");
        arraysch.print(y);
        System.out.println("Arrays.equals(x, y) = " + Arrays.equals(x, y));
        System.out.print("x = ");
        arraysch.print(x);
        Arrays.sort(x);
        System.out.print("x = ");
        arraysch.print(x);
        int i = Arrays.binarySearch(x, 44);
        System.out.println("Arrays.binarySearch(x, 44) = " + i);
        i = Arrays.binarySearch(x, 47);
        System.out.println("Arrays.binarySearch(x, 47) = " + i);
    }

    public void print(int[] a) {
        System.out.print("{ " + a[0]);
        for (int i = 1; i < a.length; i++) {
            System.out.print(", " + a[i]);
        }
        System.out.println(" }");
    }
}