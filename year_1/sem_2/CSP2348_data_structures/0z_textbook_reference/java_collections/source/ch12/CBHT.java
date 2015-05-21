public class CBHT {

    // An object of class CBHT is a closed-bucket hash table, containing
    // entries of class MapEntry.
    private SLLNode[] buckets;

    public CBHT (int m) {
    // Construct an empty CBHT with m buckets.
        buckets = new SLLNode[m];
    }


    private int hash (Comparable key) {
    // Translate key to an index of the array buckets.
        return Math.abs(key.hashCode()) % buckets.length;
    }


    public SLLNode search (Comparable targetKey) {
    // Find which if any node of this CBHT contains an entry whose key is equal 
    // to targetKey. Return a link to that node (or null if there is none).
        int b = hash(targetKey);
        for (SLLNode curr = buckets[b]; curr != null; curr = curr.succ) {
            if (targetKey.equals(((MapEntry) curr.element).key))
                return curr;
        }
        return null;
    }


    public void insert (Comparable key, Object val) {
    // Insert the entry <key, val> into this CBHT.
        MapEntry newEntry = new MapEntry(key, val);
        int b = hash(key);
        for (SLLNode curr = buckets[b]; curr != null; curr = curr.succ) {
            if (key.equals(((MapEntry) curr.element).key)) { 
                // Make newEntry replace the existing entry ...
		curr.element = newEntry;
		return;
	    }
        }
	// Insert newEntry at the front of the 1WLL in bucket b ...
	buckets[b] = new SLLNode(newEntry, buckets[b]);
    }


    public void delete (Comparable key) {
    // Delete the entry (if any) whose key is equal to key from this CBHT.
        int b = hash(key);
        for (SLLNode pred = null, curr = buckets[b];
                curr != null;
                pred = curr, curr = curr.succ) {
            if (key.equals(((MapEntry) curr.element).key)) {
                if (pred == null)
                    buckets[b] = curr.succ;
                else
                    pred.succ = curr.succ;
                return;
            }
        }
    }


    public String toString () {
    	String temp = "";
    	for (int i = 0; i < buckets.length; i++) {
    	    temp += i + ":";
            for (SLLNode curr = buckets[i];
                    curr != null;
                    curr = curr.succ) {
                temp += curr.element.toString() + " ";
            }
            temp += "\n";
        }
        return temp;
    }
    	        	
}
