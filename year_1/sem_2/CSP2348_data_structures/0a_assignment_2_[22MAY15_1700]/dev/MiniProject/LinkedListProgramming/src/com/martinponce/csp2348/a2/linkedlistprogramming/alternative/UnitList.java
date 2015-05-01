package com.martinponce.csp2348.a2.linkedlistprogramming.alternative;

/**
 * Alternative UnitList class.
 *
 * @author jitian XIAO and Martin Ponce ID 10371381
 * @version 0.0.1
 * @since 20150427
 */
public class UnitList {

    // tracks head
    private UnitListNode head;
    // cursors to traverse
    private UnitListNode cursorCurrent;
    private UnitListNode cursorPrevious;
    // tracks list length
    public int length;

    /**
     * Constructor.
     */
    public UnitList() {
        head = null;
        cursorCurrent = null;
        cursorPrevious = null;
        length = 0;
    }

    /******************************
     * ORIGINAL UnitList methods. *
     ******************************/

    /**
     * Method inserts unit result node for a student.
     * Adds students in ascending order according to studentID.
     * TODO: FIX THIS METHOD!!! DOES NOT WORK!!!
     *
     * @param studentID int.
     * @param a1Mark int.
     * @param a2Mark int.
     * @param examMark int.
     */
    public void insertUnitResult(int studentID, int a1Mark, int a2Mark, int examMark) {

        UnitListNode insert = new UnitListNode(studentID, a1Mark, a2Mark, examMark);

        // if list is empty,
        if(isEmpty()) {
            // cannot insert anyway due to void return
            return;
        }

        cursorCurrent = head;
        cursorPrevious = null;

        // traverse list
        while(cursorCurrent != null) {

            // if current's studentID is >= arg studentID
            if(cursorCurrent.getStudentID() >= studentID) {

                // insert here
                break;
            }

            cursorPrevious = cursorCurrent;
            cursorCurrent = cursorCurrent.getNext();
        }

        // if current's studentID and arg studentID match,
        if(cursorCurrent.getStudentID() == studentID) {

            // replace unit marks
            cursorCurrent.setA1Mark(a1Mark);
            cursorCurrent.setA2Mark(a2Mark);
            cursorCurrent.setExamMark(examMark);
            return;
        }

        // if insert is at start of list,
        if(cursorPrevious == null) {

            insert.setNext(head);

            // due to void return, changing link to head would not work
            UnitListNode temp = new UnitListNode(
                    head.getStudentID(),
                    head.getA1Mark(),
                    head.getA2Mark(),
                    head.getExamMark(),
                    head.getNext()
            );

            head.setStudentID(studentID);
            head.setA1Mark(a1Mark);
            head.setA2Mark(a2Mark);
            head.setExamMark(examMark);

            length++;
            return;
        }

        // otherwise current's studentID > arg studentID and != start of list,
        insert.setNext(cursorCurrent);
        cursorPrevious.setNext(insert);
        length++;
    }

    /**
     * Method determines which student has the highest mark in the list.
     * Prints result.
     */
    public void getHighestMark() {

        if(isEmpty()) {
            return;
        }

        UnitListNode highestMark = head;

        for(cursorCurrent = head.getNext(); cursorCurrent != null; cursorCurrent = cursorCurrent.getNext()) {

            if(cursorCurrent.getA1Mark()
                    + cursorCurrent.getA2Mark()
                    + cursorCurrent.getExamMark()
                    > highestMark.getA1Mark()
                    + highestMark.getA2Mark()
                    + highestMark.getExamMark()) {

                highestMark = cursorCurrent;
            }
        }

        System.out.println("** STUDENT WITH HIGHEST MARK**\n" + highestMark);
    }

    /**
     * Method prints all student marks.
     */
    public void printUnitResult(UnitList theList) {

        if(isEmpty()) {
            System.out.println("Error: Print failed. List is empty!");
            return;
        }

        System.out.println("\n** STUDENT LINKED-LIST **");

        // traverse through each node
        for(cursorCurrent = theList.head; cursorCurrent != null; cursorCurrent = cursorCurrent.getNext()) {
            // print node at every traversal
            System.out.println(cursorCurrent);
        }
        System.out.println("\nLength: " + length + " nodes\n");
    }

    /*********************************
     * ALTERNATIVE UnitList methods. *
     *********************************/

