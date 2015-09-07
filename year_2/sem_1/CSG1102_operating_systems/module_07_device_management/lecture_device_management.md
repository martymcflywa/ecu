# Device management

## Objectives

Describe

- Features of
	- Dedicated
	- Shared
	- Virtual devices
- Differences between sequential and direct access media
- Concepts of blocking and buffering
	- How they improve I/O performance
- Roles of the following in calculating access time
	- Seek time
	- Search time
	- Transfer time
- Differences in access times in several types of systems
- Critical components of the I/O subsystem
	- How they interact
- Strengths/weaknesses of common seek strategies and how they compare
	- FCFS
	- SSTF
	- SCAN/LOOK
	- C-SCAN/C-LOOK
- Different levels of RAID and what sets each apart from others

# Types of devices

## Dedicated devices

- Device assigned for one job at a time
	- For entire time, or until released
		- Job is active
- Example
	- Tape drive
	- Printer
	- Plotter
- Disadvantage
	- Inefficient if device is not used 100%
	- Allocated for duration of job's execution

## Share devices

- Device assigned to several processes
- Example
	- Direct access storage device (DASD)
		- Processes share DASD simultaneously
		- Requests interleaved
- Device manager supervision
	- Controls interleaving
		- Predetermined policies determine conflict resolution

## Virtual devices

- Dedicated and shared device combination
	- Dedicated devices transformed into shared devices
- Example
	- Printer
		- Converted by spooling program
- Spooling
	- Speeds up slow dedicated I/O devices
	- Example
		- Universal serial bus (USB) controller
		- Interface between
			- Operating system
			- Device drivers
			- Applications
			- Devices attached via USB host

# Storage media

- Two groups
- Vast differences
	- Speed
	- Share-ability

## Sequential access media

- Records stored sequentially

## Direct access storage devices (DASD)

- Records stored sequentially
- Records stored using direct access files

# Sequential access storage media

## Advantages

- Low cost
- Compact storage capabilities
- Good for
	- Magnetic disk backup
	- Long term archival

## Disadvantages

- Access time
	- Poor routine for secondary storage
- Poor for interactive applications

## Magnetic tape

- Early use
	- Routine secondary storage
- Today's use
	- Routine archiving and data backup
- Records storage
	- Records stored serially
	- Record length determined by application program
	- Record identified by position on tape
- Record access
	- Tape mount
	- Fast forward to record
- Time consuming process

