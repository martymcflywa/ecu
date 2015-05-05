/*	Database Creation & Population Script (8 marks)
	Produce a script to create the database you designed in Task 1 (incorporating any changes you have made since then).  
	Be sure to give your columns the same data types, properties and constraints specified in your data dictionary, and be sure to use a consistent naming scheme.  
	Include any logical and correct default values and any check or unique constraints that you feel are appropriate.

	Make sure this script can be run multiple times without resulting in any errors (hint: drop the database if it exists before trying to create it).  
	Examine the creation scripts of the sample databases available in the unit materials for an example of how to do this.

	See the assignment brief for further information. 
*/

-- Write your creation script here

--  **************************************************************************************
--  Creation and Population Script for the 'pizza_store' database.
--  **************************************************************************************

--  **************************************************************************************
--  We first check if the database exists, and drop it if it does.

--  Setting the active database to the built in 'master' database ensures that we are not trying to drop the currently active database.
--  Setting the database to 'single user' mode ensures that any other scripts currently using the database will be disconnectetd.
--  This allows the database to be deleted, instead of giving a 'database in use' error when trying to delete it.

IF DB_ID('pizza_store') IS NOT NULL             
	BEGIN
		PRINT 'pizza_store database exists - dropping.';
		
		USE master;		
		ALTER DATABASE pizza_store SET SINGLE_USER WITH ROLLBACK IMMEDIATE;
		
		DROP DATABASE pizza_store;
	END

GO

--  Now that we are sure the database does not exist, we create it.

PRINT 'Creating database.';

CREATE DATABASE pizza_store;

GO

--  Now that an empty database has been created, we will make it the active one.
--  The table creation statements that follow will therefore be executed on the newly created database.

USE pizza_store;

GO

--  **************************************************************************************
--  We now create the tables in the database in the correct creation order.
--  **************************************************************************************

--  **************************************************************************************
--	Table 1: staff
--  **************************************************************************************
--  Create the staff table to hold details about staff.
--  Tables with foreign keys referencing this table:
--		staff.supervisor
--		customer_order.staff_order
--		customer_order.staff_delivery

PRINT 'Creating staff table...';

CREATE TABLE staff (
	staff_id TINYINT NOT NULL IDENTITY,
	staff_last_name VARCHAR(20) NOT NULL,
	staff_first_name VARCHAR(20) NOT NULL,
	staff_dob DATE NOT NULL,
	staff_phone VARCHAR(10) NOT NULL,
	supervisor TINYINT NULL,
	
	CONSTRAINT staff_pk PRIMARY KEY (staff_id),
	CONSTRAINT staff_age_check CHECK (DATEDIFF(year, GETDATE(), staff_dob) >= 16),
	CONSTRAINT supervisor_fk FOREIGN KEY (supervisor) REFERENCES staff(staff_id)
);

--  **************************************************************************************
--	Table 2: customer
--  **************************************************************************************
--  Create the customer table to hold details about customer.
--  Tables with foreign keys referencing this table:
--		customer_order.cust_id
--		pizza_order.cust_id

PRINT 'Creating customer table...';

CREATE TABLE customer (
	cust_id SMALLINT NOT NULL IDENTITY,
	cust_name VARCHAR(50) NOT NULL,
	cust_adrs TEXT NOT NULL,
	cust_email VARCHAR(20) NOT NULL,
	
	CONSTRAINT customer_pk PRIMARY KEY (cust_id),
	CONSTRAINT cust_email_check CHECK (cust_email LIKE '_%@_%.__%')
);

--  **************************************************************************************
--	Table 3: customer_order
--  **************************************************************************************
--  Create the customer_order table to hold details about a customer's order.
--  Tables with foreign keys referencing this table:
--		pizza_order.cust_order_id

PRINT 'Creating customer_order table...';

