# Exercises Set 5

## Question 1

- `P` is a set of people, and `F` is a set of foodstuffs:
	- `P = {Ann, Bev, Clive, Don}`
	- `F = {Chips, Hamburgers, Meat pies, Spring rolls}`
- `L` is a relation between `P` and `F`, which may be translated as *likes*, defined by the following subset of the cartesian product `P × F`:

```
L = {(Ann, Chips), (Ann, Hamburgers), (Ann, Spring rolls), (Bev, Chips), (Bev, Meat pies), (Clive, Chips), (Clive, Hamburgers), (Clive, Meat pies), (Clive, Spring rolls), (Don, Chips), (Don, Hamburgers)}
```

### 1: Draw a graph of the relation `L`

![lab q1-1](http://i.imgur.com/3tA9z42.png)

### 2: Name the person described by `∃p ∈ P, ∀f ∈ F, p L f`

Charlie.

### 3: Name the foodstuff described by `∃f ∈ F, ∀p ∈ P, p L f`

Chips.

### 4: State the number of elements in the set `{p ∈ P | ~(p L hamburgers)}`

1, Bev.

## Question 2

- `S` is a set of students
	- `S = {Elle, Fred, Gary, Hilary}`
- `P` is a set of application packages
	- `P = {Browser, Graphics editor, Spreadsheet, Word processor}`
- `U` is a relation between `S` and `P`, which may be translated as uses, and defined by the following subset of the cartesian product `S × P`:

```
U = {(Elle, Browser), (Elle, Spreadsheet), (Fred, Graphics editor), (Hilary, Browser), (Hilary, Graphics editor), (Hilary, Spreadsheet), (Hilary, Word processor)}
```

### 1: Draw a graph of the relation of `U`

![lab q2-1](http://i.imgur.com/ereIXEB.png)

### 2: Name the student described by `∃s ∈ S, ∀p ∈ P, ~(s U p)`

Gary.

### 3: Is the following statement true or false? `∀p ∈ P, ∃s ∈ S, s U p`

True.

### 4: State the number of elements in the set `{s ∈ S | ~(s U b)}`

2.

## Question 3

- `A = {a, b, c}`
- `B = {x, y}`

### A) Let `R` be the relation defined by `R = {(a, x), (b, x), (b, y), (c, y)}`

#### 1: Draw the graph of `R`

![lab q3-a1](http://i.imgur.com/KxRJGHi.png)

#### 2: Draw an arrow diagram for `R`

![lab q3-a2](http://i.imgur.com/egGC75o.png)

### B) Let `S` be the relation represented by the graph below:

![lab q3-b0](http://i.imgur.com/RqNdsnN.png)

#### 1: Write `S` as a set of ordered pairs

```
S = {(a, y), (b, y), (c, x), (c, y)}
```

#### 2: Draw an arrow diagram for `S`

![lab q3-b2](http://i.imgur.com/cKU5G8c.png)

### C) Let `T` be the relation represented by the graph below:

![lab q3-c0](http://i.imgur.com/lrJccnx.png)

#### 1: Write `T` as a set of ordered pairs

```
T = {(a, x), (a, y), (c, x)}
```

#### 2: Draw the graph of `T`

![lab q3-c2](http://i.imgur.com/Qp6Vw1Z.png)

#### 3: Express `T` using a matrix

![lab q3-c3](http://i.imgur.com/efRpDoO.png)

## Question 4

For the relation "is less than" defined on the set `{1, 2, 3, 4}`

### 1: Express the relation as a set of ordered pairs

```
{(1, 2), (1, 3), (1, 4), (2, 3), (2, 4), (3, 4)}
```

### 2: Draw the graph

![lab q4-2](http://i.imgur.com/VopzuNR.png)

### 3: Drawn an arrow diagram

![lab q4-3](http://i.imgur.com/4kXTytO.png)

## Question 5

For the relation "is a proper factor of" defined on the set `{2, 4, 6, 8, 10}`

`a` is a proper factor of `b` means that `a` is a factor of `b` and also `a < b`

### 1: Express the relations as a set of ordered pairs

```
{(2, 4), (2, 6), (2, 8), (2, 10), (4, 8)}
```

### 2: Draw the graph

![lab q5-2](http://i.imgur.com/0u8cXTv.png)

### 3: Draw an arrow diagram

![lab q5-3](http://i.imgur.com/8KpRTVd.png)

## Question 6

For the relation "is greater than or equal to" defined on the set `{1, 2, 3, 4}`

### 1: Express the relations as a set of ordered pairs

```
{(1, 1), (2, 1), (2, 2), (3, 1), (3, 2), (3, 3), (4, 1), (4, 2), (4, 3), (4, 4)}
```

### 2: Draw the graph

![lab q6-2](http://i.imgur.com/PYaIF0L.png)

### 3: Draw an arrow diagram

![lab q6-3](http://i.imgur.com/6G4X6C8.png)

## Question 7

- `A = {a, b, c, d}`
- `B = {e, f, g}`
- `C = {h, i, j, k}`
- `P` is relation between `A` and `B`
	- `P = {(a, e), (b, e), (b, g), (c, e), (d, f)}`
- `Q` is relation between `B` and `C`
	- `Q = {(e, h), (e, k), (f, i), (f, k), (g, h)}`

Draw arrow diagrams to represent `P` and `Q` and the composition `P ○ Q`. Express `P ○ Q` as a set of ordered pairs.

![lab q7](http://i.imgur.com/VRCdk2J.png)

```
P ○ Q = {(a, h), (a, k), (b, h), (b, k), (c, h), (c, k), (d, i), (d, k)}
```

## Question 8

- `A = {a, b, c}`
- `B = {d, e, f, g}`
- `C = {h, i, j}`
- `R` is relation between `A` and `B`
	- `R = {(a, e), (b, d), (c, g)}`
- `S` is relation between `B` and `C`
	- `S = {(d, h), (d, j), (e, h), (f, i), (g, i), (g, j)}`

Draw arrow diagrams to represent `R` and `S` and the composition `R ○ S`. Express `R ○ S` as a set of ordered pairs.

![lab q8](http://i.imgur.com/xXnuhYN.png)

```
R ○ S = {(a, h), (b, h), (b, j), (c, i), (c, j)}
```

## Question 9

- `L = {p, q, r}`
- `M = {s, t, u}`
- `N = {v, w, x, y, z}`
- `H` is relation between `L` and `M`
	- `p H u`
	- `q H s`
	- `q H t`
	- `r H u`
- `K` is relation between `M` and `N`
	- `s K w`
	- `s K x`
	- `t K v`
	- `t K y`
	- `u K x`
	- `u K z`

Draw arrow diagrams and represent `H` and `K` and the composition of `H ○ K`. Express `H ○ K` as a set of ordered pairs.

![lab q9](http://i.imgur.com/hAKLUds.png)

```
H ○ K = {(p, x), (p, z), (q, v), (q, w), (q, x), (q, y), (r, x), (r, z)}
```

## Question 10

**Repeat of Question 8**

- `A = {a, b, c}`
- `B = {d, e, f, g}`
- `C = {h, i, j}`
- `R` is the relation between `A` and `B`
	- `R = {(a, e), (b, d), (c, g)}`
- `S` is the relation between `B` and `C`
	- `S = {(d, h), (d, j), (e, h), (f, i), (g, i), (g, j)}`

![lab q10](http://i.imgur.com/xXnuhYN.png)

```
R ○ S = {(a, h), (b, h), (b, j), (c, i), (c, j)}
```

## Question 11

- `A = {a, b, c}`
- `B = {d, e}`
- `C = {f, g, h}`
- `D = {i, j, k}`
- `R` is relationship between `A` and `B`
	- `R = {(a, d), (b, d), (b, e), (c, e)}`
- `S` is relationship between `B` and `C`
	- `S = {(d, g), (d, h), (e, f)}`
- `T` is relationship between `C` and `D`
	- `T = {(f, j), (g, i), (g, k), (h, j), (h, k)}`

Draw arrow diagrams to represent `R`, `S` and `T`, and the composition `(R ○ S) ○ T`. Express `(R ○ S) ○ T` as a set of ordered pairs.

![lab q11](http://i.imgur.com/2b5YiHx.png)

```
(R ○ S) ○ T = {(a, i), (a, j), (a, k), (b, i), (b, j), (b, k), (c, j)}
```

## Question 12

- `A = {a, b, c, d}`
- `B = {e, f, g}`
- `R` is the relationship between `A` and `B`
	- `a R f`
	- `b R f`
	- `c R e`
	- `c R g`
	- `d R g`

Draw an arrow diagram for `R`<sup>-1</sup> and express `R`<sup>-1</sup> as a set of ordered pairs.

![lab q12](http://i.imgur.com/qpEdNHq.png)

```
R^-1 = {(e, c), (f, a), (f, b), (g, c), (g, d)}
```

## Question 13

- `A = {a, b, c}`
- `B = {d, e, f, g}`
- `C = {h, i}`
- `R` is the relationship between `A` and `B`
	- `a R e`
	- `a R f`
	- `b R d`
	- `c R e`
	- `c R g`
- `S` is the relationship between `B` and `C`
	- `d S h`
	- `e S i`
	- `g S h`

### 1: Draw arrow diagrams for `R`, `S` and `R ○ S`

![lab q13-1](http://i.imgur.com/2wtkiZC.png)

### 2: Draw arrow diagrams for `S`<sup>-1</sup>, `R`<sup>-1</sup> and `S`<sup>-1</sup> `○ R`<sup>-1</sup>

![lab q13-2](http://i.imgur.com/aLzRBlu.png)

### 3: Express `R ○ S`, `(R ○ S)`<sup>-1</sup> and `S`<sup>-1</sup> `○ R`<sup>-1</sup> as ordered pairs

And verify that `(R ○ S)`<sup>-1</sup> is equal to `S`<sup>-1</sup> `○ R`<sup>-1</sup>.

```
R ○ S = {(a, i), (b, h), (c, h), (c, i)}
(R ○ S)^-1 = {(i, a), (h, b), (h, c), (i, c)} // reversing R ○ S
S^-1 ○ R^-1 = {(h, b), (h, c), (i, a), (i, c)}
```

## Question 14

![lab q14-0](http://i.imgur.com/NxYx2h2.png)

### 1: Find the logical product of `A` and `B`

![lab q14-1](http://i.imgur.com/YNFw86Q.png)

### 2: Find the logical product of `B` and `C`

![lab q14-2](http://i.imgur.com/W0z8ZBm.png)

### 3: Find the logical product of `ABC`

- Find `A(BC)`
- Then `(AB)C`

![lab q14-3](http://i.imgur.com/abt5z1R.png)

## Question 15

![lab q15-0](http://i.imgur.com/BfYvGmC.png)

### 1: Find the logical product of `L` and `M`

![lab q15-1](http://i.imgur.com/5gGvMlo.png)

### 2: Find the logical product of `M` and `N`

![lab q15-2](http://i.imgur.com/hAKlSgQ.png)

### 3: Find the logical product `LMN`

- Find `L(MN)`
- Then `(LM)N`

![lab q15-3](http://i.imgur.com/2IZcZ5O.png)

## Question 16

- `A = {a, b, c, d}`
- `B = {e, f, g}`
- `R`, `S`, `P` and `Q` are relations between `A` and `B`

### 1: Find the matrix `M(R)` for `R`

```
R = {(a, f), (a, g), (b, e), (c, e), (d, f), (d, g)}
```

![lab q16-1](http://i.imgur.com/shwZS29.png)

### 2: Find the matrix `M(S)` for `S`

```
S = {(b,f), (b,g), (c, e), (d, e), (d, g)}
```

![lab q16-2](http://i.imgur.com/T4DLaGe.png)

### 3: Express the set of ordered pairs in relation to `P` represented by the matrix

![lab q16-3](http://i.imgur.com/nWJoc0e.png)

```
P = {(a, e), (a, g), (b, e), (b, g), (d, e), (d, f), (d, g)}
```

### 4: Express the set of ordered pairs in relation to `Q` represented by the matrix

![lab q16-4](http://i.imgur.com/vHO7YDt.png)

```
Q = {(a, f), (a, g), (b, e), (b, f), (c, e), (d, e), (d, g)}
```

## Question 17

- `C = {a, b, c}`
- `D = {d, e, f, g, h}`
- `P`, `Q`, `S` and `T` are relations between `C` and `D`

### 1: Find the matrix `M(P)` for `P`

```
P = {(a, d), (a, g), (b, e), (b, f), (c, f), (c, h)}
```

![lab q17-1]()

### 2: Find the matrix `M(Q)` for `Q`

```
Q = {(a, g), (b, d), (b, f), (b, h), (c, e), (c, g)}
```

![lab q17-2]()

### 3: Express the set of ordered pairs in relation to `S` represented by the matrix

![lab q17-3]()

### 4: Express the set of ordered pairs in relation to `T` represented by the matrix

![lab q17-4]()