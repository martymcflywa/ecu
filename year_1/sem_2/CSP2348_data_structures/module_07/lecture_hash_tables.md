# Hash tables

## Hash table principles

- In some applications, searching a value in a table based on a key value needs to be done quickly
	- At least not by linear search
	- Linear search will generally search about half the size of the given table/array
- Hash table is a way that rearranges the table, and then uses a function defined upon the key value, to map the key directly to a room holding the value in the rearranged table
	- Thus to quickly locate the value

![hash table](http://snag.gy/ZXWOs.jpg)

### Buckets

- A hash table is an array of m **buckets**, together with a **hash function**, hash(k), that translates each key k to a bucket index (in the range 0...m-1)
- **Hashing:**
	- Translate/map each key to a small integer, and use that integer to index an array (of buckets)
- Each key k has a **home bucket** in the hash table, namely the bucket with index hash(k)

![buckets](http://snag.gy/ZL97z.jpg)

### Operations

- **Hash table operations:**
	- **Insert:**
		- To insert a new entry with key k into the hash table, assign that entry to k's home bucket
	- **Search:**
		- To search for an entry with key k in the hash table, look in k's home bucket
	- **Delete:**
		- To delete an entry with key k from the hash table, look in k's home bucket

![operations](http://snag.gy/RhrQE.jpg)

### Hash function

- The hash function **must be consistent:**
	- if k<sub>1</sub> = k<sub>2</sub>, hash(k<sub>1</sub>) = hash(k<sub>2</sub>)
- Generally, the hash function is a many-to-one function, imlying that **different keys may share the same home bucket**
	- ie. k<sub>1</sub> &ne; k<sub>2</sub> but hash(k<sub>1</sub>) = hash(k<sub>2</sub>)
	- In such a case, we say a **collision** occured
- Always prefer a hash function that makes collisions relatively infrequent

### Example: Hash function for words

- Suppose that the keys are English words
- One possible hash function on word w:
	- m = 26
		- ie. Hash table has m = 26 buckets
	- hash(w) = 'A'
		- Initial letter of w
			- All words with initial letter 'A' share bucket 0
			- ...
			- All words with initial letter 'Z' share bucket 25
- This is a convenient choice for illustrative purpose, but a poor choice in practice
	- Collisions are likely to be frequent in some buckets

### Hashing in Java

- Instance method in class `Object`:

``` java
public int hashCode();
// Translate this object to an integer, such that x.equals(y)
// implies x.hashCode() == y.hashCode()
```

- Note that `hashCode` is consistent
- We can use it to implement a hash function for a hash table with m buckets:

``` java
int hash(Object k) {
	return Math.abs(k.hashCode()) % m;
	// Math.abs returns a nonnegative int
	// % Modulo-m arithmetic then gives an integer in the range 0...m-1
}
```

## Closed bucket vs. open bucket hash tables

- **Closed bucket:**
	- Each bucket may be occupied by several entries
		- Multiple entries with the same hashing value share same bucket
			- ie. **Closed**
	- Buckets are completely separate
- **Open bucket:**
	- Each bucket may be occupied by at most one entry
	- Whenever there is a collision, displace the new entry to another bucket
		- ie. All buckets **open** for sharing space
	- Multiple entries with the same hashing value **do not** share same bucket

### CBHT vs. OBHT practical

- CBHTs provide dynamic allocation of nodes, and thus can grow up freely as long as the memory capacity is not restricted
- OBHTs have fixed length, and when they become full, a time-consuming operation is needed to expand the number of buckets, rehashing all the existing entries
- A CBHT is always preferable to OBHT, unless
	1. Memory is restricted
	2. Dynamic memory management is not feasible
	3. The number of entries is naturally bounded

## Closed bucket hash tables (CBHT)

- Each bucket may be occupied by several entries
- Buckets are completely separate
- Simplest implementation: Each bucket is an SLL

### CBHT illustrative examples

- Keys are names of chemical elements
- Assume:
	- m = 26
	- hash(e) = (initial letter of e) - 'A'

#### CBHT no collisions

![chemical cbht no coll](http://snag.gy/nWNdV.jpg)

>**Element and their atomic numbers:**  
F – Fluorine; Hash (F) = ‘F’-’A’ = 5 (atomic number is 9)  
Ne - Neon; Hash (Na) = ‘N’-’A’ = 13 (atomic number is 10)  
Cl – Chlorine; Hash (Cl) = ‘C’-’A’ = 2 (atomic number is 17)  
Ar – Argon; Hash (Ar) = ‘A’-’A’ = 0 (atomic number is 18)  
Br – Bromine; Hash (Br) = ‘B’-’A’ = 1 (atomic number is 2)  
Kr – Krypton; Hash (Kr) = ‘K’-’A’ = 10 (atomic number is 36)  
I – Iodine;  Hash (l) = ‘I’-’A’ = 8 (atomic number is 53)  
Xe – Xenon; Hash (Cl) = ‘X’-’A’ = 23 (atomic number is 54)  

#### CBHT with collisions

![chemical cbht with coll](http://snag.gy/NhAHi.jpg)

### CBHT Java class

``` java
public class CBHT {

	// reference to node
	private BucketNode[] buckets;

	// constructor
	public CBHT(int m) {
		buckets = new BucketNode[m];
	}

	// ... CBHT methods here

	// hash function
	private int hash(Object key) {
		return Math.abs(key.hashCode()) % buckets.length;
		// Math.abs returns a nonnegative int
		// % Modulo-m arithmetic then gives an integer in the range 0...m-1
	}

	/**
	* Subclass for cbht nodes
	*/
	private static class BucketNode {

		// stores key, value and next
		private Object key;
		private Object value;
		private BucketNode next;

		// constructor
		private BucketNode(Object key, Object val, BucketNode next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
	}
}
```

### CBHT search

#### CBHT search algorithm

>To find which (if any) node of a CBHT contains an entry whose key is equal to target-key:

>1. Set b to hash(target-key)
2. Find which (if any) node of the SLL of bucket b contains an entry whose key is equal to target-key, and terminate with that node as answer

#### CBHT search Java method

``` java
// inside CBHT class

// returns BucketNode
public BucketNode search(Object targetKey) {

	// 1.0 Set b to hash(target-key)
	int b = hash(targetKey);

	// 2.0 Find which (if any) node of the SLL of bucket b contains
	// an entry whose key is equal to target-key, and terminate with that node as answer

	// For loop below implies that each bucket is a linked list

	// traverse current from buckets[b] to its next, until current = null:
	for(BucketNode current = buckets[b]; current != null; current = current.next) {

		// if target found, return it
		if(targetKey.equals(current.key)) {
			return current;
		}
	}

	// for loop ended, current = null and key not found
	return null;
}
```

### CBHT insertion

#### CBHT insertion algorithm

>To insert the entry(key, val) into a CBHT:

>1. Set b to hash(key)
2. Insert the entry (key, val) into the SLL of bucket b, replacing any existing entry whose key is key
3. Terminate

#### CBHT Java method

``` java
// inside CBHT class

public void insert(Object key, Object val) {

	// 1.0 Set b to hash(key)
	int b = hash(key);

	// 2.0 Insert the entry (key, val) into the SLL of bucket b,
	// replacing any existing entry whose key is key

	// traverse current from buckets[b] to its next, until current = null:
	for(BucketNode current = buckets[b]; current != null; current = current.next) {

		// if key matches current key,
		if(key.equals(current.key)) {

			// 2.0 "replace existing entry whose key is key"
			current.value = val;
			return;
		}
	}

	// for loop ended, current = null and key not found,
	// create new node, insert first
	buckets[b] = new BucketNode(key, val, buckets[b]);
}
```

![anim cbht insertion](http://i.imgur.com/sfP2Wea.gif)

### CBHT deletion

#### CBHT deletion algorithm

>To delete the entry (if any) whose key is equal to key from a CBHT:

>1. Set b to hash(key)
2. Delete the entry (if any) whose key is equal to key from the SLL of bucket b
3. Terminate

#### CBHT Java method

``` java
// inside CBHT class

public void delete(Object key) {

	// 1.0 Set be to hash(key)
	int b = hash(key);

	// 2.0 Delete the entry (if any) whose key is equal to key from the SLL of bucket b

	// using two cursors, previous and current
	// previous starts at null, current starts at buckets[b]
	// traverse cursors until current == null
	// for each traversal, previous is set to current, and current is set to current.next
	// previous is always one step behind
	for(BucketNode previous = null, current = buckets[b]; current != null; previous = current, current = current.next) {

		// if key matches current key,
		if(key.equals(current.key)) {

			// if previous == null, (current is still at buckets[b])
			if(previous == null) {

				// set buckets[b] to current.next, deleting current node
				buckets[b] = current.next;

			// else previous != null
			} else {

				// set previous.next to current.next, deleting current node
				previous.next = current.next;
			}
			return;
		}
	}
}
```

### CBHT analysis

- Analysis of the CBHT search/insert/delete algorithms:
	- Counting comparisons
	- Let n be the number of entries
- **Best case:**
	- No buckets contain more than (say) 2 entries
		- Max no. comparisons: 2
		- Best case time complexity: O(1)
- **Worst case:**
	- One bucket contains all n entries
		- Max no. comparisons: n
		- Worst case time complexity: O(n)

### CBHT design

- CBHT design consists of:
	1. Choosing the number of buckets, m
	2. Choosing the hash function hash()
- Design aims:
	- Collisions should be infrequent
	- Entries should be distributed evenly among the buckets
		- Such that few buckets contain more than about two entries

#### CBHT: Choosing the number of buckets

- **Load factor** of a hash table:
	- The average number of entries per bucket
	- n / m
- If n is (roughly) predictable, choose m such that the load factor is likely to be between 0.5 and 0.75
	- A low load factor wastes space
	- A high load factor tends to cause some buckets to have many entries
- Choose m to be a **prime number**
	- Typically the hash function performs **modulo-m** arithmetic
		- If m is prime, the entries are more likely to be **distributed evenly** over the buckets
			- Regardless of any patterns in the keys

#### CBHT: Choosing the hash function

- The hash function should be efficient
	- ie. Performing few arithmetic operations only
- The hash function should distribute the entries evenly among the buckets
	- Regardless of any patterns in the keys
- Possible trade-off:
	- Speed up the hash function by using only part of the key
	- But beware of any patterns in that part of the key

#### Example: Hash table for words

- Suppose that a hash table will contain about 1000 common English words
- Known patterns in the keys:
	- Letters vary in frequency
		- A, E, I, N, S, T are common
		- Q, X, Z are uncommon
	- Word lengths vary in frequency
		- Word lengths 4 - 8 are common
		- Other word lengths are less common
- `hash(w)` can depend on any of `w`'s letters and/or length
	1. Consider `m = 20, hash(w) = length of w - 1`
		- Far too few buckets
		- Load factor = 1000 / 20 = 50
		- Very uneven distribution
	2. Consider `m = 26, hash(w) = initial letter of w - 'A'`
		- Far too few buckets
		- Very uneven distribution
	3. Consider `m = 520, hash(w) = 26 * (length of w - 1) + (initial letter of w - 'A')`
		- Too few buckets
		- Load factor = 1000 / 520 &asymp; 1.9
		- Very uneven distribution
			- Since few words have length 1~2, buckets 0-51 will be sparsely populated
			- Since inital letter Z is uncommon, buckets 25, 51, 77, 103, ... will be sparsely populated
			- And so on
	4. Consider `m = 1499, hash(w) = (weighted sum of letters of w) % m`
		- ie. (c<sub>1</sub> * 1st letter of w + c<sub>2</sub> * 2nd letter of w + ...) % m
		- Good number of buckets
		- Load factor &asymp; 0.67
		- Reasonably even distribution

## Open bucket hash tables (OBHT)

- Each bucket may be occupied by at most one entry
- Whenever there is a collision, displace the new entry to another bucket (same array!)
	- Multiple entries with the same hashing value **do not** share same room/bucket
- Each bucket has three possible states
	- **Never occupied**
		- Has never contained an entry
	- **Occupied**
		- Currently contains an entry
	- **Formerly occupied**
		- Previously contained an entry
			- Which has been deleted and not yet replaced

### OBHT illustrative examples

- Keys are names of chemical elements
- Assume:
	- m = 26
	- hash(e) = (initial letter of e) - 'A'
- On a collision, insert the new entry in the next unoccupied bucket
	- Treating the array as cyclic

#### OBHT no collisions

![chemical obht no coll](http://snag.gy/1GM5a.jpg)

#### OBHT with collisions

![chemical obht with coll](http://snag.gy/5Gh9s.jpg)

### OBHT Java class

``` java
public class OBHT {

	// reference to entry
	private BucketEntry[] buckets;

	// constructor
	public OBHT(int m) {
		buckets = new BucketEntry[m];
	}

	// ... OBHT methods here

	// hash function
	private int hash(Object k) {
		return Maths.abs(k.hashCode()) % buckets.length;
		// Math.abs returns a nonnegative int
		// % Modulo-m arithmetic then gives an integer in the range 0...m-1
	}

	/**
	* Subclass for obht entries
	*/
	private static class BucketEntry {

		// stores key and value
		private Object key;
		private Object value;

		// constructor
		private BucketEntry(Object key, Object value) {
			this.key = key;
			this.value = value;
		}

		// reference to FORMER
		private static final BucketEntry FORMER = new BucketEntry(null, null);
	}
}
```

### Example: Populating an OBHT

![anim obht population](http://i.imgur.com/JBNweQ2.gif)

### OBHT search

#### OBHT search algorithm

>To find which (if any) bucket of an OBHT is occupied by an entry whose key is equal to target-key:

>1. Set b to hash(target-key)
2. Repeat:
	1. If bucket b is never occupied:
		1. Terminate with answer none
	2. If bucket b is occupied by an entry whose key is equal to target-key:
		1. Terminate with answer b
	3. If bucket b is formerly occupied, or is occupied by an entry whose key is not equal to target-key
		1. Increment b modulo m

#### OBHT search animation

![anim obht search](http://i.imgur.com/fUp4Ik2.gif)

#### OBHT search Java method

``` java
// inside OBHT class

public int search(Object targetKey) {

	// 1.0 Set b to hash(target-key)
	int b = hash(targetKey);

	// 2.0 Repeat:
	for(;;) {

		BucketEntry old = buckets[b];

		// 2.1 If bucket b is never occupied:
		if(old == null) {

			// 2.1.1 Terminate with answer none
			return NONE;

		// 2.2 If bucket b is occupied by an entry is equal to target-key:
		} else if(old != BucketEntry.FORMER && targetKey.equals(old.key)) {

			//  2.2.1 Terminate with answer b
			return b;

		// 2.3 If bucket b is formerly occupied, or is occupied by an entry whose key is not equal to target-key
		} else {

			// 2.3.1 Increment b modulo m
			b = (b + 1) % buckets.length;
		}
	}
}
```

### OBHT insertion

#### OBHT insertion algorithm

>To insert the entry (key, val) into an OBHT:

>1. Set b to hash(key)
2. Repeat:
	1. If bucket b is never occupied:
		1. If bucket b is the last never occupied bucket, treat the OBHT as full
		2. Make bucket b occupied by (key, val)
		3. Terminate
	2. If bucket b is formerly occupied, or is occupied by an entry whose key is equal to to key:
		1. Make bucket b occupied by (key, val)
		2. Terminate
	3. If bucket b is occupied by an entry whose key is not equal to key:
		1. Increment b modulo m

#### OBHT insertion animation

![anim obht insertion](http://i.imgur.com/RKI0OtQ.gif)

#### OBHT insertion Java method

``` java
// inside OBHT class

// new variable, number of occupied or formerly occupied buckets in this OBHT
public int load = 0;

public void insert(Object key, Object val) {

	// make new BucketEntry with key, val
	BucketEntry newest = new BucketEntry(key, val);

	// 1.0 Set b to hash(key)
	int b = hash(key);

	// 2.0 Repeat:
	for(;;) {

		// create temp BucketEntry called old, set to buckets[b]
		// used to check state of BucketEntry
		BucketEntry old = buckets[b];

		// 2.1 If bucket b is never occupied:
		if(old == null) {

			// 2.1.1 If bucket b is the last never occupied bucket, treat the OBHT as full:
			if(++load == buckets.length) {

				// 2.1.2 Make bucket b occupied by (key, val)
				buckets[b] = newest;

				// 2.1.3 Terminate
				return;
			}

		// 2.2 If bucket b is formerly occupied, or is occupied by an entry whose key is equal to key:
		} else if(old == BucketEntry.FORMER || keys.equals(old.key)) {

			// 2.2.1 Make bucket b occupied by (key, val)
			buckets[b] = newest;

			// 2.2.3 Terminate
			return

		// 2.3 If bucket b is occupied by an entry whose key is not equal to key:
		} else {

			// 2.3.1 Increment b modulo m
			b = (b + 1) % buckets.length;
		}
	}
}
```

### OBHT deletion

#### OBHT deletion algorithm

>To delete the entry (if any) whose key is equal to key from an OBHT:

>1. Set b to hash(key)
2. Repeat:
	1. If bucket b is never occupied
		1. Terminate
	2. If bucket b is occupied by an entry whose key is equal to key:
		1. Make bucket b formerly occupied
		2. Terminate
	3. If bucket b is formerly occupied, or is occupied by an entry whose key is not equal to key:
		1. Increment b modulo m

#### OBHT deletion animation

![anim obht deletion](http://i.imgur.com/D4DyCrJ.gif)

#### OBHT deletion Java method

``` java
// inside OBHT class

public void delete(Object key) {

	// 1.0 Set b to hash(key)
	int b = hash(key);

	// 2.0 Repeat:
	for(;;) {

		// create temp BucketEntry called old, set to buckets[b]
		// used to check state of BucketEntry
		BucketEntry old = buckets[b];

		// 2.1 If bucket b is never occupied:
		if(old == null) {

			// 2.1.1 Terminate
			return;

		// 2.2 If bucket b is occupied by an entry whose key is equal to key:
		} else if (old != BucketEntry.FORMER && key.equals(old.key)) {

			// 2.2.1 Make bucket b formerly occupied
			buckets[b] =  BucketEntry.FORMER;

			// 2.2.2 Terminate
			return;

		// 2.3 If bucket b is formerly occupied, or is occupied by an entry whose key is not equal to key:
		} else {

			// 2.3.1 Increment b modulo m
			b = (b + 1) % buckets.length;
		}
	}
}
```

### OBHT analysis

- Analysis of OBHT search/insert/delete algorithm
	- Counting comparisons
	- Let n be the number of entries
- **Best case:**
	- No cluster contains more than (say) 4 entries
		- Max no. comparisons: 4
		- Best case time complexity: O(1)
- **Worst case:**
	- One cluster contains all n entries
		- Max no. comparisons: n
		- Worst case time complexity: O(n)

### OBHT design

- OBHT design consists of:
	1. Choosing the number of buckets m
	2. Choosing the hash function hash()
	3. Choosing the step length s
- Design aims:
	- Collisions should be infrequent
	- Entries should be distributed evenly over the hash table
		- Such that few clusters contain more than about 4 entries

#### OBHT choosing number of buckets

- **Load factor** of a hash table:
	- The average number of entries per bucket
	- n / m
- If n is (roughly) predictable, choose m such that the load factor is likely to be between 0.5 and 0.75
	- A low load factor wastes space
	- A high load factor tends to cause some buckets to have many entries
- Choose m to be a **prime number**
	- Typically the hash function performs **modulo-m** arithmetic
		- If m is prime, the entries are more likely to be **distributed evenly** over the buckets
			- Regardless of any patterns in the keys

#### OBHT choosing the hash function

- The hash function should be efficient
- THe hash function should distribute the entries evenly over the buckets, with few long clusters
	- In an OBHT with step length s = 1, a cluster will form when several entries fall into the same or **adjacent** buckets

#### OBHT choosing the step length

- To resolve a collision, the search/insert/delete algorithm increments the bucket index and tries again
- The **step length s** is the amount by which the bucket index is incremented
	- So far we have assumed **s = 1**
- Alternatively, we can use a fixed s (with s > 1)
- Once again, choose m to be a prime and choose s to be in the range 2...m-1
	- This ensures that s and m have no common factors
	- Otherwise, if (say) m = 10 and s = 2, a typical search path would be 6-8-0-2-4, never reaching the remaining buckets!

### OBHT double hashing

- To search/insert/delete key k, compute s from k using a second hash function s = step(k)
	- Better to let different keys have different step lengths
	- And each key always has the same step length
- In the following illustration, keys are names of chemical elements
	- Assume:
		- m = 23
		- hash(e) = (initial letter of e - 'A') modulo m
		- step(e) = 1, if e has a single letter, else (2 + (second letter of e - 'a') modulo 21) modulo 23

#### OBHT double hashing algorithm

>To insert the entry (key, val) into an OBHT:

>1. Set b to hash(key), and set s to step(key)
2. Repeat:
	1. If bucket b is never occupied:
		1. If bucket b is the last never occupied bucket
			1. Expand the number of buckets
			2. Repeat from Step 1
		2. Make bucket b occupied by (key, val)
		3. Terminate
	2. If bucket b is formerly occupied, or is occupied by an entry whose key is equal to key:
		1. Make bucket b occupied by (key, val)
		2. Terminate
	3. If bucket b is occupied by an entry whose key is not equal to key:
		1. Increment b by s, modulo m

#### OBHT double hashing animation

![anim obht doublehash](http://i.imgur.com/q5XkLt5.gif)


## Study guide

- Reading:
	- Chapter 12: Java Collections
	- Chapter 9: Data Structures and Algorithms in Java
