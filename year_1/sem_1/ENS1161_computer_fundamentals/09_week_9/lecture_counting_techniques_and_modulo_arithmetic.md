# Counting techniques and modulo arithmetic

## Modulo arithmetic and congruencies

If you look at a page of a calendar you may notice a pattern that is so obvious that it hardly seems worth mentioning.

![calendar](http://contently.com/strategist/wp-content/uploads/2012/01/calendar_icon3.png)

We can extend this from the days of a month to the whole set of integers:

```
..., -20, -13,  -6,   1,   8,  15,  22,  29,  36,  43,  50, ...
..., -19, -12,  -5,   2,   9,  16,  23,  30,  37,  44,  51, ...
..., -18, -11,  -4,   3,  10,  17,  24,  31,  38,  45,  52, ...
..., ..., ..., ..., ..., ..., ..., ..., ..., ..., ..., ..., ...
..., -14,  -7,   0,   7,  14,  21,  28,  35,  42,  49,  56, ...
```

Using the number 7 we can separate the integers into seven sets, and within each set, any two members differ from each other by a multiple of 7.

For example, we could separate the integers into three sets so that any two members of one set differed from each other by a multiple of 3:

```
..., -12, -9, -6, -3, 0, 3, 6,  9, 12, 15, ...
..., -11, -8, -5, -2, 1, 4, 7, 10, 13, 16, ...
..., -10, -7, -4, -1, 2, 5, 8, 11, 14, 17, ...
```

These observations may seem obvious and even trivial, but vast amounts of research money are being spend on simple sets of numbers such as these, because they have very important applications.

### Definition of congruence

If two integers `a` and `b` differ by a multiple of some natural number `m`, we say that "`a` is congruent to `b` modulo `m`", and we write this as:

`a ≡ b (mod m)`

For example, from the sets of numbers we obtained from the calendar, we can say that:

`50 ≡ 1 (mod 7), and 40 ≡ -2 (mod7)`

Similarly

`78 ≡ 43 (mod 7)`

because the difference between 78 and 43 is 35, which is a multiple of 7.

### Congruence examples

`22 ≡ 7 (mod 5)`  
Because 22 and 7 differ by 15, which is a multiple of 5

`54 ≡ 4 (mod 5)`  
Because the difference is 50, which is a multiple of 5

`41 ≡ 16 (mod 5)`  
Because the difference is 25, which is a multiple of 5

`67 ≡ 23 (mod 11)`  
Because 67 and 23 differ by 44, which is a multiple of 11

`86 ≡ 20 (mod 11)`  
Because the difference is 66, which is a multiple of 11

`30 ≡ 8 (mod 11)`  
Because the difference is 22, which is a multiple of 11

## Least residues

Obviously a given number is congruent to many other numbers with respect to a particular modulus.

For example the numbers:

```
..., -20, -13, -6, 1, 8, 15, 22, 29, 36, 43, 50, ...,
```

are all congruent to each other modulo 7.

In any set of congruent numbers, there is always a smallest non-negative number, and we call it the least residue.

For example, when dividing by 7, the possible remainders are 0, 1, 2, 3, 4, 5 and 6, and so these are the least residues modulo 7.

Calculations using modulo arithmetic can be greatly simplified by replacing numbers by their least residues.

### Finding least residues using a calculator

#### Example 1

Find the least residue modulo 7 of 1583.

In plan english, the question is:

>Find the remainder when 1583 is divided by 7.

Using the calculator:

```
1583 / 7 = 2261428571...
```

In other words, 1583 = 226 * 7 + remainder.

Therefore the remainder is, using a calculator:

```
1583 - 226 * 7 = 1
```

#### Example 2

Find the least residue modulo 31 of 577.

>Find the remainder when 577 is divided by 31.

Using the calculator:

```
577 / 31 = 18.612903...
577 = 18 * 31 + remainder
577 - 18 * 31 = 19
```

So the least residue (mod 31) of 577 is 19.

### Exercises

**1:** 381 (mod 21)

```
381 / 21 = 18.142857...
381 = 21 * 18 + remainder
381 - 21 * 18 = 3
```

`381 (mod 21) ≡ 3 (mod 21)`

**2:** 602 (mod 45)

```
602 / 45 = 13.377777...
602 = 45 * 13 + remainder
602 - 45 * 13 = 17
```

`602 (mod 45) ≡ 17 (mod 45)`

**3:** 2000 (mod 57)

```
2000 / 57 = 35.087719...
2000 = 57 * 35 + remainder
2000 - 57 * 35 = 5
```

`2000 (mod 57) ≡ 5 (mod 57)`

### Why are least residues important?

Important applications of modulo arithmetic are found in the generation of pseudo-random numbers, and cryptography.

Both of these applications, and especially cryptography, involve calculations with very large numbers.

We can often simplify calculations by replacing a number by its least residue (or a simpler number to which it is congruent).

#### Example 1

Suppose we have to calculate the product:

`423 × 562 × 841 (mod 7)`

##### The long way

`423 × 562 × 841 = 199927566`

then

`199927566 ÷ 7 = 28561080 + remainder`

so

`199927566 – 28561080 × 7 = 6`

therefore,

`423 × 562 × 841 ≡ 6 (mod 7)`

##### The short way

`423 ≡ 3 (mod 7), 562 ≡ 2 (mod 7) and 841 ≡ 1 (mod 7)`

Replacing each number by its least residue, it follows that:

`423 × 562 × 841 ≡ 3 × 2 × 1 ≡ 6 (mod 7)`

Remember when using modulo arithmetic, the calculations are much simpler if you replace numbers by their least residues.

## Solution of congruencies

The theory of solution of congruence's is beyond the scope of this unit, so we will consider only very simple examples that can easily be solved by trying every possible solution.

We will look at a few short-cuts, but if all else fails, one can always resort to trial and error.

So remember, if we are trying to solve congruence's modulo `m`, then there are only `m` possible solutions, namely the least residues, 0, 1, 2, ..., `m`-1.

So a *fail-safe* method is simply to try every possible least residue.

### Example 1

Solve for `x`, `x + 3 ≡ 1 (mod 7)`

We could try `x ≡ 0`, `x ≡ 1`, ... etc, and we would find that `x = 5` is a solution.

Alternatively, since we can replace a number by another that is congruent to it, we can replace 1 by 8, and consider `x + 3 ≡ 8 (mod 7)`

So `x ≡ 5` is a solution.

### Example 2

Solve `x`, `x + 4 ≡ 1 (mod 11)`

Using the *fail-safe* method, we could try `x ≡ 0`, `x ≡ 1`, ... etc, and we would find that `x ≡ 8` is a solution.

Alternatively, we could replace 1 by 12, and consider `x + 4 ≡ 12 (mod 11)`

So `x ≡ 8` is a solution.

### Example 3

Solve `x`, `3x ≡ 1 (mod 7)`

Using the *fail-safe* method, we could find that `x ≡ 5` is a solution.

Alternatively, we could replace 1 by 15 (since `1 ≡ 15 (mod 7)`) and consider `3x ≡ 15 (mod 7)`

So `x ≡ 5` is a solution.

### Example 4

Solve `x`, `7x ≡ 2 (mod 10)`

Using the *fail-safe* method, we would find that `x ≡ 6` is a solution.

Alternatively, we could replace 2 by 42 (since `2 ≡ 42 (mod 10)`) and consider `7x ≡ 42 (mod 10)`

So `x ≡ 6` is a solution.

## Solution of congruencies

Note that in the next type of congruence, which involves the square of the variable, the surest way is to try each possible least residue. There may be one solution, or more than one solution, or there may be no solution. So it is important to try all possibilities.

### Example 5

Solve `x`, `x`<sub>2</sub>` ≡ 4 (mod 9)`

```
x = 0: 0 mod 9 = 0
x = 1: 1 mod 9 = 1
x = 2: 2 mod 9 = 4 ** answer
x = 3: 9 mod 9 = 0
x = 4: 16 mod 9 = 7
x = 5: 25 mod 9 = 7
x = 6: 36 mod 9 = 0
x = 7: 42 mod 9 = 4 ** answer
x = 8: 64 mod 9 = 1
```

`x ≡ 2 and 7`

### Example 6

Solve `x`, `x`<sup>2</sup>` ≡ 5 (mod 9)`

```
x = 0: 0 mod 9 = 0
x = 1: 1 mod 9 = 1
x = 2: 4 mod 9 = 4
x = 3: 9 mod 9 = 0
x = 4: 16 mod 9 = 9
x = 5: 25 mod 9 = 7
x = 6: 36 mod 9 = 0
x = 7: 49 mod 9 = 4
x = 8: 64 mod 9 = 1
```

No solution

### Example 7

Solve `x`, `x`<sup>2</sup>` ≡ 1 (mod 8)`

```
x = 0: 0 mod 8 = 0
x = 1: 1 mod 8 = 1 ** answer
x = 2: 4 mod 8 = 4
x = 3: 9 mod 8 = 1 ** answer
x = 4: 16 mod 8 = 0 
x = 5: 25 mod 8 = 1 ** answer
x = 6: 36 mod 8 = 4
x = 7: 49 mod 8 = 1 ** answer
```

`x ≡ 1, 3, 5 and 7`

## Generation of pseudo-random numbers

Sometimes it is necessary to generate numbers randomly from a set of possible numbers, so that each number in the set has an equal chance of being generated.

For example, such random numbers could be used to simulate customer arrival times at a service point. Could be telephone calls, aircraft arrival, customers arriving at check out etc.

Random numbers are also used in the generation of samples from a population in order to conduct a poll or marketing survey; or to generate test input for checking a computer program.

They are also used to generate the output from gambling devices such as poker machines.

Numbers that are generated by a computer for such purposes are called pseudo-random numbers.

A common way to generate pseudo-random numbers is to use a rule based on modulo arithmetic.

The proces begins with some number, called a **seed** and then sequence of numbers is generated from that seed, using formulae such as:

>Given x<sub>0</sub>, calculate x<sub>1</sub>, x<sub>2</sub>, x<sub>3</sub>, ..., using x<sub>n</sub> ≡ a x<sub>n-1</sub> (mod m)

### Example

Suppose we have to generate 10 pseudo-random numbers using 

>x<sub>0</sub> = 5731, x<sub>n</sub> ≡ 5731 x<sub>n-1</sub> (mod 65536)

The first pseudo-random number is

>x<sub>1</sub> ≡ 5731 x<sub>0</sub> ≡ 5731 * 5731 ≡ 28847641 ≡ 11801 (mod 65536)

Then the next pseudo-random number is

>x<sub>2</sub> ≡ 5731 x<sub>1</sub> ≡ 5731 * 11801 ≡ 63383171 ≡ 9859 (mod 65536)

The 10 pseudo-random numbers are:

>11801, 9859, 65137, 19659, 9993, 63955, 28129, 20379, 10489, 40995

To convert these to numbers from a uniform distribution from 0 to 1, we simply need to divide by 65536, giving:

>0.180069, 0.150436, 0.993912, 0.299973, 0.152481, 0.975876, 0.429214, 0.310959, 0.160049, 0.625534

Now to simulate the rolls of a dice, we could multiply each of these by 6 and round up to next integer, giving:

>2, 1, 6, 2, 1, 6, 3, 2, 1, 4

Or to simulate tosses of a coin, multiply the numbers from the uniform distribution by 2, and round up to the nearest integer, then take 1 as Heads and 2 as Tails:

>H, H, T, H, H, T, H, H, H, T

## Fast exponentiation

When working with applications of modulo systems, it is frequently necessary to calculate high powers of numbers. We need to recall two rules.

The first rule:

>a<sup>m</sup> * a<sup>n</sup> = a<sup>m + n</sup>

The second rule:

>(a<sup>m</sup>)n = a<sup>mn</sup>

### Examples 

Suppose we had to calculate the 16th power of some number *x*, that is x<sup>16</sup>.

We could do so using 15 operations:

>x<sup>16</sup> = x * x * x * x * x * x * x * x * x * x * x * x * x * x * x
Or, we could use just 4 operations:

>x<sup>16</sup> = (((x<sup>2</sup>)<sup>2</sup>)<sup>2</sup>)<sup>2</sup>

x<sup>64</sup> could be calculated with just 6 operations:

>x<sup>64</sup> = (((((x<sup>2</sup>)<sup>2</sup>)<sup>2</sup>)<sup>2</sup>)<sup>2</sup>)<sup>2</sup>

For example, suppose we had to calculate the 45th power, or x<sup>45</sup>. We could make use of the fact that:

>45 = 32 + 8 + 4 + 1

And therefore

>x<sup>45</sup> = x<sup>32</sup> * x<sup>8</sup> * x<sup>4</sup> * x

Again, if we need to calculate the 87th power, that is x<sup>87</sup>, we could use the fact that:

>87 = 64 + 16 + 4 + 2 + 1

And therefore

>x<sup>87</sup> = x<sup>64</sup> * x<sup>16</sup> * x<sup>4</sup> * x<sup>2</sup> * x

How do we know which powers of 2 do we need to make up a particular exponent?

Simply by looking at the binary representation. For example, the binary representation of 45 is 10111. In other words:

>45 = 1 * 2<sup>5</sup> + 0 * 2<sup>4</sup> + 1 * 2<sup>2</sup> + 0 * 2 + 1 * 1  
= 32 + 8 + 4 + 1

And the binary representation of 87 is 1010111, which means that

>87 = 1 * 2<sup>6</sup> + 0 * 2<sup>5</sup> + 1 * 2<sup>4</sup> + 0 * 2<sup>3</sup> + 1 * 2<sup>2</sup> + 1 * 2 + 1 * 1  
= 64 + 16 + 4 + 2 + 1

## Calculating higher powers using modulo arithmetic

We now combine the method for fast exponention with the simplifications obtained by replacing numbers by their least residues.

### Example 1

Calculate 3<sup>77</sup> (mod 11)

Convert to binary: 77<sub>10</sub> = 115<sub>8</sub> = 1001101<sub>2</sub>

Therefore: 77 = 64 + 8 + 4 + 1

Now we calculate powers of 3 whose exponenets are 2, 4, 8, ...

>3<sup>2</sup> ≡ 9, (mod 11)  
3<sup>4</sup> ≡ (3<sup>2</sup>)<sup>2</sup> ≡ 9<sup>2</sup> ≡ 81 ≡ 4 (mod 11)  
3<sup>8</sup> ≡ (3<sup>4</sup>)<sup>2</sup> ≡ 4<sup>2</sup> ≡ 16 ≡ 5 (mod 11)  
3<sup>16</sup> ≡ (3<sup>8</sup>)<sup>2</sup> ≡ 5<sup>2</sup> ≡ 25 ≡ 3 (mod 11)  
3<sup>32</sup> ≡ (3<sup>32</sup>)<sup>2</sup> ≡ 3<sup>2</sup> ≡ 9 (mod 11)  
3<sup>64</sup> ≡ (3<sup>64</sup>)<sup>2</sup> = 9<sup>2</sup> ≡ 81 ≡ 4 (mod 11)

Finally

>3<sup>77</sup> ≡ 3<sup>64</sup> * 3<sup>8</sup> * 3<sup>4</sup> * 3 ≡ 4 * 5 * 4 * 3 ≡ 20 * 12 ≡ 9 * 1 ≡ 9 (mod 11)

### Example 2

Calculate 7<sup>241</sup> (mod 23)

Convert to binary: 241<sub>10</sub> = 361<sub>8</sub> = 11 110 001<sub>2</sub>

Therefore: 241 = 128 + 64 + 32 + 16 + 1

Now we calculate powers of 7 whose exponents are 2, 4, 8, ...

>7<sup>2</sup> ≡ 49 ≡ 3 (mod 23)  
7<sup>4</sup> ≡ (7<sup>2</sup>)<sup>2</sup> ≡ 3<sup>2</sup> ≡ 9 (mod 23)  
7<sup>8</sup> ≡ (7<sup>4</sup>)<sup>2</sup> ≡ 9<sup>2</sup> ≡ 81 ≡ 12 (mod 23)  
7<sup>16</sup> ≡ (7<sup>8</sup>)<sup>2</sup> ≡ 12<sup>2</sup> ≡ 144 ≡ 6 (mod 23)  
7<sup>32</sup> ≡ (7<sup>16</sup>)<sup>2</sup> ≡ 6<sup>2</sup> ≡ 36 ≡ 13 (mod 23)  
7<sup>64</sup> ≡ (7<sup>32</sup>)<sup>2</sup> ≡ 13<sup>2</sup> ≡ 169 ≡ 8 (mod 23)  
7<sup>128</sup> = (7<sup>64</sup>)<sup>2</sup> ≡ 8<sup>2</sup> ≡ 64 ≡ 18 (mod 23)

Finally

>7<sup>241</sup> ≡ 7<sup>128</sup> * 7<sup>64</sup> * 7<sup>32</sup> * 7<sup>16</sup> * 7 ≡ 18 * 8 * 13 * 6 * 7 ≡ 144 * 78 * 7 ≡ 6 * 9 * 7 ≡ 8 * 7 ≡ 10 (mod 23)

Therefore

>7<sup>241</sup> ≡10 (mod 23)

## Cryptography

Modulo arithmetic is used extensively in cryptography.

Such systems are used extensively by governments, the military and commercial organisations.

The aim is to develop a system in which the information is encrypted very easily, but is effectively impossible to decrypt without the use of a key.

There is great interest in *one-way* functions, sometimes called *trapdoor* functions.

Functions *y = f(x)* such that, given *x*, one can easily find *y*, but given *y*, it is virtually impossible to find *x*.

Many of these functions involve modulo arithmetic.

As an illustration compare the following exercises to be done on a calculator.

Exercise 1: Find *x* so that 2<sup>x</sup> = 16384  
Exercise 2: Find *x* so that 3<sup>x</sup> ≡ 12 (mod 17)

The first exercise involves a simple exponential function. 

>2<sup>1</sup> = 2, 2<sup>2</sup> = 4, 2<sup>3</sup> = 8, 2<sup>4</sup> = 16, ..., etc.

We can solve the equation by a process of guessing and then improving on the guess.

We have to find *x* so that 2<sup>x</sup> = 16384.

Suppose we guess:

1: *x* = 16  
2<sup>16</sup> = 65536, too big  

2: *x* = 15  
2<sup>15</sup> = 32768, still too big

3: *x* = 14  
2<sup>14</sup> = 16384

So we have solved the equation.

But this is not the case for exponential functions using modulo arithmetic, as in the second exercise.

We have to find *x* so that 3<sup>x</sup> ≡ 12 (mod 17)

Our guesses:

1: *x* ≡ 9  
3<sup>9</sup> (mod 17) = 14, too big

2: *x* ≡ 8  
3<sup>8</sup> ≡ 16 (mod 17), bigger again

3: *x* ≡ 10  
3<sup>10</sup> ≡ 8 (mod 17), too small

After stumbling about trying various guesses we will eventually find that the answer is:

>x ≡ 13

To understand what is happening, consider the table of values and also the graph of the function:

>y = 3<sup>3</sup> (mod 17)

![crypto](http://i.imgur.com/FWxATDb.png)

Cryptography often relies on the use of very large prime numbers.

In fact there are two related problems upon which vast amounts of research time and money are spent:

- Trying to determine whether a number *n* is a prime
- Trying to find the factors of a number *n*

For small numbers we can solve either problem by dividing *n* by each of the primes 2, 3, 5, 7, ..., up to √*n*.

But for large numbers such methods are too slow.

Short-cuts are needed, but even with short-cuts, the problem is far from solved.

## Safe exchage of messages using modular arithmetic

Alice and Bob want to be able to send each other coded messages, and so they need a key that will be used to code and decode messages.

By using modular arithmetic they can agree upon a key that will be kept secret even though their messages are intercepted by Eve.

Suppose Alice and Bob agree to use the function 7<sup>x</sup> (mod 11).

This is how the system works:

- Alice chooses a number *A*, which she keeps secret
- Bob chooses a number *B*, which he keeps secret
- Alice calculates the number *α* = 7<sup>A</sup> (mod 11)
- Bob calculates the number *β* = 7<sup>B</sup> (mod 11)
- Alice sends Bob the number *α*
- Bob sends Alice the number *β*
- Eve intercepts both these messages and so she knows *α* and *β*
- Alice calculates *β*<sup>A</sup> (mod 11)
- Bob calculates *α*<sup>B</sup> (mod 11)
- Now *β*<sup>A</sup> (mod 11) is equal to *α*<sup>B</sup> (mod 11) because:
	- *β*<sup>A</sup> = (7<sup>B</sup>)<sup>A</sup> = (7<sup>A</sup>)<sup>B</sup> = *α*<sup>B</sup>
- Eve has to solve 7<sup>A</sup> = *α* (mod 11) for *A*, or else solve 7<sup>B</sup> = *β* (mod 11)
for B
- Impossible for large numbers

### Exercise 1

- A = 5
- B = 7

Show that α = 10 and β = 6, and then β<sup>A</sup> and α<sup>B</sup> are both congruent to 10 (mod 11)

Solution:

Alice calculates β<sup>A</sup> (mod 11): 6<sup>5</sup> ≡ 10 (mod 11)
Bob calculates α<sup>B</sup> (mod 11): 10<sup>7</sup> ≡ 10 (mod 11)

Solve *x* for:

#### 1: 7<sup>x</sup> ≡ 2 (mod 11)

```
x = 0: 1 mod 11 = 1
x = 1: 7 mod 11 = 7
x = 2: 49 mod 11 = 5
x = 3: 343 mod 11 = 2
x = 4: 2401 mod 11 = 3
x = 5: 16807 mod 11 = 10
x = 6: 117649 mod 11 = 4
x = 7: 823543 mod 11 = 6
x = 8: 5764801 mod 11 = 9
x = 9: 40353607 mod 11 = 8
x = 10: 282475249 mod 11 = 1
```

>x = 3

#### 2: 7<sup>x</sup> ≡ 6 (mod 11)

```
x = 0: 1 mod 11 = 1
x = 1: 7 mod 11 = 7
x = 2: 49 mod 11 = 5
x = 3: 343 mod 11 = 2
x = 4: 2401 mod 11 = 3
x = 5: 16807 mod 11 = 10
x = 6: 117649 mod 11 = 4
x = 7: 823543 mod 11 = 6
x = 8: 5764801 mod 11 = 9
x = 9: 40353607 mod 11 = 8
x = 10: 282475249 mod 11 = 1
```

>x = 7

#### 3. 7<sup>x</sup> ≡ 1 (mod 11)

```
x = 0: 1 mod 11 = 1
x = 1: 7 mod 11 = 7
x = 2: 49 mod 11 = 5
x = 3: 343 mod 11 = 2
x = 4: 2401 mod 11 = 3
x = 5: 16807 mod 11 = 10
x = 6: 117649 mod 11 = 4
x = 7: 823543 mod 11 = 6
x = 8: 5764801 mod 11 = 9
x = 9: 40353607 mod 11 = 8
x = 10: 282475249 mod 11 = 1
```

>x = 0 and 10

## Counting techniques

In computer science it is sometimes necessary to calculate.

"How many?" for example, how many different ways a task can be performed, or how many different possibilities there are, or how many times an operation has to be performed, or how many different arrangements could there be, and so on.

There are different *counting techniques* for such calculations.

### The addition principle

We have already met the addition principle in week 2.

Briefly, if there are two sets *A* and *B*, and if set *A* has *n(A)* elements and set *B* has *n(B)* elements, then the number of elements in the union *A∪B* is

>n(A∪B) = n(A) + n(B) – n(A∩B)

In other words we must make allowance for elements that belong to both sets, and make sure that they are not counted more than once.

### The multiplication principle

Consider a simple example.

Suppose that there are two roads from town *A* to town *B* and three roads from town *B* to town *C*.

Then the number of different ways to travel from town *A* to town *C* 

>2 * 3 = 6

If also there are two roads from town *C* to town *D*, then the number of ways to travel from town *A* to town *D* is

>2 * 3 * 2 = 12

As another example, suppose a menu offers 2 different soups, 3 main courses and 4 desserts. Then if we choose one soup, one main course and one dessert, there are 2 * 3 * 4 different possible meals.

This idea applies to the number of ways that a series of tasks can be done, the number of ways a series of choices can be made and so on.

Suppose that there are *k* different "things".

If there are:

>n<sub>1</sub> ways of doing the 1st "thing", and  
n<sub>2</sub> ways of doing the 2nd "thing", and  
n<sub>3</sub> ways of doing the 3rd "thing", and  
...  
n<sub>k</sub> ways od doing the kth "thing",

then the total number of ways doing ALL THE THINGS is:

>n<sub>1</sub> * n<sub>2</sub> * n<sub>3</sub> * ... * n<sub>k</sub>

This is called the multiplication principle.

#### Example 1

Suppose a licence plate for a vehicle must have 2 letters of the alphabet followed by and 3 decimal digits.

ie: GW694

There are 26 ways of choosing the first letter, and 26 ways of choosing the second letter.

Then there are 10 ways of choosing each of the digits.

So the number of possible plates is:

>26 * 26 * 10 * 10 * 10 * 10 = 676000

#### Example 2

Suppose you must toss a coin, roll a dice and select a card from a set of four different cards

How many different possible outcomes are there?

There are two possible results from tossing a coin, heads or tails, six possible results from tossing the dice, 1 - 6, and four different results from choosing the card.

So the number of different possible outcomes is:

>2 * 6 * 4 = 48

## Four types of problems

Although it would be possible to solve most types of counting problems using the addition and/or the multiplication principles, there are some easily recognised type of problems that occur frequently.

We consider four different types.

Each involves the selection of a number of items from a larger collection.

At first glance the problems may look similar, but in fact they are quite different.

There are two key criteria to distinguish the different types:

>Is order important?  
Are repititions allowed?

The answers to these two questions indicate whether the problem involves **sequences**, **permutations**, **subsets** or **multisets**.

Multisets do not appear to have many applications in computer science and are mentioned only for completeness.

| Type         | Order important | Repetition allowed |
|--------------|:---------------:|:------------------:|
| Sequences    | Yes             | Yes                |
| Permutations | Yes             | No                 |
| Subsets      | No              | No                 |
| Multisets    | No              | Yes                |

### Examples of the different types

The following examples illustrate the different types. In each case, three objects are to be selected from a set of 10.

#### Type 1: Sequences

How many 3-digit decimal numbers are there, that is from 000 to 999?

**Order is important**  
**Repitition is allowed**

For example, 337 and 444 are 3-digit decimal numbers.

So this type of problem involves *sequences*.

#### Type 2: Permutations

There is a committee of 10 people, from which a president, a secretary and a treasurer must be elected.

How many possible outcomes are there?

**Order is important**  
**Repetition not allowed** The same person cannot hold more than one office.

So this type of problem involves *permutations*.

#### Type 3: Subsets

A team of 10 players want transport from the airport to their hotel. A taxi arrives with room for 3 people. Choose any 3 players to take the taxi.

**Order is not important** Any three players can take the taxi  
**Repitition not allowed** We would not choose the same person twice

So this type of problem involves *subsets*.

#### Type 4:

There are unlimited supplies of 10 types of food available. You have 3 vouchers, and each voucher buys one food item. Choose 3 food items.

**Order is not important**  
**Repitition is allowed** It is permissable to choose more than one of a particular item

So this type of problem involves *multisets*.

