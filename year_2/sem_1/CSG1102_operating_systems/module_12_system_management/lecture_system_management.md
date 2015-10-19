# System management

## Objectives

- Tradeoffs to be considered when attempting to improve overall system performance
- Roles of system measurement tools
	- Positive/negative feedback loops
- Two system monitoring techniques
- Fundamentals of patch management
- Importance of sound accounting practices by sys admins

## Evaluating an OS

- Knowledge required
	- Design goals and history
	- User's communication mechanisms
	- Resource management techniques
	- Tradeoffs accepted to achieve goals
- OS strengths and weaknesses
	- Weighted against
		- Users
		- Hardware
		- Purpose

## Tradeoffs to consider

### Cooperation among components

- Performance dependency
	- One resource depends on other system resources
- System improvement
	- Requires extensive needs analysis
		- System resources
		- Requirements
		- Managers
		- Users
- System change results
	- Trade one problem for another
- Consider entire system performance
	- Not just individual components

### Role of memory management

- Consider actual operating environment
	- Before memory related changes
- Tradeoff
	- Memory use vs. CPU overhead
	- Algorithm complexity increases
		- CPU overhead increases
	- Overall performance suffers
- Additional memory
	- May/may not help

### Role of processor management

- Multiprogramming system
	- Requires synchronization
		- Memory manager
		- Processor manager
		- IO devices
- Tradeoff
	- Better CPU usage vs. increased overhead
	- Slower response time
	- Decreased throughput

#### Problems

- System saturation point
	- CPU fully utilized and accepting additional jobs
	- Higher over head and less time to run programs
- Heavy loads
	- CPU time required to manage IO queues dramatically increases time required to run jobs
- Long queues at channels, control units and IO devices
	- CPU idle
		- Waiting for processes to finish IO

### Role of device management

- IO device utilization improvement techniques
	- Blocking
	- Buffering
	- Rescheduling IO requests
- Tradeoffs
	- Increased CPU overhead
		- Additional memory space used

#### Blocking

- Reduces physical IO requests
	- Good
- Increases overhead
	- Bad

#### Buffering

- CPU matches slower IO device speed
	- Vice versa
- Requires memory space
	- Buffers
- Tradeoffs
	- Less multiprogramming vs. better IO device use

#### Rescheduling requests

- Optimizes IO times
- Queue reordering technique
- Overhead function
- CPU and IO device speeds vs. reordering algorithm execution time

