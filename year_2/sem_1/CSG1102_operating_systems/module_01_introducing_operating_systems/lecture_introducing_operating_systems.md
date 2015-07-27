# Introducing operating systems

## Learning objectives

After completing this chapter, you should be able to describe:

- Innovations in operating systems development
- The basic role of an operating system
- The major operating system software subsystem managers and their functions
- The types of machine hardware on which operating systems run
- The differences among batch, interactive, real-time, hybrid and embedded operating systems
- Multiprocessing and its impact on the evolution of operating system software
- Virtualization and core architecture trends in new operating systems

## Introduction

- Operating systems
	- Manage computer system hardware and software
- This text explores:
	- What they are
	- How they work
	- What they do
	- Why they do it
- This chapter describes
	- How operating systems work
	- The evolution of operating systems

### What is an operating system

- Computer system
	- Software
		- Programs
	- Hardware
		- Physical machine and electronic components
- Operating system
	- Part of computer system
		- Software
	- Manages all hardware and software
		- Controls every file, device, section of main memory and nanosecond of processing time
		- Controls who can use the system
		- Controls how the system is used

## Operating system software

- Includes four essential subsystem managers
	- Memory manager
	- Processor manager
	- Device manager
	- File manager
- Network manager (fifth subsystem manager)
	- In all modern operating systems
	- Assumes responsibility for networking tasks
	- Discussed further in module 9 & 10

