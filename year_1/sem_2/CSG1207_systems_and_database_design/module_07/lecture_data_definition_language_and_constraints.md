# Data definition language and constraints

## Data definition language

- DDL is a subset of SQL that is used to create databases and their tables (and other database objects)
	- Creates the **structure**
		- Not the content
	- A normalised database design is implemented into a database server using DDL
	- A data dictionary should provide all the information needed

### Naming rules

- Database, table and column names
	- Must **begin** with a letter or `_` underscore
		- `@` and `#` also allowed but have special meanings
	- Can then be followed by letters, numbers, `_`, `$`, `@` and `#`
		- Be consistent
			- If you have `itemOrder`, don't make `Cust_Address`
	- Can be 1 to 128 characters long
	- Cannot contain spaces or special characters
	- Must be unique within its own visible range
		- Different tables per database
		- Different columns per table
	- Must not be an SQL Server reserved word

### Creating a database

``` sql
CREATE DATABASE database_name
[ON [ PRIMARY ] [ <filespec> [ ,...n ]
[ , <filegroup> [ ,...n ] ]
[ LOG ON { <filespec> [ ,...n ] } ] ]
[COLLATE collation_name]
[ WITH <external_access_option> ]
```

- Everything apart from the first line is optional
	- Allows you to specify various attributes of the database
- Common database creation simply involves:

``` sql
CREATE DATABASE database_name
```

### Creating a table

``` sql
CREATE TABLE table_name
( column_name1 <column_description1>
	{[, column_name2 <column_description] ...}

	[table_constraint1]
	{[, table_constraint2 ...]}
);
```

- Syntax notes:
	- `[]` indicates something is **optional**
	- `{}` indicates something can occur **multiple** times
	- ie. May have multiple columns and constraints
- `<column_description>` defines the nature of the column
	- Data type and length
	- Default value
	- Identity
	- Null
	- Constraint
	- etc.

### Basic table creation example

``` sql
CREATE TABLE user (
	user_id INT,
	name VARCHAR(20),
	access CHAR(6),
	reg_date SMALLDATETIME
);
```

- Simply defines
	- Name of table
	- Name of columns
		- And their data type/lengths
	- No primary or foreign keys specified
- It is always better to specify a table as thoroughly as you can from the beginning
	- Rather than having to alter it later
- **Note:** May need to refresh the Object Explorer in SSMS after creating a table so that it appears

## Column definitions

### `DEFAULT` option

- You can give columns a default value
	- If a row is inserted into a table and no value is specified for that column, the default value is used
	- Literal values, expressions, SQL functions are acceptable values, but the name of another column isn't
	- The default data must match the column data type

``` sql
CREATE TABLE item (
	name VARCAR(50) DEFAULT 'No Name',
	stock SMALLINT DEFAULT 100,
	reorder SMALLINT DEFAULT 25,
	ordered DATETIME DEFAULT GETDATE()
);
```

- A default value is often not necessary or suitable for a column
	- Most columns will **not** have a default value

### `IDENTITY` option

- The `IDENTITY` option creates an auto-incrementing integer
	- Can only be applied to `INT` based columns
	- When a row is inserted, the server generates a value for the `IDENTITY` column by incrementing the last value it generated
		- Numbers are never repeated
			- Even if rows are deleted
		- Value is always unique
			- So it's perfect for a primary key
- You can specify the initial value and increment
	- If you don't, it starts at 1 and increments by 1 each time

``` sql
CREATE TABLE pet (
	pet_id INT IDENTITY;
);

CREATE TABLE owner (
	owner_id INT IDENTITY(1000, 5)
);
```

- `owner_id` will begin at 1000 and increment 5
	- ie. 1000, 1005, 1010, 1015, 1020, 1025...

## Constraints

- Constraints **enforce rules** at the table/column level
	- Give columns conditions to ensure that the database integrity remains intact and free of errors
	- These rules are checked whenever you try to insert, update or delete data from the table
- Available constraint types in SQL Server
	- `NULL` / `NOT NULL`
	- `PRIMARY KEY`
	- `FOREIGN KEY`
	- `UNIQUE`
	- `CHECK`
- Constraints can be defined at the **column level**
	- As part of a column definition
- Or at the **table level**
	- After column definitions
- This simply changes where it appears in the `CREATE TABLE`
- Constraints can also be added to a table **after** its creation
	- This may be required if your entities have circular relationships
- You can name a constraint
	- Useful if you need to refer to it
	- SQL Server will generate a name for it if you don't
- You can view constraints via the Object Explorer in SSMS

