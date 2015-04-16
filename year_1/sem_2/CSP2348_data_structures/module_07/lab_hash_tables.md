# Tutorial 07: Hash table data structures

## Tasks

### Task 1

Consider a CBHT in which the keys are student identifiers (string of 6 digits). Assume the following number of buckets and hash function:

>m = 100; hash(id) = first two digits of id

#### Answer:

``` java
private int hash(Object key) {

	// key.hashCode() = first two digits of id
	// buckets.length = m = 100
	return Math.abs(key.hashCode()) % buckets.length;
}
```

#### 1.1

Starting with an empty hash table, show the effect of successively adding the following student identifiers:

```
000014
990021
990019
970036
000015
970012
970023
```

##### Answer:

```
hash(00) = 0
hash(99) = 99
hash(97) = 97

HASH:	LIST:
00		000015 => 000014
..		...
97		970023 => 970012 => 970036
..		...
99		990019 => 990021
```

**Note:** CBHT with linked-list for each bucket performs insertFirst() at each insert collision.

#### 1.2

What is the average number of comparisons when the resulting hash table is searched for each of these keys?

##### Answer:

| ID     | Comparisons |
|--------|-------------|
| 000014 | 2           |
| 990021 | 2           |
| 990019 | 1           |
| 970036 | 3           |
| 000015 | 1           |
| 970012 | 2           |
| 970023 | 1           |

(2 + 2 + 1 + 3 + 1 + 2 + 1) / 7 &asymp; 1.71

#### 1.3

Show the effect of deleting `000014` from the hash table.

##### Answer:

```
HASH:	LIST:
00		000015
..		...
97		970023 => 970012 => 970036
..		...
99		990019 => 990021
```

#### 1.4

Discuss whether the given hash function is a right choice or not.

##### Answer:

Given the range of possible IDs, the hash function will potentially produce 10<sup>4</sup> collisions.

Load factor = n / m  
= 100000 / 100  
= 1000

Hash function is not suitable.

### Task 2

Repeat Task 1 with an OBHT with double hashing, with the following second hash function:

>step(id) = last digit of id

#### Answer:

``` java
private int step(Object key) {

	// key.hashCode() = last digits of id
	// buckets.length = m = 100
	return Math.abs(key.hashCode()) % buckets.length;
}
```

```
000014 | hash(00) = 00 | step(4) = 4
990021 | hash(99) = 99 | step(1) = 1
990019 | hash(99) = 99 | step(9) = 9
970036 | hash(97) = 97 | step(6) = 6
000015 | hash(00) = 00 | step(5) = 5
970012 | hash(97) = 97 | step(2) = 2
970023 | hash(97) = 97 | step(3) = 3
```

```
HASH:	ID:			STEPS:			FROM:
000		000014		no coll			n/a
001		970012		2 * 2 steps		097
002
003		970023		2 * 3 steps		097
004
005		000015		5 steps			000
006
007
008		990019		9 steps			099
009
010
...		......		.......			...
097		970036		no coll			n/a
098
099		990021		no coll			n/a
```

#### OBHT double hashing notes

- `step()` function not called if no collision
- Hash table wraps around from tail to head
- If `step()` collides, perform `step()` again
	- See "2 * 2 steps" or "2 * 3 steps" above

### Task 3

Test the Java program WS0601.

``` java
public class WS0701 {

	private static final int MASK = 0x7FFFFFFF; // 2^32-1
	private static final int CAPACITY = 11;

	public static void main(String[] args) {
		printHash("Rad");
		printHash("Uhr");
		printHash("Ohr");
		printHash("Tor");
		printHash("Hut");
		printHash("Tag");
	}

	private static void printHash(String word) {
		System.out.println("hash(" + word + ") = " + hash(word));
	}

	private static int hash(Object object) {
		return (object.hashCode() & MASK) % CAPACITY;
	}
}
```

#### 3.1

Analyze the hash function given in the program.

##### Answer:

The hash function `hash(Object object)` calculates the hash with statement:

``` java
return (object.hashCode() & MASK) % CAPACITY
```

`MASK = 0x7FFFFFFF` or 2147483647<sub>10</sub>  
`CAPACITY = 11`

The `&` removes the sign from whatever integer `object.hashCode()` returns. Therefore, the resulting value returned by `hash()` will always be between 0 and 10.

#### 3.2

Execute this program.

#### Results:

Results:

```
hash(Rad) = 3
hash(Uhr) = 4
hash(Ohr) = 2
hash(Tor) = 8
hash(Hut) = 5
hash(Tag) = 3
```

#### 3.3

Draw sketches of the OBHT and CBHT to show the executed results. Draw the search path as well if any collision occurs.

##### Answer:

###### OBHT

```
HASH:	ID:
00
01
02		Ohr
03		Tag => Rad
04		Uhr
05		Hut
06
07
08		Tor
09
10
```

###### CBHT

```
HASH:	ID:		SearchPath:
00
01
02		Ohr
03		Rad		1
04		Uhr		2
05		Hut		3
06		Tag		4
07
08		Tor
09
10
```

### Task 4

Test the Java program WS0602.

``` java
public class WS0702 {

	private static final int MASK = 0x7FFFFFFF; // 2^32-1
	private static final int CAPACITY = 101;

	public static void main(String[] args) {
		printHash("Rad");
		printHash("Uhr");
		printHash("Ohr");
		printHash("Tor");
		printHash("Hut");
		printHash("Tag");
	}

	private static void printHash(String word) {
		System.out.println("hash(" + word + ") = " + hash(word));
	}

	private static int hash(Object object) {
		return (object.hashCode() & MASK) % CAPACITY;
	}
}
```

#### 4.1

Execute this program.

##### Results:

```
hash(Rad) = 99
hash(Uhr) = 82
hash(Ohr) = 73
hash(Tor) = 45
hash(Hut) = 13
hash(Tag) = 4
```

#### 4.2

Discuss why no collision occurred in this program.

##### Answer:

`CAPACITY` has been raised to a higher prime number, 101. This reduces the possibility of collision occurring.
