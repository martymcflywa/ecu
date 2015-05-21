package WattBrown;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArraySet implements Set {

    // This set is represented as follows:
    // its members occupy members[0...card-1].
    private Comparable [] members;
    private int card;


    public ArraySet (int maxcard) {
        members = new Comparable[maxcard];
        card = 0;
    }


    public boolean isEmpty () {
        return (card == 0);
    }


    public int size () {
        return card;
    }


    public boolean contains (Object obj) {
    	if (obj instanceof Comparable) {
    	    Comparable it = (Comparable) obj;
            int left = 0, right = card-1;
            while (left <= right) {
                int mid = (left + right)/2;
                int comp = it.compareTo(members[mid]);
                if (comp < 0)
                    right = mid - 1;
                else if (comp > 0)
                    left = mid + 1;
                else  // if (comp == 0)
                    return true;
            }
        }
        return false;
    }


    public boolean equals (Set that) {
        ArraySet other = (ArraySet) that;
        if (card != other.card)
            return false;
        for (int i = 0; i < card; i++) {
            if (! members[i].equals(other.members[i]))
                return false;
        }
        return true;
    }


    public boolean disjoint (Set that) {
        ArraySet other = (ArraySet)that;
        int i = 0, j = 0;
        while (i < card && j < other.card) {
            int comp = members[i].compareTo(other.members[j]);
            if (comp < 0)
                i++;
            else if (comp > 0)
                j++;
            else  // if (comp == 0)
                return false;
            }
        return true;
    }


    public boolean containsAll (Set that) {
        ArraySet other = (ArraySet)that;
        if (card < other.card)
            return false;
        int i = 0, j = 0;
        while (i < card && j < other.card) {
            int comp = members[i].compareTo(other.members[j]);
            if (comp < 0)
                i++;
            else if (comp > 0)
                return false;
            else {  // if (comp == 0)
                i++;  j++;
            }
        }
        return (j == other.card);
    }


    public Object clone () {
        ArraySet that = new ArraySet(members.length);
        that.card = card;
        System.arraycopy(members, 0,
                that.members, 0, members.length);
        return that;
    }


    public String toString() {
        String str = "{";
        for (int i = 0; i < card; i++) {
            if (i > 0)  str += ",";
            str += members[i].toString();
        }
        str += "}";
        return str;
    }


    public void clear () {
        for (int i = 0; i < card; i++)
            members[i] = null;
        card = 0;
    }


    public void add (Object obj) {
    	Comparable it = (Comparable) obj;
        int left = 0, right = card-1;
        while (left <= right) {
            int mid = (left + right)/2;
            int comp = it.compareTo(members[mid]);
            if (comp < 0)
                right = mid - 1;
            else if (comp > 0)
                left = mid + 1;
            else  // if (comp == 0)
                return;
        }
        if (card == members.length)  return;  // TEMP
        // Insert x in members[left] ...
        for (int i = card-1; i >= left; i--)
            members[i+1] = members[i];
        members[left] = it;
        card++;
    }


    public void remove (Object obj) {
    	if (obj instanceof Comparable) {
    	    Comparable it = (Comparable) obj;
            int left = 0, right = card-1;
            while (left <= right) {
                int mid = (left + right)/2;
                int comp = it.compareTo(members[mid]);
                if (comp < 0)
                    right = mid - 1;
                else if (comp > 0)
                    left = mid + 1;
                else {  // if (comp == 0)
                    // Delete x from members[mid] ...
                    for (int i = mid+1; i < card; i++)
                        members[i-1] = members[i];
                    card--;
                    return;
                }
            }
        }
    }


    public void addAll (Set that) {
        ArraySet other = (ArraySet)that;

	// Count the number of disjoint elements in this set and that set.
	int i = 0, j = 0, k = 0;
	while (i < card && j < other.card) {
	    int comp = members[i].compareTo(other.members[j]);
	    if (comp < 0) {
		k++;  i++;
	    } else if (comp > 0) {
		k++;  j++;
	    } else {
		i++;  j++;
	    }
	}
	while (i < card) {
	    k++;  i++;
	}
	while (j < other.card) {
	    k++;  j++;
	}

	// Create a new array at least as large as this set.
        Comparable[] a = new Comparable[Math.max(k, members.length)];
        i = 0;  j = 0;  k = 0;
        while (i < card && j < other.card) {
            int comp = members[i].compareTo(other.members[j]);
            if (comp < 0)
                a[k++] = members[i++];
            else if (comp > 0)
                a[k++] = other.members[j++];
            else {  // if (comp == 0)
                a[k++] = members[i++];  j++;
            }
        }
        while (i < card)
            a[k++] = members[i++];
        while (j < other.card)
            a[k++] = other.members[j++];
        members = a;  card = k;
    }


    public void removeAll (Set that) {
        ArraySet other = (ArraySet)that;
        Comparable[] a = new Comparable[members.length];
        int i = 0, j = 0, k = 0;
        while (i < card && j < other.card) {
            int comp = members[i].compareTo(other.members[j]);
            if (comp < 0)
                a[k++] = members[i++];
            else if (comp > 0)
                j++;
            else {  // if (comp == 0)
                i++;  j++;
            }
        }
        while (i < card)
            a[k++] = members[i++];
        members = a;  card = k;
    }


    public void retainAll (Set that) {
        ArraySet other = (ArraySet)that;
        Comparable[] a = new Comparable[members.length];
        int i = 0, j = 0, k = 0;
        while (i < card && j < other.card) {
            int comp = members[i].compareTo(other.members[j]);
            if (comp < 0)
                i++;
            else if (comp > 0)
                j++;
            else {   // if (comp == 0)
                a[k++] = members[i++];  j++;
            }
        }
        members = a;  card = k;
    }


    public Iterator iterator () {
    // Return an iterator that visits all members, in no particular order.
        return new ArraySet.LRIterator();
    }

    //////////// Inner class ////////////

    private class LRIterator implements Iterator {

        private int place;

        private LRIterator () {
            place = 0;
        }

        public boolean hasNext () {
            return (place < card);
        }

        public Object next () {
            if (place >= card)
                return new NoSuchElementException();
            return members[place++];
        }

        public void remove () {
            throw new UnsupportedOperationException();
        }

    }

}
