package WattBrown;

public class BSTMap implements Map {

    // Each BSTMap object is a map in which the keys are Comparable
    // objects and the values are arbitrary objects.

    // This map is represented as follows: root is a link to the root node of a
    // BST containing the entries, and card is the cardinality of this map.
    private BSTMap.Entry root;
    private int card;

    //////////// Constructor ////////////

    public BSTMap () {
    // Construct a map, initially empty.
        root = null;
        card = 0;
    }

    //////////// Accessors ////////////

    public boolean isEmpty () {
    // Return true if and only if this map is empty.
	return (card == 0);
    }


    public int size () {
    // Return the cardinality of this map, i.e., the number of entries.
	return card;
    }


    public Object get (Object key) {
    // Return the value in the entry with key in this map, or null if there
    // is no such entry.
	BSTMap.Entry curr = search((Comparable) key);
	if (curr == null)
	    return null;
	else
	    return curr.value;
    }


    public boolean equals (Map that) {
    // Return true if this map is equal to that.
	return false;  // TEMPORARY
    }


    public Object clone () {
        BSTMap copy = new BSTMap();
        copy.root = BSTMap.Entry.cloneSubtree(root);
        copy.card = card;
        return copy;
    }


    public Set keySet () {
    // Return the set of all keys in this map.
	Set keys = new BSTSet();
	Stack track = new LinkedStack();

        if (root != null) {
            track.addLast(root);
	    while (! track.isEmpty()) {
		BSTMap.Entry place = (BSTMap.Entry) track.removeLast();
		if (place.right != null)
		    track.addLast(place.right);
		if (place.left != null)
		    track.addLast(place.left);
		keys.add(place.key);
	    }
	}
	return keys;
    }


    public String toString () {
    // Convert this map to a string using the {<k1,v1>,...,<kn,vn>} notation.
        String temp = "";
        Stack track = new LinkedStack();
        BSTMap.Entry curr = root;
        while (curr != null) {
            track.addLast(curr);
            curr = curr.left;
        }
        while (! track.isEmpty()) {
            BSTMap.Entry place = (BSTMap.Entry) track.removeLast();
            curr = place.right;
            while (curr != null) {
                track.addLast(curr);
                curr = curr.left;
            }
            temp += "<" + place.key + "," + place.value + ">";
            if (! track.isEmpty())  temp += ",";
        }
        return "{" + temp + "}";
    }

    //////////// Transformers ////////////

    public void clear () {
    // Make this map empty.
	root = null;
	card = 0;
    }


    public Object remove (Object key) {
    // Remove the entry with key (if any) from this map. Return the value
    // in that entry, or null if there was no such entry.
        if (key instanceof Comparable) {
            BSTMap.Entry node = search((Comparable) key);
            if (node == null)
	        return null;
	    else {
	        delete((Comparable) key);
	        card--;
	        return node.value;
	    }
	}
	return null;
    }


    public Object put (Object key, Object val) {
    // Add the entry <key, val> to this map, replacing any existing entry with
    // key. Return the value in that entry, or null if there was no such entry.
        Comparable compKey = (Comparable) key;
	BSTMap.Entry node = search(compKey);
	if (node == null) {
	    insert(compKey, val);
	    card++;
	    return null;
	} else {
	    Object oldValue = node.value;
	    node.value = val;
	    return oldValue;
	}
    }


    public void putAll (Map that) {
    // Overlay this map with that, i.e., add all entries of that to this map,
    // replacing any existing entries with the same keys.
        BSTMap other = (BSTMap) that;
	Stack track = new LinkedStack();

        if (other.root != null) {
            track.addLast(other.root);
	    while (! track.isEmpty()) {
		BSTMap.Entry place = (BSTMap.Entry) track.removeLast();
		if (place.right != null)
		    track.addLast(place.right);
		if (place.left != null)
		    track.addLast(place.left);
		this.put(place.key, place.value);
	    }
	}
    }

    //////////// Auxiliary methods ////////////

