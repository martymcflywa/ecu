# Symbols

| Symbol  | Name                     | LaTeX           |Function
|---------|--------------------------|-----------------|--------------------------------------| 
| `~`     | `NOT`                    | `\sim{x}`       | Negates
| `˄`     | `AND`                    | `\wedge`        | And
| `˅`     | `OR`                     | `\vee`          | Or
| `→`     | `IF THEN`                | `\rightarrow`   | Conditional
| `≡`     | `LOGICAL EQUIVALENCE`    | `\equiv`        | Is equal to
| `├`     | `CONCLUSION`             | `\mid`          | Anything to the right of `├` is the conclusion
| `P(x):` | `Predicate`              |                 | A statement with one or more variables, I see it as a function
| `R`     | `SET` of real numbers    | `\mathbb{R}`    | 1.5, 2.5, 3.5
| `N`     | `SET` of natural numbers | `\mathbb{N}`    | 1, 2, 3
| `∈`    | `element of`             | `\in`           | sets membership
| `∉`     | `not element of`         | `\notin`        | negative of `∈`
| `∀`    | `for all`                | `\forall`       | quantifier "for every"
| `∃`    | `there exists`           | `\exists`       | quantifier "for some"
| `U`     | `universal set`          |                 | the `set` of all things that contains working parts of a problem
| `∅`     | `empty set`              | `\varnothing`   | self explanatory, null
| `{}`    | `empty set`              | `\{\}`          | self explanatory, null
| `⊆`    | `subset`                 | `\subseteq`     | a set of elements within another `set`
| `∩`     | `intersect`              | `\cap`          | the set of elements that are in common with...
| `∪`    | `union`                  | `\cup`          | the set of elements that are in **all** `sets`, except the `universal set`
| `'`     | `complement`             | `'`             | the set of elements that are in the `universal set`, but not in `A` for example
| `n(A)`  | `number of elements`     |                 | count how many elements are a member of `A`
| `A × B` | `cartesian product`      | `\times`        | the `×` denotes cartesian product of `A` then `B`
| `P(A)`  | `POWER SET`              |                 | `P` denotes the power set of `A`
| `R ○ S` | `followed by`            | `\bigcirc`      | The composition of `R` followed by `S`


# Analogy with logic concepts

The laws are essentially the same, but are just presented differently.

`~(A ˅ B) ≡ ~A ˄ ~B` corresponds to `(A ∪ B)' = A' ∩ B'`

| Logic   | Set  | Boolean | LaTeX   
|---------|------|---------|-----------
| `~`     | `'`  | `'`     |         
| `˄`     | `∩`  | `•`     | `\bullet`
| `˅`     | `∪` | `+`     |
| `true`  | `U`  | `1`     |
| `false` | `∅`  | `0`     |

# Laws

| Distributive Laws                    | de Morgan's Laws      |
|--------------------------------------|-----------------------|
| `p ˅ (q ˄ r) = (p ˅ q) ˄ (p ˅ r)`    | `~(p ˅ q) = ~p ˄ ~q`  |
| `p ˄ (q ˅ r) = (p ˄ q) ˅ (p ˄ r)`    | `~(p ˄ q) = ~p ˅ ~q`  |
| `p + q • r = (p + q) • (p + r)`      | `(p + q)' = p' • q'`  |
| `p • (q + r) = p • q + p • r`        | `(p • q)' = p' + q'`  |
| `A ∩ (B ∪ C) = (A ∩ B) ∪ (A ∩ C)`   | `(A ∪ B)' = A' ∩ B'` |
| `A ∪ (B ∩ C) = (A ∪ B) ∩ (A ∪ C)`  | `(A ∩ B)' = A' ∪ B'` |
| `(w + x)(y + z) = wy + wz + xy + xz` | `(x + y)' = x'y'`     |
| `x(w + y + z) = xw + xy + xz`        | `(xy)' = x' + y'`     |

## de Morgan's Laws

Is a three-step process when used for simplifying.

- If `(a + b)'`, then convert to product with `a'b'`
- Then for each element, `(xy)' = x' + y'` to convert to sum outside brackets
- Then complete expansion of brackets from `(a + b)(a + b)` to `aa + ab + ba + bb`

# Negations

## Statement Negations

| Statement   | Negation        |
|-------------|-----------------|
| All do...   | Some don't...   |
| All are...  | Some are not... |
| Some do...  | None do...      |
| Some are... | None are...     |

## Negation of `∀∃`

```
~(∀x ∈ P, ∃y ∈ M, S(x, y)) ≡ ∃x ∈ P, ∀y ∈ M, ~S(x, y)
```

## Negation of `∃∀`

```
~(∃y ∈ M, ∀x ∈ P, S(x, y)) ≡ ∀y ∈ M, ∃x ∈ P, ~S(x, y)
```

## Negation of `∃∃`

```
~(∃x ∈ P, ∃y ∈ M, S(x, y)) ≡ ∀x ∈ P, ∀y ∈ M, ~S(x, y)
```

## Negation of `∀∀`

```
~(∀y ∈ M, ∀x ∈ P, S(x, y)) ≡ ∃y ∈ M, ∃x ∈ P, ~S(x, y)
```

