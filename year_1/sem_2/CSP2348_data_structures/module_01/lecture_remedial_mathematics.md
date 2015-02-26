# Remedial mathematics

## Floor and ceiling

The **floor** and **ceiling** functions return the nearest integer for a given real number *x*. For example *x* = 3.326

![floor & ceiling](http://snag.gy/hd9yN.jpg)

- The floor of *x*, denoted by `floor(x)` is the greatest integer that is not greater than *x*
- The ceiling of *x*, denoted by `ceiling(x)` is the smallest integer that is not smaller than *x*
- `ceiling(x) = floor(x)` if *x* is an integer, otherwise `ceiling(x) = floor(x) + 1`
	- ie. If *x* = 2, then `floor(x) = ceiling(x) = 2`
	- However if *x* = 7.14159, then `floor(x) = 7, ceiling(x) = 8`

## Powers

Consider a number *b* and a non-negative integer *n*. Then *b*<sup>n</sup> is the multiplication of *n* copies of *b*.

So *b*<sup>n</sup> = 

![powers](http://snag.gy/1NvsR.jpg)

For example

>b<sup>0</sup> = 1  
b<sup>1</sup> = b  
b<sup>2</sup> = b * b  
b<sup>3</sup> = b * b * b

Or if b = 5

>5<sup>0</sup> = 1  
5<sup>1</sup> = 5  
5<sup>2</sup> = 5 * 5 = 25  
5<sup>3</sup> = 5 * 5 * 5 = 125

### Basic laws of powers

>b<sup>n+m</sup> = b<sup>n</sup> * b<sup>m</sup> (special case: b<sup>n+1</sup> * b)  
b<sup>n-m</sup> = b<sup>n</sup> | b<sup>m</sup> (special case: b<sup>n-1</sup> = b<sup>n</sup> | b)  
b<sup>nm</sup> = (b<sup>n</sup>)<sup>m</sup> = (b<sup>m</sup>)<sup>n</sup> (special case: b<sup>n*1</sup> =  (b<sup>n</sup>)<sup>1</sup> = b<sup>n</sup>)

![powers table](http://snag.gy/G6kox.jpg)

## Logarithms

Consider a positive number y:

The logarithm of y to the base of 2 (log<sub>2</sub>y) is the number of copies of 2 that must be multiplied together to equal y.

Logarithm is the **reverse** operation of power.

**Power** (y = 2<sup>n</sup>): Know base and power (2 and n), asks for powered result y (2<sup>n</sup>)  
**Logarithm** (n = log<sub>2</sub>y): Know base and powered result (y = 2<sup>n</sup>), asks for power (n)

If y is a power of 2, log<sub>2</sub> is an integer. For example:

- log<sub>2</sub>1 = 0
	- Since 2<sup>0</sup> = 1
- log<sub>2</sub>2 =  1
	- Since 2<sup>1</sup> = 2
- log<sub>2</sub>8 = 3
	- Since 2<sup>3</sup> = 8

If y is not a power of 2, log<sub>2</sub>y is fractional. For example:

- log<sub>2</sub>5 = 2.32
	- Since 2<sup>2.32</sup> = 5
- log<sub>2</sub>7 = 2.81
	- Since 2<sup>2.81</sup> = 7

- Q: How many times may we halve the value of n (discarding remainders) to reach 1?
	- Suppose that n is a power of 2
		- 8 → 4 → 2 → 1
			- 8 = 2<sup>3</sup> may be halved 3 times
		- 16 → 8 → 4 → 2 → 1
			- 16 = 2<sup>4</sup> may be halved 4 times
- Generally, if n = 2<sup>m</sup>, n may be halved m times to reach 1
	- Suppose that n is not a power of 2
		- 9 → 4 → 2 → 1
			- 9 may be halved 3 times
		- 15 → 7 → 3 → 1
			- 15 may be halved 3 times
- If 2<sup>m</sup> < n < 2<sup>m+1</sup>, n may be halve m times to reach 1

### Basic laws of logarithm

>log<sub>2</sub>(x * y) = log<sub>2</sub>x + log<sub>2</sub>y  
log<sub>2</sub>(x / y) = log<sub>2</sub>x - log<sub>2</sub>y  
log<sub>2</sub>(2<sup>2</sup>) = n (how many times 2 halves 2<sup>n</sup>)

### Logarithm summary

In summary, n may be halved m times to reach 1 if

>2<sup>m</sup> &le; n < 2<sup>m+1</sup>

#### How:

Applying log<sub>2</sub>() to above

>log<sub>2</sub>(2<sup>m</sup>) &le; log<sub>2</sub>(n) < log<sub>2</sub>(2<sup>m+1</sup>)

we got 

>m &le; log<sub>2</sub>(n) < m + 1

then we have

>m = floor(log<sub>2</sub>n)

- Conclusion: n may be halved floor(log<sub>2</sub>n) times to reach 1
- Also: n may be halved floor(log<sub>2</sub>n) + 1 times to reach 0

## Reading

> Watt, D. A. & Brown, D. F. (2001). Java Collections: An Introduction to Abstract Data Types, Data Structures and Algorithms

- Appendix A