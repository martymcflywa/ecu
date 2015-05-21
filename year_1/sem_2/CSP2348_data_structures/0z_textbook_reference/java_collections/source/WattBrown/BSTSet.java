package WattBrown;

import java.util.Iterator;

public class BSTSet implements Set {

    // An object of class BSTSet represents an unbounded set.
    // Each set member must belong to a class that implements the
    // Comparable interface.

    // This set is represented simply by a reference to the root node
    // of a binary search tree, root.
    protected BSTNode root;

    //////////// Constructor ////////////

    public BSTSet () {
    // Construct an empty set.
        root = null;
    }

    //////////// Accessors ////////////

    public boolean isEmpty () {
    // Return true if and only if this set is empty.
        return (root == null);
    }

    public int size () {
    // Return the cardinality of this set.
        return BSTNode.sizeOfSubtree(root);
    }

    public boolean contains (Object x) {
    // Return true if and only if x is a member of this set.
        if (x instanceof Comparable)
            return (search((Comparable) x) != null);
        else
            return false;
    }

    public boolean equals (Set that) {
    // Return true if and only if this set is equal to that.
        BSTSet other = (BSTSet) that;
        return (this.size() == other.size() && this.containsAll(other));
    }

    public boolean disjoint (Set that) {
    // Return true if and only if this set is disjoint from that.
        BSTSet other = (BSTSet) that;
        Iterator iter = other.preOrderIterator();
        while (iter.hasNext()) {
            Comparable x = (Comparable) iter.next();
            if (this.contains(x))  return false;
        }
        return true;
    }

    public boolean containsAll (Set that) {
    // Return true if and only if this set subsumes that.
        BSTSet other = (BSTSet) that;
        Iterator iter = other.preOrderIterator();
        while (iter.hasNext()) {
            Comparable x = (Comparable) iter.next();
            if (! this.contains(x))  return false;
        }
        return true;
    }

    public Object clone () {
    // Return a copy of this set.
        BSTSet copy = new BSTSet();
        copy.root = BSTNode.cloneSubtree(this.root);
        return copy;
    }

    public String toString () {
    // Return a textual representation of this set, using the
    // conventional mathematical notation.
        String image = "";
        boolean empty = true;
        Iterator iter = iterator();
        while (iter.hasNext()) {
            Comparable x = (Comparable) iter.next();
            if (! empty)  image += ", ";
            image += x.toString();
            empty = false;
        }
        return "{" + image + "}";
    }

    //////////// Transformers ////////////

    public void clear () {
    // Make this set empty.
        root = null;
    }

    public void add (Object x) {
    // Add x as a member of this set.
        insert((Comparable) x);
    }

    public void remove (Object x) {
    // Remove x from this set.
        if (x instanceof Comparable)
            delete((Comparable) x);
    }

    public void addAll (Set that) {
    // Make this set the union of itself and that.
    	BSTSet other = (BSTSet) that;
        Iterator iter = other.preOrderIterator();
        while (iter.hasNext())
            this.insert((Comparable) iter.next());
    }

    public void removeAll (Set that) {
    // Make this set the difference of itself and that.
        BSTSet other = (BSTSet) that;
        Iterator iter = other.preOrderIterator();
        while (iter.hasNext()) {
            Comparable x = (Comparable) iter.next();
            this.delete(x);
        }
    }

    public void retainAll (Set that) {
    // Make this set the intersection itself and that.
        BSTSet result = new BSTSet();
        BSTSet other = (BSTSet) that;
        Iterator iter = other.preOrderIterator();
        while (iter.hasNext()) {
            Comparable x = (Comparable) iter.next();
            if (this.contains(x))
                result.insert(x);
        }
        this.root = result.root;
    }

    //////////// Iterators ////////////

    public Iterator preOrderIterator () {
    // Return an iterator that visits all members, in pre-order.
        return new BSTSet.PreOrderIterator();
    }

    public Iterator iterator () {
    // Return an iterator that visits all members, in ascending order.
        return new BSTSet.InOrderIterator();
    }

    //////////// Auxiliary methods ////////////

    private BSTNode search (Comparable target) {
    // Find which if any node of this BST contains an element equal to target.
    // Return a link to that node (or null if there is none).
        int direction = 0;  // ... 0 for here, < 0 for left, > 0 for right
        BSTNode curr = root;
        for (;;) {
            if (curr == null)
                return null;
            direction = target.compareTo(curr.element);
            if (direction == 0)
                return curr;
            if (direction < 0)
                curr = curr.left;
            else  // direction > 0
                curr = curr.right;
        }
    }

    private void insert (Comparable elem) {
    // Insert the element elem in this BST.
        int direction = 0;  // ... 0 for here, < 0 for left, > 0 for right
        BSTNode parent = null, curr = root;
        for (;;) {
            if (curr == null) {
                BSTNode ins = new BSTNode(elem);
                if (curr == root)
                    root = ins;
                else if (direction < 0)
                    parent.left = ins;
                else  // direction > 0
                    parent.right = ins;
                return;
            }
            direction = elem.compareTo(curr.element);
            if (direction == 0)
                return;
            parent = curr;
            if (direction < 0)
                curr = curr.left;
            else  // direction > 0
                curr = curr.right;
        }
    }

    private void delete (Comparable elem) {
    // Delete the element elem in this BST.
        int direction = 0;  // ... 0 for here, < 0 for left, > 0 for right
        BSTNode parent = null, curr = root;
        for (;;) {
            if (curr == null)
                return;
            direction = elem.compareTo(curr.element);
            if (direction == 0) {
                BSTNode del = curr.deleteTopmost();
                if (curr == root)
                    root = del;
                else if (curr == parent.left)
                    parent.left = del;
                else  // curr == parent.right
                    parent.right = del;
                return;
            }
            parent = curr;
            if (direction < 0)
                curr = parent.left;
            else  // direction > 0
                curr = parent.right;
        }
    }

    //////////// Inner classes ////////////

    private class InOrderIterator implements Iterator {

        private Stack track;  // sequence of nodes not yet visited

        private InOrderIterator () {
            track = new LinkedStack();
            for (BSTNode curr = root; curr != null; curr = curr.left)
                track.addLast(curr);
        }

        public boolean hasNext () {
            return (! track.isEmpty());
        }

        public Object next () {
            BSTNode place = (BSTNode) track.removeLast();
            for (BSTNode curr = place.right; curr != null; curr = curr.left)
                track.addLast(curr);
            return place.element;
        }

        public void remove () {
            throw new UnsupportedOperationException();
        }
    }

    //////////////////////////////////////////////////////////////////////////

    private class PreOrderIterator implements Iterator {

        private Stack track;  // sequence of nonempty subtrees still to be visited

        private PreOrderIterator () {
            track = new LinkedStack();
            if (root != null)
                track.addLast(root);
        }

        public boolean hasNext () {
            return (! track.isEmpty());
        }

        public Object next () {
            BSTNode place = (BSTNode) track.removeLast();
            if (place.right != null)
                track.addLast(place.right);
            if (place.left != null)
                track.addLast(place.left);
            return place.element;
        }

        public void remove () {
            throw new UnsupportedOperationException();
        }
    }
}
