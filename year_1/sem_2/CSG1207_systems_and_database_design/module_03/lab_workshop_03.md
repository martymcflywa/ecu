# Systems and database design workshop 3

## Background

Entity relationship modelling allows us to design and model a database in a visual manner. ER diagrams consist of entities, the relationships between them (1:1, 1:M, M:M) and the attributes of thos relationships. Other aspects of ER modelling such as cardinality, allow us to depict more detail and information in diagrams.

An ER diagram can be created from a problem statement, or from a normalised set of relations. Both normalisation and ER modelling are database design methods/techniques - they allow us to design and model the structure of a database and ensure that it conforms to the principles of relational databases. An entity in a physical ER diagram corresponds to a normalised relation, and vice versa. As we will explore in upcoming weeks, they also correspond to actual tables in an implemented database.

## Task 1

Answer the following review questions:

1. Briefly describe the following components/concepts of ER modelling, and how they relate to each other:
	- Entity
		- Is a thing
		- Capable of independent existence
		- May be uniquely identified
		- Usually holds at least two attributes
			- PK and non-key attribute
	- Relationship
		- Indicates connection between entities
			- Between primary key of one entity, and foreign key of another
		- Shown on model as a line between two entities involved in a relationship
	- Attribute
		- Attribute is data stored about an entity
		- Includes
			- Primary key/s
				- Identifies entity
			- Foreign keys
				- Links entities to one another
			- Non-key attributes
2. Describe the process of resolving an M:M relationship (see figure 1.1)
	1. A new entity C is created as an intermediary between A and B
	2. Entities A and B both form a 1:M relationship with C
	3. C inherits the primary key attributes of A and B as foreign keys
3. What are the differences between logical and physical ER diagrams, and why do these differences exist?
	- Logical
		- Rounded corners for entities
			- Differentiates between logical and physical ER models
		- Do not need to show foreign key attributes
			- The relationships are demonstrated via lines linking entities
		- Only resolve M:M relationships if the intermediary entity contains attributes other than the foreign keys
	- Physical
		- Square corners
		- Need to show foreign key attributes
			- Used for implementation
		- Resolve all M:M relationships
			- Used for implementation
4. Using an example, explain why 1:1 relationships are uncommon in databases
	- One person has one drivers licence
		- Not required to split into two entities
5. What are the pros and cons of including names for relationships between entities?
	- Pro
		- Clarifies ambiguous relationships
	- Con
		- Relationship may already be obvious
6. Describe the information presented in the following three examples (see figure 1.2)
	- 1.2.1
		- For each instance of C, there may be one or more instances of D related to it
		- For each instance of D, there must be one instance of C related to it
	- 1.2.2
		- For each instance of E, there may be one instance of F related to it
		- For each instance of F, there must be one instance of E related to it
	1.2.3
		- For each instance of G, there must be one or more instances of H related to it
		- For each instance of H, there may one one instance of G related to it

**Figure 1.1**

