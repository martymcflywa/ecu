# Chapter 1

## 1:

Use Euclid's algorithm, to find the GCD of the following pairs of numbers:

1. 6, 9
2. 12, 18
3. 15, 21
4. 11, 15

### Answers:

6, 9

```
1.  p = 6, q = 9
2.  p % q = 0?
	6 % 9 != 0
		2.1 r = p % q
			r = 6 % 9
			r = 6
		2.2 p = q
			p = 9
		2.3 q = r
			q = 6
3.  p % q = 0?
	9 % 6 != 0
		3.1 r = p % q
			r = 9 % 6
			r = 3
		3.2 p = q
			p = 6
		3.3 q = r
			q = 3
4.  p % q = 0?
	6 % 3 = 0
5.  q = 3
```

2. 12, 18

```
1.  p = 12, q = 18
2.  p % q = 0?
	12 % 18 != 0
		2.1 r = p % q
			r = 12 % 18
			r = 12
		2.2 p = q
			p = 18
		2.3 q = r
			q = 12
3.  p % q = 0?
	18 % 12 != 0
		3.1 r = p % q
			r = 6
		3.2 p = q
			p = 12
		3.3 q = r
			q = 6
4.  p % q = 0?
	12 % 6 = 0
5.	q = 6
```

3. 15, 21

```
1.	p = 15, q = 21
2.	p % q = 0?
	15 % 21 != 0
		2.1 r = p % q
			r = 15 % 21
			r = 15
		2.2 p = q
			p = 21
		2.3 q = r
			q = 15
3.	p % q = 0?
	21 % 15 != 0
		3.1 r = p % q
			r = 21 % 15
			r = 6
		3.2 p = q
			p = 15
		3.3 q = r
			q = 6
4.	p % q = 0?
	15 % 6 != 0
		4.1 r = p % q
			r = 15 % 6
			r = 3
		4.2 p = q
			p = 6
		4.3 q = r
			q = 3
5.	p % q = 0?
	6 % 3 = 0
6. q = 3
```

4. 11, 15

```
1.	p = 11, q 21
2.	11 % 21 != 0
	2.1 r = 11 % 21
		r = 11
	2.2 p = 21
	2.3 q = 11
3.	21 % 11 != 0
	3.1 r = 21 % 11
		r = 10
	3.2 p = 11
	3.3 q = 10
4.	11 % 10 != 0
	4.1 r = 11 % 10
		r = 1
	4.2 p = 10
	4.3 q = 1
5.	10 % 1 = 0
6.	q = 1
```

## 2:

Consider Newton's algorithm to calculate the square root of a number.

1. Use algorithm to calculate square roots of: 4, 6, 8, 9
	- In each case, calculate to accuracy of 0.01
		- ie. The absolute difference between a and r<sup>2</sup> is less than 0.01
2. Write a Java program to implement the algorithm and use it to check your answers
3. What would happen if step 2 of the algorithm were as follows?
	- 2. Until r<sup>2</sup> = a, repeat:

#### Answers:

##### 1:

Square root of 4.

```
1.	r = (1 + a) / 2
	r = (1 + 4) / 2
	r = 2.5
2. 	r^2 = a?
	2.5^2 != 4
		2.1 r = (r + (a / r)) / 2
			r = (2.5 + (4 / 2.5)) / 2
			r = 2.05
3.	r^2 = a?
	2.05^2 != a
		3.1 r = (r + (a / r)) / 2
			r = (2.05 + (4 / 2.05)) / 2
			r = 2.0006
4.	r^2 = a?
	2.0006^2 = a
5.	r = 2.0006
```

Square root of 6

```
1.	r = (1 + 6) / 2
	r = 3.5
2. 	3.5^2 != 6
	2.1 r = (3.5 + (6 / 3.5)) / 2
		r = 2.607
3.	2.607^2 != 6
	3.1 r = (2.607 + (6 / 2.607)) / 2
		r = 2.454
4.	2.454^2 != 6
	4.1 r = (2.454 + (6 / 2.454)) / 2
		r = 2.449
5.	2.449^2 = 6
6.	r = 2.449
```

## 3:

Give some examples of algorithms used in every day life, not requiring a calculator or computer.

## 4:

Write an algorithm to perform each of the following tasks:

1. Use an automated bank teller to withdraw cash from your account
2. Set the current time on your watch
3. Cook a frozen meal in a microwave
4. Match the pair of socks in a bundle of freshly laundered socks

## 5:

Try to find further examples of early algorithms like the ones given in this chapter.

## 6:

Devise an algorithm to find the roots of the general quadratic equation:

>ax<sup>2</sup> + bx + c = 0

The roots are the two values of the formula:

>(-b ± &radic;(b<sup>2</sup> - 4ac)) / 2a
