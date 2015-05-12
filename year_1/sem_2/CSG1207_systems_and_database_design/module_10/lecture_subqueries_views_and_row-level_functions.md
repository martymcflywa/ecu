# Subqueries, views and row level functions

## Subqueries

- It is possible to embed a `SELECT` statement in another SQL statement
	- ie. Within another `SELECT` statement
	- Subqueries introduces in `INSERT` and `UPDATE`
		- See Module 8
- Can be useful when queries depend on data that is stored in database
	- May be as simple as retreiving a single value from another row of a table to use in an `UPDATE` statement
	- Or could involve a complex subquery that uses `JOIN`s, aggregate functions, `GROUP BY` and `HAVING` clauses etc. to retreive and make use of very specific data

### Subquery example

**Who has a salary greater than Grant's `employee_id 15`?**

- We need to know Grant's salary to answer this question
- Grant's salary is stored in the database
- To answer this question, we must:
	1. Determine Grant's salary by retrieving it from the database
	2. Retrieve employee details with a higher salary than Grants

![nested queries](http://snag.gy/fG3n6.jpg)

- When queries are nested, they are always processed from the innermost to the outermost query
	- ie. Subqueries first
- The queries involved are very simple:

``` sql
-- Main/Outer query
SELECT last_name, salary FROM employee WHERE salary >

-- Sub/Inner query
SELECT salary FROM employee WHERE employee_id = 15
```

- Syntax involved:

``` sql
SELECT last_name, salary
FROM employee
WHERE salary > (
	SELECT salary
	FROM employee
	WHERE employee_id = 15
);
```

- Note the parenthesis `()` around the subquery and how it is positioned where it is needed in the outer query

``` sql
SELECT last_name, salary
FROM employee
WHERE salary > (
	SELECT salary
	FROM employee
	WHERE employee_id = 15
)
ORDER BY salary DESC;
```

- You can of course, enhance the query further
	- Adding more conditions, ordering results etc
		- As with any other `SELECT`
- You can have multiple subqueries
	- In different parts of the outer query

### Subquery guidelines

- Enclose subqueries in parenthesis `()`
- Place subqueries on the right side of a comparison
- Use single-row comparison operators with single-row subqueries
- Use multiple-row comparison operators with multiple-row subqueries
	- The data returned by the subquery must match the data expected wherever it is located in the outer query
- Use indenting to make your subqueries clear

### Single-row and multiple-row subqueries

- Subqueries can be categorised into two types:
	1. Those that can only return a **single** row of data
	2. Those that may return **multiple** rows of data
- The type of subquery you use must match what is expected where the subquery is located in the outer query
	- Comparisons involving the following operations expect a single row
		- `=`
		- `>`
		- `>=`
		- `<`
		- `<=`
		- `!=`
	- Aggregate functions can be used in a subquery to return a single value
		- ie. A max or average salary value
	- Comparison operators used for multiple rows
		- `IN`
		- `ANY`
		- `ALL`

#### Single-row subquery example

- The previous example `salary > Grant's` was a single-row subquery
	- We'll extend that example here

**Select the last name and salary of employees in the same job grade as Grant**

- A `JOIN` is required to determine an employee's job grade
- Job grades are determined by a min and max salary
	- ie. Grade B is salaries from `3000` to `5999`
- Need to determine which grade level Grant's salary places him in before we can determine who else is in that grade level

``` sql
SELECT last_name, salary
FROM employee INNER JOIN job_grade
ON salary BETWEEN lowest_sal AND highest_sal
WHERE grade_level = (
	SELECT grade_level
	FROM employee INNER JOIN job_grade
	ON salary BETWEEN lowest_sal AND highest_sal
	WHERE employee_id = 15
)
ORDER BY salary DESC;
```

- Subquery determines grade level of Grant
- Outer query selects all employees with matching grade level
- Both queries require the `JOIN`
	- To compare grade levels we need the join to match grades to employee salaries
- As is often the case, there is more than one way to do this

``` sql
SELECT last_name, salary
FROM employee
WHERE salary BETWEEN (
	SELECT lowest_sal
	FROM employee INNER JOIN job_grade
	ON salary BETWEEN lowest_sal AND highest_sal
	WHERE employee_id = 15
) AND (
	SELECT highest_sal
	FROM employee INNER JOIN job_grade
	ON salary BETWEEN lowest_sal AND highest_sal
	WHERE employee_id = 15
)
ORDER BY salary DESC;
```

- Subqueries use `JOIN` to select lowest and highest salary values for the appropriate grade level
	- Grant is in grade `C`
- Outer query uses `BETWEEN` to find other employees who have salaries within those boundaries
	- No `JOIN` needed

##### Single-row aggregate subquery

- Aggregate functions can be used in subqueries as well
- What does this query do?

``` sql
SELECT last_name, salary
FROM employee
WHERE salary > (
	SELECT AVG(salary)
	FROM employee
)
ORDER BY salary DESC;
```

- Select last name and salary whose salaries are greater than the average

### Multiple-row subqueries

- You **cannot** use a single row comparison operator with a subquery that returns multiple rows
- Multiple row comparison operators include
	- `IN`: Equal to any member in list
	- `ANY`: Compare to any value returned by subquery
	- `ALL`: Compare to all values returned by subquery

#### Using `IN`

**Get the last name of everyone who has the same job as Kochhar or Lorentz:**

``` sql
SELECT last_name
FROM employee
WHERE job_id IN (
	SELECT job_id
	FROM employee
	WHERE last_name IN ('Kochhar', 'Lorentz')
);
```

- `IN` can be given in a subquery rather than a list of values or expressions
- Each row of the subquery becomes a value/expression in the `IN` list
- In this example, since Kochhar and Lorentz have join titles of `AD_VP` and `IT_PROG` respecetively, the query retrieves the last name of everyone with those job titles

#### Using `ANY` and `ALL`

- `ANY` and `ALL` are added after normal (single-row) comparison operators to allow for multiple-row subqueries
	- Comparisons with `ANY` will be true if at least one row is true
	- Comparisons with `ALL` will only be true if all rows are true
- Examples
	- `value > ANY (multiple-row subquery)`
		- `value` must be bigger than at least one row
	- `value > ALL (multiple-row subquery)`
		- `value` must be greater than every row
- You may be able to deduce that `= ANY` is the same as `IN`
- `< ALL` means "less than the minimum in the rows"
- `> ALL` means "greater than the max in the rows"
- `ANY` and `ALL` aren't really comparison operators themselves
	- Are more like modifiers that allow single-row comparisons to be applied to multiple-rows with either a "match at least 1" or "match all" condition

#### Multiple-row subquery `ANY` example

**List the last name, job id and salary of employees who are not IT programmers, and earn less than any of the IT programmers:**

``` sql
SELECT last_name, job_id, salary
FROM employee
WHERE job_id != 'IT_PROG'
AND salary < ANY (
	SELECT salary
	FROM employee
	WHERE job_id = 'IT_PROG'
);
```

![multi-row any result](http://snag.gy/ogQ71.jpg)

- Note the wording
	- Less than any means "less than any one of the rows"
	- Not "less than all of them"
- All employees returned are paid less than at least one of the IT programmers
- The first subquery gets the salaries of all the employees with a job id of `IT_PROG`
	- Then the main query gets the employee details of employees who have a salary of less than any one of the IT programmer's salaries
- Note: You can do this using a single-row subquery and an aggregate function
	- Might be easier to read the following version:

``` sql
SELECT last_name, job_id, salary
FROM employee
WHERE job_id != 'IT_PROG'
AND salary < (
	SELECT MAX(salary)
	FROM employee
	WHERE job_id = 'IT_PROG'
);
```

#### Multiple-row subquery `ALL` example

**List the last name, job id and salary of employees who are not IT programmers, and earn less than all of the IT programmers:**

``` sql
SELECT last_name, job_id, salary
FROM employee
WHERE job_id != 'IT_PROG'
AND salary < ALL (
	SELECT salary
	FROM employee
	WHERE job_id = 'IT_PROG'
);
```

![multi-row all result](http://snag.gy/EzC2Z.jpg)

- Less than all means "less than every one of the rows"
- All employees returned are paid less than all of the IT programmers
- This example is almost the same, except it uses `ALL` instead of `ANY`
	- Now the query only returns employees who earn less than all of the IT programmers
- Note: You can use an alternative version that avoids using `ALL`:

``` sql
SELECT last_name, job_id, salary
FROM employee
WHERE job_id != 'IT_PROG'
AND salary < (
	SELECT MIN(salary)
	FROM employee
	WHERE job_id = 'IT_PROG'
);
```

### Subqueries vs. `JOIN`s

- Results of subqueries can sometimes be recreated using `JOIN`s and vice versa
- For example, **who earns more than Grant?** can be done using a `JOIN`

``` sql
SELECT e1.last_name, e1.salary
FROM employee AS e1 INNER JOIN employee AS e2
ON e1.salary > e2.salary
AND e2.employee_id = 15
ORDER BY e1.salary DESC;
```

- A self `JOIN` as seen in Module 9
- In this case, the version using a subquery was a lot easier to understand
	- And hence to maintain
	- Take this into account

## `VIEW`s

- Views are **database objects**, like tables
	- When you create them, they continue to exist until deleted
- Views allow you to store and use a representation of data from one or more tables
- Views are often known as **virtual tables**
- They are essentially a `SELECT` statement which is saved on the server
	- Allows you to use the rows and columns of data that the statement returns **as if it were a table**
	- Views do not occupy much disk sapce as they have no data of their own
	- You're only saving the `SELECT` statement
- See http://msdn.microsoft.com/en-US/library/ms187956.aspx
- Views are handing, allowing you to abstract away many of the fiddly details in a database

### Simple `VIEW` example

![employee (table)](http://snag.gy/2ff7N.jpg)

``` sql
CREATE VIEW emp_contacts
AS SELECT	first_name,
			last_name,
			email,
			phone_number
	FROM employee;
```

![emp_contacts (view)](http://snag.gy/nT8Hn.jpg)

### Purpose for using `VIEW`s

- `VIEW`s provide a seamless way to combine data from multiple tables
	- Create a `VIEW` that combines data using a `JOIN`, then use the `VIEW` in queries without having to perform the `JOIN` each time
	- The results of a `VIEW` can be used as a table whenever needed
		- To `SELECT` from
		- To manipulate data
		- To use in further `JOIN`s
		- etc.
- `VIEW`s can restrict some users from seeing part of the database
	- Provides data independence
	- Database users can be given access to `VIEW`s which only show what they need to see
		- ie. Contact details byt not salary details
		- Auto incrementing integers can also be hidden
- `VIEW`s can hide the details of complicated queries
	- Making complex queries easier
	- The `SELECT` statement used to create a `VIEW` can contain any amount of
		- `JOIN`s
		- Expressions
		- Arithmetic
		- Clauses
		- etc.
- One common and useful `VIEW` would be one which simply gets all columns in a table, and uses `JOIN`s to replace any ID based foreign keys with their corresponding names in a lookup table or similar
	- For example, a version of the employee table where you see job titles and department names rather than the ids for them
- Since you are not actually storing the results of the `VIEW`, just the statement to retrieve them, the data is being stored in a normalised manner
- But creating a `VIEW` such as this means we now have a very easy way to view and use more meaningful information

### Creating a `VIEW`

- Syntax:

``` sql
CREATE VIEW view_name [(column_alias[, column_alias]...)]
AS subquery
[WITH CHECK OPTION]
```

- `VIEW` name must be specified
	- Used to refer to the view in the same way as table names are used
- You can specify names for the columns of the view
	- Although you can specify them in `SELECT` statements as well
- Subquery is the `SELECT` statement that the view will store / perform when it is used
- `WITH CHECK OPTION` is optional
- See http://msdn.microsoft.com/en-us/library/ms187956.aspx
- Specifying column aliases in `CREATE VIEW` is optional
	- You can just use column aliases in the `SELECT` subquery instead
- The important thing to remember is just that all columns **must** have a name
	- When you uuse arithmetic and aggregate functions, the result does not get a column name
	- You need to specify one
		- Eitherin the `CREATE TABLE` or `SELECT` line

### Creating and querying a `VIEW`

- First we create a view named `emp_contacts`

``` sql
CREATE VIEW emp_contacts
AS SELECT 	employee_id AS emp_id,
			first_name,
			last_name,
			email,
			phone_number
	FROM employee;
```

- Then we can use it in queries as if it were a table

``` sql
SELECT *
FROM emp_contacts
WHERE last_name LIKE 'K%';
```

![emp_contacts view query results](http://snag.gy/878qR.jpg)

#### Creating and querying a `VIEW` useful example

``` sql
CREATE VIEW emp_info
AS SELECT	e.employee_id AS emp_id,
			e.first_name,
			e.last_name,
			job_title,
			e.salary,
			m.last_name AS manager_name,
			department_name AS department
	FROM employee AS e LEFT OUTER JOIN department AS d
	ON e.department_id = d.department_id
	LEFT OUTER JOIN job AS j
	ON e.job_id = j.job_id
	LEFT OUTER JOIN employee AS m
	ON e.manager_id = m.employee_id;
```

- The `SELECT` query uses three `JOIN`s to get the department name, job title and manager name, rather than the IDs and codes
- Have omitted numerous fields, but they could be included if the `VIEW` was to be used in further queries

``` sql
SELECT *
FROM emp_info;
```

![emp_info view query results](http://snag.gy/DNfNq.jpg)

### Viewing a `VIEW` in SSMS

- `VIEW`s are in the "Views" folder of the database they apply to in SMSS
- As with other database objects, you may need to refresh the "Object Explorer" display to see changes

![SMSS views 1](http://snag.gy/eYBwW.jpg)

- Viewing a `VIEW` is similar to viewing a table
	- Remember that data is stored in the table/s, not the `VIEW`

![SMSS views 2](http://snag.gy/SLZHD.jpg)

### Data in `VIEW`s

- `VIEW`s **do not store data** of their own
	- `VIEW`s are not real tables
	- The data is still stored in the original tables as normal
- All the server stores is the name of the `VIEW`, and its associated `SELECT` statement
	- When you use the `VIEW` in a statement, the server performs the associated `SELECT` statement
	- Just like a subquery!
- If you create a `VIEW`, and then modify the schema of the tables that it uses, the `VIEW` may stop working
	- The `SELECT` statement must be valid for it to work
- If you create a view such as the `emp_info` `VIEW` we created previously, and then you modify the tables involved..
	- ie. Rename the `salary` column to `wage` in the `employee` table
	- The `VIEW` will no longer work
	- This is because the `SELECT` statement associated with the `VIEW` will still be the same
		- It will still be looking for `salary`
	- You need to update the `VIEW` so that it has a valid/working `SELECT` statemnet associated with it

### Altering a `VIEW`

- Syntax:

``` sql
ALTER VIEW view_name [(column_alias[, column_alias]...)]
AS subquery
[WITH CHECK OPTION]
```

- `VIEW` name must already exist
- Subquery can be entirely different from the original
- Essentially the exact same syntax and usage, but redefines an existing `VIEW` name rather than creating a new one

``` sql
ALTER VIEW emp_contacts
AS SELECT	first_name + ' ' + last_name AS full_name,
			LOWER(email)+'@corp.com' AS email,
			phone_number
	FROM employee;
```

- Altering a `VIEW` is somewhat trivial, since the only thing a `VIEW` actually contains is a `SELECT` statement
	- So you're essentially just specifying a new `SELECT` statement and keeping the same name

### Dropping a `VIEW`

- Syntax:

``` sql
DROP VIEW view_name;
```

- Works the same as `DROP TABLE`
- A lot less risky, since the only thing deleted/list is the `VIEW` name and `SELECT` statement associated with it
- No data (row/s) are lost

### Manipulating data through `VIEW`s

- All data (row/s) shown in a `VIEW` have been drawn from where it is stored
	- In tables
- You can use DML statements `INSERT`, `UPDATE`, `DELETE` to manipulate this data via a `VIEW`
	- Syntax is the same as normal, using the `VIEW` name instead of a table name
- To ensure that `INSERT`s/`UPDATE`s/`DELETE`s performed on a `VIEW` are fully processed, following the statement with the `GO` command is recommended
- Numerous circumstances will make it impossible to manipulate data via a `VIEW`

``` sql
-- View created:
CREATE VIEW job_titles
AS SELECT job_id, job_title
	FROM job;

-- New row inserted into job table.
-- Columns not included in VIEW get default or NULL values.
INSERT INTO job_titles
VALUES ('MK_ASS', 'Marketing Assistant');

-- Row in job table updated.
UPDATE job_titles
SET job_id = 'MK_ASST'
WHERE job_id = 'MK_ASS';

-- Row deleted from job table.
DELETE FROM job_titles
WHERE job_id = 'MK_ASST';
```

#### Manipulating data through `VIEW`s requirements

- You can only manipulate data through a `VIEW` when:
	- You are trying to manipulate `INSERT`, `UPDATE`, `DELETE` columns that are drawn from **one table**
	- The columns being manipulated **directly reference the columns of a table**
		- No arithmetic, aggregate functions etc.
	- There are no `NOT NULL` columns without default values in the table that are not included in the `VIEW`
		- `INSERT` requirement only
	- The columns being manipulated are not affected by a `GROUP BY`, `HAVING` or `DISTINCT` clause
- Essentially, you can only manipulate data via a `VIEW` if the `VIEW` of what you are doing would be valid without the `VIEW`
- Note: Most of these make sense, since manipulating the data shown in the `VIEW` would not make any sense
	- ie. It comes from multiple tables, or is the result of performing a calculation on numerous rows etc.
	- Hence you can only really use a view for DML if it is quite a simple `VIEW`
	- When it comes to `VIEW`s that omit required columns, from their base table, you cannot insert new rows via the `VIEW`
		- ie. NOT NULL and with no default
	- This makes sense, since you cannot specify a value for these columns, and they can't be given a default or null value
	- Of course, if rows are already in the columns, you can update or delete them via this `VIEW`

### `WITH CHECK OPTION`

- By including `WITH CHECK OPTION` at the end of a `CREATE`/`ALTER VIEW` statement, you can prevent any inserts or updates that would make the row unavailable in the `VIEW`
- Example:

``` sql
CREATE VIEW low_pay_emps
AS SELECT	employee_id,
			first_name,
			last_name,
			salary
	FROM employee
	WHERE salary < 5000
WITH CHECK OPTION;
```

- `low_pay_emps` `VIEW` shows the id, name and salary of employees who earn less than $5000
- Attempting to update a salary to over $5000 would result in an error message

## Row level functions

- While aggregate functions perform a calculation on multiple rows and return one result, row level functions **operate on and return a result for every row**
	- Row level functions **can** be used in `WHERE` clauses
- Row level functions can do numerous and various things
	- Numeric / mathematical functions
	- String / character manipulation
	- Date and time manipulation
	- Data type conversion
	- Miscellaneous functions
- Row level functions often resemble functions available in many programming languages
- Syntax fo row level functions is fairly simple
	- Name of function is followed by parenthesis `()`, inside which is the column/expression to perform the function on
	- Other parameters may be between the parenthesis
		- ie. The number of decimal places desired when using `ROUND` to round a numeric column
- As with aggregate functions, columns which involve row level functions will not have names
	- Use column aliases to specify names as needed

### Numeric / mathematical functions

- Many mathematical functions are available
	- `SIN()`
	- `COS()`
	- `SQRT()`
	- `LOG()`
	- `EXP()`
	- `ABS()`
	- Unlikely to be needed in most databases but useful to know
- More widely used mathematical functions include
	- `ROUND(expression, length)`
		- Rounds a value to the specified number of decimal points
	- `FLOOR(expression)` and `CEILING(expression)`
		- Returns the closest integer below or above a value
	- `RAND()`
		- Returns a random floating point number between 0 and 1
		- Does not need a value
		- Can use arithmetic and other functions to make it a random number within whatever ranges is desired

#### Numeric / mathematical functions example

- Some of these examples just use numbers to demonstrate the functions, rather than columns from a table
- If all the columns you are `SELECT`ing are not drawn from tables, you don't even need a `FROM` clause
	- The first few examples just demonstrate the functions using numbers rather than columns

``` sql
-- Returns 3, 4 and 3.14
-- PI() function returns the value of pi
SELECT FLOOR(PI()), CEILING(PI()), ROUND(PI(), 2);

-- Returns random floating point number between 0 and 1
-- ie. 0.607848129504828
SELECT RAND();

-- Returns random integer between - and 100, ie. 57
SELECT ROUND(RAND() * 100, 0);

-- Returns last name, salary, and salary plus a random number between 0 and 10% of salary for each employee
SELECT last_name, salary,
	salary + ROUND(RAND() * (salary / 10), 0)
FROM employee;
```

### String / character manipulation

- These functions let you manipulate strings
- Again there are many functions available
- Some common ones are
	- `LOWER(expression)` and `UPPER(expression)`
		- Change a value to lower/upper case
	- `LEFT(expression, length)` and `RIGHT(expression, length)`
		- Returns the specified number of characters from the left or right end of a string
		- ie. `LEFT('hello', 2)` returns 'he'
	- `LTRIM(expression)` and `RTRIM(expression)`
		- Returns the value without leading or trailing spaces
	- `LEN(expression)`
		- Returns the number of characters in the value
	- `REPLACE(expression, replacing, replaced with)`
		- First parameter is an expression, second is what to replace, third is what to replace it with
		- See http://msdn.microsoft.com/en-us/library/ms186862.aspx
	- `SUBSTRING(expression, startpoint, length)`
		- First parameter is an expression, second is int starting point, third is int length
		- See http://msdn.microsoft.com/en-gb/library/ms187748.aspx
	- `CHARINDEX(char, string)`
		- Returns the index of char in string
		- See http://msdn.microsoft.com/en-gb/library/ms186323.aspx
- See String functions http://msdn.microsoft.com/en-gb/library/ms181984.aspx
	- `LOWER` http://msdn.microsoft.com/en-gb/library/ms174400.aspx
	- `LEFT` http://msdn.microsoft.com/en-gb/library/ms177601.aspx
	- `LTRIM` http://msdn.microsoft.com/en-gb/library/ms177827.aspx

#### String / character manipulation example

- Some of these examples just use strings to demonstrate the functions, rather than columns from a table

``` sql
-- Returns 'hello world' and 'HELLO WORLD'
SELECT LOWER('Hello World'), UPPER('Hello World');

-- Returns 'Hel' and 'rld'
SELECT LEFT('Hello World', 3), RIGHT('Hello World', 3);

-- Returns ' Hello   ' and '   World'
SELECT LTRIM('   Hello   '), RTRIM('   World   ');

-- Returns 5, 'Jello', 'lo' and 3
SELECT LEN('Hello'), REPLACE('Hello', 'H', 'J'),
	SUBSTRING('Hello', 4, 2), CHARINDEX('l', 'Hello ');
```

### Date and time manipulation

- Functions to manipulate or format dates and times
	- `DAY(date)`, `MONTH(date)`, `YEAR(date)`
		- Returns part of a date
	- `DATEPART(datepart, date)`
		- `datepart` specifies the part of date to return
			- See http://msdn.microsoft.com/en-gb/library/ms174420.aspx
			- Anything from millisecond to day of year, week, week day number, etc.
	- `GETDATE()`
		- Returns the current date and time
		- Can be used as the `datepart` of other date manipulation functions
	- `DATEDIFF(datepart, start_date, end_date)`
		- Returns the difference between two dates, expressed in the unit specified in datepart
		- See http://msdn.microsoft.com/en-gb/library/ms189794.aspx
- See http://msdn.microsoft.com/en-gb/library/ms177516.aspx

#### `DATEPART`s

- `DATEPART`s are the different units of a date that can be used

![dateparts](http://snag.gy/9MTql.jpg)

``` sql
-- Returns 1987.
SELECT DATEPART(yy, '1987-08-25');

-- Returns 8.
SELECT DATEPART(mm, '1987-08-25');

-- Returns 25.
SELECT DATEPART(dd, '1987-08-25');

-- Returns 5760.
SELECT DATEDIFF(mi, '1987-08-25', '1987-08-29');
```

- You can use the full name of the `DATEPART` or any of the abbreviations in functions needing a `DATEPART`

#### Date and time manipulation examples

- Some of these examples just use dates to demonstrate the functions, rather than columns from a table

``` sql
-- Returns 25 and 8.
SELECT DAY('1987-08-25'), MONTH('1987-08-25');

-- Returns the last name and number of years that
-- each employee has worked at the company for,
-- based on hire date.
SELECT last_name, DATEDIFF(yy, hire_date, GETDATE()) AS work_years
FROM employee;

-- Returns 1988-02-25 (six months added to specified data)
SELECT DATEADD(mm, 6, '1987-08-25');
```

### Data type conversion

- Converting between data types can happen either
	- **Implicitly**
		- When SQL Server converts data types as needed
		- ie. Integers will often be converted to floats when used in arithmetic operations that can result in a float
	- **Explicitly**
		- When row level functions are used in a query to convert one data type to another
			- For that query only
- Common explicit conversion functions
	- `CAST(expression AS data_type)`
		- See http://msdn.microsoft.com/en-us/library/ms187928.aspx
	- `CONVERT(data_type, expression [, style])`
		- Change a value to the specified type
		- See http://msdn.microsoft.com/en-us/library/ms187928.aspx
	- `STR(float_expression, length, decimals)`
		- Converts float values to string/char
		- See http://msdn.microsoft.com/en-us/library/ms189527.aspx

#### Data type conversion examples

- Some of these examples just use values to demonstrate the functions, rather than columns from a table

``` sql
-- Returns 'Pi is equal to 3.14159'.
SELECT 'Pi is equal to ' + CAST(PI() AS CHAR);

-- Returns 25 (int) and '25.68985' (string).
SELECT CAST(25.68985 AS INT), CAST(25.68985 AS CHAR);

-- Returns 25 and 25 as int.
SELECT CAST(25.68985 AS INT), CONVERT(INT, 25.68985);

-- Returns the date in the default SQL Server format,
-- The date in 'DD/MM/YY' format, and the date in
-- 'Mon DD, YYYY' format
SELECT GETDATE(),
	CONVERT(VARCHAR, GETDATE(), 3),
	CONVERT(VARCHAR, GETDATE(), 107);
```

- `style` parameter for `CONVERT` is not intuitive or readable
	- See http://msdn.microsoft.com/en-us/library/ms187928.aspx
	- See http://www.sql-server-helper.com/tips/date-formats.aspx

### Miscellaneous functions

- Numerous other functions exist that don't fall into the categories previously covered
- See http://msdn.microsoft.com/en-us/library/ms174318.aspx
- Some concern `NULL` values
	- `ISNULL(expression, value)`
		- If expression is `NULL`, returns value, otherwise returns expression
		- See http://msdn.microsoft.com/en-us/library/ms184325.aspx
	- `NULLIF(expression1, expression2)`
		- If both expressions are equal, returns `NULL`, otherwise returns `expression1`
		- See http://msdn.microsoft.com/en-us/library/ms177562.aspx
	- `COAELSCE(expression1, expression2, expression3, ...)`
		- Returns the first expression that is not null
		- If all of them are null, returns `NULL`
		- See http://msdn.microsoft.com/en-us/library/ms190349.aspx

#### Miscellaneous functions example

- Some of these examples just use dates to demonstrate the functions, rather than columns from a table

``` sql
-- Returns salary of employees. If salary is null, returns 0.
SELECT ISNULL(salary, 0) FROM employee;

-- Returns salary + salary * commission percentage.
-- If commission percentage is NULL, just returns salary.
-- SELECT salary + salary * ISNULL(commission_pct, 0) from employee;

-- Returns NULL, 3.14, NULL, NULL
-- Note that the float of 100.00 and string of '100' are equivalent.
SELECT NULLIF('Smith', 'Smith'), NULLIF(100.00, '100'),
	NULLIF(3.14, ROUND(PI(), 2)), NULLIF(100.00, '100');

-- Returns 1.0 (return value is converted to *widest* data type in expression list)
-- In this case, a float.
SELECT COALESCE(NULL, 1, NULL, '2', 3.4);
```

### Row level functions big example

``` sql
SELECT ISNULL(last_name + ' has worked here for ' +
	CAST(DATEDIFF(yy, hire_date, GETDATE()) AS VARCHAR) +
	' years.', 'We do not know when ' + last_name +
	' started working here.') AS work_time
FROM employee;
```

- `GETDATE()` gets the current date
- `DATEDIFF()` uses `hire_date` and current date to calculate years `yy` between hire date and current date
- `CAST()` converts the result (difference of years) to a `VARCHAR` so that it can be concatenated with the rest of the string
- `ISNULL()` makes sure that any rows with `NULL` in the `hire_date` column return an approprate message rather than `NULL`

![big example result](http://snag.gy/oGVXA.jpg)
