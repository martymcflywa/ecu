# Chapter 8: Hybrid intelligent systems

## Introduction

- Combines at least two intelligent technologies
	- Neural network with fuzzy system
		- Hybrid neuro fuzzy system
- Soft computing
	- Combination of
		- Probabilistic reasoning
		- Fuzzy logic
		- Neural networks
		- Evolutionary computation
	- Emerging approach to building hybrid intelligent systems
	- Capable of reasoning and learning in uncertain/imprecise environments

### Soft computing

- Hard computing
	- Crisp values
- Soft computing
	- Fuzzy sets
	- Capable of operating with uncertainty
		- Uncertain
		- Imprecise
		- Incomplete
	- Reflects human thinking

### Solving complex problems using words

- Words
	- Less precise than numbers
- Precision
	- High cost
- Words used when
	- There is tolerance for imprecision
		- Soft computing exploits tolerance for uncertainty/imprecision to achieve
			- Greater
				- Tractability
				- Robustness
			- Lowers
				- Cost of solutions
	- Available data is not precise enough to use numbers
		- Often case with complex problems
		- Hard computing fails to produce solution
		- Soft computing still capable of finding good solutions

### Soft computing vs. AI

- Conventional AI
	- Attempts to express human knowledge in symbolic terms
	- Corner stones
		- Rigid theory for symbol manipulation
		- Exact reasoning mechanisms
			- Forward/backward chaining
	- Expert system
		- Only good as knowledge acquired from human expert
			- Represented in knowledge base
		- Limits field of practical applications
- Domain of AI expanded
	- Now includes
		- Artificial neural networks
		- Genetic algorithms
		- Fuzzy set theory
	- Makes boundaries between modern AI and soft computing vague

### What is combined in hybrid system

- Goal
	- Select right components for building good hybrid system
- Each component has strengths/weaknesses
	- Probabilistic reasoning
		- Concerned with uncertainty
	- Fuzzy logic
		- Concerned with imprecision
	- Neural networks
		- Concerned with learning
	- Evolutionary computation
		- Concerned with optimization
- Table 8.1
	- Comparison of different intelligent technologies

|                                 | Expert systems | Fuzzy systems | Neural networks | Genetic Algorithms |
|:--------------------------------|----------------|---------------|-----------------|--------------------|
| Knowledge representation        | Rather good    | Good          | Bad             | Rather bad         |
| Uncertainty tolerance           | Rather good    | Good          | Good            | Good               |
| Imprecision tolerance           | Bad            | Good          | Good            | Good               |
| Adaptability                    | Bad            | Rather bad    | Good            | Good               |
| Learning ability                | Bad            | Bad           | Good            | Good               |
| Explanation ability             | Good           | Good          | Bad             | Rather bad         |
| Knowledge discovery/data mining | Bad            | Rather bad    | Good            | Rather good        |
| Maintainability                 | Bad            | Rather good   | Good            | Rather good        |

- Good hybrid system
	- Brings advantages of technologies together
	- Allows hybrid system to
		- Accommodate common sense
		- Extract knowledge from raw data
		- Use human like reason mechanisms
		- Deal with uncertainty/imprecision
		- Learn to adapt to changing/unknown environment

## 8.2 Neural expert systems

- Expert systems and neural networks share common goals
	- Attempt to imitate human intelligence
	- Eventually creates intelligent machine
- They both use different means to achieve goals

### Expert systems

- Rely on
	- Logical inferences
	- Decision trees
- Focus on
	- Modeling human reasoning
- Treat brain as a black box
- Knowledge acquisition
	- Observe/interview human experts
	- Difficult/expensive
	- Once rules are stored in knowledge base
		- Can't be modified by expert system itself
		- Only humans can manually manage rules in knowledge base
			- Adding
			- Changing
			- Deleting
- Knowledge can be divided into individual rules
	- User can see/understand the piece of knowledge applied by the system
- Learning
	- Cannot learn
	- Can explain how it arrives at solution

### Neural networks

- Rely on
	- Parallel data processing
- Focus on
	- Modeling human brain
- Looks at structure and function of brain
	- Ability to learn
