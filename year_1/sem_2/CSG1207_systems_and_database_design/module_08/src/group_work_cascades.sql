--  **************************************************************************************
--  Creation and Population Script for the 'group_work_2' database.
--  This database is used in Module 8 of CSG1207/CSI5135.
--  **************************************************************************************



--  **************************************************************************************
--  We first check if the database exists, and drop it if it does.

--  Setting the active database to the built in 'master' database ensures that we are not trying to drop the currently active database.
--  Setting the database to 'single user' mode ensures that any other scripts currently using the database will be disconnectetd.
--  This allows the database to be deleted, instead of giving a 'database in use' error when trying to delete it.

IF DB_ID('group_work_2') IS NOT NULL             
	BEGIN
		PRINT 'Database exists - dropping.';
		
		USE master;		
		ALTER DATABASE group_work_2 SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
		
		DROP DATABASE group_work_2;
	END

GO

--  Now that we are sure the database does not exist, we create it.

PRINT 'Creating database.';

CREATE DATABASE group_work_2;

GO

--  Now that an empty database has been created, we will make it the active one.
--  The table creation statements that follow will therefore be executed on the newly created database.

USE group_work_2;

GO



--  **************************************************************************************
--  We now create the tables in the database.
--  **************************************************************************************


--  Create the unit table.
CREATE TABLE unit
(  unit_code CHAR(7) NOT NULL CONSTRAINT unit_pk PRIMARY KEY,
   unit_name VARCHAR(50) NOT NULL,
   unit_desc TEXT NULL,
   credit_points TINYINT NOT NULL DEFAULT 15
);

--  Create the student table.
CREATE TABLE student
(  student_num INT NOT NULL CONSTRAINT student_pk PRIMARY KEY,
   student_name VARCHAR(50) NOT NULL,
   gender CHAR(1) NULL,
   birthdate DATE NULL
);

--  Create the assignment_type table.
CREATE TABLE assignment_type
(  assn_type_id TINYINT NOT NULL IDENTITY CONSTRAINT assn_type_pk PRIMARY KEY,
   assn_type VARCHAR(20) NOT NULL CONSTRAINT assn_type_uk UNIQUE
);

--  Create the assignment table.
CREATE TABLE assignment
(  assn_id INT NOT NULL IDENTITY CONSTRAINT assn_pk PRIMARY KEY,
   unit_code CHAR(7) NULL CONSTRAINT assn_unit_fk FOREIGN KEY REFERENCES unit ON UPDATE CASCADE ON DELETE SET NULL,
   assn_type TINYINT NULL CONSTRAINT assn_assn_type_fk FOREIGN KEY REFERENCES assignment_type(assn_type_id) ON DELETE SET NULL,
   assn_name VARCHAR(50) NOT NULL,
   assn_desc TEXT NULL,
   weighting DECIMAL(4,1) NULL
);

--  Create the group table.
CREATE TABLE work_group
(  group_id INT NOT NULL IDENTITY CONSTRAINT group_pk PRIMARY KEY,
   assn_id INT NOT NULL FOREIGN KEY REFERENCES assignment ON DELETE CASCADE,
   group_name VARCHAR(50) NOT NULL,
   creation_date DATE DEFAULT GETDATE() NOT NULL
);

--  Create the group_member table.
CREATE TABLE group_member
(  student_num INT NOT NULL CONSTRAINT gmem_student_fk FOREIGN KEY REFERENCES student ON UPDATE CASCADE ON DELETE CASCADE,
   group_id INT NOT NULL CONSTRAINT gmem_group_fk FOREIGN KEY REFERENCES work_group ON DELETE CASCADE,
   
   CONSTRAINT gmem_pk PRIMARY KEY (student_num, group_id)
);



--  **************************************************************************************
--  Now that the database tables have been created, we can populate them with data
--  **************************************************************************************



--  Populate the unit table.
INSERT INTO unit
VALUES ('CSG1207', 'Systems and Database Design', 'This unit introduces students to the concepts of relational databases, including database design via normalisation and entity-relationship modelling in order to solve problems. It explores the use of Structured Query Language (SQL) to create, populate and administer relational databases and to perform complex queries upon the data inside them.', DEFAULT),
       ('CSG2431', 'Interactive Web Development', 'This unit focuses on the development of distributed applications with an emphasis on Web based applications.  It covers concepts and characteristics of distributed systems, underlying enabling architectures, interface design, portability inter-operability and interactivity.  Methods and issues in connecting databases to the Web, client and server side scripting are addressed.  Special attention is given to the design and implementation of e-business enabled Web applications.', DEFAULT),
       ('CSP3341', 'Programming Languages and Paradigms', 'This unit engages the students in the exploration of the theoretical, practical and evolutionary characteristics of programming languages using various operational paradigms.', DEFAULT);


--  Populate the student table.
INSERT INTO student
VALUES (102412, 'Joe Bloggs', 'M', '22-MAR-1978'),
       (109467, 'Sam Smith', 'M', '04-JUN-1984'),
       (102345, 'Mary Turner', 'F', NULL),
       (101345, 'Jane Doe', 'F', '18-FEB-1991'),
       (104851, 'Jessie Hope', NULL, '30-DEC-1994'),
       (102746, 'Sarah Collins', 'F', '16-SEP-1973');


--  Populate the assignment_type table.
INSERT INTO assignment_type
VALUES ('Other / Unspecified'),
	   ('Report'),
	   ('Essay'),
	   ('Project'),
	   ('Programming'),
	   ('Presentation');


--  Populate the assignment table.
INSERT INTO assignment
VALUES ('CSG1207', 4, 'Database Design Project', 'Normalisation and ER Diagrams.', 20.0),
       ('CSG1207', 4, 'Database Development Project', 'Implement a database and manipulate it.', 30.0),
       ('CSG2431', 5, 'Web Application Development', NULL, 25.0),
       ('CSG2431', 6, 'Application Presentation', 'Present and demonstrate your Web application to the class.', 25.0),
       ('CSP3341', 2, 'Programming Language Report', NULL, NULL);


--  Populate the work_group table.
INSERT INTO work_group
VALUES (1, 'Group 1', DEFAULT),
       (1, 'Group 2', DEFAULT),
       (2, 'Group 1', DEFAULT),
       (2, 'Group 2', DEFAULT),
       (3, 'Superfoxes', DEFAULT),
       (3, 'Best Group', DEFAULT),
       (4, 'A Team', DEFAULT),
       (5, 'Team Best Team', DEFAULT),
       (5, 'Team Rocket', DEFAULT);


--  Populate the group_member table.
INSERT INTO group_member
VALUES (102412, 1),
       (109467, 1),
       (102345, 1),
       (101345, 2),
       (104851, 2),
       (102412, 3),
       (109467, 3),
       (102345, 3),
       (101345, 4),
       (104851, 4),
       (102345, 5),
       (104851, 5),
       (102746, 5),
       (101345, 6),
       (109467, 6),
       (104851, 7),
       (102746, 7),
       (109467, 7),
       (102412, 7),
       (109467, 8),
       (102412, 8),
       (102746, 9),
       (104851, 9);