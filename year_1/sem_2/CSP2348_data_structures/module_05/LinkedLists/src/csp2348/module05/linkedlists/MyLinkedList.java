package csp2348.module05.linkedlists;

public class MyLinkedList<E> {

    private Node<E> head;
    private Node<E> tail;
    private Node<E> cursorCurrent;
    private Node<E> cursorPrevious;

    public int length;

    /**
     * MyLinkedList default constructor.
     */
    public MyLinkedList() {
        head = null;
        tail = null;
        cursorCurrent = null;
        cursorPrevious = null;
        length = 0;
    }

    /**********************
     * SLL ADD ALGORITHMS *
     **********************/

    /**
     * SLL: Insert new node as first.
     *
     * O(1): Performs one comparison for any length of list.
     *
     * @param data E
     */
    public void insertFirstSLL(E data) {

        // create new node called insert, pass data
        Node<E> insert = new Node<E>(data);

        // east case: if list is empty (ie. head == null),
        if(isEmpty()) {

            // set head as insert
            head = insert;

            // else list is not empty,
        } else {

            // set insert's next as head,
            insert.setNext(head);
            // set head as insert
            head = insert;
        }
        length++;

        System.out.println("[" + data + "]" + " inserted as FIRST node: \n" + this);
        System.out.println("Head: " + "[" + head.getData() + "]");
        System.out.println("Length: " + length + "\n");
    }

    /**
     * SLL: Insert new node as last.
     *
     * O(n): Performs n comparisons to traverse to end of list.
     *
     * @param data E
     */
    public void insertLastSLL(E data) {

        // create new node called insert, pass data
        Node<E> insert = new Node<E>(data);

        // easy case: if list is empty,
        if(isEmpty()) {

            // set head as insert
            head = insert;

            // else list is not empty,
        } else {

            // set cursors to head
            cursorCurrent = head;
            cursorPrevious = head;

            // loop while cursorCurrent != null:
            while(cursorCurrent != null) {

                // continue traversal with cursors
                cursorPrevious = cursorCurrent;
                cursorCurrent = cursorCurrent.getNext();
            }

            // end of list is found, set cursorPrevious next as insert
            cursorPrevious.setNext(insert);
        }

        // reset cursors
        resetCursors();
        // increment list
        length++;

        System.out.println("[" + data + "]" + " inserted as LAST node: \n" + this);
        System.out.println("Head: " + "[" + head.getData() + "]");
        System.out.println("Length: " + length + "\n");
    }

    /**
     * SLL: Insert after target.
     *
     * To insert elem at a given point in the SLL headed by first:
     *
     * O(n): Performs between (n + 1) / 2 (successful) or n (unsuccessful) comparisons,
     * to find target before inserting.
     *
     * @param data E
     * @param target E
     */
    public void insertAfterSLL(E data, E target) {

        cursorCurrent = head;

        for(MyLinkedList list = this; cursorCurrent != null; cursorCurrent = cursorCurrent.getNext()) {

            if(cursorCurrent.getData().equals(target)) {

                Node<E> insert = new Node<E>(data, cursorCurrent.getNext());
                cursorCurrent.setNext(insert);
                length++;

                System.out.println("[" + data + "]" + " inserted AFTER " + "[" + target + "]: \n" + this);
                System.out.println("Head: " + "[" + head.getData() + "]");
                System.out.println("Length: " + length + "\n");

                resetCursors();
                return;
            }
        }
        System.out.println("[" + data + "]" + " NOT inserted, " + "[" + target + "]" + " was not found in the list!\n" + this);
        System.out.println("Head: " + "[" + head.getData() + "]");
        System.out.println("Length: " + length + "\n");
    }

    /*************************
     * SLL DELETE ALGORITHMS *
     *************************/

    /**
     * SLL: Delete first node. Return deleted node.
     *
     * O(1): Performs one comparison for any length of list.
     *
     * @return E
     */
    public void deleteFirstSLL() {

        // create temp node called remove, set it to head
        Node<E> remove = head;

        // easy case: if list is empty,
        if(isEmpty()) {
            // print error message and end algorithm
            System.out.println("Error: Nothing deleted, list is empty!");

            // else list is not empty,
        } else {

            // set head to head's next
            head = head.getNext();
            // decrement length
            length--;

            System.out.println("First node " + "[" + remove.getData() + "]" + " deleted:\n" + this);
        }

        System.out.println("Head: " + "[" + head.getData() + "]");
        System.out.println("Length: " + length + "\n");
    }

    /**
     * SLL: Delete last node. Return deleted node.
     *
     * O(n): Performs n comparisons to traverse to end of list.
     *
     * @return E
     */
    public void deleteLastSLL() {

        E remove;

        // easy case: list is empty,
        if(isEmpty()) {
            // print error message and end algorithm
            System.out.println("Nothing deleted, list is empty!\n" + this);

            // else list is not empty,
        } else {

            // set cursorCurrent to head
            cursorCurrent = head;
            cursorPrevious = head;

            // loop until cursorCurrent is at last node:
            while(cursorCurrent.getNext() != null) {
                // traverse cursorPrevious one node behind
                cursorPrevious = cursorCurrent;
                // traverse cursorCurrent to next node
                cursorCurrent = cursorCurrent.getNext();
            }

            // when arrived at last node,

            // remove link to final node
            cursorPrevious.setNext(null);
            // set remove to the removed link's data
            remove = cursorCurrent.getData();
            // decrement length
            length--;
            // reset cursors
            resetCursors();

            // print message
            System.out.println("Last node " + "[" + remove + "]" + " deleted:\n" + this);
        }
        System.out.println("Head: " + "[" + head.getData() + "]");
        System.out.println("Length: " + length + "\n");
    }

