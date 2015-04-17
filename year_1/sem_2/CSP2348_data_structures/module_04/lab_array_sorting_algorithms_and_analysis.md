# Array sorting algorithms and analysis

## Task 1

Consider the problem of reading a file of unsorted values into an array where the array must be sorted. There are n values in the file.

1. Write an algorithm to read all of the unsorted values into the array, and then sort the array using the selection sort algorithm. What is the time efficiency of your algorithm?
2. Write an algorithm to read each value in turn, and insert it into a sorted array, which is initially empty. What is the time efficiency of your algorithm? How does this compare with your answer to part 1?

### 1:

>To read values from the unsorted file f into a sorted array a[0...]:

>1. Set m to 0
2. While not at end of file f, repeat:
	1. Read value val from f
	2. Store val into a[m]
	3. Increment m
3. Sort a[0...m-1] using selection sort algorithm
4. Terminate

#### Analysis:

- Step 2 performs 0 comparisons
- Step 3 uses selection sort to sort the array a[]
	- It performs about n<sup>2</sup> / 2 comparisons
	- Therefore this algorithm performs about n<sup>2</sup> / 2 comparisons

### 2:

>To read values from the unsorted file f into a sorted array a[0...]:

>1. Set m to 0
2. While not at the end of file f, repeat:
	1. Read value val from f
	2. Insert val in the sorted array a[0...m-1]
	3. Increment m
3. Terminate

#### Analysis:

- Step 2.2 would use the array insertion algorithm
	- This performs about m / 2 comparisons
	- Since m ranges from 0 to n - 1, the total number of comparisons is
		- 0 + 1 / 2 + ... + (n - 1) / 2
		- = n(n - 1) / 4
		- &asymp; n<sup>2</sup> / 4
	- Both methods have time complexity O(n<sup>2</sup>)

## Task 2

You are given two unsorted arrays of values. You are required to obtain a sorted array containing all these values. Suggest two different ways of achieving this. Compare their time efficiency.

Note: Assume that suitable merging and sorting algorithms are already available.

### Version 1

- Let
	- n1 = right1 - left1 + 1
	- n2 = right2 - left2 + 1
	- n = n1 + n2

>Copy all values from arrays a1[left1...right1] and a2[left2...right2] into an array a3[0...n - 1], and then sort array a3[0...n - 1] using an available array sorting algorithm:

>1. Copy a1[left1...right1] to a3[0...n1 - 1]
2. Copy a2[left2...right2] to a3[n1...n - 1]
3. Sort a3[0...n - 1]
4. Terminate

#### Analysis

- Step 1 and 2 perform 0 comparisons
- If Step 3 uses selection sort, it performs about n<sup>2</sup> / 2 comparisons
- The total number of comparisons is therefore about
	- n<sup>2</sup> / 2
	- = (n1 + n2)<sup>2</sup> / 2
	- = n1<sup>2</sup> /  2 + n2<sup>2</sup> + n1n2

### Version 2

- Let
	- n1 = right1 - left1 + 1
	- n2 = right2 - left2 + 1
	- n = n1 + n2

>Sort arrays a1[left1...right2] and a2[left2...right2] respectively, and then merge the two sorted arrays into sorted array a3[1...n - 1] using array merging algorithm:

>1. Sort a1[left1...right1]
2. Sort a2[left2...right2]
3. Merge a1[left1...right1] and a2[left2...right2] into a3[1...n - 1]
4. Terminate

#### Analysis

- If steps 1 and 2 use selection sorting algorithm, they perform about n1<sup>2</sup> / 2 and n2<sup>2</sup> / 2 comparisons respectively
- Step 3 performs about n = n1 + n2 comparisons
- The total number of comparisons is therefore about
	- n1<sup>2</sup> / 2 + n2<sup>2</sup> / 2 + n1 + n2
- For all but small values of n1 and n2, n1 + n2 < n1n2
	- Therefore the second way is faster than the first

## Task 3

Test the Java selection and insertion sorting programs given.

1. Run this program to observe the sorting process using pre-coded data
2. Explain the executed results according to the principles of the selection and insertion sorting algorithms
3. Modify the code to test different data sets

#### Answer

- WS0401 is sorting `String` array [fox, cow, pig, cat, rat, lio, tig, goa, dog] using selection and insertion sort algorithms
	- Selection sort
		- Outer loop accounts for sorted invariant
			- Iterates with `l` until `l < right`
			- Sets `p = l`
			- Sets `least = a[p]`
		- Inner loop iterates over unsorted invariant and looks for least value
			- Iterates with 'k' until `k <= right`
			- Sets `comp` to `a[k].compareTo(least)`
				- Value will either be
					- If `a[k] < least` value is `-1`
					- If `a[k] == least` value is `0`
					- If `a[k] > least` value is `1`
			- If `comp < 0`, meaning `a[k] < least`
				- Sets `p = k`
				- Sets `least = a[p]`
		- When inner loop exits,
			- If `a[p] != a[l]`
				- Set `a[p] = a[l]`
				- Set `a[l] = least`
	- Insertion sort
		- Outer loop 

## Task 4

Test the Java merge and quick sort programs given.

1. Run this program to observe the sorting process using pre-coded data
2. Explain the executed results according to the principles of the merge and quick sort algorithms
3. Modify the code to test different data sets

## Task 5

Test the Vector class.

1. Note how to construct vector objects
2. Observe the operation of some vector methods by analysing the executed results

### 1:

``` java
private static Vector v = new Vector();
pritave static Vector w = new Vector();
```

### 2:

Executed results:

``` java
v = []
v = [Perth, Sydney, Melbourne, Brisbane, Adelaide]
w = [Perth, Sydney, Melbourne, Brisbane, Adelaide]
w.equals(v) = true
v = [Perth, Sydney, Melbourne, Canberra, Adelaide]
w = [Perth, Sydney, Melbourne, Brisbane, Adelaide]
w.equals(v) = false
v = [Perth, Sydney, Melbourne, Hobart, Canberra, Adelaide]
w = [Perth, Sydney, Melbourne, Brisbane, Adelaide]
w.equals(v) = false
w = [Perth, Melbourne, Brisbane]
v = [Perth, Sydney, Melbourne, Hobart, Canberra, Perth,
Melbourne, Brisbane, Adelaide]
v.indexOf("Perth") = 0
v.indexOf("Perth",2) = 5
v.indexOf("Canberra") = 4
```
