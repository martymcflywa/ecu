# Enhanced ER modelling and introduction to SQL

## Review discussion

- Task is to create database for student enrollments
- Details and assumptions
	- Each course contains multiple units
	- One unit can be in multiple courses
	- Each unit has multiple activities
		- ie. Lectures, workshops
	- Students are only allowed to enroll in one course at a time
	- Students can be enrolled in zero or more units and activities at a time
	- Staff members may coordinate one or more courses and may coordinate one or more units
	- Courses can have multiple coordinators
		- Units only have one
	- Staff members may also deliver one or more activities
		- Each activity only requires one staff member to deliver
	- Ensuring students enroll in correct activities for their unit enrollments, and correct unit for course enrollment is ALL TAKEN CARE OF

![uni course erd](http://snag.gy/XS9jA.jpg)

## Enhanced entity relationship (EER) model

- Why EER
	- ERD first introduced in mid 70s
	- Real-world relationships are more complex than what can be depicted via basic ER modelling
	- Need to model more complex data, advanced relationships
		- Self-referencing relationship
		- Supertype and subtype

### Multiple relationships

- In the examples in the previous lectures, there was only **one relationship** between **two given entities**
	- This is **NOT** a rule
- Multiple relationships may occur when two entities are linked in more than one way

#### Example

##### Primary School

- Imagine a primary school database
	- Each class has multiple students
		- ie. Year 6
	- Each class has a Head Boy
	- Each class has a Head Girl
	- Each year must have a Head Boy and a Head Girl, but it is of course not required that each student is a Head Boy or Girl

![class student](http://snag.gy/A1n1K.jpg)

- When multiple relationships exist, it is important to give FKs meaningful names, and consider naming the relationships

##### Flights

>A flight departs from one airport and lands at another.

![flights](http://snag.gy/aom3n.jpg)

##### Groups

>Groups can have many students and must have a leader.

![groups](http://snag.gy/gOTfq.jpg)

### Self-referencing relationships

- A company database, with departments and employees
	- One department may have multiple employees
	- Each department also has a department manager
	- Employees may also mentor other employees in a 1:M way
- This is a self-referencing relationship
- Employee has a recursive relationship with itself

![self-ref 1](http://snag.gy/FvVHn.jpg)

- It is important to give the foreign key which establishes a self-referencing relationship a meaningful name
	- You cannot reuse the name of the primary key
		- Why not?
	- Something like "Employee#_2" is not meaningful
	- Make sure that the name reflects the nature of the relationship
	- Consider naming the relationship as well

![self-ref 2](http://snag.gy/wT5Ab.jpg)

#### Self-referencing M:M

- It is also possible to have a self-referencing many-to-many relationship that will require **resolution**
- Database for friends and their crushes on each other:
	- Each friend may have a crush on many other friends
	- Each friend may be the subject of many crushes
- This is resolved the same as any other M:M relationship

![m:m self-ref](http://snag.gy/qq3Gb.jpg)

- Create intermediary entity
- Flip the relationship
- Add appropriate cardinality

![m:m self-ref logical resolved](http://snag.gy/xM68e.jpg)

- Can be redrawn to look like...
- Physical model
	- Could also use a compound PK in Crush
	- Some friends may not have a crush or be the subject of a crush
		- Relationships are optional

![m:m self-ref physical resolved](http://snag.gy/W7uqK.jpg)

### Supertype and subtype

- Supertypes and subtypes are often overlooked by data modellers, but allow for concise and sophisticated modelling
- A **supertype** is a generic entity with a number of attributes common to all of its subtypes
	- A supertype encapsulates numerous subtypes
	- All encapsulated subtypes inherit their supertype's attributes
- A **subtype** is a more specific entity, which has *distinct* attributes, and possibly relations, of its own
	- Numerous subtypes inside a single supertype
	- Each subtype in a supertype has attributes distinct from both its parent supertype and other subtypes in that parent
- Similar concepts to those in object-oriented programming

>Instead of this:

![no sup/sub type](http://snag.gy/mgOGh.jpg)

>You can do this:

![sup/sub type 1](http://snag.gy/ZmbTu.jpg)

- An instance of a subtype is also an instance of the same parent supertype
	- Primary key of the supertype and subtype always the same
- Always 1:0 cardinality between supertype and subtype, ie:
	- Instance of supertype may have no associated subtype instance
		ie. If it does not have any distinct attributes
	- Every instance of a subtype must have one corresponding instance in the supertype
- Relationships on a supertype apply to all its subtypes
	- Subtypes can have own relationships that apply to them alone

![sup/sub type 2](http://snag.gy/Njs25.jpg)

- The **total specialisation rule** specifies that 1:1 cardinality must exist between supertype and subtype instances
	- Each instance of a supertype **must** have a corresponding instance of a subtype
	- Depicted by a double line between the supertype and circle
	- Previous examples had 1:0 cardinality (the default), depicted by a single line between the supertype and circle
		- Allows for instances of the supertype not to have a corresponding subtype instance
- Nesting is possible
	- A subtype may be a supertype
- Even more things are possible in this area

![total specialisation](http://snag.gy/GSVuw.jpg)

- When it comes to implementing a database design that incorporates supertypes and subtypes, object oriented databases are better suited to it than relational databases
- In a relational database, the subtypes are typically implemented as a number of entities that have a 1:1 relationship with the supertype entity

## Database table creation

- Once a physical model of a normalised system has been created, it is time to **implement** it as an actual database
- The first step is to **create the tables** of your database
- Each entity in your physical model will become a table
- The **order** of table creation is **important**, in order to ensure the existance of primary and foreign keys in relationships
	- You cannot have a foreign key column that refers to a table that has not yet been created

### Order of table creation

- The basic rule to remember when creating tables is:

>The one side of a one-to-many relationship must always be made before the many side

![order of table](http://snag.gy/vZQLm.jpg)

- Creating **Unit**, then **Student**, then **Enrollment** would also be appropriate
	- As long as **Unit** and **Student** are created before **Enrollment**

- Have a go at:

![order of table exercise](http://snag.gy/JOphx.jpg)

- Several orders correct, as long as:
	- **Unit** created before **Tenant**
	- **Appliance** and **Tenant** created before **ApplianceOwner**

### Order of table dropping

- Deleting a table in a database is known as **dropping** it
- The rule to remember for this is:

>All tables with foreign keys be dropped before the table they reference is dropped

- Essentially:

>The many side of a one-to-many relationship must always be dropped before the one side

- In case it isn't obvious:

>The drop order is the reverse of the creation order

### Data dictionaries

- Once a well-structured and normalised database has been designed via normalisation and/or ER modelling, it is almost ready to implement as an actual database in a DBMS
- The last step in a good design is to create a data dictionary
- The data dictionary should contain all the information needed to implement the database in a DBMS
- This includes:
	- The names of all entities and their attributes
	- The domain of all attributes
		- Data types, constraints etc.
	- Details of all primary and foreign keys
	- Written descriptions of entities, attributes, relationships etc, where needed
		- For anything confusing or ambiguous
- Data dictionaries typically take the form of a number of tables
	- One table per entity
	- Order the tables in an appropriate table creation order
		- Or remember to specify this information in the data dictionary
- Data dictionary for our first normalisation example:

![data dictionary: cust order 1](http://snag.gy/5D9LD.jpg)

![data dictionar: cust order 2](http://snag.gy/BUmS3.jpg)

- A data dictionary should contain **everything** that someone needs to know to implement the database in a DBMS
- Some columns of the data dictionary refer to data types and constraints used in the database/DBMS itself
	- We will cover this in upcoming weeks

## Brief introduction to SQL

- Structured Query Language (SQL) is the language used to send commands to a database in a RDBMS, including...
	- Commands to retrieve data from a database
		- Standard SQL queries using the `SELECT` command
	- Commands to insert, update or delete data in a database
		- Data Manipulation Language (DML)
	- Commands to create, modify and delete database schemas
		- Data Definition Language (DDL)
	- Commands to manage users access control to a database
		- Data Control Language (DCL)
- All these languages (DML, DDL, etc.) are part of SQL, and have consistent syntax style and structure
	- They are defined only by their purpose
- SQL is a standardised language supported by just about every RDBMS, but many **variations** exist
	- While the common/basic syntax for most commands remains the same, some commands have different syntax
	- They also add features which are often only supported by certain products who have implemented that variation
	- It is unwise to rely heavily on such features, as this limits your ability to transfer your database from one DBMS to another

### Dropping tables in SQL

- Since we just discussed it, lets start with something simple: Dropping tables in a database using SQL statements
- The syntax for this statement is simply:

``` sql
DROP TABLE <table name>;
```

- In regards to our last example:

``` sql
DROP TABLE ApplianceOwner;
DROP TABLE Appliance;
DROP TABLE Tenant;
DROP TABLE Unit;
```

- Each statement ends with a `;`

### Creasting tables in SQL

- A table creation statement in SQL consists of several basic elements
	- The words `CREATE TABLE`
	- The name of the table
	- An opening parenthesis `(`
	- Column definitions, separated by commas
		- Includes name, data type and other properties of each column
	- Constraint definitions, separated by commans
		- Key fields, unique fields, etc.
	- A closing parenthesis `)`
	- An SQL terminator `;`

#### Example

- Remembering that each entity in your physical ERD maps to a table, let's make a `student` table
	- Some DBMSs do not support `#` in a field name, so we use alphanumeric characters and underscores only

![student](http://snag.gy/5QuU1.jpg)

![student sql](http://snag.gy/FEniO.jpg)

``` sql
CREATE TABLE student (
	student_id INT NOT NULL PRIMARY KEY,
	first_name VARCHAR(20) NOT NULL,
	surname VARCHAR(20) NOT NULL,
	gender CHAR(1) NOT NULL,
	dob DATE NOT NULL,
	phone VARCHAR(10) NULL,
	email VARCHAR(50) NULL,
	height NUMERIC(3,2) NULL
);
```

- Here's another example, this type with a compound key:

![order_item compound key](http://snag.gy/RuJA6.jpg)

``` sql
CREATE TABLE order_item (
	invoice_id INT NOT NULL,
	item_id CHAR(10) NOT NULL,
	qty TINYINT NOT NULL DEFAULT 1,
	CONSTRAINT order_item_pk PRIMARY KEY (invoice_id, item_id)
);
```

### Foreign keys

- The foreign key, or *referential integrity constraint*, designates a column, or combination of columns, as a foreign key and establishes a relationship to a primary key (or unique key) in another table (or even the same table)
- Create order must be followed - primary key must already exist in order to create foreign key constraint with it

#### Example

- Create tables for the simple enrollment model:

![sql enrollment](http://snag.gy/Vyijn.jpg)

- Student table and Unit table must be created first

![student and unit creation](http://snag.gy/DemhR.jpg)

``` sql
CREATE TABLE student (
	student_id INT NOT NULL PRIMARY KEY,
	name VARCHAR(50) NOT NULL,
	gender CHAR(1) NOT NULL,
	dob DATE NOT NULL
);

CREATE TABLE unit (
	unit_code CHAR(7) NOT NULL PRIMARY KEY,
	unit_title VARCHAR(50) NOT NULL,
	credit_points TINYINT NOT NULL DEFAULT 15
	description TEXT NULL
);
```

- And then the enrollments table

![enrollment creation](http://snag.gy/6UXAm.jpg)

``` sql
CREATE TABLE enrollment (
	enrollment_id INT NOT NULL IDENTITY PRIMARY KEY,
	student_id INT NOT NULL,
	unit_code CHAR(7) NOT NULL,
	semester TINYINT NOT NULL,
	year SMALLINT NOT NULL,
	CONSTRAINT stud_fk FOREIGN KEY (student_id) REFERENCES student(student_id),
	CONSTRAINT unit_fk FOREIGN KEY (unit_code) REFERENCES unit(unit_code)
);
```
