package WattBrown;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList implements List {

    // Each LinkedList value is an unbounded list whose elements are
    // objects.

    // This list is represented as follows: first and last are links to the
    // first and last nodes of a SLL containing the elements; length is the
    // number of elements.
    protected SLLNode first, last;
    protected int length;

    // Constructor ...

    public LinkedList () {
    // Construct a list, initially empty.
        first = last = null;
        length = 0;
    }

    // Accessors ...

    public boolean isEmpty () {
    // Return true if and only if this list is empty.
        return (first == null);
    }

    public int size () {
    // Return this list's length.
        return length;
    }

    public Object get (int i) {
    // Return the element with index i in this list, or null if there is
    // no such element.
        if (i < 0 || i >= length)
            throw new IndexOutOfBoundsException();
        SLLNode curr = node(i);
        return curr.element;
    }

    public boolean equals (List that) {
    // Return true if and only if this list and that have the same length, and
    // each element of this list equals the corresponding element of that.
        LinkedList other = (LinkedList) that;
        if (length != other.length)
            return false;
        for (SLLNode curr1 = first, curr2 = other.first;
                curr1 != null;
                curr1 = curr1.succ, curr2 = curr2.succ) {
            if (! curr1.element.equals(curr2.element))
                return false;
        }
        return true;
    }

    // Transformers ...

    public void clear () {
    // Make this list empty.
        first = last = null;
        length = 0;
    }

    public void set (int i, Object x) {
    // Replace by x the element at index i in this list.
        if (i < 0 || i >= length)
            throw new IndexOutOfBoundsException();
        SLLNode curr = node(i);
        curr.element = x;
    }

    public void add (int i, Object x) {
    // Add x as the element with index i in this list.
        if (i < 0 || i > length)
            throw new IndexOutOfBoundsException();
        SLLNode newest = new SLLNode(x, null);
        if (i == 0) {
            newest.succ = first;
            first = newest;
        } else {
            SLLNode pred = node(i-1);
            newest.succ = pred.succ;
            pred.succ = newest;
        }
        if (newest.succ == null)
            last = newest;
        length++;
    }

    public void add (Object x) {
    // Add x after the last element of this list.
        SLLNode newest = new SLLNode(x, null);
        if (first == null)
            first = newest;
        else
            last.succ = newest;
        last = newest;
        length++;
    }

    public void addAll (List that) {
    // Add all the elements of that after the last element of this list.
        Iterator iter = that.iterator();
        while (iter.hasNext())
            this.add(iter.next());
    }

    public Object remove (int i) {
    // Remove and return the element with index i in this list, or return null
    // if there is no such element.
        if (i < 0 || i >= length)
            throw new IndexOutOfBoundsException();
        Object oldElem;
        if (i == 0) {
            oldElem = first.element;
            if (first == last)
                last = null;
            first = first.succ;
        } else {
            SLLNode pred = node(i-1);
            SLLNode old = pred.succ;
            oldElem = old.element;
            pred.succ = old.succ;
            if (old == last)
                last = pred;
        }
        length--;
        return oldElem;
    }

    // Iterator ...

    public Iterator iterator () {
    // Return an iterator that visits all elements of this list, in
    // left-to-right order.
        return new LinkedList.LRIterator();
    }

    /////////// Auxiliary method ////////////

    protected SLLNode node (int i) {
    // Return a link to the node containing the element with index i in
    // this list.
        SLLNode curr = first;
        for (int j = 0; j < i; j++)
            curr = curr.succ;
        return curr;
    }

    //////////// Inner class ////////////

    private class LRIterator implements Iterator {

        private SLLNode place, prev, curr;

        private LRIterator () {
            place = first;
            curr = prev = null;
        }

        public boolean hasNext () {
            return (place != null);
        }

        public Object next () {
            if (place == null)
                throw new NoSuchElementException();
            Object nextElem = place.element;
            prev = curr;
            curr = place;
            place = place.succ;
            return nextElem;
        }

        public void remove () {
            if (curr == null)
                throw new NoSuchElementException();
            if (prev == null)
                first = first.succ;
            else
                prev.succ = curr.succ;
            length--;
        }
    }
}
