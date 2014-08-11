# Requirements

## Requirements Elicitation

>Sommerville and Sawyer (1997)

Is the process of discovering the requirements for a system by communicating with:

- Customers
- Systems users
- Others who have a stake in the system development

## Requirements Engineering Process

>Sommerville (2004)

![requirements engineering process](http://i.imgur.com/nXnyL2l.png)

## What is Specification

>Bruegge and Dutoit (2003)

- Definition of the system in terms understood by the customer
- Determine and capture the purpose of a system
- Definition of the system boundary (scope)
	- What is inside
	- What is outside
	- Specification of the system's capabilities
		- Functional
		- Non functional
		- May be captured in a variety of notations or approaches

### Requirements Elicitation

- Not for the faint-hearted
- A challenging activity
- Requires collaboration of people with different backgrounds
	- User with application domain knowledge
	- Developer with implementation domain knowledge
- Bridges the gap between client and analyst

### How to Perform Requirements Elicitation

>http://www.requirements.com

- Brainstorming
- Document analysis (review existing documentation)
- Focus groups
- Interface analysis (review existing interfaces)
- Interviews
- Observation
- Prototyping
- Requirements workshops
- Surveys / questionnaires

## How to Document Requirements

>http://www.requirements.com

- A requirements specification will describe requirements in a list form, but may also include:
	- Diagrams
	- Use cases
	- User stories
	- Prototypes

### Potential Problems with Requirements

>Sommerville (2004)

- Stakeholders don't know what they really want
- Stakeholders express requirements in their own terms
- Different stakeholders may have conflicting requirements
- Organisational and political factors may influence the system requirements
- Requirements change during analysis process

### IEEE Definition of Requirements

- The IEEE 610 standard defines a requirement as:
	1. A condition or capability needed by a user to solve a problem or achieve an objective
	2. A condition or capability that must be met or possessed by a system or system component to satisfy a contract, standard, specification or other formally imposed documents
	3. A documented representation of a condition or capability

### IEEE Desirable Properties of Requirements

- Correct
- Verifiable
- Testable
- Complete
- Traceable
- Unambiguous

## Types of Requirements

### Functional Requirements:

Describes the interaction between the system and its environment independant from implementation. What the system is supposed to **do**.

- Write what is to be done, not how to do it
	- **Yes:** The student can select a unit
	- **No:** The student clicks the OK button to choose a unit
	- Making too many assumptions when describing how it is done in a requirement
	- Write requirement in non technology dependent way
- Use a template sentence structure that captures the following elements:
	- The user
	- The capability
	- The object
	- The qualifier (optional)
- Functional requirements describe the behaviour of the system as it relates to the system's functionality

>- The warehouse manager (user) must be able to create (capability) an incoming stock record (object) any time within standard business hours (qualifier)
	- *What is standard business hours?*
- The watch system must display the time based on its location
	- *What is the method of determining location?*
- When a vat sensor records that the temperature is above specified limits, the system must shut the vat down
	- *What is the unit of measure?*
	- *What is the limit?*
	- *What if the vats are in series? What is the repercussion of shutting down one vat if multiple vats are onsite*
- The system will record pressure readings and store them for 72 hours
	- *What is the unit of measure?*
	- *Why 72 hours?*
	- *How often are readings provided?*
	- *What happens at 72 hours + 1 reading? Are previous reads destroyed?*

### Non Functional Requirements

Defines how a system is supposed to **be**. It specifies a property of the system, not what the system is intended to do. Could be constraints or limitations imposed by customer for implementation.

- Non functional requirements are often constraints such as:
	- Environment
		- Hardware
		- Software
		- Programming language
	- Availability
		- Business hours
		- 24/7
	- Quality
		- Maintainability
		- Reliability
		- Portability
	- Security
		- User accounts
	- Performance criteria
		- Loading times
		- Close order within one hour
		- Measuring time
	- Conformance to standards
		- Must follow AS3563
		- Software standards

>- The system must use a 512 bit public key cryptosystem
- The system must be available 24/7
- The system must be programmed in C#
- Any quality criteria

## How to Identify Non Requirements

- Requirements must be provable or testable
- What do you think about the following:
	- The system must have an easy to use user interface
		- Can't test or prove
		- "Easy to use" too personal
		- Not a requirement 
	- The web pages must load in under 500ms
		- Measurable constraint
		- Non functional requirement
	- The system must be secure
		- Security
		- Who can / cannot access
		- Needs more detail
		- Non functional requirement
	- The system will log out when a user leaves the computer idle
		- Security
		- Needs more detail
		- Functional requirement
- *They're too broad, must be more specific*

### Examples of FR / NFR

- The system must send an email whenever an order is placed
	- *Functional*
- The vehicle tracking system must measure the vehicle speed with a precision of ± 0.1ms
	- *Non functional*
- The system shall support one currency, specifically AUD
	- *Non functional*
- When placing a new order, the system shall display the total cost and require confirmation from the user
	- *Functional*
- The system will be responsive to the user
	- *Nothing*
	- Unable to test / validate
	- What is the definition of responsive
	- Needs measurement of time
- The system will conform to ISO27799
	- *Non functional*

## Review

- Define the following:
	- Functional requirement
		- Describes the interaction between the system and its environment independant from implementation.
	- Non functional requirement
		- Defines how a system is supposed to be. It specifies a property of the system, not what the system is intended to do.
		- Also could be constraints or limitations imposed by customer for implementation.
	- Requirements elicitation
		- Is the process of discovering the requirements for a system by communicating with:
			- Customers
			- Systems users
			- Others who have a stake in the system development
	- Requirements validation
		- Must be able to verify, test and trace requirement from document
	- Requirements specification
		- Definition of the system in terms understood by the customer
		- Determine and capture the purpose of a system
		- Definition of the system boundary (scope)
			- What is inside
			- What is outside
			- Specification of the system's capabilities
				- Functional
				- Non functional
				- May be captured in a variety of notations or approaches
- Are functional requirements more important than non functional requirements
	- They are both as important as each other
	- Functional defines what the system does
	- Non functional defines what the system is
	- Both provide picture of system as a whole, and if one is missing, can only see half the picture
- How do you know when (and if) you have captured enough requirements
	- FURPS/FURPS+
	- Need to find out
- Can a system behave correctly (according to the requirements) but still have an unhappy customer
	- Yes, stakeholders don't always know what they really want