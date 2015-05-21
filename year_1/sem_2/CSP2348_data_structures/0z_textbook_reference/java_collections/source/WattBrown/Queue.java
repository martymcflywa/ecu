package WattBrown;

public interface Queue {

    // Queue values are queues whose elements are objects.

    // Accessors ...

    public boolean isEmpty ();
    // Return true if and only if this queue is empty.

    public int size ();
    // Return this queue's length.

    public Object getFirst ();
    // Return the element at the front of this queue,
    // or null if this queue is empty.

    // Transformers ...

    public void clear ();
    // Make this queue empty.

    public void addLast (Object x);
    // Add x as the rear element of this queue.

    public Object removeFirst ();
    // Remove and return the front element from this queue,
    // or return null if this queue is empty.

}
