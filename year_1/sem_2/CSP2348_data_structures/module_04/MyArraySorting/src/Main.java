/**
 * Created by marty on 14/04/2015.
 */
public class Main {

    private static int[] numbers = {9, 1, 8, 5, 7, 6, 3, 4, 0, 2};
    private static ArraySorting myArraySorting;

    public static void main(String[] args) {

        // instantiate ArraySorting class
        myArraySorting = new ArraySorting();
        // print unsorted array
        System.out.println(myArraySorting.getString(numbers));

        // do selection sort and print
        myArraySorting.selectionSort(numbers);
        System.out.println(myArraySorting.getString(numbers));

        // unsort and print
        unsort();

        // do insertion sort and print
        myArraySorting.insertionSort(numbers);
        System.out.println(myArraySorting.getString(numbers));

    }

    private static void unsort() {
        numbers[0] = 9;
        numbers[1] = 1;
        numbers[2] = 8;
        numbers[3] = 5;
        numbers[4] = 7;
        numbers[5] = 6;
        numbers[6] = 3;
        numbers[7] = 4;
        numbers[8] = 0;
        numbers[9] = 2;

        System.out.println(myArraySorting.getString(numbers));
    }
}
