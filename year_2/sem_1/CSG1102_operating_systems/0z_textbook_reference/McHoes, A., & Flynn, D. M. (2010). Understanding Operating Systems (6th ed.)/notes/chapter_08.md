# Chapter 8: File management

## Objectives

- Fundamentals of file management
	- Structure of file management system
- File naming conventions
	- Role of extensions
- Difference between record formats
	- Fixed length
	- Variable length
- Advantage/disadvantage of file storing techniques
	- Contiguous
	- Non contiguous
	- Indexed
- Sequential vs. direct file access
- Role of data compression in file storage

## Introduction

- File manager
	- Controls every file in system
- How files are
	- Organized logically
	- Stored physically
	- Access
	- Who is allowed to access them
- Interactions between
	- File manager
	- Device manager
- Efficiency of file manager depends on
	- How files are organized
		- Sequential
		- Direct
		- Indexed sequential
	- How files are stored
		- Contiguously
		- Non contiguously
		- Indexed
	- How each file's records are structured
		- Fixed length
		- Variable length
	- How access is controlled

## File manager

- Responsible for
	- Managing files
		- Create
		- Delete
		- Modify
		- Controlling access
	- Managing resources used by files
- Provides support for libraries of programs/data to
	- Online users
	- Spooling operations
	- Interactive computing
- Functions performed in collaboration with the device manager

### File manager responsibilities

- In charge of
	- System's physical components
	- Information resources
	- Policies used to store/distribute files
- Must perform four tasks
	1. Keep track of where each file is stored
	2. Use a policy to determine where/how files are stored
		- Efficiently use available storage space
		- Provide efficient access to files
	3. Allocate each file when user has been cleared access to it
		- Record access
	4. Deallocate file when file is to be returned to storage
		- Communicate availability to others who may be waiting for it
- File manager keeps track of files with directories
	- Contains
		- Filename
		- Physical location in secondary storage
		- Important information about each file
- File manager policy
	- Determines where each file is stored
	- How system and users access them
		- Via commands that are independent from device details
	- Must determine who will have access to which files
		- Two factors
			- Flexibility of access
			- Protection
		- Allows access to shared files
			- Provide distributed access
			- Allow users to browse public directories
		- Protect OS files against system malfunction
		- Provide security checks via account numbers/passwords
			- Preserve integrity of data
			- Safeguard against tampering
- File allocation
	- Activates appropriate secondary storage device
	- File loaded into memory
	- Records updated of who is using the file
- File deallocation
	- Update file tables
	- Rewrite file to secondary storage
		- If dirty
	- Any processes waiting to access file is notified of availability

## Definitions

