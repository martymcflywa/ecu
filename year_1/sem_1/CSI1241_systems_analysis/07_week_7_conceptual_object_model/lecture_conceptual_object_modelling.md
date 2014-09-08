# Conceptual object modelling

## Introduction

- In this lecture we will look at how data are stored and the process of deciding how to store data
- The process of storing data is a two stage process
	1. The first stage is to create a conceptual model of the data to be stored
		- Covered in this lecture
	2. The second stage is to convert the conceptual model into a physical model
		- Covered in logical relational data model lecture
- A conceptual model is a model that cannot be directly implemented on a computer
	- However its advantage is that it allows use to work at a higher level of abstraction and focus on aspects that are important to sort out first before worrying about physical aspects
- In this unit, the conceptual model used is called an **object model**
- It contains objects and relationships between these objects
	- Object models are thus object-oriented

## What is object orientation

- Object-orientation is a way of looking at the world
	- ie. A way of modelling a domain of interest
- There are many facets of object-orientation
	- Some of these are more relevant to systems analysis than others
- In this lecture, we will only look at the aspects that are needed for analysing a human activity system of a proposed information system in order to create a systems specification

## Object

- An **object** is *something of interest* in a human activity system (HAS)
	- Depending on the HAS, its objects might be
		- Customers
		- Employees
		- Orders
		- Agreements
		- Breakdowns
- An object is characterised by a number of operations which may be applied to it and a number of attributes that store data that is used within the system for a purpose
	- Variables
	- Methods
- Because of the previous discussion regarding business rules, all objects need to contain a state attribute so that we can track the state of an object at any time
- When identifying objects, we look for those tractable units that the actors in the human activity system use and conceptualise as *objects*
- Underlying this, we need an appreciation of coupling and cohesion in order to decide where to locate some operation and/or attributes
- This leads to the following way of depicting objects

