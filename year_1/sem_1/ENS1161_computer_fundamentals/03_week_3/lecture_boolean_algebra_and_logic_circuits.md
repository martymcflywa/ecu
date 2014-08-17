# Boolean Algebra & Logic Circuits

## Boolean Algebra

In Boolean Algebra there are:

- Two values
	- `0`
	- `1`
- Three operations
	- `•` Multiplication
	- `+` Addition
	- `'` Complementation

The truth tables for three operations look identical as logical concepts:

| `p` | `q` | `p + q` |
|:---:|:---:|:-------:|
| 0   | 0   | 0       |
| 0   | 1   | 1       |
| 1   | 0   | 1       |
| 1   | 1   | 1       |

| `p` | `q` | `p • q` |
|:---:|:---:|:-------:|
| 0   | 0   | 0       |
| 0   | 1   | 0       |
| 1   | 0   | 0       |
| 1   | 1   | 1       |

| `p` | `p'` |
|:---:|:----:|
| 0   | 1    |
| 1   | 0    |

### Corresponding Symbols

| Logic   | Set  | Boolean |
|---------|------|---------|
| `~`     | `'`  | `'`     |         
| `˄`     | `∩`  | `•`     |
| `˅`     | `∪` | `+`     |
| `true`  | `U`  | `1`     |
| `false` | `∅`  | `0`     |

One major advantage of using a notation with symbols `•` and `+` is that many of the laws of logic look like the familiar laws of ordinary algebra, and that makes algebraic manipulation so much easier.

### Boolean Algebra Laws

#### Laws for Multiplication

- `0 • 0 = 0`
- `0 • 1 = 0`
- `1 • 0 = 0`
- `1 • 1 = 1`

#### Laws for Addition

- `0 + 0 = 0`
- `0 + 1 = 1`
- `1 + 0 = 1`
- `1 + 1 = 1`

#### Laws for Complementation

`0' = 1` `1' = 0`

### Precedence

- `NOT` takes precedence over `AND`
- `AND` takes precedence over `OR`
- Brackets take precedence if shown

Suppose we had to evaluate the Boolean expression `x + y'•z`, given some values for `x` `y` and `z`. We would first find `y'` then `y'•z` then finally `x + y'•z`

In other words we first perform the `NOT`, then the `AND` and finally the `OR`.

### Shorthand

We often drop the `•` symbol altogether.

So for example, the distributive law:

```
x • (y + z) = (x • y) + (x • z)
```

Could be written as:

```
x(y + z) = xy + xz
```

When carrying out some algebraic operations, such as using de Morgan's laws, or when working with numerical values, it is often a good idea to temporarilty use the `•` symbol.

## Evaluating Boolean Expressions

### Example 1:

- Find the value of `xy' + yz'` if
	- `x = 1`
	- `y = 0`
	- `z = 0`

`1•0' + 0•0' = 1•1 + 0•1 = 1 + 0 = 1`  

### Example 2:

- Evaluate `(x' + y)'` if
	- `x = 0`
	- `y = 1`

`(x' + y)' = (0' + 1)' = (1 + 1)' = 1' = 0`

### Exercise 1:

If `x = 0, y = 1` and `z = 0` find the value of `(x + yz') (xy' + z)`

`(x + yz') (xy' + z) = (0 + 1•0') (0•1' + 0) = (0 + 1•1) (0•0 + 0) = (0 + 1) (0 + 0) = 1•0 = 0`

### Exercise 2:

If `x = 0, y = 1, z = 0` find the value of `xyz + x'yz' + x'y'z`

`xyz + x'yz' + x'y'z = 0•1•0 + 0'•1•0' + 0'•1'•0 = 0•1•0 + 1•1•1 + 1•0•0 = 1 + 1 + 1 = 1`

## Products and Sums

Two very important concepts that we use in boolean algebra are products and sums of products.

A product is an expression in which the variables are multiplied 

```
xy'z
x'y
yz'
```

A sum of products is an expression in which products are added

```
xy + y'z + x'yz'
x'y' + xy'z + xz
```

### Exercise 3:

For each expression, what values of `x` `y` and `z` will make the expression equal to `1`

- `xyz'`
	- `x = 1`
	- `y = 1`
	- `z = 0`
- `x'y'z`
	- `x = 0`
	- `y = 0`
	- `z = 1`
- `x'yz`
	- `x = 0`
	- `y = 1`
	- `z = 1`
- `xy'z'`
	- `x = 1`
	- `y = 0`
	- `z = 0`

### Exercise 4:

For each of the following combinations of values, which product of `x` `y` and `z` (with or without the dashes) is equal to `1`

- `x = 0, y = 1, z = 0`
	- `x'yz'`
- `x = 1, y = 0, z = 1`
	- `xy'z`
- `x = 1, y = 1, z = 1`
	- `xyz`
