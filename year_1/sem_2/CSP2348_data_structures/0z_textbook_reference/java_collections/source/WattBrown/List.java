package WattBrown;

import java.util.Iterator;

public interface List {

    // Each List value is a list (sequence) whose elements are objects.

    // Accessors ...

    public boolean isEmpty ();
    // Return true if and only if this list is empty.

    public int size ();
    // Return this list's length.

    public Object get (int i);
    // Return the element with index i in this list,
    // or null if there is no such element.

    public boolean equals (List that);
    // Return true if and only if this list and that list have
    // the same length, and each element of this list equals the
    // corresponding element of that list.

    // Transformers ...

    public void clear ();
    // Make this list empty.

    public void set (int i, Object x);
    // Replace by x the element at index i in this list,
    // or do nothing if there is no such element.

    public void add (int i, Object x);
    // Add x as the element with index i in this list,
    // or do nothing if there can be no such element.

    public void add (Object x);
    // Add x after the last element of this list.

    public void addAll (List that);
    // Add all the elements of that list after the last element
    // of this list.

    public Object remove (int i);
    // Remove and return the element with index i in this list,
    // or return null if there is no such element.

    // Iterator ...

    public Iterator iterator ();
    // Return an iterator that visits all elements of this list,
    // in sequence from first to last.

}