![object](http://i.imgur.com/PGjtdqh.png)

## Encapsulation

- The states, operations and attributes are encapsulated within the object
	- In essence, this is **information hiding** which means that the internal structure is hidden from the outside
- The operations support the functioning of the object
	- So in order to change an object state or the value of an attribute or even just to enquire about an attribute value, it is necessary to execute its operations to achieve this
- Thus a list of operations can be obtained by examining the activities performed by the object within the system

## Class and instance

### Class

- A **class** represents a template or specification for objects *of the same kind* and describes how the objects are structured internally
	- Objects of the same class have the same definitions for their operations and for their information structures and may take on the same states
- So the object class "customer" is a template for all customers in terms of their attributes and operations
- Object diagrams such as the one previously describe the object class

### Instance

- An **instance** is an object created from class
	- It represents therefore one occurence of the object class
- So customer "Smith" is an object which is an instance of the object class "customer"
- It makes sense to use the concept of classes, since it allows us to generalise about a number of similar objects by using the same template or specification

## Complex object

- An object may be simple or complex
- **Simple objects** contain attributes whose properties only occur one for each instance
- **Complex objects** may have attributes that occur more than once
	- For example:
		- `customer-object = {customer-instance}`
		- `customer-instance = customer-name + customer-address + {phone-no}`
	- The multiple `phone-no` make it a complex object

## The conceptual object model

- The conceptual object model is the blueprint or plan for the eventual database to be used in an information system
	- As such, it is the focus of attention in the analysis phase
	- It is drawn as a network of objects and relationships
- Because information systems rely so heavily on data, much of the effort in analysis goes into ensuring that the conceptual object model meets all the requirements of the system
	- Only then should conversion to a database model proceed
- The conceptual object model is named because it cannot be implemented as it stands
	- So it only exists in our minds
- It is a useful *halfway house* because it allows us to confirm that we have identified the essential data and operations that an information system needs before going on and providing more detail
	- For instance we don't worry about keys in a conceptual object model and we assume that we can jump *magically* from one object to another to obtain data related to the task we are working on

## Relationships

### Relationship

- A relationship is a meaningful association between objects
	- For example, where an employee works in a department, the relationship is:
		- `EMPLOYEE WORKS FOR DEPARTMENT`

### Relationship occurence

- A relationship occurence instantiates a relationship by identifing related object instances
	- `MR JONES WORKS FOR ACCOUNTS`

## Degree of relationships

- The degree of relationship (cardinality) is an important aspect about the nature of the relationship between two objects
	- It identifies the number of occurences that one object instance has with respect to its counterpart in the other object
	- There are three types
		- One-to-one
		- One-to-many
		- Many-to-many

### One-to-one relationship

- A one-to-one relationship is where there is only one occurence in one object instance for one occurence in another
	- An example of a one-to-one relationship is the relationship `IS MARRIED TO`, which is an association between objects `MAN` and `WOMAN`

![one-to-one](http://i.imgur.com/et6vV9L.png)

- Well, this is true for most Western societies, but note the following
	- Are there the **same number** of men and women in Australia?
	- Is **every** man in Australia married to a woman and vice versa?
	- What if we wanted to say that every man **must** be married to a woman?
- We need a way of qualifying the nature of the `IS MARRIED TO` relationship

### Mandatory / optional relationships

![mandatory optional](http://i.imgur.com/e69zNa3.png)

- `1` stands for mandatory association at that end of the relationship
- `0` stands for optional association at that end of the relationship
- Note that although we have only one relationship, each end of the relationship has to be assessed separately to determine its optionality or mandatoriness

### One-to-many relationship

- A one-to-many relationship is where one object instance is related to many object instances in its counterpart
- As with one-to-one relationships, one-to-many relationships may be mandatory or optional at each end

![one-to-many](http://i.imgur.com/0T69ges.png)

#### Questions

- Write down examples of object instances in the `PROJECT` object and the `STAFF` object

![project-staff](http://i.imgur.com/cIm5beJ.png)

### Many-to-many relationships

- A many-to-many relationship is where an object instance in the first object is related to many object instances in the second
	- Also where an object instance in the second has many in the first
	- In other words, there must be two one-to-many relationships, each in the opposite direction to each other

![many-to-many](http://i.imgur.com/zWjnFsD.png)

The example above allows `STUDENT` object and `ASSIGNMENT` object to be set up at the start of the year *before* any assignments have begun.

- If the degree of relationship is unclear, the sketch out a few occurences of each object
	- This will help identify the cardinality

![sketch](http://i.imgur.com/OLbNBKa.png)

#### The many-to-many issue

- But what if we now want to store marks for each assignment?
- Marks could be stored in either the `STUDENT` object or `ASSIGNMENT` object
	- Remember that we said we could just magically jump from one object to another?
- Another alternative is to have a third object that is located inbetween these two objects

![student marks](http://i.imgur.com/zeSMJ8V.png)

### Recursive relationships

A recursive relationship is where an object has a relationship with itself.

![recursive relationship](http://i.imgur.com/IEo39x0.png)

This says that a part may contain many other parts - a common situation in a manufacturing company. Let's sketch out an example:

![recursive car](http://i.imgur.com/lALblAk.png)

Another commonly occuring recursive relationship is `EMPLOYEE REPORTS TO EMPLOYEE`

## Difficulties in creating the conceptual object model

- Typically, one-to-one can become one-to-many or many-to-many by expanding the time horizon
	- Similarly, one-to-many can become many-to-many depending on time
- The important question to ask:
	- What is it the organisation needs to store to meet the needs of the information system?

### Seeing the objects

- A common difficulty is in identifying or seeing the objects
	- One solution is to try the following:
		- List all elementary data items from the data dictionary which are outputs of the system
		- Remove all derived fields
			- Derived by calculations upon other attributes or for example today's date from the system date
		- Put the remaining attributes into *groups* on the basis that they relate to the same thing
			- For example, `customer-no`, `customer-name`, and `address` all relate to `CUSTOMER`
	- These groupings become possible (candidate) objects
	- There may still be some attributes not allocated, but the list should be much shorter
	- Continue to search for groupings in the remaining list until all attributes have an object
	- Check that the set of objects and attributes will generate all the outputs

### Attributes which are not used as outputs

- Sometimes attributes require to be held in storage, but for some reason they don't seem to appear as an output
	- An example in the PPA case study is credit limit
	- The credit limit is checked to determine whether an order is to be accepted, but it never actually appears as an output
		- Clearly these attributes need to be stored
	- They can be identified by listing all the conditions in the business rules and looking for attributes which are not already in the data dictionary

### Time dimension

- When modelling a problem, it is often difficult to know if historical information is required
	- ie. take the example of `MAN is married to WOMAN`
- This is a one-to-one relationship **only** if a current *snapshot* is required
- If it is required to store information over time, then the relationship becomes many-to-many

### The fluid nature of objects, attributes and relationships

- Object modelling has a lot to do with bringing into focus that set of objects, attributes and relationships which are actually required for the information system to operate
- Bringing it into focus is painful because of the fuzziness of the project
- Sometimes by slightly altering the focus, whole objects can disappear or what you thought was a relationship becomes an attribute:

#### Example 1: Merging relationships

![merging relationships](http://i.imgur.com/V2mwN1l.png)

#### Example 2: Merging objects

![merging objects](http://i.imgur.com/LhIqSNI.png)

### Seeing the relationships

- There is sometimes a tendency to include more relationships than necessary or it's not clear that all permutations of candidate relationships have been considered
	- This is especially true of large object models
- Later on in systems analysis, the former will be addressed in data model navigation because it tells you what relationships are actually used
- To assist in the second problem, use the relationship matrix, which is a triangular matrix that ensures that every permutation is considered

#### The relationship matrix

![relationship matrix](http://i.imgur.com/RD9M8sj.png)

## Rules for conceptual object models

- Objects normally contain several occurences
- Any unique attribute can occur only once, anywhere in the object model
- Only have objects/attributes which are actually needed to create the outputs
- It is not necessary to store totals and sub-totals since we know the computer can always re-calculate these from raw data
- Only have relationships which are actually used in the access of other objects
- One-to-one, one-to-many, many-to-many and recursive relationships are permitted
- Show mandatoriness and optionality

## Steps in creating the conceptual object model

- Identify the objects
- Identify the attributes for each object
- Identify operations for each object
- Identify relationships and their degree
	- Use the relationship matrix
- Draw the object model

## Example object model

![example object model](http://i.imgur.com/7rLhmLA.png)

## Quiz

- Given the above model, is it possible to work out what the total value of unpaid orders are for `customer 1234`?
- If so, what attributes are used and what operations are required?

### Answer

- The answer is yes and this is how we would do it *conceptually*
- We start in the customer object and find the object instance for `customer 1234`
	- This instance may have a number of orders associated with it
- For each associated order we do the following
	- First we need to check if the order is paid or unpaid
		- Do this by checking the status attribute
		- If paid, ignore the order
		- If unpaid, carry on
	- We obtain `ord-qty`'s of the object instance in order
		- There may be several of these
	- For each `ord-qty` we can now go to the product object and obtain the cost by reading the product instance associated with that order line
		- `ord-qty` represents a line on the order
	- By multiplying `ord-qty` by cost we get the value of that line on the order
		- So we need to repeat this procedure for all lines on this order to get the value of this unpaid order
	- This process is repeated for all unpaid orders until we have the total value of unpaid orders
- The operations required are:
	- Read customer instance
	- Read order instance
	- Read product instance
- The attributes used were:
	- `cust-no`
	- `order-status`
	- `ord-qty`
	- `cost`
- Note also that we did not need any total fields in our conceptual model since we could re-calculate them as we went along

## Recap

- What we have done so far is to introduce object modelling by describing how to create a **conceptual object model**
- The rules and the steps for the conceptual object model have been discussed in detail
- Later we will create a new, but different model from the conceptual model that describes physical aspects of the database
	- This is called the logical relational data model

## Review

Define the following:

- Object
	- Something of interest in a Human Activity System (HAS)
- Object instance
	- An object created from a class, representing one occurence of the object class
- Attribute
	- Stores data that is used within the system for a purpose
	- Variable
- Relationship
	- A meaningful association between objects
- Relationship occurence
	- Instantiates a relationship by identifying related object instances
- Degree of relationship
	- Identifies the number of occurences that one object has with another
	- Three main types
		- One-to-one
		- One-to-many
		- Many-to-many
- One-to-one
	- Only one occurence in one object instance for one occurence in another
- One-to-many
	- Where one object instance is related to many object instances
- Many-to-many
	- Where an object instance in the first object is related to many object instances in the second, and where an object instance in the second has many in the first
	- Multiple object relationships in both directions
- Mandatory relationship
	- denoted by `1`
	- Relationship is a must
- Optional relationship
	- denoted by `0`
	- Relationship is optional
- Recursive relationship
	- Where an object has a relationship within itself
- What does an object contain?
	- Operations
		- Methods
	- Attributes
		- Variables
- What is a complex object?
	- An object with attributes that occur more than once
		- ie. A `customer` object with multiple `phone-no` (`phone-no` is attribute)
- What is an object model?
	- A blueprint or plan for the eventual database to  be used in an information system
- What are the main cardinalities?
	- One-to-one
	- One-to-many
	- Many-to-many
- What are the rules for drawing the conceptual model?
	- Objects normally contain several occurences
	- Any unique attribute can occur only once, anywhere in the object model
	- Only have objects/attributes which are actually needed to create the outputs
	- It is not necessary to store totals and sub-totals since we know the computer can always re-calculate these from raw data
	- Only have relationships which are actually used in the access of other objects
	- One-to-one, one-to-many, many-to-many and recursive relationships are permitted
	- Show mandatoriness and optionality
- What are the steps in creating the conceptual object model?
	- Identify the objects
	- Identify the attributes for each object
	- Identify operations for each object
	- Identify relationships and their degree
		- Use the relationship matrix
	- Draw the object model
- What are the difficulties in creating the conceptual model?
	- See or identify objects
	- Defining attributes which are not used as outputs
	- Time dimension
	- The fluid nature of objects, attributes and relationships
	- See or identify relationships