# Describing business rules

## Introduction

- The term *business rule* is a very common and popular term in the IT industry, yet unlike the terms *object* or *database*, there is no broad agreement on a firm definition
- Informally of course we can say that a business rule defines certain aspects about how the business operates but such definitions are not satisfactory as we shall see
- We must remember that if business rules are unclear or incomplete, then so will be the final system
- A major task in systems analysis is to tease out business rules from the users
	- So whatever diagram or other means we use for this task, it must be something that most users can understand and be at an appropriate level for the task at hand
- Of course we could argue that our elaborated use case defines the business rules for the use case, but it is generally accepted that English narrative is not a particularly good medium for the purpose of detailed specification writing - at least not on its own
- In this unit we prefer to use a diagram known as a business rules diagram (BRD) to specify how use cases operate and in particular, how they relate to state changes

## Definition of a business rule

- A business rule is an explicit state change context in an organisation which describes the states, conditions and signals associated with events that either change the state of a human activity system so that subsequently it will respond differently to external stimuli, or reinforce the constraints which govern a human activity system

## Notes

- Note the phrase at the end of the definition emphasising the reinforcement of the constraints that govern a system
- What this means is that there may be occasions in a system where the end result of an activity is no change to any of the states
	- For example, someone trying to withdraw cash they do not have
- While from a systems analysis perspective, it's absolutely vital to capture the events that change the states of systems, it's equally important that the rules are so defined to reject changes where that is also part of the business's policy too

## Notational constructs for business rules diagram

![brd template](http://snag.gy/uRWvc.jpg)

## State

- States reflect the status of an object of interest at any given time, so for example, a student in a student record system might occupy the states good standing, conditional, terminated or graduated
- A state is a set of properties of a system which permit distinction from other states
	- It should always be recorded as an attribute of an object
- States are occupied for some finite time within the life of an object life history

## Event

- Events are actions carried out internally by the organisation
	- They are considered to be instantaneous occurrences which reflect the organisation's policy on what should happen in a particular circumstance
		- ie. Graduate student
- Events may accompany a state change, or they may not
	- ie. A student graduating
	- ie. If a bank customer has insufficient cash, a withdrawal attempt will be rejected and no state will have changed within the system, yet a rejection event needs to take place
- One important role of the event is to avoid describing unnecessary detail at this level of abstraction

## Condition

- Conditions define the criteria by which objects of interest in the business move from one state to the next as business events take place
	- Sometimes many conditions require to be met in order for an event to take place thus increasing complexity
- Modelling conditions without the context of states and events (and vice versa) is far less powerful
	- Yet that is what you will find in other techniques
		- ie. Decision trees have no states

## Signal (Trigger or message)

- Signals either enter or leave the human activity system
- Signals which enter the system will typically initiate activity within the system and these are called **triggers**
	- Triggers may be external such as a customer sending an order or internal such as one department sending a document to another department which then triggers some activity
	- Further, a trigger may be a time trigger, ie. an activity beginning at the start of the day or the end of the month
- Signals which leave the system serve the purpose of informing those outside the system of what has occured inside the system and therefore referred to as **messages**

## Creating the BRD

- A use case diagram would exist by this point together with an elaborated use case for each use case
- We will look at starting to develop two business rules diagrams:
	- Simple: Create invoice
	- Complex: Part/pay invoice

## Create invoice

### Elaborated use case

When the work has been completed, the Pergola man wishes to send the customer an invoice in order to obtain payment. The Pergola man will search the system using a list structure (to avoid data entry) to find the record of the order received from this customer. Once found, he simply updates it to invoice status by pressing the update button and an invoice is printed.

### Steps for drawing the BRD

- What is the trigger?
- What messages are generated?
- What state changes occur?
- What conditions are tested?
- Of those conditions, which can be checked by states?
- What events can take place?
- Connect up the constructs

### Create invoice examination

- The trigger to the use case is that work is completed
- The only message generated is the invoice
- State change is from order to invoice
- The only test that is necessary is that an order for this work must exist
	- Tests whether checking on a prior state or conditions (diamond symbol) are always shown within the Harel blob
- There is not really the possibility of a reject case here
	- If Pergola man cannot find the order, he will simply exit from this use case
- The event create invoice updates the status of the object being invoiced

### Create invoice draft BRD

![create invoice brd](http://snag.gy/spSyE.jpg)

### Event specification table

- The above example is quite simple, however some are not
- To make things clearer we can re-cast the state transitions into a table to confirm they are correctly covered in another presentation

## Part/pay invoice

### Elaborated use case

Receive details from web page. If any field is invalid then generate error message. If details correct then check payment amount against invoice balance. Three situations can arise. If payment amount = invoice balance then invoice is paid, so send an invoice paid message to the customer and update records. If payment amount < invoice balance then send part paid message to customer and reduce invoice balance by payment amount. Lastly, if payment amount > invoice balance then send error message to the customer.

### Part/pay invoice examination

- The trigger to the use case is when a payment is received
	- Remember that it would be a customer entering this detail
- To keep it simple, assume that only cust-no, quotation-no and payment amount are required here
- Cust-no and quotation-no would already be in the system and so could be found using list structures to minimise errors
- So the only data entry that cannot be avoided is the payment amount itself
- Possible messages are full payment, part payment and payment rejected
- The order must either be in invoiced state or part paid state
	- Since either no previous part payments or one or more previous part payments are possible
	- See state precedence map
- The elaborated use case indicates there are three possible scenarios (conditions)
	- Payment amount equals balance in which case the invoice is fully paid
	- Payment amount is greater than balance in which case the customer has almost certainly entered the wrong amount
		- Here there would be no state change
	- Payment amount is less than balance in which case a part payment is assumed
- Three events are possible, reject payment, accept full payment, accept part payment

### Part/pay invoice draft BRD

![part-pay invoice brd](http://snag.gy/tRweR.jpg)

## Review

Define the following:

- Business rule
	- Is an explicit state change context in an organisation which describes the states, conditions and signals associated with events that either change the state of a human activity system so that subsequently it will respond differently to external stimuli or reinforce the constraints which govern a human activity system
- Trigger
	- Signals that enter the system and initiate activity within the system
- Condition
	- Defines the criteria by which objects of interest in the business move from one state to the next as business events take place
	 - Sometimes many conditions require to be met in order for an event to take place, increasing complexity
- State
	- States reflect the status of an object of interest at any given time
	- A set of properties of a system which permit distinction from other states
		- Should always be recorded as an attribute of an object
- Event
	- Events are actions carried out internally by the organisation
	- Considered to be instantaneous occurences which reflect the organisation's policy on what should happen in a particular circumstance
- Message
	- Signals that leave the system to inform those outside the system of what has occured inside the system
- Harel blob
	- Encapsulates other constructs and used to model selection or simultaneous action
- What is the main disadvantage of using English as a means to describe business rules?
	- Unable to explain complex scenarios thoroughly with plain English
- Why is the state construct so important in the business rules diagram?
	- Conditions can be checked by states
- What is the advantage of showing all the business rules constructs on the event specification table?
	- Makes things clearer, and can be used to confirm they are correctly covered