# Concurrent processes

## Objectives

Describe

- Critical difference between
	- Processes and processors
	- Their connection
- Differences among common configurations of multiprocessing systems
- Significance of a critical region in process synchronization
- Basic concepts of process synchronization software
	- Test and set
	- WAIT and SIGNAL
	- semaphores
- The need for process cooperation when several processes work together
- How several processors
	- Execute a single job
	- Cooperate
- Similarities / differences between processes and threads
- Significance of concurrent programming languages and their applications

# Parallel processing

## What is parallel processing

- Multiprocessing
- Two or more processors operate in unison
- Two or more CPUs execute instructions simultaneously
- Processor manager
	- Coordinates activity of each processor
	- Syncs interaction among CPUs

## Parallel processing development

- Enhances throughput
- Increases computing power

## Benefits

- Increased reliability
	- More than one CPU
	- If one processor fails
		- The other takes over
	- Not simple to implement
- Faster processing
	- Instructions processed in parallel two or more at a time
- Faster instruction processing methods
	- CPU allocated to each program or job
	- CPU allocated to each working set or parts of it
	- Individual instructions subdivided
		- Each subdivision processed simultaneously
		- **Concurrent programming**

## Challenges

- Connecting processors into configurations
- Orchestrating processor interaction
- Example
	- Six step information retrieval system
	- Synchronization is key

