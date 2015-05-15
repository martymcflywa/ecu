USE pizza_store;

/*	Query 1 – Pizza Menu (2 marks)
	Write a query that shows the range name, pizza name, pizza description and range price of all pizzas.  
	Order the results by range ID number, then pizza name.
*/

-- Write Query 1 here

SELECT
	pr.range_name,
	pz.pizza_name,
	pz.pizza_desc,
	pr.range_price
FROM
	pizza AS pz
	INNER JOIN pizza_range AS pr
	ON pz.range_id = pr.range_id
ORDER BY
	pr.range_id,
	pz.pizza_name;



/*	Query 2 – Customer Search (2 marks)
	Write a query that shows all details of customers with a name beginning with the letter “F” or “J”, and whose email address is at least 15 characters long.  
	Order the results by customer name.
*/

-- Write Query 2 here

SELECT *
FROM customer
WHERE
	(cust_name LIKE ('F%') OR cust_name LIKE ('J%'))
	AND LEN(cust_email) >= 15;



/*	Query 3 – Unready Pizzas (2.5 marks)
	Write a query that shows the order date, pizza name, crust name and sauce name of any ordered pizzas which are not ready (ready column contains “N”).  
	Order the results by the order date.  Using the Ordered Pizzas View in this query is recommended.
*/

-- Write Query 3 here

SELECT
	po.order_date,
	op.pizza_name,
	op.crust_name,
	op.sauce_name,
	op.ready
FROM
	view_pizza_orders AS po
	INNER JOIN view_ordered_pizzas AS op
	ON po.pizza_order_id = op.pizza_order_id
WHERE
	op.ready = 'N'
ORDER BY
	po.order_date;



/*	Query 4 – Popular Pizzas (3 marks)
	Write a query that that shows the names of the top three most ordered pizzas and the number of times they have each been ordered.  
	Using the Ordered Pizzas View in this query is recommended.
*/

-- Write Query 4 here

SELECT TOP(3)
	pizza_name,
	COUNT(pizza_id) AS 'times_ordered'
FROM
	view_ordered_pizzas
GROUP BY
	pizza_name
ORDER BY
	times_ordered DESC;



/*	Query 5 – Underage Supervisors (3 marks)
	Write a query that shows the name and age (in years) of any staff members who younger than 21 years old and are supervising at least one other staff member.  
	Using the Staff View in this query is recommended.

	Hint:  Use the DATEDIFF function to determine the age of a staff member from their date of birth, 
	and consider using a subquery and an IN comparison to determine if a staff member is supervising anyone.
*/

-- Write Query 5 here

-- view_supervisors does heavy lifting to identify supervisors.
SELECT
	supervisor_full_name,
	age
FROM
	view_supervisors
WHERE
	age < 21;



/*	Query 6 – Pizza Order Summaries (3.5 marks)
	Write a query that shows the order ID number, order date, customer name, and total cost of all pizza orders.  
	Order the results by the order date, in descending order.  Using the Pizza Orders View and the Ordered Pizzas View in this query is recommended.

	Hint:  Use GROUP BY and SUM to group the results per order and calculate the total cost of the pizzas in each order.
*/

-- Write Query 6 here

SELECT
	op.cust_order_id AS 'order_id',
	po.order_date AS 'order_date',
	po.cust_name AS 'cust_name',
	SUM(op.cost) AS 'total_cost'
FROM
	view_ordered_pizzas AS op
	INNER JOIN view_pizza_orders AS po
	ON po.pizza_order_id = op.pizza_order_id
GROUP BY
	op.cust_order_id, po.order_date, po.cust_name
ORDER BY
	po.order_date DESC;



/*	Query 7 – Orders Awaiting Delivery (4 marks)
	Write a query that shows the order ID number, order date and customer name of any orders which have not been delivered yet (delivery foreign key is NULL) 
	and all pizzas in the order are ready (ready column contains “Y”).  Order the results by the order date.  
	Using the Pizza Orders View and the Ordered Pizzas View in this query is recommended.

	Hint:  The WHERE clause which determines if the pizzas are ready and if the order has been delivered must come before the GROUP BY clause which groups the results per order.
*/

-- Write Query 7 here





/*	Query 8 – Staff Workload (4 marks)
	Write a query that shows the full name of all staff members, the number of orders they have taken and the number of orders they have delivered.  
	Ensure that all staff members are included in the results, even those who have not taken or delivered any orders.  
	Order the results by the staff ID number.  Using the Staff View in this query is recommended. 

	Hint:  This query will require two OUTER JOINs, a GROUP BY clause and the COUNTing of DISTINCT order ID numbers.
*/

-- Write Query 8 here
