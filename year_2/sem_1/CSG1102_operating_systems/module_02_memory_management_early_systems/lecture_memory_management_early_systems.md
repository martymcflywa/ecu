# Memory management: early systems

## Learning objectives

- Basic functionality of three memory allocation schemes
	- Fixed partitions
	- Dynamic partitions
	- Relocatable dynamic partitions
- Two memory allocation algorithms
	- Best fit
	- First fit
- How memory list keeps track of available memory
- Importance of deallocation of memory in dynamic partition systems
- Importance of bounds register in memory allocation schemes
- Role of compaction and how it improves memory allocation efficiency

## Introduction

- Management of main memory is crucial
- Entire system performance dependent on two items
	- How much memory is available
	- Optimization of memory during job processing
- This chapter introduces
	- Memory manager
	- Four types of memory allocation schemes
		- Single user systems
		- Fixed partitions
		- Dynamic partitions
		- Relocatable dynamic partitions

## Memory allocation schemes

### Single user contiguous scheme

- Commercially available in 1940s and 1950s
- Entire program loaded into memory
- Contiguous memory space allocated as needed
- Jobs processed sequentially
- Memory manager performs minimal work
	- Register to store the base address
	- Accumulator to track program size

#### Disadvantages

- No support for multi programming or networking
- Not cost effective
- Program size must be less than memory size to execute

### Fixed partitions

- Commercially available in 1950s and 1960s
- Main memory is partitioned
	- At system start up
	- One contiguous partition per job
- Permits multi programming
- Partition sizes remain static
	- Must shut down computer system to reconfigure
- Requires
	- Protection of the job's memory space
	- Matching job size with partition size
- Memory manager allocates memory space to jobs
	- Uses table

#### Disadvantages

- Requires contiguous loading of entire program
- Job allocation method
	- First available partition with required size
- To work well
	- All jobs must be same size and memory size know ahead of time
- Arbitrary partition size leads to undesired results
	- If partition too small
		- Large jobs have longer turn around time
	- If partition to large
		- Memory waste
			- **Internal fragmentation**

#### Fixed partition memory table

