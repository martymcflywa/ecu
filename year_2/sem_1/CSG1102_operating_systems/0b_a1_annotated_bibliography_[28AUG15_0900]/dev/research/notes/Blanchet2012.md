# Computer architecture (2012)

>Blanchet, G., & Bertrand, D. (2012). Computer Architecture. Hoboken, NJ: Wiley.

## Chapter 9: Virtual memory

>pp. 175 - 204

- Introduction
- General concept
	- Operation
	- Accessing information
	- Address translation
- Rules of the access method
	- Page fault
	- Multi-level paging
	- Service information, protection and access rights
	- Page size
- Example of the execution of a program
- Example of two-level paging
- Paged segmentation

### Introduction

- "Technique that relies on the combined use of the main memory and a mass storage unit" pp. 175
	- Describes virtual memory as a technique combining main memory and a mass storage unit, using the mass storage unit to simulate the presence of a larger memory capacity
	- Virtual memory fits in with the "hierarchy of a memory management system" which include mass storage, main memory, cache and registers
- First implementation of virtual memory: ATLAS computer, University of Manchester, early 1960s
	- Used one-level store approach
	- Used algorithm to keep most frequently used pages in physical memory

### General concept

#### Operation

- Physical memory and mass storage is seen by the "user" as a single space
- Pages serve as a method to transfer blocks of information between physical memory and mass storage
	- Pages are implemented by the operating system
		- Deals with the location of data so that the "user" doesn't have to
	- "Programs can be written as if physical memory is equal to the size of mass storage" pp. 176
- Can cause delays during transfer of data between physical memory and mass storage

#### Accessing information

- Describes the logical process of virtual memory when accessing data
- Processor sends out an address
- Translation mechanism determines presence of required page in physical memory
- If page is present, data is accessed immediately
- Else, the required page must be transferred from mass storage to physical memory
	- If necessary, clear space for incoming page
- If space to be cleared contains a page that has been modified, transfer the modified page to mass storage
- Else the incoming page replaces the previous page without saving

#### Address translation

- Describes the process of address translation, from physical to virtual
	- Physical address
		- Location of data within actual physical main memory
	- Virtual address
		- Logical location known to the "user"
	- Memory management system responsible for address translation
- Defines page fault
	- When a requested page is not found in physical memory
	- Mass storage must be searched for desired page
- Defines page size
	- "Virtual and physical space divided into blocks of the same size" pp. 177
- Defines address
	- Page number
	- Page offset
- Discusses VPN / PPN
	- Translation of a virtual page number (VPN) to a physical page number (PPN)
	- VPN can only refer to one PPN
		- One to one
	- PPN can refer to many VPN
		- One to many
- Discusses translation device
	- Is purely hardware
	- Translation tables kept in memory
		- Uses cache system to improve performance
			- Translation lookaside buffer (TLB)
			- Translation buffer (TB)
			- Address translation cache (ATC)
- Compares translation cache to conventional cache
	- Translation cache only contains physical page number that contains data
		- Not the data itself
		- Page number then used by the cache memory
	- Page search within the translation cache is managed by the OS
		- Not by hardware

### Rules of the access method

#### Page fault

- Defines page fault
	- When a program executes, the processor sends virtual addresses to the memory management module
	- The memory manager indicates if the virtual address corresponds to a physical address
		- If so, the virtual address is translated to the physical address and the data is fetched
		- If not, the memory manager sends an abort signal to stop the execution
- Compares page fault to interrupt
	- Page fault
		- Instructions are to revert to the initial state instead of stopping
		- Registers altered by the execution must be restored so that
			- Once the page fault is handled, it is possible to restart the instruction from the beginning
		- The address saved in the stack is not the address of the instruction
			- But of the instruction that triggered the fault

#### Multi level paging

- Page tables can take up large amount of physical memory
- Use of multi level paging addresses issue
	- First level stored in memory
	- Second level partially stored in mass storage
