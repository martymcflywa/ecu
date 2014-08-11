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

`0 • 0 = 0` `0 • 1 = 0` `1 • 0 = 0` `1 • 1 = 1`

#### Laws for Addition

`0 + 0 = 0` `0 + 1 = 1` `1 + 0 = 1` `1 + 1 = 1`

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

For each expression, what values of `x` `y` and `z` will make the expression equal to `1`?

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

For each of the following combinations of values, which product of `x` `y` and `z` (with or without the dashes) is equal to `1`?

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

The output of an `OR` is `0` if all the inputs are `0`, otherwise the output is `1`/

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

