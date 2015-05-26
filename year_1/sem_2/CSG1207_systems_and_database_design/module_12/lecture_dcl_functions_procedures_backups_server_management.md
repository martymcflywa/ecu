# DCL, functions and procedures, backups and server management

## Data control language (DCL)

- In order to interact with anything on an SQL server, you must first connect to it with a username and password
	- Our servers have been set up to use Windows authentication, which uses your Windows credentials to access the server
	- Access can also be controlled using SQL
		- In all environments
- The DCL commands in SQL can be used to
	- Create, alter and drop logins, users and roles
	- Grant and revoke privileges to interact with database objects
- The privileges given to a user or role determine what they can see and do once they connect to a server
	- The **principle of least privilege** should be used to determine what access is given to different users/roles
	- ie. Give the least access needed to perform duties
- DCL commands in SQL provide an authentication mode that can be applied to just about any server in any environment
	- Can often be integrated with whatever other authentication mechanisms are being used in that environment

### Database logins

- `CREATE LOGIN` creates a name and password that can be used to **connect to the SQL server**

``` sql
CREATE LOGIN jbloggs
WITH PASSWORD = 'abc123';
```

- Other options such as password expiry can be specified
- This does not allow access to anything
	- Unless a guest user exists, in which case it is given the guest user's privileges

### Database users

- `CREATE USER` creates a user for the active database

``` sql
CREATE USER jbloggs_user
FOR LOGIN jbloggs;
```

- The user is mapped to a login
	- When the login is used to connect, access is granted to whatever the **user** can access
- If a single login needs access to multiple databases, you must create a user in each of those databases
- If you simply create a login and don't associate a user with it, two possible things can occur:
	1. If the database server has a built in and active **guest** user, the login gets mapped to that
		- Logging in would give you access to whatever the guest user has access to
	2. If the database server does not have an active **guest** user, the login will work but not give access to anything

### User roles

- Granting the same set of privileges to many different users is cumbersome, so **roles** can be used to streamline this

``` sql
CREATE ROLE reception_staff
EXEC sp_addrolemember 'reception_staff', 'jblogs_user';
```

- Many users can be added to a single role, and permissions can be granted to the role rather than individual users
- A user can be a member of multiple different roles
- Adding members to roles uses the `ALTER ROLE` command in SQL Server 2012
- There are a number of built in users and roles in all database servers for various administrative purposes
	- ie. Guest, admin and backup users/roles

### Grant permissions

- `GRANT` gives privileges to a user or role

``` sql
GRANT select ON employee
TO reception_staff;
```

- There are privileges regarding many different types of objects
	- Privileges regarding the server and associated services
	- Privileges regarding logins, users and roles
	- Privileges regarding databases, tables and views
- Include `WITH GRANT OPTION` at the end of statement to allow the user to grant the privilege to other users
	- Use with care
- You can give users/roles **exactly** the access they need
	- Using views and functions like `CURRENT_USER()`, you can even control access to specific **columns** and **rows** inside a table

### Revoke permissions

- `REVOKE` takes privileges away from a user or role

``` sql
REVOKE select ON employee
FROM jbloggs_user;
```

- You can revoke any previously granted privilege
- You can revoke the `WITH GRANT OPTION` ability
	- You can even revoke privileges granted using that ability

### Deny permissions

- `DENY` denies privileges from a user or role

``` sql
DENY delete ON employe
FROM jbloggs_user;
```

- Deny will always win when user/role privileges clash
	- Denying a privilege from a user will overrule a privilege granted to a role that the user is in
	- Denying a privilege from a role will overrule a privilege granted directly to a user who is a member of the role

### DCL summary

- This has been a very brief look at DCL
	- DCL commands can be used to improve security of database servers by modelling users and logins to the appropriate level of access
- To use the logins you have created, you will need to make your server accept SQL Server user authentication
	- Default is to use Windows user authentication only
	- In the Object Explorer in SSMS, right click on the server and select "Properties"

