# Systems and database design lab 08

## Introduction

This lab allows you to practise the SQL covered in this week’s lecture. Do your best to answer the following questions and write the specified queries. You are encouraged to experiment with SQL – it is a very flexible language, so if you can think of something that would be useful to achieve in a query, it can probably be done. This lab uses the "company" database, which you can create by running the script file Module 5 of the unit materials. It is assumed that you are
working in SQL Server Management Studio, also covered in Module 5.

If you are having trouble writing an SQL query, read any error messages and try to fix the error. Search for examples in the unit materials, and ask your tutor for assistance if needed. Contact your tutor if you spot something which appears to be incorrect in any of the labs.

## Lab tasks

### 1

Insert a new row into the `job` table, with the following details. For this insert, do not list the column names after the name of the table.

![q1](http://snag.gy/4yw29.jpg)

``` sql
INSERT INTO job
VALUES ('GN_SEC', 'Secretary', 3500, 10000);
```

### 2

Insert another row into the `job` table, with the following details. This time, list the column names after the name of the table.

![q2](http://snag.gy/pL1yS.jpg)

``` sql
INSERT INTO job (job_id, job_title, min_salary, max_salary)
VALUES ('GN_JAN', 'Janitor', 1500, NULL);
```

### 3

Insert another row into the `job` table, with the following details. You can choose whether or not to list the column names this time.

![q3](http://snag.gy/IWMLF.jpg)

``` sql
INSERT INTO job (job_id, job_title, min_salary, max_salary)
VALUES ('GN_CAF', 'Cafeteria Worker', DEFAULT, 4500);
```

### 4

Write an `UPDATE` statement which updates rows in the `job` table, giving the `GN_SEC` and `GN_JAN` jobs a maximum salary of 5000.

``` sql
UPDATE job
SET max_salary = 5000
WHERE job_id IN ('GN_SEC', 'GN_JAN');
```

### 5

The following statement is trying to insert three rows into the `country` table using a multiple-insert, however `33` was accidentally typed instead of `3`. Run the statement without fixing it – does SQL Server insert the correct rows, or none of them?

``` sql
INSERT INTO country
VALUES	('CH', 'China', 3),
		('JP', 'Japan', 33),
		('EG', 'Egypt', 4);
```

**Console output:**

```
Msg 547, Level 16, State 0, Line 1
The INSERT statement conflicted with the FOREIGN KEY constraint "cntry_reg_fk". The conflict occurred in database "company", table "dbo.region", column 'region_id'.
The statement has been terminated.
```

Then fix the typo and run the statement to insert the three countries.

**Fixed statement:**

``` sql
INSERT INTO country
VALUES	('CH', 'China', 3),
		('JP', 'Japan', 3),
		('EG', 'Egypt', 4);
```

### 6

Write a `DELETE` statement that deletes any countries from the `country` table that have a region ID larger than 2.

``` sql
DELETE FROM country
WHERE region_id > 2;
```

### 7

Write an `UPDATE` statement that uses a subquery to update the maximum salary of the `GN_CAF` job to be the same as the maximum salary of the `GN_SEC` job.

``` sql
UPDATE job
SET max_salary = (SELECT max_salary
				  FROM job
				  WHERE job_id = 'GN_SEC')
WHERE job_id = 'GN_CAF';
```

### 8

![q8](http://snag.gy/JRxkm.jpg)

Write statements to do the following (do not run them until you have written them all):

1. Begin a transaction (it does not need a name).
2. Insert a new row in the `job` table with the values shown in the table above
3. Create a save point in the transaction named `after_spy`
4. Update all the rows in the `job` table to have a minimum salary of 50000 and a maximum salary of 75000
5. Select all data from the `job` table to see the current state of the data
6. Roll backl the transaction to the `after_spy` save point
7. Commit transaction

Once you have written and run the complete transaction, select all data from the `job` table to see which changes were committed. Which changes have been committed?

``` sql
BEGIN TRANSACTION q8;
INSERT INTO job (job_id, job_title, min_salary, max_salary)
VALUES ('GN_SPY', 'Corporate Spy', 50000, 75000);
SAVE TRANSACTION after_spy;
UPDATE job
SET min_salary = 50000,
	max_salary = 75000;
SELECT * FROM job;
ROLLBACK TRANSACTION after_spy;
COMMIT TRANSACTION q8;
```

Only changes before `TRANSACTION after_spy` were committed.

### 9

Write a `DELETE` statement that deletes all jobs with a job ID starting in `GN`.

``` sql
DELETE FROM job
WHERE job_id LIKE 'GN%';
```

### 10 Challenge query

The following query is more difficult than the previous queries, and may involve SQL syntax which has not yet been covered in the unit.

This week's challenge query practices inserting data from one table into another using a subquery, covered on slide 10 of Module 8’s lecture. First, create a table with the following specifications:

![10-1](http://snag.gy/UEcCW.jpg)

Once you have create the table, we need to populate it with the appropriate data from the `employee` table. The corresponding columns are as follows:

![10-2](http://snag.gy/CLHtd.jpg)

Write an INSERT statement that uses a subquery to insert the data from the `employee` table into the `emp_summary` table following the specifications above. Check that you have copied the data correctly by selecting all rows from `emp_summary`.

**Note:** What we have done is a lab exercise only. It has duplicated data, which goes against the purpose and goals of a database. It would be much more effective to create a view, covered in Module 10.

**Creating table:**

``` sql
CREATE TABLE emp_summary (
	emp_id INT NOT NULL CONSTRAINT emp_summary_pk PRIMARY KEY,
	full_name VARCHAR(50) NOT NULL,
	email VARCHAR(75) NULL,
	phone VARCHAR(20) NULL
);
```

**Inserting values from `employee` to `emp_summary`:**

``` sql
INSERT INTO emp_summary (emp_id, full_name, email, phone)
SELECT	employee_id,
		first_name + ' ' + last_name,
		LOWER(email) + '@company.com',
		phone_number
FROM employee;
```
