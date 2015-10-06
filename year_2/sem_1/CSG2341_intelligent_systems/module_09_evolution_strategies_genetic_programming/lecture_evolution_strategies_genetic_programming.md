# Evolution strategies and genetic programming

- Evolution strategies
- Genetic programming
- Summary

# Evolution strategies

## Introduction

- Another approach to simulating natural evolution
- Proposed in Germany early 1960s
- Called evolution strategy
	- Designed to solve technical optimization problems
- 1963, two students of Technical University Berlin
	- Ingo Rechenberg
	- Hans-Paul Schefel
	- Working on search for optimal shapes of bodies in a flow
	- Decided to try random changes in parameters defining the shape
		- Following example of natural mutation
	- As a result, evolution strategy was born
- Evolution strategies developed as an alternative to engineer's intuition
- Unlike GAs, evolution strategies use only a mutation operator

## Basic evolution strategies

- Simplest form
	- Called **(1+1)-evolution strategy**
- One parent generates one offspring per generation
- By applying **normally distributed mutation**

### (1+1)-evolution implementation

- An evolution strategy reflects the nature of a chromosome
- A single gene may simultaneously affect several characteristics of the living organism
- On the other hand, a single characteristic of an individual may be determined by the simultaneous interactions of several genes
- The natural selection acts on a collection of genes
	- Not on a single gene in isonlation

#### Step 1

- Choose number of parameters N to represent the problem
- Determine feasible range for each parameter

