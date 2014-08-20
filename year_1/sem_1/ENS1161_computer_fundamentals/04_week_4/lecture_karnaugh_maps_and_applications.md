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

![kmap 4var prob5](http://i.imgur.com/G3WhLPH.png)

The answer is `wy + xz + w'y'`

#### Example 6:

Find the Boolean sum of products represented by the K-map below.

![kmap 4var prob6](http://i.imgur.com/9vqELIT.png)

The answer is `xy' + w'yz' + wx'yz`

#### Example 7:

Find the Boolean sum of products represented by the K-map below.

![kmap 4var prob7](http://i.imgur.com/Cuh6TTr.png)

The answer is `x' + w'y'z + wyz`

#### Example 8:

Find the Boolean sum of products represented by the K-map below.

![kmap 4var prob8](http://i.imgur.com/82iZ5Fg.png)

The answer is `wxy + w'y'z + w'x'z'`

#### Example 9:

Find the Boolean sum of products represented by the K-map below.

![kmap 4var prob9](http://i.imgur.com/ZWm1YNL.png)

The answer is `wz + w'x + w'y'z' + yz`

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

## Typical Design Problems

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

![kmap minsop from kmap1](http://i.imgur.com/Tx5Z83k.png)

### Examples of incorrect and correct grouping of cells

![kmap minsop from kmap2](http://i.imgur.com/GukM5TQ.png)

![kmap minsop from kmap3](http://i.imgur.com/V1PpeGq.png)

![kmap minsop from kmap4](http://i.imgur.com/yja2t45.png)

## Min SOP from K-maps Examples

### Example 1

Find the MIN SOP corresponding to the Karnaugh Map.

