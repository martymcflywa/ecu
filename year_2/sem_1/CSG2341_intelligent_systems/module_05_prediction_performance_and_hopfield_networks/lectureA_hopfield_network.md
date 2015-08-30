# The Hopfield network

- Neural networks were designed on analogy with the brain
	- The brain's memory however, works by association
	- For example we can recognise a familiar face even in an unfamiliar environment within 100-200ms
	- We can also recall a complete sensory experience, including sounds and scenes when we hear only a few bars of music
	- The brain routinely associates one thing with another
- Multilayer neural networks trained with **back propagation** algorithms are used for pattern recognition problems
	- However, to emulate the human memory's associative characteristics we need a different type of network
		- A **recurrent neural network**
- A recurrent neural network has feedback loops from its outputs to its inputs
	- The presence of such loops has a profound impact on the learning capability of the network
- The stability of recurrent networks intrigued several researchers in 1960s and 70s
	- None was able to predict which network would be stable
	- Some researchers were pessimistic about finding a solution at all
	- The problem was solved in 1982 when **John Hopfield** formulated the physical principle of storing information in a dynamically stable network

## Single layer n-neuron Hopfield network

![single layer n-neuron hopfield network](http://snag.gy/RRTxN.jpg)

- The Hopfield network uses McCulloch and Pitts neurons with the **sign activation function** as its computing element

![sign activation function](http://snag.gy/3wAFV.jpg)

- The current state of the Hopfield network is determined by the current outputs of all neurons:

>y<sub>1</sub>, y<sub>2</sub>, ..., y<sub>n</sub>

- Thus, for a single layer n-neuron network, the state can be defined by the **state vector** as:

![state vector](http://snag.gy/ZfHgG.jpg)

- Where
	- M = number of states to be memories by the network
	- Y<sub>m</sub> is the n-dimensional binary vector
	- I is n\`n identity matrix
	- T denotes matrix transposition

## Possible states for the three-neuron Hopfield network

![three-neuron hopfield network states](http://snag.gy/yVqiX.jpg)

- The stable state-vertex is determined by the
	- Weight matrix W
	- Current input vector X
	- Threshold matrix &theta;
- If the input vector is partially incorrect or incomplete
	- The initial state will converge into the stable state-vertex after a few iterations
- Suppose that our network is required to memorise two opposite states
	- (1,1,1) and (-1,-1,-1), thus:

![3d vector](http://snag.gy/YtmKs.jpg)

- Or:

![3d vector transposed](http://snag.gy/dLSCN.jpg)

- Where
	- Y<sub>1</sub> and Y<sub>2</sub> are the 3d vectors
- The 3\`3 identity matrix I is:

![3`3 identity matrix](http://snag.gy/NrRBX.jpg)

- Now we can determine the weight matrix as follows:

![determine weight matrix](http://snag.gy/4M68f.jpg)

- Next, the network is tested by the sequence of input vectors
	- X<sub>1</sub> and X<sub>2</sub>
	- They are equal to the output (or target vectors)
		- Y<sub>1</sub> and Y<sub>2</sub> respectively
- First we activate the Hopfield network by applying the input vector X
	- Then we calculate the actual output vector Y
	- Finally we compare the result with the initial input vector X

![activate hopfield network](http://snag.gy/0uGTM.jpg)

- The remaining six states are all unstable
	- However, stable states are capable of attracting states that are close to them
		- Also called **fundamental memories**
- The fundamental memory (1,1,1) attracts unstable states (-1,1,1), (1,-1,1) and (1,1,-1)
	- Each of these unstable states represents a single error, compared to the fundamental memory (1,1,1)
- The fundamental memory (-1,-1,-1) attracts unstable states (-1,-1,1), (-1,1,-1) and (1,-1,-1)
- Thus the Hopfield network can act as an **error correction network**

## Storage capacity of the Hopfield network

- Storage capacity is one of the largest number of fundamental memories that can be stored and retrieved correctly
- The maximum number of fundamental memories M<sub>max</sub> that can be stored in the n-neuron recurrent network is limited by:

![M_max](http://snag.gy/Q4p0I.jpg)

# Bidirectional associative memory (BAM)

- The Hopfield network represents an **autoassociative** type of memory
	- It can retrieve a corrupted or incomplete memory
		- But cannot associate this memory with another different memory
- Human memory is essentially **associative**
	- One thing reminds us of another, and then of another and so on
	- We use a chain of mental associations to recover a lost memory
		- If we forget where we left the keys, we try to recall
			- Where we last had it
			- What we were doing
			- Who we were talking to
	- We attempt to establish a chain of associations to restore a lost memory
- To associate one memory with another
	- We need a recurrent neural network capable of
		- Accepting an input pattern on one set of neurons
		- Producing a related, but different, output pattern on another set of neurons
- Bidirectional associated memory (BAM) first proposed by Bart Kosko
	- Heteroassociative network
	- It associates patters from one set, set A
		- To patterns from another set, set B
			- Vice versa
	- Like Hopfield networks, BAM can generalise and also produce correct outputs despite corrupted or incomplete inputs

## BAM operation

![BAM operation](http://snag.gy/xq6vJ.jpg)

- The basic idea behind BAM is to
	- Store pattern pairs so that when n-dimensional vector X from set A is presented as input
	- The BAM recalls m-dimensional vector Y from set B
	- But when Y is presented as input, BAM recalls X
- To develop the BAM, we need to create a correlation matrix for each pattern pair we want to store
	- The correlation matrix is the matrix product of the input vector X
		- And the transpose of the output vector Y<sup>T</sup>
	- The BAM weight matrix is the sum of all correlation matrices:

![sum correlation matrices](http://snag.gy/jgoRa.jpg)

- Where
	- M = number of pattern pairs to be stored in the BAM

## Stability and storage capacity of the BAM

- The BAM is **unconditionally stable**
	- This means that any set of associations can be learned without risk of instability
- The maximum number of associations to be stored in the BAM should not exceed the number of neurons in the smaller layer
- The more serious problem with BAM is **incorrect convergence**
	- The BAM may not always produce the closest association
	- In fact, a stable association may be only slightly related to the initial input vector
