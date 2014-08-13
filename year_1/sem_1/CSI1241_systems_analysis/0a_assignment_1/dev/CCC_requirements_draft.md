# Functional Requirements

## Client registration

- Client must be able to register their interest *online* and provide the following details when registering:
	- Name
	- Mailing address
	- Email
	- Age
	- Gender
	- Phone number
- Client must be shown terms and conditions and must be able to agree or disagree after registering
- Client must complete a **secure** online questionnaire to check whether the sample to be stored is at risk from various infectious diseases after agreeing to terms and conditions
- The system must create an online account for the client which is assigned a unique clientID if successfully registered
- System must notify client via email of second sample test results and advise whether or not their sample has been approved for storage
- Client must be able to add the following trustee details through their online acount once their test sample has been approved for storage
	- Trustee
		- Name
		- Mailing address
		- Email
		- DOB (for identification)
		- Phone number

## Client billing and payment

- Client must be able to pay via credit card for testing and storage fees and opt-in for direct debit of four equal installments when test is successful
- Annual and quarterly invoices must be issued by the system to client at least one month before due date
- Invoices must display the following when issued to the client
	- Company name
	- Company address
	- Company ABN
	- Invoice data
	- Invoice number
	- Client name
	- Client address
	- ClientID
	- SampleID
	- Invoiced items
	- Item price
	- Invoice total

## Client request to destroy sample

- The system must accept client or trustee requests via email to cancel and destroy the sample/s
- The system must respond to these cancellation requests via email which must include a link to a secure web form for client cancellation confirmation
- The system must alert employees that the cancellation form has been submitted to prompt destruction of sample

## Client refunds

- The system must refund the prorata annual fee to the client if their test sample is found to contain infectious disease/s and has been destroyed

## Sample collection and testing

- The system must record the following details when a sample is collected from the client
	- Name
	- Address
	- Requested pickup time/date
	- Courier firm authorised to transport sample
- Each sample collected must be assigned a unique identifier and will store the following data records associated with the sample's unique identifier (sampleID) in a searchable database:
	- Test status
		- Initial sample
		- Waiting to be tested
		- Test pass
		- Test fail
	- Physical status
		- In transit to CCC
		- In storage at CCC
		- In transit to client
		- Delivered to client
		- Destroyed
	- Identification and location
		- Date of storage
		- FacilityID (3 char)
		- CSC number
		- CSC position
	- Medical information
		- Test log
	- Account information
		- Linked clientID
		- Client details
- The system must record the following details to the sampleID when the sample arrives at one of CCC's facilities and transferred to a CSC:
	- Date of storage
	- FacilityID (3 char)
	- Fridge number
	- CSC number
	- CSC position
- Laboratory technicians must be able to log test results to the sampleID when testing for infectious diseases
- The system must alert employees if a sample is found to contain infectious diseases to begin the sample destruction process

## Internal system functions

- The system must record the following actions for auditory functions, which can only be accessed by Lab Manager
	- Data record creation
	- Data record modification
	- Data record access
	- Data record deletion
- The system must provide the Lab Manager the ability to create new staff users for staff that exist on CCC Human resources system

## Potential Requirements

- ~~The system must generate and send invoices to client *x* days before due date~~
	- See functional requirement **Client billing and payment**
- ~~The system must warn client if invoice is *x* days overdue and destruction of sample is imminent~~
	- Assumption
- ~~The system must advise client when sample is destroyed for overdue payment~~
	- Assumption

# Non Functional Requirements

- System must comply with Australian Privacy Principles
- The sample must be shipped in a cryo-shipping container marked by unique barcode while being delivered
- Medical information about client must be stored securely
- Sample destruction process must adhere to Australian Standard for disposal of biological samples
- Mobile development must use [Corona SDK](http://coronalabs.com/products/corona-sdk/)
- Credit card payments are only accepted via MasterCard or Visa
- Security requirements
	- Client account managers can only access
		- Client details
	- Lab technicians can only access
		- Sample data
		- Sample location data

# Assumptions

- Client registration only occurs online
- Invoices are generated and sent electronically
- Clients are warned if their payment is overdue and sample is to be destroyed
- Clients have grace period for late payment
- Clients are notified when sample is destroyed for late payment
- Refunds to client is via credit card reversal
- Refund is given to clients after cancelling their storage and requested their sample/s to be destroyed
- CCC Human Resources system already exists and assigns unique identifiers for each staff member

# Out of Scope

- Interfacing with external printhouse
- Refund process
- Shipping tracking
- Access requirements for employees that are not lab technicians or lab managers

# Questions

- Are invoices to be printed or sent electronically?
	- If printed, who prints? CCC or external printhouse?
- What are the business rules for invoices? 
	- How long does a client get to pay bill?
	- When should the invoices be sent?
	- How long overdue before sample/s destroyed? Is there grace period?
	- Do clients get warning before that happens?

# Record Prototype

- ClientID
	- Details
		- Name
		- Mailing address
		- Email
		- Age / DOB
		- Gender
		- Phone number
	- Trustee
		- Name
		- Mailing address
		- Email
		- DOB (for identification)
		- Phone number
	- Payment
		- Credit card
		- Invoices
		- Installment plan
- Sample ID
	- Test status
		- Initial sample
		- Waiting to be tested
		- Test pass
		- Test fail
	- Physical status
		- In transit to CCC
		- In storage at CCC
		- In transit to client
		- Delivered to client
		- Destroyed
	- Identification and location
		- Date of storage
		- Facility ID number (3 char)
		- CSC number
		- CSC position
	- Medical information
		- Test log