    /**
     * Method inserts a new node as first node.
     *
     * @param studentID int.
     * @param a1Mark int.
     * @param a2Mark int.
     * @param examMark int.
     */
    public void insertFirst(int studentID, int a1Mark, int a2Mark, int examMark) {

        // create new node called insert using args as data
        UnitListNode insert = new UnitListNode(studentID, a1Mark, a2Mark, examMark);

        // if list is empty,
        if(isEmpty()) {

            // set head as insert
            head = insert;

            // else list is not empty,
        } else {

            // set insert's next as head
            insert.setNext(head);
            // set head as insert
            head = insert;
        }
        length++;
    }

    /**
     * Method inserts a new node as last node.
     *
     * @param studentID int.
     * @param a1Mark int.
     * @param a2Mark int.
     * @param examMark int.
     */
    public void insertLast(int studentID, int a1Mark, int a2Mark, int examMark) {

        UnitListNode insert = new UnitListNode(studentID, a1Mark, a2Mark, examMark);

        if(isEmpty()) {
            head = insert;
        } else {
            cursorCurrent = head;
            cursorPrevious = null;

            while(cursorCurrent != null) {
                cursorPrevious = cursorCurrent;
                cursorCurrent = cursorCurrent.getNext();
            }

            cursorPrevious.setNext(insert);
        }
        length++;
    }

    /**
     * Method inserts student data after a specified studentID.
     *
     * @param targetStudentID int - The studentID where new data will be inserted after.
     * @param studentID int.
     * @param a1Mark int.
     * @param a2Mark int.
     * @param examMark int.
     */
    public void inserAfterStudent(int targetStudentID, int studentID, int a1Mark, int a2Mark, int examMark) {

        for(cursorCurrent = head; cursorCurrent != null; cursorCurrent = cursorCurrent.getNext()) {

            if(cursorCurrent.getStudentID() == targetStudentID) {

                UnitListNode insert = new UnitListNode(studentID, a1Mark, a2Mark, examMark, cursorCurrent.getNext());
                cursorCurrent.setNext(insert);

                length++;
                return;
            }
        }

        // targetStudentID not found,
        System.out.println("Error: Student " + studentID + " NOT inserted. Target Student " + targetStudentID + " not found!");
    }

    public void deleteUnitResult(int studentID) {

        if(isEmpty()) {
            System.out.println("\nError: List is empty!");
            return;
        } else if(studentID < 999 || studentID > 9999) {
            System.out.println("\nError: Student " + studentID + " is outside valid range!");
            return;
        }

        cursorCurrent = head;
        cursorPrevious = null;

        while(cursorCurrent.getStudentID() != studentID) {

            if(cursorCurrent.getNext() == null) {

                System.out.println("Error: Student " + studentID + " not deleted. Student does not exist!");
                return;

            } else {
                cursorPrevious = cursorCurrent;
                cursorCurrent = cursorCurrent.getNext();
            }
        }

        if(cursorPrevious == null) {

            head = cursorCurrent.getNext();
            System.out.println("Deleted Student " + studentID + " (first node)");

        } else {

            System.out.println("\nDeleted Student " + studentID);
            cursorPrevious.setNext(cursorCurrent.getNext());
            cursorCurrent.setNext(null);
        }
        length--;
    }

    /**
     * Method reverses order of nodes in list then prints the list in reverse order.
     * Calls insertFirst() to rearrange nodes, and tempReverseList to store in reverse order.
     *
     * @pre Assumes that the list is already in ascending order.
     */
    public void printUnitResultReverse() {

        if(isEmpty()) {
            System.out.println("Error: List is empty. No nodes to print!");
            return;
        }

        System.out.println("** REVERSE STUDENT LINKED-LIST **");

        UnitList tempReverseList = new UnitList();

        for(cursorCurrent = head; cursorCurrent != null; cursorCurrent = cursorCurrent.getNext()) {

            tempReverseList.insertFirst(
                    cursorCurrent.getStudentID(),
                    cursorCurrent.getA1Mark(),
                    cursorCurrent.getA2Mark(),
                    cursorCurrent.getExamMark()
            );
        }

        printUnitResult(tempReverseList);
    }

    /**
     * Method checks if list is empty.
     *
     * @return boolean.
     */
    private boolean isEmpty() {
        return head == null;
    }
}
