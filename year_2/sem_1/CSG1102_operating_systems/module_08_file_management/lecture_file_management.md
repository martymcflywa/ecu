# File management

## Objectives

- Fundamentals of file management
	- Structure of file management system
- File naming conventions
	- Role of extensions
- Difference between fixed length/variable length record format
- Advantages/disadvantages of file storage techniques
	- Contiguous
	- Non contiguous
	- Indexed
- Comparisons of sequential and direct file access
- Access control techniques and how they compare
- Role of data compression in file storage

# File manager

## File management system

- Software
- File access responsibilities
	- Creating
	- Deleting
	- Modifying
	- Controlling
- Support for libraries of programs
	- Online users
		- Spooling operations
		- Interactive computing
- Collaborates with device manager

## Four tasks

- File storage tracking
- Policy implementation
	- Determine where and how files are stored
	- Efficiently use available storage space
	- Provide efficient file access
- File allocation if user access cleared
	- Record file use
- File deallocation
	- File returned to storage
	- Communicate file availability

## Responsibilities

- Policy determines
	- File storage location
	- System and user access
		- Uses device independent commands
- Access to material
	- Two factors

### Factor 1

- Flexibility of access to information
- Shared files
- Providing distributed access
- Allowing users to browse public directories

### Factor 2

- Subsequent protection
- Prevent system malfunctions
- Security checks
	- Account numbers and passwords

### File allocation

- Activate secondary storage device
- Load file into memory
- Update records

### File deallocation

- Update file tables
- Rewrite file
	- If revised
- Notify waiting processes of file availability

## Definitions

