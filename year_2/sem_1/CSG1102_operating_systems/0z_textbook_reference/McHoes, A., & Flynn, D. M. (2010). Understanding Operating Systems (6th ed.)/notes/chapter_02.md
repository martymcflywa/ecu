# Chapter 2: Memory management - early systems

## Objectives

- Basic functionality of three memory allocation schemes in this chapter
	- Fixed partitions
	- Dynamic partitions
	- Relocatable dynamic partitions
- Best fit memory allocation as well as first fit memory allocation schemes
- How a memory list keeps track of available memory
- The importance of deallocation of memory in a dynamic partition scheme
- The importance of the bounds register in memory allocation schemes
- The role of compaction and how it improves memory allocation efficiency

## Introduction

- The management of main memory is critical
- The performance of the entire system has been dependent on
	- How much memory is available
	- How it is optimized while jobs are being processed
- This chapter introduces
	- Main memory manager
		- Known as
			- RAM
			- Core memory
			- Primary storage
	- Four types of memory allocation schemes
		- Single user systems
		- Fixed partitions
		- Dynamic partitions
		- Relocatable dynamic partitions
- These early memory management schemes are seldom used by today's OS
	- Important to study because they introduce fundamental concepts that helped memory management evolve

## Single user contiguous scheme

- First memory allocation
- Each program to be processed was loaded in its entirety into memory
	- See figure 2.2
- Allocated as much contiguous space in memory as it needed
- If program was too large
	- Didn't fit the available memory space
	- Program could not be executed

