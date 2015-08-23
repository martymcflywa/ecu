#### Jacob, B., Ng, S. W., & Wang, D. T. (2008). Memory Systems - Cache, DRAM, Disk. Burlington, MA: Morgan Kaufmann Publishers.

`Jacob2008`

- Many references to academic sources
- Pseudocode instead of code in a specific language
- Describes technique of virtual memory management
	- Manages
		- Cache
		- Main memory
		- Disk
	- Describes brief history
	- Advantages
		- Provides framework for OS multitasking
			- Process "owns" all available resources
			- Provides protection of resources
		- Allows execution of processes not entirely resident in main memory
			- Transferred to main memory on demand
	- Most virtual memory management is implemented via paging
	- Asserts virtual memory is also increasingly found in embedded systems
- Describes supporting hardware
	- Memory management unit (MMU)
	- Intel translation lookaside buffer (TLB)
- Describes the relationship between
	- Address spaces and main memory cache
	- Address mapping and the page table
- Compares page table structures
	- Hierarchical
		- Top down traversal
		- Bottom up traversal
	- Inverted page tables
- Looks at hardware implementation

#### Silberschatz, A., Galvin, P. B., & Gagne, G. (2013). Operating System Concepts Essentials (2nd ed.). Wiley.

`Silberschatz2013`

- Book provides overview of operating system as a whole
	- Chapter 8: Virtual Memory (p. 371 - 438)
- Provides an overview of virtual memory, and the virtual address space.
	- Explains organisation of virtual address space
- Introduces the concept of paging
	- Explores the functionality of demand paging and page faults.
	- Offers several mathematical equations to calculate demand paging efficiency
	- Provides considerably more detail of page replacement and frame allocation algorithms compared to other books in this annotated bibliography
- Provides explanations on the causes of thrashing, and working set model
- Chapter concludes by comparing the implementation of virtual memory between Windows and Solaris

#### Babaoglu, Ö., & Joy, W. (1981). Converting a swap-based system to do paging in an architecture lacking page-referenced bits. In SOSP ’81 Proceedings of the eighth ACM symposium on Operating systems principles (Vol. 15, pp. 78–86). New York. doi:10.1145/800216.806595

`Babaoglu1981`

- Authors modify UNIX from swap-based segmented system to paging-based virtual memory system for VAX 11/780 system
- Discusses challenges with architecture of VAX
	- Architecture limitation
		- VAX supports paging but does not have mechanism to record page-referenced bits
		- Page-referenced bits used for clock and sampled working set (SWS) page replacement algorithms
		- Can only use FIFO and Random (RAND) policies
			- Not as efficient as clock and SWS
	- Explains memory management of VMS, the OS provided with the VAX system
		- Fixed partition scheme
	- Compares VMS with UNIX and its memory management operations
		- Describes unsuitability of VMS memory management if used in a UNIX environment
- Authors describe work around over limitation
	- Uses dynamic address translation mechanisms to record references to pages
- Compares page replacement algorithms with VMS memory management
	- Clock page replacement algorithm performs better than fixed partition scheme
		- Page fault rates similar to least recently used algorithm
			- Easier to implement
		- Reliant on page-referenced bits
		- Authors applied clock page replacement to all pages in the system instead of locally due to studies showing that it out-performs local implementations
			- Easier to implement with architecture that does not support page-referenced bits
- Discusses design decisions to their clock replacement algorithm
	- Original clock page replacement algorithm is triggered when a page fault occurs
		- Selects single page for replacement
			- Due to nature of memory access of OS, high spikes of page faults have been observed
		- Modified algorithm to replace more than one page
			- Through use of a free page pool
				- Page frames currently not in use
			- Monitor size of pool
				- If pool drops below set threshold, clock policy is triggered
					- Scans a given number of pages per second
						- Number of pages per second increases as free page pool decreases until reaches maximum value
		- Cost of algorithm controlled by max scan rate
