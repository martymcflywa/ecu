package WattBrown;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedSet implements Set {

    // Each LinkedSet value is an unbounded set whose elements are
    // comparable objects.


    // This set is represented as follows: first is a link to the
    // first node of a SLL containing the elements; card is the
    // number of elements.
    protected SLLNode first;
    protected int card;


    public LinkedSet () {
    // Construct a set, initially empty.
	clear();
    }

    // Accessors ...

    public boolean isEmpty () {
    // Return true if and only if this set is empty.
        return (card == 0);
    }


    public int size () {
    // Return this set's cardinality.
        return card;
    }


    public boolean contains (Object obj) {
    	if (obj instanceof Comparable)
            return (search((Comparable) obj) != null);
        else
            return false;
    }

    // Transformers ...

    public void clear () {
    // Make this set empty.
        first = null;
	card = 0;
    }


    public void add (Object obj) {
        insert((Comparable) obj);
    }


    public void remove (Object obj) {
    	if (obj instanceof Comparable)
            delete((Comparable) obj);
    }


    public boolean equals (Set that) {
        LinkedSet other = (LinkedSet)that;
	if (this.card != other.card)  return false;

        SLLNode cur1, cur2;
        for (cur1 = this.first, cur2 = other.first;
            cur1 != null && cur2 != null;
            cur1 = cur1.succ, cur2 = cur2.succ) {
            int comp = ((Comparable) cur1.element).compareTo(
		    (Comparable) cur2.element);
            if (comp != 0)
                return false;
        }
        return (cur1 == null) && (cur2 == null);
    }


    public boolean containsAll (Set that) {
        LinkedSet other = (LinkedSet)that;
        return this.compare(other, true);
    }


    public void addAll (Set that) {
        LinkedSet other = (LinkedSet)that;
        this.merge(other);
    }


    public void removeAll (Set that) {
        LinkedSet other = (LinkedSet)that;
        this.demerge(other, true);
    }


    public void retainAll (Set that) {
        LinkedSet other = (LinkedSet)that;
        this.demerge(other, false);
    }


    public Object clone () {
        LinkedSet that = new LinkedSet();
        SLLNode thatCurrent = null;
        for (SLLNode thisCurrent = this.first;
            thisCurrent != null; thisCurrent = thisCurrent.succ) {
            SLLNode ins = new SLLNode(thisCurrent.element, null);
            if (thatCurrent == null)
                that.first = ins;
            else
                thatCurrent.succ = ins;
            thatCurrent = ins;
        }
	that.card = this.card;
        return that;
    }


    public String toString () {
        String s = "";
        for (SLLNode current = first;
                current != null; current = current.succ) {
            s += current.element.toString();
            if (current.succ != null)
                s += ", ";
        }
        return "{" + s + "}";
    }


    public Iterator iterator () {
        return new LinkedSet.SetIterator(this);
    }


    private void insert (Comparable newElement) {
	// Inserts newElement into this set.
	SLLNode current;
	SLLNode previous = null;
	for (current = first; current != null; current = current.succ) {
	    int comp = newElement.compareTo((Comparable) current.element);
	    if (comp == 0)
                return;
	    else if (comp < 0)
		break;
	    previous = current;
	}
	SLLNode ins = new SLLNode(newElement, current);
	if (previous != null)
	    previous.succ = ins;
	else
	    first = ins;
	card++;
    }


    public void delete (Comparable oldElement) {
	// Deletes all occurrences of oldElement (if present) from this set.
	SLLNode current;
	SLLNode previous = null;
	for (current = first; current != null; current = current.succ) {
	    int comp = oldElement.compareTo((Comparable) current.element);
	    if (comp == 0) {
                if (previous != null)
		    previous.succ = current.succ;
		else
		    first = current.succ;
		card--;
	    } else if (comp < 0)
	        break;
	    previous = current;
	}
    }


    public void merge (LinkedSet that) {
    // Inserts all elements of that set into this set.
	SLLNode prev = null;
        int comp;
        for (SLLNode cur1 = this.first, cur2 = that.first;
            cur1 != null || cur2 != null; ) {
                // Compare the current elements of the sets,
                // and make nextElement the lesser of these elements
                // (or the only one if one set is exhausted) ...
            if (cur1 == null)
                comp = +1;
            else if (cur2 == null)
                comp = -1;
            else
                comp = ((Comparable) cur1.element).compareTo(
			(Comparable) cur2.element);
            if (comp == 0) {
                cur2 = cur2.succ;
            } else if (comp > 0) {
                // Insert cur2.element into this set ...
                SLLNode ins = new SLLNode(cur2.element, cur1);
                if (prev == null)
                    this.first = ins;
                else
                    prev.succ = ins;
                cur2 = cur2.succ;
            }
	    prev = cur1;
	    cur1 = cur1.succ;
        }
    }


    private void demerge (LinkedSet that, boolean expected) {
    // Deletes from this set those elements that are present (absent) in
    // that set, provided that expected is true (false).
        SLLNode result = null;
        for (SLLNode current = this.first;
            current != null; current = current.succ) {
            boolean common = that.search((Comparable) current.element) != null;
            if (common == expected)
                this.delete((Comparable) current.element);
        }
        // ... A more efficient algorithm would be to scan both
        // sets in tandem.
    }


    private SLLNode search (Comparable element) {
    // Returns the node containing the given element in the given set.
    // Returns null if there is no such node.
        for (SLLNode current = first;
            current != null; current = current.succ) {
            int comp = element.compareTo((Comparable) current.element);
            if (comp == 0)
                return current;
            else if (comp < 0)
                break;
        }
        return null;
    }


    private boolean compare (LinkedSet that, boolean expected) {
    // Returns true iff this set contains only elements present (absent) in
    // that set, provided that expected is true (false).
        for (SLLNode current = this.first;
            current != null; current = current.succ) {
            SLLNode matchNode = that.search((Comparable) current.element);
            if ((matchNode == null) == expected)
                return false;
        }
        return true;
        // ... A more efficient algorithm would be to scan both
        // lists in tandem.
    }

    //////////// Inner class ////////////

    private static class SetIterator implements Iterator {

        //    private LinkedSet baseSet;
        private SLLNode place;

        private SetIterator (LinkedSet set) {
            //        baseSet = set;
            place = set.first;
        }

        public boolean hasNext () {
            return (place != null);
        }

        public Object next () {
            Object nextElem = place.element;
            place = place.succ;
            return nextElem;
        }

        public void remove () {
            throw new UnsupportedOperationException();
        }

    }

}
