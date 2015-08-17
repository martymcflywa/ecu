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
