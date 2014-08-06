# Exercises Set 2

## 1.

- `P` denote a set of people
- `M` a set of movies
- `S(x, y)` means that person `x` has seen movie `y`

### A: 

#### 1 - 6: Translate each of these sentences into symbols:
#### 7 - 12: Translate each of the following propositions into simple English:

1. For each movie there is somebody who has not seen it
	- `∀y ∈ M, ∃x ∈ P, ~S(x, y)`
2. Nobody has seen any of the movies
	- `∀x ∈ P, ∀y ∈ M, ~S(x, y)`
3. There is some movie that at least one person has not seen
	- `∃y ∈ M, ∃x ∈ P, ~S(x, y)`
4. There is at least one movie that some person has seen
	- `∃y ∈ M, ∃x ∈ P, S(x, y)`
5. There is some person who has seen all the movies
	- `∃x ∈ P, ∀y ∈ M, S(x, y)`
6. Everybody has seen at least one movie
	- `∀x ∈ P, ∃y ∈ M, S(x, y)`
7. `∀x ∈ P, ∀y ∈ M, S(x, y)`
	- Everybody has seen all the movies
8. `∃x ∈ P, ∀y ∈ M, ~S(x, y)`
	- Some people have not seen all the movies **wrong**
	- There is some person who has not seen any of the movies **right**
9. `∀y ∈ M, ∃x ∈ P, S(x, y)`
	- For each movie there is somebody who has seen it
10. `∀x ∈ P, ∃y ∈ M, ~S(x, y)`
	- There is some person who has not seen at least one movie **wrong**
	- For each person there is some movie that they have not seen **right**
11. `∃y ∈ M, ∀x ∈ P, S(x, y)`
	- There is at least one movie that everybody has seen
12. `∃y ∈ M, ∀x ∈ P, ~S(x, y)`
	- There is at least one movie that everybody has not seen **wrong**
	- There is some movie that nobody has seen

<!--more-->

### B:

Suppose `Figures 1 - 4` on `pp. 2` represent possible scenarios, by showing which people have seen various movies. For each scenario from **A**, decide whether the proposition is true or false, based on the figures.

| Propositon                         | Fig 1 | Fig 2 | Fig 3 | Fig 4 |
|------------------------------------|:-----:|:-----:|:-----:|:-----:|
| 1. `∀y ∈ M, ∃x ∈ P, ~S(x, y)`  | 1     | 0     | 1     | 0     |
| 2. `∀x ∈ P, ∀y ∈ M, ~S(x, y)`  | 0     | 0     | 0     | 0     |
| 3. `∃y ∈ M, ∃x ∈ P, ~S(x, y)`  | 1     | 1     | 1     | 1     |
| 4. `∃y ∈ M, ∃x ∈ P, S(x, y)`   | 1     | 1     | 1     | 1     |
| 5. `∃x ∈ P, ∀y ∈ M, S(x, y)`   | 0     | 1     | 0     | 0     |
| 6. `∀x ∈ P, ∃y ∈ M, S(x, y)`   | 1     | 1     | 0     | 1     |
| 7. `∀x ∈ P, ∀y ∈ M, S(x, y)`   | 0     | 0     | 0     | 0     |
| 8. `∃x ∈ P, ∀y ∈ M, ~S(x, y)`  | 0     | 0     | 1     | 0     |
| 9. `∀y ∈ M, ∃x ∈ P, S(x, y)`   | 1     | 1     | 0     | 0     |
| 10. `∀x ∈ P, ∃y ∈ M, ~S(x, y)` | 1     | 0     | 1     | 1     |
| 11. `∃y ∈ M, ∀x ∈ P, S(x, y)`  | 0     | 1     | 0     | 1     |
| 12. `∃y ∈ M, ∀x ∈ P, ~S(x, y)` | 0     | 0     | 1     | 1     |

### C:

Interpret each of the propositions from **A** in terms of dots and blanks in the rows and/or columns of the figures.

