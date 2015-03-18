# Systems and database design workshop 4

## Background

Entity relationship modelling allows us to design and model a database in a visual manner. ER diagrams consist of entities, the relationships between them, and the attributes of those relationships. Other aspects of ER modelling, such as cardinality, allow us to depict more detail and information in diagrams.

Enhanced ER modelling allows for the depiction of more sophisticated aspects of a system, particularly in relation to the relationships between entities. Multiple relationships occur when two entities are linked in more than one way, self-referencing relationships occur when a given entity has a recursive relationship with itself and supertypes and subtypes provide a sophisticated and efficient way to represent related entities.

## Task 1

Answer the following review questions:

### 1:

Name two possible situations where you may encounter a self-referencing relationship and draw a physical ER diagram for each.

![1-1](http://snag.gy/GOJf6.jpg)

### 2:

What must be taken into account for attribute names when multiple relationships exist between two entities?

Give foreign keys **meaningful** names. Also consider naming the relationships.

### 3:

Create an ER diagram involving a supertype for a music festival ticket, consisting of a ticket#, sale date and name of ticket holder which has two subtypes:

1. Single stage ticket
	- Includes attributes of stage number and stage location
2. Single show ticket
	- Includes attributes of show number and start time

![1-3](http://snag.gy/e1o3j.jpg)

### 4:

What rules dictate the order of table creation and table dropping?

- Table creation
	- 1 side of 1:M relationship must be created before M side
- Table dropping
	- Mside of 1:M relationship must be dropped before 1 side

### 5:

What is the purpose of a data dictionary?

- Provides all information required to implement database in DBMS
- Names all entities and attributes
- Defines domain of attributes
- Defines PK/FK
- Removes ambiguity

### 6:

Name and describe three commonly known sub-languages of SQL.

- DML
	- Data manipulation language
- DDL
	- Data definition language
- DCL
	- Data control language

## Task 2

Given the ER diagram below, do the following:

![pets and vets](http://snag.gy/DuIJc.jpg)

1. Add cardinality to all relationships in the diagram, stating any assumptions you make
2. Convert to a physical diagram
3. List two possible create and drop orders for the diagram
4. Add an entity named AnimalType which contains a list of animal types (Cat, Dog, etc.), which will have relationships to the Pet entity and the Vet entity
	- A pet can only be one AnimalType, but a vet may specialise in many AnimalTypes
		- And there may be multiple vets who specialise in a specific animal

### 1: Add cardinality

![2-1](http://snag.gy/26v7Z.jpg)

### 2: Convert to physical diagram

![2-2](http://snag.gy/zWZlG.jpg)

- An owner must have at least one pet
- A pet may not have any appointments
- A vet may not have any appointments
- An appointment may not result in a prescription
- A medication may never have been prescribed

### 3: Create/drop orders

#### Create:

1. Owner, Pet, Vet, Appointment, Medication, Prescription
2. Owner, Pet, Medication, Vet, Appointment, Prescription

#### Drop:

1. Prescription, Medication, Appointment, Vet, Pet, Owner
2. Prescription, Appointment, Vet, Medication, Pet, Owner

### 4: Add AnimalType

![2-4](http://snag.gy/nemsj.jpg)

- Animal attribute in Pet is kept, used for specific breed/details
- A vet may not specialise in any AnimalType

## Task 3

Come up with a database scenario and create a physical ER diagram to model it. Aim to include at least 5 entities (including intermediary entities). Your diagram should include entities with multiple relationships, a self-referencing relationship, and supertype/subtypes if you can think of an appropriate scenario.

### Logical

![soldiers logical](http://snag.gy/pBoun.jpg)

### Physical

![soldiers physical](http://snag.gy/JAgs4.jpg)

### Assumptions

- An Ammo type may not be used by a Weapon
- A Weapon may not be used by a Soldier
- A Skill may not be used by a SoldierClass
- A SoldierClass may not be used by a Soldier
- A Soldier may not be part of a Fireteam
- A SoldierFireTeam must be part of a Fireteam
	- A Fireteam will be assigned a Soldier as a FireteamLeader
- A Fireteam must be part of a FireteamSection
- A FireteamSection must be part of a Section
	- A Section will be assigned a Soldier as a SectionCO
	- A SectionCO is also an Instructor to one or many Soldiers
- A Section must be part of a SectionPlatoon
- A SectionPlatoon must be part of a Platoon
	- A Platoon will be assigned a Soldier as a PlatoonCO


## Task 4

Your friend was asked to design a database for a chain of breweries to manage their beer and sales to pubs, but ended up sampling too much beer and came up with the following diagram.

![beer](http://snag.gy/wxKB8.jpg)

The finished database design is due tomorrow, and your friend is too busy talking to a pile of beer keys to finish it, so you've decided to help. You know the diagram has errors and is missing some things that should be shown. You know the following details about the scenario:

- A beer can be made in multiple breweries, not just one
- Orders can consist of more than one beer
- Breweries make more than one beer

Find and correct any errors in the diagram, and make sure that it incorporates the details that you know. The result should be a well-structured physical ER diagram including cardinality. Once this is complete, list the table creation and dropping order for the database, and try to create a data dictionary for it.

### Physical ERD

![3-0](http://snag.gy/f9uXd.jpg)

- All breweries must produce at least one beer
- Each beer is produced in at least one brewery
- Each order must have at least one beer
- Some beers may never have been ordered
- Some pubs may not have made an order

### Data dictionary

![3-0 data definitions](http://snag.gy/Dw0UP.jpg)

#### Create order

1. Brewery
2. BeerType
3. Pub
4. Order
5. Beer
6. BrewBeer
7. OrderBeer

## Task 5

You wish to create a database to store details of Pokemon. The database needs to keep track of Pokemon details, including the moves they can do and which Pokemon they evolve into. Draw a physical ER diagram to model this, using the following guidelinies:

- Pokemon details include
	- Number
	- Name
	- Description
	- Type (fire, water, earth, etc.)
- Move details include
	- Name of move
	- Amount of points it takes to use
- Pokemon can do many moves, and each move can be done by multiple Pokemon
- Different Pokemon learn the same move at a different level
	- This should be included
- Attacks are associated with a type
	- ie. "Water Gun" is a Water type move
- You can assume a Pokemon can only evolve into one other Pokemon, and some do not evolve
	- This should be implemented as a self-referencing relationship