![figure 7.1](http://snag.gy/v5x0G.jpg)

### Tape density

- Characters recorded per inch
	- Depends upon storage method
		- Individual
		- Blocked
- Tape read/write mechanics
	- Tape moves under read/write head when needed

### Transfer rate

- (tape density) x (transport speed)

![table 7.1](http://snag.gy/GzVEp.jpg)

### Interrecord gap (IRG)

- Half inch gap inserted between each record
- Same size regardless of records it separates

![figure 7.2](http://snag.gy/ALMOw.jpg)

### Interblock gap (IBG)

- Half inch gap inserted between each block
- More efficient than individual records and IRG

![figure 7.3](http://snag.gy/4zFS3.jpg)

### Blocking

- Group records into blocks

#### Blocking advantages

- Fewer I/O operations needed
- Less wasted tape

#### Blocking disadvantages

- Overhead and software routines needed for
	- Blocking
	- Deblocking
	- Record keeping
- Buffer space wasted
	- When only one logical record needed

# Direct access storage devices (DASD)

- Directly read/write to specific disk area
	- Random access storage devices
- Four categories
	- Magnetic disks
	- Optical disks
	- Flash memory
	- Magneto-optical disks
- Access time variance
	- Not as wide as magnetic tape
	- Record location directly affects access time

## Magnetic disc storage

### Fixed head magnetic disc storage

- Looks like a large CD/DVD
	- Covered with magnetic film
	- Formatted
		- Both sides in concentric circles called **tracks**
	- Data recorded serially on each track
		- Fixed read/write head positioned over data

![figure 7.4](http://snag.gy/388pk.jpg)

#### Advantages

- Fast
	- More so than movable head

#### Disadvantages

- High cost and reduced storage

### Movable head magnetic disc storage

- One read/write head floats over disk surface
- Example
	- Computer hard drive
	- Disks
		- Single platter
		- Part of disk pack
			- Stack of platters

#### Disk pack platter

- Two recording surfaces
	- Exception
		- Top and bottom platters
- Surface formatted with concentric tracks
- Track number varies
	- High capacity disk
		- 1000+ tracks
- Track surface number
	- Track zero
		- Outermost concentric circle on each surface
	- Highest numbered track
		- Center
- Arm moves over all heads in unison
	- Fill disk pack surface by surface
		- Slower
	- Fill disk pack track by track
		- Faster
- Virtual cylinder
	- Fill track zero
- Record access system requirements
	- Cylinder number
	- Surface number
	- Record number

![figure 7.5](http://snag.gy/8o8r3.jpg)

### Magnetic disk drive access time

- File access time factors

#### Seek time

- **Slowest**
- Time to position read/write head on track
- Does not apply to fixed read/write head devices

#### Search time

- Rotational delay
- Time to rotate DASD
- Rotate until desired record under read/write head

#### Transfer time

- **Fastest**
- Time to transfer data
- Secondary storage to main memory transfer

## Optical disc storage

### Design difference

#### Magnetic disk

- **Concentric** tracks of sectors
- Spins at **constant angular velocity**
	- CAV
- Wastes storage space but fast data retrieval

![figure 7.7](http://snag.gy/Bn3RG.jpg)

#### Optical disk

- **Single spiraling track** of same-sized sectors
	- Runs from center to disk rim
- Spins at **constant linear velocity**
	- CLV
- More sectors and more disc data

![figure 7.8](http://snag.gy/LeOmO.jpg)

### Performance features

#### Sustained data transfer rate

- Speed to read massive data amounts from disc
- Measured in megabytes per second (Mbps)
- Crucial for applications requiring sequential access

#### Average access time

- Average time to move head to specific disc location
- Expressed in milliseconds (ms)

#### Cache size (hardware)

- Buffer to transfer data blocks from disk

### CD/DVD technology

#### CD

- Data recorded as binary
- **Pits**
	- Indentations
- **Lands**
	- Flat areas
- Reads with low power laser
	- Light strikes land and reflects photodetector
	- Pit is scattered and absorbed
	- Photodetector converts light intensity into digital signal

#### CD recordable (CD-R)

- Requires expensive disk controller
- Records data using write once technique
- Data cannot be erased or modified
- Disk
	- Contains several layers
	- Gold reflective layer and dye layer
	- Records with high power laser
	- Permanent marks on dye layer
	- CD cannot be erased after data is recorded
- Data read on standard CD drive
	- Low power laser

#### CD rewritable (CD-RW)

- Data written, changed, erased
- Uses phase change technology
	- Amorphous and crystalline phase states
- **Write data**
	- Beam heats up disc
	- State changes from crystalline to amorphous
- **Erase data**
	- Low energy beam to heat up pits
	- Loosens allow to return to original crystalline state
- Drives read standard CD-ROM, CD-R, CD-RW discs
- Drives store large quantities of
	- Data
	- Sound
	- Graphics
	- Multimedia

#### Digital versatile disc (DVD)

- Compared to CD-ROM
- Similar in
	- Design
	- Shape
	- Size
- Differs in capacity
	- Dual layer, single sided DVD
		- 13 CDs
	- Single layer, single sided DVD
		- 8.6GB
			- MPEG video comparison
- Differs in laser wavelength
	- Uses red laser
		- Smaller pits
		- Tighter spiral
- DVDs cannot be read by CD/CD-ROM drives
- DVD-R and DVD-RW provide rewritable flexibility

#### Blue-Ray disc

- Same physical size as DVD/CD
- Smaller pits
- More tightly wound tracks
- Use of blue-violet laser allows multiple lasers
- 50GB - 500GB
- 432 Mbps
- Formats
	- BD-ROM
	- BD-R
	- BD-RE

## Flash memory storage

- Electronically erasable programmable read-ony memory
	- EEP
- Non volatile and removable
- Emulates random access
	- Difference
		- Data stored securely
			- Even if removed
- Data stored on microchip card, or **key**
	- Compact flash
	- Smart cards
	- Memory sticks
	- Often connected through USB port
- Write data
	- Electric charge sent through floating gate
- Erase data
	- Strong electrical field (flash) applied

# Fixed vs. movable head devices

## Fixed head devices

- Record access requires two items
	- Track number
	- Record number

>(access time) = (search time) + (transfer time)

- Total access time
	- Rotational speed dependent
- DASDs rotate continuously
	- Three basic positions for requested record
		- In relation to read/write head position
- DASD has little access variance
	- Good candidates
		- Low activity files
		- Random access
- Blocking used to minimize access time

![figure 7.10](http://snag.gy/5vFem.jpg)

## Movable head devices

- Record access requires three items
	- Seek time
	- Search time
	- Transfer time
- Search time and transfer time calculation
	- Same as fixed head DASD
- Blocking is a good way to minimize access time

![table 7.3](http://snag.gy/OuYOq.jpg)

# Components of the I/O subsystem

## I/O channel

- Programmable units
	- Positioned between CPU and control unit
- Synchronizes device speeds
	- CPU
		- Fast
	- I/O device
		- Slow
- Manages concurrent processing
	- CPU and I/O device requests
- Allows overlap
	- CPU and I/O operations
- Channels
	- Expensive because so often shared

## I/O channel programs

- Specifies action performed by devices
- Controls data transmission
	- Between main memory and control units

## I/O control unit

- Receives and interprets signal

## Disk controller

- Disk drive interface
- Links drive and system bus
- Entire path must be available when I/O command initiated
- I/O subsystem configuration
	- Multiple paths increase
		- Flexibility
		- Reliability

![figure 7.12](http://snag.gy/dLc6y.jpg)

![figure 7.13](http://snag.gy/Uc3zj.jpg)

# Communication among devices

## Problems to solve

- Know which components are busy/free
	- Solved by structuring interaction between units
- Accommodate requests during heavy I/O traffic
	- Handled by
		- Buffering records
		- Queuing requests
- Accommodate speed disparity between CPU and I/O devices
	- Handled by
		- Buffering records
		- Queuing requests

## Communication method

- I/O subsystem units finish independently of others
- CPU processes data while I/O is performed
- Success requires device completion knowledge
- Hardware flag tested by CPU

### Channel status word

- Contains flag
- Three bits in flag represent I/O system component
	- Channel
	- Control unit
	- Device
- Changes zero to one
	- Free to busy
- Flag tested using polling and interrupts
	- **Interrupts**
		- More efficient way to test flag

### Direct memory access (DMA)

- Allows control unit main memory access directly
- Transfers data without the intervention of CPU
- Used for high-speed devices
	- Disk

### Buffers

- Temporary storage areas in
	- Main memory
	- Channels
	- Control units
- Improves data movement synchronization
	- Between
		- Slow I/O devices
		- Fast CPU
- Double buffering
	- Processing of record by CPU
	- While another is read or written by channel

![figure 7.14](http://snag.gy/aCi9f.jpg)

## Management of I/O requests

### I/O traffic controller

- Watches status of
	- Devices
	- Control units
	- Channels
- Three main tasks
	- Determine if path available
	- If more than one path available
		- Determine which one to select
	- If all paths busy
		- Determine when one is available
- Maintain database containing unit status and connections

### I/O scheduler

- Same job as process scheduler
	- Chapter 4
- Allocates
	- Devices
	- Control units
	- Channels
- If requests greater than available path
	- Decides which request to satisfy first
		- Based on different criteria
- In many systems
	- I/O requests not preempted
- For some systems
	- Allow preemption with I/O request subdivided
	- Allow preferential treatment for high priority requests

### I/O device handler

- Performs actual data transfer
	- Processes device interrupts
	- Handles error conditions
	- Provides detailed scheduling algorithms
- Device independent
- Each I/O device type has device handler algorithm

![table 7.4](http://snag.gy/ABXCR.jpg)

# Device handler seek strategies

- Predetermined device handler
	- Determines device processing order
- Goal
	- Minimize seek time
- Types
	- FCFS
		- First come first serve
	- SSTF
		- Shortest seek time first
	- SCAN
		- Including
			- LOOK
			- N-Step SCAN
			- C-SCAN
				- Circular SCAN
			- C-LOOK
- Scheduling algorithm goals
	- Minimize arm movement
	- Minimize mean response time
	- Minimize variance in response time

## FCFS

- First come first serve
- On average
	- Does not meet three seek strategy goals
- Disadvantage
	- Extreme arm movement

![figure 7.15](http://snag.gy/MTM1y.jpg)

## SSTF

- Shortest seek time first
- Request with track closest to one being served
- Minimizes overall seek time
- Postpones traveling to out of way tracks

![figure 7.16](http://snag.gy/n0iTr.jpg)

## SCAN

- Directional bit
	- Indicates if arm is moving toward/awaya from disk center
- Algorithm moves arm methodically
	- From outer to inner track
		- Services every request in its path
	- If it reaches inner most track
		- Reverse direction
		- Move towards outer track
		- Service every request in its path

### LOOK

- Arm does not go to either edge
	- Unless requests exist
- Eliminates indefinite postponement

![figure 7.17](http://snag.gy/NlUeC.jpg)

### N-Step SCAN

- Holds all requests until arm starts on way back
	- New requests grouped together for next sweep

### C-SCAN

- Circular SCAN
- Arm picks up requests on path during inward sweep
- Provides more uniform wait time

### C-LOOK

- Inward sweep stops at last high numbered track request
- No last track access unless required

## Strategy comparisons

- **FCFS**
	- Best with light loads
	- Service time unacceptably long under high loads
- **SSTF**
	- Best with moderate loads
	- Localization problem under heavy loads
- **SCAN**
	- Best with light to moderate loads
	- Eliminates indefinite postponement
		- Similarities with **SSTF**
			- Throughput
			- Mean service times
- **C-SCAN**
	- Best with moderate to heavy loads
	- Very small service time variances

## Rotational ordering

- Optimizes search times
	- Orders requests once read/write heads positioned
- Read/write head movement time
	- Hardware dependent
- Reduces time wasted
	- Due to rotational delay
	- Request arrangement
		- First sector requested on second track
			- Is next number higher than one just served

![figure 7.18](http://snag.gy/j7WRM.jpg)

![table 7.5](http://snag.gy/yHBcn.jpg)

![table 7.6](http://snag.gy/hrtRg.jpg)

# RAID

- Physical disk drive set viewed as a single logical unit
	- Preferable over few large-capacity disk drives
- Improved I/O performance
- Improved data recovery
	- Disk failure event
- Introduces redundancy
	- Helps with hardware failure recovery
- Significant factors in RAID level selection
	- Cost
	- Speed
	- System applications
- Increases hardware costs

![figure 7.19](http://snag.gy/1y3SF.jpg)

![table 7.7](http://snag.gy/D1ZBx.jpg)

## RAID 0

- Not considered true RAID
- Uses data striping
	- No parity and error corrections
	- No error
		- Correction
		- Redundancy
		- Recovery
- Benefits
	- Devices appear as one logical unit
	- Best for
		- Large data quantity
		- Non critical data

![figure 7.20](http://snag.gy/2uNAJ.jpg)

## RAID 1

- Considered true RAID
- Uses data striping
- Mirrored configuration
	- Backup
	- Duplicate set of all data
		- Expensive
- Provides
	- Redundancy
	- Improved reliability

![figure 7.21](http://snag.gy/5JOE8.jpg)

## RAID 2

- Considered true RAID
- Uses small stripes
- **Hamming code**
	- Error
		- Detection
		- Correction
- Expensive and complex
	- Size of strip determines number of array disks

![figure 7.22](http://snag.gy/2i3HC.jpg)

## RAID 3

- Modification of RAID 2
- Requires one disk for redundancy
	- One parity bit for each strip

![figure 7.23](http://snag.gy/Fc4sc.jpg)

## RAID 4

- Same strip scheme as RAID 0/RAID 1
- Computes parity for each strip
- Stores parities in corresponding strip
	- Has designated parity disk

![figure 7.24](http://snag.gy/fq7Ho.jpg)

## RAID 5

- Modification of RAID 4
- Distributes parity strips across disks
	- Avoids RAID 4 bottlenecks
- Disadvantage
	- Complicated to regenerate data from failed device

![figure 7.25](http://snag.gy/COmgR.jpg)

## RAID 6

- Provides extra degree of error protection/correction
- Two different parity calculations
	- Double parity
		- Same level as RAID 4/RAID 5
		- Independent algorithm
- Parities stored on separate disk across array
	- Stored in corresponding data strip
- Advantage
	- Data restoration possible even if two disks fail

![figure 7.26](http://snag.gy/CTZEK.jpg)

## Nested RAID

- Combines multiple RAID levels
	- Complex

![figure 7.27](http://snag.gy/mg5O5.jpg)

![table 7.8](http://snag.gy/OLZ5i.jpg)

# Summary

- Device manager
	- Manages every system device effectively as possible
- Devices
	- Vary in speed and share-ability degrees
	- Direct access and sequential access
- Magnetic media
	- One or many read/write heads
	- Heads in fixed position
		- Optimum speed
	- Move across surface
		- Optimum storage space
- Optical media
	- Disc speed adjusted
	- Data recorded/retrieved correctly
- Flash memory
	- Device manager tracks USB devices
	- Assures data sent/received correctly
- I/O subsystem success dependence
	- Communication linking channels
	- Control units
	- Devices
- SCAN
	- Eliminates indefinite postponement problem
	- Best for light to moderate loads
- C-SCAN
	- Very small service time variance
	- Best for moderate to heavy loads
- RAID
	- Redundancy helps hardware failure recovery
	- Consider
		- Cost
		- Speed
		- Application

![table 7.9](http://snag.gy/i3b24.jpg)
