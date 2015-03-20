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

### Analysis:

## Newton's square root

To compute approximately the square root of a positive real number a:

1. Set r to the mean of 1 and a
2. Until r<sup>2</sup> is a sufficient good approximation to a, repeat:
	1. Set r to the mean of r and a / r
3. Terminate with answer r

### Analysis:

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

#### Analysis: Counting multiplications

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

#### Analysis: Counting multiplications

- 2 multiplications
- 1 division (half)
- = 2 floor(log<sub>2</sub>n)
- = O(log(n))

## Arrays

### Insert & Delete

#### Insertion

**Problem:** Given a (sub)array a[left ... right], insert a value val at a[ins]. If necessary, shift values right to make way for it.

![insert](http://i.imgur.com/JZfQR8V.gif)

##### Analysis: Counting copies

- Let n = right - left + 1 be the length of the array
- Step 1 performs between 0 and n-1 copies
	- Say (n - 1) / 2 copies on average

![average formula](http://i.imgur.com/ER6og2E.png)

- Step 2 performs 1 copy
- Average number of copies = (n - 1) / 2 + 1 = n / 2 + <sup>1</sup>/<sub>2</sub>
- Time complexity is O(n)

#### Deletion

**Problem:** Given a (sub)array a[left ... right], delete the value from a[del]. If necessary, shift values left to fill the gap (assume that left &le; del &le; right).

![deletion](http://i.imgur.com/nKPNSMa.gif)

##### Analysis: Counting copies

- Let n = right - left + 1 be the length of the array
- Step 1 performs between 0 and n-1 copies
- Step 2 takes constant time
	- ie. O(1) time
- Average number of copies = (n - 1) / 2 = n / 2 - <sup>1</sup>/<sub>2</sub>
- Time complexity is O(n)

### Searching

#### Linear search: O(n)

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

##### Successful linear search

![successful linear search](http://i.imgur.com/QQcyoC0.gif)

##### Unsuccessful linear search

![unsuccessful linear search](http://i.imgur.com/Iy96Pyw.gif)

##### Analysis: Counting comparisons

- Let n = right - left + 1 be the length of the array
- If the search is **successful**, step 1.1 is repeated between 1 and n times
	- Average number of comparisons = (n + 1) / 2
- If the search is **unsuccessful**, step 1.1 is repeated n times
	- Number of comparisons = n
- In both cases, time complexity is O(n)

#### Binary search

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

##### Successful binary search

![successful binary search](http://i.imgur.com/GsH8gL9.gif)

##### Unsuccessful binary search

![unsuccessful binary search](http://i.imgur.com/4urQWAl.gif)

##### Analysis: Counting comparisons

- Let n be the length of the array
- Assume that steps 2.2~2.4 perform a single (successful) comparison
- If the search is **unsuccessful**, these steps are repeated as often as we must halve n to reach 0:
	- Number of comparisons = floor(log<sub>2</sub>n) + 1
- If the search is **successful**, these steps are repeated at most that many times
	- Maximum number of comparisons = floor(log<sub>2</sub>n) + 1
- In both cases, the time complexity is O(log<sub>2</sub>n)
