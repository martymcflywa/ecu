# Systems and database design lab 09

## Introduction

This lab allows you to practise the SQL covered in this week’s lecture. Do your best to answer the following questions and write the specified queries. You are encouraged to experiment with SQL – it is a very flexible language, so if you can think of something that would be useful to achieve in a query, it can probably be done. This lab uses the `company` database, which you can create by running the script file Module 5 of the unit materials. It is assumed that you are
working in SQL Server Management Studio, also covered in Module 5.

If you are having trouble writing an SQL query, read any error messages and try to fix the error. Search for examples in the unit materials, and ask your tutor for assistance if needed. Contact your tutor if you spot something which appears to be incorrect in any of the labs.

## Note

Rather than a challenge query, this lab contains 15 tasks instead of 10. Since this module's lecture covers a few very important concepts, the extra tasks allow us to practise them all.

## Lab tasks

### 1

Write a query which selects the full name (e.g. "Steven King"), salary and department name of all employees who earn over $10,000.

``` sql
SELECT first_name + ' ' + last_name AS 'full_name', salary, department_name
FROM employee AS e INNER JOIN department AS d
	ON e.department_id = d.department_id
WHERE salary > 10000;
```

### 2

Write a query which shows a unique list of the job titles of employees in department 50.

``` sql
SELECT DISTINCT job_title
FROM employee AS e INNER JOIN job AS j
	ON e.job_id = j.job_id
WHERE e.department_id = 50;
```

### 3

Write a query which selects the last name, commission, department name, and city name of all employees who earn a commission (i.e. have a non `NULL` commission). Order the results by commission, in descending order.

``` sql
SELECT last_name, commission_pct, department_name, city
FROM employee as e LEFT OUTER JOIN department AS d
	ON e.department_id = d.department_id
	LEFT OUTER JOIN location AS l
	ON d.location_id = l.location_id
WHERE commission_pct IS NOT NULL
ORDER BY commission_pct DESC;
```

### 4

Describe the difference between a `LEFT OUTER JOIN`, a `RIGHT OUTER JOIN` and a `FULL OUTER JOIN`, and explain why the word `OUTER` is optional in the syntax for outer joins.

- `LEFT OUTER JOIN`
	- Returns matched rows and `NULL` unmatched rows in left table
- `RIGHT OUTER JOIN`
	- Returns unmatched rows and `NULL` unmatched rows in right table
- `FULL OUTER JOIN`
	- Returns matched row, `NULL` unmatched rows in left table and no matches in right table
- `OUTER` is optionaly since it only makes sense to speficy `LEFT`, `RIGHT` or `FULL` for an outer join

### 5

Write a query which selects all countries in the country table and the name of the region they are in. Make sure your query includes all regions, even those that do not match any of the countries.

``` sql
SELECT country_name, region_name
FROM country AS c RIGHT OUTER JOIN region AS r
	ON r.region_id = c.region_id;
```

### 6

The following query is trying to show the last name, job title and department name of all employees (including those who are not in a department), but it contains errors. Identify the errors and fix the query so that it works as intended.

``` sql
SELECT last_name, job_title, department_name
FROM employee AS e INNER JOIN job AS j
	ON e.employee_id = j.job_id
FROM employee AS e RIGHT OUTER JOIN department AS d
	ON e.department_id = d.department_id;
```

- Errors:
	- First join condition should have `e.job_id` instead of `e.employee_id`
	- `FROM employee AS e` should not be repeated
	- Should be using `LEFT OUTER JOIN` instead of `RIGHT OUTER JOIN`

``` sql
SELECT last_name, job_title, department_name
FROM employee AS e INNER JOIN job AS j
	ON e.job_id = j.job_id
	LEFT OUTER JOIN department as d
	ON e.department_id = d.department_id;
```

### 7

Write query which selects the last name, salary, job title and job’s minimum salary for all employees who are earning less than the minimum salary for their job.

``` sql
SELECT last_name, salary, job_title, min_salary
FROM employee AS e INNER JOIN job AS j
	ON e.job_id = j.job_id
WHERE e.salary < j.min_salary;
```

### 8

Write a query which selects the full name of employees and the full name of their manager. Order the results by the full name of the employee, and be sure to include all employees – even those who have no manager.

``` sql
SELECT e.first_name + ' ' + e.last_name AS 'employee_full_name',
	m.first_name + ' ' + m.last_name as 'manager_full_name'
FROM employee AS e LEFT OUTER JOIN employee AS m
	ON e.manager_id = m.employee_id
ORDER BY employee_full_name;
```

### 9

Write a query which displays the average minimum salary and average maximum salary of all jobs. Be sure to give the columns appropriate aliases.

``` sql
SELECT AVG(min_salary) AS 'avg_min_salary',
	AVG(max_salary) AS 'avg_max_salary'
FROM job;
```

### 10

Write a query which displays the job ID and salary of the lowest paid employee in each job, and the number of employees in each job. Give all columns appropriate aliases.

``` sql
SELECT job_id,
	MIN(salary) AS 'lowest_salary',
	COUNT(*) AS 'employees'
FROM employee
GROUP BY job_id;
```

### 11

Write a query which displays the department name, number of employees, average salary, minimum salary and maximum salary of employees, grouped by department
name. Order the results by department name.

``` sql
SELECT department_name,
	COUNT(*) AS 'employees',
	AVG(salary) AS 'avg_salary',
	MIN(salary) AS 'lowest_salary',
	MAX(salary) AS 'highest_salary'
FROM employee AS e INNER JOIN department AS d
	ON e.department_id = d.department_id
GROUP BY department_name
ORDER BY department_name;
```

### 12

Modify your query from the previous task so that it groups by department name then gender, and includes employee gender in the results. Order the results by department name then gender.

``` sql
SELECT department_name,
	gender,
	COUNT(*) AS 'employees',
	AVG(salary) AS 'avg_salary',
	MIN(salary) AS 'lowest_salary',
	MAX(salary) AS 'highest_salary'
FROM employee AS e INNER JOIN department AS d
	ON e.department_id = d.department_id
GROUP BY department_name, gender
ORDER BY department_name, gender;
```

### 13

Write a query which selects all the last name of employees, their department’s name, the name of the city their department is in, the name of the country the city is in and the name of the region the country is in. Use full outer joins to ensure that all employees, departments, locations, cities, countries and regions are returned.

``` sql
SELECT last_name,
	department_name,
	city,
	country_name,
	region_name
FROM employee AS e FULL OUTER JOIN department AS d
	ON e.department_id = d.department_id
	FULL OUTER JOIN location as l
	ON d.location_id = l.location_id
	FULL OUTER JOIN country AS c
	ON l.country_id = c.country_id
	FULL OUTER JOIN region AS r
	ON c.region_id = r.region_id;
```

### 14

Write a query which selects the department name of all departments where the average salary of employees working in the department is less than $7,500.

``` sql
SELECT department_name
FROM employee AS e INNER JOIN department AS d
	ON e.department_id = d.department_id
GROUP BY department_name
HAVING AVG(salary) < 7500;
```

### 15

Write a query which selects the employee last name and their manager's last name for all employees who have a higher salary than their manager. Also include the
difference between the two salaries in the results.

``` sql
SELECT e.last_name AS 'employee_last_name',
	m.last_name AS 'manager_last_name',
	e.salary - m.salary AS 'difference'
FROM employee AS e INNER JOIN employee AS m
	ON e.manager_id = m.employee_id
WHERE e.salary > m.salary;
```
