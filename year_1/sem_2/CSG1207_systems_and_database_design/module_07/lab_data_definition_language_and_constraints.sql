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
		
-- 7:
-- An `ALTER TABLE` statement to drop the primary key constraint
-- An `ALTER TABLE` statement to drop the `project_id` column
-- An `ALTER TABLE` statement to add the `project_code` column, `CHAR(5)`, and give it a primary key constraint
ALTER TABLE project
	DROP CONSTRAINT project_pk;

ALTER TABLE project
	DROP COLUMN project_id;

ALTER TABLE project
	ADD project_code CHAR(5) CONSTRAINT project_pk PRIMARY KEY;
	
-- 8:
-- Rewrite the `CREATE TABLE` statement from task 5 of this lab so that it incorporates the changes made in tasks 6 and 7. You will need to drop the `project` table before you can create it again.
DROP TABLE project;

CREATE TABLE project (
	project_code CHAR(5) NOT NULL CONSTRAINT project_pk PRIMARY KEY,
	project_name VARCHAR(50) NOT NULL CONSTRAINT project_uk UNIQUE,
	project_desc TEXT NULL,
	creation_date SMALLDATETIME NOT NULL DEFAULT GETDATE(),
	project_leader INT NOT NULL
		CONSTRAINT project_leader_fk FOREIGN KEY
		REFERENCES employee(employee_id)
);

-- 9:
-- To record which employees are working in which project, create a `project_work` table with an `employee_id` column and a `project_code` column. Make sure the data types of the columns match the columns that they are referencing, and give them appropriate foreign key constraints. The primary key of the table should be a compound key using both of the columns. (This table is essentially an intermediary table resolving a M:M)
CREATE TABLE project_work (
	employee_id INT NOT NULL
		CONSTRAINT employee_id_fk FOREIGN KEY
		REFERENCES employee(employee_id),
	project_code CHAR(5) NOT NULL 
		CONSTRAINT project_code_fk FOREIGN KEY
		REFERENCES project(project_code),
		
	CONSTRAINT project_work_pk PRIMARY KEY (employee_id, project_code)
);

-- 10:

CREATE TABLE item (
	item_id INT NOT NULL IDENTITY(100, 20),
	item_name VARCHAR(50) NOT NULL DEFAULT 'No name',
	item_desc VARCHAR(250) NOT NULL,
	initial_stock SMALLINT NOT NULL DEFAULT 100,
	reorder_level SMALLINT NOT NULL DEFAULT 25,
	created_by INT NULL CONSTRAINT created_by_fk FOREIGN KEY
		REFERENCES item(item_id),
	
	CONSTRAINT item_pk PRIMARY KEY (item_id),
	CONSTRAINT item_name_uk UNIQUE (item_name),
	CONSTRAINT item_desc_char_min CHECK (LEN(item_desc) >= 40),
	CONSTRAINT reorder_level_max CHECK (reorder_level < initial_stock)
);