# Remedial mathematics for algorithm analysis

## Task 1: Test Euclid GCD algorithm

Euclid's GCD algorithm is shown on slides 7 - 8 in module 1 lecture. A segment of Java code applying this algorithm is given on slide 9 of slides.

Consider the two sets of paired integers (12, 18) and (54, 36):

1. Find the GCD of these two sets by:
	1. Verifying your answers by hand-testing the Euclid GCD algorithm
	2. Using the GCD Java program in your computer
2. Discuss the relationship between an algorithm and a program

### GCD (12, 18)

>p = 12  
q = 18  
r = (12 mod 18) = 12  
p = 18  
q = 12  
r = (18 mod 12) = 6  
p = 18  
q = 6  

GCD(12, 18) = 6

### GCD (54, 36)

>p = 54  
q = 36  
r = (54 mod 36) = 18  
p = 36  
q = 18  

GCD(54, 36) = 18

### GCD Algorithm

1. m = p;
2. n = q;
3. WHILE q % p != 0 (q does not exactly divide p);
	- r = (p mod q);
	- p = q;
	- q = r;
4. q = GDC;

## Task 2: Computation of powers of a number by different ways

Calculate 2<sup>6</sup> by hand in as many was as you can find and compare their efficiency in terms of multiplications.

>2<sup>6</sup> = 2 * 2 * 2 * 2 * 2 * 2 = 5 steps  
2<sup>6</sup> = 2 * 2 = 4; 4 * 4 * 4 = 3 steps  
2<sup>6</sup> = 2 * 2 * 2 = 8; 8 * 8 = 3 steps

## Task 3: Floor and ceiling functions in simplifying results from logarithm operations

Apply floor() and ceiling() functions to log<sub>2</sub>(56).

How many times can 56 be halved until 1?

>56 / 2 = 28  
28 / 2 = 14  
14 / 2 = 7  
7 / 2 = 3  
3 / 2 = 1    

log<sub>2</sub>(56) = 5

56 is not a power of 2, therefore log<sub>2</sub>(56) is a fractional number.

>floor(log<sub>2</sub>(56)) = 5  
ceiling(log<sub>2</sub>(56)) = 6