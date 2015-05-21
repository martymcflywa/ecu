# Sets and maps

# Sets

## Set concepts

- A **set** is a collection of **distinct members**, whose order is **insignificant**
	- Values or objects
	- Duplicated members not permitted
		- Or could be allowed but not counted repeatedly
- Notation for sets: `{a, b, ..., z}`
	- The empty set is `{}`
	- Set notation is used here, but **not** supported by Java

### Examples of sets

```
// set of integers
evens = {0, 2, 4, 6, 8}

// set of chars
punct = {'.', '!', '?', ':', ';', ','}

// set of short names of EU countries
EU  {AT, BE, DE, DK, ES, FI, FR, GR, IE, IT, LU, NL, PT, SE, UK}

// set of North American Trade Agreemment
NAFTA = {CA, MX, US}

// set of North Atlantic Treaty Organization
NATO = {BE, CA, CZ, DE, DK, ES, FR, GR, HU, IS, IT, LU, NL, NO, PL, PT, TR, UK, US}

SCSS_Staff = {Craig VALLI, Jitian XIAO, ...}

CSP2348_NameList = {James, ...}
```

### Set cardinality

- The **cardinality** of a set `s` is the number of distinct members of `s`
- This is written as `#s`, for example:
	- `#EU = 15`
	- `#{red, white, red} = 2`
		- Duplicate members are not counted
		- Must be distinct
	- An **empty** set has cardinality 0

### Set membership test

- We can test whether `x` is a member of a set `s`
	- ie. `s` contains `x`
- This is the **membership test**, written as `x ∈ s`
	- `∈`: Relationship between a set and (one of) its members, for example:
		- `EU = {AT, BE, DE, DK, ES, FI, FR, GR, IE, IT, LU, NL, PT, SE, UK}`
		- `UK ∈ EU`
			- `UK` is an element of `EU`
		- `IT ∈ EU`
			- `IT` is an element of `EU`
		- `US ∉ EU`
			- `US` is not an element of `EU`

### Set equality

- Two sets are **equal** if they contain exactly the same members
- Order of members does not matter
	- `NAFTA = {US, CA, MX}`
	- `NAFTA != {CA, US}`

### Supersets

- Set `s_1` **subsumes** (is a **superset** of) set `s_2` if every member of `s_2` is also a member of `s_1`
- This is written as either
	- `s_1 ⊇ s_2`
		- `s_1` is a superset of `s_2`
	- `s_2 ⊆ s_1`
		- `s_2` is a subset of `s_1`
- Like `=`, `⊇` and `⊆` are of relationships between sets
	- `NATO ⊇ {CA, US}`
		- `NATO` is a superset of `{CA, US}`
	- `NATO ⊅ EU`
		- `NATO` is not a superset of `EU`

### Set union

