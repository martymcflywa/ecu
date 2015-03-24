--  **************************************************************************************
--  Creation and Population Script for the 'company' database.
--  This database is used for lecture examples and workshop questions in CSG1207/CSI5135.
--  **************************************************************************************



--  **************************************************************************************
--  We first check if the database exists, and drop it if it does.

--  Setting the active database to the built in 'master' database ensures that we are not trying to drop the currently active database.
--  Setting the database to 'single user' mode ensures that any other scripts currently using the database will be disconnectetd.
--  This allows the database to be deleted, instead of giving a 'database in use' error when trying to delete it.

IF DB_ID('company') IS NOT NULL             
	BEGIN
		PRINT 'Database exists - dropping.';
		
		USE master;		
		ALTER DATABASE company SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
		
		DROP DATABASE company;
	END

GO

--  Now that we are sure the database does not exist, we create it.

PRINT 'Creating database.';

CREATE DATABASE company;

GO

--  Now that an empty database has been created, we will make it the active one.
--  The table creation statements that follow will therefore be executed on the newly created database.

USE company;

GO



--  **************************************************************************************
--  We now create the tables in the database.
--  **************************************************************************************



--  **************************************************************************************
--  Create the region table to hold region information for location.
--  The country table has a foreign key referencing this table.

PRINT 'Creating region table...';

CREATE TABLE region
( region_id		TINYINT NOT NULL IDENTITY, 
  region_name	VARCHAR(25) NOT NULL,
  
  CONSTRAINT reg_pk PRIMARY KEY (region_id),
  CONSTRAINT reg_name_uk UNIQUE (region_name)
);


--  **************************************************************************************
--  Create the country table to hold country information for customers and company location. 
--  The location table has a foreign key referencing this table.

PRINT 'Creating country table...';

CREATE TABLE country 
( country_id	CHAR(2) NOT NULL, 
  country_name	VARCHAR(50) NOT NULL, 
  region_id		TINYINT NOT NULL, 
  
  CONSTRAINT cntry_pk PRIMARY KEY (country_id),
  CONSTRAINT cntry_reg_fk FOREIGN KEY (region_id) REFERENCES region(region_id),
  CONSTRAINT country_name_uk UNIQUE (country_name)
);


--  **************************************************************************************
--  Create the location table to hold address information for company department.
--  The department table has a foreign key referencing this table.

--  Note that I've created the constraints at the column level for this table, for comparison.

PRINT 'Creating location table...';

CREATE TABLE location
( location_id    SMALLINT NOT NULL IDENTITY PRIMARY KEY,
  street_address VARCHAR(50) NOT NULL,
  postal_code    VARCHAR(15) NOT NULL,
  city			 VARCHAR(30) NOT NULL,
  state_province VARCHAR(25) NOT NULL,
  country_id     CHAR(2) NOT NULL FOREIGN KEY REFERENCES country(country_id)
);
 
 
--  **************************************************************************************
--  Create the job table to hold the different names of job roles within the company.
--  The employee and job_history tables have foreign keys referencing this table.

PRINT 'Creating job table...';

CREATE TABLE job
( job_id		VARCHAR(10) NOT NULL,
  job_title		VARCHAR(50) NOT NULL,
  min_salary	MONEY NOT NULL DEFAULT 1000,
  max_salary	MONEY NULL,
  
  CONSTRAINT job_pk PRIMARY KEY (job_id),
  CONSTRAINT job_title_uk UNIQUE (job_title),
  CONSTRAINT sal_check CHECK (max_salary > min_salary)
);


--  **************************************************************************************
--  Create the department table to hold company department information.
--  The employee and job_history tables have foreign keys referencing this table.
--  
--  Note that the foreign key referencing the employee table cannot be applied to the manager_id column at this stage.
--  This is due to the presence of both a 1:M and a M:1 relationship between employee and department.
--  We will alter the table to add the foreign key constraint once the data has been inserted.

--  Also note that the manager_id column allows NULLs - a department can exist with no manager.

PRINT 'Creating department table...';

