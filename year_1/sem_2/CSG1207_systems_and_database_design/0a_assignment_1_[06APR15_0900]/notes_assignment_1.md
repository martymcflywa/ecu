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
R12 = (<ins>**_CustomerPhone_**</ins>, <ins>**Booking#**</ins>, BookingDate, Duration, Room#, RoomName, RoomCapacity)

### 2NF

No partial dependencies, already 2NF.

>R11 = (<ins>**CustomerPhone**</ins>, CustomerName)  
R12 = (<ins>**_CustomerPhone_**</ins>, <ins>**Booking#**</ins>, BookingDate, Duration, Room#, RoomName, RoomCapacity)

### 3NF

>R11 = (<ins>**CustomerPhone**</ins>, CustomerName)  
~~R12 = (<ins>**_CustomerPhone_**</ins>, <ins>**Booking#**</ins>, BookingDate, Duration, Room#, RoomName, RoomCapacity)~~  
R121 = (<ins>**_CustomerPhone_**</ins>, <ins>**Booking#**</ins>, BookingDate, Duration, *Room#*)  
R122 = (<ins>**Room#**</ins>, RoomName, RoomCapacity)

### Named relations

>Customer = (<ins>**CustomerPhone**</ins>, CustomerName)  
Booking = (<ins>**_CustomerPhone_**</ins>, <ins>**Booking#**</ins>, BookingDate, Duration, *Room#*)  
Room = (<ins>**Room#**</ins>, RoomName, RoomCapacity)

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

No transitive dependencies, already 3NF.

>R11 = (<ins>**CustEmail**</ins>, CustName, CustPhone, DeliveryAddress, DeliveryInstructions)  
R12 = (<ins>**Invoice#**</ins>, InvoiceDate, *CustEmail*)  
R131 = (<ins>**_Invoice#_**</ins>, <ins>**_ItemCode_**</ins>, Qty)  
R132 = (<ins>**ItemCode**</ins>, ItemName, CatCode, CatName, Cost)

### Named relations

>Customer = (<ins>**CustEmail**</ins>, CustName, CustPhone, DeliveryAddress, DeliveryInstructions)  
Invoice = (<ins>**Invoice#**</ins>, InvoiceDate, *CustEmail*)  
InvoiceItem = (<ins>**_Invoice#_**</ins>, <ins>**_ItemCode_**</ins>, Qty)  
Item = (<ins>**ItemCode**</ins>, ItemName, CatCode, CatName, Cost)