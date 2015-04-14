# `WHERE`, `ORDER BY` and data types

## `WHERE`

- `WHERE` limits the retrieved rows to specified condition/s

``` sql
SELECT	*|{[DISTINCT] column|expression [alias], ...}
FROM	table
[WHERE	Conditions];
```

- The `WHERE` clause is optional in a `SELECT` statement
- It follows the `FROM` clause, which specifies table/s
- The `WHERE` clause identifies **which row/s** to return
	- One or more **conditions** can be specified
		- Criteria by which to select which rows to retrieve
	- Only those rows whose values make the condition/s true will be returned

### `WHERE` with `CHAR`

- A query without the `WHERE` clause

``` sql
SELECT first_name, last_name, gender
FROM employee;
```

![where char 1](http://snag.gy/SJwvM.jpg)

- A query using `WHERE` to limit retrieved rows to female employees

``` sql
SELECT first_name, last_name, gender
FROM employee
WHERE gender = 'F';
```

![where char 2](http://snag.gy/vHugB.jpg)

- `CHAR` values are not case sensitive
	- `'f'` would also work
- `CHAR` values must be enclosed in single quotes `''`

### `WHERE` with `DATE`

- A query using `WHERE` to limit retrieved rows to employees who were hired on May 7th, 1999

``` sql
SELECT first_name, last_name, hire_date
FROM employee
WHERE hire_date = '1999-05-07';
```

![where date](http://snag.gy/8m2PK.jpg)

- Date values are format sensitive
	- The most widely recognised format is `YYYY-MM-DD`
	- `DD-MMM-YYYY` 01-JAN-2010 also works
	- This differs in some other RDBMS
		- Always test carefully
- Date values must also be enclosed in single quotes `''`

### Comparison operators

- Comparison operators are used to specify criteria in the conditions of a `WHERE` clause

![comparison operators](http://snag.gy/RSwIo.jpg)

- Different data types allow for the use of different comparison operators
	- ie. Using `<` or `>` between two numerical data types makes sense
		- But using it between two `CHAR` does not

#### Comparison operators in use

- A query using `WHERE` with a comparison operator to limit retrieved rows to employees with a salary of at least 15,000

``` sql
SELECT last_name, salary
FROM employee
WHERE salary >= 15000;
```

![>= comparison operator](http://snag.gy/KbJoI.jpg)

- Do not use quote marks `''` with numeric values
	- ie. `INT`, `FLOAT`
	- If you do, they will be interpreted as `CHAR` not numbers

#### More comparison operators

- Comparisons are a big part of SQL, and hence there are some other comparison operators we can use to help us out

![more comparison operators](http://snag.gy/tPPjs.jpg)

##### `BETWEEN`

- The formate of between is:
	- `column BETWEEN lower_limit AND upper_limit`
- A query using `WHERE` with `BETWEEN` to limit retrieved rows to employees with salaries between 10,000 and 20,000

``` sql
SELECT last_name, salary
FROM employee
WHERE salary BETWEEN 10000 AND 20000;
```

![between](http://snag.gy/XlQlt.jpg)

##### `IN`

- `IN` lets you test if something is equal to numerous values:
	- `column IN (value1, value2, value3)`
- A query using `WHERE` with `IN` to limit retrieved rows to employees with job ids of `AD_PRES`, `AD_VP` or `AD_ASST`

``` sql
SELECT last_name, job_id
FROM employee
WHERE job_id IN ('AD_PRES', 'AD_VP', 'AD_ASST');
```

![in](http://snag.gy/IsKWi.jpg)

##### `LIKE`

- `LIKE` can perform wildcard searches on columns:
	- `column LIKE 'search_pattern'`
- `LIKE` can search character data types, as well as numeric ones
	- **Always** need the quote marks around `'search_pattern'`
	- `LIKE` is **not** often used on numbers, since it makes more sense to use comparisons like `>`, `<`, `BETWEEN`, etc. with numbers
- Wildcards add flexibility to your searching, like `*` in Windows
	- `%` denotes **zero or more of any character**
	- `_` denotes **any one character**
- Character ranges add more specific flexibility
	- `[range]` denotes **any one character within this range**
	- `[^range]` denotes **any one character not within this range**

###### `LIKE` and `%`

- `%` denotes **zero or more of any character**
- A query using `WHERE` with `LIKE` and `%` to limit retrieved rows to employees with "el" in their first name

``` sql
SELECT first_name
FROM employee
WHERE first_name LIKE '%el%';
```

![like % 1](http://snag.gy/DNFnY.jpg)

- A query using `WHERE` with `LIKE` and `%` to limit retrieved rows to employees with job ids starting with "SA"

``` sql
SELECT last_name, job_id
FROM employee
WHERE job_id LIKE 'SA%';
```

![like % 2](http://snag.gy/V0CIi.jpg)

###### `LIKE` and `_`

- `_` denotes **any one character**
	- Must be **one**
- A query using `WHERE` with `LIKE`, `_` and `%` to limit retrieved rows to employees with "a" as the second letter of their first name

``` sql
SELECT first_name
FROM employee
WHERE first_name LIKE '_a%';
```

![like _ 1](http://snag.gy/9sYqS.jpg)

- A query using `WHERE` with `LIKE`, `_` and `%` to limit retrieved rows to employees with "s" as first letter, and "e" as second last letter in their first name

``` sql
SELECT first_name
FROM employee
WHERE first_name LIKE 's%e_';
```

###### `LIKE` and `[range]`

- `[range]` denotes **any one character within this range**
- Range can be a **list** of characters
	- ie. A set
- A query using `WHERE` with `LIKE` and `[range]` to limit retrieved rows to employees who have a first name starting with a vowel

``` sql
SELECT first_name
FROM employee
WHERE first_name LIKE '[aeiou]%';
```

![like range 1](http://snag.gy/x0rJz.jpg)

- Range can also be a range of characters
	- ie. A range between a - m
- A query using `WHERE` with `LIKE` and `[range]` to limit retrieved rows to employees who have a first name starting from "d" to "g"

``` sql
SELECT first_name
FROM employee
WHERE first_name LIKE '[d-g]%';
```

![like range 2](http://snag.gy/Cg5ed.jpg)

###### `LIKE` and `[^range]`

- `[^range]` denotes **any one character not within this range**
	- The opposite of `[range]`
- A query using `WHERE` with `LIKE` and `[^range]` to limit retrieved rows to employees who have a first name **not** starting with a vowel

``` sql
SELECT first_name
FROM employee
WHERE first_name LIKE '[^aeiou]%';
```

![like ^range 1](http://snag.gy/e9PMF.jpg)

- A query using `WHERE` with `LIKE` and `[^range]` to limit retrieved rows to employees who have a first name **not** starting from "d" to "g"

``` sql
SELECT first_name
FROM employee
WHERE first_name LIKE '[^d-g]%';
```

###### `LIKE` summary

Limits query to jobs with job titles that have "Manager":

``` sql
SELECT *
FROM job
WHERE job_title LIKE '%Manager%';
```

Limits query to employees with first name that begins with "m" to "v" and is five characters long.

``` sql
SELECT first_name
FROM employee
WHERE first_name LIKE '[m-v]____';
```

Limits query to employees with phone numbers that begin with "5" and contains "23" at least two character from the start and end.

``` sql
SELECT last_name, phone_number
FROM employee
WHERE phone_number LIKE '5%23_%'
```

##### `IS NULL`

- `IS_NULL` tests for `NULL` values
	- Cannot do `= NULL`
- A query using `IS NULL` to limit retrieved rows to employees with no data about their gender

``` sql
SELECT first_name, gender
FROM employee
WHERE gender IS NULL;
```

![is null](http://snag.gy/wfOXq.jpg)

##### `IS NOT NULL`

- `IS NOT NULL` tests for anything **except** `NULL` values
	- Opposite of `IS NULL`
- A query using `IS NOT NULL` to limit retrieved rows to employees with data about their gender

``` sql
SELECT first_name, gender
FROM employee
WHERE gender IS NOT NULL;
```

![is not null](http://snag.gy/tgOtL.jpg)

### Logical operators

- Specifies more sophisticated conditions with logical operators

![logical operators](http://snag.gy/ssder.jpg)

- `AND`, `OR` allows multiple conditions to be specified in the `WHERE` clause
- As usual, numerous logical operators can be combined, along with numerous comparisons and arithmetic, etc.

#### `AND`

- Format:
	- `comparison_1 AND comparison_2`
- A query using `WHERE` and `AND` to limit retrieved rows to employees who are male AND have a salary of at least 15,000

``` sql
SELECT last_name, gender, salary
FROM employee
WHERE gender = 'M' AND salary >= 15000;
```

![and](http://snag.gy/4Bqv2.jpg)

#### `OR`

- Format:
	- `comparison_1 OR comparison_2`
- A query using `WHERE` and `OR` to limit retrieved rows to employees who are male OR have a salary of at least 15,000

``` sql
SELECT last_name, gender, salary
FROM employee
WHERE gender = 'M' OR salary >= 15000;
```

![or](http://snag.gy/uHr7z.jpg)

##### `OR` vs. `IN`

- Watch out for using `OR` when you can use `IN` instead

``` sql
SELECT last_name, job_id
FROM employee
WHERE job_id = 'AD_PRES'
	OR job_id = 'AD_VP'
	OR job_id = 'AD_ASST';
```

- Is the same as:

``` sql
SELECT last_name, job_id
FROM employee
WHERE job_id IN ('AD_PRES', 'AD_VP', 'AD_ASST');
```

- Using `IN` is quicker to type, and clearer to read

#### `NOT`

- `NOT` turns false into true
	- Use parenthesis `()` to specify what comparison (or group of comparisons/logic) is to be reversed

``` sql
SELECT last_name, gender
FROM employee
WHERE NOT (gender = 'M');
```

- Or:

``` sql
SELECT last_name, gender
FROM employee
WHERE gender != 'M';
```

- The effect of `NOT` can often be achieved via comparisons

![not](http://snag.gy/NY1ba.jpg)

##### `NOT` within other comparison operators

- `NOT` can be used within `BETWEEN`, `IN` and `LIKE`
	- `column NOT BETWEEN lower_limit AND upper_limit`
	- `column NOT IN (value1, value2, value3)`
	- `column NOT LIKE 'search_pattern'`
- Works the same every time, turning false into true
- This can be very useful, resulting in highly efficient and highly readable queries

#### Logical operator order of precedence

- `NOT` will be evaluated first
	- Then `AND`
	- Then `OR`

![logical operator order of precedence](http://snag.gy/7565L.jpg)

- Evaluated from left to right if the same level of precedence exists
	- `a AND b AND c`
- Parenthesis `()` can be used to force precedence

##### Order of precedence `AND` `OR`

- A query to limit retrieved rows to employees with a job id beginning with "SA", **OR** female employees who have a salary of at least 11,000

``` sql
SELECT last_name, job_id, salary
FROM employee
WHERE job_id LIKE 'SA%' OR gender = 'F' AND salary >= 11000;
```

- The `AND` is evaluated first, finding females with a salary of at least 11,000
- The true/false result of the `AND` is then used for the `OR`

![order of precedence and-or](http://snag.gy/3rjHY.jpg)

##### Order of precedence parenthesis `()`

- A query to limit retrieved rows to employees with a job id beginning with "SA" **OR** that are female, who have a salary of at least 11,000

``` sql
SELECT last_name, job_id, salary
FROM employee
WHERE (job_id LIKE 'SA%' OR gender = 'F') AND salary >= 11000;
```

- The `OR` is evaluated first, finding employees with a job id starting with "SA" or female employees
- The true/false result of the `OR` is then used for the `AND`

![order of precedence parenthesis](http://snag.gy/ZFXdC.jpg)

## Sort rows retrieved with `ORDER BY`

- The `ORDER BY` clause comes last in a `SELECT` statement, and is optional
	- Format:
		- `ORDER BY column`
			- The default direction to order by is `ASC`
				- Ascending, or smallest to largest
			- But you can specify descending order
		- `ORDER BY column ASC`
			- Ascending
		- `ORDER BY column DESC`
			- Descending
- The column you order by does **not need to be one of the columns** you are selecting
- You can also order by an **alias** used in the query
	- You cannot use aliases in `WHERE` clause though

### `ORDER BY` `ASC`

- Default order

``` sql
SELECT last_name, salary
FROM employee
WHERE job_id LIKE 'SA%'
ORDER BY salary;
```

![order by asc](http://snag.gy/Dfn0t.jpg)

### `ORDER BY` `DESC`

``` sql
SELECT last_name, salary
FROM employee
WHERE job_id LIKE 'SA%'
ORDER BY salary DESC;
```

![order by desc](http://snag.gy/lWx5y.jpg)

### `ORDER BY` multiple columns

- `ORDER BY` can order by multiple columns or **aliases**
	- `ASC` or `DESC` can be included for each one
- A query which will order by salary in descending order, then by last name in ascending order

``` sql
SELECT last_name, salary
FROM employee
WHERE salary <= 10000
ORDER BY salary DESC, last_name;
```

![order by multi columns](http://snag.gy/hc1ZS.jpg)

## Using `TOP` to limit returned rows

- You can limit the number of rows returned to only the top (first) number or percent using `TOP` after `SELECT`
- Using `TOP` without `ORDER BY` is possible, but not meaningful or useful

### `SELECT TOP (number)`

``` sql
SELECT TOP(2) last_name, salary
FROM employee
WHERE salary <= 10000
ORDER BY salary DESC, last_name;
```

![top(number)](http://snag.gy/CYBsS.jpg)

### `SELECT TOP (number) PERCENT`

``` sql
SELECT TOP(20) PERCENT last_name
FROM employee
ORDER BY last_name;
```

![top(number) percent](http://snag.gy/pUDSw.jpg)

### `TOP` `WITH TIES`

- You can include `WITH TIES` to include any rows that are equal to the last row returned when using `TOP`
	- Includes **TIES**, rows that have the same value as the last result
- A `WITH TIES` query **must** include an `ORDER BY` clause, else would not make sense

``` sql
SELECT TOP (2) WITH TIES last_name, salary
FROM employee
WHERE salary <= 10000
ORDER BY salary DESC;
```

![top with ties](http://snag.gy/UsF6B.jpg)

## Data types in SQL Server 2008

- Each column in a table requires a data type to be specified
- It is important to select the data type that best suits the data
- SQL Server 2008 supports approx 30 different data types, although these can be grouped into four main groups
	- Characters/Strings
	- Numbers
	- Date/Time
	- Miscellaneous
- Each of these groups consists of a number of data types
	- Each have unique properties

### Character/String

- These data types are for any kind of textual content, including
	- Letters
	- Numbers
	- Punctuations
	- Symbols
	- etc.
- `CHAR` and `VARCHAR` most commonly used
- `TEXT` used to store **large** amounts of text, or text that includes multiple lines/line breaks
	- ie. Address, bio

![data type char/string](http://snag.gy/7JweC.jpg)

### Numbers

- The numeric data types can themselves be split into groups
	- **Integer**
		- `TINYINT`
		- `SMALLINT`
		- `INT`
		- `BIGINT`
	- **Decimal**
		- `FLOAT`
		- `REAL`
		- `DECIMAL` and `NUMERIC`
		- `MONEY` and `SMALLMONEY`

#### Integers

- Integers are whole numbers, with no decimal component
- `TINYINT` and `SMALLINT` are often used for columns where max/min amount is sure to be within their value ranges
- `INT` is usually sufficient for most whole number fields

![integers](http://snag.gy/qC1gt.jpg)

#### Decimals

- These data types store numbers with decimal components
- `DECIMAL` is easier to use/understand than `FLOAT` or `REAL`
	- Will often be suitable for most decimal needs

![decimals](http://snag.gy/3imk5.jpg)

##### `DECIMAL`/`NUMERIC` precision and scale

- `DECIMAL` and `NUMERIC` are exactly the same data type
- This type allows you to specify precision and scale
	- **Precision:**
		- Total number of digits in the number, both to the left and right of decimal point
		- Default precision = 18
		- Max = 38
	- **Scale:**
		- Total number of digits to the right of the decimal point
		- Default scale = 0
		- Max = precision
- Examples:

``` sql
DECIMAL(4,2) = -99.99 to 99.99
DECIMAL(3) = -999 to 999
DECIMAL(5,4) = -9.9999 to 9.9999
```

### Date/Time

- SQL Server 2008 has several date/time data types
- `DATE` is likely to be most commonly used
- `DATE` and `TIME` are not available in SQL Server 2005
	- Consider using `SMALLDATETIME` or `DATETIME` if compatibility with SQL Server 2005 is required

![date/time](http://snag.gy/782YO.jpg)

### Miscellaneous

- `BINARY`
	- Single-byte binary data type for up to 8000 bytes
- `BIT`
	- Can be 0, 1 or NULL
- `XML`, `TABLE`, `IMAGE` etc.
	- These data types are not as commonly used as the ones already covered

### Data type selection considerations

- Use the smallest possible data type and size
	- ie. Use `TINYINT` to store the age of a person rather than `INT`
- Use numeric data types for numbers, rather than `CHAR`
	- It typically takes less space, and allows for arithmetic
- Do not use `FLOAT` or `REAL` for primary keys
- Use `CHAR` when you know the data will have consistent / similar lengths
	- Use `VARCHAR` when length of data varies
- Always consider extreme cases and the long term
	- Ensure your database is reliable and scalable
	