![model: non-networked subsystem managers](http://snag.gy/La3LD.jpg)

- Each manager
	- Works closely with other managers
	- Performs a unique role
- Manager tasks
	- Monitor its resources continuously
	- Enforce policies determining
		- Who gets what, when and how
	- Allocate the resource when appropriate
	- Deallocate the resource when appropriate
- Network manager
	- Operating systems with networking capability
	- Fifth essential manager
	- Convenient way for users to share resources
	- Retains user access control
- Resources include
	- Hardware
		- CPU
		- Memory areas
		- Printers
		- Tape drives
		- Modems
		- Disk drives
	- Software
		- Compilers
		- Application programs
		- Data files

![model: networked subsystem managers](http://snag.gy/xDyhW.jpg)

### Main memory management

- In charge of main memory
	- Random Access Memory (RAM)
- Responsibilities include
	- Preserving space in main memory occupied by operating system
	- Check validity and legality of memory space request
	- Setting up memory tracking table
		- Tracks usage of memory by sections
		- Needed in multiuser environment
	- Deallocating memory to reclaim it

### Processor management

- In charge of allocating Central Processing Unit (CPU)
- Tracks process status
	- An instance of program execution
- Two levels of responsibility
	- Handle jobs as they enter the system
		- Handled by **Job Scheduler**
	- Manage each process within those jobs
		- Handled by **Process Scheduler**

### Device management

- In charge of monitoring all resources
	- Devices
	- Channels
	- Control units
- Responsibilities include
	- Choosing most efficient resource allocation method
		- Printers, ports, disk drives etc.
		- Based on scheduling policy
	- Allocating the device
	- Starting device operation
	- Deallocating the device

### File management

- In charge of tracking every file in the system
	- Data files
	- Program files
	- Compilers
	- Application programs
- Responsibilities include
	- Enforcing user/program resource access restrictions
		- Uses predetermined access policies
	- Controlling user/program modification restrictions
		- Read-only, read-write, create, delete
	- Allocating resource
		- Opening the file
		- Deallocating file
			- Closing it

### Cooperation issues

- Essential manager
	- Perform individual tasks **and**
	- Harmoniously interact with other managers
		- Requires incredible precision
	- No single manager performs tasks in isolation
	- Network manager
		- Convenient way to share resources
		- Controls user access

## A brief history of machine hardware

- Hardware
	- Physical machine and electronic components
		- Main memory (RAM)
			- Data / instruction storage and execution
		- Input / output devices (I/O)
			- All peripheral devices in system
				- Printers
				- Disk drives
				- CD/DVD drives
				- Flash memory
				- Keyboards
		- Central processing unit (CPU)
			- Controls interpretation and execution of instructions
			- Controls operation of computer system

![logical model: computer hardware](http://snag.gy/cbN2b.jpg)


## Computer classification

- By capacity and price (until mid 1970s)

### Mainframe

- Large machine
	- Physical size and internal memory capacity
- Example
	- 1964 IBM 360 model 30
	- CPU required 18' square air-conditioned room
	- CPU size: 5' high x 6' wide
	- Internal memory: 64k
	- Price: $200,000 (in 1964)
- Applications limited to large computer centers

### Minicomputer

- Developed for smaller institutions
- Compared to mainframe
- Smaller in size and memory capacity
	- Cheaper
- Example
	- Digital Equipment Corp. minicomputer
	- Price: < $18,000
- Today
	- Known as midrange computers
	- Capacity between microcomputers and mainframes

### Supercomputer

- Massive machine
- Developed for military and weather forecasting
- Example
	- Cray supercomputer
	- 6 to 1000 processors
	- Performs up to 2.4 trillion floating-point operations per second
		- Teraflops
- Uses
	- Scientific research
	- Customer support / product development

### Microcomputer

- Developed for single users in the late 1970s
- Example
	- Microcomputers by Tandy Corporation and Apple Computer, Inc.
	- Very little memory by today's standards
	- 64k maximum capacity
- Microcomputer's distinguishing characteristic
	- Single-user status

### Workstations

- Most powerful microcomputers
- Developed for commercial, educational, and government enterprises
- Networked together
- Support engineering and technical users
	- Massive mathematical computations
	- Computer Aided Designed (CAD)
- Applications
	- Requiring powerful CPUs
	- Large main memory
	- Extremely high resolution graphic displays

### Servers

- Provide specialized services
	- To other computers or client/server networks
- Perform critical network tasks
- Examples
	- Print servers
	- Internet servers
	- Mail servers

### Advances in computer technology

- Dramatic changes
	- Physical size
	- Cost
	- Memory capacity
- Networking
	- Integral part of modern computer systems
- Mobile society information delivery
	- Creating strong market for handheld devices
- New classification
	- By processor capacity, not memory capacity
- Moore's law
	- Computing power rises exponentially

### Classification and OS

![class and os](http://snag.gy/dyOOB.jpg)

## Types of operating systems

- Five categories
	- Batch
	- Interactive
	- Real-time
	- Hybrid
	- Embedded
- Two distinguishing features
	- Response time
	- How data enters into the system

### Batch systems

- Input relied on punched cards or tape
- Efficiency measured in throughput

### Interactive systems

- Faster turnaround than batch systems
- Slower than real-time systems
- Introduced to provide fast turnaround when debugging programs
- Time-sharing software developed for operating system

### Real-time systems

- Reliability is key
- Fast and time limit sensitive
- Used in time-critical environments
	- Space flights
	- Airport traffic control
	- High speed aircraft
	- Industrial processes
	- Sophisticated medical equipment
	- Distribution of electricity
	- Telephone switching
- Must be 100% responsive, 100% of the time

### Hybrid systems

- Combination of batch and interactive
- Accept and run batch programs in the background
	- Interactive load is light

### Embedded systems

- Computers placed inside other products
- Adds features or capabilities
- Operating system requirements
	- Performs specific set of programs
	- Not interchangeable among systems
	- Small kernel and flexible function capabilities

## Brief history of operating systems development

### 1940s: First generation

- Computers based on vacuum tube technology
- No standard operating system software
- Typical program included every instruction needed by the computer to perform tasks requested
- Poor machine utilization
	- CPU processed data and performed calculations for fraction of available time
- Early programs
	- Designed to use the resources conservatively
	- Understandability not a priority

![first 'bug'](http://i.imgur.com/vk5bBNl.png)

### 1950s: Second generation

- Focused on cost effectiveness
- Computers were expensive
	- IBM 7094: $200,000
- Two widely adopted improvements
	- Computer operators
		- Humans hired to facilitate machine operation
	- Concept of job scheduling
		- Group together programs with similar requirements
- Expensive time lags between CPU and I/O devices
- I/O device speed gradually became faster
	- Tape drives
	- Disks
	- Drums
- Records blocked before retrieval or storage
- Access methods developed
	- Added to object code by linkage editor
- Buffer between I/O and CPU introduced
	- Reduced speed discrepancy
- Timer interrupts developed
	- Allowed job-sharing

### 1960s: Third generation

- Faster CPUs
- Speed caused problems with slower I/O devices
- Multiprogramming
	- Allowed loading many programs at one time
- Program scheduling
	- Initiated with second-generation systems
	- Continues today
- Few advances in data management
- Total operating system customization
	- Suit user's needs

### 1970s

- Faster CPUs
- Speed caused problems with slower I/O devices
- Main memory physical capacity limitations
	- Multiprogramming schemes used to increase CPU
	- Virtual memory developed to solve physical limitation
- Database management software
	- Became a popular tool
- A number of query systems introduced
- Programs started using
	- English-like words
	- Modular structure
	- Standard operations

### 1980s

- Cost/performance ration improvement of computer components
- More flexible hardware
	- Firmware
- Multiprocessing
	- Allowed parallel program execution
- Evolution of personal computers
- Evolution of high-speed communications
- Distributed processing and networked systems introduced

### 1990s

- Demand for Internet capability
	- Sparked proliferation of networking capability
	- Increased networking
	- Increased tighter security demands to protect hardware and software
- Multimedia applications
	- Demanding additional functionality for most operating systems
		- Power
		- Flexibility
		- Device compatibility

![1989 'linked info system'](http://snag.gy/pr1oW.jpg)

### 2000s

- Primary design features support
	- Multimedia applications
	- Internet and web access
	- Client/server computing
- Computer system requirements
	- Increased CPU speed
	- Highspeed network attachments
	- Increased number and variety of storage devices
- Virtualization
	- Single server supports different operating systems

## Threads

- Multiple actions executing simultaneously
	- Heavyweight process (conventional process)
		- Owns the resources
		- Passive element
	- Lightweight process (thread)
		- Uses CPU and scheduled for execution
		- Active element
	- Multithreaded applications programs
		- Contains several threads running at one time
		- Same or different priorities
		- Examples
			- Web browsers
			- Time sharing systems

## Object oriented design

- Driving force in system architecture improvements
- **Kernel** (operating system nucleus)
	- Resides in memory at all times
	- Performs essential tasks
	- Protected by hardware
- **Kernel reorganisation**
	- Memory resident
		- Process scheduling and memory allocation
	- Modules
		- All other functions
- **Advantages**
	- Modification and customization without disrupting integrity of the remainder of the system
	- Software development more productive

![early os vs. object oriented os](http://snag.gy/pz44n.jpg)

## Summary

- Operating systems overview
- Functions of OS
	- Manages computer system
		- Hardware and software
	- Four essential managers
		- Work closely with the other managers and perform unique role
	- Network manager
		- Operating systems with networking capability
	- Essential hardware components
		- Memory chips, I/O, storage devices, CPU
- Evolution of OS
	- Run increasingly complex computers
	- Run increasingly complex computer systems
	- Prior to mid 1970s
		- Computers classified by capacity and price
	- Dramatic changes over time
		- Moore's law
			- Computing power rises exponentially
		- Physical size, cost, memory capacity
- Mobile society information delivery
	- Creates strong market for handheld devices
	- Integral in modern computer systems
- Five categories of operating systems
	- Batch
	- Interactive
	- Real-time
	- Hybrid
	- Embedded
- Use of object-oriented design improves the system architecture
- Several ways to perform OS tasks
- Designer determines policies to match system's environment
- Next
	- Explore details of operating system components
