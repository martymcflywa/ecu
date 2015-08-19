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

## Estimating activity resources

- Must have good idea of quantity and type of resources that will be assigned to each activity
	- People
	- Equipment
	- Materials
- Tools
	- Expert judgment
	- Analysis of alternatives
	- Estimating data
	- Project management software tools
- Important questions
	- How difficult will specific activities be on this project
	- Is anything unique in the project's scope statement that will affect resources
	- What is the organisation's history in doing similar activities
		- Has the organisation done similar tasks before
		- What level of personnel did the work
	- Does the organisation have the resources available to do the work
		- People
		- Equipment
		- Materials
	- Could any organisational policies affect the availability of resources
	- Does the organisation need to acquire more resources to accomplish the work
		- Would it make sense to outsource some of the work
		- Will outsourcing increase or decrease the amount of resources needed
		- When will they be available
- Input
	- Project schedule
	- Management plan
	- Activity list
	- Activity attributes
	- Resource calendars
	- Risk register
	- Activity cost estimates
	- Enterprise environmental factors
	- Organisational process assets
		- Policies regarding staffing and outsourcing
- Output
	- List of activity resource requirements
	- Resource breakdown structure
	- Project document updates
- Provides vital information for
	- Project cost estimates
	- Project human resources management
	- Project communications management
	- Project risk management
	- Project procurement management
- Resource breakdown structure
	- Hierarchical structure that identifies the project's resources by category and type
		- Example categories
			- Analysts
			- Programmers
				- Java
				- COBOL
			- Testers
	- Helpful in determining
		- Resource cost
		- Acquiring resource
		- etc.

## Estimating activity durations

- **Duration includes**
	- Amount of time worked on activity
	- Plus elapsed time
	- ie. It might take five working days to do the work
		- But estimate time might be ten working days to allow for extra time needed to obtain outside information
- **Duration vs. effort**
	- Duration estimate
		- Time worked + elapsed time
		- Calendar date
	- Effort estimate
		- Time to complete work
- Input
	- Schedule management plan
	- Activity list / attributes
	- Activity resource requirements
	- Resource calendars
	- Project scope statement
	- Risk register
	- Resource breakdown structure
	- Enterprise environmental factors
	- Organisational process assets
- Review
	- Accuracy of duration estimates thus far on the project
- Considerations
	- Availability of resources, especially human
	- What skills do people need
	- What are the skill level of the people assigned to the work
	- How many people are expected to be available to work on the project at any one time
- Output
	- Duration estimates
		- Provided as a
			- Discrete number
				- ie. Four weeks
			- Range
				- ie. Three to five weeks
			- Three point estimate
			- Analogous / parametric estimates
			- Reserve analysis
	- Project document updates

### Three point estimate

- Includes three estimates
	- Optimistic
		- Best case scenario
	- Most likely
		- Expected scenario
	- Pessimistic
		- Worst case scenario
- Three point estimate is a required input for
	- PERT estimates
	- Monte carlo simulations

## Developing the schedule

- Uses the results of all preceding project time management processes to determine start and end dates of the project and activities
	- Time management processes often go through several iterations before a project schedule is finalised
- Goal
	- Develop a realistic project schedule
	- Provide a basis for monitory project progress for time dimension
- Output
	- Project schedule
	- Schedule baseline
	- Schedule data
	- Project calendars
	- Project management plan updates
	- Project document updates
- Tools
	- Gant chart
		- Displays project schedule information
	- Critical path analysis
		- Develop and control project schedules
	- Critical chain scheduling
		- Focuses on limited resources when creating a project schedule
	- PERT analysis
		- Means to consider schedule risk on projects

### Gantt charts

- Provides standard format for displaying project schedule information
	- Lists project activities and corresponding start/finish dates in calendar form
- Activities on gantt chart should align with WBS activities
	- Which should align with activity and milestone list
- Contains
	- Milestones
	- Summary tasks
	- Individual task durations
	- Arrows showing task dependencies
- Advantages
	- Provide standard format to display planned and actual project schedule info
	- Easy to create / understand
- Disadvantage
	- Do not usually show relationships / dependencies
		- Unless project management software does it
			- ie. MS Project

