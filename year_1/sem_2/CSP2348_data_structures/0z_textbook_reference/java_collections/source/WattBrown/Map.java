package WattBrown;

public interface Map {

    // Each Map object is a map in which the keys are Comparable objects
    // and the values are arbitrary objects.

    //////////// Accessors ////////////

    public boolean isEmpty ();
    // Return true if and only if this map is empty.

    public int size ();
    // Return the cardinality of this map, i.e., the number of entries.

    public Object get (Object key);
    // Return the value in the entry with key in this map, or null if there
    // is no such entry. (Throw a ClassCastException if this map cannot
    // contain a key with the class of key.)

    public boolean equals (Map that);
    // Return true if this map is equal to that.

    public Set keySet ();
    // Return the set of all keys in this map.

    //////////// Transformers ////////////

    public void clear ();
    // Make this map empty.

    public Object remove (Object key);
    // Remove the entry with key (if any) from this map. Return the value
    // in that entry, or null if there was no such entry.

    public Object put (Object key, Object val);
    // Add the entry ‹key, val› to this map, replacing any existing entry with
    // key. Return the value in that entry, or null if there was no such entry.
    // (Throw a ClassCastException if this map cannot contain a key with the
    // class of key.)

    public void putAll (Map that);
    // Overlay this map with that, i.e., add all entries of that to this map,
    // replacing any existing entries with the same keys.

    //////////// Inner interface for map entries ////////////

    public interface Entry {

        // Each Map.Entry object is a map entry consisting of a key and
        // a value (both arbitrary objects).

        public Object getKey ();
        // Return the key of this entry.

        public Object getValue ();
        // Return the value of this entry.

        public void setValue (Object val);
        // Update the value of this entry to be val.
    }
}
