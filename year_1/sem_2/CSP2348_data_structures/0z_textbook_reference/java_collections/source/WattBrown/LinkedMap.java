package WattBrown;

public class LinkedMap implements Map {

    // Each LinkedMap object is a map in which the keys are Comparable
    // objects and the values are arbitrary objects.

    // This map is represented as follows: its cardinality is held in card;
    // first is a link to the first node of a SLL containing the entries.
    private LinkedMap.Entry first;
    private int card;

    //////////// Constructor ////////////

    public LinkedMap () {
    // Construct a map, initially empty.
        first = null;
        card = 0;
    }

    //////////// Accessors ////////////

    public int size () {
    // Return this maps size.
	return card;
    }


    public boolean isEmpty () {
    // Return true if and only if this map is empty.
	return (card == 0);
    }


    public boolean equals (Map that) {
	return false;  // TEMPORARY
    }


    public Object get (Object key) {
    // Return the value in the entry with key in this map, or null if there
    // is no such entry.
        Comparable compKey = (Comparable) key;
	for (LinkedMap.Entry curr = first; curr != null; curr = curr.succ) {
	    int comp = compKey.compareTo(curr.key);
	    if (comp == 0)
		return curr.value;
	    else if (comp < 0)
		break;
	}
	return null;
    }


    public Set keySet () {
	Set keys = new ArraySet(card);
	for (LinkedMap.Entry curr = first; curr != null; curr = curr.succ) {
	    keys.add(curr.key);
	}
	return keys;
    }


    public String toString () {
        String temp = "";
        for (LinkedMap.Entry curr = first; curr != null; curr = curr.succ) {
            if (curr != first)  temp += ",";
            temp += "<" + curr.key + "," + curr.value + ">";
        }
        return "{" + temp + "}";
    }

    //////////// Transformers ////////////


    public void clear () {
    // Make this map empty.
	first = null;
	card = 0;
    }


    public Object put (Object key, Object val) {
    	Comparable compKey = (Comparable) key;
	LinkedMap.Entry curr, prev = null;
	for (curr = first; curr != null; curr = curr.succ) {
	    int comp = compKey.compareTo(curr.key);
	    if (comp == 0) {
		Object oldVal = curr.value;
		curr.value = val;
		return oldVal;
	    } else if (comp < 0)
		break;
	    prev = curr;
	}
	LinkedMap.Entry ins = new LinkedMap.Entry(compKey, val, curr);
	if (prev != null)
	    prev.succ = ins;
	else
	    first = ins;
	card++;
	return null;
    }


    public void putAll (Map that) {
	LinkedMap other = (LinkedMap) that;
	this.overlay(other);
    }


    private void overlay (LinkedMap that) {
    // Overlays all entries of that map into this map.
        LinkedMap.Entry prev = null;
        int comp;
        for (LinkedMap.Entry cur1 = this.first, cur2 = that.first;
            cur1 != null || cur2 != null; ) {
            if (cur1 == null)
                comp = +1;
            else if (cur2 == null)
                comp = -1;
            else {
                comp = (cur1.key).compareTo(cur2.key);
            }
            if (comp == 0) {
		cur1.value = cur2.value;
                cur2 = cur2.succ;
            } else if (comp > 0) {
                // Insert cur2.element into this map ...
                LinkedMap.Entry ins =
                        new LinkedMap.Entry(cur2.key, cur2.value, cur1);
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


    public Object remove (Object key) {
    	if (key instanceof Comparable) {
    	    Comparable compKey = (Comparable) key;
	    LinkedMap.Entry curr, prev = null;
	    for (curr = first; curr != null; curr = curr.succ) {
	        int comp = compKey.compareTo(curr.key);
	        if (comp == 0) {
		    if (prev != null)
		        prev.succ = curr.succ;
		    else
		        first = curr.succ;
		    card--;
		    return curr.value;
	        } else if (comp < 0)
		    break;
	        prev = curr;
	    }
	}
	return null;
    }

    //////////// Inner class for map entries ////////////

    private static class Entry implements Map.Entry {

    	// Each ArrayMap.Entry object is a map entry consisting of a key,
    	// which is a Comparable object, a value, which is an arbitrary
    	// object, and a link to the next entry in the SLL.
    	private Comparable key;
    	private Object value;
    	private Entry succ;

    	private Entry (Comparable key, Object value, Entry succ) {
    	    this.key = key;
    	    this.value = value;
    	    this.succ = succ;
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
    }
}
