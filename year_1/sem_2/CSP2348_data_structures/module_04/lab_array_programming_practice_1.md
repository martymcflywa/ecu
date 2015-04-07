# Programming practice 1: Java arrays

1. Write an algorithm to test whether an array a[left...right] is sorted in ascending order
	1. In terms of the number of comparisons required, determine the time efficiency of your algorithm
		- In best case
		- In worst case
		- In average
	2. Implement your algorithm as a Java method, assuming that the array elements are `Comparable` objects
2. A *palindrome* is a sequence that is identical to the reverse of itself
	- For example, the sequence <<'m', 'a', 'd', 'a', 'm'>> is a palindrome
	1. Write an algorithm to test whether a character array a[left...right] is a palindrome
	2. What is the time efficiency and space efficiency of your algorithm
	3. Implement your algorithm as a Java method
3. Consider the implementations of selection sort (Program 3.30), insertion sort (Program 3.34), merge sort (Program 3.37) and quick sort (Program 3.44)
	1. Modify each of these Java methods to count the number of comparisons and the number of copies
		- Run the modified sorting methods with a range of array lengths
			- Say 10, 50, 100, 500, 1000 and 5000
	2. Compare your experimental results with the theoretical results given in Table 3.45
4. Consider the sorting algorithm given below:
	1. Implement this algorithm as a Java method
	2. Modify your code to count the number of comparisons and the number of copies
	3. Run your method with a range of array lengths
		- Comapare your experimental results with those given in Table 3.45 for other sorting algorithms

## Bubble sort algorithm

> To sort a[left...right]:

>1. For i = 0, ..., right-left-l, repeat:
	1. For j = left + 1, ..., right-i, repeat:
		1. If a[j-l] is greater than a[j], swap a[j-l] and a[j]
2. Terminate

## 1

Write an algorithm to test whether an array a[left...right] is sorted in ascending order.

>To test whether the array a[left...right] is sorted in ascending order:

>1. For p = left+1, ..., right, repeat:
	1. If a[p-1] is greater than a[p], terminate with answer false
2. Terminate

### 1-1

- Best case: 1 comparison
- Worst case: n-1 comparisons
- Average case: n/2 comparisons

### 1-2

``` java
static boolean isSorted(Comparable[] a, int left, int right) {
	for(int p = left + 1; p <= right; p++) {
		if(a[p - 1].compareTo(a[p]) > 0) {
			return false;
		}
	}
	return false;
}
```

## 2

Testing palindrome.

### 2-1

>To test whether the char array a[left...right] is a palindrome:

>1. Set l to left, set r to right
2. While l < r, repeat:
	1. If a[l] ≠ a[r], terminate with answer false
	2. Increment l, decrement r
3. Terminate with answer true

### 2-2

- Number of comparisons is between 1 and n/2, ie. about n/4 on average
	- Therefore, time complexity is O(n)
- Space complexity is O(1)

### 2-3

``` java
static boolean isPalindrome(char[] a, int left, int right) {
	// set l to left, set r to right
	int l = left;
	int r = right;

	while(l < r) {

		// if current left and current right are not equal,
		if(a[l] != a[r]) {
			// return false
			return false;
		}
		// increment l, decrement r
		l++;
		r--;
	}
	return true;
}
```

## 3

To run tests

## 4

Bubble sort algorithm:

> To sort a[left...right]:

>1. For i = 0, ..., right-left-1, repeat:
	1. For j = left + 1, ..., right-i, repeat:
		1. If a[j-1] is greater than a[j], swap a[j-l] and a[j]
2. Terminate

### 4-1

``` java
static void bubbleSort(Comparable[] a, int left, int right) {
	// 1. For i = 0, ..., right-left-1, repeat:
	for(int i = 0; i <= right - left - 1; i++) {
		// 1.1 For j = left + 1, ..., right - i, repeat:
		for(int j = left + 1; i < right - i; j++) {
			// compare a[j - 1] to a[j]
			int comp = a[j - 1].compareTo(a[j]);
			// 1.1.1 If a[j-1] > a[j]...
			if(comp > 0) {
				// store a[j-1] in temp variable
				Comparable temp = a[j - 1];
				// ... swap a[j-1] and a[j]
				a[j - 1] = a[j];
				a[j] = temp;
			}
		}
	}
}
```