- `x = 0, y = 0, z = 0`
	- `x'y'z'`

## Logic Gates

### `AND` Gate

An `AND` gate has two or more inputs, and its output is the product of the inputs.

The output of an `AND` is `1` if all the inputs are `1`, otherwise the output is `0`.

Hence the rule: an `AND` gives `1` if all inputs are `1`, otherwise it is `0`.

![gate AND](http://i.imgur.com/08mC0Co.png)

### `OR` Gate

An `OR` gate has two or more inputs, and its output is the Boolean sum of the inputs.

![gate OR](http://i.imgur.com/ujDl3G7.png)

The output of an `OR` is `0` if all the inputs are `0`, otherwise the output is `1`

Hence the rule: an `OR` gives `0` if all inputs are `0`, otherwise it is `1`.

### `NOT` Gate

A `NOT` gate (also called an inverter) has one input and one output.

![gate NOT](http://i.imgur.com/bru947l.png)

The output of a `NOT` is the complement of the input.

In other words, an input of `1` gives output of `0` and vice versa.

### From Logic Circuit to Boolean Expression

The Boolean expression for a particular circuit can be determined by following the output of each logic gate as it connects to the input of another logic gate.

When you are first learning about circuits it is helpful to write the appropriate expression at the output of each gate, as shown in the following two examples.

![gate demo](http://i.imgur.com/qUsoLbe.png)

#### Example 1:

![gate example 1](http://i.imgur.com/zVGJF6I.png)

#### Example 2:

![gate example 2](http://i.imgur.com/NNPLlne.png)

#### Example 3:

![gate example 3](http://i.imgur.com/OfYqw23.png)

### From Boolean Expression to Logic Circuit

#### Example 1: `(y' + z)(x' + yz')`

![gate exptocirc1](http://i.imgur.com/SMQW6YG.png)

#### Example 2: `xy'z + x'z'`

![gate exptocirc2](http://i.imgur.com/1bQfhxe.png)

#### Example 3: `(xyz' + x'y')' + y'`

![gate exptocirc2](http://i.imgur.com/X0GVEAb.png)

## Truth Tables and Boolean Expressions

It is important to be able to transfer between truth tables, Boolean expressions and circuits.

`truth table -> expression -> circuit`

We have looked at links between expressions and circuits, now we will consider expressions and truth tables. There are two points to note:

- In constructing truth tables for expressions, we will confine our attention to so called *sums of products* since these correspond to `AND` `OR` circuits.
- The link from truth tables to expressions is important for the design of circuits, and here we will need the concept of *fundamental product*.

### From Sums of Products to Truth Tables

A **product** is an expression such as `xy'` or `x'yz'` which consists of variables combined using the `AND` operation. In other words, the variables are **multiplied** together.

A **sum of products (SOP)** consists of products combined using the `OR` operation. The products are **added** together.

To construct a truth table for a sum of products, we use one column for each product and then one for the sum of the products, as shown in the examples below.

#### Example 1: Find the truth table for `L = x'yz + xy' + x'z'`

| `x` | `y` | `z` | `x'yz` | `xy'` | `x'z'` | `L` |
|:---:|:---:|:---:|:------:|:-----:|:------:|:---:|
| 0   | 0   | 0   | 0      | 0     | 1      | 1   |
| 0   | 0   | 1   | 0      | 0     | 0      | 0   |
| 0   | 1   | 0   | 0      | 0     | 1      | 1   |
| 0   | 1   | 1   | 1      | 0     | 0      | 1   |
| 1   | 0   | 0   | 0      | 1     | 0      | 1   |
| 1   | 0   | 1   | 0      | 1     | 0      | 1   |
| 1   | 1   | 0   | 0      | 0     | 0      | 0   |
| 1   | 1   | 1   | 0      | 0     | 0      | 0   |

#### Example 2: Find the truth table for `P = xyz' + x'y'`

| `x` | `y` | `z` | `xyz'` | `x'y'` | `P` |
|:---:|:---:|:---:|:------:|:------:|:---:|
| 0   | 0   | 0   | 0      | 1      | 1   |
| 0   | 0   | 1   | 0      | 1      | 1   |
| 0   | 1   | 0   | 0      | 0      | 0   |
| 0   | 1   | 1   | 0      | 0      | 0   |
| 1   | 0   | 0   | 0      | 0      | 0   |
| 1   | 0   | 1   | 0      | 0      | 0   |
| 1   | 1   | 0   | 1      | 0      | 1   |
| 1   | 1   | 1   | 0      | 0      | 0   |

### Fundamental Products

In order to find a Boolean expression corresponding to a given truth table, we need the concept of **fundamental product**.

For two variables `x` and `y`, there are **four** fundamental products. They are:

```
xy
xy'
x'y
x'y'
```

For three variables `x`, `y` and `z`, there are **eight** fundamental products:

```
xyz
xyz'
xy'z
x'yz
x'yz'
x'y'z
x'y'z'
```

For four variables `w`, `x`, `y` and `z`, there are **sixteen** fundamental products:

```
wxyz
wxyz'
wxy'z
...
w'x'y'z'
```

>Which is the same as the possible combinations for each proposition. The formula is:

>`x = number of outcomes (which is two, 0 or 1); y = number of variables`

>`2 ˄ y = number of possible combinations`

There are two key concepts to remember:

- In a fundamental product, each variable must be present, with or without `'`
- Each fundamental product is equal to 1 for one and only one combination of the variables

As an example of the first concept, `x'yz` **is** a fundamental product if we are dealing with three variables `x` `y` and `z`, but **not** if we are dealing with four variables `w` `x` `y` and `z` (because `w` is missing).

Suppose we are only dealing with three variables `x` `y` and `z`:

`xy'z'` is equal to `1` only if `x = 1` `y = 0` and `z = 0`

`xy'z` is equal to `1` only if `x = 1` `y = 0` and `z = 1`

### From Truth Table to Boolean Expression

We are now ready to find a Boolean expression corresponding to a given truth table.

#### Example 1:

| `x` | `y` | `z` | `L` |
|:---:|:---:|:---:|:---:|
| 0   | 0   | 0   | 0   |
| 0   | 0   | 1   | 0   |
| 0   | 1   | 0   | 1   |
| 0   | 1   | 1   | 0   |
| 1   | 0   | 0   | 1   |
| 1   | 0   | 1   | 1   |
| 1   | 1   | 0   | 0   |
| 1   | 1   | 1   | 1   |

`L = x'yz' + xy'z' + xy'z + xyz`

#### Example 2:

| `a` | `b` | `c` | `P` |
|:---:|:---:|:---:|:---:|
| 0   | 0   | 0   | 1   |
| 0   | 0   | 1   | 0   |
| 0   | 1   | 0   | 0   |
| 0   | 1   | 1   | 1   |
| 1   | 0   | 0   | 1   |
| 1   | 0   | 1   | 0   |
| 1   | 1   | 0   | 1   |
| 1   | 1   | 1   | 0   |

`P = a'b'c' + a'bc + ab'c' + abc'`

#### Example 3:

| `w` | `x` | `y` | `z` | `L` |
|:---:|:---:|:---:|:---:|:---:|
| 0   | 0   | 0   | 0   | 0   |
| 0   | 0   | 0   | 1   | 0   |
| 0   | 0   | 1   | 0   | 1   |
| 0   | 0   | 1   | 1   | 0   |
| 0   | 1   | 0   | 0   | 0   |
| 0   | 1   | 0   | 1   | 1   |
| 0   | 1   | 1   | 0   | 1   |
| 0   | 1   | 1   | 1   | 0   |
| 1   | 0   | 0   | 0   | 0   |
| 1   | 0   | 0   | 1   | 0   |
| 1   | 0   | 1   | 0   | 1   |
| 1   | 0   | 1   | 1   | 0   |
| 1   | 1   | 0   | 0   | 0   |
| 1   | 1   | 0   | 1   | 1   |
| 1   | 1   | 1   | 0   | 0   |
| 1   | 1   | 1   | 1   | 0   |

`L = w'x'yz' + w'xy'z + w'xyz' + wx'yz' + wxy'z`

## Laws of Boolean Algebra

It is important to be familiar with these laws because they can help to simplify complicated expressions.

### Idempotent Laws

- `a + a = a`
- `a • a = a`

### Complement Laws

- `a + a' = 1`
- `a • a' = 0`

### Involution Law

- `(a')' = a`

### Associative Laws

- `(a + b) + c = a + (b + c)`
- `(a • b) • c = a • (b • c)`

### Commutative Laws

- `a + b = b + a`
- `a • b = b • a`

### Distributive Laws

- `a + b • c = (a + b) • (a + c)`
- `a • (b + c) = a • b + a • c`

### de Morgan's Laws

- `(a + b)' = a' • b'`
- `(a • b)' = a' + b'`

### Identity Laws

- `a + 0 = a`
- `a • 1 = a`
- `a + 1 = 1`
- `a • 0 = 0`

### Laws Involving 0 and 1

#### `0`

- `xx' = 0`
- `0x = 0`
- `0 + x = x`

#### `1`

- `x + 1 = 1`
- `1x = x`
- `x + x' = 1`

### Other Useful Laws

- `x'' = x`
- `x + x = x`
- `x + x' = 1`

## Using the Laws

Laws of Boolean algebra can be used to reduce expressions to their simplest form. We will use a combination of Boolean algebra and Karanugh maps to simplify expressions.

The most useful for that purpose are:

### Commutative laws for `•` and `+`

- `x • y = y • x`
- `x + y = y + x`

### Associative laws for `•` and `+`

- `(x • y) • z = x • (y • z)`
- `(x + y) + z = x + (y + z)`

- The practical value of Commutative and Associative laws is that
	- In any product, the order of multiplication is unimportant
		- `xy'z = y'xz = zy'x = ... etc`
	- In any sum, the order of addition is unimportant
		- `x' + y' + z = y' + x' + z = z + y' + x' = ... etc`

### Distributive laws

Are used to remove brackets.

- `x(y + z) = xy + xz`
- `(w + x)(y + z) = wy + wz + xy + xz`
- `x(w + y + z) = xw + xy + xz`

### Laws involving 0 and 1

#### `0`

- `xx' = 0`
- `0x = 0`
- `0 + x = x`

#### `1`

- `x + 1 = 1`
- `1x = x`
- `x + x' = 1`

Examples of use

- `y'(yz + xz') = y'yz + xy'z' = 0z + xy'z' = 0 + xy'z' = xy'z'`

### Other Useful Laws

- `x'' = x`
- `x + x = x`
- `x + x' = 1`

Example

- `xy + xy + wz = xy + wz`
- `wx'ywz = wx'yz`

## Using de Morgan's Laws

- `(x + y)' = x'y'`
- `(xy)' = x' + y'`

Can also be used on cases like:

- `(w + x + y + z)' = w'x'y'z'`
- `(wxyz)' =  w' + x' + y' z'`

Typically, de Morgan's law is used to remove brackets from certain expressions to obtain a sum of products.

- Law: `(pq)' = p' + q'`
	- `(x' yz)' = x + y ' +z'`
	- `(wxy'z')' = w' + x' + y + z`
- Law: `(p + q)' = p'q'`
	- `(x + y' + z)' = x'yz'`
	- `(w' + x' + y + z') = wxy'z`

The following examples use both de Morgan's laws. In each case, the task is to reduce the given expression to a sum of products. **Notice** that sometimes it is necessary to introduce brackets during the simplifaction.

### My Notes on de Morgan's Laws

Is a three-step process when used for simplifying.

- If `(a + b)'`, then convert to product with `a'b'`
- Then for each element, `(xy)' = x' + y'` to convert to sum outside brackets
- Then complete **expansion of brackets** to convert from `(a + b)(a + b)` to `aa + ab + ba + bb`

### Examples

```
1. (x + y'z)' = x'(y'z)' = x'(y + z') = x'y + x'z'

2. (xy' + yz')' = (xy')'(yz')' = (x' + y)(y' + z) = x'y' + x'z + 0 + yz = x'y' + x'z + yz

3. (x' + xy'z + yz')'	= x(xy'z)'(yz')' = x(x' + y + z')(y' + z)
						= x(x'y' + x'z + 0 + yz + z'y' + 0)
						= 0 + 0 + xyz + xy'z' = xyz + xy'z'

4. (xy' + x'z + yz')'	= (xy')'(x'z)'(yz')' = (x' + y)(x + z')(y' + z)
						= (x' + y)(xy' + xz + y'z') = x'y'z' + xyz

5. (x' + yz)'(wy' + xz')'	= x(yz)'(wy')'(xz')'
							= x(y' + z')(w' + y)(x' + z)
							= (xy' + xz')(w'x' + w'z + x'y + yz)
							= 0 + w'xy'z + 0 + 0 + 0 + 0 + 0 + 0
							= w'xy'z
```

## Expanding SOP into a Complete Sum of Products

Sometimes it is desirable to expand a sum of products intoa complete sum of products.

In a complete sum of products, each term must be a fundamental product, that is in each term, every variable **must** be present, with or without the `'`.

If any term of a sum of products has a variable missing, we multiply the term by `1` in the form `(var + var')`.

Since the sum `(var + var') = 1`, we are multiplying by 1, which does not alter the value of the original expression.

### Examples

```
1. P(x,y,z) = xy' = xy'(z + z') = xy'z + xy'z'

2. M(x,y,z)	= z = z(x + x') = xz + x'z = xz(y + y') + x'z(y + y')
			= xyz + xy'z + x'yz + x'y'z

3. L(w,x,y,z)	= wxy'z + xyz' + w'yz
				= wxy'z + wxyz' + w'xyz' + w'xyz + w'x'yz 
```

### Exercise

For which combinations of `x` `y` and `z` will `M` be equal to `1`?

![gate soptoproduct](http://i.imgur.com/WqpR7MA.png)

#### Solution

Expand `M` into a complete sum of products

`M = x'z + yz' = x'yz + x'y'z + xyz' + x'yz'`

So

`M = 1 for (x,y,z) = (0,1,1), (0,0,1), (1,1,0) and (0,1,0)`