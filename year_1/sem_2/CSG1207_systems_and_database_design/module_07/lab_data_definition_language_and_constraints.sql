-- 3:
-- If you have noticed anything missing or incorrect in the `company` database, write an ALTER TABLE statement to correct the problem. Use the steps in the first two tasks of this lab to check that the database now matches the ERD in the lecture of Module 5.
ALTER TABLE job_history
	ADD CONSTRAINT jhist_dept_fk FOREIGN KEY (department_id)
		REFERENCES department(department_id);
		
-- 5:
-- Write a `CREATE TABLE` statement to create the table specified in below:
CREATE TABLE project (
	project_id INT NOT NULL CONSTRAINT project_pk PRIMARY KEY IDENTITY,
	project_name VARCHAR(50) NOT NULL UNIQUE,
	project_desc TEXT NULL,
	creation_date SMALLDATETIME NOT NULL DEFAULT GETDATE()
);

-- 6:
-- Alter the `project` table to add a `project_leader` column – `INT`, `NOT NULL`. Give it a foreign key constraint, referencing the `employee_id` column of the `employee` table.
ALTER TABLE project
	ADD project_leader INT NOT NULL
		CONSTRAINT proj_leader_fk FOREIGN KEY
		REFERENCES employee(employee_id);