# Laws of Sets

The laws are in pairs, and can swap from a law to its dual (matching pair) by swapping `∪` with `∩`, and `U` with `∅`.

## Distributive Laws

```
A ∩ (B ∪ C) = (A ∩ B) ∪ (A ∩ C)
A ∪ (B ∩ C) = (A ∪ B) ∩ (A ∪ C)
```

## de Morgan's Laws:

```
(A ∪ B)' = A' ∩ B'
(A ∩ B)' = A' ∪ B'
```

# Power Sets

Is a collection of all the possible combinations of subsets, including `∅`, the empty set.

If `A = {1, 2, 3}` 

Then `P(A) = [∅, {1}, {2}, {3}, {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}]`

Formula to work it out is `2^n`, where `n = number of subsets`

# Boolean Algebra Laws

| Multiplication | Addition    |
|:--------------:|:-----------:|
| `0 x 0 = 0`    | `0 + 0 = 0` |
| `0 x 1 = 0`    | `0 + 1 = 1` |
| `1 x 0 = 0`    | `1 + 0 = 1` |
| `1 x 1 = 1`    | `1 + 1 = 1` |

## Laws for Complementation

- `0' = 1`
- `1' = 0`

## Idempotent Laws

- `a + a = a`
- `a • a = a`

## Complement Laws

- `a + a' = 1`
- `a • a' = 0`

## Involution Law

- `(a')' = a`

## Associative Laws

- `(a + b) + c = a + (b + c)`
- `(a • b) • c = a • (b • c)`

## Commutative Laws

- `a + b = b + a`
- `a • b = b • a`

## Distributive Laws

- `a + b • c = (a + b) • (a + c)`
- `a • (b + c) = a • b + a • c`

## de Morgan's Laws

- `(a + b)' = a' • b'`
- `(a • b)' = a' + b'`

## Identity Laws

- `a + 0 = a`
- `a • 1 = a`
- `a + 1 = 1`
- `a • 0 = 0`

# Fundamental Products

Formula to work out is how many fundamental products is `2^n`, where `n = number of variables`

There are two key concepts to remember:

- In a fundamental product, each variable must be present, with or without `'`
- Each fundamental product is equal to 1 for one and only one combination of the variables

# Multiplying matrices

1. The matrix on the left must have equal amount of columns as there is rows on the right hand side
2. The product will be `left side rows x right side columns`
3. Multiply each cell from row from left side with each cell in column from right side
4. Each product must then be added together to calculate the data for that cell
5. Repeat steps 3 and 4 until all cells have been covered for that particular row for the right side
6. Move to next row on left side, rinse and repeat
7. Remember Boolean laws for addition and multiplication

## Example

Here we are multiplying `A` with `B`

