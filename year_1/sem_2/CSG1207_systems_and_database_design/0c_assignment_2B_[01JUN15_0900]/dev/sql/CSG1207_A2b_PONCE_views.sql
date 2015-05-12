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
	DROP VIEW dbo.view_staff;
GO

-- Create view_staff.

PRINT 'Creating view_staff.';
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

-- Check out view_staff.

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

-- If view exists, drop it.

IF EXISTS (SELECT *
	FROM sys.views
	WHERE name = 'view_pizza_orders'
	AND schema_id = SCHEMA_ID('dbo'))
	DROP VIEW dbo.view_pizza_orders;
GO

-- Create view_pizza_orders.

PRINT 'Creating view_pizza_orders.';
GO

CREATE VIEW view_pizza_orders
AS SELECT	po.pizza_order_id AS 'order_id',
			co.cust_order_datetime AS 'order_date',
			co.cust_id AS 'cust_id',
			cu.cust_name AS 'cust_name',
			co.staff_order AS 'taken_by',
			st.staff_full_name AS 'taker_name',
			co.staff_delivery AS 'delivered_by',
			d.staff_full_name AS 'deliverer_name'
	FROM pizza_order AS po INNER JOIN customer_order AS co
	ON po.cust_order_id = co.cust_order_id
	INNER JOIN customer AS cu
	ON co.cust_id = cu.cust_id
	INNER JOIN view_staff AS st
	ON co.staff_order = st.staff_id
	LEFT OUTER JOIN view_staff AS d
	ON co.staff_delivery = d.staff_id;
GO

-- Check out view_pizza_orders.

SELECT *
FROM view_pizza_orders;
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

-- If view exists, drop it.

IF EXISTS (SELECT *
	FROM sys.views
	WHERE name = 'view_ordered_pizzas'
	AND schema_id = SCHEMA_ID('dbo'))
	DROP VIEW dbo.view_ordered_pizzas;
GO

-- Create view_ordered_pizzas.

PRINT 'Creating view_ordered_pizzas.';
GO

CREATE VIEW view_ordered_pizzas
AS SELECT	po.pizza_order_id AS 'pizza_order_id',
			po.cust_order_id AS 'cust_order_id',
			po.pizza_id AS 'pizza_id',
			pz.pizza_name AS 'pizza_name',
			pz.range_id AS 'range_id',
			pr.range_name AS 'range_name',
			po.crust_id AS 'crust_id',
			pc.crust_name AS 'crust_name',
			po.sauce_id AS 'sauce_id',
			ps.sauce_name AS 'sauce_name',
			po.pizza_ready AS 'ready',
			pr.range_price + pc.crust_surcharge + ps.sauce_surcharge AS 'cost'
	FROM pizza_order AS po INNER JOIN pizza AS pz
	ON po.pizza_id = pz.pizza_id
	INNER JOIN pizza_range AS pr
	ON pz.range_id = pr.range_id
	INNER JOIN pizza_crust AS pc
	ON po.crust_id = pc.crust_id
	INNER JOIN pizza_sauce AS ps
	ON po.sauce_id = ps.sauce_id;
GO

-- Check out view_ordered_pizzas.

SELECT *
FROM view_ordered_pizzas;
GO

/*	If you wish to create additional views to use in the queries which follow, include them in this file. */
