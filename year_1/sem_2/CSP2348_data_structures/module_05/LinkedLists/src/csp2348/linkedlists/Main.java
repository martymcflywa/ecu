package csp2348.linkedlists;

import csp2348.linkedlists.dll.*;
import csp2348.linkedlists.sll.*;

/**
 * This is the main executable class to test SLL methods.
 *
 * @author Martin Ponce, StudentID 10371381
 * @version 20110415
 */
public class Main {

    private static SLL<String> fruitSLL = new SLL();
    private static DLL<String> carsDLL = new DLL();

    public static void main (String[] args) {

        /**
         * SLL TEST:
         */
        System.out.println("*** TESTING SLL: *** \n");
        // do insert methods
        insertSLL(fruitSLL, "first", "Orange", null);
        insertSLL(fruitSLL, "last", "Watermelon", null);
        insertSLL(fruitSLL, "first", "Apple", null);
        insertSLL(fruitSLL, "after", "Banana", "Apple");
        insertSLL(fruitSLL, "after", "Coconut", "Banana");
        insertSLL(fruitSLL, "after", "Papaya", "Orange");
        // target doesn't exist here
        insertSLL(fruitSLL, "after", "Grapefruit", "Fig");
        insertSLL(fruitSLL, "after", "Durian", "Coconut");

        System.out.println("Now performing delete methods on:");
        System.out.println(fruitSLL + "\n");

        // do delete methods
        deleteSLL(fruitSLL, "first", null);
        deleteSLL(fruitSLL, "last", null);
        deleteSLL(fruitSLL, "target", "Durian");
        deleteSLL(fruitSLL, "target", "Tomato");
        deleteSLL(fruitSLL, "first", null);
        deleteSLL(fruitSLL, "last", null);
        deleteSLL(fruitSLL, "first", null);
        // last node
        deleteSLL(fruitSLL, "first", null);
        // list already empty
        deleteSLL(fruitSLL, "first", null);

        /**
         * DLL TEST:
         */
        System.out.println("*** TESTING DLL: *** \n");
        carsDLL.insertFirst("Porsche");
        carsDLL.insertFirst("Mercedes");
        carsDLL.insertLast("Ferrari");
        System.out.println(carsDLL);
        System.out.println(carsDLL.getHead());
        System.out.println(carsDLL.getTail());
        System.out.println(carsDLL.getListLength());
        System.out.println(carsDLL.deleteFirst());
        System.out.println(carsDLL.deleteLast());
        System.out.println(carsDLL);
    }

    private static void insertSLL(SLL<String> list, String insertType, String data, String target) {

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

    private static void deleteSLL(SLL<String> list, String deleteType, String target) {
        if(deleteType == "first" || deleteType == "last") {
            if(deleteType == "first") {
                System.out.println("deleteFirst() deletes " + list.deleteFirst());
                System.out.println("deleteFirst(): " + list);
            } else {
                System.out.println("deleteLast() deletes " + list.deleteLast());
                System.out.println("deleteLast(): " + list);
            }
        } else if(deleteType == "target") {
            list.deleteTarget(target);
            System.out.println("deleteTarget(" + target + "): " + list);
        }
        //System.out.println("Head: " + list.getHead());
        System.out.println("Length: " + list.getListLength() + "\n");
    }

    private static void insertDLL(DLL<String> list, String insertType, String data, String target) {

        if(insertType == "first" || insertType == "last") {
            if(insertType == "first") {
                // insertFirst here
            } else {
                // insertLast here
            }
            System.out.println("Head: " + list.getHead());
            System.out.println("Tail: " + list.getTail());
            System.out.println("Length: " + list.getListLength() + "\n");
        } else if(insertType == "after") {
            // insertAfter here
            System.out.println("insertAfter(" + data + ", " + target + "): " + list);
            System.out.println("Head: " + list.getHead());
            System.out.println("Tail: " + list.getTail());
            System.out.println("Length: " + list.getListLength() + "\n");
        }
    }
}
