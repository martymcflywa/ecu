# Chapter 6: Artificial neural networks

## 6.1 Introduction: How the brain works

### What is machine learning

- Involves adaptive mechanisms that enable computers to learn from
	- Experience
	- Example
	- Analogy
- Learning capabilities can improve the performance of an intelligent system over time
- Machine learning mechanisms form the basis for adaptive systems
- Most popular approaches
	- Artificial neural networks
	- Genetic algorithms

### What is a neural network

- Model of reasoning based on human brain
- Brain consists of densely interconnected set of nerve cells
	- Neurons
		- Basic information processing units
		- 10 billion
	- Synapses
		- Connections between neurons
		- 60 trillion
- By using multiple neurons simultaneously
	- Brain can perform functions faster than fastest computers in existence
- Each neuron has very simple structure
	- But in numbers has tremendous processing power
- Neuron consists of
	- Soma
		- Cell body
	- Dendrites
		- Fibers
		- Branch into a network around the soma
	- Axon
		- Single long fiber
		- Stretches out to the dendrites and somas of other neurons
			- See figure 6.1

![figure 6.1](http://snag.gy/u5LU9.jpg)

- Signals are propagated from one neuron to another
	- By complex electro chemical reactions
- Chemical substances released from synapses cause change in electrical potential of cell body
- When potential reaches threshold
	- An **action potential** is sent down through the axon
		- Electrical pulse
- The pulse spreads out eventually reaching synapses
	- Causing them to decrease/increase their potential
- Neural networks exhibit **plasticity**
- In response to stimulation pattern
	- Neurons also can form new connections with other neurons
- Even entire collections of neurons may sometimes migrate from one place to another
- These mechanisms for the basis for learning in the brain
- Brain
	- Highly complex
	- Non linear
	- Parallel information processing system
	- Information is stored and processed in a neural network simultaneously throughout the whole network
		- Rather than at specific locations
	- Neural networks
		- Data and processing
			- Global rather than local
- Plasticity
	- Connections between neurons leading to the
		- Right answer are strengthened
		- Wrong answer are weakened
	- Neural networks have ability to learn through experience
- Learning
	- Fundamental/essential characteristic of biological neural networks

### How do artificial neural networks model the brain

- ANN consists of a number of simple and highly interconnected processors
	- Neurons
	- Analogous to biological neurons in the brain
- Neurons connected by weighted links
	- Passing signals from one neuron to another
- Each neuron receives a number of input signals through its connections
	- It never produces more than a single output signal
- Output signal is transmitted through neuron's outgoing connection
	- Axon
- Outgoing connection splits into a number of branches that transmit the same signal
	- Signal is not divided among branches
- Outgoing branches terminate at incoming connections of other neurons in network
- See figure 6.2, table 6.1

![figure 6.2](http://snag.gy/fgd9D.jpg)

![table 6.1](http://snag.gy/StBOC.jpg)

### Does neural network know how to adjust weights

- Figure 6.2 shows a typical ANN made up of a hierarchy of layers
	- Neurons in the networks are arranged along these layers
- Neurons connected to external environment are
	- Input/output layer
- Weights are modified to bring the network input/output behavior in line with that of the environment
- Each neuron is an elementary information processing unit
	- It has means of computing its **activation level** given the inputs and numerical weights
- To build an ANN
	- Decide how many neurons are to be used
		- How the neurons are to be connected to form a network
		- Must choose network architecture
	- Decide which learning algorithm to use
	- Train neural network
		- Initialize the weights of the network
		- Update the weights from a set of training examples

## 6.2 The neuron as a single computing element

- Receives several signals from its input links
- Computes new activation level
- Sends it as an output signal through output links
- Input signal can be
	- Raw data
	- Outputs of other neurons
- Output signal can be
	- Final solution
	- Input to another neurons
- Figure 6.3 shows a typical neuron

![figure 6.3](http://snag.gy/p1ZO3.jpg)

### How does the neuron determine its output

- Computes weighted sum of the input signals
- Compares result with threshold value, &theta;
	- If (net input) < (threshold)
		- Neuron output = -1
	- If (net input) >= (threshold)
		- Neuron output = +1
		- Neuron is activated
- Neuron uses following transfer **activation function**

![equation 6.1]()

- Where
	- X = net weighted input to the neuron
	- x<sub>i</sub> = value of input i
	- w<sub>i</sub> = weight of input i
	- n = number of neuron inputs
	- Y = output of neuron
- This type of activation function is called a **sign function**
	- Thus actual output of the neuron with a sign activation function can be represented as

![equation 6.2](http://snag.gy/AGYX9.jpg)

### Other activation functions

- Many activation functions have been tested
	- Only few have found practical applications
- Four common choices in figure 6.4
	- Step
	- Sign
	- Linear
	- Sigmoid

![figure 6.4](http://snag.gy/XiShK.jpg)

- Hard limit functions
	- Step
	- Sign
	- Used in decision making neurons
		- For classification and pattern recognition tasks
- Sigmoid function
	- Transforms input
		- From any value between +/- infinity
		- To a reasonable value in range between 0 and 1
- Linear function
	- Provides output equal to neuron weighted input
	- Neurons with linear function often used for linear approximation

## 6.3 Perceptron

- Simplest form of neural network
- Single neuron
- Adjustable synaptic weights
- Hard limiter
- See figure 6.5
	- Single layer two input perceptron

![figure 6.5](http://snag.gy/mWkU6.jpg)

- Model consists of
	- Linear combiner
	- Hard limiter
- Weighted sum of imputs is applied to hard limiter
	- If input is positive
		- Output = +1
	- If input is negative
		- Output = -1
- Aim
	- Classify inputs into one of two classes
		- ie. A<sub>1</sub> and A<sub>2</sub>
- Thus in case of an elementary perceptron
	- The n-dimensional space is divided by a hyperplane into two decision regions
- Hyperplane defined by **linearly separable** function

![equation 6.3](http://snag.gy/vaUYg.jpg)

- For case of two inputs, x<sub>1</sub> and x<sub>2</sub>
	- The decision boundary takes the form of a straight line shown in bold in figure 6.6(a)
- Point 1
	- Lies above the boundary line
	- Belongs to class A<sub>1</sub>
- Point 2
	- Lines below the boundary line
	- Belongs to class A<sub>2</sub>
- The threshold &theta; can be used to shift the decision boundary line

![figure 6.6](http://snag.gy/sOPYv.jpg)

- With three inputs
	- Hyperplane can still be visualized
	- Figure 6.6(b) shows three dimensions for the three input perceptron
	- The separating plane here is defined by equation:

![3d hyperplane equation](http://snag.gy/XSLDk.jpg)

### How does perceptron learn its classification tasks

- Done by making small adjustments in weights to reduce the difference between actual and desired outputs of the perceptron
- Initial weights are randomly assigned
	- Usually in range -0.5 to 0.5
- Then updated to obtain the output consistent with training examples
- For a perceptron
	- Process of weight updating is simple
- If at iteration p
	- The actual output is Y(p)
	- The desired output is Y<sub>d</sub>(p)
- Then the erorr is given by

![equation 6.4](http://snag.gy/oKinK.jpg)

- Iteration p
	- Refers to the pth training example presented to the perceptron
- If the error, e(p) is positive
	- Need to increase perceptron output Y(p)
- If the error, e(p) is negative
	- Need to decrease perceptron output Y(p)
- Taking into account that each perceptron input contributes x<sub>i</sub>(p) * w<sub>i</sub>(p) to the total input X(p)
	- If input value x<sub>i</sub>(p) is positive
		- An increase in its weight w<sub>i</sub>(p) tends to increase output Y(p)
	- If input value x<sub>i</sub>(p) is negative
		- An increase in its weight w<sub>i</sub>(p) tends to decrease input Y(p)
- Thus the following **perceptron learning rule** can be established

![equation 6.5](http://snag.gy/8q67l.jpg)

- Where
	- &alpha; = learning rate
		- A positive constant less than unity
- Using this rule we can derive the perceptron training algorithm for classification of tasks

### Process

#### Step 1: Initialization

- Set to initial random numbers in range -0.5 to 0.5
	- Weights w<sub>1</sub>, w<sub>2</sub>, ..., w<sub>n</sub>
	- Threshold &theta;

#### Step 2: Activation

- Activate perceptron by applying
	- Inputs x<sub>1</sub>(p), x<sub>2</sub>(p), ..., x<sub>n</sub>(p)
	- Desired output Y<sub>d</sub>(p)
	- Calculate actual output at iteration p = 1

![equation 6.6](http://snag.gy/fkY46.jpg)

- Where
	- n = number of perceptron inputs
	- step = step activation function

#### Step 3: Weight training

- Update weights of the perceptron

![equation 6.7](http://snag.gy/Lp1xg.jpg)

- Where
	- &Delta;w<sub>i</sub>(p) = weight correction at iteration p
- Weight correction is computed by **delta rule**:

![equation 6.8](http://snag.gy/nLcMQ.jpg)

#### Step 4: Iteration

- Increase iteration p + 1
- Go back to step 2
- Repeat process until convergence

### Train a perceptron to perform basic logical operations: AND/OR/XOR

- Table 6.2 shows truth tables for AND/OR/XOR
	- Represents all possible combinations of values for
		- Two values
			- x<sub>1</sub>
			- x<sub>2</sub>
		- Results of operations

![table 6.2](http://snag.gy/SZpww.jpg)

- Perceptron must be trained to classify the input patterns
- First consider AND
	- After completing initialization step
		- Perceptron is activated by the sequence of four input patterns
			- Representing an epoch
	- Perceptron weights are updated after each activation
	- Process is repeated until all weights converge to a uniform set of values
		- Results shown in table 6.3

![table 6.3](http://snag.gy/tKBoe.jpg)

- Similarly, perceptron can learn OR operation
- But cannot learn XOR operation
- Figure 6.7 shows why
	- Represents AND/OR/XOR functions as 2d plots based on values of inputs
	- Function output = 1
		- Black dots
	- Function output = 0
		- White dots

![figure 6.7](http://snag.gy/M40wH.jpg)

- Figures 6.7(a) and (b) can be separated by hyperplane
	- White dots on one side
	- Black dots on the other
- Figure 6.7(c) dots cannot be separated by hyperplane
- Perceptron can only represent a function if there is some line that separates black dots from white ones
	- Such functions are called **linearly separable**
- Therefore perceptron can learn AND/OR
	- Cannot learn XOR

### Why only linearly separable functions

- Directly follows equation 6.1
- Perceptron output Y is 1
	- Only if total weighted input X is >= threshold &theta;
	- Means that entire input space is divided in two along a boundary defined by X = &theta;
- Example
	- A separating line for the operation AND is defined by the equation

![linearly separable 1](http://snag.gy/nQo6i.jpg)

- Substituting with values from table 6.3
	- We obtain one of the possible separating lines as

![linearly separable 2](http://snag.gy/zQ7Fm.jpg)

- Thus the region below the boundary line
	- Where output is 0, is given by

![linearly separable 3](http://snag.gy/xfrE9.jpg)

- And the region above this line
	- Where the output is 1, is given by

![linearly separable 4](http://snag.gy/vDKTQ.jpg)

### Can sigmoidal or linear element improve on hard limiter

- Single layer perceptrons make decisions in the same way
	- Regardless of activation function
- Can only classify linearly separable patterns
	- Whether we use hard limit or soft limit activation function

### How to cope with problems not linearly separable

- Need multilayer neural networks
- Can be overcome by advanced forms of neural networks
	- Multilayer perceptrons trained with back propagation algorithm

## 6.4 Multilayer neural networks

- Feed forward neural network
- One or more hidden layers
- Network consists of
	- Input layer of source neurons
	- At least one middle/hidden layer of computational neurons
	- Output layer of computational neurons
- Input signals
	- Propagated in forward direction
	- Layer by layer basis
- Figure 6.8 shows multilayer perceptron with two hidden layers

![figure 6.8](http://snag.gy/foN3L.jpg)

### Why need hidden layer

- Each layer in has its own specific function
- Input layer accepts input signals from outside world
	- Redistributes signals to all neurons in hidden layer
	- Rarely includes computing neurons
		- Does not process input patterns
- Output layer accepts output signals
	- Stimulus pattern
	- From hidden layer
	- Establishes output pattern of entire network
- Neurons in hidden layer
	- Detect the features
	- Weights of neurons represent features hidden in the input patterns
	- Features are then used by output layer in determining the output pattern
- With one hidden layer
	- Can represent any continuous function of the input signals
- With two hidden layers
	- Even discontinuous functions can be represented

### Why is middle layer called hidden, what does it hide

- Hides its desired output
- Neurons in hidden layer cannot be observed through input/output behavior of network
- No obvious way to know what desired output of hidden layer should be
- Desired output of hidden layer is determined by the layer itself

### Can neural networks include more than two hidden layers

- Commerical ANNs
	- Three/four layers
	- Include one or two hidden layers
- Each layer can contain from 10 to 1000 neurons
- Experimental neural networks may have 5 to 6 layers
	- 3 to 4 hidden layers
	- Millions of neurons
- Most practical applications
	- Three layers
- Each additional layer increases overhead exponentially

### How do multilayer neural networks learn

- Most popular method
	- Back propagation
- Same way as perceptron
- Training set of input patterns presented to network
- Network computes output pattern
- If there is an error
	- Difference between actual and desired output patterns
	- Weights adjusted to reduce error
- Perceptron
	- Only one weight for each input/output
- Multilayer network
	- Many weights
	- Each contributes to more than one output

### How to assess blame for error and divide it among contributing weights

- Back propagation neural network
- Learning algorithm has two phases
	- Training input presented to network input layer
	- Network propagates input pattern from layer to layer until output pattern is generated
	- If pattern is different from desired output
		- Error is calculated
		- Propagated backwards through the network back to input layer
	- Weights modified as error is propagated
- Back propagation determined by
	- Connections between neurons
		- Network's architecture
	- Activation function used by the neurons
	- Learning algorithm that specifies the procedure for adjusting weights
- Typically back propagation network is a multilayer network
	- Three/four layers
	- Layers are fully connected
		- Every neuron in each layer is connected to every other neuron in the adjacent forward layer
- A neuron determines its output similar to perceptron
	- First computes net weighted input

![net weighted input](http://snag.gy/w9ith.jpg)

- Where
	- n = number of inputs
	- &theta; = threshold applied to neuron
- Input value is passed through activation function
- Unlike perceptron
	- Neurons in back propagation network use sigmoid activation function

![sigmoid activation function](http://snag.gy/YvgdM.jpg)

- Derivative of function is easy to compute
	- Guarantees that neuron output is bounded between 0 and 1

### What about the learning law used in back propagation networks

- To derive back propagation learning law
	- Consider three layer network
		- See figure 6.9

![figure 6.9](http://snag.gy/NR25b.jpg)

- Where
	- i = input layer neurons
	- j = hidden layer neurons
	- k = output layer neurons
	- Input signals x<sub>1</sub>, x<sub>2</sub>, ..., x<sub>n</sub> are propagated through network left to right
	- Error signals e<sub>1</sub>, e<sub>2</sub>, ..., e<sub>l</sub> propagated through network right to left
	- w<sub>ij</sub> = weight for the connection between input neuron i and hidden layer neuron j
	- w<sub>jk</sub> = weight between hidden layer neuron j and output neuron k
- To propagate error signals
	- Start at the output layer and work backwards to hidden layer
	- Error signal at the output of neuron k at iteration p is defined by

![equation 6.10](http://snag.gy/a5Av9.jpg)

- Where
	- y<sub>d,k</sub>(p) = desired output of neuron k at iteration p
- Output neuron k is supplied with a desired output of its own
	- Hence we may use a straight forward procedure to update weight w<sub>jk</sub>
- The rule for updating weights at the output layer is similar to perceptron learning rule
	- See equation 6.7

![equation 6.11](http://snag.gy/F5NVp.jpg)

- Where
	- &Delta;w<sub>jk</sub>(p) = weight correction
- When we determine the weight correction for the perceptron
	- We used input signal x<sub>i</sub>
- But in multilayer networks
	- Inputs of the neurons in the output layer are different from the inputs of the neurons in the input layer

### What input signal can be used instead of x<sub>i</sub>

- Use the output of hidden layer neuron j, y<sub>j</sub> instead of input x<sub>i</sub>
- The weight correction in the multilayer network is computed by

![equation 6.12](http://snag.gy/KJTwO.jpg)

- Where
	- &delta;<sub>k</sub>(p) is the error gradient at output neuron k at iteration p

### What is the error gradient

- Determined as the derivative of (activation function) * (error at neuron output)
- Thus, for output neuron k, we have:

![equation 6.13]()

- Where
	- y<sub>k</sub>(p) = output of neuron k at iteration p
	- X<sub>k</sub>(p) = net weighted input to neuron k at same iteration
- For a sigmoid activation function, equation 6.13 can be represented as

![sigmoid activation function](http://snag.gy/QNjfz.jpg)

- Thus we obtain:

![equation 6.14](http://snag.gy/8MUQI.jpg)

### How to determine weight correction for neuron in hidden layer

- To calculate weight correction for hidden layer
	- We can apply the same equation for output layer

![equation 6.15](http://snag.gy/hGv2b.jpg)

- Where
	- &delta;<sub>j</sub>(p) represents the error gradient at hidden layer neuron j

![error gradient neuron j](http://snag.gy/qsAXh.jpg)

- Where
	- l = number of neurons in the output layer

![where](http://snag.gy/9UlCU.jpg)

- Where
	- n = number of neurons in input layer
- Now we can derive the back propagation training algorithm

### Step 1: Initialization

- Set all weights/threshold levels of network to random numbers uniformly distributed inside a small range

![step 1](http://snag.gy/cUzH2.jpg)

- Where
	- F<sub>i</sub> = total number of inputs of neuron i in network
- Weight initialization is done on a neuron by neuron basis

### Step 2: Activation

- Apply inputs
	- x<sub>1</sub>(p), x<sub>2</sub>(p), ..., x<sub>n</sub>(p)
- Apply desired outputs
	- y<sub>d,1</sub>(p), y<sub>d,2</sub>(p), ..., y<sub>d,n</sub>(p)
- Calculate actual outputs of the hidden layer neurons

![calculate actual outputs of hidden layer neurons](http://snag.gy/4RanJ.jpg)

- Where
	- n = number of inputs of hidden layer neuron j
	- sigmoid = sigmoid activation function
- Calculate actual outputs of output layer neurons

![calculate actual outputs of output layer neurons](http://snag.gy/1fPCP.jpg)

- Where
	- m = number of inputs of neuron k in output layer

### Step 3: Weight training

- Update the weights in the back propagation network
	- Propagating backwards the errors associated with the output neurons

![step 3](http://snag.gy/EkKsL.jpg)

### Step 4: Iteration

- Increase iteration p by one
- Go back to step 2
- Repeat process until selected error criteria is satisfied

### Example

- Consider three layer back propagation network
	- See figure 6.10
- Suppose network is required to perform logical operation XOR
	- Single layer perceptron cannot do operation
	- Will apply in three layer network

![figure 6.10](http://snag.gy/Gq9my.jpg)

- Neuron 1 accepts input x<sub>1</sub>
- Neuron 2 accepts input x<sub>2</sub>
- Redistributes inputs to neurons in the hidden layer without processing

![inputs](http://snag.gy/gt5fd.jpg)

- The effect of the threshold applied to a neuron in the hidden or output layer is represented by its weight, &delta;, connected to a fixed input equal to -1
- The initial weights and threshold levels are set randomly as follows

![initial random weights/thresholds](http://snag.gy/hCpC8.jpg)

- Consider a training set where
	- Inputs x<sub>1</sub> and x<sub>2</sub> = 1
	- Desired output y<sub>d,5</sub> = 0
- The actual outputs of neurons 3 and 4 in hidden layer are calculated as

![actual outputs neurons 3 and 4](http://snag.gy/NWQ7J.jpg)

- Now the actual output of neuron 5 in the output layer is determined as

![actual output neuron 5](http://snag.gy/KQSqI.jpg)

- Thus the following error is obtained

![error obtained](http://snag.gy/hcb5c.jpg)

- The next step is weight training
- To update the weights and threshold levels in the network
	- Propagate error, e, from output layer backward to input layer
- First calculate the error gradient from neuron 5 in the output layer

![error gradient](http://snag.gy/I3bBW.jpg)

- Then determine the weight corrections assuming that the learning rate parameter, &alpha;, is equal to 0.1

![learning rate parameter](http://snag.gy/DN1IF.jpg)

- Next calculate error gradients for neurons 3 and 4 in hidden layer

![error gradient neurons 3 and 4](http://snag.gy/Wr0PJ.jpg)

- Then determine weight corrections

![weight corrections](http://snag.gy/zrlZq.jpg)

- Lastly update weights and threshold levels in network

![update weights thresholds in network](http://snag.gy/HtMVa.jpg)

- Training process is repeated until sum of squared errors is less than 0.001

### Why do we need to sum squared errors

- Useful indicator of network's performance
- Back propagation training algorithm attempts to minimize this criteria
- When value of the sum of squared errors in an entire pass through all training sets/epoch is sufficiently small
	- Network is considered to have **converged**
- In example above
	- Sufficiently small sum of squared errors is defined as less than 0.001
- Figure 6.11 represents a learning curve
	- The sum of squared errors plotted vs. the number of epochs used in training
	- Learning curve shows how fast a network is learning

![figure 6.11](http://snag.gy/CyjjQ.jpg)

- It took
	- 224 epochs
	- 896 iterations
- To train network to perform XOR operation
- The following set of final weights and threshold levels satisfied the chosen error criteria

![final weights/thresholds](http://snag.gy/wHL7L.jpg)

- The network has solved the problem
	- Can now test the network by presenting all training sets and calculating the network's output
	- See table 6.4 for results

![table 6.4](http://snag.gy/SSHKH.jpg)

### Since initial weights and thresholds set randomly, will same network find different solutions?

- Network obtains different weights and threshold values when it starts from different initial conditions
- However, it6 will always solve the problem
	- Although using a different number of iterations
- For instance
	- When the network was trained again
	- We obtain the following solution

![solution alt](http://snag.gy/mY0bO.jpg)

### Can we now draw decision boundaries constructed by multilayer network for XOR?

- May be difficult to draw decision boundaries constructed by neurons with sigmoid function
- Can represent each neuron in the hidden and output layers by a McCulloch and Pitts model
	- Using a sign function
- Network in figure 6.12 is also trained to perform XOR
	- Positions of the decision boundaries constructed by neurons 3 and 4 in hidden layer are shown in figure 6.13(a) and 6.13(b)
	- Neuron 5 in output layer performs a linear combination of the decision boundaries formed by the two hidden neurons
		- See figure 6.13(c)
	- The network in figure 6.12 separates black and white dots
		- Solves XOR problem

![figure 6.12](http://snag.gy/jY2mD.jpg)

![figure 6.13](http://snag.gy/RlMoK.jpg)

### Is back propagation learning a good method for machine learning

- Not immune to problems
- Does not seem to function in the biological world
	- Biological neurons do not work backward to adjust strengths of interconnections or synapses
	- Back propagation learning cannot be viewed as a process that emulates brain like learning
- Calculations are extensive
	- Training is slow
- Back propagation rarely used in practical applications

## 6.5 Accelerated learning in multilayer neural networks

- Multilayer network learns faster when sigmoidal activation function is represented by a **hyperbolic tangent**

![equation 6.16](http://snag.gy/7eD9G.jpg)

- Where
	- a and b are constants
- Suitable values for a and b are
	- a = 1.716
	- b = 0.667
- Can also accelerate training by including a **momentum term** in the delta rule of equation 6.12

![equation 6.17](http://snag.gy/vys8H.jpg)

- Where
	- &beta; = positive number
		- &beta; <= &beta; < 1
		- Called **momentum constant**
	- Typically
		- &beta; = 0.95
- Equation 6.178 is called the **generalised delta rule**
	- In a special case
		- When &beta; = 0
			- We obtain the delta rule of equation 6.12

### Why do we need the momentum constant

- Has a stabilizing effect on training
- Tends to accelerate descent in the steady downhill direction
	- Slow down process when learning surface exhibits peaks and valleys
- Figure 6.14 represents learning with momentum for XOR operation
- A comparison with pure back propagation algorithm shows that we reduced number of epochs from 224 to 126


![figure 6.14](http://snag.gy/u5PoC.jpg)

### Can learning parameter &alpha; be increased to speed up training

- One of the most effective means to accelerate the convergence of back propagation learning is to adjust the learning rate parameter during training
- The small learning rate parameter &alpha; causes small changes to the weights in the network from one iteration to the next
	- Leads to the smooth training curve
- If learning rate parameter &alpha; is made larger to speed up the training process
	- Resulting larger changes in weights may cause instability
	- Network may become oscillatory
- To accelerate the convergence and avoid instability
	- Can apply two heuristics
- Heuristic 1
	- If the change of the sum of squared errors has the same algebraic sign for several consequent epochs
		- Learning rate parameter &alpha; should be increased
- Heuristic 2
	- If the algebraic sign of the change of the sum of squared errors alternates for several consequent epochs
		- Learning rate parameter &alpha; should be decreased
- Adapting the learning rate requires changes in the back propagation algorithm
	- Network outputs and errors are calculated from the initial learning rate parameter
		- If the sum of squared errors at the current epoch exceeds the previous value by more than a predefined ratio
			- Typically 1.04
			- The learning rate parameter is decreased
				- Typically by multiplying by 0.7
			- New weights and thresholds are calculated
		- If error is less than the previous one
			- Learning rate is increased
				- Typically by multiplying by 1.05
- Figure 6.15 represents an example of back propagation training with adaptive learning rate
	- Demonstrates that adapting the learning rate can decrease the number of iterations

![figure 6.15](http://snag.gy/YyYI3.jpg)

- Learning rate adaptation can be used together with learning with momentum
	- Figure 6.16 shows the benefits of applying simultaneously both techniques

![figure 6.16](http://snag.gy/KwmEe.jpg)

- The use of momentum and adaptive learning rate significantly improves performance of the multi layer back propagation neural network and minimizes the chance that network can become oscillatory
- Neural networks were designed on an analogy with the brain
	- The brain's memory works by association
	- Example
		- We can recognize a familiar face even in an unfamiliar environment within 100-200ms
		- Can recall complete sensory experience
		- Brain routinely associates one thing with another

### Can a neural network simulate associative characteristics of the human memory

- Multilayer neural networks trained with back propagation algorithm are used for pattern recognition problems
- But not intrinsically intelligent
- To emulate human memory's associative characteristics
	- Need a different type of network
		- **Recurrent neural network**
