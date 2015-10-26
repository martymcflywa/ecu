# Chapter 4: Processor management

## Objectives

- Difference between and relations
	- Job scheduling
	- Process scheduling
- Advantages/disadvantages of process scheduling algorithms
	- Preemptive
	- Non preemptive
- Goals of process scheduling policies in single core CPUs
- Six different process scheduling algorithms
- Role of internal interrupts and tasks performed by the interrupt handler

## Introduction

- Process manager
	- Responsible for allocating processor to execute
		- Incoming jobs
		- Tasks of those jobs

## Overview

- In simple system
	- Single user
	- One processor
- Process is busy only when it is executing the user's jobs
- When there are many users
	- Multiprogramming environment
	- Multiple processes competing to be run by a single CPU
- Processor must be allocated to each job in fair and efficient manner
- Can be a complex task
	- Devoted to single processor systems

### Program

- Inactive unit
	- ie. File stored on a disk
- Not a process
- To an OS
	- A program or job
		- Is a unit of work that has been submitted by the user

### Process

- Active entity
- Requires set of resources to perform its function
	- Processor
	- Special registers
- Also called task
- Single instance of a program in execution

### Thread

- Portion of a process
- Can run independently
- Example
	- If system allows processes to have a single thread of control
		- Want to see a series of pictures on a friend's website
	- Can instruct the browser to establish one connection between the two sites
		- Download one picture at a time
	- If system allows processes to have multiple threads of control
		- Can request several pictures at the same time
		- Browser will set up multiple connections
		- Download several pictures at once

### Processor

- CPU
- Part of the machine that performs the calculations
- Executes the programs

### Multiprogramming

- Requires the processor be either
	- Allocated to each job
	- Allocated to each job process
	- For a period of time
- Deallocated at appropriate moment
- If processor is deallocated during program's execution
	- Must be done in such a way that it can be restarted later as easily as possible
- Delicate procedure
	- When interrupted for higher priority program
		- Context switch to mark last performed instruction
	- Execute higher priority program
		- Switch back to previous program

#### Processor manager events

