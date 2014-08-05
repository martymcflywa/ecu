# Gathering Requirements

*Notes taken from [lynda.com:](http://www.lynda.com/Programming-tutorials/Foundations-of-Programming-Object-Oriented-Design/96949-2.html) Foundations of Programming - Object Oriented Design*

- What is the application / system required to do? 
- What must it do?
- Define the scope, only add what the app / system **must** do
	- Nothing optional
	- Do not be exhaustive
- Requirements will change
- Start with bullet points

## Functional Requirements

- Features
- Capabilities
- Security

### Functional Requirements Examples

- Short, simple, succinct statements.
- System must...
- Application must...

>- System **must** display heart rate, temperature and blood pressure of a patient connected to the patient monitor.
- Application **must** allow user to search by customer's last name, telephone number or order number.
- Program **must** allow receipts receipts to be generated via email.

## Non-Functional Requirements

- Help
- Legal
- Performance
- Support
- Security (could also fall in this space)

### Non-Functional Requirements Examples

- Not a feature, but is something that is required

>- System must respond to searches within 2 seconds.
- Help desk should be available by telephone, Mon-Fri 8am-6pm.
- Comply with all relevant HIPAA regulations.
- Be available 99.99% of time during business hours.

## FURPS / FURPS+

FURPS / FURPS+ is a checklist to confirm all the requirements have been defined.

- **F** unctional requirements
	- The features of the app / system
- **U** sability requirements
	- Help, documentation, tutorials
- **R** eliability requirements
	- Disaster recovery, acceptable failure range, backup strategy
- **P** erformance requirements
	- Avaliability, capacity, resources
- **S** upportability
	- support other languages, cross platform
- **+** 
	- **Design** requirements
		- must be iphone app, must require relational database
	- **Implementation** requirements
		- which programming language, comply with standards or methodology
	- **Interface** requirements
		- interfacing with external system
	- **Physical** requirements
		- must ship with dvd, must run on device with camera

## Use Cases

### Understanding Use Cases

Write use cases in every day language. Keep it simple, no technical jargon.

- Title
	- What is the goal?
	- Short phrase, active verb
	- Examples:
		- Register new member
		- Transfer funds
		- Purchase items
		- Create new page
		- Collect late payments
		- Process accounts
- Actor
	- Who desires it?
	- Anything that lives outside the system / app but wants to accomplish something with it
	- Could be people or other systems
	- It could be:
		- User
		- Customer
		- Member
		- Administrator
		- Audit system
		- Printing service
		- HR system
- Scenario
	- How is it accomplished?
	- Short, succinct
	- Could be written as a paragraph
	- Could also be written as steps
	- Written in the perspective of the user

#### Scenario as Paragraph:

>Customer reviews items in shopping cart. Customer provides payment and shipping information. System validates payment information and responds with confirmation of order and provides order number that Customer can use to check on order status. System will send Customer a confirmation of order details and tracking number in an email.

#### Scenario as Steps:

>1. Customer chooses to enter the checkout process
2. Customer is shown a confirmation page for their order, allowing them to change quantities, remove items or cancel
3. Customer enters his/her shipping address
4. System validates the customer address
5. Customer selects a payment method
6. System validates the payment details
7. System creates an order number that can be used for tracking
8. System displays a confirmation screen to the Customer
9. Email is sent to the Customer with order details

#### Scenario Additional Details

- Describe steps for alternative flows
- Or when things go wrong
	- Steps for out-of-stock situations
	- Steps for order never finalized
	- Steps for payment problems
- Add precondition if applicable
	- Only occurs if customer added at least one item to shopping cart

### Identifying the Actors

- An actor is anything with behaviour who lives outside the system, but has a goal they want to accomplish with it.
- Each type of actor will have different goals when using the system.
- Does the system / app need to interact with other computer systems or organisations?
	- External data sources
	- Web services
	- Tax reporting
	- Backup systems
- For people, we need to distinguish the following (will prompt use cases)
	- Roles / Security groups
		- Visitor
		- Member
		- Administrator
		- Owner
	- Job Titles / Departments
		- Manager
		- Payroll Admin
		- Production Staff
		- Executive Team
		- Accounting
	- Might be able to simplify it to
		- Who requests
		- Who approves

### Identifying the Scenarios

- Stay focused on the user's **goal**
	- Purchase items
	- Create new document
	- Balance accounts
		- **Not** something like logging in, too specific
		- **Not** write book, too broad
- Omit needless words
	- Use active words
		- **NO:** The system is provided with the payment information and shipping information by the Customer
		- **YES:** Customer provides payment and shipping information
	- Do not give too much detail
		- **NO:** The system connects to the external payment processor over HTTPS and uses JSON to submit the provided payment information to be validated, then waits for a delegated callback response.
		- **YES:** System validates payment information
- Focus on intention
	- Keep user interface out of the scenario
	- Do not mention buttons, page, click, select, mouse etc.

#### Multiple Scenarios

- May need to extend with alternate paths
- As described above as "Additional Details"

### Use Case Prompts

- Who performs system administration tasks?
- Who manages users and security?
- What happens if the system fails?
- Who is looking at performance metrics or logs?

### Diagramming Use Cases

- Primary actors on the left
- System functions in the middle
- Secondary actors on the right
- Not usually referred to sequence
	- An overview of multiple actors interacting with the system at the same time

### Employing User Stories

- From user perspective
- Typically written as one or two sentences
	- Short and sweet
	- Focused on intention
	- No mention of user interface
	- Expresses one need
- Good for brainstorming use cases
- Format
	- As a...
		- Type of user
			- "Bank Customer"
	- I want...
		- Goal
			- "to change my PIN online" 
	- So that...
		- Reason
			- "I don't have to go into a branch"