![right click here](http://snag.gy/vNgzA.jpg)

- Go to "Security" and select "SQL Server and Windows Authentication mode" from the Server authentication area
- Press "OK" to restart the server, then you can use SQL user logins

## User defined functions and stored procedures

- User Defined Functions (UDFs) and Stored Procedures (SPs) are two ways of writing and saving your own block of SQL code so that you can reuse it later
	- This concept exists in all programming languages, allowing for greater efficiency, readability and modularization of code
	- The server will cache the execution plan of UDFs and SPs, allowing them to be executed without needing to re-parse and re-optimise the statements
		- Resulting in faster execution
- UDFs and SPs use common programming constructs
	- A **function call** where parameters can be passed to the function
	- Variables declared and used to store values between statements
	- Control structures to control flow of execution
		- ie `IF`, `WHILE`
	- A **return value** that is the end result of the function

### User defined functions

- In module 10 we covered row-level functions
	- Built in functions that performed some kind of useful action on the parameter/s you pass it and return a result
	- ie. `ROUND`, `LEN`, `LTRIM`, `DATEDIFF`, `CAST`
- **User Defined Functions** are functions that you write yourself, defining them so that they can be used in future queries
	- Very useful if you repeatedly need to manipulate data in some way and there is not already a function that does it
	- It is also possible to create **User Defined Aggregate Functions**
- UDFs cannot make any permanent changes to data/schema
	- They cannot perform `UPDATE`, `INSERT`, `DELETE` commands
	- They cannot `CREATE`/`ALTER`/`DROP` tables

#### User defined functions example

- This code creates a UDF called `TRIM` which trims whitespace from both the start and end of a piece of text

``` sql
-- specifies the name of function and parameter/data type
CREATE FUNCTION TRIM (@string VARCHAR(MAX))
-- specifies the returned data type
RETURNS VARCHAR(MAX)
-- start of function code
BEGIN
	-- function code here
	RETURN LTRIM(RTRIM(@string));
-- end of function code
END;
```

- The function can now be used as needed in your queries

``` sql
-- Returns 'testing!' with no whitespace on either end
SELECT dbo.TRIM('   testing!   ');

-- Selects column with no whitespace on either end
SELECT dbo.TRIM(first_name) AS 'trimmed_name'
FROM employee

-- Updates columns to same thing with no whitespace on either end
UPDATE employee
SET first_name = dbo.TRIM(first_name),
	last_name = dbo.TRIM(last_name);
```

- The `dbo.` before the function name is required in order to let the server know that you're referring to an object owned by the **database owner**, rather than one of the built in functions
- In some ways, UDFs are similar to views
	- Writing something and saving it to make things easier for you

### Stored procedures

- Stored procedures differ from UDFs in a number of ways
	- SPs can include statements that modify data and schemas
		- ie. `INSERT`, `UPDATE`, `DELETE`, `CREATE TABLE` etc.
	- SPs must be run on their own as a single statement
		- UDFs can be used inline as part of another statement
	- SPs can return no/multiple values
		- UDFs must return one
	- SPs can include try-catch block exception handling
		- UDFs cant
- Hence, while UDFs allow you to define a new function to use, SPs are more like defining a whole statement
	- SPs often created to perform some kind of multi-step process that would otherwise be done by the application using the database
	- SPs often created to perform validation and access control, allowing from more sophisticated control of input and access

#### Stored procedure example 1

- This code creates an SP called `usp_searchemp` which looks for a search string in employee name, phone or email

``` sql
-- defines name of sp
CREATE PROCEDURE usp_searchemp
	-- defines the parameter and gives it default value
	@search VARCHAR(30) = ''
-- indicates the start of sp
AS
	-- sets NOCOUNT to ON, eliminating the "# rows affected" message, best practice, reduces network overheads
	SET NOCOUNT ON;

	-- declares @wild_search variable, set it to contain the @search variable with wildcard symbols at either end
	DECLARE @wild_search AS VARCHAR(32);
	SET @wild_search = '%' + @search + '%';

	-- SELECT statements, using LIKE to find matches with @wild_search
	SELECT first_name, last_name, phone_number, email
	FROM employee
	WHERE first_name LIKE @wild_search
		OR last_name LIKE @wild_search
		OR phone_number LIKE @wild_search
		OR email LIKE @wild_search
	ORDER BY last_name;
-- indicates end of procedure
GO
```

- The SP access one parameter, `@search`, and uses a default of an empty string if a string is not provided
- The SPs name starts with `usp_`
	- Built in SPs start with `sp_`
	- Prefixing a stored procedure name with `usp_` is not required but is considered best practice in order to make it clear that it is a user defined stored procedure
- The `(# row(s) affected)` message is disabled
	- Best practice
- A `@wild_search` variable is created, and set to contain the `@search` parameter with wildcard chars on both ends
- A `SELECT` statement is then run, using `LIKE` to find matches to `@wild_search` in a number of key columns

``` sql
-- returns details of all employees - default parameter value
EXEC usp_searchemp;

-- returns details of all employees with 'ha' in searched columns
EXEC usp_searchemp 'ha';
```

#### Stored procedure example 2

- This code creates an SP called `usp_setjob` which either updates the details of an existing job or inserts a new one

``` sql
CREATE PROCEDURE usp_setjob
	@job_id VARCHAR(10),
	@job_title VARCHAR(35),
	@min_sal INT = NULL,
	@max_sal INT = NULL
AS
	SET NOCOUNT ON;

	IF EXISTS (SELECT job_id FROM job WHERE job_id = @job_id)
	BEGIN
		UPDATE job
		SET
			job_title = @job_title,
			min_salary = ISNULL(@min_sal, min_salary),
			max_salary = ISNULL(@max_sal, max_salary)
		WHERE
			job_id = @job_id;
		PRINT
			'Job updated.';
	END
	ELSE
	BEGIN
		INSERT INTO job VALUES (@job_id, @job_title, @min_sal, @max_sal);
		PRINT
			'Job inserted.';
	END
GO
```

- The SP accepts between 2 and 4 parameters
- `@job_id` and `@job_title` are required but `@min_sal` and `@max_sal` can be left out
	- Since they can be given a default of NULL
- The SP then uses `IF`, `EXISTS` and `SELECT` to determine whether a job with that job ID already exists
	- If so, the details of the job are updated
		- `ISNULL` is used to only change the min and max salaries if values were provided
	- If not, a new job is inserted using the values provided

``` sql
-- Insert a new job with the specified details
EXEC usp_setjob 'SCPGT', 'Scapegoat', 0, 1000;

-- Update the title of the AC_MGR job
EXEC usp_setjob 'AC_MGR', 'Master Accountant';

-- Update all details of the AC_MGR job
EXEC usp_setjob 'AC_MGR', 'Master Accountant', 9999, 9999;
```

## Backup and server management

### Backup and restore

- To back up and restore a database to/from a file

``` sql
BACKUP DATABASE company
TO DISK = 'D:\some\folder\company.bck';

RESTORE DATABASE company
FROM DISK = 'D:\some\folder\company.bck';
```

- SQL Server must have permission to write to the location
- Can perform much more sophisticated backup and restore operations with advanced syntax
- Most database management tools will also have the ability to **export** a database into a text file of SQL commands
	- ie. Produce a creation/population script for you
	- Most will allow you to specify which things to export, and whether to include the structure and/or data

### Server management

![sql server tools](http://snag.gy/tO7wG.jpg)

- Along with SSMS, you have access to a few tools to manage and configure your SQL Server
	- The SQL Server Configuration Manager is the most relevant to this unit

#### Configuration manager

![configuration manager](http://snag.gy/GXgON.jpg)

- Allows you to configure various aspects of the SQL Server
	- Services
		- If SQL Server service is stopped, server is off
	- Ways in which the server can be connected to
	- Aliases allowing for connections over different ports / methods
