# Simple database queries and SQL server management studio

## Review

- Last week we covered
	- Brief introduction to Structured Query Language (SQL)
		- What it is and what it is for
		- Variations in implementation of SQL between RDBMSs
	- Subset of SQL, defined by their purpose
		- Data Definition Language
			- Define/modify schemas
			- Table creating and dropping commands
		- Data Manipulation Language
			- Select
			- Insert
			- Update
			- Delete

## SQL

### History of SQL

- SQL is a relational database language which emerged in response to Edgar Codd's 1970 paper which defined the relational database model
- Prototype of SQL originally developed for IBMs first relational database project *System R* in the 1970s
- Relational Software Inc. (now Oracle) developed the first commercially available implementation of SQL for Oracle v2
- IBM then released commercially available RDBMSs with SQL support in the late 1970s and early 80s
- Various versions standardised by ANSI and ISO since 1986

### Introduction to SQL

- SQL is a **set-oriented** language
	- Can query multiple rows from one or more tables using just one statement
		- Which is in contrast to **record-oriented** language, that processes one record at a time
- SQL is **non-procedural**
	- Statements/commands describe **what a user wants**, rather than how a task is accomplished step by step
	- Opposite of imperative programming languages, where statements are used to accomplish a task step by step

### SQL Implementation

#### Common SQL commands

