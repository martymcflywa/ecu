# Genetic algorithms

## Crossover operations

### Two point crossover

```
PARENTS:
A = 2 3 5 6 1 4 8 7
B = 7 1 2 3 8 6 5 4
```

```
CROSSOVER POINTS:
A = 2 3 | 5 6 1 | 4 8 7
B = 7 1 | 2 3 8 | 6 5 4
```

```
OFFSPRING:
A' = 2 3 | 2 3 8 | 6 5 4
B' = 7 1 | 5 6 1 | 4 8 7
```

#### Problem for traveling salesman

- Traveling salesman must travel to every city once
- Offspring now includes duplicates
- Some cities are never traveled to
- Is an issue for any problem that requires
	- Uniqueness
	- Every combination of gene needs to appear in chromosome

### Partially mapped crossover (PMX)

- Resolves traveling salesman offspring two point crossover issue
- Select random substring from parents
	- Must match length and position
- Exchange substring in offspring
- Determine relationship map
	- Example
		- A' `7` &hArr; B' `4`
		- Multiple relationships may exist
			- See `1` &hArr; `6` &hArr; `3`
			- Since `6` appears in both child substrings
- Use relationship map to legalize offspring
	- Swap mapped genes that are outside the substring
		- Using multiple relationship
			- `1` is swapped with `3`
			- Uses `1` &hArr; `6` &hArr; `3` relationship
			- `6` is intermediary between `1` and `3`
- Removes duplicates in each offspring
- Ensures each possible gene appears in offspring chromosomes

```
RANDOM PARENT SUBSTRINGS:
A = 1 2 [3 4 5 6] 7
B = 5 4 [6 7 2 1] 3
```

```
OFFSPRING SUBSTRINGS EXCHANGED:
A' = 1 2 [6 7 2 1] 7
B' = 5 4 [3 4 5 6] 3
```

```
RELATIONSHIP MAP:
1 <=> 6 <=> 3
7 <=> 4
2 <=> 5
```

```
LEGALIZED OFFSPRING:

MAP: 1 <=> 6 <=> 3
A' = [1] 2 [6 7 2 1]  7
B' =  5  4 [3 4 5 6] [3]

SWAPPED:
A' = [3] 2 [6 7 2 1]  7
B' =  5  4 [3 4 5 6] [1]

MAP: 7 <=> 4
A' = 3  2  [6 7 2 1] [7]
B' = 5 [4] [3 4 5 6]  1

SWAPPED:
A' = 3  2  [6 7 2 1] [4]
B' = 5 [7] [3 4 5 6]  1

MAP: 2 <=> 5
A' =  3 [2] [6 7 2 1] 4
B' = [5] 7  [3 4 5 6] 1

SWAPPED:
A' =  3 [5] [6 7 2 1] 4
B' = [2] 7  [3 4 5 6] 1
```

```
PMX CROSSOVER RESULT:
A' = 3 5 6 7 2 1 4
B' = 2 7 3 4 5 6 1
// No duplicates, every possible gene is included in chromosome
```

## Mutation operations

### Inversion mutation

- Select random substring
- Invert substring

```
ORIGINAL:
2 3 4 5 6 1 7 9 8
```
```
SUBSTRING:
2 3 | 4 5 6 | 1 7 9 8
```
```
MUTATION RESULT:
2 3 | 6 4 5 | 1 7 9 8
```

### Displacement mutation

- Select random substring
- Insert at random displacement point outside substring

```
ORIGINAL:
9 4 2 6 3 8 7 1 5
```

```
SUBSTRING:
9 [4 2 6] 3 8 7 1 5
```

```
DISPLACEMENT POINT:
9 4 2 6 3 8 7 1 | 5
```

```
MUTATION RESULT:
9 3 8 7 1 [4 2 6] 5
```

### Shift mutation

- Similar to displacement but for single gene
- Select random gene
- Shift random gene left or right to random position

```
ORIGINAL:
9 4 2 6 3 8 7 1 5
```

```
RANDOM GENE:
9 4 2 [6] 3 8 7 1 5
```

```
RANDOM SHIFT POINT:
9 | 4 2 6 3 8 7 1 5
```

```
MUTATION RESULT:
9 [6] 4 2 3 8 7 1 5
```

### Exchange mutation

- Select two random genes
- Swap the genes

```
ORIGINAL:
5 6 8 2 3 7 9 1 4
```

```
RANDOM GENES:
5 [6] 8 2 3 7 9 [1] 4
```

```
MUTATION RESULT:
5 [1] 8 2 3 7 9 [6] 4
```

### Insertion mutation

- Select random gene
- Select random position
- Insert random gene at random position

```
ORIGINAL:
4 5 8 2 3 6 7 9 1
```

```
RANDOM GENE:
4 [5] 8 2 3 6 7 9 1
```

```
RANDOM POSITION:
4 5 8 2 3 6 7 9 | 1
```

```
MUTATION RESULT:
4 8 2 3 6 7 9 [5] 1
```
### Sample exam fitness function

- See Q2 part g

![fitness function](http://snag.gy/KY8mq.jpg)

- Where
	- L = left side of truck
	- R = right side of truck
	- W = weight of box
	- Closest to 0 is fittest
