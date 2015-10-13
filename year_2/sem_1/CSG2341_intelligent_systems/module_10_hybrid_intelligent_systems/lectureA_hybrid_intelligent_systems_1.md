# Hybrid intelligent systems:

## Neural expert systems and neuro fuzzy systems

## Introduction

- Hybrid intelligent system
	- Combines at least two intelligent technologies
	- Example
		- Combine neural network with fuzzy system
		- Hybrid neuro-fuzzy system
- Combination of
	- Probabilistic reasoning
	- Fuzzy logic
	- Neural networks
	- Evolutionary computation
- Forms core of **soft** computing
	- Emerging approach to building hybrid intelligent systems capable of learning/reasoning in an environment that is
		- Uncertain
		- Imprecise
- Words are less precise than numbers
	- Precision is costly
	- We use words when there is a tolerance for imprecision
	- Soft computing exploits tolerance for uncertainty/imprecision
	- To achieve
		- Greater tractability/robustness
		- Lower cost of solutions
- We also use words when available data is not precise enough to use numbers
	- Often the case with complex problems
	- While **hard** computing fails to produce any solution
		- Soft computing still capable of finding good solutions
- Lotfi Zadeh reputed to say that
	- A good hybrid would be
		- British police
		- German mechanics
		- French cuisine
		- Swiss banking
		- Italian love
	- A bad hybrid would be
		- British cuisine
		- German police
		- French mechanics
		- Italian banking
		- Swiss love
	- A hybrid intelligent system can also be good or bad
		- It depends on which components constitute the hybrid
	- Goal is to select the right components for building good hybrid system

## Comparison of intelligent systems

- ES: Expert system
- FS: Fuzzy system
- NN: Neural network
- GA: Genetic algorithm

