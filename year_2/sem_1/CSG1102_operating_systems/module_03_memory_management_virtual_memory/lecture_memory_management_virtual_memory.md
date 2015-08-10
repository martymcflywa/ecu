# Memory management: Virtual memory

## Objectives

- Basic functionality of memory allocation methods covered in this module
	- Paged
	- Demand paging
	- Segmented
	- Segmented / demand paged
- The influence that these page allocation methods have had on virtual memory
- Difference in page replacement policies
	- First in first out
	- Least recently used
	- Clock page
- Mechanics of paging and how memory allocation schemes determine which pages should be swapped out of memory
- Concept of the working set and how it is used in memory allocation schemes
- Impact that virtual memory had on multiprogramming
- Cache memory and its role in improving system response time

## Introduction

- Evolution of virtual memory
	- Foundation for current virtual memory methods
		- Paged
		- Demand paging
		- Segmented
		- Segmented / demand paging
- Improvement areas
	- Need for continuous program storage
	- Need for placement of entire program in memory during execution
	- Fragmentation
	- Overhead due to relocation
- Page replacement policies
	- First in first out
	- Least recently used
		- Clock replacement and bit shifting
	- Mechanics of paging
	- The working set
- Virtual memory
	- Concepts and advantages
- Cache memory
	- Concepts and advantages

## Virtual memory model

- Essential for multiprogramming and multitasking environments
- Essential for platforms allowing portable executables
- Modern (multitasking) operating systems all use a virtual memory manager (VMM)
- After a program is compiled, memory addresses are absolute
- To avoid conflicts, every program would need to use different memory addresses
- This is obviously not feasible

### Virtual memory approach

- The VMM approach has each program compiled to use **virtual addresses**
- Each process sees that it has half of the memory space available to it
	- 2GB in 32bit
	- 32EB in 64bit
- The other half is reserved for the OS (kernel) use
- The above is true regardless of the amount of actual memory available or the presence of other processes
- Each process allocates/deallocates memory as it needs to within the virtual address space
- The VMM translates these to physical addresses in memory and manages the allocation/deallocation to keep track of the actual memory available

## Paged allocation techniques

### Paged memory allocation

- Divides each incoming job into pages of equal size
- **Best condition**
	- Page size = memory block size (page frames) = size of disk section (sector, block)
- Memory manager tasks prior to program execution
	- Determines number of pages in program
	- Locates enough empty page frames in main memory
	- Loads all program pages into page frames
- Advantage of storing program **non-contiguously**
	- New problem
		- Keeping track of job's pages