![gantt](http://snag.gy/QUlrG.jpg)

- Example above
	- Black diamond
		- Milestone
	- Thick black bars with arrows at the beginning and end
		- Summary tasks
	- Light gray horizontal bars
		- Duration of each individual task
	- Arrows
		- Relationship / dependencies between tasks
		- Are automatically displayed in MS Project
			- If dependencies are configured

#### Adding milestones to gantt charts

- Milestones can be created by adding a task with zero duration
- MS Project
	- Mark any task as milestone
	- Checking appropriate box in advanced tab of task information dialog box
	- Duration will not change to zero but milestone icon will be shown to represent that task based on its start date
- Use SMART criteria to help define meaningful milestones
	- Specific
	- Measurable
	- Assignable
	- Realistic
	- Time framed
- SMART example
	- Distributing a marketing plan is specific, measurable and assignable if everyone knows
		- What should be in the marketing pan
		- How it should be distributed
		- How many copies should be distributed and to whom
		- Who is responsible for the actual delivery
	- Distributing the marketing plan is realistic and able to be time framed if it is an achievable event and scheduled appropriately

#### Tracking gantt charts to compare planned and actual dates

![tracking gantt](http://lms.oum.edu.my/e-content/EBXP3103/content/050940123_EBXP3103_final/topic5/graphic5/EBXP3103_5_3.jpg)

- Tracking gantt chart
	- Special type of gantt chart to evaluate progress on a project by showing actual schedule information
	- Compares planned and actual project schedule information
- Planned schedule dates
	- Baseline dates
- Entire approved planned schedule
	- Schedule baseline
- Includes
	- Columns labeled start and finish to represent actual start and finish dates for each task
	- Columns labeled baseline start / finish to represent planned start and finish dates for each task
- Additional symbols
	- Two bars to represent baseline schedule and actual schedule
		- Top bar
			- Planned
		- Bottom bar
			- Actual
		- Two bars same length
			- Planned and actual is the same
		- Bars do not start and end of the same dates
			- Actual schedule differed from baseline schedule
		- Top bar shorter than bottom bar
			- Task took longer than planned to complete
		- Top bar is longer than bottom bar
			- Task too less tim than planned
	- White diamond
		- Represents slipped milestone
		- Milestone activity completed later than planned
	- Percentages
		- Percent of work completed for each task
- Based on percentage of work completed for tasks or actual start and finish dates
- Allows monitoring of schedule progress on individual tasks and entire project

### Critical path method

- Also called critical path analysis
- Network diagramming technique used to predict total project duration
- Helps combat project schedule overruns
- Critical path is series of activities that determine the earliest time by which the project can be completed
	- The longest path through the network diagram
	- Has least amount of slack and float
- Slack and float
	- Amount of time an activity may be delayed without delaying a succeeding activity or project finish date
- The longest path or path that contains the critical tasks is what drives the completion date for the project
	- You are not finished with the project until you have finished all the tasks
- Notes
	- Critical path does not mean critical tasks
		- Only concerned with time domain
	- Critical path is not shortest path
	- Critical path can have multiple critical path
	- Critical path can change as project progresses

#### Calculating critical path

- Must have
	- Good network diagram
	- Good activity list based on WBS
	- Estimate duration of each activity
- Add durations for all activities on each path through the network diagram
	- The longest path is the critical path
- Even though the critical path is the longest
	- It represents the shortest time required to complete a project
- If one or more activities on the critical path take longer than planned
	- The whole project schedule will slip
		- Unless project manager takes corrective action

### Using critical path analysis to make schedule trade offs

- Determine free slack and total slack for each project activity
	- Free slack or free float
		- Amount of time an activity can be delayed without delaying the early start date of any immediately following activities
	- Early start date
		- The earliest possible time an activity can start based on project network logic
	- Total slack or total float
		- Amount of time an activity can be delayed from its early start without delaying the planned project finish date
- Calculate free slack and total slack
	- Doing a forward and backward pass through a network diagram

#### Forward pass

- Determines the early start and early finish dates for each activity
- Early finish
	- The earliest possible time an activity can finish based on the project network logic
- Project start is equal to early start date of first network diagram activity
	- Early start + duration of first activity = early finish date of first activity
	- Also = to early start date of each subsequent activity
		- Unless an activity has multiple predecessors
	- When activity has multiple predecessors
		- Early start date is the latest of the early finish dates of those predecessors

#### Backward pass

- Determines the late start and finish dates for each activity in a similar fashion
- Late start date
	- Latest possible time an activity might begin without delaying the project finish date
- Late finish date
	- Latest possible time an activity can be completed without delaying the project finish date

### Using critical path to shorten a project schedule

- Can use compression techniques to shorten project schedule
- ie. Reduce duration of activities on the critical path
	- By allocating more resources or changing scope
- Project time management techniques
	- Crashing
	- Fast tracking

#### Crashing

- Making cost and schedule trade-offs to obtain greatest amount of schedule compression for least incremental cost
	- ie. If two critical tasks each take two weeks
		- It takes $100 to shorten task 1 by a week
		- It takes $1000 to shorten task 2 by a week
			- Shorten task 1
- Advantage
	- Shorten time needed to finish project
- Disadvantage
	- Increase total project cost

#### Fast tracking

- Doing activities in parallel that would normally be completed in sequence
	- ie. Normally no coding done until all analysis complete
		- Coding started before analysis completed to save time
- Advantage
	- Shorten time needed to finish project
- Disadvantage
	- Can lengthen project schedule
		- Starting some tasks too soon can increase project risk
			- Resulting in rework

#### Importance of updating critical path data

- Document actual durations of completed activities
- Update revised estimates for activities in progress or yet to be started
- Revisions can cause project critical path to change
	- Resulting in new estimated completion date
- Stay informed when making decisions

### Critical chain scheduling

- Theory of constraints
	- Critical chain scheduling
- Management philosophy based on metaphor of a chain and its weakest link
- Considers limited resources for a project schedule
	- Includes buffers to protect the project completion date
	- Acknowledges that decisions must be made to delay a task when conflicts of resources arise
- Other concepts
	- Multitasking
	- Time buffers

#### Multitasking

- When a resource works on more than one task at a time
- Multitasking can delay task completion
- Involves wasted setup time
	- Increases total duration
- Critical chaining assumes that resources do not multitask
	- Or at least minimize it
- If multitasking does occur, critical chaining ensures projects are prioritized
- Preventing multitasking avoids
	- Resource conflicts
	- Wasted setup time switching between different tasks

#### Time buffer

- People add buffer to estimates to account for unknown factors
- Critical chaining removes buffers from individual tasks
	- Creates **project buffer** instead
	- Time added before the project's due date
- Critical chaining protects tasks on critical chain from being delayed
	- Uses **feeding buffers**
	- Time added before tasks on the critical chain if they are preceded by other tasks that are not on the critical path
- Task estimates in critical chain should be shorter than traditional estimates
	- Because buffers are not included in each task
	- Fewer occurrences of **Parkinsons law**
		- Work expands to fill the time allowed
- Feeding and project buffers protect the project completion date

### Program evaluation and review technique (PERT)

- Network analysis technique used to estimate project duration
	- When there is a high degree of uncertainty about the individual activity duration estimates
- PERT applies the critical path method (CPM) to a weighted average duration estimate
- Uses probabilistic time estimates
	- Duration estimates based on using optimistic, most likely, and pessimistic estimates of activity durations
		- Instead of one specific or discrete estimate
- To calculate weighted average for duration estimate

>PERT = (optimistic + 4 * most likely + pessimistic) / 6

- PERT weighted average considers risk and uncertainty in individual activity estimates
- Advantages
	- Addresses risk associated with duration estimates
	- Helps develop more realistic schedules
- Disadvantages
	- Involves more work
	- Need to supply multiple estimates per activity
	- Better probabilistic methods for assessing schedule risk
		- ie. Monte carlo simulation

## Controlling the schedule

- Goal
	- Know the status of the schedule
	- Influence factors that cause schedule changes
	- Determine that a schedule has changed
	- Manage changes when they occur
- Input
	- Project management plan
	- Project schedule
	- Work performance data
	- Project calendars
	- Schedule data
	- Organisational proces assets
- Tools
	- Performance reviews
		- Progress reports
	- Schedule change control system
		- Part of integrated change control system
	- Scheduling tool and/or project management software
	- Variance analysis
		- Analysing float / slack
		- Using earned value
	- What if scenario analysis
		- Done manually
		- Aid of software
	- Adjusting lead and lag
	- Schedule compression
		- Crashing
		- Fast tracking
	- Resource optimization
		- Resource leveling
- Output
	- Work performance measurements
	- Organisational process assets updates
		- Lessons learned reports
	- Change requests
	- Project management plan updates
	- Project documents updates
- Ensure project schedule is realistic

### Reality checks on scheduling and need for discipline

- Review draft schedule in project charter
	- Review start and end date of project
	- Ensure it is realistic
- Prepare more detailed schedule
	- Get stakeholder approval
- Hold regular progress meetings with stakeholders
	- Communicate progress
		- ie. Tracking gantt chart
- Verify schedule progress
	- Review actual work completed
	- Ensure work completed as planned
	- Changes are reported as needed
- Be clear and honest in communicating project status
	- Don't create illusion project is fine when it has serious problems
	- Alert management when conflicts arise that could affect project schedule
- Use discipline to control project schedules
	- Set firm dates for key milestones helps minimize schedule changes
	- Insist important schedule dates be met
	- Proper planning and analysis be completed upfront

### Using software to assist in project time management

- Can use project management software to
	- Create network diagrams
		- Automatically
	- Determine critical path
		- Automatically
	- Create gantt charts
	- Report, view, filter specific time management information
	- Calculate free / total float / slack
- Eliminates need to perform manual calculations
	- Allows for what if analysis as activity duration estimates or dependencies change
	- Knowing which activities have the most slack allows to reallocate resources
		- Or make other changes to compress the schedule
- Create gantt charts easier
	- But must enter schedule data in timely manner to help project benefit from using such charts
- Can generate built in reports, views and filters
	- ie. Report to list all activities scheduled to start soon and send reminders to people responsible

### Words of caution using project management software

- Misused due to lack of understanding of concepts
- Rely too heavily on sample files or templates
