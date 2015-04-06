# Remedial maths

## Manual floor() & ceiling()

Using a manual method, apply floor() and ceiling() functions to log<sub>2</sub>(1050).

>1. 1024 &le; 1050 < 2048
2. log<sub>2</sub>(1024) &le; log<sub>2</sub>(1050) < log<sub>2</sub>(2048)
3. log<sub>2</sub>(1024) = 10 &le; log<sub>2</sub>(1050) < log<sub>2</sub>(2048) = 11
4. Therefore:
	- floor(log<sub>2</sub>(1050)) = 10
	- ceiling(log<sub>2</sub>(1050)) = 11

## Basic laws of powers

>b<sup>n+m</sup> = b<sup>n</sup> \* b<sup>m</sup>  
Special case: b<sup>n+1</sup> \* b

>b<sup>n-m</sup> = b<sup>n</sup> / b<sup>m</sup>  
Special case: b<sup>n-1</sup> = b<sup>n</sup> / b  

>b<sup>nm</sup> = (b<sup>n</sup>)<sup>m</sup> = (b<sup>m</sup>)<sup>n</sup>  
Special case: b<sup>n*1</sup> =  (b<sup>n</sup>)<sup>1</sup> = b<sup>n</sup>

### Power calculations

Calculate 2<sup>6</sup> by hand in as many was as you can find and compare their efficiency in terms of multiplications.

>2<sup>6</sup> = 2 \* 2 \* 2 \* 2 \* 2 \* 2 = 5 steps  
2<sup>6</sup> = 2 \* 2 = 4; 4 \* 4 \* 4 = 3 steps  
2<sup>6</sup> = 2 \* 2 \* 2 = 8; 8 \* 8 = 3 steps

Calculate 2<sup>8</sup> by hand in as many was as you can find, then compare their efficiency in terms of multiplications.

>2 \* 2 \* 2 \* 2 \* 2 \* 2 \* 2 \* 2 = 2<sup>8</sup>  
7 multiplications  
0 variables

>4 = 2 \* 2; 4 \* 4 \* 4 \* 4 = 2<sup>8</sup>  
4 multiplications  
1 variable

>4 = 2 \* 2; 8 = 4 \* 2, 4 \* 8 \* 8 = 2<sup>8</sup>  
4 multiplications  
2 variables

>4 = 2 \* 2; 16 = 4 \* 4; 16 \* 16 = 2<sup>8</sup>  
3 multiplications  
2 variables

## Basic laws of logarithm

>log<sub>2</sub>(x * y) = log<sub>2</sub>x + log<sub>2</sub>y  
log<sub>2</sub>(x / y) = log<sub>2</sub>x - log<sub>2</sub>y  
log<sub>2</sub>(2<sup>2</sup>) = n (how many times 2 halves 2<sup>n</sup>)

### Alternative log rules

Goodrich, M. T., & Tamassia, R. (2014). Data Structures and Algorithms in Java (6th ed.). New York: John Wiley & Sons.

Chapter 4.2, pp. 157.

>1. log<sub>b</sub>(ac) = log<sub>b</sub>a + log<sub>b</sub>c
2. log<sub>b</sub>(a/c) = log<sub>b</sub>a - log<sub>b</sub>c
3. log<sub>b</sub>(a<sup>c</sup>) = c * log<sub>b</sub>a
4. log<sub>b</sub>a = log<sub>d</sub>a / log<sub>d</sub>b
5. b<sup>log<sub>d</sub>a</sup> = a<sup>log<sub>d</sub>b</sup>

#### Rule application

Goodrich, M. T., & Tamassia, R. (2014). Data Structures and Algorithms in Java (6th ed.). New York: John Wiley & Sons.

Chapter 4.2, pp. 157.

>- Rule 1:
	- log(2n) = log(2) + log(n) = 1 + log(n)
- Rule 2:
	- log(n / 2) = log(n) - log(2) = log(n) - 1
- Rule 3:
	- log(n<sup>3</sup>) = 3 \* log(n)
	- log(2<sup>n</sup>) = n \* log(2) = n * 1 = n
- Rule 4:
	- log<sub>4</sub>n = (log(n)) / log(4) = (log(n)) / 2
