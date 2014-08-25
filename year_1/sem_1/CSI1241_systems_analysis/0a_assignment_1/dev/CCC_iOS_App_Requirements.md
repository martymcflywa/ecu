# Functional requirements

## Client requirements

- Client must be able to browse the services provided by CCC
- Client must be able to request their sample be destroyed and cancel their storage plan with CCC
- Client must be able to view the status of their sample
- Client must be able to securely view and pay invoices via credit card

### Client billing and payment

- Client must be able to select to either pay annual invoices, or through direct debit, with quarterly instalments
- Client must receive annual invoices at least one month before due date
- Invoices must display the following information when issued to the client
	- Company name
	- Company address
	- Company ABN
	- Invoice date
	- Invoice number
	- Client name
	- ClientID
	- SampleID
	- Invoiced items
	- Item price
	- Invoice total

## Employee requirements

- Employee must be able to log in with their associated user account, which is created by the Lab Manager
- Client Account manager must be only able to search and view client data records
- Laboratory Technicians must be only able to search and view sample data and sample location records
- Laboratory Managers must be only able to search and view the internal auditory system data records
- The iOS application must interface with CCC's internal auditory system and record the following data when a client or sample data record is accessed by any employee account type
	- Employee account name
	- Access date
	- Access time

# Non functional requirements

- iOS application must be developed using Corona SDK
- Credit card payment is only accepted via MasterCard or Visa
- Sample destruction process must adhere to Australian Standard for disposal of biological samples
- Samples in transit must be stored in a cryo-shipping container provided by CCC which are uniquely marked with a barcode
- The iOS application must provide encapsulation for both user types:
	- A client account type must not be able to access employee functions
	- An employee account type must not be able to access client functions

# Assumptions

## Client assumptions

### Registration

- Client registration is assumed to occur outside of the application on CCC website
- Client registration is assumed to create data records for the client that can be utilised by the iOS application
- Client registration is assumed to be recorded by CCC's internal auditory system

### Sample destruction

- It is assumed that rather than emailing clients a link to a secure form requesting sample destruction, as outlined in the case study, the secure form will be issued to the customer from within the iOS application where it can be completed

### Sample status

- Sample data records are assumed to contain fields that indicate the physical and testing status of client samples

### Billing and payment

- It is assumed that there is no GST component in the invoice
- It is assumed that invoices are only generated and issued electronically
- It is assumed that clients are warned if their payment is overdue and sample is to be destroyed
- It is assumed that clients are notified when sample is destroyed for non payment
- It is assumed that refunds are processed externally from the proposed iOS application
- It is assumed that refund of pro-rata annual fee is also provided to clients after requesting their sample to be destroyed and cancelled their storage plan

## Employee assumptions

- It is assumed that roles are specified within employee user accounts as they are created by the Laboratory Manager
- It is assumed that access to data records within the iOS application by employees is read-only

## Data record assumptions

### Client data records

- Client data records are assumed to be stored in a database and contain the following fields
	- Personal details
		- Name
		- Mailing address
		- Email
		- Age / DOB
		- Gender
		- Phone number
	- Trustee details
		- Name
		- Mailing address
		- Email
		- DOB (to verify identity)
		- Phone number
	- Invoice details
		- Balance
		- Invoice history
		- Current invoice due date
		- Instalment plan (where applicable)
	- Sample collection details
		- Requested pickup time / date
		- Pickup location
		- Courier authorised to transport sample
		- Cryo-shipping container barcode number

## Application assumptions

- It is assumed that the iOS application will be developed as a "Universal app", so that it may also compatible with iPads and other iOS devices

### Sample data records

- Sample data records are assumed to be stored in a database and contain the following fields
	- Test status
		- Initial sample
		- Waiting to be tested
		- Test pass / fail
	- Physical status
		- In transit to CCC
		- In storage at CCC
		- In transit to client
		- Delivered to client
		- Destroyed
	- Identification and location
		- Date of storage
		- FacilityID
		- FridgeID
		- CSC Number
		- CSC Matrix position
	- Medical information
		- Test log

### Internal auditory functions

- CCC's interal systems are assumed to record the following actions into a database
	- Data record creation
	- Data record modification
	- Data record access
	- Data record deletion
- It is assumed that Laboratory manager functions to create new employee users are performed externally from the proposed iOS application

# Out of scope

- Generate printed invoices
- Interfacing with bank/s to generate refunds
- Track shipping
- Access requirements for employees that are not Client Account Managers, Lab Technicians and Lab Managers
- The monitoring of storage climates and temperatures
- The development of the application on the Android platform
- The development of the application on desktop environments ie. Windows/OSX
- Modification of CCC's existing systems and processes