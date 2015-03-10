# Systems and database design workshop 2

## Background

Databases are made up of tables, or relations. Each table in the database corresponds to a normalised data set. This workshop enables you to practice the process of normalisation, covering 1NF, 2NF and 3NF, resulting in a normalised set of relations. It also tests general knowledge of topics covered in the lecture.

## Task 1

Answer the following questions:

1. Describe the requirements of 1NF and the process needed to reach it from 0NF
	- Requirements
		- A relation is in 1NF if all its underlying attributes contain atomic values only
			- ie. No repeating groups
	- Process
		1. Identification of primary keys in all groups
		2. Removal of any repeating groups in the unnormalised data set into new relations
		3. Introduction of foreign keys in the relation
			- Essentially splitting the inner and outer parts of repeating groups into separate relations
2. Describe the requirements of 2NF and the process needed to reach it from 1NF
	- Requirements
		- A relation is in 2NF if it is in 1NF, and **every** non-key attribute is **fully dependent** on the entire primary key
	- Process
		1. Remove all **partial dependencies** that exist in the relations
			- A partial dependency occurs when an attribute is not wholly dependent on the **entire** primary key
			- Can only occur in relations that have more than one primary key attribute
				- Compound key
			- Often occurs when the primary key was expanded to include the foreign key after a relation with a repeating group was split
		2. Copy the part of the primary key that the attributes depend on and make it the primary key for the new relation
			- Make the original of the copied primary key the foreign key, since it is now the primary key of the new relation
3. Describe the requirements of 3NF and the process needed to reach it from 2NF
	- Requirements
		- A relation is in 3NF if it is in 2NF and every non-key attribute is **mutually independent**
	- Process
		1. Remove all transitive dependencies between non-key attributes
4. What are partial dependencies and transitive dependencies
	- Partial dependencies
		- When a non-key attribute is not dependent on a compound key as a whole
	- Transitive dependencies
		- When a non-key attribute is dependent on another non-key attribute, not just the designated primary key
5. Why is it useful to use Relational Symbolic Notation (R1, R12, etc.) during normalisation?
	- Makes it easy to trace the relation splitting if an error is found at a later stage of the normalisation
6. Based on your understanding of normalisation, can insert, update and delete anomalies occur when a set of relations is in 3NF? Justify your answer
	- If normalised to 3NF correctly, insert, update and delete anomalies should no longer occur
	- Normalised data is structured in a way that insert, update and delete anomalies no longer occur

## Task 2

The following unnormalised data set represents the basic unversity enrolment example from the first lecture. Normalise it to 3NF.