CREATE TABLE customer_order (
	cust_order_id INT NOT NULL IDENTITY,
	cust_id SMALLINT NOT NULL,
	staff_order TINYINT NOT NULL,
	cust_order_datetime DATETIME NOT NULL,
	staff_delivery TINYINT NULL,
	
	CONSTRAINT customer_order_pk PRIMARY KEY (cust_order_id),
	CONSTRAINT cust_id_pk FOREIGN KEY (cust_id) REFERENCES customer(cust_id),
	CONSTRAINT staff_order_fk FOREIGN KEY (staff_order) REFERENCES staff(staff_id),
	CONSTRAINT staff_delivery_fk FOREIGN KEY (staff_delivery) REFERENCES staff(staff_id)
);

--  **************************************************************************************
--	Table 4: pizza_crust
--  **************************************************************************************
--  Create the pizza_crust table to hold details about available pizza crusts.
--  Tables with foreign keys referencing this table:
--		pizza_order.crust_id

PRINT 'Creating pizza_crust table...';

CREATE TABLE pizza_crust (
	crust_id TINYINT NOT NULL IDENTITY,
	crust_name VARCHAR(20) NOT NULL,
	crust_surcharge DECIMAL(3,2) NOT NULL DEFAULT 0.00,
	
	CONSTRAINT crust_id_pk PRIMARY KEY (crust_id),
	CONSTRAINT crust_name_uk UNIQUE (crust_name)
);

--  **************************************************************************************
--	Table 5: pizza_sauce
--  **************************************************************************************
--  Create the pizza_sauce table to hold details about available pizza sauces.
--  Tables with foreign keys referencing this table:
--		pizza_order.sauce_id

PRINT 'Creating pizza_sauce table...';

CREATE TABLE pizza_sauce (
	sauce_id TINYINT NOT NULL IDENTITY,
	sauce_name VARCHAR(20) NOT NULL,
	sauce_surcharge DECIMAL(3,2) NOT NULL DEFAULT 0.00,
	
	CONSTRAINT sauce_id_pk PRIMARY KEY (sauce_id),
	CONSTRAINT sauce_name_uk UNIQUE (sauce_name)
);

--  **************************************************************************************
--	Table 6: pizza_range
--  **************************************************************************************
--  Create the pizza_range table to hold details about available pizza ranges.
--  Tables with foreign keys referencing this table:
--		pizza_type.range_id

PRINT 'Creating pizza_range table...';

CREATE TABLE pizza_range (
	range_id TINYINT NOT NULL IDENTITY,
	range_name VARCHAR(20) NOT NULL,
	range_price DECIMAL(4,2) NOT NULL,
	
	CONSTRAINT range_id_pk PRIMARY KEY (range_id),
	CONSTRAINT range_name_uk UNIQUE (range_name)
);

--  **************************************************************************************
--	Table 7: pizza
--  **************************************************************************************
--  Create the pizza table to hold details about available pizzas.
--  Tables with foreign keys referencing this table:
--		pizza_order.pizza_id

PRINT 'Creating pizza table...';

CREATE TABLE pizza (
	pizza_id TINYINT NOT NULL IDENTITY,
	range_id TINYINT NOT NULL,
	pizza_name VARCHAR(20) NOT NULL,
	pizza_desc TEXT NOT NULL,
	
	CONSTRAINT pizza_id_pk PRIMARY KEY (pizza_id),
	CONSTRAINT range_id_fk FOREIGN KEY (range_id) REFERENCES pizza_range(range_id),
	CONSTRAINT pizza_name_uk UNIQUE (pizza_name)
);

--  **************************************************************************************
--	Table 8: pizza_order
--  **************************************************************************************
--  Create the pizza_order table to hold details about an ordered pizza.
--	No tables/foreign keys reference this table.

PRINT 'Creating pizza_order table...';

CREATE TABLE pizza_order (
	pizza_order_id INT NOT NULL IDENTITY,
	pizza_ready CHAR(1) NOT NULL DEFAULT 'N',
	cust_order_id INT NOT NULL,
	pizza_id TINYINT NOT NULL,
	crust_id TINYINT NOT NULL,
	sauce_id TINYINT NOT NULL,
	
	CONSTRAINT pizza_order_id_pk PRIMARY KEY (pizza_order_id),
	CONSTRAINT pizza_ready_check CHECK (pizza_ready IN ('Y', 'N')),
	CONSTRAINT pizza_id_fk FOREIGN KEY(pizza_id) REFERENCES pizza(pizza_id),
	CONSTRAINT crust_id_fk FOREIGN KEY (crust_id) REFERENCES pizza_crust(crust_id),
	CONSTRAINT sauce_id_fk FOREIGN KEY (sauce_id) REFERENCES pizza_sauce(sauce_id)
);