![comparison of intelligent systems](http://snag.gy/yTS5w.jpg)

## Neural Expert systems

- Expert systems
	- Rely on logical inferences/decision trees
		- Focus on modeling human reasoning
	- Treat brain as black box
	- Knowledge can be divided into individual rules
		- User can see/understand the piece of knowledge applied by the system
	- Rule based expert system
		- Knowledge is represented by IF-THEN production rules
- Neural networks
	- Rely on parallel data processing
		- Focus on modeling human brain
	- Look at its structure and functions
		- Particularly ability to learn
	- Knowledge is stored as synaptic weights between neurons
	- One cannot select a single synaptic weight as a discrete piece of knowledge
		- Knowledge is embedded in the entire network
		- It cannot be broken into individual pieces
		- Any change of a synaptic weight may lead to unpredictable results
	- A neural network is a black box for its user

## Combining expert systems and neural networks

- Combine advantages of expert systems and neural networks to create a more powerful/effective expert system
- Called **neural expert system**
	- Or **connectionist expert system**

### Basic structure of neural expert system

![basic structure of neural expert system](http://snag.gy/hl3x3.jpg)

- Heart of neural expert system is the **inference engine**
	- Controls the information flow in system
	- Initiates inference over neural knowledge base
	- Neural inference engine ensures **approximate reasoning**

### Approximate reasoning

- Rule based expert system
	- Inference engine compares condition part of each rule with data given in database
	- When IF part of rule matches data in database
		- Rule is fired
		- THEN part is executed
	- The **precise matching** is required
		- Inference engine cannot cope with noisy or incomplete data
- Neural expert system
	- User trained neural network in place of knowledge base
	- Input data does not have to precisely match the data that was used in network training
	- Ability is called **approximate reasoning**

### Rule extraction

- Neurons in the network are connected by links
	- Each has a numerical weight attached to it
- Weights in a trained neural network determine strength/importance of associated neuron inputs

### Neural knowledge base

- If we set each input of the input layer to either
	- `+1 (true)`
	- `-1 (false)`
	- `0 (unknown)`
- We can give a semantic interpretation for the activation of any output neuron

#### Neural knowledge base example

![neural knowledge base](http://snag.gy/f8kWe.jpg)

- If the object has
	- Wings `+1`
	- Beak `+1`
	- Feathers `+1`
- But does not have
	- Engine `-1`
- Then we can conclude the object is a Bird `+1`:

![bird neural rule 1](http://snag.gy/NFKLp.jpg)

- Conclude that object is not a Plane:

![plane neural rule 2](http://snag.gy/WRfLG.jpg)

- Conclude that object is not a Glider:

![glider neural rule 3](http://snag.gy/IMSHn.jpg)

- By attaching corresponding questions to each input neuron
- We can enable the system to prompt the user for initial values of the input variables
- Neuron Wings
	- Does object have wings?
- Neuron Tail
	- Does object have tail?
- Neuron Beak
	- Does object have beak?
- Neuron Feathers
	- Does object have feathers?
- Neuron Engine
	- Does object have engine?

### Inference

- An inference can be made if the known net weighted input to a neuron is greater than the sums of the absolute values of the weights of the unknown inputs:

![inference known vs. unknown](http://snag.gy/bv0xE.jpg)

- Where
	- i &isin; known
	- j &notin; known
	- n is number of neuron inputs

#### Inference example

##### Enter initial value for input Feathers

```
Input: +1

KNOWN = 1 * 2.8 = 2.8
UNKNOWN = (-0.8) + (-0.2) + (2.2) + (-1.1) = 4.3
KNOWN < UNKNOWN
```

##### Enter initial value for input Beak

```
Input: +1

KNOWN = 1 * 2.8 + 1 * 2.2 = 5.0
UNKNOWN = (-0.8) + (-0.2) + (-1.1) = 2.1
KNOWN > UNKNOWN
```

##### Conclusion

```
BIRD = TRUE
```

### Example of multi layered knowledge base

![multi layered knowledge base](http://snag.gy/cmDdb.jpg)

## Neuro-fuzzy systems

- Fuzzy logic and neural networks are natural complimentary tools in building intelligent systems
- Neural networks
	- Low level computational structures
	- Perform well when dealing with raw data
	- Can learn
	- Opaque to user
- Fuzzy logic
	- Deals with reasoning on higher level
	- Using linguistic information acquired from domain experts
	- Lack ability to learn
		- Cannot adjust to new environment
- Integrated neuro-fuzzy systems
	- Combine abilities of
		- Neural network
			- Parallel computation
			- Learning abilities
		- Fuzzy system
			- Human like knowledge representation
			- Explanation abilities
	- As a result
		- Neural networks become more transparent
		- Fuzzy systems become capable of learning
- Neuro-fuzzy system is a
	- Neural network which is functionally equivalent to a fuzzy inference model
	- Can be trained to develop IF-THEN fuzzy rules
	- Determine membership functions for input/output variables of the system
	- Expert knowledge can be incorporated into the structure
	- Connectionist structure avoids fuzzy inference
		- Which entails substantial computational burden
- Neuro-fuzzy system structure
	- Similar to multi layered neural network
	- In general
		- Has input/output layers
		- Three hidden layers representing
			- Membership functions
			- Fuzzy rules

### Neuro-fuzzy system example

![neuro-fuzzy system](http://snag.gy/iPpgX.jpg)

- Each layer is associated with a particular step in the fuzzy inference process

#### Layer 1

- Input layer
- Each neuron in this layer transmits external crisp signals directl to the next layer
- That is:

![layer 1](http://snag.gy/F2NTI.jpg)

#### Layer 2

- Fuzzification layer
- Neurons in this layer represent fuzzy sets used in the antecedents of fuzzy rules
- A fuzzification neuron receives a crisp input
- Determines degree to which this input belongs to the neuron's fuzzy set

##### Triangle activation function

- The activation function of a membership neuron is set to the function that specifies the neuron's fuzzy set
- We use triangle sets
	- Therefore, activation functions for neurons in Layer 2 are set to
		- **Triangle membership functions**
- A triangle membership function can be specified by two parameters `a, b` as follows:

![triangle membership function](http://snag.gy/Zo5El.jpg)

- Triangle activation functions:

![triangle activation functions](http://snag.gy/R2xBP.jpg)

#### Layer 3

- Fuzzy rule layer
- Each neuron corresponds to a single fuzzy rule
- Receives input from fuzzification neurons
	- Representing fuzzy sets in rule antecedents
- Example
	- Neuron `R1`
		- Corresponds to Rule 1
	- Receives inputs from neurons
		- `A1`
		- `B1`
- In a neuro-fuzzy system
	- Intersection can be implemented by **product operator**
	- Output of neuron `i` in Layer 3 is obtained as:

![output of neuron i in layer 3](http://snag.gy/aJ9mq.jpg)

#### Layer 4

- Output membership layer
- Each neuron represents fuzzy sets used in consequent of fuzzy rules
- An output membership neuron combines all its inputs by using the fuzzy operation **union**
- The operation can be implemented by the **probabilistic OR**
- That is:

![probabilistic OR](http://snag.gy/aDM2X.jpg)

- The value of &mu;<sub>C1</sub> represents the integrated firing strength of fuzzy rule neurons `R3` and `R6`


#### Layer 5

- Defuzzification layer
- Each neuron represents a single output of the neuro-fuzzy system
- Takes output fuzzy sets clipped by respective integrated firing strengths
	- Combines them into a single fuzzy set
- Neuro-fuzzy systems can apply standard defuzzification methods
	- Including centroid technique
- This example uses **sum-product composition** method

##### Sum-product composition

- Calculates crisp output as the weighted average of the centroids of all output membership functions
- Example
	- The weighted average of the centroids of the clipped fuzzy sets `C1` and `C2` is calculated as:

![sum-product composition](http://snag.gy/8YcDD.jpg)

### How does a neuro-fuzzy system learn

- Is essentially a multi layer neural network
	- Can apply standard learning algorithms developed for neural networks
		- Including back propagation algorithm
- When a training input/output example is presented to the system
	- Back propagation algorithm computes the system output
	- Compares it with desired output of the training example
	- The error is propagated backwards through the network from the output layer to the input layer
	- The neuron activation functions are modified as the error is propagated
	- To determine necessary modifications
		- Back propagation algorithm differentiates the activation functions of the neurons

#### Learning example

##### Training patterns

![training patterns](http://snag.gy/NQfzY.jpg)

##### Five-rule neuro-fuzzy system

- The data set is used for training the five-rule neuro-fuzzy system shown below

![five-rule neuro-fuzzy system](http://snag.gy/i1pbO.jpg)

- Suppose that fuzzy IF-THEN rules incorporated into the system structure are supplied by a domain expert
	- Prior or existing knowledge can dramatically expedite the system training
- If quality of training data is poor
	- Expert knowledge may be the only way to come to a solution at all
	- However
		- Experts do occasionally make mistakes
		- Some rules used in a neuro-fuzzy system may be false or redundant
	- Therefore
		- Neuro-fuzzy system should also be capable of identifying bad rules
- Given the input/output linguistic values
	- Neuro-fuzzy system can automatically generate a complete set of fuzzy IF-THEN rules
- Let us create the system for the XOR example
	- This system consists of 2<sup>2</sup> * 2 = 8 rules
	- Because the expert knowledge is not embodied in the system this time
		- We set all initial weights between Layer 3 and Layer 4 to `0.5`
- After training
	- We can eliminate all rules whose certainty factors are less than some sufficiently small number
		- Say `0.1`
	- As a result
		- We obtain the same set of four fuzzy IF-THEN rules that represent the XOR operation

##### Eight-rule neuro-fuzzy system

![eight-rule neuro-fuzzy system](http://snag.gy/lnTMa.jpg)

### Neuro-fuzzy systems summary

- Combination of fuzzy logic/neural networks constitutes a powerful means for designing intelligent systems
- Domain knowledge can be put into a neuro-fuzzy system by human experts in the form of
	- Linguistic variables
	- Fuzzy rules
- When a representative set of examples is available
	- A neuro-fuzzy system can automatically transform it into a robust set of fuzzy IF-THEN rules
	- Thereby reduce dependence on expert knowledge when building intelligent systems

## Adaptive neuro-fuzzy inference system (ANFIS)

- The Sugeno fuzzy model was proposed for generating fuzzy rules from a given input/output data set
- A typical Sugeno fuzzy rule is expressed in the following form:

![sugeno fuzzy rule](http://snag.gy/r7sXk.jpg)

- When `y` is a constant
	- We obtain a **zero order Sugeno fuzzy model**
	- In which the consequent of a rule is specified by a singleton
- When `y` is a first order polynomial:

![first order polynomial](http://snag.gy/lHEFT.jpg)

- We obtain a **first order Sugeno fuzzy model**

![adaptive neuro-fuzzy inference system](http://snag.gy/kjLLc.jpg)

### Layer 1

- Input layer
- Neurons in this layer pass external crisp signals to Layer 2

### Layer 2

- Fuzzification layer
- Neurons perform fuzzification
- In Jang's model
	- Fuzzification neurons have a **bell activation function**

### Layer 3

- Rule layer
- Each neuron corresponds to a single Sugeno type fuzzy rule
- A neuron receives inputs from the respective fuzzification neurons
	- Calculates the firing strength of the rule it represents
- In an ANFIS
	- The conjunction of the rule antecedents is evaluated by the operator **product**
- Thus
	- The output of neuron `i` in Layer 3 is obtained as:

![Layer 3 output](http://snag.gy/Kc05t.jpg)

- Where the value of &mu;<sub>1</sub> represents the firing strength
	- Or the truth value
		- Of Rule 1 in this case

### Layer 4

- Normalization layer
- Each neuron receives inputs from all neurons in the rule layer
	- Calculates the **normalized firing strength** of a given rule
- Normalized firing strength is the ratio of the firing strength of a given rule to the sum of firing strength of all rules
- It represents the contribution of a given rule to the final result
- Thus
	- The output of neuron `i` in Layer 4 is determined as:

![Layer 4 output](http://snag.gy/bUdvZ.jpg)

### Layer 5

- Defuzzification layer
- Each neuron is connected to respective normalization neuron
	- Also receives initial inputs
		- x<sub>1</sub> and x<sub>2</sub>
- A defuzzification neuron calculates the weighted consequent value of a given rule as:

![weighted consequent value](http://snag.gy/4IQWW.jpg)

- Where
	- For defuzzification neuron `i` in Layer 5
		- x is the input
		- y is the output
	- The set of consequent parameters of rule `i`
		- k<sub>i0</sub>
		- k<sub>i1</sub>
		- k<sub>i2</sub>

### Layer 6

- A single **summation neuron**
- This neuron calculates the sum of outputs of all defuzzification neurons
- Produces the overall ANFIS output, `y`

![layer 6 summation neuron](http://snag.gy/bRwiF.jpg)

### ANFIS without prior knowledge of rule consequent parameters

- Can ANFIS deal with problems where we do not have any prior knowledge of the rule consequent parameters?
	- It is not necessary to have any prior knowledge of rule consequent parameters
	- An ANFIS learns these parameters and tunes membership functions

### Learning in the ANFIS model

- An ANFIS uses hybrid learning algorithm
	- Combines
		- **Least squares estimator**
		- **Gradient descent method**
- In ANFIS training algorithm
	- Each epoch is composed from a
		- Forward pass
		- Backward pass
	- Forward pass
		- A training set of input patterns (input vector) is presented to the ANFIS
		- Neuron outputs are calculated on the layer-by-layer basis
		- Rule consequent parameters are identified
- The rule consequent parameters are identified by the **least squares estimator**
	- In the Sugeno style fuzzy inference
		- An output `y` is a linear function
		- Thus
			- Given the values of
				- Membership parameters
				- Training set of `P` input/output patterns
			- We can form `P` linear equations in terms of the consequent parameters as:

![P linear equations](http://snag.gy/QAmoe.jpg)

- In the matrix notation we have:

>y<sub>d</sub> = Ak  

- Where y<sub>d</sub> is a (P * 1) desired output vector:

![matrix notation](http://snag.gy/gH8Jv.jpg)

- And k is an n(1 + m) * 1 vector of unknown consequent parameters:

![k vector of unknown consequent parameters](http://snag.gy/6neTM.jpg)

- As soon as the rule consequent parameters are established
	- We compute an actual network output vector `y`
	- And determine the error vector `e`

> e = y<sub>d</sub> - y

- In the backward pass
	- The back propagation algorithm is applied
	- The error signals are propagated back
	- And the antecedent parameters are updated according to the chain rule

#### Optimization of parameters

- In the ANFIS training algorithm suggested by Jang
	- Both antecedent parameters and consequent parameters are optimised
- In the forward pass
	- Consequent parameters are adjusted
	- While antecedent parameters remain fixed
- In the backward pass
	- The antecedent parameters are tuned
	- While consequent parameters are kept fixed

### Function approximation using the ANFIS model

- In this example
	- An ANFIS is used to follow a trajectory of the non linear function defined by the equation:

![follow trajectory of non linear function](http://snag.gy/RVz1A.jpg)

- First we choose an appropriate architecture for the ANFIS
	- Must have two inputs
		- `x1`
		- `x2`
	- One output
		- `y`
- Thus in our example
	- The ANFIS is defined by four rules
	- And has the structure below:

![ANFIS model with four rules](http://snag.gy/PWeZG.jpg)

#### Training

- The ANFIS training data includes 101 training samples
	- They are represented by a 101 * 3 matrix

>matrix[x1 x2 y<sub>d</sub>]

- Where
	- x1 and x2 are input vectors
	- y<sub>d</sub> is a desired output vector
- The first input vector x1
	- Starts at 0
	- Increments by 0.1
	- Ends at 10
- The second input vector x2
	- Is created by taking sin from each element of vector x1
	- With elements of the desired output vector y<sub>d</sub>
	- Determined by the function equation

#### Two membership function assigned to each input

##### One epoch

![one epoch](http://snag.gy/W3S6s.jpg)

##### 100 epochs

![100 epochs](http://snag.gy/RXfSe.jpg)

#### Improving the result

- We can achieve some improvement with more epochs
- But much better results are obtained when we assign three membership functions to each input variable
- In this case, the ANFIS model will have nine rules
	- As shown in the figure below

##### ANFIS model with nine rules

![ANFIS model with nine rules](http://snag.gy/xW1kT.jpg)

#### Three membership function assigned to each input

##### One epoch

![one epoch](http://snag.gy/o3fBm.jpg)

##### 100 epochs

![100 epochs](http://snag.gy/4RJ7a.jpg)

#### Initial and final membership functions of the ANFIS

![initial and final membership functions of the ANFIS](http://snag.gy/dX0jg.jpg)