    /**
     * SLL: Delete target node.
     *
     * O(n): Performs between (n - 1) / 2 (successful) and n (unsuccessful) comparisons to find target.
     *
     * @param target E
     * @return
     */
    public void deleteTargetSLL(E target) {

        E remove = null;
        cursorCurrent = head;
        cursorPrevious = head;

        while(cursorCurrent.getData() != target) {

            // if currentCursor traversed to end of link, and target not found,
            if(cursorCurrent.getNext() == null) {
                // print error message, end process
                System.out.println("[" + target + "]" + " NOT deleted, was not found!\n" + this);
                System.out.println("Head: " + "[" + head.getData() + "]");
                System.out.println("Length: " + length + "\n");
                return;

                // else continue traversing
            } else {
                cursorPrevious = cursorCurrent;
                cursorCurrent = cursorCurrent.getNext();
            }
        }

        // if cursorCurrent is at first node, and target matched (implied after exiting while loop)
        if(cursorCurrent == head) {
            remove = head.getData();
            head = head.getNext();

            // else cursorCurrent is somewhere else down the list, and target matched (implied after exiting while loop)
        } else {
            remove = cursorCurrent.getData();
            cursorPrevious.setNext(cursorCurrent.getNext());
        }

        resetCursors();
        length--;

        System.out.println("[" + remove + "]" + " found and deleted:\n" + this);
        System.out.println("Head: " + "[" + head.getData() + "]");
        System.out.println("Length: " + length + "\n");
    }

    /*************************
     * SLL SEARCH ALGORITHMS *
     *************************/

    /**
     * SLL: Searches for target in list.
     * Returns int index if target found, else returns -1
     *
     * O(n): Performs between (n + 1) / 2 (successful) and n (unsuccessful) comparisons
     *
     * @param target E
     * @return int
     */
    public void searchSLL(E target) {

        int index = 1;

        // easy case: if list is empty,
        if(isEmpty()) {

            index = -1;
            return;

            // else list is not empty,
        } else {

            // set cursorCurrent to head
            cursorCurrent = head;

            // loop until cursor is at last node
            while(cursorCurrent != null) {

                // if data at cursor matches target,
                if(cursorCurrent.getData().equals(target)) {

                    // return index
                    //return index;
                    System.out.println(cursorCurrent.getData() + " was found at index " + index + "\n" + this);
                    System.out.println("Head: " + "[" + head.getData() + "]");
                    System.out.println("Length: " + length + "\n");
                    return;
                }
                // cursor traverses to next node
                cursorCurrent = cursorCurrent.getNext();
                // increment index
                index++;
            }
        }

        // done with cursor, reset to null
        resetCursors();
        // return -1 if at end of list and target not found
        //return -1;
        System.out.println("Error: " + "[" + target + "]"  + " was not found in the list!\n" + this);
        System.out.println("Head: " + "[" + head.getData() + "]");
        System.out.println("Length: " + length + "\n");
    }

    /***********
     * HELPERS *
     ***********/

    /**
     * Helper method.
     * Tests if list is empty.
     *
     * @return boolean
     */
    private boolean isEmpty() {
        return(head == null);
    }

    /**
     * Helper method.
     * Set cursors to null.
     */
    private void resetCursors() {
        cursorCurrent = null;
        cursorPrevious = null;
    }

    /**
     * Overriding toString, returns all elements in list,
     * concatenated as a single String.
     * Delimited by '[' and ']'.
     *
     * @return
     */
    @Override
    public String toString() {
        cursorCurrent = head;
        cursorPrevious = head;
        String output = "";

        while(cursorCurrent != null) {
            cursorPrevious = cursorCurrent;
            output += "[" + cursorPrevious.getData() + "]";
            cursorCurrent = cursorCurrent.getNext();
        }

        // done with cursors, reset to null
        resetCursors();
        return output;
    }

    /**
     * Node subclass.
     *
     * @param <E>
     */
    class Node<E> {

        private E data;
        private Node<E> next;
        private Node<E> previous;

        /**
         * Node default constructor.
         */
        public Node() {
            data = null;
            next = null;
            previous = null;
        }

        /**
         * Node overloaded constructor.
         * Accepts data.
         *
         * @param data E
         */
        public Node(E data) {
            this.data = data;
            next = null;
            previous = null;
        }

        /**
         * Node overloaded constructor.
         * Accepts data, next.
         *
         * @param data E
         * @param next Node
         */
        public Node(E data, Node<E> next) {
            this.data = data;
            this.next = next;
            previous = null;
        }

        /**
         * Node overloaded constructor.
         * Accepts data, next, previous.
         *
         * @param data E
         * @param next Node
         * @param previous Node
         */
        public Node(E data, Node<E> next, Node<E> previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        /**
         * Returns data.
         *
         * @return data E
         */
        public E getData() {
            return data;
        }

        /**
         * Returns next.
         *
         * @return next Node
         */
        public Node<E> getNext() {
            return next;
        }

        /**
         * Returns previous.
         *
         * @return previous Node
         */
        public Node<E> getPrevious() {
            return previous;
        }

        /**
         * Sets data.
         *
         * @param data E
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * Sets next.
         *
         * @param next E
         */
        public void setNext(Node<E> next) {
            this.next = next;
        }

        /**
         * Sets previous.
         *
         * @param previous Node
         */
        public void setPrevious(Node<E> previous) {
            this.previous = previous;
        }
    }
}
