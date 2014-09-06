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

## Onto and one-to-one

### Onto

![onto](http://i.imgur.com/YEcjGmr.png)

### One-to-one

![one-to-one](http://i.imgur.com/5Z3oozp.png)

## Composite functions

Composite functions are nested inside each other within parenthesis, with the first function inside and the last function outside.

`h(g(f(x)))`

![comp func](http://i.imgur.com/5gCxcVt.png)

## Inverse functions

### Conditions

A function `f` has an inverse `f`<sup>-1</sup> **only** if `f` is "one-to-one" **and** "onto".

### Methods

- Two methods:
	1. `Take off shoes, then take off socks`
		- Reversing each function individually in reverse order
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

