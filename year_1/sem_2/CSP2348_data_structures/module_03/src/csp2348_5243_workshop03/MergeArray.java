package csp2348_5243_workshop03;
/* Example code taken from 
 * http://www.roseindia.net/tutorial/java/core/mergeArray.html
 * This is used to give you another implementation of the ArrayMerge algorithm.
 */

import java.util.*;

public class MergeArray {

    public static int[] merge(int[]... arr) {
        int arrSize = 0;
        for (int[] array : arr) {
            arrSize += array.length;
        }
        int[] result = new int[arrSize];
        int j = 0;
        for (int[] array : arr) {
            for (int s : array) {
                result[j++] = s;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] array1 = new int[5];
        System.out.println("Enter 5 numbers");
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < array1.length; i++) {
            array1[i] = input.nextInt();
        }
        int[] array2 = new int[3];
        System.out.println("Enter 3 numbers");
        for (int i = 0; i < array2.length; i++) {
            array2[i] = input.nextInt();
        }
        int[] array3 = new int[2];
        System.out.println("Enter 2 numbers");
        for (int i = 0; i < array3.length; i++) {
            array3[i] = input.nextInt();
        }
        int M[] = (int[]) merge(array1, array2, array3);
        System.out.println("Merged Array is: ");
        for (int i = 0; i < M.length; i++) {
            System.out.println(M[i]);
        }

    }
}