1. At least one blank in each row
2. All blank
3. At least one blank somewhere
4. At least one dot somewhere
5. At least one column filled with dots
6. At least one dot in each column
7. All filled
8. At least one blank column
9. At least one dot in each row
10. At least one blank in each column
11. At least one row filled with dots
12. At least one blank row.

## 2:

- `P` is a set of people
- `S` is a set of songs
- `H(p, s)` means that person `p` has heard song `s`
	1. Match the corresponding sentence with its symbolic statement
	2. Negate symbolic statement
	3. Write negating sentence in English

1. For each song there is at least one person who has not heard it
	1. n. `∀ s ∈ S, ∃ p ∈ P, ~H(p, s)`
	2. c. `∃ s ∈ S, ∀ p ∈ P, H(p, s)`
	3. There is at least one song that everybody has heard
2. There is at least one person who has not heard any of the songs
	1. h. `∃ p ∈ P, ∀ s ∈ S, ~H(p, s)`
	2. b. `∀ p ∈ P, ∃ s ∈ S, H(p, s)`
	3. Each person has heard at least one song
3. Nobody has heard any of the songs
	1. g. `∀ s ∈ S, ∀ p ∈ P, ~H(p, s)`
	2. a. `∃ s ∈ S, ∃ p ∈ P, H(p, s)`
	3. There is at least one song that one person has heard
4. Everybody has heard all of the songs
	1. e. `∀ s ∈ S, ∀ p ∈ P, H(p, s)`
	2. j. `∃ s ∈ S, ∃ p ∈ P, ~H(p, s)`
	3. There is at least one song that at least one person has not heard
5. There is at least one person who has heard all the songs
	1. m. `∃ p ∈ P, ∀ s ∈ S, H(p, s)`
	2. f. `∀ p ∈ P, ∃ s ∈ S, ~H(p, s)`
	3. For each person there is at least one song they have not heard
6. There is at least one song that nobody has heard
	1. k. `∃ s ∈ S, ∀ p ∈ P, , ~H(p, s)`
	2. d. `∀ s ∈ S, ∃ p ∈ P, H(p, s)`
	3. For each song there is at least one person who has heard it

## 3:

- `U = {1, 2, 3, ..., 12}`
- `E = {numbers in U that are even}`
- `T = {numbers in U that are divisible by 3}`

List the elements of, and describe the following sets:

1. `E'`
	- `{1, 3, 5 ..., 11}`
	- `{odd numbers < 12}`
2. `E' ∩ T`
	- `{3, 9}`
	- `{odd numbers < 12 divisble by 3}`
3. `E ∩ T`
	- `{6, 12}`
	- `{even numbers ≤ 12 divisible by 3}`
	- `{divisible by 6 ≤ 12}`
4. `E ∪ T`
	- `{2, 3, 4, 6, 8, 9, 10, 12}`
	- `{number ≤ 12 divisible by 3 or even}`

## 4:

- `U = {animals}`
- `H = {animals with horns}`
- `M = {meat eaters}`
- `S = {striped animals}`

Describe the sets:

1. `S' ∩ M`
	- Non striped meat eaters
2. `S ∪ H`
	- Striped animals or animals with horns

## 5: 

- `U = {people in Hay St Mall}`
- `A = {Australian citizens}`
- `T = {tourists}`
- `F = {females}`

Describe the sets:

1. `A ∩ T`
	- Australian citizens that are tourists
2. `A' ∩ F`
	- Non Australian females
3. `F' ∩ T`
	- Male tourists
4. `F' ∩ (A ∪ T)`
	- Males who are Australian citizens or tourists

## 6:

Draw a Venn diagram to represent each of the following sets:

### A: `A ∩ B' ∩ C'`