![paged memory allocation](http://snag.gy/lkR3f.jpg)

#### Paged memory allocation tables

- Three tables for tracking pages
	- **Job table (JT)**
		- Size of job
		- Memory location where its PMT is stored
	- **Page map table (PMT)**
		- Page number
		- Corresponding page frame memory address
	- **Memory map table (MMT)**
		- Location for each page frame
		- Free / busy status

![paged memory allocation tables](http://snag.gy/PZAbS.jpg)

#### Paged memory displacement

- **Displacement** (offset) of a line
	- Determines line distance from beginning of its page
	- Locates line within its page frame
	- Relative value
- Determining page number and displacement of a line
	- Divide job space address by page size
	- **Page number**
		- Integer quotient from the division
	- **Displacement**
		- Remainder from the division

![paged memory displacement](http://snag.gy/8BdAk.jpg)

#### Paged memory location and address resolution

- Steps to determining exact location of a line in memory
	- Determine page number and displacement of a line
	- Refer to the job's **page map table (PMT)**
		- Determine page frame containing required page
	- Obtain address of the beginning of the page frame
		- Multiply page frame number by page frame size
	- Add the displacement (calculated previously) to starting address of the page frame
- Address resolution
	- Translating job space address into physical address
	- Relative address into absolute address

![paged memory address resolution](http://snag.gy/tU3FX.jpg)

#### Paged memory advantages / disadvantages

- Advantages
	- Allows job allocation in non-contiguous memory
		- Efficient use of memory
- Disadvantages
	- Increased overhead from address resolution
	- Internal fragmentation in last page
	- Must store entire job in memory location
- Page size selection is crucial
	- Too small
		- Generates very long PMTs
	- Too large
		- Excessive internal fragmentation

### Demand paging

- Pages brought into memory only as needed
	- Removes restriction
		- Entire program in memory
	- Requires high speed page access
- Exploits programming techniques
	- Modules written sequentially
		- All pages not needed simultaneously
	- Examples
		- User-written error handling modules
		- Mutually exclusive modules
		- Certain program options
			- Mutually exclusive or not accessible
		- Tables given fixed amount of space
			- Fraction used
- Allowed for wide availability of **virtual memory** concept
	- Provides appearance of almost infinite physical memory
	- Jobs run with less main memory than required in paged memory allocation scheme
	- Requires high-speed direct access storage device
		- Works directly with CPU
	- **Swapping:**
		- How and when pages passed in memory
			- Depends on predefined policies

#### Demand paging allocation tables

- Memory manager requires three tables
	- **Job table**
	- **Page map table**
		- Adds three new fields
			- If requested page is already in memory
			- If page contents have been modified
			- If page has been referenced recently
				- Determines which page remains in memory
					- And which is swapped out
	- **Memory map table**

![demand paging page map table](http://snag.gy/sQ8tE.jpg)

#### Demand paging swapping process

- Exchanges resident memory page with secondary storage page
- Involves
	- Copying resident page to disk
		- If it was modified
	- Writing new page into the empty page frame
- Requires
	- Hardware components
	- Software algorithms
	- Policy schemes
- Hardware instruction processing
- **Page fault:**
	- Failure to find page in memory
- Page fault handler
	- Part of operating system
	- Determines if empty page frames in memory
		- Yes
			- Requested page copied from secondary storage
		- No
			- Swapping occurs
	- Deciding page frame to swap out of all are busy
		- Directly dependent on the predefined policy for page removal

#### Demand page thrashing

- An excessive amount of page swapping between main memory and secondary storage
- Due to main memory page removal that is called back shortly thereafter
- Produces inefficient operation
- Occurs across jobs
	- Large number of jobs competing for a relatively few number of free pages
- Occurs within a job
	- In loops crossing page boundaries

#### Demand paging advantages / disadvantages

- Advantages
	- Job no longer constrained by the size of physical memory
		- Concept of virtual memory
	- Utilizes memory more efficiently that previous schemes
	- Faster response
- Disadvantages
	- Increased overhead caused by tables and page interrupts

## Page replacement policies and concepts

- Policy to select page removal
	- Crucial to system efficiency
- Page replacement policies
	- **First in first out (FIFO)**
		- Best page to remove is one in memory longest
	- **Least recently used (LRU)**
		- Best page to remove is least recently accessed
- Mechanics of paging concepts
- The working set concept

### First in first out (FIFO)

- Removes page efficiency in memory the longest
- **Efficiency**
	- Ratio of page interrupts to page requests
	- FIFO example: Not so good
		- Efficiency is 9/11 or 82%
- **FIFO anomaly**
	- More memory does not lead to better performance

![fifo 1](http://snag.gy/BxPSU.jpg)

![fifo 2](http://snag.gy/02AK7.jpg)

### Least recently used (LRU)

- Removes page least recently accessed
- **Efficiency**
	- Causes either decrease in or same number of interrupts
	- Slightly better (compared to FIFO)
		- 8/11 or 73%
- **LRU is a stack algorithm** removal policy
	- Increasing main memory will cause either a decrease in or the same number of page interrupts
	- Does not experience FIFO anomaly

![lru](http://snag.gy/qSSZ3.jpg)

### Least recently used variations

- Two variations
	- Clock replacement technique
		- Paced according to the computer's clock cycle
	- Bit shifting technique
		- Uses 8-bit reference byte and bit shifting technique
		- Tracks usage of each page currently in memory

## Mechanics of paging

- Page swapping
	- Memory manage requires specific information
	- Uses **page map table** information
		- **Status bits**
			- `0` or `1`

![page map table](http://snag.gy/mMTb0.jpg)

### Page map table bit definition

- Status bit
	- Indicates if page currently in memory
- Referenced bit
	- Indicates if page referenced recently
	- Used by **LRU** to determine page swap
- Modified bit
	- Indicates if page contents altered
	- Used to determine if page must be rewritten to secondary storage when swapped out
- Four combinations of modified and referenced bits

![page map table definitions](http://snag.gy/F4caA.jpg)

![page map table modified / referenced combinations](http://snag.gy/Ampdd.jpg)

## The working set

- Set of pages residing in memory accessed directly without incurring a page fault
	- Improves performance of demand page scheme
- Requires concept of **locality of reference**
	- Occurs in well-structured programs
		- Only small fraction of pages needed during program execution
- Time sharing system considerations
- System decides
	- Number of pages comprising working set
	- Maximum number of pages allowed for a working set

![working set time](http://snag.gy/fs0T2.jpg)

## Alternative memory allocation techniques

### Segmented memory allocation

- Each job divided into several segments
	- Segments are different sizes
	- One for each module containing related functions
- Reduces page faults
	- Segment's loops not split over two or more pages
- Main memory no longer divided into page frames
	- Now allocated dynamically
- Program's structural modules determine segments
	- Each segment numbered when compiled / assembled
	- **Segment Map Table (SMT)** generated

![segmented memory allocation 1](http://snag.gy/4oEUv.jpg)

![segmented memory allocation 2](http://snag.gy/Vjpij.jpg)

![segmented memory allocation 3](http://snag.gy/T2zD0.jpg)

#### Segmented memory allocation tables

- Memory manager tracks segments using tables
	- **Job table**
		- Lists every job in process
			- One for whole system
	- **Segment table**
		- Lists details about each segment
			- One for each job
	- **Memory map table**
		- Monitors allocation of main memory
			- One for whole system
- Instructions with segments ordered sequentially
- Segments not necessarily stored contiguously
- Addressing scheme requirement
	- Segment number and displacement

#### Segmented memory allocation advantages / disadvantages

- Advantages
	- Internal fragmentation is removed
	- Memory allocated dynamically
	- Removes segmentation problems
		- Compaction
		- External
- Disadvantages
	- Difficulty managing variable-length segments in secondary storage
	- External fragmentation

### Segmented / demand page memory allocation

- Subdivides segments into pages of equal size
	- Smaller than most segments
	- More easily manipulated than whole segments
	- Logical benefits of segmentation
	- Physical benefits of paging
- Segmentation problems removed
	- Compaction
	- External fragmentation
	- Secondary storage handling
- Addressing scheme requirements
	- Segment number
	- Page number within that segment
	- Displacement within that page

#### Segmented / demand page memory allocation tables

- Scheme requires four tables
	- **Job table**
		- Lists every job in process
			- One for whole system
	- **Segment map table**
		- Lists details about each segment
			- One for each job
	- **Page map table**
		- Lists details about every page
			- One for each segment
	- **Memory map table**
		- Monitors allocation of page frames in main memory
			- One for whole system

![segmented / demand page memory allocation tables](http://snag.gy/VVJ5E.jpg)

#### Segmented / demand page memory allocation advantages / disadvantages

- Advantages
	- Large virtual memory
	- Segment loaded on demand
	- Logical benefits of segmentation
	- Physical benefits of paging
- Disadvantages
	- Table handling overhead
	- Memory needed for page and segment tables

#### Segmented / demand page memory allocation associative memory

- Several registers allocated to each job
	- Associate segment and page numbers with main memory
- Uses two simultaneous searches for page
	- One search of registers
	- One search of **segment map table (SMT)** and **page map table (PMT)**
- Minimizes number of references
- Used to speed up process
- Disadvantage
	- High cost of complex hardware required to perform parallel searches

## Virtual memory

- Allows program execution even if not stored entirely in memory
- Requires cooperation between memory manager and processor hardware

### Virtual memory advantages / disadvantages

- Advantages
	- Job size not restricted to size of memory
	- Memory used more efficiently
	- Allows an unlimited amount of multiprogramming
	- Eliminates external fragmentation and minimizes internal fragmentation
	- Allows the sharing of code and data
	- Facilitates dynamic linking of program segments
- Disadvantages
	- Increased processor hardware costs
	- Increased overhead for handling page interrupts
	- Increased software complexity to prevent thrashing

### Virtual memory paging vs. segmentation

![virtual memory paging vs. segmentation](http://snag.gy/dGRO7.jpg)

## Cache memory

- Small, high speed intermediate memory unit
- Performance of computer system increased
	- Memory access time significantly reduced
	- Faster processor access compared to main memory
	- Stores frequently used data and instructions
- Two levels of cache
	- **L2**
		- Connected to CPU
		- Contains copy of bus data
	- **L1**
		- Pair built into CPU
		- Stores instructions and data
- Data / instructions move from main memory to cache
	- Uses methods similar to paging algorithms

![cache memory](http://snag.gy/rXjaM.jpg)

- Four cache memory design factors
	- Cache size
	- Block size
	- Block replacement algorithm
	- Rewrite policy
- An optimal selection of cache and replacement algorithm necessary
	- May lead to 80-90% of all requests in cache
- Efficiency measures
	- **Cache hit ration (h)**
		- Percentage of total memory request found in cache
	- **Miss ratio (1 - h)**
	- **Average memory access time**
		- `AvgCacheAccessTime + (1 - h) * AvgMemAccessTime`

## Summary

- Paged memory allocation
	- Efficient use of memory
	- Allocate jobs in non-contiguous memory locations
	- Problems
		- Increased overhead
		- Internal fragmentation
- Demand paging scheme
	- Eliminates physical memory size constraint
	- LRU provides slightly better efficiency than FIFO
- Segmented memory allocation scheme
	- Solves internal fragmentation problem
- Segmented / demand paged memory
	- Problems solved
		- Compaction
		- External fragmentation
		- Secondary storage handling
- Associative memory
	- Used to speed up process
- Virtual memory
	- Programs execute if not stored entirely in memory
	- Job's size no longer a restriction to main memory size
- Cache memory
	- CPU can execute instructions faster

### Memory allocation scheme comparisons

![memory allocation scheme comparisons](http://snag.gy/AhsrW.jpg)
