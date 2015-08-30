# Process management

## Objectives

Describe

- Differences between
	- Deadlock
	- Race
	- Starvation
- Several causes of system deadlock and livelock
- Difference between preventing and avoiding deadlocks
- How to detect and recover from deadlocks
- How to detect and recover from starvation
- The concept of race and how to prevent it

## Introduction

- Resource sharing perspectives
	- Memory management and processor sharing
- Many programs competing for limited resources
- Lack of process synchronization consequences
	- Deadlock
		- Deadly embrace
		- Catch 22
		- BSOD
			- Two or more jobs placed in HOLD state
			- Jobs waiting for unavailable vital resource
			- System comes to standstill
			- Unresolved by OS
				- Requires external intervention

# Deadlock, livelock and starvation

- Narrow staircase analogy
	- Staircase
		- The system
	- Steps and landings
		- Resources
	- Stairs
		- Only wide enough for one person
	- Landing at each floor
		- Room for two people
- Deadlock
	- Two people meet on the stairs
	- Neither retreats
- Livelock
	- Two people on a landing
	- Each time one takes a step to the side, the other mirrors that step
		- Neither moves forward
- Starvation
	- People wait on landing for a break
		- Break never comes

## Deadlock

- More serious than starvation
- Affects entire system
	- Affects more than one job
		- Not just a few programs
	- All system resources become unavailable
- More prevalent in interactive systems
- Realtime systems
	- Deadlocks quickly become critical situations
- OS must prevent or resolve

