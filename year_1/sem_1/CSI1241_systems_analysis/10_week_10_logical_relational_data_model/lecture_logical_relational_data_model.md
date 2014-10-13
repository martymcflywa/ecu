# Logical relational data model

## Introduction

- The logical relational data model is created from the conceptual object model
- The conceptual object model is the best vehicle for checking completeness
	- ie. No duplication or redundancy
	- But it is not in a form that is easily implementable on real software
- The logical relational data model is a model of the final database and is considered the end point in systems analysis in terms of data definition

![lrdm model](http://snag.gy/G3kfX.jpg)

## From objects to entities

- While objects can be simple or complex, an entity must be simple
	- ie. The attributes of each entity are unique
- This means we will have to convert often complex objects into several entities
- Also, as we are becoming more physical in our thinking, we need to add keys so that we can physically find the information we are looking for on the computer

## Entities

- An entity, sometimes called a relation (hence the name relational database) is something of interest or relevance to the organisation about which data is likely to be stored
	- An entity name is always singular, never plural
	- It is drawn as a rectangle on the data model
- An entity is abit like an object except that it is always simple
	- This is where the rules for entities are stricter
		- Objects can be simple or complex, but entities must be simple
	- That means only unique attributes in each entitie that occur once for each instance of the entity

### Simple

`customer-file = {customer-record}`  
`customer-record = cust-no + cust-name + cust-addr`

The definition above is **simple** because every attribute occurs only once per record and can thus qualify as an entity.

### Complex

`order-file = {order-record}`  
`order-record = order-no + order-date + {order-qty}`

The definition above is **complex** because the size of each *record* may vary depending on the number of `order-qty`'s on the order.

## Entity occurences

- An entity occurence, sometimes referred to as *tuple* is an instance of an entity
- So customer "Smith" would be an entity occurence of the entity `CUSTOMER`

## Attributes

- Sometimes, attribute names are similar to those in other entities
	- ie. Address for entity `CUSTOMER` and address for `EMPLOYEE`
- Always qualify an attribute name so that it is unique
	- ie. `customer-address` and `employee-address`

## Summary of terms

![summaryofterms](http://snag.gy/1rVr4.jpg)

Entities, entity occurences and attributes all appear in the data dictionary the same way as objects, reports and web pages do.

## Composite definition of an entity

`product = {product-occurrence}`  
`product-occurrence = product-code + product-description + unit-of-measure + product-price + quantity-in-stock`

## Keys

- With the conceptual object model, we conveniently overlooked identifying keys
	- In a sense, keys are more to do with *how* than *what*
- With the logical relational data model, we need to identify a key for each entity
	- As with files, a key is an attribute or attributes which enable us to distinguish between that entity occurrence and all others
- We normally look for the fewest number of attributes which meet the definition of a key
- Keys are usually underlined

## What is a database?

- A database is a network of tables called entities, conceptually connected together by one to many relationships
	- Its purpose is to have (as far as possible) only one place for each attribute anywhere in the database, reducing duplication
	- All web pages, screens and reports are generated from the same database
- It is considered much better than alternatives such as files because of the lack of duplication and other benefits
- Firstly, let's see what a logical relational data model looks like

## Creating the LRDM

- Firstly we start with the conceptual object model
	- We examine each object in turn to identify whether it is simple or complex
- If the object is simple it becomes an entity
- If the object is complex it needs to be converted into entities by removing the repeating attributes into a new entity or entities

![create lrdm 1](http://snag.gy/47rEB.jpg)

- We see by inspection that the customer object and product object are simple, so they become entities
- The order object however is complex and so must be converted into two entites
	- One for those attributes that are unique for each instance
	- And another for those that are not
- Of course we must attend to other matters such as keys and foreign keys (later)

![create lrdm 2](http://snag.gy/LQvOx.jpg)

### Notes

- The relationships are actually drawn to help the reader, not the database software
	- In reality, the way a computer program moves from one entity to another is by matching attributes in one entity with attributes in another
	- A key of an entity is normally called a primary key
	- The attribute in the partner entity that matches is referred to as the foreign key
- Although this introduces duplication of keys it is necessary for the software to do the matching

## Rules for data models

- All entities must have keys
- All entities must be regular
	- Contain unique attributes
		- Cannot occur anywhere else in the data model, except for keys
	- Contain non-repeating attributes
		- ie. `{telephone-no}` not allowed
	- Cheats such as `telephone-no-1`, `telephone-no-2` not allowed
- Foreign keys needed to navigate between entities
- Not necessary to store calculated or derived attributes as these can be calculated from other attributes
- Across all entities, every attribute in the system must be stored
- Only require one to many relationships

## Data model navigation

- So we can see how to create a data model, but how do we use it in practice?
- Let's imagine that we have a small system that produces only two outputs from our database
	- One is a report
	- The other is a web page
- The next few examples illustrate how the same database can be used to provide two different outputs

## Example: Order form

![order form](http://snag.gy/rb5aX.jpg)

### LRDM

![order form lrdm](http://snag.gy/Ea820.jpg)

### Data model navigation

1. Get `order-no`, `order-date` and `cust-no` from `ORDER HEADER` by matching on `order-no`
2. Go to `ORDER LINE` via `contains` relationship
3. Obtain `item-no`, `ord-qty` and `prod-code` from `ORDER LINE` by a partial match on `order-no`
4. Go to `PRODUCT` via `describes` relationship
5. Obtain `prod_desc` and `uom` from `PRODUCT` by matching on `prod-code`

Steps 3, 4 and 5 are repeated for each line within the `contains` relationship.

## Example: Web page

![web page](http://snag.gy/U0v1H.jpg)

### LRDM

![web page lrdm](http://snag.gy/oMvFk.jpg)

### Data model navigation

1. Get `cust-no`, `cust-name` and `cust-addr` from `CUSTOMER` by matching on `cust-no`
2. Go to `ORDER` via `places` relationship
3. Obtain `order-no` and `order-date` by matching on `cust-no`

Repeat Step 3 for all matches on `cust-no`

## Data model navigation

- The above examples showed what a database is and how it works
- It showed how the same attributes in the same entities can be used in different outputs
- This raises an important question
	- How does the analyst know for sure that all the entities, attributes and relationship are going to be needed somewhere within the system at some point?
- This is what data model navigation is used for
- Data model navigation is a confirmation technique performed after the systems analyst has drawn the data model, and has two purposes
	1. The first check is to confirm if all the necessary attributes across all outputs exist somewhere in the data model
	2. The second check is in the form of a data model navigation check
		- Here we work through the data model, moving from one entity to another via the relationships
		- This confirms that all the necessary relationships exist to support the outputs

## Why database?

- The main alternative to databases is a file based approach
- With files, there are no rules
	- Many files are allowed to exist
		- ie. It would be quite common to see the same data being repeated in different files
		- With databases, this is not allowed
- This has a number of implications
	- Duplication of data causes redundancy
		- Why is redundancy bad?
			- Because it means that effort is used unnecessarily in maintaining the data
				- ie. A new customer or a change of address may be recorded several times
	- Data is likely to be inconsistent at any point in time
		- There is no way to say a change of customer address is going to be updated simultaneously
			- Therefore the files will be *inconsistent* with each other across all the changes arising in a business
		- Even in computerised systems, one file may be updated weekly, but in another system, the same event is not updated until the end of the month
			- So, th4e4re may be three weeks while the systems are inconsistent
- The cost of changes to the data can be significant
	- The examples here are trivial compared to many real world situations
- There is no standard design solution for a given problem
	- Files can be designed in different ways to meet a perceived problem
	- Even the attribute format can vary between solutions
		- ie. Smith J vs. John Smith, can't happen if every attribute is unique
- The typical size in bytes of a database system is much less because of the **no redundancy** rule
	- Assume the following:
		- 500 customers
		- 1000 invoices with an average of 5 lines to be stored at any one time
		- 700 products
	- How much storage space in characters or bytes would it take to store 1000 invoices?
	- Remember that over 1000 invoices the same customer address and product description would likely repeat many times
		- Not so in a database

### Message

- A solution which stores only one occurrence of each attribute required by the information system and which allows access to all authorised users addresses many of the above problems
- In essence this is a database

## Notational changes

- The conceptual model uses a different notation from the logical relational data model
	- We do this in this unit to help make the distinction clearer
	- In the literature you will find that both notations are used in an arbitrary manner
- The conceptual model uses **Chen's** notation
- The logical relational model uses **Crow's foot** notation
- The following summarises the changes:

![crows foot](http://snag.gy/XnRe4.jpg)

## One-to-many relationships

![one-to-many](http://snag.gy/h3tFN.jpg)

## Many-to-many relationships

- There are no many-to-many relationships in LRDM
- Many-to-many relationships cannot be implemented directly onto a relational database without breaking the rules of an entity
	- ie. That it must be simple
- Using a standard transform, the many-to-many relationships can be eliminated by adding an intermediate entity as we did for the `marks` object in a previous lecture

## One-to-one relationships

![one-to-one 1](http://snag.gy/S8nI5.jpg)

![one-to-one 2](http://snag.gy/IuMyp.jpg)

![one-to-one 3](http://snag.gy/0NKYw.jpg)

## Foreign keys

- A foreign key are attribute/s in one entity which is the key of another entity
- It is used in a relational database to move from one entity to another
	- It is a kind of *look-up* device in which having obtained the value of an attribute in one entity, you can then go to another entity and find an occurrence by matching the value with an attribute in the new entity
- This means we have introduced redundancy to into the data model because there will now be two occurrences of the same attribute in different entities


### Two situations for foreign keys

- Where the foreign key becomes a non-key attribute
	- `order-line` = _order-no* + item-no_ + `qty` + `prod-code*` (italics = underlined)
	- `prod-code` is a non-key attribute
- Where the foreign key becomes part of a multiple key in the other entity
	- `order-line` = _order-no* + item-no_ + `qty` + `prod-code*` (italics = underlined)
	- `order-no` is a key in entity `ORDER`
- Underline denotes key fields
- Asterisk denotes foreign key

## Many-to-many alternative

`ASSIGNMENT` has been converted from many-to-many to one-to-many.

![many-to-many alternative](http://snag.gy/Pa4nA.jpg)

## The Logical Relational Data Model

### Add state attributes

Suppose a company wished to store the name of the employee's spouse. The conceptual model might be:

![spouse](http://snag.gy/g3TjF.jpg)

Then the logical relational data model could be a merged entity such as:

![spouse entity](http://snag.gy/hhbH7.jpg)

Now if the employee is not married, `spouse-name` will be null. In other words, we could always work out whether an employee is married by checking wither `spouse_name` is null or not.

Rather than doing this, you should add a status attribute - in this case it could be called `marital_status` and have states, say `M` for married, `U` for unmarried. Only if `marital_status` was `U` would `spouse_name` be null.

### Remove recursive relationships

Recursive relationships, like many-to-many relationships cannot be directly implemented into a relational database. However, since controlled redundancy is legitimate in the logical relational data model, it is possible to apply a standard transformation, similar to the many-to-many.

![recursive](http://snag.gy/5da2U.jpg)

`rel-no` is the `emp-no` of the employee's boss or subordinate.  
`rel-type` is a status attribute indicating whether the `rel-no` is a boss or subordinate.

## Review

Define:

- Entity
	- Also known as relation
	- Something of interest or relevance to the organisation about which data is likely to be stored
		- Entity name is always singular, never plural
		- Drawn as a rectangle on the data model
- Entity occurrence
	- Also known as tuple
	- An instance of an entity
- Attribute
	- Data related to the entity
- Key
	- Distinguishes an entity occurrence from all other occurrences
	- Each entity must have at least one key
		- Look for the fewest number of attributes to define key
	- Keys are underlined
- Foreign key
	- An attribute from one entity which forms a key of another entity
	- Used as a look-up device to match values with another entity
	- Creates a controlled redundancy since two attributes exist in two or more entities
- Duplication
	- Redundancy
- Inconsistency
	- Changes in one file is not updated to another
- Crow's foot notation
	- Notation for LRDM
	- The *feet* represent the relationship type, one-to-one or one-to-many
	- The notch, or 1, represents **must** relationship
	- The circle, or 0, represents **may** relationship
	- Many-to-many does not exist
