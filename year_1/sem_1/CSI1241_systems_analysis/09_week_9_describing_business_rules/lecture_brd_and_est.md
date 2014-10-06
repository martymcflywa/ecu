# Business rule diagrams and event specification tables

## Introduction

- We know that a business rule diagram is
	- A process model
	- State based
- What we may not have noticed yet is that the BRD follows a strict **meta rule**
	- Each pair of states must be separated by at least one event

## Creating a BRD

- A use case diagram would exist by this point together with an elaborated use case for each use case
- The use case elaborations is the basis for the BRD
- The appropriate OLH is also used during the process if useful
- We will look at refining the BRD of pay invoice

## Part/pay invoice examination

- The elaborated use case indicates there are three possible scenarios, or conditions
	- Payment amount equals balance in which case the invoice is fully paid
	- Payment amount is greater than balance in which case the customer has almost certainly entered the wrong amount
		- Here there would be no state change
	- Payment amount is less than balance in which case a part payment is assumed

## Draft part/pay invoice BRD

![draft part-pay invoice brd](http://snag.gy/6UdYt.jpg)

## Is the BRD correct?

- Several issues appear in the diagram
	- Multiple start states
		- Choice of start state?
	- No final state for the Reject Payment event
	- Many conditions
		- Too many?
	- Two payment events that do the same thing

## Final part/pay invoice BRD

![final part-pay invoice brd](http://snag.gy/fTox4.jpg)

## Is any BRD correct?

- Drawing the diagram is easy, but how do we know that it represents the real-world problem well enough?
	- Is it a good model?
- BRDs can be ambiguous due to the use of *Selection* within the Harel blob
- How to resolve this problem so that the diagrams make sense?

## EST to the rescue

- An EST is a tabular model that serves several purposes in the BRD method
- It acts to clarify ambiguities in a BRD by:
	- Providing another model that is diferrent from text or graphic
		- Text: Use case
		- Graphic: BRD
	- Links the BRD to the functional requirements and/or assumptions
	- Describes the lawful state space of a BRD

## The process of the BRD method

![brd process](http://snag.gy/lOOLJ.jpg)

## EST for part/pay invoice BRD

![est part-pay invoice](http://snag.gy/fDAOu.jpg)

## The solution

- The EST provides a link back to the functional requirements and/or assumptions and ensures that each state transition is represented
- It guarantees that the BRD makes sense because the requirements are represented