USE name_of_your_database;

/*	Query 1 – Pizza Menu (2 marks)
	Write a query that shows the range name, pizza name, pizza description and range price of all pizzas.  
	Order the results by range ID number, then pizza name.
*/

-- Write Query 1 here





/*	Query 2 – Customer Search (2 marks)
	Write a query that shows all details of customers with a name beginning with the letter “F” or “J”, and whose email address is at least 15 characters long.  
	Order the results by customer name.
*/

-- Write Query 2 here





/*	Query 3 – Unready Pizzas (2.5 marks)
	Write a query that shows the order date, pizza name, crust name and sauce name of any ordered pizzas which are not ready (ready column contains “N”).  
	Order the results by the order date.  Using the Ordered Pizzas View in this query is recommended.
*/

-- Write Query 3 here





/*	Query 4 – Popular Pizzas (3 marks)
	Write a query that that shows the names of the top three most ordered pizzas and the number of times they have each been ordered.  
	Using the Ordered Pizzas View in this query is recommended.
*/

-- Write Query 4 here





/*	Query 5 – Underage Supervisors (3 marks)
	Write a query that shows the name and age (in years) of any staff members who younger than 21 years old and are supervising at least one other staff member.  
	Using the Staff View in this query is recommended.

	Hint:  Use the DATEDIFF function to determine the age of a staff member from their date of birth, 
	and consider using a subquery and an IN comparison to determine if a staff member is supervising anyone.
*/

-- Write Query 5 here





/*	Query 6 – Pizza Order Summaries (3.5 marks)
	Write a query that shows the order ID number, order date, customer name, and total cost of all pizza orders.  
	Order the results by the order date, in descending order.  Using the Pizza Orders View and the Ordered Pizzas View in this query is recommended.

	Hint:  Use GROUP BY and SUM to group the results per order and calculate the total cost of the pizzas in each order.
*/

-- Write Query 6 here





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
