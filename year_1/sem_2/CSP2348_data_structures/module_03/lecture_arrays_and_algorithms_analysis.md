# Arrays and algorithms analysis

## Arrays and subarrays

### Properties of arrays in general

- An array is a sequence of indexed components
- Each array component has a fixed, unique index
	- The indices range from a **lower bound** to an **upper bound**

![array properties](http://snag.gy/Sv5S9.jpg)

- Any array component can be efficiently accessed using its index, in O(1) time
	- ie. Inspected or updated
- The `length` of the array is fixed when the array is constructed
	- ie. A static data structure

### Properties of arrays in Java

- A Java array's components are either values of some stated primitive type, or objects of some stated class
- A Java array of length n has
	- An int lower bound of 0
	- An into upper bound of n-1
	- Thus the index type is int
- A Java array is itself an object
	- It is allocated dynamically by `new T[n]`
		- Where T is the data type of its components

![java array](http://snag.gy/cib5G.jpg)

### Examples

#### Java primitive array

- Java code to create, initialize and inspect an array of integers

``` java
int[] primes = {2, 3, 5, 7, 11, 13};
for(int i = 0; i < primes.length; i++) {
	System.out.println(primes[i]);
}
```

![java primitive array](http://snag.gy/Rmm3c.jpg)

#### Java object array

- Suppose that a `Date` object has fields `y`, `m`, and `d`
- The code to create an array of `Date` objects:

```java
Date[] hols = new Date[3];
```

![create date array](http://snag.gy/sY7jK.jpg)

- Java code to update the array of `Date` objects

``` java
hols[0] = new Date(2011, 7, 1);
hols[1] = new Date(2013, 12, 14);
hols[2] = new Date(2015, 2, 25);
```

![update date array](http://snag.gy/VaXUY.jpg)

### Subarrays

- A **subarray** is a sequence of consecutive components that forms a part of a larger array
- Notation a[l...r]:
	- The subarray consisting of components a[l], a[l+1], ... a[r] (note that l &le; r)
	- Subarray notation is used here for demonstrative purpose, but is **not** supported by Java

![subarray](http://snag.gy/4TL9Q.jpg)

### Sorted arrays

- An array/subarray is **sorted** if its components are in ascending or descending order
	- ie. Each component is less or greater than or equal to the component on its right-hand side
- The meaning of "x is **less**/**greater** than y" must be defined for each data type
	- ie. Meaning of **less** for numbers
		- x is numerically less that y
			- x < y
	- ie. Conventional meaning of **less** for strings
		- x precedes y lexicographically
			- "bat" is less than "bath"
				- In turn is less than "bay"

### Interface `java.util.Comparable`

- Java provides:

``` java
public interface Comparable {
	public int compareTo(Object that);
	// Returns negative int if 'this < that'
	// or zero if 'this == that'
	// or positive int if 'this > that'
}
```

- The `compareTo` method captures the notions of **less than**, **equal to**, and **greater than** for objects
- If a class implements `Comparable`, it must implement `compareTo` in accordance with this **contract**

## Array insertion and deletion

### Insertion

**Problem:** Given a (sub)array a[left ... right], insert a value val at a[ins]. If necessary, shift values right to make way for it.

![insert](http://i.imgur.com/JZfQR8V.gif)

#### Analysis: Counting copies

- Let n = right - left + 1 be the length of the array
- Step 1 performs between 0 and n-1 copies
	- Say (n - 1) / 2 copies on average

![average](http://snag.gy/31r68.jpg)

- Step 2 performs 1 copy
- Average number of copies = (n - 1) / 2 + 1 = n / 2 + <sup>1</sup>/<sub>2</sub>
- Time complexity is O(n)

### Deletion

**Problem:** Given a (sub)array a[left ... right], delete the value from a[del]. If necessary, shift values left to fill the gap (assume that left &le; del &le; right).

![deletion](http://i.imgur.com/nKPNSMa.gif)

#### Analysis: Counting copies

- Let n = right - left + 1 be the length of the array
- Step 1 performs between 0 and n-1 copies
- Step 2 takes constant time
	- ie. O(1) time
- Average number of copies = (n - 1) / 2 = n / 2 - <sup>1</sup>/<sub>2</sub>
- Time complexity is O(n)

## Array searching: linear and binary search

**Problem:** Given a (sub)array a[left ... right], find which (if any) component equals a given target value.

- Choice of algorithms
	- **Linear search:**
		- Unsorted or sorted array
	- **Binary search:**
		- Sorted array only
- An **invariant** is a logical statement that always holds at a particular step/s in an algorithm or program
- A **loop invariant** is an invariant that holds at every iteration of a loop
- Invariants can be expressed:
	- In logical notation
		- ie. 0 &le; i < n
	- Or as a schematic diagram

### Linear search

**Linear search algorithm:** To find which (if any) component of a[left ... right] equals target:

1. For p = left, ..., right, repeat
	1. If target equals a[p], terminate with answer p
2. Else terminate with answer none

Loop invariant:

![loop invariant](http://snag.gy/jKAbj.jpg)

#### Successful linear search

![successful linear search](http://i.imgur.com/QQcyoC0.gif)

#### Unsuccessful linear search

![unsuccessful linear search](http://i.imgur.com/Iy96Pyw.gif)

## Guide