![figure 12.1](http://snag.gy/8MMqf.jpg)

### Reordering

- Reordering requests not always warranted
- Example
	- CPU 1 and much faster disk drive C
	- Without reordering
		- Access time = 5 + 5 + 5 = 15ms
	- With reordering
		- Access time = 5 + 30 = 35ms

#### Reordering algorithm

- Always on or always off
- Requires configuration to change
- Initial setting
	- Determined by evaluating system on average

#### Example without reordering

- CPU 1 and Drive A
	- Access track 1, track 9, track 1, track 9
	- Arm already located at track 1

![figure 12.2](http://snag.gy/SPBNc.jpg)

#### Example after reordering

- Arm performs both accesses on track 1 before traveling to track 9
	- 35ms

![figure 12.3](http://snag.gy/nH3MZ.jpg)

### Role of file management

- Secondary storage allocation schemes
	- Help organize and access system files
- Important considerations
	- File organization
		- Example
			- File records stored non contiguously
			- Time consuming and requires compaction
				- CPU time
	- Volume directory location
		- Affects retrieval time
- Different schemes offer different flexibility
	- Tradeoff
		- File flexibility vs. CPU overhead
- Closely related to device storing files
- File management related to device where files stored

![table 12.1](http://snag.gy/surBb.jpg)

### Role of network management

- Routinely synchronizes remote processor load
- Determines message priority
- Selects most efficient communication paths
	- Over multiple data communication lines
- Monitors use
	- Individual computers and shared hardware
	- Ensures software license agreements compliance
- Simplifies updating data files and programs on networked computers

## Measuring system performance

- Total system performance
	- Efficiency with which computer system meets goals
- System efficiency
	- Not easily measured
	- Affected by three components
		- User programs
		- OS programs
		- Hardware
- System performance
	- Very subjective
	- Difficult to quantify
	- When quantifiable
		- Not an absolute measure

### Measurement tools

- System performance measures
	- Throughput
	- Capacity
	- Response time
	- Turnaround time
	- Resource utilization
	- Availability
	- Reliability

#### Throughput

- Composite measure
- Indicates system productivity as a whole
- Measured under steady state conditions
- Example
	- Quantities
		- Number of jobs processed per day
		- Number of online transactions handled per hour
- Measure work volume handled by system unit
- Monitored
	- Hardware
	- Software

##### Throughput bottlenecks

- Capacity
- Max throughput level
	- Resources saturated
	- Processes not passed along
	- Thrashing results
- Main memory over committed
	- Multiprogramming level reaches peak point
	- Monitored by
		- Hardware
		- Software
- Bottleneck detection
	- Monitor queues at each resource

#### Response time

- Online interactive user
- Interval required to process user requests
	- From when user presses key to send message until system indicates receipt of message

#### Turnaround time

- Batch job response time
- Time from job submission until output returned to user
- Dependencies
	- Workload handled by system at time of request
	- Type of job or request being submitted
- Include
	- Average values/variance

#### Resource utilization

- How much unit contributing to overall operation
- Percentage of time resource actually in use
	- Example
		- CPU busy 60% of time
- Helps analyst determine
	- Balance among system units
	- System category
		- IO bound or CPU bound

#### Availability

- Indicates likelihood resource ready when needed
- Influences
	- **Mean time between failures (MTBF)**
		- Average time unit operational before break down
	- **Mean time to repair (MTTR)**
		- Average time needed to fix failed unit and put back in service

![availability formula](http://snag.gy/dQ2Fy.jpg)

#### Reliability

- Measures probability unit will not fail during given time period
- Function of **mean time between failures (MTBF)**:

### Performance measures

- Avoid taking in isolation from system workload
- Overall system performance
	- Varies with time
	- Important to define actual working environment
		- Before making generalizations

## Feedback loops

- Monitor system resource utilization for adjustments
	- Prevents processor time spent on overhead
	- More time executing jobs
- Feedback loop types
	- Negative feedback loop
	- Positive feedback loop

### Negative feedback loop

- Process arrival rate decreased when system too congested
- Stabilized system
- Queue lengths close to estimated mean values

![figure 12.4](http://snag.gy/d3Yl8.jpg)

### Positive feedback loop

- Arrival rate increased when system underutilized
- Paged virtual memory systems use this
- Implementation more difficult than negative loops

![figure 12.5](http://snag.gy/lQpei.jpg)

## Patch management

- Systematic updating
	- OS or other software
- Patch
	- Programming code
	- Replaces or changes software code
- Reasons
	- Provides vigilant security precautions against threats
	- Assures government regulation compliance
		- Privacy and financial accountability
	- Keeps systems running at peak efficiency
- Challenges
	- System complexity
		- OS
		- Network
		- Various platforms
		- Remote users
	- Speed in which vulnerabilities are exploited
		- Worms
		- Viruses
		- Other system assaults
- Rigorous patching results
	- Resources reach top performance
	- Information best protected
- Responsibility
	- Organization dependent
		- Chief information officer
		- Chief security officer
- Manual and automatic patch technologies
	- Among top eight used by organizations

![table 12.2](http://snag.gy/CrCs5.jpg)

### Patching fundamentals

- Steps
	- Identify required patch
	- Verify source/integrity
	- Test patch in safe environment
	- Deploy patch throughout system
	- Audit system
		- Gauge patch deployment success
- Recent data backup in hand
	- Before patch installation

#### Patch availability

- Identify patch criticality category
	- Critical
		- Apply patch as soon as possible
	- Not critical
		- Delay until regular patch cycle

#### Patch integrity

- Validate source/integrity
- Use digital signature or patch validation tool
- Validate patch vendor's digital signature

#### Patch testing

- Sample system or isolated machine
	- Resemble target network complexity
- Tests
	- System reboot after patch installed
	- Software performs assigned tasks
- Test contingency plans for installation failure
	- Uninstall patch
	- Recover old software

#### Patch deployment

- Installation

##### Single user computer

- Simple task
- Install software and reboot computer

##### Multiplatform system

- Many users
- Exceptionally complicated task
- Maintain accurate hardware/software inventory
- Use network mapping software
- Stage patch deployment

#### Audit finished system

- Confirm results meet expectations
- Verify all computers patched correctly
	- Performs expected fundamental tasks
- Verify all users eligible for patch
	- No unauthorized software on computers
- Verify all users patched
	- No unpatched computer software
- Document
	- System changes
	- Successes/failures
		- Each stage of the process
	- Log all system changes
		- Future reference
	- User feedback
		- Verify deployment success

### Software options

- Patch installation techniques
	- Manually
		- One at a time
	- Automatically
		- Using software
- Deployment
	- Agent based software
		- Software assists in patch installation
		- On all target systems before patch deployed
	- Agentless software
		- Attractive for large complex network
		- Time saving efficiencies

### Timing the patch cycle

- Critical patches
	- Applied immediately
- Less critical patches
	- Scheduled at system group's convenience
- Routine patches
	- Applied monthly or quarterly
	- Timed
		- Coincide with vendor service pack release
	- Advantage
		- Thorough review before deployment
			- Patch
			- Testing cycles

## System monitoring

- Early systems performance measurements
	- Monitored CPU speed
- Today's measurements
	- Other hardware units
	- OS
	- Compilers
	- Other system software
- Measurements made in variety of ways
	- Real programs
		- Production programs
		- Run with different configurations of
			- CPUs
			- OS
			- Other components
	- Results called benchmarks
	- Using simulation models

### Hardware monitors

- More expensive
- Minimum impact on system
	- Outside and attached electronically
- Examples
	- Counters
	- Clocks
	- Comparator

### Software monitors

- Relatively inexpensive
- Distortion of analysis results
	- Software monitor becomes part of system
- Developed for each specific system
- Difficult to move from system to system

### Benchmarks

- Demonstrate specific advantages
	- New
		- CPU
		- OS
		- Compiler
		- Piece of hardware
- Useful when comparing systems experiencing extensive changes
- Results dependent on
	- System workload
	- System design/implementation
	- Specific requirements of applications loaded on system

## Accounting

- Pays bills
- Keeps system financially operable
- Single user environment
	- Easy to calculate system cost
- Multi user environment
	- Computer costs distributed among users
	- Basis
		- User's resource usage

### Distributing computer costs

- Operating system tasks
	- Set up user accounts
	- Assign passwords
	- Identify resources available to each user
	- Define quotas for available resources
		- Disk space
		- Max CPU time allowed per job

### Pricing policies

- Vary from system to system
- Examples
	- Total amount of time spent between job submission and completion
	- CPU time/main memory usage
	- Secondary storage used during program execution
	- Secondary storage used during billing period
	- Use of system software/number of IO operations
	- Time spent waiting for IO completion
	- Number of input record reads, output records printed, page faults
- Pricing policies
	- Achieve specific operational goals
- Pricing incentives
	- Encourage access of more plentiful and cheap resources
- Billing method information
	- Environment dependent
- Maintaining billing records online
	- User's status checked before job enters READY queue
	- Increased overhead

## Summary

- OS orchestrates cooperation
	- All hardware/software
- One part favored at expense of others
	- Leads to tradeoffs
- System managers
	- Use appropriate measurement tools/techniques
		- Verify systerm effectiveness
	- Evaluate degree of improvement