![(1+1)-evolution step 1](http://snag.gy/WyWWZ.jpg)

#### Step 2

- Randomly select an initial value for each parameter from respective feasible range
- The set of these parameters will constitute the initial population of parent parameters

![(1+1)-evolution step 2](http://snag.gy/0Hpd8.jpg)

#### Step 3

- Calculate the solution associated with the parent parameters

![(1+1)-evolution step 3](http://snag.gy/e4bWY.jpg)

#### Step 4

- Create a new offspring parameter by
- Adding a normally distributed random variable a with mean zero and preselected deviation &delta; to each parent parameter

![(1+1)-evolution step 4](http://snag.gy/aJMMT.jpg)

#### Step 5

- Calculate the solution associated with the offspring parameters

![(1+1)-evolution step 5](http://snag.gy/ChttD.jpg)

#### Step 6

- Compare the solution associated with offspring parameters with the one associated with the parent parameters
- If the solution for the offspring is better, replace the parent population with the offspring population
- Else keep parent parameters

#### Step 7

- Go to Step 4
- Repeat process until satisfactory solution reached
	- Or specified number of generations considered

# Genetic programming

## Introduction

- One of the central problems in CS is how to make computers solve problems without being explicitly programmed to do so
- Genetic programming offers a solution through the evolution of computer programs by methods of natural selection
- Genetic programming is an extension of genetic algorithm
	- Goal of genetic programming is not just to evolve a bit string representation of some problem
	- But the computer code that solves the problem
- Genetic programming is a recent development in the area of evolutionary computation
	- Stimulated in 1990s by John Koza
- According to Koza, genetic programming searches the space of possible computer programs for a program that is highly fit for solving the problem at hand
- Any computer program is a sequence of operations (functions) applied to values (arguments)
	- But different programming languages may include different types of statements and operations
	- Have different syntactic restrictions
- Since genetic programming manipulates programs by applying genetic operators
	- A programming language should permit a computer program to be manipulated as data
	- And newly created data to be executed as a program
	- For these reasons **LISP** was chosen as the main language for genetic programming

## LISP

### LISP structure

- LISP has a highly symbol oriented structure
- Its basic data structures are **atoms** and **lists**
- An atom is the smallest indivisible element of the LISP syntax
	- `int 21`
	- `char x`
	- `string "This is a string"`
- A list is an object composed of atoms and/or other lists
- LISP lists are written as an ordered collection of items inside a pair of parenthesis

### LISP list

- For example, the list:

``` lisp
(-(*AB)C)
```

- Calls for the application of the subtraction function `(-)` to two arguments
	- The list `(*AB)`
	- The atom `C`
- First, LISP applied the multiplication function the the atoms `A` and `B`
- Once the list `(*AB)` is evaluated
	- LISP applies subtraction function `(-)` to the two arguments
	- Thus evaluates the entire list

### Graphical representation of LISP S-expressions

- Both atoms and lists are called symbolic expressions
	- **S-expressions**
- All data and all programs are S-expressions
	- This gives LISP the ability to operate on programs as if they were data
	- In other words, LISP programs can modify themselves or even write other LISP programs
	- This property makes it very attractive for genetic programming
- Any LISP S-expression can be depicted as a rooted point-labelled tree with ordered branches

#### LISP S-expression `(-(*AB)C)`

![LISP S-expression (-(*AB)C)](http://snag.gy/CE3Ow.jpg)

## How to apply genetic programming to a problem

### Preparatory steps

1. Determine set of terminals
2. Select set of primitive functions
3. Define fitness function
4. Decide on parameters for controlling the run
5. Choose the method of designating a result of the run

### Pythagorean theorem example

- Pythagorean theorem helps illustrate the preparatory steps
	- Demonstrates the potential of genetic programming
- Theorem:

>The hypotenuse c, of a right triangle with short sides a and b is given by:

![pythag theorem](http://snag.gy/2Ww59.jpg)

- The aim of genetic programming is to discover a program that matches this function
- To measure the performance of the as-yet-undiscovered computer program
	- We will use a number of different **fitness cases**
- The fitness cases for the Pythagorean theorem are represented by the samples of right triangles in the table below
- These fitness cases are chosen at random over a range of values of variables a and b

![fitness cases](http://snag.gy/nudIj.jpg)

#### Step 1

- Determine the set of terminals
- The terminals correspond to the inputs of the computer program to be discovered
- Our program takes two inputs
	- `a`
	- `b`

#### Step 2

- Select the set of primitive functions
- The functions can be presented by
	- Standard arithmetic operations
	- Standard programming operations
	- Standard mathematical functions
	- Logical functions
	- Domain specific functions
- Our program will use four standard arithmetic operations
	- `+`
	- `-`
	- `*`
	- `/`
	- One mathematical function
		- `sqrt`

#### Step 3

- Define the fitness function
- A fitness function evaluates how well a particular computer program can solve the problem
- For our problem, the fitness of the computer program can be measured by the error between
	- Result produced by the program
	- Correct result given by fitness case
- Typically the error is not measured over just one fitness case
	- But instead calculated as a sum of the absolute errors over a number of fitness cases
- The close the sum is to zero, the better the program

#### Step 4

- Decide on the parameters for controlling the run
- For controlling the run, genetic programming uses the same primary parameters used in GAs
- Include
	- Population size
	- Max number of generations to run

#### Step 5

- Choose the method for designating a result of the run
- It is common practice in genetic programming to designate the **best so far** generated program as the result of the run

#### Run

- Once five steps are complete a run can be made
	- The run starts with a random generation of an initial population of computer programs
	- Each program is composed of
		- Functions
			- `+`
			- `-`
			- `*`
			- `/`
			- `sqrt`
		- Terminals
			- `a`
			- `b`
- In the initial population all programs usually have poor fitness
	- But some individuals are more fit than others
	- A fitter program is more likely to survive by copying itself into the next generation

## Crossover in genetic programming

### Two parental S-expressions

![two parental S-expressions](http://snag.gy/xZn5R.jpg)

### Two offspring S-expressions

![two offspring S-expressions](http://snag.gy/niBtz.jpg)

## Mutation in genetic programming

- A mutation operator can randomly change any function or terminal in the LIS S-expression
	- A function can only be replaced by a function
	- A terminal can only be replaced by a terminal

### Original S-expressions

![original S-expressions](http://snag.gy/iuZW2.jpg)

### Mutated S-expressions

![mutated S-expressions](http://snag.gy/6VdYp.jpg)

## Genetic programming summary

- In summary, genetic programming creates computer programs by executing the following steps

### Step 1

- Assign
	- Max number of generations to run
	- Probability for
		- Cloning
		- Crossover
		- Mutation
- Probabilities sum must == 1

### Step 2

- Generate initial population of programs of size N
- By combining randomly selected functions/terminals

### Step 3

- Execute each program in the population
- Calculate fitness with an appropriate fitness function
- Designate the best so far individual as the result of the run

### Step 4

- Select a genetic operator to perform one of the following, based on selected probabilities
	- Cloning
	- Crossover
	- Mutation

### Step 5

- If cloning operator is chosen
	- Select one program from the current population
	- Copy it into new population
- If crossover operator is chosen
	- Select pair of programs from the current population
	- Create pair of offspring programs
	- Place them into new population
- If mutation operator is chosen
	- Select one program from the current population
	- Perform mutation
	- Place the mutant into new population

### Step 6

- Repeat Step 4 until size of new population of programs becomes equal to the size of initial population, N

### Step 7

- Replace parent population with offspring population

### Step 8

- Go to Step 3
- Repeat process until termination criteria satisfied

### Fitness history of best S-expression

![fitness history](http://snag.gy/M3LfC.jpg)

## Genetic programming vs. genetic algorithms

- Genetic programming applies same evolutionary approach
	- However genetic programming is not breeding bit strings that represent coded solutions
	- Breeds complete programs that solve a problem
- Fundamental difficulty of GAs is the problem representation
	- Fixed length coding
	- Poor representation limits the power of a GA
		- May lead to false solution
- Fixed length coding is artificial
	- Cannot provide dynamic variability in length
		- Causes considerable redundancy
		- Reduces efficiency of genetic search
	- Genetic programming uses high level building blocks of variable length
		- Size and complexity can change during breeding
- Genetic programming works well in a large number of different cases
	- Has many potential applications
