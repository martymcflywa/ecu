# Genetic computation and genetic algorithms

- Introduction
- Simulation of natural evolution
- Genetic algorithms
- Case study
	- Maintenance scheduling with genetic algorithms
- Summary

# Introduction

- Intelligence can be defined as the capability of a system to adapt its behavior to every changing environment
	- According to Alan Turing
		- The form or appearance of a system is irrelevant to its intelligence
- Evolutionary computation simulates evolution on a computer
	- The result of such a simulation is a series of optimization algorithms
		- Usually based on a simple set of rules
	- Optimization iteratively improves the quality of solutions
		- Until an optimal, or feasible solution is found
- The behavior of an individual organism is an inductive inference about some yet unknown aspects of its environment
	- If, over successive generations, the organism survives
		- We can say that this organism is capable of learning to predict changes in its environment
- The evolutionary approach is based on computational models of natural selection and genetics
	- We call them **evolutionary computation**
		- An umbrella term that combines
			- **Genetic algorithms**
			- **Evolution strategies**
			- **Genetic programming**

## Simulation of natural evolution

- 1 July, 1858, Charles Darwin presented his theory of evolution before the Linnean Society of London
	- This marks the beginning of a revolution in biology
- Three concepts now represent the neo-Darwinian paradigm
	- Darwin's classical **theory of evolution**
	- Weismann's **theory of natural selection**
	- Mendel's concept of **genetics**
- **Neo-Darwinism** is based on processes of
	- Reproduction
		- Essential property of life
	- Mutation
		- Guaranteed in any living organism that reproduces itself in a continuously changing environment
	- Competition
		- Takes place in natural world where expanding populations of different species are limited by a finite space
	- Selection
		- Takes place in natural world where expanding populations of different species are limited by a finite space
- **Evolutionary fitness**
	- Process leading to the maintenance of a population's ability to survive and reproduce itself in a specific environment
	- Can also be viewed as a measure of the organism's ability to anticipate changes in its environment
	- The fitness, or quantitative measure of the ability to predict environmental changes and respond adequately
		- Considered as the quality that is optimized in natural life

## How is a population with increasing fitness generated?

- Consider population of rabbits
	- Some rabbits are faster
		- Have superior fitness
		- Have greater chance of avoiding foxes
		- Surviving and breeding
- If two parents have superior fitness
	- Good chance that combination of genes will produce offspring with higher fitness
	- Over time, population of rabbits become faster
	- Meet environmental challenges in face of foxes

## Simulation of natural evolution

- All methods of evolutionary computation simulate natural evolution by
	- Creating a population of individuals
	- Evaluating their fitness
	- Generating a new population through genetic operations
	- Repeat process a number of times
- **Genetic algorithms**
	- Most of the other evolutionary algorithms are variations of genetic algorithms

# Genetic algorithms

- Early 1970s, John Holland introduced concept of genetic algorithms
- Aim was to make computers do what nature does
	- Holland was concerned with algorithms that manipulate strings of binary digits
- Each artificial **chromosomes** consists of a number of **genes**
	- Each gene is represented by a zero, or one

