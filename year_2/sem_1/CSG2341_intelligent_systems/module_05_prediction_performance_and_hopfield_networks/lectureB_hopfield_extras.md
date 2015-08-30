# Extra info on Hopfield networks

- See Negnevitsky Chapter 6.6
- Hopfield networks can model **associative memory**
- Can understand this using network **energy**

## Hopfield networks

- Completely connected
- Symmetric connections
- No self connections
- Update rule
	- There are variations
	- Activation:
		- 1 if input > 0
		- Activation<sub>old</sub> if input = 0
		- -1 if input < 0
- Can be used to store **memories** by setting weights:

>W = &sum;Y<sub>m</sub>Y<sub>m</sub><sup>t</sup> - MI

- Starting from an arbitrary activation pattern
	- Update neurons until no more changes
	- Can converge on stored memories
	- Number of errors depends on
		- Size of network
		- Number of patterns
- This much is in Negnevitsky
	- Try `HopfieldTest`

## Energy function

- Under these conditions, it is possible define a **Lyapunov function**, or energy function:

>H = - &sum; w<sub>ij</sub> \* a<sub>j</sub> \* a<sub>i</sub>

- Every update of the network either
	- Leaves the network unchanged
	- Or lowers the value of H
- This allows us to prove various things
	- Starting from a random initial set of activation levels
		- The network will converge to some stable set of levels and then stop changing
			- ie. a<sup>new</sup><sub>i</sub> = a<sup>old</sup> for all neurons
	- These stable states are the **memories** from the network

## Memories in activation space

![memories in activation space](http://snag.gy/0YY0Y.jpg)

## Hopfield networks for optimisation

- The energy function can be turned on its head
- Starting from an optimisation problem (like TSP)
	- Define an energy function to minimise
	- Design the network and set of weights that has this energy function
	- Use the network to solve the optimisation problem
