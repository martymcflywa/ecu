# Chapter 7: Device management

## Objectives

- Features of devices
	- Dedicated
	- Shared
	- Virtual
- Differences between
	- Sequential access media
	- Direct access media
- Concepts of blocking and buffering
	- How they improve IO performance
- Roles in calculating access time
	- Seek time
	- Search time
	- Transfer time
- Differences in access times in several types of devices
- Critical components of input/output subsystem
	- How they interact
- Strengths/weaknesses of common seek strategies
	- FCFS
	- SSTF
	- SCAN/LOOK
	- C-SCAN/C-LOOK
- Different levels of RAID

## Introduction

- Device manager must manage every peripheral device of system
	- Maintains balance of supply and demand
		- Finite supply of devices
		- Infinite demand for them
- Device management basic functions
	- Monitor status of devices
		- Storage drives
		- Printers
	- Enforce preset policies
		- Determine which process will
			- Get device
			- How long
	- Allocating devices
	- Deallocating devices at two levels
		- Process/task level
			- When IO command has been executed
				- Device temporarily released
		- Job level
			- Job is finished
			- Device permanently released

## Types of devices

- Three allocation categories
	- Dedicated
	- Shared
	- Virtual

### Dedicated

- Must be assigned to one job at a time
- Serve that job for entire time it is active or released
- Devices that demand this type of allocation
	- Tape drives
	- Printers
	- Plotters
- Can't allow multiple simultaneous processes
- Disadvantage
	- Must be allocated to single user for duration of job execution
		- Inefficient
		- Device not used 100% of time

### Shared

- Can be assigned to multiple processes
- Devices that can be shared
	- Disk
	- Direct access storage device (DASD)
- Can be shared by multiple simultaneous processes
	- Interleaved requests
		- Must be controlled by device manager
- Conflicts
	- Resolved based on predetermined policies
		- Decides which requests are handled first
	- Example
		- Process A and process B need to read from same disk

### Virtual

- Combination of dedicated and shared
- Dedicated devices transformed into shared devices
- Example devices
	- Printers
		- Converted into sharable devices
			- Through spooling program
				- Reroutes print requests to disk
			- When all of job's output is written to disk
				- Printer is ready to print document
				- Spool output is sent to printer
			- Must be managed to prevent deadlock

### Example: USB controller

- Acts as interface between
	- OS
	- Device drivers
	- Applications
	- Devices connected to USB
- One USB host can accommodate up to 127 different devices
- Each device identified by USB controller with unique ID number
	- Allows many devices to exchange data using same USB connection
- USB controller assigns bandwidth to each device depending on priority
	- High priority
		- Real time exchanges
		- Interruption in data flow not allowed
			- Video
			- Sound data
	- Medium priority
		- Allow occasional interrupts without jeopardizing use of device
			- Keyboard
			- Joystick
	- Low priority
		- Bulk transfers/exchanges
		- Can accommodate slower data flow
			- Printers
			- Scanners

## Sequential access storage media

- Magnetic tape
	- Records stored serially
- Length of records
	- Determined by application
- Identification of record
	- Position on tape
- To access single record
	- Tape must be
		- Mounted
		- Fast forwarded from beginning to desired position
	- Time consuming

### Magnetic tape example

- Tape reel 2400 feet long
	- Figure 7.1
- Data recorded on eight of nine parallel tracks
	- Ninth track holds parity bit used for error checking

