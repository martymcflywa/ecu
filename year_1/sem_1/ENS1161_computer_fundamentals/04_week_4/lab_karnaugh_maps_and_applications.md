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