- Rule 5:
	- 2<sup>log(n)</sup> = n<sup>log(2)</sup> = n<sup>1</sup> = n

## Basic laws of exponents

Goodrich, M. T., & Tamassia, R. (2014). Data Structures and Algorithms in Java (6th ed.). New York: John Wiley & Sons.

Chapter 4.2, pp. 161.

>1. (b<sup>a</sup>)<sup>c</sup> = b<sup>ac</sup>
2. b<sup>a</sup>b<sup>c</sup> = b<sup>a+c</sup>
3. b<sup>a</sup> / b<sup>c = b<sup>a-c</sup>

### Rule application

Goodrich, M. T., & Tamassia, R. (2014). Data Structures and Algorithms in Java (6th ed.). New York: John Wiley & Sons.

Chapter 4.2, pp. 162.

>- Rule 1:
	- 256 = 16<sup>2</sup> = (2<sup>4</sup>)<sup>2</sup> = 2<sup>4\*2</sup> = 2<sup>8</sup> = 256
- Rule 2:
	- 243 = 3<sup>5</sup> = 3<sup>2+3</sup> = 3<sup>2</sup> \* 3<sup>3</sup> = 9 \* 27 = 243
- Rule 3:
	- 16 = 1024 / 64 = 2<sup>10</sup> / 2<sup>6</sup> = 2<sup>10-6</sup> = 2<sup>4</sup> = 16

## Summation of simple arithmetic series

- An **arithmetic series** is a sequence of numbers with a fixed difference between consecutive numbers, for example

>1, 2, 3, 4, 5  
2, 4, 6, 8, 10, 12, 14, 16, 18

- Special case: **Simple arithmetic series**

>1, 2, 3, ..., n-2, n-1, n

>**Question:** What is the summation, S = 1 + 2 + 3 + ..., + n?

Calculate 2\*S, we have 2\*S = n * (n + 1)

or:

