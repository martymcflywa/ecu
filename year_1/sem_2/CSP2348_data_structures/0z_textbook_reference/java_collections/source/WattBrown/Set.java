package WattBrown;

import java.util.Iterator;

public interface Set {

    // An object of class Set represents a set, i.e., a collection
    // of distinct members whose order is insignificant.
    // Each set member must belong to a class set implements the
    // Comparable interface.

    // Accessors ...

    public boolean isEmpty ();
    // Return true if and only if this set is empty.

    public int size ();
    // Return the cardinality of this set.

    public boolean contains (Object x);
    // Return true if and only if x is a member of this set.

    public boolean equals (Set that);
    // Return true if and only if this set is equal to that.

    public boolean containsAll (Set that);
    // Return true if and only if this set subsumes that.

    public Object clone ();
    // Return a copy of this set.

    public String toString();
    // Return a textual representation of this set, using the
    // conventional mathematical notation.

    // Transformers ...

    public void clear ();
    // Make this set empty.

    public void add (Object x);
    // Add x as a member of this set.

    public void remove (Object x);
    // Remove x from this set.

    public void addAll (Set that);
    // Make this set the union of itself and that.

    public void removeAll (Set that);
    // Make this set the difference of itself and that.

    public void retainAll (Set that);
    // Make this set the intersection itself and that.

    // Iterator ...

    public Iterator iterator ();
    // Return an iterator that visits all members, in no particular order.
}
