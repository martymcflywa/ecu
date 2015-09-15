# Genetic algorithms for scheduling

## Genetic algorithm design steps

- Step 1
	- Specify the problem
	- Define
		- Constraints
		- Optimum criteria
- Step 2
	- Represent the problem domain as a chromosome
- Step 3
	- Define a fitness function to evaluate the chromosome performance
- Step 4
	- Construct the genetic operators
- Step 5
	- Run the GA and tune its parameters

## Scheduling problems

- Good candidates for an evolutionary algorithm
	- High value
	- Complex
	- Difficult to approach analytically
	- Often NP-complete

### Step 1

>Specify the problem, define constraints and optimum criteria

- Problem constraints
	- Max loads expected during four intervals are (MW)
		- 80
		- 90
		- 65
		- 70
	- Maintenance of any unit
		- Starts at the beginning of an interval
		- Finishes at the end of the same or adjacent interval
		- Cannot be aborted or finished earlier than scheduled
	- Net reserve of power system must be
		- Greater or equal to zero at any interval
- Optimum criteria
	- Minimum of the net reserve at any maintenance period

#### Data for the scheduling problem

![data for the scheduling problem](http://snag.gy/z9iR2.jpg)

- See `ScheduleProblem.java`

### Step 2

>Represent the problem domain as a chromosome

![represent problem domain as a chromosome](http://snag.gy/91ShL.jpg)

### Step 3

>Define a fitness function to evaluate the chromosome performance

- Optimum criteria
	- Maximum of the net reserve at any maintenance period
- See `ScheduleEvaluator.java`

### Step 4

>Construct the genetic operators

- Examine `DiscreteEvolvable` class in IS

### Step 5

>Run the GA and tune its parameters

- Let's try it

## Another case study: Traveling salesperson problem (TSP)

- Imagine a salesman who
	- Has a number of cities to visit
	- Wants to visit each of them once in such an order that
		- His round trip is as short as possible
- An ordering of cities to visit is called a tour
- Many real scheduling problems turn out to be equivalent to the traveling salesperson problem (TSP)
	- Scheduling deliveries
	- Crew rostering

### Traveling salesperson problem (TSP) example

![tsp example](http://snag.gy/EYxGR.jpg)

### TSP with a GA

- Possible chromosome:
	- `2 3 5 6 1 4 8 7 `
	- Permutation of city numbers

### TSP operators

#### Mutation (2-opt)

![mutation 2-opt](http://snag.gy/lyqQm.jpg)

- What does this mean in terms of tours?

#### Crossover (PMX)

![crossover pmx](http://snag.gy/VfGCg.jpg)

- Why not use normal crossover?
- What does this mean in terms of tours?

### Run the GA

- See `PermutationEvolvable.java`
- Have a quick look at the rest of the TSP solution
