class MapEntry implements Comparable {

    // Each MapEntry oject is a pair consisting of a key (a Comparable 
    // object) and a value (an arbitrary object).
    Comparable key;
    Object value;

    public MapEntry (Comparable key, Object val) {
        this.key = key;
        this.value = val;
    }
    
    public int compareTo (Object that) {
    // Compare this map entry to that map entry.
        MapEntry other = (MapEntry) that;
        return this.key.compareTo(other.key);
    }

    public String toString () {
        return "<" + key + "," + value + ">";
    }
}
