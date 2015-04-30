# Operating system security

## What is an operating system?

- Provides the interface between the user and the computer hardware
- Manages how applications access resources
	- Hard disks
	- CPU
	- RAM
	- Input devices
	- Output devices
	- Network interfaces

## OS security concepts

- Identification, authentication, authorisation
- Separation and projection of objects
- Auditing
- Permissions and file system security

### Separation of objects

- An OS needs to stop objects from interfering with other objects
- In particular it needs to prevent one process from interfering with other processes
- Memory management is important
- Many memory management techniques have been used by operating systems

### Identification and authentication

- Passwords still heavily relied upon as a means of authentication
- Smartcards, tokens making some progress
- Consumer oriented biometric devices are becoming prominent for mobile computing devices

### Authorisation

- An operating system controls accesses to object within the system
- Objects might include
	- Files
	- Network shares
	- External drives and peripherals
	- Resources
		- Processor
		- Memory
		- etc.
- Different operating systems have different capabilities in controlling access to these resources

### Access control lists

- For every user there is a list of objects

![user objects](http://snag.gy/2M9H9.jpg)

- For each object the OS maintains a list of users and permissions

![permissions for object](http://snag.gy/FZFVy.jpg)

#### Access control matrices

- The OS maintains a table of subjects, objects and permissions

![access control matrix](http://snag.gy/laOQ6.jpg)

## Windows security architecture

- Local Security Authority (LSA)
- Security Reference Monitor (SRM)
- Security Accounts Manager (SAM)
- WinLogon and NetLogon
- Access Control Lists (ACL)
- User Account Controls (UAC)
- Security Identifier (SID)

### Local Security Authority (LSA)

- A process responsible for enforcing a local security policy
- Issues security tokens to accounts
- Key component of the logon process

![lsa in task manager](http://snag.gy/IkUB6.jpg)

### Security Reference Monitor (SRM)

- Determines if a process has the appropriate rights to perform an action

![srm model](http://snag.gy/8T06b.jpg)

### Security Accounts Manager (SAM)

- A database that stores user accounts and relevant security information about local users and groups
- Stores users' passwords in a hashed format

![sam database](http://snag.gy/H3XgF.jpg)

### Winlogon and NetLogon

- Winlogon.exe handles local logons
- NetLogon handles logons across the network
- Makes use of a Security Attention Sequence (SAS)
- The SAS is designed to make login spoofing difficult

![winlogon and netlogon](http://snag.gy/74bdQ.jpg)

### Security identifiers / users and groups

- User accoutns and groups are identified by a Security Identifier (SID)
- Users have individual accounts
- Users can be placed in groups
- There is a many-to-many relationship between users in groups
	- A group can have many users
	- A user may be in may groups

### Windows login process example

1. Administrator creates a user account with:
	1. Full name
	2. Username
	3. Password
	4. Group
	5. Privileges
2. Windows in turn creates a Security Identifier (SID) in the form of `S-1-5-21-AA-BB-CC-DD`
3. User initiates Security Attention Sequence (SAS)
4. User types in username and password
5. Local Security Authority (LSA) runs authentication package
6. User is authenticated locally or by a Domain Controller
7. Security Accounts Manager (SAM) returns a Security Identifier (SID) to the Local Security Authority (LSA)
8. Local Security Authority (LSA) creates an access token containing:
	- User's individual Security Identifier (SID)
	- User's group Security Identifier (SID)
	- Local system rights
9. Token is used to access objects via the Security Reference Monitor (SRM)

### Windows NT security architecture

![windows nt security architecture](http://snag.gy/hxJZm.jpg)

### Special accounts and groups

- Administrator account
	- Most powerful account
	- Often this account is not subject to account lock out if incorrect password is entered repeatedly
- Guest account
	- These days this account is typically disabled by default
	- Admins should check this to make sure that it is disabled
- Everyone group
	- Every user is automatically a member of this group
	- Newly created files may default to allowing access to the "everyone" group
	- Access to the "everyone" group should be removed if you want to limit access to a file

### User Account Control (UAC)

- Any task that has the potential to affect the integrity or security of the operatiung system will trigger the User Account Control
- UAC is used in Unix operating systems

![uac](http://snag.gy/O6Y33.jpg)

## File systems

- Legacy Windows OS used the **File Allocation Table** (FAT, FAT32)
- Contemporary Windows OS use **New Technology File System** (NTFS)
- From a security point of view NTFS is highly recommended
- NTFS offers the following advantages
	- Can use file permissions
	- Increased stability
	- Increased robustness
	- Fault tolerance

### NTFS security descriptors

- Each NTFS file has a security descriptor
	- Contains the Security token of the owner
- File also has an Access Control List (ACL)
- All file access must go through the Security Reference Monitor (SRM)
- The Security Reference Monitor (SRM) compares tokens of users to the file's Access Control List (ACL) and determines if access is allowed
	- There are rules that determine how to handle ambiguous situations
		- ie. If a user belongs to a group which has access to a file, but that particular user is specifically denied access to that file, the file access by that user should be denied

### NTFS stability

- NTFS writes all file system interactions as transactions
	- Which either fully complete or do not complete
	- Similar to SQL transaction
- NTFS keeps logs of transactions so that in the event of a crash, or power failure, the OS can go through the logs and undo any transactions that failed to complete and redo any necessary transactions
- This improves the fault tolerance of NTFS compared to FAT

### NTFS encryption

- NTFS users can also benefit from transparent encryption of files
- Encrypted Files System (EFS) exists as a layer on top of NTFS
- Files are encrypted and decrypted on-the-fly
- Doesn't provide protection if an attacker gets access to a machine that is logged in
- Does provide protection if a machine or disk is stolen after being logged out
- Recovery agent allows administrators to recover files if user's keys are lost

#### NTFS backdoors

- There were claims some time ago that someone had found some **NSA** keys referred to in a Windows patch
- Fears that MS and US government had cooperated to leave backdoors
- This was at the time, and remains a speculation

## Auditing

- Operating systems have auditing capabilities
- Administrators can audit and log many events
	- Successful and unsuccessful login attempts
	- Access to sensitive files
	- Modification of certain files
		- Particularly executable files
- Windows has an event viewer that can be used to monitor logs

![windows auditing](http://snag.gy/CEfVQ.jpg)

### Windows event logger

- Keeps track of
	- What processes are running
	- What other machines have interacted with the system via Internet
	- If the operating system has experienced any unexpected or suspicious behaviour
- Can leave important clues for troubleshooting
	- Can also determine the cause of security breach

![windows event logger](http://snag.gy/6ipM3.jpg)

### Over auditing

- Deciding what to audit is a difficult task
- Audit too little and you risk missing important events
- Audit too much and performance suffers
	- You may also miss important events due to it being masked in too many irrelevant log entries
- A balance is required
- Determining balance is not an easy task

## OS vulnerabilities

- Operating systems are complex pieces of software
- How many millions of lines of code in a modern OS?
- They **will** have
	- Design flaws
	- Implemnentation errors
	- Which lead to vulnerabilities
- Sound software engineering practices can help to improve the overall quality of systems
	- But we have to assume that these problems are not going to go away

### Comments on OS security

- Sometimes an OS can be limited by its need for backwards compatibility
	- ie. When Windows NT was released, it had a better way of hashing passwords than previous versions
	- However the old method was maintained in parallel with the new method so that the newer Windows NT could work with older versions of Windows
	- This lead to a vulnerability as the older passwords were generally easier to crack

### Applying OS security

- However, none of these operating systems are secure 'out-of-the-box'
	- Whether you are using Windows, Linux, MacOS security features must be put to use
	- Configuration and maintenance are vital
- Which is the most secure OS?
	- Which ever you can configure the best
	- It may well be that a well configured Windows system is more secure than a poorly configured Linux machine and vice versa

## Open source vs. commercial OS

![open vs commercial os 1](http://snag.gy/aBf63.jpg)

![open vs commercial os 2](http://snag.gy/nQGcj.jpg)

![open vs commercial os 3](http://snag.gy/Z1jZa.jpg)

## Virtual Machines (VM)

- Virtual machines allow an operating system to run without direct contact to the underlying hardware and operating system
- A VM allows you to test software, examine malware in a sandbox and test the stability of a system
- Any errors or identified threats can be rolled back through the VM hosting software

## Security standards for OS evaluation

- Numerous organisations create criteria for evaulating computer systems which are used to store and transfer sensitive information
- Trusted Computer System Evaluation Criteria (TCSEC)
- Common Criteria for Information Technology Security Evaluation Critera

### Trusted Computer System Evaluation Criteria (TCSEC)

- US Department of Defence standard formalised in 1985
- Orange book
- Used to determine how and for what purpose a computer system can be used in a Government organisation
- Focuses on the confidentiality of information

### TCSEC security criteria divisions

- D: Minimal protection
	- Has been certified/evaluated but does not meet any strict security requirements
- C: Discretionary protection
	- A system utilising discretionary access control
- B: Mandatory protection
	- A system utilising mandatory access control
- A: Verified protection
	- A system utilising formal verification of security

### Common Criteria

- Common Criteria is not a certification process but rather a framework for vendors to create security goals for their product and document how these goals have been ment
- In the US, Common Criteria has replaced TCSEC as a measure of evaluating the security of a computer system
