# Review questions

## Array algorithms analysis


### 1:

- The elements of an array are related by the fact that they have the same __________ and __________.
	- Name
	- Type

### 2:

- The process of placing the elements of an array in order is called _________ the array.
	- Sorting

### 3:

- Determining if an array contains a certain value is called __________ the array.
	- Searching

### 4:

- An array index should normally be of data type **float**
	- False

### 5:

Consider the array data set below. Use binary search to work out step-by-step the search process for values 123 and 76 respectively.

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

1. l = 0, r = 7
2. l ≤ r
	1. m = (0 + 7) / 2
		- m = 3
	2. a[3] != 123
	3. 123 > a[3]
		- l = m + 1
		- l = 4
3. l ≤ r
	1. m = (4 + 7) / 2
		- m = 5
	2. a[5] != 123
	3. 123 < a[5]
		- r = m - 1
		- r = 4
4. l ≤ r
	1. m = (4 + 4) / 2
		- m = 4
	2. a[4] != 123
	3. 123 > a[4]
		- r = m - 1
		- r = 3
5. l > r
6. Answer = none

#### Binary search 76

1. l = 0, r = 7
2. l ≤ r
	1. m = (0 + 7) / 2
		- m = 3
	2. a[3] != 76
	3. 76 < 100
		r = m - 1
		r = 2
3. l ≤ r
	1. m = (0 + 2) / 2
		- m = 1
	2. a[1] != 76
	3. 76 > 43
		- l = m + 1
		- l = 2
5. l ≤ r
	1. m = (2 + 2) / 2
		- m = 2
	2. a[2] = 76
6. Answer: m = 2