### Column level constraints

- Defining a constraint at the **column level** is easier, but not suitable for certain things
	- ie. Compound primary keys
- You do not need to give the constraint a name

``` sql
CREATE TABLE cat (
	cat_id INT IDENTITY PRIMARY KEY
);
```

![constraint column level no name](http://snag.gy/ku8oI.jpg)

``` sql
CREATE TABLE cat (
	cat_id INT IDENTITY CONSTRAINT cat_pk PRIMARY KEY
);
```

![constraint column level named](http://snag.gy/hyeyu.jpg)

### Table level constraints

- Defining a constraint at the **table level** requires the **full syntax** but can handle more complex constraints
- Allows for compound keys

``` sql
CREATE TABLE enrolment (
	unit_id INT,
	stud_num INT,

	CONSTRAINT enr_pk PRIMARY KEY (unit_id, stud_num)
);
```

![constraint table level compound key](http://snag.gy/6WqyY.jpg)

- Constraint name is **not optional**
- Become familiar with **both** ways of doing it

### Column and table level constraint summary

- Constraint names are optional with **column level** constraints
	- But mandatory for **table level** constraints
- Compound keys can only be created with **table level** constraints
- `NULL` / `NOT NULL` constraints can only be created with **column level** constraints
	- These are often thought of as a property/option of a column, like `DEFAULT` and `IDENTITY`, rather than as a constraint
- Outside of these conditions, which one you use is largely a matter of personal choice

### `NULL` / `NOT NULL` constraint

- Giving a column `NOT NULL` means it **must** have a value
	- Any important/required columns should be `NOT NULL`
- Giving a column `NULL` means it can be null
	- Any optional columns can be `NULL`
	- Any columns where data may not be known, may be unspecified or may be invalid for some rows can be `NULL`
	- `NULL` is the default
		- Doesn't usually need to be specified
- `PRIMARY KEY` or `IDENTITY` columns **cannot** be `NULL`
	- Automatically set to `NOT NULL`

``` sql
CREATE TABLE cat (
	cat_id INT IDENTITY PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	owner_id INT NULL,
	birthdate DATETIME NULL,
);
```

### `PRIMARY KEY` constraint

- Defines the primary key column/s of a table
	- The column/s **uniquely identify each row** in the table
		- ie. Every row must have a different value in the PK column/s
	- Each table can only have **one** primary key constraint
	- Primary key can be **compound**
		- Involve multiple columns
		- Compound keys can only be created with table level constraints

``` sql
CREATE TABLE cat (
	cat_id INT IDENTITY PRIMARY KEY
	name VARCHAR(20) NOT NULL
);
```

``` sql
CREATE TABLE enrolment (
	unit_id INT,
	stud_num INT CONSTRAINT enr_pk PRIMARY KEY (unit_id, stud_num)
);
```

### `UNIQUE` constraint

- Columns must be unique for each row in table
	- Like a primary key, but can have **multiple** unique constraints
	- Unlike a PK, unique columns allow `NULL`
		- Only once
	- Foreign keys can reference a unique constraint
	- Unique constraints can be compounded
		- Like PKs

``` sql
CREATE TABLE user_account (
	user_id INT IDENTITY PRIMARY KEY,
	username VARCHAR(20) NOT NULL UNIQUE
);
```

``` sql
CREATE TABLE user_account (
	user_id INT IDENTITY PRIMARY KEY,
	f_name VARCHAR(20) NOT NULL,
	surname VARCHAR(20) NOT NULL,

	CONSTRAINT full_name UNIQUE (f_name, surname)
);
```

### `FOREIGN KEY` constraint

- Defines the foreign keys of a table
	- Establishes/enforces a **link between columns** in two tables
	- Foreign key in one table references the primary key of another table
		- Or a column with a unique constraint
	- Self referencing relationships have a FK with the same table
	- Enforces referential integrity
		- Will prevent conditions which lead to broken PK -> FK relationships
- The table/column that the foreign key references must already exist
	- ie. Has been created, remember **creation order**

#### Column level example

``` sql
CREATE TABLE cat (
	cat_id INT IDENTITY PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	owner INT FOREIGN KEY REFERENCES owner(owner_id)
);
```

![foreign key column level](http://snag.gy/YxvMN.jpg)

#### Table level example

``` sql
CREATE TABLE cat (
	cat_id INT IDENTITY PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	owner INT,
	CONSTRAINT owner_fk FOREIGN KEY (owner) REFERENCES owner(owner_id)
);
```

##### Syntax

``` sql
CONSTRAINT <constraint_name> FOREIGN KEY (<column(s)>) REFERENCES <pk_table(<pk_column(s)>)
```

- The `(<pk_column(s)>)` part is optional **if it is the same** as the `(<column(s)>)` part
	- ie. Column name is the same in both tables

### `CHECK` constraint

- **Limit the values** accepted by a column using an expression
	- **Logical expression must be true** for value to be accepted
	- Can use normal logic and arithmetic operators
	- Can define **multiple** check constraints in a table
	- Can define **multiple** check constraints on a single column

``` sql
CREATE TABLE employee (
	emp_id INT PRIMARY KEY CHECK (emp_id > 0),
	f_name VARCHAR(20) NOT NULL,
	surname VARCHAR(20) NOT NULL,
	salary SMALLINT NOT NULL,

	CONSTRAINT sal_con CHECK (salary BETWEEN 1000 AND 5000),
	CONSTRAINT name_con CHECK (LEN(f_name) + LEN(surname) > 3)
);
```

- Checked whenever inserting or updating a row of data

## Altering a table

- The `ALTER TABLE` command can be used to modify a table structure once it has been created
	- Add a column
	- Alter a column
	- Drop a column
	- Add a constraint
	- Drop a constraint
- Better to get the table structure correct when creating it
	- But sometimes circumstances change and you need to alter it
- Certain things may not be alterable
	- If they are crucial to the way the table operates

### Adding a column

#### Single column

To add a single column:

``` sql
ALTER TABLE employee
	ADD uni_degree VARCHAR(50) NULL;
```

- Column will be added to table named after `ALTER TABLE`
- Notice there is no `()` around the `ADD` clause
- Column definition as normal after `ADD`

#### Multiple columns

To add multiple columns, just put a `,` between them:

``` sql
ALTER TABLE employee
	ADD uni_degree VARCHAR(50) NULL,
		home_phone INT NOT NULL DEFAULT 0,
		access_level CHAR(1) NULL DEFAULT 'C';
```

- To use `NOT NULL`, you must specify a `DEFAULT` or use `IDENTITY`, or the table must have no rows in it

### Altering a column

- To change an existing column's definition:

``` sql
ALTER TABLE employee
	ALTER COLUMN home_phone CHAR(15) NULL;
```

- Very much like adding a column
- Can only alter one column at a time
- Certain alterations to columns can cause problems
	- Altering columns with constraints
	- Shortening the length/size of a column
	- Changing to incompatible data type
		- ie. `CHAR` to `INT`
- The server will typically inform you of any potential problems and prevent you from altering a column if needed
	- You may need to drop constraints before altering a column

### Dropping a column

- To drop a column:

``` sql
ALTER TABLE employee
	DROP COLUMN eye_colour;
```

- All of the data in the column will be lost
	- Cannot be undone
- Multiple columns can be dropped at once by putting a `,` between each column name
- You cannot drop a column when it is
	- Part of a constraint
		- PK, FK, `UNIQUE` or `CHECK`
	- Has default value associated with it
	- To drop these types of columns, you will normally need to drop the constraints/defaults associated with them first

### Adding and dropping a constraint

#### Adding constraint to column

- To add a constraint to an existing column

``` sql
ALTER TABLE employee
	ADD CONSTRAINT mgr_fk FOREIGN KEY (manager_id) REFERENCES employee(employee_id);
```

- Syntax for the constraint is same as creating a **table level** constraint during a `CREATE TABLE` statement
- You can create any kind of constraint
	- As long as it is valid

#### Dropping constraint from column

- To drop an existing constraint from a column

``` sql
ALTER TABLE employee
	DROP CONSTRAINT mgr_fk;
```

- Much easier and more readable if you **named the constraint**
- Can add or drop multiple constraints at once with `,`
- Must still adhere to creating/dropping order

### Dropping tables and databases

- Very simple syntax for dropping tables and databases

``` sql
DROP TABLE employee;

DROP DATABASE company;
```

- **All of the data will be lost**
	- Cannot be undone
- Any constraints will be dropped along with the table/database
- Remember the dropping order if there are foreign keys
- Can drop more than one at a time

``` sql
DROP TABLE walk, owner, pet, park;

DROP DATABASE company, enrolments;
```

- `TRUNCATE TABLE` can be used to **delete all rows** in a table, but keep structure (columns, constraints etc)
	- Will reset any `IDENTITY` columns to their starting value

### Data definition language summary

- This table summarises the main DDL commands

![ddl command summary](http://snag.gy/p1hYA.jpg)

## Considerations when creating tables

- Keep your table creation script **neat and tidy**
	- Collection of all necessary `CREATE TABLE` statements
	- Each column on a new line, use spaces or tabs to align things
	- Consistent naming of columns and constraints
	- Consistent ordering of options and constraint creation
- **Save a copy** of your table creation script
	- This will allow you to re-create your database structure
	- Remember to **update** the creation script if you alter a table
	- Add comments to make it clearer
- To make your table creation script more flexible, you may want to include statements to drop the database first
	- So that the script re-creates everything from scratch each time
- It may be necessary to create tables **without** foreign key constraints and then add them once tables are created
	- Where primary and foreign keys relate in a circular manner
	- Remember that foreign keys simply **enforce referential integrity**
- In the diagram below, employees work in a department, and departments have a manager (who is an employee)

![employee department manager](http://snag.gy/SzINw.jpg)

- While you can create the necessary columns for FK values, you cannot create both constraints until both tables exist
	- Create one constraint, then add the other once populated
	- See **Staff** and **CustomerOrder** in assignment

## Example database `group_work`

![group_work per](http://snag.gy/0OmJx.jpg)

### `group_work` table creation order

![group_work creation order](http://snag.gy/8VLIU.jpg)

### `group_work` creation script

#### Initial preparation

``` sql
IF DB_ID('group_work') IS NOT NULL
	BEGIN
		PRINT 'Database exists - dropping.';
		USE master;
		ALTER DATABASE group_work SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
		DROP DATABASE group_work;
	END
GO

-- Now that we are sure the database does not exist, we create it.

PRINT 'Creating database.';
CREATE DATABASE group_work;
GO

-- Now that an empty database has been created, we will make it the active one.
-- The table creation statements that follow will therefore be executed on group_work
USE group_work;
```

#### Create first three tables

``` sql
-- Create the unit table
CREATE TABLE unit (
	unit_code CHAR(7) NOT NULL CONSTRAINT unit_pk PRIMARY KEY,
	unit_name VARCHAR(50) NOT NULL,
	unit_desc TEXT NULL,
	credit_points TINYINT NOT NULL DEFAULT 15
);

-- Create the student table
CREATE TABLE student (
	student_num INT NOT NULL CONSTRAINT student_pk PRIMARY KEY,
	student_name VARCHAR(50) NOT NULL,
	gender CHAR(1) NULL,
	birthdate DATE NULL
);

-- Create the assignment_type table
CREATE TABLE assignment_type (
	assn_type_id TINYINT NOT NULL IDENTITY CONSTRAINT ass_type_pk PRIMARY KEY,
	ass_type VARCHAR(20) NOT NULL CONSTRAINT assn_type_uk UNIQUE
);
```

#### Create the last three tables

``` sql
-- Create the assignment table.
CREATE TABLE assignment (
	assn_id INT NOT NULL IDENTITY CONSTRAINT assn_pk PRIMARY KEY,
	unit_code CHAR(7) NOT NULL CONSTRAINT assn_unit_fk FOREIGN KEY REFERENCES unit,
	assn_type TINYINT NOT NULL CONSTRAINT assn_assn_type_fk
		FOREIGN KEY REFERENCES assignment_type(assn_type_id),
	assn_name VARCHAR(50) NOT NULL,
	assn_desc TEXT NULL,
	weighting DECIMAL(4, 1) NULL
);

-- Create the group table
CREATE TABLE work_group (
	group_id INT NOT NULL IDENTITY CONSTRAINT group_pk PRIMARY KEY,
	assn_id INT NOT NULL FOREIGN KEY REFERENCES assignment,
	group_name VARCHAR(50) NOT NULL,
	creation_date DATE DEFAULT GETDATE() NOT NULL
);

-- Create the group_member table
CREATE TABLE group_member (
	student_num INT NOT NULL CONSTRAINT gmem_student_fk FOREIGN KEY REFERENCES student,
	group_id INT NOT NULL CONSTRAINT gmem_group_fk FOREIGN KEY REFERENCES work_group,

	CONSTRAINT gmem_pk PRIMARY KEY (student_num, group_id)
);
```

### Challenges

- Add an `enrolment` table as an intermediary table between `student` and `unit` containing a **compound primary key** of `student_num` and `unit_code` and the necessary foreign keys
- Add a `group_leader` column to `work_group` table, which is a foreign key reference to the `student_num` column in `student`
- Add an optional **prerequisite** column to the `unit` table, which is a self-referencing foreign key to the `unit_code` column
- Update the creation script to incorporate all of these changes
