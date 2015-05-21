package WattBrown;

import java.util.Iterator;

public class ArrayMap implements Map {

    // Each ArrayMap object is a bounded map in which the keys are
    // Comparable objects and the values are arbitrary objects.

    // This map is represented as follows: its cardinality is held in card;
    // its entries (which are sorted by key) occupy the subarray entries
    // [0...card-1].
    private ArrayMap.Entry[] entries;
    private int card;

    //////////// Constructor ////////////

    public ArrayMap (int maxcard) {
    // Construct a map, initially empty, whose cardinality will be bounded by
    // maxcard.
        entries = new ArrayMap.Entry[maxcard];
        card = 0;
    }

    //////////// Accessors ////////////

    public int size () {
    // Return this map's size.
	return card;
    }


    public boolean equals (Map that) {
    // Return true if and only if this map equals that map.
	return false;
    }


    public boolean isEmpty () {
    // Return true if and only if this map is empty.
	return (card == 0);
    }


    public Object get (Object key) {
    // Return the value in the entry with key in this map, or null if there
    // is no such entry.
    	int pos = search((Comparable) key);
        if (key.equals(entries[pos].key))
            return entries[pos].value;
        else
            return null;
    }


    public Set keySet () {
	Set keys = new ArraySet(card);
	for (int i = 0; i < card; i++)
	    keys.add(entries[i].key);
	return keys;
    }


    public String toString () {
        String temp = "";
        for (int i = 0; i < card; i++) {
            if (i > 0)  temp += ",";
            temp += "<" + entries[i].key + "," + entries[i].value + ">";
        }
        return "{" + temp + "}";
    }

    //////////// Transformers ////////////

    public void clear () {
    // Make this map empty.
	for (int i = 0; i < card; i++)
	    entries[i] = null;
	card = 0;
    }


    public Object remove (Object key) {
    // Remove the entry with key (if any) from this map. Return the value
    // in that entry, or null if there was no such entry.
        if (key instanceof Comparable) {
            int pos = search((Comparable) key);
            if (key.equals(entries[pos].key)) {
                Object oldVal = entries[pos].value;
                for (int i = pos + 1; i < card; i++)
                    entries[i-1] = entries[i];
                entries[card] = null;
                card--;
                return oldVal;
            }
        }
        return null;
    }


    public Object put (Object key, Object val) {
    // Add the entry <key, val> to this map, replacing any existing entry with
    // key. Return the value in that entry, or null if there was no such entry.
        Comparable compKey = (Comparable) key;
        ArrayMap.Entry newEntry = new ArrayMap.Entry(compKey, val);
        int pos = search(compKey);
        if (compKey.equals(entries[pos].key)) {
            Object oldVal = entries[pos].value;
            entries[pos] = newEntry;
            return oldVal;
        } else {
            // No entry matches key. Insert newEntry at position pos …
            if (card == entries.length)  expand();
            for (int i = card; i > pos; i--)
                entries[i] = entries[i-1];
            entries[pos] = newEntry;
            card++;
            return null;
        }
    }


    public void putAll (Map that) {
	ArrayMap other = (ArrayMap) that;
	this.overlay(other);
    }


    private void overlay (ArrayMap that) {
    // Overlay this map with that map.
	// Count the number of disjoint keys in this map and that map.
	int i = 0, j = 0, k = 0;
	while (i < card && j < that.card) {
	    int comp = entries[i].key.compareTo(that.entries[j].key);
	    if (comp < 0) {
		k++;  i++;
	    } else if (comp > 0) {
		k++;  j++;
	    } else {
		i++; j++;
	    }
	}
	while (i < card) {
	    k++; i++;
	}
	while (j < that.card) {
	    k++; j++;
	}

	// Create a new array of map entries at least as large as this map.
        ArrayMap.Entry[] a = new ArrayMap.Entry[Math.max(entries.length, k)];

	i = 0;  j = 0;  k = 0;
        while (i < card && j < that.card) {
            int comp = entries[i].key.compareTo(that.entries[j].key);
            if (comp < 0)
                a[k++] = entries[i++];
            else if (comp > 0)
                a[k++] = that.entries[j++];
            else {  // if (comp == 0)
                a[k++] = that.entries[j++];  i++;
            }
        }
        while (i < card)
            a[k++] = entries[i++];
        while (j < that.card)
            a[k++] = that.entries[j++];
        entries = a;  card = k;
    }

    private int search (Comparable key) {
        int left = 0, right = card-1, mid = 0;
        while (left <= right) {
            mid = (left + right)/2;
            int comp = key.compareTo(entries[mid].key);
            if (comp == 0)
                break;
            else if (comp < 0)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return mid;
    }

    private void expand () {
    }

    //////////// Inner class for map entries ////////////

    private static class Entry implements Map.Entry {

    	// Each ArrayMap.Entry object is a map entry consisting of a key,
    	// which is a Comparable object, and a value, which is an arbitrary
    	// object.
    	private Comparable key;
    	private Object value;

    	private Entry (Comparable key, Object value) {
    	    this.key = key;
    	    this.value = value;
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
