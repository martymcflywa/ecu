# Chapter 5: Process management

## Objectives

- Several causes of system deadlock/livelock
- Difference between
	- Preventing deadlock
	- Avoiding deadlock
- How to detect and recover from deadlock
- Concept of process starvation
	- How to detect/recover from it
- Concept of race
	- How to prevent it
- Difference between
	- Deadlock
	- Starvation
	- Race

## Introduction

- Address problems caused when
	- Many processes compete for few resources
	- System stops responding as it should
	- Unable to service all processes in the system

### Lack of process synchronization

- Can result in two extreme conditions
	- Deadlock
	- Starvation
- In early OS
	- Deadlock was known as **deadly embrace**
	- Exactly what happens when system freezes
	- System wide tangle of resources
- Begins when two or more jobs are put on hold
	- Each waiting for vital resource to become available
	- Problem builds when resources needed by jobs are resources held by other jobs
		- Also waiting to run but cannot because waiting for other unavailable resources
- Tangled jobs come to standstill
	- Deadlock is complete if the remainder of the system comes to a standstill as well
- When situation can't be resolved by the OS
	- Intervention is required

#### Deadlock example

- System
	- Staircase
- Resources
	- Landings
	- Steps
- Narrow staircase in a building
- Traffic on staircase moves well unless
	- Two people traveling in opposite directions need to pass on the stairs
	- Only room for one person on each step
- Landings between each floor
	- Wide enough for people to share it
	- Stairs cannot be shared
		- Can only be allocated to one person at a time
- Problems occur when someone going up the stairs meets someone coming down
	- Each refuses to retreat to a wider place
- Creates deadlock

#### Livelock example

- If two people on the landing try to pass each other but cannot
	- As one steps to the right
	- The other steps to the left and vice versa
	- People continue moving but neither move forward
- Creates livelock

#### Starvation example

- If few patient people wait on landing for break in opposing traffic
	- Break never comes
	- Could wait forever
- Creates starvation
	- Indefinite postponement

## Deadlock

- More serious than starvation
	- Affects more than one job
- Because resources are tied up
	- Entire system is affected
- Example
	- Traffic jam
- Figure 5.1
	- No simple/immediate solution to deadlock
	- No one can move forward until someone moves out the way
	- No one can move out the way until either
		- Someone advances
		- Rear of the line moves back
	- Requires intervention to either
		- Remove one of four vehicles from intersection
		- Make a line move back
	- Only then can deadlock be resolved

