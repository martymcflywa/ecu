# Hybrid intelligent systems:

## Evolutionary neural networks and fuzzy evolutionary systems

# Evolutionary neural networks

- Neural networks used for solving variety of problems
	- Still have limitations
- One limitation is neural network training
	- Back propagation learning algorithm cannot guarantee an optimal solution
	- In real world applications
		- Back propagation algorithm might converge to a set of sub optimal weights from which it cannot escape
		- As a result
			- Neural network is often unable to find a desirable solution to a problem
- Another difficulty is related to selecting an optimal topology for the neural network
	- The **right** architecture for a particular problem is often chosen by means of heuristics
	- Designing a neural network topology is still more art than engineering
- Genetic algorithms are an effective optimization technique
	- Can guide both
		- Weight optimization
		- Topology optimization

## Encoding a set of weights in a chromosome

![encoding a set of weights in a chromosome](http://snag.gy/QhqB6.jpg)

- The second step
	- Define a fitness function for evaluating the chromosome's performance
		- This function must estimate the performance of a given neural network
		- We can apply here a simple function defined by the sum of squared errors
- The training set of examples is presented to the network
	- Sum of squared errors is calculated
		- The smaller the sum
			- The fitter the chromosome
	- The genetic algorithm attempts to find a set of weights that minimize the sum of squared errors
- The third step
	- Choose genetic operators
		- Crossover
		- Mutation
	- Crossover operator
		- Takes two parent chromosomes
			- Creates a single child with genetic material from both parents
		- Each gene in the child's chromosome is represented by the corresponding gene of the randomly selected parent
	- Mutation operator
		- Selects a gene in a chromosome
			- Adds a small random value
				- Between -1 and 1 to each weight in this gene

### Crossover in weight optimization

![crossover in weight optimization](http://snag.gy/o6ufI.jpg)

### Mutation in weight optimization

![mutation in weight optimization](http://snag.gy/4aGCC.jpg)

## Genetic algorithm to select network architecture

- Architecture of network
	- Number of neurons
	- Number of interconnections between neurons
- Architecture often determines success/failure of application
	- Architecture usually decided by trial and error
	- Great need for a method of automatically designing the architecture for a particular application
- Genetic algorithms may be well suited to the task
- Basic idea
	- Evolving a suitable network architecture
	- Conduct genetic search in a population of possible architectures
- Must first
	- Choose a method of encoding a network's architecture into a chromosome

### Encoding network architecture

- The connection topology of a neural network can be represented by
	- A square connectivity matrix
- Each entry in the matrix defines the type of connection from one neuron (column) to another (row)
	- 0 = no connection
	- 1 = connection
		- Weight can be changed through learning
- To transform the connectivity matrix into a chromosome
	- We need only to string the rows of the matrix together

### Encoding network topology

![encoding network topology](http://snag.gy/cvMCF.jpg)

### Cycle of evolving a neural network topology

![cycle of evolving a neural network topology](http://snag.gy/IvYaD.jpg)

# Fuzzy evolutionary systems

- Evolutionary computation is also used in the design of fuzzy systems
	- Particularly for
		- Generating fuzzy rules
		- Adjusting membership functions of fuzzy sets
- In this section
	- We introduce an application of genetic algorithms to select an appropriate set of fuzzy IF-THEN rules for a classification problem
- For a classification problem
	- A set of fuzzy IF-THEN rules is generated from numerical data
- First
	- We use a grid-type fuzzy partition of an input space

## Fuzzy partition

![fuzzy partition example](http://snag.gy/QCB39.jpg)

- Black and white dots denote training patterns of Class 1 and Class 2
- The grid-type fuzzy partition can be seen as a rule table
- The linguistic values
	- X axis
		- Input x1
			- A<sub>1</sub>
			- A<sub>2</sub>
			- A<sub>3</sub>
	- Y axis
		- Input x2
			- B<sub>1</sub>
			- B<sub>2</sub>
			- B<sub>3</sub>
- Each intersection of each row/column lies the rule consequent

### Rule table

- In the rule table
	- Each fuzzy subspace can have only one fuzzy IF-THEN rule
- Thus
	- Total number of rules that can be generated in a K*K grid
	- Is equal to K*K
- Fuzzy rules that correspond to the K*K fuzzy partition can be represented in a general form as:

![fuzzy rule general form](http://snag.gy/jLrWs.jpg)

- Where
	- x<sub>p</sub> is a training pattern on inut space X1*X2
	- P is the total number of training patterns
	- C<sub>n</sub> is the rule consequent
		- Either Class 1 or Class 2
	- CF<sup>C<sub>n</sub></sup><sub>A<sub>i</sub>B<sub>j</sub></sub> is the certainty factor that a pattern in fuzzy subspace A<sub>i</sub>B<sub>j</sub> belongs to in class C<sub>n</sub>

## Procedure

- To determine the rule consequent and certainty factor
	- We use the following procedure

### Step 1

- Partition an input space into K*K fuzzy subspaces
	- Calculate strength of each class of training patterns in every fuzzy subspace
- Each class in a given fuzzy subspace is represented by its training patterns
	- The more training patterns
		- The stronger the class
	- In a given fuzzy subspace
		- The rule consequent becomes more certain when patterns of one particular class appear more ofetn than patterns of any other class

### Step 2

- Determine the rule consequent and the certainty factor in each fuzzy subspace
- The certainty factor can be interpreted as:
	- If all the training patterns in fuzzy subspace A<sub>i</sub>B<sub>j</sub> belong to the same class
		- Then the certainty factor is maximum
		- It is certain that any new class pattern in this subspace will belong to this class
	- If training patterns belong to different classes and these classs have similar strengths
		- Then the certainty factor is minimum
		- It is uncertain that a new pattern will belong to any particular class
	- This means that patterns in a fuzzy subspace can be misclassified
		- Moreover, if a fuzzy subspace does not have any training patterns
			- We cannot determine the rule consequent at all
		- If a fuzzy partition is too coarse
			- Many patterns may be misclassified
		- If a fuzzy partition is too fine
			- Many rules cannot be obtained
				- Because of the lack of training patterns in the corresponding fuzzy subspaces

### Training pattern distribution

- Training patterns are not necessarily distributed evenly in the input space
- As a result
	- It is often difficult to choose an appropriate density for the fuzzy grid
- To overcome this difficulty
	- We use **multiple rule tables**

## Multiple fuzzy rule tables

![multiple fuzzy rule tables](http://snag.gy/3QEjU.jpg)

- Fuzzy IF-THEN rules are generated for each fuzzy subspace of multiple fuzzy rule tables
- A complete set of rules for the example above can be specified as:

![complete set](http://snag.gy/ZnenU.jpg)

- Once the set of rules S<sub>ALL</sub> is generated
	- A new pattern: x = (x1, x2), can be classified by the following procedure:

### Step 1

- In every fuzzy subspace of the multiple fuzzy rule tables
	- Calculate the degree of compatibility of a new pattern with each class

### Step 2

- Determine the maximum degree of compatibility of the new pattern with each class

### Step 3

- Determine the class with which the new pattern has the highest degree of compatibility
	- Assign the pattern to this class

### Number of fuzzy rule tables

- The number of multiple fuzzy rule tables required for an accurate pattern classification may be large
- Consequently
	- A complete set of rules can be enormous
- Meanwhile
	- These rules have different classification abilities
- Thus
	- By selecting only rules with high potential for accurate classification
- We reduce the number of rules

## Using genetic algorithms for selecting fuzzy IF-THEN rules

- The problem of selecting fuzzy IF-THEN rules can be seen as a combinatorial optimization problem with two objectives
- First objective
	- More important
	- Maximize the number of correctly classified patterns
- Second objective
	- Minimize the number of rules
- Genetic algorithms can be applied to this problem

### Step 1

- Randomly generate an initial population of chromosomes
- Population size may be relatively small
	- Say 10 or 20 chromosomes
- Each gene in a chromosome corresponds to a particular fuzzy IF-THEN rule in the rule set defined by S<sub>ALL</sub>

### Step 2

- Calculate the performance/fitness of each individual chromosome in the current population

#### Fitness function

- The fitness function has to accommodate the objectives stated above
	- Maximize number of correctly classified patterns
	- Minimize number of rules
- This can be achieved by introducing two respective weights in the fitness function
	- w<sub>p</sub>
	- w<sub>n</sub>

![fitness function](http://snag.gy/VVu96.jpg)

- Where
	- P<sub>s</sub> is the number of patterns classified successfully
	- P<sub>ALL</sub> is the total number of patterns presented to the classification system
	- N<sub>s</sub> is the number of fuzzy IF-THEN rules in set S
	- N<sub>ALL</sub> is the number of fuzzy IF-THEN rules in set S<sub>ALL</sub>
- The classification accuracy is more important than the size of a rule set
	- That is:

![classification accuracy > size of a rule set](http://snag.gy/rDgkp.jpg)

### Step 3

- Select a pair of chromosomes for mating
- Parent chromosomes are selected with a probability associated with their fitness
	- A better fit chromosome has a higher probability of being selected

### Step 4

- Create a pair of offspring chromosomes by applying a standard crossover operator
- Parent chromosomes are crossed at the randomly selected crossover point

### Step 5

- Perform mutation on each gene of the created offspring
- The mutation probability is normally kept quite low
	- Around 0.01
- The mutation is done by multiplying the gene value by -1

### Step 6

- Place the created offspring chromosomes in the new population

### Step 7

- Repeat Step 3 until the size of the new population becomes equal to the size of the initial population
- Then replace the initial (parent) population with the new (offspring) population

### Step 8

- Go to Step 2 and repeat the process until a specified number of generations is considered
- The number of rules can be cut down to less than 2% of the initially generated set of rules