CREATE TABLE department
( department_id    SMALLINT NOT NULL IDENTITY(10, 10),
  department_name  VARCHAR(25) NOT NULL,
  manager_id       INT NULL,
  location_id      SMALLINT NOT NULL,
  
  CONSTRAINT dept_pk PRIMARY KEY (department_id),
  CONSTRAINT dept_loc_fk FOREIGN KEY (location_id) REFERENCES location(location_id),
  CONSTRAINT dept_name_uk UNIQUE (department_name)  
);


 
--  **************************************************************************************
--  Create the employee table to hold the employee personnel information for the company.
--  The department table will have a foreign key referencing this table (see note above).
--  This table has a self-referencing relationship - A foreign key constraint on manager_id, referencing employee_id.

--  Note that the manager_id and department_id columns allows NULLs - an employee can exist with no manager or department.

PRINT 'Creating employee table...';

CREATE TABLE employee
( employee_id    INT NOT NULL IDENTITY,
  first_name     VARCHAR(25) NOT NULL,
  last_name      VARCHAR(25) NOT NULL,
  gender	     CHAR(1) NULL,
  email          VARCHAR(25) NOT NULL,
  phone_number   VARCHAR(20) NOT NULL,
  hire_date      DATE NULL,
  job_id         VARCHAR(10) NOT NULL,
  salary         MONEY NOT NULL,
  commission_pct NUMERIC(2,2) NULL,
  manager_id     INT NULL,
  department_id  SMALLINT NULL,
  
  CONSTRAINT emp_emp_id_pk PRIMARY KEY (employee_id),
  CONSTRAINT emp_job_fk FOREIGN KEY (job_id) REFERENCES job(job_id),
  CONSTRAINT emp_dept_fk FOREIGN KEY (department_id) REFERENCES department(department_id),
  CONSTRAINT emp_manager_fk FOREIGN KEY (manager_id) REFERENCES employee(employee_id),
  CONSTRAINT emp_salary_min CHECK (salary > 0), 
  CONSTRAINT gender_char CHECK (gender IN ('M', 'F')),   
  CONSTRAINT emp_email_uk UNIQUE (email)
);

 
--  **************************************************************************************
--  Create the job_history table to hold the history of job that employee have held in the past.
--  The job, department and employee tables have foreign keys referencing this table.

--  Note that this table has a compound primary key consisting of the employee_id and start_date columns.

PRINT 'Creating job_history table...';
CREATE TABLE job_history
( employee_id	INT NOT NULL,
  start_date    DATE NOT NULL,
  end_date      DATE NOT NULL,
  job_id        VARCHAR(10) NOT NULL,
  department_id SMALLINT NULL,
  
  CONSTRAINT jhist_pk PRIMARY KEY (employee_id, start_date),
  CONSTRAINT jhist_job_fk FOREIGN KEY (job_id) REFERENCES job(job_id),
  CONSTRAINT jhist_emp_fk FOREIGN KEY (employee_id) REFERENCES employee(employee_id),
  CONSTRAINT jhist_date_interval CHECK (end_date > start_date)
) ;


--  **************************************************************************************
--  Create the job_grade table to hold the names and thresholds of job grade levels.

--  Note that there are no tables with foreign keys referencing this table.

PRINT 'Creating job_grade table...'
CREATE TABLE job_grade
( grade_level	CHAR(1) NOT NULL,
  lowest_sal	MONEY NOT NULL,
  highest_sal	MONEY NOT NULL,
  
  CONSTRAINT jgrade_pk PRIMARY KEY (grade_level),
  CONSTRAINT jgrade_sal_check CHECK (highest_sal > lowest_sal)
 );



--  **************************************************************************************
--  Now that the database tables have been created, we can populate them with data
--  **************************************************************************************



--  **************************************************************************************
--  Populate the region table.
--  Since the primary key uses IDENTITY, we don't specify a value for that column.

PRINT 'Populating region table...';

INSERT INTO region 
VALUES ('Europe'), 
	   ('Americas'), 
	   ('Asia'), 
	   ('Middle East and Africa');


--  **************************************************************************************
--  Populate the country table.

PRINT 'Populating country table...';

