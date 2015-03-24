/***********
* TUTORIAL *
***********/

SELECT last_name, 
	salary,
	hire_date
FROM employee;

/******
* LAB *
******/

-- 1:
SELECT first_name,
	last_name,
	gender
FROM employee;

-- 2:
SELECT *
FROM department;

-- 3:
SELECT employee_id, 
	last_name, 
	salary, 
	salary * 12, 
	salary * 0.75
FROM employee;

-- 4:
SELECT employee_id, 
	last_name,
	salary,
	salary * 12 AS 'annual_salary',
	salary * 0.75 AS 'penalty_salary'
FROM employee;

-- 5:
SELECT first_name + ' ' + last_name AS 'full_name', 
	last_name + ', ' + first_name AS 'last_name_first'
FROM employee;

-- 6:
SELECT DISTINCT job_id
FROM employee;

-- 7:
SELECT first_name + ' ' + last_name + ' - ' + email AS 'name_and_email'
FROM employee;

-- 8:
SELECT first_name + ' ' + last_name + ' (' + job_id + ')' AS 'name_and_job',
	email + '@COMPANY.COM' AS 'full_email'
FROM employee;

-- 9:
SELECT job_id + ' - ' + job_title AS 'job_id_and_title',
	max_salary - min_salary AS 'salary_difference'
FROM job;

-- 10:
SELECT '<a href="mailto:' + LOWER(email) + '@company.com">' 
	+ first_name + ' ' + UPPER(last_name) + '</a>' 
	AS 'email_hyperlink'
FROM employee;