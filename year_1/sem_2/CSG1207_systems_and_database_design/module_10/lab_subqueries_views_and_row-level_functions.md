# Systems and database design lab 10

## Introduction

This lab allows you to practise the SQL covered in this week’s lecture. Do your best to answer the following questions and write the specified queries. You are encouraged to experiment with SQL – it is a very flexible language, so if you can think of something that would be useful to achieve in a query, it can probably be done. This lab uses the `company` database, which you can create by running the script file Module 5 of the unit materials. It is assumed that you are
working in SQL Server Management Studio, also covered in Module 5.

If you are having trouble writing an SQL query, read any error messages and try to fix the error. Search for examples in the unit materials, and ask your tutor for assistance if needed. Contact your tutor if you spot something which appears to be incorrect in any of the labs.

## Lab tasks

### 1

Write a query which uses a subquery to select the last name and hire date of any employees who were hired after the employee with an ID of 17. Order the results by
hire date, with the most recently hired employees at the top.

``` sql
SELECT last_name, hire_date
FROM employee
WHERE hire_date > (
	SELECT hire_date
	FROM employee
	WHERE employee_id = 17
)
ORDER BY hire_date DESC;
```

### 2

Write a query which uses subqueries to select the last name, salary and department name of any employees who earn less than the employee with an ID of 18 or are in the
same department as the employee with an ID of 5.

``` sql
SELECT last_name, salary, department_name
FROM employee AS e INNER JOIN department AS d
	ON e.department_id = d.department_id
WHERE salary < (
	SELECT salary
	FROM employee
	WHERE employee_id = 18
) OR e.department_id = (
	SELECT department_id
	FROM employee
	WHERE employee_id = 5
);
```

### 3

Write a query which uses a subquery to select the employee ID, last name and department ID of any employees who work in the same department as employee 19, employee 18 or employee 2.

``` sql
SELECT	employee_id,
		last_name,
		department_id
FROM employee
WHERE department_id IN (
	SELECT department_id
	FROM employee
	WHERE employee_id IN (19, 18, 2)
);
```

### 4

Write a query which uses a subquery to select the last name and salary of any employees who earn more than all of the employees in department 40.

``` sql
SELECT	last_name,
		salary
FROM employee
WHERE salary > ALL (
	SELECT salary
	FROM employee
	WHERE department_id = 40
);
```

### 5

Create the `emp_summary` table from the challenge task of Lab 8 as a view. The view should be named `emp_summary_view`, and it should contain the employee ID (named
as `emp_id`), full name, lower case email address with `@company.com` at the end and phone number of all employees.

``` sql
CREATE VIEW emp_summary_view
AS SELECT	employee_id AS 'employee_id',
			first_name + ' ' + last_name AS 'full_name',
			LOWER(email) + '@company.com' AS 'email',
			phone_number AS 'phone_number'
FROM employee;
```

### 6

Alter the view you created in the previous task so that it also includes the job title and department name of employees. Make sure the view includes employees who are not in a department.

``` sql
ALTER VIEW emp_summary_view
AS SELECT	employee_id AS 'employee_id',
			first_name + ' ' + last_name AS 'full_name',
			LOWER(email) + '@company.com' AS 'email',
			phone_number AS 'phone_number',
			job_title,
			department_name
FROM employee AS e INNER JOIN job AS j
	ON e.job_id = j.job_id
	LEFT OUTER JOIN department as d
	ON e.department_id = d.department_id;
```

### 7

Without running the following query, try to determine what it would output. Note that it does not interact with a database, it simply manipulates the string in the query.

``` sql
SELECT CHARINDEX('e', SUBSTRING(RIGHT(REVERSE('Hello World'), 5), 2, 3));
```

``` sql
REVERSE('Hello World');
-- 'dlroW olleH'

RIGHT('dlroW olleH', 5);
-- 'olleH'

SUBSTRING('olleH', 2, 3);
-- 'lle'

CHARINDEX('e', 'lle');
-- 3
```

### 8

- Write a query which displays the following employee details:
	- Their initials, e.g. `SK` for `Steven King`
	- The gender column, with NULLs replaced by a `?`
	- The email column, in lower case with `@company.com` appended to the end
	- The number of years since they were hired, using the `hire_date` column
	- The number of characters in their job ID, e.g. 5 for `AD_VP`
	- Their salary multiplied by the value of pi and rounded to two decimal places
- Give all columns appropriate aliases.

``` sql
SELECT	LEFT(first_name, 1) + LEFT(last_name, 1) AS 'initials',
		ISNULL(gender, '?') AS 'gender',
		LOWER(email) + '@company.com' AS 'email',
		LEN(job_id) as 'job_id_length',
		ROUND(salary * PI(), 2) AS 'salary*pi'
FROM employee;
```

### 9

Use row level functions to select the last name and commission value of employees. The commission should be multiplied by 100, have no decimal places, and should have a
`%` at the end, e.g. a value of `0.20` becomes `20%`. Limit your results to only show employees who have a commission.

``` sql
SELECT	last_name,
		LTRIM(STR(commission_pct * 100)) + '%' AS 'commission'
FROM employee
WHERE commission_pct IS NOT NULL;
```

- `STR()` allows the decimal places to be avoided easily
- `LTRIM()` allows the output of `STR()` to have no whitespaces without needing to specify length

### 10 Challenge query

The following query is more difficult than the previous queries, and may involve SQL syntax which has not yet been covered in the unit.

Write a query which uses the`job_history` table to produce the following results:

![job_history results](http://snag.gy/n6d01.jpg)

This will require joins with the employee and job tables for the names and job titles, a date-based row level function, converting data types, and quite a bit of concatenation.

For an extra challenge, make the query show "for less than a year" instead of "0 years" wherever appropriate. This involves using [`CASE`](http://msdn.microsoft.com/en-us/library/ms181765.aspx), which we don't cover in this unit.

#### 10.1

``` sql
SELECT	first_name + ' ' + last_name + ' was a ' + job_title + ' for '
		+ CAST(DATEDIFF(YEAR, start_date, end_date) AS VARCHAR)
		+ ' years' AS 'job_history'
FROM employee AS e INNER JOIN job_history AS jh
	ON e.employee_id = jh.employee_id
	INNER JOIN job AS j
	ON jh.job_id = j.job_id;
```

#### 10.2

``` sql
SELECT	first_name + ' ' + last_name + ' was a ' + job_title + ' for ' +
		CASE DATEDIFF(YEAR, start_date, end_date)
			WHEN 0 THEN 'less than a year'
			ELSE CAST(DATEDIFF(YEAR, start_date, end_date) AS VARCHAR) + ' years'
		END AS 'job_history'
FROM employee AS e INNER JOIN job_history AS jh
	ON e.employee_id = jh.employee_id
	INNER JOIN job AS j
	ON jh.job_id = j.job_id;
```
