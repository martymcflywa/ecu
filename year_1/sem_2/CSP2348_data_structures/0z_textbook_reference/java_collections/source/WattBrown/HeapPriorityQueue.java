package WattBrown;

import java.util.Comparator;
import java.util.NoSuchElementException;

public class HeapPriorityQueue implements PriorityQueue {

    // Each HeapPriorityQueue object is a priority queue whose elements
    // are Comparable objects.

    // Assume that x.compareTo(y) is negative (zero, positive) if x has
    // higher (equal, lower) priority than y.

    // This priority queue is represented as follows: the subarray
    // elems[0...length-1] contains the priority queue's elements, arranged
    // in such a way that elems[(p-1)/2] has higher or equal priority than
    // elems[p] for every p > 0.
    private Comparable[] elems;
    private int length;
    private Comparator comparator;

    //////////// Constructors ////////////

    public HeapPriorityQueue (int maxlen) {
    // Construct a priority queue, initially empty, whose length will be bounded
    // by maxlen.
        this(maxlen, null);
    }


    public HeapPriorityQueue (int maxlen, Comparator comp) {
    // Construct a priority queue, initially empty, whose length will be bounded
    // by maxlen. The elements of the priority queue are sorted according to
    // the comparator, comp. If comp is null, then the natural ordering of
    // the elements is used.
        elems = new Comparable[maxlen];
        length = 0;
        comparator = comp;
    }

    //////////// Accessors ////////////

    public boolean isEmpty () {
    // Return true if and only if this priority queue is empty.
        return (length == 0);
    }


    public int size () {
    // Return this priority queue's length.
        return length;
    }


    public Comparable getLeast () {
    // Return the least element in this priority queue, or null if
    // this priority queue is empty. (If there are several equal-highest-
    // priority elements, return any one of these elements.)
        if (length == 0)
            throw new NoSuchElementException();
        return elems[0];
    }

    //////////// Transformers ////////////

    public void clear () {
    // Make this priority queue empty.
        for (int p = 0; p < length; p++)
            elems[p] = null;
        length = 0;
    }


    public void add (Comparable elem) {
    // Add elem to this priority queue.
        if (length == elems.length)
            expand(); // spill
        int hole = length++;
        for (;;) {
            int parent = (hole-1) / 2;
            if (hole == 0 || compare(elems[parent], elem) <= 0) {
                elems[hole] = elem;
                return;
            } else {
                elems[hole] = elems[parent];
                hole = parent;
            }
        }
    }


    public Comparable removeLeast () {
    // Remove and return the least element in this priority queue, or
    // return null if this priority queue is empty. (If there are several equal-
    // highest-priority elements, remove and return the same one that would be
    // returned by highest.)
        if (length == 0)
            throw new NoSuchElementException();
        int hole = 0;
        Comparable least = elems[0];
        Comparable last = elems[--length];
        for (;;) {
            int left = 2*hole + 1, right = 2*hole + 2;
            int child;
            if (left >= length) {     		// hole has no child
                elems[hole] = last;
                return least;
            } else if (right >= length) 	// hole has a left child only
                child = left;
            else {                    		// hole has two children
                child = (compare(elems[left], elems[right]) <= 0 ?
                        left :
                        right);
            }
            if (compare(last, elems[child]) <= 0) {
                elems[hole] = last;
                return least;
            } else {
                elems[hole] = elems[child];
                hole = child;
            }
        }
    }


    private void expand () {
    // Expand this heap by creating a new array and copying the elements.
        return; // TEMPORARY
    }


    private int compare (Object k1, Object k2) {
	return (comparator==null ? ((Comparable)k1).compareTo(k2)
				 : comparator.compare(k1, k2));
    }

}