![venn lab 1](http://i.imgur.com/7bQzcBK.png)

### B: `A' ∩ B' ∩ C`

![venn lab 2](http://i.imgur.com/O8hVeeX.png)

### C: `A' ∩ B ∩ C'`

![venn lab 3](http://i.imgur.com/M9oaIPU.png)

### D: `A ∩ B' ∩ C`

![venn lab 4](http://i.imgur.com/piAJhfu.png)

### E: `(A ∪ B) ∩ C`

![venn lab 5](http://i.imgur.com/83NMX6L.png)

### F: `(A ∩ B' ∩ C) ∪ (A ∩ B ∩ C')`

![venn lab 6](http://i.imgur.com/ut30yvv.png)

### G: `(A ∩ B) ∪ (B ∩ C)`

![venn lab 7](http://i.imgur.com/vILqFmv.png)

### H: `(A ∪ B ∪ C)'`

![venn lab 8](http://i.imgur.com/yHCLgu2.png)

## 7:

Illustrate the following laws of Boolean algebra by drawing a Venn diagram for each side of the equation:

### A: `A ∪ (B ∩ C) = (A ∪ B) ∩ (A ∪ C)`

#### `A ∪ (B ∩ C)`

![venn lab 9](http://i.imgur.com/nmEdtbx.png)

#### `(A ∪ B) ∩ (A ∪ C)`

![venn lab 10](http://i.imgur.com/1LlV6jK.png)

### B: `(A ∪ B)' = A' ∩ B'`

#### `(A ∪ B)'`

![venn lab 11](http://i.imgur.com/6YZhW2b.png)

#### `A' ∩ B'`

![venn lab 12](http://i.imgur.com/kc1yI5H.png)

## 8:

- `A = {1, 2, 3, 4}`
- `B = {0, 1, 2}`

### A: 

Find the following:

#### The power of set `A`:

```
P(A) = {∅, {1}, {2}, {3}, {4}, {1, 2}, {3, 4}, {1, 3}, {1, 4}, {2, 3}, {2, 4}, {1, 2, 3}, {1, 2, 4}, {1, 3, 4}, {2, 3, 4}, {1, 2, 3, 4}}
````

#### The power of set `B`:

```
P(B) = {∅, {0}, {1}, {2}, {0, 1}, {0, 2}, {1, 2}, {0, 1, 2}}
```

#### `B x B`

```
B x B = {(x, y) | x ∈ B and y ∈ B}
B x B = {(0, 0), (0, 1), (0, 2), (1, 0), (1, 1), (1, 2), (2, 0), (2, 1), (2, 2)}
```

### B:

Draw the graph of the cartesian product `A x B`

```
A x B = {(x, y) | x ∈ A and y ∈ B}
A x B = {(1, 0), (1, 1), (1, 2), (2, 0), (2, 1), (2, 2), (3, 0), (3, 1), (3, 2), (4, 0), (4, 1), (4, 2)}
```

![cartesian 1](http://i.imgur.com/x1k4zVI.png)

### C: 

Does any element of `A x B` belong to `B x A`?

```
A x B = {(1, 0), (1, 1), (1, 2), (2, 0), (2, 1), (2, 2), (3, 0), (3, 1), (3, 2), (4, 0), (4, 1), (4, 2)}
B x A = {(0, 1), (0, 2), (0, 3), (0, 4), (1, 1), (1, 2), (1, 3), (1, 4), (2, 1), (2, 2), (2, 3), (2, 4)}
```

Yes, `(1, 1), (2, 1), (2, 2)` belong to both `A x B` and `B x A`

## 9:

Suppose that in a group of 100 people, 40 drink tea, 65 drink coffee and 12 drink neither.

- Find out how many drink:
	1. Tea, but not coffee
	2. Coffee, but not tea
	3. Both tea and coffee

```
n(T ∩ C) = x
n(T) = 40 - x
n(T' ∩ C) = 65 - x
(40 - x) + (65 - x) + 12 = 100
x = 40 + 65 + 12 - 100
x = 17

n(T) = 23
n(T' ∩ C) = 48
```

- Answers:
	1. Tea, but not coffee
		- 23
	2. Coffee, but not tea
		- 48
	3. Both tea and coffee
		- 17

## 10:

Suppose that `A` and `B` are subsets of a universal set `U`. Given that:

```
n(U) = 140
n(A ∩ B') = 48
n(A' ∩ B) = 56
n(A ∩ B) = 22
```

- Find:
	1. `n(A' ∩ B)`
		- 56
	2. `n(A' ∩ B')`
		- 14
	3. `n(A)`
		- 70
	4. `n(B)`
		- 78
	5. `n(A ∪ B)`
		- 126

## 11:

Suppose that `P` and `Q` are subsets of a universal set `U`. Given that:

```
n(U) = 110
n(P ∩ Q') = 35
n(P ∩ Q) = 15
n(Q) = 57
```

- Find
	1. `n(P' ∩ Q')`
		- 18
	2. `n(P' ∩ Q)`
		- 42
	3. `n(P)`
		- 50
	4. `n((P' ∩ Q) ∪ (P ∩ Q'))`
		- 77
	5. `n((P ∩ Q)')`
		- 95

## 12:

Consider three subsets `A`, `B` and `C` of a universal set `U`. Given that:

```
n(U) = 50
n(A) = 24
n(B) = 19
n(C) = 27
n(A ∩ B) = 7
n(A ∩ C) = 11
n(B ∩ C) = 8
n(A' ∩ B' ∩ C') = 3
```

- Find:
	1. `n(A ∩ B ∩ C')`
		- 4
	2. `n((A ∩ B) ∪ (A ∩ C))`
		- 15
	3. `n(A' ∩ B' ∩ C)`
		- 11
	4. `n(A ∩ B' ∩ C')`
		- 9
	5. `n((A ∩ B) ∪ (A ∩ C) ∪ (B ∩ C))`
		- 20
	6. `n(A ∩ B ∩ C)`
		- 3
	7. The number of elements in any two of the three subsets, or in other words: `n((A ∩ B ∩ C') ∪ (A ∩ B' ∩ C) ∪ (A' ∩ B ∩ C))`
		- 17

## 13:

Consider three subsets `P`, `Q` and `R` of a universal set `U`. Given that:

```
n(U) = 150
n(P) = 72
n(Q) = 85
n(R) = 82
n(P ∩ Q) = 38
n(P ∩ R) = 40
n(Q ∩ R) = 45
n(P' ∩ Q' ∩ R') = 13
```

- Find:
	1. `n(P' ∩ Q ∩ R')`
		- 23
	2. `n((P ∩ Q) ∪ (Q ∩ R))`
		- 62
	3. `n(P ∩ Q' ∩ R)`
		- 19
	4. `n(P ∩ Q' ∩ R')`
		- 15
	5. `n((P ∩ Q) ∪ (P ∩ R) ∪ (Q ∩ R))`
		- 81
	6. `n(P ∩ Q ∩ R)`
		- 21
	7. The number of elements in only one of the three subsets, or in other words: `n((P ∩ Q' ∩ R') ∪ (P' ∩ Q ∩ R') ∪ (P' ∩ Q' ∩ R))`
		- 56

## 14:

- In a group of 75 students:
	- 31 are enrolled in Maths
	- 33 in Business Studies
	- 49 in Computer Science
	- 10 enrolled in Maths and Business Studies
	- 16 enrolled in Maths and Computer Science
	- 19 enrolled in Business Studies and Computer Science
	- 3 students do not study any of these units

- Find the number of students who are enrolled in:
	1. All three units
		- 4
	2. Only two of the three units
		- 33
	3. Only one of the three units
		- 35
	4. Maths only
		- 9
	5. Computer Science only
		- 18
	6. Maths and Computer Science but not Business Studies
		- 12
	7. Business Studies or Computer Studies
		- 63
	8. Maths or Computer Science, but not Business Studies
		- 39

## Need practice

Get more questions like 6, 12, 14