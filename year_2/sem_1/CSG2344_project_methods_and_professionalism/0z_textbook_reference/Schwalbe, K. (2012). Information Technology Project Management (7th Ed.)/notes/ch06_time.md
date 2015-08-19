# Project time management

## Project time management definition

- Involves the processes required to ensure timely completion of a project
- Seven main processes:

### Planning schedule management

- Determine
	- Policies
	- Procedures
- Used to do the following for the project schedule
	- Planning
	- Executing
	- Controlling
- Output
	- Schedule management plan

### Defining activities

- Identify specific activities that must be performed to produce deliverables
	- Activity or task
		- Found on WBS
		- Have expected
			- Duration
			- Cost
			- Resource requirements
- Output
	- Activity list
	- Activity attributes
	- Milestone list
	- Project management plan updates

### Sequencing activities

- Identify / document relationships between project activities
- Output
	- Project schedule network diagrams
	- Project document updates

### Estimating activity resources

- Estimate how many resources should be used to perform activities
	- People
	- Equipment
	- Materials
- Output
	- Activity resource requirements
	- Resource breakdown structure
	- Project documents updates

### Estimating activity durations

- Estimate the number of work periods required to complete individual activities
- Output
	- Activity duration estimates
	- Project documents updates

### Developing the schedule

- Analyze
	- Activity sequences
	- Activity resource estimates
	- Activity duration estimates
- To create project schedule
- Output
	- Schedule baseline
	- Project schedule
	- Schedule data
	- Project calendars
	- Project management plan updates
	- Project document updates

### Controlling the schedule

- Control / manage changes to project schedule
- Output
	- Work performance information
	- Schedule forecasts
	- Change requests
	- Project management plan updates
	- Project documents updates
	- Organisational process assets updates

## Planning schedule management

- Plan how the schedule will be managed throughout the life of the project
- Grow from basic documents that initiate the project
	- ie. Project charter mentions planned project start / end dates
- Review
	- Project management plan
	- Project charter
	- Enterprise environmental factors
	- Organisational process assets
- Tools
	- Expert judgement
	- Analytical techniques
	- Meetings
- Schedule management plan should include:

### Project schedule model development

- Contains
	- Project activities with estimated time durations
	- Dependencies
	- Other planning information that can be used to produce a project schedule

### Scheduling methodology

- Also include scheduling tools
- Which methodology will be used, ie.
	- Critical path
	- Critical chain
	- Focus on milestones

### Level of accuracy and units of measure

- How accurate schedule estimates should be
- What measure of time is used
	- ie. Days, weeks, months etc.

### Control thresholds

- Variance thresholds
	- ie. &plusmn;10% for monitoring schedule performance

### Rules of performance measurement

- Methods used to measure performance
	- ie. Earned value management (EVM)
- Specify how method will be used

### Reporing formats

- Describe the format and frequency of schedule reports

### Process descriptions

- Describe how all of the schedule management processes will be performed

## Defining activities

- Describe activities in more detail
- Identify specific actions to produce deliverables in enough detail to determine estimates
	- Resource
	- Schedule
- Goal
	- Ensure the team understands the work it must do as part of scope
	- So that scheduling can begin
- Review
	- Schedule management plan
	- Scope baseline
	- Enterprise environmental factors
	- Organisational process assets
- Output
	- Activity list
	- Activity attributes
	- Milestone list
	- Project management plan updates
- Activity info is a required input for other time management processes
	- Activity sequencing
	- Resources / durations
	- Develop schedule
	- Control schedule
- Order of triple constraint important:
	- Scope
		- Further define activities
	- Time
		- Sequencing activities
		- Estimate activity resources and duration
	- Cost
		- Estimate activity resources and duration
- Define in same order

### Activity list / activity attributes

- Activity list
	- Tabulation of activities to be included in project schedule
	- Includes
		- Activity name
		- Activity id
		- Brief description
- Activity attributes
	- Provide more schedule related information
	- Includes
		- Predecessors
		- Successors
		- Logical relationships
		- Leads and lags
		- Resource requirements
		- Constraints
		- Imposed dates
		- Assumptions
- Activity list and attributes must align with WBS and WBS dictionary
- Information is added to activity attributes as they become available
	- Such as
		- Logical relationships
		- Resource requirements
- Can use automated system to keep track of activity related info

### Milestones

- Significant event that has no duration
- Can take several activities and lots of work to complete a milestone
- Milestone is like a marker to help identify necessary activities
- Milestones are useful tools for
	- Setting schedule goals
	- Monitoring progress
- Milestones might be
	- Completion and customer sign off on key documents
		- Design document
		- Test plan
	- Completion of specific products
		- Software module
		- Installation of new hardware
	- Completion of process work
		- Project review meeting
		- Tests
