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