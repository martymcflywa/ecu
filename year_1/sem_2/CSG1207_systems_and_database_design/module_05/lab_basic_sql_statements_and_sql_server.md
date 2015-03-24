# Systems and database design workshop 4

## Background

This lab allows you to practise the SQL covered in this week’s lecture. Do your best to answer the following questions and write the specified queries. You are encouraged to experiment with SQL – it is a very flexible language, so if you can think of something that would be useful to achieve in a query, it can probably be done. This lab uses the “company” database, which you can create by running the script file Module 5 of the unit materials. It is assumed that you are working in SQL Server Management Studio, also covered in Module 5.

If you are having trouble writing an SQL query, read any error messages and try to fix the error. Search for examples in the unit materials, and ask your tutor for assistance if needed. Contact your tutor if you spot something which appears to be incorrect in any of the labs.

## Lab tasks

### 1:

There are two errors in the following query. Identify the errors and fix the query so that it retrieves the `first_name`, `last_name` and `gender` of all employees.

``` sql
SELECT first_name, lastname gender
FROM employee
```

#### Errors:

1. `lastname` should be `last_name`
2. No comma `,` between `lastname` and `gender`

#### Rewrite:

``` sql
SELECT first_name,
	last_name,
	gender
FROM employee;
```

### 2:

Write a query which selects all columns from the `department` table.

``` sql
SELECT *
FROM department;
```

### 3:

- Write a query which selects the following from the `employee` table:
	- Employee ID numbers
	- Last names of employees
	- Employee salaries
	- Employee salaries multiplied by 12
	- 75% of employee salaries
		- Calculate by multiplying by 0.75

``` sql
SELECT employee_id,
	last_name,
	salary,
	salary * 12,
	salary * 0.75
FROM employee;
```

### 4:

Modify the query you wrote in question 3 to give the last two columns appropriate aliases. Name the salary multiplied by 12 "annual_salary" and 75% of the salary "penalty_salary".

``` sql
SELECT employee_id,
	last_name,
	salary,
	salary * 12 AS 'annual_salary',
	salary * 0.75 AS 'penalty_salary'
FROM employee;
```

### 5:

- Write a query which uses the concatenation operator `+` to select the following:
	- Full names of all employees
		- ie. "Steven King"
	- Full names of all employees with last name first
		- ie. "King, Steven"

``` sql
SELECT first_name + ' ' + last_name AS 'full_name',
	last_name + ', ' + first_name AS 'last_name_first'
FROM employee;
```

### 6:

Write a query which selects **unique** job IDs from the `employee` table. Even though there are multiple employees who have a job ID of `IT_PROG`, it should only appear once in the results of the query.

``` sql
SELECT DISTINCT job_id
FROM employee;
```

### 7:

The following query is meant to retrieve the full names of employees and their emails, ie. "Steven King - SKING", in a column named `name_and_email` but contains some errors. Identify the errors and fix the query so that it works as intended.

``` sql
SELECT first_name + " " + last_name + " - " + email AS "name_and_email'
FROM employee;
```

#### Errors:

- Uses `"` instead of `'` for strings

#### Rewrite:

``` sql
SELECT first_name + ' ' + last_name + ' - ' + email AS 'name_and_email'
FROM employee;
```

### 8:

- Write a query which selects the following from the `employee` table:
	- Full name of employees, with Job IDs in parenthesis at the end of the name
		- ie. "Steven King (AD_PRES)"
	- Emails of employees, with "@COMPANY.COM" concatenated to the end
		- ie. "SKING@COMPANY.COM"
	- Give both columns appropriate aliases
		- Such as `name_and_job` for the first column

``` sql
SELECT first_name + ' ' + last_name + ' (' + job_id + ')' AS 'name_and_job',
	email + '@COMPANY.COM' AS 'full_email'
FROM employee;
```

### 9:

- Write a query which selects the following from the `job` table:
	- Job ID followed by a hyphen and then job title
		- ie. "IT_PROG - Programmer"
	- Maximum salary minus minimum salary, resulting in the difference between the two
		- ie. The `IT_PROG` job has a difference of 6000 between the min and max
	- Give both columns appropriate aliases

``` sql
SELECT job_id + ' - ' + job_title AS 'job_id_and_title',
	max_salary - min_salary AS 'salary_difference'
FROM job;
```

### 10:

Write a query which uses concatenation to return employee names and email addresses in the form of a HTML email hyperlink. For example:

``` html
<a href="mailto:sking@company.com">Steven KING</a>
```

``` sql
SELECT '<a href="mailto:' + LOWER(email) + '@company.com">'
	+ first_name + ' ' + UPPER(last_name) + '</a>'
	AS 'email_hyperlink'
FROM employee;
```
