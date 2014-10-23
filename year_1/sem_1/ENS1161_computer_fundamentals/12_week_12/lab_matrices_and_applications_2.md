# Exercises set 12

## Question 1

A polygon has vertices:

- A(-1, 1)
- B(3, 1)
- C(1, -1)
- D(1, 0)
- E(-1, 0)

![q1](http://snag.gy/xbtx9.jpg)

Plot the vertices and join them. Then find and plot the images of the vertices after transformation by:

### 1:

![q1-1](http://snag.gy/IF47c.jpg)

- A'(1, 3)
- B'(1, -1)
- C'(-1, -3)
- D'(0, -1)
- E'(0, 1)

### 2:

![q1-2](http://snag.gy/3dPUG.jpg)

- A'(-1, 1)
- B'(-1, -3)
- C'(1, -1)
- D'(0, -1)
- E'(0, 1)

### 3:

![q1-3](http://snag.gy/isfeQ.jpg)

- A'(0, 1)
- B'(-4, -3)
- C'(0, -1)
- D'(-1, -1)
- E'(1, 1)

### 4:

![q1-4](http://snag.gy/R8sFb.jpg)

- A'(0, 2)
- B'(4, -2)
- C'(0, -2)
- D'(1, -1)
- E'(-1, 1)

### 5:

![q1-5](http://snag.gy/sRz5H.jpg)

- A'(0, 1)
- B'(4, 1)
- C'(0, -1)
- D'(1, 0)
- E'(-1, 0)

### 6:

![q1-6](http://snag.gy/zgEbJ.jpg)

- A'(1, 2)
- B'(-3, -2)
- C'(-1, -2)
- D'(-1, -1)
- E'(1, 1)

## Question 2

By determining the images of the points I(1, 0) and J(0, 1), find the matrix for each of the following transformations.

![q2](http://snag.gy/GtkLy.jpg)

- I = red
- J = blue

### 1:

2-fold stretch parallel to the X-axis. All x-coordinates are doubled, y-coordinates remain unchanged.

- I'(2, 0)
- J'(0, 1)

![q2-1](http://snag.gy/HG0eX.jpg)

### 2:

Magnification by a factor of 2. All coordinates are doubled.

- I'(2, 0)
- J'(0, 2)

![q2-2](http://snag.gy/RdJds.jpg)

### 3:

90° rotation about the origin.

- I'(0, 1)
- J'(-1, 0)

![q2-3](http://snag.gy/RzPdc.jpg)

### 4:

Reflection in the X-axis.

- I'(1, 0)
- J'(0, -1)

![q2-4](http://snag.gy/8H9R8.jpg)

### 5:

Reflection in the Y-axis.

- I'(-1, 0)
- J'(0, 1)

![q2-5](http://snag.gy/F534K.jpg)

### 6:

Reflection in the y = -x.

- I'(0, -1)
- J'(-1, 0)

![q2-6](http://snag.gy/xb02J.jpg)

## Question 3

This exercise uses the following transformations and matrices:

![q3](http://snag.gy/MF2gw.jpg)

Each of the following involves the combination of one transformation followed by a second transformation. Your task is to multiply the appropriate matrices in the correct order and then identify the resulting information.

Find the transformation that is the combination of:

### 1:

Reflection in Y-axis followed by rotation through 90°.

>M1 * M5 = M7  
Reflection in line y = -x.

Answer given as:  
Reflection in line y = x  
Therefore answer given is calculated by AB = C instead of BA = C.  

Determining multiplication order is situational.  
See Successive_Transform.pdf from Wlodek.

### 2:

Reflection in line y = x followed by reflection in X-axis.

>M4 * M6  
Rotation through -90°

Answer is given as:  
Rotation through 90°  
Therefore answer given is calculated by AB = C instead of BA = C.  

Determining multiplication order is situational.  
See Successive_Transform.pdf from Wlodek.

### 3:

Reflection in line y = -x followed by reflection in line y = x.

>M6 * M7  
Rotation through 180°

### 4:

Reflection in line y = -x followed by rotation through -90°.

>M2 * M7  
Reflection in Y-axis

### 5:

Rotation through 180° followed by reflection in Y-axis.

>M5 * M3  
Reflection in X-axis

### 6:

Rotation through -90° followed by reflection in line y = -x.

>M7 * M2  
Reflection in X-axis

## Question 4

For each of the following 2x2 matrices, find the inverse if it exists, and if there is no inverse, say so.

>Inverse is possible if:  
ad - bc ≠ 0

### 1:

![q4-1](http://snag.gy/f9uQb.jpg)

### 2:

![q4-2](http://snag.gy/9Fy5H.jpg)

### 3:

![q4-3](http://snag.gy/nNVeO.jpg)

1*4 - 2*2 = 0.  
No inverse.

### 4:

![q4-4](http://snag.gy/2DUCS.jpg)

### 5:

![q4-5](http://snag.gy/ClveE.jpg)

### 6:

![q4-6](http://snag.gy/lrAgO.jpg)

If inverse is the same, check ad - bc = 0.

1 * 1 - (-1 * -1) = 0.  
No inverse.

### 7:

![q4-7](http://snag.gy/LObbZ.jpg)

### 8:

![q4-8](http://snag.gy/TL8Pm.jpg)

### 9:

![q4-9](http://snag.gy/llmFo.jpg)

1 * (-1) - (0 * 0) = -1.  
Inverse exists.

### 10:

![q4-10](http://snag.gy/feCK2.jpg)

## Question 5

For each of the following pairs of matrices, check whether the two matrices are inverses of each other.

### 1:

![q5-1](http://snag.gy/fkIhp.jpg)

Yes.

Calculator may represent 0 as E digit.

### 2:

![q5-2](http://snag.gy/Nmkda.jpg)

No.

### 3:

![q5-3](http://snag.gy/k9XPw.jpg)

Yes.

Calculator may represent 0 as E digit.

### 4:

![q5-4](http://snag.gy/NdRVq.jpg)

No.

## Question 6

Solve each of the following system of equations using matrices:

Don't forget to include `-` sign when applicable.

### 1:

>2x + y = 3  
5x + 2y = 9

![q6-1](http://snag.gy/fIEzh.jpg)

### 2:

>3x - 2y = 10  
4x - y = 15

![q6-2](http://snag.gy/6ybVX.jpg)

### 3:

>2y = -10  
-x + 5y = -3

![q6-3](http://snag.gy/TRuFH.jpg)

## Question 7

### 1:

Verify that the matrices below are inverses:

![q7-1](http://snag.gy/7SE5D.jpg)

The matrices are inverses of each other.

### 2:

Solve the system of equations:

>2x + y - z = 1  
3x + 2y - 2z = 0  
2x + z = 5

![q7-2](http://snag.gy/u2uhm.jpg)

### 3:

Solve the system of equations:

>2x - y = 0  
-7x + 4y + z = 4  
-4x + 2y + z = 3

![q7-3](http://snag.gy/9TejP.jpg)

## Question 8

Given that the inverse of matrix M is shown below:

![q8-0](http://snag.gy/dnVoJ.jpg)

show that the solution of the system of equations:

>x + 3y + z = 4  
2x + 2y + z = -1  
2x + 3y + z = 3

is:

>x = -1, y = 4, z = -7

![q8-1](http://snag.gy/gQU1c.jpg)

## Question 9

### 1:

Show that the matrices below are inverses:

![q9-1](http://snag.gy/p6Hdo.jpg)

The matrices are inverses of each other.

### 2:

Solve the system of equations:

>-x -2y - 3z = -7  
w + x + 4y + 4z = 10  
w + 3x + 7y + 9z = 22  
-w - 2x - 4y - 6z = -16

![q9-2](http://snag.gy/SKDxB.jpg)