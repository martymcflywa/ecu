package WattBrown;

public interface PriorityQueue {

    // Each PriorityQueue object is a priority queue whose elements are
    // Comparable objects.

    // Assume that x.compareTo(y) is negative (zero, positive) if x has
    // higher (equal, lower) priority than y.

    //////////// Accessors ////////////

    public boolean isEmpty ();
    // Return true if and only if this priority queue is empty.

    public int size ();
    // Return this priority queue's length.

    public Comparable getLeast ();
    // Return the highest-priority element in this priority queue, or throw
    // a NoSuchElementException if this queue is empty.
    // (If there are several equal-priority least elements, return any one of
    // these elements.)

    //////////// Transformers ////////////

    public void clear ();
    // Make this priority queue empty.

    public void add (Comparable elem);
    // Add elem to this priority queue.

    public Comparable removeLeast ();
    // Remove and return the highest-priority element in this priority queue, or
    // throw a NoSuchElementException if this priority queue is empty. (If there
    // are several equal-priority least elements, remove and return the same
    // element that would be returned by getLeast.)

}
