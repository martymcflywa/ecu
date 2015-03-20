# Test 1 review

## Module 1: Introduction

### 1:

>What are the differences between an algorithm and a program?

- Algorithm is a procedure that
	- Can be performed by humans or machines
	- Can be expressed in any suitable language
	- May be as abstract as we like
- A program is an algorithm that
	- Must be performed by machines
	- Must be expressed in a programming language
	- Must be detailed and specific

### 2:

>What are the features of a concrete data type?

A data type is characterized by a set of values, a data representation, and a set of operations.

### 3:

>Calculate 2<sup>8</sup> by hand in as many ways as you can find, then compare their efficiency in terms of multiplications.

1. 2 \* 2 \* 2 \* 2 \* 2 \* 2 \* 2 \* 2 = 2<sup>8</sup>
	- 0 variables
	- 7 multiplications
2. 4 = 2 \* 2, 4 \* 4 \* 4 \* 4 = 2<sup>8</sup>
	- 1 variable
	- 4 multiplications
3. 4 = 2 \* 2, 8 = 4 \* 2, 8 \* 8 \* 4 = 2<sup>8</sup>
	- 2 variables
	- 4 multiplications
4. 4 = 2 \* 2, 16 = 4 \* 4, 16 \* 16 = 2<sup>8</sup>
	- 3 variables
	- 4 multiplications

### 4:

>Given 2<sup>10</sup> &asymp; 10<sup>3</sup>, use power laws to prove that 2<sup>20</sup> &asymp; 10<sup>6</sup> and 2<sup>30</sup> &asymp; 10<sup>9</sup>.

- Proving 2<sup>20</sup> &asymp; 10<sup>6</sup>
	- 2<sup>10</sup> \* 2<sup>10</sup> &asymp; 10<sup>3</sup> \* 10<sup>3</sup>
	- 2<sup>10+10</sup> &asymp; 10<sup>3+3</sup>
	- 2<sup>20</sup> &asymp; 10<sup>6</sup>
- Proving 2<sup>30</sup> &asymp; 10<sup>9</sup>
	- 2<sup>10</sup> \* 2<sup>20</sup> &asymp; 10<sup>3</sup> \* 10<sup>6</sup>
	- 2<sup>10+20</sup> &asymp; 10<sup>3+6</sup>
	- 2<sup>30</sup> &asymp; 10<sup>9</sup>

### 5:

>Apply floor() and ceiling() functions to log<sub>2</sub>(70).

- 64 &le; 70 < 128
- log<sub>2</sub>(64) &le; 70 < log<sub>2</sub>(128)
	- log<sub>2</sub>(64) = 6
	- log<sub>2</sub>(128) = 7
- floor(log<sub>2</sub>(70)) = 6
- ceiling(log<sub>2</sub>(70)) = 7

### 6:

>If 2<sup>p</sup> < n < 2<sup>p+1</sup>, what should the values of floor(log<sub>2</sub>(n)) and ceiling(log<sub>2</sub>(n))?

- Since 2<sup>p</sup> < n < 2<sup>p+1
- Then log<sub>2</sub>(2<sup>p</sup>) < log<sub>2</sub>(n) < log<sub>2</sub>(2<sup>p+1</sup>)
- Then p < log<sub>2</sub>(n) < p + 1
- Therefore
	- floor(log<sub>2</sub>(n)) = p
	- ceiling(log<sub>2</sub>(n)) = p + 1

## Module 2: Algorithm analysis

### 1:

>An algorithm that takes a certain number of steps to complete any given tasks has a time complexity of:

O(1)

### 2:

>The notation O(n<sup>2</sup>) means that the algorithm's time or space complexity growth rate is proportional to:

n<sup>2</sup>

### 3:

>Determine the time complexity of the following expression:

>(3 \* n<sup>4</sup> + 2 \* n<sup>3</sup> + 2) / (5
\* n)

![review 2-2](http://i.imgur.com/lIBoDvd.png)

### 4:

>What is the growth rate of the following method?

``` java
int count(int[] a, int c) {       // 01
	int i;                        // 02
	int count = 0;                // 03
	for(i = 0; i < a.length; i++) // 04
		if(a[i] == c) count++;    // 05
	return count;                 // 06
}                                 // 07
```

- 01: O(1)
- 02: O(1)
- 03: O(1)
- 04: O(n)
	- Loops a.length times
- 05: max{O(1), O(1)}
- 06: O(1)
- max{O(1), O(n)}
- = O(n)

## Module 3: Array algorithm analysis

### 1:

>The elements of an array are related by the fact they have the same \_\_\_\_\_\_\_\_\_\_ and \_\_\_\_\_\_\_\_\_\_\_:

- Name
- Type

### 2:

>The process of placing the elements of an array in order is called \_\_\_\_\_\_\_\_\_\_ the array.

- Sorting

### 3:

>Determining if an array contains a certain value is called \_\_\_\_\_\_\_\_\_\_ the array.

- Searching

### 4:

>True or false: An array index should normally be of data type **float**.

- False

### 5:

>Consider the array data set below. Use binary search to work out step-by-step the search process for values 123 and 76 respectively.

| 14   | 43   | 76   | 100  | 115  | 290  | 400  | 511  |
|------|------|------|------|------|------|------|------|
| a[0] | a[1] | a[2] | a[3] | a[4] | a[5] | a[6] | a[7] |

>To find which (if any) component of the sorted (sub)array a[left ... right] equals target:

>1. Set l = left, r = right
2. While l ≤ r, repeat:
	1. Let m be an integer about halfway between l and r
	2. If target equals a[m], terminate with answer m
	3. If target is less than a[m], set r = m - 1
	4. If target is greater than a[m], set l = m + 1
3. Terminate with answer none

#### Binary search 123

1. target = 123, l = 0, r = 7
2. l &le; r
	1. m = floor((0 + 7) / 2)
		- m = 3
	2. target != a[3]
	3. target !< a[3]
	4. target > a[3]
		- l = m + 1
		- l = 3 + 1
		- l = 4
3. l &le; r
	1. m = floor((4 + 7) / 2)
		- m = 5
	2. target != a[5]
	3. target < a[5]
		- r = m - 1
		- r = 5 - 1
		- r - 4
4. l &le; r
	1. m = floor((4 + 4) / 2)
		- m = 4
	2. target != a[4]
	3. target !< a[4]
	4. target > a[4]
		- l = m + 1
		- l = 4 + 1
		- l = 5
5. l !&le; r
6. Terminate with answer none

#### Binary search 76

1. target = 76, l = 0, r = 7
2. l &le; r
	1. m = floor((0 + 7) / 2)
		- m = 3
	2. target != a[3]
	3. target < a[3]
		- r = m - 1
		- r = 3 - 1
		- r = 2
3. l &le; r
	1. m = floor((0 + 2) / 2)
		- m = 1
	2. target != a[1]
	3. target !< a[1]
	4. target > a[1]
		- l = m + 1
		- l = 1 + 1
		- l = 2
5. l &le; r
	1. m = floor((2 + 2) / 2)
		- m = 2
	2. target == a[2]
6. Terminate with answer m
	- m = 2