![figure 8.1](http://snag.gy/FkUu8.jpg)

### Field

- Group of related bytes
- Can be identified by user with
	- Name
	- Type
	- Size

### Record

- Group of related fields

### File

- Group of related records
- Contains information to be used by specific applications to generate reports
- This type of file contains data
- Sometimes called **flat file**
	- No connections to other files
		- Unlike databases
	- No dimensionality

### Database

- Appears to a file manager as a type of file
- More complex
- Groups of related files
	- Interconnected at various levels
	- Gives users flexibility of access to stored data
- If user database requires specific structure
	- File manager must be able to support it

### Directories

- Special files with listings of filenames and attributes
- Data collected to monitor system performance and provide for system accounting is collected into files
- Every program and data file accessed by computer and software is treated as a file

## Interacting with the file manager

- Responds to specific commands
	- OPEN
	- DELETE
	- RENAME
	- COPY
- Files can be created with other system specific terms
	- CREATE
		- First time user gives command to save file
		- Could also be shown as OPEN NEW
- Designed to be simple to use
	- Do not include detailed instruction required to run the device where the file might be stored
		- Information in device driver
	- Commands are device independent
- To access a file
	- User doesn't need to know
		- Exact physical location on disk pack
			- Cylinder
			- Surface
			- Sector
		- Medium used
			- Tape
			- Magnetic disk
			- Optical disc
			- Flash storage
		- Network specifics
- Each logical command is broken down into a sequence of signals
	- Trigger step by step actions performed by the device
	- Supervise progress of operation by testing device status

### Example

- When user program issues command to read a record from disk
	- READ instruction has to be decomposed in following steps
		1. Move read/write heads to cylinder/track where record is stored
		2. Wait for rotational delay until sector containing record passes under read/write head
		3. Activate appropriate read/write head
			- Read record
		4. Transfer record to memory
		5. Set flag to indicate device is free to satisfy another request
- While steps are executed
	- System must check for possible error conditions
- File manager abstracts operations from user
	- So user does not have execute commands themselves
- Without file manager
	- Every program would need to include instructions to operate all different types/models of devices
- Would be impractical to require each program to include such detail

### Typical volume configuration

- Each storage unit is considered a volume
	- Either
		- Removable
		- Non removable
	- Multifile volume
		- Volumes containing multiple files
	- Multivolume files
		- Files contained in several volumes
- Each volume is given a name
	- File manager writes volume descriptor
		- Name and other descriptive information in easy to access place on each unit
		- See figure 8.3
		- Example
			- Innermost track of CD/DVD
			- Start of tape
			- First sector of outermost track in disk pack
- Once identified
	- OS can interact with storage unit

![figure 8.3](http://snag.gy/b2MfL.jpg)

#### Master file directory (MFD)

- Stored immediately after volume descriptor
- Lists names and characteristics of every file contained in the volume
- Filenames in MFD can refer to
	- Program files
	- Data files
	- System files
	- Subdirectories
		- If file manager supports it
- Remainder of volume is used for file storage

### Single directory per volume

- First OS's
- Directory created by file manager
- Contained names of files
	- Ordered by either
		- Alphabetical
		- Spatial
		- Chronological
- Advantages
	- Simple to
		- Implement
		- Maintain
- Disadvantages
	- Long time to search for individual file
		- Especially if MFD was organized in arbitrary order
	- 256 filename limit
		- Directory space may be filled before storage space is filled
	- Users cannot create subdirectories to group related files
	- Multiple users can't safeguard their files from other users
		- Entire directory was available to every user in the group on request
	- Each program in entire directory needed unique name
		- Even those directories serving many users
		- Only one person using that directory could have a program named `Program1`

### Subdirectories

- File managers create an MFD for each volume that can contain entries for both
	- Files
	- Subdirectories
- Subdirectory is created when user opens an account to access computer system
- Although user directory is treated like a file
	- Its entry in the MFD is flagged to indicate that the file is really a subdirectory
		- Has unique properties
		- Its records are filenames pointing to files
- Improvement from single directory scheme
- It doesn't solve problems encountered by users who wanted to group files in logical order
	- Improving accessibility and efficiency of system
- Today's file managers
	- Encourage users to create own subdirectories
		- Related files grouped together
- Structure
	- Extension of previous two level directory organization
	- Implemented as an upside down tree
	- Figure 8.4

![figure 8.4](http://snag.gy/GpEnd.jpg)

- Tree structure
	- Allow system to efficiently search individual directories
		- Fewer entries per directory
	- However path to requested file may lead through several directories
- For every file request
	- MFD is point of entry
	- MFD is transparent to user
		- Only accessible by OS
- When user wants to access specific file
	- Filename is sent to file manager
	- File manager first searches MFD for user's directory
	- Then searches user's directory and subdirectories

### File descriptor

- Information describing every file
- Includes
	- Filename
		- Must be unique within single directory
		- May be case sensitive
	- File type
		- Organization and usage that are dependent on the system
			- ie. Files, directories
	- File size
		- Could be computed from other information
		- Kept in descriptor for convenience
	- File location
		- Identification of first physical block where file is stored
			- Or all blocks
	- Date/time of creation
	- Owner
	- Protection information
		- Access restrictions
		- Based on
			- Who is allowed to access the file
	- Record size
		- Fixed or max size
		- Depends on type of record

### File naming conventions

- A file's name can be longer than it appears
- It can have from two to many components
- Common components
	- Relative filename
	- Extension
- Complete filename
	- Absolute filename
	- Includes all path information
- Relative filename
	- Name without path information
	- Appears in
		- Directory listings
		- Folders
	- Differentiates it from other files in same directory
	- Can vary in length from one to many characters
	- Can include letters and digits
	- Each OS have specific rules that affect
		- Length of relative filename
		- Types of characters allowed

#### Extensions

- Appended to relative filename
- Two/three characters long
- Separated by period `.`
- Identifies the type of file/contents
- Example
	- `Music.mp3`
- Incorrect/unknown extensions
	- OS asks for guidance from user
		- Figure 8.5

![figure 8.5](http://snag.gy/YCneA.jpg)

- Reserved extensions
	- May be reserved by OS
		- Example
			- `*.exe`
			- `*.bat`
			- `*.cob`
			- `*.for`
	- Serve as signal to system to use specific compiler/program to run files
- Different OS
	- Example
		- `inventory_cost.doc`
	- Windows
		- File's complete name is composed of
			- Relative name
			- Extension
			- Preceded by
				- Drive label
				- Directory name
		- `C:\imfst\flynn\inventory_cost.doc`
			- Requires word processing document
			- Can be found in
				- C drive
				- `imfst` root directory
				- `flynn` subdirectory
	- \*nix
		- `/usr/imfst/flynn/inventory_cost.doc`
		- `/` = root
		- Case sensitive

#### Home directory

- File manager selects directory for user when interactive sessions begin
- All file operations requested by user start from home/base directory
- Current/working directory
	- User selected subdirectory from home
	- Files presumed to be located in current directory
- When file is accessed
	- User types in relative name
	- File manager adds correct prefix
	- As long as users refer to files in working directory
		- They can access their files without entering complete name

## File organization

- Arrangement of records within a file
	- All files composed of records
- When user gives command to modify contents of file
	- It's actually a command to access records within the file

### Record format

- Within each file
	- All records are presumed to have same format
- Can be fixed or variable length
	- Figure 8.6
- Records can be blocked or not blocked
	- Regardless of format

![figure 8.6](http://snag.gy/24Adn.jpg)

#### Fixed length records

- Most common
- Easiest to access directly
- Ideal for data files
- Critical aspect
	- Size of record
		- If smaller than number of characters to be stored in record
			- Characters may be truncated
		- If larger than number of characters to be stored
			- Space wasted

#### Variable length records

- Don't leave empty storage space
- Don't truncate any characters
- Eliminates two disadvantages of fixed length records
- Can be easily read
- Difficult to access
	- Hard to calculate exactly where record is located
- Used frequently in files that use index to access records
- File descriptor
	- Record format
	- How it's blocked
	- Other information

### Physical file organization

- The way records are arranged
- Characteristics of medium used to store it

#### Magnetic disks/hard drives

- Files can be organized in one of several ways
	- Sequential
	- Direct
	- Indexed sequential
- To select best method
	- Designer must consider practical characteristics
		- Volatility of data
			- Frequency which additions/deletions occur
		- Activity of file
			- Percentage of records processed during given run
		- Size of file
		- Response time
			- Amount of time user is willing to wait before requested operation is complete
				- Crucial when doing time sensitive searches

#### Sequential record organization

- Easiest to implement
- Records stored/retrieved serially
	- One after another
- To find specific record
	- File is searched from beginning until requested record is found
- To speed up process
	- Some optimization features may be built into system
		- Select key field from record
		- Sort the records by that field before storing them
		- When user requests specific record
			- System searches only the key field of each record in file
			- Search ends when either
				- Record found
				- Key field for requested record is smaller than value of record last compared
					- Record not found
	- Complicates file maintenance
		- Original order must be preserved every time records are added/deleted
		- To preserve physical order
			- File must be completely rewritten/maintained in sorted fashion every time it's update

#### Direct record organization

- Direct access files
	- Only implementable on direct access storage devices
- Give users flexibility of accessing any record in any order
	- Without having to begin a search from beginning of file
- Known as
	- Random organization
- Files called
	- Random access files
- Record identification
	- Relative address
		- Address relative to beginning of file
	- Logical address
		- Computed when records are stored and retrieved
- Method
	- User identifies a field in the record format
	- Designates it as the **key field**
		- It uniquely identifies each record
	- Program used to store data follows instructions
		- **Hashing algorithm**
		- Transforms each key into a number
			- The record's logical address
	- Hash given to file manager
		- Takes necessary steps to translate logical address into physical address
			- Cylinder
			- Surface
			- Record number
		- Preserves file organization
	- Same process for retrieving record
- Direct access file can also be access sequentially
	- Start at first relative address
	- Move down each line
- Can be updated more quickly than sequential files
	- Records can be quickly rewritten to original address after modification
	- No need to preserve order of records
		- Adding/deleting takes little time

##### Issues with hashing

- Several records with unique keys may generate same hash
	- Same logical address
	- Collision
	- Figure 8.7

![figure 8.7](http://snag.gy/Gc3Bl.jpg)

- When collisions occur
	- Program must generate another logical address before sending to file manager for storage
- Collided records are stored in an overflow area that was set aside when file was created

##### Physical location

- Although program does all the work of linking records from the overflow area to corresponding logical address
	- File manager must handle physical allocation of space
- Max size of file is established when it's created
	- Either
		- File might become completely full
		- Number of records stored in overflow area might become so large that efficiency of retrieval is lost
			- File must be reorganized/rewritten
				- Requires intervention by file manager

#### Indexed sequential record organization

- Combines sequential and direct access
- Created and maintained through an indexed sequential access method (ISAM) application
	- Removes burden of handling overflows
	- Preserves record order
- Doesn't create collisions
	- Hash algorithm not used to generate record address
- Hash used to generate index file
	- Used to retrieve records
- Method
	- Divides an ordered sequential file into blocks of equal size
		- Size determined by file manager to
			- Take advantage of physical storage devices
			- Optimize retrieval strategies
	- Each entry in index file contains
		- Highest record key
		- Physical location of data block where record and records with smaller keys are stored
- To access any record in file
	- System searches index file
	- Then goes to physical location indicated at that entry
	- Index file acts like a pointer to data file
- Overflow area
	- Spread throughout the file
		- Example
			- Every few records
	- Expansion of existing records can take place
	- New records can be located in close physical sequence as well as logical sequence
- Overflow of last resort
	- Separate overflow from main data area
	- Only used when other overflow areas are completely filled
	- Can store records added during lifetime of file
	- Records kept in logical order by software without effort by programmer
	- When too many records have been added here
		- Retrieval process slows down
		- Search for record has to go from
			- Index
			- To main data area
			- To last resort overflow area
- When retrieval time is too slow
	- File has to be reorganized
	- Usually performed by maintenance software
- For most dynamic files
	- Indexed sequential is organization method of choice
	- Allows both direct access to few requested records
	- Sequential access to many

## Physical storage allocation

- File manager must work with files as whole units and logical units
- Records within a file must have same format
	- But can vary in length
	- Figure 8.8

![figure 8.8](http://snag.gy/G7i8M.jpg)

- Records are subdivided into fields
	- In most cases
		- Structure is managed by programs not OS
	- Exception
		- Systems heavily oriented to database programs
		- File manager handles field structure
- File storage = record storage
- File manager and device manager have to cooperate to ensure successful storage/retrieval of records

### Contiguous storage

- Records stored one after the other
	- Used by early OS
- Advantages
	- Simple to implement/manage
	- Any record can be found/read once starting address and size is known
		- Directory is streamlined
	- Ease of direct access
		- Every part of file is stored in same compact area
- Disadvantage
	- File can't be expanded unless there's empty space after it
		- Figure 8.9
	- Room for expansion must be provided when file is created
		- If not enough room
			- Entire file must be recopied to larger section of the disk every time records are added
		- Fragmentation
			- Slivers of unused storage space
			- Overcome by compacting and rearranging files
				- Files can't be accessed during compaction

![figure 8.9](http://snag.gy/vq4jt.jpg)

- File manager keeps track of free space by treating them as files
	- Entered in directory but flagged to differentiate from real files
- Directory usually kept in order by sector number
	- Adjacent empty areas can be combined into one large free space

### Non contiguous storage

- Allows files to use any storage space available on disk
- File's records stored in contiguous manner
	- Only if there's enough empty space
- Any remaining records and additions to file are stored in other sections of the disk
- In some systems, these are called the **extents** of the file
	- Linked together with pointers
- Physical size of each extent is determined by OS
	- Usually 256 bytes
		- Or some other power of two
- File extents linked in two ways
	- Storage level
	- Directory level

#### Storage level

- Each extent points to the next one in sequence
	- Figure 8.10
- Directory entry consists of
	- Filename
	- Location of first extent
	- Location of last extent
	- Total number of extents - 1

![figure 8.10](http://snag.gy/4gjqN.jpg)

#### Directory level

- Each extent is listed with
	- Physical address
	- Size
	- Pointer to next extent
	- Null pointer
		- Last extent
		- Indicated by `-`
	- Figure 8.11

![figure 8.11](http://snag.gy/nmoBF.jpg)

### Indexed storage

- Allows direct record access using pointers linking every extent of the file into an index block
- Every file has its own index block
	- Consists of addresses of each disk sector that make up the file
- The index lists each entry in same order in which sectors are linked
	- Figure 8.12
- Example
	- Third entry in index block corresponds to third sector making up the file
- File creation
	- Pointer in index block are all set to null
	- As each sector is filled
		- Pointer is set to appropriate sector address
			- Address is removed from empty space list
			- Copied into its position in index block
- Supports both sequential and direct access
	- Doesn't improve use of storage space
		- Each file must have an index block
		- Usually size of one disk sector
- For larger files with more entries
	- Several levels of indexes can be generated
	- To find desired record
		- File manager accesses first index
			- Highest level
		- Points to second index
			- Lower level
		- Points to lower level index
			- Eventually to data record

![figure 8.12](http://snag.gy/e3bWg.jpg)

## Access methods

- Directed by file's organization
	- Most flexibility is allowed with indexed sequential files
	- Least flexibility with sequential
- A file that has been organized in sequential fashion only supports sequential access to records
	- Records can be fixed or variable length
		- Figure 8.6
	- File manager uses address of last byte read to access next sequential record
- Therefore
	- **Current byte address (CBA)** must be updated every time a record is accessed
		- ie. READ command
- Figure 8.13 shows difference between storage of fixed length and variable length records

![figure 8.13](http://snag.gy/hbr9Q.jpg)

### Sequential access

#### Fixed length records

- CBA is updated by incrementing it by record length (RL)
	- Is constant

>CBA = CBA + RL

#### Variable length records

- File manager adds record length (RL) plus number of bytes used to hold record length N to CBA

>CBA = CBA + N + RL

### Direct access

#### Fixed length records

- CBA computed directly from record length (RL) and desired record number (RN) - 1

>CBA = (RN - 1) * RL

- Example
	- Looking for beginning of 11th record
	- Fixed record length = 25 bytes
	- CBA calculated as:

>(11 - 1) * 25 = 250

#### Variable length records

- Impossible to access record directly
	- Address of desired record can't be easily computed
- To access record
	- File manager must do sequential search through records
- It becomes a half sequential read through the file because file manager could save the address of the last record accessed
	- When next request arrives
		- Could search forward from last record or from start of file
			- Depending if request address is higher or lower than last recorded address
- Alternative
	- File manager keeps table of record numbers and CBAs
	- To fill request
		- Table is searched for exact storage location of desired record
			- Direct access reduced to table lookup
- To avoid dealing with this problem
	- OS force users to have files organized for fixed length records
		- If records are to be accessed directly

### Indexed sequential files

- Can be accessed either sequentially or directly
	- Either procedure to compute CBA can be applied
		- Plus one extra step
	- Index file must be searched for pointer to the block where data is stored
- Because index file is smaller than data file
	- It can be kept in memory
	- Quick search can be performed to locate block where desired record is located
	- Then the block can be retrieved from secondary storage
		- Beginning byte address of the record can be calculated
- In systems that support several levels of indexing to improve access to large files
	- Index at each level must be searched before computation of CBA can be done
- Entry point to this type of data file is usually through the index file

## Levels in a file management system

- Basic file system
	- Highest level
	- Passes information through
		- Access control verification module
		- To Logical filesystem
			- Who notifies physical file system
				- Which works with device manager
- Hierarchy shown in figure 8.14

![figure 8.14](http://snag.gy/TSiKQ.jpg)

- Each level of file management system is implemented using structured and modular programming techniques
	- Also set up hierarchy
	- High level modules
		- Pass information to lower modules
		- Perform required service
		- Continue communication down chain to lowest module
	- Lowest module
		- Communicates with physical device
		- Interacts with device manager
- Each module is subdivided into specific tasks
	- See example below

### Hierarchy example

- IO instruction
	- `READ RECORD NUMBER 7 FROM FILE CLASSES INTO STUDENT`
- `CLASSES` = direct access file opened for input
- `STUDENT` = data record defined within program
	- Occupies specific memory locations
- Because file has already been opened
	- Directory has already been searched to verify existence of `CLASSES`
	- Info of file has been brought into OS active file table
		- Info includes
			- Record size
			- Address of first physical record
			- Protection
			- Access information
			- See table 8.1

![table 8.1](http://snag.gy/M7DZY.jpg)

- This information is used by the basic filesystem
	- Activates access control verification module to verify that user is permitted to perform operation
- If access is allowed
	- Information and control is passed to logical filesystem
- If access not allowed
	- Error message shown to user
- Using the information passed from basic filesystem
	- Logical filesystem transforms the record number to its byte address

>CBA = (RN - 1) * RL

- This result together with address of first physical record and physical block size is passed down to the physical filesystem
	- Computes location where desired record physically resides
- If there's more than one record in that block
	- It computes offset within that block using formulas:

![block number and offset](http://snag.gy/CprgA.jpg)

- This information is passed to device interface module
	- Which transforms block number to actual cylinder/surface/record combination needed to retrieve the information from secondary storage
- Once retrieved
	- Device scheduling algorithm comes into play
	- Information is placed in a buffer and returns control to physical filesystem
		- Which copies the information into the desired memory location
- Finally
	- When operation is complete
	- All clear message is passed to other modules

#### WRITE

- Process is similar for
	- WRITE
- Except when reaching device handler
- The portion of the device that handles free space allocation is called
	- It is responsible for keeping track of unused areas in storage device

#### Verification

- Occurs at every level of file management system
- First verification
	- Occurs at directory level
	- When filesystem checks to see if requested file exists
- Second verification
	- Occurs when access control verification module determines whether access is allowed
- Third verification
	- Occurs when logical filesystem checks to see if requested byte address is within file's limits
- Final verification
	- Occurs when device interface module checks to see whether storage device exists
- Correct operation of simple user commands require coordinated effort of every part of file management system

## Access control verification module

- Early OS didn't support file sharing among users
- Example
	- Early OS needed 10 copies of compiler to serve 10 users
- Today's systems
	- Only require single copy to serve everyone
		- Regardless of number of active programs in system
	- Any file can be shared
		- Data files
		- User owned program files
		- System files
- Advantages of file sharing
	- Saves space
	- Allows synchronization of data updates
		- Two applications updating same file
	- Improves efficiency of resources
		- Reduces IO operations if shared file resides in memory
- Disadvantages of file sharing
	- Integrity of each file must be safeguarded
		- Must control
			- Who is allowed to access
			- What type of access is granted
- Five possible actions on files
	- Read only
	- Write only
	- Execute only
	- Delete only
	- Combination of four
- Each file management system has own method to control file access

### Access control matrix

- Appealing
- Easy to implement
- Small size
	- Only works well for systems with
		- Few files
		- Few users
- Each cell contains access rights for that user to that file
	- Table 8.2

![table 8.2](http://snag.gy/MxPov.jpg)

- In actual implementation
	- `RWED` is represented by binary
		- `0` = access denied
		- `1` = access granted
- Table 8.3
	- Code for user 2, file 1 would be
		- `1010`
		- Instead of `R-E-`

![table 8.3](http://snag.gy/nMfAU.jpg)

- Disadvantage
	- As number of files/users increase
		- Matrix becomes extremely large
			- Sometimes too large to store in memory
	- Wasted space
		- Many entries are null
			- Table 8.2

### Access control lists

- Modification of access control matrix
- Each file is entered in the list
	- Contains names of users who are
		- Allowed to access it
		- Type of access permitted
- To shorten list
	- Only those who have access are named
	- Users denied access are grouped under global heading `world`
		- See table 8.4

![table 8.4](http://snag.gy/iohAy.jpg)

- Some systems shorten the access control list even more
	- Place every user into categories
		- `system`
		- `owner`
		- `group`
		- `world`
- `system` / `admin`
	- Designated to users who have unlimited access to all files in system
- `owner`
	- Has absolute control over all files created in owner's account
	- `owner` may create a `group` file
		- All users belonging to group have access to it
- `world`
	- All other users in system
		- ie. Those who don't fall into any of other categories

### Capability list

- Shows access control information from different perspective
- Lists every user and files they have access to
	- Table 8.5

![table 8.5](http://snag.gy/LJ9wS.jpg)

### Comparison

- Most common used is access control list
- Capability lists gaining popularity
	- Used in \*nix OS
	- Control access to devices as well as files
- Subtle differences between methods
	- Capability list
		- Specific concert tickets made available only to individuals who appear on a guest list
	- Access control list
		- Reservation list in restaurant that has limited seating
		- Each seat assigned to specific individuals

## Data compression

- Two types
	- Lossless
		- Retain all data throughout compression
	- Lossy
		- Removes data permanently

### Text compression

- Three methods
	- Repeated characters
	- Repeated terms
	- Front end compression

#### Repeated characters

- Data in a fixed length fields might include a short name followed by many blank characters
- This can be replaced with a variable length field and special code to indicate how many blanks were truncated
- Example
	- String
		- `ADAMS`
	- Stored in fixed length field
		- `ADAMSbbbbbbbbbb`
			- `b` = blank char
	- Encoded
		- `ADAMSb10`
- Numbers with many zeros can be shorted with a code
	- `#`
	- Indicates how many zeros must be added to recreate original number
- Example
	- String
		- `300000000`
	- Encoded
		- `3#8`

#### Repeated terms

- Compressed using symbols to represent each of most commonly used words in database
- Example
	- University student database
	- Common words
		- `student`
		- `course`
		- `teacher`
		- `classroom`
	- Could be represented by single character
- System must be able to distinguish between compressed and uncompressed data

#### Front end compression

- Builds on repeated terms
	- Table 8.6
- Replaces commonly used terms with number
	- Indicates how many chars used from previous string

![table 8.6](http://snag.gy/z02gT.jpg)

#### Compression tradeoff

- Storage space gained
- Processing time lost

### Other compression schemes

- Lossy compression
	- Allows loss of data from original file
	- Significantly compresses file
- Compression is irreversible
	- Original file cannot be reconstructed
- Compression algorithms
	- Dependent on file being compressed
- JPEG
	- Still images
- MPEG
	- Video
- ISO
	- MPEG standards
	- International standards dealing with
		- Compression
		- Decompression
		- Processing
		- Coded representation of
			- Moving pictures
			- Audio
			- Combination

## Conclusion

- File manager
	- Controls every file in the system
	- Processes user commands
		- READ
		- WRITE
		- etc.
	- Interacts with any file in system
	- Manages access control procedures
		- Maintains
			- Integrity
			- Security
- Accommodates variety of
	- File organizations
	- Physical storage allocation schemes
	- Record types
	- Access methods
- File organization
	- Sequential
	- Direct
	- Indexed sequential
- File storage allocation
	- Contiguous
	- Non contiguous
	- Indexed
- Record length
	- Fixed
	- Variable
- Access control
	- Access control matrix
	- Access control lists
	- Capability lists
- Data compression
	- Repeated characters
	- Repeated terms
	- Front end compression
