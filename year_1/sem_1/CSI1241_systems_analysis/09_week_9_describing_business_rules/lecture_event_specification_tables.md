# Event specification tables

## Is a BRD correct?

- Drawing the diagram is easy, but how do we know that it represents the real-world problem well enough?
	- Is it a good model?
- BRDs can be ambiguous due to the use of *selection* within the harel blog
- How to resolve this problem so that the diagrams make sense?

## The process of the BRD method

![brd process](http://snag.gy/lOOLJ.jpg)

## Event specification table to the rescue

- An EST is a tablular model that serves several purposes in the BRD method
- It acts to clarify ambiguities in a BRD by:
	- Providing another model that is different from text or graphics
		- Text: Business rules
		- Graphics: BRD
	- Links the BRD to the business rules
		- Business rules: Functional requirements
	- Describes the lawful state space of a BRD

## EST Example

![est example](http://snag.gy/RgqqD.jpg)

## Notation used in the EST

- You must give each atomic construct a unique identifier
	- ie. S27 means state 27 and there will only be one state 27 across the whole project
- You can use Boolean connectives
	- S1 | S2 = S1 or S2
	- C3 & C4 = C3 and C4
	- [C5 ... C7] = C5 and C6 and C7
	- !C8 = not C8
	- Also use parentheses to clarify connectives

## Example: Journal website

### The business rules

- 4.1.1: Subscribers must be able to access the full journal from the home page of the site
- 4.1.2: To access the full journal, a subscriber must enter a valid user name and password
- 4.1.3: If a subscriber enters an invalid user name, then s/he must be offered a choice of either subscribing or returning to the home page of the site
- 4.1.4: Subscribers must be able to search the website for articles containing key phrases
- 4.1.6: If a subscriber enters an invalid password, s/he will be returned to the site home page
- 4.1.7: A subscriber may, at any time, return to the site home page

### The BRD

![journal brd](http://snag.gy/UMBbi.jpg)

### Problems

- How to identify which state to be in? 
	- S28 or S32 for example?
- If the blob is a selection, how do we get to S5 or S6?
- What if we have missed an important business rule?

### The solution

- The EST answers these questions by providing a link back to the business rules and making sure that each state transition is represented
- It ensures that the BRD makes sense and that the rules (requirements) are represented

### The EST

![journal est](http://snag.gy/hY20V.jpg)

## Summary

- An EST helps to provide rigour for a BRD thus making the method more useful