/*	Database Population Statements
	Following the SQL statements to create your database and its tables, you must include statements to populate the database with sufficient test data.

	You may wish to start working on your views and queries and write INSERT statements that add the data needed to test each one as you go.   
	The final create.sql should be able to create your database and populate it with enough data to make sure that all views and queries return meaningful results.
*/

-- Write your insert statements here

--  **************************************************************************************
--  Now that the database tables have been created, we can populate them with data
--  **************************************************************************************

--  **************************************************************************************
--  Populate the staff table.
--  Since the primary key uses IDENTITY, we don't specify a value for that column.

INSERT INTO staff (staff_last_name, staff_first_name, staff_dob, staff_phone, supervisor)
VALUES	('Capone', 'Al', '1979-01-17', '0418991747', NULL),
		('Luciano', 'Lucky', '1977-11-24', '0418971962', NULL),
		('Gotti', 'John', '1980-10-27', '0419402002', NULL),
		('Hill', 'Henry', '1983-06-11', '0419432012', NULL),
		('Brasco', 'Donnie', '1984-01-01', '0419392015', 4),
		('Costello', 'Frank', '1976-01-26', '0418911773', 2),
		('Genovese', 'Vito', '1967-11-27', '0418971969', 1),
		('Gigante', 'Vincent', '1986-03-29', '0419282005', NULL),
		('DeMeo', 'Roy', '1989-09-07', '0419421983', 3),
		('Lucchese', 'Tommy', '1995-07-13', '0418991967', 3),
		('Giancana', 'Sam', '1983-06-19', '0419081795', 1),
		('Gravano', 'Sammy', '1994-03-12', '0419452015', 4),
		('Scarpa', 'Greg', '1988-05-08', '0419281994', 2),
		('Spilotro', 'Tony', '1998-06-14', '0419381986', 3),
		('Cohen', 'Mickey', '1993-09-04', '0419131976', 16),
		('Siegel', 'Bugsy', '1990-06-20', '0419061947', NULL),
		('Pitera', 'Tommy', '1991-12-02', '0419542015', 4),
		('Casso', 'Anthony', '1982-05-21', '0419402015', 1),
		('Bonanno', 'Joseph', '1992-05-11', '0419052002', 3),
		('Castellano', 'Paul', '1985-12-16', '0419151985', 2);

--  **************************************************************************************
--  Populate the customer table.
--  Since the primary key uses IDENTITY, we don't specify a value for that column.

INSERT INTO customer (cust_name, cust_adrs, cust_email)
VALUES	('James Brown', '1 Street Rd, Suburb, 0101', 'soulbrothernumberone@jamesbrown.com'),
		('Kurt Cobain', '2 Street Rd, Suburb, 0102', 'kurt@nirvana.com'),
		('Dr. Dre', '3 Street Rd, Compton, 0420', 'dreday@nwa.com'),
		('Eazy E', '4 Street Rd, Compton, 0420', 'eazy@nwa.com'),
		('Ice Cube', '5 Street Rd, Compton, 0420', 'doughboy@nwa.com'),
		('MC Ren', '6 Street Rd, Compton, 0420', 'ren@nwa.com'),
		('RZA', '7 Street Rd, Staten Island, 0718', 'rza@wutangclan.com'),
		('Ol Dirty Bastard', '8 Street Rd, Staten Island, 0718', 'odb@wutangclan.com'),
		('Method Man', '9 Street Rd, Staten Island, 0718', 'meth@wutangclan.com'),
		('Joseph Simmons', '10 Street Rd, Queens, 1423', 'run@rundmc.com'),
		('Darryl McDaniels', '11 Street Rd, Queens, 1423', 'dmc@rundmc.com'),
		('Jason Mizell', '12 Street Rd, Queens, 1423', 'jammasterjay@rundmc.com'),
		('Adam Yauch', '13 Street Rd, Brooklyn, 1249', 'mca@beastieboys.com'),
		('Michael Diamond', '14 Street Rd, Brooklyn, 1249', 'miked@beastieboys.com'),
		('Adam Horovitz', '15 Street Rd, Brooklyn, 1249', 'adrock@beastieboys.com'),
		('Mixmaster Mike', '16 Street Rd, Brooklyn, 1249', 'mmm@beastieboys.com'),
		('Chuck D', '17 Street Rd, Long Island, 1101', 'chuckd@publicenemy.com'),
		('Flavor Flav', '18 Street Rd, Long Island, 1101', 'flav@publicenemy.com'),
		('DJ Lord', '19 Street Rd, Long Island, 1101', 'djlord@publicenemy.com'),
		('Zach de la Rocha', '20 Street Rd, Los Angeles, 0323', 'zach@rageagainsthemachine.com');
		