![processor manager events](http://snag.gy/03Kdg.jpg)

- Single processor can be shared by several jobs/processes
- Only if
	- OS has
		- Scheduling policy
		- Scheduling algorithm
	- To determine when to stop working on one job and process another

## About multi core technologies

- Multi core CPUs have more than one processor on the computer chip
	- Called cores
- Multi core engineering
	- Driven by problems caused by
		- Nano sized transistors
		- Ultra close placement on chip
			- Increased
				- Current leakage
				- Heat generation
- Solution
	- Single chip with two or more processor cores
		- One piece of silicon
	- Replaced single large processor with two half sized processors or four quarter sized processors
	- Design allowed same sized chip to
		- Produce less heat
		- Offer opportunity to perform concurrent calculations

## Job scheduling vs. process scheduling

- Processor manager is composite of two sub managers
	- Job scheduler
	- Process scheduler
- Job scheduler initiates each job
	- Based on certain criteria
- Once job is selected for execution
- Process scheduler determines when each step or set of steps is executed
	- Based on certain criteria
- Each job/program passes through hierarchy of managers
	- Job scheduler encountered first
		- High level scheduler
		- Concerned with
			- Selecting jobs from queue of incoming jobs
			- Placing them in process queue
				- Based on job's characteristics
		- Goal
			- Put jobs in sequence that will use all of system resources as fully as possible
	- If job scheduler selects several jobs to run consecutively
		- Each had a lot of IO
			- Then IO devices would be kept very busy
		- CPU might be busy handling IO so little computation might get done
	- If job scheduler selects several jobs to run consecutively
		- Each had a lot of computation
			- Then CPU would be very busy dealing with computation
			- IO devices would be idle waiting for IO requests
	- Therefore
		- Job scheduler strives for balanced mix of jobs that require
			- Large amounts of IO
			- Large amounts of computation
		- Goal
			- Keep most components of the computer system busy most of the time

## Process scheduler

- After job has been placed on READY queue by job scheduler
	- Process scheduler takes over
- Determines
	- Which jobs will get the CPU
	- When
	- For how long
- Decides
	- When processing should be interrupted
	- Which queues the job should be moved to during execution
- Recognizes
	- When job has been concluded
	- When to terminate
- Low level scheduler
	- Assigns CPU to execute processes of jobs in READY queue
- Takes advantage of a common trait among programs
	- Alternate between CPU and IO cycles
- Example
	- The following job has
		- One relatively long CPU cycle
		- Two brief IO cycles

![IO and CPU cycles](http://snag.gy/waQ5n.jpg)

### Process scheduling algorithm selection

- Although duration and frequency of CPU cycles vary from program to program
	- There are general tendencies that can be exploited when selecting a scheduling algorithm
- IO bound jobs
	- Example
		- Printing series of documents
	- Brief CPU cycles
	- Long IO cycles
- CPU bound jobs
	- Example
		- Finding the first 300 prime numbers
	- Long CPU cycles
	- Brief IO cycles
- Total effect of all CPU cycles approximates a Poisson distribution curve
	- From both
		- IO bound jobs
		- CPU bound jobs
	- See figure 4.1

![figure 4.1](http://snag.gy/fBGQ7.jpg)

### Middle level scheduler

- In highly interactive environments
- In some cases or where system is overloaded
	- Middle level scheduler finds it advantageous to
		- Remove active jobs from memory to reduce degree of multiprogramming
		- Allows jobs to be completed faster
- The jobs swapped out/swapped in are managed by middle level scheduler

### Single user environment

- No distinction between job and process scheduling
	- Only one job is active in the system at given time
	- CPU and other resources are dedicated to that job/processes
		- Until job is complete

### Job and process status

- As a job moves through system
	- Is in one of five job/process status
		- HOLD
		- READY
		- RUNNING
		- WAITING
		- FINISHED
	- See figure 4.2

![figure 4.2](http://snag.gy/29iNP.jpg)

#### Job status changes in batch/interactive mode

- HOLD
	- When job is accepted by the system
	- Placed in queue
	- In some systems
		- Job spooler/disk controller creates a table
			- With characteristics of each job in queue
			- Notes important features of the job
				- Estimate of CPU time
				- Priority
				- Special IO devices required
				- Max memory required
			- Table used by job scheduler to decide which job is run next
- READY
	- When job is ready to run but waiting for CPU
	- In some systems
		- The job/process might be placed on READY list directly
- RUNNING
	- Job being processed
	- In single processor systems
		- This is one job/process
- WAITING
	- Job can't continue until
		- Specific resource is allocated
		- IO operation finished
- FINISHED
	- Job/process completed
	- Returned to user

#### Transition between status

- Initiated by either job scheduler or process scheduler
- HOLD to READY
	- Handled by job scheduler
		- According to predefined policy
	- At this point
		- Availability of enough main memory and requested devices is checked
- READY to RUNNING
	- Handled by process scheduler
		- According to predefined algorithm
			- FCFS
			- SJN
			- Priority scheduling
			- SRT
			- Round robin
- RUNNING back to READY
	- Handled by process scheduler
		- According to predefined time limit or other criteria
			- ie. Priority interrupt
- RUNNING to WAITING
	- Handled by process scheduler
	- Initiated by an instruction in the job
		- READ
		- WRITE
		- Other IO request
		- Requires page fetch
- WAITING to READY
	- Handled by process scheduler
	- Initiated by a signal from the IO device manager
		- IO request has been satisfied
		- Job can continue
	- In case of page fetch
		- Page fault handler will signal that page is now in memory
		- Process can be placed in READY queue
- RUNNING to FINISHED
	- Handled by process scheduler or job scheduler either when
		- Job is successfully completed
			- Ends execution
		- OS indicates error has occurred
			- Job terminated prematurely

### Process control blocks (PCB)

- Each process in system is represented by data structure
	- Process control block (PCB)
- Performs same function as traveler's passport
	- See figure 4.3
- Contains basic info about job
	- What it is
	- Where it is going
	- How much of its processing has been completed
	- Where it is stored
	- How much it has spent in resources

![figure 4.3](http://snag.gy/y1nus.jpg)

#### Process identification

- Job is uniquely identified by
	- User's identification
	- Pointer connecting it to its descriptor
		- Supplied by job scheduler when
			- Job first enters the system
			- Placed on HOLD

#### Process status

- Indicates
	- Current status of job
		- HOLD
		- READY
		- RUNNING
		- WAITING
	- Resources responsible for that status

#### Process state

- Contains all info needed to indicate current state of the job

##### Process status word

- Current instruction counter
- Register contents
- When the job isn't running but is either on
	- HOLD
	- READY
	- WAITING
- If job is RUNNING
	- This information is left undefined

##### Register contents

- Contents of the register if the job has been interrupted
	- Waiting to resume processing

##### Main memory

- Includes
	- Address where the job is stored
	- Virtual memory
		- Mapping between virtual and physical mem locations

##### Resources

- Information about all resources allocated to this job
- Each resource has
	- Identification field
		- Listing its type
	- Description field
		- Details of allocation
			- ie. Sector address on disk
- Resource can be
	- Hardware units
		- Disk drives
		- Printers
	- Files

##### Process priority

- Used by systems using priority scheduling algorithm
	- To select which job to run next

#### Accounting

- Contains information used for
	- Billing purposes
	- Performance measurement
- Indicates
	- Kind of resources used for job
	- For how long
- Typical charges include
	- Amount of CPU time used from start to end of execution
	- Total time job was in system until exited
	- Main storage occupancy
		- How long job stayed in memory until end of execution
		- Combination of time and space used
		- Example
			- Paging system may record units of page seconds
	- Secondary storage used during execution
		- Recorded as combination of time and space used
	- System programs used
		- Compilers
		- Editors
		- Utilities
	- Number and type of IO operations
		- IO transmission time
		- Utilization of
			- Channels
			- Control units
			- Devices
	- Time spent waiting for IO completion
	- Number of input records reads
		- Either from
			- Online
			- Coming from
				- Optical scanners
				- Card readers
				- Other input devices
		- Number of output records written

### PCBs and queuing

- Job's PCB is created when job scheduler accepts the job
	- Updated as the job progresses from beginning to end of execution
- Queues
	- Use PCBs to track jobs similar to customs officials using passports to track international visitors
	- PCB contains all data about the job needed by OS to manage the processing of the job
	- As job moves through system
		- Progress is noted in PCB
- The PCBs, not the jobs are linked to form the queues
	- See Figure 4.4
	- PCBs for every ready on are linked on the READY queue
	- PCBs for jobs just entering the system are linked on the HOLD queue
	- Jobs that are WAITING
		- Linked together by "reason for waiting"
			- So PCBs for jobs that are waiting for specific IO are linked together
- Queues need to be managed in an orderly fashion
	- Determined by the process scheduling policy/algorithms

![figure 4.4](http://snag.gy/A47Qi.jpg)

## Process scheduling policies

- Multiprogramming environment
	- Usually more jobs to be executed than could possibly be run at one time
	- Before OS can schedule them
		- Needs to resolve three limitations of system
			- There are finite number of resources
				- Disk drives
				- Printers
				- Tape drives
			- Some resources once allocated, cannot be shared with another job
				- Printers
			- Some resources require operator intervention
				- They can't be reassigned automatically from job to job
					- Tape drives

### Scheduling policy criteria

- Some contradict each other
- Maximize throughput
	- Run as many jobs as possible in given amount of time
	- Can be accomplished easily by
		- Running only short jobs
		- Running jobs without interruption
- Minimize response time
	- Quickly turn around interactive requests
	- Could be done by running only interactive jobs
	- Let batch jobs wait until interactive load ceases
- Minimize turnaround time
	- Move entire jobs in/out of system quickly
	- Could be done by running all batch jobs first
		- Batch jobs can be grouped to run more efficiently than interactive jobs
- Minimize wait time
	- Move jobs out of READY queue as soon as possible
	- Could be done by reducing number of users allowed on system
		- So CPU would be available immediately whenever job enters READY queue
- Maximize CPU efficiency
	- Keep CPU busy 100% of time
	- Could be done by running CPU bound jobs
		- Not IO bound jobs
- Ensure fairness for all jobs
	- Give everyone equal amount of CPU and IO time
	- Could be done by not giving special treatment to any job
		- Regardless of processing characteristics/priority

#### Scheduling policy selection decision

- From list above
	- If system favors one type of user
		- It hurts another
		- Or doesn't efficiently use its resources
- Final decision
	- Rests with system designer
	- Must determine which criteria are most important for specific system
- Example
	- Decide to
		- Maximize CPU utilization
		- Minimize response time
		- Balance use of all system components through mix of
			- IO bound jobs
			- CPU bound jobs
	- Select scheduling policy that most closely fits criteria

#### Timing mechanism

- Although job scheduler selects jobs to ensure that READY and IO queues remain balanced
	- There are instances when a job claims the CPU for very long time before issuing an IO request
	- If IO requests are being satisfied
		- ie. Done by an IO controller
		- Extensive use of CPU will build up the READY queue while emptying IO queues
			- Creates unacceptable balance in system
- To solve problem
	- Process scheduler often uses a timing mechanism
	- Periodically interrupts running processes when predetermined slice of time has expired
- Scheduler suspends all activity on the job currently running
	- Reschedules it into READY queue
		- Will be continued later
	- CPU is now allocated to another job that runs until either
		- Exceeds time out
			- Moves to READY queue
		- Job issues IO command
			- Moves to WAIT queue
		- Job is finished
			- Moves to FINISHED queue
	- An IO request is called a **natural wait** in multiprogramming environments
		- Allows processor to be allocated to another job

#### Preemptive and non preemptive scheduling policies

- Preemptive scheduling policy
	- Interrupts processing of a job
	- Transfers CPU to another job
- Non preemptive scheduling policy
	- Functions without interrupts
		- External to job
	- Once job captures the processor and begins execution
		- It remains in RUNNING state uninterrupted
		- Until
			- It issues IO request
				- Natural wait
			- It is finished
				- Exceptions made for infinite loops
					- Interrupted by both preemptive and non preemptive policies

## Process scheduling algorithms

- Allocates CPU and moves jobs through the system
- Early OS
	- Used non preemptive policies
	- Designed to move batch jobs through system as efficiently as possible
- Most current systems
	- Emphasis on interactive use and response time
	- Use algorithm that takes care of immediate requests of interactive users
- Six process scheduling algorithms that have been used extensively

### First come first served (FCFS)

- Non preemptive
- Handles jobs according to arrival time
	- Earlier they arrive
	- Sooner they are served
- Simple to implement
	- Uses FIFO queue
- Turnaround time unpredictable
- Fine for most batch systems
- Unacceptable for interactive systems
	- Quick response times expected
- As new job enters system
	- PCB is linked to end of READY queue
	- Removed from front of queue when processor becomes available
	- After it has processed all other jobs ahead of it in queue
- In strictly FCFS systems
	- No WAIT queues
		- Each job is run to completion
	- There may be systems in which control (context) is switched on a natural wait (IO request)
		- Then job resumes on IO completion

#### Example

- Strictly FCFS environment
	- No multiprogramming
- Job A
	- CPU cycle 15 ms
- Job B
	- CPU cycle 2 ms
- Job C
	- CPU cycle 1 ms
- For each job
	- CPU cycle contains both actual CPU usage and IO requests
		- Total run time
- Using FCFS algorithm with arrival sequence of ABC
	- Timeline is shown in figure 4.5

![figure 4.5](http://snag.gy/uvNv3.jpg)

- If all three jobs arrive almost simultaneously
	- We can calculate that the turnaround time
		- Job A = 15
		- Job B = 17
		- Job C = 18
	- Average turnaround time is:

![average turnaround time 1](http://snag.gy/r4HKk.jpg)

- However, if jobs arrived in different order
	- CBA
	- Then results using same FCFS algorithm will be as shown in figure 4.6

![figure 4.6](http://snag.gy/Ho8ac.jpg)

- In this example
	- Turnaround time is
		- Job A = 18
		- Job B = 3
		- Job C = 1
	- Average turnaround time is:

![average turnaround time 2](http://snag.gy/BCwxN.jpg)

#### FCFS Disadvantage

- Examples above
	- Improvement of turnaround time between first and second examples
- Average turnaround times vary widely
- Seldom minimized
- When there are three jobs in READY queue
	- System has only 1 in 6 chance of running the jobs in most advantageous sequence
		- CBA
	- With four jobs
		- Odds fall to 1 in 24
			- And so on
- If one job monopolizes the system
	- Extent of its overall effect on system performance depends on
		- Scheduling policy
		- Whether job is
			- CPU bound
			- IO bound
- While a job with long CPU cycle is using the CPU
	- Other jobs in system are waiting for processing or finishing their IO requests
		- If IO controller is used
	- And joining the READY queue to wait for their turn to use the processor
- If IO requests are not being serviced
	- IO queues would remain stable while READY queue list grew with new arrivals
- In extreme cases
	- READY queue could fill to capacity
	- While IO queues would be empty or stable
		- IO devices would sit idle
- If job is processing lengthy IO cycle
	- IO queues quickly build to overflowing
	- CPU could be idle
		- If IO controller is used
- Situation is eventually resolved when IO bound job finishes its IO cycle
	- Queues start moving again
	- System can recover from bottleneck
- In a strictly FCFS algorithm
	- Neither situation occurs
	- However turnaround time is variable
		- Unpredictable
	- For this reason
		- FCFS is less attractive algorithm than one that would serve the shortest job first

### Shortest job next (SJN)

- Non preemptive
- Also known as shortest job first (SJF)
- Handles jobs based on length of CPU cycle time
- Easiest to implement in batch environments
	- Where estimated CPU time required to run job is given in advance by each user at start of each job
- Doesn't work in interactive systems
	- Users don't estimate in advance the CPU time required

#### Example

- Four batch jobs
- All in READY queue
- Job A = 5
- Job B = 2
- Job C = 6
- Job D = 4
- SJN algorithm
	- Reviews four jobs
	- Schedules them for processing in following order
		- BDAC
		- See figure 4.7

![figure 4.7](http://snag.gy/zoxEM.jpg)

- Average turnaround time:

![average 1](http://snag.gy/YGBrI.jpg)

#### Why algorithm consistently gives min average turnaround times

- See figure 4.7
	- Job B finishes in given time
		- 2
	- Job D finishes in given time + job B time
		- 4 + 2
	- Job A finishes in given time + job B + job D time
		- 5 + 4 + 2
	- Job C finishes in given time + job B + job D + job A time
		- 6 + 5 + 4 + 2
	- When calculating average:

![average 2](http://snag.gy/uMEuD.jpg)

- Time for first job appears in equation 4 times
	- Once for each job
- Similarly
	- Time for second job appears 3 times
		- (number of jobs) - 1
	- Time for third job appears 2 times
		- (number of jobs) - 2
	- Time for fourth job appears once
		- (number of jobs) - 3
- Above equation can be rewritten as:

![average 3](http://snag.gy/3UzWt.jpg)

- Because the time for the first job appears in the equation 4 times
	- It has 4 times the effect on average time than does the length of the fourth job
		- Only appears once
- Therefore
	- If first job requires the shortest computation time
		- Followed in turn by the other jobs
			- Ordered shortest to longest
		- Then result will be the smallest possible average
	- Formula for average is:

![average formula](http://snag.gy/DAVJe.jpg)

- Where
	- n = number of jobs in queue
	- t<sub>i</sub>(j = 1, 2, 3, ... n) is the length of the CPU cycle for each of the jobs

#### SJN disadvantage

- Only optimal only when all of the jobs are available at the same time
- CPU estimates are available and accurate

### Priority scheduling

- Non preemptive algorithm
- One of most used algorithms in batch systems
	- May give slower turnaround to some users
- Gives preferential treatment to important jobs
- Allows programs with highest priority to be processed first
	- Are not interrupted until either
		- CPU cycles completed
		- Natural wait occurs
- If two or more jobs with equal priority are present in READY queue
	- Processor is allocated to job that arrived first
		- FCFS within priority

#### Priority assignment

- Can be assigned by sys admin
	- Uses characteristics extrinsic to jobs
- Example
	- Can be assigned based on position of user
		- Researchers first
		- Students last
	- In commercial environments
		- Can be purchased by user who pay more for higher priority
			- Guarantees fastest possible processing of jobs
- Within priority algorithm
	- Jobs are usually linked to one of several READY queues by job scheduler
		- Based on priority
	- So process scheduler manages multiple READY queues instead of just one
- Priorities can also be determined by process manager based on characteristics intrinsic to the jobs
	- Memory requirements
		- Jobs requiring large amounts of memory could be allocated lower priorities than those requiring less memory
			- Or vice versa
		- Number and type of peripheral devices
			- Jobs requiring many peripheral devices would be allocated lower priorities than those requesting fewer devices
		- Total CPU time
			- Jobs having a longer CPU cycle or estimated run time given lower priorities than those with shorter run times
		- Amount of time already spent in system
			- Total amount of elapsed time since job was accepted for processing
			- Some systems increase priority of jobs that have been in system for unusually long time to expedite their exit
			- Known as **aging**
- These criteria could be used to determine default priorities in many systems
- Default priorities can be overruled by specific priorities named by users
- There are also preemptive priority schemes

### Shortest remaining time (SRT)

- Preemptive version of shortest job next (SJN)
- Processor is allocated to the job closest to completion
	- Even this job can be preempted if a newer job in READY queue has a time to completion that is shorter
- Cannot be implemented in an interactive system
	- Requires advanced knowledge of the CPU time required to finish each job
- Often used in batch environments
	- When desirable to give preference to short jobs
- Involves more overhead than SJN
	- Because OS has to frequently monitor CPU time for all jobs in READY queue
	- Must perform context switching for jobs being swapped at preemption time
		- Not necessarily swapped out to disk
			- But might occur

#### Example

- Figure 4.8 shows how SRT algorithm works with four jobs that arrived in quick succession
	- One CPU cycle apart

![figure 4.8](http://snag.gy/mIwme.jpg)

- Job A
	- Arrival time = 0
	- CPU cycle = 6
- Job B
	- Arrival time = 1
	- CPU cycle = 3
- Job C
	- Arrival time = 2
	- CPU cycle = 1
- Job D
	- Arrival time = 3
	- CPU cycle = 4
- In this case
	- Turnaround time is the completion of each job minus arrival time
	- Job A = 14
	- Job B = 4
	- Job C = 1
	- Job D = 6
- So average turnaround time is:

![average 1](http://snag.gy/Esr2G.jpg)

#### SRT vs. SJN

- How does that compare to same problem using non preemptive SJN policy?
	- Figure 4.9 shows same situation using SJN

![figure 4.9](http://snag.gy/xYR1s.jpg)

- In this case, turnaround time is
	- Job A = 6
	- Job B = 9
	- Job C = 5
	- Job D = 11
- So average turnaround time is:

![average 2](http://snag.gy/viV0m.jpg)

- Note in figure 4.9
	- Initially A is the only job in READY queue
		- So it runs first
		- Continues until it's finished
			- Because SJN is non preemptive
	- Next job to be rune is C
		- Because when job A is finished
			- At time 6
		- All other jobs have arrived
			- B, C, D
		- Of those three
			- C had shortest CPU cycle
			- So was selected to run next
		- Then B
		- Then D
- Therefore with this example
	- SRT at 6.25 is faster than SJN at 7.75
- However we neglected to include the time required by SRT algorithm to perform context switching

#### Context switching

- Required by all preemptive algorithms
- When job A is preempted
	- All of its processing information must be saved in its PCB for later
		- When job A's execution is continued
	- All contents of job B's PCB are loaded into appropriate registers so it can start running again
- Later when job A is once again assigned to the processor
	- Another context switch is performed
	- This time the information the preempted job in its PCB
	- Contents of job A's PCB are loaded into the appropriate registers
- How context switching is done depends on CPU architecture
	- In many systems
		- There are special instructions that provide quick saving and restoring of information
- Switching is designed to be performed efficiently
	- But no matter how fast it is
		- It still takes valuable CPU time
- So although SRT appears to be faster
	- In a real OS
		- It's advantages are diminished by time spent in context switching
- A precise comparison of SRT and SJN would have to include
	- Time required to do context switching

### Round robin

- Preemptive
- Used extensively in interactive systems
- Easy to implement
- Isn't based on job characteristics
- Based on predetermined slice of time that is given to each job
	- Ensures that CPU is equally shared among active processes
	- Isn't monopolized by any one job
- Time quantum
	- Time slice
	- Size is crucial to performance of system
	- Varies between 100 ms to 1 or 2 seconds
- Jobs are placed in READY queue using FCFS scheme
	- Process scheduler selects first job from front of queue
	- Sets timer for time quantum
	- Allocates CPU to job
	- If processing isn't finished when time quantum expires
		- Job is preempted
		- Put at end of READY queue
		- Information saved in PCB
- If job's CPU cycle is shorter than time quantum
	- If this is job's last CPU cycle and job is finished
		- All resources allocated to it are released
		- Completed job returned to user
	- If CPU cycle has been interrupted by IO request
		- Information about job is saved in PCB
		- Linked at the end of appropriate IO queue
		- When IO request has been satisfied
			- It is returned to end of READY queue
			- Wait reallocation of CPU

#### Example

![figure 4.10](http://snag.gy/tQDXi.jpg)

- Figure 4.10 shows round robin algorithm with time slice of 4ms
	- IO requests ignored
- Job A
	- Arrival = 0
	- Cycle = 8
- Job B
	- Arrival = 1
	- Cycle = 4
- Job C
	- Arrival = 2
	- Cycle = 9
- Job D
	- Arrival = 3
	- Cycle = 5
- Turnaround time
	- Job A = 20
	- Job B = 7
	- Job C = 24
	- Job D = 22
- Average turnaround time:

![average turnaround](http://snag.gy/pvNcc.jpg)

- Note in figure 4.10
	- Job A was preempted once because it needed 8ms to complete its CPU cycle
	- Job B was terminated in just one time quantum
	- Job C was preempted twice because it needed 9ms
	- Job D was preempted once because it needed 5ms
	- In last execution or swap into memory
		- Both jobs D and C used the CPU for only 1ms and terminated before last time quantum expired
			- Released CPU sooner

#### Round robin efficiency

- Depends on size of time quantum in relation to average CPU cycle
- If quantum too large
	- Algorithm reduced to FCFS scheme
- If quantum too small
	- Amount of context switching dramatically increased
	- Slows down execution of jobs
	- Amount of overhead increased
	- See figure 4.11
		- Job A CPU cycle = 8ms
	- Amount of context switching increases as time quantum decreases in size

#### Time quantum considerations

![figure 4.11](http://snag.gy/1sxvH.jpg)

- First case (a) has time quantum of 10ms
	- No context switching
	- No overhead
	- CPU cycle ends shortly after time quantum expires
	- Jobs run to completion
	- For this job with this time quantum
		- No difference between round robin and FCFS algorithm
- Second case (b) has time quantum 5ms
	- One context switch
	- Job is preempted once when time quantum expires
	- Some overhead for context switch
	- Would be delayed turnaround based on the number of other jobs in system
- Third case (c) has time quantum 1ms
	- 10 context switches
	- Job is preempted when time quantum expires
	- Overhead becomes costly
	- Turnaround time suffers
- What is best time quantum size
	- Depends on the system
	- If interactive
		- System is expected to respond quickly to users
			- When they make simple requests
	- If batch system
		- Response time not a factor
		- Turnaround is a factor
		- Overhead becomes very important
- Rules of thumb for time quantum selection
	- It should be long enough to allow 80% of CPU cycles to run to completion
	- Should be at least 100 times longer than time required to perform one context switch

### Multiple level queues

- Not a separate scheduling algorithm
- Works in conjunction with several schemes previously discussed
	- Priority based system
	- Different queues for each priority level
- Found in systems with jobs that can be grouped according to common characteristic
- Example
	- System which gathers
		- CPU bound jobs in one queue
		- IO bound jobs in another
		- Process scheduler then alternately selects jobs from each queue to keep system balanced
	- Hybrid environment supporting interactive and batch jobs
		- Batch jobs put in one queue
			- Called background queue
		- Interactive jobs in another queue
			- Called foreground queue
			- Treated more favorably than background queue
- Common
	- Scheduling policy is based on some predetermined scheme
	- Allocates special treatment to jobs in each queue
	- Within each queue
		- Jobs served in FCFS method
- Raises questions
	- Is processor allocated to the jobs in the first queue until it is empty before moving to the next queue?
		- Or does it travel from queue to queue until last job on last queue has been served and then go back to serve the first job in the first queue?
	- Is this fair to those who have earned/paid for higher priority?
	- Is it fair to those in low priority queue?
	- If the processor is allocated to the jobs on first queue and never empties out
		- When will jobs in the last queues be served?
	- Can jobs in the last queues get "time off for good behavior" and upgrade to better queues?
- Answers depend on policy used by system to service queues
- Four primary methods to movement
	- Not allowing movement between queues
	- Moving jobs from queue to queue
	- Moving jobs from queue to queue and increasing time quantums for lower queues
	- Giving special treatment to jobs that are aging

#### Case 1: No movement between queues

- Simple policy
- Rewards those who have high priority jobs
- Processor is allocated to jobs in high priority queue as FCFS
- Allocated to jobs in low priority queues only when high priority queues are empty
- Policy can be justified if there are relatively few users with high priority jobs
	- Top queues quickly empty out
	- Allows processor to spend most of time running low priority jobs

#### Case 2: Movement between queues

- Adjust priorities assigned to each job
- High priority jobs treated like all others once they are in the system
	- Initial priority may be favorable
- When time quantum interrupt occurs
	- Job is preempted and moved to end of next lower queue
	- Job may also have priority increased
		- ie. When it issues an IO request before time quantum has expired
- Policy is fairest in system which jobs are handled according to computing cycle characteristics
	- CPU bound
	- IO bound
- Assumes that a job that exceeds its time quantum is CPU bound
	- Will require more CPU allocation that one that requests IO before time quantum expires
- Therefore
	- CPU bound jobs are placed at the end of the next lower level queue when they're preempted
		- Because of the expiration of time quantum
	- IO bound jobs are returned to end of next higher level queue once IO request has finished
- Facilitates IO bound jobs
	- Good in interactive systems

#### Case 3: Variable time quantum per queue

- Variation of movement between queues policy
- Allows for faster turnaround of CPU bound jobs
- Each of the queues is given a time quantum twice as long as previous queues
- If a job doesn't finish its CPU cycle in first time quantum
	- It is moved to end of next lower level queue
	- When processor is next allocated to it
		- Job executes with twice as longer time quantum
- CPU bound job can execute for longer and longer periods of time
	- Improving its chances of finishing faster

#### Case 4: Aging

- Used to ensure that jobs in lower level queues will eventually complete execution
- OS keeps track of each job's waiting time
- When a job gets too old
	- When it reaches time limit
- System moves job to next highest queue
	- Until it reaches top queue
- A more drastic age policy
	- Moves old job directly from lowest queue to top queue
- Regardless of implementation
	- Aging policy guards against indefinite postmonment of unweildy jobs
	- Indefinite postponment
		- Job's execution is delayed for undefined amount of time
		- Repeatedly preempted so other jobs can be processed
		- Could eventually lead to job's starvation
		- Major problem when allocating resources

## Interrupts

- Page interrupt
- Time quantum expiration
- IO interrupts
	- Issued when READ/WRITE commands issued
- Internal interrupts
	- Also known as synchronous interrupts
	- Occur as direct result of the arithmetic operation/job instruction being processed
- Illegal arithmetic operations can generate interrupts
	- Division by zero
	- Floating point ops generating over/underflow
	- Fixed point addition/subtraction causing overflow
- Illegal job instructions can generate interrupts
	- Attempts to access protected/non existent memory locations
	- Attempts to use an undefined op code
	- Operating on invalid data
	- Attempts to make system changes
		- Trying to change size of time quantum

### Interrupt handler

- Handles interruption sequence of events
- When OS detects non recoverable error
- Interrupt handler typically follows this sequence
	1. Type of interrupt is described and stored
		- Passed on to user as an error message
	2. State of interrupted process is saved
		- Includes
			- Value of program counter
			- Mode specification
			- Contents of registers
	3. Interrupt is processed
		- Error message and state of interrupted process sent to user
		- Program execution is stopped
		- Any resources allocated to job are released
		- Job exists system
	4. Processor resumes normal operation
- If dealing with internal interrupts only
	- Non recoverable
	- Job is terminated in step 3
- When working with IO interrupt, time quantum or other recoverable interrupt
	- Step 3 halts job
	- Moves it to appropriate IO device queue or READY queue
	- When IO request is finished
	- Job is returned to READY queue
- If was quantum interrupt
	- Job/process is already in READY queue

## Comparison of scheduling algorithms

![figure 4.1](http://snag.gy/dCEtz.jpg)
