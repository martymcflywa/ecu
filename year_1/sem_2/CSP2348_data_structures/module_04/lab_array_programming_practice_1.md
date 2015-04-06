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
