-- First let's create a database named salon and set it to be the currently active database.
CREATE DATABASE salon;
GO
USE salon;



-- This table will contain all of the data in a "flat file" format.
-- i.e. The format that it was in before being normalised, in the spreadsheet.
CREATE TABLE allData
(
	appointmentDate SMALLDATETIME NOT NULL,
	staffNum INT NOT NULL,
	staffName VARCHAR(50) NOT NULL,
	customerPhone VARCHAR(50) NOT NULL,
	customerName  VARCHAR(50) NOT NULL,
	appointmentDescription VARCHAR(50) NOT NULL
);

-- Now let's insert all of the unnormalised data into the allData table.
INSERT INTO allData
VALUES  ('2014-09-12 10:30', 3, 'Michelle Brooks', '0432 514 658', 'Cassie', 'Hot Rock Massage'), 
		('2014-09-12 10:30', 1, 'Patrice Clements', '0415 789 459', 'Barbara', 'Hot Rock Massage'), 
		('2014-09-12 11:00', 4, 'Sammie Oaks', '0421 577 844', 'Angelo', 'Tahitian Body Polish'), 
		('2014-09-12 01:00', 3, 'Michelle Brooks', '0432 514 658', 'Cassie', 'Exfoliating Facial'), 
		('2014-09-12 01:30', 3, 'Michelle Brooks', '0421 577 844', 'Angelo', 'Spa Manicure'), 
		('2014-09-13 10:30', 2, 'Jolene Walker', '0415 784 456', 'Susan', 'Scalp Massage'), 
		('2014-09-13 11:00', 2, 'Jolene Walker', '0468 549 234', 'Bazza', 'Pedicure');

-- While we don't have much data in this example, imagine if the spreadsheet contained the details of thousands of appointments...



-- Now we create the normalised version of the database...

-- Customer table.
CREATE TABLE customer
(
	customerPhone VARCHAR(50) NOT NULL,
	customerName  VARCHAR(50) NOT NULL,
	
	CONSTRAINT cust_pk PRIMARY KEY (customerPhone)
);

-- Staff table.
CREATE TABLE staff
(
	staffNum INT NOT NULL,
	staffName VARCHAR(50) NOT NULL,
		
	CONSTRAINT staff_pk PRIMARY KEY (staffNum)
);

-- Appointment table.
-- Note the compound primary key and the two foreign keys.
CREATE TABLE appointment
(
	appointmentDate SMALLDATETIME NOT NULL,
	staffNum INT NOT NULL,
	customerPhone VARCHAR(50) NOT NULL,
	appointmentDescription VARCHAR(50) NOT NULL,
	
	CONSTRAINT appt_pk PRIMARY KEY (appointmentDate, staffNum),
	CONSTRAINT staff_fk FOREIGN KEY (staffNum) REFERENCES staff(staffNum),
	CONSTRAINT cust_fk FOREIGN KEY (customerPhone) REFERENCES customer(customerPhone)
);



-- Now let's use the INSERT command with a subquery to copy data from the unnormalised allData table into our normalised tables.

-- First we select the customer details and put them into the customer table.
-- We use DISTINCT to make sure we only get each customer once.
-- The two columns we are selecting will go into the two columns of the customer table.
INSERT INTO customer
	SELECT DISTINCT customerPhone, customerName
	FROM allData;
	
-- We do the same for the staff details.
INSERT INTO staff
	SELECT DISTINCT staffNum, staffName
	FROM allData;
	
-- We don't need to include DISTINCT for the appointments, since every row is a different appointment.
-- We just need to make sure we get the appropriate columns in the correct order for the appointment table.
INSERT INTO appointment
	SELECT appointmentDate, staffNum, customerPhone, appointmentDescription
	FROM allData;


-- This technique is one way of converting a file of unnormalised data into a normalised database.
-- It gets more complicated if there are things such as auto-incrementing integers involved.