![table 6.1](http://snag.gy/SwXS6.jpg)

# Multiprocessors

## Evolution of multiprocessors

- Developed for high/mid range and mainframe computers
	- Each additional CPU treated as additional resource
- Today hardware costs reduced
	- Multiprocessor systems available on all systems
- Multiprocessing occurs at three levels
	- Job level
	- Process level
	- Thread level
	- Each level requires different synchronization frequency

![table 6.2](http://snag.gy/lsgWO.jpg)

## Introduction to multicore processors

- Several processors placed on a single chip
- Problems
	- Heat
	- Current leakage
		- Tunneling
- Solution
	- Single chip with two processor cores in same space
		- Allows two sets of simultaneous calculations
		- 80 or more cores on single chip
	- Two cores each run more slowly than single core chip

## Typical multiprocessing configurations

- Multiple processor configuration impacts systems
- Three types
	- Master / slave
	- Loosely coupled
	- Symmetric

### Master / slave configuration

- Asymmetric multiprocessing system
- Single processor system
	- Additional slave processors
		- Each managed by primary master processor
- Master processor responsibilities
	- Manages entire system
	- Maintains all processor status
	- Performs storage management activities
	- Schedules work for other processors
	- Executes all control programs

![figure 6.1](http://snag.gy/X82Iz.jpg)

- Advantages
	- Simplicity
- Disadvantages
	- Reliability
		- No higher than single processor system
	- Potentially poor resources usage
	- Increases number of interrupts

### Loosely coupled configuration

- Several complete computer systems
	- Each with own resources
		- Maintains commands and I/O management tables
- Independent single processing difference
	- Each processor
		- Communicates and cooperates with others
		- Has global tables
- Several requirements and policies for job scheduling
- Single processor failure
	- Others continue work independently
	- Difficult to detect

![figure 6.2](http://snag.gy/X6uki.jpg)

### Symmetric configuration

- Decentralized processor scheduling
	- Each processor is same type
- Advantages over loosely coupled
	- More reliable
	- Uses resources efficiently
	- Can balance loads well
	- Can degrade gracefully in failure situation
- Most difficult to implement
	- Requires well synchronized processes
		- Avoids races and deadlocks

![figure 6.3](http://snag.gy/KA8xw.jpg)

- Decentralized processing scheduling
	- Single operating system copy
	- Global table listing
- Interrupt processing
	- Update corresponding process list
	- Run another process
- More conflicts
	- Several processors access same resource at same time
- Process synchronization
	- Algorithms resolving conflicts between processors

# Process synchronization software

## Successful process synchronization

- Lock up used resource
	- Protect from other processes until released
- Only when resource is released
	- Waiting process is allowed to use resource

## Consequences of mistakes in synchronization

- Starvation
	- Leave job waiting indefinitely
- Deadlock
	- If key resource is being used

## Critical region

- Part of a program
- Critical region must complete execution
	- Other processes must wait before accessing critical region resources
- Processes within critical region
	- Cannot be interleaved
		- Threatens integrity of operation

# Synchronization

- Implemented as lock-and-key arrangement
- Process determines key availability
	- Process obtains key
	- Puts key in lock
	- Makes it unavailable to other processes
- Types of locking mechanisms
	- Test and set
	- WAIT and SIGNAL
	- Semaphores

## Test and set

- Indivisible machine instruction
- Executed on single machine cycle
	- If key is available
		- Set to unavailable
- Actual key
	- Single bit in storage location
		- `0 = free`
		- `1 = busy`
- Before process enters critical region
	- Tests condition code using TS instruction
	- No other process in region
		- Process proceeds
		- Condition code changed from `0` to `1`
		- P1 exits
			- Code reset to 0
			- Allows others to enter
- Advantages
	- Simple procedure to implement
	- Works well for small number of processes
- Disadvantages
	- Starvation
		- Many processes waiting to enter a critical region
		- Processes gain access in arbitrary fashion
	- Busy waiting
		- Waiting processes remain in unproductive, resource consuming wait loops

### WAIT and SIGNAL

- Modification of test and set
	- Designed to remove busy waiting
- Two new mutually exclusive operations
	- WAIT and SIGNAL
	- Part of process scheduler's operations
- WAIT
	- Activated when process encounters busy condition code
- SIGNAL
	- Activated when process exists critical region and condition code set to `0 = free`

### Semaphores

- Non negative integer variable
	- Flag
	- Signals if and when resource is free
		- Resource can be used by a process
- Two operations of semaphore
	- `P`
		- Proberen
		- **To test**
	- `V`
		- Verhogen
		- **To increment**

![figure 6.4](http://snag.gy/kp1SV.jpg)

#### Semaphore operations

- Let `s` be a semaphore variable
- Fetch, increment, store sequence:

```
V(s): s: = s + 1
```

- Test, fetch, decrement, store sequence:

```
P(s): If s > 0, then s: = s - 1
```

- `s = 0` implies busy critical region
	- Process calling on `P` operations must wait until `s > 0`
- Waiting job of choice processed next
	- Depends on process scheduler algorithm

![table 6.3](http://snag.gy/fzn2H.jpg)

#### Semaphore mutual exclusion

- `P` and `V` operations on semaphore `s`
	- Enforce mutual exclusion concept
- Semaphore called `mutex`: MUTual EXclusion

```
P(mutex): if mutex > 0 then mutex: = mutex - 1
V(mutex): mutex: = mutex + 1
```

- **Critical region**
	- Ensures parallel processes modify shared data only while in critical region
- Parallel computations
	- Mutual exclusion explicitly stated and maintained

# Process cooperation

- Several processes work together to complete common task
- Each case requires
	- Mutual exclusion and synchronization
- Absence of mutual exclusion and synchronization
	- Results in problems
- Examples
	- Producers and consumers problem
	- Readers and writers problem
- Each case implemented using semaphores

## Producers and consumers

- One process produces data
- Another process consumes data
- ie. CPU and line printer buffer
	- Delay producer
		- Buffer full
	- Delay consumer
		- Buffer empty
	- Implemented by two semaphores
		- Number of full positions
		- Number of empty positions
	- Mutex
		- Third semaphore
			- Ensures mutual exclusion

![figure 6.5](http://snag.gy/7bEbA.jpg)

![table 6.4](http://snag.gy/oX6li.jpg)

![table 6.5](http://snag.gy/4M6zh.jpg)

### Producers and consumers algorithm

```
empty: = n
full: = 0
mutex: = 1
COBEGIN
		repeat until no more data PRODUCER
		repeat until buffer is empty
	CONSUMER
COEND
```

## Readers and writers

- Two process types need to access shared resource
	- ie. File or database
- ie. Airline reservation system
	- Implemented using two semaphores
		- Ensures mutual exclusion between readers and writers
	- Resource given to all readers
		- Provided no writers are processing
			- `W2 = 0`
	- Resource given to a writer
		- Provided no readers are reading
			- `R2 = 0`
		- And no writers are writing
			- `W2 = 0`

# Concurrent programming

- Concurrent processing system
	- One job uses several processors
		- Executes sets of instructions in parallel
	- Requires programming language and computer system support

## Example sequential vs. concurrent process

![table 6.6](http://snag.gy/wEI0N.jpg)

![table 6.7](http://snag.gy/GbAYI.jpg)

## Explicit parallelism

- Requires programmer intervention
	- Explicitly state parallel executable instructions
- Disadvantages
	- Time consuming coding
	- Missed opportunities for parallel processing
	- Errors
		- Parallel processing mistakenly indicated
	- Programs difficult to modify

## Implicit parallelism

- Compiler automatically detects parallel instructions
- Advantages
	- Solves explicit parallelism problems
	- Complexity dramatically reduced
		- Working with array operations within loops
		- Performing matrix multiplications
		- Conducting parallel searches in database
		- Sorting or merging file

# Threads and concurrent programming

- Threads
	- Small unit within process
		- Scheduled and executed
- Minimizes overhead
	- Swapping process between main memory and secondary storage
- Each active process thread
	- Processor registers
	- Program counter
	- Stack and status
- Shares data area and resources allocated to its process

## Thread states

![figure 6.6](http://snag.gy/GL31M.jpg)

## Operating system support

- Creating new threads
- Setting up thread
	- Ready to execute
- Delaying or putting threads to sleep
	- Specified amount of time
- Blocking or suspending new threads
	- Those waiting for I/O completion
- Setting threads to WAIT state
	- Until specific event occurs

## Concurrent programming languages

- Ada
	- First language providing specific concurrency commands
	- Developed in late 1970s
- Java
	- Designed as universal Internet application software platform
	- Developed by Sun Microsystems
	- Adopted in commercial and educational environments

### Java

- Allows programmers to code applications that can run on any computer
- Developed at Sun Microsystems, Inc (1995)
- Solves several issues
	- High software development costs for different, incompatible computer architectures
	- Distributed client-server environment needs
	- Internet growth
- Uses compiler and interpreter
	- Easy to distribute

#### Java platform

- Software only platform
	- Runs on top of other hardware based platforms
- Two components
	- Java Virtual Machine (JVM)
		- Foundation for Java platform
		- Contains the interpreter
		- Runs compiled byte code
	- Java application programming interface (Java API)
		- Collection of software modules
		- Grouped into libraries by classes and interfaces

![figure 6.8](http://snag.gy/awYA3.jpg)

#### Java language environment

- Designed for experienced programmers
	- Like C++
- Object oriented
	- Exploits modern software development methods
		- Fits into distributed client-server applications
- Memory allocation features
	- Done at runtime
	- References memory via symbolic **handles**
	- Translated to real memory addresses at runtime
	- Not visible to programmers
- Security
	- Built-in feature
		- Language and runtime system
	- Checking
		- Compile-time and runtime
- Sophisticated synchronization capabilities
	- Multithreading at language level
- Popular features
	- Handles many applications
	- Can write a program once
	- Robust
	- Internet and Web integration

# Summary

- Multiprocessing
	- Single processor systems
		- Interacting processes obtain control of CPU at different times
	- Systems with two or more CPUs
		- Control synchronized by processor manager
		- Processor communication and cooperation
	- System configuration
		- Master/slave
		- Loosely coupled
		- Symmetric
- Multiprocessing system success
	- Synchronization of resources
- Mutual exclusion
	- Prevents deadlock
	- Maintained with
		- Test and set
		- WAIT and SIGNAL
		- Sephamores
			- `P`, `V` and `mutex`
- Synchronize processes using hardware and software mechanisms
- Avoid typical problems of synchronization
	- Missed waiting customers
	- Synchronization of producers and consumers
	- Mutual exclusion of readers and writers
- Concurrent processing innovations
	- Threads and multicore processors
		- Requires modifications to operating systems
