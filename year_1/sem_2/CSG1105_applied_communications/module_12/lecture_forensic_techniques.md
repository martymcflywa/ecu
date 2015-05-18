# Forensic techniques

## CSIRT

- Computer Security Incident Response Team (CSIRT)
	- Groups of individuals who
		- Detect
		- Investigate
		- Solve
		- Document
	- Computer security incidents
- Incident response process
	- Involves seven steps

### 1: Pre-incident preparation

- Many tasks must be completed
	- Before first incident is ever reported

### 2: Detection of incident

- Requires routinely and timely examination of
	- Logs
	- Security alerts
	- IDS event logs
- Provides mechanisms for users to report incidents
- Identifies who should be informed
	- How should they be informed
- Provides timely incident reporting
	- Important as detecting the incident
- Involves gathering necessary information items

### 3: Initial response to the incident

- Quick problem examination
	- Gather information to support response strategy formulation
- Consult individuals
- Determine incident severity

### 4: Formulate a response strategy

- Based on information from initial response
- Take into account:
	- Legal and ethical issues
	- Financial considerations
	- Skills required

### 5: Investigate the incident

- Purpose
	- Answer various questions
- Gather additional information
	- Deleted files
	- Unallocated disk space
	- Decrypted files
	- Email
	- Browser history
- Evidence from
	- Live systems
	- Network traffic
	- All running processes on affected systems

### 6: Report the findings

- Develop a detailed incident report
	- Benefits people not directly involved
		- Law enforcement
	- Useful learning tool
		- Future resource for similar problem

### 7: Resolve the incident

- Repair the damage
- Prevent same incident type from occuring again
	- Make necessary changes

## Digital evidence handling

- `copy c:\*.* /s d:` command not acceptable
	- Does not copy every hard disk sector
- Forensice hard disk copy required
- Bit by bit duplicating including
	- Boot sector
	- Partition table
	- All partitions
	- Hidden files
	- Bad sectors
	- Unallocated space
- Software and hardware tools available to
	- Make forensic copies
	- Generate MD5, SHA1 hashes
- Use in conjunction with a write-blocker
	- Prevents evidence tampering

