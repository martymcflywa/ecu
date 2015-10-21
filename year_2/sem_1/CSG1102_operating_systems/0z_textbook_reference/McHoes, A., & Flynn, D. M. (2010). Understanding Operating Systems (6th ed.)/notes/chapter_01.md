# Chapter 1: Introducing operating systems

## Objectives

- Innovations in operating system development
- Basic role of an operating system
- Major OS software subsystem managers and their functions
- Types of machine hardware on which OS's run
- Difference among OS types
	- Batch
	- Interactive
	- Real time
	- Hybrid
	- Embedded
- Multiprocessing and impact on evolution of OS
- Virtualization and core architecture trends in new OS

## Introduction

- To understand OS is to understand the workings of an entire computer system
	- OS manages every piece of hardware/software
- This chapter describes how simple OS's work
	- And how they've evolved

## What is an operating system

- Computers consist of software and hardware
- OS is the chief piece of software
	- The portion of the computing system that manages all of the hardware and software
- It controls every
	- File
	- Device
	- Section of main memory
	- Nanosecond of processing time
- It controls who can use the system and how
	- It's the boss
- Each time the user sends a command
	- The OS must make sure that the command is executed
	- If it's not executed, must arrange for the user to get a message explaining the error
- Doesn't necessarily mean the OS executes the command or sends the error message
	- But it controls the parts of the system that do

## Operating system software

- Figure 1.1 shows an abstract representation of an OS
	- Demonstrates how its major components work together