![union](http://snag.gy/7gnK1.jpg)

- The **union** of sets `s_1` and `s_2` is a set containing just those members of `s_1` or `s_2` or both
- This is written as `s_1 ∪ s_2`
	- `{DK, NO, SE} ∪ {FI, IS} = {DK, FI, IS, NO, SE}`
	- `{DK, NO, SE} ∪ {IS, NO} = {DK, IS, NO, SE}`
		- `NO` belongs to both original sets and is not included twice after the union

### Set intersection

![intersect](http://snag.gy/XIIuS.jpg)

- The **intersection** of sets `s_1` and `s_2` is a set containing just members of both `s_1` and `s_2`
- This is written as `s_1 ∩ s_2`
	- `NAFTA ∩ NATO = {CA, US}`
	- `NAFTA ∩ EU = {}`

#### Set disjoint

![disjoint](http://snag.gy/KBgtm.jpg)

- Two sets are **disjoint** if the have no common member
	- ie. If their intersection is empty
	- `NAFTA` and `EU` are disjoint
	- `NAFTA` and `NATO` are not disjoint

### Set difference

- The **difference** of sets `s_1` and `s_2` is a set containing just those that are members of `s_1`, but not `s_2`
- This is written as `s_1 - s_2`
	- `NATO - EU = {CA, CZ, HU, IS, NO, PL, TR, US}`
	- `EU - NATO = {AT, FI, IE, SE}`

## Set applications

### Spell checker

- A spell checker's dictionary is a **set** of words
- The spell checker highlights any words in the document that are not in the dictionary set
- The spell checker might allow the user to add words to the dictionary set

### Relational database system

- A relation is essentially a set of tuples
- The tuples are in no particular order
- Each tuple is **distinct**

## Set requirements

1. It must be possible to make a set empty
2. It must be possible to test whether a set is empty
3. It must be possible to obtain the cardinality of a set
4. It must be possible to perform a membership test
5. It must be possible to add or remove a member of a set
6. It must be possible to test whether two sets are equal
7. It must be possible to test whether one set subsumes another
8. It must be possible to compute from two sets:
	- Union
	- Intersection
	- Difference
9. It must be possible to traverse a set

## Set contract as `interface`

``` java
/**
 * Each Set object is a set whose members are objects.
 */
public interface Set {

	/*************
	 * ACCESSORS *
	 *************/

	/**
	 * Return true if set is empty.
	 *
	 * @return boolean.
	 */
	public boolean isEmpty();

	/**
	 * Return cardinality of set.
	 *
	 * @return int.
	 */
	public int size();

	/**
	 * Return true of obj is a member of this set
	 *
	 * @param obj Object.
	 * @return boolean.
	 */
	public boolean contains(Object obj);

	/**
	 * Return true if this set is equal to that.
	 *
	 * @param that Set.
	 * @return boolean.
	 */
	public boolean equals(Set that);

	/**
	 * Return true if this set is disjoint to that.
	 *
	 * @param that Set.
	 * @return boolean.
	 */
	public boolean disjoint(Set that);

	/**
	 * Return true if this set subsumes that.
	 *
	 * @param that Set.
	 * @return boolean.
	 */
	public boolean containsAll(Set that);

	/****************
	 * TRANSFORMERS *
	 ****************/

	/**
	 * Make this set empty.
	 */
	public void clear();

	/**
	 * Add obj as a member of this set.
	 * Throw ClassCastException if this set cannot contain an object
	 * with the class of obj.
	 *
	 * @param obj Object.
	 */
	public void add(Object obj);

	/**
	 * Remove obj from this set.
	 *
	 * @param obj Object.
	 */
	public void remove(Object obj);

	/**
	 * Make this set union of itself and that.
	 *
	 * @oaram that Set.
	 */
	public void addAll(Set that);

	/**
	 * Make this set the difference of itself and that.
	 *
	 * @param that Set.
	 */
	public void removeAll(Set that);

	/**
	 * Make this set the intersection of itself and that.
	 *
	 * @param that Set.
	 */
	public void retainAll(Set that);

	/************
	 * ITERATOR *
	 ************/

	/**
	 * Return an iterator that will visit all members of this set,
	 * in no particular order
	 */
	public Iterator iterator();
}
```

## Set implementation using member arrays

- Represent a **bounded** set (cardinality <= `maxcard`) by:
	- A variable `card`
		- Contains the current cardinality
	- An array, members, of length `maxcard`
		- Contains the set members in `members[0...card-1]`
	- Keeping the array sorted, and not storing duplicates

### Set using member arrays invariant

![sets as arrays invariant](http://snag.gy/zGkXo.jpg)

### `ArraySet` Java class

``` java
/**
 * Each ArraySet object is a bounded set whose members are Comparable objects.
 *
 * The set is represented as follows:
 * Its cardinality is held in card.
 * Its members (which are sorted and distinct)
 * occupy the subarray members[0...card-1]
 */
public class ArraySet implements Set {

	private Comparable[] members;
	private int card;

	/**
	 * Constructor.
	 * Construct a set, initially empty, whose cardinality
	 * will be bounded by maxcard.
	 *
	 * @param maxCard int.
	 */
	public ArraySet(int maxCard) {
		members = new Comparable[maxcard];
		card = 0;
	}

	/**
	 * Implement Set.
	 */

	/*************
	 * ACCESSORS *
	 *************/

	/**
	 * Return true if set is empty.
	 *
	 * @return boolean.
	 */
	public boolean isEmpty() {
		return (card == 0);
	}

	/**
	 * Return cardinality of set.
	 *
	 * @return int.
	 */
	public int size() {
		return card;
	}

	/**
	 * Return true of obj is a member of this set
	 *
	 * @param obj Object.
	 * @return boolean.
	 */
	public boolean contains(Object obj) {

		if(obj instanceof Comparable) {

			Comparable it = (Comparable) obj;
			int pos = search(it);
			return it.equals(members[pos]);

		} else {
			return false;
		}
	}

	/**
	 * Return true if this set is equal to that.
	 *
	 * @param that Set.
	 * @return boolean.
	 */
	public boolean equals(Set that) {

		ArraySet other = (ArraySet) that;

		if(this.card != other.card) {
			return false;
		}

		for(int i = 0; i < this.card; i++) {

			if (! this.members[i].equals(other.members[i])) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Return true if this set is disjoint to that.
	 *
	 * @param that Set.
	 * @return boolean.
	 */
	public boolean disjoint(Set that) {

		ArraySet other = (ArraySet) that;
		int i = 0;
		int j = 0;

		while(i < card && j < other.card) {

			int comp = members[i].compareTo(other.members[j]);

			if(comp < 0) {
				i++;
			} else if(comp > 0) {
				j++
			// else comp == 0
			} else {
				return false;
			}
		}

		return true;
	}

	/**
	 * Return true if this set subsumes that.
	 *
	 * @param that Set.
	 * @return boolean.
	 */
	public boolean containsAll(Set that) {

		ArraySet other = (ArraySet) that;

		if(card < other.card) {
			return false;
		}

		int i = 0;
		int j = 0;

		while(i < card && j < other.card) {

			int comp = members[i].compareTo(other.members[j]);

			if(comp < 0) {
				i++;
			} else if(comp > 0) {
				return false;
			// else comp == 0
			} else {
				i++;
				j++;
			}
		}

		return (j == other.card);
	}

	/****************
	 * TRANSFORMERS *
	 ****************/

	/**
	 * Make this set empty.
	 */
	public void clear() {

		for(int i = 0; i < card; i++) {
			members[i] = null;
		}

		card = 0;
	}

	/**
	 * Add obj as a member of this set.
	 * Throw ClassCastException if this set cannot contain an object
	 * with the class of obj.
	 *
	 * @param obj Object.
	 */
	public void add(Object obj) {

		Comparable it = (Comparable) obj;

		int left = 0;
		int right = card - 1;

		while(left <= right) {

			int mid = (left + right) / 2;
			int comp = it.compareTo(members[mid]);

			if(comp < 0) {
				right = mid - 1;
			} else if(comp > 0) {
				left = mid + 1;
			// else comp == 0
			} else {
				return;
			}
		}

		if(card == members.length) {
			return;
		}

		// insert x in members[left]
		for(int i = card - 1; i >= left; i--) {
			members[i + 1] = members[i];
		}

		members[left] = it;
		card++;
	}

	/**
	 * Remove obj from this set.
	 *
	 * @param obj Object.
	 */
	public void remove(Object obj) {

		if(obj instanceof Comparable) {

			Comparable it = (Comparable) obj;
			int left = 0;
			int right = card - 1;

			while(left <= right) {

				int mid = (left + right) / 2;
				int comp = it.compareTo(members[mid]);

				if(comp < 0) {

					right = mid - 1;

				} else if(comp > 0) {

					left = mid + 1;

				// else comp == 0
				} else {

					// delete x from members[mid]
					for(int i = mid + 1; i < card; i++) {
						members[i - 1] = members[i];
					}

					card--;
					return;
				}
			}
		}
	}

	/**
	 * Make this set union of itself and that.
	 *
	 * @oaram that Set.
	 */
	public void addAll(Set that) {

		ArraySet other = (ArraySet) that;

		// count the number of disjoint elements in this set and that
		int i = 0;
		int j = 0;
		int k = 0;

		while(i < card && j < other.card) {

			int comp = members[i].compareTo(other.members[j]);

			if(comp < 0) {
				k++;
				i++
			} else if(comp > 0) {
				k++;
				j++;
			} else {
				i++;
				j++;
			}
		}

		while(i < card) {
			k++;
			i++;
		}

		while(j < other.card) {
			k++;
			j++;
		}

		// create a new array at least as large as this set
		Comparable[] a = new Comparable[Math.max(k, members.length)];
		i = 0;
		j = 0;
		k = 0;

		while(i < card && j < other.card) {

			int comp = members[i].compareTo(other.members[j]);

			if(comp < 0) {
				a[k++] = members[i++];
			} else if(comp > 0) {
				a[k++] = other.members[j++];
			} else {
				a[k++] = members[i++];
				j++;
			}
		}

		while(i < card) {
			a[k++] = members[i++];
		}

		while(j < other.card) {
			a[k++] = other.members[j++];
		}

		members = a;
		card = k;
	}

	/**
	 * Make this set the difference of itself and that.
	 *
	 * @param that Set.
	 */
	public void removeAll(Set that) {

		ArraySet other = (ArraySet) that;
		Comparable[] a = new Comparable[members.length];
		int i = 0;
		int j = 0;
		int k = 0;

		while(i < card && j < other.card) {

			int comp = members[i].compareTo(other.members[j]);

			if(comp < 0) {
				a[k++] = members[i++];
			} else if(comp > 0) {
				j++;
			} else {
				i++;
				j++;
			}
		}

		while(i < card) {
			a[k++] = members[i++];
		}

		members = a;
		card = k;
	}

	/**
	 * Make this set the intersection of itself and that.
	 *
	 * @param that Set.
	 */
	public void retainAll(Set that) {

		ArraySet other = (ArraySet) that;
		Comparable[] a = new Comparable[members.length];
		int i = 0;
		int j = 0;
		int k = 0;

		while(i < card && j < other.card) {

			int comp = members[i].compareTo(other.members[j]);

			if(comp < 0) {
				i++;
			} else if(comp > 0) {
				j++;
			} else {
				a[k++] = members[i++];
				j++;
			}
		}

		members = a;
		card = k;
	}

	/************
	 * ITERATOR *
	 ************/

	/**
	 * Return an iterator that will visit all members of this set,
	 * in no particular order
	 */
	public Iterator iterator() {

		return new ArraySet.LRIterator();
	}

	/************************
	 * ITERATOR inner class *
	 ************************/

	private class LRIterator implements Iterator {

		private int place;

		/**
		 * Constructor.
		 */
		private LRIterator() {
			place = 0;
		}

		/**
		 * Return true if this iterator has a next element.
		 *
		 * @return boolean.
		 */
		public boolean hasNext() {
			return (place < card);
		}

		/**
		 * Return the next element in this iterator.
		 * Throw NoSuchElementException if there is no such element.
		 *
		 * @return Object.
		 */
		public Object next() {

			if(place >= card) {
				return new NoSuchElementException();
			}

			return members[place++];
		}

		/**
		 * Remove.
		 */
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
}
```

### Set using member algorithms and complexities

| Operation     | Algorithm                      | Time complexity                  |
|---------------|--------------------------------|----------------------------------|
| `contains`    | Binary search                  | O(log n)                         |
| `add`         | Binary search, insert          | O(n)                             |
| `remove`      | Binary search, delete          | O(n)                             |
| `equals`      | Pairwise comparison            | O(n<sub>2</sub>) (n = n<sub>1</sub></sub> = n<sub>2</sub>) |
| `containsAll` | Variant of pairwise comparison | O(n<sub>2</sub>)                 |
| `addAll`      | Array merge                    | O(n<sub>1</sub> + n<sub>2</sub>) |
| `removeAll`   | Variant of array merge         | O(n<sub>1</sub> + n<sub>2</sub>) |
| `retainAll`   | Variant of array merge         | O(n<sub>1</sub> + n<sub>2</sub>) |


## Set implementation using SLLs

- Represent an **unbounded** set by:
	- A variable `card`
		- Contains the current cardinality
	- An SLL, containing one member per node
	- Keeping the SLL sorted, and not storing duplicates

### Set using SLLs invariant

![sets as sll invariant](http://snag.gy/ehyPX.jpg)

### Set using SLLs algorithms and complexities

| Operation     | Algorithm                      | Time complexity                  |
|---------------|--------------------------------|----------------------------------|
| `contains`    | SLL linear search              | O(n)                             |
| `add`         | SLL linear search, insert      | O(n)                             |
| `remove`      | SLL linear search, delete      | O(n)                             |
| `equals`      | Pairwise comparison            | O(n<sub>2</sub>) (n = n<sub>1</sub></sub> = n<sub>2</sub>) |
| `containsAll` | Variant of pairwise comparison | O(n<sub>2</sub>)                 |
| `addAll`      | SLL merge                      | O(n<sub>1</sub> + n<sub>2</sub>) |
| `removeAll`   | Variant of SLL merge           | O(n<sub>1</sub> + n<sub>2</sub>) |
| `retainAll`   | Variant of SLL merge           | O(n<sub>1</sub> + n<sub>2</sub>) |

## Summary of set implementations

| Operation     | Set as member array                 | Set as SLL                       |
|---------------|-------------------------------------|----------------------------------|
| `contains`    | O(log n)                            | O(n)                             |
| `add`         | O(n)                                | O(n)                             |
| `remove`      | O(n)                                | O(n)                             |
| `equals`      | O(n<sub>2</sub>)                    | O(n<sub>2</sub>)                 |
| `containsAll` | O(n<sub>2</sub>)                    | O(n<sub>2</sub>)                 |
| `addAll`      | O(n<sub>1</sub> + n<sub>2</sub>)    | O(n<sub>1</sub> + n<sub>2</sub>) |
| `removeAll`   | O(n<sub>1</sub> + n<sub>2</sub>)    | O(n<sub>1</sub> + n<sub>2</sub>) |
| `retainAll`   | O(n<sub>1</sub> + n<sub>2</sub>)    | O(n<sub>1</sub> + n<sub>2</sub>) |

- The **array** representation is suitable only for small or static sets
	- A **static** set is one in which members are never added or removed
		- Or at least infrequently
- The **SLL** representation is suitable only for small sets
	- Because all operations are O(n)
		- If large set, operations will take too long
- For general applications, we need a more efficient set representation
	- **Binary search trees**
	- **Hash tables**

## Set implementation using BSTs

- Represent an **unbounded** set by a BST whose elements are the set members

### Set using BSTs invariant

![set as bst invariant](http://snag.gy/Q5zDW.jpg)

### Set using BSTs uniqueness

- The BST representation of a set is not unique
	- ie. Order of insertion does not make the set unique
	- Example below demonstrates that the two sets are equal, even though the elements were inserted in a different order

![set as bst uniqueness](http://snag.gy/PcJHn.jpg)

### Set using BSTs algorithms and complexities

| Operation  | Algorithm  | Best case | Worst case |
|------------|------------|-----------|------------|
| `contains` | BST search | O(log n)  | O(n)       |
| `add`      | BST insert | O(log n)  | O(n)       |
| `remove`   | BST delete | O(log n)  | O(n)       |


## Set implementation using CBHTs

- Represent an **unbounded** set by a CBHT whose objects are single-component set elements
- The `HashSet` class uses the objects' `hashCode()` values to store them in a hash table

### Set using CBHTs algorithms and complexities

| Operation  | Algorithm   | Best case | Worst case |
|------------|-------------|-----------|------------|
| `contains` | CBHT search | O(1)      | O(n)       |
| `add`      | CBHT insert | O(1)      | O(n)       |
| `remove`   | CBHT delete | O(1)      | O(n)       |

## Sets in the Java class library

- The `java.util.Set` interface is similar to the `Set` interface above
- The `java.util.TreeSet` class implements the `java.util.Set` interface, representing each set by a **balanced BST**
- The `java.util.HashSet` class implements the `java.util.Set` interface, representing each set by a **CBHT**

### Sets in the Java class library model

![Sets java class library model](http://snag.gy/1yD23.jpg)

### Java `TreeSet` class

- Constructors and major methods of Java `TreeSet` class:

``` java
public class TreeSet extends AbstractSet implements Set {
	public TreeSet();
	//...
	public boolean isEmpty();
	public boolean contains(Object object);
	public boolean add(Object object);
	public boolean remove(Object object);
	public void clear();
	public Object first();
	public Object last();
	public SortedSet subSet(Object start, Object stop);
	public SortedSet headSet(Object stop);
	public SortedSet tailSet(Object start);
}
```

### Java `HashSet` class

- Constructors and major methods of Java `HashSet` class:

``` java
public class HashSet implements Set {
	public HashSet();
	public HashSet(Collection collection);
	public HashSet(int capacity, float threshold);
	public HashSet(int capacity);
	public Iterator iterator();
	public boolean isEmpty();
	public boolean contains(Object object);
	public boolean add(Object object);
	public boolean remove(Object object);
	public void clear();
	public int size();
	public Object clone();
}
```

# Maps

## Map concepts

![simple map model](http://snag.gy/Jjbgf.jpg)

- A *map** is a collection of entries, which have
	- Distinct keys
	- Whose order is insignificant
- A map is also called a
	- Table
	- Dictionary
	- Associated array
- Each entry is a tuple consisting of a minimum of
	- One key field
	- One value field
- More generally, an entry may have
	- Several key fields
	- And/or several value fields
- Here we assume one key field and one value field only
	- But the algorithms work for almost all cases

### Map examples

![RomanLetter map](http://snag.gy/JvXi3.jpg)

![EC map](http://snag.gy/hOa7R.jpg)

![NAFTA map](http://snag.gy/J1SOb.jpg)

### Map cardinality

- The **cardinality** of a map m is the number of entries in m
- This is written as `#m`
	- `#NAFTA = 3`
	- An **empty** map has cardinality zero
- We can **look up** a map for a given key, to obtain the corresponding value

>Looking up `'X'` in map `RomanLetter` gives 10  
>Looking up `'A'` in map `RomanLetter` gives nothing

![RomanLetter map](http://snag.gy/47cEd.jpg)

### Map overlay

- We can **overlay** map `m_1` by map `m_2`
- The result contains all entries from both `m_1` and `m_2`
	- Except where both maps contain entries with the same key
	- To this entry, the result contains the entry from `m_2` only
	- ie. Duplicates are not considered, and entry will only show up once

![map overlay](http://snag.gy/q5KpI.jpg)

## Map applications

### Relational database

- A **relation** is a collection of tuples
- If a relation has a key field, all tuples must have distinct keys
- The tuples are in no particular order
- Thus a relation is really a map

### Telephone directory

- Each entry consists of a
	- Name
	- Address
	- Phone number
- Several entries may share the same name, but each entry must have a unique name-address combination
	- Unique key
- The entries could be in any order
	- They are typically sorted by name and address to make lookup fast
		- But it is not essential
- This a telephone directory is a map in which the key field is the name-address combination

## Map requirements

1. It must be possible to make a map empty
2. It must be possible to test whether a map is empty
3. It must be possible to test whether a map contains an entry with a given key
4. It must be possible to look up the value corresponding to a given key in a map
5. It must be possible to add a new entry to a map or to replace an existing entry
6. It must be possible to remove an entry from a map, given its key
7. It must be possible to test whether two maps are equal
8. It must be possible to compute the overlay of two maps
9. It must be possible to traverse a map

## Map contract as `interface`

``` java
/**
 * Each Map object is a map in which the keys are Comparable objects
 * and the values are arbitrary objects.
 */
public interface Map {

	/*************
	 * ACCESSORS *
	 *************/

	/**
	 * Return true if this map is empty.
	 *
	 * @return boolean.
	 */
	public boolean isEmpty();

	/**
	 * Return the cardinality of this map, ie. the number of entries.
	 *
	 * @return boolean.
	 */
	public int size();

	/**
	 * Return the value in the entry with the key in this map,
	 * or null if there is no such entry.
	 * Throw a ClassCastException if this map cannot contain
	 * a key with the class of key
	 *
	 * @param key Object.
	 * @return Object.
	 */
	public Object get(Object key);

	/**
	 * Return true if this map is equal to that.
	 *
	 * @param that Map.
	 * @return boolean.
	 */
	public boolean equals(Map that);

	/**
	 * Return the set of all keys in this map.
	 *
	 * @return Set.
	 */
	public Set keySet();

	/****************
	 * TRANSFORMERS *
	 ****************/

	/**
	 * Make this map empty.
	 */
	public void clear();

	/**
	 * Remove the entry with key (if any) from this map.
	 * Return the value in that entry, or null if there was no such entry.
	 *
	 * @param key Object.
	 * @return Object.
	 */
	public Object remove(Object key);

	/**
	 * Add the entry <key, val> to this map, replacing any existing entry with key.
	 * Return the value in that entry, or null if there was no such entry.
	 * Throw a ClassCastException if this map cannot contain a key with the class of key.
	 *
	 * @param key Object.
	 * @param val Object.
	 * @return Object.
	 */
	public Object put(Object key, Object val);

	/**
	 * Overlay this map with that, ie. add all entries of that to this map,
	 * replacing any existing entries with the same keys.
	 *
	 * @param that Map.
	 */
	public void putAll(Map that);

	/***********************************
	 * Inner interface for map entries *
	 ***********************************/

	/**
	 * Each Map.Entry object is a map entry consisting of a key and a value.
	 * Both are arbitrary objects.
	 */
	public interface Entry {

		/**
		 * Return the key of this entry.
		 *
		 * @return Object.
		 */
		public Object getKey();

		/**
		 * Return the value of this entry.
		 *
		 * @return Object.
		 */
		public Object getValue();

		/**
		 * Update the value of this entry to be val.
		 *
		 * @param val Object.
		 */
		public void setValue(Object val);
	}
}
```

## Map implementation using entry arrays

- Represent a **bounded** map (cardinality <= `maxcard`) by:
	- A variable `card`
		- Contains the current current cardinality
	- An array, `entries`, of length `maxcard`
		- Contains the map entries in `entries[0...card-1]`
	- Keeping the array sorted by `key`

### Map using entry arrays invariant

![map as array invariant](http://snag.gy/GPa2m.jpg)

### Map using entry arrays model

![map as array model](http://snag.gy/V21Ws.jpg)

### Map using entry arrays algorithms and complexities

| Operation | Algorithm                   | Time complexity                  |
|-----------|-----------------------------|----------------------------------|
| `get`     | Binary search               | O(log n)                         |
| `remove`  | Binary search, array delete | O(n)                             |
| `put`     | Binary search, array insert | O(n)                             |
| `putAll`  | Variant of array merge      | O(n<sub>1</sub> + n<sub>2</sub>) |
| `equals`  | Pairwise equality test      | O(n<sub>2</sub>)                 |

## Map implementation using SLLs

- Represent an **unbounded** map by:
	- A variable `card`
		- Contains the current cardinality
	- An SLL
		- Contains one entry per node
	- Keep the SLL sorted by `key`

### Map using SLLs invariant

![map as sll invariant](http://snag.gy/MmzxM.jpg)

### Map using SLLs model

![map as sll model](http://snag.gy/eOFfp.jpg)

### Map using SLLs algorithms and complexities

| Operation | Algorithm                   | Time complexity                  |
|-----------|-----------------------------|----------------------------------|
| `get`     | SLL linear search           | O(log n)                         |
| `remove`  | SLL linear search, delete   | O(n)                             |
| `put`     | SLL linear search, insert   | O(n)                             |
| `putAll`  | Variant of SLL merge        | O(n<sub>1</sub> + n<sub>2</sub>) |
| `equals`  | Pairwise equality test      | O(n<sub>2</sub>)                 |

## Map implementation using BSTs

- Represent an **unbounded** map by a BST whose elements are the entries
- Use only the keys to order the entries

### Map using BSTs invariant

![map as bst invariant](http://snag.gy/1YjuF.jpg)

### Map using BSTs model

![map as bst model](http://snag.gy/lTDat.jpg)

### Map using BSTs algorithms and complexities

| Operation | Algorithm                                     | Best case                                           | Worst case                     |
|-----------|-----------------------------------------------|-----------------------------------------------------|--------------------------------|
| `get`     | BST search                                    | O(log n)                                            | O(n)                           |
| `remove`  | BST delete                                    | O(log n)                                            | O(n)                           |
| `put`     | BST insert                                    | O(log n)                                            | O(n)                           |
| `putAll`  | BST merge                                     | O(n<sub>2</sub> log(n<sub>1</sub> + n<sub>2</sub>)) | O(n<sub>1</sub> n<sub>2</sub>) |
| `equals`  | Traverse one BST, search for key in other BST | O(n<sub>1</sub> log n<sub>2</sub>)                  | O(n<sub>1</sub> n<sub>2</sub>) |

## Map implementation using CBHTs

- Represent an **unbounded** map by a CBHT whose keys are hashed to bucket indices (entries) and elements are stored in the bucket's list

### Map using CBHT algorithms and complexities

| Operation | Algorithm                                            | Best case | Worst case                     |
|-----------|------------------------------------------------------|-----------|--------------------------------|
| `get`     | CBHT search                                          | O(1)      | O(n)                           |
| `remove`  | CBHT delete                                          | O(1)      | O(n)                           |
| `put`     | CBHT insert                                          | O(1)      | O(n)                           |
| `putAll`  | Merge on corresponding buckets of both CBHTs         | O(m)      | O(n<sub>1</sub> n<sub>2</sub>) |
| `equals`  | Equality test on corresponding buckets of both CBHTs | O(m)      | O(n<sub>1</sub> n<sub>2</sub>) |

## Maps in the Java class library

- The `java.util.Map` interface is similar to the `Map` interface above
- The `java.util.TreeMap` class implements the `java.util.Map` interface
	- Represents each map by a balanced BST
- The `java.util.HashMap` class implements the `java.util.Map` interface
	- Represents each map by a CBHT

### Maps in the Java class library model

- Java provides a `HashMap` class for unsorted maps
- `TreeMap` class for sorted maps

![maps in java class library model](http://snag.gy/nRTdd.jpg)

### Java `TreeMap` class

- Constructors and major methods of Java `TreeMap` class

``` java
public class TreeMap extends AbstractMap implements Map {
	public TreeMap();
	public boolean isEmpty();
	public boolean containsKey(Object key);
	public boolean containsValue(Object value);
	public Object get(Object key);
	public Object remove(Object key);
	public Object put(Object key, Object value);
	public void clear();
	public void putAll(Map map);
	public int hashCode();
	public Set keySet();
	public Set entrySet();
}
```

### Java `HashMap` class

- Constructors and major methods of Java `HashMap` class

``` java
public class HashMap implements Map {
	public HashMap();
	public boolean isEmpty();
	public boolean containsKey(Object key);
	public boolean containsValue(Object value);
	public Object get(Object key);
	public Object remove(Object key);
	public Object put(Object key, Object value);
	public void clear();
	public void putAll(Map map);
	public int hashCode();
	public Set keySet();
	public Set entrySet();
}
```

# Study guide

- Java Collections
	- Chapter 9
	- Chapter 11