INSERT INTO country 
VALUES ('CA', 'Canada', 2), 
	   ('DE', 'Germany', 1), 
	   ('UK', 'United Kingdom', 1),
	   ('US', 'United States of America', 2);


--  **************************************************************************************
--  Populate the location table.
--  Since the primary key uses IDENTITY, we don't specify a value for that column.

PRINT 'Populating location table...';

INSERT INTO location 
VALUES ('2014 Jabberwocky Rd', '26192', 'Southlake', 'Texas', 'US'),
	   ('2011 Interiors Blvd', '99236', 'South San Francisco', 'California', 'US'),
	   ('2004 Charade Rd', '98199', 'Seattle', 'Washington', 'US'),
	   ('460 Bloor St. W.', 'ON M5S 1X8', 'Toronto', 'Ontario', 'CA'),
	   ('Magdalen Centre, The Oxford Science Park', 'OX9 9ZB', 'Oxford', 'Oxford', 'UK'); 


--  **************************************************************************************
--  Populate the job table.
--  Note that I've specified the column names for this table, and used NULL and DEFAULT for some pieces of data.

PRINT 'Populating job table...';

INSERT INTO job (job_id, job_title, min_salary, max_salary)
VALUES ('AD_PRES', 'President', 20000, NULL),
	   ('AD_VP', 'Administration Vice President', 15000, 30000),
	   ('AD_ASST', 'Administration Assistant', 3000, 6000),
	   ('AC_MGR', 'Accounting Manager', 8200, 16000),
       ('AC_ACCOUNT', 'Public Accountant', 4200, 9000),
       ('SA_MAN', 'Sales Manager', 10000, 20000),
       ('SA_REP', 'Sales Representative', 6000, 12000),
       ('ST_MAN', 'Stock Manager', 5500, 8500),
       ('ST_CLERK', 'Stock Clerk', DEFAULT, 5000),
       ('IT_PROG', 'Programmer', 4000, 10000),
       ('MK_MAN', 'Marketing Manager', 9000, 15000),
       ('MK_REP', 'Marketing Representative', 4000, 9000);


--  **************************************************************************************
--  Populate the department table.
--  Since the primary key uses IDENTITY, we don't specify a value for that column.
--  Note that the department_id uses IDENTITY(10, 10), so the values generated will be 10, 20, 30, 40, etc.

--  Remember that for the time being, the middle column (manager_id) does not have a foreign key constraint.
--  We can't link the data to the employee table yet, since the employee details have not been inserted yet.

PRINT 'Populating department table...';

INSERT INTO department 
VALUES ('Administration', 16, 3),
       ('Marketing', 17, 4),
       ('Shipping', 7, 2),
       ('IT', 4, 1),
       ('Sales', 12, 5),
       ('Executive', 1, 3),
       ('Accounting', 19, 3),
       ('Contracting', NULL, 3);


--  **************************************************************************************
--  Populate the employee table.
--  Note that I've specified the column names for this table, and used NULL for some pieces of data.

PRINT 'Populating employee table...';

