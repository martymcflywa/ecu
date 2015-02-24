# Intro to relational databasaes & normalisation basis

## Introduction to database systems

### What is a database

- Shared collection of logically related data (and a description of this data), designed to meet the information needs of an organisation
	- Shared data
	- Logically related data comprises of entities, attributes, and relationships of an organisation's information
	- Focus on storing data efficiently, without redundancy
- A database typically stores
	- Details of authorised users
	- Names and values of data items in the database
	- Constraints on each data item
	- Data items accessible by a user and the type of access

![simplified overview of database](http://snag.gy/JaqFC.jpg)

### Database management system (DBMS)

- A software system that enables users to define, create, and maintain the database and it provides controlled access to the database/s
- Five components of a DBMS environment
	1. Hardware
		- Media to store data
		- Can range from a PC to a network of computers
	2. Software
		- DBMS
		- Operating system
		- Network software 
			- If necessary
		- Application programs
	3. Data
		- The data needed/used by the organisation
		- A description/definition of this data's format and structure
			- Known as a **schema**
	4. Procedures
		- Instructions and rules that should be applied to the design and use of the database and DBMS
			- For example
				- Database security procedure
				- Backup and recovery
				- Database tuning procedures
	5. People
		- Database administrators
		- Database designers
		- Application developers
		- End users

### The role of a database

- The database is typically not accessed directly by users
	- The database is first designed
		- Covered in the next 4 weeks
	- It is then implemented in a DBMS
		- Covered in Week 5 & Week 7
	- The DBMS hosts the database, making it available for applications to interact with as needed
	- Applications interact with the database
		- Requesting data from it
		- Inserting data into it
		- Updating the data in it
		- Deleting data from it
	- The application sends SQL *(Structured Query Language, see Week 5)*, queries to the DBMS, which executes them and sends the resulting data/response back to the application
	- Users interact with the application, not directly with the database
	- This controls access to the database, allowing policies and procedures to be enforced

![dbms model](http://snag.gy/hfo09.jpg)

### Notes:

- The DBMS may contain multiple databases
- Multiple different applications may interact with a DBMS/database
- The interaction, or application itself, may be over a network or the Internet
	- For example, most modern websites involve a DBMS that a web application written in PHP or ASP.NET interacts with
- In this unit, we focus on the design and implementation of databases, and the SQL used to interact with them

### History of database systems

#### First generation

- 1960s navigational models
	- Hierarchical
		- IBM developed **IMS** (Information Management System)
		- Provided a standardised/simple transaction manager
		- Was too late for Apollo project it was meant to help, but is still in use today in a newer form, with supporting software
	- Network
		- Charles Bachman from General Electric developed **IDS** (Integerated Data Store)
		- **CODASYL**: IT consortium who invented COBOL programming language and developed some of the first standardised DB interfaces

##### Hierarchical model

- High level *parent* records link to lower level *child* records in a **one-to-many** way

![hierarchical model](http://snag.gy/B8SBc.jpg)

##### Network model

- High level *parent* records link to lower level *child* records in a **many-to-many** way

![network model](http://snag.gy/YmzMa.jpg)

#### Second generation

- 1970s and beyond
	- Relational model
		- Edgar Codd from IBM proposed relational model
			- Addressed limitations of navigational models such as lack of searching
		- Disconnects schema from physical storage methods
		- Introduced concept of normalised tables with **key** fields
		- Late 1970s saw release of **SQL** by IBM
			- Widely adopted
		- Oracle, DB2, Informix, Sybase...
		- While they emerged in the 1970s, relational databases became common throughout the 80s and 90s
		- The relational database model and SQL are the norm these days, and they are what this unit focuses upon

#### Third generation

- 1980s, 1990s and beyond
	- Object-oriented databases arise, but have not seen much mainstream use
		- Remains a niche product
	- Merges concepts of databases with those of object-oriented programming, ie. encapsulation
		- Attributes of an object and operations that can be performed upon it are defined/stored in a single unit
	- Involves an Object Definition Language (ODL) and Object Query Language (OQL)
		- Similar to SQL, although with significant extensions to allow for the object-oriented elements

#### Fourth generation

- 2000s and beyond
	- Computing power, storage space and the amount of data to store/process have grown to massive levels
	- This has lead to various solutions often termed *NoSQL* (Not Only SQL) solutions which are non-relational
		- Document-oriented, with flexible/non-fixed structures
		- This area is relatively young and still maturing
	- Focus on speed rather than efficiency
		- Stored in denormalised way that consumes more disk space, but eliminates need for joining tables together
		- More difficult to query in some ways, easier in others

### Basic relational model terminology

- Relation
	- A two-dimensional table of related data
		- Has columns and rows, like a spreadsheet

![relation](http://snag.gy/WypjP.jpg)

- Attribute
	- A named column of a relation
- Domain
	- The set of allowable values for an attribute
- Tuple
	- A row of a relation
- Relational database
	- A collection of normalised relations, each with a distinct relation name

#### Examples of attribute domains

- The domain of an attribute defines the format of the data it relates to, including the name, meaning, data type, restrictions/limitations etc.

![attribute domains](http://snag.gy/pEj8t.jpg)

#### Alternative terminology for relational model

- Different sets of terminology are in use when discussing databases from different perspectives
- The SQL terms are most commonly used when discussing databases

![alternative terminology](http://snag.gy/3hyKh.jpg)

#### Relational database schema

- Table schema
	- Named table defined by a set of column names
		- For example: `Branch = (branchNo, street, city, postcode)`
- Relational database schema
	- Set of table schemas, each with a distinct name
	- Includes all the tables needed to appropriately represent the data that the database needs to capture

#### Properties of relations (tables)

- Table names are distinct from each other in a relational database schema
	- No two tables with the same name
- Each cell of a table contains exactly one single value
- Each column in a table has a distinct name
- Values of a column are all of the same data type
- Each row is distinct
	- There are no duplicate rows
- Order of columns has no significance
- Order of rows has no significance

## Normalisation basics

### What is normalisation?

- Normalisation is a data modelling technique by which a flat file (ie. a *list* or simple spreadsheet) of data may be converted into a set of well-structured relations (tables)
	- Contains the minimum amount of data redundancy
		- No unnecessary repetition of data
	- Allows users to modify rows in a table without producing anomalies, errors or inconsistencies
	- Defines/maintains relationships between relations
- Work through a series of stages, called normal forms
	- First normal form 1NF
	- Second normal form 2NF
	- Third normal form 3NF
	- etc.

### Why normalise?

- To minimise data redundancy in database tables
	- Data should only ever need to be stored once
		- Should not need to duplicate data
- To convert data in forms and spreadsheets into well-structured relational database tables
	- Each table should only contain columns that directly relate to it
		- ie. Student details in student table, unit details in unit table...
	- Relationships between tables are defined/maintained by primary and foreign keys
- The normalisation process ensures that a flat file of data is turned into an efficient and structured set of relations, eliminating any possible anomalies

### Data anomalies

- Three main types of data anomalies
	- Insertion anomalies
	- Deletion anomalies
	- Update anomalies
- These are all indicators that data is being stored in an inefficient/redundant manner
	- ie. flat file
- Storing data in a normalised relational database eliminates these anomalies

#### Insertion anomalies

- An insertion anomaly occurs where:
	- **To add a new row into a table requires duplication of data** that already exists
		- For example, the addition of a new unit would require the addition of student details to complete the row

![insertion anomaly](http://snag.gy/Z51jO.jpg)

#### Deletion anomalies

- A deletion anomaly occurs when:
	- **The deletion of a single piece of data results in a loss of valid data on the same row**
		- For example, removing Student 0972343 will remove all information of the unit CSG1207

![deletion anomaly](http://snag.gy/gEt5w.jpg)

#### Update anomalies

- An update anomaly occurs when:
	- The same data is stored repeatedly in one table, and hence andy **updates to the data requires multiple changes**
		- For example, to rename the unit code CSI12441 to CSG1208 would require updates to multiple rows

![update anomalies](http://snag.gy/gOT0f.jpg)

### Keys

- The term *key* refers to a column (or columns) in a table taht is used to:
	- Uniquely identify each row in the table so that it can be referred to
		- Known as the **Primary Key** (PK)
	- Link two columns in two or more separate tables together
		- Known as the **Foreign Key** (FK)
	- The identification of the correct keys is central to normalisation and databases
		- If the keys are identified correctly, then there is no chance of any of the three previously mentioned anomalies occuring

#### Primary keys (PK)

- A primary key is:
	- **One or more columns in a table that uniquely identifies each row**
- Usually denoted by <u>underlining</u> and/or **bolding** the name of the primary key attribute
	- Example: Student = (**Student#**, Student Name, Address, DOB)
		- Note: No underline in markdown, add underline to bolded keys
- The primary key attribute/s must be unique
	- Two rows cannot have the same primary key data

![primary key](http://snag.gy/bAvzM.jpg)

#### Compound keys

- If two or more columns must be combined to uniquely identify each row, it is a **compound key**
- Denoted in the same way as other primary keys
	- Example: (**Student#**, Student Name, **Unit Code**, Unit Name)
- Either of the two fields may have duplicated entries, but *when combined, they must be unique*

![compound keys](http://snag.gy/BDMO0.jpg)

#### Foreign Keys

- A foreign key is:
	- A column in a table that refers to the primary key of another table
	- Unlike primary keys, foreign keys do not need to be unique
	- Since a single row in one table may relate to multiple rows in another table
		- ie. One course has many students enrolled in it
	- Hence the student table has a "course_code" FK column, which is the PK of the course table
- Foreign keys are usually denoted by *italicising* the name of their attributes
- This allows us to define relationships between rows in different tables
- A foreign key should have the same domain of the primary key it relates to
	- Data type
	- Range constraints

#### Primary and foreign key relationships

![pk fk relationships](http://snag.gy/jtWRt.jpg)

- First we have the Student table, containing student details only
- **Student#** is the primary key, uniquely identifying each student
- Then we have the Unit table, containing unit details only
- **Unit Code** is the primary key, uniquely identifying each unit
- Lastly, we have the Enrolment table, containing enrolment details
- **Enrolment#** is the primary key, an auto incrementing integer
- Student# and Unit Code are foreign keys, linking to their tables
	- Allws us to connect student and unit details with the enrolments

### Normalisation process

- The normalisation process follows a standard series of steps, known ass Normal Forms (NF)
	- 0NF: Gather the unnormalised data set
	- 1NF: Convert to first normal form
	- 2NF: Convert to second normal form
	- 3NF: Convert to third normal form
	- 4NF & 5NF: Exists, but typically 3NF is considered normalised
- **Note:** Unless each step is carried out properly, the next step will be flawed
	- Unless a data set is in first normal form, it will not be in a valid second or third normal form

#### Stages of normalisation

![stages of normalisation](http://snag.gy/PSGnd.jpg)

#### When to end the process?

- 2NF is better than 1NF
- 3NF is better than 2NF
- For most business database design purposes, 3NF is as far as we need to normalise
- 3NF is typically considered *normalised*, and databases in 3NF are usually already in 4NF and 5NF
- Highest level of normalisation is not always most desirable

### Gather unnormalised data sets

- The first step of normalisation involves gathering or identifying an unnormalised data set - a collection of all the attributes (their names, not the data itself) that need to be stored
- Where groups of attributes exist in a nested manner, they are known as repeating groups
	- *Tables within tables*
	- A repeating group is a set of attributes that can have more than one value for a given primary key (value)
	- For example: For a single instance of the *outer* attributes, there can be multiple instances of a group of *inner* attributes
- This step is often rushed, but is perhaps the most critical of the entire normalisation process
	- If the unnormalised data set contains errors, then it is more than likely that these errors will be carried throughout the entire normalisation resulting in possible data anomalies
- Another way of thinking about it is "identifying one-to-many relationships"
	- For example: For a **single instance** of one key, is there a group of attributes within it that can have **many different instances?**
		- One student can have many unit enrolments
			- One Student# and associated student details, many Unit Codes and associated unit details, and vice versa
		- One invoice can have many items
			- One Order# and associated order details, many Item# and associated item details
		- One building can have many rooms
			- One Building# and associated details, many Room# and associated room details
- You may be able to see other related groups of attributes or entities within the data set, but unless they are nested (have a one-to-many relationship with the outer key) they are not repeating groups, and not identified at this stage
- The following enrolments table is unnormalised because it contains repeating groups

![repeating groups](http://snag.gy/JUonJ.jpg)

- Unit code and name can have different content for same student number
- Can be seen from either the **student** or **unit** perspective in this case
	- One unit, many students
- Repeated groups are denoted in curly brackets

R1 = (Student#, Student Name, {Unit Code, Unit Name})

![r1](http://snag.gy/UnlDy.jpg)

R2 = (Unit Code, Unit Name. {Student#, Student Name})

![r2](http://snag.gy/DBP0T.jpg)

#### Some tips

- The following principles should be applied to ensure an easier transition throughout the process
	- Attributes that are likely to be primary keys should be placed to the left of the other attributes that relate to them
	- Repeating groups are usually placed to the right in an unnormalised data set
		- This is simply for a cleaner look before you normalise and split them into separate relations
	- Remember
		- A repeating group represents something that there can be multiple instances of for a single instance of another thing
			- Example: One unit can have many students and vice versa, one building can have many rooms, one door can have many keys

#### Unnormalised example 1

![unnormalised 1](http://snag.gy/IozMX.jpg)

- There can be many staff members in each department
	- R1 = (DepartmentID, DepartmentName, {Staff#, StaffName, DoB})

#### Unnormalised example 2

![unnormalised 2](http://snag.gy/mjuRg.jpg)

- In each invoice, there are multiple items (repeating group)
- Subtotal and total are **derived** attributes and should be excluded from the data set, no need to store them
	- R1 = (Invoice #, Order Date, Customer #, Name, Phone, Address, {Item #, Description, Qty, Unit Price})
- Such fields should always be calculated on the fly, to avoid redundancy and out-of-date data
