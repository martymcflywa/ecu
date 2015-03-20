# Arrays merging algorithm

**Problem:**

Given two **sorted** arrays, make a third sorted array containing copies of all components of the two original arrays.

![a1 + a2 = a3](http://snag.gy/ozfKf.jpg)

## Algorithm

>To merge a1[l1...r1] and a2[l2...r2] into a3[l3...r3], where a1 and a2 are sorted:

>1. Set i = l1, set j = l2, set k = l3
2. While i &le; r1 and j &le; r2, repeat:
	1. If a1[i] &le; a2[j]:
		- Copy a1[i] into a3[k], then increment i and k
	2. If a1[i] > a2[j]:
		- Copy a2[j] into a3[k], then increment j and k
3. If i &le; r1, copy a1[i...r1] into a3[k...r3]
4. If j &le; r2, copy a2[j...r2] int a3[k...r3]
5. Terminate

## Loop invariant

![array merge loop invariant](http://snag.gy/9aFIl.jpg)

## Animation

![array merge anim](http://i.imgur.com/3RGF96T.gif)

## Java implementation

``` java
void merge(Comparable[] a1, int l1, int r1, Comparable[] a2, int l2, int r2, Comparable[] a3, int l3) {
	// merge existing a1[l1...r1] and existing a2[l2...r2]
	// into existing a3[l3...], where a1 and a2 are sorted
	int i = l1, j = l2, k = l3;
	while(i <= r1 && j <= r2) {
		int comp = a1[i].compareTo(a2[j]);
		if(comp <= 0) {
			a3[k++] = a1[i++];
		} else {
			a3[k++] = a2[j++];
		}
	}
	while(i <= r1) {
		a3[k++] = a1[i++];
	}
	while(j <= r2) {
		a3[k++] = a2[j++];
	}
}
```

## Analysis

### Counting number of copies

- Let n<sub>1</sub> and n<sub>2</sub> be the lengths of a1 and a2
	- Then set n = n<sub>1</sub> + n<sub>2</sub>
- Each component of a1 is copied once, and each component of a2 is copied once
- Number of copies = n<sub>1</sub> + n<sub>2</sub> = n
- &rArr; Time complexity is O(n)

### Counting comparisons

- Assume that Steps 2.1 to 2.2 perform a single comparison
	- ie. If-then-else
	- Steps 2.1 to 2.2 are repeated at most n-1 times
- Maximum number of comparisons = n-1
- &rArr; Time complexity is O(n)

### Overall complexity

>max{O(n), O(n)}  
= O(n)