![figure 7.1](http://snag.gy/upei4.jpg)

- Number of characters that can be recorded per inch determined by density of tape
	- 1600 bytes per inch (bpi)
- Example
	- Records = 160 char
	- Tape density = 1600 bpi
	- Could store 10 records per inch
- In practice
	- Depends on how records are stored
		- Individually or grouped into blocks
- If stored individually
	- Each record would need to be separated by a space to indicate start/end points
- If stored as blocks
	- Entire block preceded/followed by space
	- Individual blocks stored sequentially

### Read/write magnetic tape

- When there is need to read/write
	- Tape moves under read/write head to correct position
- At all other times
	- Tape is not moving
- Tape needs time/space to stop
	- Gap inserted between each record
		- Interrecord gap (IRG)

### Interrecord gap (IRG)

- Standard size
- Half inch long regardless of size of record
- Example
	- 10 records
	- 9 gaps
- Figure 7.2
	- 5.5 inches of tape required to store 1 inch of data
		- Stored sequentially
	- Not efficient

![figure 7.2](http://snag.gy/HOESp.jpg)

### Blocking

- Store groups of records into blocks
- Performed when file is created
- Number of records in block determined by application
	- Set to take advantage of the transfer rate
		- Density of tape
		- Multiplied by transport speed
			- Tape drive speed
			- Inches per second

>(transfer rate (ips)) = (density) * (transport speed)

- Example
	- Transport speed = 200 ips
	- Tape density = 1600 bpi
	- 1600 * 200 = 320,000 bytes per second
- This technique requires that entire block be read into a buffer
	- So buffer must be at least as large as the block
- Figure 7.3
	- Shows interblock gap
		- Still half inch long
	- But data from each block of 10 records stored in 1 inch of tape
		- Only used 1.5 inches of tape
			- Instead of 5.5 inches from figure 7.2
		- Wasted only one half inch tape
			- Instead of 4.5 inches

![figure 7.3](http://snag.gy/OObUb.jpg)

#### Blocking advantages

- Fewer IO operations
	- Single READ command moves entire block
		- From physical record to main memory
- Less tape is wasted
	- Size of physical record exceeds size of gap

#### Blocking disadvantages

- Overhead needed for
	- Blocking
	- Deblocking
	- Record keeping
- Buffer space may be wasted
	- May only need one logical record
	- Must read entire block to get it

### Magnetic tape access times

- Depends where record is located
- Example
	- Tape reel = 2400 ft
	- Transport speed = 200 ips
- Table 7.1 shows access times

![table 7.1](http://snag.gy/ypqeH.jpg)

## Direct access storage devices (DASD)

- Can directly read/write to specific place
- Three categories
	- Magnetic disks
		- Fixed head
		- Movable head
	- Optical disks
	- Flash memory
- Location of specific record effects access time

### Fixed head magnetic disk

- Fixed head
	- Faster than movable head disks
		- Tracks must be positioned further apart
			- Due to head width
- Looks like CD/DVD
- Formatted both sides
- Tracks
	- Concentric circles
- Data
	- Recorded serially on each track
	- By fixed read/write head positioned over it
- Used when speed is important
	- Aircraft
	- Space flight
- Figure 7.4

![figure 7.4](http://snag.gy/Ik9Ln.jpg)

### Movable head magnetic disk

- Computer hard drives
- One read/write head
	- Floats over surface of each disk
- Can be
	- Single platter
	- Stack of magnetic platters
		- Disk pack
- Figure 7.5 shows typical disk pack
	- Platters stacked on central spindle
	- Separated by enough space to allow read/write heads to move between each pair of disks

![figure 7.5](http://snag.gy/24ZuR.jpg)

- Each platter has two surfaces for recording
	- Except top and bottom
	- Each surface formatted with specific number of concentric tracks
		- Where data is recorded
- Number of tracks varies between manufacturers
	- High capacity disks
		- 1000+ tracks
- Each track is numbered
	- Track 0
		- Outermost track
	- Track N - 1
		- N = number of tracks
		- Innermost track
- Arm
	- Figure 7.6
	- Moves two read/write heads between pair of surfaces
		- One for above surface
		- One for below surface
	- Moves all heads in unison
		- If one head is on track 36
			- All heads are on track 36
		- Positioned on same track
			- But on respective surfaces
			- Creates virtual cylinder

![figure 7.6](http://snag.gy/2MKvP.jpg)

- Questions
	- Is it more efficient
		- To write series of records on each surface sequentially
		- To fill up every outside track of every surface before moving head inward to next track
- It is slower to fill a disk pack surface-by-surface than track-by-track
- Concept
	- If we fill track 0 of all surfaces
		- We have a virtual cylinder of data
	- There are as many cylinders as there are tracks
		- Cylinders are as tall as the disk pack
- Cylinders
	- Series of smaller soup cans
		- Nested inside larger ones

#### Accessing records

- Needs three things
	- Cylinder number
		- Arm moves head to it
	- Surface number
		- Proper head is activated
	- Sector number
		- Head knows when it begins read/write
		- Figure 7.7

![figure 7.7](http://snag.gy/F1hmp.jpg)

### Optical disk

- Uses laser technology
- Magnetic vs. optical
	- Magnetic
		- Concentric tracks of sectors
		- Spins at constant speed
			- Constant angular velocity (CAV)
		- Outer sectors spin faster than inner sectors
			- Outer sectors larger
			- Inner sectors smaller
		- Wastes storage space
		- Maximizes retrieval speed
	- Optical
		- Single spiraling track
			- Same sized sectors
			- Track starts from inner to outer
			- Figure 7.8
		- Sectors
			- Same size regardless of location
			- Allows more
				- Sectors
				- Data
		- Drive
			- Adjusts speed of spin
				- Compensates for sector's location on disk
				- Constant linear velocity (CLV)
			- Disk spins faster to read inner sectors
			- Disk spins slower to read outer sectors

![figure 7.8](http://snag.gy/sRhFq.jpg)

#### Optical disk features

- Sustained data transfer rate
	- Measured in megabytes per second
	- Refers to speed at which massive amounts of data can be read from disk
	- Crucial for applications requiring sequential access
		- Audio
		- Video
- Average access time
	- Retrieving data not stored sequentially
	- Average time required to move the head to specific place on disk
		- Expressed in milliseconds ms
	- Fastest units have smallest average access time
	- Most important factor when searching for information randomly
		- ie. Database
- Data transfer rate vs. average access time
	- Data transfer rate
		- Important for sequential disk access
	- Average access time
		- Important for retrieving data dispersed on disk
- Cache size
	- Not a speed measurement
	- Substantial impact on perceived performance
	- Acts as buffer
		- Transfers blocks of data from disk
		- Anticipates user may want to reread recently retrieved records
		- Can be done quickly if data is in cache
	- Can also act as read-ahead buffer
		- Looks for next block of data from disk
		- Useful for media playback
			- Continuous stream of data
		- Fills up quickly
			- Become more useful when paging through database or ebook
			- Cache has time to recover while user is reading current piece of data

#### Optical disk types

- CD
- DVD
- Bluray
- Figure 7.9

![figure 7.9](http://snag.gy/6WgDk.jpg)

#### Writing to optical disk

- Pits
	- Burned in by laser beam
	- Represents 0
- Lands
	- Unburned areas
	- Represent 1
- First sectors
	- Located in center if disc
- Laser moves outward to read each sector
- Multilayer disc
	- Laser course reversed to read second layer
	- Arm moves from outer to inner

#### CD/DVD

- Read by low powered laser
	- Shines through protective layer to track
- Light striking a land
	- Reflected into a photodetector
- Light striking a pit
	- Scattered
	- Absorbed
- Photodetector converts intensity of light to binary

#### CDR/DVDR

- More expensive controllers
- Need to incorporate write mechanisms
- CD
	- Several layers
		- Gold reflective layer
		- Dye layer
		- Used to record data
	- Write
		- High power laser beam to record data
		- Permanent mark is made on the dye
			- Laser beam absorbed
			- Cannot be erased
	- Read
		- Existence of mark on dye
			- Laser beam scatters
			- Light not returned back to read head
			- Like reading pit
			- Represents 0
		- No mark on dye
			- Gold layer reflects light back to read head
			- Like reading land
			- Represents 1
	- ISO 9096
		- Automatically error checks
		- Creates table of contents
			- Tracks file locations

#### CDRW/DVDRW

- Rewritable
- Uses phase change technology to
	- Write
	- Change
	- Erase
- Recording layer
	- Uses alloy of
		- Silver
		- Indium
		- Antimony
		- Tellurium
	- Two phase states
		- Amorphous
			- Light not reflected well
		- Crystalline
			- Light reflects well
- Write
	- Laser beam heats up disc
	- Changes state from crystalline to amorphous
	- Like burning pit
- Read
	- Amorphous areas
		- Scatters light
		- Like reading pit
		- Represents 0
	- Crystalline areas
		- Light reflected back to head
		- Like reading land
		- Represents 1
- Erase
	- Low energy beam
	- Heats up pits
	- Loosens allow
	- Returns to crystalline state

#### DVD

- Holds more data
	- Dual layer, single side DVD
		- Equivalent to 13 CDs
- Red laser
	- Shorter wavelength than CD laser
	- Makes smaller pits
	- Spirals wound tighter

#### Bluray

- Different laser tech
	- Blue violet
	- 405nm
- Smaller pits
- Tighter wound tracks
- Higher density
- Figure 7.9
- Laser can write on thinner layer
- Capacity
	- Bluray two layer disc
		- 50GB
	- Bluray 20 layer disc
		- 500GB
	- DVD two layer disc
		- 8.5GB
- Read speed
	- Faster
		- 432Mbps
	- DVD
		- 168.75Mbps
- Types
	- BD-ROM
		- Read only
	- BD-R
		- Recordable
	- BD-RE
		- Rewritable

#### Flash memory

- Electrically erasable programmable read only memory
	- EEP-ROM
- Non volatile removable medium
	- Emulates RAM
- Stores data securely without power source
- Uses Fowler-Nordheim tunneling
	- Sends electrons through floating gate transistor
		- Remains there even after power turned off
	- Allows to store data
- Writing
	- Electric charge sent through one transistor
		- Called floating gate
	- Then through metal oxide layer
	- Into second transistor
		- Called control gate
	- Charge is stored in control gate until erased
- Erasing
	- Strong electrical field applied to entire card
		- Called flash
- Limitations
	- Bits can be erased only by flashing a large block of memory
	- Each flash causes blocks to become unstable
		- After 10,000 to 1,000,000 uses
			- Device no longer reliable

## Components of the IO subsystem

- IO subsystem components have to work together
- Similar to figure 7.11
	- Flynn taxicab company
	- Requests come from all over the city
		- Handled by dispatcher
	- Dispatcher organizes calls
		- Must use resources efficiently

![figure 7.11](http://snag.gy/Djr3v.jpg)

- IO subsystem components
	- Perform similar functions
- Channel
	- Like dispatcher
	- Job
		- Keep up with IO requests from CPU
		- Pass them to appropriate control unit
- Control unit
	- Like mechanics
- IO devices
	- Like vehicles

### IO channel

- Programmable units between CPU and control units
- Synchronizes
	- Fast speed of CPU
	- Slow speed of IO
- Makes it possible for concurrent operations between
	- IO
	- Processor
- Uses IO channel programs
	- Range in size
		- One to many instructions
	- Specifies action to be performed by the devices
	- Controls transmission of data between memory and control units
- Sends one signal for each function
	- IO control unit interprets signal
		- Example
			- Printer
				- Go to top of page
			- Tape drive
				- Rewind

### Disk controller/interface

- Links disk drives with system bus
- Control transfer of information between
	- Disk drives
	- Rest of computer system
- OS normally deals with controller not device

### IO commands

- Passes information from CPU to channel
	- IO command
		- Read
		- Write
		- etc.
	- Channel number
	- Address of physical record to be transferred
	- Starting address of memory buffer where record is transferred from/to

### Control units

- Channels
	- As fast as CPU
	- Can direct several control units
		- Interleaved commands
- Control units
	- Can direct several devices
- Typical configuration
	- One channel
		- Eight control units
			- 8 devices per control unit
- Shared channels
	- Most expensive item in IO subsystem
- Figure 7.12
	- Requires entire path available when IO command is initiated
	- Flexibility in system
		- Each unit can end independently of others
	- Shows hierarchical nature of communication between device and transmission path
		- Interconnection
		- One-to-one correspondence

![figure 7.12](http://snag.gy/4MpWx.jpg)

- Additional flexibility
	- Connect more than one channel to a control unit
	- Connect more than one control unit to single device
- Multiple paths
	- Increase reliability of IO subsystem
	- Keeps communication lines open even if component malfunctions
	- Figure 7.3
		- Shows same system as figure 7.3
		- But with one control unit connected to two channels
		- One device connected to two control units

![figure 7.13](http://snag.gy/VQqaq.jpg)

## Communication among devices

- Three problems to solve
	- Identify busy/free components
		- Answer
			- Structure interaction between units
	- Handle requests during heavy IO traffic
		- Answer
			- Buffer records
	- Handle disparity of speeds between
		- CPU
		- IO device
		- Answer
			- Queue requests
- Each unit in IO subsystem can finish operation independently from others
	- Before device completes task
		- Connection between device and control unit can be cut off
		- Control unit can initiate another IO task for another device
	- CPU is free to process data while IO is performed
		- Allows concurrent processing and IO

### Identify free/busy devices

- Use hardware flag
	- Tested by CPU
- Flag
	- 3 bits
	- Resides in **channel status word (CSW)**
		- Predefined location in memory
	- Contains status of channel
	- Each bit
		- Represents one of the components of IO subsystem
			- Channel
			- Control unit
			- Device
		- Changes from 0 to 1
			- Indicates unit is free or busy
- Each component has access to the flag
	- Can be tested before proceeding with next IO
	- Ensures entire path is free/busy
- Two common ways to perform test
	- Polling
	- Interrupts

#### Polling

- Machine instruction performs test
- CPU periodically tests channel status bit of CSW
- If channel still busy
	- CPU performs other processing task until test shows channel is free
	- Then performs IO operation
- Problem
	- How often should flag be polled
	- Too frequent
		- CPU wastes time testing flag
	- Too seldom
		- Channel sits idle for long periods of time

#### Interrupts

- More efficient than polling
- Hardware mechanism performs test
	- Part of every machine instruction executed by CPU
- If channel busy
	- Flag is set so execution of current sequence of instructions is automatically interrupted
	- Control is transferred to interrupt handler
		- Part of OS
		- Resides in predefined area in memory
- Interrupt handler
	- Job to determine best course of action based on current situation
	- Not unusual to have multiple units cause IO interrupt
	- Must
		- Find which unit sent the signal
		- Analyze status
		- Restart when appropriate with next operation
		- Return control to interrupted process

##### Interrupt classes

- Some sophisticated systems are equipped with hardware to distinguish between several classes of interrupts
- Ordered by priority
- Each can transfer control to corresponding location in memory
- Memory locations
	- Ranked in order according to same priorities
- Example
	- If CPU is executing interrupt handler routine associated with given priority
		- Hardware will automatically intercept all interrupts at the same or lower priorities
- Helps improve system utilization
	- Each interrupt is handled according to relative importance

### Direct memory access

- IO technique allows control unit to directly access memory
- Once read/write begun
	- Remainder of data can be transferred to/from memory without CPU
- It is possible that DMA control unit and CPU compete for system bus if they need it at the same time
- To activate process
	- CPU sends enough information
		- Type of operation
		- IO device unit number
		- Data memory location
	- Received by DMA control unit
		- Initiates transfer of data
	- CPU then moves on to another task
		- While control unit completes IO transfer independently
	- DMA controller then sends interrupt to CPU
		- Indicates operation is complete
- Method used for high speed devices
	- ie. Disks
- Without DMA
	- CPU is responsible for physical movement of data between memory and device
		- Time consuming task
		- Significant overhead
		- Decreased CPU utilization

### Buffers

- Helps synchronize movement of data between
	- Slow IO device
	- Fast CPU
- Temporary storage areas
	- Three locations
		- Main memory
		- Channels
		- Control units
- Used to
	- Store data from input device
		- Before it is needed by CPU
	- Store data that will be written to output device
- Typical use of buffers
	- When blocked records are either read/written to IO device
	- Example
		- One physical record contains several logical records
		- Must reside in memory while processing of each individual record occurs
		- If a block contains 5 records
			- Physical READ occurs with every six READ commands
			- All other READ requests are directed to retrieve information from the buffer
				- May be set by application

#### Double buffering

- Minimize
	- Idle time for devices
- Maximize
	- Throughput
- Figure 7.14
- Two buffers present in
	- Memory
	- Channels
	- Control units
- Objective
	- Have a record ready to be transferred to/from memory at any time
	- Avoid possible delay when waiting for buffer to fill up with data
- While one record is processed by CPU
	- Another can be read/written by channel

![figure 7.14](http://snag.gy/WTNUt.jpg)

- When using blocked records
	- Receiving READ command to last logical record
	- Channel can start reading next physical record
	- Results in overlapped IO and processing
- When first READ command received
	- Two records are transferred from device
	- Immediately fill both buffers
- Then as data from one buffer is processed
	- Second buffer is ready
- As second is being read
	- First buffer is being filled with data from third record
- And so on...

## Management of IO requests

- Device manager divides task into three parts
	- Each handled by specific software component of IO subsystem
		- IO traffic controller
			- Watches status of all
				- Devices
				- Control units
				- Channels
		- IO scheduler
			- Implements policies determining interaction
				- Allocation
				- Access
		- IO device handler
			- Performs actual transfer of data
			- Processes device interrupts

### IO traffic controller

- Monitors status
- Becomes more complex as number of units in IO subsystem increases
	- Number of paths between units increases
- Three main tasks
	- Determine if there is at least one path available
	- If multiple paths available
		- Determine which one to select
	- If paths are all busy
		- Must determine when one will become available
- Maintains database containing status and connections for each unit
	- Grouped into
		- Table 7.4
		- Channel control blocks
		- Control unit blocks
		- Device control blocks

![table 7.4](http://snag.gy/k6vjb.jpg)

- Selecting free path to satisfy IO request
	- Traffic controller traces backward from
		- Control block of requested device
		- Through control units to channels
	- If path not available
		- Its process (PCB) is linked to the queues kept in the control blocks of the
			- Requested device
			- Control unit
			- Channel
	- Creates multiple wait queues
		- One queue per path
- When path becomes available
	- Traffic controller selects first PCB from queue for that path

### IO scheduler

- Same job as process scheduler
- Allocates
	- Devices
	- Control units
	- Channels
- Under heavy load
	- Number of requests greater than number of available paths
	- Must decide which request to satisfy first
	- Similar criteria for process scheduler applies here
- IO scheduler vs. process scheduler
	- IO requests not preempted
		- Once channel program has started
			- It continues to completion even though IO requests with higher priorities may have entered the queue
		- Feasible because
			- Channel programs usually short
				- 50ms to 100ms
	- Other systems may subdivide IO request into several stages
		- Allow preemption of IO requests during one of the stages
- Some systems may allow IO scheduler to give preferential treatment to IO requests
	- From high priority programs
	- If process has high priority
		- IO requests would also have high priority
		- Would be satisfied before other IO requests with lower priorities
- IO scheduler must synchronize its work with the traffic controller
	- Makes sure that a path is available to satisfy selected IO requests

### IO device handler

- Processes IO interrupts
- Handles error conditions
- Provides detailed scheduling algorithms
	- Device dependent
- Each type of IO device has own device handler algorithm

## Device handler seek strategies

- Predetermined policy that device handler uses to allocate access to the device among many processes that may be waiting for it
- Determines order which processes get the device
- Goal
	- Minimize seek time
- Common seek strategies
	- First come first served (FCFS)
	- Shortest seek time first (SSTF)
	- SCAN
		- LOOK
		- N-Step
		- SCAN
		- C-SCAN
		- C-LOOK

### Device handler goals

- Three goals
- Every scheduling algorithm must minimize
	- Arm movement
	- Mean response time
	- Variance in response time

### First come first served (FCFS)

- Simplest algorithm
	- Easy to program
	- Fair to users
- Problems
	- Doesn't meet any of device handler goals

#### FCFS Example

- Single sided disk
- One recordable surface
- Tracks numbered 0 to 49
- Takes 1ms to travel from one track to next
- While reading track 15
	- Requests have arrived to read following tracks
		- 4
		- 40
		- 11
		- 35
		- 7
		- 14
- Once requested track reached
	- Entire track is read into memory
- Path shown in figure 7.15
- Takes 135ms for arm to to satisfy entire series of requests
	- Not including
		- Search time
		- Data transfer

![figure 7.15](http://snag.gy/enUrO.jpg)

- Seek time most time consuming
- Algorithm minimizing it is preferred over FCFS

### Shortest seek time first (SSTF)

- Same as shortest job next (SJN)
	- Shortest jobs processed first
	- Longer jobs wait
- Request with track closest to current track is next
	- Minimizes overall seek time
- Figure 7.16 shows same requests as figure 7.15
	- But with SSTF
	- Requests took 47ms

![figure 7.16](http://snag.gy/fT8AS.jpg)

#### SSTF disadvantage

- Can cause starvation
	- Never moves to further track
- Example
	- Currently serving closely grouped requests
		- Then receives request for further track
		- Then continues receiving requests closer to current track
		- SSTF may never satisfy request to further track
- Meets first goal
	- Fails other two

### SCAN

- Uses directional bit
- Indicates whether arm is moving towards/away from center
- Algorithm moves arm methodically from
	- Outer to inner
		- Service requests in path
	- When arm reaches inner
		- Reverses direction
		- Services requests in path
	- Vice versa
- Variations
	- Look
	- N-Step SCAN
	- C-SCAN
	- C-LOOK
- Meets all three goals for seek strategies

#### LOOK

- Optimization of SCAN
- Elevator algorithm
- Arm may not go all the way in/out
- Looks ahead for request before servicing it
- Figure 7.17
	- Arm is moving towards inner tracks before reversing direction
		- Inner tracks
			- Higher numbered

![figure 7.17](http://snag.gy/b0zLa.jpg)

- Result
	- 61ms to satisfy all requests
		- 14ms more than SSTF
	- But eliminates possibility of indefinite postponement
- As requests arrive
	- Each is added to proper place in queue
	- Service when arm reaches track
- Example
	- If track 11 is being serviced when request for track 13 arrives
		- Track 13 must wait until arm starts on its way back
		- Similar for track 16
- Eliminates arm movement
- Saves time

#### N-Step SCAN

- Holds all new requests until arm reverses direction
- Any requests that arrive while arm is in motion are grouped for next sweep

#### C-SCAN

- Circular SCAN
- Arm picks up requests during inward sweep
- When innermost track reached
	- Arm immediately returns to outermost track
	- Begins servicing requests that arrived during last sweep
- System can provide quicker service to requests that accumulated for low numbered tracks while arm was moving inward
- Theory
	- By the time arm reaches highest numbered tracks
	- There are few requests immediately behind it
- However
	- There are many requests at the end of the disk
	- These have been waiting the longest
- Designed to provide more uniform wait time

#### C-LOOK

- Optimization of C-SCAN
- Inward sweep stops at last high numbered track request
	- Arm does not move to inner most track unless required to
- Arm doesn't necessarily return to outermost track
	- Only returns to lowest numbered track requested

### Seek strategy comparisons

- Up to system designer to select best algorithm for environment
- Performance depends on load to be handled
- Generalizations
	- FCFS
		- Works well with light loads
		- If load grows
			- Service time becomes unacceptably long
	- SSTF
		- Popular
		- Works well with moderate loads
		- Problem
			- Localization under heavy load
	- SCAN
		- Works well with light/moderate load
		- Eliminates indefinite postponement
		- Similar to SSTF throughput
		- Small variance in service times
	- C-SCAN
		- Works well with moderate to heavy loads
		- Very small variance in service times
- Combination of more than one scheme may work well
	- Example
		- SCAN or LOOK during light/moderate load
		- C-SCAN/C-LOOK during heavy load

![table 7.9](http://snag.gy/0YXMp.jpg)

## Search strategies: Rotational ordering

- Optimizes search times
- Orders requests once read/write heads have found correct position
- Figure 7.18 shows virtual cylinder
	- List of requests arrive for different sectors on different tracks
	- Cylinder only has 5 tracks
		- 0 to 4
	- Each track contains 5 sectors
		- 0 to 4
	- Requests taken in order they arrive
		- Table 7.5

![figure 7.18](http://snag.gy/JXryn.jpg)

![table 7.5](http://snag.gy/CWAKr.jpg)

- Amount of time wasted due to rotational delay can be reduced
- If requests are ordered within each track so first sector request on the second track is the next number higher than the one just served
	- Rotational delay is minimized
		- Table 7.6

![table 7.6](http://snag.gy/ZQs8Q.jpg)

- To implement algorithm
	- Device controller must provide rotational sensing
	- Device driver can determine which sector is currently under read/write head
- Under heavy IO loads
	- This kind of ordering can significantly increase throughput
		- Especially if device has fixed read/write heads rather than movable heads
- Disk pack cylinders are an extension of previous example
	- Once heads are positioned on a cylinder
		- Each surface has its own read/write head
			- See figure 7.5
	- Rotational ordering can be accomplished on surface-by-surface basis
	- Read/write heads can be activated in turn with no additional movement required
- Only one read/write head can be active at one time
	- Controller must be ready to handle mutually exclusive requests
		- ie. Request 2 and 5 in table 7.6
	- They are mutually exclusive because both are requesting Sector 3
		- At track 1
		- At track 2
	- But only one of two read/write heads can be transmitting at one time
	- So policy could state that tracks will be processed from low to high numbered
		- Then high to low numbered in sweeping motion
			- Like SCAN
- To handle requests on a disk pack
	- There would be two orderings of requests
		- One to handle position of read/write heads making up the cylinder
		- The other to handle processing of each cylinder

## RAID

- Set of physical drives viewed as single logical unit by OS
- Introduced to close gap between
	- Fast CPU
	- Slow disk drives
- RAID assumes
	- Several small capacity drives are preferable over few large capacity drives
	- Distributes data among several disks
		- System can simultaneously access requested data from multiple drives
		- Improves
			- IO performance
			- Data recovery in event of failure
- Typical configuration
	- Several drives connected to specialized controller
		- Houses software that coordinates transfer of data from disks in array to large capacity disk connected to IO subsystem
			- See figure 7.19
	- Viewed by OS as single large capacity disk
		- No software changes required

![figure 7.19](http://snag.gy/qSFYi.jpg)

- Strips
	- Data divided into segments
	- Strips distributed across the disks in array
- Stripes
	- A set of consecutive strips across disks
- Striping
	- Process of dividing data into strips and stripes
- Seven levels of RAID
	- Level 0 to 6
	- Table 7.7

![table 7.7](http://snag.gy/fEe0m.jpg)

### RAID 0

- Uses data striping without parity
	- No error correction
- Only level without error correction/redundancy
	- Not considered true form of RAID
	- Cannot recover from hardware failure
- Offers same benefit of RAID
	- Group of devices appear to OS as single unit
- Suited for transferring large quantities of non critical data
- Figure 7.20
	- When OS issues read command for first four strips
		- All four strips can be transferred in parallel
		- Improves performance
- Works in combination with other configurations

![figure 7.20](http://snag.gy/ciSxp.jpg)

### RAID 1

- Uses striping
- Mirrored configuration
	- Provides redundancy
- Duplicate set of all data in a mirror array of disks
	- Acts as backup system in event of hardware failure
- If one drive fails
	- System retrieves data from backup disk
- Reliable
- Figure 7.21
	- Three disks
	- Identical array
		- Main and mirror

![figure 7.21](http://snag.gy/hVYox.jpg)

### RAID 2

- Uses small strips
	- Size of word or byte
- Uses hamming code to provide error correction/detection
- Hamming code
	- Algorithm that adds extra redundant bits to data
	- Able to
		- Correct single bit errors
		- Detect double bit errors
- Expensive and complex
	- Number of disks in array depends on
		- Size of strip
	- Drives must be highly synchronized in
		- Rotational movement
		- Arm positioning
- Example
	- Each strip is 4 bits
	- Hamming code adds 3 parity bits in positions 1, 2 and 4 of the newly created 7 bit data item
- Figure 7.22
	- Array of 7 disks
		- One for each bit
- Advantage
	- If drive fails
		- Only one bit would be affected
		- Data quickly recovered

![figure 7.22](http://snag.gy/SgD7q.jpg)

### RAID 3

- Modification of RAID 2
- Requires only one disk for redundancy
- Only one parity bit is computed for each strip
	- Stored in designated redundant disk
- Figure 7.23 shows 5 disk array
	- Stores 4 bit strips and parity bit
- If drive fails
	- RAID controller considers all bits coming from that drive to be 0
	- Notes the location of damaged bit
- If data item being read has a parity error
	- Controller knows that the bit from the faulty drive should have been a 1
		- Corrects it
- If data is written to array that has failed disk
	- Controller keeps the parity consistent so data can be regenerated when array is restored
- System returns to normal when failed disk is replaced
	- Contents regenerated on new disk

![figure 7.23](http://snag.gy/Apfln.jpg)

### RAID 4

- Same strip scheme as RAID 0 and 1
- Computes parity for each strip
	- Stores parities in corresponding strip in designated parity disk
- Figure 7.24 shows 4 disk array
	- Three disks hold data
	- Fourth disk stores parities for corresponding strips on first three disks
- Advantage
	- If any one drive fails
		- Data can be restored using bits in parity disk
	- Parity is computed every time a write command is executed
- However
	- If data is rewritten
		- RAID controller must update both data and parity strips
- Disadvantage
	- Parity disk is accessed with every write/rewrite
	- Can cause bottleneck in system

![figure 7.24](http://snag.gy/aOY96.jpg)

### RAID 5

- Modification of RAID 4
- Instead of using one disk for storing parities
	- It distributes parity strips across the disks
	- Avoids bottleneck in RAID 4
- Disadvantage
	- Regenerating data from failed drive is more complicated

![figure 7.25](http://snag.gy/fb7xR.jpg)

### RAID 6

- Provides extra degree of error detection/correction
- Requires two different parity calculations
	- One calculation is same used in RAID 4 and 5
	- Other calculation is an independent data-check algorithm
- Both parities are distributed on separate disks across array
	- Are stored in strips that correspond with data strips
		- See figure 7.26
- Advantage
	- Double parity allows for restoration even if two disks fail
- Disadvantage
	- Redundancy increases time needed to write data
	- Each write affects two parity strips
	- Requires two disks become dedicated to parity strips
		- Not data
		- Reduces number of data disks in array

![figure 7.26](http://snag.gy/IUysH.jpg)

### Nested RAID

- Complex configurations of RAID by combining multiple levels
- Example
	- RAID 10
		- Combines RAID 1 and RAID 0
		- Both controlled by single RAID 0 system
		- See figure 7.27
- See table 7.8

![figure 7.27](http://snag.gy/0NSHq.jpg)

![table 7.8](http://snag.gy/BqpmP.jpg)

## Conclusion

- Device manager's job
	- Manage every system device as effectively as possible
- Device unique characteristics
	- Varying
		- Speeds
		- Degrees of sharability
	- Some can handle
		- Direct access
		- Sequential access
- Magnetic media
	- Read/write heads
		- One or many
		- Fixed or movable
- Optical media
	- Device manager tracks storage locations
	- Adjusts disc speed accordingly
		- So data is recorded and retrieved correctly
- Flash media
	- Device manager tracks every USB device
	- Assures data is sent/received correctly
- Balancing demand for devices
	- Complex task
	- Divided among several hardware components
		- Channels
		- Control units
		- IO devices
	- Success of IO subsystem depends on communication that links these parts
- Seek strategies
	- Disadvantages
	- Advantages
	- See table 7.9
- RAID
	- Compare strengths/weaknesses of each level
	- Combinations of levels
	- Potential to boost
		- System reliability
		- Error correction
