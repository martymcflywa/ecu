package com.martinponce.csp2348.a2.linkedlistprogramming.alternative;

/**
 * Defines alternative UnitList SLL class.
 *
 * @author jitian XIAO and Martin Ponce ID 10371381
 * @version 1.0.1
 * @since 20150502
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
     * If insert's studentID and current node studentID match, marks will be overwritten instead of adding new node.
     *
     * @param studentID int.
     * @param a1Mark int.
     * @param a2Mark int.
     * @param examMark int.
     */
    public void insertUnitResult(int studentID, int a1Mark, int a2Mark, int examMark) {

        UnitListNode insert = new UnitListNode(studentID, a1Mark, a2Mark, examMark);

        cursorCurrent = head;
        cursorPrevious = null;

        // traverse list
        while(cursorCurrent != null) {

            // if current studentID is >= arg studentID
            if(cursorCurrent.getStudentID() >= studentID) {

                // insert here
                break;
            }

            cursorPrevious = cursorCurrent;
            cursorCurrent = cursorCurrent.getNext();
        }

        // if insert is at start of list,
        if(cursorPrevious == null) {

            insert.setNext(head);

            head = insert;

            length++;
            return;
        }

        // if current studentID and arg studentID match,
        if(cursorCurrent != null && cursorCurrent.getStudentID() == studentID) {

            // replace unit marks
            cursorCurrent.setA1Mark(a1Mark);
            cursorCurrent.setA2Mark(a2Mark);
            cursorCurrent.setExamMark(examMark);

            System.out.println("\nReplaced Student " + studentID + " with new marks.");

            return;
        }

        // otherwise current studentID > arg studentID and != start of list,
        insert.setNext(cursorCurrent);
        cursorPrevious.setNext(insert);
        length++;
    }

    /**
     * Method determines which student has the highest mark in the list.
     * Prints result.
     */
    public void getHighestMark() {

        // if list is empty,
        if(isEmpty()) {
            // print error message and terminate
            System.out.println("\nError: Highest mark failed. List is empty!");
            return;
        }

        // start highestMark at head
        UnitListNode highestMark = head;

        // traverse through each node
        for(cursorCurrent = head.getNext(); cursorCurrent != null; cursorCurrent = cursorCurrent.getNext()) {

            // if current mark is higher than highestMark
            if(cursorCurrent.getA1Mark() + cursorCurrent.getA2Mark() + cursorCurrent.getExamMark()
                    > highestMark.getA1Mark() + highestMark.getA2Mark() + highestMark.getExamMark()) {

                // set highestMark to current
                highestMark = cursorCurrent;
            }
        }

        // terminate with highestMark as answer
        System.out.println("\n** STUDENT WITH HIGHEST MARK **\n" + highestMark);
    }

    /**
     * Method prints all student marks.
     */
    public void printUnitResult(UnitList theList) {

        // if list is empty,
        if(isEmpty()) {
            // print error message and terminate
            System.out.println("\nError: Print failed. List is empty!");
            return;
        }

        System.out.println("\n** STUDENT LINKED-LIST **");

        // traverse through each node
        for(cursorCurrent = theList.head; cursorCurrent != null; cursorCurrent = cursorCurrent.getNext()) {
            // print node at every traversal
            System.out.println(cursorCurrent);
        }
        System.out.println("\nLength: " + length + " nodes");
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

            // set insert next as head
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

        // create new node called insert
        UnitListNode insert = new UnitListNode(studentID, a1Mark, a2Mark, examMark);

        // if list is empty,
        if(isEmpty()) {
            // set head as insert
            head = insert;

            // else list is not empty,
        } else {

            // set cursors to start of list
            cursorCurrent = head;
            cursorPrevious = null;

            // traverse each cursor through the list until current = null
            while(cursorCurrent != null) {
                cursorPrevious = cursorCurrent;
                cursorCurrent = cursorCurrent.getNext();
            }

            // at end of list, set previous next to insert
            cursorPrevious.setNext(insert);
        }
        length++;
    }

    /**
     * Method inserts student data after a specified studentID.
     *
     * @param targetStudentID int - The studentID where new node will be inserted after.
     * @param studentID int.
     * @param a1Mark int.
     * @param a2Mark int.
     * @param examMark int.
     */
    public void inserAfterStudent(int targetStudentID, int studentID, int a1Mark, int a2Mark, int examMark) {

        // traverse through each node
        for(cursorCurrent = head; cursorCurrent != null; cursorCurrent = cursorCurrent.getNext()) {

            // if target found,
            if(cursorCurrent.getStudentID() == targetStudentID) {

                // create new node called insert
                UnitListNode insert = new UnitListNode(studentID, a1Mark, a2Mark, examMark, cursorCurrent.getNext());
                // set current next as insert
                cursorCurrent.setNext(insert);

                length++;
                return;
            }
        }

        // this happens if targetStudentID not found,
        System.out.println("\nError: Student " + studentID + " NOT inserted. Target Student " + targetStudentID + " not found!");
    }

    /**
     * Method deletes specified node, using studentID as target.
     *
     * O(n):
     *
     * @param studentID int - Identifies the node to be deleted.
     */
    public void deleteUnitResult(int studentID) {

        // if list is empty,
        if(isEmpty()) {
            // print error message and terminate
            System.out.println("\nError: List is empty!");
            return;

            // else if studentID outside rage,
        } else if(studentID < 999 || studentID > 9999) {
            // print error message and terminate
            System.out.println("\nError: Student " + studentID + " is outside valid range!");
            return;
        }

        // set cursors to start of list
        cursorCurrent = head;
        cursorPrevious = null;

        // while current studentID does not match target studentID
        while(cursorCurrent.getStudentID() != studentID) {

            // if reached end of list,
            if(cursorCurrent.getNext() == null) {
                // print error message and terminate
                System.out.println("\nError: Student " + studentID + " not deleted. Student does not exist!");
                return;

                // else continue traversing
            } else {
                cursorPrevious = cursorCurrent;
                cursorCurrent = cursorCurrent.getNext();
            }
        }

        // if targetID found in very first node,
        if(cursorPrevious == null) {

            // set head to current next
            head = cursorCurrent.getNext();
            // print success message
            System.out.println("\nDeleted Student " + studentID + " (first node).");

            // else targetID found somewhere else down the list,
        } else {

            // print success message
            System.out.println("\nDeleted Student " + studentID + ".");
            // set previous next to current next
            cursorPrevious.setNext(cursorCurrent.getNext());
            // set current next to null
            cursorCurrent.setNext(null);
        }
        length--;
    }

    /**
     * Method reverses order of nodes in list then prints the list in reverse order.
     * Calls insertFirst() to rearrange nodes, and tempReverseList to store in reverse order.
     *
     * O(n^2):
     *
     * @pre Assumes that the list is already in ascending order.
     */
    public void printUnitResultReverse() {

        // if list is empty,
        if(isEmpty()) {
            // print error message and terminate
            System.out.println("\nError: List is empty. No nodes to print!");
            return;
        }

        System.out.println("\n** REVERSE STUDENT LINKED-LIST **");

        // create new temp list to store reverse list
        UnitList tempReverseList = new UnitList();

        // traverse through each node O(n)
        for(cursorCurrent = head; cursorCurrent != null; cursorCurrent = cursorCurrent.getNext()) {

            // copy each node to temp list in reverse order (uses insertFirst)
            // ASSUMPTION: list already in ascending order, otherwise won't work
            tempReverseList.insertFirst(
                    cursorCurrent.getStudentID(),
                    cursorCurrent.getA1Mark(),
                    cursorCurrent.getA2Mark(),
                    cursorCurrent.getExamMark()
            );
        }

        // print each node in temp list O(n)
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
