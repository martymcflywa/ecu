# Entity-Relationship modelling

## Review

### Anomaly recap

- Insertion anomaly
	- To add a new row into a database/table requires duplication of data that already exists
	- Occur when in order to add details about something, unrelated or duplicate details must be added
- Deletion anomaly
	- The deletion of a single piece of data results in a loss of valid data on the same row
	- Opposite of insertion anomaly
- Update anomaly
	- The same data is stored repeatedly in one table, hence any updates to the data requires multiple changes
	- Have to update multiple things
- Once normalised to 3NF, attributes are

#### Anomaly example

![driver](http://snag.gy/M5A8h.jpg)

#### 0NF

>R1 = (Driver#, DriverName, {Race#, RaceDate, Car#, CarClass, ClassLimit, Owner, OwnerPhone})

- Anomalies
	- R1
		- Insert
		- Delete
		- Update

#### 1NF

**Remove repeating groups.**

>R11 = (<ins>**Driver#**</ins>, DriverName)  
R12 = (<ins>**_Driver#_**</ins>, <ins>**Race#**</ins>, RaceDate, Car#, CarClass, ClassLimit, OwnerPhone, OwnerName)

![R11](http://snag.gy/GVbGK.jpg)

![R12](http://snag.gy/diIYy.jpg)

- Anomalies
	- R11
		- None
	- R12
		- Insert
		- Delete
		- Update

#### 2NF

**Remove partial dependencies.**

>R11 = (<ins>**Driver#**</ins>, DriverName)  
R121 = (<ins>**_Driver#_**</ins>, <ins>**_Race#_**</ins>, Car#, CarClass, ClassLimit, OwnerPhone, OwnerName)  
R122 = (<ins>**Race#**</ins>, RaceDate)

![R11](http://snag.gy/GVbGK.jpg)

![R121 & R122](http://snag.gy/tSJMQ.jpg)

- Anomalies
	- R11
		- None
	- R121
		- Insert
		- Delete
		- Update
	- R122
		- None

#### 3NF

**Remove transitive dependencies.**

>R11 = (<ins>**Driver#**</ins>, DriverName)  
R1211 = (<ins>**_Driver#_**</ins>, <ins>**_Race#_**</ins>, *Car#*)  
R12121 = (<ins>**Car#**</ins>, *CarClass*, *OwnerPhone*)  
R12122 = (<ins>**CarClass**</ins>, ClassLimit)  
R12123 = (<ins>**OwnerPhone**</ins>, OwnerName)  
R122 = (<ins>**Race#**</ins>, RaceDate)

- Anomalies
	- R11
		- None
	- R1211
		- None
	- R12121
		- None
	- R12122
		- None
	- R12123
		- None
	- R122
		- None

### Review conclusion

- Only by 3NF will a dataset no longer suffer from insertion, deletion or update anomalies
- To check that your database is in 3NF, look for
	- Repeated groups
	- Partial dependencies
	- Transitive dependencies
	- Potential anomalies

## What is Entity Relationship modelling

- A set of diagrammatic standards for depicting the **structure** of a database, both **logically** and **physically**
- Proposed by Peter Chen in 1976
- ER models consist of three main parts
	1. Entities
	2. Relationships
		- One-to-one
		- One-to-many
		- Many-to-many
	3. Attributes
		- Primary keys
		- Foreign keys
		- Non-key attributes
- These are depicted via a specialized symbolic notation

## Entities

- An entity
	- Is a thing
	- Is capable of an *independent* existence
	- May be uniquely identified
	- Usually holds at least two attributes
		- This may just be a PK and one other attribute

As a general rule:

>If you need to store data about many properties of some thing, then that thing is likely to be an entity. (Beynon-Davies, 1996, p. 163)

- In ER models, an entity is represented by a box with the name of the entity in it, for example:

![er entitiy](http://snag.gy/iKX9y.jpg)

- **Note:**
	- **Logical** model entities are usually drawn with **rounded** corners
	- **Physical** model entities are usually drawn with **square** corners
	- So they can be distinguished from each other
	- No restrictions on size and colour

### Naming entities

- The names of entities should be **singular** and must be **unique**
	- Two entities cannot have the same name
- The entity name refers to a **single instance**, no to the whole table
	- In database terms, a tuple/record/row
	- For example
		- Account rather than Accounts
		- Customer rather than Customer File or Customers
		- Product rather than Product Catalogue
		- Historical Transaction rather than Transaction History
		- Scheduled Visit rather than Visiting Schedule
- Use a consistent naming scheme, and consistent word delimination
	- ie. Spaces, underscores, hyphens, capitals
	- This applies to naming tables/fields in databases as well
- The rules for naming entities on the previous slide exist for these reasons
	- **Consistency:**
		- Both internally consistent, and to conform with standard for entity naming in ER modelling
	- **Communication:**
		- An entity is something we want to keep information about, rather than a group
	- **Compatibility with relationship names:**
		- If hoping to translate entity names to relationship names, for implementation in a database directly, avoid spaces and hyphens
			- ie. StudentEnrolment not Student Enrolment

### Defining entities

- It is a wise practice to write definitions of every entity you create at some point during the development process
- A good entity definition will clearly answer three questions
	1. What does this entity represent and what is its role or purpose within the organisation/database?
	2.  What distinguishes instances of this entity from instances of other entities?
	3. What distinguishes one instance from another of the same entity?
		ie. Primary key attribute?

## Relationships

- A **relationship** indicates a connection between two entities
	ie. Between the primary key of one entitiy, to a foreign key in another
- Is shown on the model as a **line** between two entities involved in the relationship
	- The start and/or end of the line depicts the type of relationship
- There are three types of relationships
	1. One-to-one
		- 1:1
	2. One-to-many
		- 1:M
		- 1:&infin;
	3. Many-to-many
		- M:M
		- &infin;:&infin;

### One-to-one relationship

**For each instance of entity A, there is one related instance of entity B.**

![one-to-one](http://snag.gy/9I22e.jpg)

- Shown via a simple straight line joining two entities
- **Note:**
	- Where this type of relationship exists, the entities joined may have the same primary keys and thus it is often questioned whether or not the two entities should be separate
	- Thus while the model acknowledges the 1:1 existence, it is not often used or seen in full-scale relational databases

### One-to-many relationship

**For each instance of entity A, there is one or more related instances of entity B.**

![one-to-many](http://snag.gy/6YCFy.jpg)

- Shown via a straight line with a *crow's foot* on the **many side** of the relationship
	- **Note:**
		- Where this type of relationship exists, the **primary key** of the **1-side** of the relation is present as a **foreign key** in the **many side**
		- This is the most common relationship used in database modelling and as such will occur in almost every ER model you will create

### Many-to-many relationship

**For each instance of entity A, there is one or more related instances of entity B and vice versa**

![many-to-many](http://snag.gy/e8NxF.jpg)

- Shown via a line with *crow's feet* on both ends
	- **Note:**
		- Where this type of relationship exists, the **primary keys** of each entity **exists** as a **foreign key** in the other
		- Due to the complexity in actually implementing the logic behind this type of relationship, they **must** be **resolved** in a **physical** ER diagram
			- Cannot implement a M:M relationship in an actual database

### Resolving a many-to-many relationship

- A many-to-many relationship exists between the entities of student and unit
	- Many students in one unit
	- One unit has many students
- This cannot be managed with PK/FKs

![m:m student unit](http://snag.gy/qeWP2.jpg)

- The relationship must be resolved by **introducing a new entity between them**, hence forming two 1:M relationships

#### Resolving many-to-many example

- Another example
- Since resolving a M:M is usually done in **physical ER** diagrams, the entities have square corners

![resolving m:m example](http://snag.gy/lMX1C.jpg)

#### Steps to resolve many-to-many relationships

1. A new entity is created as an intermediary between the two existing entities
2. The original entities both form a 1:M relationship with the intermediary entity
3. The new entity inherits the primary key attributes of the two original entities as **foreign keys**
	- These may also become compound primary key for the new entity, but it is common to create an auto-incrementing integer field to act as a primary key instead
	- These may be the **only** attributes in the new entity, but not always
		- ie. Items in an order will have a quantity attribute

#### Naming the intermediary entity

- When naming the newly created intermediary entity, firstly consider if the new entity is akin to any **real life** object or term
	- ie. Attendee, Enrolment, Appointment etc.

**Specific:**

![specific](http://snag.gy/Rnk4f.jpg)

- If no specific term is apparent, a common technique is to name the new entity with a hybrid of the two original entities
	- ie. OrderItem, LawyerCase etc.

**Hybrid:**

![hybrid](http://snag.gy/jN2TV.jpg)

### When to resolve many-to-many relationships

- **Logical ER diagrams** represent the logical structure of a database - how it is structured **in theory**
	- Only resolve M:M relationships if the **intermediary entity** contains **meaningful attributes** other than the foreign keys
		- For example
			- Quantity of items in an order
			- Academic period and result of a student's enrolment in a unit
		- The logical structure of the database would be incomplete if the intermediary table was not shown in the logical ER diagram
	- If the intermediary entity **doesn't contain** anything other than the **two foreign keys**, it can be left unresolved in a logical diagram
- **Physical ER diagrams** represent the physical structure of a database - how it is actually structured, for implementation
	- M:M relationships must **always be resolved**

### Naming relationships

- While not necessary, giving relationships between entities in an ER diagram a name can help to convey meaning
	- Most of the time the meaning of a relationship is obvious
	- In some situations, the meaning could be unclear
- If the meaning of a relationship is **unclear**, naming the relationship may be worthwhile

![named relationships](http://snag.gy/lqNnC.jpg)

## Cardinality

![surgeon operation](http://snag.gy/8Fo5X.jpg)

- Given the above ER model, you may discern:
	- A Surgeon entity and an Operation entity exists
	- Each Operation may be associated with only one Surgeon
	- Each Surgeon may be associated with many Operations
- To increase the amount of information depicted my a model, you may indicate the **cardinality** of each end of a relationship as being mandatory or optional
	- Ideally, you should indicate the cardinality for **all** relationships

![mandatory optional](http://snag.gy/d4XC0.jpg)

- In the example above, each operation **must** be managed by a surgeon, but each surgeon **may** manage zero or more operations
	- For each instance of the surgeon entity, there **may** be one or more instances of the operation entity related to it
	- For each instance of the operation entity, there **must** be a related instance of the surgeon entity

![optional optional](http://snag.gy/r4qcV.jpg)

- In the example above, each operation **may** (or may not - zero or one) be managed by a surgeon, and each surgeon **may** manage zero or more operations
	- For each instance of the surgeon entity, there **may** be one or more instances of the operation entity related to it
	- For each instance of the operation entity, there **may** be a related instance of the surgeon entity

![mandatory mandatory](http://snag.gy/KFeEM.jpg)

- In the example above, each surgeon **must** manage at least one operation and each operation **must** be managed by a surgeon
	- For each instance of the surgeon entity, there **must** be one or more instances of the operation entity related to it
	- For each instance of the operation entity, there **must** be a related instance of the surgeon entity

## Attributes

- To add detail and value to an ER diagram, **attributes** of entities should be shown
	- ie. What data is stored about each entity
- A good place to start is with the **primary keys**
	- By this stage you should have a clear understanding of likely primary keys and their correct placement
- Primary keys are usually depicted alongside their associated entity and <ins>underlined</ins>
	- Sometimes also <ins>**bolded**</ins> too
- **Non-key attributes** are then listed in order of priorty/logic after the primary key attribute/s, separated by commas

![attributes](http://snag.gy/sk73t.jpg)

### Alternative attribute notations

- Two other ways to indicate the attributes of an entity
	- The first, used by the Oracle CASE tool, is to place the attributes **inside** the entity

![inside](http://snag.gy/9NfB6.jpg)

- The other is to list the attributes of each entity below the model

![below](http://snag.gy/diNVl.jpg)

### Foreign keys in ER models

- Foreign keys have been left to last due to the ability to depict both **logical** and **physical** models in ER diagrams
- It is typical for a **logical** ER diagram to **leave out** foreign keys altogether, as their implementation and usage is of a more physical nature
	- In the **logical** model, the line between two entities is all that is needed to depict a relationship
		- The existence of a foreign key to create the link between entities is assumed, and does not need to be included
	- In the **physical** model, the foreign key should be included in the attribute list as appropriate
		- Since physical models aim to depict the implementable structure of the database, the foreign key attributes must be included

### Logical to physical foreign key transfer

- To convert a logical model into a physical model, you first start with a completed logical model

![logical model](http://snag.gy/Od1nn.jpg)

- In the physical model, foreign keys must be depicted
- Add the primary key of the **one** side to the **many** side
	- This is a foreign key, so it is *italicised*

![transfer fk](http://snag.gy/xbzl2.jpg)

- **Important:** Foreign keys always flow from **one-to-many** , never from **many-to-one**

### Logical to physical diagram summary

- **Logical ER diagrams**
	- Rounded corners for entities
	- Do not need to show foreign key attributes
	- Only resolve M:M relationships if the intermediary entity contains attributes other than the two foreign keys
- **Physical ER diagrams**
	- Square corners for entities
	- Need to show foreign key attributes
	- Resolve all M:M relationships
- Attributes and cardinality are shown on **both** diagrams
	- Cardinality should be shown on **both** ends of **all** relationships

## Entities for lists of values

- As entities represent the tables that will be implemented in a database, it is important to strive for optimal efficiency and minimal redundancy
- An important aspect of this is defining entities to **hold lists** of largely pre-determined data
	- Ofter referred to as **look-up tables** when implemented
- These entities are typically used to store a list of valid values for an attribute of another entity
	- For example
		- Study mode and load of a student's course enrolment
		- Type or pay level of a staff member
		- Most scenarious involving a **type**, **mode**, **status** etc. attribute that indicate there is a specific set of valid attributes
- These entities may store additional data, but may simply store the names/values and associated ID numbers
	- ie. Salary and superannuation rate for pay levels

![lists of values](http://snag.gy/whXwg.jpg)

- Why do we do this?
	- If the value was simply stored as an attribute, it could be entered inconsistently
		- FT, Full Time, Fulltime, Full-time
	- No need to store these values more than once
		- Store them in their own tables/entities, then use their IDs in relationships
	- Updating a value involves updating only one row, compared to may rows
		- "Pay Level A" renamed to "Pay Level 1"

## Creating ER models from problem statements

- A common task for programmer/analyst is to create an ER diagram from a *problem statement* provided by a client
- Initial ER models tend to need revision, but they provide a starting point for database design and implementation
- Problem statements may be
	- Described in person by the client in a formal meeting
	- Presented in written form in a project scope/plan document
	- Described by several different people in different areas
	- Picked up by a site visit
	- Picked up by a collection of forms, discussions, documents
	- Helpfully drawn in "a way that makes sense to me" by the client on the back of a dirty napkin after a few beers

### Problem statement example

>In a given housing unit at any one time, there may be a given number of tenants. Each of these tenants owns specific appliances, however it is possible for certain appliances to be jointly owned by two or more tenants.

>The strata company requires a database that will allow tenants to track which appliances they have ownership of, and the value of the appliances, to allow the fair distribution of property when a unit is vacated.

>At the moment, each tenant fills out a form with his or her driver's license details along with the serial number, brand, description and cost of any appliance they own.

- On the basis of the problem statement, create a logical ER diagram, and then convert it into a physical one
- For the sake of simplicity, we will assume the following:
	- A tenant will only ever live in one unit
	- Ownership of the unit is **not** important/relevant
	- Every tenant has a driver's license
		- As an identifying field
- The steps we need to take are
	1. Identify the entities and their attributes
	2. Identify relationships between entities
	3. Create the logical ER diagram
	4. Convert the logical model to a physical diagram

#### Step 1

- Based on the problem description, what *entities* have we identified, and what are the **primary keys** and other attributes
- Entity 1: Unit
	- PK: Unit#
- Entity 2: Tenant
	- PK: DriversLicense
	- Name
	- FK: Unit#
	- FK: ApplianceSerial#
- Entity 3: Appliance
	- PK: ApplianceSerial#
	- Brand
	- Description
	- Cost
- More?

#### Step 2 & 3

- Now that we've defined the entities, we need to identify the relationships and put together our logical ER diagram

![logical dummy](http://snag.gy/qbHpl.jpg)

#### Step 4

- Last step is to convert the logical ERD into a physical ERD
	- Round to sharp corners
	- Show all foreign keys
	- Resolve all M:M relationships

![converted physical](http://snag.gy/VmGFC.jpg)

## Creating ER models from normalised relations

- In previous weeks we applied the normalisation process to produce sets of well-structured relations

>**Student** = (<ins>StudentNum</ins>, StudentName)  
**Enrolment** = (<ins>*StudentNum*</ins>, <ins>*UnitCode*</ins>)  
**Unit** = (<ins>UnitCode</ins>, UnitName)

- Converting normalisation results to an ER diagram is usually very straightforward and logical
	- Each relation corresponds to an entity in the ER diagram
		- The name of the relation becomes the name of the entity, and all attributes are carried across
	- Each primary to foreign key link between relations corresponds to a 1:M (or 1:1) relationship in the ER diagram

Hence:

>**Student** = (<ins>StudentNum</ins>, StudentName)  
**Enrolment** = (<ins>*StudentNum*</ins>, <ins>*UnitCode*</ins>)  
**Unit** = (<ins>UnitCode</ins>, UnitName)

Becomes:

![student physical er](http://snag.gy/trNEV.jpg)

**Note:** The ERD produced from normalised data sets is **physical**, due to the inclusion of the foreign keys.

### Example

Now try creating a model for the car race example:

>**Driver** = (<ins>Driver#</ins>, DriverName)  
**RaceEntry** = (<ins>*Driver#*</ins>, <ins>*Race#*</ins>, <ins>*Car#*</ins>)  
**Car** = (<ins>Car#</ins>, CarClass, *Owner*)  
**CarClass** = (<ins>CarClass</ins>, ClassLimit)  
**Owner** = (<ins>OwnerPhone</ins>, OwnerName)  
**Race** = (<ins>Race#</ins>, RaceDate)

![driver physical er](http://snag.gy/djk3D.jpg)
