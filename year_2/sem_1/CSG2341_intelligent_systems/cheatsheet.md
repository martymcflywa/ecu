# Fuzzy systems

## Sugeno

### Rule aggregation

#### Rules

- Rule 1
	- IF (heading angle IS front) AND (energy difference IS winning) THEN (turn is 0)
- Rule 2
	- IF (heading angle IS left front) AND (energy difference IS winning) THEN (turn is 90)

#### Energy difference

- Energy difference sets
	- Figure 5
	- Input = +3675.97j
	- &mu; = 1

![figure 5](http://snag.gy/x51Yi.jpg)

#### Heading angle

- Heading angle sets
	- Figure 6
	- Input = 0.31&deg;
	- Fires rule 1 and 2 simultaneously

![figure 6](http://snag.gy/n2Z9x.jpg)

- Input belongs to two sets
	- Front
		- &mu; = 1
	- leftFront
		- &mu; = 0.31
- Calculate weighted average of each &mu; value
	- Equation 4.1
	- Equation 4.2

![equation 4.1](http://snag.gy/dEiOm.jpg)

![equation 4.2](http://snag.gy/edYQM.jpg)

- Then consider &mu; value for energy difference
	- Energy difference
		- Winning
			- &mu; = 1
- Rule using conjunction
	- IF (set) AND (set) THEN ...
	- Intersection operation
		- MIN function

![equation 4.4](http://snag.gy/fdBJq.jpg)

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
- L = sum of weights on left side of truck
- R = sum of weights on right side of truck
- f(x) = abs(L - R)
- Closest to 0 = higher fitness

# Artificial neural networks

## Converting data

### Continuous

- Can be decimal
- Varies between
	- Min
	- Max

![equation 9.2](http://snag.gy/UUJEs.jpg)

##### Example

- Living area
	- Between 59 m<sup>2</sup> and 231 m<sup>2</sup>
		- Min = 50
		- Max = 250
	- Any value lower than min is mapped to min
	- Any value higher than max is mapped to max
- Converting 121 m<sup>2</sup>:

![continuous](http://snag.gy/M8t9a.jpg)

### Discrete

- Must be integer
- Varies between
	- Max
	- Min
- Assign equal space to each possible value on interval 0 to 1

![figure 9.23](http://snag.gy/pI1pr.jpg)

### Categorical

- Example
	- Gender
	- Marital status
- Use 1 of N coding
	- Each categorical value is handled as a separate input
- Marital status
	- Four inputs
		- Single
		- Divorced
		- Married
		- Widowed
	- Value either 0 or 1
	- Married person
		- `0010`

## Prevent overfitting

- Overfitting
	- When number of hidden neurons too big
	- Network memorizes all training examples
	- Prevents network from
		- Generalizing
		- Producing correct outputs when presented with data not used in training
- Avoiding overfitting
	- Training
		- Choose smallest number of hidden neurons that yield good generalization
		- Start training for each instance with small number of hidden neurons, incrementally increasing number of neurons
			- 2
			- 5
			- 10
			- 20
		- Compare training results
			- Graph performance of each instance to evaluate
				- If network can converge to solution
					- Eliminate instance where it cannot converge
				- Number of epochs required to converge to solution
					- These instances will be tested
	- Test
		- Present test data
			- Must be independent of training data
			- Must include noise
				- Distortion of input data
				- Add small random values chosen from normal distribution
		- Compare test results
			- Graph performance data of each instance to evaluate
				- Most efficient number of hidden neurons that can adapt to noise
					- Difference in recognition error must be high to justify selection of higher number of neurons

### Overtraining graph

![overtraining](https://upload.wikimedia.org/wikipedia/commons/thumb/1/1f/Overfitting_svg.svg/1220px-Overfitting_svg.svg.png)