- First level
	- Called
		- Page directory
		- Root table page
		- Hyperpage table
	- Virtual address divided into three fields
		- Entry in page directory
		- Entry in page table
		- Offset in page

#### Service information, protection and access rights

- Describes service bits
	- Used for
		- Protecting data and programs
		- Management of memory
- Modify bit M:
	- Also known as dirty bit
	- Indicates if page has been modified
	- Determines if page needs to be copied back to mass storage before removal
- Valid bit N:
	- Helps avoid accessing pages that are referenced in a table but not yet transferred to memory
		- This can occur when
			- Machine is turned on/initialised, content of memory is uncertain
			- Page in memory is copied to mass storage to save space
				- Page number is replaced by the number of the disk block it was loaded to
				- Corresponding V bit is then set to invalid position
- Reference bit R:
	- Used to estimate how frequently the page is used
	- Bit is set to 1 when the page is accessed
	- Periodically set to 0
	- Used for LRU algorithm, bit with 0 is least used
	- Notes that not all processors are equipped with this service bit
		- OS can simulate by using the M or V bit
- Other bits included to
	- Manage read/write/execute rights
	- Define the process that owns the page

#### Page size

- Describes "conflicting" pp. 181 criteria in choosing page size
- Smaller page size = larger description tables
	- Smaller page size better than larger page size
- Internal fragmentation
	- Smaller page size better than larger page size
- Smaller page size means quicker transfer between physical memory and mass storage
- Locality principle
	- Do not need entire program in physical memory
- If pages too small
	- Too many transfers between physical memory and mass storage
	- Loss in performance due to execution of page replacement algorithm
- Relationship between size of physical sector of mass storage and page size
	- Physical sector
		- Physical unit for the transfer
	- Page size
		- Logic unit for the transfer
- Generalisation: quotes all from pp. 182
	- "Page size is chosen an equal to one to eight times the size of the disk sector, or equal to the disk allocation unit"
		"Granularity or cluster from the point of view of the operating system"
	- "Page size in Windows or Mac OSX is usually 4kb"
		"It is related to the granularity parameter in the processor's memory management system"

### Example of executing a program

- Describes the process of virtual memory while a program is executed
	- Role of the physical page number (PPN) and its presence bit P
	- Where the the page table address is stored in memory
		- Page table register (PTR)
		- Its access rights (read only)
	- Step by step description as the program is loaded into pages of physical memory
		- Interactions with the translation cache
		- Describes
			- What happens when a "hit" occurs
				- And when a page fault occurs
- General rule: "Operating systems try to keep in memory of the most used pages" pp. 187
	- Working set
	- "Virtual memory management relies on this paging-transfer association" pp. 188
- Difficulties in updating translation cache compare to conventional cache
	- Two virtual addresses can be identical in the address memory of the translation lookaside buffer (TLB)
		- Solutions
			- Invalidate entire content of the TLB
				- After a page fault
				- Or after OS resets the table page bit P to 0
				- Used by early Intel 386
			- Invalidate only part of the entries involved
				- Requires having access instructions to lines of the the TLB
				- Used by AMD29000
				- A TLB miss generates a TLB trap exception is generated
				- Memory manager provides the recommendation register the TLB entry number corresponding to the LRU line
				- The address responsible for the trap is also saved in a register so that the OS can update the TLB and page table

### Example of two-level paging

- Describes process of two-level paging
	- Uses NS32000 (1980s) as example
	- Virtual memory and physical memory have the same size
- Describes design of memory management module
	- Address
		- 24 bit
	- Page
		- 512 bytes
		- Offset bits
			- 9 bits
		- Page number
			- 15 bits
	- Virtual page number
		- Two fields
			- Page directory entry
				- 8 bit
				- Refers to one of 256 entries in page directory (PD)
					- PD permanently stored in memory
					- Built based on page table base (PTB)
			- Page table entry
				- 7 bit
				- Refers to one of 128 entries in page table
				- 9 LSB refer to offset

### Paged segmentation

- Uses Intel 80386 as example
