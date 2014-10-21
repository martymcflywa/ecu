# Matrices and applications 2

## 2D geometric transformations

Two-dimensional geometric transformations are an important application of matrices, and they also proide an easy way to illustrate various matrix concepts.

We imagine that the X-Y plane undergoes some sort of transformation - a rotation, reflection, a stretch, etc, and each point of the plane is mapped onto some other point.

However the reference system - the X and Y axes do not move.

So for each point in the plane we can consider its position before the transformation, and its position after the transformation (usually called its "image").

### Example: Rotation

Consider 90° rotation about the origin.

Anti-clockwise rotation is positive, and clockwise rotation is negative.

![example rotation](http://snag.gy/1SsYZ.jpg)

Such transformations can be simply represented by a pair of equations.

>x' = ax + by  
y' = cx + dy

in which:

>(x, y) are the coordinates of a point before the transformation  
(x', y') are the coordinates of its image after the transformation

The equations for the 90° rotation above are very simple.

#### Equation

Suppose that we label the vertices A, B, C, D and E, as shown.

![equation graph](http://i.imgur.com/qHoj2yv.png?1)

From the table it is easy to check that:

>x' = -y  
y' = x

So the x-coordinate of the image is -1 times the y-coordinate of the original point, and the y-coordinate of the image is equal to the x-coordinate of the original point.

### Example: Reflection

Consider reflection in the X-axis.

![example reflection](http://snag.gy/KOJlG.jpg)

It easy to see that for any point, the x-coordinate of its image remains unchanged, but the y-coordinate changes sign.

More precisely:

>x' = x  
y' = -y

### Example: Rotation and magnification

The figure below illustrates a more complex transformation that involves a rotation and also a magnification.

![example rotation and magnification](http://snag.gy/QkujU.jpg)

In fact the equations for the transformation are:

>x' = x - y  
y' = x + y

As previously, (x, y) are the coordinates of a point before the transformation, and (x', y') are the coordinates of its image after the transformation.

## Representation of a transformation using matrices

We have seen several examples of 2D geometric transformations that were represented by a pair of equations

>x' = ax + by  
y' = cx + dy

in which (x, y) are the coordinates of a point before the transformation, and (x', y') are the coordinates of its image after the transformation.

We rewrite these equations as a single matrix equation:

![matrix equation](http://snag.gy/dTFuP.jpg)

Such a representation makes calculations much simpler, as we shall see.

It also has the advantage that it separates the **input** (the original point), the **output** (the image of the point) and the **process** (the matrix that represents the transformation, which is rotation, reflection etc.)

## How to find image of a point under transformation

Suppose we have a 2D geometric transformation that is represented by a matrix:

![matrix equation](http://snag.gy/0XAcD.jpg)

and we want to find the image of some point (x, y).

First we represent the point (x, y) by the column matrix:

![column xy](http://snag.gy/i48z7.jpg)

And then we use the matrix equation:

![matrix equation](http://snag.gy/gLjUc.jpg)

to find the column matrix:

![column x'y'](http://snag.gy/LuHlK.jpg)

and this represents the image (x', y').

### Example 1

Suppose we want to find the images of points

>(-1, 0), (-2, 4), (-3, 0) and (-2, -1)

which are the vertices of the *tree* under the transformation 90° rotation about the origin.

We represent these points by:

![xy points](http://snag.gy/c4syd.jpg)

The matrix that represents the transformation is:

![transform matrix](http://snag.gy/YZDnt.jpg)

So we can multiply each of the column matrices by this matrix:

![multiply xy by transform](http://snag.gy/2ve3D.jpg)

From these four matrix multiplications, we find that the images of the four points:

>origin: (-1, 0), (-2, 4), (-3, 0), (-2, -1)  
image: (0, -1), (-4, -2), (0, -3), (1, -2)

![matrix multiply](http://snag.gy/vNs3L.jpg)

### Note: Abbreviation

We can abberviate this process by combining the column matrices and performing just one matrix multiplication:

![abberviate](http://snag.gy/REil8.jpg)

and from this single matrix equation, we again see that the images of the four points  (-1, 0), (-2, 4), (-3, 0) and (-2, -1) are (0, -1), (-4, -2), (0, -3) and (1, -2), respectively.

### Example 2

Find the images of the points:

>(1, 0), (1, 1), (3, 2), (4, 1) and (4, 0)

which are the vertices of the *house*, under reflection in the Y-ais, which is represented by the matrix:

![y reflect](http://snag.gy/YWn3F.jpg)

![matrix multiply](http://snag.gy/U3JwY.jpg)

So the images of the five points are:

>(-1, 0), (-1, 1), (-3, 2), (-4, 1) and (-4, 0)

## How to find matrix of a given transformation

Finding the matrix that represents a particular transformation is a simple matter if we can determine the images of just two points, namely the points (1, 0) and (0, 1).

Given this information, we can write down the matrix because its first column is the image of point (1, 0) and its second column is the image of the point (0, 1).

### Example 1: -90° rotation

Find the matrix that represents -90° rotation about the origin.

The transformation would look like this:

![-90 rotation](http://snag.gy/OPObZ.jpg)

All we need to consider is what happens to the two points (1, 0) and (0, 1). Suppose we called them *I* and *J*, and make them the corners of a square.

After a clockwise rotation of 90°, the image of *I* is *I'* at (0, -1).

So the first column of the matrix is:

![first column](http://snag.gy/7036b.jpg)

and the image of *J* is *J'* at (1, 0), which gives us the second column of the matrix:

![second column](http://snag.gy/tDV9b.jpg)

So this is the matrix for -90° rotation.

### Example 2: 180° rotation

Find the matrix for a 180° rotation about the origin.

Once again, all we need to consider is what happens to the two points I(1, 0) and J(0, 1).

![180 rotation](http://snag.gy/bNX3Q.jpg)

After a rotation of 180°, the image of I is I' at (-1, 0), and the image of J is J' at (0, -1). So the matrix for a 180° rotation about the origin is:

![180 rotation matrix](http://snag.gy/pVLm7.jpg)

### Example 3: Reflection

Find the matrix that represents reflection in the line y = x.

The transformation would look like this:

![reflection](http://snag.gy/MqCna.jpg)

The dotted line is the line y = x, which in this case is the mirror. It may be easier to visualize the transformation by superimposing the before and after pictures, as shown in the next figure.

![mirror](http://snag.gy/z274R.jpg)

Objects on one side of the mirror have their images on the opposite side.

Once again, all we need to consider is what happens to the two points I(1, 0) and J(0, 1).

![I and J reflection](http://snag.gy/3gaaQ.jpg)

In fact, I and J *swap places*. In other words, I' is at (0, 1) and J' is at (1, 0).

These give us the first and second columns of the matrix.

So the matrix for reflection in the line y = x is:

![reflection matrix](http://snag.gy/DuNIK.jpg)

### Exercise

Show that the matrix that represents reflection in the line y = -x is:

![exercise matrix](http://snag.gy/v1zOP.jpg)

The line y = -x is a line through the origin making an angle of -45° with the X-axis.

![exercise graph](http://snag.gy/ggV5D.jpg)

![finding answer](http://snag.gy/mpTOl.jpg)

## Successive transformations

Suppose we have a transformation that is a combination of two transformations, applied one after another.

How are the various matrices related?

For example, suppose that a transformation, represented by matrix L, is followed by another transformation, represented by matrix M, and suppose that the combined transformation is represented by matrix P.

How are L, M and P related?

It turns out that P = ML. In other words, if the transformation represented by L is followed by the transformation represented by M, the combined transformation is represented by ML.

### Example 1

The matrix for reflection in the X-axis is:

![reflection](http://snag.gy/Ro9hr.jpg)

The matrix for a 90° rotation about the origin is:

![90 rotation](http://snag.gy/99l3s.jpg)

So the matrix for reflection in the X-axis followed by a 90° rotation about the origin is:

![combo transform](http://snag.gy/dWXtp.jpg)

In fact, this is the matrix for reflection in the lin y = x, which we considered earlier.

### Example 2

Notice what happens when we reverse the order of the transformations in the previous example.

The matrix for a 90° rotation about the origin followed by reflection in the X-axis is:

![combo matrix](http://snag.gy/N4gcd.jpg)

which is the matrix for reflection in the line y = x.

So here we have an example of non-commutativity of multiplication. That is, we have two matrices A and B, and AB ≠ BA.

### Example 3

The matrix for 90° rotation about the origin is:

![90 rotation](http://snag.gy/SMmfP.jpg)

So the matrix for a 90° rotation followed by another 90° rotation is:

![combo matrix](http://snag.gy/Rnndw.jpg)

Finding the matrix:

![combo](http://snag.gy/x2oUO.jpg)

## Identity matrices

An identity matrix is a square matrix with all entries on the **leading diagonal** equal to 1, and all other entries equal to 0.

For example:

![identity matrix](http://snag.gy/Wojfx.jpg)

Such a matrix is usually denoted by *I*. An identity matrix *behaves like* the number 1, in that it has no effect when it is multiplied by another matrix. In other words, for any matrix A:

>AI = IA = A

## Inverse of a square matrix

Some square matrices have inverses. In looking for the inverse of a particular square matrix A, we are looking for a matrix which, when multiplied by A, will give I:

![inverse](http://snag.gy/mjLRr.jpg)

If A<sup>-1</sup> exists, then:

>AA<sup>-1</sup> = A<sup>-1</sup>A = I

Whether or not a particular matrix has an inverse depends on a number called its determinant.

An inverse of a particular matrix exists if and only if the determinant is not zero.

### Example 1

The two matrices below are inverses.

![inverse 1](http://snag.gy/TU3Jf.jpg)

We can verify this by multiplying them:

![multiply inverse 1](http://snag.gy/OFYcK.jpg)

### Example 2

The two matrices below are inverses.

![inverse 2](http://snag.gy/OxwCq.jpg)

We can verify this by multiplying them:

![multiply inverse 2](http://snag.gy/ubIje.jpg)

## Formula for inverse of 2x2 matrix

There is a simple formula for the inverse of a 2x2 matrix.

Consider the matrix:

![M](http://snag.gy/P7Au0.jpg)

The formula for the inverse is:

![M^-1](http://snag.gy/mWHrZ.jpg)

where D is the number ad - bc.

We can write this formula more simply as:

![inverse formula](http://snag.gy/9zxbY.jpg)

### Example 1

Find the inverse matrix:

![inverse example 1](http://snag.gy/E9iuT.jpg)

Solution:

![inverse solution 1](http://snag.gy/N35pS.jpg)

### Example 2

Find the inverse matrix:

![inverse example 2](http://snag.gy/RjQUs.jpg)

Solution:

![inverse solution 2](http://snag.gy/qI5qP.jpg)

### Example 3

Find the inverse matrix:

![inverse example 3](http://snag.gy/AZIlY.jpg)

Solution:

![inverse solution 3](http://snag.gy/Ohnr0.jpg)

### Example 4

Find the inverse matrix:

![inverse example 4](http://snag.gy/NYxsW.jpg)

Solution:

![inverse solution 4](http://snag.gy/WKf1f.jpg)

### Example 5

Find the inverse matrix:

![inverse example 5](http://snag.gy/EFhja.jpg)

Solution:

![inverse solution 5](http://snag.gy/iM7Sx.jpg)

### Example 6

Find the inverse matrix:

![inverse example 6](http://snag.gy/orUeP.jpg)

Solution:

![inverse solution 6](http://snag.gy/K5ihO.jpg)

## Inverse geometric transformations

### Example 1: Rotation

The matrix that represents 90° rotation:

![transform inverse example 1](http://snag.gy/rNN4G.jpg)

The inverse is:

![transform inverse solution 1](http://snag.gy/MP1aO.jpg)

which is the matrix that represents rotation through -90°.

### Example 2: Reflection

The matrix that represents reflection in the X-axis is:

![transform inverse example 2](http://snag.gy/JHZET.jpg)

The inverse is:

![transform inverse solution 2](http://snag.gy/0sItU.jpg)

which is the matrix that represents reflection in the X-axis.

### Example 3: Magnification

The matrix that represents magnification by a factor of 2 is:

![transform inverse example 3](http://snag.gy/elXqe.jpg)

In this transformation, lengths and widths are all doubled. The inverse is:

![transform inverse solution 3](http://snag.gy/CspK8.jpg)

which is the matrix that represents magnification by a factor of 0.5.

## The determinant of a matrix

The number ad - bc determines whether or not the matrix has an inverse, and for this reason it is called the determinant of the matrix.

A 2x2 matrix has an inverse provided that its determinant is not zero. We can state the rule for an inverse more precisely as follows:

The matrix:

![determinant](http://snag.gy/daBg3.jpg)

has an inverse if and only if:

>ad - bc ≠ 0.

And the formula for the inverse is:

![inverse formula](http://snag.gy/Mzhnp.jpg)

## Matrix representation of systems of equations

A system of equations may be represented by a single matrix equation.

For example, the system of equations:

>ax + by = h  
cx + dy = k

is equivalent to the single matrix equation:

![single matrix equation](http://snag.gy/Q009y.jpg)

To see this equivalence, we "multiply out" the matrix equation.

This gives:

![multiply out](http://snag.gy/cHAEb.jpg)

Then, using the definitions of equality of matrices, the corresponding elements are equal, and so:

>ax + by = h  
cx + dy = k

which is the original system of equations.

Similarly, the system of equations:

>ax + by + cz = k  
dx + ey + fz = m  
gx + hy + jz = n

is equivalent to the matrix equation:

![matrix equation](http://snag.gy/RmSd5.jpg)

### Example 1

The system of equations:

>4x + 5y = 12  
2x + 3y = 8

is represented by the matrix equation:

![matrix equation](http://snag.gy/WdNGl.jpg)

### Example 2

The system of equations:

>–3y + 4z = 11  
5x + 2y – 6z = –8  
x + 7y = 5

is represented by the matrix equation:

![matrix equation](http://snag.gy/ZlwX3.jpg)

### Example 3

Verify that the system of equations:

>3x − 4y = 7  
2x + y = −3

is equivalent to the matrix equation:

![matrix equation](http://snag.gy/skJii.jpg)

### Example 4

Verify that the matrix equation:

![matrix equation](http://snag.gy/KfNhR.jpg)

is equivalent to the system of equations:

>–2x + 3y = 5  
4y = – 4

### Example 5

Verify that the system of equations:

>4x + 5y − 3z = 7  
3x + 5z = −4  
x − 3y + 4z = 1

is equivalent to the matrix equation:

![matrix equation](http://snag.gy/TqJFR.jpg)

### Example 6

Verify that the matrix equation:

![matrix equation]()

is equivalent to the system of equations:

>4x –2z = 5  
3x + y + –z = –2  
2y – 3z = 7

## Solution of a matrix equation

We rewrite the matrix equation:

![matrix equation](http://snag.gy/ufFMS.jpg)

as:

>AX = H (1)

where:

![AX = H](http://snag.gy/Grp58.jpg)

Now equation (1) looks like a simple equation such as 5x = 40.

For this simple equation, the solution, x = 8 is obvious.

However, if we put in all the algebraic steps to solve this equation, we get:

>5x = 40

Multiply both sides by 1/5:

>(1/5)5w = (1/5)40  
1w = 8  
w = 8

This solution depends on two important results:

>1/5 * 5  
1w = w

We attempt to perform analogous operations on equation (1):

>AX = H

Pre-multiply both sides by A<sup>-1</sup>.

>A<sup>-1</sup>AX = A<sup>-1</sup>H  
IX = A<sup>-1</sup>H  
X = A<sup>-1</sup>H

If the operations above are possible, then they would give a solution for X and hence for x and y.

The only possible catch is that the inverse A<sup>-1</sup> may not exist, but if it does exist, the procedure will work.

Notice that this solution also depends on two results:

>A<sup>-1</sup>A = I  
IX = X

### Example 1

Solve the following systems of equations using matrices:

>4x + 5y = 12  
2x + 3y = 8

Solution: Re-write the system as the matrix equation:

![matrix equation](http://snag.gy/IXDCb.jpg)

Find the inverse of the first matrix:

![m](http://snag.gy/t8OiF.jpg)

which is:

![m^-1](http://snag.gy/BKlQk.jpg)

then multiply both sides by the inverse:

![multiply out](http://snag.gy/XIIMP.jpg)

Multiplying out we get:

![solution](http://snag.gy/ekzpB.jpg)

from which we get:

>x = -2  
y = 4

These satisfy the given system of equations.

## Example 2

Given that the inverse of the matrix:

![inverse](http://snag.gy/n9pyq.jpg)

solve the system of equations:

>x + 3y + z = 4  
2x + 2y + z = −1  
2x + 3y + z = 3

Solution:

Rewrite the system as:

![matrix equation](http://snag.gy/VUJKF.jpg)

Therefore:

>x = -1  
y = 4  
z = -7

### Note

Since we have not looked at methods of finding the inverse of a 3x3 or higher order matrix, the inverse of such a matrix must be given as part of the exercise.