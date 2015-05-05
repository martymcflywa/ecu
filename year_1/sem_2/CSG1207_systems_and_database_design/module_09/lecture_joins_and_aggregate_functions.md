# Joins and aggregate functions

# Joins

- Relational database stores data in separate tables in order to reduce data redundancy
	- Each table stores only one logically related data set
		- ie. Normalised data set
- A join allows you to bring together data that is stored in separate tables in a `SELECT` statement
- This allows the corresponding rows in related sets of data to be drawn together in a query
	- The data remains stored in a normalised, relational manner
	- It is only drawn together as needed within the `SELECT` query
	- Hence, the efficiency and structure of normalised data is combined with the accessibility of **flat-file** data

### Retrieving data from multiple tables

**List employees' last name and the name of their department:**

![last name and department name](http://snag.gy/HsXDp.jpg)

### Different types of joins in SQL server

- Cross joins
	- Returns every possible combination of rows in the two tables
		- Cartesian product
- Inner joins
	- Includes equi-joins
	- Matches common values between columns in two tables
		- Usually based on PK to FK relationships
- Outer joins
	- Results of a join also includes rows which do not match the join condition due to `NULL` values or no matches
- Self joins
	- Technically falling under classification of other join types
	- Involves a single table rather than two different tables

### Syntax of specifying a join

- As of the SQL92 standard, join use these keywords:
	- `[INNER] JOIN`
	- `CROSS JOIN`
	- `{LEFT | RIGHT | FULL} [OUTER] JOIN`
- Syntax placed in the `FROM` clause of a `SELECT` statement
- After specifying the tables to join, the `ON` keyword is used to specify join conditions
- General syntax:

``` sql
table1 [join type] JOIN table2 ON [condition]
```

``` sql
employee INNER JOB job ON employee.job_id = job.job_id
```

## Cross joins

- A cross join has no join condition, resulting in the cartesian product of the two tables
	- Result set includes every row in the first table matched with every row in the second table
	- Number of rows in first table multiplied by number of rows in second table
		- Typically results in large number of results
	- Not used very often as it is often meaningless
	- Adding a join condition makes a cross join an inner join
		- Since only the rows meeting the condition will be returned

### Cross join example

![tables country region](http://snag.gy/pfYUb.jpg)

``` sql
SELECT country_name, region_name
FROM country CROSS JOIN region;
```

![cross join result](http://snag.gy/8eJIe.jpg)

# Inner joins / equi-joins

- An inner join can be thought of as a cross join with a join condition
	- The condition can be any comparison between two columns
		- `=, <, >, !=` etc
	- The most common condition is equality between two columns
	- Usually, this is equality between FK and PK
	- An inner join which only has equality based join conditions is known as an **equi-join**

### Inner join / equi-join example 1

![tables country region](http://snag.gy/pfYUb.jpg)

``` sql
SELECT country_name, region_name
FROM country INNER JOIN regoin
ON country.region_id = region.region_id;
```

![inner/equi-join result 1](http://snag.gy/PAGiJ.jpg)

### Inner join / equi-join example 2

![tables employee department](http://snag.gy/WpY8j.jpg)

``` sql
SELECT last_name, department_name
FROM employee INNER JOIN department
ON employee.department_id = department.department_id;
```

![inner/equi-join result 2](http://snag.gy/0dQeO.jpg)

## Inner joins that are not equi-joins

- As previously stated, inner joins can use any comparison between columns, not just equality `=`
	- This also includes comparison operators like `BETWEEN`

**List the last name, salary and grade level of employees:**

![tables employee job_grade](http://snag.gy/GkX2N.jpg)

- Join condition checks if the salary of an employee is between the `lowest_sal` and `highest_sal` values of a grade level

``` sql
SELECT last_name, salary, grade_level
FROM employee INNER JOIN job_grade
	ON salary BETWEEN lowest_sal AND highest_sal;
```

![inner join result](http://snag.gy/n2qht.jpg)

## `WHERE` clauses and joins

- You can specify `WHERE` clauses as normal after a join, in order to specify more criteria

**List the last name, salary and department name of employees who have a salary of at least $10,000:**

``` sql
SELECT last_name, salary, department_name
FROM employee INNER JOIN department
	ON employee.department_id = department.department_id
WHERE salary >= 10000;
```

![join where result](http://snag.gy/14qAx.jpg)

## Dealing with ambiguity

- Columns in a query must be able to be uniquely identified
- Now that we're working with multiple tables, its possible and quite likely that there will be duplicate column names
	- Primary and foreign key columns
	- Commonly occuring columns such as `name` or `title`
- To specify a column unambiguously, precede it with the table name and a full stop
	- `table_name.column_name`
	- ie. `employee.department_id = department.department_id`
	- This **must be done** wherever ambiguity exists, in any part of the statement
		- Not just the `JOIN` or `ON` clause
			- Column list after `SELECT`, `WHERE` clause, `ORDER BY`, etc.

## Table aliases

- To make the task of unambiguously referring to columns less tedius/long, you can define **table aliases**
	- Similar concept to defining a column alias in the `SELECT` list
- Table aliases are defined after the table name in the `FROM` clause of the `SELECT` statement
	- The `AS` keyword is optional
	- Table aliases are usually created to be concise, rather than being descriptive or explanatory like column aliases often are

``` sql
SELECT last_name, salary, e.department_id, department_name
FROM employee AS e INNER JOIN department AS d
	ON e.department_id = d.department_id
WHERE salary >= 1000
ORDER BY e.department_id;
```

# Outer joins

- When using an inner join, any `NULL` values in the columns being joined will result in the row being omitted
	- ie. If an `employee` has `NULL` for their `department_id`, they **would not** appear in an `INNER JOIN` involving `department_id`
	- Only the rows that **meet the join** condition are returned in an inner join
- Outer joins return matching rows, as well as rows **which do not match anything** or contain `NULL` values
	- Can choose to include non-matched/`NULL` rows from either or both of the tables involved in the join
- Which to use?
	- Depends on if there can be/are `NULL` values in the columns, and if you need to see those rows

![employee.department_id null](http://snag.gy/5r2S3.jpg)

- Above table shows `department_id` is `NULL` for Grant
	- So an inner join with department table will not include this employee

![department_id null](http://snag.gy/0MurC.jpg)

- From the two tables above, no employees work in `Contracting` department
	- So it will not be included in an inner join between `employee` and `department`

## Outer join types and syntaxes

- Three types of outer joins
	- `LEFT`
		- Returns matched rows, and `NULL` unmatched rows in left table
	- `RIGHT`
		- Returns matched rows, and `NULL` unmatched rows in right table
	- `FULL`
		- Returns matched rows, and `NULL` unmatched rows in left table and **no matches** in right table
- Syntax:

``` sql
{LEFT | RIGHT | FULL} [OUTER] JOIN
```

- `OUTER` is optional since it only makes sense to specify `LEFT`/`RIGHT`/`FULL` before `JOIN` for an outer join

## `INNER JOIN` vs. `LEFT OUTER JOIN`

### `INNER JOIN`

``` sql
SELECT last_name, department_name
FROM employee INNER JOIN department
	ON employeee.department_id = department.department_id;
```

![inner join result](http://snag.gy/9maAZ.jpg)

### `LEFT OUTER JOIN`

``` sql
SELECT last_name, department_name
FROM employee LEFT OUTER JOIN department
	ON employee.department_id = department.department_id;
```

![left outer join result](http://snag.gy/Hu6te.jpg)

## `INNER JOIN` vs. `RIGHT OUTER JOIN`

### `INNER JOIN`

``` sql
SELECT last_name, department_name
FROM employee INNER JOIN department
	ON employeee.department_id = department.department_id;
```

![inner join result](http://snag.gy/9maAZ.jpg)

### `RIGHT OUTER JOIN`

``` sql
SELECT last_name, department_name
FROM employee RIGHT OUTER JOIN department
	ON employee.department_id = department.department_id;
```

![right outer join result](http://snag.gy/fG70Q.jpg)

## `INNER JOIN` vs. `FULL OUTER JOIN`

### `INNER JOIN`

``` sql
SELECT last_name, department_name
FROM employee INNER JOIN department
	ON employeee.department_id = department.department_id;
```

![inner join result](http://snag.gy/9maAZ.jpg)

### `FULL OUTER JOIN`

``` sql
SELECT last_name, department_name
FROM employee FULL OUTER JOIN department
	ON employee.department_id = department.department_id;
```

![full outer join result](http://snag.gy/5wGo4.jpg)

# Self joins

- Self joins involve joining two columns in the same table
	- ie. A self-referencing relationship
- No specific join syntax
- The same table appears **twice** in the `FROM` clause
- Table aliases **must** be used to make it possible to do this

![self join](http://snag.gy/xGlLe.jpg)

## Self join example

**List the last name of all employees, and the last name of their manager:**

``` sql
SELECT e.last_name AS 'employee', m.last_name AS 'manager'
FROM employee AS e LEFT OUTER JOIN employee AS m
	ON e.manager_id = m.employee_id;
```

![self join example result](http://snag.gy/qXvxg.jpg)

# Joining more than two tables

- Multiple joins can be used in a statement as needed

**List the last names of all employees, and the city in which their department is located:**

![multiple table join](http://snag.gy/cSDMk.jpg)

``` sql
SELECT last_name, city
FROM employee AS e INNER JOIN department as d
	ON e.department_id = d.department_id
	INNER JOIN location as l
	ON d.location_id = l.location_id;
```

- Note the syntax
	- Do not repeat the name of any tables
	- The **left** part of the second join is the first join

``` sql
table1 JOIN table2
	ON condition JOIN table3
	ON condition JOIN table4
	ON condition...
```

![multiple table join result](http://snag.gy/JIB64.jpg)

# Join summary

- Joins allow you to draw together corresponding rows of data from different tables, based on specified conditions
- Cross joins match every row in one table with every row in another table
	- Not much use in most circumstances
- Most common join/condition is equality between PK and FK
	- Known as equi-join, a type of inner join
- Outer joins can be used to include unmatched or `NULL` rows
- Multiple `JOIN`s, `ON` clauses, `WHERE` clauses, etc. can be combined to draw data together exactly how you want it

# Aggregate functions

- Aggregate functions perform a calculation on a set of values from a column in multiple rows
	- They return one value only, rather than one value per row
- Commonly used aggregate functions in SQL Server:
	- `AVG`
	- `SUM`
	- `MIN`
	- `MAX`
	- `COUNT`

## Sample uses of aggregate functions

- Aggregate functions can be used in many scenarios
	- What is the average salary of employees?
	- What is the total salary of `IT_PROG` employees?
	- What is the highest/lowest salary in the employee table?
	- How many `SA_REP` employees are there?

## Simple aggregate function examples

### What is the average salary of employees?

``` sql
SELECT AVG(salary) AS 'average salary'
FROM employee;
```

![AVG result](http://snag.gy/Q521g.jpg)

### What is the total salary of `IT_PROG` employees?

``` sql
SELECT SUM(salary) AS 'total salary'
FROM employee
WHERE job_id = 'IT_PROG';
```

![SUM result](http://snag.gy/bidX7.jpg)

### What is the highest salary in the employee table?

``` sql
SELECT MAX(salary) AS 'max salary'
FROM employee;
```

![MAX result](http://snag.gy/116xB.jpg)

### How many `SA_REP` employees are there?

``` sql
SELECT COUNT(*) AS 'sales reps'
FROM employee
WHERE job_id = 'SA_REP';
```

![COUNT result](http://snag.gy/YWz7N.jpg)

## Aggregate function notes

- `AVG` and `SUM` only work on **numeric** data types
- `MIN` and `MAX` can be used on
	- Numeric
	- Character
		- Alphabetic
		- 'A' = `MIN`
		- 'Z' = `MAX`
	- Date
		- Earliest time = `MIN`
		- Most recent time = 'MAX'
- Can use multiple aggregate functions in a statement

``` sql
SELECT MIN(salary) AS 'min sal', MAX(salary) AS 'max sal',
	AVG(salary) AS 'avg sal', COUNT(*) AS 'employees'
FROM employee;
```

![multiple aggregate functions result](http://snag.gy/sC3d7.jpg)

- `DISTINCT` can be used to eliminate duplicate values

``` sql
SELECT COUNT(job_id) AS 'jobs'
	COUNT(DISTINCT job_id) AS 'distinct jobs'
FROM employee;
```

![DISTINCT result](http://snag.gy/lHdsF.jpg)

- Aggregate functions will not have column names, so it is a good idea to use column aliases
- You cannot mix normal columns and aggregate functions, unless you use `GROUP BY`
	- Example of incorrect mixing of normal and aggregate function

``` sql
-- INCORRECT!
SELECT MAX(salary) AS 'max salary', last_name
FROM employee;
```

## Aggregate functions and `NULL`

- Aggregate functions **ignore** `NULL` values
- The exception is `COUNT(*)`
	- When `COUNT` is given a column, ie. `COUNT(manager_id)`
		- It ignores `NULL`s
		- Counts number of non-`NULL` rows

``` sql
SELECT COUNT(manager_id) AS 'managed employees'
FROM employee;
```

![COUNT(row) result](http://snag.gy/ugMNP.jpg)

- When `COUNT(*)` is used, it counts **every** row
	- Including `NULL`s

``` sql
SELECT COUNT(*) AS 'employees'
FROM employee;
```

![COUNT(*) result](http://snag.gy/ksvvC.jpg)

# `GROUP BY` clause

- The `GROUP BY` clause lets you specify grouping of output

**What is the average salary of employees per department:**

``` sql
SELECT department_id, AVG(salary) AS 'avg salary'
FROM employee
GROUP BY department_id;
```

- Aggregate function performed for each distinct group value
- Columns in the `GROUP BY` clause can be included in the `SELECT` list
- ie. It allows you to mix normal and aggregate columns

![AVG GROUP BY result](http://snag.gy/Halwr.jpg)

## `GROUP BY` example

**How many locations are there in each country:**

``` sql
SELECT country_id, COUNT(*) AS 'locations'
FROM location
GROUP BY country_id;
```

![COUNT(*) GROUP BY result](http://snag.gy/22Lon.jpg)

## `GROUP BY` without `SELECT`ed column

- The `GROUP BY` column does not need to be selected
	- However, it may make the results meaningless

**How many locations are there in each country:**

``` sql
-- country_id not selected here
SELECT COUNT(*) AS 'locations'
FROM location
GROUP BY country_id;
```

![COUNT(*) GROUP BY no SELECT result](http://snag.gy/Y1uKA.jpg)

## `GROUP BY` multiple columns

- You can `GROUP BY` more than one column

**What are the total salaries for each job in the department:**

``` sql
SELECT department_id, job_id, SUM(salary) AS 'total salary'
FROM employee
GROUP BY department_id, job_id
ORDER BY department_id, job_id;
```

![multiple `GROUP BY` result](http://snag.gy/8qjlR.jpg)

- **Note:** If you `GROUP BY` the **PK column** of a table, the results will not change if you also `GROUP BY` other columns in that table
	- ie. `job_id, job_title`
- The behaviour described in the note makes sense
	– The whole point of a PK column is to uniquely identify each row in a table
	- So if you group by it, there is no chance that other columns from the same table will have varying values (which would cause them to be grouped separately)
		- ie. `GROUP BY job_id, job_title`
		– Once the results have been grouped by `job_id`, you're not going to have more than one `job_title` for each `job_id`
	- This can be useful if you need to include the columns in your results

# `HAVING` clause

- The `HAVING` clause is used to specify conditions involving aggregate functions
	- Can't use aggregate functions in `WHERE` clause
- Essentially a `WHERE` clause that is aggregate function compatible
	- Allowing you to specify criteria relating to aggregate functions
- Syntax:

``` sql
HAVING <search condition>
```

- Typically goes after the `GROUP BY` clause
- Search condition is just any normal comparison
- Allows you to use aggregate functions in criteria

## `HAVING` example

**Display the average salary of departments that is greater than 6500:**

``` sql
SELECT department_id,
	AVG(salary) AS 'avg salary'
FROM employee
GROUP BY department_id
HAVING AVG(salary) > 6500;
```

![HAVING result](http://snag.gy/LdEN8.jpg)

# Combining it all

- You can combine `JOIN`s, aggregate functions, `GROUP BY` etc.

``` sql
SELECT department_name, job_title, AVG(salary) AS 'avg salary'
FROM employee e FULL OUTER JOIN department d
	ON e.department_id = d.department d
	INNER JOIN job j
	ON e.job_id = j.job_id
GROUP BY department_name, job_title
HAVING AVG(salary) > 6500
ORDER BY department_name, job_title;
```

- Uses two joins to get the department names and job titles
	- Since they're more user friendly than the id numbers/codes
- Shows average salary of each job within each department
- Average salary must be above $6500

![combined result](http://snag.gy/3ftIl.jpg)

# Aggregate function summary

- Aggregate functions perform calculations on a set of values and return a single result
	- Common functions
		- `AVG`
		- `SUM`
		- `MIN`
		- `MAX`
		- `COUNT`
- `NULL` values ingored by aggregate functions except `COUNT(*)`
- You cannot mix aggregate functions and normal columns in a `SELECT`
	- Unless they are listed in the `GROUP BY` clause
	- `GROUP BY` lets you specify grouping of output
- The `HAVING` clause allows criteria for aggregate functions
- As usual, everything can be combined for specific queries
