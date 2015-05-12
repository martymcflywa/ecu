-- 1:
SELECT	last_name,
		hire_date
FROM employee
WHERE hire_date > (
	SELECT hire_date
	FROM employee
	WHERE employee_id = 17
)
ORDER BY hire_date DESC;

-- 2:
SELECT	last_name,
		salary,
		department_name
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

-- 3:
SELECT	employee_id,
		last_name,
		department_id
FROM employee
WHERE department_id IN (
	SELECT department_id
	FROM employee
	WHERE employee_id IN (19, 18, 2)
);

-- 4:
SELECT	last_name,
		salary
FROM employee
WHERE salary > ALL (
	SELECT salary
	FROM employee
	WHERE department_id = 40
);

-- 5:
CREATE VIEW emp_summary_view
AS SELECT	employee_id AS 'employee_id',
			first_name + ' ' + last_name AS 'full_name',
			LOWER(email) + '@company.com' AS 'email',
			phone_number AS 'phone_number'
FROM employee;

-- 6:
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

-- 7:
SELECT CHARINDEX('e', SUBSTRING(RIGHT(REVERSE('Hello World'), 5), 2, 3));

-- 8:
SELECT	LEFT(first_name, 1) + LEFT(last_name, 1) AS 'initials',
		ISNULL(gender, '?') AS 'gender',
		LOWER(email) + '@company.com' AS 'email',
		LEN(job_id) as 'job_id_length',
		ROUND(salary * PI(), 2) AS 'salary*pi'
FROM employee;

--9:
SELECT	last_name,
		LTRIM(STR(commission_pct * 100)) + '%' AS 'commission'
FROM employee
WHERE commission_pct IS NOT NULL;

-- 10.1:
SELECT	first_name + ' ' + last_name + ' was a ' + job_title + ' for '
		+ CAST(DATEDIFF(YEAR, start_date, end_date) AS VARCHAR)
		+ ' years' AS 'job_history'
FROM employee AS e INNER JOIN job_history AS jh
	ON e.employee_id = jh.employee_id
	INNER JOIN job AS j
	ON jh.job_id = j.job_id;

-- 10.2
SELECT	first_name + ' ' + last_name + ' was a ' + job_title + ' for ' +
		CASE DATEDIFF(YEAR, start_date, end_date)
			WHEN 0 THEN 'less than a year'
			ELSE CAST(DATEDIFF(YEAR, start_date, end_date) AS VARCHAR) + ' years'
		END AS 'job_history'
FROM employee AS e INNER JOIN job_history AS jh
	ON e.employee_id = jh.employee_id
	INNER JOIN job AS j
	ON jh.job_id = j.job_id;