- Not every deliverable is a milestone
- Milestones are most important and visible events

## Sequencing activities

- Sequence or determine dependencies of activities
- Inputs
	- Schedule management plan
	- Activity list / attributes
- Involves
	- Evaluating
		- Reasons for dependencies
		- Types of dependencies
- Important to define sequence of activities to enable scheduling tools
	- Network diagrams
	- Critical path analysis

### Dependencies

- Relates to sequencing of activities / tasks
	- Does a certain activity have to be finished before another can start
	- Can some activities be completed in parallel
	- Can some overlap
- Three basic reasons for creating dependencies among activities:

#### Mandatory dependency

- Inherent in nature of the work
- Sometimes called **hard logic**
- ie. Cannot test code until code is written

#### Discretionary dependency

- Defined by the project team
- ie. To follow good practice, detailed design work is not started until users sign off on analysis work
- Sometimes called **soft logic**
- Should be used with care
	- May limit later scheduling options

#### External dependency

- Involve relationships between project and non project activities
- ie. Installation of new OS depends on delivery of new hardware from external supplier
	- Even though delivery of hardware is out of scope, it should be added as external dependency since late delivery will affect project schedule

### Network diagrams

- Prferred technique for showing activity sequencing
- A schematic display of the logical relationships among project activities and their sequencing
- Also known as PERT charts

![aoa diagram](http://snag.gy/6wfQW.jpg)

- Example above:
	- Letters A through J represent activities with dependencies required to complete the project
	- Arrows represent sequencing or relationships between tasks
	- A must be done before D, D must be done before H
- Uses **activity on arrow (AOA)** (also called **arrow diagramming method (ADM)**)
	- Activities represented by arrows connected to nodes to illustrate sequence
	- A **node** is a starting and ending point for an activity
		- First node is the start of the project
		- Last node is the end of the project
- Every activity shown in network diagram must be completed in order to finish the project
- Not every item in WBS needs to be shown on network diagram
	- **Only those with dependencies**

#### Creating an AOA diagram

1. Find all activities that start at node 1
	- Draw their finish nodes
		- Draw arrows between node 1 and each of the finish nodes
	- Label the activity with a letter or name on the associated arrow
	- Write duration estimate next to label, if known
		- ie. A = 1 means duration is one defined standard unit of time
	- Arrow heads signify direction of relationship
2. Continue drawing diagram, left to right
	- Look for bursts or merges
		- **Burst**
			- Occurs when two or more activities follow a single node
			- Node 1 is a burst, it goes into multiple nodes
		- **Merge**
			- Occurs when two or more nodes precede a single node
			- Node 5 is a merge, it is preceded by node 2 and 3
3. Continue drawing diagram until all activities are included
4. Rules of thumb
	- All arrowheads should face to the right
	- No arrows should cross
	- Redraw to make it look presentable

#### Precedence diagramming method (PDM)

- Boxes represent activities
- Useful for visualising certain types of time relationships
- After determining reason of dependency
	- Determine type of dependency

![pdm](http://www.stakeholdermap.com/plan-project/project-dependencies.png)

##### Task dependencies

- Nature of the relationship between two linked tasks
- Defines a dependency between finish and start dates
- Four kinds of task dependencies in MS Project:

##### Finish to start

- Predecessor must finish before successor can start
	- ie. Cannot provide training until software installed
- Most common type of relationship
- AOA diagrams only use finish to start dependency

##### Start to start

- Predecessor cannot start until successor has started
- ie. A group of activities might start simultaneously

##### Finish to finish

- Predecessor must be finished before successor can finish
	- Both can occur be performed simultaneously
- ie. Quality control cannot finish before production finishes

##### Start to finish

- Predecessor must start before successor can finish
	- Rarely used
- ie. Organisation might strive to stock raw materials in time for manufacturing process to begin
	- Delay in starting the manufacturing process should delay completion of stocking raw materials
- ie. Babysitter who wants to finish watching child
	- But dependent on parents arrival
	- Parent must start before babysitter can finish

##### MS Project PDM

![ms project pdm](http://resources.intenseschool.com//wp-content/uploads/060413_2332_PMPSeriesP1.png)

- Activities placed inside boxes
- Arrows show relationship between activities
- Each task box is populated automatically with
	- Start / finish dates
	- Task ID
	- Task duration
	- Resources
- Red borders for tasks on the critical path
	- MS Project calculates critical path automatically

##### PDM vs. AOA

- PDM used more often than AOA
- PDM avoids the need to use dummy activities
- Dummy activities
	- Have no duration / resources
	- Used to show logical relationships between activities in AOA
	- Represented with dashed arrow lines
	- Have zeros for duration estimates
- PDM shows different dependencies among tasks
	- AOA only show finsh to start
