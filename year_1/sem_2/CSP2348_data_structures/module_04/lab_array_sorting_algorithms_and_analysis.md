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

## Task 3

Test the Java selection and insertion sorting programs given.

1. Run this program to observe the sorting process using pre-coded data
2. Explain the executed results according to the principles of the selection and insertion sorting algorithms
3. Modify the code to test different data sets

## Task 4

Test the Java merge and quick sort programs given.

1. Run this program to observe the sorting process using pre-coded data
2. Explain the executed results according to the principles of the merge and quick sort algorithms
3. Modify the code to test different data sets

## Task 5

Test the Vector class.

1. Note how to construct vector objects
2. Observe the operation of some vector methods by analysing the executed results