![multiply matrix 1](http://i.imgur.com/yse4TiD.png)

When each cell in rows from `A` is multiplied with each cell in columns from `B`, we get the following table:

| `AB` 1st row    | `AB` 2nd row    | `AB` 3rd row    | `AB` 4th row    | `AB` 5th row    |
|:---------------:|:---------------:|:---------------:|:---------------:|:---------------:|
| `0 + 0 + 0 + 0` | `1 + 0 + 0 + 0` | `1 + 0 + 0 + 1` | `0 + 0 + 0 + 0` | `0 + 0 + 0 + 1` |
| `0 + 0 + 0 + 0` | `0 + 1 + 0 + 0` | `0 + 0 + 0 + 0` | `0 + 1 + 0 + 0` | `0 + 0 + 0 + 0` |
| `0 + 0 + 1 + 0` | `0 + 0 + 1 + 0` | `0 + 0 + 0 + 0` | `0 + 0 + 0 + 0` | `0 + 0 + 0 + 0` |

Because of the Boolean laws of addition, any cell that has a `1` will become a `1`.  

Any cell without a `1` will become `0`.

Which results in the following Boolean product:

![multiply matrix 2](http://i.imgur.com/YNFw86Q.png)

# Functions

## Syntax

`f: A → B, f(x) = ...`  
`domain → codomain, rule`

## Range

When asked for range, provide all possible answers for function/s. Do not include duplicates.

## Conditions for functions

1. `∀a ∈ A, ∃b ∈ B, b = f(a)`
	- All items from domain must connect to something in sub-domain
2. `∀a, α ∈ A, a = α → f(a) = f(α)`
	- Item from domain cannot be used twice to connect to something in sub-domain

## Onto and one-to-one

### Onto

Function links to all objects of codomain.

![onto](http://i.imgur.com/YEcjGmr.png)

### One-to-one

Function links each object from domain once, and once only.

![one-to-one](http://i.imgur.com/5Z3oozp.png)

## Composite functions

Composite functions are nested inside each other within parenthesis, with the first function inside and the last function outside.

`h(g(f(x)))`

![comp func](http://i.imgur.com/5gCxcVt.png)

## Inverse functions

### Conditions for inversion

A function `f` has an inverse `f`<sup>-1</sup> **only** if `f` is "one-to-one" **and** "onto".

### Methods

- Two methods:
	1. `Take off shoes, then take off socks`
		- Reversing each function individually in reverse order
		- Remember to reverse the order rules for
			- Multiplication / Division
			- Addition / Subtraction
			- Parenthesis
	2. `Turn inside out and swap labels`
		- Breaking the function apart then swapping `x` for `y`
		- Can be applied to complex functions
		- I need to understand this better

#### Method 2: Turn inside out and swap labels

```
f(x) = √x + 2

y = √x + 2 // introduce arbritrary variable to help break formula apart
y^2 = x + 2 // reverse sq. root and move it left of equals
y^2 - 2 = x // reverse addition and move it left of equals
y = x^2 - 2 // move operations right of equals back to x
f^-1(x) = x^2 - 2 // replace y with f^-1 
```

## Checking inverse formula for function

Nest original function inside inverse function. Result should equal to `x` (the argument).

```
f(x) // original function
f^-1(x) // inverse function

f^-1(f(x)) // nested original function inside inverse function
f^-1(f(x)) =  x // result should equal to argument
```

### Example

```
h(x) = √x - 5 // original function
h^-1(x) = (x + 5)^2 // inverse function

= (h(x) + 5)^2 // nested original function inside inverse function
= (√x - 5 + 5)^2 // expanding original function to show formula
= x // result is equal to x, the original argument
```

# Converting Binary to Hex

Every 4 bits is 1 hex digit.

```
4 2 1 8 4 2 1
1 0 0 1 0 0 0 = 48
1 1 0 0 1 0 1 = 65
1 1 0 1 1 0 0 = 6C
1 1 0 1 1 1 1 = 6F
0 1 0 0 0 0 0 = 20
1 0 1 0 1 1 1 = 57
1 1 1 0 0 1 0 = 72
1 1 0 0 1 0 0 = 64
0 1 0 0 0 0 1 = 21
```

# Base numbers

## Base<sub>8</sub>

### Convert base<sub>10</sub> to base<sub>8</sub>

x = base<sub>10</sub> number  
y = integer  
z = remainder  

1. x<sub>10</sub> / 8 = y remainder z
2. Divide y by 8 until y = 0
3. Note z for each division (get modulus)
4. z reversed = base<sub>8</sub>

#### Example

42<sub>10</sub>

```
42 / 8 = 5 rem 2
5 / 8 = 0 rem 5
```

42<sub>10</sub> = 52<sub>8</sub>

### Convert base<sub>8</sub> to base<sub>10</sub>

1. Multiply each base<sub>10</sub> digit by 8<sup>x</sup>.
2. Sum = base<sub>10</sub>

#### Example

12345<sub>10</sub>

5 * 8<sup>0</sup> = 5  
4 * 8<sup>1</sup> = 32  
3 * 8<sup>2</sup> = 192  
2 * 8<sup>3</sup> = 1024  
1 * 8<sup>4</sup> = 4096  

5 + 32 + 192 + 1024 + 4096

= 5349<sub>10</sub>

#### Calculator shortcut

Wrap each base<sub>8</sub> digit inside parenthesis, and multiply by 8. The last digit should not be wrapped as it is multiplied by 8<sup>0</sup> (which is 1).

Convert 12345<sub>8</sub> to base<sub>10</sub>

```
((((1 * 8) + 2) * 8 + 3) * 8 + 4) * 8 + 5
```

= 5349<sub>10</sub>

## Base<sub>2</sub>

### Convert base<sub>10</sub> to base<sub>2</sub>

#### Method 1

Similar to base<sub>10</sub> to base<sub>8</sub>:

x = base<sub>10</sub> number  
y = integer  
z = remainder

1. x<sub>10</sub> / 2 = y remainder z
2. Divide y by 8 until y = 0
3. Note z for each division (get modulus)
4. z reversed = base<sub>2</sub>

##### Example

Convert 42<sub>10</sub> to base<sub>2</sub>:

```
42 / 2 = 21 rem 0
21 / 2 = 10 rem 1
10 / 2 = 5 rem 0
5 / 2 = 2 rem 1
2 / 2 = 1 rem 0
1 / 2 = 0 rem 1
```

42<sub>10</sub> = 101010<sub>2</sub>

#### Method 2

1. Convert base<sub>10</sub> to base<sub>8</sub>
2. Replace base<sub>8</sub> with base<sub>2</sub> equivalent
	- Base<sub>8</sub> = x<sup>3</sup>, will always produce 3-bit binary

| Base<sub>10</sub> | Base<sub>2</sub> |
|------------------:|------------------|
| 0                 | 000              |
| 1                 | 001              |
| 2                 | 010              |
| 3                 | 011              |
| 4                 | 100              |
| 5                 | 101              |
| 6                 | 110              |
| 7                 | 111              |

##### Example

Convert 42<sub>10</sub> to base<sub>2</sub>:

1. Convert base<sub>10</sub> to base<sub>8</sub>
	- = 52<sub>8</sub>
2. Replace base<sub>8</sub> with base<sub>2</sub> equivalent
	- = 101010<sub>2</sub>

### Convert base<sub>2</sub> to base<sub>10</sub>

#### Method 1

1. Sum the powers of 2 for each 1

##### Example

Convert 1010011<sub>2</sub> to base<sub>10</sub>:

1. Sum the powers of 2 for each 1
	- 1 * 2<sup>0</sup> +
	- 1 * 2<sup>1</sup> +
	- 0 * 2<sup>2</sup> +
	- 0 * 2<sup>3</sup> +
	- 1 * 2<sup>4</sup> +
	- 0 * 2<sup>5</sup> +
	- 1 * 2<sup>6</sup>

```
64 + 0 + 16 + 0 + 0 + 2 + 1
= 83
```

1010011<sub>2</sub> = 83<sub>10</sub>

#### Method 2

1. Make 3-bit base<sub>2</sub> groups
	- Add leading 0's to create a 3-bit group if required
2. Replace each 3-bit base<sub>2</sub> group with base<sub>8</sub> equivalent
3. Convert base<sub>8</sub> to base<sub>10</sub>

##### Example

Convert 1010011<sub>2</sub> to base<sub>10</sub>:

1. Make 3-bit base<sub>2</sub> groups
	- 001 010 011<sub>2</sub>
		- Added leading 0's to last group on left
2. Replace each 3-bit base<sub>2</sub> group with base<sub>8</sub> equivalent
	- 001 = 1
	- 010 = 2
	- 011 = 3
3. Convert base<sub>8</sub> to base<sub>10</sub>
	- 123<sub>8</sub> = 83<sub>10</sub>

1010011<sub>2</sub> = 83<sub>10</sub>

## Base<sub>16</sub>

### Convert base<sub>10</sub> to base<sub>16</sub>

1. Divide base<sub>10</sub> by 16
	- Whole number becomes the first digit
	- Remainder becomes the 2nd.

#### Example

Convert 90<sub>10</sub> to base<sub>16</sub>

```
90 / 16
= 5 rem 10
= 5A
```

90<sub>10</sub> = 5A<sub>16</sub>

### Convert base<sub>16</sub> to base<sub>10</sub>

1. Multiply each digit to the powers of 16

#### Example

Convert 5A<sub>16</sub> to base<sub>10</sub>

1. Multiply each digit to the powers of 16
	- A * 16<sup>0</sup> +
	- 5 * 16<sup>1</sup>

```
10 + 80
= 90
```

5A<sub>16</sub> = 90<sub>10</sub>

### Convert base<sub>16</sub> to base<sub>2</sub>

Base<sub>16</sub> is x<sup>4</sup>, will always produce a 4-bit binary.

Use the following table as a guide to converting base<sub>16</sub> to base<sub>2</sub>.

| Base<sub>16</sub> | Base<sub>2</sub> |
|------------------:|:-----------------|
| 0                 | 0000             |
| 1                 | 0001             |
| 2                 | 0010             |
| 3                 | 0011             |
| 4                 | 0100             |
| 5                 | 0101             |
| 6                 | 0110             |
| 7                 | 0111             |
| 8                 | 1000             |
| 9                 | 1001             |
| A                 | 1010             |
| B                 | 1011             |
| C                 | 1100             |
| D                 | 1101             |
| E                 | 1110             |
| F                 | 1111             |

1. Replace each base<sub>16</sub> digit with corresponding 4-bit base<sub>2</sub> digit
2. Combine and remove any leading 0's

#### Example

Convert 5A<sub>16</sub> to base<sub>2</sub>

1. Replace each base<sub>16</sub> digit with corresponding 4-bit base<sub>2</sub> digit
	- 5 = 0101
	- A = 1010
2. Combine and remove any leading 0's
	- 1011010

5A<sub>16</sub> = 1011010<sub>2</sub>

### Convert base<sub>2</sub> to base<sub>16</sub>

1. Make 4-bit base<sub>2</sub> groups
	- Add leading 0's to create a 3-bit group if required
2. Replace each group with base<sub>16</sub> equivalent

#### Example

Convert 1011010<sub>2</sub> to base<sub>16</sub>

1. Make 4-bit base<sub>2</sub> groups
	- 0101 1010<sub>2</sub>
		- Added leading 0's to last group on left
2. Replace each group with base<sub>16</sub> equivalent
	- 0101 = 5<sub>8</sub>
	- 1010 = A<sub>8</sub>

1011010<sub>2</sub> = 5A<sub>16</sub>

## Fractions

### Base<sub>10</sub> fraction to base<sub>2</sub> fraction

1. Multiply base<sub>10</sub> digits right of decimal by 2, until no more decimals appear
	- Do not include integers when multiplying
2. Count integers as the answer resulting in binary number but is read from top down
	- Which is reverse of when converting non fraction base<sub>10</sub> to base<sub>2</sub>

#### Example

Convert 0.34375<sub>10</sub> to base<sub>2</sub> fraction

1. Multiply base<sub>10</sub> digits right of decimal by 2, until no more decimals appear
	- Do not include integers when multiplying
		- 0.34375 * 2 = 0.6875
		- 0.6875 * 2 = 1.375
		- 0.375 * 2 = 0.75
		- 0.75 * 2 = 1.5
		- 0.5 * 2 = 1.0
2. Count integers as the answer resulting in binary number but is read from top down
	- 01011

0.34375<sub>10</sub> = 0.01011<sub>2</sub>

### Base<sub>2</sub> fraction to base<sub>10</sub> fraction

1. Ignore decimal point
2. Convert base<sub>2</sub> to base<sub>10</sub>
3. x / 2<sup>y</sup> = base<sub>10</sub>
	- x = converted base<sub>10</sub>, y = decimal places

#### Example

Convert 0.01011<sub>2</sub> to base<sub>10</sub>

1. Ignore decimal point
	- 01011
2. Convert base<sub>2</sub> to base<sub>10</sub>
	- 01011 = 11<sub>10</sub>
3. x / 2<sup>y</sup> = base<sub>10</sub>
	11 / 2<sup>5</sup> = 0.34375

0.01011<sub>2</sub> = 0.34375<sub>10</sub>

## Additions

### Base<sub>8</sub> addition

- Rule for octal addition:  
	- If sum is => 8, subtract 8, carry 1.

```
47 + 35
7 + 5 		= 12 - 8 	= 4 carry 1
1 + 4 + 3 	= 8 - 8 	= 0 carry 1
1 + 0 		= 1
```

= 104<sub>8</sub>  

### Base<sub>2</sub> addition

- Rules for binary addition:
	- 1 + 1 = 10 carry 1
	- 1 + 1 + 1 = 11 carry 1
	- 1 + 0 = 1
	- 0 + 1 = 1
	- 0 + 0 = 0

#### Example

```
1101 + 111
1 + 1 		= 0 carry 1
1 + 0 + 1 	= 0 carry 1
1 + 1 + 1 	= 1 carry 1
1 + 1 		= 0 carry 1
1 + 0 		= 1
```

= 10100<sub>2</sub>

### Base<sub>16</sub> addition

- Rule for hex addition
	- If sum is > 15, subtract 16, carry 1.
	- Use A - F for sums between 10 - 15

#### Example

```
5B8 + FA6
8 + 6 					= E
B + A 		= 21 - 16 	= 5 carry 1
1 + 5 + F 	= 21 - 16 	= 5 carry 1
1 + 0 					= 1
```

= 155E<sub>16</sub>

### Base<sub>16</sub> additon to BCD

BCD numbers are 4-bit binary codes for digits between 0-9. When converting from base<sub>16</sub> make sure that no *invalid* binary codes are included by following the rules below.

Invalid codes are base<sub>2</sub> equivalents for A - F.

- Rules to make base<sub>16</sub> BCD friendly
	- If sum > 9 (or had to carry), add 6, carry 1
		- If sum > 15, subtract 16 carry 1
	- If sum =< 9, add 0

### Example

5886<sub>16</sub> + 4938<sub>16</sub>

```
1111  // carry
 5886
 4938 +
-----
1A2CE // no carry when adding 6 or 0
 6666
-----
10824
```

= 10824<sub>16</sub>

To check work, just add the two numbers normally as decimal, should also == to answer.

# Signed and unsigned integers

## Range

### Unsigned

8-bit unsigned binary has range between:

0000 0000 to 1111 1111  
or  
0<sub>10</sub> - 255<sub>10</sub>

16-bit unsigned binary has range between:

0000 0000 0000 0000 to 1111 1111 1111 1111  
or  
0<sub>10</sub> to 65535<sub>10</sub>

### Signed

8-bit signed integers have a negative number range and a positive number range. The MSB determines if integer is positive or negative.

MSB 0 = positive number  
MSB 1 = negative number

0000 0000 to 0111 1111 = positive number  
1000 0000 to 1111 1111 = negative number

Range is between -128<sub>10</sub> to +127<sub>10</sub>

## Converting negative integer to 2's complement

1. Drop minus sign
2. Convert decimal to 8-bit binary
3. Find 1's complement
4. Add 1.

```
 -48
= 48            // dropped minus sign
= 60_8          // converted to b8
= 0011 0000     // converted to b2
= 1100 0000 + 1 // 1's complement + 1
= 1100 0001     // result in 2's complement form
```

## Convert 2's complement to integers

### Positive number (starting with 0)

Just use normal method to convert to decimal

### Negative number (starting with 1)

1. Find 1's complement
2. Add 1
3. Convert result to binary
3. Add minus sign

```
  1101 0111
= 0010 1000 + 1 // 1's complement + 1
= 0010 1001
= 29_16         // convert b2 to b16
= 41_10         // convert b16 to b10
= -41_10        // add minus sign
```

## C, N and V flags

Flag positions:

![cnv positions](http://i.imgur.com/JbMWPqv.png)

### C flag

C Flag only used for unsigned integers.

| Flag | Byte | Description                        |
|:----:|:----:|------------------------------------|
| C    | 0    | No overflow, output remains 8-bit  |
| C    | 1    | Overflow, extend output to 16-bit  |

### N and V flags

N and V flags only used for signed integers.

| Flag | Byte | Description                        |
|:----:|:----:|:-----------------------------------|
| N    | 0    | Not negative                       |
| N    | 1    | Is negative                        |
| V    | 0    | N = true, output remains 8-bit     |
| V    | 1    | N = false, extend output to 16-bit |

As seen in the flag positions above, the V flag XOR's the carry in and the carry out.

Use the following table to determine the V flag value:

| Carry out | Carry in | Flag | Result |
|:---------:|:--------:|:----:|--------|
| 0         | 0        | V    | 0      |
| 0         | 1        | V    | 1      |
| 1         | 0        | V    | 1      |
| 1         | 1        | V    | 0      |

# Modulo arithmetic

## Calculate modulo (least residue)

`a - b * c = x`

Find 1583 mod 7

```
1583 / 7 = 226 + remainder
1583 - 7 * 226
= 1
```

## Solving congruences

### Examples

#### Is n ≡ x (mod y) true or false

During the calculation, we are looking for mod 0 for true

##### Is 22 ≡ 40 (mod 9) true or false

```
40 - 22 = 18
18 mod 9 = 0
True
```

##### Is 34 ≡ 44 (mod 6) true or false

```
44 - 34 = 10
10 mod 6 = 4
False
```

#### Involving addition

Formula I found, only works for addition.

>x + a ≡ b (mod c)  
(c + b - a) (mod c)  
= x

##### x + 7 ≡ 4 (mod 9)

```
9 + 4 - 7 = 6
6 (mod 9) = 6

x = 6
```

#### Involving multiplication

Just go through all the possible answers.  
Number of possible answers will be (mod x) - 1.

##### 5x ≡ 3 (mod 11)

```
x = 0: 0 mod 11 = 0
x = 1: 5 mod 11 = 5
x = 2: 10 mod 11 = 10
x = 3: 15 mod 11 = 4
x = 4: 20 mod 11 = 9
x = 5: 25 mod 11 = 3 ** answer
x = 6: 30 mod 11 = 8
x = 7: 35 mod 11 = 2
x = 8: 40 mod 11 = 7
x = 9: 45 mod 11 = 1
x = 10: 50 mod 11 = 6

x = 5
```

#### Involving powers

Just go through all the possible answers.  
Number of possible answers will be (mod x) - 1.  
There could be multiple answers here.

##### x<sup>2</sup> ≡ 5 (mod 11)

```
x = 0: 0 mod 11 = 0
x = 1: 1 mod 11 = 1
x = 2: 4 mod 11 = 4
x = 3: 9 mod 11 = 9
x = 4: 16 mod 11 = 5 ** answer
x = 5: 25 mod 11 = 3
x = 6: 36 mod 11 = 3
x = 7: 49 mod 11 = 5 ** answer
x = 8: 64 mod 11 = 9
x = 9: 81 mod 11 = 4
x = 10: 100 mod 11 = 1

x = 4 and 7
```

## Generating pseudo-random numbers

### Example

Start with the seed x0 = 47 and generate 10 pseudo-random numbers using the formula.

>x<sub>n</sub> = 47 x<sub>-1</sub> (mod 100)

```
 x_1 ≡ 47 x_0 ≡ 47 * 47 ≡ 2209 ≡ 9 (mod 100)
 x_2 ≡ 47 x_1 ≡ 47 * 2209 ≡ 103823 ≡ 23 (mod 100)
 x_3 ≡ 47 x_2 ≡ 47 * 103823 ≡ 4879681 ≡ 81 (mod 100)
 x_4 ≡ 47 x_3 ≡ 47 * 4879681 ≡ 229345007 ≡ 7 (mod 100)
 x_5 ≡ 47 x_4 ≡ 47 * 229345007 ≡ 10779215329 ≡ 29 (mod 100)
 x_6 ≡ 47 x_5 ≡ 47 * 10779215329 ≡ 506623120463 ≡ 63 (mod 100)
 x_7 ≡ 47 x_6 ≡ 47 * 506623120463 ≡ 23811286661761 ≡ 61 (mod 100)
 x_8 ≡ 47 x_7 ≡ 47 * 23811286661761 ≡ 1119130473102767 ≡ 67 (mod 100)
 x_9 ≡ 47 x_8 ≡ 47 * 1119130473102767 ≡ 52599132235830049 ≡ 49 (mod 100)
x_10 ≡ 47 x_9 ≡ 47 * 52599132235830049 ≡ 2472159215084012303 ≡ 3 (mod 100)
```

## Addition principle

To find the union `n(A ∪ B)`:

>n(A ∪ B) = n(A) + n(B) – n(A ∩ B)

Minus the intersect, otherwise will be counting it twice.

## Multiplication principle

The number of ways a series of tasks can be done * the number of ways a series of choices can be made.

>n<sub>1</sub> * n<sub>2</sub> * n<sub>3</sub> ...

### Example

Suppose there are two roads from town A to town B and three roads from town B to town C, how many different ways to travel from town A to town C?

```
2 * 3
= 6
```

## Four types of problems

| Type         | Order important | Repetition allowed |
|--------------|:---------------:|:------------------:|
| Sequences    | Yes             | Yes                |
| Permutations | Yes             | No                 |
| Subsets      | No              | No                 |
| Multisets    | No              | Yes                |

### Sequences

Order is important.  
Repitition is allowed.

#### Formula

*n* = number of objects  
*r* = number of sequences

>n<sup>r</sup>

#### Example

>How many 3-digit decimal numbers are there, that is from 000 to 999?

10 objects, 3 sequences.

```
10^3 = 1000
```

### Permutations

Order is important.  
Repetition is not allowed.

#### Formula

*n* = number of objects  
*r* = number of permutations

##### Multiple permutations

>P(n, r)  
= <sup>n</sup>P<sub>r</sub>  
= n! / (n - r)!

##### Single permutation

>P(r, r)  
= <sup>r</sup>P<sub>r</sub>  
= r!

#### Example: Multiple permutations

There are 16 teams in a competition. At the end of the season, how many different arrangements could there be for the top 6?

```
P(16, 4)
= 16! / (16 - 6)!
= 16! / 10!
= 20922789888000 / 3628800
= 5765760
```

#### Example: Single permutation

A salesperson has to visit 8 different towns exactly once. In how many ways can this be done? Assume that each town is connected directly to every other town.

```
8! = 8 * 7 * 6 * 5 * 4 * 3 * 2 * 1
= 40320
```

### Subsets

Order is not important.  
Repetition is not allowed.  

#### Formula

*n* = number of objects  
*r* = number of subsets

><sup>n</sup>C<sub>r</sub>  
= C(n, r)  
= n! / (r! * (n - r)!)

#### Example

How many 5-subsets are there of {a, b, c, d, e, f}?

Objects = 6  
Subsets = 5

```
C(6, 5)  
= 6! / (5! * (6 - 5)!)
= 6! / (5! * 1!)
= 6! / 5!
= 720 / 120
= 6
```

## Factorials

**n!**

When solving problems above, do the factorials as they come before any operations.

For example, 5! * 2!.

Solve 5! first, then 2!. Then multiply the result.

```
5! * 2!

5! = 120
2! = 4

120 * 4 = 480
```

If multiplication before factorials occured first, the answer would be wrong:

```
5! * 2!
= 10!
= 3628800 // way off!
```

### Example

n = 5

```
5! = 5 * 4 * 3 * 2 * 1
```

# Graph Theory

## Complements

Original graph:

![complement a](http://snag.gy/tkqB8.jpg)

Complement graph:

![complement b](http://snag.gy/ER2tE.jpg)

### Degree of vertex

The number of edges connecting to a vertex.

A graph with pairs of vertices that are joined with only one edge is called **simple**.

A graph with pairs of vertices that are joined with more than one edge is called **multigraph**.

A vertex can have odd or even degrees.

## Number of edges

Theorems:

>1. For any graph, the sum of the degrees of the vertex is equal to twice the number of edges.  
2. The sum of degrees of a graph is always even  
3. Any graph has an even number of odd vertices

## Isomorphic graphs

Two different looking graphs that contain the same information are considered isomorphic graphs. The graphs must have the same characteristics listed below:

- Number of vertices
- Number of edges
- Degrees

## Mapping isomorphic graphs

The two graphs below are mapped as:

>A → Q, B → R, C → S, D → T and E → P

The matrix representation shows that both maps as isomorphic:

![matrix iso](http://snag.gy/t2wY4.jpg)

## Non-isomorphic graphs

11 non-isomorphic graphs with 4 vertices:

![non-iso](http://snag.gy/txdhM.jpg)

## Eulerian paths and circuits

![eul paths and circuits](http://snag.gy/na1QE.jpg)

### Eulerian path

>A Eulerian path includes every edge exactly once.  
A Eulerian path may pass through a vertex more than once.

### Eulerian circuit

>A Eulerian circuit is a Eulerian path that is also a circuit.  
Meaning it ends where it begins.

### Methods for identifying Eulerian paths and circuits

1. No Eulerian path if it has more than two odd vertices
2. A Eulerian path, but no Eulerian circuit if it has two odd vertices
3. A Eulerian circuit if every vertex is even

### Eulerian examples

Eulerian path. Has two odd vertices. **Start at odd vertex**.

![q16-F](http://snag.gy/QhQhL.jpg)

Eulerian circuit. Every vertex is even.

![q16-H](http://snag.gy/U0mnm.jpg)

## Hamiltonian paths and circuits

![ham paths and circuits](http://snag.gy/D8k8I.jpg)

### Hamiltonian path

>A Hamiltonian path includes every vertex exactly once, except that the last vertex may also be the first.

### Hamiltonian circuit

>A Hamiltonian circuit is a Hamiltonian path that is also a circuit.  
Meaning it ends where it begins.

### Hamiltonian examples

Hamiltonian path.

![q17-J](http://snag.gy/ULaXz.jpg)

Hamiltonian circuit.

![q17-G](http://snag.gy/hdxhz.jpg)

## Planar graphs

Planar graphs have edges that only intersect at vertices.

### Examples

![redraw 4](http://snag.gy/B0U6K.jpg)

![redraw 5](http://snag.gy/iUg0Y.jpg)

![redraw 3](http://snag.gy/Y1iti.jpg)

## Non-planar graphs

Sometimes these graphs are used to prove another graph is isomorphic to these graphs and therefore non-planar.

![non-planar K](http://snag.gy/EMOSD.jpg)

# Matrices and applications 1

## Definitions and terminology

- Numbers in a matrix are called **elements**
- Reference to these elements are called **subscription** notation
	- For example, m<sub>23</sub> refers to the element in the 2nd row, 3rd column

## Order

The order of a matrix determines how many rows and columns it has. Rows is always first, followed by columns.

For example 10x3 matrix will have 10 rows and 3 columns.

## Matrix operations

### Addition of matrices

To add two matrices, add their corresponding elements.

### Multiplication by a number

To multiply a matrix by a number, multiply every element by the number.

### Multiplying two matrices

Multiply each row from first matrix to the column of the second matrix. Sum the answers to get the single element value. Repeat for all rows and columns.

Multiplication is only possible if the following condition is satisfied:

>- Suppose we have an m × n matrix and a p × q matrix
- Multiplication is possible only if n = p
- And if this is the case, then the order of the result is m × q

In other words, number of columns of first matrix is equal to number of rows of the second matrix. Resulting matrix product will be an order of number of rows of first matrix, and number of columns of second matrix.

### Matrix algebra rules

>- A + B = B + A
- A + (B + C) = (A + B) + C
- A (B C) = (A B) C
- A (B + C) = A B + A C
- (B + C) A = B A + C A

### Matrix non-communtativity

>For matrices A and B, it may be that AB = BA, but very often AB ≠ BA.

#### Holonomic

Commutativity in robotics. Holonomic means commutative, ie. AB = BA.

#### Non-holonomic

Non-commutativity in robotics. Non-holonomic means non-commutative, ie. AB ≠ BA.

## Application of matrix to directed graphs

Directed graphs also known as digraphs.

The adjacency matrix for this digraph is:

![digraph adjacency](http://snag.gy/DnYMw.jpg)

![vertex table](http://snag.gy/ATfsS.jpg)

- The row totals should be equal to the number of **outdegree**
	- The edges leaving the vertex
- The column totals should be equal to the number of **indegree**
	- The edges arriving the vertex

## Reachability of vertices

Reachability determines which vertices are reachable from other vertices.

Reachability matrix is represented as M*.

### To calculate M*:

If the digraph has n vertices, then M* will be n × n, and is obtained from:

>M* = M + M2 + ... + Mn

# Matrices and applications 2

Each point on the plane is represented by x and y coordinate which are represented in a matrix as:

>[[x], [y]] - x is always first.

## Finding image of point

Multiply the transformation matrix to the x,y column matrix to find the image (x', y').

>[[x'], [y']] = [[a, b], [c, d]] * [[x], [y]]

![matrix equation](http://snag.gy/dTFuP.jpg)

Rather than finding the product for each x,y coordinate, each coordinate can be combined into one matrix and multiplied with the transformation matrix.

![abberviate](http://snag.gy/REil8.jpg)

## Finding matrix of given transformation

Only need to figure out the transformation for two points: I(1,0) and J(0,1).

Perform the transformation with these two points, then find their images I' and J'.

I' is first column of matrix, J' is second column.

### Example

90° rotation about the origin.

![q2-3](http://snag.gy/RzPdc.jpg)

## Transformations

### Rotation

**POSITIVE ROTATION:** Anti-clockwise  
**NEGATIVE ROTATION:** Clockwise

### Reflection

**y = x:** diagonal line going up from the left, 45°

![y = x](http://snag.gy/MqCna.jpg)

**y = -x:** diagonal line going down from the left, -45°

![y = -x](http://snag.gy/ggV5D.jpg)

## Successive transformations

If matrix A transformation is followed by matrix B, find matrix C.

>BA = C

**WARNING:** Not always the case, map the transformations first to confirm the final image and check answer.

## Identity matrix

Identity matrix, usually called "I", is a square matrix with 1's on the diagonal from top left to bottom right, all other elements are 0.

Behaves like the number 1, no effect when multiplied with another matrix.

![identity matrix](http://snag.gy/Wojfx.jpg)

Identity matrix is found by multiplying a matrix with its inverse, if it has one.

>AA<sup>-1</sup> = A<sup>-1</sup>A = I

## Inverse of a square matrix

![matrix](http://snag.gy/daBg3.jpg)

Before finding inverse, check determinant ≠ 0.

>ad - bc ≠ 0

M<sup>-1</sup> will identify inverse.

**WARNING:** Calculator may give you the same matrix as the answer. Ensure that determinant ≠ 0:

>ad - bc ≠ 0

Or manually with formula:

![inverse formula](http://snag.gy/9zxbY.jpg)

## Matrix system of equations

>ax + by = h  
cx + dy = k

is equivalent to:

![sys of eq](http://snag.gy/Q009y.jpg)

### Rules:

- Don't forget to use `-` sign where applicable
- If letter doesn't appear, it is 0
- If letter appears with no number, it is 1

## Solving matrix equations

- Find the inverse of matrix that contains numerical elements
- Multiply everything with inverse matrix

### Example

>2y = -10  
-x + 5y = -3

![q6-3](http://snag.gy/TRuFH.jpg)
