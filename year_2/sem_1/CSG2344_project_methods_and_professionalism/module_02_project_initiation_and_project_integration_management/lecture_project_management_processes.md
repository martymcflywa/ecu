# Project management processes

- What are the big lessons the IT industry has learned about software development?
- How do we organise a software project?

## Objectives

- Where SDLC processes fit into PM
- Project management processes
- Project integration management
- Project initiation
	- Prepare a business case for the project
	- Create the project charter
	- Develop a preliminary scope statement

## Review: Systems development lifecycles (SDLC)

- Characterised by different stages or phases
- A well defined phase has
	- A set of activities
	- A set of deliverables
	- A set of quality control measures
- Alternative lifecycles may structure the phases differently
	- Waterfall
	- Prototyping
	- Incremental
	- Extreme Programming
	- Spiral

## Generic SDLC phases

- Regardless of the lifecycle, certain activities must be done
	- Problem definition
		- Why
	- Analysis
		- What
	- Design
		- How
	- Implementation
		- How
	- Testing
		- How well

### Problem definition

>What is the problem or situation that has given rise to an information system being required?

- Definition of the problem in user terms
	- It is the user's problem?
	- Defining it helps the understanding
- What is the business case for solving the problem?
	- Information systems are expensive to develop
	- There are competing priorities for development
	- Justification of project

### Analysis

- The result of systems analysis is the requirements specification
- A contract between developer and user
	- A clear understanding of what the solution should provide
- What inputs the system will process
- What functions will it perform
- What outputs will be produced
- Response time / other performance requirements
- **What the system will do**

### Design

- A model of the whole system is developed which will solve the problem
- The model can be sub-divided
	- Data structure
	- Software architecture
	- Human interface
	- Algorithmic detail
- **How the solution will be implemented**

### Implementation (Coding)

- Refers to entering the solution in the code of the selected programming language
- Translate the design into executable programs
	- May include code generation
- All code must
	- Be written according to standards
	- Be fully documented
- May be constrained by the language / platform to be used

### Testing

- A variety of test activities performed at this stage to assure the quality of the product
- Unit test
	- Modules tested separately
		- Black box
		- White box
- Integration test
	- Modules tested in groups
- System test
- Acceptance test
	- By users
- Not strictly correct to show testing as a phase following code
	- Testing activities occur throughout the lifecycle

### Maintenance

- Keeping the software operational after it has been successfully installed
	- Fixing bugs
	- Changing functionality required by uers
	- Adapting the software for a new environment
	- Perfecting the structure of the code

### What else needs to be done: Project management

- The SDLC focuses on the software engineering phases, processes, tools and techniques for building the system
- Project management focuses on the project management phases, processes, tools and techniques for effectively managing the project
- In other words, there are many activities which are not software engineering activities but are **project management activities**

## Project management processes

>Process: A series of actions directed toward a particular result

- Initiating processes
	- Actions to begin projects
- Planning processes
	- Devising a workable scheme to ensure that the project meets its goal
- Executing processes
	- Coordinating people and other resources to carry out the project plans and produce deliverables of the project
- Monitoring and controlling processes
	- Measure progress towards achieving project goals
	- Monitor deviation from plans
	- Take corrective action to match progress with plans and customer expectations
- Closing processes
	- Formalizing acceptance of the project
	- Bring it to an orderly end

### Project processes summary

