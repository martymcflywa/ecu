# Exercises Set 6

## Question 1

Suppose we define the function: `square: R → R, square(x) = x^2`

- Find the value of
	1. `square(13)`
		- 169
	2. `square(-8)`
		- 64
	3. `square(4.5)`
		- 20.25

## Question 2

Suppose we define the function: `g: R → R, g(x) = 3x + 5`

- Find the value of
	1. `g(5)`
		- 20
	2. `g(11)`
		- 38
	3. `g(-6)`
		- -13

## Question 3

Suppose we define the function: `len: {strings} → N, len(s) = length of s`

- Find the value of
	1. `len(guitar)`
		- 6
	2. `len(computer)`
		- 8
	3. `len(dsf%$#123)`
		- 9

## Question 4

A function `f: {students} → {units}` is defined by:

`f = {(John, CS123), (Kelly, CS451), (Matt, CS123), (Peter, MA227), (Bob, CS123), (Cathy, CS451), (Andrew, MA227)}`

### 1: Draw an arrow diagram to represent the function

![lab q4-1](http://i.imgur.com/C6PKH6T.png)

### 2: Draw a graph to represent the function

![lab q4-2](http://i.imgur.com/mCMJ65d.png)

## Question 5

Consider the function `f: {1, 2, 3, 4, 5, 6} → R, f(x) = x(x + 2)`

### 1: What is the value of `f(3)`

15

### 2: What is the value of `f(4)`

24

### 3: What is the range of `f`?

{3, 8, 15, 24, 35, 48}

## Question 6

Consider the function `len: {ant, bear, dog, zebra, elephant} → N, len(w) = length of word w`

### 1: What is the value of `len(bear)`

4

### 2: What is the value of `len(elephant)`

8

### 3: What is the range of `len`?

{3, 4, 5, 8}

## Question 7

Consider set `S = {1, 2, 3, ..., 12}` and the function `g: S → S` as defined by the table:

| `x`    | 0 | 1 | 2  | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 | 11 | 12 |
|-------:|:-:|:-:|:--:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:--:|:--:|:--:|
| `g(x)` | 0 | 1 | 11 | 3 | 4 | 8 | 7 | 6 | 5 | 9 | 10 | 2  | 12 |

### Find the values of `g(0)`, `g(2)`, `g(8)`

```
g(0) = 0
g(2) = 11
g(8) = 5
```

### For which values of `x` does `g(x) = x`?

```
0
1
3
4
9
10
12
```

### For which values of `x` does `g`<sup>-1</sup>`(x) = g(x)`?

**Review this**

All of values `x`

## Question 8

Which of the following represent functions? If not, which condition is not satisfied?

![lab q8](http://i.imgur.com/ahAJWMt.png)

## Question 9

Define sets `A = {a, b, c, d, e}` and `B = {p, q, r, s}`

For each of the following:

1. State whether the set of ordered pairs represents a function from `A` to `B`
2. If it does represent a function, state the range, and if not state which condition for a function is not satisfied

### A: `f = {(a, r), (d, p), (c, p), (b, q)}`

Not a function, fails condition 1.

### B: `g = {(b, p), (d, r), (a, q), (e, q), (c, p), (e, s)}`

Not a function, fails condition 2.

### C: `h = {(e, p), (c, q), (b, p), (a, s), (d, p)}`

Is a function. Range `{p, q, s}`

### D: `j = {(d, r), (a, p), (c, p), (e, p), (c, q)}`

Not a function, fails condition 1 and 2.

## Question 10

### A: If `f(x) = 5x + 7`

#### 1: Find `f(2)`

17

#### 2: Find `f(6)`

37

#### 3: Find `f(9)`

52

### B: If `g(x) = x(x + 1)(x + 2)`

#### 1: Find `g(3)`

60

#### 2: Find `g(4)`

120

#### 3: Find `g(10)`

1320

## Question 11

Does each of the following graphs represent functions? If not, state which condition is not satisfied.

![lab q11](http://i.imgur.com/oMNp3Js.png)

## Question 12

Each of the following arrow diagrams represents a function. For each, state whether the function is one-to-one or onto.

![lab q12](http://i.imgur.com/4bBXFED.png)

## Question 13

Define sets 

- `A = {p, q, r}`
- `B = {x, y}`
- `C = {a, b, c}`
- `D = {k, l, m, n}`

Each of the following sets of ordered pairs represents a function from `A` to `B`, `A` to `C`, or `A` to `D`. For each set, state whether the function is one-to-one or onto:

### A: `f = {(p, b), (q, a), (r, c)}`

Is one-to-one, is onto

### B: `g = {(p, y), (q, x), (r, y)}`

Not one-to-one, is onto

### C: `h = {(p, m), (q, k), (r, n)}`

Is one-to-one, not onto

### D: `j = {(p, c), (q, a), (r, c)}`

Not one-to-one, not onto

## Question 14

Consider the functions `f`, `g` and `h`, all defined on the set `{0, 1, 2, 3, ..., 10}`

| `x`    | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8  | 9 | 10 |
|-------:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:--:|:-:|:--:|
| `f(x)` | 0 | 4 | 8 | 1 | 5 | 9 | 2 | 6 | 10 | 3 | 7  |

| `x`    | 0 | 1 | 2 | 3  | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
|-------:|:-:|:-:|:-:|:--:|:-:|:-:|:-:|:-:|:-:|:-:|:--:|
| `g(x)` | 0 | 7 | 3 | 10 | 6 | 2 | 9 | 5 | 1 | 8 | 4  |

| `x`    | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9 | 10 |
|-------:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:--:|
| `h(x)` | 0 | 1 | 6 | 4 | 3 | 9 | 2 | 8 | 7 | 5 | 10 |

### 1: Write down the values of

1. `f(g(h(9)))`
	- 8
2. `f –1(h–1(3))`
	- 1
3. `h(g–1(f(5)))`
	- 2

### 2: Construct a table of values for `g(f(x))`

| `x`       | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7 | 8 | 9  | 10 |
|----------:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:--:|:--:|
| `g(f(x))` | 0 | 6 | 1 | 7 | 2 | 8 | 3 | 9 | 4 | 10 | 5  |

### 3: Construct a table for `f`<sup>-1</sup>`(x)` and draw its graph

| `x`      | 0 | 1 | 2 | 3 | 4 | 5 | 6 | 7  | 8 | 9 | 10 |
|---------:|:-:|:-:|:-:|:-:|:-:|:-:|:-:|:--:|:-:|:-:|:--:|
| `f^1(x)` | 0 | 3 | 6 | 9 | 1 | 4 | 7 | 10 | 2 | 5 | 8  |

![lab q14-3](http://i.imgur.com/KSlXgSi.png)

## Question 15

State whether each of the following functions is one-to-one or onto.

### A: `f: {1, 2, 3, 4, 5} → R, f(x) = x(12 – x)`

1,11 2,20 3,27 4,32 5,35

Is one-to-one, not onto

### B: `g: {2, 4, 6, 8} → {20, 32, 36}, g(x) = x(12 – x)`

2,20 4,32 6,36 8,32

Not one-to-one, is onto

### C: `h: {3, 4, 5} → {27, 32, 35}, h(x) = x(12 – x)`

3,27 4,32, 5,35

Is one-to-one, is onto

### D: `j: {5, 6, 7} → {35, 36, 37}, j(x) = x(12 – x)`

5,35 6,36 7,35

Not one-to-one, not onto

## Question 16

Suppose that:

- `f(x) = 2x + 5`
- `g(x) = √x + 4`
- `h(x) = x^2 - 1`
- `j(x) = (x - 2) / 3`

Find

### 1: `g(f(0))`
	
3

### 2: `f(g(5))`

11

### 3: `h(f(1))`

48

### 4: `j(g(60))`

2

### 5: `f(h(g(0)))`

11

### 6: `h(g(f(8)))`

24

## Question 17

Consider the function `f: {names on a class list} → {ID numbers on the class list}`

`f(x) = ID number of student with name x`

### 1: Will `f` be one-to-one?

Yes

### 2: Will `f` be onto?

Yes

### 3: Will `f` have an inverse?

Yes

### 4: If so, what will be the rule for `f`<sup>-1</sup>?

`f`<sup>-1</sup>`(x) = student name of ID number x`

## Question 18

Consider the function `g: {names on a class list) → {letters of the alphabet}`

`g(x) = initial of family name x`

### 1: Would you expect `g` to be one-to-one?

No

### 2: Would you expect `g` to be onto?

No

### 3: Would you expect `g` to have an inverse?

No

## Question 19

Find the inverse of each of the following functions

### 1: `f(x) = 5(x − 3)`

```
y = 5(x - 3)
y / 5 = x + 3
y / 5 + 3 = x
y = x / 5 + 3
```

`f`<sup>-1</sup>`(x) = x / 5 + 3`

### 2: `g(x) = 3x + 1`

```
y = 3x + 1
y - 1 = x / 3
(y - 1) / 3 = x
y = (x - 1) / 3
```

`g`<sup>-1</sup>`(x) = (x - 1) / 3`

### 3: `h = √x + 6`

```
y = √x + 6
y^2 = x - 6
y^2 - 6 = x
y = x^2 - 6
```

`h`<sup>-1</sup>`(x) = x^2 - 6`

### 4: `j(x) = (2x + 5) / 3`

```
y = (2x + 5) / 3
3y = (x - 5) / 2
3y - 5 = x / 2
(3y - 5) / 2 = x
y = (3x - 5) / 2
```

`j`<sup>-1</sup>`(x) = (3x - 5) / 2`

## Question 20

Let `h` be a function from set `S = {a, b, c, d, e, f}` to itself, defined by:

`h = {(a, c), (b, b), (c, f), (d, e), (e, a), (f, d)}`

### 1: Is `h` one-to-one?

Yes

### 2: Is `h` onto?

Yes

### 3: Does `h` have an inverse? If so, list the inverse as a set of ordered pairs

Yes

`h`<sup>-1</sup>`= {(a, e), (b, b), (c, a), (d, f), (e, d), (f, c)}`

## Question 21

Let `g` be a function from set `S = {a, b, c, d, e, f}` to itself, defined by:

`g = {(a, c), (b, a), (c, d), (d, a), (e, d), (f, e)}`

### 1: Is `g` one-to-one?

No

### 2: Is `g` onto?

No

### 3: Does `g` have an inverse? If so, list the inverse as a set of ordered pairs

No

## Question 22

Convert the 20 character string "Can Henry save $500?" into ASCII code, first as hex, then as 7-bit binary.

| Char | Hex | Binary   |
|:----:|:---:|:--------:|
| `C`  | 43  | 100 0011 |
| `a`  | 61  | 110 0001 |
| `n`  | 6E  | 110 1110 |
| `H`  | 48  | 100 1000 |
| `e`  | 65  | 110 0101 |
| `n`  | 6E  | 110 1110 |
| `r`  | 72  | 111 0010 |
| `y`  | 79  | 111 1001 |
| `s`  | 73  | 111 0011 |
| `a`  | 61  | 110 0001 |
| `v`  | 76  | 111 0110 |
| `e`  | 65  | 110 0101 |
| `$`  | 24  | 010 0100 |
| `5`  | 35  | 011 0101 |
| `0`  | 30  | 011 0000 |
| `0`  | 30  | 011 0000 |
| `?`  | 3F  | 011 1111 |

## Question 23

Convert the ASCII code in the first column from binary to hex, then use the ASCII table to translate the hex to alphanumeric characters.

| Binary   | Hex | Char      |
|:--------:|:---:|:---------:|
| 100 1000 | 48  | H         |
| 110 0101 | 65  | e         |
| 110 1100 | 6C  | l         |
| 110 1100 | 6C  | l         |
| 110 1111 | 6F  | o         |
| 010 0000 | 20  | `<space>` |
| 101 0111 | 57  | W         |
| 110 1111 | 6F  | o         |
| 111 0010 | 72  | r         |
| 110 1100 | 6C  | l         |
| 110 0100 | 64  | d         |
| 010 0001 | 21  | !         |

`Hello World!`

```
4 2 1 8 4 2 1
1 0 0 1 0 0 0 = 48
1 1 0 0 1 0 1 = 65
1 1 0 1 1 0 0 = 6C
1 1 0 1 1 1 1 = 6F
0 1 0 0 0 0 0 = 20
1 0 1 0 1 1 1 = 57
1 1 1 0 0 1 0 = 72
1 1 0 0 1 0 0 = 64
0 1 0 0 0 0 1 = 21
```

## Question 24

The ASCII codes for upper case letters A, B, C, ..., Z are 65, 66, 67, ..., 90.

Define `asc: {A, B, C, ..., Z} → {n | n∈ N and 65 ≤ n ≤ 90}`

`asc(x) = ASCII code of letter x`

### 1: Will `asc` be one-to-one?

Yes

### 2: Will `asc` be onto?

Yes

### 3: Will `asc` have an inverse?

Yes