![digital evidence handling](http://snag.gy/113b6.jpg)

## File systems and operating systems

- Forensice examination requires familiarity with
	- Different file systems structure and operation
	- Operating systems

### FAT

- File Allocation Table (FAT) very common
- Understanding use in floppy disks extends to hard disks

#### FAT Floppy disk

- Floppy disk information stored in blocks called sectors
	- Sector contains 512 bytes of data
		- Normally
	- Sectors arraged in groups on track

![FAT floppy disk sectors](http://snag.gy/bLP5D.jpg)

- Formatted floppy disk information
	- Boot sector
	- FAT sectors
	- Directory sectors
	- Data area
- FAT stores files in dynamic chains of clusters
- Advantage
	- No need for consecutive file clusters
- Disadvantage
	- Fragmentation
- Cluster numbers keep FAT small and manageable
	- Can result in wasted space

#### FAT Hard disk

- Hard disk organisation
	- Three dimensional
	- Disk geometry
		- Number of sectors
		- Heads
		- Cylinders

![FAT hard disk organisation](http://snag.gy/ef9xn.jpg)

- Several FAT versions exist
	- Operation always the same
- Cannot recover files stored in a damaged FAT area

### NTFS

- Created by Microsoft in 1993
- Contains features not found in FAT
- Maintains a Master File Table
	- Stores metadata about every file on the volume
- Structure more complicated than FAT
	- Requires around 10MB for an **empty** file system
- Uses **B+ trees** for  more efficient file management

### Operating systems

- Provide the platform for computer hardware
	- Made available to software applications
- Modern operating systems more complex than early offerings
- Forensic examiner must understand the operating system's inner workings and its structures and activities
	- Helps determine where to look for information and evidence

![block diagram of modern os](http://snag.gy/uONLH.jpg)

#### Major sections

- Process management
- Memory management
- I/O management
- User management
- Resource management

#### Kernel (System Executive)

- Ties everything together
	- Maintains control over areas
- Of great interet to malware coders

## Live and static analysis

### Static analysis

- Performed on a
	- CD
	- DVD
	- Thumb drive
	- Hard disk

### Live analysis

- Performed on a system powered on and running
- Can examine many more items than static analysis
- Requires tools and external storage device
	- Keep track of
		- Tools
		- Commands
		- Evidence
		- Date
		- Time
- Data collection tools
	- Look at specific data structures within the operating system

## Finding digital evidence

- Unallocated disk clusters
	- Eventually allocated and data overwritten
		- Create entries in FAT or Master File Table making cluster appear assigned to a file
- Bad clusters
	- Trick allowing malicious code to hide itself
		- Write data to unused cluster
		- Mark cluster as bad
			- Guarantees never used
- Slack space
	- Part of unused cluster containing data
- Use free utilities
	- `Strings.exe` reports on all ASCII strings in a file
- Windows computers and \*NIX systems
	- Have many files of interest to examine
- Programs available to automatically extract clues and information

## Network traffic

- Make sure you have permission
- WireShark displays basic information about captured packets
- Investigating unrecognized IP addresses or domain names
	- WireShark has **Follow TCP Stream** tool
- Other useful information
	- IP address list and/or domain names that the host system communicates with
	- Ports used during communication sessions

## Malware analysis

- Requires several different skills and patience

### Encrypted script 1

- MySpace look-alike web page collecting usernames and passwords and spreading malware
- Captured packets contained long strings of ASCII codes
	- Decoding discovered JavaScript with strange string
	- Contained URL pointing to site in Hong Kong
	- Ultimately downloaded malicious code

### Encrypted script 2

- College website hacked with pornographic images
- Faculty member used WireShark Follow TCP Stream feature and found suspicious JavaScript
	- Modified JavaScript to throw additional characters into decoded stream
	- Prevented valid script from emerging when decoded
	- Determined script was redirecting browsers college home page to `av-online-test.com` website
	- Whois identifed owner
- Lesson:
	- Install all in timely manner
		- Patches
		- Hotfixes
		- Security updates

### Making the code harmless

- Professor provided malware program inside a password encrypted zip file on college web server
- IT discovered malicious code and deleted it
- Professor provided another interesting way to load file for teaching purposes
	- Cripple new piece of malware to make it harmless
	- Convert crippled malware program into file containing plaintext encryption of malware program
	- Write decryption program converting plaintext encrypted file back into crippled malware program

## Legal and ethical issues

- Associated with computing, communication and forensics
	- Go beyond maintaining chain of custody
		- Examples
			- Honeypots
			- Email
- No rigid standard for computer ethics
	- Strive to **do the right thing**
- Organisations typically post their own rules governing ethical behaviour
	- Example
		- Association for Computing Machinery
- Laws provide guidelines for computer and information-related crime prosecution

## Forensic marketplace

- Attend a forensices conference
	- Businesses offer forensics hardware, software and services
	- Introduces emerging topics
	- Expands contacts
		- Provides valuable advice
	- Training available
- Conferences specializing in forensics and security
	- Techno Security
	- SANS
	- Educause
	- ADFSL Conference on Digital Forensics, Security and Law
- Become a member of a forensic listserv

## Troubleshooting techniques

- Power outage cripples computer
	- Reboot produced "Missing Operating System" boot from floppy
		- `C:\ = Invalid drive`
	- Use external USB-IDE interface to see if hard disk recognizable failed
	- Moving hard drive jumpers failed
	- Internet disk recovery software failed
	- Local computer repair shop could not recover fles
	- Company specializing in data recovery
		- High costs and days to recover
- Lessons learned
	- Purchase a UPS
	- Back up using three-fold process
	- Save work frequently
		- Save work to USB drive
		- Upload copy of work protected website
		- Email copy of work
	- Periodically copy files to a CD or DVD
	- Print a copy for scanning if necessary
