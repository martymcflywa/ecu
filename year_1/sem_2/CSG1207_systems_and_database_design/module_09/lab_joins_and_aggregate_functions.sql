-- 1:
SELECT first_name + ' ' + last_name AS 'full_name',
	salary, department_name
FROM employee AS e INNER JOIN department AS d
	ON e.department_id = d.department_id
WHERE salary > 10000;

-- 2:
SELECT DISTINCT job_title
FROM employee AS e INNER JOIN job AS j
	ON e.job_id = j.job_id
WHERE e.department_id = 50;

-- 3:
SELECT last_name,
	commission_pct,
	department_name,
	city
FROM employee as e LEFT OUTER JOIN department AS d
	ON e.department_id = d.department_id
	LEFT OUTER JOIN location AS l
	ON d.location_id = l.location_id
WHERE commission_pct IS NOT NULL
ORDER BY commission_pct DESC;

-- 4: See .md

-- 5:
SELECT country_name,
	region_name
FROM country AS c RIGHT OUTER JOIN region AS r
	ON r.region_id = c.region_id;
	
-- 6.1:
SELECT last_name,
	job_title,
	department_name
FROM employee AS e INNER JOIN job AS j
	ON e.employee_id = j.job_id
FROM employee AS e RIGHT OUTER JOIN department AS d
	ON e.department_id = d.department_id;
	
-- 6.2:
SELECT last_name,
	job_title,
	department_name
FROM employee AS e INNER JOIN job AS j
	ON e.job_id = j.job_id
	LEFT OUTER JOIN department as d
	ON e.department_id = d.department_id;
	
-- 7:
SELECT last_name,
	salary,
	job_title,
	min_salary
FROM employee AS e INNER JOIN job AS j
	ON e.job_id = j.job_id
WHERE e.salary < j.min_salary;

-- 8:
SELECT e.first_name + ' ' + e.last_name AS 'employee_full_name',
	m.first_name + ' ' + m.last_name as 'manager_full_name'
FROM employee AS e LEFT OUTER JOIN employee AS m
	ON e.manager_id = m.employee_id
ORDER BY employee_full_name;

-- 9:
SELECT AVG(min_salary) AS 'avg_min_salary', 
	AVG(max_salary) AS 'avg_max_salary'
FROM job;

-- 10:
SELECT job_id,
	MIN(salary) AS 'lowest_salary',
	COUNT(*) AS 'employees'
FROM employee
GROUP BY job_id;

-- 11:
SELECT department_name,
	COUNT(*) AS 'employees',
	AVG(salary) AS 'avg_salary',
	MIN(salary) AS 'lowest_salary',
	MAX(salary) AS 'highest_salary'
FROM employee AS e INNER JOIN department AS d
	ON e.department_id = d.department_id
GROUP BY department_name
ORDER BY department_name;

-- 12:
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

-- 13:
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
	
-- 14:
SELECT department_name
FROM employee AS e INNER JOIN department AS d
	ON e.department_id = d.department_id
GROUP BY department_name
HAVING AVG(salary) < 7500;

-- 15:
SELECT e.last_name AS 'employee_last_name',
	m.last_name AS 'manager_last_name',
	e.salary - m.salary AS 'difference'
FROM employee AS e INNER JOIN employee AS m
	ON e.manager_id = m.employee_id
WHERE e.salary > m.salary;