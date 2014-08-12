# Functional Requirements

- Client must be able to register their interest *online* and provide the following details when registering:
	- Name
	- Mailing address
	- Email
	- Age
	- Gender
	- Phone number
- Client must be shown terms and conditions and must be able to agree or disagree after registering
- Client must complete a *secure* online questionnaire to check whether the sample to be stored is at risk from various infectious diseases after agreeing to terms and conditions
- *Client must be assigned a unique account number when successfully registering*
- Client must be able to pay via credit card for testing and storage fees and opt-in for direct debit of four equal installments when test is successful
- The system must record the following details when a sample is collected from the client
	- Name
	- Address
	- Requested pickup time/date
	- Courier firm authorised to transport sample
- Each sample collected must be assigned a unique identifier and will store the following data records associated with the sample's unique identifier in a searchable database:
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
	- Account information
		- Linked client account number
		- Client details
- The system must record the following details to the sample's unique identifier when the sample arrives at one of CCC's facilities and transferred to a CSC:
	- Date of storage
	- Facility ID number (3 char)
	- Fridge number
	- CSC number
	- CSC position
- Laboratory technicians must be able to log test results to the sample's unique identifier when testing for infectious diseases
- The system must record the following actions for auditory functions, which can only be accessed by Lab Manager
	- Data record creation
	- Data record modification
	- Data record access
	- Data record deletion
- The system must provide the Lab Manager the ability to create new staff users for staff that exist on CCC Human resources system

## Potential Functional Requirements

- The system must generate and send invoices to customer *x* days before due date
- The system must warn customer if invoice is *x* days overdue and destruction of sample is imminent
- The system must advise customer when sample is destroyed

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

- Refund is via credit card reversal
- Customer registration only occurs online
- CCC Human Resources system already exists and assigns unique identifiers for each staff member

# Questions

- Are invoices to be printed or sent electronically?
	- If printed, who prints? CCC or external printhouse?
- What are the business rules for invoices? 
	- How long does a customer get to pay bill?
	- When should the invoices be sent?
	- How long overdue before sample/s destroyed? Is there grace period?
	- Do customers get warning before that happens?

# Remarks

- Need to find a way to determine if sample is initial, or second for testing

# Prototype object

- Client account number
	- Details
		- Name
		- Mailing address
		- Email
		- Age
		- Gender
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
		- Delivered to client
		- Destroyed
	- Identification and location
		- Date of storage
		- Facility ID number (3 char)
		- CSC number
		- CSC position
	- Medical information
		- Test log