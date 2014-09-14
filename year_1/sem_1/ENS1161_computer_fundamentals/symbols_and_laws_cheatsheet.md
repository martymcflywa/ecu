# Lecture 1

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
	- 1 + 1 = 0 carry 1
	- 1 + 1 + 1 = 1 carry 1
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
5886 + 4938
6 + 8 					= E
8 + 3 					= B
8 + 9 		= 17 - 16 	= 1 carry 1
1 + 5 + 4 				= A

//converting hex as BCD here

E + 6 		= 20 - 16 	= 4 carry 1
1 + B + 6 	= 18 - 16 	= 2 carry 1
1 + 1 + 6 				= 8
10 + 6 		= 16 - 16 	= 0 carry 1
1 + 0 					= 1
```

= 10824<sub>16</sub>

