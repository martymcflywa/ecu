# Chapter 6: Concurrent processes

## Objectives

- Critical difference between
	- Processes
	- Processors
	- Their connection
- Difference among configurations of multiprocessing systems
- Basic concepts of multicore processor technology
- Significance of a critical region in process synchronization
- Essential ideas behind process synchronization software
- Need for process cooperation when several processors work together
- Similarities/differences between processes and threads
- How processors cooperate when executing
	- Job
	- Process
	- Thread
- Significance of concurrent programming languages and their applications

## Introduction

- Multiprogramming
	- System using only one CPU
	- Shared by several jobs/processes
- Multiprocessing
	- Several processors working together in several distinctly different configurations
	- Single computers with multiple cores
	- Linked computing systems
		- One processor each
		- Shares processing among them

## Parallel processing

- Form of multiprocessing
- Where two or more processors operate in unison
- Two or more CPUs executing instructions simultaneously
- Processor manager has to
	- Coordinate activity of each processor
	- Synchronize cooperative interaction among the CPUs

### Benefits

#### Increased reliability

- Stems from availability of more than one CPU
- If one processor fails
	- Others can continue to operate/absorb load
- Isn't simple to do
- System must be designed so that
	1. Failing processor can inform other processors to take over
	2. OS can restructure resource allocation strategies
		- Remaining processors don't become overloaded

#### Increased processing speed

- Achieved because sometimes instructions can be processed in parallel
	- Two or more simultaneously
- Achieved in one of several ways
	- Allocate a CPU to each program/job
	- Allocate CPU to each working set/part of working set
	- Subdivide individual instructions
		- Each subdivision can be processed simultaneously
		- Called **concurrent programming**

### Disadvantage

#### Increased complexity

- Increased flexibility brings increased complexity
- Two major challenges
	- How to connect processors into configurations
	- How to orchestrate their interaction
- Also applies to multiple interacting processes

#### Six step information retrieval system

1. Processor 1
	- Accepts query
	- Checks for errors
	- Passes request to processor 2
2. Processor 2
	- Searches database for required information
3. Processor 3
	- Retrieves data from database
		- If kept offline in secondary storage
4. Once data is gathered
	- It is placed where processor 2 can retrieve it
5. Processor 2 passes it on to processor 4
6. Processor 4 routes response back to originator of request


