/*	Database Creation & Population Script (8 marks)
	Produce a script to create the database you designed in Task 1 (incorporating any changes you have made since then).  
	Be sure to give your columns the same data types, properties and constraints specified in your data dictionary, and be sure to use a consistent naming scheme.  
	Include any logical and correct default values and any check or unique constraints that you feel are appropriate.

	Make sure this script can be run multiple times without resulting in any errors (hint: drop the database if it exists before trying to create it).  
	Examine the creation scripts of the sample databases available in the unit materials for an example of how to do this.

	See the assignment brief for further information. 
*/

-- Write your creation script here







/*	Database Population Statements
	Following the SQL statements to create your database and its tables, you must include statements to populate the database with sufficient test data.

	You may wish to start working on your views and queries and write INSERT statements that add the data needed to test each one as you go.   
	The final create.sql should be able to create your database and populate it with enough data to make sure that all views and queries return meaningful results.
*/

-- Write your insert statements here






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

INSERT INTO crust (crust_name, crust_surcharge)
VALUES	('Thick Crust', 0),				-- crust ID 1
		('Thin Crust', 0),				-- crust ID 2
		('Sauce-Stuffed Crust', 1),		-- crust ID 3
		('Cheese-Stuffed Crust', 1.5);	-- crust ID 4
		


/*	The following statement inserts the details of 4 sauces into a table named "sauce".  It specifies values for "sauce_name" and "sauce_surcharge" columns.
	Sauce ID numbers numbers are not specified since it is assumed that an auto-incrementing integer is being used.
	If required, change the table and column names to match those in your database.
*/

INSERT INTO sauce (sauce_name, sauce_surcharge)
VALUES	('Pizza Sauce', 0),							-- sauce ID 1
		('BBQ Sauce', 0),							-- sauce ID 2
		('Traditional Italian Pesto', 1),			-- sauce ID 3
		('Garlic and Red Wine Tomato Chutney', 2);	-- sauce ID 4