- Knowledge acquisition
	- Obtained during learning phase
		- When training set of data is presented to network
	- Stored as synaptic weights between neurons
	- Network propagates input data from layer to layer until output data is generated
		- If different from desired output
			- Error is calculated
			- Output propagated backwards through network
			- Synaptic weights then modified as error is propagated
	- Learn without human intervention
- Knowledge cannot be divided into rules
	- User cannot select a single synaptic weight as a discrete piece of knowledge
	- Knowledge is embedded in entire network
	- Any change of a synaptic weight may lead to unpredictable results
	- Neural network is a black box to its user
- Learning
	- Can learn
	- Cannot explain how it arrives at solution

### Neural expert system

- Combines advantages of each technology creates more powerful/effective expert system
- Also called connectionist expert system
- Properties
	- Learning ability
	- Generalization
	- Robustness
	- Parallel information processing
- Figure 8.1
	- Basic structure of neural expert system
	- Knowledge base is represented by a trained neural network

![figure 8.1](http://snag.gy/xOJan.jpg)

- Can extract IF-THEN rules from neural network
	- Enables to justify/explain conclusion

#### Neural expert system components

- Inference engine
	- At heart of neural expert system
	- Controls information flow in system
	- Initiates inference over neural knowledge base
	- Ensures approximate reasoning
- Rule extraction unit
	- Examines neural knowledge base
	- Produces rules implicitly buried in trained neural network
- Explanation facilities
	- Explain to user how neural expert system arrives at solution when working with new input data
- User interface
	- Communicates between user and neural expert system

#### Approximate reasoning

- Ability to deal with noisy/incomplete data
- Rule based expert systems
	- Inference engine compares condition part of each rule with data given in database
	- When IF part of rule matches data in database
		- Rule is fired
		- THEN part is executed
	- Precise matching is required
		- Inference engine cannot cope with noisy/incomplete data
- Neural expert system
	- Use trained neural network in place of knowledge base
	- Neural network is capable of generalization
		- New input data does not have to precisely match data that was used in network training
		- Allows approximate reasoning

#### Neural expert system inference justification

- Neurons in network are connected by links
	- Each link assigned weights
- Weights
	- Determine strength/importance of associated neuron inputs
	- Used for extracting rules
- Example
	- Object classification problem
		- Birds
		- Planes
		- Gliders
	- Neural network
		- Figure 8.2
		- Three layer network
			- Fully connected between first and second layers
		- All neurons labeled according to concepts they represent

![figure 8.2](http://snag.gy/H4JyQ.jpg)

- Input layer
	- First layer
	- Neurons in input layer transmit signals to next layer
- Conjunction layer
	- Neurons apply sign activation function

![equation 8.1](http://snag.gy/Kcw9u.jpg)

- Where
	- X = net weighted input to the neuron

![weighted input](http://snag.gy/r2CdZ.jpg)

- Where
	- x<sub>i</sub> = value of input i
	- w<sub>i</sub> = weight of input i
	- n = number of neuron inputs
- Output layer
	- Each output neuron receives an input from a single conjunction neuron
	- Weights between second and third layers are set to unity
- IF-THEN rules are mapped into three layer neural network
	- Third layer
		- Disjunction
		- Represents the consequent part of the rules
	- Strength of a given rule can be associated with the weight between respective conjunction and disjunction neurones
		- Certainty factor
- Neural knowledge base was trained with a set of training examples
	- Figure 8.2 shows numerical weights obtained between first and second layers
- If we now set each input of the input layer to either
	- +1 = true
	- -1 = false
	- 0 = unknown
	- We can give a semantic interpretation for the activation of any output neuron
- Example
	- If object
		- Has
			- Wings +1
			- Beak +1
			- Feathers +1
		- Does not have
			- Engine -1
	- Can conclude that object is
		- Bird +1

![bird](http://snag.gy/qED1t.jpg)

- By attaching a corresponding question to each input neuron
	- Wings
		- Does object have wings
	- Tail
		- Does object have tail
	- Beak
		- Does object have beak
	- Feathers
		- Does object have feathers
	- Engine
		- Does object have engine
- We can enable the system to prompt the user for initial values of the input variables
- System's goal
	- Obtain the most important information first
	- Draw a conclusion as quickly as possible

#### How does system know what most important information is and whether it has enough information to draw a conclusion

- Importance of a particular neuron input is determined by the absolute value of the weight attached to this input
- Example
	- Neuron Rule 1
		- Input Feathers has much greater importance than input Wings
- Thus we might establish the following dialogue with the system

![dialogue](http://snag.gy/M0URZ.jpg)

- Task now is to see whether the acquired information is sufficient to draw a conclusion
- The following heuristic can be applied
	- An inference can be made if the known net weighted input to a neuron is greater than the sum of absolute values of the weights of the unknown inputs
	- Expressed as:

![equation 8.2](http://snag.gy/bpSRN.jpg)

- When input feathers becomes known
	- We obtain:

![known vs. unknown](http://snag.gy/kWp4W.jpg)

- Therefore inference for neuron rule 1 cannot be made yet
- User is asked to provide a value for next important input
	- Beak
- Then repeat equation 8.2 to determine if inference can be made
- KNOWN
	- Gives the acquired net weighted input to neuron
- UNKNOWN
	- Indicates how this net input might change based on worst possible combination of values of unknown inputs
- In example above
	- Net weighted input cannot change more than ~2.1
	- Therefore
		- Output of neuron rule 1 will be greater than 0 regardless of values of known inputs
		- We can make inference that Bird must be true

### Mapping rules to multi-layered network

- Figure 8.3
	- Set of rules
	- Mapped to five layer neural network
	- Strengths of rules
		- Weights between conjunction/disjunction layers
		- Regarded as certainty factors of associated rules

![figure 8.3](http://snag.gy/OTjw1.jpg)

### Training neural knowledge base

- According to given set of training data
- Can be done using appropriate algorithm
	- Back propagation
- When training complete
	- Examine neural network knowledge base
	- Extract/refine set of IF-THEN rules
- Neural expert systems provide bi-directional link between
	- Neural networks
	- Rule based systems

### Limitations

- Suffer from same limitations of boolean logic
- Any attempt to represent continuous input variables may lead to infinite increase in number of rules
- Limits application for neural expert systems
- Overcome by using fuzzy logic

## 8.3 Neuro-fuzzy systems (Mamdani)

### Neural networks

- Low level computational structures
- Perform well when dealing with raw data
- Can learn
- Opaque to user

### Fuzzy logic

- Deals with reasoning on higher level
- Uses linguistic information acquired from domain experts
- Lacks ability to learn
- Cannot adjust to new environment

### Neuro-fuzzy system

- Combines
	- Neural networks
		- Parallel computation
		- Learning abilities
	- Fuzzy logic
		- Human like knowledge
			- Representation
			- Explanation
	- Neural networks become more transparent
	- Fuzzy logic is able to learn
- Functionally equivalent to fuzzy inference model
	- Can be trained to
		- Develop IF-THEN fuzzy rules
		- Determine membership functions for input/output variables
	- Expert knowledge can be incorporated into structure
	- Connectionist structure avoids fuzzy inference
		- Needs more CPU overhead

### Neuro-fuzzy system structure

- Similar to multi-layer neural network
	- Input/output layers
	- Three hidden layers
		- Represent membership functions and fuzzy rules
- Figure 8.4
	- Mamdani inference model
- Figure 8.5
	- Neuro fuzzy system corresponding to model
- Assume
	- Fuzzy system has
		- Two inputs
			- x1
				- Represented by fuzzy sets
					- A1
					- A2
					- A3
			- x2
				- Represented by fuzzy sets
					- B1
					- B2
					- B3
		- One output
			- y
				- Represented by fuzzy sets
					- C1
					- C2

![figure 8.4](http://snag.gy/uWRbL.jpg)

![figure 8.5](http://snag.gy/fQMmm.jpg)

- Each layer is associated with a particular step in fuzzy inference process

#### Layer 1: Input layer

- Each neuron transmits external crisp signals directly to next layer:

![equation 8.3](http://snag.gy/xiowd.jpg)

- Where
	- x<sub>i</sub><sup>(1)</sup> = input in layer 1
	- y<sub>i</sub><sup>(1)</sup> = output in layer 1

#### Layer 2: Input membership/fuzzification layer

- Neurons represent fuzzy sets used in **antecedents** to fuzzy rules
- Receives crisp set
- Determines degree to which this input belongs to in the neuron's fuzzy set
	- Activation function
		- Set to the function that specifies the neuron's fuzzy set
		- Figure 8.4
			- Uses triangular sets
		- Therefore
			- Activation functions for neurons in layer 2 are set to the triangular membership functions
				- See equation 8.4

##### Triangular membership function

![equation 8.4](http://snag.gy/eEaMs.jpg)

- Where
	- a = controls center of triangle
	- b = controls width of triangle
	- x<sub>i</sub><sup>(2)</sup> = input
	- y<sub>i</sub><sup>(2)</sup> = output
- Figure 8.6 shows
	- Triangular function and the effect caused by the variation of parameters a and b
	- Output of a fuzzification neuron depends on
		- Input
		- Center, a
		- Width, b
	- Neuron input may remain constant
		- But output will vary with change of parameters a and b
	- In other words
		- Parameters a and b can play same role as synaptic weights in a neural network

![figure 8.6](http://snag.gy/gBZI6.jpg)

#### Layer 3: Fuzzy rule layer

- Each neuron corresponds to a single fuzzy rule
- Receives inputs from fuzzification neurons
	- Represent fuzzy sets in rule antecedents
- Example
	- Neuron R1
		- Rule 1
	- Receives input from neurons A1 and B1
		- Have to deal with multiple antecedents

##### Multiple antecedents

- If given rule has multiple antecedents
	- Fuzzy operator is used to obtain a single number that represents the result of antecedent evaluation
- The conjunction of the rule antecedents is evaluated by fuzzy operation
	- Intersection
- Same fuzzy operation can be used to combine multiple inputs to a fuzzy rule neuron
- In neuro fuzzy system
	- Intersection can be implemented by product operator
	- Thus output of neuron i in layer 3 can be obtained as:

![equation 8.5](http://snag.gy/N2HPe.jpg)

- Where
	- &mu;<sub>R1</sub> = firing strength of fuzzy rule neuron R1
- The weights between layer 3 and 4 represent **normalised degrees of confidence** of corresponding rules
	- Also known as certainty factors
	- These weights are adjusted during training of neuro-fuzzy system

##### Normalised degree of confidence of a fuzzy rule

- Different rules represented in a neuro fuzzy system may be associated with different degrees of confidence
	- Figure 8.4
		- An expert may attach the degrees of confidence to each IF THEN rule
			- By setting corresponding weights
				- Within range 0 to 1
		- During training
			- These weights can change
		- To keep them within specified range
			- Weights are normalized by dividing their values by highest weight magnitude obtained at each iteration

#### Layer 4: Output membership layer

- Neurons represent fuzzy sets used in consequent of fuzzy rules
- Output membership neuron receives inputs from corresponding fuzzy rule neurons
	- Combines them using fuzzy operation union
		- Can be implemented by probabilistic OR
			- Also known as algebraic sum
		- Equation 8.6

![equation 8.6](http://snag.gy/t20Az.jpg)

- The value of &mu;<sub>C1</sub> represents the integrated firing strength of fuzzy rule neurons R3 and R6
	- Firing strengths of neurons in the output membership layer are combined in the same way as truth values of fuzzy rules
		- See figure 8.4
	- Mamdani fuzzy system
		- Output fuzzy sets are clipped by the truth values of corresponding fuzzy rules
	- Neuro-fuzzy system
		- Activation functions of output membership neurons are clipped
	- Example
		- Membership function of neuron C1 is clipped by integrated firing strength &mu;<sub>C1</sub>

#### Layer 5: Defuzzification layer

- Each neuron represents a single output
- It takes output fuzzy sets clipped by respective integrated firing strengths
- Combines them into a single fuzzy set
- Output is crisp
	- Therefore a combined output fuzzy set must be defuzzified
- Neuro-fuzzy systems can apply standard defuzzification methods
	- Including centroid technique
- In example
	- Will use **sum-product compositionn** method
		- Offers computational shortcut for Mamdani style inference

##### Sum-product composition

- Calculates the crisp output as
	- The weighted average of the centroids of all output membership functions
- Example
	- Weighted average of the centroids of the clipped fuzzy sets C1 and C2 is calculated as:

![equation 8.7](http://snag.gy/fXqdb.jpg)

- Where
	- a<sub>C1</sub> = center of C1
	- a<sub>C2</sub> = center of C2
	- b<sub>C1</sub> = width of C1
	- b<sub>C2</sub> = width of C2

### How neuro-fuzzy systems learn

- Multi layered network
- Can apply standard learning algorithms
	- Including back propagation
- When training input/output example is presented
	- Back propagation algorithm computes system output
	- Compares output with desired output of training example
	- Error is propagated backwards through the network from output layer to input layer
	- The neuron activation functions are modified as the error is propagated
	- To determine necessary modifications
		- Back propagation algorithm differentiates the activation functions of the neurons

#### Learning example

- Figure 8.7
	- Distribution of 100 training patters in three dimensional input/output space
		- X1 x X2 x Y
- Each training pattern here is determined by three variables
	- Inputs
		- x1
		- x2
	- Output
		- y
- Input and output variables are represented by two linguistic variables
	- S = small
	- L = large

![figure 8.7](http://snag.gy/PSkkr.jpg)

- The data set of figure 8.7 is sued for training the five rule neuro fuzzy system shown in figure 8.8(a)
- Suppose that fuzzy IF-THEN rules incorporated into the system structure are supplied by a domain expert
	- Prior or existing knowledge can dramatically expedite system training
	- If quality of training data is poor
		- Expert knowledge may be the only way to come to a solution at all
	- However
		- Experts occasionally do make mistakes
			- Thus some rules used in a neuro-fuzzy system may be false or redundant
				- Figure 8.8
					- Either rule 1 or rule 2 is wrong
						- They have exactly the same IF parts
						- Their THEN parts are different
			- Therefore
				- Neuro-fuzzy system must be able to identify bad rules
- Figure 8.8(a)
	- Initial weights between layer 3 and 4 are set to unity
	- During weight training
		- Neuro fuzzy system uses back propagation algorithm to adjust weights and modify input/output membership functions
	- Training continues until sum of squared errors is less than 0.001
	- As seen in figure 8.8(b)
		- Weight w<sub>R2</sub> becomes equal to 0 while other weights remain high
			- This indicates that rule 2 is certainly false
				- Can be removed without harm to system
		- It leaves the system with four rules
			- Which represents the behavior of the XOR operation

![figure 8.8](http://snag.gy/mW0gw.jpg)

- Training pattern included bad patterns
	- System still capable of identifying false rules
- In XOR example
	- An expert gave 5 rules
		- One was wrong
	- Also cannot be sure that the expert provided all rules
	- What can be done to reduce dependence on expert knowledge
		- Can system extract rules directly from numerical data

#### Automatic generation of rules

- Given input and output linguistic variables
	- A neuro fuzzy system can automatically generate a complete set of fuzzy IF-THEN rules
- Figure 8.9 shows the system created for XOR example
	- Consists of 2<sup>2</sup> * 2 = 8 rules

![figure 8.9]

- Because expert knowledge is not embodied in the system this time
	- We set all initial weights between layer 3 and 4 to 0.5
	- After training
		- We can eliminate all rules whose certainty factors are less than some sufficiently small number
			- 0.1
	- As a result
		- We obtain the same set of four fuzzy IF-THEN rules representing XOR operation

### Neuro fuzzy system summary

- Domain knowledge can be put into a neuro fuzzy system by human experts
	- In form of linguistic variables and fuzzy rules
- When representative set of examples is available
	- Can automatically transform it into set of IF-THEN rules
	- Reduce dependence on expert knowledge

## 8.4 Adaptive neuro fuzzy inference system (ANFIS Sugeno)

- Sugeno fuzzy model
	- Typical Sugeno fuzzy rule:

![sugeno rule](http://snag.gy/UPwE3.jpg)

- Where
	- x<sub>1</sub>, x<sub>2</sub>, ..., x<sub>m</sub> = input variables
	- A<sub>1</sub>, A<sub>2</sub>, ..., A<sub>m</sub> = fuzzy sets
	- y = either
		- Constant
			- Obtain zero-order Sugeno model
			- The consequent of ar ule is specified by a singleton
		- Linear function of the input variables
			- Obtain first-order
			- y is a first-order polynomial
				- Example below

![first-order polynomial](http://snag.gy/DZqnm.jpg)

- ANFIS structure
	- Six layers
	- Feedforward neural network
- Figure 8.10
	- Structure of first-order Sugeno fuzzy model
	- Inputs
		- x1
		- x2
	- Output
		- y
	- Each input represented by two fuzzy sets
	- Output represented by a first-order polynomial
- Four rules:

![rules](http://snag.gy/L32fI.jpg)

- Where
	- x1 and x2 = input variables
	- A1 and A2 = fuzzy sets for universe of discourse X1
	- B1 and B2 = fuzzy sets for universe of discourse X2
	- k<sub>0</sub>, k<sub>1</sub> and k<sub>2</sub> = set of parameters specified for rule i

![figure 8.10](http://snag.gy/6K6Uw.jpg)

### Layer 1: Input layer

- Neurons pass external crisp signals to layer 2

### Layer 2: Fuzzification layer

- Neurons perform fuzzification
- Bell activation function
	- Regular bell shape
	- See equation 8.9

![equation 8.9](http://snag.gy/YPyt0.jpg)

- Where
	- x<sub>i</sub><sup>2</sup> = input for neuron i
	- y<sub>i</sub><sup>2</sup> = output neuron i
	- a<sub>i</sub> = center of bell activation function of neuron i
	- b<sub>i</sub> = width of bell activation function of neuron i
	- c<sub>i</sub> = slope of bell activation function of neuron i

### Layer 3: Rule layer

- Neurons correspond to a single Sugeno-type fuzzy rule
- Receives inputs for respective fuzzification neurons
- Calculates firing strengths of the rule it represents
- Conjunction of the rule antecedents is evaluated by operator **product**
	- Output of neuron i in layer 3 is calculated as:

![equation 8.10](http://snag.gy/Ovjtz.jpg)

- Where
	- x<sub>ji</sub><sup>(3)</sup> = inputs
	- y<sub>i</sub><sup>(3)</sup> = output

![example](http://snag.gy/0eFM6.jpg)

### Layer 4: Normalization layer

- Neurons receives inputs from all neurons in the rule layer
- Calculates **normalized firing strength** of a given rule
- Normalized firing strength
	- Ratio of the firing strength of a given rule to the sum of firing strengths of all rules
	- Represents a contribution of a given rule to the final result
	- Output determined as:

![equation 8.11](http://snag.gy/agAKB.jpg)

### Layer 5: Defuzzification layer

- Each neuron is connected to respective normalization neuron
- Also receives initial inputs x<sub>1</sub> and x<sub>2</sub>
- Defuzzification neuron calculates weighted consequent value of a given rule as:

![equation 8.12](http://snag.gy/eOrl7.jpg)

### Layer 6: Single summation neuron

- Calculates the sum of outputs of all defuzzification neurons
- Produces overall ANFIS output, y

![equation 8.13](http://snag.gy/ShvyV.jpg)

### Rule consequent in polynomial form

- Often difficult or impossible to specify a rule consequent in polynomial form
- Not necessary to have any prior knowledge of rule consequent parameters for ANFIS to deal with a problem
- ANFIS learns these parameters and tunes membership functions

### How ANFIS learns

- Uses hybrid learning algorithm
	- Combines
		- Least squares estimator
		- Gradient descent method
- Initial activation functions are assigned to each membership neuron
	- Function centers of the neurons connected to input x<sub>i</sub> are set so that the domain of x<sub>i</sub> is divided equally
	- Width and slopes are set to allow sufficient overlapping of respective functions
- Each epoch is composed from a forward and backward pass
	- In forward pass
		- A training set of input patters is presented to the ANFIS
			- Input vector
		- Neuron outputs are calculated on layer by layer basis
		- Rule consequent parameters are identified by the least squares estimator
		- In sugeno style fuzzy inference
			- An output y is a linear function
			- Thus given the values of the membership parameters and a training set of P input/output patters
				- We can form P linear equations in terms of the consequent parameters as

## 8.5 Evolutionary neural networks

- Neural networks
	- Disadvantages
		- Backward propagation cannot guarantee optimal solution
			- Might converge to a set of sub optimal weights from which it cannot escape
			- Often unable to find desirable solution to problem
		- Difficult to select optimal topology
			- Right network architecture for a particular problem is often chosen by means of heuristics
			- Designing topology more art than science
- Genetic algorithms
	- Effective optimization technique
	- Can guide weight and topology selection

### Weight optimization technique

- Represent problem domain as chromosome
	- Example
		- Find optimal set of weights for multilayer feedforward neural network
			- Figure 8.15

![figure 8.15](http://snag.gy/zkpCN.jpg)

- Initial weights chosen randomly within interval -1 to 1
	- Set of weights can be represented by a square matrix in which a real number corresponds to the weighted link from one neuron to another
		- 0 = no connection between two given neurons
	- There are 16 weighted links in total
	- Since a chromosome is a collection of genes
		- A set of weights can be represented by a 16 gene chromosome
	- Can string the rows of the matrix together to obtain chromosome
		- Ignoring zeros
- Each row now represents a group of all the incoming weighted links to a single neuron
	- Thought of as a functional building block of the network
	- Should be allowed to stay together passing genetic material from one generation to the next
		- To achieve this
			- Associate each gene with a group of all incoming weights of a given neuron
				- Figure 8.15

#### Fitness function

- To evaluate chromosome performance
- Must estimate performance of a given neural network
- Can apply simple function defined by the reciprocal of the sum of squared errors
- To evaluate fitness of chromosome
	- Each weight contained in the chromosome is assigned to respective link in the network
	- The training set of examples is then presented to the network
	- Sum of squared errors is calculated
	- Smaller the sum
		- Fitter the chromosome
	- Genetic algorithm attempts to find a set of weights that minimizes sum of squared errors

#### Genetic operators

- Crossover
	- Two parent chromosomes create single child
		- Genetic material from both parents
	- Each gene in child's chromosome is represented by the corresponding gene of randomly selected parent
		- Figure 8.16(a) shows example of crossover
- Mutation
	- Randomly selects gene in a chromosome
	- Adds a small random value between -1 and 1 to each weight in this gene
		- Figure 8.16(b) shows example of mutation

![figure 8.16](http://snag.gy/udAcW.jpg)

### Architecture optimization technique

- Search population of possible architectures

#### Encode network structure

- Decide how much information is required for network representation
- More parameters
	- Greater computational cost
- Simple direct method
	- Can only be applied to
		- Feedforward
		- Fixed number of neurons
- Connection topology of neural network can be represented by a square connectivity matrix
	- Figure 8.17
	- Each entry in the matrix defines the type of connection from
		- Neuron
			- Column
		- To another
			- Row
		- 0 = no connection
		- 1 = connection
	- To transform connectivity matrix into chromosome
		- String rows of matrix together
		- Figure 8.17

![figure 8.17](http://snag.gy/UJHBP.jpg)

### Steps

### Step 1

- Choose
	- Population size
	- Crossover/mutation probabilities
	- Number of training epochs

### Step 2

- Define fitness function to measure performance of individual chromosome
- Should be based on
	- Accuracy
	- Learning speed
	- Size
	- Complexity
- Network performance more important than size
	- Fitness function can still be defined by reciprocal of sum of squared errors

### Step 3

- Randomly generate initial population of chromosomes

### Step 4

- Decode individual chromosome into a neural network
	- Since example is restricted to feedforward
		- Ignore all feedback connections specified in chromosome
- Set initial weights of network within range -1 to 1
- Train network on a training set of examples for certain number of epochs using back propagation algorithm
- Calculate sum of squared errors
- Determine network fitness

### Step 5

- Repeat step 4 until all individuals in population have been considered

### Step 6

- Select pair of chromosomes for mating
	- Probability proportionate to fitness

### Step 7

- Create pair of offspring chromosomes by applying crossover and mutation
- Crossover
	- Randomly chooses a row index
	- Swaps corresponding rows between two parents
		- Creates two offspring
- Mutation
	- Flips one or two bits in chromosome
	- Low probability
		- 0.005

### Step 8

- Place created offspring chromosomes in new population

### Step 9

- Repeat step 6 until size of new chromosome population becomes equal to size of initial population
- Replace parent population with offspring population

### Step 10

- Go to step 4
- Repeat process until specified number of generations reached

### Evolutionary cycle

- Figure 8.18

![figure 8.18](http://snag.gy/6qW2V.jpg)
