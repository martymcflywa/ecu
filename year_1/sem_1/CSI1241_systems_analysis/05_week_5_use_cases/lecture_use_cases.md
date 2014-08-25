# Use Cases

## What is a Use Case

- A use case describes a function that a system performs to achieve a user's goal
- A use case must yield an observable result that is of value to a user of the system
- A use case or use case description is sometimes called an elaboration
- Use cases are text based

## Style of Use Case Description

>Wirfs-Brock & Schwartz (2001)

- There are three forms of use case description
	- Narrative
	- Scenario
	- Conversation

### The Narrative Form

>Wirfs-Brock & Schwartz (2001, pp. 10)

This is a *make payment* use case example:

>The user can make online payments to vendors and companies known to the bank. Users can apply payments to specific vendor accounts they have. There are two typical ways to make payments: The user can specify a one-time payment for a specific amount, or establish regular payments to be made on a specific interval such as monthly, bi-weekly, or semi-annually.

### The Scenario Form

>Wirfs-Brock & Schwartz (2001, pp. 12)

This is a *register customer* use case example:

>1. User enters registration information:
	- Required information: user name, email address, desired login ID and password, and confirmation password
	- One of: account number and challenge data, or ATM# and PIN
	- Optional: language choice and company
2. System checks that password matches confirmation password
3. System validates required fields and verifies uniqueness of login ID
4. System verifies customer activation information
5. System creates and activates customer online account
6. System displays registration notification

### The Conversation Form

>Wirfs-Brock & Schwartz (2001, pp. 14)

This is a *make a payment* use case example:

![narrative example](http://i.imgur.com/N9dzIiS.png)

### Comparing the Three Forms

>Wirfs-Brock & Schwartz (2001, pp. 16)

All these forms are informal.

#### Narrative

- Strengths
	- Good for high-level summaries and intentions
	- Can be implementation independent
- Weaknesses
	- Easy to write at too high level or too low a level
	- Not suitable for complex descriptions
	- Can be ambiguous about who does what

#### Scenario

- Strengths
	- Good for step-by-step sequences
- Weaknesses
	- Hard to show parallelism, arbritrary ordering or optionality
	- Can be monotonous

#### Conversation

- Strengths
	- Good for seeing actor-system interactions
	- Can show parallel and optional actions
- Weaknesses
	- Easy to write to pseudo code
	- Difficult to show repetition

## Levels of Abstraction

- Use cases can be written at different levels of abstraction
	- Which is best?
- Constantine (1997) defines two levels
	- Essential use cases
		- Free of technology and implementation details
		- No user interface specifics
	- Real use cases
		- Describes process in terms of its real design
		- Uses terms specific to input / output devices

### Essential Use Case Example

![essential example](http://i.imgur.com/5quGBDj.png)

### Real Use Case Example

![real example](http://i.imgur.com/PFdNhnx.png)

## Sample Use Case Description

- The next figure shows a common template used to structure use cases
- It is simpler to use than a prose (narrative) description of a use case
- The *typical course of events* script is especially useful

![conversation template](http://i.imgur.com/g7Fa2sA.png)

## How to Fill in the Sections of the Use Case Description

- Use Case: `<name>`
- Section: Main
- Use Case: `<name>`
- Actor/s: `<actor name>`, `<actor name>`
- Purpose: What is the use case for?
- Overview: Brief description of the process
- Preconditions: What can we assume before the use case starts?
- Postconditions: How do we know something happened?
- Typical Course of Events
- Alternative Coruses
- Related Use Cases

### Use Case: `<name>`

The name should be identical to the name of the use case on the diagram

### Section: Main

- Usual to have just one section, the main one, that describes the typical course of events and the alternatives
- This might change if you have several sequences of events that are all as equally valid as the main course of events
	- For example, not just error trapping
- In this case you might have several named sections, each with its own typical course of events and alternative courses

### Actor/s: `<actor name>`

- The name should be identical to the one of the actor names on the use case diagram
- If you have more than one actor, make sure that they all do something
	- Role playing the typical course of events is particularly good for detecting this problem

### Purpose:

- What is this use case for?
- One sentence, 35 words or less

### Overview:

- Provide a brief description of the process
- Capture the following:
	- The trigger
		- What starts the process
	- The action
		- What happens
	- The result
		- How the process finishes
- Use the following templates:

>This Use Case begins when...

>This Use Case does...

>This Use Case concludes (or ends) when...

### Preconditions:

- What can we assume before the use case starts?
- Examples might be
	- The user has been authenticated
	- The customer has chosen a product
	- The customer has registered with the system
- If there aren't any, write **Nil** or **None**

### Postconditions:

- The outcome of a use case
- Usually write what happens after a successful conclusion of the use case
	- Or what is true about the system at the conclusion of a use case
- Examples
	- User is logged in
	- The customer sent his/her registration details
- If there aren't any, write **Nil** or **None**
	- Nil or None would be extremely unusual as the point of a use case is to *yield an observable result* of value to an actor

## What to Write as Action Steps

>Cockburn (2000)

- What is an action step?
	- Text placed in any of the boxes of the typical course of events
- Some examples:

>User enters name and address.

>At any time, user can request the money back.

>The system verifies that the name and account are current.

>The system updates the customer's balance to reflect the charge.

### Cockburn's Guideline 1:

>Cockburn (2000)

- Action steps should use simple grammar
	- Subject... verb... direct object... prepositional phrase
- Example:

>The system... deducts... the amount... from the account balance

### Helpful Hints

- *Number each action step*
- Make sure the action steps for *your* system stay on the right hand side
- If an actor is named at the top of an elaboration (use case description), make sure that it does something on the left hand side

## Bad Examples

### Bad Example 1:

![bad example 1](http://i.imgur.com/a3FrsfV.png)

- Action steps are not numbered
- Not much happens, so why is this important enough to be a use case?
- How does the system really respond?
- No alternative course of events, so nothing can go wrong
	- Very unlikely
		- What happens if the UserID is wrong?
		- Or the password?
		- What about a web server failure? (assuming that this system is web-based)

### Bad Example 2:

![bad example 2](http://i.imgur.com/7pwZDzU.png)

- The system starts the use case
- Action steps are too fine-grained
- Contains design information:
	- User clicks 'OK'
- Replace with:
	1. User enters name and address
	2. System presents user's profile

## Branching Typical Course of Events

>If the user has more than $1000 in his/her account, the system presents an investment option

>ELSE...

Alternatively, we could also say:

>IF Account balance >= $10000, THEN go to Step 7.

## Repeated Action/s:

There are two common ways to show repeats.

### Repeat Style 1:

![repeat style 1](http://i.imgur.com/Dop4rjS.png)

### Repeat Style 2:

![repeat style 2](http://i.imgur.com/f2jYmTs.png)

## How to Deal with `«include»`

- How do we model including one use case into another in a text-based model?
- It's easy on a diagram
- More cumbersome, but still necessary in a use case description
- If a base use case includes another use case, add a reference as an action step

![include example](http://i.imgur.com/vjTqpG3.png)

Alternatively, we could also write the following as the action step:

`<include: Authenticate User>`

## How to Deal with `«extend»`

- Use `Extension Point: <name of extension point/extending use case>` in the action step
- The extending use case includes conditions under which the extension is being committed

![extend example](http://i.imgur.com/5S8FhgI.png)

## Alternative Flow of Events

- The typical course of events shows the most common successful processes
- But things don't always work, so we use the alternative flow of events to model
	- Failures
	- Errors
	- Rare behaviour

### Choices for Modelling Alternative Flows

Add descriptions of variations in the alternative flow section of the use case description, which may reference an additional use case.

**OR**

Modify the body of the use case description to show the alternative flow, especially when you want to emphasis the variation, which may reference an additional use case.

## Related Use Cases

- `Includes <the name of a use case that *this* use case includes>`
	- Which is on the use case diagram
	- For example, the child use case
- `Extensions <the name of a use case for which *this* use case is the base>`
	- For example, the extension
- This should match the typical course of events and the use case diagram

## What Should Not Be In a Use Case

>Quatrani (2005)

Implementation details, therefore write:

>The student information is saved.

**NOT**

>The student information is written to a relational database.

Do not include any GUI information, because that is design, not analysis. So write:

>The student selects a course.

**NOT**

>The student presses the Select button to choose a course

- Never include internal processing unrelated to a stakeholder request
	- For example, how a student number is generated
- Never include non-functional requirements
	- For example, system will be available 24/7

## CRUD Use Cases

>Cockburn (2000)

- There is no agreeement on how to organise use cases of the sort:
	- Create "X"
	- Retrieve "X"
	- Update "X"
	- Delete "X"
- These are known as CRUD use cases, from the Create, Retrieve, Update, Delete operations on databases
- Are they all part of one big use case, Manage "X", or are they separate use cases?

## Summary

- Some useful advice for creating use cases
- Common pitfalls when writing use cases explained
- Guidance on what not to include in a use case

# References

- Cockburn, A. (2000) Writing Effective Use Cases. Pre-publication draft.
- Constantine, L.L. (1997) The Case for Essential Use Cases. Object Magazine, May 1997, New York, NY: SIGS Publications.
- OMG (2007). OMG Unified Modeling Language Superstructure, V2.1.2. Needham, MA: Object Management Group, Inc.
- Quatrani, T. (2005) Writing Good Use Cases. Presentation: IBM Software Group
- Wirfs-Brock, R. and Schwartz, J. (2001) The Art of Writing Use Cases. Presentation: Wirfs-Brock and Associates.
