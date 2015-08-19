# Time

## Objectives

- Time planning processes and outputs
- Estimation techniques
- Schedule development

## How good or bad are we at estimation?

- For those of you who have written a program before
	- Think of the best and worst scenario
		- How close was your best attempt compared to your initial attempt
		- How bad was your worst?

## Importance of project schedules

- Managers often cite delivering projects on time as one of their biggest challenges
	- Schedule issues are the main reason for conflicts on projects
		- Especially during the second half of projects
	- Time has the least amount of flexibility
		- It passes no matter what happens on a project

## Estimation techniques

- Guesstimating
- Top down
- Bottom up
- Analogous estimates
	- Past experience
- Delphi technique
- Software engineering approaches
- Time boxing
	- Agile method

### Guesstimating

- Based on feeling not facts
- Not a good method for estimating
	- But often used by inexperienced project managers

### Top down

- Top and middle managers determine overall project schedule
- Lower level managers are expected to break down schedule / budget into specific activities
	- WBS
- Often couched in terms of what a project **should** cost and how long it **should** take as decreed by a member of top management
- May be a political response rather than a realistic one
	- But sometimes projects have to meet deadlines in the business environment
		- ie. Government set the date for GST

### Bottom up

- Most common form of project estimation
- Schedules and budgets are constructed from the WBS
- Starts with people who will be doing the work
- Schedules and budges are the aggregate of detailed activities and costs

### Analogous estimating

- Based on similarity between current projects and others
- Use information from previous similar projects as a basis for estimation
- Why is this problematic for software development?

### Delphi technique

- Very effective but very expensive
- Involves multiple anonymous experts
- Each expert makes an estimate
- Estimates compared
	- If close, can be averaged
	- Else do another iteration until consensus is reached

### Software engineering approaches

- Lines of code (LOC)
- Function point analysis
- COCOMO

#### Lines of code (LOC)

- An often used metric for determining size of the project
- But it is the most controversial
	- Count comments?
	- Count declaring variables?
	- Efficient code vs. code bloat
	- Language differences
	- Easier to count afterwards than estimate before programming begins

#### Function point analysis

