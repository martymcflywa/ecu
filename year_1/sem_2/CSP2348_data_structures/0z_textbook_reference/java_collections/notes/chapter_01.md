# 1: Introduction

## 1.1: Background

- Algorithms are procedures for solving stated problems

### Computing greatest common divisor (GDC)

Euclid's GDC algorithm

>1. Set p to m, set q to n
2. Until q exactly divides p, repeat:
	1. Set p to q, and set q to (p mod q)
3. Terminate with answer q

### Equation x<sup>2</sup> + bx = c

al Khwarizmi's algebraic algorithm

>1. Multiply b/2 by itself
2. Add c to the product
3. Take the square root of the sum
4. Let r be the difference between the square root and b/2
5. Terminate with answer r

### Multiplication using logarithms

>1. Convert y and z to their logarithms, log y and log z
2. Let l be the sum of log y and log z
3. Let x be the number such that log x = l
4. Terminate with answer x

The basic law of logarithm is:

>log(x * y) =  log(y) + log(z)

This leads directly to a multiplication algorithm, see steps above.

This algorithm is faster and less error prone than long multiplication. A number can be quickly converted to a logarithm (step 1) or from a logarithm (step 3) by looking up a table of logarithms.

#### Computing a square root

To compute approximately the square root of a positive real number a:

>1. Set r to the mean of 1 and a
2. Until r<sup>2</sup> is a sufficient good approximation to a, repeat:
	1. Set r to the mean of r and a/r
3. Terminate with answer r

Computing a square root of positive number x is equivalent to finding the side of a square whose area is x.

If we know two different numbers whose product is x, then we can be sure that the square root of x lies somewhere between them. Moreover, the mean of these two numbers is a better approximation to the square root that either of the two original numbers.

For example, neither 2 nor 3 is a good approximation to the square root of 6, but their mean 2.5 is better, and the mean of 2.5 and 2.4 is even better.

In step 2.1 of the algorithm above, the two numbers whos product is a are r and a/r. Their mean is a better approximation to the square root of a, so we replace r with this mean. We do this repeatedly, stopping only when we are satisfied that r is sufficiently close to the desired answer. We can check this by comparing r<sup>2</sup> with a.

## 1.2 Algorithms and programs

- An algorithm is a step by step procedure for solving a stated problem
	- Can be performed by a human or machine
- Must be broken down into steps that are simple enough to be performed by human or machine
- Algorithms are more abstract than programs
	- Algorithms can be expressed in any convenient language or notation
- Programs must be expressed in some programming language
- Programs are implementations of algorithms

## 1.3 Abstract data types and data structures

### Data structures

- Data structure is a systematic way of organising a collection of data
	- ie. Array
		- Static data structure because data capacity is fixed at the time of creation
	- Dynamic data structures can expand or contract in accordance with amount of data to be stored

### Abstract data types

- When an abstract data type has been desinged, the programmer implementing the abstract data type is only concerned with choosing a suitable data structure and implementing methods 
	- Does not worry about the abstract data type's future applications
- When a programmer uses the abstract data type, they are only concerned with using that type and calling its methods
	- Does not worry about how the abstract data type is implemented
- This separation is a fundamental principle of modular software design
	- A large application might require tens or even hundreds of abstract data types
		- Identification of these abstract data types helps to decompose the program into smaller, manageable modules that can be specified, coded, tested and debugged separately
