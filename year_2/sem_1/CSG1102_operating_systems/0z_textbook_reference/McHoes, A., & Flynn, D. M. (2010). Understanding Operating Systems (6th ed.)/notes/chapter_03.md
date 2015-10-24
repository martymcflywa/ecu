# Chapter 3: Memory management - Virtual memory

## Objectives

- Basic functionality of memory allocation methods
	- Paged
	- Demand paging
	- Segmented
	- Segmented/demand paged
- The influence that these page allocation methods had on virtual memory
- The difference between page replacement policies
	- First in, first out
	- Least recently used
	- Clock page
- The mechanics of paging
	- How a memory allocation scheme determines which pages should be swapped out of memory
- The concept of the working set
	- How it is used in memory allocation schemes
- The impact that virtual memory had on multiprogramming
- Cache memory and its role in improving system response time

## Introduction

- Chapter 2 looked at simple memory allocation schemes
	- The program had to be stored entirely in main memory contiguously
	- Schemes solved some problems but created others
		- Fragmentation
		- Overhead of relocation
- Chapter 3 looks at the evolution of virtual memory with four memory allocation schemes that
	- Remove restriction of storing programs contiguously
	- Remove requirement that entire program must reside in memory during execution
	- These allocation schemes are
		- Paged
		- Demand paging
		- Segmented
		- Segmented/demand paged
	- Form the foundation for current virtual memory methods
- Cache memory
	- Its use improves the performance of the memory manager

# Paged memory allocation

- Before a job is loaded into memory
	- It is divided into parts called pages
	- Then loaded into memory locations called page frames
- Based on concept of dividing an incoming job into pages of equal size
	- Some OS choose a page size that is
		- The same as the memory block size
		- Also the same size as the sections of the disk/secondary storage
- Sectors
	- Sections of disk
- Page frames
	- Sections of memory
- Scheme works efficiently when are all the same size
	- Pages
	- Sectors
	- Page frames
- Size usually determined by disk's sector size
	- One sector will hold one page of job instructions
	- Will fit into one page frame of memory

## Non contiguous

- When a program is initially prepared for loading
	- Its pages are in logical sequence
		- The first pages contain the first instructions
		- The last page has the last instructions
	- Will refer to program instructions as bytes or words
- The loading process is different from schemes in chapter 2
	- Pages do not have to be loaded in adjacent memory blocks
	- Each page can be stored in any available page frame anywhere in memory
- Advantage of storing programs non contiguously
	- Memory is used more efficiently
	- Empty page frame can be used by any page of any job
	- No need for compaction scheme
		- No external fragmentation
		- No internal fragmentation in most pages

## New problem

- Because a job's pages can be loaded anywhere
	- Memory manager needs to keep track of them
	- Means enlarging size and complexity of OS
		- Increases overhead

