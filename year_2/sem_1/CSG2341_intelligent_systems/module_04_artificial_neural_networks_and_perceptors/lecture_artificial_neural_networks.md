# Artificial neural networks

## Overview

- Introduction
- Neuron as a simple computing element
- The perceptron
- Multilayer neural networks
- Accelerated learning in multilayer neural networks
- Summary

## Introduction

- Machine learning involves adaptive mechanisms that enable computers to learn from
	- Experience
	- Example
	- Analogy
	- Learning capabilities can improve the performance of an intelligent system over time
	- Most popular approaches to machine learning are
		- Artificial neural networks
		- Genetic algorithms
	- This lecture is dedicated to artificial neural networks
- A neural network can be defined as a model of reasoning based on the human brain
	- The brain consists of a densely interconnected set of nerve cells, or basic information processing units called **neurons**
- The human brain incorporates nearly 10 billion neurons and 60 trillion connections between them called **synapses**
	- By using multiple neurons simultaneously, the brain can perform its functions much faster than the fastest computers in existence today
- Each neuron has a very simple structure
	- But an army of such elements constitutes a tremendous processing power
- A neuron consists of
	- Cell body
		- **Soma**
	- A number of fibers
		- **Dendrites**
	- Single long fiber
		- **Axon**

### Biological neural network

