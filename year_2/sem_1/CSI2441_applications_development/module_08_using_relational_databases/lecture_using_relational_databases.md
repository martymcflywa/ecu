# Using relational databases

## Objectives

- Understand relational database fundamentals
- Create databases and table descriptions
- Identify primary keys
- Understand database structure notation
- Understand the principles of interacting with records within a table
	- Adding
	- Deleting
	- Updating
	- Sorting
- Write queries
- Understand relationships between
	- Tables
	- Functional dependence between columns
- Understand
	- Anomalies
	- Normal forms
	- Normalization process
- Performance and security issues connected to database administration

## Relational database fundamentals

### Data hierarchy

- Stores data from smallest usable unit of data to the largest
	- Characters
	- Fields
	- Records
	- Tables
		- Also known as files

### Database

- Has group of files needed to support an organization
- Files in a database are called tables
- Data in tables can be arranged in rows and columns
	- Each row represents an entire record in the table

![figure 16-1](http://snag.gy/UFGy9.jpg)

### Primary key

- Uniquely identifies a record
- May be composed of one or multiple columns
- Typically one

### Compound key

- Constructed from multiple columns

### Database management system

- Software that allows you to
	- Create table descriptions
	- Identify keys
	- Add/delete/update records within a table
	- Sort records within a table by specific field/s
	- Write questions to select specific records for viewing
	- Write questions to combine information from multiple related tables
	- Create reports
	- Secure the data
- On the three tier model
	- Databases are typically 3rd tier
	- Or on the data tier

## Creating databases and table descriptions

- Creating a database requires planning and analysis
	- What data to store
	- How to divide the data between tables
	- How the tables will interrelate
- Designing a database table
	- Determine what columns are required and name them
	- Determine the type of data in each column

![figure 16-2](http://snag.gy/5FYJS.jpg)

## Identify primary keys

- Identify a column or combination of columns to be the primary key
- Values of primary keys must be unique
	- Student ID
	- Inventory part
	- Social security number
- In an environment where no such unique identifier exists
	- Developers can use an incrementing primary key as managed by the database system
- Primary key is used for
	- Ensuring that multiple records with the same values cannot be added
	- Sorting the records in primary key order
	- Creating relationships between tables
	- Normalizing a database
- May need to use a multicolumn key to ensure unique values
- Or you can use incrementing primary keys
	- Then query the database BEFORE data insertion to check for existing data

## Check for existing data and referential integrity

- If you try to insert a value into a database which already exists
	- The database will generate an error
- It is better not to rely on database to do the checking
	- Failure mode not user friendly
- For insertion to database
	- Take the form data
	- Search primary key or other main fields against database to see if record is already there
- Then a more specific error message can be thrown

### Referential integrity

- Most RDBMS systems can implement rules upon relationships
- Example
	- `studentEnrolments` FK cannot be inserted unless it exists as a PK in a related table
		- ie `student`
- This stops redundant data entering the system
- Not all database environments fully support referential integrity automatically

### Programming integrity

- Better to encode referential integrity into applications
	- Rather than rely on database to do it
- Tents to increase programming load
- Allows for application transportability
	- If more logic is in the code rather than relying on database
	- More likely it is to work with different databases

## Key management issues

- Can either define own key or use database to manage keys
- Classic mistake
	- Key fields entered by the user
	- ie. Let users make them up
- In some instances this is fine
	- ie. Item tagged with barcode
	- However if end user has to just make one up, problems will occur
- If you are using automatically generated keys
	- 95% of cases, users do not need to see it

![key management issue 1](http://snag.gy/MkNZm.jpg)

![key management issue 2](http://snag.gy/VKCC2.jpg)

## Manipulating records within tables

- Adding data
	- Data types must match the column definitions
	- Database software may not permit blank values
- Records can be deleted from tables
- Fields within records can be modified
- Maintaining correct data at all times is extremely important
- Point is to have a single instance of current information available from a centralized location

## Sorting records in a table

- Can sort a table based on any column
- After sorting
	- Records can be grouped by specific values or ranges
	- Aggregate values can be calculated
		- Count
		- Sum
		- Averages
- Data retrieved from tables can be formatted for display

## Creating queries

- Query
	- Question presented to database which results in data being returned
- Structured Query Language
	- Common language used to query a database
- `SELECT-FROM-WHERE`
	- Basic form of a query
	- Select which columns to use
	- Select the table which to retrieve the data
	- Select records where one or more conditions are met
- Wildcard symbol can be used to specify any/all
- Can create compound conditions using `AND`/`OR`

![figure 16-4](http://snag.gy/TTK0b.jpg)

![figure 16-5](http://snag.gy/xbB5H.jpg)

## Table relationships

- Relationship
	- Connection between two tables
- Relational database
	- Database containing relationships
- Join operation
	- Connecting two tables based on values in a common column
- Query returns data taken from each joined table
- 3 types of relationships
	- One to may
	- Many to many
		- Avoid
	- One to one

![figure 16-6](http://snag.gy/1J08d.jpg)

### One to many

- A row in one table is related to one or more rows in another table
- Most common type of table relationship
- Can be based on one or more columns
- One side
	- PK is used for the join
- Many side
	- May be a non-key column
- Foreign key
	- A field in a table which is also a primary key in another table

![figure 16-7](http://snag.gy/JTpZ7.jpg)

### Many to many

- Multiple rows in each table can correspond to multiple rows in the other table
- Use an additional table to contain the pairs of primary keys from each table
- Pairs form unique keys in the new table
- Sometimes called intermediate table

![figure 16-8](http://snag.gy/M9Yxg.jpg)

### One to one

- A row in one table corresponds to exactly one row in another table
- Indicate that the tables could be combined into a single table
- Often keep the tables separate for security purposes
	- Salary
	- Password

![figure 16-9](http://snag.gy/XDgXx.jpg)

### Poor table design

- If tables are not designed correctly
	- Database may not support needs of application
- What are the short comings of this table design?

![figure 16-10](http://snag.gy/KqYib.jpg)

## Anomalies and normalization

### Normalization

- Process of designing and creating database structure that satisfies needs
- Helps reduce duplication of data

### Redundancy

- Unnecessary duplication of data
- Data appears in more than one place
	- ie. Student name appearing in other tables aside from `StudentDetails` table

### Anomaly

- Irregularity in database design that causes problems
- ie. Deleting data in a one to many relationship
	- If you delete the PK but do not remove the FK
		- Those FKs could reference a PK that no longer exists
- Three types of anomalies
	- Update
	- Delete
	- Insert

#### Update anomaly

- When updating data in one table
	- You must update the same data in another table

#### Delete anomaly

- Deleting a record causes other problems
	- ie. Loss of unrelated information

#### Insert anomaly

- Inability to add a new record due to lack of related data

### Normalization process

- Removes redundancies and anomalies
- Three normal forms
	- 1NF
		- Eliminate repeating groups
	- 2NF
		- Eliminate partial key dependencies
	- 3NF
		- Eliminate transitive dependencies

#### 1NF

- Unnormalized
	- Table containing repeating groups
- Repeating group
	- Subset of rows in table that depend on the same key
- After eliminating repeating `class` and `classTitle`:

![figure 16-11](http://snag.gy/tz2hl.jpg)

- When repeating groups are eliminated
	- May have to change the key field if it is no longer unique
- Can use compound key to solve problem
- Atomic attributes
	- Each attribute contains an un-dividable piece of data

#### 2NF

- Partial key dependencies
	- When a column depends on only part of the key
- Database must already be in 1NF
- All non key fields must be dependent on entire primary key
- Eliminate partial key dependencies by creating multiple tables

![figure 16-12](http://snag.gy/ADySF.jpg)

#### 3NF

- Transitive dependency
	- When value of a non key attribute determines or predicts the value of another non key attribute
- Database must already be in 2NF
- No transitive dependencies
- Remove the attributes that are functionally dependent on the attribute that causes the transitive dependency

![figure 16-13](http://snag.gy/fJmGB.jpg)

- All redundancy and anomalies have now been removed
- Determinant is allowed in 3NF if it is a candidate key
- Normalization summary
	- 1NF
		- No repeating groups
	- 2NF
		- 1NF plus no partial key dependencies
	- 3NF
		- 2NF plus no transitive dependencies

## Database performance and security issues

- Company's data must be protected
- Data security includes
	- Providing data integrity
	- Recovering lost data
	- Providing rollback features
	- Avoiding concurrent update problems
	- Providing authentication and permissions
	- Providing encryption
	- Providing audit trail as to who
		- Accessed
		- Altered
		- What
		- When

### Data integrity

- Data is accurate and consistent
- Database software must enforce referential integrity
- Database enforces data type and data presence rules
	- What type of data a field will accept
	- What format
	- Can it be blank

### Recovering lost data

- Loss caused by
	- User error
	- Hackers
	- Hardware issues
	- Natural disasters
- Recovery
	- Returning the database to a correct form that existed before the problem occurred
- Can use a backup copy of database with a record of all transactions to recover db
- Transaction
	- Change made to data in db
	- Most modern RDBMS environments provide rollback facilities for one or more operations
	- Difficult when applied across large amounts of related records

### Concurrent update problems

- When two users both need to make changes to the same record
- If each user changes the data and saves the record
	- Who's update will be saved/ignored?
- Lock
	- A mechanism to prevent changes to a database record for some period of time
	- This is a real problem in file based databases as most operating systems lock a file open to only one user at a time
- Solving concurrent update problem
	- Use record level locking
	- Make transactions offline then process as a batch

### Authentication and permissions

- Database software must determine that a user is legitimate and is authorized to use database
- Authentication techniques include
	- Storing/verifying password
	- Using biometric data to identify user
- Permissions
	- Settings that determine what actions a user is allowed to perform
- Authentication determines what permissions a user has
- Web apps typically deal with security at two levels
	- The access the application has to the database
		- Permissions on the connection
	- The access the application provides to its user based on business rules
		- User account stored in database
	- Two are usually separate

### Providing encryption

- Encryption
	- Coding data into a format that humans cannot read
- Prevents use of data by unauthorized users even if they gain access to the database itself
- Not a good idea to encrypt when in development phase
	- Cannot edit database directly if you need to read and verify record manually
- If database is lost then recovered
	- Some environments need original encryption key to recover data
	- If keys are lost, recovered data may be forever unreadable

## Summary

- Database
	- Collection of tables containing organization's data
- Primary key
	- Value that uniquely identifies a record
- Database management software allows you to
	- Add
	- Delete
	- Update
- Query
	- Question that selects data from database
- Database creation requires planning and analysis
- Primary key can consist of one or multiple columns
- Most data is in a constant state of change
- Can sort table based on any column
- Can do aggregate calculations on data
- Normalization
	- Designing a database to meet stated needs yet avoiding redundancies and anomalies
- Three forms of normalization are commonly used
- Database may be one of a company's most important assets
	- So it must be secured
- Security issues
	- Data integrity
	- Recovery
	- Avoid concurrent updates
	- Authentication/permissions
	- Provide encryption