![figure 1.1](http://snag.gy/WiFDm.jpg)

- At the base of the pyramid are the four essential managers of every operating system
	- Memory manager
	- Processor manager
	- Device manager
	- File manager
- These managers are the basis of all OS's
- Each manager works closely with the other managers
	- Performs its unique role regardless of which specific OS is being discussed
- At the top of the pyramid is the user interface
	- From which users issue commands to the OS
- This is the component that is unique to each OS
	- Sometimes even between different versions of the same OS
- A network was not always an integral part of OS's
	- Early systems were self contained with all network capability added on top of existing OS's
	- Now most OS routinely incorporate a **network manager**
	- The base of a pyramid for a networked OS is shown in figure 1.2

![figure 1.2](http://snag.gy/sKxx4.jpg)

- Regardless of the size or configuration of the system
	- Each of the subsystem managers, shown in figure 1.3 must perform the following tasks
		- Monitor its resources continuously
		- Enforce the policies that determine who gets what, when and how much
		- Allocate the resource when appropriate
		- Deallocate the resource when appropriate

![figure 1.3](http://snag.gy/6teMq.jpg)

### Main memory management

- In charge of main memory
	- Also known as RAM
- Checks the validity of each request for memory space
- If request is legal, it allocates a portion of memory that isn't already in use
- In a multiuser environment
	- Memory manager sets up a table to keep track of who is using which section of memory
- When time comes to reclaim memory
	- Memory manager deallocates memory
- Primary responsibility
	- Protect the space in main memory occupied by the OS itself
	- It cannot allow any part of it to be accidentally or intentionally altered

### Processor management

- Decides how to allocate the CPU
- Important function
	- Keep track of the status of each process
	- Process
		- Defined as an instance of execution of a program
- Monitors whether the CPU is executing a process or waiting for a READ/WRITE command to finish execution
- Because it handles the processes transitions form one state to another
	- It can be compared to a traffic controller
- Once the processor manager allocates the processor
	- It sets up the necessary registers and tables
- When the job is finished or max time expired
	- It reclaims the processor
- Two levels of responsibility
	- One is to handle jobs as they enter the system
		- Handled by job scheduler
			- High level portion of the processor manager
			- Accepts/rejects incoming jobs
	- Manage each process within those jobs
		- Handled by process scheduler
			- Low level portion of the processor manager
			- Decides which process gets the CPU and for how long

### Device management

- Monitors every device, channel and control unit
- Its job is to choose the most efficient way to allocate all of the systems devices
	- Based on a scheduling policy
		- Chosen by OS designers
- Does this by
	- Allocating each resource
	- Starting the operation
	- Deallocating the device
		- Make it available to next process/job

### File management

- Keeps track of every file in the system
	- Data files
	- Program files
	- Compilers
	- Applications
- Uses predetermined access policies to enforce restrictions on who has access to which files
- Controls what users are allowed to do with files once they access them
- Example
	- User may have read only access, read/write access or authority to create/delete files
- Managing access control is key part of file management
- Allocates necessary resources
- Deallocates as well

### Network management

- OS with Internet or network capability have fifth essential manager
- Provides convenient way for users to share resources while controlling users' access to them
- Resources include
	- Hardware
	- Software

### User interface

- Users interact with UI directly

## Types of operating systems

### Batch

- Earliest computers
- Relied on stacks of punched cards/reels of magnetic tape for input
- Jobs were entered by assembling cards into a deck
	- Running entire deck of cards through a card reader as a group
		- A batch
- Efficiency of batch system measured in throughput
	- Number of jobs completed in given amount of time

### Interactive

- Give a faster turn around than batch systems
	- Slower than real time systems
- Introduced to satisfy the demands of users who needed fast turn around when debugging programs
- OS required the development of time sharing software
	- Allows each user to interact directly with the computer via commands entered from terminal
- The OS provides immediate feedback to user
- Response time measured in fractions of a second

### Real time

- Used in time critical environments where reliability is key and data must be processed within a strict time limit
- System response time must meet deadline or risk significant consequences
- These systems need to provide contingencies to fail gracefully
	- Preserve as much of system's capabilities and data as possible to facilitate recovery
- Example
	- Real time systems were used for
		- Space flights
		- Airport traffic control
		- Fly by wire aircraft
		- Critical industrial processes
		- Certain medical equipment
		- Telephone switching
- Two types of real time systems, depending on the consequences of missing the deadline
	- Hard real time systems
		- Risk total system failure if predicted time deadline is missed
	- Soft real time systems
		- Suffer performance degradation
		- But not total system failure

### Hybrid

- Combination of batch and interactive
- Appear to be interactive because individual users can access the system and get fast responses
	- Actually accepts/runs batch programs in the background when interactive load is light
- Takes advantage of free time between high demand usage and low demand times
- Many large computer systems are hybrid

### Embedded

- Computers placed inside other products
	- Adds features/capabilities
- Example
	- Household appliances
	- Cars
		- Can help with
			- Engine performance
			- Braking
			- Navigation
	- Digital music players
	- Elevators
	- Pacemakers
- Very different to OS in general computer systems
	- Designed to perform a set of specific programs
		- Not interchangeable among other systems
	- Permits designers to make the OS more efficient
		- Take advantage of the computers limited resources
			- Memory
- Before general purpose OS can be used in an embedded system
	- Designers must select which components are needed in the environment
	- Final version of OS will include only necessary elements
	- Any unneeded features will be dropped

## Threads

- Multi core tech helps the OS handle threads
	- Multiple actions that can be executed at the same time
- Processor manager is responsible for processing each job submitted by a user
	- Jobs are made up of processes
		- Sometimes called tasks
	- Processes consist of multiple threads
- A process has two characteristics
	- It requires space in main memory where it resides during execution
		- From time to time it requires other resources
			- Data files
			- IO devices
	- It passes through several states from its initial arrival into the computer system to completion
		- Running
		- Waiting
		- Ready
- Multiprogramming and virtual memory dictate that processes be swapped between main memory and secondary storage during execution
- With conventional processes, this swapping results in a lot of overhead
	- Heavyweight processes
- Because each time a swap takes place
	- All process information must be saved to preserve the process' integrity
- A thread (lightweight process) can be defined as
	- A unit smaller than a process
	- Can be
		- Scheduled
		- Executed
	- Using this technique
		- The heavyweight process which owns the resources
			- Becomes a more passive element
		- The thread becomes the element that uses the CPU and is scheduled for execution
	- Manipulating threads is less time consuming that manipulating processes (which are more complex)
	- Some OS support multiple processes with a single thread
	- Others support multiple processes with multiple threads
- Multi threading allows applications to manage a separate process with several threads of control
	- Web browsers use multi threading routinely
		- One thread can retrieve images
		- While another sends and retrieves email
	- Multi threading is also used to increase responsiveness in a time sharing system
		- Increases resource sharing and decreases overhead

## Object oriented design

### Kernel

- Part of the OS that resides in memory at all times
- Performs most essential OS tasks
- Protected by hardware from user tampering

### First generation

- OS were designed as a comprehensive single unit
	- See figure 1.15 (a)
- Stored all required elements of the OS in memory
	- Memory allocation
	- Process scheduling
	- Device allocation
	- File management
- Architecture was cumbersome
	- Time consuming for programmers to
		- Add new components
		- Modify existing ones

### Recent

- Part of the OS that resides in memory has been limited to few essential functions
	- Process scheduling
	- Memory allocation
- All other functions are provided by special modules
	- Such as
		- Device allocation
	- Treated as regular applications
		- See figure 1.15 (b)
- Object oriented design
	- Driving force behind new organization
	- Objects are self contained modules that provide models of the real world
		- Units of software
		- Can be reused in different applications
- By working on objects
	- Programmers can modify/customize pieces of an OS without disrupting the integrity of the remainder of the system
	- Modular object oriented approach can make software development groups more productive than was possible with procedural structured programming

![figure 1.15](http://snag.gy/IHWa9.jpg)
