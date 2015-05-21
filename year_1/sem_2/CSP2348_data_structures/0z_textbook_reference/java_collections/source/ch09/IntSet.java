import java.util.Iterator;

public class IntSet {
    
    // Each IntSet value is a set whose members are small integers.
    
    // This set is represented as follows: b[i] is true if and only if integer i 
    // is a member, and card is the cardinality.
    private boolean[] b;
    private int card;
    
    // Constructor ...
    
    public IntSet (int m) {
    // Construct a set, initially empty, whose members will be integers in the 
    // range 0 through m-1.
        b = new boolean[m];  // … All components are initially false.
        card = 0;
    }
    
    // Accessors ...
    
    public boolean isEmpty () {
    // Return true if and only if this set is empty.
        return (card == 0);
    }

    public int size () {
    // Return the cardinality of this set.
        return card;
    }
    
    public boolean contains (int i) {
    // Return true if and only if i is a member of this set.
        return b[i];
    }
    
    public boolean equals (IntSet that) {
    // Return true if and only if this set is equal to that.
        if (card != that.card)  return false;
        int minLength =
                Math.min(b.length, that.b.length);
        for (int i = 0; i < minLength; i++) {
            if (b[i] != that.b[i])  return false;
        }
        for (int i = minLength; i < b.length; i++) {
            if (b[i])  return false;
        }
        for (int i = minLength; i < that.b.length; i++) {
            if (that.b[i])  return false;
        }
        return true;
    }
    
    public boolean disjoint (IntSet that) {
    // Return true if and only if this set is disjoint from that.
        int minLength =
                Math.min(b.length, that.b.length);
        for (int i = 0; i < minLength; i++) {
            if (b[i] == that.b[i])  return false;
        }
        return true;
    }
    
    public boolean containsAll (IntSet that) {
    // Return true if and only if this set subsumes that.
        if (card < that.card)  return false;
        int minLength =
                Math.min(b.length, that.b.length);
        for (int i = 0; i < minLength; i++) {
            if (!b[i] && that.b[i])  return false;
        }
        for (int i = minLength; i < that.b.length; i++) {
            if (that.b[i])  return false;
        }
        return true;
    }
    
    public Object clone () {
    // Return a copy of this set.
        IntSet other = new IntSet(b.length);
        for (int i = 0; i < b.length; i++)
            other.b[i] = b[i];
        other.card = card;
        return other;
    }
    
    public String toString() {
    // Return a textual representation of this set, using the
    // conventional mathematical notation.
        StringBuffer enum = new StringBuffer();
        if (card > 0) {
            for (int i = 0; i < b.length; i++) {
                if (b[i]) {
                    enum.append(' ');  enum.append(i);
                }
            }
            enum.append(' ');
        }
        return '{' + enum.toString() + '}';
    }
    
    // Transformers ...
    
    public void clear () {
    // Make this set empty.
        for (int i = 0; i < b.length; i++)  b[i] = false;
        card = 0;
    }
    
    public void add (int i) {
    // Add i as a member of this set.
        if (i < 0 || i >= b.length)
            return;  // TEMP  // i is out of range for this set
        if (!b[i]) {
            b[i] = true;
            card++;
        }
    }
    
    public void remove (int i) {
    // Remove x from this set.
        if (i < 0 || i >= b.length)  return;
        if (b[i]) {
            b[i] = false;
            card--;
        }
    }
    
    public void addAll (IntSet that) {
    // Make this set the union of itself and that.
        int minLength =
                Math.min(b.length, that.b.length);
        for (int i = 0; i < minLength; i++) {
            if (!b[i] && that.b[i]) {
                b[i] = true;
                card++;
            }
        }
        for (int i = minLength; i < that.b.length; i++) {
            if (that.b[i])  return;  // TEMP  // i is out of range for this set
        }
    }
    
    public void removeAll (IntSet that) {
    // Make this set the difference of itself and that.
        int minLength =
                Math.min(b.length, that.b.length);
        for (int i = 0; i < minLength; i++) {
            if (b[i] && that.b[i]) {
                b[i] = false;
                card--;
            }
        }
    }
    
    public void retainAll (IntSet that) {
    // Make this set the intersection of itself and that.
        int minLength =
                Math.min(b.length, that.b.length);
        for (int i = 0; i < minLength; i++)
            if (b[i] && !that.b[i]) {
                b[i] = false;
                card--;
            }
    }

    // Iterator ...
    
    public Iterator iterator() {
    // Return an iterator that visits all members of this set, in no particular 
    // order.
        return new IntSetIterator();
    }
    
    private class IntSetIterator implements Iterator {
    
        private int place;
    
        public IntSetIterator () {
            place = 0;
            while (place < b.length && !b[place])
                place++;
        }
    
        public boolean hasNext () {
            return (place < b.length);
        }
    
        public Object next () {
            int nextMember = place;
            place++;
            while (place < b.length && !b[place])
                place++;
            return new Integer(nextMember);

        }
    
        public void remove () {
            throw new UnsupportedOperationException();
        }

    }
}
