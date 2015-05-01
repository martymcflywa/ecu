package com.martinponce.csp2348.a2.linkedlistprogramming.alternative;

/**
 * Defines a node for alternative UnitList class.
 *
 * @author Martin Ponce ID 10371381
 * @version 0.0.1
 * @since 20150427
 */
public class UnitListNode {

    // student data
    private int studentID;
    private int a1Mark;
    private int a2Mark;
    private int examMark;

    // tracks next node
    private UnitListNode next;

    /**
     * Constructor.
     *
     * @param studentID
     * @param a1Mark
     * @param a2Mark
     * @param examMark
     */
    public UnitListNode(int studentID, int a1Mark, int a2Mark, int examMark) {

        if((studentID < 999) || (studentID > 9999)) {
            return;
        }
        if((a1Mark < 0.0) || (a1Mark > 20.0)) {
            return;
        }
        if((a2Mark < 0.0) || (a2Mark > 30.0)) {
            return;
        }
        if((examMark < 0.0) || (examMark > 50.0)) {
            return;
        }

        this.studentID = studentID;
        this.a1Mark = a1Mark;
        this.a2Mark = a2Mark;
        this.examMark = examMark;
        next = null;
    }

    /**
     * Overloaded constructor, accepts next node.
     *
     * @param studentID int.
     * @param a1Mark int.
     * @param a2Mark int.
     * @param examMark int.
     * @param next UnitListNode.
     */
    public UnitListNode(int studentID, int a1Mark, int a2Mark, int examMark, UnitListNode next) {
        this.studentID = studentID;
        this.a1Mark = a1Mark;
        this.a2Mark = a2Mark;
        this.examMark = examMark;
        this.next = next;
    }

    /**
     * Overriding toString.
     *
     * @return output String.
     */
    @Override
    public String toString() {
        String output = "\nStudent: " + studentID
                + "\nA1 Mark: " + a1Mark
                + "\nA2 Mark: " + a2Mark
                + "\nExam Mark: " + examMark
                + "\nNext Node: ";

        if(this.getNext() == null) {
            output += "null";
        } else {
            output += this.getNext().getStudentID();
        }

        return output;
    }

    /**
     * Sets studentID.
     *
     * @param studentID int.
     */
    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    /**
     * Sets a1Mark.
     *
     * @param a1Mark int.
     */
    public void setA1Mark(int a1Mark) {
        this.a1Mark = a1Mark;
    }

    /**
     * Sets a2Mark.
     *
     * @param a2Mark int.
     */
    public void setA2Mark(int a2Mark) {
        this.a2Mark = a2Mark;
    }

    /**
     * Sets examMark.
     *
     * @param examMark int.
     */
    public void setExamMark(int examMark) {
        this.examMark = examMark;
    }

    /**
     * Sets next.
     *
     * @param next UnitListNode.
     */
    public void setNext(UnitListNode next) {
        this.next = next;
    }

    /**
     * Gets studentID.
     *
     * @return studentID int.
     */
    public int getStudentID() {
        return studentID;
    }

    /**
     * Gets a1Mark.
     *
     * @return a1Mark int.
     */
    public int getA1Mark() {
        return a1Mark;
    }

    /**
     * Gets a2Mark.
     *
     * @eturn a2Mark int.
     */
    public int getA2Mark() {
        return a2Mark;
    }

    /**
     * Gets examMark.
     *
     * @return examMark int.
     */
    public int getExamMark() {
        return examMark;
    }

    /**
     * Gets next node.
     *
     * @return next UnitListNode.
     */
    public UnitListNode getNext() {
        return next;
    }
}