![common sql commands](http://snag.gy/1a1Gx.jpg)

#### Concept to database

![concept to db](http://snag.gy/W31S3.jpg)

#### ERD to database tables

- Each entity in a physical ERD translates **directly** to a table

![erd to db tables](http://snag.gy/gL3C1.jpg)

## Sample database: Company

![company physical erd](http://snag.gy/oxi1o.jpg)

- job_grade has no FKs
	- Creation order not important
- The relationship in red is added **after creation and population** to prevent issues with circular references

### The Company database

![employee](http://snag.gy/8Su0x.jpg)

![dept job location](http://snag.gy/Flrlp.jpg)

## Relational database terminology recap

![terminology recap](http://snag.gy/fj5rT.jpg)

## General guidelines for writing SQL

- Correct syntax
- Readability
- Easy to edit
- Guides
	- SQL statements are **not** case sensitive
	- SQL statements can be on one or more lines
	- Keywords cannot be abbreviated or split across lines
	- Keywords are typically entered in UPPERCASE
	- New clauses are usually placed on separate lines
	- Indents are used to enhance readability

## `SELECT` statement

### Capabilities of `SELECT`

![capabilities of select](http://snag.gy/HHkYe.jpg)

### Basic `SELECT` statements

``` sql
SELECT *|{[DISTINCT] column|expression [alias],...}
FROM table
[WHERE Conditions];
```

- `SELECT` clause identifies which **column/s**
- `FROM` clause identifies which **table/s**
- `WHERE` clause identifies which **row/s**
	- Is optional
	- Only those rows whose values make the conditions **true** will be returned

### Selecting all columns

``` sql
SELECT *
FROM job;
```

![selecting all columns](http://snag.gy/XrDk1.jpg)

### Selecting specific columns

``` sql
SELECT job_id, max_salary
FROM job;
```

![selecting specific columns](http://snag.gy/Kp8Fa.jpg)

### Arithmetic expressions

- Can create expressions with number and date data by using arithmetic operators
	- Operators
		- `+`
		- `-`
		- `*`
		- `/`
	- Other operators exist but these are most common
- Operator precedence
	- Multiplication and division take priority over addition and subtraction
	- Operators of the same priority are evaluated from left to right
	- Parentheses are used to prioritise evaluation and to clarify statements

#### Arithmetic example

``` sql
SELECT job_id, min_salary, max_salary, max_salary * 1.05
FROM job;
```

![arithmetic example 1](http://snag.gy/t9fmm.jpg)

![arithmetic example 2](http://snag.gy/3cPkC.jpg)

- A `NULL` is a value that is
	- Unavailable
	- Unassigned
	- Unknown
	- Or inapplicable

### Column aliases

- A column alias:
	- Renames a column heading for the results of that query
	- Is useful with calculations and other situations where column names may be missing, unhelpful or ambiguous
- Usual form is `AS 'aliasname'` after the column name
	- The `AS` is optional, but recommended for clarity
	- Iif the alias contains spaces or special characters, you must enclose it in single quotation marks
		- If the alias is a single word with no spaces, the quote marks can be omitted

#### Column alias example

``` sql
SELECT job_title AS Job, max_salary AS 'Pre-raise Maximum', max_salary * 1.05 AS 'Post-raise Maximum'
FROM job;
```

![column aliases](http://snag.gy/Hroxt.jpg)

### Concatenation operator `+`

- Using `+` between text-based columns (ie. `CHAR` or `VARCHAR`) joins them together
	- Concatenation

``` sql
SELECT job_id + job_title AS 'Job ID & Title'
FROM job;
```

![concatenate 1](http://snag.gy/HtXfv.jpg)

- You can also add other text to this **in single quotes** `'` as needed

``` sql
SELECT job_id + ' (' + job_title + ') ' AS 'Job ID & Title'
FROM job;
```

![concatenate 2](http://snag.gy/Kru6Y.jpg)

### Duplicate rows & the `DISTINCT` keyword

- By default, a query will display all rows, including rows which contain athe same values
	- ie. Duplicates

``` sql
SELECT job_id
FROM employee;
```

![duplicate 1](http://snag.gy/JY9SC.jpg)

- You can **eliminate duplicate rows** by using the `DISTINCT` keyword in the `SELECT` clause

``` sql
SELECT DISTINCT job_id
FROM employee;
```

![duplicate 2](http://snag.gy/GF730.jpg)

### Summary of `SELECT` basics

- That covers the basics of the `SELECT` statement
	- Selecting all columns with `*`
	- Specifying which columns to select by column name
	- Arithmetic operators
	- Column aliases
	- The concatenation operator
	- Using the `DISTINCT` keyword to eliminate duplicates
- These can all be combined in order to select something very specific from a table
- In coming weeks, we will learn to specify extra criteria with the `WHERE` clause, and connect columns from different tables using `join`s

## MS SQL Server 2008 overview

- MS SQL Server 2008 includes multiple components and services that makes it a comprehensive enterprise platform
- Key components
	- Database engine
	- Analysis services
	- Integration services
	- Replication services
	- Reporting services
	- Service broker
	- Native HTTP support
	- .NET Common Language Runtime (SQL CLR)
	- Notification services
	- Full-text search
	- And more!
- Newer versions of SQL server exist, but the implementation of SQL in the newer versions are almost identical to 2008
	- This unit focuses on SQL
		- Not the other server features

### SQL Server Management Studio (SSMS)

- SSMS is an integrated database management and development environment for SQL Server
- Developers can use it to
	- Create databases, tables and other objects
	- Change table structures and constraints
	- Create, execute and save scripts/queries
	- Create database diagrams

![ssms flow](http://snag.gy/8gx4p.jpg)

- SSMS can generate database diagrams such as this:

![ssms erd](http://snag.gy/wZCM6.jpg)

#### SSMS UI

![ssms ui](http://snag.gy/fbNXA.jpg)

#### Object explorer

- The left menu is the **Object Explorer**
- **Browse**, access and manage all objects on the server
	- Tables, databases etc
- **Refresh button** may be needed before new items show up
- **Right click** on objects for menu of useful/common commands
	- Right click on a table (or view) to select or edit its contents
	- Right click on column to edit data type, length, null, etc.

#### Useful toolbar items

- Many of the toolbar buttons are very useful, but here are a few you will probably use the most frequently
	- Some toolbars will only appear while working on a query
	- Hover over other buttons to see tooltips about their purpose

![ssms toolbar](http://snag.gy/2gfCq.jpg)

- **Note:** If you have some text selected in your query, **only the selected text** will be executed when you press the execute button

#### Starting SQL Server Management Studio

- In ECU SCSS labs
	- Find it by searching for it in the start menu and connect with the default settings
- At home
	- Follow the install/setup instructions in Blackboard
	- Download and install SQL Server 2008 R2 Express Edition
	- This is a free version of SQL Server 2008 R2
	- Make sure you install Management Studio Express
	- You may need to install other supporting software
	- Once installed, launch Management Studio and connect with default settings
- Once set up, you're ready to play with some databases
