# Unit review

## Module 1: Intro and normalisation

- History of databases and DBMSs
- Concepts and terminology of relational databases
- Insert, update and delete anomalies
- Concept and purpose of normalisation
- Primary and foreign keys
- Gathering un-normalised data sets
	- Identification of repeating groups

## Module 2: Normalisation

- Normalising to 1NF
	- Remove repeating groups
- Normalising to 2NF
	- Remove partial dependencies
- Normalising to 3NF
	- Remove functional dependencies
- Naming of data sets
- Relational symbolic notation

## Module 3: Entity-Relationship modelling

- Concept of ER modelling
	- Depict structure of database
	- Focus on relationships between entities/tables
- Logical and physical ER models
- Entity naming
- Relationships
	- 1:1
	- 1:M
	- M:M
	- Transfer of primary/foreign keys in relationships
- Resolving a M:M relationship
- Cardinality
- Creating ER models from problem statements

## Module 4: Enhanced ER modelling

- Multiple relationships
- Self-referencing relationships
- Supertypes and subtypes
- Table creating and dropping order
- Brief introduction to SQL and DL

## Module 5: SQL and basic queries

- Introduction to SQL
- Concepts of SQL and relationship between ER model
- Introduction to sample database used in unit
- Basic `SELECT` statements
- SQL formatting guidelines
- Arithmetic, column aliases, concatenation, `DISTINCT`
- Introduction to SSMS

## Module 6: `WHERE`, `ORDER BY` and data types

- `WHERE` clause
	- Specify criteria in a `SELECT` statement
	- Comparison operators `=`, `<`, `>`, `<=`, `>=`, `!=`
	- `BETWEEN`, `IN`, `LIKE`, `IS NULL`
	- Logical operators `AND`, `OR`, `NOT`
- Logical operator order of precedence
- `ORDER BY` clause
	- Order results
- `TOP`
	- Limit rows returned
- Data types
	- Character types
	- Numeric types
	- Date/time types
	- Misc types
	- Differences between various data types

## Module 7: Data Definition Language and Constraints

- Creating databases
	- Database naming rules
	- Column definitions
		- Name and data type
	- `NULL` / `NOT NULL`, `DEFAULT`, `IDENTITY`
- Constraints
	- `PRIMARY KEY`
	- `FOREIGN KEY`
	- `UNIQUE`
	- `CHECK`
	- Constraints at column level or table level
- Altering and dropping columns and constraints
- Dropping tables and databases and `TRUNCATE`
- Table creating considerations

## Module 8: Data Manipulation Language, transactions

- `INSERT`
	- With or without column list
	- Identity, null and default column considerations
	- Inserting with a subquery
- `UPDATE` and `DELETE`
- Key / constraint considerations for DML commands
	- Cascading updates and deletes
- Transactions
	- Perform all or none of a group of commands
	- Begin, save, rollback
	- Lock during transactions, read consistency

## Module 9: Joins and aggregate functions

- Joins
	- Retrieve data from multiple tables
		- Cross join
		- Inner join
		- Equi join
		- Outer join
		- Self join
	- Different syntaxes for joins
	- Table aliases and dealing with ambiguity
	- Joining more than two tables
- Aggregate functions
	- Perform calculation on value in rows
		- `AVG`
		- `SUM`
		- `MIN`
		- `MAX`
		- `COUNT`
	- Considerations with `COUNT(*)` and `NULL` values
- `GROUP BY` clause
	- Specify grouping of output
- `HAVING` clause
	- Use aggregate functions in comparisons

## Module 10: Subqueries, views, row level functions

- Subqueries
	- Queries within queries
		- Single and multiple row
		- Special comparison operators
			- `IN`
			- `ANY`
			- `ALL`
	- Subqueries and joins
- Views
	- Store and use definition of a **virtual table**
	- Purposes and capabilities of views
	- Creating, altering and dropping views
	- Updating data via a view
		- `WITH CHECK OPTION`
- Row level functions
	- Apply function to value/expression
		- Numeric
			- `ROUND()`
			- `FLOOR()`
		- String/char
			- `LOWER()`
			- `LEFT()`
			- `LTRIM()`
		- Date/time
			- `DAY()`
			- `GETDATE()`
		- Conversion
			- `CAST()`
			- `CONVERT()`
		- Misc
			- `ISNULL()`
			- `NULLIF()`

## Module 11: Subqueries and indexes

- Correlated subqueries
	- Inner queries that refer to outer
		- Difference from reqular subqueries
		- `EXISTS` and `NOT EXISTS`
		- Achieving results using other methods
- Indexes
	- Speed up retrieval of rows in queries
	- Concepts and syntaxes for index management
	- When to create indexes
		- Considerations

## Module 12: DCL, UDFs, SPs, backups and management

- DCL can be used to
	- Create logins
		- `CREATE LOGIN`
	- Create users and roles
		- `CREATE USER`, `CREATE ROLE`
	- Grant privileges to interact with database objects
		- `GRANT`, `REVOKE`, `DENY`
- User defined functions and stored procedures can be created to improve efficiency, readability and modularisation of code
- Backing up and restoring databases
- The SQL Server can be managed in various ways, including
	- Starting/stopping/disabling it
	- Allowing/denying various connection methods
	- Connecting remotely etc.
