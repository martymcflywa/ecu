# Evaluating a Use Case Script

## Background

Use Case diagrams express the functions of a system in an abstract, readable way. Use Cases provide the process step detail to explain exactly how a use case succeeds. One way to learn about writing good use cases is to analyse poor ones.

## Tasks:

1. Examine the excerpts from the following use cases
2. Find the errors in the interactions
	- Re-write as necessary
3. Explain reasoning

### Use Case 1:

![lab use case 1](http://i.imgur.com/XbUbY1z.png)

#### Errors:

- Refers to GUI
	- Essential use cases should not make any references to GUI or technology
- Too specific
	- Action steps are too fine-grained
- Repeated actions not modelled correctly
	- Should use one of the two repeat styles shown in lecture
- Alternative flow is incorrectly modelled
	- Should either add description of variation in alternative flow section
	- Or modify body of use case description to show alternative flow

#### Re-write:

![lab use case rewrite 1](http://i.imgur.com/f76BAHn.png)