![figure 5.1](http://snag.gy/cSFY0.jpg)

- Deadlocks became prevalent with introduction of interactive systems
	- Generally improve use of resources through dynamic sharing
	- Also increased possibility of deadlocks
- In some computer systems
	- Deadlocks regarded as mere inconvenience
		- Causes delays
- For some real time systems
	- Deadlocks cause critical conditions
	- Example endangering lives
		- Deadlock in hospital life support system
		- Deadlock in aircraft guidance system
- Regardless of environment
	- OS must prevent or resolve deadlocks when they occur

## Seven cases of deadlock

- Usually occurs when non sharable, non preemptive resources are allocated to jobs that eventually require other non sharable, non preemptive resources
	- Files
	- Printers
	- Scanners
	- Resources that have been locked by other jobs
- Deadlocks not only restricted to files, printers scanners etc.
	- Can also occur on sharable resources that are locked
		- Disks
		- Databases

### Case 1: Deadlocks on file requests

- If jobs are allowed to request/hold files for duration of execution
	- A deadlock can occur as figure 5.2 shows

![figure 5.2](http://snag.gy/Uj8Bu.jpg)

#### Example

- Home construction company with two application programs active at the same time
	- Purchasing
		- P1
	- Sales
		- P2
- Both need access to two files to read/write transactions
	- Inventory
		- F1
	- Suppliers
		- F2
- One day the system deadlocks when the following sequence of events take place
	1. Purchasing P1 accesses supplier file F2
		- To place an order for more timber
	2. Sales P2 accesses inventory file F1
		- To reserve the parts that will be required
	3. Purchasing P1 doesn't release supplier file F2
		- Requests inventory file F1 to verify quantity of timber on hand before placing order for more
		- P1 is blocked because F1 is being held by P2
	4. Sales P2 doesn't release inventory file F1
		- Requests supplier file F2 to check subcontractor schedules
		- P2 is blocked because F2 is being held by P1
- Any other programs that require F1 or F2 will be put on hold as long as the situation continues
- Deadlock will remain until one of two programs is closed or removed
	- File is released
- Only then can the other program to continue
- System returns to normal

### Case 2: Deadlocks in database

- If two processes access and lock records in a database
- Database queries/transactions are relatively brief processes
	- Search or modify parts of database
	- Requests usually arrive at random
	- May be interleaved arbitrarily
- Locking
	- Technique used to guarantee integrity of data
	- User locks out all other users while working with database
	- Can be done at three levels
		- Entire database
			- Prevents deadlock
			- Restricts access to one user at a time
			- Multiuser environment
				- Slowed response times
			- Normally unacceptable solution
		- Subsection
			- Access time improved
			- Possibility of deadlock increased
				- Different processes sometimes need to work with several parts of database at the same time
		- Individual record

#### Example

- System that locks each record when it is accessed until process is completed
- Two processes
	- P1
	- P2
- Each needs to update two records
	- R1
	- R2
- Sequence to deadlock
	1. P1 accesses R1
		- Locks it
	2. P2 accesses R2
		- Locks it
	3. P1 requests R2
		- Locked by P2
	4. P2 requests R1
		- Locked by P1

#### No lock database

- Avoid using locks
	- Leads to other difficulties
- If locks not used to preserve integrity
	- Updated records in database might include only some of the data
	- Contents would depend on order in which each process finishes execution
- Known as **race** between processes
	- See figure 5.3

![figure 5.3](http://snag.gy/iAXIM.jpg)

#### Race

- Introduces element of chance
	- Totally unacceptable in database management
- Integrity of database must be upheld

#### Race example

- Student of university maintaining most of files in database
	- Can be accessed by several different programs
		- Grades
		- Home addresses
- Student just moved
	- Grades submitted
	- Send change of address form shortly after grades
- Both programs race to access record in database
	1. Grades process P1 first to access record R1
		- Copies record into its work area
	2. Address process P2 accesses record
		- Copies record to work area
	3. P1 changes record R1
		- Enters grades for recent semester
		- Calculates new grade average
	4. P2 changes record R1
		- Updates address field
	5. P1 finishes work first
		- Rewrites its version of record to database
		- Grades updated
		- Address not updated
	6. P2 finishes work
		- Rewrites its version of record to database
		- Grades back to original/lost recent updates
		- Address records update
- Alternatively if order reversed
	- Grades will be updated
	- Address won't
- Either order is unacceptable
	- Incorrect data is allowed to corrupt the database
- System cannot allow integrity to depend on random sequence of events

### Case 3: Deadlocks in dedicated device allocation

- Use of a group of dedicated devices can deadlock the system
	- Cluster of DVDRW drives

#### Example

- Two users each running a program P1 and P2
- Both programs eventually need two DVD drives to copy files from one disk to another
- System is small
	- When two programs are executed
	- Only two DVD drives are available
		- Allocated on as requested basis
- Sequence
	1. P1 requests drive 1
		- Gets it
	2. P2 requests drive 2
		- Gets it
	3. P1 requests drive 2
		- Locked by P2
	4. P2 requests drive 1
		- Locked by P1
- Neither job can continue
	- Each is waiting for the other to finish
	- Will never occur

### Case 4: Deadlocks in multiple device allocation

- Can happen when several processes request, and hold several dedicated devices while other processes act in similar manner
	- See figure 5.4

#### Example

- Three programs
	- P1
	- P2
	- P3
- Three dedicated devices
	- Scanner
	- Printer
	- Plotter

![figure 5.4](http://snag.gy/kOgQa.jpg)

- Sequence
	1. P1 requests and gets scanner
	2. P2 requests and gets printer
	3. P3 requests and gets plotter
	4. P1 requests the printer
		- Locked by P2
	5. P2 requests the plotter
		- Locked by P3
	6. P3 requests the scanner
		- Locked by P1
- None of the jobs can continue
	- Each is waiting for resource held by another

### Case 5: Deadlocks in spooling

#### Spooling

- Accepts output from several users
- Acts as a temp storage area for all output until printer ready to accept it
- If printer needs all of a job's output before it will begin printing
	- But spooling system fills available space with only partially completed output
	- Deadlock occurs

#### Example

- 26 users issue print commands simultaneously
- Spooler receives pages one at a time
	- Pages received separately
- Printer is ready to print first completed document it receives
	- But as spooler reviews files
		- Only has first page of many users
		- No last page for any users
- Spooler full of partially completed output
	- No other pages can be accepted
	- None of the jobs can be printed
- Situation not limited to printers
	- Any part of system that relies on spooling is vulnerable to deadlock

### Case 6: Deadlocks in a network

- If congested or filled a large % of IO buffer space can become deadlocked
	- If it doesn't have protocols to control flow of messages through network
		- See figure 5.5

#### Example

![figure 5.5](http://snag.gy/G14jC.jpg)

- Seven computers
	- C1
		- Receives message from
			- C2
			- C6
			- C7
		- Sends message to
			- C2
	- C2
		- Receives message from
			- C1
			- C3
			- C4
		- Sends message to
			- C1
			- C3
	- Incoming/outgoing messages at C1
		- Buffered in output queue
	- As traffic increases
		- Length of each output queue increases
			- Until all available buffer space is filled
	- At this point
		- C1 can't accept any more messages
			- No more buffer space available to store them
		- C2 can't accept any more messages
			- No more buffer space available to store them
	- Communication path between C1 and C2 become deadlocked
		- C1
			- Can't send messages to any other computer except C2
			- Can only receive messages from C6 and C7
				- Routes become deadlocked
		- C1 can't send message to C2 about problem
		- Deadlock can't be resolved without outside intervention

### Case 7: Deadlocks in disk sharing

- Disks designed to be shared
- Not uncommon for two processes to be accessing different areas of the same disk
- Ability to share creates an active type of deadlock
	- Called **livelock**
- Processes use a form of busy-waiting
	- Different from a natural wait

#### Livelock

- Waiting to share a resource but never gains control of it
	- Figure 5.6
- Two competing processes are sending conflicting commands
	- Causing livelock
- Neither process is blocked
	- Blocking causes deadlock
- Each process is active
	- But never reaches fulfillment

#### Example

![figure 5.6](http://snag.gy/jOAJE.jpg)

1. P1 issues command to read track 20 on disk
2. While control unit moves arm to track 20
	- P1 is put on hold
	- IO channel free to process next IO request
3. While arm is moving to position
	- P2 issues command to write track 310 on disk
	- If command not locked out
		- P2 is put on hold
		- Control unit moves arm to track 310
4. Because P2 is put on hold while arm is moving
	- P1 recaptures control
	- Reconfirms command to read track 20
5. Arm moves back to track 20 from 310
	- P1 put on hold again
	- P2 recaptures control
		- Re-requests write to track 310
	- Arm repositioned again
		- Process constantly repeats
		- Arm moves back and forth
		- Nothing achieved

## Conditions for deadlock

- Seven cases involved
	- Interaction of several
		- Processes
		- Resources
- Each deadlock preceded by
	- Simultaneous occurrence of four conditions that the OS could recognize
- Four conditions
	- Mutual exclusion
	- Resource holding
	- No preemption
	- Circular wait
- Each condition is necessary for OS to run smoothly
	- None can be removed without causing overall function to suffer
- System needs to recognize combination of conditions
	- Before they
		- Occur
		- Threaten to cause deadlock/livelock

### Mutual exclusion

- Allowing only one process to have access to a dedicated resource

### Resource holding

- Each process holds onto resource
- Does not release to back down to other process waiting for held resource

### No preemption

- Resource allocated to process for as long as required
- Lack of temporary reallocation of resources

### Circular wait

- Previous three conditions causes circular wait
- Each process is waiting for the other process to involuntarily release the resource
	- So that at least one process can continue and complete task

### Deadlock condition requirement

- All four conditions are required for deadlock to occur
- Deadlock will continue
	- If all four conditions are present
- If one condition is removed
	- Deadlock will be resolved
- If four conditions can be prevented from occurring simultaneously
	- Deadlocks are prevented
	- Isn't easy to implement

## Modeling deadlocks

- Directed graphs
	- Use two symbols
		- Process
			- Circles
		- Resources
			- Squares
		- Arrows
			- Solid
				- Process is holding resource
			- Dashed
				- Process is waiting for resource
		- Direction of arrow
			- Indicates flow
	- If there is a cycle in graph
		- There is a deadlock involving processes/resources in cycle

![figure 5.7](http://snag.gy/mHo6M.jpg)

### Example

- The following system has
	- Three processes
		- P1
		- P2
		- P3
	- Three resources
		- R1
		- R2
		- R3
- Because there is no specified order in which requests are handled
	- Will look at three different possible scenarios using graphs to help detect any deadlocks

### Scenario 1

- Shown in table 5.1
- Directed graph
	- See figure 5.8

![table 5.1](http://snag.gy/htVox.jpg)

![figure 5.8](http://snag.gy/3Q6A2.jpg)

- No cycles shown
- Deadlock can't occur
	- Even if each process requests every resource
	- If the resources are released before the next process requests them

### Scenario 2

- Table 5.2

![table 5.2](http://snag.gy/NJFxw.jpg)

- Directed graph shown in figure 5.9
- Deadlock occurs because
	- Every process is waiting for a resource that is being held by another process
	- None will be released without intervention

![figure 5.9](http://snag.gy/anYQJ.jpg)

### Scenario 3

- Table 5.3
- Figure 5.10
	- Resources are released before deadlock can occur

![table 5.3/figure 5.10](http://snag.gy/ThsnN.jpg)

### Device clusters

- Graphs can be expanded to include several resources of the same type
	- Tape drives
- Can be allocated
	- Individually
	- In groups to the same process
- Figure 5.11
	- Clusters devices of same type into one entity
		- Rectangle
	- Arrows show links between single resource and processes using it
	- Example of cluster with three resources of same type
		- Disk drives
		- Each allocated to different process
- Figure 5.11(a)
	- Stable
	- No deadlock can occur
- Figure 5.11(b)
	- Deadlock will occur
	- All three processes request one more resource without releasing the one they are using

![figure 5.11](http://snag.gy/NdpBM.jpg)

## Strategies for handling deadlocks

- Requests/releases received in unpredictable order
	- Difficult to design preventive policy
- OS uses one of three strategies to deal with deadlocks
	- Prevention
		- Prevent one of four conditions from occurring
	- Avoidance
		- Avoid deadlock if it becomes probable
	- Detection
		- Detect deadlock when it occurs
		- Recover gracefully

### Prevention

- OS must eliminate one of four necessary conditions
- Complicated by the fact that the same condition can't be eliminated from every resource

#### Mutual exclusion

- Necessary in any computer system
- Resources must be exclusively allocated to one user at a time
	- Memory
	- CPU
	- Dedicated devices
- IO devices
	- Mutual exclusion may be bypassed by spooling
	- Allows input from many jobs to be stored in separate temporary spool files at the same time
	- Each complete output file is then selected for printing when device is ready
	- However
		- Might trade one deadlock type for another
			- Case 3: Deadlocks in dedicated device allocation
			- Case 5: Deadlocks in spooling

#### Resource holding

- Job holds on to one resource while waiting for another one that isn't available
- Could be negated by
	- Forcing each job to request every resource it needs to complete
		- At creation time
- Example
	- If every job in a batch system is given as much memory as it needs
		- Then number of active jobs will be dictated by how many can fit in memory
	- Would decrease degree of multiprogramming
	- Peripheral devices would be idle
		- Would be allocated to a job even though won't be used all the time
- This was used successfully in batch environments
	- But reduced effective use of resources
	- Restricted amount of multiprogramming
	- Doesn't work well in interactive systems

#### No preemption

- Could be bypassed by allowing the OS to deallocate resources from jobs
- Can be done if the state of the job can be easily saved/restored
	- Similar to
		- Job preemption in round robin
		- Page swapping in virtual memory
- But preemption of
	- Dedicated IO device
	- Files during modification process
- Can require unpleasant recovery tasks

#### Circular wait

- Bypassed if OS prevents formation of a circle
- Hierarchical ordering solution
	- Numbering of system resources
	- System forces each job to request its resources in ascending order
		- Any number one devices required by job would be requested first etc.
	- If a job needed a printer then plotter
		- Would request in order
			- Printer (#1)
			- Plotter (#4)
	- If job required plotter first then printer
		- Would request in order
			- Printer (#1)
			- Plotter (#4)
	- May not use resource right away
	- Numbering of resources forces particular order
- Removes possibility of circular wait
- Guarantees removal of deadlocks
- Doesn't require that jobs state their maximum needs in advance
	- But does require that jobs anticipate the order which they will request resources
- Difficulties of scheme
	- Discovering best order for resources
		- So needs of majority of users is satisfied
	- Assigning a rank to non physical resources
		- Files
		- Locked database records
		- No basis for assigning a higher number to one over another

### Avoidance

- Even if OS can't remove one of the conditions for deadlock
- It can avoid one if system knows ahead of time the sequence of requests associated with each of the active processes
- There exists at least one allocation of resource sequence that will allow jobs to continue without becoming deadlocked
- Algorithm to regulate resource allocation avoiding deadlocks
	- Bankers algorithm
		- Based on bank with fixed amount of capital

#### Banker's algorithm

- Algorithm
	- No customer will be granted a loan exceeding bank's total capital
	- All customers will be given max credit limit when opening an account
	- No customers will be allowed to borrow over the limit
	- The sum of all loans won't exceed the bank's total capital
- Under these conditions
	- Bank isn't required to have on hand the total of all max lending quotas before it can open up for business
		- Assuming bank will always have the same fixed total
		- Disregarding interest charged on loans
- Example
	- Bank has
		- Total capital fund of $10,000
		- Three customers
			- C1
				- Max $4000
			- C2
				- Max $5000
			- C3
				- Max $8000
	- Table 5.4 shows state of bank after loans granted to C2 and C3
		- Called **safe state**
			- Bank still has enough money to satisfy max requests of
				- C1
				- C2
				- C3

![table 5.4](http://snag.gy/MbmGq.jpg)

- A few weeks later
	- See table 5.5
	- More loans made
	- Some repaid

![table 5.5](http://snag.gy/HcvnC.jpg)

- Bank is in **unsafe state**
	- Only $1000 left
	- Bank can't satisfy anyone's max request
	- If bank lent $1000 to anyone
		- Would be deadlocked
			- Can't make a loan
- An unsafe state doesn't necessarily lead to deadlock
	- But indicates that the system is a candidate for one
- None of customers is required to request max
	- But bank doesn't know the exact amount that will eventually be requested
	- As long as bank capital is less than max amount available for individual loans
		- It can't guarantee that it will be able to fill every loan request
- Substituting
	- Jobs for customers
	- Dedicated devices for dollars
- Can apply banking principles to OS
- Example
	- System has 10 devices
- Table 5.6 shows system in safe state
- Table 5.7 shows system in unsafe state
- Safe state
	- Where at least one job can finish
		- Because there are enough available resources to satisfy its max needs
	- Then using the resources released by finished job
		- Max needs of another job can be filled
			- Job can be finished
			- Releases its resources
			- Etc.

![table 5.6](http://snag.gy/LuNQe.jpg)

![table 5.7]()

- OS must be sure never to satisfy request that moves it from safe to unsafe
- As user requests are satisfied
	- OS must identify the job with smallest number of remaining resources
		- Make sure that the number of available resources is >= number of available resources needed for this job to run to completion
	- Requests that may place safe state in jeopardy must be blocked by OS until they can be safely accommodated
- If solution is expanded to work with several classes of resources
	- System sets up a **resource assignment table** for each type of resource
		- Tracks each table to keep system in safe state

#### Issues with banker's algorithm

- Isn't always practical because
	- As jobs enter system
		- Must predict max number of resources needed
		- Not practical for interactive systems
	- Number of total resources for each class must remain constant
		- If device
			- Breaks
			- Becomes unavailable
		- Algorithm won't work
			- System may already be in unsafe state
	- Number of jobs must remain fixed
		- Not possible in interactive systems
		- Number of active jobs is constantly changing
	- Overhead cost incurred by running avoidance algorithm
		- Can be high when there are
			- Many active jobs
			- Many devices
		- Because it has to be invoked for every request
	- Resources not well utilized
		- Algorithm assumes worst case
		- Keeps vital resources unavailable to guard against unsafe states
	- Scheduling suffers
		- Result of poor utilization
		- Jobs kept waiting for resource allocation
		- Steady stream of jobs asking for new resources can cause indefinite postponement of a more complex job requiring many resources

### Detection

- Deadlocks can be detected by building directed resource graphs and looking for cycles
- Unlike avoidance algorithm
	- Must be performed every time there is a request
	- Algorithm used to detect circularity can be executed whenever appropriate
		- Every hour
		- Once a day
		- Only when operator notices throughput has deteriorated
		- When angry user complains

#### Detection algorithm

- Can be explained by using directed resource graphs
	- Reducing them
- Begin with system in use
	- Figure 5.12(a)
- Steps to reduce graph are
	1. Find process that is currently using a resource and **not waiting for one**
		- Process can be removed from graph
			- Disconnect the link tying the resource to the process
				- P3 in figure 5.12(b)
		- Resource can be returned to the available list
		- This is possible because the process would eventually finish and return the source
	2. Find a process that's waiting only for resource classes that aren't fully allocated
		- Process can be removed from graph
			- Disconnect link tying the resource to the process
				- P2 in figure 5.12(c)
			- Resource can be returned to available list
			- Isn't contributing to deadlock
				- Would eventually get the resource it's waiting for
				- Finish its work
				- Return the resource to available list
	3. Go back to step 1 and continue with step 1 and 2 until all lines connecting resources to processes have been removed
		- Eventually reaching stage shown in figure 5.12(d)

![figure 5.12](http://snag.gy/8cPM7.jpg)

- If there are any lines left
	- This indicates that the request of the process in question can't be satisfied
		- Deadlock exists
- Figure 5.12
	- (a) Original state
	- (b) Link between P3 and R3 can be removed
		- Because P3 isn't waiting for any other resources to finish
			- R3 is released
			- R3 allocated to P2
				- Step 1
	- (c) Links between P2 and R3, between P2 and R2 can be removed
		- Because P2 has all of its requested resources and can run to completion
		- Then R2 can be allocated to P1
	- (d) Links between P1 and R2, between P1 and R1 can be removed
		- Because P1 has all of its requested resources and can finish successfully
	- Therefore
		- Graph is completely resolved
- Figure 5.13
	- Can't be reduced
	- (a) Link between P3 and R3 can be removed
		- Because P3 isn't waiting for any other resource
		- R3 is released and allocated to P2
	- (b)
		- P2 has only two of three resources it needs to finish
			- Waiting for R1
		- But R1 can't be released by P1 because P1 is waiting for R2
			- Held by P2
		- P1 can't finish because it is waiting for P2 to finish
		- P2 can't finish because it is waiting for R1
			- Circular wait

![figure 5.13](http://snag.gy/L2e3U.jpg)

### Recovery

- Once deadlock detected
	- It must be untangled
	- System returned to normal as soon as possible
- Several recovery algorithms
	- One feature in common
		- All require at least one **victim**
			- Expendable job
			- When removed, will free the system
		- Victim removal
			- Generally requires the job be restarted from either
				- Beginning
				- Convenient midpoint

#### First method

- Most drastic
- Terminate every job that is active
- Restart all from beginning

#### Second method

- Terminate only jobs involved in deadlock
- Ask users to resubmit them

#### Third method

- Identify which jobs are involved in deadlock
- Terminate them one at a time
	- Checking to see if deadlock is eliminated after each removal
	- Until deadlock resolved
- Once system freed
	- Remaining jobs allowed to complete processing
- Halted jobs will be started again from beginning at later time

#### Fourth method

- Only applicable if job keeps record of progress
	- Snapshot
- So it can be interrupted then continued without restarting from beginning
- Snapshot
	- Like landings in staircase example
	- Instead of forcing deadlocked person to return to bottom of staircase
		- Only need to retreat to nearest landing
		- Wait until others have passed
		- Then climb can be resumed
- Method is favored for long running jobs to help make a speedy recovery

#### Non deadlocked jobs

- Next two methods deal with non deadlocked jobs and resources they hold

#### Fifth method

- Selects non deadlocked job
- Preempts the resources it is holding
- Allocates them to deadlocked process
- Deadlocked process resumes execution
- Deadlock resolved

#### Sixth method

- Stops new jobs from entering system
- Allows non deadlocked jobs to run to completion so they will release their resources
- Eventually with fewer jobs in system
	- Competition for resources is decreased
- Deadlocked processes get resources they need to run to completion
- Only method that does not rely on a victim
	- Not guaranteed to work unless number of available resources is greater than the number needed by at least one of deadlocked jobs to run
		- Possible with multiple resources

#### Victim selection

- Several factors to be considered when selecting victim
- Have least negative effect on system
	- Priority of job
		- High priority left alone
	- CPU time used by the job
		- Job close to completion left alone
	- Number of other jobs that would be affected if this job were to be victimized
- Programs working with databases require special treatment
	- Database that is only partially updated is only partially correct
- Jobs that are modifying data should not be selected for termination
	- Consistency and validity of database would be jeopardized

## Starvation

- Result of conservative resource allocation
- Single job is prevented from execution
	- Kept waiting for resources that never become available

### Dining philosopher problem

- Five philosophers siting at round table
- Center of table is bowl of spaghetti
	- Accessible to everyone
- Forks on table
	- One between each philosopher
	- See figure 5.14

![figure 5.14](http://snag.gy/JjSNd.jpg)

- Local custom
	- Each philosopher must use two forks
	- Only 5 forks
		- Not 10 that would require for every person to eat simultaneously
- P1 is first to take two forks
	- F1
	- F5
- P3 takes two forks
	- F2
	- F3
- P2 unable to start eating because no forks available
	- Only remaining fork
		- F4
	- Must wait
- P3 finishes
- Resources are allocated to philosopher only when both forks are available
	- See figure 5.15

![figure 5.15](http://snag.gy/zQ94B.jpg)

- P2, P4 and P5 still waiting
- P3 decides to eat more
	- Able to use F2 and F3 again
- P1 finishes
	- Releases
		- F1 and F5
- P2 still not able to eat
	- F2 is still allocated to P3
- Scenario would continue forever
- As long as P1 and P3 alternate their use of available resources
	- P2 must wait
- P1 and P3 can eat any time
	- P2 starves
- In computer environment
	- Forks = resources
	- Philosophers = competing processes
- If resource manager doesn't
	- Watch for starving processes/jobs
	- Plan for eventual completion
	- Could remain in system forever waiting for right combination of resources

### Starvation detection algorithm

- Algorithm designed to detect starving jobs can be implemented
- Tracks how long each job has been waiting for resources
	- Same as aging
- Once starvation has been detected
	- System can block new jobs until starving jobs have been satisfied
- Algorithm must be monitored closely
	- If monitoring done too often
		- New jobs will be blocked too frequently
		- Throughput diminished
	- If not done enough
		- Starving jobs remain in system for unacceptably long time

## Conclusion

- Every OS must dynamically allocate limited number of resources
	- While avoiding
		- Deadlock
		- Starvation
- Several methods dealing with livelock/deadlocks
	- Prevention
	- Avoidance
	- Detection
	- Recovery
- Deadlocks can be prevented by
	- Not allowing four conditions of deadlock to occur in system simultaneously
		- Mutual exclusion
		- Resource holding
		- No preemption
		- Circular wait
- Disadvantage of preventive policy
	- Each condition is vital to different parts of the system at least some of the time
	- Preventive algorithms are complex
		- Routine execution involves high overhead
- If system doesn't support prevention or avoidance
	- It must be able to detect/recover from deadlocks
	- This option usually relies on selecting at least one victim
		- A job that must be terminated before it finishes execution
			- Restarted from beginning
