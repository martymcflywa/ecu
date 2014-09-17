# Object analysis

## Object life histories

- Object life histories are a type of state diagram
	- State diagrams are used in many areas of IT to understand and define how a system operates
	- For example, a traffic light system can be modelled as a state diagram, the states for each being red, yellow and green
- For information systems, we are interested in being able to describe the essential behaviour or *business rules* within the system
	- For example, a bank customer who has a positive balance will get interest from the bank, whereas a negative balance attracts an overdraught
	- Clearly these are two different behaviours as far as the system is concerned
- Another example would be in a university where a student may be good in standing, on probation, at-risk or excluded
- Again, what they can do, what they can acces and how they are treated is determined by their *state*
- Knowing the different states of behaviour is an important building block in defining the complete business rule

## State diagrams

- A state is a property of an object that is useful for describing the different behaviours an object may exhibit
- Over time the state of an object may change and so it is useful to capture these different states if we want to define the behaviours of an object
- State diagrams come in many forms of notation
	- We will use a simple notation known as object life history or OLH, depicting only states as bubbles and changes of state by arrows

## OLH example 1

![olh 1](http://i.imgur.com/xqYSMus.png)

The logic of this diagram is as follows:

- Temp: A customer always starts as a temporary customer
	- Presumably with some restrictions
- Good: After a period of time the customer is considered a good customer
	- Presumably with better benefits
	- Note that a customer can never go back to temporary status
- Bad: If the customer proves unsatisfactory, the customer becomes a bad customer
	- Presumably some restricted rules apply
	- It is possible for a customer to redeem and be moved back to good status

## OLH example 2

![olh 2](http://i.imgur.com/z4hYBKT.png)

This is an OLH of a simple traffic light. 

Notice that we consider only a single light bank here. No turning arrows or special *Bus* lights. It is probably safest if the only return from flashing amber is a red light.

## OLH example 3

![olh 3](http://i.imgur.com/QCHSoNJ.png)

This is a student object.

The student starts the course on *Good Standing*, but if s/he fails more than 50% of credit points, moves to *Probation* status.

## Pergola man

### Conceptual model

![pman cmodel](http://i.imgur.com/xhc3gy2.png)

### OLH

![pman olh](http://i.imgur.com/BBuDwCk.png)

- If there are four objects there should be four OLH
- Arrows always enter and leave a state
	- This is a reminder that we will need a use case to instantiate the state and later delete it

### Pergola man OLH explanation

#### Customer

- *Customer* has only one state, it either exists or doesnt
	- If it exists, then a quotation can be sent to him etc. so it is important to distinguish between customers that exist, and ones that don't
	- For single state life histories such as *customer*, we tend to say 'X exists' to remind us of this distinction
		- Don't use it for multi-state life histories like *order*
- Incoming arrow: A customer has to be created in order for it to exist
- Outgoing arrow: At some point, it may be decided the customer is no longer a live customer, so the facility needs to exist to delete that customer
- Reflexive arrow: The customer's name or address might change but they can still remain a customer

#### Material

- *Material* follows a similar logic to customer
- Reflexive arrow: Indicates that the unit cost of the material might need to change


#### Labour rate

- *Labour rate* is different
- We need to be able to update labour rates from time to time
	- So we need a code that is unique for each labour rate
	- A date has been added to delineate what period that rate is valid for
- So instead of updating the rate, we simply create a new rate for a new period
- No reflexive arrow is required
- Arguably we will never delete a rate so there is no outgoing arrow

#### Work order

- *Work order* is a more interesting OLH
- The name *work order* has been given to reflect the whole cycle of its life
	- The quotation may become a proper order
- Once the work is done an invoice is generated
- It may be part paid many times or fully paid in one hit

## State precedence map (SPM)

- The SPM brings together all the OLH states into one diagram
- The purpose of this is to show how states in one OLH influence states in other OLHs
	- For example, you can't have a quotation without there being an existing customer first, at least in the sense of being a potential customer
- So all states are examined and put into a precedence map

![spm](http://i.imgur.com/RcBwtJ0.png)

- Notice we are not so concerned about incoming, outgoing and reflexive arrows on this diagram
- We can get these from OLH anyway
- The purpose here is to trace inter-object state dependency
- Specifically, SPM tells us what checking needs to be done inside certain business rules
	- For example, to create a quotation, we need:
		- An existing customer
		- Existing materials
		- Current rate code

## Abnormal life analysis

- This is attempt to deal with Murphy's law
	- What can go wrong will go wrong
- Before implementing any information system it is always wise to perform this check
- By looking at the OLHs in particular, you ask what can go wrong
	- For example, what if a customer just doesn't pay his bill?
		- Does he stay on the system forever, or can we write it off as bad debt?
	- Another example, what if a customer accepts the quotation but then later changes her mind?
	- Two ways of dealing with this are to be able to delete an order, then re-input a new quotation
		- Not currently expressed in the OLH
	- Or to allow modification of order/quotation
- Abnormal life analysis results in the generation of new use cases
- Usually many of these will be to allow the administrator the ability to delete or modify data within the system under controlled conditions
- Such use cases are vital for the integrity of the data within the system

## Review

- Define the following:
	- State
		- A state is a property of an object that is useful for describing the different behaviours an object may exhibit
	- State diagram
		- Captures the different states of objects to define the behaviours of an object
	- Object life history
		- A state diagram notation
			- Limited to depicting states as bubbles
			- Changes of states by arrows
	- Reflexive arrow
		- Used when the object requires changes but the state remains the same
	- State precedence map
		- Brings together all OLH states into one diagram
		- Demonstrates how states in one OLH influence another OLH
	- Abnormal life analysis
		- Identifies possible issues with current OLH
			- What can go wrong?
		- Results in the generation of new use cases
		- Usually to provide admin greater access to allow the modification of data under controlled conditions