>R1 = (Student#, StudentName, {UnitCode, UnitName})

### 1NF

>~~R1 = (<ins>**Student#**</ins>, StudentName, {<ins>**UnitCode**</ins>, UnitName})~~  
R11 = (<ins>**Student#**</ins>, StudentName)  
R12 = (<ins>**_Student#_**</ins>, <ins>**UnitCode**</ins>, UnitName)

### 2NF

>R11 = (<ins>**Student#**</ins>, StudentName)  
~~R12 = (<ins>**_Student#_**</ins>, <ins>**UnitCode**</ins>, UnitName)~~  
R121 = (<ins>**_Student#_**</ins>, <ins>**_UnitCode_**</ins>)  
R122 = (<ins>**UnitCode**</ins>, UnitName)

### 3NF

No transitive dependencies, already in 3NF.

>R11 = (<ins>**Student#**</ins>, StudentName)  
R121 = (<ins>**_Student#_**</ins>, <ins>**_UnitCode_**</ins>)  
R122 = (<ins>**UnitCode**</ins>, UnitName)


### Naming

>Student = (<ins>**Student#**</ins>, StudentName)  
Enrolment = (<ins>**_Student#_**</ins>, <ins>**_UnitCode_**</ins>)  
Unit = (<ins>**UnitCode**</ins>, UnitName)

## Task 3

Normalise the unnormalised data sets from Tasks 2, 3 and 4 of the first workshop to 3NF. If you have not completed the first workshop, do it now or use the solutions provided.

### Phone Plan

>R1 = (Plan#, PlanName, Quota, Cost, {Cust#, CustName, CustPhone})

#### 1NF

>~~R1 = (<ins>**Plan#**</ins>, PlanName, Quota, Cost, {<ins>**Cust#**</ins>, CustName, CustPhone})~~  
R11 = (<ins>**Plan#**</ins>, PlanName, Quota, Cost)  
R12 = (<ins>**Cust#**</ins>, *Plan#*, CustName, CustPhone)

#### 2NF

No partial dependencies, already in 2NF.

>R11 = (<ins>**Plan#**</ins>, PlanName, Quota, Cost)  
R12 = (<ins>**Cust#**</ins>, *Plan#*, CustName, CustPhone)

#### 3NF

No transitive dependencies, already in 3NF.

>R11 = (<ins>**Plan#**</ins>, PlanName, Quota, Cost)  
R12 = (<ins>**Cust#**</ins>, *Plan#*, CustName, CustPhone)

#### Naming

>Plan = (<ins>**Plan#**</ins>, PlanName, Quota, Cost)  
Customer = (<ins>**Cust#**</ins>, *Plan#*, CustName, CustPhone)

### Meeting

>R1 = (Meeting#, DateTime, Room, ProjectCode, ProjectTitle, MeetingTopic, MeetingDuration, {Staff#, StaffName})

#### 1NF

>~~R1 = (<ins>**Meeting#**</ins>, DateTime, Room, ProjectCode, ProjectTitle, MeetingTopic, MeetingDuration, {<ins>**Staff#**</ins>, StaffName})~~  
R11 = (<ins>**Meeting#**</ins>, DateTime, Room, ProjectCode, ProjectTitle, MeetingTopic, MeetingDuration)  
R12 = (<ins>**_Meeting#_**</ins>, <ins>**Staff#**</ins>, StaffName)

#### 2NF

>R11 = (<ins>**Meeting#**</ins>, DateTime, Room, ProjectCode, ProjectTitle, MeetingTopic, MeetingDuration)  
~~R12 = (<ins>**_Meeting#_**</ins>, <ins>**Staff#**</ins>, StaffName)~~  
R121 = (<ins>**_Meeting#_**</ins>, <ins>**_Staff#_**</ins>)  
R122 = (<ins>**Staff#**</ins>, StaffName)

#### 3NF

>~~R11 = (<ins>**Meeting#**</ins>, DateTime, Room, ProjectCode, ProjectTitle, MeetingTopic, MeetingDuration)~~  
R111 = (<ins>**Meeting#**</ins>, DateTime, Room, *ProjectCode*, MeetingTopic, MeetingDuration)  
R112 = (<ins>**ProjectCode**</ins>, ProjectTitle)  
R121 = (<ins>**_Meeting#_**</ins>, <ins>**_Staff#_**</ins>)  
R122 = (<ins>**Staff#**</ins>, StaffName)

#### Naming

>Meeting = (<ins>**Meeting#**</ins>, DateTime, Room, *ProjectCode*, MeetingTopic, MeetingDuration)  
Project = (<ins>**ProjectCode**</ins>, ProjectTitle)  
Attendee = (<ins>**_Meeting#_**</ins>, <ins>**_Staff#_**</ins>)  
Staff = (<ins>**Staff#**</ins>, StaffName)

### Computer sales

>R1 = (Invoice#, InvoiceDate, Username, CustomerName, Phone, Address, {Item#, ItemName, Cat#, CatName, Qty, Cost})

#### 1NF

>~~R1 = (<ins>**Invoice#**</ins>, InvoiceDate, Username, CustomerName, Phone, Address, {<ins>**Item#**</ins>, ItemName, Cat#, CatName, Qty, Cost})~~  
R11 = (<ins>**Invoice#**</ins>, InvoiceDate, Username, CustomerName, Phone, Address)  
R12 = (<ins>**_Invoice#_**</ins>. <ins>**Item#**</ins>, ItemName, Cat#, CatName, Qty, Cost)

#### 2NF

>R11 = (<ins>**Invoice#**</ins>, InvoiceDate, Username, CustomerName, Phone, Address)  
~~R12 = (<ins>**_Invoice#_**</ins>. <ins>**Item#**</ins>, ItemName, Cat#, CatName, Qty, Cost)~~  
R121 = (<ins>**_Invoice#_**</ins>. <ins>**_Item#_**</ins>, Qty)  
R122 = (<ins>**Item#**</ins>, ItemName, Cat#, CatName, Cost)

#### 3NF

>~~R11 = (<ins>**Invoice#**</ins>, InvoiceDate, Username, CustomerName, Phone, Address)~~  
R111 = (<ins>**_Invoice#_**</ins>, InvoiceDate, *Username*)  
R112 = (<ins>**Username**</ins>, CustomerName, Phone, Address)

>R121 = (<ins>**_Invoice#_**</ins>. <ins>**_Item#_**</ins>, Qty)  
~~R122 = (<ins>**Item#**</ins>, ItemName, Cat#, CatName, Cost)~~  
R1221 = (<ins>**Item#**</ins>, ItemName, *Cat#*, Cost)  
R1222 = (<ins>**Cat#**, CatName</ins>)

#### Naming

>Invoice = (<ins>**_Invoice#_**</ins>, InvoiceDate, *Username*)  
Customer = (<ins>**Username**</ins>, CustomerName, Phone, Address)  
InvoiceItem = (<ins>**_Invoice#_**</ins>. <ins>**_Item#_**</ins>, Qty)  
Item = (<ins>**Item#**</ins>, ItemName, *Cat#*, Cost)  
Category = (<ins>**Cat#**, CatName</ins>)

## Task 4

Identify the errors in each of the following data sets and relations. State any assumptions that you make in order to validate your answers.

### A: Relations in 3NF

>R111 = (<ins>**Invoice#**</ins>, OrderDate, *Customer#*)  
R112 = (<ins>**Customer#**</ins>, Name, Phone, Address)  
R112 = (<ins>**_Invoice#_**</ins>, <ins>**_Item#_**</ins>, OrderDate, UnitPrice)  
R122 = (<ins>**Item#**</ins>, Description, Qty)

#### Answer:

- OrderDate and UnitPrice assigned to inappropriate relations
- Two relations are called R112

### B: An unnormalised data set

>R1 = (Invoice#, OrderDate, {Customer#, Name, Phone, Address, {Item#, Description, Qty, UnitPrice}})

#### Answer:

- Customer defined as a repeating group
	- Would mean that an invoice would have multiple customers, who in turn have muliple items

### C: Named relations in 3NF

>InvoiceCustomer =  (<ins>**Invoice#**</ins>, OrderDate, *Customer#*, Name, Phone, Address)  
Invoice = (<ins>**Invoice#**</ins>, Customer#)  
InvoiceItem = (<ins>**_Invoice#_**</ins>, <ins>**_Item#_**</ins>, Qty)  
Item = (<ins>**Item#**</ins>, Description, UnitPrice)

#### Answer:

- Customer details should be in separate relation
- Invoice# not indicated as foreign key

### D: Relations in 2NF

>R111 = (<ins>**Invoice#**</ins>, OrderDate, *Customer#*, Name, Phone, Address)  
R112 = (<ins>**_Invoice#_**</ins>, <ins>**_Item#_**</ins>, Description, UnitPrice, Qty)

#### Answer:

- R112 contains partial dependencies
- Item# is a foreign key, but no relation exists with Item# as primary key
