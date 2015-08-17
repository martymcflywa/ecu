# Processor management

## Objectievs

- Difference between job scheduling and process scheduling and how they relate
- Advantages / disadvantages of process scheduling algorithms that are pre-emptive vs. non pre-emptive
- Goals of process scheduling policies in single-core CPUs
- Up to six different process scheduling algorithms
- Role of internal interrupts and the tasks performed by the interrupt handler

## Overview

- **Single-user systems: Two states**
	- Busy state
		- Executing a job
	- Idle state
		- All other times
	- Simple processor management
- **Program: Job**
	- Inactive unit
		- File stored on a disk
	- A unit of work submitted by a user
		- Not a process
- **Process: Task**
	- Active entity
		- Requires resources to perform function
		- Processor and special registers
	- Executable program single instance
- **Thread:**
	- Portion of a process
	- Runs independently
- **Processor**
	- Central processing unit (CPU)
	- Performs calculations and executes programs
- **Multiprogramming environment**
	- Processor allocated for a time period
	- Deallocated at appropriate moment
		- Delicate task
- **Interrupt**
	- Call for help
	- Activates higher-priority program
- **Context switch**
	- Saving job processing information when interrupted
- **Single processor**
	- May be shared by several jobs
		- Processes
	- Requires scheduling policy and scheduling algorithm

### About multi-core technologies

- **Processor: Core**
	- Located on chip
- **Multi-core CPU: More than one processor**
	- Dual core
	- Quad core
- Single chip may contain multiple cores
	- Multi-core engineering
		- Resolves leakage and heat problems
		- Multiple calculations may occur simultaneously
		- More complex than single core
			- Discussed in module 6

## Job scheduling vs. process scheduling

- Process manager
	- Composite of two submanagers
		- Hierarchy between them
- **Job scheduler: High level scheduler**
	- Job scheduling responsibilities
	- Job initiation based on certain criteria
- **Process scheduler: Lower level scheduler**
	- Process scheduling responsibilities
	- Determines execution steps
	- Process scheduling based on certain criteria

### Job scheduler

#### Functions

- Selects incoming job from queue
- Places in process queue
- Decides on job initiation criteria
	- Process scheduling algorithm and priority

#### Goal

- Sequence jobs
	- Efficient system resource utilization
- Balance I/O interaction and computation
- Keep most system components busy most of the time

### Process scheduling

>The focus of this module

#### Functions

- Determines job to get CPU resource
	- When and how long
- Decides interrupt processing
- Determines queues for job movement during execution
- Recognizes job conclusion
	- Determines job termination

#### Goals

- Lower-level scheduler in hierarchy
- Exploits common computer program traits
	- Program alternates between two cycles
		- CPU and I/O cycles
		- Frequency and CPU cycle duration vary

#### Cycle distribution

- General tendencies exist
- **I/O bound job***
	- Many brief CPU cycles
	- Long I/O cycles
		- ie. Printing documents
- **CPU bound job**
	- Many long CPU cycles
	- Shorter I/O cycles
		- ie. Math calculation
- **Poisson distribution curve**
	- CPU cycles from I/O bound and CPU bound jobs

