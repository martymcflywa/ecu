# Management of network functions

## Objectives

- Complexities introduced to OS by network capabilities
- Network OS (NOS) compared to distributed OS (DO/S)
- How DO/S manages
	- Memory
	- Process
	- Device
	- File
- How NOS manages
	- Memory
	- Process
	- Device
	- File
- Important features of DO/S and NOS

## History of networks

- Initial network creation
	- Share expensive hardware resources
	- Provide centralized information resource access
- OS development
	- Network OS first
	- DO/S followed
		- More powerful
- Distributed processing
	- Even greater centralized information access
	- User collaboration
		- Complete common tasks

# NOS vs. DO/S

## Network OS (NOS)

- Local operating systems extend powers
- Handle interfacing details
	- Coordinate remote processing
- Coordinate communications
	- Between local OS's
- Limitations
	- No global control of
		- Memory management
		- Process management
		- Device management
		- File management
	- Viewed as autonomous local functions
	- No true distributed computing

![figure 10.1](http://snag.gy/k4P8I.jpg)

## Distributed OS (DO/S)

- Global assets controlled by OS
- Provide unified environment
	- Optimize whole network operations
- Construction
	- Replicated kernel operating system
- Network and intricacies hidden from users
	- Use network as a single logical system

![table 10.1, figure 10.2](http://snag.gy/RJIV0.jpg)

# DO/S development

- Entire network resource groups managed globally
	- **Negotiation and compromise** based resource allocation
		- Occurs among equally important peer sites
- Advantage
	- No special server software on local machines
		- Supports
			- File copying
			- Email
			- Remote printing

## Memory management

- Uses kernel with paging algorithm
	- Tracks available memory amount
	- Based on goals of local system
	- Global system requirements drive local site policies/mechanisms
- Memory allocation and deallocation dependencies
	- Scheduling and resource sharing schemes that optimize network resources

### Extended role

#### Memory requests

- Local and global sources
- Local level
	- Page allocation based on local policy
- Global level
	- Receives process manager memory requests for new or expanding client or server processes
	- Uses local resources for memory garbage collection/compaction
	- Decides most and least active processes
	- Determines pre-emptive processes to provide space

#### Functions

##### Control demand

- Allocates/deallocates space requests based on network's usage patterns

##### Page fault handling

- Automatically brings requested page into memory
- Examine total free memory table before allocating space

##### Virtual memory management

- Allocates and deallocates virtual memory
- Reads/writes to virtual memory
- Swaps virtual pages to disk
- Locks virtual pages in memory and protects pages as needed

![table 10.2](http://snag.gy/Lrtyr.jpg)

## Process management

- Provides policies and mechanisms
	- Create
	- Delete
	- Abort
	- Name
	- Rename
	- Find
	- Schedule
	- Block
	- Run
	- Synchronize processes
	- Provides real time priority executing if required
- Manages execution states
	- READY
	- RUNNING
	- WAIT
	- Each CPU in network
		- Required to have own runtime kernel

### Kernel

#### Role

- Helps system reach operational goals

#### States

- Dependent on global system's process scheduler and dispatcher

#### System's scheduling function

- Decision mode
- Priority function
- Arbitration rule

![figure 10.3](http://snag.gy/jGKfY.jpg)

##### Decision mode

- Determines policies when scheduling resource
- Options
	- Preemptive
	- Non preemptive
	- Round robin

##### Priority function

- Scheduling algorithm policy assigning order given to processes in execution cycle
	- Example
		- Most time remaining (MTR)
		- Least time remaining (LTR)

##### Arbitration rule

- Resolves conflicts between equal priority jobs
	- Example
		- Last in first out (LIFO)
		- First in first out (FIFO)

### Job scheduling advances

#### Theories

- Queuing theory
- Statistical decision theory
- Estimation theory
	- Maximize system throughput using durations to compute and schedule optimal way to interleave process chunks

### Process functions

- Specific procedures
	- Create process
	- Locate process
	- Synchronize process
	- Delete/terminate process

#### Create process

- PCB with additonal information identifying network location

#### Locate process

- Uses system directory or process searching kernel queue spaces
- Requires interprocess communications support

#### Synchronize process

- Uses message passing or remote procedure calls

#### Delete/terminate process

- Finds PCB
- Accesses it
- Deletes it

## DO/S design

### Process based DO/S

- Network resources managed as large heterogeneous collection
- Process management using client/server processes
	- Sychronized/linked together through
		- Messages and ports
			- Channels or pipes
- Emphasizes processes and messages
	- Providing basic features essential to process management
- Process management
	- Single OS copy
	- Multiple cooperating peers
	- Combination of two
- High level cooperation and sharing
	- Actions and data
- Synchronization is key issue in network process management
- Interrupts represented as messages
	- Sent to proper process for service

### Object based DO/S

- Clumps each hardware type with necessary operational software into discrete objects
- Manipulated as a unit
- System viewed as collection of objects
	- Example
		- Hardware
			- CPU
			- Memory
		- Software
			- Files
			- Programs
		- Combination
- Objects viewed as abstract entities
	- Objects have set of unchanging properties
- Process management becomes object management
	- Processes act as discrete objects
- Two process management components
	- Kernel level and process manager

#### Kernel level

- Provides basic mechanisms for building OS
	- Dynamically manage objects
		- Create
		- Manage
		- Schedule
		- Synchronize
		- Delete
- Responsibilities
	- Maintain network's capability lists
	- Process synchronization
	- Communication support
- Communication between distributed objects
	- Shared data objects
	- Message objects
	- Control interactions
- Scheduler with consistent and robust mechanism

### Process manager

- Creates own primitives
	- If kernel does not have primitives
	- Example
		- Test and set
		- P and V
- Responsibilities
	- Create, dispatch, scheduling objects
	- Synchronizing object operations
	- Object communication
	- Deleting objects
- Kernel environment
	- To perform above tasks
- Objects contain all their state information

## Device management

- Devices
	- Opened
	- Read from
	- Written to
	- Closed
- Device parameters initialized
	- Status bits set or cleared
	- Basis
		- Global
		- Cluster
		- Localized
- Allocated/deallocates devices to users
	- Only when process issues OPEN/CLOSE command
- Keeps global accounting of each network device
	- Availability

![figure 10.4](http://snag.gy/b4EJB.jpg)

### Process based DO/S

#### Resources controlled by servers

- Called
	- Guardians
	- Administrators


#### Responsibilities

- Accepting requests for service on individual devices they control
- Processing each request fairly
- Providing service to requester
- Returning to serve others

![figure 10.5](http://snag.gy/S19XE.jpg)

#### Group control

- Systems have clusters of resources
- Configured around complex server processes

#### Administrator

- Administrator process configured as device manager

#### Software

- Accepts local and software remote service requests
- Deciphers meaning
	- Acts on them

#### Server process

- One or more
	- Device drivers
	- Device manager
	- Network server component

### Object based DO/S

- Each device managed same way through network
- Physical device considered an object
	- Surrounded by software layer
- Physical device manipulated by
	- Set of operations
	- Mobilizing device to perform designated functions
- Objects assembled to communicate and synchronize
	- If local device manager cannot satisfy user request
		- Request sent to another device manager

#### Users

- No need to know if centralized or distributed network resources

#### Device manager object at each site

- Maintains current directory of device objects at all sites

## File management

- Provide file transport mechanisms
	- Find
	- Open
	- Read
	- Write
	- Close
	- Create
	- Delete

### Subset of database managers

- Distributed database management implementation
	- Part of LAN

### Tasks

- Concurrency control
- Data redundancy
- Location transparency / distributed directory
- Deadlock resolution/recovery
- Query processing

![table 10.3](http://snag.gy/6WiWf.jpg)

### Concurrency control

- System ability to perform concurrent reads/writes
	- Provided actions do not jeopardize database
- Provides serial execution view on database

### Data redundancy

- Makes files faster/easier to read
- Allows process to read copy closest or easiest to access
- Read request split into several different requests for larger file
- Advantages
	- Easy disaster recovery
- Disadvantage
	- Keeping multiple copies of same file up to date at all times
	- Updates performed at all sites

### Location transparency / distributed directory

- Users not concerned with physical location of files
	- Deal with network as a single system
- Provided by mechanisms and directories
	- Map logical data items to physical locations

#### Distributed directory

- Manages data locations transparency
- Enhances data recovery for users

#### Contains

- Definitions for stored physical data and logical structure
- Policies and mechanisms mapping the two
- System wide names of all resources and addressing mechanisms
	- For locating and accessing them

### Deadlock resolution/recovery

- Critical issue in distributed systems
- Most important function
	- Detect/recover from circular wait
	- Complex/difficult to detect because
		- It involves multiple
			- Processes
			- Resources
- Strategies used by distributed system
	- Detection
	- Prevention
	- Avoidance recovery

#### Recognize circular waits

- System uses directed resource graphs
- Looks for cycles

#### Prevent circular waits

- Delays transaction start until it has all resources

#### Avoid circular waits

- Allows execution if transaction can run to completion

#### Recovery

- System selects best victim
- Kills victim
- Reallocates its resources to waiting processes

![figure 10.6](http://snag.gy/yc631.jpg)

### Query processing

- Function of processing requests for information
- Increases effectiveness
	- Global query execution sequences
	- Local site processing sequences
	- Device processing sequences
- Ensures consistency of entire system's scheduling scheme
	- Query processing strategy
	- Integral processing scheduling strategy part

## Network management

- Provides concurrent process policies
	- Intra/intersite communication

### Responsibilities

- Locate processes in network
- Send messages through network
- Track media use
- Reliably transfer data
- Code/decode messages
	- Retransmit errors
- Perform parity checking
	- Do cyclic redundancy checks
	- Establish redundant links
- Acknowledge messages/replies if necessary

### Functions

- Links processes/objects together through port
	- When communication needed
- Provides routing functions
- Keeps network use statistics
	- Message scheduling
	- Fault localizations
	- Rerouting
- Aids process time synchronization
	- Systemwide clock

### Process based DO/S

- Inter process communication transparent to users

#### Responsibilities

- Allocating ports to processes
- Identifying every process in network
- Controlling message flow
- Guaranteeing transmission/acceptance of messages
	- Without errors
- Interfacing mechanisms for every process
- Traffic operator
	- Accepts/interprets send/receive commands

### Object based DO/S

- Easy inter/intramode communications among cooperative objects
- No need to know receiver location
	- Only receiver's name
- Provides messages proper routing to receiver
- Process invokes operation part of its local object environment
- Services usually provided at kernel level

![table 10.4](http://snag.gy/lqp94.jpg)

# NOS development

- NOS runs on a server
	- Performs network services
	- Workstations are clients
- Network management functions
	- Only when system needs to use network
- Focus on sharing resources
	- Not running programs
- Factors for choosing NOS
	- Applications to run on server
	- Technical support required
	- User's training level

![figure 10.7](http://snag.gy/v5sho.jpg)

### Important NOS features

- Support
	- Standard LAN technologies
	- Client desktop OS
- Robust architecture adapting easily to new technologies
	- Support every OS in corporate information network
- Operate wide range of third party software/hardware
- Support multiuser network applications software
- Blend efficiency with security

### Major NOS functions

- Transfer files between computers
- Example
	- FTP command
	- Not true file sharing
	- Must copy file to local disk
	- Duplicates/wastes space
	- Needs version control
- Anonymous FTP
	- Files available to general public
- Advantages
	- Web for FTP
		- User knows how to use browser

# Summary

- NOS
	- No full utilization of global resources available to all connected sites
- DO/S
	- Specifically addresses NOS failure
- Specific requirements
	- Secure from unauthorized access
		- Accessible to authorized users
	- Monitor available system resources
		- Communication links
	- Perform required networking tasks