![deadlock traffic example](http://snag.gy/18RG7.jpg)

### Seven cases of deadlock or livelock

- Nonshareable / nonpreemptable resources
	- Allocated to jobs requiring same type of resources
- Resource types locked by competing jobs
	1. File requests
	2. Databases
	3. Dedicated device allocation
	4. Multiple device allocation
	5. Spooling
	6. Network
	7. Disk sharing

### Case 1: Deadlocks on file requests

- Job request and hold files for execution duration
- Example Figure 5.2
	- Two programs
		- P1
		- P2
	- Two files
		- F1
		- F2
	- Deadlock sequence
		- P1 has access to F1 and also requires F2
		- P2 has access to F2 and also requires F1
	- Deadlock remains until
		- One program is closed or
		- One program is forcibly removed and file is released
	- Other programs requiring F1 or F2
		- Put on hold for duration of situation

![figure 5.2](http://snag.gy/iXzRi.jpg)

### Case 2: Deadlocks in databases

- Two processes access and lock database records
- Locking
	- Guarantees data integrity
		- One user locks out all other database users
	- Three locking levels
		- Entire database for duration of request
		- Subsection of database
		- Individual records until request completed
- Example Figure 5.3
	- Two processes
		- P1
		- P2
	- Two records
		- R1
		- R2
	- P1 and P2 to update two records R1 and R2
	- Deadlock sequence
		- P1 accesses R1 and locks it
		- P2 accesses R2 and locks it
		- P1 requests R2 but is locked by P2
		- P2 requests R1 but is locked by P1
	- Race between processes
		- Results when locking not used
		- Causes incorrect final version of data
		- Depends on process execution order

![figure 5.3](http://snag.gy/xZcTr.jpg)

### Case 3: Deadlocks in dedicated device allocation

- Limited number of dedicated devices
- Example
	- Two admins each running education programs with processes
		- P1
		- P2
	- Need two audio recorders each
		- Only two audio recorders available
			- R1
			- R2
	- Deadlock sequence
		- P1 requests tape R1 and gets it
		- P2 requests tape R2 and gets it
		- P1 requests tape R2 but blocked
		- P2 requests tape R1 but blocked

### Case 4: Deadlocks in multiple device allocation

- Several processes request and hold dedicated devices
- Example Figure 5.4
	- Three programs
		- P1
		- P2
		- P3
	- Three dedicate devices
		- Scanner
		- Printer
		- Plotter
	- Deadlock sequence
		- P1 requests and gets scanner
		- P2 requests and gets printer
		- P3 requests and gets plotter
		- P1 requests printer but blocked
		- P2 requests plotter but blocked
		- P3 requests scanner but blocked

![figure 5.4](http://snag.gy/RoePV.jpg)

### Case 5: Deadlocks in spooling

- Virtual device
	- Dedicated device made shareable
	- Example
		- Printer
			- High speed disk device transfers data between printer and CPU
- Spooling
	- Process
		- Spooler accepts output from several users
		- Acts as temporary storage for output
		- Output resides in spooling system until printer accepts job data
- Deadlock sequence
	- Printer needs all job output before printing begins
		- Spooling system fills disk space area
		- No one job has entire print output in spool area
		- Results in partially completed output for all jobs
		- Results in deadlock

### Case 6: Deadlocks in a network

- No network protocols controlling network message flow
- Example Figure 5.5
	- Seven devices on network
		- Each on different nodes
	- Direction of arrows
		- Indicate communication flow
	- Deadlock sequence
		- All available buffer space filles

![figure 5.5](http://snag.gy/75EVu.jpg)

### Case 7: Deadlocks in disk sharing

- Competing processes send conflicting commands
	- Scenario
		- Disk access resulting in livelock
- Example Figure 5.6
	- Two processes
	- Each process waiting for I/O request
		- Track 20
		- Track 310
	- Deadlock sequence
		- Arm moves back and forth between tracks 20 and 310 attempting to fulfill the two competing commands
		- Neither I/O request is satisfied

![figure 5.6](http://snag.gy/4MIbD.jpg)

## Necessary conditions for deadlock / livelock

- Four conditions required for a locked system
	1. Mutual exclusion
		- Allowing only one process access to dedicated resource
	2. Resource holding
		- Not releasing the resource
		- Waiting for the other job to retreat
	3. No preemption
		- Lack of temporary reallocation of resources
	4. Circular wait
		- Each process waiting for another to voluntarily release so at least one can continue
- All conditions are required for a deadlock
- Resolving deadlock
	- Remove one of the conditions
- All four conditions will then be prevented simultaneously
	- Deadlock prevented
	- Difficult to implement

## Modelling deadlocks

- Directed graphs: Richard Holt 1972
	- Circles
		- Processes
	- Squares
		- Resources
	- Solid line with arrow from resource to process
		- Process holding resource
	- Dashed line with arrow from process to resource
		- Process waiting for resource
	- Arrows indicate flow
	- Cycle in graph
		- Deadlock involving processes and resources

![figure 5.7](http://snag.gy/rfyBy.jpg)

- Three graph scenarios to help detect deadlocks
	- System has three processes
		- P1
		- P2
		- P3
	- System has three resources
		- R1
		- R2
		- R3
- Scenario 1: No deadlock
	- Resources released before next process request
- Scenario 2: Deadlock
	- Process waiting for resource held by another
- Scenario 3: No deadlock
	- Resource released before deadlock

### Scenario 1: No deadlock

![table 5.1](http://snag.gy/WJ6tZ.jpg)

![figure 5.8](http://snag.gy/Es6uC.jpg)

### Scenario 2: Deadlock

![table 5.2](http://snag.gy/hWIhl.jpg)

![figure 5.9](http://snag.gy/XjeVm.jpg)

### Scenario 3: No deadlock

![table 5.3](http://snag.gy/p85sU.jpg)

![figure 5.10](http://snag.gy/riL3L.jpg)

### Another example

- Resources of the same type
- Allocated individually or grouped in same process
	- Graph clusters devices into one entity
- Allocated individually or grouped in different process
	- Graph clusters devices into one entity

## Strategies for handling deadlocks

- Prevention
	- Prevent occurrence of one condition
		- Mutual exclusion
		- Resource holding
		- No preemption
		- Circular wait
- Avoidance
	- Avoid deadlock if it becomes probable
- Detection
	- Detect deadlock when it occurs
- Recovery
	- Resume system normalcy quickly and gracefully

### Prevention

- Prevention eliminates one of four conditions
- Complication
	- Same condition cannot be eliminated from every resource
- Mutual exclusion
	- Some resources must allocate exclusively
	- Bypassed if I/O device uses spooling
- Resource holding
	- Bypassed if jobs request every necessary resource at creation time
	- Multiprogramming degree significantly decreased
	- Idle peripheral devices
- No preemption
	- Bypassed if operating system allowed to deallocate resources from jobs
	- OK if job state easily saved and restored
	- Preempting dedicated I/O device or files during modification
		- Extremely unpleasant recovery tasks
- Circular wait
	- Bypassed if operating system prevents circle formation
	- Uses hierarchical ordering scheme
	- Requires jobs to anticipate resource request order
	- Difficult to satisfy all users

### Avoidance

- Use if condition cannot be removed
- System knows ahead of time
	- Sequence of requests associated with each active process
- Dijkstra's bankers algorithm (Dijkstra, 1965)
	- Regulates resource allocation to avoid deadlocks
		- No customers granted loan exceeding bank's total capital
		- All customers given maximum credit limit
		- No customer allowed to borrow over limit
		- Sum of all loans will not exceed bank's total capital

![table 5.4](http://snag.gy/zfCW8.jpg)

![table 5.5](http://snag.gy/y6jZS.jpg)

![table 5.6](http://snag.gy/OWbWS.jpg)

![table 5.7](http://snag.gy/EnncK.jpg)

#### Operating systems deadlock avoidance assurances

- Never satisfy request if job state moves from safe to unsafe
- Identify job with smallest number of remaining resources
- Number of available resources >= number needed for selected job to complete
- Block request jeopardizing safe state

#### Problems with bankers algorithm

- Jobs must state maximum number needed resources
- Requires constant number of total resources for each class
- Number of jobs must remain fixed
- Possible high overhead cost incurred
- Resources not well utilized
	- Algorithm assumes worst case
- Scheduling suffers
	- Result of poor utilization
	- Jobs kept waiting for resource allocation

### Detection

- Build directed resource graphs
	- Look for cycles
- Algorithm detecting circularity
	- Executed whenever appropriate
- Detection algorithm
	1. Remove process using current resource and not waiting for one
	2. Remove process waiting for one resource class
		- Not fully associated
	3. Return to Step 1
		- Repeat Step 1 and 2 until all connecting lines removed

![figure 5.11](http://snag.gy/StfMH.jpg)

![figure 5.12](http://snag.gy/1dF9i.jpg)

### Recovery

- Deadlock untangled once detected
- System returns to normal quickly
- Nearly all recovery methods have at least one victim
- Recovery methods
	- Terminate every job active in the system
		- Restart jobs from beginning
	- Terminate only jobs involved in deadlock
		- Ask users to resubmit jobs
	- Identify jobs involved in deadlock
		- Terminate jobs one at a time
- Interrupt jobs with record of progress
	- Snapshot
- Select non-deadlocked job
	- Preempt its resources
	- Allocate resources to deadlocked process
- Stop new jobs from entering the system
	- Allow non-deadlocked jobs to complete
	- Releases resources when complete
	- No victim

#### Recovery factors to consider

- Select victim with least negative effect on the system
- Most common
	- Job priority under consideration
		- High priority jobs usually untouched
	- CPU time used by job
		- Jobs close to completion usually left alone
	- Number of other jobs affected if job selected as victim
	- Jobs modifying data
		- Usually not selected for termination
			- A database issue

## Starvation

- Job execution prevented
	- Waiting for resources that never become available
	- Results from conservative resource allocation
- Example
	- Dining philosophers problem (Dijkstra, 1968)
- Starvation avoidance
	- Implement algorithm tracking how long each job has been waiting for resources
		- Aging
	- Starvation detected
		- Block new jobs until starving jobs satisified

![dining philosophers](http://snag.gy/ZLZWm.jpg)

![figure 5.4](http://snag.gy/YW4Cw.jpg)

# Conclusion

- Operating systems
	- Must dynamically allocate resources while avoiding deadlock and starvation
- Four methods for dealing with deadlocks
	- Prevention
	- Avoidance
	- Detection
	- Recovery
- Prevention
	- Removes simultaneous occurrence of one or more conditions
		- System will become deadlock free
	- Prevention algorithms
		- Complex algorithms and high execution overhead
- Avoidance
	- Clearly identify safe and unsafe states
	- Keep reserve resources to guarantee job completion
	- Disadvantage
		- System not full utilized
- When there is no prevention support
	- System must detect and recover from deadlocks
		- Detection relies on selection of victim
