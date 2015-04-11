package csp2348.linkedlists.sll;

/**
 * This class defines the SLL fields and methods.
 * Uses generics so any type may be stored in the list.
 *
 * @author Martin Ponce, StudentID 10371381
 * @version 20150411
 */
public class SLL<E> {

    // always points to first node
    private SLLNode<E> head;

    // used for traversal
    private SLLNode<E> current;
    private SLLNode<E> previous;

    // might as well store list length too
    private int listLength;

    /**
     * SLL default constructor.
     * Creates new nodes for head, current, previous, and sets to null.
     * Sets listLength to 0.
     */
    public SLL() {

        // set head to null
        head = null;
        listLength = 0;
    }

    /**
     * This method inserts a new node as first node.
     * O(1): Performs 1 comparison for any length of list.
     *
     * @param data E
     */
    public void insertFirst(E data) {

        // create new node with arg data as its data, null as its next
        SLLNode<E> insert = new SLLNode<E>(data, null);

        // if head is null, meaning there are no other nodes in the list,
        if(head == null) {

            // set head to insert, making insert the first node
            head = insert;

        // else, there are other nodes in the list,
        } else {

            // set inserts next as head, meaning point insert's next to current first node
            insert.setNext(head);
            // set head as insert, making insert the first node
            head = insert;
        }
        // increment list length
        listLength++;
    }

    /**
     * This method inserts a new node as last node.
     * O(n): Performs n comparisons to traverse to end of list.
     *
     * @param data E
     */
    public void insertLast(E data) {

        // create new node with arg data as its data, null as its next
        SLLNode<E> insert = new SLLNode<E>(data, null);

        // if head is null,
        if(head == null) {

            // set head to insert, new node is last
            head = insert;

        // else, there are other nodes in list
        } else {

            // set current to head, current will traverse to find last node
            current = head;

            // loop while current != null, current traverses until it reaches end of list:
            while(current != null) {
                // set previous to current
                previous = current;
                // set current to its next node
                current = current.getNext();
            }
            // current == null, last node found,
            // set previous next as insert, meaning point last node's next to new node,
            // making new node the last node
            previous.setNext(insert);
        }
        // increment list length
        listLength++;
    }

    /**
     * This method deletes first node, and returns the deleted node.
     * If list is empty, return null. See TODO.
     * O(1): Performs 1 comparison for any length of list.
     *
     * @return remove SLLNode<E>
     */
    public SLLNode<E> deleteFirst() {

        // create new reference called remove, set as head
        SLLNode<E> remove = head;

        // if head != null, meaning other nodes exist in list,
        if(head != null) {

            // set head as the next node, making the next node the first node
            head = head.getNext();

        // else head == null, no other nodes exist,
        } else {
            // set remove as null
            // TODO: throw exception instead
            remove = null;
        }
        // decrement list length;
        listLength--;
        // return removed node
        return remove;
    }

    /**
     * This method deletes last node, and returns the deleted node.
     * If list is empty, return null. See TODO.
     * O(n): Performs n comparisons to traverse to end of list.
     *
     * @return remove SLLNode<E>
     */
    public SLLNode<E> deleteLast() {

        // if head != null, meaning other nodes exist in list,
        if(head != null) {

            // set current to head, make current == first node
            current = head;

            // loop while current's next is not null, meaning loop through until at last node:
            while(current.getNext() != null) {
                // traverse previous to current node
                previous = current;
                // traverse current to current's next node
                current = current.getNext();
            }
            // current.getNext() == null, arrived at last node
            // set previous node's pointer to null, removing link to last node
            previous.setNext(null);
            // decrement list length
            listLength--;
            // return removed node
            return current;

        // else head == null, no other nodes exist,
        } else {
            // return null
            // TODO: throw exception instead
            return null;
        }
    }

    /**
     * This method deletes a node that matches the specified target.
     * Returns the deleted node (current).
     * Prints error messages when list is empty, or target is not found.
     * Returns null. See TODO.
     * O(n): Performs (n - 1) / 2 traversals to find target.
     *
     * @param target E
     * @return current SSLNode<E>
     */
    public SLLNode<E> deleteTarget(E target) {

        // if list is empty,
        if(head == null) {
            // print error message
            System.out.println("Error: The list is empty!");
            // return null
            // TODO: throw exception instead
            return null;

        // else list is not empty,
        } else {

            // set current to first node
            current = head;

            // loop while current != null AND current != target:
            while(current != null && !current.getData().equals(target)) {

                // previous traverses to current
                previous = current;
                // current traverses to next node
                current = current.getNext();
            }
        }

        // if current is first node AND matches target,
        if(current == head && current.getData().equals(target)) {

            // set head as second node
            head = head.getNext();
            // decrement list length
            listLength--;
            // return current
            return current;

        // else if current != null (also implies target is found)
        } else if(current != null) {

            // set previous's next as current's next, skipping current to remove node
            previous.setNext(current.getNext());
            // decrement list length
            listLength--;
            // return current
            return current;

        // else end of list is reached, target not found
        } else {
            // print error message
            System.out.println("Error: Target does not exist in the list!");
            // return null
            // TODO: throw exception instead
            return null;
        }
    }

