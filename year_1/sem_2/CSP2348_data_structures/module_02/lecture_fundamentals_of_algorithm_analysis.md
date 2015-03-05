# Fundamentals of algorithm analysis

## Fundamental principles of algorithms

- An **algorithm** is a step-by-step procedure for solving a stated problem in a finite amount of time (or finite steps)
	- It will be performed by a **processor**, which may be human, mechanical or electronic
	- It must be expressed in **steps** that the processor is capable of performing
	- It must eventually **terminate**
- An algorithm must be expressed in some **language** that the processor *understands*, but the underlying procedure is independent of the particular language chosen
- The stated problem must be **solvable**
	- ie. Capable of solution by a step-by-step procedure

## Time and space efficiency of algorithms

- Given several algorithms to solve the same problem, which algorithm is **best**?
- Given an algorithm, is it **feasible** to use it at all?
	- In other words, is it *efficient* enough to be usable in practice?
- How much **time** does the algorithm require?
- How much **space** (memory) does the algorithm require?
- In general, both time and space requirements depend on the algorithm's input
	- Typically, the *size* of the input

### A dummy question

- Matrix A(n, n) stores the same value, say x, in all its elements
- Which of the following algorithms would be the best (fastest) to sum all elements?

**Algorithm 1:**

![algorithm 1](http://snag.gy/tsT0g.jpg)

**Algorithm 2:**

![algorithm 2](http://snag.gy/yIbAN.jpg)

**Algorithm 3:**

![algorithm 3](http://snag.gy/8yn5F.jpg)

**Speculating answer:**

Algorithm 3 would be fastest, because it does not need to spend time iterating over each element in the array.

### Efficiency

![efficiency](http://snag.gy/g0lFv.jpg)

- Hypothetical profile of two sorting algorithms
- Algorithm B's time grows more slowly than A's

#### Measuring time

- Measure time in seconds?
	- Pro: Is useful in practice
	- Con: Depends on language, compiler, and processor
- Count algorithm steps?
	- Pro: Does not depend on compiler or processor
	- Con: Depends on granularity of steps
- Count **characteristic operations**
	- ie. Arithmetic operations in mathematical algorithms, comparisons in searching algorithms etc.
		- Pro: Depends only on the algorithm itself
		- Pro: Measures the algorithm's intrinsic efficiency

### Example: Simple power algorithm

Simple power algorithm to compute b<sup>n</sup>:

>1. Set p to 1
2. For i = 1, ... n, repeat:
	1. Multiply p by b
3. Terminate with answer p

#### Analysis

- Step 2.1 performs one multiplication
- This is repeated n times in Step 2
- Total number of multiplications = n

#### Implementation in Java

``` java
int simplePower(int b, int n) {

	// return b^n, where n >= 0
	if(n < 0) {
		return 0;
	} else {
		int p = 1;
		for(int i = 1; i <= n; i++) {
			p *= b;
		}
	}
	return p;
}
```

### Example: Smart power algorithm

- Idea
	- b<sup>1000</sup> = b<sup>500</sup> * b<sup>500</sup>, we can compute b<sup>1000</sup> with only one more multiplication!

To compute b<sup>n</sup>:

>1. Set p to 1, set q to b, and set m to n
2. While m > 0, repeat:
	1. If m is odd, multiply p by q
	2. Halve m (discard any remainder)
	3. Multiply q by itself
3. Terminate with answer p

#### Trying the smart algorithm

Run the algorithm, considering the case of n = 22:

![n = 22](http://snag.gy/DBaZT.jpg)

#### Binary format

![binary](http://snag.gy/WnTNe.jpg)

#### Analysis: Counting multiplications

- Steps 2.1 - 2.3 together perform at most 2 multiplications
	- They are repeated as often as we must halve the value of n (discarding any remainder) until it reaches 0
		- Which is floor(log<sub>2</sub>n) + 1 times
	- Maximum number of multiplications
		- = 2 * (floor(log<sub>2</sub>n) + 1)
		- = 2 * floor(log<sub>2</sub>n) + 2

#### Implementation in Java

``` java
int smartPower(int b, int n) {

	// return b^n, where n >= 0
	if(n < 0) {
		return 0;
	} else {
		int p = 1, q = b, m = n;
		while(m > 0) {
			if((m % 2) != 0) {
				p *= q;
			} else {
				m /= 2;
				q *= q;
			}
		}
	}
	return p;
}
```

### Comparison: Simple vs. smart algorithm

![comparison](http://snag.gy/2Wxie.jpg)

## Complexity of algorithms

- For many interesting algorithms, the exact number of operations is too difficult to analyse mathematically
- To simplify the analysis, we normally:
	- Identify the fastest-growing term
	- Neglect the slower-growing terms
	- Neglect the constant factor in the fastest-growing term
- The resulting formula is the algorithm's **time complexity**
	- It focuses on the **growth rate** of the algorithm's time requirement
- Similary for **space complexity**

### Analysis of simple power algorithm

- Counting multiplications
- Number of multiplications = n
- Time taken is approximately proportional to n
- Time complexity is **of order n**
	- This is written as **O(n)**

### Analysis of smart power algorithm

- Counting multipications
- Maximum number of multiplications
	- = 2 \* floor(log<sub>2</sub>n) **+ 2**
		- Neglect slow-growing term, + 2
- Simplified to
	- **2 \*** floor(log<sub>2</sub>n)
		- Normalize constant factor, 2
- Simplified to
	- **floor**(log<sub>2</sub>n)
		- Neglect floor(), which subtracts a constant value < 1.0 from log<sub>2</sub>n
- Simplified to
	- log<sub>2</sub>n
- Time complexity is **of order (log<sub>2</sub>n)**
	- This is written as **O(log<sub>2</sub>n)**

### Comparison: Simple vs. smart algorithm

![comparison](http://snag.gy/SqtkQ.jpg)

## Complexities

- We have seen that an O(log n) algorithm is inherently better than an O(n) algorithm for large values of n
	- O(log n) signifies a slower growth rate than O(n)
- Complexity O(Y) means **of order Y**
	- ie. Growing proportionally to Y
	- Signifies the growth rate, neglecting slower-growing terms and constant factors

### Common time complexities

- O(1) **Constant** time
	- Feasible
- O(log n) **Logarithmic** time
	- Feasible
- O(n) **Linear** time
	- Feasible
- O(n log n) **Log linear** time
	- Feasible
- O(n<sup>2</sup>) **Quadratic** time
	- Sometimes feasible
- O(n<sup>3</sup>) **Cubic** time
	- Less often feasible
- O(2<sup>n</sup>) **Exponential** time
	- Rarely feasible

### O(2<sup>n</sup>): Tower of Hanoi

>Is there any algorithm whose intrinsic growth rate (or complexity) is of order O(2<sup>n</sup>)?

- Yes, many of them
- One example is *The tower of Hanoi*
	- Given n disks, it needs at least 2<sup>n</sup> - 1 movements to move them from one tower to another tower
	- Why? Try it

![tower of hanoi](http://snag.gy/RLFz3.jpg)

Moving n disks from Pole A to Pole C, via Pole B:

![tower of hanoi table](http://snag.gy/mcFGq.jpg)

## Growth rates

Comparison of growth rates:

![growth rates](http://snag.gy/qb0nI.jpg)

Graphically:

![growth rate graph](http://snag.gy/X0o8N.jpg)

## Big-O notation

In terms of growth rates slowest to fastest:

**O(1) < O(log n) < O(n) < O(n log n) < O(n<sup>2</sup>) < O(n<sup>3</sup>) < ... < O(2<sup>n</sup>)**

### O notation operations

#### Rule 1

>O(g(n) ± h(n)) = O(g(n)) ± O(h(n)) &rArr; max{O(g(n)), O(h(n))}

#### Rule 2

>O(g(n) * h(n)) = O(g(n)) * O(h(n))

#### Rule 3

>O(g(n) / h(n)) = O(g(n)) / O(h(n))

### Big-O notation example

>An algorithm consists of 3 steps performed in sequence

>1. Takes a constant number of operations c to create a file
2. Takes b * n operations to read n values into the file
3. Takes a * n<sup>2</sup> operations to sort the n values in ascending order

>What is the time complexity of this algorithm?

#### Solution 1

Suppose a, b and c are constants, n is variable.

Total number of operations:

>T<sub>n</sub>  
= S1 + S2 + S3  
= c + b * n + a * n<sup>2</sup>

Thus:

>O(T<sub>n</sub>)  
= O(c + b * n + a * n<sup>2</sup>)  
= max{O(c), O(b * n), O(a * n<sup>2</sup>)}  
= O(a * n<sup>2</sup>)

Normalizing,

>O(T<sub>n</sub>)  
= O(n<sup>2</sup>)

#### Solution 2

Suppose a, b and c are constants, n is variable.

>Step 1 = O(S1) = O(c) = O(1)  
Step 2 = O(S2) = O(b * n) = O(n)  
Step 3 = O(S3) = O(a * n<sup>2</sup>) = O(n<sup>2</sup>)

So:

>O(T<sub>n</sub>)  
= O(S1) + O(S2) + O(S3)  
= max{O(S1), O(S2), O(S3)}  
= max{O(1), O(n), O(n<sup>2</sup>)}

## Guide

- Reading
	- Chapter 2, Java Collections
	- Appendix A, Java Collections
- Tutorial 2
	- Algorithm analysis