- Independent of the technology
- [IFPUG](http://www.ifpug.org) standards
- 5 primary elements of varying complexity
	- Inputs
	- Outputs
	- Inquiries
	- Internal logical files
		- ie. Each entity in an ERD
	- External interface file
- Adjustment for system characteristics

#### What do function points mean?

- A measure of system size
- Transform into development estimates
	- ie. A programmer can produce x function points per week/month
- Requires commitment to metric collection over time
- Comparison between organisations

#### COCOMO

- COCOMO computes software development effort and cost as a function of program size
	- Program size is expressed in estimated thousands of source lines of code (SLOC)
- COCOMO applies to three classes of software projects:
	- **Organic projects**
		- Small teams
		- Good experience
		- Less than rigid requirements
	- **Semi detached projects**
		- Medium teams
		- Mixed experience
		- Less than rigid requirements
	- **Embedded projects**
		- Developed within a set of **tight** constraints
		- Combination of organic and semi detached projects
			- Hardware, software, operational

### What is the best way to estimate IT projects

- Use more than one technique for estimating
- If estimates from different techniques is close, average them
- Adjust estimate based on experience
- Negotiations may lead to unrealistic estimations

### Project time management as defined in PMBOK

- Project time management
	- Involves the processes required to ensure timely completion of a project
		- Activity definition
		- Activity sequencing
		- Activity duration estimation
		- Schedule development
		- Schedule control

#### Creating the activity definition

- Activity list
	- From WBS
	- Tabulation of activities to be included on a project schedule
- Activity attributes
	- Further info for WBS dictionary
	- Provides schedule related information about each activity, such as
		- Predecessors
		- Successors
		- Logical relationships
		- Leads and lags
		- Resource requirements
		- Constraints
		- Imposed dates
		- Assumptions related to the activity

#### Creating a milestone list

- A milestone is a significant event in a project
- It often takes several activities and a lot of work to complete a milestone
	- But the milestone itself is like a marker to help identify necessary activities
- There is usually no cost or duration for a milestone
- Project sponsors and senior managers often focus on major milestones when reviewing projects
- Sample milestones for many projects include
	- Sign off on key documents
	- Completion of specific products
	- Completion of important process related work
		- ie. Awarding a contract to a supplier

#### Activity sequencing

- Determining the relationships or dependencies between activities
- A dependency or relationship relates to the sequencing of project activities or tasks
	- For example, does a certain activity have to be finished before another one can start?
	- Can the project team do several activities in parallel?
	- Can some overlap?
- Activity sequencing has a significant impact on developing and managing a project schedule

#### Network diagrams

- Network diagrams are the preferred technique for showing activity sequencing
	- Network diagramming techniques
		- **Precedence diagramming method (PDM)**
			- Activities are represented by boxes
				- These are now more widely used
		- **Activity-on-arrow (AOA)** approach, or **arrow diagramming method (ADM)**
			- Activities are represented by arrows
			- Connected at points called **nodes**
			- Starting and end point of an activity to illustrate sequence

#### AOA diagram

![aoa diagram](http://snag.gy/6wfQW.jpg)

### Discrete, range and three point estimates

- **Duration estimates**
	- Often provided as discrete estimates
	- ie. Four weeks
- **Range estimate**
	- Between two dates
	- ie. Between three and five weeks
- **Three point estimates**
	- Includes three estimates
		- Optimistic
			- ie. Three weeks
		- Most likely
			- ie. Four weeks
		- Pessimistic
			- ie. Five weeks

### Program evaluation and review technique (PERT)

- Program evaluation and review technique (PERT)
	- Network analysis technique used to estimate project duration when there is a high degree of uncertainty about the individual activity duration estimates
- **PERT weighted average:**

>optimistic time + 4 * most likely time + pessimistic time / 6

- PERT example:

>1 workday + 4 * 2 workdays + 9 workdays / 6 = 3 workdays

- Instead of using the most likely time of two work days for this task, you would use three workdays with a PERT estimate

## Schedule development

- Schedule development
	- Uses the results of all the preceding estimation to determine the start and end dates of all project activities
- The project schedule
	- Is often shown on Gantt chart
		- Listing project activities and their corresponding start and finish dates in a calendar format
- The ultimate goal of schedule development is to create a realistic project schedule that provides a basis for monitoring project progress for the time dimension of the project

### Sample project schedule

![sample project schedule 1](http://snag.gy/V4A1O.jpg)

![sample project schedule 2](http://snag.gy/QUlrG.jpg)

### Adding milestones

- Many people like to focus on meeting milestones
	- Especially for large projects
- Milestones emphasize important events or accomplishments in projects
- You typically create a milestone by entering tasks that have a zero duration
	- Or can mark any task as a milestone

### Sample tracking gantt chart

![sample tracking gantt chart](http://snag.gy/69Lzd.jpg)

## Critical path analysis

- Critical path method (CPM), also called critical path analysis
	- Network diagramming technique used to predict total project duration
- A critical path for a project is the series of activities that determine the **earliest** time by which the project can be completed
	- It is the **longest** path through the network diagram and has zero slack or float
		- **Slack** or **float**
			- The amount of time an activity may be delayed without delaying a succeeded activity or project finish date
- The longest path or the path containing the critical tasks is what is driving the completion date for the project

### Critical path calculation

![critical path calculation](http://snag.gy/xznWc.jpg)

### What does the critical path really mean?

- The critical path shows the shortest time in which a project can be completed
- If one or more activities on the critical path takes longer than planned
	- The whole project schedule will slip unless the project manager takes corrective action
- Apple Computer team members put a stuffed gorilla on top of a cubicle of whoever was in charge of a critical task
	- So they would not distract the person

### More on critical path

- The critical path does not necessarily contain all **critical** activities
	- It only accounts for time
- There can be more than one critical path if the lengths of two or more paths are the same
- The critical path can change as the project progresses

### Using critical path analysis to make schedule trade-offs

- It is important to know what the critical path is throughout the life of a project
	- So that the project manager can make trade-offs
- If one of the tasks on the critical path is behind schedule
	- Should the schedule be renegotiated with stakeholders?
	- Or should more resources be allocated to other items on the critical path to make up for that time?
- It is also common for project stakeholders to want to shorten project schedule estimates
	- So you need to know what tasks are on the critical path

## Schedule compression techniques

- Crashing
	- Technique for making cost and schedule trade-offs
	- To obtain the greatest amount of schedule compression for the least incremental cost
		- ie. If two critical tasks each take two weeks
			- It will take $100 to shorten Task 1 by a week
			- It will take $1000 to shorten Task 2 by a week
				- Shorten Task 1
- Fast tracking
	- Involves doing activities in parallel that normally would occur in sequence
		- ie. Instead of waiting for Task 1 to be completed before starting Task 2
			- Start Task 2 when Task 1 is halfway done
- Schedule compression often backfires by causing the following problems, and lead to even longer schedules
	- Cost
	- Human resource
	- Quality problems
