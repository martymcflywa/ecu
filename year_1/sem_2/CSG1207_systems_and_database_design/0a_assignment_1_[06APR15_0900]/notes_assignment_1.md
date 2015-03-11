# Task 1: Normalisastion

- Normalise table to 3NF
- Clearly show stages of
	- 0NF
	- 1NF
	- 2NF
	- 3NF
- State assumptions made
- Use relational symbolic notation as indicated in second lecture
- Name resultant data sets upon reaching 3NF

![task 1](http://snag.gy/2aQXA.jpg)

- Table is part of spreadsheet used by a taver which allows customers to book rooms for events and functions
- Each row represents a booking

## Tips

- There are several correct ways to normalise this data
	- Leads to almost identical solutions
- Columns may be added to serve as primary keys
	- Must be stated in assumptions
	- Include the column/s from the beginning of the work
- Only need to identify one repeating group
	- ie. R1 = (Outer group {Repeating group})

## Additional requirements

- For CSI5135
- Once 3NF, convert results into physical E-R diagram
- Indicate all cardinality, attributes, primary and foreign keys

## Assumptions

- The pub currently identifies customers by their phone number
- A room cannot have multiple bookings at the same time

## Normalisation

### 0NF

>R1 = (CustomerPhone, CustomerName, {Booking#, BookingDate, Duration, Room#, RoomName, RoomCapacity})

### 1NF

>~~R1 = (<ins>**CustomerPhone**</ins>, CustomerName, {<ins>**Booking#**</ins>, BookingDate, Duration, Room#, RoomName, RoomCapacity})~~  
R11 = (<ins>**CustomerPhone**</ins>, CustomerName)  
R12 = (<ins>**Booking#**</ins>, BookingDate, Duration, Room#, RoomName, RoomCapacity, *CustomerPhone*)

### 2NF

No partial dependencies, already 2NF.

>R11 = (<ins>**CustomerPhone**</ins>, CustomerName)  
R12 = (<ins>**Booking#**</ins>, BookingDate, Duration, Room#, RoomName, RoomCapacity, *CustomerPhone*)

### 3NF

>R11 = (<ins>**CustomerPhone**</ins>, CustomerName)  
~~R12 = (<ins>**_CustomerPhone_**</ins>, <ins>**Booking#**</ins>, BookingDate, Duration, Room#, RoomName, RoomCapacity)~~  
R121 = (<ins>**Booking#**</ins>, BookingDate, Duration, *Room#*, *CustomerPhone*)  
R122 = (<ins>**Room#**</ins>, RoomName, RoomCapacity)

### Named relations

>Customer = (<ins>**CustomerPhone**</ins>, CustomerName)  
Booking = (<ins>**Booking#**</ins>, BookingDate, Duration, *Room#*)  
Room = (<ins>**Room#**</ins>, RoomName, RoomCapacity, *CustomerPhone*)

# Task 2: Advanced Normalisation

![task 2](http://snag.gy/Sflhq.jpg)

- Normalise table to 3NF
- Clearly show stages of
	- 0NF
	- 1NF
	- 2NF
	- 3NF
- State assumptions made
- Use relational symbolic notation as indicated in second lecture
- Name resultant data sets upon reaching 3NF

## Additional requirements

- For CSI5135
- Once 3NF, convert results into physical E-R diagram
- Indicate all cardinality, attributes, primary and foreign keys

## Assumptions

- The store identifies customers by their email address
- Each item is only in one category
- Item Codes are unique per item, even if the items are in different categories
- Invoice header and footer is static and is not stored on the database

## Normalisation

### 0NF

>R1 = (CustEmail, CustName, CustPhone, DeliveryAddress, DeliveryInstructions, {Invoice#, InvoiceDate, {ItemCode, ItemName, CatCode, CatName, Cost, Qty}})

### 1NF

>~~R1 = (<ins>**CustEmail**</ins>, CustName, CustPhone, DeliveryAddress, DeliveryInstructions, {<ins>**Invoice#**</ins>, InvoiceDate, {<ins>**ItemCode**</ins>, ItemName, CatCode, CatName, Cost, Qty}})~~  
R11 = (<ins>**CustEmail**</ins>, CustName, CustPhone, DeliveryAddress, DeliveryInstructions)  
R12 = (<ins>**Invoice#**</ins>, InvoiceDate, *CustEmail*)  
R13 = (<ins>**_Invoice#_**</ins>, <ins>**ItemCode**</ins>, ItemName, CatCode, CatName, Cost, Qty)

### 2NF

>R11 = (<ins>**CustEmail**</ins>, CustName, CustPhone, DeliveryAddress, DeliveryInstructions)  
R12 = (<ins>**Invoice#**</ins>, InvoiceDate, *CustEmail*)  
~~R13 = (<ins>**_Invoice#_**</ins>, <ins>**ItemCode**</ins>, ItemName, CatCode, CatName, Cost, Qty)~~  
R131 = (<ins>**_Invoice#_**</ins>, <ins>**_ItemCode_**</ins>, Qty)  
R132 = (<ins>**ItemCode**</ins>, ItemName, CatCode, CatName, Cost)

### 3NF

>R11 = (<ins>**CustEmail**</ins>, CustName, CustPhone, DeliveryAddress, DeliveryInstructions)  
R12 = (<ins>**Invoice#**</ins>, InvoiceDate, *CustEmail*)  
R131 = (<ins>**_Invoice#_**</ins>, <ins>**_ItemCode_**</ins>, Qty)  
~~R132 = (<ins>**ItemCode**</ins>, ItemName, CatCode, CatName, Cost)~~  
R1321 = (<ins>**ItemCode**</ins>, ItemName, *CatCode*)  
R1322 = (<ins>**CatCode**</ins>, CatName)

### Named relations

>Customer = (<ins>**CustEmail**</ins>, CustName, CustPhone, DeliveryAddress, DeliveryInstructions)  
Invoice = (<ins>**Invoice#**</ins>, InvoiceDate, *CustEmail*)  
InvoiceItem = (<ins>**_Invoice#_**</ins>, <ins>**_ItemCode_**</ins>, Qty)  
Item = (<ins>**ItemCode**</ins>, ItemName, *CatCode*)  
Category = (<ins>**CatCode**</ins>, CatName)

## Task 2

You have been hired to design a database system for a pizza store. The database must encompass the customers, staff, pizza details, and the pizza orders made by customers. You have the following information about the way the store operates:

### Attributes

- Customer
	- Notes
		- Customer details are recorded when they make first order
	- Attributes
		- CustID
		- CustName
		- CustAdrs
		- CustEmail
- Staff
	- Attributes
		- StaffID
		- StaffFirstName
		- StaffSurname
		- StaffDOB
		- StaffPhone
- CustomerOrder
	- Notes
		- Each order can contain multiple pizzas
	- Attributes
		- CustOrderID
		- CustOrderDate
		- CustOrderTime
		- *CustID*
			- Who ordered the pizza
		- *StaffID*
			- Who took the order
- PizzaOrder
	- CustomerOrder and PizzaType intermediary
	- Attributes
		- PizzaOrderID
		- *CustOrderID*
		- *PizzaTypeID*
		- *PizzaCrustID*
		- *PizzaSauceID*
		- PizzaReady
			- Boolean
			- Default N
- PizzaType
	- Notes
		- Does this need to go in PizzaOrder?
	- Attributes
		- PizzaTypeID
		- PizzaName
		- PizzaDesc
		- PizzaPrice
- PizzaCrust
	- Notes
		- Must be chosen when ordering
	- Attributes
		- PizzaCrustID
		- PizzaCrustName
- PizzaSauce
	- Attributes
		- PizzaSauceID
		- PizzaSauceName
- Other requirements
	- Database must track which pizzas were ordered in which orders
		- Auto-incrementing ordered pizzaID
		- FK identifying the order that this pizza is part of
		- FK identifying which pizza was chosen
		- FK identifying which sauce was chosen

### Assumptions

- A customer must order at least one pizza to exist on database
- Some staff may not take any CustomerOrders
- A CustomerOrder must contain at least one PizzaOrder
- A PizzaOrder must include one PizzaType selection
- A PizzaOrder must include one PizzaCrust selection
- A PizzaOrder must include one PizzaSauce selection

### Logical ER

![pizza LER](http://snag.gy/0QQZX.jpg)

### Physical ER

![pizza PER](http://snag.gy/4AMtc.jpg)
