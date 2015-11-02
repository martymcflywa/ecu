# Chapter 7: Evolutionary computation

## 7.1 Introduction: Can evolution be intelligent

- Intelligence
	- Capability to adapt behavior to changing environment
- Evolutionary computation
	- Simulates evolution on a computer
	- Results of simulation
		- In a series of optimization algorithms
		- Based on simple set of rules
- Optimization iteratively improves quality of solutions
	- Until optimal/feasible solution is found
- Evolutionary machine learning
	- Based on computational models of
		- Natural selection
		- Genetics
- Evolutionary computation
	- Genetic algorithms
	- Evolution strategies
	- Genetic programming

## 7.2: Simulation of natural evolution

- Neo darwinism
	- Process of
		- Reproduction
		- Mutation
		- Competition
		- Selection
	- Power to reproduce
		- Essential property to life
	- Power to mutate
		- Guaranteed in any living organism that reproduces in constantly changing environment
	- Process of competition/selection
		- Take place in natural world
		- Expanding populations of different species are limited by finite space
- Evolutionary fitness
	- Process leading to maintenance or increase of population's ability to survive/reproduce in specific environment
	- Cannot be measured directly
		- Can be estimated based on ecology and functional morphology of organism in its environment
	- It is the quantitative measure of the ability to predict environmental changes and respond adequately
		- Can be considered the quality that is being optimized in natural life

### Adaptive topology

- Illustrates fitness
- Example
	- Represent a given environment by a landscape
		- Each peak corresponds to optimized fitness of a species
	- As evolution takes place
		- Each species is of a given population moves up the slopes of the landscape towards the peaks
		- Environmental conditions change over time
			- Species have to continually adjust their routes
		- As a result
			- Only fittest can reach the peaks
- Adaptive topology is a continuous function
	- Simulates fact that environment is not static
	- Shape of topology changes over time
		- All species continually undergo selection
	- Goal of evolution
		- To generate a population of individuals with increasing fitness

### How is a population with increasing fitness generated

- Example: Rabbits
	- Some rabbits are faster than others
		- Posses superior fitness
			- Greater chance of avoiding foxes
			- Surviving then breeding
	- Some slower rabbits may survive too
	- Slow rabbits breed with fast rabbits
		- Or slow rabbits with slow rabbits
		- Or fast rabbits with fast rabbits
	- Breeding generates mixture of rabbit genes
	- If two parents have superior fitness
		- Good chance that a combination of their genes will produce an offspring with even higher fitness
	- Over time, the entire population of rabbits becomes faster to meet environmental challenges
		- ie. Foxes
	- Environmental changes could change to favor fat but smart rabbits
	- To optimize survival
		- Genetic structure of rabbit population will change accordingly

### Simulating natural evolution in a computer

- Common methods
	- Create population of individuals
	- Evaluate fitness
	- Generate new population through genetic operations
	- Repeat process
- Genetic algorithm
	- One method of performing evolutionary computation
	- Moves from one population of artificial chromosomes to a new population
	- Uses natural selection and genetics inspired techniques
		- Crossover
		- Mutation
	- Each chromosome consists of a number of genes
	- Each gene is represented by 0 or 1
		- See figure 7.1

