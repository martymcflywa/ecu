package WattBrown;

import java.util.NoSuchElementException;

public class LinkedQueue implements Queue {

    // Queue values are queues whose elements are objects.

    // A Queue value is represented as follows.
    // length contains the number of elements.
    // The elements are stored in the nodes of a SLL, with
    // front and rear as links to the first and last nodes, respectively.
    SLLNode front, rear;
    int length;

    // Constructor ...

    public LinkedQueue () {
        clear();
    }

    // Accessors ...

    public boolean isEmpty () {
    // Return true if and only if this queue is empty.
        return (length == 0);
    }

    public int size () {
    // Return this queue's length.
        return length;
    }

    public Object getFirst () {
    // Return the element at the front of this queue,
    // or null if this queue is empty.
        if (front == null)
            throw new NoSuchElementException();
        return front.element;
    }

    // Transformers ...

    public void clear () {
    // Make this queue empty.
        front = rear = null;
        length = 0;
    }

    public void addLast (Object x) {
    // Add x as the rear element of this queue.
        SLLNode latest = new SLLNode(x, null);
        if (rear != null) {
            rear.succ = latest;
            rear = latest;
        } else
            front = rear = latest;
        length++;
    }

    public Object removeFirst () {
    // Remove and return the front element from this queue,
    // or return null if this queue is empty.
        if (front != null) {
            Object frontmost = front.element;
            front = front.succ;
            if (front == null)  rear = null;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }

}
