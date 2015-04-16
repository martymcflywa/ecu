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

>step(id) = last digits of id

#### Answer:

``` java
private int step(Object key) {

	// key.hashCode() = last digits of id
	// buckets.length = m = 100
	return Math.abs(key.hashCode()) % buckets.length;
}
```

```
000014 | hash(00) = 00 | step() not required
990021 | hash(99) = 99 | step() not required
990019 | hash(99) = 99 | step(9) = 9
970036 | hash(97) = 97 | step() not required
000015 | hash(00) = 00 | step(5) = 5
970012 | hash(97) = 97 | step(2) = 2
970023 | hash(97) = 97 | step(3) = 3
```

```
HASH:	ID:
000		000014
001		970023 (3rd step from 097 + 2, since 100 and 000 already occupied)
002
003
004
005		000015 (5th step from 000)
006
007		990019 (9th step from 099)
008
...		......
097		970036
098
099		990021
100		970012 (2nd step from 097 + 1, since 099 already occupied)
```

### Task 3

Test the Java program WS0601.

#### 3.1

Analyse the hash function given in the program.

#### 3.2

Execute this program.

#### 3.3

Draw sketchges of the OBHT and CBHT to show the executed results. Draw the search path as well if any collision occurs.

### Task 4

Test the Java program WS0602.

#### 4.1

Execute this program.

#### 4.2

Discuss why no collision occurred in this program.
