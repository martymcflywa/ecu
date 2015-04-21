# Systems and database design lab 7

## Introduction

This lab allows you to practise the SQL covered in this week’s lecture. Do your best to answer the following questions and write the specified queries. You are encouraged to experiment with
SQL – it is a very flexible language, so if you can think of something that would be useful to achieve in a query, it can probably be done. This lab uses the `company` database, which you
can create by running the script file Module 5 of the unit materials. It is assumed that you are working in SQL Server Management Studio, also covered in Module 5.

If you are having trouble writing an SQL query, read any error messages and try to fix the error. Search for examples in the unit materials, and ask your tutor for assistance if needed. Contact your tutor if you spot something which appears to be incorrect in any of the labs.

## Lab tasks

### 1

Using Management Studio, examine the tables in the `company` database. Identify the primary and foreign keys of all tables, and compare them to the ERD of the company database in the lecture of Module 5. Has the database been implemented correctly?

- `region`
	- ERD
		- PK: `region_id`
	- DB
		- PK: `region_id`
- `country`
	- ERD
		- PK: `country_id`
		- FK: `region_id`
	- DB
		- PK: `country_id`
		- FK: `region_id`
- `location`
	- ERD
		- PK: `location_id`
		- FK: `country_id`
	- DB
		- PK: `location_id`
		- FK: `country_id`
- `job`
	- ERD
		- PK: `job_id`
	- DB
		- PK: `job_id`
- `department`
	- ERD
		- PK: `department_id`
		- FK: `manager_id`
		- FK: `location_id`
	- DB
		- PK: `department_id`
		- FK: `manager_id`
		- FK: `location_id`
- `employee`
	- ERD
		- PK: `employee_id`
		- FK: `department_id`
		- FK: `job_id`
		- FK: `manager_id`
	- DB
		- PK: `employee_id`
		- FK: `department_id`
		- FK: `job_id`
		- FK: `manager_id`
- `job_history`
	- ERD
		- PK FK: `employee_id`
		- PK: `start_date`
		- FK: `department_id`
		- FK: `job_id`
	- DB
		- PK FK: `employee_id`
		- PK: `start_date`
		- FK: `job_id`
		- **Missing:** FK `department_id`
- `job_grade`
	- ERD
		- PK: `grade_level`
	- DB
		- PK: `grade_level`


### 2

In the Object Explorer of Management Studio, right click on the "Database Diagrams" folder inside the `company` database and select "New Database Diagram". Create support objects if you are prompted to do so, and then select all the tables in the list and press "Add". Press "Close" and look at the ERD created by Management Studio. Does this ERD match the one in the lecture of Module 5? (You may wish to save the ERD so you can return to it at a later stage)

**Original ERD**

![q2-0](http://snag.gy/oxi1o.jpg)

**Generated diagram:**

![q2-1](http://snag.gy/2zfUy.jpg)

- Missing relationship between `job_history` and `department`
	- Caused by missing FK `department_id` in `job_history`

### 3

If you have noticed anything missing or incorrect in the `company` database, write an ALTER TABLE statement to correct the problem. Use the steps in the first two tasks of this lab to check that the database now matches the ERD in the lecture of Module 5.

``` sql
ALTER TABLE job_history
	ADD CONSTRAINT jhist_dept_fk FOREIGN KEY (department_id)
		REFERENCES department(department_id);
```

### 4

In addition to the primary and foreign keys, two `CHECK` constraints and a `UNIQUE` constraint have been defined in the `employee` table. What names have they been given, what columns do they effect, and what do they all do/ensure/enforce?

Ensure `salary` is greater than 0:

``` sql
CONSTRAINT emp_salary_min CHECK (salary > 0),
```

Ensure `gender_char` is either 'M' or 'F':

``` sql
CONSTRAINT gender_char CHECK (gender IN ('M', 'F')),
```

Ensure `emp_email_uk` is unique:

``` sql
CONSTRAINT emp_email_uk UNIQUE (email)
```

### 5

Write a `CREATE TABLE` statement to create the table specified in below:

![q5](http://snag.gy/JSfmz.jpg)

``` sql
CREATE TABLE project (
	project_id INT NOT NULL CONSTRAINT project_pk PRIMARY KEY IDENTITY,
	project_name VARCHAR(50) NOT NULL UNIQUE,
	project_desc TEXT NULL,
	creation_date SMALLDATETIME NOT NULL DEFAULT GETDATE()
);
```

### 6

Alter the `project` table to add a `project_leader` column – `INT`, `NOT NULL`. Give it a foreign key constraint, referencing the `employee_id` column of the `employee` table.

``` sql
ALTER TABLE project
	ADD project_leader INT NOT NULL
		CONSTRAINT proj_leader_fk FOREIGN KEY
		REFERENCES employee(employee_id);
```

### 7

Rather than using an auto-incrementing integer as the primary key, the company wishes to use a 5 letter project code. Alter the existing table to meet these new requirements. Since the `project_id` column has a primary key constraint, this involves several steps:

- An `ALTER TABLE` statement to drop the primary key constraint
- An `ALTER TABLE` statement to drop the `project_id` column
- An `ALTER TABLE` statement to add the `project_code` column, `CHAR(5)`, and give it a primary key constraint

### 8

Rewrite the `CREATE TABLE` statement from task 5 of this lab so that it incorporates the changes made in tasks 6 and 7. You will need to drop the `project` table before you can create it again.

### 9

To record which employees are working in which project, create a `project_work` table with an employee_id column and a `project_code` column. Make sure the data types of the columns match the columns that they are referencing, and give them appropriate foreign key constraints. The primary key of the table should be a compound key using both of the columns. (This table is essentially an intermediary table resolving a M:M)

![q9](http://snag.gy/uN6tS.jpg)

This ERD shows the structure of the database after task 9.

### 10 Challenge query

The following query is more difficult than the previous queries, and may involve SQL syntax which has not yet been covered in the unit.

Create a table named “item” with the following specifications:

- An `item_id` column, INT, with a primary key constraint. Using `IDENTITY`, make it auto-incrementing starting at `100` and incrementing by `20` each time.
- An `item_name` column, `VARCHAR(50)` and `NOT NULL`, with a unique constraint and a default value of `No name`.
- An `item_desc` column, `VARCHAR(250)` and `NOT NULL`, with a `CHECK` constraint that ensures that the description is at least `40` characters long. Use the `LEN()` function to determine the length of the description.
	- For an example, see slide 21 of the Module 7 lecture.
- A `initial_stock` column and a `reorder_level` column, both `SMALLINT` and `NOT NULL`, with defaults of `100` and `25` respectively.
	- Include a `CHECK` constraint that ensures that the reorder level is less than the initial stock.
- A `created_by` column, `INT` and `NULL`, with a foreign key constraint referencing the `item_id` in the same table.
	- ie. A self-referencing relationship.