![project processes summary](http://i.imgur.com/eTfCeew.png)

### Project management knowledge areas

![knowledge areas](http://snag.gy/gXHi8.jpg)

### Key to overall project success

- Good project integration management
- Project managers must coordinate all of the other knowledge areas throughout a project's lifecycle
- Many new project managers have trouble looking at the **big picture** and want to focus on too many details

## Project integration management processes

- **Develop the project charter**
	- Working with stakeholders to create the document that formally authorizes a project
		- The charter
- **Develop the preliminary project scope statement**
	- Working with the following to develop the high-level scope requirements
		- Stakeholders
		- Users of the project's products / services / results
	- Create a preliminary scope statement
- **Develop the project management plan**
	- Coordinating all planning efforts to create a consistent, coherent document
		- The project management plan
- **Direct and manage project execution**
	- Carry out the project management plan by performing the activities included in it
- **Monitor and control the project work**
	- Overseeing project work to meet the performance objectives of the project
- **Perform integrated change control**
	- Coordinating changes that affect the project's deliverables and organizational process assets
- **Close the project**
	- Finalizing all project activities to formally close the project

## Project initiation

- Prepare a business case for the project
- Create the project charter
- Develop a preliminary scope statement

### Preparing a business case

- Successful organizations initiate projects to meet business needs
	- A common business need is to spend money wisely
- A business case is a document that provides justification for investing in a product
- It allows comparisons between potential projects

#### Contents of a business case

- Introduction / background
- Business objective
- Current situation and problem / opportunity statement
- Critical assumptions and constraints
- Analysis of options and recommendation
- Preliminary project requirements
- Budget estimate and financial analysis
- Schedule estimate
- Potential risks

### Ratio analysis

- This term comes from accountancy, where it is common practice for accounting to use ratios or percentages to gauge a company's performance in selecting capital projects such as computer projects
- In selecting a project, the ratios are those techniques which allow us to quantify the costs and benefits, ie
	- ROI
	- NPV

#### Concepts

- Present value of money
- Payback period
- Net present value
- Return on investment
- Internal rate of return

#### Present value of money

- The value of money changes over time
	- So the value of a dollar to a company today is greater than it will be in a year's time because of inflation
		- Positive inflation assumed
- In fact the difference is easily calculated by using the inflation rate
	- Although often in most calculations the same inflation rate is assumed throughout

![pv formula](http://snag.gy/6tRTG.jpg)

##### Example

- What will $1000 be worth in 5 years time assuming a discount (inflation) rate of 16%?

![pv example](http://snag.gy/OS48A.jpg)

#### Payback period

- This is simply how long it takes for the benefits to pay back the costs using present values
- This is done by charting out a table in which the benefits and costs are plotted on a yearly basis and then searching for the break even (BE) point

![payback period](http://snag.gy/PUMB2.jpg)

#### Costs and benefits

- When quantifying costs and benefits, it is usual to do this based on the **marginal** contribution
- The marginal contribution is the difference between
	- The total current costs and benefits
	- The total future costs and benefits
- For example
	- If you are shifting from a manual system to a computerized system
		- You will have current costs and benefits in the manual system
		- Current costs and benefits have to be taken away from any future costs and benefits

#### Net present value (NPV)

- Net present value (NPV) is simply
	- The sum of the net present benefits minus the sum of the net present costs over the life of the project
		- Note that costs are often incurred before the benefits arise
		- So the time value of money becomes important
- **If NPV is positive, the project is viable**

#### Return on investment (ROI)

- Return on investment is the percentage obtained from dividing the net present costs by the NPV
- For example
	- Net present benefit = 176474
	- Net present cost = 110551
	- ROI = (176474 - 110551) / 110551 = 60%

![roi formula](http://snag.gy/DxZXR.jpg)

#### Internal rate of return (IRR)

- Internal rate of return (IRR) is the average discount rate required to make the net costs equal to the net benefits
	- It can be worked out from ROI
- Suppose ROI was 60% and the life of the project was 5 years
	- IRR is 12%
- Companies usually have a minimum value for accepting projects
	- So if this was 15%, the project proposal would be rejected

![irr formula](http://snag.gy/bmNFn.jpg)

### The business case has been approved

- Who is the project manager
- Who is the project sponsor
- Who is on the project team
- What role does everyone associated with the project play
- What is the scope of the project
- What resources and technology will be required
- What approach, tools and techniques will be used to develop the information system
- What tasks or activities will be required to perform the project work
- How long will these tasks or activities take
- Who will be responsible for performing these tasks or activities

### Creating a project charter

- A project charter
	- Is a document that formally recognizes the existence of a project and provides a summary of the project's objectives and management
	- It authorizes the project manager to use organizational resources to complete the project
- A crucial part of the project charter is the sign off section

#### Contents of a project charter

- Project title and date of authorization
- Project start / end date
- Other schedule information
- Budget information
- Project manager
- Project objectives
- Approach
- Roles and responsibilities
- Sign off
- Comments

### Preliminary scope statement

- A **scope statement** is a document used to develop and confirm a common understanding of the project scope
- It describes in detail the work to be accomplished and is an important tool for preventing **scope creep**
	- The tendency for project scope to continually increase
- It is helpful to create a **preliminary scope statement** during project initiation so that the entire project team can start discussions and work related to the project scope
- There are usually several versions
	- Each one becomes more detailed as the project progresses and more information becomes available

#### Contents of a scope statement

- Contents and length will vary based on the project
- Typical contents include
	- Requirements and characteristics
	- A summary of all deliverables
	- The project success criteria
	- References to related documents

## Summary

- SDLC processes
- Project management processes
- Project integration management
- Project initiation
	- Prepare a business case for the project
	- Create the project charter
	- Develop a preliminary scope statement