![series formula](http://i.cubeupload.com/KtZIf5.png)

- General case:
	- Used when series does not start at 1
	- Sum of the two ends
		- ie. 2, 3, 4, 5, 6, 7, 8
			- 2 + 8
				- S = (7 * (2 + 8)) / 2
				- S = 35
		- ie. 5, 10, 15, 20, 25, 30
			- 5 + 30
				- S = (6 * (5 + 30)) / 2
				- S = 105

>S = ((total num of values) * (sum of the two ends)) / 2

- Or alternatively:

![series formula general case](http://snag.gy/NGjzc.jpg)

![s block](http://snag.gy/Mo8lO.jpg)

# Algorithm analysis

## Time complexities

| Big-O            | Type        | Feasibility |
|------------------|-------------|-------------|
| O(1)             | Constant    | Always      |
| O(log(n))        | Logarithmic | Always      |
| O(n)             | Linear      | Always      |
| O(n log(n))      | Log Linear  | Always      |
| O(n<sup>2</sup>) | Quadratic   | Sometimes   |
| O(n<sup>3</sup>) | Cubic       | Less Often  |
| O(2<sup>n</sup>) | Exponential | Rarely      |

![big-o chart](http://bigocheatsheet.com/img/big-o-complexity.png)

## O notation operations

### Rule 1

>O(g(n) ± h(n)) = O(g(n)) ± O(h(n)) &rArr; max{O(g(n)), O(h(n))}

### Rule 2

>O(g(n) \* h(n)) = O(g(n)) \* O(h(n))

### Rule 3

>O(g(n) / h(n)) = O(g(n)) / O(h(n))

# Algorithms

## GCD

To find the GCD of positive integers m and n:

>1. Set p = m, set q = n
2. Until q exactly divides p, repeat:
	1. Set p = q, set q = (p mod q)
3. Terminate with answer q

![gcd](http://i.imgur.com/BiVdlui.gif)

``` java
static int gcd(int m, int n) {
	// return gcd of positive integers m
	int p = m;
	int q = n;
	while(p % q != 0) {
		int r = p % q;
		p = q;
		q = r;
	}
	return q;
}
```

### GCD analysis:

## Newton's square root

To compute approximately the square root of a positive real number a:

1. Set r to the mean of 1 and a
2. Until r<sup>2</sup> is a sufficient good approximation to a, repeat:
	1. Set r to the mean of r and a / r
3. Terminate with answer r

### Newton's square root nalysis:

## Powers

### Simple power: O(n)

To compute b<sup>n</sup> where n is a non-negative int.

>1. Set p to 1
2. For i = 1, ..., n, repeat:
	1. Multiply p by b
3. Terminate with answer p

``` java
static int power(int b, int n) {
	// return value of b raised to nth power
	// n is non-negative int
	int p = 1;
	for(int i = 1, i <= n; i++) {
		p *= b;
	}
	return p;
}
```

#### Simple power analysis

- Counting multiplications
- 1 multiplication for every n
- = 1n
- = O(n)

### Smart power: O(log(n))

To compute b<sup>n</sup> where n is a non-negative int.

>1. Set p to 1, set q to b, set m to n
2. While m is positive, repeat:
	1. If m is odd, multiply p by q
	2. Halve m (neglect remainder) and multiply q by itself
3. Terminate with answer p

``` java
static int power(int b, int n) {
	// return value of b raised to nth power
	// n is non-negative int
	int p = 1, q = b, m = n;
	while(m > 0) {
		if(m % 2 ! = 0) {
			p *= q;
		} else {
			m /= 2;
			q *= q;
		}
	}
	return p;
}
```

#### Smart power analysis

- Counting multiplications
- 2 multiplications
- 1 division (half)
- = 2 floor(log<sub>2</sub>n)
- = O(log(n))

## Array manipulation algorithms

### Insertion

**Problem:** Given a (sub)array a[left ... right], insert a value val at a[ins]. If necessary, shift values right to make way for it.

![insert](http://i.imgur.com/JZfQR8V.gif)

#### Insertion analysis

- Counting copies
- Let n = right - left + 1 be the length of the array
- Step 1 performs between 0 and n-1 copies
	- Say (n - 1) / 2 copies on average

![average formula](http://i.imgur.com/ER6og2E.png)

- Step 2 performs 1 copy
- Average number of copies = (n - 1) / 2 + 1 = n / 2 + <sup>1</sup>/<sub>2</sub>
- Time complexity is O(n)

### Deletion

**Problem:** Given a (sub)array a[left ... right], delete the value from a[del]. If necessary, shift values left to fill the gap (assume that left &le; del &le; right).

![deletion](http://i.imgur.com/nKPNSMa.gif)

#### Deletion analysis

- Counting copies
- Let n = right - left + 1 be the length of the array
- Step 1 performs between 0 and n-1 copies
- Step 2 takes constant time
	- ie. O(1) time
- Average number of copies = (n - 1) / 2 = n / 2 - <sup>1</sup>/<sub>2</sub>
- Time complexity is O(n)

### Merge sorted arrays

- **Problem:**
	- Given two **sorted** arrays, make a third sorted array containing copies of all components of the two original arrays.

#### Merge sorted arrays algorithm

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

![array merge anim](http://i.imgur.com/3RGF96T.gif)

#### Merge sorted arrays Java implementation

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

#### Merge sorted arrays analysis

##### Counting number of copies

- Let n<sub>1</sub> and n<sub>2</sub> be the lengths of a1 and a2
	- Then set n = n<sub>1</sub> + n<sub>2</sub>
- Each component of a1 is copied once, and each component of a2 is copied once
- Number of copies = n<sub>1</sub> + n<sub>2</sub> = n
- &rArr; Time complexity is O(n)

##### Counting comparisons

- Assume that Steps 2.1 to 2.2 perform a single comparison
	- ie. If-then-else
	- Steps 2.1 to 2.2 are repeated at most n-1 times
- Maximum number of comparisons = n-1
- &rArr; Time complexity is O(n)

##### Overall complexity

>max{O(n), O(n)}  
= O(n)

## Array searching algorithms

### Linear search: O(n)

To find which (if any) component of a[left ... right] equals target.

>1. For p = left, ..., right, repeat:
	1. If target equals a[p], terminate with answer p
2. Else terminate with answer none.

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

#### Successful linear search

![successful linear search](http://i.imgur.com/QQcyoC0.gif)

#### Unsuccessful linear search

![unsuccessful linear search](http://i.imgur.com/Iy96Pyw.gif)

#### Linear search analysis

- Counting comparisons
- Let n = right - left + 1 be the length of the array
- If the search is **successful**, step 1.1 is repeated between 1 and n times
	- Average number of comparisons = (n + 1) / 2
- If the search is **unsuccessful**, step 1.1 is repeated n times
	- Number of comparisons = n
- In both cases, time complexity is O(n)

### Binary search

To find which (if any) component of the sorted (sub)array a[left ... right] equals target:

1. Set l = left, r = right
2. While l &le; r, repeat:
	1. Let m be an integer about halfway between l and r
	2. If target equals a[m], terminate with answer m
	3. If target is less than a[m], set r = m - 1
	4. If target is greater than a[m], set l = m + 1
3. Terminate with answer none

![binary search](http://snag.gy/3lQqG.jpg)

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

#### Successful binary search

![successful binary search](http://i.imgur.com/GsH8gL9.gif)

#### Unsuccessful binary search

![unsuccessful binary search](http://i.imgur.com/4urQWAl.gif)

#### Binary search analysis

- Counting comparisons
- Let n be the length of the array
- Assume that steps 2.2~2.4 perform a single (successful) comparison
- If the search is **unsuccessful**, these steps are repeated as often as we must halve n to reach 0:
	- Number of comparisons = floor(log<sub>2</sub>n) + 1
- If the search is **successful**, these steps are repeated at most that many times
	- Maximum number of comparisons = floor(log<sub>2</sub>n) + 1
- In both cases, the time complexity is O(log<sub>2</sub>n)

## Array sorting algorithms

### Selection sort

- **Idea:**
	- Find the least value in the array
	- Swap it into the leftmost component
	- Forget the leftmost component
	- Repeat for rest of array

**Loop invariant:**

![loop invariant](http://snag.gy/QcLnk.jpg)

#### Selection sort algorithm

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

- **Total number of comparisons:** right - l

![select sort anim](http://i.imgur.com/6PAZhC7.gif)

#### Selection sort demo

- The array [2, 5, 1, 3, 4] sorted by selection sort

![select sort demo](http://i.imgur.com/u6aU2wi.gif)

#### Selection sort analysis

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

#### Selection sort Java implementation

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

### Insertion sort

- **Idea:**
	- Successively read each value and insert it into its correct position in the sorted part of the array
	- Use the same idea to sort an array of values in place

**Loop invariant:**

![loop invariant](http://snag.gy/9swVF.jpg)

#### Insertion sort algorithm

>To sort a[left...right] into ascending order:

>1. For r = left + 1, ..., right, repeat: // start at 2nd element, first element is considered the "sorted" subarray
	1. Let val = a[r] // a[r] becomes a spare index where "sorted" subarray elements can shift to the right if a[r] is to be inserted somewhere in "sorted" subarrray
	2. Insert val into its correct sorted position in a[left...r] // a[r] is target, and searched in "sorted" subarray to find correct placement, then inserted
2. Terminate

- Step 1.2 can be implemented using a combination of **array search** and **insert** algorithm to insert val into the already sorted sub-array a[left...r-l]
	- If val is the greatest, no insertion is needed

![insert sort](http://i.imgur.com/vGYqi83.gif)

#### Insertion sort demo

- The array [2, 5, 1, 3, 4] sorted by insertion sort:

![anim insert sort demo](http://i.imgur.com/r2WrZ3C.gif)

#### Insertion sort analysis

- Counting comparisons
- Let n = right - left + 1 be the length of the array
- Step 1.2 performs between 1 and (r - left) comparisons
	- Say (r - left + 1) / 2 comparisons on average
- This is repeated with r = left + 1, left + 2, ..., right
- Average no. of comparisons:

>- = 2 / 2 + 3 / 2 + ... + n / 2  
- = (2 + 3 + 4 + ... + n) / 2  
- = (n - 1)(n + 2) / 4  
	- This uses summation of series
		- (n - 1) = total number of values
			- (n - 1) instead of just (n) because algorithm starts at 2nd element, since it considers the 1st element as the "sorted" subarray
		- (n + 2) or (2 + n) = sum of the two ends, see summation formula
		- Divided by 4 because
			- Divided by 2 to find average
			- Divided by 2 again for summation formula
- = (n<sup>2</sup> + n - 2) / 4
	- After simplifying (n - 1)(n + 2) / 4

- Time complexity: O(n<sup>2</sup>)

### Merge sort

- **Idea:**
	- Divide-and-sort-and-merge
	- Divide the array into two subarrays of about equal length
	- Sort the two subarrays separately
	- Merge the sorted subarrays
		- See **merge sorted arrays** algorithm
- This is an application of the **divide-and-conquer** strategy
	- To solve a hard problem
		- Break the problem down into two or more "easier" sub-problems
		- Solve these sub-problems separately
		- Combine their answers
	- The divide-and-conquer strategy is effective for solving many problems

#### Merge sort algorithm

>To sort a[left...right] into ascending order:

>1. If left < right: // meaning at least 2 elements in array
	1. Let m be an integer about midway between left and right
	2. Sort a[left...m] into ascending order
		- Recursive: Call Step 1.1 to split subarray into smallest possible halves
	3. Sort a[m + 1...right] into ascending order
		- Recursive: Call Step 1.1 to split subarray into smallest possible halves
	4. Merge a[left...m] and a[m + 1...right] into auxiliary array b
		- See **merge sorted array** algorithm
			- The merge sorted array algorithm does the sorting
	5. Copy all components of b into a[left...right]
2. Terminate

![merge sort anim](http://i.imgur.com/Wwo3JQl.gif)

#### Merge sort demo

![merge sort demo](http://i.imgur.com/XSx7qRA.gif)

#### Recursive strategy

- Merge sort is a **recursive** algorithm
	- ie. The algorithm calls itself inside the body of the algorithm
- Step 1.1 and Step 1.2 both use the same idea of merge-sort to sort these smaller subarrays
- For recursive algorithm, we must consider the **exit** condition (or **easy** case) and the **recursive** condition (or hard case) for recursion
	- **Easy case:** No more sorting to do at all
		- ie. left &ge; right
	- **Hard case:** At least two values to be sorted
		- ie. left < right

#### Merge sort analysis

- Counting comparisons
- Let n = right - left + 1 be the length of the array
- Let the total no. of comparisons required to sort n values be C(n)
	- The left subarray's length is about n/2, so step 1.2 takes about C(n/2) comparisons to sort
	- Similary, Step 1.3 takes about C(n/2) comparisons to sort the right array
	- Step 1.4 takes about n - 1 comparisons to merge the subarrays
- Therefore:

![merge sort C(n) 1](http://i.imgur.com/OT9JgYB.png)

##### Merge sort analysis equation

![merge sort formula 1](http://snag.gy/5VFHV.jpg)

``` tex
\begin{align*}
C(n) &= 2C(n / 2) + n - 1 \\
= 2(2C(n / 4) + n / 2 - 1) + n - 1 &= 4C(n / 4) + 2n - 3 \\
= 4(2C(n / 8) + n / 4 - 1) + 2n - 3 &= 8C(n / 8) + 3n - 7 \\
&\mbox{...} \\
\mbox{Let's assume that } n &= 2^i \\
&= 2^iC(n / 2^i) + i \times n - (2^i - 1) \\
&= 2^i \times 1 + i \times n - 2^i + 1 \\
&= n \times 1 + log(n) \times n - n + 1 \\
&= O(n \times log(n))
\end{align}
```

- Therefore the time complexity is O(n log n).
- **Space** complexity is O(n), since Step 1.4 needs an auxiliary array of length n.

###### C(n) = O(n log n) proof

Consider a special case: n = 2<sup>k</sup> (for some k), or k = log<sub>2</sub>n. Then:

####### 1:

![C(n) equation](http://i.imgur.com/ftEbrCf.png)

####### 2:

>If n &ne; 2<sup>k</sup>, let 2<sup>k-1</sup> &le; n < 2<sup>k</sup> for some k.

>Then k-1 &le; log<sub>2</sub>(n) < k.

>Follow similar proof, we have O(n * log<sub>2</sub>(n)) &le; C(n) &le; O(n * log<sub>2</sub>(n)).

>Which also leads to C(n) &rArr; O(n * log<sub>2</sub>(n))

### Quick sort

- **Idea:**
	- Choose any value from the array
		- Called the **pivot**
	- And then **partition** the array into three subarrays such that:
		- The left subarray contains only values less than or equal to the pivot
		- The middle subarray contains the pivot only
		- The right subarray contains only values greater than or equal to the pivot
	- Finally sort the left subarray and right subarray separately, leading to the whole array sorted
- This is another application of the divide-and-conquer strategy

#### Quick sort algorithm

>To sort a[left...right] into ascending order:

>1. If left < right:
	1. Partition a[left...right] such that
		1. a[left...p - 1] are less than or equal to a[p]
		2. a[p + 1...right] are all greater than or equal to a[p]
	2. Sort a[left...p - 1] into ascending order
	3. Sort a[p + 1...right] into ascending order
2. Terminate

![quick sort anim](http://i.imgur.com/S1IMTgH.gif)

#### Quick sort invariants

![quick sort invariants](http://snag.gy/ZgxpK.jpg)

##### Quick sort analysis

- Counting comparisons
- Let n be the number of values to be sorted, and the total number of comparisons required to sort n values be C(n)
- Step 1.1 takes about n - 1 comparisons to partition the array (not sort!)

###### Quick sort best case

- In the **best case**, the pivot turns out to be the median value in the array
	- So left and right subarrays both have length about n / 2
	- Then Steps 1.2 and 1.3 take about C(n / 2) comparisons each
- Therefore:

![quick sort worst case C(n)](http://i.imgur.com/OT9JgYB.png)

- Solution: C(n) = n log<sub>2</sub>n
- Therefore, best-case time complexity is O(n log n)

###### Quick sort worst case

- In the **worst case**, the pivot turns out to be the minimum/maximum value
- So the right/left subarray has length n - 1, whilst the other subarray has length 0
- Then Step 1.3 performs C(n - 1) comparisons, but Step 1.2 does nothing at all

In such a case:

![quick sort worst case C(n)](http://i.imgur.com/FvUxgel.png)

Thus:

![quick sort worst case formula](http://i.imgur.com/4ZISKio.png)

- Worst case time complexity is O(n<sup>2</sup>)
- The worst case arises **if the array is already sorted!**

#### Quick sort Java implementation

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

#### Quick sort partitioning algorithm

>To partition a[left...right] such that a[left...p-1] are all less than or equal to a[p], and a[p + 1...right] are all greater than or equal to a[p]:

>1. Let pivot be the value of a[left], and set p = left
2. For r = left + 1, ..., right, repeat:
	1. If a[r] is less than pivot:
		1. Copy a[r] into a[p], a[p + 1] into a[r], and pivot into a[p + 1]
		2. Increment p
3. Terminate with answer p

- Note that other and better partitioning algorithms exist

###### Partition loop invariant

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

![sort algorithms table](http://snag.gy/JzAZO.jpg)

# Review questions

## Module 2: Algorithm analysis

### 1:

>The notation O(n<sup>2</sup>) means that the algorithm's time or space growth rate is proportional to:

n<sup>2</sup>

### 2:

>Determine the time complexity of the following expression:

>(3 \* n<sup>4</sup> + 2 \* n<sup>3</sup> + 2) / (5 \* n)

![review 2-2](http://i.imgur.com/lIBoDvd.png)

``` latex
\begin{align*}
(3 \times n^4 + 2 \times n^3 + 2) / (5 \times n) &= \frac{3}{5} \times n^3 + \frac{2}{5} + n^2 + \frac{2}{5} \times n^{-1} \\
&\Rightarrow max \begin{Bmatrix}
O(\frac{3}{5} \times n^3), O(\frac{2}{5} \times n^2), O(\frac{2}{5} \times n^{-1})
\end{Bmatrix} \\
&\Rightarrow max \begin{Bmatrix}
O(n^3), O(n^2), O(n^{-1})
\end{Bmatrix} \\
&\Rightarrow O(n^3)
\end{align}
```
