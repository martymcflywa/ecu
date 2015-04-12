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

        // do insert methods
        doInsert(fruitList, "first", "Orange", null);
        doInsert(fruitList, "last", "Watermelon", null);
        doInsert(fruitList, "first", "Apple", null);
        doInsert(fruitList, "after", "Banana", "Apple");
        doInsert(fruitList, "after", "Coconut", "Banana");
        doInsert(fruitList, "after", "Papaya", "Orange");
        // target doesn't exist here
        doInsert(fruitList, "after", "Grapefruit", "Fig");
        doInsert(fruitList, "after", "Durian", "Coconut");

        System.out.println("Now performing delete methods on:");
        System.out.println(fruitList + "\n");

        // do delete methods
        doDelete(fruitList, "first", null);
        doDelete(fruitList, "last", null);
        doDelete(fruitList, "target", "Durian");
        doDelete(fruitList, "target", "Tomato");
        doDelete(fruitList, "first", null);
        doDelete(fruitList, "last", null);
        doDelete(fruitList, "first", null);
        // last node
        doDelete(fruitList, "first", null);
        // list already empty
        doDelete(fruitList, "first", null);
    }

    private static void doInsert(SLL<String> list, String insertType, String data, String target) {

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

    private static void doDelete(SLL<String> list, String deleteType, String target) {
        if(deleteType == "first" || deleteType == "last") {
            if(deleteType == "first") {
                list.deleteFirst();
                System.out.println("deleteFirst(): " + list);
            } else {
                list.deleteLast();
                System.out.println("deleteLast(): " + list);
            }
        } else if(deleteType == "target") {
            list.deleteTarget(target);
            System.out.println("deleteTarget(" + target + "): " + list);
        }
        //System.out.println("Head: " + list.getHead());
        System.out.println("Length: " + list.getListLength() + "\n");
    }
}