/*	The following statement inserts the details of 3 pizza ranges into a table named "pizza_range".  It specifies values "range_name" and "range_price" columns.
	Range ID numbers numbers are not specified since it is assumed that an auto-incrementing integer is being used.
	If required, change the table and column names to match those in your database.
*/

INSERT INTO pizza_range (range_name, range_price)
VALUES	('Budget Range', 8),		-- range ID 1
		('Traditional Range', 12),	-- range ID 2
		('Gourmet Range', 16);		-- range ID 3



/*	The following statement inserts the details of 9 pizzas into a table named "pizza".  It specifies values for "pizza_name", "pizza_desc" and "range_id" columns.
	Pizza ID numbers numbers are not specified since it is assumed that an auto-incrementing integer is being used.
	If required, change the table and column names to match those in your database.
*/

INSERT INTO pizza (pizza_name, pizza_desc, range_id) 
VALUES	('Classic Cheese', 'Who needs toppings?', 1),									-- pizza ID 1
		('Hawaiian', 'A ham and pineapple classic.', 1),								-- pizza ID 2
		('Pepperoni', 'Slices of pepperoni all over.', 1),								-- pizza ID 3
		('Meatlovers', 'Covered in cheap processed meat.  Best with BBQ sauce.', 2),	-- pizza ID 4
		('Supreme', 'Meat AND vegetables - a balanced meal!', 2),						-- pizza ID 5
		('Vegetarian', 'Various vegetables, and some wilted herbs.', 2),				-- pizza ID 6
		('BBQ Duck and Asparagus', 'Sweet duck breast and seasoned asparagus.', 3),		-- pizza ID 7
		('Pulled Pork and Pear', 'Slow-cooked pulled pork and fresh pear slices.', 3),	-- pizza ID 8
		('Wagyu Beef and Prawn', 'Tender slices of beef and tiger prawns.', 3);			-- pizza ID 9



/*	The following statement inserts the details of 4 crusts into a table named "crust".  It specifies values for "crust_name" and "crust_surcharge" columns.
	Crust ID numbers numbers are not specified since it is assumed that an auto-incrementing integer is being used.
	If required, change the table and column names to match those in your database.
*/

-- MP 20150505: Modified crust to pizza_crust
INSERT INTO pizza_crust (crust_name, crust_surcharge)
VALUES	('Thick Crust', 0),				-- crust ID 1
		('Thin Crust', 0),				-- crust ID 2
		('Sauce-Stuffed Crust', 1),		-- crust ID 3
		('Cheese-Stuffed Crust', 1.5);	-- crust ID 4
		


/*	The following statement inserts the details of 4 sauces into a table named "sauce".  It specifies values for "sauce_name" and "sauce_surcharge" columns.
	Sauce ID numbers numbers are not specified since it is assumed that an auto-incrementing integer is being used.
	If required, change the table and column names to match those in your database.
*/

-- MP 20150505: Modified sauce to pizza_sauce
INSERT INTO sauce (sauce_name, sauce_surcharge)
VALUES	('Pizza Sauce', 0),							-- sauce ID 1
		('BBQ Sauce', 0),							-- sauce ID 2
		('Traditional Italian Pesto', 1),			-- sauce ID 3
		('Garlic and Red Wine Tomato Chutney', 2);	-- sauce ID 4