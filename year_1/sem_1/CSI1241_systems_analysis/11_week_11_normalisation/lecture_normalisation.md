# Normalisation

## Introduction

- Normalisation is a technique developed by Dr. E. Codd
- It is used NOT to develope a data model from scratch but as a CONFIRMATION that the logical relational data model is correct
- Normalisation works by taking a complex object
	- Either from the conceptual object model
	- Or a document that is an output of the system
- And applying tests which reduce the object into entities
- Eventually these tables become entities as we know them
	- The tables are working versions of entities as we work through the normalisation process
- From these entities, a logical relational data model can be constructed which can be compared to the one produced in the logical relational data modelling process
- There are at least 5 normal forms
- We will only consider the first three in this unit
	- Stage 1: create an unnormalised list
	- Stage 2: create first normal form 1NF
	- Stage 3: create second normal form 2NF
	- Stage 4: create third normal form 3NF

## Sample for discussion

- The following data is taken from records in a doctor's practice
- The data records visits to consultants recommended by doctors in the practice
- It is made up to aid our learning
- It contains all necessary variations of data as examples for our decision-making

### Sample composite

![composite](http://snag.gy/QyxUC.jpg)

### Observations

- Repeated data have been left blank
	- That is, on the second and third lines of the report, spaces appear to indicate that the same patient and doctor information apply to the remainder of the line
- Sometimes you will see objects with this data actually repeating itself
	- It doesn't matter which way you choose to show this
	- The important thing is that you can recognise that it is repeated data
- Notice that patient Tng sees two consultants on the same day

## State 1: Create an unnormalised list

- Remember we are starting from a minimal complex object so no derived attributes should be present
- Simply list all attributes in the object
	- Ignore the fact that some attributes are duplicated

![stage 1](http://snag.gy/bHqF9.jpg)

### Employee training object

- The following object has to be normalised
- So create the unnormalised form for it

![employee training object](http://snag.gy/AK8Ca.jpg)

### Unnormalised list: Employee training object

![employee training unnormalised](http://snag.gy/iIG01.jpg)

## Stage 2: Create 1NF tables

- Remove any repeating groups
- Show them as separate tables
- Include the **key** from the original list
- Usually the first table will have the key from the original list and any other new tables will also include that key from the original list as part of a composite key

![stage 2](http://snag.gy/Es2RU.jpg)

### Employee training object

- Create the 1NF for the employee training object

![employee training 1NF](http://snag.gy/SYzSv.jpg)

## Stage 3: Create 2NF tables

- Is each attribute **entirely dependent** on the key?
	- If not, remove to a new table with its key
- Entirely dependent means that each attribute needs all parts of the key in order to be determined
	- ie. order-no, part-no, qty, part-description
	- Here qty is entirely dependent whereas part-description is not entirely dependent on the **whole** key
- There may be only a transformation if the table has a multi-attribute key
	- In other words, if a table has a single-attribute key then it goes straight to 2NF

![stage 3](http://snag.gy/4s84P.jpg)

### Employee training object

- Create the 2NF tables for the employee training object

![employee training 2NF](http://snag.gy/Zf86D.jpg)

## Stage 4: Create 3NF tables

- Is any attribute **transitively** dependent on another attribute?
	- If so, remove to a new entity type with its key
- This question refers to the possibility that an attribute may be more dependent on another attribute (or set of attributes) that it is on the key of the table it is currently in
	- ie. order-no, item-no, part-no, part-description
	- Here part-description is more dependent or part-no that it is on order-no, item-no
- Note that if there is only one non-key attribute in the table then that table automatically goes to 3NF

![stage 4](http://snag.gy/S25pf.jpg)

### Employee training object

- Create the 3NF tables for the employee training object

![employee training 3NF](http://snag.gy/7dKig.jpg)

## Building a relational data model from 3NF tables

- Now that we have the entities, it is time to add the relationships between the entities
- Because the rules for normalisation include adding foreign keys as you go through the process, all foreign keys are already there in the tables
- This is a fairly straightforward process:
	1. Each table becomes an entity
	2. Where a foreign key exists in an entity, a relationship is drawn between that entity and the **home** entity
	3. Where a foreign key is part of the key of the entity, then the relationship is of degree one-to-many
	4. Otherwise the relationship degree has to be obtained by considering the association between the two entities

### Appointment data model

![appointment data model](http://snag.gy/zUCny.jpg)

### Employee training object

- Create the data model for the employee training object

![employee training data model](http://snag.gy/mQdhL.jpg)

## Summary 

- A confirmation of data modelling
- A fairly mechanical process for producing a data model
- It may identify attributes or entities overlooked in the data modelling process
- A structured opportunity for gaining insight into the nature of the data
	- Because it forces you to ask questions you may not previously have
	- ie. Can two consultants with the same name have appointments on the same day?
- Gives increased confidence that the data model is correct

## Warning

- Because normalisation is sometimes performed on the attributes that actually exist on a document, it may produce different answers from your data modelling
	- For example, suppose the appointment's example did not contain doctor-no but just referred to doctors by their name
	- You woulld probbaly have to use doctor-name as the key but then you have the possibility of duplicate names of doctors
	- However, given this reservation, normalisation is a useful tool in the toolbox

## Review

- What is normalisation?
	- Examines complex objects and applies tests which reduce the object into entities
- List the four stages of normalisation
	1. Create unnormalised list
	2. Create 1NF
	3. Create 2NF
	4. Create 3NF
- How do you create an unnormalised list?
	- List all attributes in the object
	- Ignore duplications
- What is the rule for creating 1NF?
	- Remove repeating groups
	- Show them as separate tables
	- Include **key** from original list
	- Usually first table will *own* the key and other tables will include that key as part of a composite key
- What is the rule for creating 2NF?
	- Is each attribute entirely dependent on the key?
		- If not, remove to a new table with its key
	- There may only be a transformation if the table has a multi-attribute key
		- In other words, if a table has a single-attribute key, then it goes straight to 2NF
- What is the rule for creating 3NF?
	- Is any attribute transitively dependent on another attribute?
		- If so, remove to a new entity type with its key
	- If there is only one non-key attribute in the table then that table automatically goes to 3NF
- How do you build a relational data model from 3NF tables?
	1. Each table becomes an entity
	2. Where a foreign key exists in an entity, a relationship is drawn between that entity and the **home** entity
	3. Where a foreign key is part of the key of the entity, then the relationship is of degree one-to-many
	4. Otherwise the relationship degree has to be obtained by considering the association between the two entities