![figure 1.1](http://snag.gy/3saD1.jpg)

**Figure 1.2**

![figure 1.2](http://snag.gy/B0lNX.jpg)

## Task 2

Create physical ER diagrams for the normalised relations from Task 3, Workshop 2.

State any assumptions you make that influence your diagrams.

### Phone plan

>Plan = (<ins>**Plan#**</ins>, PlanName, Quota, Cost)  
Customer = (<ins>**Cust#**</ins>, *Plan#*, CustName, CustPhone)

#### Assumptions

- There may be plans with no customers
- All customers are signed up to a plan

![phone plan er](http://snag.gy/UjyZ1.jpg)

### Meeting

#### Assumptions

- Projects may not require a meeting
- Some staff may not attend a meeting
- Every meeting must have at least one attendee

>Meeting = (<ins>**Meeting#**</ins>, DateTime, Room, *ProjectCode*, MeetingTopic, MeetingDuration)  
Project = (<ins>**ProjectCode**</ins>, ProjectTitle)  
Attendee = (<ins>**_Meeting#_**</ins>, <ins>**_Staff#_**</ins>)  
Staff = (<ins>**Staff#**</ins>, StaffName)

![meeting er](http://snag.gy/s7X4I.jpg)

### Computer sales

>Invoice = (<ins>**_Invoice#_**</ins>, InvoiceDate, *Username*)  
Customer = (<ins>**Username**</ins>, CustomerName, Phone, Address)  
InvoiceItem = (<ins>**_Invoice#_**</ins>. <ins>**_Item#_**</ins>)  
Item = (<ins>**Item#**</ins>, ItemName, *Cat#*, Cost)  
Category = (<ins>**Cat#**, CatName</ins>)

#### Assumptions

- A customer must have at least one invoice
- An invoice must have at least one invoice item
- An item may never be purchased
- All items must be a category, and all categories must have at least one item in them

![computer sales er](http://snag.gy/j5bR4.jpg)

## Task 3

Create a physical ER diagram from the following set of normalised relations:

>**Player** = (<ins>**Username**</ins>, Password, DoB, RealName, Hobbies)  
**Game** = (<ins>**GameID**</ins>, Name, Description)  
**Play** = (<ins>**Play#**</ins>, *GameID*, StartTime, Duration, *Winner*)  
**PlayPlayer** = (<ins>**_Play#_**</ins>, <ins>**_Username_**</ins>)

>The database is for an online boardgame website. There is a record in the **Play** entity for each game that is started, and a record is added to the **PlayPlayer** entity when a Player joins a game that has been started. The **Winner** foreign key in the **Play** entity refers to a **Username** in the **Player** entity.

### Assumptions

- There may be games in the database that have never been played
- It is possible for a play of a game to have not had a winner
- It is possible for a player to have never played or won a game
- It is not possible for a play of a game to occur without any players joining it
	- A record is not added to the play entity unless the game itself actually starts, which requires a player

![game er](http://snag.gy/G39bF.jpg)

## Task 4

Create a logical ER diagram for the following problem description, and then convert it to a physical ER diagram. Remember to include cardinality on all relationships. State any assumptions you make that influence your diagrams.

>I run a small computer consultancy firm with a number of employees. As well as basic information about the employees (name, DoB, contact details etc.) I need to be able to keep track of what type of role they are able to perform, such as Hardware Technician, Programmer, Software Installer. Most employees can perform multiple roles, and each role has an associated hourly pay.

>I need to keep name and contact details of any customers that have a contract with us. A customer can have multiple contracts at the same time, but each contract is only associated with one customer. Each contract has a name, a description, a starting date and a job type. For example: System development, Software upgrade. No details of job types need to be stored other than their name - it simply makes searching easier. Each contract also has a single employee designated as the project leader. One employee may be the project leader of multiple contracts.

As an additional challenge, try to incorporate the following into your ER diagrams. This can be implemented in a number of ways.

>I need to be able to record the work done by each employee on each contract. The database must record the employee who did work, the contract it was performed on, the date it was performed on, and the hours of work performed. To determine pay, the role which the employee was performing must also be recorded.

### Easy version

#### Notes

- Employee
	- EmployeeID
	- EmployeeName
	- EmployeeDOB
	- EmployeePhone
	- EmployeeAdrs
- Role
	- RoleID
	- RoleName
	- RolePay
- EmployeeRole
	- *EmployeeID*
	- *RoleID*
- Customer
	- CustID
	- CustName
	- CustPhone
	- CustEmail
	- CustAdrs
- Contract
	- Contract#
	- ContractName
	- ContractDescription
	- ContratStartDate
	- *JobType*
- JobType
	- JobType

#### Assumptions

- Every customer must have a contract
	- Otherwise no reason to store details
- Every employee must be able to perform at least one role
- Some roles and job types may not have anything associated with them

![job roles easy](http://snag.gy/Yfywp.jpg)

### Hard version

- EmployeeRole in Work entity is composite of EmployeeRole PK's EmployeeID and RoleID

![job roles hard](http://snag.gy/EwfrP.jpg)

## Task 5

In this week's lecture, we created an ER diagram for the following problem statement:

>In a given housing unit at any one time, there may be a given number of tenants. Each of these tenants owns specific appliances, however it is possible for certain appliances to be jointly owned by two or more tenants.

>The strata company requires a database that will allow tenants to track which appliances they have ownership of, and the value of the appliances, to allow the fair distribution of property when a unit is vacated.

>At the moment, each tenant fills out a form with his or her driver's license details along with the serial number, brand, description and cost of any appliance they own.

A solution we arrived at was based on these three assumptions:

- A tenant will only ever live in one unit
- Ownership of the unit is **not** important/relevant
- Every tenant has a driver's licence (as an identifying feed)

Attempt to create a physical ER diagram which does **not** make these assumptions. That is, the database must account for a tenant living in more than one unit, each unit has an owner (who is a tenant), and not all tenants have a driver's licence.

State any assumptions or decisions you have made in order to incorporate these elements.

### Notes

- Unit
	- **Unit#**
	- UnitAdrs
	- Phone
	- Rent
	- *Owner*
- Residence
	- **_Unit#_**
	- **_TenantID_**
	- RentDateStart
	- RentDateEnd
- Tenant
	- **TenantID**
	- TenantName
	- TenantPhone
- ApplianceOwner
	- **_TenantID_**
	- **_Serial#_**
- Appliance
	- **Serial#**
	- Brand
	- Model
	- Description
	- Cost

### Assumptions

- Units may be empty
- A tenant must be living in a unit
- A tenant can only be the owner of one unit

![tenants](http://snag.gy/r1KCb.jpg)
