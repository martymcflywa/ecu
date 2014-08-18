# Use Case Diagrams

## What is a Use Case

- A use case describes a function that a system performs to achieve a user's goal
- A use case must yield an observable result that is of value to a user of the system
- A use case describes a relationship between the system and its user/s
- A use case diagram is not the same thing, use cases are text based

## Elements of a Use Case Diagram

- Use case diagrams have two useful properties
	- They show the things of interest to us
	- They show how things are related

## Parts of the Model

### Use Cases

> (Quatrani, 2005)

- In models that depict businesses, use cases represent the processes and activities of the business
- In models that depict software systems, use cases represent the capabilities of the software

![part_usecase](http://i.imgur.com/0N2WkVJ.png)

### Actors

- Actors are outside the system
- The system responds because an actor *presses* on the system boundary
- Actors can be
	- Roles
	- Other systems
	- Hardware devices

![actors](http://i.imgur.com/5VW7bcr.png)

- UML version 2 (OMG, 2007) allows for other actor icons
	- For example, other icons that convey the kind of actor may also be used to denote an actor, such as using a separate icon for non-human actors

### Relationships: Connecting Things Together

- Association
	- Between use cases and actors
- Include
	- Between use cases
- Exclude
	- Between use cases
- Generalisation
	- Between use cases or between actors

### Association

- Things that are related, eg. actors and use cases

![usecase](http://i.imgur.com/9323rFy.png)

### The `«include»` Stereotype

- A relationship in which one use case (the base use case) includes the functionality of another use case (the inclusion use case)
- A way to show the reuse of functionality

![part_include](http://i.imgur.com/PYY56Y0.png)

- In the example above, Withdraw is the "including" use case, and Card identification is the "included" use case
- Note the direction and style of the arrow

### The `«extend»` Stereotype

- Used when there is some additional behaviour that should be added, possibly conditionally, to the behaviour defined in another use case

![part_extend](http://i.imgur.com/J6uP9cO.png)

- Note the arrow direction

### Extension Points

- An extension point is the point in a use case where another use case, which extends the functionality of the first use case, may or may not occur, depending on some condition
- An example might be the use case for paying for an item, which has an extension point at the payment type
	- Extending use cases may then extend at this point to pay by direct debit or credit card

### Extend: Correct Notation

>(OMG, 2003)

- Notice that the condition is written under the arrow

![part_extendnotation](http://i.imgur.com/JN8Qd9T.png)

- Or you could use a note if your software supports comments

![part_extendcomments](http://i.imgur.com/wCQWWIi.png)

### Generalisation

- A generalisation relationship is one in which one model element (the child) is based on another model element (the parent)
- The child receives all of the attributes, the operations, and relationships that are defined in the parent
- We can generalise actors or use cases

#### Generalise Actors

- SysAdmin **is an** Employee, but not the reverse

![generalise_actor](http://i.imgur.com/yFSdo0r.png)

#### Generalise Use Cases

- Use cases can be generalised too

![generalise_usecase](http://i.imgur.com/HbGyi9b.png)

#### Includes vs. Generalisation

![generalise_vs_include](http://i.imgur.com/3i7stCT.png)

- Watch out for this situation

![generalise_issue](http://i.imgur.com/DIrFtiY.png)

## Naming Use Cases

>(Wirfs-Brock & Schwartz, 2001, pp. 25)

- Use concrete, **strong** verbs / nouns instead of generalised, weaker ones
	- Weak verbs / nouns may indicate uncertainty
- Strong verbs
	- Create
	- Merge
	- Calculate
	- Migrate
	- Receive
	- Archive
	- Register
	- Activate
- Weak verbs
	- Make
	- Report
	- Use
	- Copy
	- Organise
	- Record
	- Find
	- Process
	- Maintain
	- List
- Strong Nouns
	- Property
	- Payment
	- Transcript
	- Account
- Weak Nouns
	- Data
	- Paper
	- Report
	- System
	- Form