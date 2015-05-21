public class SortedLinkedPriorityQueue implements PriorityQueue {

    // Each SortedLinkedPriorityQueue object is a priority queue 
    // whose elements are Comparable objects.

    // Assume that x.compareTo(y) is negative (zero, positive) if x has 
    // higher (equal, lower) priority than y.

    // This priority queue is represented as follows: length is the number of 
    // its elements; first is a link to the first node of a 1WLL containing its 
    // elements.
    private OneWLLNode first;
    private int length;

    //////////// Constructor ////////////

    public SortedLinkedPriorityQueue () {
    // Construct a priority queue, initially empty.
        first = null;
        length = 0;
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


    public Comparable highest () {
    // Return the highest-priority element in this priority queue, or null if
    // this priority queue is empty. (If there are several equal-highest-
    // priority elements, return any one of these elements.)
        if (first == null)  return null;
        return (Comparable) first.element;
    }

    //////////// Transformers ////////////

    public void clear () {
    // Make this priority queue empty.
        first = null;
        length = 0;
    }


    public void add (Comparable elem) {
    // Add elem to this priority queue.
        OneWLLNode pred = null, curr = first;
        while (curr != null && elem.compareTo(curr.element) >= 0) {
            pred = curr;  curr = curr.succ;
        }
        OneWLLNode newNode = new OneWLLNode(elem, curr);
        if (pred == null)
            first = newNode;
        else
            pred.succ = newNode;
        length++;
    }


    public Comparable remove () {
    // Remove and return the highest-priority element in this priority queue, or 
    // return null if this priority queue is empty. (If there are several equal-
    // highest-priority elements, remove and return the same one that would be 
    // returned by highest.)
        if (first == null)  return null;
        Comparable highest = (Comparable) first.element;
        first = first.succ;
        length--;
        return highest;
    }
}
