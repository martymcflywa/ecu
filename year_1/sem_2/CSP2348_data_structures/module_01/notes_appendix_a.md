# Appending A

Summary of mathematics for algorithm analysis

## Powers

Given the nonnegative integer n, the n'th power of a number b, written b<sup>n</sup>, is defined by:

>b<sup>n</sup> = b * ... * b

### Example

>b<sup>3</sup> = b * b * b  
b<sup>2</sup> = b * b  
b<sup>1</sup> = b  
b<sup>0</sup> = 1

It might not be obvious that b<sup>0</sup> = 1, but we shall soon see why.

### Laws

The basic law of powers is:

#### A.3 

>b<sup>n+m</sup> = b<sup>n</sup> * b<sup>m</sup>

This holds because b<sup>n</sup> is the product of n copies of b, and b<sup>m</sup> is the product of m copies of b, so b<sup>n</sup> * b<sup>m</sup> is the product of n + m copies of b.

A useful special case of A.3 is:

>b<sup>n+1</sup> = b<sup>n</sup> * b

#### A.5

>b<sup>n-m</sup> = b<sup>n</sup> / b<sup>m</sup>

This holds because b<sup>n</sup> / b<sup>m</sup> is the product of n - m copies of b.

A useful special case of A.3 is:

>b<sup>n-1</sup> = b<sup>n</sup> / b

From this, by taking n = 1, we can deduce that b<sup>0</sup> = b<sup>1</sup> / b = 1.

#### Example:

How many different bit strings of length n exist?

First consider some simple cases:

- There are 2 different bit strings of length 1
	- 0
	- 1
- There are 2 * 2 = 2<sup>2</sup> = 4 different bit strings of length 2
	- 00
	- 01
	- 10
	- 11
- We can easily generalize from these cases:
	- There are 2<sup>n</sup> different bit strings of length n
- Characters are represented in a computer by bit strings
	- The 7-bit ASCII character set has 2<sup>7</sup> different characters
	- The 8-bit ISO-LATIN-1 character set has 2<sup>8</sup> different characters
	- The 16 bit Unicode character set has 2<sup>16</sup> different characters

Powers of 2 are ubiquitous in computing, as a consequence of the binary representation of data. The first few powers of 2, as shown in the table below are worth memorizing. By happy coincidence, 2<sup>10</sup> &asymp; 1 thousand, 2<sup>20</sup> &asymp; 1 million, and 2<sup>30</sup> &asymp; 1 billion.

| n             | 0 | 1 | 2 | 3 | 4  | 5  | 6  | 7   | 8   | 9   | 10   |
|---------------|---|---|---|---|----|----|----|-----|-----|-----|------|
| 2<sup>n</sup> | 1 | 2 | 4 | 8 | 16 | 32 | 64 | 128 | 256 | 512 | 1024 |

## Logarithms

- The logarithm of a number y to the base 2, written log<sub>2</sub>y, is the number of copies that 2 that must be multiplied together to give y
	- Thus 
		- log<sub>2</sub>2 = 1
		- log<sub>2</sub>4 = 2 (since 2<sup>2</sup> = 4)
		- log<sub>2</sub>8 = 3 (since 2<sup>3</sup> = 8)
- All powers of 2 have integer logarithms to the base 2
- Other numbers have fractional logarithms
	- Thus
		- log<sub>2</sub>5 &asymp; 2.322
		- log<sub>2</sub>6 &asymp; 2.585
		- log<sub>2</sub>7 &asymp; 2.807
- More generally, the logarithm of a number y to the base b (where b > 1), written log<sub>b</sub>y, is the number of copies of b that must be multiplied together to give y
- From this defenition, it follows immediately that:

>log<sub>b</sub>(b<sup>n</sup>)

Two important special cases for above are:

>log<sub>b</sub>1 = 0  
log<sub>b</sub>b = 1

### Laws

#### A.10

The basic laws of logarithms states that the logarithm of the product of two numbers is the sum of their logarithms:

>log<sub>b</sub>(yz) = log<sub>b</sub>y + log<sub>b</sub>z

A useful special case of A.10 is:

>log<sub>b</sub>(by) = log<sub>b</sub>b + log<sub>b</sub>y = 1 + log<sub>b</sub>y

To verify A.10, suppose that y = b<sup>m</sup> and z = b<sup>n</sup> 

Then log<sub>b</sub>(yz) = log<sub>b</sub>(b<sup>m</sup> * b<sup>n</sup>) = log<sub>b</sub>(b<sup>m+n</sup>) = m + n = log<sub>b</sub>y + log<sub>b</sub>z

#### A.12

A second law states that the logarithm of the quotient of two numbers is the difference of their algorithms:

>log<sub>b</sub>(y / z) = log<sub>b</sub>y - log<sub>b</sub>z

A useful special case of A.12 is:

>log<sub>b</sub>(y / b) = log<sub>b</sub>y - log<sub>b</sub> = log<sub>b</sub>y - 1

#### A.14

A third law relates logarithms to the base b and logarithms to the base 2:

>log<sub>b</sub>y = log<sub>2</sub>y / log<sub>2</sub>b

The are related by a constant factor, log<sub>2</sub>b

The logarithm of an integer is not, in general, an integer. The following functions therefore turn out to be useful in conjunction with logarithms. The floor of x is the largest integer not greater than x, and is written floor(x).

Likewise, ceiling of x is the smallest integer not less than x, and is written ceiling(x)
