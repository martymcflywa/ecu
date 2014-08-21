# Karnaugh Maps

- A `boolean` expression may be simplified using only the laws of Boolean Algebra
- However, it is generally easier to begin the simplification using Boolean Algebra and to complete it using a Karnaugh map
- A Karnaugh map (K-Map) contains the same information as a truth table
- It is arranged as a grid, which makes it easier to simplify expressions
- We will consider 3-variable and 4-variable Karnaugh maps

## Karnaugh Map Examples

### 3-Variable

![kmap example 3var](http://i.imgur.com/h6Ai4in.png)

### 4-Variable

![kmap example 4var](http://i.imgur.com/UShfLcP.png)

## 3-Variable Karnaugh Maps

A simple way to understand K-maps is to consider rows and columns and the products that they represent. We will look at them first separately and then together. First look at the rows. The bottom row of cells represents the `x` and the top row represents `x'`, as shown in the figures below.

![kmap example x](http://i.imgur.com/OlNOpki.png)

![kmap example columns](http://i.imgur.com/BQq3TTy.png)

![kmap example 3var intersect1](http://i.imgur.com/4CSsZOk.png)

![kmap example 3var intersect2](http://i.imgur.com/nfJoV74.png)

## 4-Variable Karnaugh Maps

Now consider both rows and columns for 4-variable K-maps.

### Rows

![kmap example 4var row](http://i.imgur.com/1fqerr7.png)

### Columns

![kmap example 4var column](http://i.imgur.com/GG5mxdp.png)

### Intersects

![kmap example 4var intersect1](http://i.imgur.com/4JuY8DP.png)

### Examples

#### Example 1:

Find the Boolean product represented by the K-map below.

![kmap 4var prob1](http://i.imgur.com/o42sToS.png)

The row represents `wx'` and the columns represent `y`. So the product is `wx'y`.

#### Example 2:

Find the Boolean product represented by the K-map below.

![kmap 4var prob2](http://i.imgur.com/ZbBjX6c.png)

The row represents `x` and the column represents `y'`. The product is `xy'`.

#### Example 3:

Find the Boolean product represented by the K-map below.

![kmap 4var prob3](http://i.imgur.com/ur1xJDV.png)

The row represents `x` and the column represents `z'`. The product is `xz'`.

#### Example 4:

Find the Boolean product represented by the K-map below.

![kmap 4var prob4](http://i.imgur.com/0WgfZhk.png)

The answer is `x + z'`

#### Example 5:

Find the Boolean sum of products represented by the K-map below.

![kmap 4var prob5](http://i.imgur.com/h6jNK8i.png)

#### Example 6:

Find the Boolean sum of products represented by the K-map below.

![kmap 4var prob6](http://i.imgur.com/vnoyy7o.png)

#### Example 7:

Find the Boolean sum of products represented by the K-map below.

![kmap 4var prob7](http://i.imgur.com/6PSpJHk.png)

#### Example 8:

Find the Boolean sum of products represented by the K-map below.

![kmap 4var prob8](http://i.imgur.com/gYO3PYu.png)

#### Example 9:

Find the Boolean sum of products represented by the K-map below.

![kmap 4var prob9](http://i.imgur.com/f7sW09k.png)

# Minimal Sum of Products

Our aim is to find the simplest possible expression that is still a sum of products.

We want a sum of products with fewest terms and fewest letters. Such an expression is called a minimal sum of products (Min SOP), and the corresponding circuit is called a minimal `AND`-`OR` circuit.

For example, the expression

```
xyz + xyz' + xy'z
```

is a sum of products, and it can be simplified to 

```
xy + xz
```

which is a Min SOP.

Notice that we will not simplify further to `x(y + z)` because this is no longer a SOP.

## SOPs, CSOPs and Min SOPs

A **SOP** is simply an expression consisting of products of variables (with or without dashes) added together.

A **CSOP** is an expression that has been expanded into its fundamental products. In other words, its *smallest* pieces.

A **Min SOP** is an expression that has been simplified so as to consist of the fewest possible terms and letters, and still remain a SOP. In other words, simplified into its *largest* pieces.

So, at one end of the spectrum we have a CSOP, and at the other end we have a Min SOP.

### Comparison between CSOP and Min SOP

Consider the expression

```
wyz + w'yz + wxyz'
```

which when expanded to **CSOP**

```
wxyz + wx'yz + w'xyz + w'x'yz + wxyz'
```

or simplified to **Min SOP**

```
yz + wxy
```

On the Karnaugh map below, the expression is represented by five cells, each corresponding to a fundamental product which is the **CSOP**. Alternatively, we can interpret the expression as two groups of cells, which is the **Min SOP**.

![kmap csop minsop](http://i.imgur.com/7f32SGI.png)

# Typical Design Problems

We are concerned with two types of problems

- Given the specifications for a circuit in the form of a truth table design, the simplest circuit to meet the specifications
- Given a circuit, design a simpler circuit that performs the same way

We will be looking at simplifying K-maps to a **simple expression**.

## Finding Min SOPs from K-Maps

For a given K-map we need to be able to find the corresponding Min SOP. To do this we look for groups of cells that correspond to products `xy', x'yz, ...`. We also look for products with as few variables as possible.

- So remember
	- Look for groups that are `4 x 2`, `4 x 1`, `4 x 1`, `2 x 2`, `2 x 1`
		- Because products involve only powers of `2`
	- Make groups as large as possible
		- The larger the group, the simpler the product
	- Overlap groups if possible
		- Without introducing redundancy
	- Don't forget to **split** the groups
		- With cells at opposite edges of the K-map

![kmap minsop from kmap1](http://i.imgur.com/T6dH11q.png)

### Examples of incorrect and correct grouping of cells

![kmap minsop from kmap2](http://i.imgur.com/GukM5TQ.png)

![kmap minsop from kmap3](http://i.imgur.com/V1PpeGq.png)

![kmap minsop from kmap4](http://i.imgur.com/OkJ01J8.png)

## Min SOP from K-maps Examples

### Example 1

Find the Min SOP corresponding to the Karnaugh Map.

![kmap minsop from kmap ex1](http://i.imgur.com/2VF4uH5.png)

### Example 2

Find the Min SOP corresponding to the Karnaugh Map.

![kmap minsop from kmap ex2](http://i.imgur.com/jVy3AJU.png)

### Example 3

Find the Min SOP corresponding to the Karnaugh Map.

![kmap minsop from kmap ex3](http://i.imgur.com/2Stnmpt.png)

### Example 4

Find the Min SOP corresponding to the Karnaugh Map.

![kmap minsop from kmap ex4](http://i.imgur.com/IZVmbT8.png)

### Example 5

Find the Min SOP corresponding to the Karnaugh Map.

![kmap minsop from kmap ex5](http://i.imgur.com/HJRQpRm.png)

### Example 6A

Find the Min SOP corresponding to the Karnaugh Map.

![kmap minsop from kmap ex6a](http://i.imgur.com/8tUPYMH.png)

### Example 6B

Find the Min SOP corresponding to the Karnaugh Map.

![kmap minsop from kmap ex6b](http://i.imgur.com/bNBiQGX.png)

### Example 7

Find the Min SOP corresponding to the Karnaugh Map.

![kmap minsop from kmap ex7](http://i.imgur.com/5ncev9b.png)

### Example 8

Find the Min SOP corresponding to the Karnaugh Map.

![kmap minsop from kmap ex8](http://i.imgur.com/cFbuOmI.png)

### Example 9

Find the Min SOP corresponding to the Karnaugh Map.

![kmap minsop from kmap ex9](http://i.imgur.com/gfQjnlS.png)

### Example 10

Find the Min SOP corresponding to the Karnaugh Map.

![kmap minsop from kmap ex10](http://i.imgur.com/jeFd3wI.png)

## Design Problem Type 1: From Truth Table to Circuit

The specifications of a circuit are given in a truth table. The task is to design a circuit with output as specified in the truth table.

- The steps are:
	- From the truth table, obtain a Boolean expression
	- Construct a Karnaugh Map
	- Find a corresponding Min SOP
	- Draw the minimal `AND`-`OR` circuit

### Example

Design a minimal `AND`-`OR` circuit to give the output `P` as shown in the truth table below:


| `x` | `y` | `z` | `P` |
|:---:|:---:|:---:|:---:|
| 0   | 0   | 0   | 0   |
| 0   | 0   | 1   | 1   |
| 0   | 1   | 0   | 1   |
| 0   | 1   | 1   | 1   |
| 1   | 0   | 0   | 1   |
| 1   | 0   | 1   | 0   |
| 1   | 1   | 0   | 1   |
| 1   | 1   | 1   | 0   |

From the truth table, the CSOP is:

```
P = x'y'z + x'yz' + x'yz + xy'z' + xyz'
```

![kmap design prob1](http://i.imgur.com/gKJSaeX.png)

![gate design prob1](http://i.imgur.com/Z4YXfC0.png)

## Design Problem Type 2: Simplifying a Given Circuit

A logical circuit is given, and the task is to produce a simpler circuit with the same output.

- The steps are:
	- From the given circuit, obtain a Boolean expression
	- Construct a Karnaugh map
	- Find a corresponding Min SOP
	- Draw the minimal `AND`-`OR` circuit

### Example

Design a minimal `AND`-`OR` circuit that does the same job as the circuit below:

![gate design prob2a](http://i.imgur.com/HK9FmFF.png)

From the circuit, the Boolean expression is:

```
R = (y' + z)x' + (x + z')y = x'y' + x'z + xy + yz'
```

Converted to a K-map:

![kmap design prob2](http://i.imgur.com/iPYgHcg.png)

Simplified circuit:

![kmap design prob2b](http://i.imgur.com/4fpbp68.png)

# Application: 7-Segment Display

Some digital devices such as calculators, microwaves, clocks etc use a 7-segment display, in which each number is represented by a 7 tiny light-emmiting diodes (LEDs) arranged like this:

![7seg five](http://i.imgur.com/UBZnzUG.png)

When a numeric key (0, 1, 2, ..., 9) is pressed, the appropriate lights come on. For example if key `5` is pressed, the display is shown above.

Decimal digits display on 7-segment display:

![7seg digits](http://i.imgur.com/oro4Rgu.png)

To display decimal digits, we have to design a seven segment decoder circuit.

![7seg decoder](http://i.imgur.com/40wPZJz.png)

## 7-Segment Decoder Truth Table

- Key is the key pressed, 0-9
- `w` - `z` is the inputs
- `a` - `g` is the outputs

| Key | `w` | `x` | `y` | `z` | `a` | `b` | `c` | `d` | `e` | `f` | `g` |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| 0   | 0   | 0   | 0   | 0   |     |     |     |     | 1   |     |     |
| 1   | 0   | 0   | 0   | 1   |     |     |     |     | 0   |     |     |
| 2   | 0   | 0   | 1   | 0   |     |     |     |     | 1   |     |     |
| 3   | 0   | 0   | 1   | 1   |     |     |     |     | 0   |     |     |
| 4   | 0   | 1   | 0   | 0   |     |     |     |     | 0   |     |     |
| 5   | 0   | 1   | 0   | 1   |     |     |     |     | 0   |     |     |
| 6   | 0   | 1   | 1   | 0   |     |     |     |     | 1   |     |     |
| 7   | 0   | 1   | 1   | 1   |     |     |     |     | 0   |     |     |
| 8   | 1   | 0   | 0   | 0   |     |     |     |     | 1   |     |     |
| 9   | 1   | 0   | 0   | 1   |     |     |     |     | 0   |     |     |

Segment `e` = `w'x'y'z' + w'x'yz' + w'xyz' + wx'y'z'`

Min SOP for segment `e` = `x'y'z' + w'yz'`, as shown in the Karnaugh map below.

![7seg kmap segmente](http://i.imgur.com/thRKOak.png)

#`NAND` gate

One reason why a `NAND` gate is important is that it is a *unversal gate*, which means that a logic circuit can be made entirely from `NAND`s.

A `NAND` gate has two or more inputs. Its output is the negation of the products of the inputs. So it is the opposite of `AND`.

![gate NAND](http://i.imgur.com/BnqbdAA.png)

## `NAND` Truth Tables

| `x` | `y` | `(x • y)'` |
|:---:|:---:|:----------:|
| 0   | 0   | 1          |
| 0   | 1   | 1          |
| 1   | 0   | 1          |
| 1   | 1   | 0          |

| `x` | `y` | `z` | `(x • y • z)'` |
|:---:|:---:|:---:|:--------------:|
| 0   | 0   | 0   | 1              |
| 0   | 0   | 1   | 1              |
| 0   | 1   | 0   | 1              |
| 0   | 1   | 1   | 1              |
| 1   | 0   | 0   | 1              |
| 1   | 0   | 1   | 1              |
| 1   | 1   | 0   | 1              |
| 1   | 1   | 1   | 0              |

## The *Universality* of `NAND`s

We can construct a circuit entirely from `NAND`s because we can construct `AND`, `OR` and `NOT` gates from `NAND`s, as shown below. Therefore, in any `AND`-`OR` circuit, the `AND`, `OR` and `NOT` gates can be replaced by appropriate combinations of `NAND`s.

![gate NAND universal](http://i.imgur.com/4RivA6M.png)

So a `NAND` is called a *universal gate*.

## Converting `AND`-`OR` circuit to `NAND`s only

One way to convert an `AND`-`OR` circuit to one that uses only `NAND`s is to replace each `AND`, `OR` and `NOT` by the equivalent `NAND` circuit, and then simplify where possible.

A simpler algebraic meethod uses de Morgan's laws.

We begin with the sum of products that represents the circuit.

We negate this expression twice, and then use de Morgan's law on the inner negation to obtain an expression in terms of `NAND`s.

### Example

Suppose we want to change the sum of products

```
L = xy'z + x'y
```

into an expression in terms of `NAND`s. We negate the expression twice, and use de Morgan's law:

```
L 	= (xy'z + x'y)
	= ((xy'z + x'y)')'
	= ((xy'z)'(x'y)')'
```

The resulting circuit with `NAND` gates:

![gate NAND convert](http://i.imgur.com/LXLprBP.png)