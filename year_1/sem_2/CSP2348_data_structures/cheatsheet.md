# Remedial maths

## Basic laws of powers

>b<sup>n+m</sup> = b<sup>n</sup> \* b<sup>m</sup>  
Special case: b<sup>n+1</sup> \* b

>b<sup>n-m</sup> = b<sup>n</sup> | b<sup>m</sup>  
Special case: b<sup>n-1</sup> = b<sup>n</sup> | b  

>b<sup>nm</sup> = (b<sup>n</sup>)<sup>m</sup> = (b<sup>m</sup>)<sup>n</sup>  
Special case: b<sup>n*1</sup> =  (b<sup>n</sup>)<sup>1</sup> = b<sup>n</sup>

## Basic laws of logarithm

>log<sub>2</sub>(x * y) = log<sub>2</sub>x + log<sub>2</sub>y  
log<sub>2</sub>(x / y) = log<sub>2</sub>x - log<sub>2</sub>y  
log<sub>2</sub>(2<sup>2</sup>) = n (how many times 2 halves 2<sup>n</sup>)

### Examples

#### Power calculations

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

### Simple power

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

#### Analysis:

- 1 multiplication for every n
- = 1n
- = O(n)

### Smart power

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

#### Analysis:

- 2 multiplications
- 1 division (half)
- = 2 floor(log<sub>2</sub>n)
- = O(log(n))

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

>O(g(n) * h(n)) = O(g(n)) * O(h(n))

### Rule 3

>O(g(n) / h(n)) = O(g(n)) / O(h(n))