![simplified fixed partition memory table](http://snag.gy/7OJgq.jpg)

#### Fixed partition memory allocation

![memory use during fixed partition allocation](http://snag.gy/cFygF.jpg)

### Dynamic partitions

- Main memory is partitioned
	- Jobs given memory requested when loaded
	- One contiguous partition per job
- Job allocation method
	- **First come, first serve** allocation method
	- Memory waste
		- Comparatively small

#### Disadvantages

- Full memory utilization only during loading of first jobs
- Subsequent allocation
	- Memory waste
- External fragmentation
	- Fragments between blocks

#### Dynamic partition memory allocation

![dynamic partition memory allocation](http://snag.gy/I0WdF.jpg)

## Best fit vs. first fit allocation

- Two methods for free space allocation
	- First fit
		- First partition fitting the requirements
		- Leads to fast allocation of memory space
	- Best fit
		- Smallest partition fitting the requirements
		- Results in least wasted space
		- Internal fragmentation reduced but not eliminated
- Fixed and dynamic memory allocation schemes use both methods

### First fit memory allocation

- Advantage
	- Faster in making allocation
- Disadvantage
	- Leads to memory waste

![first fit allocation](http://snag.gy/kP1lv.jpg)

### First fit algorithm

- Assumes memory manager keeps two lists
	- One for free memory
	- One for busy memory blocks
- Loop compares the size of each job to size of each memory block
	- Until a block is found that is large enough to fit the job
- Job stored into that block of memory
- Memory manager moves out of loop
	- Fetches next job from the entry queue
- If entire list searched in vain
	- The job is placed into waiting queue
	- Otherwise, memory manager fetches next job
- Process repeats

![first fit algorithm](http://snag.gy/OGqlQ.jpg)

### Best fit memory allocation

- Advantage
	- Makes best use of memory space
- Disadvantage
	- Slower in making allocation

![best fit allocation](http://snag.gy/PfS4b.jpg)

### Best fit algorithm

- Goal
	- Find the smallest memory block into which the job will fit
- Entire table searched before allocation

![best fit algorithm](http://snag.gy/VsxKf.jpg)

#### Hypothetical allocation schemes

- **Next fit**
	- Starts searching from last allocated block for next available block when a new job arrives
- **Worst fit**
	- Allocates largest free available block to new job
	- Opposite of best fit
	- Good way to explore theory of memory allocation
	- Not best choice for an actual system

## Deallocation

- Freeing allocated memory space

### Deallocation for fixed partition

- Straight forward process
- Memory manager resets the status of the job's memory block to **free** upon job completion
- Any code may be used
- Example code
	- Binary values
	- `0` = free
	- `1` = busy

### Deallocation for dynamic partition

- Algorithm tries to combine free areas of memory
- More complex
- Three dynamic partition system cases, when the block to be deallocated is:
	1. **Adjacent** to another free block
	2. **Between** two free blocks
	3. **Isolated** from other free blocks

#### Case 1: Adjacent to another free block

- **Join two free blocks**
- List changes to reflect starting address of new free block
	- Example below
		- `7600`
			- The address of the first instruction of the job that just released this block
- Memory block size changes to show its new size for the new free space
	- Combined total of the two free partitions
	- Example below
		- `200 + 5`

![adjacent to another free block 1](http://snag.gy/gzLsk.jpg)

![adjacent to another free block 2](http://snag.gy/pckex.jpg)

#### Case 2: Between two free blocks

- **Join three free blocks**
- List changes to reflect starting address of new free block
	- Example below
		- `7560` was smallest start address
- Sizes of the three free partitions must be combined
	- Example below
		- `20 + 20 + 205`
- Combined entry (last of the three) given status of `null`
	- Example below
		- `7600`

![between two free blocks 1](http://snag.gy/McB4H.jpg)

![between two free blocks 2](http://snag.gy/ubFND.jpg)

#### Case 3: Isolated from other free blocks

- **Deallocate an isolated block**
- System determines released memory block status
	- Not adjacent to any free blocks of memory
	- Between two other busy areas
- System searches table for a null entry
	- Occurs when memory block between two other busy memory blocks is returned to the free list

![isolated from other free blocks 1](http://snag.gy/tw2mG.jpg)

![isolated from other free blocks 2](http://snag.gy/yezcN.jpg)

![isolated from other free blocks 3](http://snag.gy/RUF7d.jpg)

![isolated from other free blocks 4](http://snag.gy/6Ge6m.jpg)

## Relocatable dynamic partitions

- Memory manager relocates programs
	- Gathers together all empty blocks
- Compact the empty blocks
	- Make one block of memory large enough to accommodate some or all of the jobs waiting to get in

### Compaction

- **Reclaiming fragmented sections of memory space**
	- Every program in memory must be relocated
		- Programs become contiguous
	- Operating system must distinguish between address and data values
		- Every address adjusted to account for the program's new location in memory
		- Data values left alone

![compaction 1](http://snag.gy/DpUAu.jpg)

![compaction 2](http://snag.gy/h9lcS.jpg)

![compaction 3](http://snag.gy/2F1mJ.jpg)

![compaction 4](http://snag.gy/uqrgD.jpg)

### Compaction issues

- What goes on behind the scenes when relocation and compaction take place?
- What keeps track of how far each job has moved from its original storage area?
- What lists have to be updated?

### Lists to be updated

- Free list
	- Must show the partition for the new block of free memory
- Busy list
	- Must show the new locations for all of the jobs already in process that were relocated
- Each job will have a new address
	- Exception
		- Those already at the lowest memory locations

### Special purpose registers used for relocation

- **Bounds register**
	- Stores highest location accessible by each program
- **Relocation register**
	- Contains the value that must be added to each address referenced in the program
	- Must be able to access the correct memory addresses after relocation
- If the program is not relocated, `zero` value stored in the program's relocation register

### Compaction considerations

- Compacting and relocating optimizes use of memory
	- Improves throughput
- Options for timing of compaction
	- When a certain percentage of memory is busy
	- When there are jobs waiting to get in
	- After a prescribed amount of time has elapsed
- Compaction entails more overhead
- **Goal**
	- Optimize processing time and memory use while keeping overhead as low as possible

## Summary

- Four memory management techniques
	- Single user systems
	- Fixed partitions
	- Dynamic partitions
	- Relocatable dynamic partitions
- Common requirements of four memory management techniques
	- Entire program loaded into memory
	- Contiguous storage
	- Memory residency until job completed
- Each places severe restrictions on job size
- Sufficient for first three generations of computers
- New modern memory management trends in late 1960s and early 1970s
	- Discussed in next chapter
	- Common characteristics of memory schemes
		- Programs are not stored in contiguous memory
		- Not all segments reside in memory during job execution