![figure 7.1](http://snag.gy/dFdtV.jpg)

- Genetic algorithms find good chromosomes blindly
- Two mechanisms link a GA to the problem it is solving
	- Encoding
	- Evaluation
- Encoding
	- Can be represented as string of 0 and 1
	- Other types of encoding techniques have been invented
	- No one type works best for all problems
- Evaluation
	- Function used to measure chromosome's performance/fitness
		- For problem to be solved
	- Measure of fitness used for reproduction
- Reproduction
	- As it takes place
		- Crossover operator
			- Exchanges parts of two single chromosomes
		- Mutation operator
			- Changes gene value in some randomly chosen location of the chromosome
	- After a number of successive reproductions
		- Less fit chromosomes become extinct
		- More fit chromosomes survive
			- Gradually come to dominate population

## 7.3 Genetic algorithms

- Class of stochastic search algorithms based on biological evolution
- Basic GA can be represented as in figure 7.2
	- Clearly defined problem to be solved
	- Binary string representation for candidate solutions

![figure 7.2](http://snag.gy/La1HE.jpg)

### Step 1

- Represent problem variable domain as a chromosome of fixed length
- Choose
	- Size of chromosome population N
	- Crossover probability p<sub>c</sub>
	- Mutation probability p<sub>m</sub>

### Step 2

- Define fitness function to measure fitness of individual chromosome in problem domain
- Fitness function
	- Establishes basis for selecting chromosomes that will be mated during reproduction

### Step 3

- Randomly generate an initial population of chromosomes of size N

![chromosomes size N](http://snag.gy/9HOsg.jpg)

### Step 4

- Calculate fitness for each individual chromosome

![fitness function](http://snag.gy/C186h.jpg)

### Step 5

- Select a pair of chromosomes for mating from the current population
- Parent chromosomes are selected with a probability related to their fitness
- Highly fit chromosomes
	- Higher probability of being selected
- Lower fit chromosomes
	- Low probability of being selected

### Step 6

- Create a pair of offspring chromosomes by applying the genetic operators
	- Crossover
	- Mutation

### Step 7

- Place created offspring chromosomes in new population

### Step 8

- Repeat step 5 until size of new chromosome population becomes equal to size of initial population, N

### Step 9

- Replace parent chromosome population with offspring population

### Step 10

- Go to step 4
- Repeat process until termination criteria is satisfied

### Generations

- Generation is each iteration of the GA process
- Typical number of generations
	- 50 to 500+
- Entire set of generations is called
	- **Run**
- At end of a run
	- We expect to find one or more highly fit chromosomes

### Conventional termination criteria

- Applying conventional criteria problematic
	- GAs use stochastic search method
	- Fitness of population may remain stable for number of generations before superior chromosome appears
- Common practice
	- Terminate GAs after a specified number of generations
	- Examine best chromosomes in population
	- If no satisfactory solution is found
		- GA is restarted

### Example

- Find max value of function:

>(15x - x<sup>2</sup>)

- Where
	- x <= 0 <= 15
		- Only integer values
- Chromosome can be built with only four genes:

![example genes](http://snag.gy/cpRaK.jpg)

#### Step 1

- Chromosome population size, N = 6
- Crossover probability, p<sub>c</sub> = 0.7
	- Typical value
- Mutation probability, p<sub>m</sub> = 0.001
	- Typical value

#### Step 2

- Fitness function:

![example fitness function](http://snag.gy/judEw.jpg)

#### Step 3

- GA creates an initial population of chromosomes
	- Fills six 4bit strings with randomly generated 0 and 1
- Initial population
	- See table 7.1
	- Initial locations of fitness functions are in figure 7.3(a)
	- Real example might have thousands of chromosomes

![table 7.1](http://snag.gy/BywTP.jpg)

#### Step 4

- Calculate fitness of individual chromosomes
	- Results shown in table 7.1
- Average fitness for population is 36

#### Step 5

- To improve it
	- Initial population is modified using genetic operators
		- Selection
		- Crossover
		- Mutation
- Similar approach to natural selection
	- But size of chromosome population is constant

![figure 7.3](http://snag.gy/2SQIu.jpg)

### How to maintain size of population constant while improving average fitness

- Last column in table 7.1 shows ratio of individual chromosome's fitness to population's total fitness
	- Ration determines chromosome's chance of being selected for mating
- Thus
	- Chromosome X5 and X6
		- Have fair chance of selection
	- Chromosome X3 and X4
		- Have low chance of selection
- As a result
	- Average fitness improves from one generation to the next

#### Roulette wheel selection

- Commonly used selection technique
- See figure 7.4

![figure 7.4](http://snag.gy/ovQL8.jpg)

- Each chromosome is given a slice of a circular roulette wheel
- Area of the slice within the wheel is equal to the chromosome fitness ratio
- Example
	- X5 and X6
		- Most fit
		- Occupy largest areas
	- X3 and X4
		- Least fit
			- Occupy least areas
- To select chromosomes for mating
	- Random number is generated in interval 0 - 100
	- Chromosome whose segment spans random number is selected
	- Like spinning roulette wheel where each chromosome has a segment on the wheel proportionate to its fitness
- In example
	- Initial population = 6 chromosomes
	- To establish population in next generation
		- Roulette wheel is spun 6 times
			- First 2 spins
				- Might select X6 and X2 to become parents
			- Next 2 spins
				- Might select X1 and X5
			- Last 2 spins
				- Might select X2 and X5
- Once pair of parent chromosomes are selected
	- Crossover operator is applied

### Crossover operator

- Randomly chooses a crossover point where two parent chromosomes break
- Then exchanges chromosome parts after that point
- As a result
	- Two new offspring are created
- Example
	- X6 and X2 cross over after the 2nd gene in each to produce two offspring
		- See figure 7.5

![figure 7.5](http://snag.gy/WX2gC.jpg)

- Cloning
	- When crossover does not occur
	- Offspring are exact copies of parent
	- Example
		- X2 and X5
- A value of 0.7 for crossover probability generally produces good results
- After selection and crossover
	- Average fitness of the chromosome population has improved from 36 to 42

### Mutation operator

- Mutation is rare in nature
- Represents change in the gene
- May lead to either
	- Significant improvement in fitness
	- Harmful results
		- Occurs more often
- Why use mutation
	- Provides a guarantee that the search algorithm is not trapped on a local **optimum**
	- Sequence of selection and crossover operations may stagnate at any homogeneous set of solutions
	- Under such conditions
		- All chromosomes are identical
		- Average fitness of population cannot improve
	- However
		- Solution might appear to become locally optimal
			- Only because the search algorithm is not able to proceed any further
- Mutation is equivalent to a random search
	- Aids in avoiding loss of genetic diversity

#### How mutation operator works

- Flips a randomly selected gene in a chromosome
- Example in figure 7.5
	- X1' mutated to its second gene
	- X2 mutated to its third gene
- Mutation can occur at any gene in a chromosome with some probability
- Mutation probability is small in nature
	- Kept low in GA
	- Typical range
		- 0.001 to 0.01
- Genetic algorithms assure the continuous improvement of the average fitness of the population
	- After a number of generations
		- Typically several hundred
		- The population evolves to a **near optimal** solution
- In previous example
	- Final population would consist of only chromosomes `0111` and `1000`
	- The chromosome's final locations on the fitness function are shown in figure 7.3(b)

### Two variable example

- Example
	- Find max of peak function of two variables

![max of peak function, two variables](http://snag.gy/dCs5S.jpg)

- Where
	- x and y vary between -3 and 3

#### Step 1

- Represent problem variables as a chromosome
	- Represent parameters x and y as a concatenated binary string:

![step 1](http://snag.gy/9FOW2.jpg)

- Each parameter is represented by 8bit binary

#### Step 2

- Choose size of population
	- 6
- Randomly generate initial population

#### Step 3

- Calculate fitness for each chromosome
- Done in two stages
- Stage 1
	- Chromosome decoded
	- Converting into two real numbers
		- x and y
		- Must be within interval -3 to 3
- Stage 2
	- Decoded values used in peak function

##### Decoding

- Split chromosome in half
	- ie. 16 bit to 8 bit
	- 16 bit
		- `1000 1010 0011 1011`
	- x
		- `1000 1010`
	- y
		- `0011 1011`
- Convert binary to decimal
	- x = 138
	- y = 59
- Range of integers that can be handled by 8 bits is mapped to actual range of parameters
	- Between 0 to 2<sup>8</sup>-1
		- 256 - 1
	- Between -3 to 3
		- 6

![decoding 1](http://snag.gy/H8lcX.jpg)

- To obtain actual values of x and y
	- Multiply decimal values by 0.0235294
	- Subtract 3

![decoding 2](http://snag.gy/kOTZb.jpg)

- When necessary
	- Can also apply other decoding techniques
		- Grey coding
- Using decoded values of x and y as inputs in mathematical function
	- The GA calculates the fitness for each chromosome

#### Results

- To find the maximum of the peak function
	- Crossover
		- Probability 0.7
	- Mutation
		- Probability 0.001
	- Max generations
		- 100
- Figure 7.6(a) shows initial locations of the chromosomes on the surface and contour plot of the peak function
	- Each chromosome here is represented by a sphere
	- The initial population consists of randomly generated individuals that are dissimilar
		- Or **heterogeneous**
	- The second generation
		- Crossover begins to recombine features of the best chromosomes
		- Population begins to converge on the peak containing the maximum
			- Shown in figure 7.6(b)
	- For then until the final generation
		- GA is searching around this peak with mutation
			- Results in diversity
	- Figure 7.6(c)
		- Shows final chromosome generation
		- However
			- Population has converged on a chromosome lying on a local maximum of the peak function
- But we are looking for the global maximum
	- So can we be sure the search is for the optimal solution?

![figure 7.6](http://snag.gy/AGCj6.jpg)

#### GA disadvantage

- Quality of results
- Whether or not an optimal solution is being reached
- One way of providing insurance is to compare results obtained under different rates of mutation
- Increased mutation rate 0.01
	- Population might now converge on the chromosomes in figure 7.6(s)
- But to be sure of steady results
	- Increase population size
- Surface of a mathematical function given in figure 7.6 is a convenient medium for displaying the GAs performance
	- However, fitness functions for real world problems cannot be easily represented graphically
	- Instead use performance graphs

#### Performance graph

## 7.4 Why genetic algorithms work

- Based on **schema theorem**
- Schema
	- Set of bit strings of `0`, `1`, `*`
		- `0`, `1` = fixed positions of a schema
		- `*` = wildcard
- Example
	- `1**0`
		- Set of 4bit strings
		- Each string in this set
			- Begins with a 1
			- Ends with a 0
		- These strings are called **instances** of the schema

### Relationship between schema and chromosome

- A chromosome matches a schema when the fixed positions in the schema match the corresponding positions in the chromosome
- Example schema H
	- `1**0`
- Matches the following set of 4 bit chromosomes

![4bit chromosomes](http://snag.gy/x1XHt.jpg)

- Number of defined bits (non asterisk) in a schema is called the **order**
- The schema H has two defined bits
	- It's order is 2
- Genetic algorithms manipulate **schemata** when they run
	- Plural of schema
- If GAs use a technique that makes the probability of reproduction proportional to chromosome fitness
	- We can predict the presence of a given schema in the next chromosome generation
		- In other words
			- We can describe the GAs behavior in terms of the increase/decrease in the number of instances of a given schema
- Assume that at least one instance of the schema H is present in the chromosome initial generation i
	- Let
		- m<sub>H</sub>(i) = number of instances of the schema H in generation i
		- f<sub>H(i) = average fitness for these instances
	- We want to calculate the number of instances in the next generation
		- m<sub>H</sub>(i + 1)
	- As the probability of reproduction is proportional to chromosome fitness
		- We can easily calculate the expected number of offspring of a chromosome x in the next generation:

![equation 7.1](http://snag.gy/GvyQJ.jpg)

- Where
	- f<sub>x</sub>(i) = fitness of chromosome x
	- f(i) = average fitness of chromosome initial generation i
- Then assuming that chromosome x is an instance of schema H
	- Can obtain:

![equation 7.2/7.3](http://snag.gy/Z1pTB.jpg)

- Thus a schema with above average fitness will tend to occur more frequently in the next generations of chromosomes
- A schema with below average fitness will occur less frequently

### Effects caused by crossover and mutation

- Crossover and mutation and create/destroy instances of a schema
- Will only consider destructive effects
	- Decrease number of instances of schema H

#### Crossover destruction

- Schema will survive after crossover if at least one of its offspring is also an instance of schema
- This is the case where crossover does not occur within defining length of the schema

##### What is the defining length of a schema

- The distance between outermost defined bits
- Example
	- `****1101` = 3
	- `*0*1*10*` = 5
	- `1******0` = 7
- If crossover takes place within the defining length
	- Schema H can be destroyed
	- Offspring that are not instances of H can be created
	- However
		- Schema H will not be destroyed if
			- Two identical chromosomes cross over
			- Even when crossover occurs within the defining length

## 7.5 Case study: Maintenance scheduling with genetic algorithms

- One of most successful applications for GA
- Scheduling problems
	- Complex
	- Difficult to solve
- Usually approached with
	- Search techniques
	- Heuristics

### Why scheduling problems are difficult

- Belongs to NP-complete problems
- NP-complete problems
	- Unmanageable
	- Cannot be solved by combinatorial search techniques
	- Heuristics alone cannot guarantee best solution
- Involve competition for limited resources
	- Complicated by many constraints
- Key to success
	- Defining fitness function that incorporates constraints

### Case study problem

- Maintenance scheduling in modern power systems
- Has to be carried out under several constraints and uncertainties
	- Failures
	- Forced outages
	- Delays in obtaining spare parts
- Schedule has to be revised at short notice

### Typical process of GA development

1. Specify problem
	- Define
		- Constraints
		- Optimum criteria
2. Represent the problem domain as a chromosome
3. Define fitness function to evaluate chromosome performance
4. Construct genetic operators
5. Run GA and tune parameters

### Step 1: Specify problem

- Most important step
- If not done correctly/completely
	- A viable schedule cannot be obtained
- Power system components
	- Made to operate continuously throughout life by means of preventative maintenance
- Purpose of maintenance scheduling
	- Find sequence of outages of power units over a given period of time
		- So that uptime is maximized
- Uptime margin
	- Determined by system's net reserve
- Net reserve
	- Defined as
		- Total installed generating capacity of the system
		- Minus power lost due to a scheduled outage
		- Minus max load forecast during the maintenance period
- Example
	- Total installed capacity is 150MW
	- Unit of 20MW scheduled for maintenance during period when max load is predicted to be 100MW
	- Net reserve = 30MW
	- Maintenance scheduling must ensure that sufficient net reserve is provided for secure power supply during any maintenance period
- Suppose there are 7 power units to be maintained in four equal intervals
	- Max loads expected during these intervals
		- 80MW
		- 90MW
		- 65MW
		- 70MW
	- Unit capacities and maintenance requirements in table 7.2
- Constraints are specified as
	- Maintenance of any unit
		- Starts at the beginning of an interval
		- Finished at the end of the same or adjacent interval
		- Maintenance cannot be aborted or finished earlier than expected
	- Net reserve of power system must be greater than or equal to zero at any interval

### Step 2: Represent the problem domain as a chromosome
