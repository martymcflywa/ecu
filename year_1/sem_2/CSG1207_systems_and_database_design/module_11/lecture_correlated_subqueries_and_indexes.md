# Correlated sub-queries and indexes

## Review of sub-queries

- Sub-queries involve embedding a `SELECT` statement in another SQL statement
	- The Sub-query is executed first, retrieving one or more values
	- The value/s are used by the outer query
	- Allows for the creation of queries which utilise data already in the database in `WHERE` criteria

![sub-query](http://snag.gy/iS1qd.jpg)

## Correlated sub-queries

- In module 10, all sub-queries were:
	- Independent from the main query
	- Executed once only
		- Before the outer query
- Correlated sub-queries change these two attributes
- Correlated sub-queries **reference the outer query**, hence:
	- They are **linked to the outer query**
	- They are **executed multiple times**
		- Once for each row of the outer query
- Syntax:

``` sql
SELECT select_list
FROM table AS tbl_alias
WHERE expr operator (
	SELECT select_list
	FROM table
	WHERE expr = tbl_alias.expr
);
```

- This is just an example/overview of the syntax, illustrating the concepts involved
- The sub-query references a column in the outer query
- Table in the outer column given a table alias to facilitate this

### Correlated sub-query example 1

**Find all employees who earn more than the average salary in their department:**

``` sql
SELECT last_name, salary, department_id
FROM employee AS e
WHERE salary > (
	SELECT AVG(salary)
	FROM employee
	WHERE department_id = e.department_id;
)
```

- The sub-query refers to the `department_id` in the outer query
	- Via the table alias `e`
- As the outer query checks each row against the `WHERE` clause, the sub-query is executed
- The table alias is needed to distinguish the tables, since both the outer and sub-query refer to the same table
	- Hence an alias is needed to specify that you are referring to the outer version
	- Much like a self join

![correlated sub-query example 1 result](http://snag.gy/iYbmf.jpg)

### Alternative solution using a `VIEW` and a `JOIN`

``` sql
CREATE VIEW dept_average
AS SELECT department_id, AVG(salary) AS dept_avg
	FROM employee
	GROUP BY department_id;
GO

SELECT last_name, salary, e.department_id, dept_avg
FROM employee e JOIN dept_average da
ON e.department_id = da.department_id
WHERE e.salary > da.dept_avg;
```

- Creates a `VIEW` which contains average `sal` of each department
- Uses `VIEW` in a `JOIN` with a simple `WHERE` clause

![alternative solution using view and join query result](http://snag.gy/111Nb.jpg)

### Correlated sub-query example 2

**Find all employees who have switched job at least twice:**

- This query relies upon the `job_history` table, which contains a row for each employee job change

![job_history table](http://snag.gy/efDYY.jpg)

- Each row contains an `employee_id`, and details of the job
	- We can assume that whenever an employee changes a job, a new row is added to this table with the details of their old job

``` sql
SELECT employee_id, last_name, job_id
FROM employee AS e
WHERE 2 <= (
	SELECT COUNT(*)
	FROM job_history
	WHERE employee_id = e.employee_id
);
```

- The sub-query counts the number of job changes for each employee
- Outer query only returns rows with two or more job changes
- Notice the use of a table alias to distinguish the appropriate columns in both the outer `SELECT` list and the `WHERE` clause of the sub-query

![correlated sub-query example 2 result](http://snag.gy/nWUe9.jpg)

- Again, the sub-query needs to be executed for each employee, counting the number of entries for the current employee in the `job_history` table
- Note that this query can also be done without a sub-query by using a `JOIN`, `GROUP BY` and `HAVING`:

``` sql
SELECT e.employee_id, last_name, e.job_id
FROM job_history AS j JOIN employee AS e
	ON j.employee_id = e.employee_id
GROUP BY e.employee_id, last_name, e.job_id
HAVING COUNT(*) >= 2;
```

- As well as not requiring a sub-query to be run for each row, this version also allows the number of job changes to be included in the results by including the `COUNT(*)` in the `SELECT` list

## `EXIST` and `NOT EXIST` operators

- Correlated sub-queries are often written such that the aim of the inner query is to determine if something exists
	- ie. To test if the sub-query returns **any** rows of data
- The `EXISTS` operator tests for the **existence** of returned rows in a sub-query
	- If the sub-query returns any rows of data, `EXISTS` is true
	- If nothing is returned, `EXISTS` is false
- `NOT EXIST` reverses this
	- If the sub-query returns any rows of data, `NOT EXISTS` is false
	- If nothing is true, `NOT EXISTS` is true

### `EXISTS` example

**Find all employees who have at least one person reporting to them:**

``` sql
SELECT employee_id, last_name
FROM employee AS e
WHERE EXISTS (
	SELECT 'whatever'
	FROM employee
	WHERE manager_id = e.employee_id
);
```

- The sub-query tests if the `employee_id` being examined in the outer query appears as the `manager_id`
- Since we're only testing if it exists, what it actually returns is irrelevant in this case
	- Hence the 'whatever' instead of a column
- Outer query is simply getting the id and name of employees and using `EXISTS` in the `WHERE` clause

![EXISTS example result](http://snag.gy/36bWI.jpg)

- Of course you could also replicate this using a simple sub-query:

``` sql
SELECT employee_id, last_name
FROM employee
WHERE employee_id IN (
	SELECT DISTINCT manager_id
	FROM employee
);
```

- Or you could use a correlated sub-query that uses `COUNT`:

``` sql
SELECT employee_id, last_name
FROM employee AS e
WHERE 0 < (
	SELECT COUNT(*)
	FROM employee
	WHERE manager_id = e.employee_id
);
```

### `NOT EXISTS` example

**Find all departments that DO NOT have any employees:**

``` sql
SELECT department_id, department_name
FROM department AS d
WHERE NOT EXISTS (
	SELECT 'whatever'
	FROM employee
	WHERE department_id = d.department_id
);
```

- The sub-query tests if there are any employees in the current department
- Outer query is simply getting the id and name of departments and using `NOT EXISTS` in the `WHERE` clause

![NOT EXISTS example result](http://snag.gy/hxNlj.jpg)

- This too can easily be done in other ways
	- For example:

``` sql
SELECT d.department_id, d.department_name
FROM employee AS e RIGHT OUTER JOIN department AS d
ON e.department_id = d.department_id
WHERE e.department_id IS NULL;
```

### `EXISTS` and `NOT EXISTS` vs. other methods

- Much of the time, what can be achieved with `EXISTS` and `NOT EXISTS` can also be achieved with other SQL code
	- This includes the use of
		- `JOIN`s
		- Simple sub-queries
		- Sub-queries using `ANY`, `ALL` and `IN`
		- Checking for `IS NULL` etc.
- Being able to achieve results in more than one way is a big part of SQLs flexibility
- Remember to consider
	- Which way is more readable
	- Which way is more reliable
		- Works in all circumstances
	- Which way does not rely on proprietary T-SQL features
	- Which way is more efficient / faster to execute

## Indexes

- An index is a database object that can be created to speed up the retrieval of rows
	- And hence execution of queries
- Similar to the index in a book, which can be used to rapidly locate the desired page/topic
	- An index in SQL allows the server to rapidly find the piece of memory in which the row data is stored
- When you define a primary key or unique constraint, the server automatically creates an index for the column/s
	- This makes sense, since such columns are likely to be used in queries, since they allow rows to be uniquely identified
	- Hence, being able to utilise such columns with greater efficiency is desirable
- Indexes are something used/managed by the server as needed
	- You do not need to incorporate them into your SQL queries in any way
	- If an appropriate index exists, it will be used

### Index creation and deletion

- Basic syntax is quite simple:

``` sql
CREATE INDEX index_name
ON {table_name | view_name}
	(column1 [ASC|DESC] [, column2 [ASC|DESC]...);

DROP INDEX {table_name | view_name}.index_name;
```

- Advanced syntax allows for many more optional parts
- `ALTER INDEX` command also exists
- For our purposes, basic syntax is sufficient
- Example:

``` sql
CREATE INDEX last_name_index
ON employee(last_name);

DROP INDEX employee.last_name_index;
```

### Viewing Indexes in SSMS

- Indexes can be found in the `Indexes` folder of the table to which they apply
- The automatically created ones are there too

![indexes in ssms](http://snag.gy/Gyn9B.jpg)

### When to create indexes

- If a query involves searching in an un-indexed column, each row must be examined
	- ie. In a `WHERE` clause
	- This is known as a table scan
	- The more rows there are, the longer this takes
- If an index exists for the column, the server will utilise it to speed up the search
- A table scan is much like reading a whole book to find references to a topic
	- Rather than looking it up in the index
- If indexes speed things up, why not create them for every column?
- See
	- http://www.1keydata.com/sql/sql-index.html
	- http://www.sql-server-performance.com/tips/optimizing_indexes_general_p1.aspx
- Each index is essentially **storing all of the data** from the column, in either ascending or descending order, along with a pointer to where the rest of the associated row is located
	- This means that it is much quicker/easier to match `WHERE` clauses that involve things like `<`, `>`, `=`, `BETWEEN`, etc
- By storing an ordered copy of a column, you can make it much easier for the server to match things in `WHERE` clauses
	- ie. If you added an index to the `salary` column in the `employee` table, matching `WHERE` clauses involving the column, (checking for `>`, `<`, `BETWEEN`) would be quicker
	- It's all in order, so the server can determine what needs to be searched
	- It finds matches in the index, then uses the pointer to the rest of the row to do whatever else it needs to do
- So again, why not create an index for every column
	- Disk space
		- While not so much a problem these days, storing another copy of each column doubles the size of a database
	- indexes slow down the modification of data, since whenever data is modified, all associated indexes also need to be kept up to date
		- ie. `INSERT`, `UPDATE`, `DELETE`

### Index example

- Imagine a `member` table with a `date_of_birth` column
	- The database involves several queries which use this column
	- ie. To find members over or under a certain age

**Find all members born between Jan 1, 1980 and Jun 30, 1980:**

``` sql
SELECT *
FROM member
WHERE date_of_birth BETWEEN '01-JAN-1980' AND '30-JUN-1980';
```

![member table no index](http://snag.gy/vRjj4.jpg)

- With no index, `date_of_birth` are unordered and each row must be checked in order to execute the query, which is slow

![date_of_birth index](http://snag.gy/wNY1G.jpg)

- With an index on `date_of_birth` column, an ordered version exists
	- The index can be searched quickly to find the values that match the clause

### Clustered indexes

- Normal, non-clustered indexes store the content of the index key (one or more columns), and a pointer to where the rest of the data can be found
	- Once matching keys are found, pointer directs query to data
- A clustered index stores the index key, and the rest of the data in the table, every column in a row
	- Essentially, the entire table ordered by the index key
	- This represents the physical storage of the table
	- No need to follow a pointer to the rest of the data, it's all there
- While a normal index is like the index of a book, a clustered index is like a **phone book**
	- An ordered set of data
- A clustered index essentially defines the order in which the table rows are physically stored
- In order to create a clustered index on a column that isn't the primary key, you need to specify the primary key constraint as being unclustered
- Syntax is the same, with the word `CLUSTERED` in it:

``` sql
CREATE CLUSTERED INDEX index_name
ON {table_name | view_name}
	(column1 [ASC | DESC] [, column2 [ASC | DESC]...);
```

- A clustered index will automatically be created by the server, using the primary key as the index key
	- Can only have one clustered index per table
- If a column other than the primary key is used in most queries, a clustered index for that column may be better
	- You can still create non-clustered index for the primary key
- Overheads of maintaining the index can be significant

### When to create an index

- Creating indexes must balance the benefits of efficiency
- General guidelines and considerations include:
	- Indexes are more efficient on columns that are not often modified
		- Less time spending maintaining the index
	- Indexes are best made on columns that are frequently used in `WHERE` clauses, `JOIN` conditions etc.
	- Integer based columns which don't take much storage space are good for indexes
		- As are short columns with few duplicates
	- Indexes are most useful in large tables where most queries are expected to retrieve only a small subset of rows
- All the databases we've been using in this unit have relatively few rows of data
	- 20 employees in the company database etc.
	- Hence all of our queries execute almost instantly regardless of indexes
- However, in the real world, it is possible for a table to have tens of thousands or even millions of rows of data
	- And there may be tens, hundreds, or more people using the database simultaneously
	- Indexes are extremely important in these situations