    private BSTMap.Entry search (Comparable key) {
    // Search this map for an entry which contains key. Return the
    // corresponding node of the BST, or null if no entry has this key.
	int direction = 0; // ... 0 for here, < 0 for left, > 0 for right.
	BSTMap.Entry curr = root;
	for (;;) {
	    if (curr == null)
		return null;
	    direction = key.compareTo(curr.key);
	    if (direction == 0)
		return curr;
	    if (direction < 0)
		curr = curr.left;
	    else // direction > 0
		curr = curr.right;
	}
    }


    private void insert (Comparable key, Object val) {
    // Insert the entry <key, val> in this map.
        int direction = 0;  // ... 0 for here, < 0 for left, > 0 for right
        BSTMap.Entry parent = null, curr = root;
        for (;;) {
            if (curr == null) {
                BSTMap.Entry ins = new BSTMap.Entry(key, val);
                if (curr == root)
                    root = ins;
                else if (direction < 0)
                    parent.left = ins;
                else  // direction > 0
                    parent.right = ins;
                return;
            }
            direction = key.compareTo(curr.key);
            if (direction == 0)
                return;
            parent = curr;
            if (direction < 0)
                curr = curr.left;
            else  // direction > 0
                curr = curr.right;
        }
    }


    private void delete (Comparable key) {
    // Delete the entry with key in this map.
        int direction = 0;  // ... 0 for here, < 0 for left, > 0 for right
        BSTMap.Entry parent = null, curr = root;
        for (;;) {
            if (curr == null)
                return;
            direction = key.compareTo(curr.key);
            if (direction == 0) {
                BSTMap.Entry del = curr.deleteTopmost();
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

    private static class Entry implements Map.Entry {

    	// Each ArrayMap.Entry object is a map entry consisting of a key,
    	// which is a Comparable object, a value, which is an arbitrary
    	// object, and a link to the left and right children.
    	private Comparable key;
    	private Object value;
    	private Entry left, right;

    	private Entry (Comparable key, Object value) {
    	    this.key = key;
    	    this.value = value;
    	    this.left = null;
    	    this.right = null;
    	}

    	public Object getKey () {
    	// Return the key of this entry.
    	    return this.key;
    	}

    	public Object getValue () {
    	// Return the value of this entry.
    	    return this.value;
    	}

    	public void setValue (Object val) {
    	// Update the value of this entry to be val.
    	    this.value = val;
    	}

        private Entry deleteTopmost () {
        // Delete the topmost element in the subtree whose topmost node is this.
        // Return a link to the modified subtree.
            if (left == null)
                return right;
            else if (right == null)
                return left;
            else {  // this node has both a left child and a right child
                Entry other = right.getLeftmost();
                this.key = other.key;
                this.value = other.value;
                right = right.deleteLeftmost();
                return this;
            }
        }

        private Entry deleteLeftmost () {
        // Delete the leftmost node of the (nonempty) subtree
        // whose topmost node is this.
        // Return a link to the modified subtree.
            Entry parent = null, curr = this;
            while (curr.left != null) {
                parent = curr;  curr = curr.left;
            }
            if (curr == this)
                return this.right;
            else {
                parent.left = curr.right;
                return this;
            }
        }

        private Entry getLeftmost () {
        // Return the key of the entry in the leftmost node of the (nonempty)
        // subtree whose topmost node is this.
            Entry curr = this;
            while (curr.left != null)
                curr = curr.left;
            return curr;
        }

        private static int sizeOfSubtree (Entry top) {
            if (top == null)
                return 0;
            else
                return 1 + sizeOfSubtree(top.left) + sizeOfSubtree(top.right);
        }

        private static Entry cloneSubtree (Entry top) {
            if (top == null)
                return null;
            else {
                Entry copy = new Entry(top.key, top.value);
                copy.left  = cloneSubtree(top.left);
                copy.right = cloneSubtree(top.right);
                return copy;
            }
        }
    }
}
