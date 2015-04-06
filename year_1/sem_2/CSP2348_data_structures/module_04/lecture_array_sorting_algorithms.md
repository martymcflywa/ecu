# Array sorting algorithms

## Remedial maths for sorting algorithm analysis

### Summation of simple arithmetic series

- An **arithmetic series** is a sequence of numbers with a fixed difference between consecutive numbers, for example

>1, 2, 3, 4, 5  
2, 4, 6, 8, 10, 12, 14, 16, 18

- Special case: **Simple arithmetic series**

>1, 2, 3, ..., n-2, n-1, n

>**Question:** What is the summation, S = 1 + 2 + 3 + ..., + n?

Calculate 2\*S, we have 2\*S = n * (n + 1)

or:

![s=](http://i.cubeupload.com/KtZIf5.png)

- General case:

>S = (total num of values) * (sum of the two ends) / 2

![s block](http://snag.gy/Mo8lO.jpg)

#### Example 1

- Sum the series 1, 2, 3, ..., 10
- Let n = 10, we have

>S = n(n + 1) / 2  
= 10 \* (10 + 1) / 2  
= 10 \* 11 / 2 = 55

#### Example 2

- Sum the series 2, 4, 6, ..., 18
- Let n = 18

>S = 2 + 4 + 6 + ... + 16 + 18  
= n(n + 2) / 2  
= 9 \* (18 + 2) / 2  
= 9 \* 20 / 2  
= 90

- Or alternatively

>S = 2 + 4 + 6 + ... + 16 + 18  
= 2 \* (1 + 2 + 3 ... + 8 + 9)  
= 2(n(n + 1) / 2)  
= 2 \* (9 \* (9 + 1) / 2)  
= 2 \* (9 \* 10 / 2)  
= 2 \* 45  
= 90

## Sorting algorithms using arrays

- **Problem:**
	- Given an (unsorted) array of data, rearrange the data into certain ascending / descending order
- Sorting is an important operation because sorted data can be searched and merged efficiently
- Choice of sorting algorithms
	- Selection sort
	- Insertion sort
	- Merge sort
	- Quick sort
	- Bubble sort
	- Shell sort
	- Radix sort
	- See textbook

### Why sorting

- Sorted data can be searched efficiently
	- Using binary search algorithm
- As a data preprocessing step in many applications
	- Award winners selection
		- Top 10 marks of semester results in a student class
	- Median price
		- Value that sits in the middle range of all values
			- One half are greater than or equal to
			- Other half are less than or equal to
		- Australian real estate market indicator
			- Perth metro house price $540,000
			- Perth quarterly median value of selling prices among 299 suburbs
		- How difficult to calculate median without sorting the price data?

### Elementary sorting techniques

#### Selection sort

- **Idea:**
	- Find the least value in the array
	- Swap it into the leftmost component
	- Forget the leftmost component
	- Repeat for rest of array

**Loop invariant:**

![loop invariant](http://snag.gy/QcLnk.jpg)

>To sort a[left...right] into ascending order:

>1. For l = left, ..., right-1, repeat:
	1. Set p such that a[p] is the least of a[l...right]
	2. If p &ne; l, swap a[p] and a[l]
2. Terminate

>**Note** Step 1.1 can be implemented using an algorithm similar to the *linear* search algorithm ie. Search the least value in array a[l...right]

- Implementation of Step 1.1
	- Linear search of the least value in array a[l... right]
		- Initially, take the first component as the **least**
		- Loop: if the current array component is less than the current **least**, replace the **least** with the current array component, and record the current position of the new **least** in the array
- The algorithm part for Step 1.1 in pseudo-code:

```
least = a[l]; p = l;
for k = l + 1, ..., right, repeat:
	if(a[k] < least) {least = a[k]; p = k;}
terminate with p
```

- Total number of comparisons: right - l

![select sort anim](http://i.imgur.com/6PAZhC7.gif)

#### Selection sort demo

- The array [2, 5, 1, 3, 4] sorted by selection sort

![select sort demo](http://i.imgur.com/u6aU2wi.gif)

##### Analysis

- Counting comparisons
- Let n = right - left + 1 be the length of the array
- Step 1.1 performs (right - l) comparisons
- This is repeated with l = left, ..., right - 2, right - 1
- No. of comparisons:

>= (right - left) + ... + 2 + 1  
= (n - 1) + ... + 2 + 1  
= (n - 1)(1 + (n - 1)) / 2  
= (n - 1)n / 2  
= (n<sup>2</sup> - n) / 2

- Time complexity: O(n<sup>2</sup>)

##### Implementation in Java

``` java
static void selectionSort(Comparable[] a, int left, int right) {
	// sort a[left...right] into ascending order
	for(int l = left; l < right; l++) {
		int p = 1;
		Comparable least = a[p];
		for(int k = l + 1; k <= right; k++) {
			int comp = a[k].compareTo(least);
			if(comp < 0) {
				p = k;
				least = a[p];
			}
		}
		if(p != 1) {
			a[p] = a[l];
			a[l] = least;
		}
	}
}
```

#### Insertion sort

- Idea
	- Successively read each value and insert it into its correct position in the sorted part of the array
	- Use the same idea to sort an array of values in place

**Loop invariant:**

![loop invariant](http://snag.gy/9swVF.jpg)

>To sort a[left...right] into ascending order:

>1. For r = left + 1, ..., right, repeat:
	1. Let val = a[r]
	2. Insert val into its correct sorted position in a[left...r]
2. Terminate

- Step 1.2 can be implemented using a combination of array search and insert algorithm to insert val into the already sorted sub-array a[left...r-l]
	- If val is the greatest, no insertion is needed

![insert sort](http://i.imgur.com/vGYqi83.gif)

**The array [2, 5, 1, 3, 4] sorted by insertion sort:**

![anim insert sort demo](http://i.imgur.com/r2WrZ3C.gif)

##### Analysis

- Counting comparisons
- Let n = right - left + 1 be the length of the array
- Step 1.2 performs between 1 and (r - left) comparisons
	- Say (r - left + 1) / 2 comparisons on average
- This is repeated with r = left + 1, left + 2, ..., right
- Average no. of comparisons:

>= 2 / 2 + 3 / 2 + ... + n / 2  
= (2 + 3 + 4 + ... + n) / 2  
= (n - 1)(n + 2) / 4  
= (n<sup>2</sup> + n - 2) / 4

- Time complexity: O(n<sup>2</sup>)

### Efficient sorting techniques

#### Merge sort

- Idea
	- Divide-and-sort-and-merge
	- Divide the array into two subarrays of about equal length
	- Sort the two subarrays separately
	- Merge the sorted subarrays
- This is an application of the **divide-and-conquer** strategy
	- To solve a hard problem
		- Break the problem down into two or more "easier" sub-problems
		- Solve these sub-problems separately
		- Combine their answers
	- The divide-and-conquer strategy is effective for solving many problems

>To sort a[left...right] into ascending order:

>1. If left < right:
	1. Let m be an integer about midway between left and right
	2. Sort a[left...m] into ascending order
	3. Sort a[m + 1...right] into ascending order
	4. Merge a[left...m] and a[m + 1...right] into auxiliary array b
	5. Copy all components of b into a[left...right]
2. Terminate

![merge sort anim](http://i.imgur.com/Wwo3JQl.gif)

#### Merge sort demo

![merge sort demo](http://i.imgur.com/XSx7qRA.gif)

##### Recursive strategy

- Merge sort is a **recursive** algorithm
	- ie. The algorithm calls itself inside the body of the algorithm
- Step 1.1 and Step 1.2 both use the same idea of merge-sort to sort these smaller subarrays
- For recursive algorithm, we must consider the **exit** condition (or **easy** case) and the **recursive** condition (or hard case) for recursion
	- **Easy case:** No more sorting to do at all
		- ie. left &ge; right
	- **Hard case:** At least two values to be sorted
		- ie. left < right

##### Analysis

- Counting comparisons
- Left n = right - left + 1 be the length of the array
- Let the total no. of comparisons required to sort n values be C(n)
	- The left subarray's length is about n/2, so step 1.2 takes about C(n/2) comparisons to sort
	- Similary, Step 1.3 takes about C(n/2) comparisons to sort the right array
	- Step 1.4 takes about n - 1 comparisons to merge the subarrays
- Therefore:

![merge sort C(n) 1](http://i.imgur.com/OT9JgYB.png)

>C(n)  
= 2C(n / 2) + n - 1  
= 2(2C(n / 4) + n / 2 - 1) + n - 1  
= 4C(n / 4) + 2 * n - 3  
= 4(2C(n / 8) + n / 4 - 1) + 2n - 3  
= 8C(n / 8) + 3 * n - 7  
...
Let's assume that n = 2<sup>i</sup>  
= 2<sup>i</sup>C(n / 2<sup>i</sup>) + i * n - (2<sup>i</sup> - 1)  
= 2<sup>i</sup> * 1 + i * n - 2<sup>i</sup> + 1  
= n * 1 + log(n) * n - n + 1  
= O(n * log(n))

From the formula:

![merge sort C(n) 2](http://i.imgur.com/thaVA3o.png)

We can get:

>C(n) &asymp; n log<sub>2</sub>n

And time complexity is O(n log n).

**Space** complexity is O(n), since Step 1.4 needs an auxiliary array of length n.

##### Why does C(n) = O(n log n)

Consider a special case: n = 2<sup>k</sup> (for some k), or k = log<sub>2</sub>n. Then:

###### 1:

![C(n) equation](http://i.imgur.com/ftEbrCf.png)

###### 2:

>If n &ne; 2<sup>k</sup>, let 2<sup>k-1</sup> &le; n < 2<sup>k</sup> for some k.

>Then k-1 &le; log<sub>2</sub>(n) < k.

>Follow similar proof, we have O(n * log<sub>2</sub>(n)) &le; C(n) &le; O(n * log<sub>2</sub>(n)).

>Which also leads to C(n) &rArr; O(n * log<sub>2</sub>(n))

#### Quick sort

- Idea
	- Choose any value from the array
		- Called the **pivot**
	- And then **partition** the array into three subarrays such that:
		- The left subarray contains only values less than or equal to the pivot
		- The middle subarray contains the pivot only
		- The right subarray contains only values greater than or equal to the pivot
	- Finally sort the left subarray and right subarray separately, leading to the whole array sorted
- This is another application of the divide-and-conquer strategy

>To sort a[left...right] into ascending order:

>1. If left < right:
	1. Partition a[left...right] such that
		1. a[left...p - 1] are less than or equal to a[p]
		2. a[p + 1...right] are all greater than or equal to a[p]
	2. Sort a[left...p - 1] into ascending order
	3. Sort a[p + 1...right] into ascending order
2. Terminate

**Invariants:**

![quick sort invariants](http://snag.gy/ZgxpK.jpg)

![quick sort anim](http://i.imgur.com/S1IMTgH.gif)

##### Analysis

- Counting comparisons
- Let n be the number of values to be sorted, and the total number of comparisons required to sort n values be C(n)
- Step 1.1 takes about n - 1 comparisons to partition the array (not sort!)

###### Best case

- In the **best case**, the pivot turns out to be the median value in the array
	- So left and right subarrays both have length about n / 2
	- Then Steps 1.2 and 1.3 take about C(n / 2) comparisons each
- Therefore:

![quick sort worst case C(n)](http://i.imgur.com/OT9JgYB.png)

- Solution: C(n) = n log<sub>2</sub>n
- Therefore, best-case time complexity is O(n log n)

###### Worst case

- In the **worst case**, the pivot turns out to be the minimum/maximum value
- So the right/left subarray has length n - 1, whilst the other subarray has length 0
- Then Step 1.3 performs C(n - 1) comparisons, but Step 1.2 does nothing at all

In such a case:

![quick sort worst case C(n)](http://i.imgur.com/FvUxgel.png)

Thus:

![quick sort worst case formula](http://i.imgur.com/4ZISKio.png)

- Worst case time complexity is O(n<sup>2</sup>)
- The worst case arises if the array is already sorted!

##### Implementation in Java

``` java
static void quickSort(Comparable[] a, int left, int right) {
	// sort a[left...right] into ascending order
	if(left < right) {
		int p = partition(a, left, right);
		quickSort(a, left, p - 1);
		quickSort(a, p + 1, right);
	}
}
```

##### Partitioning algorithm

>To partition a[left...right] such that a[left...p-1] are all less than or equal to a[p], and a[p + 1...right] are all greater than or equal to a[p]:

>1. Let pivot be the value of a[left], and set p = left
2. For r = left + 1, ..., right, repeat:
	1. If a[r] is less than pivot:
		1. Copy a[r] into a[p], a[p + 1] into a[r], and pivot into a[p + 1]
		2. Increment p
3. Terminate with answer p

- Note that other and better partitioning algorithms exist

**Loop invariant:**

![partition invariant](http://snag.gy/CMw1W.jpg)

##### Implementation in Java

``` java
static int partition(Comparable[] a, int left, int right) {
	// partition a[left...right] such that
	// a[left...p-1] are all less than or equal to a[p] and
	// a[p+1...right] are all greater than or equal to a[p]
	// return p
	Comparable pivot = a[left];
	int p = left;
	for(int r = left + 1; r <= right; r++) {
		int comp = a[r].compareTo(pivot);
		if(comp < 0) {
			a[p] = a[r];
			a[r] = a[p + 1];
			a[p + 1] = pivot;
			p++;
		}
	}
	return p;
}
```

### Comparison of sorting algorithms

![compare table](http://snag.gy/JzAZO.jpg)

## Guide

- Reading
	- Java Collections
		- Chapter 3
		- Appendix A4
	- Data Structures & Algorithms
		- Section 3.1.2
		- Section 8.2.2
		- Section 11.1
		- Section 11.2
