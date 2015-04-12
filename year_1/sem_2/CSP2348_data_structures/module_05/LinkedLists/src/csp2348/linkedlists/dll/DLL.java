package csp2348.linkedlists.dll;

/**
 * TODO: Define DLL class and DLLNode subclass here.
 *
 * @author Martin Ponce, StudentID 10371381
 */
public class DLL<E> {

    // always point to first node
    private DLLNode<E> head;
    // always point to last node
    private DLLNode<E> tail;

    // used for traversal
    private DLLNode<E> current;

    // might as well store list length too
    private int listLength;

    /**
     * DLL default constructor.
     * Sets head and tail to null, list length = 0.
     */
    public DLL() {
        head = null;
        tail = null;
        listLength = 0;
    }

    /**
     * This method inserts a new node as first node.
     * O(1): Performs 1 comparison for any length of list.
     *
     * @param data E
     */
    public void insertFirst(E data) {

        // create new node with arg data as its data
        DLLNode<E> insert = new DLLNode<E>(data);

        // if head is null, meaning list is empty,
        if(head == null) {

            // set head to insert
            head = insert;
            // set tail to insert
            tail = insert;

            // else list is not empty,
        } else {

            // set insert's next as head,
            insert.setNext(head);
            // set head's previous as insert
            head.setPrevious(insert);
            // set head to insert
            head = insert;
        }
        // increment list length
        listLength++;
    }

    /**
     * This method inserts a new node as last node.
     * O(1): Performs 1 comparison, since tail is already known.
     * No traversals necessary.
     *
     * @param data E
     */
    public void insertLast(E data) {

        DLLNode<E> insert = new DLLNode<E>(data);

        // if list is empty,
        if(tail == null) {
            head = insert;
            tail = insert;

            // else list is not empty,
        } else {

            // set insert's previous to tail
            insert.setPrevious(tail);
            // set tail's next to insert
            tail.setNext(insert);
            // set tail to insert
            tail = insert;
        }
        // increment list length
        listLength++;
    }

    /**
     * This method deletes first node, and returns the deleted node.
     * If list is empty, return null. See TODO.
     * O(1): Performs 1 comparison for any length of list.
     *
     * @return remove E
     */
    public E deleteFirst() {

        DLLNode<E> remove = head;

        // if list is not empty,
        if(head != null) {

            // if only one node in list,
            if(head.getNext() == null) {
                // remove last and only node
                head = null;
                tail = null;
                // print warning
                System.out.println("Warning: Last node deleted!");
                // decrement list length
                listLength--;

                // else more than one node in list,
            } else {
                // remove first node
                head = head.getNext();
                // decrement list length
                listLength--;
            }

            // else list already empty
        } else {
            // TODO: Throw exception instead
            System.out.println("Error: List already empty!");
            return null;
        }
        // return removed node
        return remove.getData();
    }

//    /**
//     * This method deletes last node, and returns the deleted node.
//     * If list is empty, return null. See TODO.
//     * O(1): Performs 1 comparison for any length of list.
//     * No traversals required, since tail is already known.
//     *
//     * TODO: NEEDS WORK!
//     * @return remove E
//     */
//    public E deleteLast() {
//
//        DLLNode<E> remove = tail;
//
//        // if list is not empty
//        if(tail != null) {
//
//            // if only one node in list
//            if(tail.getPrevious() == head) {
//                // remove last and only node
//                head = null;
//                tail = null;
//                // print warning
//                System.out.println("Warning: Last node deleted!");
//
//                // else list contains more than one node,
//            } else {
//
//                // set tail to tail's previous
//                tail = remove.getPrevious();
//                tail.getData();
//
//            }
//            // decrement list length
//            listLength--;
//
//            // else list already empty
//        } else {
//            // TODO: Throw exception instead
//            System.out.println("Error: List already empty!");
//            return null;
//        }
//        // return removed node
//        return remove.getData();
//    }

    /**
     * This method deletes last node, and returns the deleted node.
     * If list is empty, return null. See TODO.
     * O(1): Performs 1 comparison for any length of list.
     * No traversals required, since tail is already known.
     *
     * TODO: NEEDS WORK!
     * @return remove E
     */
    public E deleteLast() {

        E remove = tail.getData();

        DLLNode<E> penult = tail.getPrevious();

        penult.setNext(null);
        tail = penult;

        return remove;

    }

    /**
     * TODO: Needs work.
     *
     * @return
     */
    public String printLastToFirst() {
        String output = "";
        for(DLLNode curr = this.tail; curr != null; curr.getPrevious()) {
            output += "[" + curr.getData() + "]";
        }
        return output;
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
        DLLNode<E> curr = head;
        String output = "";

        while(curr != null) {
            DLLNode<E> prev = curr;
            output += "[" + prev.getData() + "]";
            curr = curr.getNext();
        }
        return output;
    }

    /**
     * This method gets the list length.
     *
     * @return listLength int
     */
    public int getListLength() {
        return this.listLength;
    }

    /**
     * This method returns the head pointer.
     *
     * @return head E
     */
    public E getHead() {

        return head.getData();
    }

    /**
     * This method returns the tail pointer.
     *
     * @return head E
     */
    public E getTail() {

        return tail.getData();
    }


    /**
     * This subclass defines the DLLNode fields and methods.
     * Uses generics so that any type may be stored in this list.
     *
     * @param <E>
     */
    protected class DLLNode<E> {

        private E data;
        private DLLNode<E> next;
        private DLLNode<E> previous;

        /**
         * DLLNode constructor.
         * Accepts data, next and previous as args.
         *
         * @param data E
         * @param next DLLNode<E>
         * @param previous DLLNode<E>
         */
        public DLLNode(E data, DLLNode<E> next, DLLNode<E> previous) {
            this.data = data;
            this.next = next;
            this.previous = previous;
        }

        /**
         * DLLNode constructor.
         * Accepts data as arg, sets next and previous as null.
         *
         * @param data E
         */
        public DLLNode(E data) {
            this.data = data;
            next = null;
            previous = null;
        }

        /**
         * This method returns this DLLNode.
         *
         * @return DLLNode<E>
         */
        public DLLNode<E> getNode() {
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
         * @return DLLNode<E>
         */
        public DLLNode<E> getNext() {
            return next;
        }

        /**
         * This method gets previous.
         *
         * @return DLLNode<E>
         */
        public DLLNode<E> getPrevious() {
            return previous;
        }

        /**
         * This method sets next.
         *
         * @param next DLLNode<E>
         */
        public void setNext(DLLNode<E> next) {
            this.next = next;
        }

        /**
         * This method sets previous.
         *
         * @param previous DLLNode<E>
         */
        public void setPrevious(DLLNode<E> previous) {
            this.previous = next;
        }
    }
}