![biological neural network](http://snag.gy/C4Sc7.jpg)

- Our brain can be considered as a highly complex, non linear and parallel information processing system
- Information is stored and processed in a neural network simultaneously throughout the whole network, rather than at specific locations
	- In other words, in neural networks, both data and its processing are **global** rather than local
- Learning is a fundamental and essential characteristic of biological neural networks
	- The ease with which they can learn led to attempts to emulate a biological neural network in a computer

#### Architecture of a typical artificial neural network

![architecture of a typical artificial neural network](http://snag.gy/3Il8J.jpg)

#### Analogy between biological and artificial neural networks

![analogy between biological and artificial neural networks](http://snag.gy/Qd6z4.jpg)

## Neuron as a simple computing element

![diagram of a neuron](http://snag.gy/Dz0TE.jpg)

- The neuron computes the **weighted sum of the input signals** and compares the result with a **threshold value**, &theta;
	- If the net input is less than the threshold, the neuron output is `-1`
	- If the net input is greater than or equal to the threshold, the neuron becomes activated and its output attains a value `+1`
- The neuron uses the following transfer or **activation function:**
	- This type of activation function is called a **sign function**

![activation function](http://snag.gy/EEV3F.jpg)

### Activation functions of a neuron

![activation functions of a neuron](http://snag.gy/zmUMM.jpg)

### Can a single neuron learn a task?

- In 1958, Frank Rosenblatt introduced a training algorithm that provided the first procedure for training a simple ANN
	- A **perceptron**
- The perceptron is the simplest form of a neural network
	- It consists of a single neuron with **adjustable** synaptic weights and a **hard limiter**

### Single layer, two input perceptron

![single layer, two input pereceptron](http://snag.gy/yRqCn.jpg)

## The perceptron

- The operation of Rosenblatt's perceptron is based on the **McCulloch and Pitts neuron model**
	- The model consists of a linear combiner followed by a hard limiter
- The weighted sum of the inputs is applied to the hard limiter
	- If input is positive
		- Output is `+1`
	- If input is negative
		- Output is `-1`
- The aim of the perceptron is to classify inputs, x<sub>1</sub>, x<sub>2</sub>, ..., x<sub>n</sub>, into one of two classes
	- ie. A<sub>1</sub> and A<sub>2</sub>
- In the case of an elementary perceptron, the n-dimensional space is divided by a **hyperplane** into two decision regions
	- The hyperplane is defined by the **linearly separable function:**

![linearly separable function](http://snag.gy/TKeNS.jpg)

### Linear separability in the perceptrons

![linear separability in the perceptrons](http://snag.gy/G9mHc.jpg)

### How does the perceptron learn its classification tasks?

- This is done by making small adjustments in the weights to reduce the difference between the actual and desired outputs of the perceptron
	- The initial weights are randomly assigned
		- Usually in the range `[-0.5, 0.5]`
	- Then updated to obtain the output consisten with the training examples
- If at iteration `p`, the actual output is `Y(p)` and the desired output is `Y_d(p)`, then the error is given by:

![error given by](http://snag.gy/PrJNB.jpg)

- Iteration `p` here refers to the `p`th training example presented to the perceptron
- If the error, `e(p)`, is positive
	- We need to increase perceptron output `Y(p)`
- If the error, `e(p)`, is negative
	- We need to decrease `Y(p)`

### The perceptron learning rule

![perceptron learning rule](http://snag.gy/DfbqC.jpg)

- &alpha; is the **learning rate**
	- A positive constant less than unity
- The perceptron learning rule was first proposed by Rosenblatt in 1960
	- Using this rule we can derive the perceptron training algorithm for classification tasks

### Perceptron's training algorithm

#### Step 1: Initialisation

- Set initial weights w<sub>1</sub>, w<sub>2</sub>, w<sub>3</sub>, ..., w<sub>n</sub> and threshold &theta; to random numbers in the range `[-0.5, 0.5]`
- If the error e(p) is positive
	- Increase perceptron output Y(p)
- If the error e(p) is negative
	- Decrease perceptron output Y(p)

#### Step 2: Activation

- Activate the perceptron by applying
	- Inputs
		- x<sub>1</sub>(p), x<sub>2</sub>(p), x<sub>3</sub>(p), ..., x<sub>n</sub>(p)
	- Desired output
		- Y<sub>d</sub>(p)
- Calculate the actual output at iteration p = 1:
	- Where n is the number of perceptron inputs
	- Step is a step activation function

![step 2 activation](http://snag.gy/qTNgX.jpg)

#### Step 3: Weight training

- Update the weights of the perceptron
	- Where &Delta;w<sub>i</sub>(p) is the weight correction at iteration p

![weights of the perceptron](http://snag.gy/SSWI0.jpg)

- The weight correction is computed by the **delta rule:**

![delta rule](http://snag.gy/nYB0c.jpg)

#### Step 4: Iteration

- Increase iteration p by one
- Go back to Step 2 and repeat the process until convergence

### Example of perceptron learning: Logical operation AND

![logical operation AND](http://snag.gy/qWKPF.jpg)

### 2D plots of basic logical operations

- The perceptron can learn the operations AND, and OR
	- But not **exclusive OR**

![2d plot logical operations](http://snag.gy/1zcFr.jpg)

## Multilayer neural networks

- A multilayer perceptron is a feedforward neural network with one or more hidden layers
- The network consists of
	- An **input layer** which is the of source neurons
	- At least one middle or **hidden layer** of computational neurons
	- An **output layer** of computational neurons
- The input signals are propagated in a forward direction on a layer-by-layer basis

### Multilayer perceptron with two hidden layers

![two hidden layers](http://snag.gy/lYM2q.jpg)

### What does the middle layer hide?

- A hidden layer **hides** its desired output
	- Neurons in the hidden layer cannot be observed through the input/output behaviour of the network
	- There is no obvious ways to know what the desired output of the hidden layer should be
- Commercial ANNs incorporate three and sometimes four layers
	- Including one or two hidden layers
	- Each layer can contain from 10 to 1000 neurons
	- Experimental neural networks may have five or even six layers
		- Including three or four hidden layers
		- And utilise millions of neurons

### Back propagation neural network

- Learning in a multilayer network proceeds the same way as for a perceptron
- A training set of input patterns is presented to the network
- The network computes its output pattern
	- If there is an error (a difference between actual and desired output patterns)
		- The weights are adjusted to reduce this error
- In a back propagation neural network
	- The learning algorithm has two phases
- First, a training input pattern is presented to the input layer
	- The network propagates the input pattern from layer to layer until the output pattern is generated by the output layer
- If this pattern is different from the desired output
	- An error is calculated and then propagated backwards through the network from  the output layer to the input layer
	- The weights are modified as the error is propagated

## Three layer back propagation neural network

![three layer back propagation neural network](http://snag.gy/BBdpW.jpg)

### Back propagation training algorithm

#### Step 1: Initialisation

- Set all the weights and threshold levels of the network to random numbers uniformly distributed inside a small range:
	- Where F<sub>i</sub> is the total number of inputs of neuron i in the network
	- The weight initialisation is done on a neuron by neuron basis

![uniform distribution](http://snag.gy/1O1ov.jpg)

#### Step 2: Activation

- Activate the back propagation neural network by applying
	- Inputs
		- x<sub>1</sub>(p), x<sub>2</sub>(p), x<sub>3</sub>(p), ..., x<sub>n</sub>(p)
	- Desired outputs
		- y<sub>d,1</sub>(p), y<sub>d,2</sub>(p), y<sub>d,3</sub>(p), ..., y<sub>d,n</sub>(p)
- Calculate the actual outputs of the neurons in the hidden layer:
	- Where n is the number of inputs of neuron j in the hidden layer
	- sigmoid is the **sigmoid activation function**

![step 2 calculate outputs of neurons j in hidden layer](http://snag.gy/tbU1P.jpg)

- Calculate the actual outputs of the neurons in the output layer:
	- Where m is the number if inputs from neuron k in the output layer

![step 2 calculate outputs of neurons k in output layer](http://snag.gy/cXghG.jpg)

#### Step 3: Weight training

- Update the weights in the back propagation network
	- Propagating backwards the errors associated with output neurons
- Calculate the error gradient for the neurons in the output layer:

![calculate error gradient for neurons in output layer](http://snag.gy/cx07I.jpg)

- Calculate the weight corrections:

![calculate weight corrections](http://snag.gy/RiDgn.jpg)

- Update the weights at the output neurons:

![update weights at the output neurons](http://snag.gy/klfbu.jpg)

- Calculate the error gradient for the neurons in the hidden layer:

![calculate error gradient for neurons in hidden layer](http://snag.gy/mnHaX.jpg)

- Calculate the weight corrections:

![calculate the weight corrections](http://snag.gy/uGL5P.jpg)

- Update the weights at the hidden neurons:

![update weights at the hidden neurons](http://snag.gy/FvKnd.jpg)

#### Step 4: Iteration

- Increase iteration p by one
	- Go back to Step 2 and repeat the process until the selected error criterion is satisfied

### Three layer back propagation example

- As an example, we may consider the three layer back propagation network
	- Suppose that the network is required to perform logical operation **XOR**
	- Recall that a single layer perceptron could not do this operation
	- Now we will apply the three layer net

#### Three layer network for solving XOR operation

![three layer net for solving XOR operation](http://snag.gy/ipVDE.jpg)

- The effect of the threshold applied to a neuron in the hidden or output layer is represented by
	- Its weight, &theta;
	- Connected to a fixed input equal to `-1`
- The initial weights and threshold levels are set randomly as follows:

![random initial weights and threshold](http://snag.gy/q0Fue.jpg)

- We consider a training set where
	- Inputs
		- x<sub>1</sub> and x<sub>2</sub> are equal to 1
	- Desired output
		- y<sub>d,5</sub> is 0
	- The actual outputs of neurons 3 and 4 in the hidden layer are calculated as:

![calculate outputs of neuron 3 and 4 in hidden layer](http://snag.gy/MMvHz.jpg)

- Now the actual output of neuron 5 in the output layer is determined as:

![calculate neuron 5 in output layer](http://snag.gy/FJxph.jpg)

- Thus, the following error is obtained:

![obtained error](http://snag.gy/H0JJr.jpg)

- The next step is weight training
	- To update the weights and threshold levels in our network
		- We propagate the error, e, from the output layer backward to the input layer
- First we calculate the error gradient for neuron 5 in the output layer:

![calculate error gradient for neuron 5 in output layer](http://snag.gy/71IGU.jpg)

- Then we determine the weight corrections
	- Assuming that the learning rate parameter, &alpha; is equal to 0.1:

![calculate weight corrections](http://snag.gy/8gJQ1.jpg)

- Next we calculate the error gradients for neurons 3 and 4 in the hidden layer:

![calculate error gradient for neuron 3 and 4 in hidden layer](http://snag.gy/07wtN.jpg)

- We then determine the weight corrections

![calculate weight corrections](http://snag.gy/8svA2.jpg)

- At last, we update all weights and thresholds:

![update all weights and thresholds](http://snag.gy/KK6XY.jpg)

- The training process is repeated until the sum of squared errors is less than 0.001

#### Learning curve for operation XOR

![learning curve for operation xor](http://snag.gy/sHjw2.jpg)

#### Final results of three layered network learning

![final results of three layered net](http://snag.gy/tmclG.jpg)

#### McCulloch-Pitts model solving XOR

![McCulloch-Pitts model solving XOR](http://snag.gy/Rdiin.jpg)

### Decision boundaries

![decision boundaries](http://snag.gy/RS0J7.jpg)

- (a): Decision boundary constructed by hidden neuron 3
- (b): Decision boundary constructed by hidden neuron 4
- (c): Decision boundaries constructed by the complete three layered network

## Accelerated learning in multilayer neural networks

- A multilayered network learns much faster when the sigmoidal activation function is represented by a **hyperbolic tangent:**
	- Where a and b are constants

![hyperbolic tangent](http://snag.gy/HOc9z.jpg)

- Suitable values for a and be are
	- a = 1.716
	- b = 0.667
- We can also accelerate training by including a **momentum term** in the delta rule:
	- Where &beta; is a positive number (0 &le; &beta; < 1) called the **momentum constant**
		- Typically, the momentum constant is set to 0.95

![momentum turn](http://snag.gy/PxEn8.jpg)

- This equation is called the **generalised delta rule**

### Learning with momentum for operation XOR

![learning with momentum for operation XOR](http://snag.gy/a17dj.jpg)

### Learning with adaptive learning rate

- To accelerate the convergence and yet avoid the danger of instability
	- We can apply two heuristics
- **Heuristic 1:**
	- If the change of the some of squared errors has the same algebraic sign for several consequent epochs
		- Then the learning rate parameter &alpha; should be increased
- **Heuristic 2:**
	- If the algebraic sign of the change of the sum of squared errors alternates for several consequent epochs
		- Then the learning rate parameter &alpha; should be decreased
- Adapting the learning rate requires some changes in the back propagation algorithm
- If the sum of squared errors are the current epoch exceeds the previous value by more than a predefined ratio (typically 1.04)
	- The learning rate parameter is decreased (typically by multiplying by 0.7)
	- New weights and thresholds are calculated
- If the error is less than the previous one
	- The learning rate is increased (typically by multiplying 1.05)

#### Adaptive learning rate

![adaptive learning rate](http://snag.gy/ccULM.jpg)

#### Momentum and adaptive learning rate

![momentum and adaptive learning rate](http://snag.gy/H8guV.jpg)
