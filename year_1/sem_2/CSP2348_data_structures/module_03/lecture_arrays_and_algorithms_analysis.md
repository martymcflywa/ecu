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

1. For p = left, ..., right, repeat:
	1. If target equals a[p], terminate with answer p
2. Else terminate with answer none

Loop invariant:

![loop invariant](http://snag.gy/jKAbj.jpg)

#### Successful linear search

![successful linear search](http://i.imgur.com/QQcyoC0.gif)

#### Unsuccessful linear search

![unsuccessful linear search](http://i.imgur.com/Iy96Pyw.gif)

#### Analysis: Counting comparisons

- Let n = right - left + 1 be the length of the array
- If the search is **successful**, step 1.1 is repeated between 1 and n times
	- Average number of comparisons = (n + 1) / 2
- If the search is **unsuccessful**, step 1.1 is repeated n times
	- Number of comparisons = n
- In both cases, time complexity is O(n)

#### Implementation in Java

``` java
int linearSearch(Object target, Object[] a, int left, int right) {
	// Find target in a[left ... right]
	for(int p = left; p <= right; p++) {
		if(target.equals(a[p])) {
			return p;
		}
	}
	return -1;
}
```

#### Linear search in sorted array

If the (sub)array is known to be sorted, linear search can be speeded up in the unsuccessful case:

To find which (if any) component of the sorted (sub)array a[left ... right] equals target:

1. For p  = left, ..., right, repeat:
	1. If target equals a[p], terminate with answer p
	2. **If target is less than a[p], terminate with answer none**
2. Terminate with answer none

However, time complexity does not improve much. Why?

- Because still have to iterate?

### Binary search

- **Only** applies to cases where the (sub)array is sorted
- **Idea:** Mimic searching a target word from a dictionary
	- **Bad dea:** Look at page 1, then page 2, etc until you find the page containing the target word
		- That is **linear** search!
	- **Better idea:** Choose a page near the middle
		- If the target word happens to be on that middle page, we're finished
		- If the target word is less/greater than the words on that middle page, focus on the pages before/after that middle page and repeat
		- That is **binary search**
			- ie. Each round of searches divides the search space in two halves and removes one from consideration

To find which (if any) component of the sorted (sub)array a[left ... right] equals target:

1. Set l = left, r = right
2. While l &le; r, repeat:
	1. Let m be an integer about halfway between l and r
	2. If target equals a[m], terminate with answer m
	3. If target is less than a[m], set r = m - 1
	4. If target is greater than a[m], set l = m + 1
3. Terminate with answer none

![binary search](http://snag.gy/3lQqG.jpg)

#### How to calculate middle index m

>m = (l + r) / 2, discarding any remainder  
ie. floor((l + r) / 2)

#### Loop invariant

![loop invariant](http://snag.gy/XagzE.jpg)

#### Successful binary search

![successful binary search](http://i.imgur.com/GsH8gL9.gif)

#### Unsuccessful binary search

![unsuccessful binary search](http://i.imgur.com/4urQWAl.gif)

#### Analysis: Counting comparisons

- Let n be the length of the array
- Assume that steps 2.2~2.4 perform a single (successful) comparison
- If the search is **unsuccessful**, these steps are repeated as often as we must halve n to reach 0:
	- Number of comparisons = floor(log<sub>2</sub>n) + 1
- If the search is **successful**, these steps are repeated at most that many times
	- Maximum number of comparisons = floor(log<sub>2</sub>n) + 1
- In both cases, the time complexity is O(log<sub>2</sub>n)

#### Implementation in Java

``` java
int binarySearch(Comparable target, Comparable[] a, int left, int right) {
	// Find target in (sub)array a[left ... right]
	int l = left, r = right;
	while(l <= r) {
		int m = (l + r) / 2;
		int comp = target.compareTo(a[m]);
		if(comp == 0) {
			return m;
		} else if(comp < 0) {
			r = m -1;
		} else {
			l = m + 1
		}
	}
	return -1;
}
```

### Comparison of search algorithms

![comparison of search algorithms](http://snag.gy/YsOK8.jpg)

### Comparison of time complexity

![comparison of time complexity](http://snag.gy/saSGo.jpg)

## Alternative ways of exercise

If an algorithm is given in Java-like pseudocode (or any other programming language), the algorithm's time complexity may be measured by counting the number of primitive operations, or statements to be executed.

### Example 1

The `ascending()` method determines whether the array's elements are in the ascending order with/without uniqueness. A `descending()` method can be similarly defined.

![ascending](http://snag.gy/BtIz6.jpg)

### Example 2

The `equal()` method determines whether two arrays are equal. Calculating the `equal()` method complexity.

![equal](http://snag.gy/R6E3U.jpg)

### Example 3

The `binarySearch()` method searches for a target in an ordered (ascending) array. Returns its position or -1 if not found.

![binarysearch](http://snag.gy/Kuift.jpg)

### Example 4

The `searchLinear()` method determines whether a target value, item, is present in the array, which is assumed to be in ascending order. The int result is the item's position/index with respect to the array's values, or -1 if not found.

![searchlinear](http://snag.gy/TUAey.jpg)

## Pseudocode

Used to express algorithm's key instructions.

- Control flow
	- If... then... [else...]
	- For... repeat
	- While... repeat
- Algorithm/method declaration
	- Algorithm method_name(arg[, arg...])
		- Input and output...
- Algorithm/method call
- Return value
- Other statements
	- Assignment
		- Like = in Java
	- Comparison/testing
		- Like == in Java
	- Natural language statement, etc.
- Detailed definition not important

## Guide

- Reading
	- Java Collections
		- Sections 3.1 - 3.5
		- Appendix A4
	- Data Structures & Algorithm in Java
		- Sections 1.5 & 3.1
