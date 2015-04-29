-- 1:
INSERT INTO job
VALUES ('GN_SEC', 'Secretary', 3500, 10000);

-- 2:
INSERT INTO job (job_id, job_title, min_salary, max_salary)
VALUES ('GN_JAN', 'Janitor', 1500, NULL);

-- 3:
INSERT INTO job (job_id, job_title, min_salary, max_salary)
VALUES ('GN_CAF', 'Cafeteria Worker', DEFAULT, 4500);

-- 4:
UPDATE job
SET max_salary = 5000
WHERE job_id IN ('GN_SEC', 'GN_JAN');

-- 5.1:
INSERT INTO country
VALUES	('CH', 'China', 3),
		('JP', 'Japan', 33),
		('EG', 'Egypt', 4);

-- 5.2:
INSERT INTO country
VALUES	('CH', 'China', 3),
		('JP', 'Japan', 3),
		('EG', 'Egypt', 4);
		
-- 6:
DELETE FROM country
WHERE region_id > 2;

-- 7:
UPDATE job
SET max_salary = (SELECT max_salary
				  FROM job
				  WHERE job_id = 'GN_SEC')
WHERE job_id = 'GN_CAF';

-- 8:
BEGIN TRANSACTION q8;
INSERT INTO job (job_id, job_title, min_salary, max_salary)
VALUES ('GN_SPY', 'Corporate Spy', 50000, 75000);
SAVE TRANSACTION after_spy;
UPDATE job
SET min_salary = 50000,
	max_salary = 75000;
SELECT * FROM job;
ROLLBACK TRANSACTION after_spy;
COMMIT TRANSACTION q8;

-- Checking to see committed changed after transaction q8
SELECT * FROM job;

-- 9:
DELETE FROM job
WHERE job_id LIKE 'GN%';

-- 10.1 Create table
CREATE TABLE emp_summary (
	emp_id INT NOT NULL CONSTRAINT emp_summary_pk PRIMARY KEY,
	full_name VARCHAR(50) NOT NULL,
	email VARCHAR(75) NULL,
	phone VARCHAR(20) NULL
);

-- 10.2 Copy data from employee to emp_summary
INSERT INTO emp_summary (emp_id, full_name, email, phone)
SELECT	employee_id,
		first_name + ' ' + last_name,
		LOWER(email) + '@company.com',
		phone_number
FROM employee;

-- Checking to see if emp_summary populated correctly
SELECT  * FROM emp_summary;