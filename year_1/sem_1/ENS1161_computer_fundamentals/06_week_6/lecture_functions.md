# Functions

## Function as a process

It is useful to think of a *function* as a *process* with an *input* and an *output*:

![functions as processes](http://i.imgur.com/1dTMoT8.png)

Usually we give the process a name such as:

- `recip(4) = 0.25`
- `vowelcount("emu") = 2`
- `sqroot(100) = 10`
- `distPerth(Hedland) = 1270`

A function is often defined by a rule:

- `recip(x) = 1 / x`
- `vowelcount(<string>) = no. vowels in <string>`
- `sqrt(x) = √ x`
- `distPerth(town) = distance town to Perth in km`

## Function defined in terms of sets

A function `f` from set `A` to set `B` is a rule that assigns to each element of `A` exactly one element of `B`. 

>**Exactly one** means **one** and not more than one.

![functions in sets](http://i.imgur.com/2dgS30A.png)

As symbols we write:

`f: A → B, f(x) = ...`

Syntax:

`domain → codomain, rule`

The set `A` is called the *domain* of the function, and set `B` is called the *codomain*.

The range is defined as the set:

`{b | b ∈ B and b = f(a) for some a ∈ A}`

If `b = f(a)` then `b` is called the image of `a`. We also say that if `f` is a *mapping* from set `A` to set `B`.

### Example 1

Consider a function that tells us the position of a letter in the alphabet:

`pos: {alphabet} → N, pos(letter) = position of letter in alphabet`

eg. `pos(A) = 1`, `pos(N) = 14`, `pos(Y) = 25`

The *domain* is `{alphabet}`, the *codomain* is `N` and the *range* is `{1, 2, 3, ..., 26}`.

### Example 2

Consider a function that gives us yesterday's market price of vegetables

`price: {vegetables} → R, price(x) = price in $ of 1kg of x`

eg. `price(sweet potato) = 3.75`, `price(beans) = 8.50`, `price(tomatoes) = 3.99`, `price(pumpkin) = 1.30`

The range is `{3.75, 8.50, 3.99, 1.30, ... etc}`.

### More examples

- `len: {strings} → N, len(s) = length of s`
	- `len(DVD) = 3`, `len(Australia) = 9`
- `initial: {names} → {alphabet}, intial(x) = first letter of x`
	- `initial(Jones) = J`, `initial(Smith) = S`
- `f: R → R, f(x) = x(x + 1)`
	- `f(3) = 12`, `f(7) = 56`, `f(10) = 110`
- `g: N → N, g(x) = successor of x`
	- `g(3) = 4`, `g(4) = 5`, ..., `g(20) = 21`
- `h: {0, 1, 2, 3, ..., 10} → {0, 1, 2, 3, ..., 10}` defined by table:

| `x`    | 0 | 1 | 2 | 3 | 4  | 5 | 6 | 7  | 8 | 9 | 10 |
|-------:|:-:|:-:|:-:|:-:|:--:|:-:|:-:|:--:|:-:|:-:|:--:|
| `h(x)` | 5 | 6 | 9 | 3 | 10 | 8 | 8 | 10 | 3 | 9 | 6  |

`f: {a, b, c, d, e} → {a, b, c, d, e}` defined by arrow diagram:

![function to arrow](http://i.imgur.com/LjYdNgA.png)

Which is equivalent to `f = {(a, b), (b, a), (c, e), (d, c), (e, d)}` or as a table:

| `x`    | a | b | c | d | e |
|-------:|:-:|:-:|:-:|:-:|:-:|
| `f(x)` | b | a | e | c | d |

## Functions as relations

We defined a function as a rule that assigns to each member of one set (the domain) exactly one member of another set (the codomain). Alternatively, we can think of a function as a special type of relation.

A function `f` from set `A` to set `B` is a subset of `A × B` that satisfies two conditions:

1. For each `a ∈ A`, there is some `b ∈ B` such that `b = f(a)`
	- `∀a ∈ A, ∃b ∈ B, b = f(a)`
2. For each `a and α` in `A`, if `a = α` then `f(a) = f(α)`
	- `∀a, α ∈ A, a = α → f(a) = f(α)`

![function to graph](http://i.imgur.com/ipJpKIS.png)

### Exercise 1

Which of the following arrow diagrams represent functions?

![function as relation ex1](http://i.imgur.com/ModncC0.png)

### Exercise 2

Consider the sets:

- `A = {apple, banana, lemon, plum, grapefruit}`
- `B = {0, 1, 2, 3, ..., 10}`

Which of the following subsets of `A × B` are functions from `A` to `B`?

- `L = {(apple, 5), (banana, 6), (lemon, 5), (plum, 4), (grapefruit, 10)}`
	- Function
- `M = {(apple, 6), (banana, 0), (lemon, 2), (plum, 10), (grapefruit, 1)}`
	- Function
- `P = {(apple, 3), (banana, 4), (plum, 9), (grapefruit, 5)}`
	- Not function
- `Q = {(apple, 6), (banana, 0), (lemon, 2), (plum, 10), (banana, 4)}`
	- Not function

### Exercise 3

Which of the following graphs represent functions?

![function as relation ex3](http://i.imgur.com/WaMa6Yz.png)

## Using function notation

If the rule for `f` is `f(x) = √x + 2` then to find the value of `f(x)` for a particular value of `x`, simply replace `x` in the formula by whatever appears in the brackets:

- Example:
	- `f(7) = √7 + 2 = 3`
	- `f(2) = √2 + 2 = 2`
	- `f(1) = √1 + 2 = 1.732...`

If the rule for `g` is `g(x) = (x^2 + 1)(x - 3)` then

- Example:
	- `g(4) = (17)(1) = 17`
	- `g(2) = (5)(-1) = -5`
	- `g(0) = (1)(-3) = -3`

### Exercises

1. If `f(x) = x^2 + 5`
	- Find `f(2)`, `f(4)`, `f(7)`
		- `f(2) = 9`
		- `f(4) = 21`
		- `f(7) = 54`
2. If `f(x) = (x + 1)(x + 2)(x + 3)`
	- Find `f(2)`, `f(4), `f(7)`
		- `f(2) = 3 * 4 * 5 = 60`
		- `f(4) = 5 * 6 * 7 = 210`
		- `f(7) = 8 * 9 * 10 = 720`
3. Consider
	- `S = {a, b, c, d, e, f}`
	- `g: S → S` defined by the table below
	- Find `g(b)`, `g(d)`, `g(f)`
		- `g(b) = c`
		- `g(d) = a`
		= `g(f) = b`

| `x`    | a | b | c | d | e | f |
|-------:|:-:|:-:|:-:|:-:|:-:|:-:|
| `g(x)` | d | c | e | a | f | b |

## Onto and one-to-one functions

### Onto functions

Consider the function `f: A → B`

![onto function example](http://i.imgur.com/2dgS30A.png)

The *range* of a function is a *subset* of the *codomain*.

If the range is equal to the codomain, we say the function is **onto**.

#### Definition

A function is onto if its range is equal to its codomain.

`∀b ∈ B, ∃a ∈ A, b = f(a)`

Every element in the codomain is the image of some element in the domain.

![define onto](http://i.imgur.com/YEcjGmr.png)

### One-to-one functions

#### Definintion

A function is one-to-one if no two elements of the domain have the same image.

`∀a, b ∈ A, a ≠ b → f(a) ≠ f(b)`

Every element of the codomain is the image of only one element of the domain.

![define one-to-one](http://i.imgur.com/5Z3oozp.png)

### Examples

![onto or one-to-one](http://i.imgur.com/w48khkF.png)

## Composite functions

Suppose that `f(x) = x + 3`, `g(x) = 2x - 4` and `h(x) = x^2`.

Now let us arrange the *processes* one after another, so that the output from one process becomes the input for the next process.

For example:  
if `x = 5`, then `f(x) = 8`, `g(f(x)) = 12` and `h(g(f(x))) = 144`

![composite explained](http://i.imgur.com/5gCxcVt.png)

### Exercise

Suppose that:

- `f(x) = √x`
- `g(x) = x + 3`
- `h(x) = 2x`

Find:

1. `g(f(81))`
	- 12
2. `f(g(1))`
	- 2
3. `h(g(5))`
	- 16
4. `f(g(h(11)))`
	- 5
5. `h(g(f(f(g(13)))))`
	- 10

## Inverse functions

Can we find an inverse function?

Suppose we have a machine:

![function flow](http://i.imgur.com/wg0u157.png)

Can we create another machine that does exactly the opposite?

To reverse the process we reverse each operation starting with the last.

>Take off shoes, then take off socks

### Exercise 1

![inverse ex1](http://i.imgur.com/udG9k4W.png)

Applying the "shows and socks" method, the inverse is "subtract 5 and divide by 2".

`f(x) = 2x + 5` is inversed to:

`f`<sup>-1</sup>`(x) = (x - 5) / 2`

### Exercise 2

![inverse ex2](http://i.imgur.com/a7UA6Ed.png)

The inverse is "add 3 and divide by 4".

`f(x) = 4x - 3` is inversed to:

`f`<sup>-1</sup>`(x) = (x + 3) / 4`

### Exercise 3

![inverse ex3](http://i.imgur.com/9GaO5ft.png)

The inverse is "divide by 2 then subtract 10".

`f(x) = 2(x + 10)` is inversed to:

`f`<sup>-1</sup>`(x) = x / 2 - 10`

### Exercise 4

![inverse ex4](http://i.imgur.com/oLDvTRc.png)

The inverse is "multiply by 2 and add 8".

`f(x) = (x - 8) / 2` is inversed to:

`f`<sup>-1</sup>`(x) = 2x + 8`

### Exercise 5

![inverse ex5](http://i.imgur.com/35atBiK.png)

The inverse is "square and subtract 1"

`f(x) = √(x - 1)` is inversed to:

`f`<sup>-1</sup>`(x) = x^2 - 1`

## How to find a formula for an inverse

### Method 1: Shoes and socks

So we must find the reverse of each operation, and in the reverse order.

#### Example 1

Consider the function `f` with the rule `f(x) = √x + 2`

`f` means "take square root and add 2"

So `f`<sup>-1</sup> means "subtract 2 then square"

Therefore the rule for `f`<sup>-1</sup> is `f`<sup>-1</sup>`(x) = x^2 - 2`

#### Example 2

Consider the function `g` with the rule `g(x) = (3x + 7) / 5`

`g` means "multiply the number by 3, add 7, then divide by 5"

So `g`<sup>-1</sup> means "multiply the number 5, subtract 7, then divide by 3"

Therefore the rule for `g`<sup>-1</sup> is `g`<sup>-1</sup>`(x) = (5x - 7) / 3`

### Method 2: Turn inside out and swap labels

Again consider the function `f` with the rule:

`f(x) = √x + 2`

First we let `y = √x + 2`, then we solve `x`:

`y^2 = x + 2`

`y^2 - 2 = x`

Now swap the labels:

`y = x^2 - 2`

Therefore the inverse rule is `f`<sup>-1</sup>`(x) = x^2 - 2`

**Note:** Method 2 is more general because it can be applied to any function, whereas the first method is useful only for very simple functions.

## How to check that the formula for inverse is correct?

Suppose for some function `f`, we have found what we believe is the formula for its inverse `f`<sup>-1</sup>. In order to verify that the formula for `f`<sup>-1</sup> is correct, we must check that:

`f`<sup>-1</sup>`(f(x)) = x`

![inverse check](http://i.imgur.com/IPCzy7c.png)

### Example

If `f(x) = 2x + 5` then `f`<sup>-1</sup>`(x) = (x - 5) / 2`

To check that we are correct, we find: `f`<sup>-1</sup>`(f(x))`

`f`<sup>-1</sup>`(f(x)) = (f(x) - 5) / 2 = (2x + 5 - 5) / 2 =  x`

### Exercise 1

Let `h(x) = √x - 5`.

Find `h`<sup>-1</sup>`(x)` and check that `h`<sup>-1</sup>`(h(x)) = x`.