![table 6.1](http://snag.gy/Jy8n2.jpg)

### Synchronization

- Key to system's success
	- Many things can go wrong in multiprocessing system
- Example
	- What if communications system broke down
		- Couldn't speak with order clerk
	- What if cook made hamburgers all day at full speed
		- Even during slow periods
		- What would happen to extra unsold hamburgers
	- What if cook became badly burned
		- Couldn't cook any more
	- What would bagger do if there were no hamburgers
- System can't work properly unless
	- Every processor communicates/cooperates with every other processor

## Evolution of multiprocessors

- Can take place at different levels
- Each requires a different frequency of synchronization
	- See table 6.2
- Job level
	- As if each job is running on its own
		- With own workstation
		- Shared system resources
- Thread level
	- High degree of synchronization required
	- To
		- Disassemble each process
		- Perform thread's instructions
		- Correctly reassemble process
	- May require additional work by programmer

![table 6.2](http://snag.gy/A6tGG.jpg)

## Introduction to multicore processors

- Have several processors on single chip
- Processors became
	- Smaller in size
	- Faster processing speed
- Designers began to use nanometer sized transistors
- Each transistor switches between two positions
	- 0
	- 1
	- As computer conducts binary arithmetic at increasingly fast speeds
- As transistors reached
	- Nano sized dimensions
- Space between transistors became closer
	- Quantum physics of electrons got in the way
- When transistors are placed extremely close together
	- Electrons have ability to spontaneously tunnel from one transistor to another
		- Occurs at random
		- Causes tiny amount of current to leak
- The smaller the transistor
	- The more significant the leak
		- Current can disappear from one transistor and appear in another one nearby
- Heat generated from chip
	- Processors became faster
	- Heat increased
	- Difficult to disperse
- Heat and tunneling issues threated to limit ability of chip designers to make processors even smaller
- Solution
	- Create a single chip with two processor cores in same amount of space
	- Two sets of calculations can take place at the same time
	- Two cores on chip
		- Generate less heat
		- Reduced tunneling
	- But two cores
		- Run slower than single core
- To improve performance of dual core
	- Software has to be structured to take advantage of double calculation capabilities of chip
- Hardware innovation affects OS
	- Must manage multiple
		- Processors
		- RAM
		- Processing of many tasks simultaneously
- Dual core
	- Not always faster than single core
	- Depends on tasks being performed
	- Whether they are multithreaded or sequential

## Typical muiltiprocessing configurations

- Three typical configurations
	- Master/slave
	- Loosely coupled
	- Symmetric

### Master/slave

- Figure 6.1
- Asymmetric multiprocessing system
- Single processor with additional slave processors
	- Each is managed by primary master processor

![figure 6.1](http://snag.gy/MXJbs.jpg)

#### Advantage

- Simplicity

#### Disadvantages

- Reliability
	- No higher than single core system
	- If master fails
		- Entire system fails
- Can lead to poor use of resources
	- If a slave processor should become free while master processor is busy
		- Slave must wait until master is free to assign more work to it
- Increases number of interrupts
	- All slave processors must interrupt the master processor every time they need OS intervention
		- ie. IO requests
	- Creates long queues at the master processor level when there are
		- Many processors
		- Many interrupts

### Loosely coupled

- Figure 6.2
- Several complete computer systems
- Each with own
	- Memory
	- IO devices
	- CPU
	- OS
- Each processor controls its own resources
	- Files
	- Access to memory
	- Own IO devices
- Each processor maintains own commands and IO management tables

![figure 6.2](http://snag.gy/DGjMM.jpg)

- Only difference between
	- Loosely coupled
	- Collection of independent single core systems
	- Is that
		- Each processor can communicate/cooperate with the others
- When a job arrives for the first time
	- It is assigned to one processor
- Once allocated
	- Job remains with same processor until finished
- Therefore
	- Each processor must have global tables
		- Indicating which processor each job has been allocated to
- To keep system balanced and ensure best use of resources
	- Job scheduling is based on several requirements and policies
		- Example
			- New jobs might be assigned to processor with either
				- Lightest load
				- Best combination of output devices available

#### Advantage

- Not prone to system failures
	- When single processor fails
		- Others can continue to work independently

#### Disadvantage

- Difficult to detect when a processor has failed


### Symmetric configuration

- Figure 6.3
- Also called **tightly coupled**
- Processor scheduling is decentralized
- Stored in common area of memory so every processor has access
	- OS
	- Global table listing each process
		- Its status
- Each processor uses same scheduling algorithm to select with process it will run next
- When a process is interrupted
	- Cause
		- IO
		- Other
	- Its processor updates corresponding entry in the process table
	- Finds another process to run
- Means that processors are kept busy
- Also means that any given job or task may be executed by several different processors during run time
- Because each processor has access to all IO devices/storage units
	- There are more conflicts as several processors try to access the same resource simultaneously
- Presents obvious need for algorithms to resolve conflicts between processors
	- **Process synchronization**

![figure 6.3](http://snag.gy/KvsR2.jpg)

#### Advantage

- Four advantages over loosely coupled
	- More reliable
	- Uses resources effectively
	- Can balance loads well
	- Can degrade gracefully in event of failure

#### Disadvantage

- Most difficult configuration to implement
- Processes must be well synchronized to avoid
	- Races
	- Deadlocks

## Process synchronization software

- There are occasions when several processes work directly together to complete a common task
- Example problems
	- Producers and consumers
	- Readers and writers
- Each case requires
	- Mutual exclusion
	- Synchronization
- Each is implemented by using semaphores

### Producers and consumers

- One process produces some data
- The other process consumes the data later
- Producer produces data
- Data sent to consumer
- Both processes have access to one common area
	- Buffer area
		- Can only hold finite amount of data
		- Necessary storage area
			- Due to producing speed is independent to consuming speed
- Problems at two extremes
	- Producer attempts to add to already full buffer
	- Consumer attempts to draw from empty buffer

#### Case of CPU

- CPU can generate output data much faster than printer can print
- Since it involves a producer and consumer at different speeds
	- Need a buffer where producer temporarily stores data
	- Can be retrieved by consumer at appropriate speed
- Figure 6.5 shows three typical buffer states

![figure 6.5](http://snag.gy/nwZxa.jpg)

- Because buffer can only hold finite amount of data
	- Sync process must
		- Delay producer from generating more data when buffer is full
		- Delay consumer from retrieving data when buffer is empty
- Can be implemented by two counting **sephamores**
	- One indicating number of full positions in buffer
	- One indicating number of empty positions in buffer
- Third semaphore
	- **Mutex**
	- Ensures mutual exclusion between processes

![table 6.4](http://snag.gy/z87yZ.jpg)

![table 6.5](http://snag.gy/3EiZ8.jpg)

- Given the definitions in table 6.4 and 6.5
	- Producers and consumers algorithm below synchronizes the interaction between producer and consumer

##### Producers and consumers algorithm

```
empty: = n
full: = 0
mutex: = 1
COBEGIN
	repeat until no more data PRODUCER
	repeat until buffer is empty CONSUMER
COEND
```

- The processes `PRODUCER` and `CONSUMER` then execute as described
- The concept of producers and consumers can be extended to
	- Buffers that hold records or other data
	- Other situations which direct process-to-process communication of messages required

### Readers and writers

- When two types of processes need to access a shared resource
	- File
	- Database

#### Example

- Airline reservation system
- Readers
	- Those who want flight information
	- Only read existing data
		- Don't modify it
	- Because no one is changing the database
		- System can allow many readers to be active at the same time
		- No need to enforce mutual exclusion among them
- Writers
	- Those who are making reservations on a particular flight
	- Must be carefully accommodated
		- They are modifying existing data in database
		- System can't allow someone to be writing while someone else is reading or writing
		- Must enforce mutual exclusion if there are either
			- Groups of readers and a writer
			- Multiple writers
- System must be fair when it enforces policy to avoid indefinite postponment of readers or writers

#### P and V operations

##### P operations

- Priority to readers over writers
- Readers only kept waiting if writer is actually modifying data
- Policy results in writer starvation if there is constant stream of readers

##### V operations

- Priority to writers over readers
- As soon as a writer arrives
	- Any readers that are already active are allowed to finish processing
	- Any additional readers are put on hold
		- Until writer is done
- Policy results in reader starvation if there is constant stream of writers

##### Starvation prevention

- Combination priority policy
- When writer is finished
	- Any/all readers who are on hold are allowed to read
- Then when that group of readers is finished
	- Writer who is on hold can begin
	- Any new readers who arrive in mean time aren't allowed to start
		- Until writer is finished
- State of the system can be summarized by four counters initialized to 0
	- R1 = 0
		- Number of readers who have requested a resource and haven't yet released it
	- R2 = 0
		- Number of readers who are using a resources and haven't yet released it
	- W1 = 0
		- Number of writers who have requested a resource and haven't yet released it
	- W2 = 0
		- Number of writers who are using a resource and haven't yet released it
- Readers must always call two procedures
	- Check whether the resource can be immediately granted for reading
	- When resource released
		- Check to see if there are any writers waiting
- Writers must always call two procedures
	- Check whether resource can be immediately granted for writing
	- When resource released
		- Check to see if there are any readers waiting

## Concurrent programming

- One job using several processors to execute sets of instructions in parallel
- Requires programming language and computer system that can support it

### Applications of concurrent programming

- Most programming languages
	- Serial in nature
	- Instructions executed one at a time
- To resolve arithmetic expression
	- Every operation is done in sequence
	- Follows order prescribed by programmer and compiler
- Table 6.6 shows steps to compute expression:

>A = 3 \* B \* C + 4 / (D + E) \*\* (F - G)

![table 6.6](http://snag.gy/AaU5a.jpg)

- All equations follow a standard **order of operations**
	- To solve an equation
		- First perform all calculations in `()`
		- Second calculate all exponents
		- Third perform all multiplication and division
		- Fourth perform addition and subtraction
	- For each step
		- Go left to right
	- If you were to perform the calculations in another order
		- Would run risk of finding incorrect answer
- For many computational purposes
	- Serial processing is sufficient
	- Easy to implement
	- Fast enough for most users
- Arithmetic expressions can be processed differently if using a language that allows for concurrent processing
- Two terms
	- `COBEGIN`
	- `COEND`
- Indicates to compiler which instructions can be processed concurrently
	- Then rewrite expression to take advantage of a concurrent processing compiler

```
COBEGIN
	T1 = 3 * B
	T2 = D + E
	T3 = F - G
COEND
COBEGIN
	T4 = T1 * C
	T5 = T2 ** T3
COEND
	A = T4 + 4 / T5
```

- Table 6.7 shows that to solve:

>A = 3 \* B \* C + 4 / (D + E) \*\* (F - G)

- The first three operations can be done at the same time
	- If computer system has at least three processors
- Next two operations are done at the same time
- Last expression is performed serially with results of the first two steps

![table 6.7](http://snag.gy/c8rgQ.jpg)

- With this system
	- Computation speed is increased
	- Complexity also increased
		- Programming language
		- Hardware
	- Placed large burden on programmer
		- Must explicitly state which instructions can be executed in parallel
		- Called **explicit parallelism**
- The automatic detection by the compiler of instructions that can be performed in parallel is called
	- **Implicit parallelism**
- With a true concurrent processing system
	- Example in table 6.6 and 6.7 is coded as a single expression
- It is the compiler that translates the algebraic expression into separate instructions and decides which steps can be performed in
	- Parallel mode
	- Serial mode

#### Example

- Example:

>Y = A + B * C + D

- Could be rearranged by the compiler as:

>A + D + B * C

- So that two operations
	- A + D and B * C
		- Would be done in parallel
	- Final addition to be calculated last
- As shown in the four cases that follow
	- Concurrent processing can also dramatically reduce complexity of
		- Working with array operations within loops
		- Performing matrix multiplication
		- Conducting parallel searches in databases
		- Sorting/merging files
	- Some of these systems use parallel processors that execute the same type of tasks

### Case 1: Array operations

- To perform an array operation within a loop in three steps

```
for(j = 1; j <= 3; j++)
	a(j) = b(j) + c(j);
```

- If we use three processors
	- Instructions could be performed in a single step like below:

![case 1 array operations](http://snag.gy/2zxIy.jpg)

### Case 2: Matrix multiplication

- Require many multiplication and addition operations
	- Can take place concurrently
	- Example
		- Matrix C = Matrix 1 * Matrix 2

![case 2 matrix multiplication](http://snag.gy/n08ed.jpg)

- To find z in matrix C
	- Multiply elements in the first column of matrix 1 by corresponding elements in first row of matrix 2
		- Then add the products
- Therefore, one calculation is this:

>z = (A * K) + (D * L)

- Likewise:

>x = (C * K) + (F * L)  
>r = (C * O) + (F * P)

- Using one processor
	- Answer to equation can be computed in 27 steps
- By multiplying several elements of the first row of matrix 1 by corresponding elements in matrix 2
	- Three processors could cooperate to resolve this question in fewer steps
- The actual number of products that could be computed at the same time would depend on the number of processors available
	- With two processors
		- 18 steps to perform in parallel
	- With three processors
		- Fewer steps
- In this example
	- By doubling the number of processors from one to two
		- Number of calculations was reduced by one third
			- Not by one half

### Case 3: Searching databases

- Database searching is a common non mathematical application for concurrent processing systems
- Example
	- If a word is searched from a dictionary database
		- Entire file can be split into discrete sections
		- One processor allocated to each section
- Results in significant reduction in search time
- Once item is found
	- All processors can be deallocated
	- Set to work on next task
- Even if item is sought in the last record of db
	- Concurrent search is faster than single processor allocation

### Case 4: Sorting/merging files

- By dividing a large file into sections
	- Each with own processor
	- Every section can be sorted at the same time
- Pairs of sections can be merged together
	- Until entire file is whole again
		- And sorted

## Threads and concurrent programming

- So far we have considered cooperation and synchronization of traditional processes
	- Known as heavyweight processes
- Have following characteristics
	- Pass through several states
		- From initial entry into computer system to completion
			- READY
			- RUNNING
			- WAITING
			- DELAYED
			- BLOCKED
	- Require space in memory where they reside during execution
	- May require other resources such as data
- As seen in chapter 3 and 4
	- These processes are often swapped between memory and secondary storage during execution
		- To accommodate multiprogramming
		- Take advantage of virtual memory
	- Every time a swap occurs
		- Overhead increases
			- Due to information needed to be saved
- To minimize overhead time
	- Most current OS support implementation of threads
		- Lightweight processes
		- Have become part of numerous application packages

### Thread

- A smaller unit within a process
	- Can be
		- Scheduled
		- Executed
- Share same resources as processes that created them
	- Becomes a more passive element
	- Because the thread is the unit that
		- Uses CPU
		- Is scheduled for execution
- Processes might have from one to several active threads
	- Can be managed more efficiently
		- Created
		- Scheduled
		- Synchronized
	- Amount of information needed is reduced
- Supported at
	- Kernel level
	- User level
- Can be managed by either
	- OS
	- Application that created them
- When running a process with multiple threads with single CPU
	- Processor switches quickly from one thread to another
	- Gives impression that threads are executing in parallel
- Only in systems with multiple CPUs that multiple threads in a process are actually executed in parallel

### Active thread

- Each active thread has its own
	- Processor registers
	- Program counter
	- Stack
	- Status
	- But shares
		- Data area
		- Resources allocated to its process
- Program counter and stack
	- Used to store variables dynamically created by a process

### Example

- Function calls in C might create variables that are local to the function
	- These variables are
		- Stored in the stack
			- When the function is invoked
		- Destroyed
			- When the function is exited
- Since threads within a process share the same space and resources
	- They can communicate more efficiently
	- Increasing processor performance

### Web server example

- Can improve performance by using threads
- When web server receives requests for images or pages
	- It serves each request with a different thread
- The process that receives all the requests may have one thread that
	- Accepts these request
	- Creates a new separate thread for each request received
- This new thread retrieves required information
- Sends it to remote client
- While thread is doing its task
	- Original thread is free to accept more requests
- Web servers are multicore processor systems
	- Allow for the concurrent completion of several steps
	- Improving
		- Throughput
		- Response time
- Instead of creating and destroying threads to serve incoming requests
	- Which would increase overhead
	- Web servers keep a pool of threads that can be assigned to those requests
	- After a thread has completed task
		- Instead of being destroyed
		- It is returned to the pool to be assigned to another request

### Thread states

- As a thread moves through the system it is in one of five states
	- Shown in figure 6.6
	- Does not include states
		- Creation
		- Finished

![figure 6.6](http://snag.gy/0G0hk.jpg)

- When an application creates a thread
	- It is made ready by
		- Allocating to it the needed resources
		- Placing it in READY queue
- Thread state is changed from READY to RUNNING
	- When the thread scheduler assigns it a processor
	- Function is similar to process scheduler
- Thread state is changed from RUNNING to WAITING
	- When it has to wait for an event outside its control to occur
	- Example
		- Mouse click can be the trigger event for a thread to change states
			- Causing a transition from WAITING to READY
	- Alternatively
		- After another thread completes its task
			- Sends a signal indicating that the WAITING thread continue to execute
	- Similar to WAIT and SIGNAL process synchronization algorithm
- When an application like a word processor has the capability of delaying the processing of a thread by a specified time
	- It causes the thread to transition from RUNNING to DELAYED
	- When prescribed time has elapsed
		- The thread transitions from DELAYED to READY
	- Example
		- The thread that periodically backs up a current document to disk will be delayed for a period of time after it has completed the backup
		- After the time has expired
			- It performs the next backup
			- Then delayed again
		- If delay was not built into the application
			- Thread would be forced into a loop
				- Continuously testing to see if it was time to do a backup
					- Wasting processor time
					- Reducing system performance
		- Setting up a delay state avoids problems of the test-and-set process synchronization algorithm
- Thread state is changed from RUNNING to BLOCKED
	- When an application issues an IO request
	- After IO completed
		- Thread returns to READY state
- Thread state is changed from RUNNING to FINISHED
	- All resources are released
	- It can exit the system

#### OS support requirements

- Threads require similar operations as traditional processes
- Therefore OS must be able to support
	- Creating new threads
	- Setting up a thread so it is ready to execute
	- Delaying/sleeping threads for a specified amount of time
	- Blocking/suspending threads that are waiting for IO to complete
	- Setting threads on WAIT until specific event has occurred
	- Scheduling threads for execution
	- Synchronizing thread execution using
		- Semaphores
		- Events
		- Conditional variables
	- Terminating a thread
		- Releasing its resources
- OS needs to track critical information for each thread

### Thread control block

- Processes represented by
	- Process control block (PCB)
- Threads represented by
	- Thread control block (TCB)
- Contains basic information about a thread
	- ID
	- State
	- Pointer to process that created it
- Figure 6.7 shows typical contents of TCB

![figure 6.7](http://snag.gy/vv8Oc.jpg)

#### Thread ID

- Unique identifier assigned by OS
- When thread is created

#### Thread state

- Changes as thread progresses through execution
- State changes and other entries in TCB
	- Apply individually to each thread

#### CPU information

- Contains everything the OS needs to know about
	- How far the thread has executed
	- Which instruction is currently being performed
	- What data is being used

#### Thread priority

- Used to indicate the weight of this thread
	- Relative to other threads
- Used by thread scheduler when determining which thread should be selected from READY queue

#### Pointer

- Points to
	- Process that created the thread
	- Other threads created by this thread

### Concurrent programming languages

- Early programming languages did not support
	- Creation of threads
	- Existence of concurrent processes
	- Typically gave programmers possibility of creating a single
		- Process
		- Thread of control
- Ada programming language
	- Late 1970s
	- One of first to provide specific concurrent commands
- Java
	- Designed as universal software platform for Internet applications
	- Widely adopted

#### Java

- Released in 1995
- First programming language allowing multiplatform capability
- Attempt to solve several issues
	- High cost of developing software for many incompatible computer architectures
	- Need of distributed client-server environments
	- Growth of Internet and web
		- Added more complexity to program development
- Uses both compiler and interpreter
	- Source code of a Java program is
		- Compiled into intermediate language
			- Java bytecode
			- Platform independent
		- Bytecode then run on any computer running Java interpreter
- Interpreter
	- Designed to fit in with hardware and OS of computer that will run bytecode
	- Function is to parse/run each bytecode instruction on that computer
- Combination of compiler and interpreter makes it easy to distribute Java applications
	- Not platform dependent
	- Once program is compiled
		- Can be ported/run on any system with Java interpreter

#### Java platform

- Software only platform
	- Runs on top of other hardware based platforms
- Has two components
	- Java virtual machine (JVM)
	- Java application programming interface (Java API)
- Java VM
	- Foundation of platform
	- Contains Java interpreter
		- Runs bytecode provided by compiler
	- Sits on top of many different hardware based platforms
		- See figure 6.8

![figure 6.8](http://snag.gy/oHF9C.jpg)

- Java API
	- Collection of software modules
	- Programmers use in applications
	- Grouped into libraries of related
		- Classes
		- Interfaces
	- Libraries
		- Known as packages
		- Provide well tested objects ranging from
			- Basic data types
			- IO functions
			- Network interfaces
			- GUI kits

##### Java language environment

- Designed to make it easy for experienced programmers to learn
- Syntax is familiar
	- Looks/feels like C++
	- Object oriented
- Memory allocation done at runtime
	- C/C++ allocates memory at compilation
	- References memory via symbolic **handles**
		- Translated to real memory addresses by Java interpreter
	- Not visible to programmers
	- Controlled by underlying runtime platform
- Supports multithreading at language level
	- `Thread` class
		- Collection of methods used to manage threads
			- Start
			- Run
			- Stop
			- Check status
	- Runtime system provides monitor and condition lock primitives
	- Threads are preemptive
		- Can be time-sliced
			- Depending on platform
- When method declared to be synchronized
	- They are not run concurrently
	- Are under control of monitors that ensure variables remain in consistent state
	- When synchronized method begins to run
		- It is given a monitor for the current object
			- Does not allow any other synchronized method in that object to execute
	- When synchronized method exits
		- Monitor is released
		- Allows other synchronized methods within same object to run
- Java popularity
	- Capable of running single program on various platforms
		- Without change to source code
	- Robust set of features
		- Runtime memory allocation
		- Security
		- Multithreading
	- Web/Internet applications
		- Integrates with browser
			- Java applets

## Conclusion

- Multiprocessing
	- Can occur in several configurations
		- Single processor system
			- Interacting processes obtain control of the processor at different times
		- Multiprocessor system
			- Work of each processor communicates/cooperates with others
			- Synchronized by processor manager
	- Configurations
		- Master/slave
		- Loosely coupled
		- Symmetric
- Synchronizing processes
	- Mutual exclusion
		- Prevents deadlock
		- Maintained by techniques
			- Test-and-set
			- WAIT and SIGNAL
			- Semaphores
				- `test(P)`
				- `increment(V)`
				- `mutex`
- Hardware/software mechanisms
	- Used to synchronize processes
	- Must ensure
		- Waiting customers not missed
		- Synchronization of producers/consumers
		- Mutual exclusion of readers/writers
- Innovations
	- Threads
	- Multicore CPUs
	- Fundamental changes to OS to take advantage of new tech
		- Require retooling of applications and OS
