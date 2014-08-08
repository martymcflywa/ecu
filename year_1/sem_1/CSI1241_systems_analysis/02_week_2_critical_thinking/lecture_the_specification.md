# The Specification

## Introduction

- While unit is concerned with systems analysis techniques rather than project management or software engineering, it is important to understand the context and connections
- This lecture will identify the requirments for the assignment

## Feasability Study

At some earlier stage, before *proper* systems analysis begins, a feasibility study would usually have been conducted. The trigger for this may have been a user request or the company may have a plan containing a list of systems that need to be developed.

### What is a Feasibility Study

- A feasibility study is an analysis of the feasibility of a proposed information system
- It attempts to establish whether a system is considered worthwhile to be implemented
- It could be considered as a *first pass* systems analysis exercise that pays particular attention to:
	- Feasibility
	- Costs
	- Benefits
	- Risks
	- Timescales
- Focuses less on the detailed design

### Feasibility Report

- The feasibility report is presented as a business casae to management for acceptance or rejection
- If accepted, the systems analyst has a document to work with
- This report is usually at a very high business level but will sketch general directions and expectations about the system
- The systems analysis phase then becomes a process of confirming or modifying the feasibility study by elaborating the initial recommendations into a detailed specification of the system

### Scope / Domain of Change

- The feasibility will have outlined the scope of the new system
- Sometimes the term *domain of change* is used to refer to those aspects that will change from the existing system (if there is one) and new
- Essentially this is a case that is being put to the business, not just a statement of what processes will change
- It is a discussion with recommendations of what the implications and consequences to the business in terms of:
	- Costs
	- Benefits
	- Strategy
	- People's time
	- Job statisfaction
	- etc.

## Costs and Benefits

- The feasibility study will have made an initial attempt to quantify costs and benefits
- Systems analyst will further examine in much more detail so the *requirements specification* should be a more thorough report

### Costs

- Non-recurring costs
	- Development costs
	- Cost of new hardware / software
- Recurring costs
	- Running costs
		- Support staff
	- Consumables
		- Paper
		- Electricity
	- Maintenance contracts
		- Hardware
		- Software
		- Support
- Intangible costs
	- Stress on staff
	- Politics

### Benefits

- Service benefit
	- Customer can make orders quicker
- Cost avoidance benefit
	- Time taken to process an order is reduced by 50%
- Revenue benefit
	- The new system will increase the order sales by 10%
		- Make sure revenue benefits do not overlap others
- Intangible benefit
	- Effect on staff morale

## Specific Models

- Logical models have been described as relatively abstract models
	- Better term is conceptual model
	- Emphasis is on what is being modelled
	- Does not have physical detail getting in the way
- Logical models are converted into physical models at some stage in development
	- Initially find and model objects
	- Objects are converted into relational tables to be implemented in a relational database

## Deliverables

- A deliverable is a tangible outcome of technique
	- It could be:
		- Diagrams
		- Programming code
		- Test data
		- Interview report
		- Documented decision
- An important characteristic of a deliverable is that it can be measured
- An independant observer can verify the task has been completed
	- Example:
		- Copied source code in a specific folder is a deliverable
		- A programmer stating that the program is complete is not

## The Specification

It is important to distinguish between requirements specification and systems specification. The end point in unit is systems specification.

### Requirements Specification

- Half way through systems analysis, a requirements specification is produced
	- It is more detailed than feasibility study, but less than systems specification
	- It is a good opportunity to get feedback from business that the work is on track
- Sub-sections are:
	- Executive summary
		- Highlights significant and interesting parts of the report
	- Background to the report
		- Statement of the history of the project
			- Who instigated it
			- Why
			- Who is completing the work
	- Recommended solution
		- Scope of the information system
		- Benefits
		- Costs
		- Timescales
		- Assumptions
	- Scope and objectives
		- Objectives define specific requirements of the information system
			- The order processing system must permit data entry of a standard order form onto computer
		- The scope of the system is the union of all objectives
			- Defines boundary
			- Defines limitations of an information system
	- Benefits
		- A more accurate set of benefits
			- Service cost
			- Cost avoidance
			- Revenue
			- Intagible benefits
	- Costs
		- A more accurate estimate
			- Recurring
			- Non recurring
			- Intagible costs
	- Timescales
		- A more accurate estimate
	- Assumptions
		- Taken from feasibility study but updated with any significant changes
		- Some assumptions may be clarified at this stage
	- Business rules
		- Business process workflows for new system
			- Use case diagrams
			- Elaborated use cases
	- User interface
		- Page design for each page in the website
		- Document design for each document in the website
	- Data requirements
		- Elementary data dictionary for all data items in new system
		- Composite data dictionary of all pages and documents required by new system

### Requirements Table

#### The IS's and IS NOT's

- The IS's are a list of all functional requirements
- Sometimes it is easier to say what is *not* included

#### The UNDECIDED Section

- Place requirements which are undecided here
- They need to be sorted out
- The requirements table is a working document so there is a need for an undecided section
- But by the end of the activity, there should be no grey areas

## Systems Specification

- Main difference is:
	- Requirements specification is an external view of the system
		- Suitable to be shown to users and managers at early stages to get confirmation
	- System specification uses same sub-sections as above
		- Adds further sub-sections to provide detailed internal view
		- Target audience is programmers
			- ie. Model of the database

### System Specification Sub-Sections

- Business rules
	- Object life histories for new system
	- State precedence map
	- Business rules diagram for each use case
- User interface
	- Navigation map
- Data requirements
	- Composite data dictionary definitions of all objects and entities described in system spec
	- Conceptual object model
	- Logical relational data model
- Non-functional aspects
	- Access (security)
	- Performance

## Review

- What are the three types of cost?
	- Recurring
	- Non recurring
	- Intangible
- What are the four types of benefits?
	- Service benefit
	- Cost avoidance benefit
	- Revenue benefit
	- Intangible benefit
- What is a deliverable?
	- A deliverable is a tangible outcome of technique
- What is a requirements table?
	- A working document that outlines:
		- What IS a **functional** requirement
		- What ISN'T a **functional** requirement
		- What is UNDECIDED as a **functional** requirement
- What is the essential difference between a requirements specification and a systems specification?
	- Requirements specification is an outside view
		- Target audience: Managers, users
	- System specification is an inside view
		- Target audience: Programmers