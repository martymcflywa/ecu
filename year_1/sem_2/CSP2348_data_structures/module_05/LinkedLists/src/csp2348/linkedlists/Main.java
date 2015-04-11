package csp2348.linkedlists;

import csp2348.linkedlists.sll.*;

/**
 * This is the main executable class to test SLL methods.
 *
 * @author Martin Ponce, StudentID 10371381
 * @version 20110415
 */
public class Main {

    private static SLL<String> fruitList = new SLL<String>();

    public static void main (String[] args) {

        doInsert(fruitList, "first", "Orange", null, 0);
        doInsert(fruitList, "last", "Watermelon", null, 0);
        //doInsert(fruitList, "after", "Banana", "Orange", 0);
        doInsert(fruitList, "first", "Apple", null, 0);
        fruitList.insertAfter("Banana", "Apple");
        System.out.println(fruitList);
    }

    private static void doInsert(SLL<String> list, String insertType, String data, String target, int index) {

        if(insertType == "first" || insertType == "last") {
            if(insertType == "first") {
                list.insertFirst(data);
                System.out.println("insertFirst(" + data + "): " + list);
            } else {
                list.insertLast(data);
                System.out.println("insertLast(" + data + "): " + list);
            }
            System.out.println("Head: " + list.getHead());
            System.out.println("Length: " + list.getListLength() + "\n");

        } else if(insertType == "after") {
            list.insertAfter(data, target);
            System.out.println("insertAfter(" + data + ", " + target + "): " + list);
            System.out.println("Head: " + list.getHead());
            System.out.println("Length: " + list.getListLength() + "\n");
        }
    }
}