![binary gene](http://snag.gy/utQR9.jpg)

- Nature has ability to adapt and learn without instruction
	- Nature finds good chromosomes blindly
	- GAs do the same
	- Two mechanisms link a GA to the problem it is solving
		- **Encoding**
		- **Evaluaion**
- GA uses measure of fitness of individual chromosomes to reproduce
	- As reproduction takes place
		- Crossover operator exchanges parts of two single chromosomes
		- Mutation operator changes the gene value in randomly chosen location of chromosome

## Basic genetic algorithms

### Step 1

- Represent problem variable domain as a chromosome of fixed length
- Choose
	- Size of chromosome population N
	- Crossover probability p<sub>c</sub>
	- Mutation probability p<sub>m</sub>

### Step 2

- Define fitness function to measure performance, or fitness of an individual chromosome in problem domain
- Establishes basis for selecting chromosomes that will be mated during reproduction

### Step 3

- Randomly generate an initial population of chromosomes of size:

>N: x<sub>1</sub>, x<sub>2</sub>, x<sub>3</sub>, ..., x<sub>N</sub>

### Step 4

- Calculate fitness of each individual chromosome:

>f(x<sub>1</sub>), f(x<sub>2</sub>), f(x<sub>3</sub>), ..., f(x<sub>N</sub>)

### Step 5

- Select a pair of chromosomes for mating from current population
- Parent chromosomes are selected with a probability related to their fitness

### Step 6

- Create a pair of offspring chromosomes by applying genetic operators
	- **Crossover**
	- **Mutation**

### Step 7

- Place the created offspring chromosomes in new population

### Step 8

- Repeat **Step 5** until size of new chromosome population becomes equal to size of initial population N

### Step 9

- Replace parent chromosome population with offspring population

### Step 10

- Go to **Step 4** and repeat process until the termination criteria is satisfied

## Generations

- GA represents an iterative process
	- Each iteration is called a **generation**
	- Typical number of generations for simple GA can be 50 to >500
	- Entire set of generations is called a **run**
- Because GA use a stochastic search method,
	- Fitness of a population may remain stable for a number of generations before a superior chromosome appears
- Common practice is to terminate a GA after a specified number of generations
	- Then examine the best chromosomes in population
	- If no satisfactory solution is found
		- GA restarted

## Genetic algorithms case study

- Find the max values of the function (15x - x<sup>2</sup>)
- Where x varies between 0 and 15
- Assume that x only accepts integers
- Chromosomes can be built with only four genes:

![ga case study](http://snag.gy/bJp2o.jpg)

- Size of chromosome population N = 6
- Crossover probability p<sub>c</sub> = 0.7
- Mutation probability p<sub>m</sub> = 0.001
- Fitness function is:

>f(x) = 15x - x<sup>2</sup>

### Fitness function and chromosome locations

![fitness function and chromosome locations](http://snag.gy/9xuB7.jpg)

- In natural selection, only fittest species can
	- Survive
	- Breed
	- Pass genes to next generation
- GAs use similar approach
	- But unlike nature
		- Size of chromosome population remains unchanged from one generation to next
- Last column in table above shows the ratio of the individual chromosome's fitness to the population's total fitness
	- This ratio determines the chromosome's chance of being selected for mating
	- Chromosome's average fitness improves from one generation to next

## Roulette wheel selection

- Most commonly used chromosome selection techniques is the roulette wheel selection

![roulette wheel selection](http://snag.gy/FHreI.jpg)

## Crossover operator

- In our example, we have an initial population of 6 chromosomes
	- To establish the same population in next generation
		- Roulette wheel would be spun 6 times
- Once a pair of parent chromosomes is selected
	- The crossover operator is applied
- First, the crossover operator randomly chooses a crossover point where two parent chromosomes **break**
	- And then exchanges the chromosome parts after that point
	- As a result, two new offspring are created
- If a pair of chromosomes does not cross over
	- Then the chromosome cloning takes place
	- The offspring are created as exact copies of each parent

![crossover operator](http://snag.gy/6avwZ.jpg)

## Mutation operator

- Mutation represents a change in the gene
- Is a background operator
	- Provides a guarantee that the search algorithm is not trapped on a local continuum
- Mutation operator flips a randomly selected gene in a chromosome
- Mutation probability is quite small in nature
	- Is kept low for GAs
	- Typically in range between 0.001 and 0.01

![mutation operator](http://snag.gy/DPtiu.jpg)

## Genetic algorithm cycle

![genetic algorithm cycle](http://snag.gy/vbPJD.jpg)

## Case study: Maximum peak function

- Suppose it is desired to find the maximum of the "peak" functions of two variables

>f(x, y) = (1 - x)<sup>2</sup>e<sup>-x<sup>2</sup>-(y+1)<sup>2</sup></sup> - (x - x<sup>3</sup> - y<sup>3</sup>)e<sup>-x<sup>2</sup>-y<sup>2</sup></sup>

- Where x and y vary between -3 and 3

### Encode to chromosome

- The first step is to represent the problem variables as a chromosome
	- x and y as a concatenated binary string:

![x,y binary string](http://snag.gy/oKTDO.jpg)

- We also choose the size of the chromosome population
	- ie. 6
	- Randomly generate an initial population
- Calculate fitness of each chromosome
	- Done in 2 stages
- Chromosome
	- 16 bits
	- Partitioned into two 8 bit strings

![x2 8bit strings](http://snag.gy/36noT.jpg)

- These strings are converted from base 2 to base 10

![base2 to base10](http://snag.gy/ac1SO.jpg)

- Now the range of integers that can be handled by 8bits is mapped to actual range of parameters x and y
	- 8-bit range
		- 0 to (2<sup>8</sup> - 1)
	- x,y range
		- -3 to 3

![map range](http://snag.gy/wCjOk.jpg)

### Decode values

- To obtain the actual values of x and y
	- Multiply decimal values by 0.0235924 and subtract 3

![obtain actual values of x and y](http://snag.gy/kPNJQ.jpg)

### Calculate fitness

- Using decoded values of x and y as inputs in the mathematical function
	- GA calculates the fitness of each chromosome
- To find maximum of peak function, use
	- Crossover with probability = 0.7
	- Mutation with probability = 0.001
	- Generations = 100 of 6 chromosomes

### Graph output

#### Chromosome locations on the surface of the peak function

##### Initial population

![initial population](http://snag.gy/In6Ux.jpg)

##### First generation

![first gen](http://snag.gy/tIfTr.jpg)

##### Local maximum

![local maximum](http://snag.gy/IKUdd.jpg)

##### Global maximum

![global maximum](http://snag.gy/Ecf4L.jpg)

#### Performance graphs for 100 generations of 6 chromosomes

##### Local maximum

![local maximum](http://snag.gy/lFHTj.jpg)

##### Global maximum

![global maximum](http://snag.gy/k5tyJ.jpg)

#### Performance grpahs for 20 generations of 60 chromosomes

![20 gen 60 chromo](http://snag.gy/hs04p.jpg)

# Case study: Maintenance scheduling

- Maintenance scheduling problems are usually solved using a combination of search techniques and heuristics
- These problems are complex and difficult to solve
- They are NP-complete and cannot be solved by combinatorial search techniques
- Scheduling involves competition for limited resources
	- Is complicated by a number of badly formalised constraints

## Steps in GA development

1. Specify
	- Problem
	- Constraints
	- Optimum criteria
2. Represent problem domain as chromosome
3. Define fitness function to evaluate chromosome performance
4. Construct genetic operators
5. Run GA, tune parameters

## Scheduling of 7 units in 4 equal intervals

### Problem constraints

- Max loads expected during four intervals
	- 80MW
	- 90MW
	- 65MW
	- 70MW
- Maintenance of any unit
	- Starts at beginning of an interval
	- Finishes at end of the same or adjacent interval
- Maintenance cannot be aborted or finished earlier than scheduled
- Net reserve of the power system must be greater or equal to zero at any interval
- Optimum criterion
	- Maximum of the net reserve at any maintenance period

### Unit data and maintenance requirements

![unit data and maintenance requirements](http://snag.gy/IegBW.jpg)

## Gene representation

- There are 4 time intervals in which a unit may be undergoing maintenance
	- 1 = is undergoing maintenance
	- 0 = not undergoing maintenance
	- Hence the gene for a given unit is a bit string of length 4
- Due to constraints
	- Not all genes are valid
- Combined bit string of all units forms the chromosome undergoing evolution
- Suppose we know roughly what the power usage will be across these intervals
- We aim to maintain the units while staying as far as possible away from overloading the station at any time

### Unit gene pools

![unit gene pools](http://snag.gy/VhV3Y.jpg)

### Chromosome for the scheduling problem

![chromosome for the scheduling problem](http://snag.gy/IDl83.jpg)

### Crossover operator

![crossover operator](http://snag.gy/uBNYu.jpg)

### Mutation operator

![mutation operator](http://snag.gy/XMy5I.jpg)

## Interpreting the diagrams

- The large rectangle on the left shows one of 4 time intervals
	- In this case no maintenance is scheduled
- The grey area shows the expected power usage during the interval
	- White shows the surplus power available
- The scheduling task is to fit the units shown in blue
	- Into the white areas
	- While allowing for a buffer to avoid overloading the power station

![interpret the diag](http://snag.gy/W2wPl.jpg)

## Performance graphs

### Best maintenance schedules

#### 20 chromosomes

![20 chromo 1](http://snag.gy/URsW7.jpg)

![20 chromo 2](http://snag.gy/gk6us.jpg)

#### 100 chromosomes

![100 chromo 1](http://snag.gy/Nss6i.jpg)

![100 chromo 2](http://snag.gy/yI3PE.jpg)
