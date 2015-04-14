# Systems and database design workshop 6

## Introduction

This lab allows you to practise the SQL covered in this week’s lecture. Do your best to answer the following questions and write the specified queries. You are encouraged to experiment with SQL – it is a very flexible language, so if you can think of something that would be useful to achieve in a query, it can probably be done. This lab uses the “company” database, which you can create by running the script file Module 5 of the unit materials. It is assumed that you are working in SQL Server Management Studio, also covered in Module 5.

If you are having trouble writing an SQL query, read any error messages and try to fix the error. Search for examples in the unit materials, and ask your tutor for assistance if needed. Contact your tutor if you spot something which appears to be incorrect in any of the labs.

## Lab tasks

### 1:

Write a query which selects the last name, job ID and salary of all employees who earn a salary of at least $12,000.

``` sql
SELECT		last_name,
			job_id,
			salary
FROM		employee
WHERE		salary >= 12000;
```

### 2:

Which of the following queries would retrieve all details of employees who have a job ID of `IT_PROG`?

``` sql
SELECT * FROM employee WHERE job_id == 'IT_PROG'
SELECT * FROM employee WHERE job_id = "IT_PROG"
SELECT * FROM employee WHERE job_id = 'IT_PROG'
SELECT * FROM employee WHERE job_id = IT_PROG
```

``` sql
SELECT		*
FROM		employee
WHERE		job_id = 'IT_PROG';
```

### 3:

Write a query which selects the full name (e.g. “Steven King”) of any employees who do not have their gender recorded in the database. Order the results by first name.

``` sql
SELECT		first_name + ' ' + last_name AS full_name
FROM		employee
WHERE		gender IS NULL
ORDER BY	first_name;
```

### 4:

Write a query which selects the employee ID, last name and salary of all employees who have a salary which is either less than $5,000 or more than $15,000. Order the results by the salary, with the highest salaries at the top.

### 5:

Write a query which selects the last name, hire date and salary of all employees hired between June 1st 1997 and September 20th 1999 who have a salary of over $5,000.

``` sql
SELECT		last_name,
			hire_date,
			salary
FROM		employee
WHERE		hire_date BETWEEN '1997-06-01' AND '1999-09-20'
			AND salary > 5000;
```

### 6:

Write a query which selects the last name of all employees who have both an "a" and an "e" in their last name. Order the results by last name, in descending order.

``` sql
SELECT		last_name
FROM		employee
WHERE		last_name LIKE '%a%' AND last_name LIKE '%e%'
ORDER BY	last_name DESC;
```

### 7:

The following query is meant to retrieve details of all employees who were either hired before January 1st 1988 or are female, and who also earn a salary of at least $15,000. Identify the errors in the query, and fix it so that it works as intended.

``` sql
SELECT *
FROM employee
WHERE hire_date< 01-JAN-1988OR gender = 'F'
AND salary <= 15000;
```

``` sql
SELECT		*
FROM		employee
WHERE		(hire_date < '1988-01-01' OR gender = 'F')
			AND salary >= 15000;
```

**Note:** When working as intended, Steven King and Neena Kochhar are the only employees the query should return.

### 8:

Write a query which selects the first name, and job ID of all employees who have a job ID of either `IT_PROG`, `ST_CLERK`, or `SA_REP` and have a first name starting either A, B, C or D. Order the results by first name.

``` sql
SELECT		first_name,
			job_id
FROM		employee
WHERE		job_id IN ('IT_PROG', 'ST_CLERK', 'SA_REP')
			AND first_name LIKE '[abcd]%'
ORDER BY	first_name;
```

### 9:

Write a query which selects the last name, salary and job ID of the three highest paid employees who have a job ID which does not start with "AD".

``` sql
SELECT TOP(3)	last_name,
				salary,
				job_id
FROM			employee
WHERE			job_id NOT LIKE 'AD%'
ORDER BY		salary DESC;
```

### 10: Challenge query

The following query is more difficult than the previous queries, and may involve SQL syntax which has not yet been covered in the unit.

Over a decade ago, a theft occurred in the company that was never solved. Some pieces of evidence were found which can be used to determine the identity of the thief. The evidence available is:

- The theft occurred in a room that only certain employees had access to employees with job IDs of either `ST_MAN`, `ST_CLERK`, `SA_MAN` or `SA_REP`
- A dark and blurry security camera photo shows part of the thief's name tag, but only "el" can be made out
	- It may be part of a first name or last name
- Scent of lady's perfume was noticed at the scene of the theft after it occurred
	- You may assume that no perfume-wearing men were employed at the time
- The theft occurred on June 15th 1997, so anyone hired after then is not a suspect

Write a query which identifies the thief, using the available evidence. The query should return the thief's full name, with the column being given an alias of `the_thief`.

For an added challenge, identify which piece of evidence is not actually needed to determine the identity of the thief.

``` sql
SELECT		first_name + ' ' + last_name AS the_thief
FROM		employee
WHERE		job_id IN ('ST_MAN', 'ST_CLERK', 'SA_MAN', 'SA_REP')
			AND (first_name LIKE '%el%' OR last_name LIKE '%el%')
			AND (gender = 'F' OR gender IS NULL)
			AND hire_date <= '1997-06-15';
```

`AND (gender = 'F' OR gender IS NULL)`:  
`IS NULL` is required to ensure that employees without gender data is also included in the query.

The perfume evidence is not required, all other evidence is enough to determine who is thief and gender could be omitted from query.