![figure 8.1](http://snag.gy/oqg6B.jpg)

### Field

- Group of related bytes
- Identified by user
	- Name
	- Type
	- Size

### Record

- Group of related fields

### File

- Group of related records
- Information used by specific application programs
	- Report generation
- Flat file
	- No connections to other files
	- No dimensionality

### Databases

- Groups of related files
- Interconnected at various levels
	- Gives users flexibility of access to stored data

### Program files

- Contains instructions

### Directories

- Listings of file names and their attributes

## Interacting with the file manager

- User commands
	- `OPEN`
	- `DELETE`
	- `RENAME`
	- `COPY`

![figure 8.2](http://snag.gy/nNk92.jpg)

### Device independent

- Physical location knowledge not needed
	- Cylinder
	- Surface
	- Sector
- Device medium knowledge not needed
	- Tape
	- Magnetic disk
	- Optical disk
	- Flash storage
- Network knowledge not needed

### Logical commands

- Broken into lower level signals
- **Example: `READ`**
	- Move read/write heads to record cylinder
	- Wait for rotational delay
		- Sector containing record passes under read/write head
	- Activate appropriate read/write head and read record
	- Transfer record to main memory
	- Send flag indicating free device for another request
- Performs error checking and correction
	- No need for error checking code in programs

## Typical volume configuration

### Volume

- Secondary storage unit
	- Removable
	- Non removable
- Multi-file volume
	- Contains many files
- Multi-volume files
	- Extremely large files spread across several volumes

### Volume name

- File manager manages
- Easily accessible
	- Innermost part of CD
	- Beginning of tape
	- First sector of outermost track

![figure 8.3](http://snag.gy/vJ53L.jpg)

### Master file directory (MFD)

- Stored immediately after volume descriptor
- Lists
	- Names/characteristics of every file in volume
		- File names
			- Program files
			- Data files
			- System files
	- Subdirectories
		- If supported by file manager
	- Remainder of volume
		- Used for file storage

#### Single directory per volume

- Supported by early operating systems
- Disadvantages
	- Long search time for individual file
	- Directory space filled before disk storage space filled
	- Users cannot create subdirectories
	- Users cannot safeguard their files
	- Each program needs unique name
		- Even those serving many users

# Introducing subdirectories

## File managers

- Create MFD for each volume
	- Contains file and subdirectory entries
- Improvement over single directory scheme
	- Problems remain
		- Unable to logically group files

## Subdirectory

- Created upon account opening
- Treated as file
	- Flagged in MFD as subdirectory
	- Unique properties

## File managers today

- Users create own subdirectories
	- Folders
	- Related files grouped together
- Implemented as upside down tree
	- Efficient system searching of individual directories
	- May require several directories to reach file

![figure 8.4](http://snag.gy/LQGK7.jpg)

## File descriptor

- Filename
	- ASCII code
- File type
	- Organization and usage
	- System dependent
- File size
	- For convenience
- File location
	- First physical block identification
- Date/time of creation
- Owner
- Protection information
	- Access restrictions
- Record size
	- Fixed size
	- Max size

# File naming conventions

- Filename components
	- Relative filename and extension

## Complete filename

- Absolute filename
- Includes all path information

## Relative filename

- Name without path information
- Appears in directory listings/folders
- Provides filename differentiation within directory
- Varies in length
	- One to many characters
	- OS specific

## Extensions

- Append to relative filename
	- Two to three characters
	- Separated by period
	- Identifies file type or contents
- Example
	- `BASIA_TUNE.MP3`
- Unknown extension
	- Requires user intervention

![figure 8.5](http://snag.gy/j5VF0.jpg)

## OS specifics

### Windows

- Drive label
- Directory name
- Relative name
- Extension

```
C:\Users\marty\My Documents\Sample.txt
```

### UNIX/Linux

- Forward slash
	- Root
- First subdirectory
- Subdirectory
- Relative name
- Extension

```
/home/marty/Documents/Sample.txt
```

# File organization

- Arrangement of records within files
- All files composed of records
- Modify command
	- Request to access record within a file

## Record format

![figure 8.6](http://snag.gy/8B5U7.jpg)

### Fixed length records

- Direct access
	- Easy
- Record size critical
- Ideal for data files

### Variable length records

- Direct access
	- Difficult
- No empty storage space and no character truncation
- File descriptor stores record format
- Used with files accessed sequentially
	- Text files
	- Program files
- Used with files using index to access records

# Physical file organization

- Describes
	- Record arrangement
	- Medium characteristics
- Magnetic disks file organization
	- Sequential
	- Direct
	- Indexed sequential
- File organization scheme selection considerations
	- Volatility of data
	- Activity of file
	- Size of file
	- Response time

## Sequential record organization

- Records stored and retrieved serially
	- One after the other
- Easiest to implement
- File search
	- Beginning until record found
- Optimization features may be built into system
	- Select key field from record and sort before storage
	- Complicates maintenance algorithms
	- Preserve original order when records
		- Added
		- Deleted

## Direct record organization

- Uses direct access files
- Direct access storage device implementation
	- Random organization
	- Random access files
- **Relative address** record identification
	- Known as **logical addresses**
	- Computed when records
		- Stored
		- Retrieved
- Uses **hashing algorithms** to transform a **key field**

### Advantages

- Fast record access
- Sequential access if starting at first relative address
	- And incrementing to next record
- Updated more quickly than sequential files
- No preservation of records order
- Adding/deleting records is quick

### Disadvantages

- Hashing algorithm collision
	- Similar keys

![figure 8.7](http://snag.gy/nfxXU.jpg)

## Indexed sequential record organization

- Best of sequential and direct access
- ISAM software
	- Creates
	- Maintains
- Generates index file for record retrieval
- Divides ordered sequential file into equal sized blocks
- Each entry in index file contains
	- Highest record key
	- Physical data block location
- Search index file
- Overflow areas

### Advantages

- No collisions
	- No hashing algorithm

# Physical storage allocation

- File manager words with files
	- As whole units
	- As logical units or records
- Within file
	- Records must have same format
	- Record length may vary
- Records subdivided into fields
- Application programs manage record structure
- File storage
	- Refers to record storage

![figure 8.8](http://snag.gy/zKfzi.jpg)

## Contiguous storage

- Records storage one after another
- **Advantages**
	- Any record can be found once these are known
		- Starting address
		- Size
	- Easy direct access
- **Disadvantages**
	- Difficult file expansion
	- Fragmentation

![figure 8.9](http://snag.gy/YyLH4.jpg)

## Non contiguous storage

- Files use any available disk storage space
- File records stored in contiguous manner
	- If enough empty space
- Remaining file records and additions
	- Stored in other disk sections
		- Extents

### Extents

- Linked together with pointers
- Physical size determined by OS
- Usually 256 bytes

### Linking extents

- Linked in two ways
	- Storage level
	- Directory level

#### Storage level

- Each extent points to next one in sequence
- Directory entry
	- Filename and storage of first extent
	- Location of last extent
	- Total number of extents
		- Not counting first

![figure 8.10](http://snag.gy/QHQuf.jpg)

#### Directory level

- Each extent listed with
	- Physical address
	- Size
	- Pointer to next extent
- Null pointer indicates last one

![figure 8.11](http://snag.gy/oFYgN.jpg)

### Advantages

- Eliminates external storage fragmentation
- Eliminates need for compaction

### Disadvantages

- No direct access
	- Cannot determine specific record's exact location

## Indexed storage

- Allows direct record access
	- Brings pointers together
	- Links every extent file into index block
- Every file has own index block
	- Disk sector addresses for file
	- Lists entry in order that sectors are linked
- Supports sequential and direct access
- Does not necessarily improve storage space use
- Larger files experience several index levels

![figure 8.12](http://snag.gy/aNNjI.jpg)

# Access methods

- Dictated by a file organization
- Most flexible
	- Indexed sequential files
- Least flexible
	- Sequential files
- Sequential file organization
	- Supports only sequential access
		- Records
			- Fixed or variable length
- Access next sequential record
	- Use address of last byte read
- **Current byte address (CBA)**
	- Updated every time record accessed

![figure 8.13](http://snag.gy/C3yd2.jpg)

## Sequential access

- Update current byte address (CBA)
- Fixed length records
	- Increment CBA
	- >CBA = CBA + record length (RL)
- Variable length records
	- Add record length (RL) plus number of bytes used to hold record to CBA
	- >CBA = CBA + N + RL

## Direct access

- Fixed length records
	- Record number (RN), the desired record number
	- >CBA = (RN - 1) * RL
- Variable length records
	- Virtually impossible
		- Address of desired record cannot be easily computed
	- Requires sequential search through records
	- Keep table of record numbers and CBAs
- Indexed sequential file
	- Accessed sequentially or directly
	- Index file searched for pointer to data block

# Levels in a file management system

![figure 8.14](http://snag.gy/MA8Oi.jpg)

- Level implementation
	- Structured and modular programming techniques
	- Hierarchical
		- Highest module passes information to lower module
- Modules further subdivided
	- More specific tasks
- Uses information of basic file system
	- Logical file system transforms record number to byte address

## Verification at every level

- Directory level
	- File system checks if requested file exists
- Access control verification module
	- Determines whether access is allowed
- Logical file system
	- Checks if requested byte address within file limits
- Device interface module
	- Checks if storage device exists

## Access control verification module

- File sharing
	- Data files
	- User owned program files
	- System files
- Advantages
	- Save space
	- Synchronized updates
	- Resource efficiency
- Disadvantage
	- Need to protect file integrity
- Five possible file actions
	- READ only
	- WRITE only
	- EXECUTE only
	- DELETE only
	- combination
- Four methods

## Access control matrix

- Advantages
	- Easy to implement
	- Works well in system with few
		- Files
		- Users
- Disadvantages
	- As file and user increase
		- Matrix increases
		- Possibly beyond memory capacity
	- Wasted space
		- Due to null entries

![table 8.2](http://snag.gy/p5ZCY.jpg)

![table 8.3](http://snag.gy/LUKXd.jpg)

## Access control lists

- Modification of access control matrix
- Contains user names granted file access
	- User denied access grouped under "WORLD"
- Shortened list by categorizing users
	- SYSTEM
		- Personnel with unlimited access to all files
	- OWNER
		- Absolute control over all files created in own account
	- GROUP
		- All users belonging to appropriate group have access
	- WORLD
		- All other users in system

![table 8.4](http://snag.gy/Bz7kw.jpg)

## Capability lists

- Lists every user and files each has access to
- Can control access to devices as well as to files
- Most common

![table 8.5](http://snag.gy/xLGBu.jpg)

# Data compression

- A technique used to save space in files
- Text decompression
- Other decompression schemes

## Text compression

- Records with repeated characters
	- Repeated chars are replaced with a code
- Repeated terms
	- Compressed using symbols to represent most commonly used words
	- University student database common words
		- Student
		- Course
		- Grade
		- Department
	- Each can be represented with a single char
- Front end compression
	- Entry takes given number of characters from previous entry that they have in common

## Other compression schemes

- Video and music
	- ISO MPEG standards
- Photographs
	- JPEG
	- PNG
- ISO
	- International organization for standardization

# Summary

- File manager
	- Controls every file and processes user commands
	- Manages access control procedures
		- Maintain file integrity and security
	- File organizations
		- Sequential
		- Direct
		- Indexed sequential
	- Physical storage allocation schemes
		- Contiguous
		- Non contiguous
		- Indexed
	- Record types
		- Fixed length
		- Variable length
	- Four access methods