![cpu cycles poisson distribution](http://snag.gy/PAf5U.jpg)

#### Middle level scheduler

- Third layer
- Found in highly interactive environments
	- Handles overloading
		- Removes active jobs from memory
		- Reduces degree of multiprogramming
	- Results in faster job completion

#### Single user environment

- No distinction between job and process scheduling
- One job active at a time
	- Receives dedicated system resources for job duration

## Job and process status

- Jobs move through the system
- Have five states:
	- `HOLD`
	- `READY`
	- `WAITING`
	- `RUNNING`
	- `FINISHED`
- These are called **job status** or **process status**

### Status step through

![job and process status](http://snag.gy/MmWYV.jpg)

- User submits job (batch/interactive)
- Job accepted
	- Put on `HOLD`
	- Placed in queue
- Job state changes from `HOLD` to `READY`
	- Indicates job is waiting for CPU
- Job state changes from `READY` to `RUNNING`
	- When selected for CPU and processing
- Job state changes from `RUNNING` to `WAITING`
	- Requires unavailable resources
- Job state changes to `FINISHED`
	- Job completed
		- Successfully or unsuccessfully

### Status responsibilities

- **Job scheduler (JS)** or **Process scheduler (PS)** incurs state transition responsibility
- `HOLD` to `READY`
	- JS initiates using predefined policy
- `READY` to `RUNNING`
	- PS initiates using predefined algorithm
- `RUNNING` back to `READY`
	- PS initiates according to predefined time limit or other criterion
- `RUNNING` to `WAITING`
	- PS initiates by instruction in job
- `WAITING` to `READY`
	- PS initiates by signal from I/O device manager
	- Signal indicates I/O request satisfied
	- Job continues
- `RUNNING` to `FINISHED`
	- PS or JS initiates upon job completion
	- Satisfactorily or with error

## Process control blocks (PCB)

- Data structure
- Contains basic job information
	- What is it
	- Where is it going
	- How much processing completed
	- Where stored
	- How much time spent using resources

### PCB components

- Process identification
	- Unique
- Process status
	- Job state
		- `HOLD`
		- `READY`
		- `RUNNING`
		- `WAITING`
- Process state
	- Process status word registers
		- Contents
		- Main memory info
		- Resources
		- Process priority
- Accounting
	- Billing and performance measurements
	- CPU time
	- Total time
	- Memory occupancy
	- I/O operations
	- Number of input records read
	- etc.

![contents of job pcb](http://snag.gy/pHHa7.jpg)

### PCBs and queueing

- Job PCB
	- Created when job scheduler (JS) accepts job
	- Updates as job executes
	- **Queues** use PCB to track jobs
	- Contains all necessary job management processing data
	- PCBs linked to form queues
		- Jobs not linked
	- Manage queues using process scheduling policies and algorithms

![queuing paths](http://snag.gy/bNpho.jpg)

## Process scheduling policies

- Muliprogramming environment
	- More jobs than resources at any given time
- Operating system pre-scheduling task
	- Resolves three system limitations
		- Finite number of resources
			- Disk drives
			- Printers
			- Tape drives
		- Some resources cannot be shared once allocated
			- Printers
		- Some resources require operator intervention
			- Tape drive

### Process scheduling criteria

- Maximize throughput
	- Run as many jobs as possible in given amount of time
- Minimize response time
	- Quickly turn around interactive requests
- Minimize turnaround time
	- Move entire job in and out of system quickly
- Minimize wait time
	- Move job out of `READY` queue quickly
- Maximize CPU efficiency
	- Keep CPU busy 100% of the time
- Ensure fairness for all jobs
	- Give every job equal CPU and I/O time
- Final policy criteria decision in designer's hands

### Process scheduling problem

- Job claims CPU for very long time before I/O request issued
	- Builds up `READY` queue and empties I/O queues
	- Creates unacceptable system imbalanace
- Corrective measure
	- **Interrupt**
		- Used by the process scheduler upon predetermined expiration of time slice
		- Current job activity suspended
		- Reschedules job into `READY` queue

### Types of scheduling policies

#### Preemptive

- Used in time sharing environments
- Interrupts job processing
- Transfers CPU to another job
- Infinite loops interrupted

#### Non preemptive

- Functions without external interrupts
- Infinite loops interrupted

## Process scheduling algorithms

- Based on specific policy
	- Allocate CPU and move job through system
- Six algorithm types
	- FCFS
		- First come, first served
	- SJN
		- Shortest job next
	- Priority scheduling
	- SRT
		- Shortest remaining time
	- Round robin
	- Multiple level queues
- Current systems emphasize interactive use and response time
	- Use **preemptive** policies

### FCFS: First come, first served

![fcfs](http://snag.gy/1UG23.jpg)

- Non preemptive
- Job handled based on arrival time
	- Earlier job arrives
	- Earlier served
- Simple algorithm implementation
	- Uses FIFO queue
- Good for batch systems
- Unacceptable in interactive systems
	- Unpredictable turnaround time
- Disadvantages
	- Average turnaround time varies
		- Seldom minimized

### SJN: Shortest job next

![sjn](http://snag.gy/Vixow.jpg)

- Non preemptive
- Also known as **SJF: Shortest job first**
- Job handled based on length of CPU cycle time
- Easy implementation in batch environment
	- CPU time requirement known in advance
- Does not work well in interactive systems
- Optimal algorithm
	- All jobs are available at same time
	- CPU estimates available and accurate

### Priority scheduling

- Non preemptive
- Preferential treatment for important jobs
	- Highest priority programs processed first
	- No interrupts until CPU cycles completed or natural wait occurs
- `READY` queue may contain two or more jobs with equal priority
	- Uses FCFS policy within priority
- System administrator or process manager use different methods of assigning priorities

#### Processor manager priority assignment methods

- Memory requirements
	- Jobs requiring large amounts of memory
		- Allocated lower priorities
	- Vice versa
- Number and type of peripheral devices
	- Jobs requiring many peripheral devices
		- Allocated lower priorities
	- Vice versa
- Total CPU time
	- Jobs having a long CPU cycle
		- Allocated lower priorities
	- Vice versa
- Amount of time already spent in system (aging)
	- Total time elapsed since job accepted for processing
	- Increase priority if job in system for unusually long time

### SRT: Shortest remaining time

![srt]()

- Preemptive version of shortest job next (SJN)
- Processor allocated to job closest to completion
	- Preemptive if newer job has shorter completion time
- Often used in batch environments
	- Short jobs given priority
- Cannot implement in interactive system
	- Requires advance CPU time knowledge
- Involves more overhead than SJN
	- System monitors CPU time for `READY` queue jobs
	- Performs context switching

### Round robin

![round robin](http://snag.gy/86hmc.jpg)

- Preemptive
- Used extremely in interactive systems
- Based on predetermined slice of time
	- Each job assigned **time quantum**
- Time quantum size
	- Crucial to system performance
	- Varies from 100ms to 1-2 seconds
- CPU equally shared among all active processes
	- Not monopolized by one job

#### Round robin process

- Job placed on `READY` queue
	- FCFS scheme
- Process scheduler selects first job
	- Sets timer to time quantum
	- Allocates CPU
- Timer expires
- If job CPU cycle > time quantum
	- Job preempted and placed at end of `READY` queue
	- Information saved in PCB
- If job CPU cycle < time quantum
	- Job finished
		- Allocated resources released
		- Job returned to user
	- Interrupted by I/O request
		- Information saved in PCB
		- Linked to I/O queue
	- Once I/O request satisfied
		- Job returns to end of `READY` queue
		- Awaits CPU

#### Round robin quantum time

![round robin quantum time](http://snag.gy/QB2cf.jpg)

- Efficiency depends on time quantum size
	- In relation to average CPU cycle
- Quantum too large (larger than most CPU cycles)
	- Algorithm reduces to FCFS scheme
- Quantum too small
	- Context switching occurs
		- Job execution slows down
		- Overhead dramatically increased
- Best quantum time size
	- Depends on the system
		- Interactive
			- Key factor is response time
		- Batch
			- Key factor is turnaround
	- General rule of thumb
		- Long enough for 80% of CPU cycles to complete
		- At least 100 times longer than context switch time requirement

### Multiple level queues

- Works in conjunction with several other schemes
- Works well in systems with jobs grouped by common characteristics
	- Priority based
		- Different queues for each priority level
	- CPU bound jobs in one queue
	- I/O bound jobs in another queue
	- Hybrid environment
		- Batch jobs in background queue
		- Interactive jobs in foreground queue
- Scheduling policy based on predetermined scheme
- Four primary methods

#### Case 1: No movement between queues

- Simple
- Rewards high priority jobs
	- Processor allocated using FCFS
- Processor allocated to lower priority jobs
	- Only when high priority queues empty
- Good environment
	- Few high priority jobs
	- Spend more time with low priority jobs

#### Case 2: Movement between queues

- Processor adjusts priorities assigned to each job
- High priority jobs
	- Initial priority favourable
		- Treated like all other jobs afterwards
- Quantum interrupt
	- Job preempted
		- Moved to next lower queue
		- May have priority increased
- Good environment
	- Jobs handled by cycle characteristics
		- CPU or I/O
	- Interactive systems

#### Case 3: Variable time quantum per queue

- Case 2 variation: Movement between queues
- Each queue given time quantum size
	- Size twice as long as previous queue
- Fast turnaround for CPU bound jobs
- CPU bound jobs execute longer and given longer time periods
	- Improves chance of finishing faster

#### Case 4: Aging

- Ensures lower level queue jobs eventually complete execution
- System keeps track of job wait time
- If too old
	- System moves job to next highest queue
	- Continues until old job reaches top queue
	- May drastically move old job to highest queue
- Advantage
	- Guards against indefinite, unwieldy job postponement
		- Major problem discussed in module 5

## Interrupts

- Interrupt types
	- Page interrupt (memory manager)
		- Accommodate job requests
	- Time quantum expiration interrupt
	- I/O interrupt
		- Results from `READ` or `WRITE` command issuance
	- Internal interrupt
		- Synchronous
		- Result from arithmetic operation or job instruction
	- Illegal arithmetic operation interrupt
		- Divide by zero
		- Bad floating point operation
	- Illegal job instruction interrupt
		- Protected storage access attempt
	- Interrupt handler
		- Control program
			- Handles interruption event sequence

## Summary

- Processor manager allocates CPU among all users
- Job scheduler
	- Assigns job to `READY` queue
		- Based on characteristics
- Process scheduler
	- Instant-by-instant allocation of CPU
- Scheduling algorithm is unique
	- Characteristics
	- Objectives
	- Applications
- System designer selects best policy and algorithm
	- After careful strengths/weaknesses evaluation

### Process scheduling algorithm comparison

![process scheduling algorithm comparison](http://snag.gy/NkEnR.jpg)
