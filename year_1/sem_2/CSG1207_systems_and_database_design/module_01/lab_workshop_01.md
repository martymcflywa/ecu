# Systems and database design workshop 1

## Background

Normalisation is the process by which a flat file (list) of data may be converted into a set of well-structured relations. A set of well-structured relations contain the minimum amount of data redundancy, and allows users to insert, delete and modify rows in a table without producing anomalies, errors or inconsistencies.

When designing a database, an analyst/programmer is often provided with a form, report or spreadsheet that is currently used by an organisation. This format of information may serve the basic needs of the organisation, but does not usually represent a well-structured set of relations and hence often contains redundant data and suffers from anomalies. One form or spreadsheet will usually not represent a single table in a database. By following the steps of normalisation, we can systematically turn a flat file of data into a set of well-structured relations.

Databases are made up of tables, or relations. Each table in the database corresponds to a normalised relation. This workshop enables you to practice creating unnormalised data sets from forms and identifying repeating groups (0NF) - the first step in producing a set of normalised relations. It also tests general knowledge of topics covered in the lecture.

## Task 1

Answer the following review questions:

1. Name and describe the five components of a DBMS environment
	- Hardware
		- Media to store data
		- Can range from a PC to a network of computers
2. Define the terms relation, attribute and tuple in context of relational databases, and define them to the common SQL terminology
	- Relation : Table
		- A two-dimensional table of related data
			- Has columns/rows like a spreadsheet
	- Attribute : Column
		- A named column of a relation
	- Tuple : Row
		- A row of a relation
3. Name and describe the three data anomalies
	- Insertion anomaly
		- Adding a new row into a table generates duplication of data
	- Deletion anomaly
		- Deleting a single piece of data results in loss of valid data on the same row
	- Update anomaly
		- Data is stored repeatedly in one table, and any updates to the data requires multiple changes
4. What are the primary and foreign keys, and how are they related?
	- Primary key
		- One or more columns in a table that uniquely identifies each row
			- Denoted by underline and/or bolding the name of the primary key attribute
	- Foreign key
		- A column in a table that refers to the primary key of another table
			- Foreign keys do not have to be unique, since a single row in one table may relate to multiple rows in another table
			- Denoted by italicising the attribute name
			- Defines relationships between rows in different tables
5. What does normalisation aim to achieve?
	- Converts flat files of data into a set of well-structured relations/tables
		- Contains the minimum amount of redundancy
		- Allows modification of rows in table without producing anomalies, errors or inconsistencies
		- Defines and maintains relationships between relations/tables
6. What are derived attributes, and why should they be omitted from data sets?
	- Derived attributes are attributes that are calculated or obtained from existing attributes
		- Omit derived attributes to avoid redundancy and out-of-date data

## Task 2

Create an unnormalised data set from the following table:

![task 2](http://snag.gy/RY9NP.jpg)

R1 = (Plan#, PlanName, Quota, Cost, {Cust#, CustName, CustPhone})

## Task 3

Create an unnormalised data set from the following form:

![task 3](http://snag.gy/vuXhc.jpg)

R1 = (Meeting#, DateTime, Room, ProjectCode, ProjectTitle, MeetingTopic, MeetingDuration, {Staff#, StaffName})

## Task 4

Create an unnormalised data set from the following form:

![task 4](http://snag.gy/ZOjZt.jpg)

R1 = (Invoice#, InvoiceDate, Username, CustomerName, Phone, Address, {Item#, ItemName, Cat#, CatName, Qty, Cost})

## Tutorial

![tutorial](http://snag.gy/jxAa4.jpg)

R1 = (Customer#, CustomerName, CustomerAddress, CustomerPhone, {Invoice#, InvoiceDate, Item#, ItemDescription, Qty, UnitPrice, GSTCode})