public class IntKeyMap {

    // Each IntKeyMap object is a map in which the keys are small integers 
    // and the values are arbitrary objects.

    // This map is represented as follows: vals[k] contains the value 
    // corresponding to key k, or null if there is no such value.
    
    private Object[] vals;

    //////////// Constructor ////////////

    public IntKeyMap (int m) {
    // Construct a map, initially empty, whose keys will be integers in the 
    // range 0 through m-1.
        vals = new Object[m];
    }

    //////////// Accessors ////////////

    public Object get (int key) {
    // Return the value in the entry with key in this map, or null if there
    // is no such entry.
        if (key < 0 || key >= vals.length)
            return null;
        return vals[key];
    }


    //////////// Transformers ////////////

    public Object remove (int key) {
    // Remove the entry with key (if any) from this map. Return the value 
    // in that entry, or null if there was no such entry.
        if (key < 0 || key >= vals.length)
            return null;
        Object oldval = vals[key];
        vals[key] = null;
        return oldval;
    }


    public Object put (int key, Object val) {
    // Add the entry <key, val> to this map, replacing any existing entry with 
    // key. Return the value in that entry, or null if there was no such entry.
        if (key < 0 || key >= vals.length)
            return null;
        Object oldval = vals[key];
        vals[key] = val;
        return oldval;
    }

}
