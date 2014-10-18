# Matrices and applications 1

## Definitions and terminology

A matrix is a rectangular array of numbers. We have seen that such an array of numbers could represent:

- Relations between sets
- Connections in a graph
	- Adjacency matrix

But they could also represent:

- 2D and 3D geometric transformations
	- Rotations
	- Reflections etc.
- Stresses in the framework that holds a building together
- Voltages in an electrical network
- Densities of body tissue in a CAT scan
- Intensities of infra-red radiation in a satellite image
- Monthly sales of various types of goods

The numbers that form a matrix are usually called **elements** and somtimes it is convenient to refer to particular elements by specifying the **row** and **column** they occupy.

For example, suppose we have a matrix:

![element position](http://snag.gy/xwaqu.jpg)

In general the elment in the `i`th row and `j`th column is called m<sub>ij</sub>. This method of naming elements is called **subscription notation**.

### Subscription notation

Using subscription notation we would write a `2x3` matrix A like this:

![subscript A](http://snag.gy/NHugu.jpg)

![subscript B](http://snag.gy/SWhNc.jpg)

## Order, square matrices, column and row matrices

The order of a matrix tells us how many rows and columns it has. For example, a `10x3` matrix has 10 rows and 3 columns. 

So the order of these three matrices:

![order](http://snag.gy/fsnIs.jpg)

For obvious reasons, a matrix that has the same number of rows and columns, for example `3x3` is called **square**, a matrix with just one column is called a **column** matrix, and a matrix with just one row is called a **row** matrix.

![square row column](http://snag.gy/KKAVX.jpg)

## Equality of matrices

Two matrices are said to be equal if they have the same order, and the corresponding elements are equal.

![equality](http://snag.gy/vHv9q.jpg)

## Addition of matrices

Matrices may be added, provided that they are the same size and shape.

>To add two matrices, simply add the corresponding elements.

![addition](http://snag.gy/9cgdH.jpg)

## Multiplication by a number

A matrix may be multiplied by a number.

>To multiply a matrix by a number, multiply every element by the number

### Example 1

![multiply by x 1](http://snag.gy/lWJDY.jpg)

### Example 2

![multiply by x 2](http://snag.gy/RNkIP.jpg)

### Example 3

This is convenient, for example, when fractions are involved, ie:

![multiply by x 3](http://snag.gy/A29wR.jpg)

## Multiplying two matrices

The appendix for week 5 gave a detailed explanation of the method for multiplying two matrices.

For example:

![multiply two matrices](http://snag.gy/RnngW.jpg)

To multiply matrices we combine the rows of the first matrix with the columns of the second in a process that involves multiplication and addition.

Suppose we multiply a matrix A by matrix B to obtain matrix C, as shown:

![multiply two matrices](http://snag.gy/D2Z68.jpg)

The element in the 2nd row and 1st column of C comes from the 2nd row of A and the 1st column of B, and is:

>c<sub>21</sub> = a<sub>21</sub>b<sub>11</sub> + a<sub>22</sub>b<sub>22</sub> + a<sub>23</sub>b<sub>23</sub>

We can abbreviate this to:

![multiply abbreviate 1](http://snag.gy/zUlnp.jpg)

Similarly, the element in the 1st row and 2nd column of C, for example, would be:

![multiply abbreviate 2](http://snag.gy/B0fWY.jpg)

More generally, if we were multiplying an `m × n` matrix A by an `n × q` matrix B to obtain an `m × q` matrix C, the formula for the typical element c<sub>ij</sub> of C is:

![multiply formula](http://snag.gy/pZRZQ.jpg)

## Which matrices can be multiplied?

If we try to multiply the following matrices, we find that it is **not possible**:

![not multiplied](http://snag.gy/zeE3E.jpg)

The number of columns of the first matrix is not the same as the number of rows of the second.

Two matrices can be multiplied **only** if the number of columns of the first is equal to the number of rows of the second.

The order of the result also depends on the orders of the two matrices being multiplied.

The simplest way to remember the rule is as follows:

>- Suppose we have an `m × n` matrix and a `p × q` matrix
- Multiplication is possible only if `n = p`
- And if this is the case, then the order of the result is `m × q`

This is sometimes called the domino rule, because it is similar to the rule for the game of dominoes.

![domino 1](http://snag.gy/0d449.jpg)

Then the matching numbers *cancel* and the resulting arrangement is equivalent to:

![domino 2](http://snag.gy/tH7fo.jpg)

- Similarly we can multiply a `4 × 1` matrix by a `1 × 3` matrix
	- The result is `4 × 3`
- Or, we can multiply a `3 × 5` matrix by a `5 × 4` matrix
	- The result is `3 × 4`
- Or, we can multiply a `1 × 2` matrix by a `2 × 6` matrix
	- The result is `1 × 6`

### Example 1

![multiply matrix 1a](http://snag.gy/nftT4.jpg)

The matrices have orders `2 × 3` and `3 × 2`, so the product exists and is `2 × 2`:

![multiply matrix 1b](http://snag.gy/Alnz3.jpg)

### Example 2

![multiply matrix 2a](http://snag.gy/7Xz3y.jpg)

The matrices have orders `2 × 2` and `2 × 2`, so the product exists and is `2 × 2`:

![multiply matrix 2b](http://snag.gy/nRc42.jpg)

### Example 3

![multiply matrix 3a](http://snag.gy/7Vx61.jpg)

The matrices have orders `2 × 2` and `2 × 5`, so the product exists and is `2 × 5`:

![multiply matrix 3b](http://snag.gy/BuR5R.jpg)

### Example 4

![multiply matrix 4a](http://snag.gy/g42ZE.jpg)

Cannot multiply `2 × 3` by `2 × 1`

### Example 5

![multiply matrix 5a](http://snag.gy/GvfUV.jpg)

The matrices have orders `3 × 2` and `2 × 4`, so the product exists and is `3 × 4`:

![multiply matrix 5b](http://snag.gy/MuOYt.jpg)

## Matrix algebra rules

Provided that the orders of the matrices allow the indicated operations to be performed, the following rules of matrix algebra are valid:

>1. A + B = B + A
2. A + (B + C) = (A + B) + C
3. A (B C) = (A B) C
4. A (B + C) = A B + A C
5. (B + C) A = B A + C A

Suppose that:

![rule example 0](http://snag.gy/mLylI.jpg)

### Rule 4: A (B + C) = A B + A C

![rule 4](http://snag.gy/bmHvk.jpg)

So LHS = RHS.

### Rule 5: (B + C) A = B A + C A

![rule 5](http://snag.gy/LjhKF.jpg)

## An important exception

Many of the rules for matrices look like the familiar rules of the ordinary algebra of numbers.

For numbers a and b, it is always true that ab = ba.

However, this rule does not hold for matrices.

For matrices A and B, it may be that AB = BA, but very often AB ≠ BA.

![exception](http://snag.gy/45CTC.jpg)

So in this case, AB = BA, but this is the exception rather than the usual result.

More typically, you will find:

![typical](http://snag.gy/m75oM.jpg)

So CD ≠ DC.

Even more obvious examples of non-commutativity are the following:

Suppose that L and M are matrices such that L is `2 × 3` and M is `3 × 2`.

Then LM is `2 × 2`, while ML is `3 × 3`, so clearly LM ≠ ML.

Suppose that P and Q are matrices such that P is `2 × 3` and Q is `3 × 1`.

Then PQ is `2 × 1`, but QP does not even exist. So obviously PQ ≠ QP.

## Non-commutativity in robotics

Non-commutativity of operations has important consequences in many applicatons, for example in robotics where they erefer to **holonomic** or **non-holonomic** systems.

### Holonomic

For example, a robot arm with two pivot points, as shown below. In the first sequences, the lower arm rotates through 45° and then the upper arm roates through 45°:

![robot 1](http://snag.gy/rvUue.jpg)

![robot 2](http://snag.gy/rmgDh.jpg)

Notice that the final position is unchanged.

This is an example of a holonomic system, in which the order of the operations does not affect the final result.

### Non-holonomic

Contrast the robot arm with a wheel chair that has independent motors on each of its two main wheels.

![wheels 1](http://snag.gy/Bebb8.jpg)

Suppose the left wheel is kept fixed while the motor on the right wheel turns the chair through 90°. 

![wheels 2](http://snag.gy/Ghg0P.jpg)

Compare the final position with that obtained when the operations are reversed. In other words, suppose the right wheel is kept fixed while the motor on the left wheel turns the chair through 90°, and then the left wheel is kept fixed while the motor on the right wheel turns the chair through 90°.

![wheels 3](http://snag.gy/dP7iH.jpg)

The final positions are quite different. This is an example of a non-holonomic system where the order of operations affects the final outcome.

## Application of matrices to directed graphs

In a directed graph (digraph), each edge has a certain direction.

![digraph 1](http://snag.gy/5t2CC.jpg)

In this digraph, it is possible to move directly from D to A. However, it is not possible to move directly from A to D. There is a path from A through B and C to D. So A is "reachable" from D in just one step, whereas D is "reachable" from A in three steps.

The adjacency matrix for this digraph is:

![digraph adjacency](http://snag.gy/DnYMw.jpg)

The vertices where the edges start are shown on the left side of the matrix, and the vertices where the edhes end are shown across the top.

In this digraph there is an edge from D to A, but there is no edge from A to D.

As a check on the accuracy of the matrix, notice that:

- The row totals give the number of edges leaving each vertex
	- Also known as the **outdegree** of the vertex
- The column totals give the number of edges arriving at the vertex
	- Also known as the **indegree** of the vertex

It follows that the sum of the indegrees must equal the sum of the outdegrees.

In this example:

![vertex table](http://snag.gy/ATfsS.jpg)

## Reachability of vertices

Suppose that there are several buildings on a university campus, each with a computer laboratory, and we want to design a communication system (LAN) so that it is possible for a computer in any lab to communicate with a computer in any other lab.

It is not necessary that every pair of buildings is directly linked, since messages could be sent from one building to another via other buildings.

An important practical problem that needs to be considered is, given a proposed set of connections (a digraph), how do we determine which sites are *reachable* from other sites?

### Example 1

Consider a simple digraph with four vertices:

![reachability digraph](http://snag.gy/ePRcy.jpg)

The adjacency matrix is:

![reachability matrix](http://snag.gy/JVay0.jpg)

From the matrix we can see that it is possible to move directly from P to S, from Q to P or R, from R to Q, and from S to R.

It is not possible to move directly from Q to S.

However, S is reachable from Q in two steps, by going via P.

To see which vertices are reachable in two steps, we calculate M<sup>2</sup>, using logical multiplication.

![M^2](http://snag.gy/IZcAg.jpg)

The matrix M<sup>2</sup> shows that P can reach R  in two steps, Q can reach S in two steps, and so on.

To determine 3-step reachability, we calculate M<sup>3</sup>, again using logical multiplication.

![M^3](http://snag.gy/OQkXX.jpg)

From M<sup>3</sup> we can see that, for example, P can reach Q in three steps, S can reach P in three steps, R can reach S in three steps, and so on.

For a digraph with 4 vertices, we calculate as far as M<sup>4</sup>, because for such a digraph, if a vertex is not reachable in 1, 2, 3 or 4 steps, then it cannot be reached at all.

For this digrah:

![M^4](http://snag.gy/XlM19.jpg)

Combining all these results, we calculate the reachability matrix M* that shows which vertices are reachable in 1, 2, 3, or 4 steps.

To find M*, we add M and M<sup>2</sup> and M<sup>3</sup> and M<sup>4</sup>, that is:

>M* = M + M<sup>2</sup> + M<sup>3</sup> + M<sup>4</sup>

Using logical addition:

![M* addition](http://snag.gy/YJ1Kh.jpg)

Which gives:

![M* sum](http://snag.gy/uHLEj.jpg)

So, for this digraph, every vertex is reachable from every other vertex in no more than 4 steps.

### Example 2

Calculate the reachability matrix M* for the following digraph:

![digraph 2](http://snag.gy/KGVBL.jpg)

The adjacency matrix is:

![digraph 2 adjacency](http://snag.gy/BiIpW.jpg)

M<sup>2</sup>, using logical multiplication:

![digraph 2 M^2](http://snag.gy/HkfVz.jpg)

M<sup>3</sup>, using logical multiplication:

![digraph 2 M^3](http://snag.gy/YNUUH.jpg)

M<sup>4</sup>, using logical multiplication:

![digraph 2 M^4](http://snag.gy/pK7Ne.jpg)

M* to find the reachability matrix, using logical addition:

![digraph 2 M*](http://snag.gy/zNkeL.jpg)

Which gives:

![digraph 2 reachability](http://snag.gy/BCYfH.jpg)

### Note

In order of the reachability matrix M* of a digraph, and the number of matrices added to find M*, depends on the number of vertices.

If the digraph has five vertices, then M* will be `5 × 5`, and is obtained from:

>M* = M + M<sup>2</sup> + M<sup>3</sup> + M<sup>3</sup> + M<sup>4</sup> + M<sup>5</sup>

Therefore, if the digraph has *n* vertices, then M* will be *n × n*, and is obtained from:

>M* = M + M<sup>2</sup> + ... + M<sup>n</sup>