![figure 2.2](http://snag.gy/J0TBz.jpg)

- Demonstrates significant limiting factor of all computers
	- Only have finite amount of memory
	- If program doesn't fit, then either
		- Increase size of main memory
		- Modify program
	- Programs usually modified to either
		- Make smaller
		- Use methods that allow program segments to be overlaid
			- Partitions made to the program
		- Overlay
			- Transfer segments of a program from secondary storage into main memory for execution
				- So that two or more segments take turns occupying the same memory locations
- Single user systems in a non networked environment work the same way
	- Each user is given access to all available main memory for each job
	- Jobs are processed sequentially, one after the other
	- To allocate memory
		- The OS uses a simple algorithm
			- See below
- The amount of work done by OS memory manager is minimal
	- Code to perform functions is straightforward
	- Logic is simple
- Only two hardware items are needed
	- Register to store the base address
	- Accumulator to keep track of the size of the program as it's being read into memory
- Once program is entirely loaded into memory
	- It remains there until execution is complete
		- Either through
			- Normal termination
			- By intervention of the OS
- Major problem
	- Doesn't support
		- Multiprogramming
		- Networking
	- Can only handle one job at a time
	- Were used in research institutions
		- Unacceptable for businesses

### Algorithm to load a job in a single user system

1. Store first memory location of program into base register
	- For memory protection
2. Set program counter equal to address of first memory location
	- It keeps track of memory space used by the program
3. Read first instruction of program
4. Increment program counter by number of bytes in instruction
5. Has the last instruction been reached?
	- If yes
		- Stop loading program
	- If no
		- Continue to step 6
6. Is program counter greater than memory size?
	- If yes
		- Stop loading program
	- If no
		- Continue to step 7
7. Load instruction in memory
8. Read next instruction of program
9. Go to step 4

## Fixed partitions

- First attempt to allow for multiprogramming used fixed partitions
	- Also called static partitions
	- One partition per job
- Size of each partition was designated when system was powered on
	- Partitions could only be reconfigured when computer was
		- Shut down
		- Reconfigured
		- Restarted
	- Once the system was in operation
		- Partition sizes remained static
- Critical factor introduced with fixed partitions
	- Protection of job's memory space
- Once partition was assigned to a job
	- No other job could be allowed to enter its boundaries, either
		- Accidentally
		- Intentionally
- Problem of partition intrusion didn't exist in single user contiguous allocation schemes
	- Because only one job was present in memory at any given time
	- Only portion of OS residing in memory had to be protected
- Protection mandatory in fixed partition schemes
	- For each partition present in memory
- Normally joint responsibility of hardware and OS
- The algorithm used to store jobs in memory requires a few more steps than the single user system
	- See below
	- Because size of job must be matched with size of partition to make sure it fits completely
	- When a block of sufficient size is located
		- Status of partition must be checked to see if it's available
- This partition scheme is more flexible than single user scheme
	- Allows several programs to be in memory at the same time
	- Still requires that the entire program be stored contiguously in memory from beginning to end of execution
- In order to allocate memory spaces to jobs
	- OS memory manager must keep a table which shows
		- Each memory partition size
		- Its address
		- Its access restrictions
		- Current status
		- See table 2.1
	- As each job terminates
		- The partition status is changed from busy to free
			- Allows incoming jobs to be assigned to that partition

![table 2.1](http://snag.gy/vMBNP.jpg)

### Algorithm to load a job in a fixed partition

1. Determine job's requested memory size
2. If `job_size > size` of largest partition
	- Reject job
		- Print appropriate message to user
		- Go to step 1 to handle next job in line
	- Else
		- Continue with step 3
3. Set `counter` to `1`
4. Do while `counte <= number` of partitions in memory
	- If `job_size > memory_partition_size` (counter)
		- Then `counter = counter + 1`
	- Else
		- If `memory_partition_size == free`
			- Then load job into `memory_partition`
				- Change `memory_parition_status` to `busy`
				- Go to step 1 to handle next job in line
		- Else
			- `counter = counter + 1`
	- End do
5. No partition available at this time
	- Put job in waiting queue
6. Go to step 1 to handle next job in line

### Advantages/disadvantages

- Works well if
	- All jobs are of same size
	- Sizes known ahead of time
		- Don't vary between reconfigurations
	- Would require accurate advanced knowledge of all jobs to be run on system
	- Unless operator can predict future
		- Size of partitions are determined in arbitrary fashion
			- Might be too small/large for incoming jobs
- Consequences
	- Partition to small
		- Larger jobs will either
			- Be rejected
			- Wait until large partitions are free
		- Larger jobs may
			- Have longer turnaround
			- Never execute
	- Partition too large
		- Memory is wasted
		- If job does not occupy entire partition
			- Unused memory in partition will remain idle
			- Can't be given to another job
				- Partition is allocated to only one job at a time
				- See figure 2.3
		- Called **internal fragmentation**
			- Major drawback to fixed partition memory allocation scheme

![figure 2.3](http://snag.gy/sRw1o.jpg)

## Dynamic partitions

- Available memory is kept in contiguous blocks
	- Jobs are given only as much memory as they request when loaded for processing
	- Improvement of internal fragmentation of fixed partitions
		- But doesn't entirely solve problem
- Dynamic partition scheme fully utilizes memory when the first jobs are loaded
	- But as new jobs enter the system that are not the same size as initial jobs
		- They are fit into available spaces on a priority bases
- First come first served priority
	- See figure 2.4
	- Subsequent allocation of memory creates fragments of free memory between blocks of allocated memory
		- Called **external fragmentation**
- In last snapshot, figure 2.4 (e)
	- There is enough free space to accommodate job 8
		- But free space is not contiguous
	- Forces job 8 to wait

![figure 2.4](http://snag.gy/XD9C1.jpg)

### Best fit vs. first fit allocation

- Both fixed and dynamic memory allocation
	- OS must keep lists of each memory location
		- Which are free/busy
	- As new jobs come in to the system
		- Free partitions are allocated
- Partitions may be allocated by
	- **First fit memory allocation**
		- First partition fitting the requirements
	- **Best fit memory allocation**
		- Least wasted space
		- Smallest partition fitting the requirements
- For both schemes
	- Memory manager organizes the memory list by either
		- Size
		- Location
	- Best fit
		- Keeps the free/busy list ordered by size
			- Smallest to largest
	- First fit
		- Keeps the free/busy list ordered by memory address
			- Low order memory to high order memory
- Each has advantages depending on needs of particular allocation scheme
	- Best fit usually makes best use of memory space
	- First fit is faster in making the allocation
- Figure 2.5 shows how a large job can have problems with first fit memory allocation
	- Jobs 1, 2 and 4 are able to enter the system and begin execution
	- Job 3 has to wait because of external fragmentation
	- First fit offers fast allocation
		- But isn't always efficient

![figure 2.5](http://snag.gy/KWxxa.jpg)

- Figure 2.6 shows the same job listing using best fit scheme
	- Uses memory more efficiently

![figure 2.6](http://snag.gy/rxQSq.jpg)

### First fit algorithm

1. Set `counter` to 1
2. Do while `counter <= number of blocks in memory`
	- If `job_size > memory_size` (counter)
		- Then `counter = counter + 1`
	- Else
		- Load job into `memory_size` (counter)
		- Adjust free/busy memory lists
		- Go to step 4
	- End do
3. Put job in waiting queue
4. Go fetch next job

#### First fit in action

- In table 2.2, a request for a block of 200 spaces has just been given to the memory manager
- Using first fit algorithm and starting from the top of the list
	- Memory manager locates the first block of memory large enough to accommodate the job
		- At location 6785
	- The job is then loaded
		- Starting at 675
		- Occupying the next 200 spaces
	- Next step is to adjust the free list to indicate that
		- The block of free memory now starts at location 6985
			- From previous 6785
		- Contains only 400 spaces
			- From previous 600

![table 2.2](http://snag.gy/FEEZt.jpg)

### Best fit algorithm

1. Initialize `memory_block(o) = 99999`
2. Compute `initial_memory_waste = memory_block(o) - job_size`
3. Initialize `subscript = o`
4. Set `counter` to 1
5. Do while `counter <= number of blocks in memory`
	- If `job_size > memory_size(counter)`
		- Then `counter = counter + 1`
	- Else
		- `memory_waste = memory_size(counter) - job_size`
	- If `initia_memory_waste > memory_waste`
		- Then `subscript = counter`
			- `initial_memory_waste = memory_waste`
			- `counter = counter + 1`
	- End do
6. If subscript = o
	- Then put job in waiting queue
	- Else
		- Load job into `memory_size(subscript)`
		- Adjust free/busy memory lists
7. Go fetch next job

#### Best fit in action

- A problem with best fit algorithm
	- Entire table must be searched before allocation can be made
		- Because memory blocks are physically stored in sequence according to location in memory
		- Not by memory block sizes
	- System could execute an algorithm to contiguously rearrange the list in ascending order by memory block size
		- But that would add more overhead
		- Might not be efficient use of processing time
- The best fit algorithm is illustrated showing only the list of free memory blocks
	- Table 2.3 shows the free list before and after the best fit block has been allocated to the same request presented in table 2.2

![table 2.3](http://snag.gy/UDGGb.jpg)

- In table 2.3, a request for a block of 200 spaces has just been given to the memory manager
- Using best fit algorithm and starting from the top of the list
	- Memory manager searches entire list
		- Locates a block of memory starting at location 7600
			- Smallest block that is large enough to accommodate the job
	- The choice of this block minimizes wasted space
		- Only 5 spaces are wasted
			- Least compared to other available blocks
	- Job is then stored
		- Starting at 7600
		- Occupying 200 spaces
	- Free list must be updated to show that the block of free memory
		- Starts at 7800
			- From 7600
		- Contains only 5 free spaces
			- From 205

### When to use first/best fit

- No way to answer
- Performance depends on job mix
- Best fit results in better fit
	- Also results in smaller free space
		- Called **sliver**
- Other hypothetical allocation schemes
	- Next fit
		- Starts searching from last allocated block for next available block when new job arrives
	- Worst fit
		- Opposite of best fit
		- Useful for exploring theory of memory allocation
		- Not best practical choice
- Access time improvement
	- Due to improvement of access time in recent years
		- Priority is focused on memory space rather than overhead
			- ie. Best fit

## Deallocation

### Fixed partition

- When job is completed
	- Memory manager resets status of the memory block where job was stored to **free**
	- Any code may be used so the mechanical task of deallocating a block of memory is relatively simple
		- ie. Binary value `0 = free`, `1 = busy`

### Dynamic partition

- More complex algorithm
- Tries to combine free areas of memory where possible
- System must be prepared for three alternative situations
	1. When the block to be deallocated is adjacent to another free block
	2. When the block to be deallocated is between two free blocks
	3. When the block to be deallocated is isolated from other free blocks
- The deallocation algorithm must be prepared for all three situations with a set of nested conditionals
- The following algorithm is based on the fact that memory locations are listed using lowest to highest address scheme
	- Algorithm would have to be modified to accommodate different organization of memory locations
- In this algorithm
	- `job_size` is the amount of memory being released by the terminating job
	- `beginning_address` is the location of the first instruction for the job

### Algorithm to deallocate memory blocks

- If `job_location` is adjacent to one or more free blocks
	- If `job_location` is between two free blocks
		- Then merge all three blocks into one block
		- `memory_size(counter-1) = memory_size(counter-1) + job_size + memory_size(counter+1)`
		- Set status of `memory_size(counter+1) to null entry`
	- Else
		- Merge both blocks into one
		- `memory_size(counter-1) = memory_size(counter-1) + job_size`
- Else
	- Search for null entry in free memory list
	- Enter `job_size` and `beginning_address` in the entry slot
	- Set its status to `free`

#### Case 1: Joining two free blocks

- Table 2.4 shows how deallocation occurs when the job to be deallocated is next to one free memory block

![table 2.4](http://snag.gy/U0Fpu.jpg)

- Table 2.5 shows the free list after deallocation

![table 2.5](http://snag.gy/wdykQ.jpg)

- The system sees that the memory to be released is next to a free memory block
	- Starts at location 7800
- Therefore, the list must be changed to reflect the starting address of the new free block
	- 7600, the address of the first instruction of the job that just released this block
- In addition, the memory block size for this new free space must be changed to show its new size
	- The combined total of the two free partitions
		- 200 + 5

#### Case 2: Joining three free blocks (between two free memory blocks)

- Table 2.6 shows how deallocation occurs between two free memory blocks

![table 2.6](http://snag.gy/AzgyG.jpg)

- The system learns that the memory to be deallocated is between two free blocks of memory
- Therefore,
	- The sizes of the three free partitions must be combined
		- 20 + 20 + 205
	- Beginning address is changed to 7560

![table 2.7](http://snag.gy/8uTiK.jpg)

##### Null entry

- Because the entry at location 7600 has been combined with the previous entry
	- We must empty out this entry
- This occurs by changing the status to **null entry**
	- With no
		- Beginning address
		- No memory block size
- This negates the need to rearrange the list at the expense of memory

#### Case 3: Deallocating an isolated block

- Table 2.8 shows the free list
- Table 2.9 shows the busy list

![table 2.8/9](http://snag.gy/3h4Gr.jpg)

- The system learns that the memory block to be released is not adjacent to any free blocks of memory
	- Instead, it is between two other busy blocks
	- Therefore, the system must search the table for a null entry
- The scheme presented in this example creates null entries in both the busy and free lists during the process of de/allocation of memory
	- Null entry in busy list
		- Occurs when a memory block between two other busy memory blocks is returned to the free list
			- See table 2.10
		- This mechanism ensures that all blocks are entered in the lists according to the beginning address of their memory locations
			- From smallest to largest

![table 2.10](http://snag.gy/0LBM6.jpg)

- When the null entry is found
	- The beginning memory location of the terminating job is entered in the beginning address column
	- The job size is entered under the memory block size column
	- Status is changed from null entry to free to indicate that a new block of memory is available
		- See table 2.11

![table 2.11](http://snag.gy/Ex4cC.jpg)

## Relocatable dynamic partitions

- Both of fixed/dynamic memory allocation schemes shared unacceptable fragmentation characteristics
	- Had to be resolved before number of jobs waiting to be accepted became unwieldy
	- There was a growing need to use all the slivers of memory often left over
- Solution is **relocatable dynamic partitions**
	- Memory manager relocates programs to gather together all of the empty blocks
	- Compacts them to make one block of memory large enough to accommodate some or all jobs waiting to be accepted
- Compaction
	- Also known as
		- Garbage collection
		- Defragmentation
	- Performed by OS to reclaim fragmented sections of memory space
		- Overhead process
	- Isn't easy
		- Every program in memory must be relocated so they're contiguous
		- Every address, reference to address must be adjusted to account for the program's new location in memory
	- All other values within the program must be left alone
		- ie. Data values
	- OS must distinguish between addresses and data values
		- Distinctions are not obvious once program has been loaded into memory
- OS can tell the function of instruction by its location in the line and op code
	- But if the program is moved to another place in memory
		- Each address must be identified or flagged
	- The amount of memory locations the program has been displaced must be added/subtracted to from the original address in the program
- Becomes important when program includes
	- Loop sequences
	- Decision sequences
	- Branching sequences
	- Data references
- If every address was not adjusted by the same value
	- The program would could potentially either
		- Branch into the wrong section of the program
		- Branch into a section of another program
		- Reference the wrong data
- Program in figure 2.7 and 2.8 shows how the OS flags the addresses so that they can be adjusted if and when a program is relocated
	- Shown by apostrophe

![figure 2.7/8](http://snag.gy/ILoZo.jpg)

- Internally, the addresses are marked with a special symbol so the memory manager will know to adjust them by the value stored in the relocation register
	- All other values are not marked and won't be changed after relocation
	- Other numbers in the program are also left alone
		- Instructions
		- Registers
		- Constants
- Figure 2.9 shows what happens to a program in memory during compaction and relocation

![figure 2.9](http://snag.gy/kx6AJ.jpg)

- Compaction raises three questions
	1. What goes on behind the scenes when relocation and compaction take place?
	2. What keeps track of how far each job has moved from its original storage area?
		- Special purpose registers are used to help with relocation
			- May use two registers
				- Bounds register
				- Relocation register
		- Bounds register
			- Stores the highest or lowest location in memory accessible by each program
			- Ensures that during execution, a program won't try to access memory locations that don't belong to it
				- Locations that are out of bounds
		- Relocation register
			- Contains the value that must be added to each address referenced in the program so that the system will be able to access the correct memory address after relocation
				- If the program isn't relocated
					- The value stored in the program's relocation register is `0`
	3. What lists have to be updated?
		- Both free and busy list are updated
		- Free list is changed to show the partition for the new block of free memory
			- The one formed as a result of compaction that will be located in memory starting after the last location used by the last job
		- The busy list is changed to show the new locations for all the jobs already in progress that were relocated
			- Each job will have a new address except for those that were already residing at the lowest memory locations
- Figure 2.10 shows what happens during relocation by using the relocation register
	- All values are shown in decimal form

![figure 2.10](http://snag.gy/EXmWW.jpg)

- Originally job 4 was loaded into memory starting at location 30720
	- It required a block of memory of 32K
	- When originally loaded
		- The job occupied space from location 30720 to 63488-1
- Suppose that within the program
	- At memory location 31744
	- There's an instruction that looked like
		- `LOAD 4, ANSWER`
- This assembly command asks that the data value known as `ANSWER` be loaded into register 4 for later computation
	- `ANSWER`, value `37` is stored at memory location 53248
		- Note that register 4 is separate to the bounds and relocation register
- After relocation, job 4 has been moved to a new starting memory address of 18432
	- The job still has its 32K addressable locations
		- So now it occupies memory from location 18432 to 51200-1
	- Relocation register ensures all addresses are adjusted accordingly
- What does the relocation register contain?
	- In this example, it contains the value -12288
	- As calculated previously, 12288 is the size of the free block that has been moved forward toward the high addressable end of memory
	- The negative sign is due to job 4 being moved back
		- Closed to to the low addressable end of memory
			- As shown in figure 2.10 (b)
- However, program instruction `LOAD 4, ANSWER` has not been changed
	- The original address 53248 where `ANSWER` had been stored remains the same in the program no matter how many times it is relocated
	- Before the instruction is executed
		- The true address must be computed by adding the value stored in the relocation register to the address found at that instruction
	- If the addresses are not adjusted by the value stored in the relocation register
		- Then even though memory location 31744 is still part of the job's accessible set of memory locations
			- It would not contain the `LOAD` command
		- Location 53248 is now out of bounds
		- The instruction that was originally at 31744 has been moved to location 19456
			- That is because all of the instructions in this program have been moved back by 12K
				- The size of the free block
	- Therefore
		- Location 52348 has been displaced by -12288
		- `ANSWER` is now located at address 40960
- In effect
	- By compacting and relocating, the memory manager optimizes the use of memory and improves throughput
	- Side effect
		- More overhead is incurred that the previous memory allocation schemes
- Crucial factor
	- Timing of the compaction
		- When and how often it should be done
- There are three options
	- Do it when a certain % of memory becomes busy
		- Disadvantage
			- System would incur unnecessary overhead if no jobs were waiting to use the remaining %
	- Do it only when there are jobs waiting to get in
		- Disadvantage
			- Constant checking of entry queue
			- Result in unnecessary overhead and slowdown of processing jobs already in the system
	- Do it after timeout
		- Disadvantage
			- If timeout too small
				- System will spend more time on compaction than processing
			- If timeout too large
				- Too many jobs will congregate in the wait queue
					- Advantage of compaction lost

## Conclusion

- Four memory management techniques
	- Single user systems
	- Fixed partitions
	- Dynamic partitions
	- Relocatable dynamic partitions
- Three things in common
	- Entire program be loaded into memory
	- Be stored contiguously
	- Remain in memory until job is complete
- Each puts severe restrictions on size of jobs
	- They can only be as large as the biggest partitions in memory
- These schemes were sufficient for first three gens of computers
	- Processed jobs in batch mode
	- Turnaround time measured in hours/days
