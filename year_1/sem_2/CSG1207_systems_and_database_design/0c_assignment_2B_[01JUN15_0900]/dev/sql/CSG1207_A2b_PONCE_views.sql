USE pizza_store;
GO

/*	Staff View (1 mark)
	Create a view which shows staff ID, date of birth, phone number and supervisor ID of all staff members, 
	as well as their first name and last name concatenated into a “full name” column.
*/

--	Write your Staff View here

-- If view exists, drop it.

IF EXISTS (SELECT *
	FROM sys.views
	WHERE name = 'view_staff'
	AND schema_id = SCHEMA_ID('dbo'))
	DROP VIEW dbo.view_staff
GO

-- Create view_staff

PRINT 'Creating view_staff.'
GO

CREATE VIEW view_staff
AS SELECT	st.staff_id AS 'staff_id',
			st.staff_first_name + ' ' + st.staff_last_name AS 'staff_full_name',
			st.staff_dob AS 'dob',
			st.staff_phone AS 'phone_number',
			sup.staff_first_name + ' ' + sup.staff_last_name AS 'supervisor_full_name'
	FROM staff AS st LEFT OUTER JOIN staff AS sup
	ON st.supervisor = sup.staff_id;
GO

SELECT *
FROM view_staff;
GO

/*	Pizza Orders View (2 marks)
	Create a view which shows the following details of all rows in the “pizza order” table:
	•	The order ID number and order date.
	•	The customer ID number and name of the customer who placed the order.
	•	The staff ID number and full name of the staff member who took the order.
	•	The staff ID number and full name of the staff member who delivered the order.
		•	Ensure that all orders are shown, even those which have not been delivered yet.

	Using the Staff View in the query of this view is recommended.
	
	Hint:  You will need two JOINs to the staff view/table, one of which needs to be an OUTER JOIN.
*/

-- Write your Pizza Orders View here





GO
/*	Ordered Pizzas View (3 marks)
	Create a view which shows the following details of all rows in the “ordered pizza” table:
	•	The ordered pizza ID number, order ID number and “ready” column.
	•	The pizza ID number and pizza name of the ordered pizza.
	•	The range ID number and range name of the ordered pizza.
	•	The crust ID number and crust name of the ordered pizza.
	•	The sauce ID number and sauce name of the ordered pizza.
	•	The cost of the pizza (add together the range price, crust surcharge and sauce surcharge)

	Hint:  This requires four JOINs.
*/

-- Write your Ordered Pizzas View here





GO
/*	If you wish to create additional views to use in the queries which follow, include them in this file. */
