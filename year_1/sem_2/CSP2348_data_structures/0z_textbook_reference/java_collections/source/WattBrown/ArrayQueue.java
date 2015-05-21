package WattBrown;

import java.util.NoSuchElementException;

public class ArrayQueue implements Queue {

    // Queue values are queues whose elements are objects.

    // A Queue value is represented as follows.
    // length contains the number of elements.
    // If length > 0, the queue's elements are stored in elems[front...rear-1]
    // if rear > front, or elems[front...maxlength-1] and elems[0...rear-1]
    // otherwise.
    Object[] elems;
    int length, front, rear;

    // Constructor ...

    public ArrayQueue (int maxlength) {
        elems = new Object[maxlength];
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
        if (length > 0)
            return elems[front];
        else
            throw new NoSuchElementException();
    }

    // Transformers ...

    public void clear () {
    // Make this queue empty.
        length = 0;
        front = rear = 0;  // arbitrary
    }

    public void addLast (Object x) {
    // Add x as the rear element of this queue.
        elems[rear++] = x;
        if (rear == elems.length)  rear = 0;
        length++;
    }

    public Object removeFirst () {
    // Remove and return the front element from this queue,
    // or return null if this queue is empty.
        if (length > 0) {
            Object frontmost = elems[front];
            elems[front++] = null;
            if (front == elems.length)  front = 0;
            length--;
            return frontmost;
        } else
            throw new NoSuchElementException();
    }
}
