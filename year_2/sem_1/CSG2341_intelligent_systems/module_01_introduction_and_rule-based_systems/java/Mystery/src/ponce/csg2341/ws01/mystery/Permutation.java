package ponce.csg2341.ws01.mystery;

/**
 * Created by marty on 28/07/2015.
 */
public class Permutation {

    // static class, do not instantiate
    private Permutation() {

    }

    public static void permute(int[] array) {
        permuteHelper(array, 0);
    }

    private static void permuteHelper(int[] array, int index) {
        if(index >= array.length - 1) {
            System.out.println();
            for(int i : array) {
                System.out.print(array[i] + ", ");
            }

            return;
        }

        for(int i : array) {
            int temp = array[index];
            array[index] = array[i];
            array[i] = temp;

            permuteHelper(array, index + 1);

            temp = array[index];
            array[index] = array[i];
            array[i] = temp;
        }
    }
}