![figure 3.1](http://snag.gy/ykLZ3.jpg)

- Figure 3.1 shows how memory manager keeps track of a program that is four pages long
	- Page size is 100 bytes
	- Job 1 is 350 bytes long
		- Being readied for execution
	- Page 3 not fully utilized
		- The job is less than 400 bytes
		- Last page only uses 50 bytes of 100
		- Very few jobs perfectly fill all pages
		- Internal fragmentation still a problem
			- Only in last page of jobs
- In figure 3.1, the OS can accommodate jobs that vary in size from 1 to 700 bytes
	- They can be stored in the seven empty page frames
	- A job larger than the remaining 700 bytes can't be accommodated until
		- Job 1 ends execution
		- Releases the four page frames it occupies
	- A job larger than 1100 bytes, the memory's capacity will never fit
		- Entire job must still be stored in memory during execution
- Memory manager uses tables to keep track of pages
	- Three tables
		- Job table
		- Page map table
		- Memory map table
	- All reside in memory reserved for the OS

### Job table (JT)

- Table 3.1 shows the job table
- Contains two values for each active job
	- Size of job
	- Memory location
		- Where its page map table is stored
- Example
	- First job
		- Size 400
		- Location 3096
- Job table is a dynamic list
	- Grows as jobs are loaded into system
	- Shrinks as jobs are completed

![table 3.1](http://snag.gy/aqDw9.jpg)

### Page map table (PMT)

- Each active job has its own page map table
- Contains vital information for each page
	- Page number
	- Corresponding page frame memory address
- PMT includes only one entry per page
- Page numbers are sequential
	- Page 0
	- Page 1
	- Page 2
	- ...
	- Page N
- Isn't necessary to list each page number in PMT
	- First entry in PMT lists the page frame memory address for page 0
	- Second entry is the address for page 1
	- etc.

### Memory map table (MMT)

- Has one entry for each page frame containing
	- Location
	- Free/busy status

## Dividing program into pages

- At compilation time, every job is divided into pages
- Using job 1 as example
	- Page 0 contains first 100 bytes
	- Page 1 contains second 100 bytes
	- Page 2 contains third hundred bytes
	- Page 3 contains last 50 bytes
- The program has 350 bytes
	- But when stored, referred in zero order
		- Starts from 0 through to 349

## Displacement

- Displacement or offset of a byte
	- How far away a byte is from the beginning of the page
	- Is the factor used to locate that byte within its page frame
	- It is a relative factor
- Figure 3.2 shows the displacement of job 1
	- First bytes of each page
		- Byte 0
			- Page 0
		- Byte 100
			- Page 1
		- Byte 200
			- Page 2
		- Byte 300
			- Page 3
		- Each has a displacement of zero
	- If the OS needs to access byte 214
		- First goes to page 2
		- Then byte 14 of page 2
			- Zero ordered as well
- First byte of each page has a displacement of 0
- Last byte has displacement of 99
- Once the OS finds the right page
	- It can access the correct bytes using its relative position within its page

![figure 3.2](http://snag.gy/P45cP.jpg)

### Displacement equations

- To find the address of a given program instruction
	- The byte number is divided by the page size
		- Keeping the remainder as an integer
	- The quotient is the page number
	- The remainder is the displacement within that page

![page size equation](http://snag.gy/Hzdxb.jpg)

- Example
	- Page size 256 bytes
	- Location 384
- 384 / 256 = 1.5
	- The byte is located in the middle of page 1

![page size equation example](http://snag.gy/x1VjA.jpg)

- To find the exact location with decimals:

>(page size) * (decimal)  
>256 * 0.5 = 128

- Therefore displacement is
	- Page 1
	- Byte 128
- Or in other words
	- Page 1
	- Line 129
- Questions
	1. Could the OS/hardware get a page number that is greater than 3 if the program was searching for byte 214?
		- No, not if the application program was written correctly
	2. If it did, what should the OS do?
		- Send an error message
		- Stop processing the program
			- Out of bounds
	3. Could the OS get a remainder of more than 99?
		- No, not if it divides correctly
	4. What is the smallest remainder possible?
		- Zero

## Memory location

- Displacement is only relative to the page
- To find exact location of the byte in memory
	- Need to correlate each of the job's pages with its page frame number
	- Using page map table
- Table 3.2 shows the PMT for job 1 from figure 3.5

![table 3.2](http://snag.gy/09HLm.jpg)

- To find its exact location in memory
	- The OS or hardware has to perform the following steps:

### Step 1

- Perform page number/displacement calculation
	- (byte number) / (page size)
- Page number
	- Integer quotient
- Displacement
	- Integer remainder

### Step 2

- Refer to job's PMT
	- See table 3.2
- Find out which page frame contains the page
	- Example
		- Page 2 located at page frame 5

### Step 3

- Get the address of the beginning of the page frame
	- (page frame number) * (page frame size)

>5 * 100 =  500

### Step 4

- Add the displacement to the start address of the page frame
	- (displacement) + (page frame address)
- Returns the precise location in memory

>14 + 500 = 514

### Example

- Figure 3.3 shows another example
	- Follows the hardware and OS as it runs an assembly language program
		- Instructs the system to load into register 1 the value found at byte 518

![figure 3.3](http://snag.gy/E3LVd.jpg)

- The page frame sizes in memory are set to 512 bytes
- Each page is 512 bytes
- The PMT shows that this job has been divided into two pages
- To find the exact location of byte 518:
	1. Compute page number and displacement
		- Page number is 1
		- Displacement is 6
	2. Go to PMT and find page frame number for page 1
		- Page frame 3
	3. Compute starting address of the page frame
		- (page frame) * (page frame size)
		- 3 * 512 = 1536
	4. Calculate exact address of the instruction in memory
		- (page frame start address) + (displacement)
		- 1536 + 6 = 1542
		- Therefore
			- Memory address 1542 holds the value that should be loaded into register 1

## Advantages/disadvantages

### Disadvantages

- Lengthy operation
- Every time an instruction is executed
	- OS/hardware must translate
		- Job address
			- Relative
		- To physical address
			- Absolute
		- Called **address resolution** or **address translation**
- All of this processing is overhead
	- Takes processing capability away from jobs waiting to be completed
	- In most systems
		- Hardware does the paging
	- But if using dynamic paging
		- OS is involved
- Internal fragmentation still a problem
	- But only at last page of each job

### Advantages

- Allows jobs to be allocated in non contiguous memory locations
- Memory used more efficiently
- More jobs can fit in memory

### Key to success: Page size

- Page size
- Too small
	- Generates very long PMTs
- Too large
	- Excessive internal fragmentation
- Determining best page size
	- Important policy decision
	- No rules that will guarantee optimal performance
	- Depends on
		- Actual job environment
		- Nature of jobs being processed
		- Constraints placed on system

# Demand paging

- Introduced concept of loading only part of program into memory for processing
- First widely used scheme that removed restriction of having entire job in memory during execution
- Jobs are still divided into equally sized pages
	- Initially reside in secondary storage
- When job is executed
	- Pages are brought into memory
	- Only as they are needed

## Enabling demand paging

- Takes advantage of conventions in programming
- Programs are written sequentially
	- While one section/module is processed
		- All other sections/module are idle
		- Not all pages are accessed at the same time or even sequentially
	- Example
		- User written error handling modules
			- Only processed when specific error is detected during execution
		- If no error occurs
			- Instructions are never processed
			- Never need to load in memory
- Many modules are mutually exclusive
	- If input module is active
		- ie. Worksheet being loaded
	- Processing module is inactive
		- ie. Printing
- Certain program options are either mutually exclusive or not always accessible
	- Easiest to visualize in menu driven programs
	- Example
		- Application may give the user several menu choices
			- See figure 3.4
		- The user can only make one selection at a time
		- If the user selects the first option
			- Then the module with the program instructions to move records to the file is the only one that is being used
				- That is the only module that needs to be in memory
				- All other modules remain in secondary storage until they are called from the main menu
- Many tables are assigned a large fixed amount of address space even though only a fraction of the table is being used
	- Example
		- A symbol table for an assembler might be prepared to handle 100 symbols
		- If only 10 symbols are used
			- 90% of table remains unused

![figure 3.4](http://snag.gy/qrXzC.jpg)

## Secondary storage

- Important innovation of demand paging
	- Made virtual memory feasible
- Demand paging scheme allows user to run jobs with less memory than required if OS uses paged memory allocation
- Can give the appearance of almost-infinite amount of physical memory
	- In reality, physical memory is limited space
- Key to successful implementation
	- Use of high speed direct access storage device
		- Hard drives
		- Flash memory
	- Works directly with CPU
		- Vital
			- Pages must be passed quickly from secondary storage to memory and back again

## Page swapping

### Table changes

- How and when pages are passed/swapped depends on predefined policies that determine when to make room for needed pages and how to do so
	- The OS relies on tables to implement the algorithm
		- Job table
		- Page map table
		- Memory map table
- Tables are the same as paged memory allocation
	- Adds three new fields in the PMT
		- See figure 3.5
		- Page status field
			- Determines if page being requested is already in memory
		- Page modified field
			- Determines if page contents have been modified
		- Page referenced field
			- Determines if page has been referenced recently

![figure 3.5](http://snag.gy/stO7K.jpg)

#### Page frame number field

- Tells the system where to find the page
- If already in memory
	- System won't have to retrieve page from secondary storage
	- Faster process

#### Page status field

- Notes if page has been modified
- Saves time when pages are removed from memory and return to secondary storage
- If contents of page have not been modified
	- Page does not need to be rewritten to secondary storage
	- The original is already in secondary storage

#### Page referenced field

- Indicates recent activity with the page
- Used to determine
	- Which pages have the most processing activity
	- Which pages are relatively inactive
- This information is used by several page swapping policies
	- To determine
		- Which pages remain in memory
		- Which pages are swapped out when system needs more room in memory

### Page swap example

- Example in figure 3.5
- The number of total job pages is 15
- Number of total available page frames is 12
	- The OS occupies the first 4 of 16 page frames
- Assuming the processing status shown in figure 3.5
	- What happens when job 4 requests that page 3 be brought into memory if there are no empty page frames available?
	- To move in a new page
		- A resident page must be swapped back into secondary storage
		- It includes
			- Copying the resident page back to disk
				- If dirty
			- Writing the new page into the empty page frame
- Hardware components
	- Generate the address of the required page
	- Find the page number
	- Determine whether it is already in memory
- The following algorithm makes up the hardware instruction processing cycle

### Hardware instruction processing algorithm

1. Start processing instruction
2. Generate data address
3. Compute page number
4. If page is in memory
	- Then
		- Get data and finish instruction
		- Advance to next instruction
		- Return to step 1
	- Else
		- Generate page interrupt
		- Call page fault handler
	- End if

### Page fault handler

- The same process is followed when fetching an instruction
- When the test fails, the OS takes over
	- Meaning that the page is in secondary storage but not in memory
- The section of the OS that resolves these problems
- It determines whether there are empty page frames in memory
	- So that the requested page can be immediately copied from secondary storage
- If all page frames are busy
	- The page fault handler must decide which page will be swapped out
		- The decision is directly dependent on the predefined policy for page removal
	- Then the swap is made

#### Page fault handler algorithm

1. If there is no free page frame
	- Then
		- Select page to be swapped out using page removal algorithm
		- Update job's page map table
		- If content of page has been changed
			- Write page to disk
		- End if
	- End if
2. Use page number from step 3 from hardware instruction processing algorithm to get disk address where page is stored
3. Read page into memory
4. Update job's page map table
5. Update memory map table
6. Restart interrupted instruction

### Updating tables

- Before continuing, three tables must be updated
	- Page map table
		- For both jobs
			- Incoming and outgoing
	- Memory map table
	- Instruction that was interrupted then resumes and processing continues

### Thrashing

- When there is excessive amount of page swapping
	- The operation becomes inefficient
	- Called thrashing
- Uses a lot of computer's energy
	- Achieves very little
- Cause
	- When page is removed from memory
	- Called back shortly after
- Can occur
	- Across jobs
		- When large number of jobs are vying for relatively low number of free pages
			- Ratio of job pages to free memory pages is high
	- Within a job
		- In loops that cross page boundaries

#### Thrashing example

- Suppose the beginning of a loop falls at the bottom of a page
	- Completed at the top of the next page
	- See figure 3.6

![figure 3.6](http://snag.gy/qng9Z.jpg)

- Figure 3.6 assumes there is only one empty page frame available
- The first page is loaded into memory and execution begins
	- After executing the last command on page 0
		- The page is swapped out to make room for page 1
- Execution continues with the first command on page 1
	- At the `}` symbol, page 1 must be swapped out so page 0 can be brought back to continue the loop
- Before the program is completed
	- Swapping will have occurred 100 times
		- Unless another page frame becomes free
			- So both pages can reside in memory at the same time
- **Page fault**
	- A failure to find a page in memory
- In such extreme cases
	- The rate of useful computation could be degraded by a factor of 100
- Ideally
	- A demand paging scheme is most efficient when programmers are aware of the page size used by their OS
	- Are careful to design programs to keep page faults to a minimum
- In reality
	- This is not often feasible

# Page replacement policies and concepts

- Selects the page to be removed
- Crucial to efficiency
	- Algorithm must be carefully selected
- Most well known algorithms
	- First in first out (FIFO)
		- Remove page that has been in memory the longest
	- Least recently used (LRU)
		- Remove page that is the least recently accessed

## First in first out (FIFO)

- Removes pages that have been in memory the longest
	- See figure 3.7

![figure 3.7](http://snag.gy/6QB5p.jpg)

### FIFO example

- Figure 3.8 shows how the FIFO algorithm works
- By following a job with four pages
	- A, B, C, D
	- As it is processed by a system with only two available page frames
- It displays how
	- Each page is swapped in and out of memory
		- Marks each interrupts with an asterisk
	- We then count the number of page interrupts and compute the
		- Failure rate
		- Success rate
- The job to be processed needs its pages in the following order
	- A, B, A, C, A, B, D, B, A, C, D

![figure 3.8](http://snag.gy/QnD0s.jpg)

- When both page frames are occupied
	- Each new page brought into memory will cause an existing one to be swapped out to secondary storage
- A page interrupt is generated when a new page needs to be loaded into memory
	- Whether a page is swapped out or not
- The efficiency of this configuration is dismal
	- 9 page interrupts out of 11 page requests
		- Due to
			- Limited number of page frames available
			- Need for many new pages
- To calculate failure rate
	- (number of interrupts) / (number of page requests)
	- Failure rate of example is 9 / 11 = 82%
	- Success rate is 2 / 11 = 18%
	- Failure rates this high is usually unacceptable

### FIFO anomaly

- Buying more memory will not guarantee better failure rate
- Known as FIFO anomaly
- Under certain circumstances
	- Increase in memory
		- Causes increase in page interrupts
- Makes FIFO undesirable as replacement policy

## Least recently used (LRU)

- Swaps pages out that show the least amount of recent activity
	- These pages are likely to be used again in immediate future
- If a page is used
	- It is likely to be used again
	- Based on theory of locality
- To implement policy
	- Queue of requests is kept in FIFO order
	- And either
		- Timestamped when job entered system
		- Mark in job's PMT made periodically

### LRU example

- Figure 3.9 shows how LRU algorithm works
	- Similar to FIFO example

![figure 3.9](http://snag.gy/OAX3X.jpg)

- Efficiency is only slightly better than FIFO
	- 8 page interrupts out of 11 page requests
	- Failure rate 8 / 11 = 73%
- Increase in memory by one page frame would increase success rate
	- For both FIFO and LRU
- LRU is a stack algorithm removal policy
	- Increase in memory will never cause an increase in number of page interrupts

## Clock page replacement

- Variation of LRU
- Implemented with a circular queue
- Uses a pointer to step through the reference bits of active pages
	- Simulating a clockwise motion
- Algorithm is paced according to the computer's clock cycle
	- The timespan between two ticks in the system clock
- Algorithm checks the reference bit for each page
	- If the bit is one
		- Was recently referenced
		- The bit is reset to zero
		- Moves on to the next bit
	- If the bit is zero
		- Page was not recently referenced
		- The page is targeted for removal
	- If all reference bits are set to 1
		- Pointer must cycle through entire circular queue again
			- Giving each page a second, third, fourth chance
- Figure 3.10 shows how a circular queue containing the reference bits for eight pages currently in memory

![figure 3.10](http://snag.gy/615cy.jpg)

- The pointer indicates the page that would be considered next for removal
- Figure 3.10 shows what happens to the reference bits of the pages that have been given a second chance
- When a new page, 146 has to be allocated to a page frame
	- It is assigned to the space that has a reference bit of zero
		- The space previously occupied by page 210

## LRU bit shifting

- A second variation of LRU
- Uses 8-bit reference byte and bit shifting technique to track the usage of each page currently in memory
- When the page is first copied into memory
	- The left most bit of its reference byte is set to 1
	- All bits to the right are set to 0
		- See figure 3.11
- At specific time intervals of the clock cycle
	- The main memory manager shifts every page's reference bytes to the right by one bit
		- Dropping their rightmost bit
- Each time a page is referenced
	- The leftmost bit is set to 1

![figure 3.11](http://snag.gy/kqinh.jpg)

- The process gives a history of each page's usage
- Example
	- A page that has not been used for the last eight ticks would have a reference byte of `00000000`
	- A page that has been referenced every tick will have a reference byte of `11111111`
- When a page fault occurs
	- The LRU policy selects the page with the smallest reference byte value
		- The one least recently used
- Figure 3.11 shows how the reference bytes for six active pages change during four snapshots of usage
- In (a)
	- The six pages have been initialized
	- All of them have been referenced
- In (b)
	- Pages 1, 3, 5 and 6 have been referenced again
		- Marked with 1
	- Pages 2 and 4 have not
		- Marked with 0
- In (c)
	- Pages 1, 2 and 4 have been referenced
- In (d)
	- Pages 1, 2, 4 and 6 have been referenced
- In (e)
	- Pages 1 and 4 have been referenced
- The values stored in the reference bytes are not unique
	- Page 3 and page 5 have the same value
	- In these cases, the LRU may either
		- Swap out all of the pages with smallest value
		- Select one among them based on other criteria
			- FIFO
			- Priority
			- Whether contents of the page have been modified

# Mechanics of paging

- Before the memory manager can determine which pages will be swapped out
	- It needs specific information about each page in memory
	- Information included in the page map tables
		- See table 3.3

## Bit definitions

![table 3.3](http://snag.gy/BFzYS.jpg)

- Status bit
	- Indicates whether the page is currently in memory
- Referenced bit
	- Indicates whether the page has been recently referenced
	- Most important
		- It is used by the LRU algorithm to determine which page should be swapped out
- Modified bit
	- Indicates whether contents of the page have been altered
		- If so
			- Page must be rewritten to secondary storage when swapped out before its page frame is released
		- If not
			- Can be overwritten directly
			- Saves a step
			- Already exists in secondary storage
- Each bit can either be 0 or 1
	- See table 3.4

![table 3.4](http://snag.gy/Ukw6g.jpg)

## Bit combinations

- Status bit for all pages in memory is 1
	- A page must be in memory before it can be swapped out
		- So all candidates for swapping have a 1 in this column
- The other two bits can either be 0 or 1
	- There are four possible combinations of the referenced and modified bits
		- See table 3.5

![table 3.5](http://snag.gy/b2wUH.jpg)

- FIFO algorithm
	- Only uses the modified and status bits when swapping pages
- LRU algorithm
	- Uses all three to decide which pages to swap
- Which page would the LRU choose to swap first?
	- Case 1 would be ideal candidates
		- Neither been modified or referenced
	- Case 3 next ideal candidate
		- Case 2 and 4 recently referenced
		- But has been modified
			- Will take more time to swap them out
	- Case 2 is third choice
	- Case 4
		- Least likely to be removed

### Case 3

- Page has been modified but not referenced
	- How is this possible
- Depends on how referenced bit is manipulated by the OS
	- When pages are brought into memory
		- They are all usually referenced at least once
- LRU algorithm would be defeated if every page has been referenced
- To make sure referenced bit indicates recently referenced
	- OS periodically resets it to 0
- As pages are referenced
	- The bit is changed from 0 to 1
- There is one brief instant where all pages have reference bits 0
	- Even active pages
- As processing continues
	- The most referenced pages soon have their bits reset to 1
		- Risk is minimized

# The working set

- Set of pages residing in memory that can be accessed directly without incurring a page fault
- When a user requests execution of a program
	- First page is loaded into memory
	- Execution continues as more pages are loaded
		- Containing
			- Variable declarations
			- Instructions
			- Data
	- After awhile
		- Most programs reach a fairly stable state
		- Processing continues smoothly with very few additional page faults
	- At this point
		- The job's working set is in memory
		- The program won't generate many page faults
			- Unit it gets to another phase
				- Requiring a different set of pages to do the work
					- A different working set
- A poorly structured program
	- Could require that every one of its pages be in memory before processing can begin

## Locality of reference

- Most programs are structured
	- Locality of reference
		- During program's execution
	- During any phase of execution
		- The program only references a small fraction of its pages

### Locality of reference example

- If a job is executing a loop
- Then the instructions within the loop are referenced extensively
	- While instructions outside the loop are not used at all
		- Until loop is completed
- This is locality of reference
- Same applies to
	- Sequential instructions
	- Subroutine calls
	- Stack implementations
	- Access to variables acting as counters/sums
	- Multidimensional variables
		- Arrays
		- Tables

## Finding the working set

- Difficult to identify job's working set to load into memory straight away
- System needs definitive answers to some questions
	- How many pages comprise the working set?
	- What is the max number of pages the OS will allow for a working set?
		- Important in networked/timesharing systems
			- Regularly swaps jobs / pages of jobs between memory and secondary storage
				- To accommodate needs of many users
- Problem
	- Every time a job has its pages swapped
		- It has to generate several page faults until working set is back in memory and processing can continue
	- Time consuming for CPU
		- Can't be processing jobs during processing page faults
			- See figure 3.12

![figure 3.12](http://snag.gy/98C2l.jpg)

- One solution
	- Begin identifying each job's working set
	- Load it into memory in its entirety before allowing execution to begin
	- Difficult to do before a job is executed
	- Can be identified as execution proceeds
- Timesharing/networked system
	- This means the OS must keep track of
		- Size and identity of every working set
		- Making sure that the jobs destined for processing at any one time won't exceed the available memory
	- Some OS use a variable working set size
		- Increase/decrease when necessary
			- May mean that number of jobs in memory will need to be reduced
				- If the system can ensure the completion of each job and subsequent release of memory space

## Demand paging advantages/disadvantages

- Two advantages
	- First scheme which a job was no longer constrained by size of physical memory
		- Introduced concept of virtual memory
	- Utilized memory more efficiently than previous schemes
		- Sections of a job that were seldom/not used are not loaded into memory
			- Unless specifically requested
- Disadvantage
	- Increased overhead
		- Caused by tables and page interrupts

# Segmented memory allocation

- Built on advantages of paging and dynamic partitions
- Based on programming practice of structuring code as modules
	- Logical grouping of code
- Each job is divided into several segments of different sizes
	- One for each module that contains pieces that perform related functions
- Was designed to reduce page faults
	- Resulted from having a segment's loop split over two or more pages
- A subroutine is an example of one such logical group
- Fundamentally different from paging scheme
	- Divides job into several pages of all the same size
	- Often contains pieces from more than one program module
- Memory no longer divided into page frames
	- Size of each segment is different
		- Some large some small
- As with dynamic partitions
	- Memory is allocated in a dynamic manner

## Segmentation

- When a program is compiled/assembled
	- Segments are set up according to the program's structural modules
- Each segment is numbered
- A segment map table (SMT) is generated for each job
	- Contains
		- Segment numbers
		- Lengths
		- Access rights
		- Status
		- Location in memory
			- When loaded
- Figure 3.13 and 3.14
	- Shows job 1
		- Composed of
			- Main program
			- Two subroutines
	- Together with
		- Segment map table
		- Actual memory allocation

![figure 3.13](http://snag.gy/LZYtf.jpg)

![figure 3.14](http://snag.gy/AzN1h.jpg)

- Referenced, modified, status bits also used
	- Not shown in figures
- Memory manager needs to keep track of the segments in memory
	- Done with three tables combining aspects of dynamic partitions and demand paging
		- Job table
			- Lists every job being processed
				- One for whole system
		- Segment table map
			- Lists details about each segment
				- One for each job
		- Memory map table
			- Monitors allocation of memory
				- One for whole system
- Like demand paging
	- Instructions within each segment are ordered sequentially
		- But segments do not need to be stored contiguously in memory
	- Only need to know where each segment is stored
	- Contents of the segments themselves are contiguous in this scheme
- To access a specific location within a segment
	- Can perform similar operation to one used in paged memory management
	- Only difference
		- Working with segments instead of pages
	- Addressing scheme requires
		- Segment number
		- Displacement number within segment
	- Segments are different sizes
		- Displacement must be verified
			- Ensuring not out of bounds
- In figure 3.15
	- Segment 1 contains all of subroutine A
		- So the system finds the beginning address of segment 1
			- Address 7000
	- If the instruction requested that processing begin at byte 100 of subroutine A
		- To locate that item in memory
			- Memory manager would need to add 100 to 7000
				- `ACTUAL_MEM_LOC = BEGIN_MEM_LOC + DISPLACEMENT`

![figure 3.15](http://snag.gy/el7Rq.jpg)

- Displacement cannot be larger than segment size
	- Accidents do happen and memory manager must always guard against this by
	- Checking the displacement against the size of the segment
		- Verify it is not out of bounds
- To access a location in memory
	- The address is composed of two values
		- Page/segment number
		- Displacement
	- It is a two dimensional addressing scheme
- Disadvantage of dynamically partitioned allocation schemes
	- External fragmentation
	- Compaction of available memory is necessary
- There are similarities between paging/segmentation
	- Often confused
- Major difference
	- Pages are physical units
		- Invisible to user's program
		- Consist of fixed sizes
	- Segments are logical units
		- Visible to user's program
		- Consist of variable sizes

# Segmentation/demand paged memory allocation

- Evolved/combination of segmentation and demand paging
- Offers
	- Logical benefits of segmentation
	- Physical benefits of paging
- Algorithms used by demand and segmented memory schemes are applied with minor modifications
	- Doesn't keep each segment as a contiguous unit
		- Subdivides it into pages of equal size
		- Smaller than most segments
		- Easily manipulated compared to whole segments
	- Many problems of segmentation are removed
		- Compaction
		- External fragmentation
		- Secondary storage handling
- Requires four tables, shown in figure 3.16
	- Job table
		- Lists every job in process
			- One for whole system
	- Segment map table
		- Lists details about each segment
			- One for each job
	- Page map table
		- Lists details about every page
			- One for each segment
	- Memory map table
		- Monitors allocation of page frames in memory
			- One for whole system

![figure 3.16](http://snag.gy/onAyK.jpg)

- Segment map table actual includes additional information regarding protection (not shown in figure 3.16)
	- Authority to manage parts of the file
		- Read
		- Write
		- Execute
		- Delete
	- Which users have access to that segment
		- User
		- Group
- Page map table includes
	- Status
	- Modified bit
	- Referenced bit

## Accessing location in memory

- System must locate address
	- Composed of three entries
		- Segment number
		- Page number within segment
		- Displacement within page
	- Three dimensional address scheme

## Disadvantage

- Overhead required for extra tables
- Time required to reference
	- Segment table
	- Page
- To minimize number of references
	- Many systems use associative memory to speed up process

## Associative memory

- Name of several registers that are allocated to each job that is active
- Task is to associate several segment and page numbers belonging to the job being processed with their memory address
- Resides in memory
- Exact number of registers varies between systems

### Associative memory role

- When a job is allocated to the CPU
	- Its segment map table is loaded into memory
	- The page map tables are loaded only as needed
	- As pages are swapped
		- All tables are updated
- When a page is first requested
	- The job's SMT is searched to locate its PMT
	- PMT is loaded and searched to determine the page's location in memory
	- If the page isn't in memory
		- A page interrupt is issued
		- Page is brought into memory
		- PMT is updated
			- Loading PMT can also cause page interrupt
	- Since the segment's PMT now resides in memory
		- Any other requests for pages within this segment can be quickly accommodated
			- No need to bring PMT into memory
	- Accessing SMT and PMT is time consuming
- This problem is addressed by associative memory
	- Stores information related to most recently used pages
	- Then when a page request is issued
		- Two searches begin
			- Through the SMT and PMT
			- Through the contents of the associative registers
	- If search of associative registers is successful
		- Search through the two other tables is stopped
		- Address translation is performed using info from associative registers
	- If search of associative memory fails
		- No time is lost because search through SMT and PMT has already begun
	- When this search is successful and memory address from PMT has been determined
		- The address is used to continue execution of the program
		- Reference is stored in one of the associative registers
	- If associative registers are full
		- LRU or other algorithm is used to make space for new associative entry
- If a job is swapped out to secondary storage during execution
	- All of the information stored in its associative registers is saved
		- Along with current
			- PMT
			- SMT
	- So that displaced jobs can be resumed quickly when CPU is reallocated to it
- Advantage
	- Increased speed
- Disadvantage
	- High cost of complex hardware to perform parallel searches
	- Some systems do not perform parallel searches
		- Search of SMT and PMT occurs after associative register search

# Virtual memory

## Introduction

- Enabled by demand paging
	- Program executes even though only part of program resides in memory
	- Removed restriction imposed on max program size
- Gives appearance that whole program is loaded into memory
	- But only a portion of it is
- Before virtual memory
	- Making programs fit into available memory was up to users
	- Programmers had to limit size of programs to make sure they fit in memory
		- May not be possible because amount of memory allocated to them was too small to get job done
		- Some wrote tight programs
	- Size or program counted the most
		- Instructions were impossible to understand by other developers
		- Useful life of program was limited to employment of programmer
- Programmers initially used overlays
	- Overlay
		- Segmented programs
			- One overlay loaded first
			- Second overlay loaded after first finished execution
	- Tedious programming
	- Gave way to demand paging/segmentation schemes
		- See table 3.6 for comparison

![table 3.6](http://snag.gy/hmhef.jpg)

## Segmentation

- Segmentation allowed for sharing program code among users
	- Shared segment contains
		- Reentrant
			- Area where unchangeable code is stored
		- Data areas
			- One fore each user
	- Users share code which cannot be modified
	- Modify information stored in own data areas
		- Without affecting data stored in other user data areas

## Copies of files

- Before virtual memory
	- Copies of files were stored in each user's account
		- Allowed to load own copy and work on it any time
		- Created unnecessary system cost
			- IO overhead loading copies
			- Secondary storage to store copies
- With virtual memory
	- Costs reduced
		- Shared programs/subroutines are loaded on demand
		- Reduced storage requirements
		- At expense of memory map table

## Required system cooperation

- Requires cooperation between
	- Memory manager
		- Tracks each page/segment
	- Processor hardware
		- Issues interrupts
		- Resolves virtual address
- Example
	- When a page is needed that is not already in memory
		- A page fault is issued
		- Memory manager chooses a page frame
			- Loads page
		- Updates entries in
			- Memory map table
			- Page map tables

## Virtual memory and multiprogramming

- Works well in multiprogramming environment
	- Most programs spend a lot of time waiting for
		- IO to be performed
		- Pages to be swapped in/out
		- Wait when time slice is up
			- In time sharing environment
- In multiprogramming environment
	- Waiting time isn't lost
	- CPU moves to another job

## Increased use of programming techniques

- Aids development of large software systems
	- Individual pieces can be developed independently
	- Linked later on

## Advantages

- Job size no longer restricted to size of memory
	- Or free space within memory
- Memory is used more efficiently
	- Only sections of a job that is needed immediately is stored
	- Other sections not needed remain in secondary storage
- Allows unlimited amount of multiprogramming
	- Can apply to many jobs
		- As in dynamic/static partitioning
	- Or many users in a time sharing environment
- Eliminates external fragmentation and minimizes internal fragmentation
	- Combines segments and pages
		- Internal fragmentation occurs in the program
- Allows sharing of code and data
- Facilitates dynamic linking of program segments

## Disadvantages

- Outweighed by advantages
- Increased processor hardware costs
- Increased overhead for handling paging interrupts
- Increased software complexity to prevent thrashing

# Cache memory

## Introduction

- Based on idea that the system can use a small amount of expensive high speed memory to make a large amount of slower less expensive memory work faster than main memory
- Cache is small in size
	- Compared to main memory
	- Can use faster, more expensive memory chips
	- Can be 5 to 10 times faster than main memory
	- Can match speed of CPU
- When frequently used data/instructions are stored in cache memory
	- Memory access times can be reduced significantly
	- CPU can execute instructions faster
	- Raising overall performance of computer system

## Architecture

![figure 3.17](http://snag.gy/IgRq4.jpg)

- Figure 3.17(a) shows original architecture of a computer
	- Data/instructions were transferred from
		- Secondary storage to main memory
		- Then to special purpose registers for processing
	- Processing time increased
- Because same instructions are used repeatedly
	- Computer system designers thought it would be more efficient if the system would not use a complete memory cycle every time an instruction or data value is required
- Designers found this could be done if they placed repeatedly used data in general purpose registers instead of in main memory
	- They found this technique required extra work for programmer
- General purpose registers was not optimal solution
	- Those registers are often needed to store temporary results from other calculations
	- Amount of instructions used repeatedly often exceeds capacity of general purpose registers
- To solve problem
	- Computer systems automatically store data in an intermediate memory unit called cache memory
	- Adds middle layer to original hierarchy
	- Cache memory can be thought of as an intermediary between main memory and special purpose registers
		- Domain of CPU
			- See figure 3.17(b)

## Cache levels

- Typical CPU has two levels of cache
	- Level 1 (L1)
	- Level 2 (L2)
- Information enters CPU through bus interface unit
	- Immediately sends copy to L2 cache
		- Directly connected to CPU
	- Second copy sent to pair of L1 caches
		- Built directly into CPU
		- Each L1 cache responsible for different information
			- One stores instructions
			- The other stores data
- If an instruction needs more data
	- It is put on hold
	- Before searching main memory
		- CPU looks for it in L1 data cache
			- Then in larger L2 cache
- Because L2 cache is an integral part of microprocessor
	- Data moves two to four times faster between CPU and L2
		- Compared to between CPU and main memory
- Cache memory is like web browser history
	- Most recently accessed data is stored
	- Can be accessed repeatedly without wasting time

## Movement of data between main and cache memory

- Similar to paging algorithms
- Cache memory is divided into blocks of equal size
	- Called slots
- When CPU first requests an instruction or data from a location in main memory
	- The requested instruction and several others around it are transferred from main memory to cache memory
		- Stored in one of the free slots
- Moving a block at a time is based on principle of locality/reference
	- It is very likely that the next CPU request will be physically close to the one just requested
- In addition to the block of data transferred
	- The slot also contains a label that indicates the main memory address from which the block was copied
	- When the CPU requests additional information from that location in main memory
		- Cache memory is accessed first
		- If the contents of one of the labels in a slot matches the address requested
			- Then access to main memory is not required

## Main memory transfer algorithm

1. CPU puts the address of a memory location in the Memory Address Register and requests data or instruction to be retrieved from that address
2. A test is performed to determine if the block containing this address is already in a cache slot
	- If yes
		- Transfer the information to the CPU register
			- DONE
	- If no
		- Access main memory for the block containing the requested address
		- Allocate a free cache slot to the block
		- Perform these in parallel
			- Transfer the information to CPU
			- Load the block into slot
		- Done

## When there are no free slots

- Algorithm becomes more complicated
	- Can occur because size of cache memory is smaller than that of main memory
		- Means that individual slots cannot be permanently allocated to blocks
- To address this
	- System needs a policy for block replacement
		- Could be one similar to page replacement

## Designing cache memory

- Must consider four factors
	- Cache size
		- Studies show having any cache, even small can substantially improve performance of computer system
	- Block size
		- Due to principle of locality of reference
			- As block size increases
				- Ratio of number of references found in the cache to the total number of references will be high
	- Block replacement algorithm
		- When all slots are busy and a new block has to be brought into cache
			- A block that is least likely to be used in the near future should be selected for replacement
			- However as seen in paging
				- This is nearly impossible to predict
			- Reasonable course of action
				- Select a block that has not been used for a long time
					- LRU is often chosen for block replacement
						- Requires hardware mechanism to specify least recently used slot
	- Rewrite policy
		- When contents of block residing in cache is changed
			- It must be written back to main memory before replaced by another block
		- Rewrite policy must be in place to determine when this writing will take place
		- Could be done every time a change occurs
			- Increase number of memory writes
			- Increase overhead
		- Could be done only when the block is replaced or processing finished
			- Minimize overhead
			- Leave the block in main memory inconsistent
			- Would create problems in
				- Multiprocessor environments
				- Cases where IO modules can access main memory directly
- Optimal selection of cache size and replacement algorithm can result in 80 to 90% of all requests being in the cache
	- Making for very efficient memory system

## Measuring efficiency

- Called cache hit ratio (h)
- Used to determine the performance of cache memory
- Represents percentage of total memory requests that are found in cache

![hit ratio equation](http://snag.gy/noR2f.jpg)

- Example
	- If total number of requests in 10
	- 6 requests found in cache memory
	- Hit ratio is 60%

>HitRatio = (6 / 10) * 100 = 60%

- Another way to measure efficiency of a system with cache memory
	- Assuming that system always checks the cache first
	- Compute the average memory access time using the following formula

![average memory access time equation](http://snag.gy/kY8pt.jpg)

- Example
	- Average cache access time is 200 ns
	- Average main memory access time is 1000 ns
	- Then a system with a hit ratio of 60% will have an average memory access time of 600 ns

![average memory access time example](http://snag.gy/renlx.jpg)

# Comparison of memory allocation schemes

![table 3.7](http://snag.gy/lQIvu.jpg)