INSERT INTO employee (first_name, last_name, gender, email, phone_number, hire_date, job_id, salary, commission_pct, manager_id, department_id)
VALUES ('Steven', 'King', 'M', 'SKING', '515 123 4567', '1987-06-17', 'AD_PRES', 24000, NULL, NULL, 60),
       ('Neena', 'Kochhar', 'F', 'NKOCHHAR', '515 123 4568', '1989-09-21', 'AD_VP', 17000, NULL, 1, 60),
       ('Lex', 'De Haan', 'M', 'LDEHAAN', '515 123 4569', '1993-01-13', 'AD_VP', 17000, NULL, 1, 60),
       ('Alexander', 'Hunold', 'M', 'AHUNOLD', '590 423 4567', '1990-01-03', 'IT_PROG', 9000, NULL, 3, 40),
       ('Bruce', 'Ernst', 'M', 'BERNST', '590 423 4568', '1991-03-21', 'IT_PROG', 6000, NULL, 4, 40),
       ('Diana', 'Lorentz', 'F', 'DLORENTZ', '590 423 5567', NULL, 'IT_PROG', 4200, NULL, 4, 40),
       ('Kevin', 'Mourgos', NULL, 'KMOURGOS', '650 123 5234', '1999-05-07', 'ST_MAN', 6000, NULL, 1, 30),
       ('Trenna', 'Rajs', 'F', 'TRAJS', '650 121 8009', '1995-10-17', 'ST_CLERK', 3500, NULL, 7, 30),
       ('Curtis', 'Davies', 'M', 'CDAVIES', '650 121 2994', NULL, 'ST_CLERK', 3100, NULL, 7, 30),
       ('Randall', 'Matos', NULL, 'RMATOS', '650 121 2874', '1998-03-15', 'ST_CLERK', 2600, NULL, 7, 30),
       ('Peter', 'Vargas', 'M', 'PVARGAS', '650 121 2004', '1999-05-07', 'ST_CLERK', 2500, NULL, 7, 30),
       ('Eleni', 'Zlotkey', 'F', 'EZLOTKEY', '(011) 44 1344 429018', '2000-01-29', 'SA_MAN', 10500, .2, 1, 50),
       ('Ellen', 'Abel', 'F', 'EABEL', '(011) 44 1644 429267', '1996-05-11', 'SA_REP', 11000, .30, 12, 50),
       ('Jonathon', 'Taylor', 'M', 'JTAYLOR', '(011) 44 1644 429265', '1998-03-24', 'SA_REP', 8000, .20, 12, 50),
       ('Kimberely', 'Grant', 'F', 'KGRANT', '(011) 44 1644 429263', '1999-05-07', 'SA_REP', 7000, .15, 12, NULL),
       ('Jennifer', 'Whalen', 'F', 'JWHALEN', '515 123 4444', '1987-09-17', 'AD_ASST', 4400, NULL, 2, 10),
       ('Michael', 'Hartstein', NULL, 'MHARTSTE', '515 123 5555', '1996-02-17', 'MK_MAN', 13000, NULL, 1, 20),
       ('Pat', 'Fay', 'F', 'PFAY', '603 123 6646', '1997-08-17', 'MK_REP', 3500, NULL, 17, 20),
       ('Shelley', 'Higgins', 'F', 'SHIGGINS', '515 123 8080', '1994-06-07', 'AC_MGR', 12000, NULL, 2, 70),
       ('William', 'Gietz', 'M', 'WGIETZ', '515 123 8181', '1994-06-07', 'AC_ACCOUNT', 8000, NULL, 19, 70);


--  **************************************************************************************
--  Now that the department and employee tables are populated, we can add the manager foreign key constraint to the department table.

ALTER TABLE department
  ADD CONSTRAINT dept_mgr_fk FOREIGN KEY (manager_id) REFERENCES employee(employee_id);
  

--  **************************************************************************************
--  Populate the job_history table.

--  Note that I have used a different date format for the start dates in this table.
--  Always make sure that the date format you use is recognised by the database server you are using.

PRINT 'Populating job_history table...';

INSERT INTO job_history
VALUES (3, '13-JAN-1993', '1998-07-24', 'IT_PROG', 40),
       (2, '21-SEP-1989', '1993-10-27', 'AC_ACCOUNT', 70),
       (2, '28-OCT-1993', '1997-03-15', 'AC_MGR', 70),
       (17, '17-FEB-1996', '1999-12-19', 'MK_REP', 20),
       (16, '17-SEP-1987', '1993-06-17', 'AD_ASST', 60),
       (14, '24-MAR-1998', '1998-12-31', 'SA_REP', 50),
       (14, '01-JAN-1999', '1999-12-31', 'SA_MAN', 50),
       (16, '01-JUL-1994', '1998-12-31', 'AC_ACCOUNT', 60);


--  **************************************************************************************
--  Populate the job_grade table.

PRINT 'Populating job_grade table...';

INSERT INTO job_grade 
VALUES ('A', 1000, 2999),
       ('B', 3000, 5999),
       ('C', 6000, 9999),
       ('D', 10000, 14999),
       ('E', 15000, 24999),
       ('F', 25000, 40000);