    /**
     * This method searches for target in list.
     * Returns index if target found, else returns -1.
     * O(n): Performs between (n + 1) / 2 (successful) and n (unsuccessful) comparisons.
     *
     * @param target E
     * @return int
     */
    public int search(E target) {

        // init index with 0
        int index = 0;

        // if list is empty,
        if(head == null) {
            // return -1, meaning not found
            return -1;

        // else list is not empty,
        } else {

            // set current to head
            current = head;

            // loop while current is not last node
            while(current != null) {

                // if current data matches target
                if(current.getData().equals(target)) {

                    // return index
                    return index;
                }

                // traverse to next node
                current = current.getNext();
                // increment index
                index++;
            }
        }
        return -1;
    }

    /**
     * This method returns the list length.
     *
     * @return listLength int
     */
    public int getListLength() {
        return listLength;
    }

//    /**
//     * TODO: Fix this method
//     * @param index
//     * @return
//     */
//    public E getDataAt(int index) {
//
//        if(index <= 0) {
//            // TODO: Throw exception instead
//            return null;
//        }
//
//        current = head.getNext();
//
//        for(int i = 1; i < index; i++) {
//            if(current.getNext() == null) {
//                return null;
//            }
//            current = current.getNext();
//        }
//        return current.getData();
//    }

//    /**
//     * TODO: Fix this method
//     * @param index
//     * @return
//     */
//    public E getDataAt(int index) {
//
//        if(index <= 0 || index > listLength) {
//            // TODO: Throw exception instead
//            System.out.println("Error: Index must be greater than 0 and <= list length!");
//            return null;
//        }
//
//        current = head.getNext();
//
//        for(int i = 1; i < index; i++) {
//            if(current == null) {
//                return null;
//            }
//            previous = current;
//            current = current.getNext();
//        }
//        return previous.getData();
//    }

    /**
     * This method returns the head pointer.
     *
     * @return head E
     */
    public E getHead() {

        return head.getData();
    }

    /**
     * This method overrides toString,
     * iterates from first node through to last,
     * concatenating each node to a string value.
     *
     * @return String
     */
    @Override
    public String toString() {
        current = head;//.getNext();
        String output = "";

        while(current != null) {
            previous = current;
            output += "[" + previous.getData() + "]";
            current = current.getNext();
        }
        return output;
    }

    /**
     * This method tests if list is empty.
     * O(1): Performs 1 comparison for any length of list.
     *
     * @return boolean
     */
    public boolean isEmpty() {
        return head == null;
    }

    /****************************************
     ** Module 5 algorithm implementations **
     ***************************************/

    /**
     * This method inserts a new node after a specificed target.
     * SEE SLL INSERTION ALGORITHM
     * To insert elem at a given point in the SLL headed by first:
     * O(n): Performs between (n + 1) / 2 (successful) or n (unsuccessful) comparisons
     * to find target before inserting.
     *
     * @param data E
     * @param target E
     */
    public void insertAfter(E data, E target) {

        // 1.0 Make ins a link to the newly-created node with element elem and successor null
        SLLNode<E> insert = new SLLNode<E>(data);

        // ** New step: check if list is empty,
        if(head == null) {
            // print error message
            // TODO: throw exception instead
            System.out.println("Error: The list is empty!");

            // 2.0 If the insertion point is before the first node:
        } else if(target == null) {

            // 2.1 Set node ins's successor to first
            insert.setNext(head);
            head = insert;
            // increment list length
            listLength++;

            // 3.0 If the insertion point is after the node pred:
        } else {

            // set current to head
            current = head;

            // while not at last node AND current data does not match target:
            while(current != null) {

                // if current data matches target,
                if(current.getData().equals(target)) {

                    // 3.1 Set node ins's successor to node pred's successor
                    insert.setNext(current.getNext());
                    // 3.2 Set node pred's successor to ins
                    current.setNext(insert);
                    // increment list length
                    listLength++;

                    // else target not found,
                } else {
                    // print error message
                    // TODO: Throw exception instead
                    System.out.println("Error: Target not found!");
                }
            }
        }
    }

    /**
     * This subclass defines the SLLNode fields and methods.
     * Uses generics so that any type may be stored in this list.
     *
     * @param <E>
     */
    private class SLLNode<E> {

        // data and next fields, generic to store any type
        private E data;
        private SLLNode<E> next;

        /**
         * This is the constructor for SLLNode.
         * Accepts data as argument, assigns next as null.
         *
         * @param data E
         */
        public SLLNode(E data) {
            this.data = data;
            next = null;
        }

        /**
         * This is the overloaded constructor for SLLNode.
         * Accepts data and next as argument.
         *
         * @param data E
         * @param next E
         */
        public SLLNode(E data, SLLNode<E> next) {
            this.data = data;
            this.next = next;
        }

        /**
         * This method returns this SLLNode.
         *
         * @return SLLNode<E>
         */
        public SLLNode<E> getSLLNode() {
            return this;
        }

        /**
         * This method gets data.
         *
         * @return data E
         */
        public E getData() {
            return data;
        }

        /**
         * This method gets next.
         *
         * @return SLLNode<E>
         */
        public SLLNode<E> getNext() {
            return next;
        }

        /**
         * This method sets data.
         *
         * @param data E
         */
        public void setData(E data) {
            this.data = data;
        }

        /**
         * This method sets next.
         *
         * @param next E
         */
        public void setNext(SLLNode<E> next) {
            this.next = next;
        }
    }
}
