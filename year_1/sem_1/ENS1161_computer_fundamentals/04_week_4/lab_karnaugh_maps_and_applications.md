# Exercises Set 4

## 1: Drawn a Karnaugh map for each of the following sums of products.

![kmap lab q1 3var](http://i.imgur.com/KtLr5tl.png)

![kmap lab q1 4var](http://i.imgur.com/F5Xs78U.png)

## 2: Use the laws of Boolean algebra to reduce each of the following expressions to a sum of products, represent each on a Karnaugh map and then find the MinSOP.

### 1: `x'(y + z') + xy'(y + z)`

![kmap lab q2-1 3var](http://i.imgur.com/MoENWOV.png)

### 2: `yz'(x + yz) + z(x' + y')`

![kmap lab q2-2 3var](http://i.imgur.com/ziQfRY2.png)

### 3: `xy'(x + y)(x' + z)`

![kmap lab q2-3 3var](http://i.imgur.com/ixcpdbD.png)

### 4: `z(x'y + y') + xz'(y' + z)`

![kmap lab q2-4 3var](http://i.imgur.com/fnWIdHi.png)

### 5: `(y + xz')(x + y)`

![kmap lab q2-5 3var](http://i.imgur.com/cUNPoXO.png)

### 6: `(xy' + z)'`

![kmap lab q2-6 3var](http://i.imgur.com/Z33mMTg.png)

### 7: `(y + xz' + x'y')'`

![kmap lab q2-7 3var](http://i.imgur.com/v6fYXRl.png)

#### Issue

Working it out:

```
(y + xz' + x'y')'
y'(x'z + xy)
y'x'z + y'xy
x'y'z + 0
x'y'z
```

#### Correct Answer

```
xy'z
```

But how is the `x` in the answer not a `x'` ?

#### Correct Law

```
(y + xz' + x'y')'
y'(xz')'(x'y')'
y'(x' + z)(x + y)
y'(x'x + x'y + zx + zy)
y'x'x + y'x'y + y'zx + y'zy
0 + 0 + xy'z + 0
xy'z
```

### 8: `(xy' + x'z)'`

![kmap lab q2-8 3var](http://i.imgur.com/p1npvIk.png)

### 9: `y'(z + xy')'`

![kmap lab q2-9 3var](http://i.imgur.com/8ZViLpO.png)

Working it out:

```
y'(z + xy')'
y'z'(x' + y)
y'z'x' + y'z'y
x'y'z' + 0
x'y'z'
```

### 10: `(x' + xy'z)'`

![kmap lab q2-10 3var](http://i.imgur.com/7Pvwbd6.png)

## 3: 

### A: For each of the following, draw a Karnaugh map for the Boolean expression defined by the truth table. 

#### Hint:

From the table, find the CSOP and use this to draw the K-map.

#### 1: Truth Tables for Boolean functions `P`, `Q`, `R` and `S`:

| `x` | `y` | `z` | `P` | `Q` | `R` | `S` |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| 0   | 0   | 0   | 1   | 1   | 0   | 0   |
| 0   | 0   | 1   | 0   | 0   | 1   | 1   |
| 0   | 1   | 0   | 0   | 1   | 1   | 0   |
| 0   | 1   | 1   | 1   | 1   | 0   | 1   |
| 1   | 0   | 0   | 0   | 1   | 1   | 1   |
| 1   | 0   | 1   | 0   | 0   | 1   | 1   |
| 1   | 1   | 0   | 1   | 1   | 0   | 0   |
| 1   | 1   | 1   | 1   | 0   | 1   | 0   |

##### `P = x'y'z' + x'yz + xyz' + xyz`

![kmap lab q3-A1 P](http://i.imgur.com/XQKL238.png)

##### `Q = x'y'z' + x'yz' + x'yz + xy'z' + xyz'`

![kmap lab q3-A1 Q](http://i.imgur.com/7c2alKm.png)

##### `R = x'y'z + x'yz' + xy'z' + xy'z + xyz`

![kmap lab q3-A1 R](http://i.imgur.com/3ryDSGJ.png)

##### `S = x'y'z + x'yz + xy'z' + xy'z`

![kmap lab q3-A1 S](http://i.imgur.com/r79Wfb4.png)

#### 2: Truth Tables for Boolean functions `L` and `M`:

| `w` | `x` | `y` | `z` | `L` | `M` |
|:---:|:---:|:---:|:---:|:---:|:---:|
| 0   | 0   | 0   | 0   | 0   | 1   |
| 0   | 0   | 0   | 1   | 1   | 0   |
| 0   | 0   | 1   | 0   | 0   | 0   |
| 0   | 0   | 1   | 1   | 0   | 1   |
| 0   | 1   | 0   | 0   | 1   | 0   |
| 0   | 1   | 0   | 1   | 0   | 1   |
| 0   | 1   | 1   | 0   | 0   | 1   |
| 0   | 1   | 1   | 1   | 1   | 0   |
| 1   | 0   | 0   | 0   | 1   | 0   |
| 1   | 0   | 0   | 1   | 0   | 1   |
| 1   | 0   | 1   | 0   | 1   | 0   |
| 1   | 0   | 1   | 1   | 0   | 0   |
| 1   | 1   | 0   | 0   | 0   | 1   |
| 1   | 1   | 0   | 1   | 0   | 1   |
| 1   | 1   | 1   | 0   | 0   | 1   |
| 1   | 1   | 1   | 1   | 1   | 0   |

##### `L = w'x'y'z + w'xy'z' + w'xyz + wx'y'z' + wx'yz' + wxyz`

![kmap lab q3-A2 L](http://i.imgur.com/3ks8D7l.png)

##### `M = w'x'y'z' + w'x'yz + w'xy'z + w'xyz' + wx'y'z + wxy'z' + wxy'z + wxyz'`

![kmap lab q3-A2 M](http://i.imgur.com/Zy7u97y.png)

### B: Construct a Truth Table for each of the Boolean expressions `L`, `M`, `P` and `Q` defined by the Karnaugh maps.

#### Hint:

Remember that each cell of the K-map corresponds to a row of the truth table.

#### `L(x,y,z)`

![kmap lab q3-B L](http://i.imgur.com/Pbf1m7l.png)

| `x` | `y` | `z` | `L` |
|:---:|:---:|:---:|:---:|
| 0   | 0   | 0   | 1   |
| 0   | 0   | 1   | 1   |
| 0   | 1   | 0   | 1   |
| 0   | 1   | 1   | 0   |
| 1   | 0   | 0   | 0   |
| 1   | 0   | 1   | 1   |
| 1   | 1   | 0   | 0   |
| 1   | 1   | 1   | 1   |

#### `M(x,y,z)`

![kmap lab q3-B M](http://i.imgur.com/K5Ki9mF.png)

| `x` | `y` | `z` | `M` |
|:---:|:---:|:---:|:---:|
| 0   | 0   | 0   | 0   |
| 0   | 0   | 1   | 0   |
| 0   | 1   | 0   | 0   |
| 0   | 1   | 1   | 1   |
| 1   | 0   | 0   | 1   |
| 1   | 0   | 1   | 1   |
| 1   | 1   | 0   | 1   |
| 1   | 1   | 1   | 0   |

#### `P(w,x,y,z)`

![kmap lab q3-B P](http://i.imgur.com/jBPNZis.png)

| `w` | `x` | `y` | `z` | `P` |
|:---:|:---:|:---:|:---:|:---:|
| 0   | 0   | 0   | 0   | 0   |
| 0   | 0   | 0   | 1   | 1   |
| 0   | 0   | 1   | 0   | 1   |
| 0   | 0   | 1   | 1   | 0   |
| 0   | 1   | 0   | 0   | 0   |
| 0   | 1   | 0   | 1   | 0   |
| 0   | 1   | 1   | 0   | 0   |
| 0   | 1   | 1   | 1   | 1   |
| 1   | 0   | 0   | 0   | 0   |
| 1   | 0   | 0   | 1   | 1   |
| 1   | 0   | 1   | 0   | 1   |
| 1   | 0   | 1   | 1   | 0   |
| 1   | 1   | 0   | 0   | 1   |
| 1   | 1   | 0   | 1   | 1   |
| 1   | 1   | 1   | 0   | 1   |
| 1   | 1   | 1   | 1   | 0   |

#### `Q(w,x,y,z)`

![kmap lab q3-B Q](http://i.imgur.com/rVhk51C.png)

| `w` | `x` | `y` | `z` | `Q` |
|:---:|:---:|:---:|:---:|:---:|
| 0   | 0   | 0   | 0   | 1   |
| 0   | 0   | 0   | 1   | 0   |
| 0   | 0   | 1   | 0   | 0   |
| 0   | 0   | 1   | 1   | 1   |
| 0   | 1   | 0   | 0   | 0   |
| 0   | 1   | 0   | 1   | 1   |
| 0   | 1   | 1   | 0   | 1   |
| 0   | 1   | 1   | 1   | 0   |
| 1   | 0   | 0   | 0   | 1   |
| 1   | 0   | 0   | 1   | 0   |
| 1   | 0   | 1   | 0   | 0   |
| 1   | 0   | 1   | 1   | 1   |
| 1   | 1   | 0   | 0   | 0   |
| 1   | 1   | 0   | 1   | 0   |
| 1   | 1   | 1   | 0   | 0   |
| 1   | 1   | 1   | 1   | 1   |

## 4: For each of the following Karnaugh maps, find the MinSOP

### Hint:

There is sometimes more than one answer.

![kmap lab q4 3var](http://i.imgur.com/dW8NoW2.png)

![kmap lab q4 4var](http://i.imgur.com/KVhCru5.png)

## 5: For each of the following Boolean expressions, simplify to SOP, draw a Karnaugh map and find the MinSOP.

### 1: `y'(x + x'z') + z'(y + x'y)`

![kmap lab q5-1](http://i.imgur.com/EY79SJa.png)

### 2: `(x + xy')z' + (x'y' + y)z`

![kmap lab q5-2](http://i.imgur.com/oemgwoV.png)

### 3: `(xz' + y'z')'`

![kmap lab q5-3](http://i.imgur.com/DnYdQBU.png)

### 4: `(y'z + xz)'`

![kmap lab q5-4](http://i.imgur.com/MGfs6by.png)

### 5: `(wz + y'z + w'x'z')'`

Working out:

```
(wz + y'z + w'x'z')'
(wz)'(y'z)'(w'x'z')'
(w' + z')(y + z')(w + x + z)
(w' + z')(yw + yx + yz + z'w + z'x + z'z)
(w' + z')(yw + yx + yz + z'w + z'x)
w'yw + w'yx + w'yz + w'z'w + w'z'x + z'yw + z'yx + z'yz + z'z'w + z'z'x
0 + w'xy + w'yz + 0 + w'xz' + wyz' + xyz' + 0 + wz' + xz'
w'xy + w'yz + w'xz' + wyz' + xyz' + wz' + xz' 
```

![kmap lab q5-5](http://i.imgur.com/9NK5W8O.png)

### 6: `(xz + yz + w'x)'`

Working out:

```
(xz + yz + w'x)'
(xz)'(yz)'(w'x)'
(x' + z')(y' + z')(w + x')
(x' + z')(y'w + y'x' + z'w + z'x')
x'y'w + x'y'x' + x'z'w + x'z'x' + z'y'w + z'y'x' + z'z'w + z'z'x'
wx'y' + x'y' + wx'z' + x'z' + wy'z' + x'y'z' + z'w
```

![kmap lab q5-6](http://i.imgur.com/9jjshjF.png)

## 6: For each of the following, draw a Karnaugh map for the Boolean expression defined by the truth table and then find an equivalent MinSOP.

### 1. Truth tables for `L`, `M` and `N`

| `x` | `y` | `z` | `L` | `M` | `N` |
|:---:|:---:|:---:|:---:|:---:|:---:|
| 0   | 0   | 0   | 0   | 0   | 1   |
| 0   | 0   | 1   | 0   | 1   | 1   |
| 0   | 1   | 0   | 1   | 0   | 1   |
| 0   | 1   | 1   | 1   | 1   | 0   |
| 1   | 0   | 0   | 1   | 1   | 1   |
| 1   | 0   | 1   | 1   | 1   | 0   |
| 1   | 1   | 0   | 1   | 1   | 1   |
| 1   | 1   | 1   | 0   | 0   | 1   |

![kmap lab q6-1](http://i.imgur.com/zXP8WPW.png)

### 2. Truth tables for `P`, `Q` and `R`

| `w` | `x` | `y` | `z` | `P` | `Q` | `R` |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| 0   | 0   | 0   | 0   | 1   | 1   | 1   |
| 0   | 0   | 0   | 1   | 0   | 0   | 1   |
| 0   | 0   | 1   | 0   | 0   | 1   | 0   |
| 0   | 0   | 1   | 1   | 1   | 0   | 0   |
| 0   | 1   | 0   | 0   | 1   | 1   | 1   |
| 0   | 1   | 0   | 1   | 1   | 0   | 1   |
| 0   | 1   | 1   | 0   | 1   | 1   | 0   |
| 0   | 1   | 1   | 1   | 1   | 1   | 1   |
| 1   | 0   | 0   | 0   | 0   | 0   | 0   |
| 1   | 0   | 0   | 1   | 0   | 1   | 0   |
| 1   | 0   | 1   | 0   | 1   | 0   | 1   |
| 1   | 0   | 1   | 1   | 1   | 0   | 1   |
| 1   | 1   | 0   | 0   | 0   | 1   | 0   |
| 1   | 1   | 0   | 1   | 0   | 0   | 1   |
| 1   | 1   | 1   | 0   | 1   | 1   | 1   |
| 1   | 1   | 1   | 1   | 1   | 0   | 1   |

![kmap lab q6-2](http://i.imgur.com/FC7lmbY.png)

## 7: In each case change the SOP to an expression involving `NAND` only

### 1: `x'y + xyz'`

```
x'y + xyz'
(x'y + xyz')
((x'y + xy'z)')'
________________
((x'y)'(xy'z)')'
```

### 2: `wxy' + x'yz' + wx'z'`

```
wxy' + x'yz' + wx'z'
(wxy' + x'yz' + wx'z')
((wxy' + x'yz' + wx'z')')'
__________________________
((wxy')'(x'yz')'(wx'z')')'
```

### 3: `w'x + wx'y' + xyz' + w'x'yz'`

```
w'x + wx'y' + xyz' + w'x'yz'
(w'x + wx'y' + xyz' + w'x'yz')
((w'x + wx'y' + xyz' + w'x'yz')')'
__________________________________
((w'x)'(wx'y')'(xyz')'(w'x'yz')')'
```

## 8: The following circuit has output `M`

![kmap lab q8-0](http://i.imgur.com/DuFZLaV.png)

### 1: Write down a Boolean expression for `M`

```
M = yz + z'(xy + x'y') + yz'
____________________________
yz + z'(xy + x'y') + yz'
yz + z'xy + z'x'y' + yz'
yz + xyz' + x'y'z' + yz'
```

### 2: Draw a Karnaugh map for `M`

![kmap lab q8-2](http://i.imgur.com/JoHmT0x.png)

### 3: Express `M` as a MinSOP

`M = y + x'z'`

### 4: Draw a minimal `AND`-`OR` circuit with output `M`

![kmap lab q8-4](http://i.imgur.com/2lGmKOp.png)

## 9: The following circuit has output `Q`

![kmap lab q9-0](http://i.imgur.com/kOV95Q5.png)

### 1: Write down a Boolean expression for `Q`

```
Q = w'xy' + x'yz + wx'y' + w'y'z + w'xy
```

### 2: Draw a Karnaugh map for `Q`

![kmap lab q9-2](http://i.imgur.com/0a9uz9L.png)

### 3: Express `Q` as a MinSOP

`P = w'x + zx' + wx'y'`

### 4: Draw a minimal `AND`-`OR` circuit with output `Q`

![kmap lab q9-4](http://i.imgur.com/majEors.png)