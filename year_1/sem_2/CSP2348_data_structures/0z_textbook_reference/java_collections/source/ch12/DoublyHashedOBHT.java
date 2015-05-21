public class DoublyHashedOBHT {

    // An object of class DoublyHashedOBHT is an open-bucket hash table,
    // containing entries of class MapEntry.
    private MapEntry[] buckets;
    
    // buckets[b] is null if bucket b has never been occupied. 
    // buckets[b] is former if bucket b is formerly-occupied 
    // by an entry that has since been deleted (and not yet replaced).

    static final int NONE = -1; // ... distinct from any bucket index.
    
    public DoublyHashedOBHT (int m) {
    // Construct an empty DoublyHashedOBHT with m buckets.
        buckets = new MapEntry[m];
    }


    private int hash (Comparable key) {
    // Translate key to an index of the array buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }


    private int step (DoublyHashable key) {
    // Translate key to a step size of the array buckets.
        return Math.abs(key.stepCode()) % buckets.length;
    }
    

    private static final MapEntry former = new MapEntry(null, null);
    // This guarantees that, for any genuine entry e, 
    // e.key.equals(former.key) returns false.

    
    public int search (Comparable targetKey) {
    // Find which if any bucket of this OBHT is occupied by an entry whose key
    // is equal to targetKey. Return the index of that bucket.
        int b = hash(targetKey);
        for (;;) {
            MapEntry oldEntry = buckets[b];
            if (oldEntry == null)
                return NONE;
            else if (targetKey.equals(oldEntry.key))
                return b;
            else
                b = (b + 1) % buckets.length;
        }
    }
    

    private int occupancy = 0;
    // ... number of occupied or formerly-occupied buckets in this OBHT.


    public void insert (Comparable key, Object val) {
    // Insert the entry <key, val> into this OBHT.
        MapEntry newEntry = new MapEntry(key, val);
        int b = hash(key);
        int s = step((DoublyHashable) key);
        for (;;) {
            MapEntry oldEntry = buckets[b];
            if (oldEntry == null) {
                if (++occupancy == buckets.length) {
                    expand();  // Expand the number of buckets.
                    b = hash(key);
                    s = step((DoublyHashable) key);
                    continue;
                }
                buckets[b] = newEntry;
                return;
            } else if (oldEntry == former
                    || key.equals(oldEntry.key)) {
                buckets[b] = newEntry;
                return;
            } else
                b = (b + s) % buckets.length;
        }
    }

    
    public void delete (Comparable key) {
    // Delete the entry (if any) whose key is equal to key from this OBHT.
        int b = hash(key);
        for (;;) {
            MapEntry oldEntry = buckets[b];
            if (oldEntry == null)
                return;
            else if (key.equals(oldEntry.key)) {
                buckets[b] = former;
                return;
            } else
                b = (b + 1) % buckets.length;
        }
    }


    public String toString () {
    	String temp = "";
    	for (int i = 0; i < buckets.length; i++) {
    	    temp += i + ":";
    	    if (buckets[i] == null)
    	        temp += "\n";
    	    else if (buckets[i] == former)
    	        temp += "former\n";
    	    else
    	        temp += buckets[i] + "\n";
    	}
    	return temp;
    }


    public Object clone () {
    	DoublyHashedOBHT copy = new DoublyHashedOBHT(buckets.length);
    	for (int i = 0; i < buckets.length; i++) {
    	    MapEntry e = buckets[i];
    	    if (e != null && e != former)
    	        copy.buckets[i] = new MapEntry(e.key, e.value);
    	    else
    	        copy.buckets[i] = e;
    	}
    	return copy;
    }

    private void expand () {
    // Expand the size of this hash table and rehash all of the current entries.
        return; // TEMPORARY
    }

}
