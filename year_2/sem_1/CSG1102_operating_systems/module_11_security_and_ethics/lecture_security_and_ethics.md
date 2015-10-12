# Security and ethics

## Objectives

- Role of OS in security
- Effect of system security practices on overall system performance
- Levels of system security that can be implemented
	- Threats posed by evolving tech
- Differences among
	- Viruses
	- Worms
	- Blended threats
- Role of education and ethical practices in security

## Role of OS in security

- Key role
	- OS level vulnerability opens entire system to attack
	- OS complexity and power increases
		- More vulnerable to attack
- Sys admin role
	- Provide OS with all available defenses against attack

## System survivability

- System's capability to fulfil mission
	- Timely manner
	- In presence of
		- Attacks
		- Failures
		- Accidents
- Survivable system's key properties
	- Attack resistance
	- Attack and resulting recognition
	- Essential services recovery after attack
	- System defense mechanisms adaptation and evolution
		- Mitigate future attacks

![table 11.1](http://snag.gy/8kqBP.jpg)

## Levels of protection

- Sys admin
	- Evaluate each computer configuration intrusion risk
		- Depends on connectivity level given to system

![table 11.2](http://snag.gy/U2RES.jpg)

## Backup and recovery

- Policies
	- Essential for most computing systems
- System manager
	- Uses layered backup schedule
- Backups
	- One set stored off site
		- Crucial for disaster recovery
- System management essential elements
	- Written policies and procedures
	- Regular user training

### Written security procedure recommendations

- Frequent password changes
- Reliable backup procedures
- Guidelines for loading new software
- Software license compliance
- Network safeguards
- Guidelines for monitoring network activity
- Terminal access rules

## Security breaches

- System security gaps
	- Malicious or not
- Intrusion classifications
	- Due to
		- Uneducated users
		- Unauthorized access to system resources
	- Purposeful disruption of system operation
	- Purely accidental
		- Hardware malfunctions
		- Undetected errors in OS/applications
		- Natural disaster
- Any security breach
	- Severely damages system credibility

### Unintentional intrusions

- Security breach or data modification
	- Not resulting from planned intrusion
- Examples
	- Accidental incomplete modification of data
		- Non synchronized processes access data records
		- Modify some record fields
	- Errors due to incorrect storage of data values
		- Field not large enough to hold numeric value stored

![figure 11.1](http://snag.gy/B0hS9.jpg)

### Intentional attacks

- Attack types
	- Intentional unauthorized access
		- Denial of service (DoS)
		- Browsing
		- Wire tapping
		- Repeated trials
		- Trap doors
		- Trash collection
	- Viruses/worms
	- Trojans
	- Bombs
	- Blended threats
- Malicious computer attacks
	- Possible state/federal law violation
- Convictions
	- Significant fines/jail terms
	- Computer equipment confiscation

#### Denial of service (DoS)

- Synchronized attempts denying service to authorized users
- Causing computer to perform repeated, unproductive task

#### Browsing

- Unauthorized users gain access to
	- Search through secondary storage directories
	- Files for information they should not have the privilege to read

#### Wire tapping

- Unauthorized users monitor/modify transmission
- Types
	- Passive
		- Monitor transmission
	- Active
		- Modify transmission

##### Passive wire tapping

- Monitor transmission
- Reasons
	- Copy data while bypassing authorization procedures
	- Collect specific information
		- Password

##### Active wire tapping

- Modify transmission
- Methods include
	- Between lines transmission
	- Piggyback entry

#### Repeated trials

- Enter system by guessing authentic passwords
- Brute force

![table 11.3](http://snag.gy/Jfk7j.jpg)

#### Trap doors

- Unspecified/undocumented system entry point
- Diagnostician or programmer installed
- System vulnerable to future intrusion

#### Trash collection

- Discarded materials
	- Disks
	- CDs
	- Printouts
- Used to enter system illegally

#### Viruses

- Small programs altering computer operations
	- No user permission to run
- Two criteria
	- Self executing
	- Self replicating
- Usually OS specific
- Spread using wide variety of applications

![figure 11.2](http://snag.gy/vBzF0.jpg)

##### Macro virus

- Attaches itself to template
	- ie. `NORMAL.DOT`
- Which in turn attaches to word processing documents

#### Worms

- Memory resident program
- Copies itself from one system to next
	- No aid from infected program file
- Slower processing time of real work
- Especially destructive on networks

#### Trojan

- Destructive program
	- Disguised as legitimate/harmless program
- Allows program creator secret access to system

#### Bombs

##### Logic bomb

- Destructive program with fuse
	- Triggering event
	- Keystroke or connected to Internet
- Spreads unnoticed throughout network

##### Time bomb

- Destructive program triggered by specific time
	- Day of the year

#### Blended threat

- Logic/time bomb characteristics combined
- Single program including
	- Virus
	- Worm
	- Trojan
	- Spyware
	- Other malicious code

##### Characteristics

- Harms affected system
- Spreads to other systems using multiple methods
- Attacks other systems for multiple points
- Propagates without human intervention
- Exploits vulnerabilities of target systems

##### Protection

- Combination of defenses with regular patch management

## System protection

- No single guaranteed method of protection
- System vulnerabilities
	- File downloads
	- Email exchange
	- Vulnerable firewalls
	- Improperly configured Internet connections
- Security issues required continuous attention
- Multifaceted system protection
- Protection methods
	- Anti virus software
	- Firewalls
	- Restrictive access
	- Encryption

### Anti virus software

- Combats viruses only
	- Preventive/diagnostic/both
	- Preventive
		- Calculate checksum for each production program
	- Diagnostic
		- Compare file sizes
		- Looks for
			- Replicating instructions
			- Unusual file activity
- Removes infection, leaves remainder intact
	- Usually
- Cannot repair
	- Worms
	- Trojans
	- Blended threats
	- Malicious code in entirety

![table 11.5](http://snag.gy/07sNh.jpg)

### Firewalls

- Set of hardware and/or software
	- Designated to protect system
	- Disguises IP address from unauthorized users
- Sits between Internet and network
- Blocks from outside system
	- Curious inquiries
	- Potentially dangerous intrusions
- Firewall mechanisms to perform tasks
	- Packet filtering
	- Proxy servers

![figure 11.5](http://snag.gy/gjGAE.jpg)

#### Typical firewall tasks

- Log activities accessing Internet
- Maintain access control
	- Based on sender/receiver IP address
	- Based on services requested
- Hide internal network from unauthorized users
- Verify virus protection installed/enforced
- Perform authentication
	- Based on source of a request from the Internet

#### Packet filtering

- Firewall reviews header information
	- Incoming/outgoing Internet packets
	- Verify
		- Source address
		- Destination address
		- Protocol authenticity

#### Proxy server

- Hides important network information from outsiders
	- Network server invisible
- Determines validity of network access request
- Invisible to users
- Critical to firewall success

### Authentication

- Verify authorization of individual accessing system

#### Kerberos

- Network authentication protocol
- Provides strong authentication for client/server applications
- Uses strong cryptography
- Requires systematic revocation of access rights from clients
	- Who no longer deserve access

![figure 11.6](http://snag.gy/SxowI.jpg)

### Encryption

- Extreme protection method
- Sensitive data put into secret code
- System communication
	- Data
		- Encrypted
		- Transmitted
		- Decrypted
		- Processed
- Sender inserts public key with message
- Receiver uses private key to decode message

#### Disadvantages

- Increased system overhead
- System dependent on encryption process itself

### Sniffers

- Programs on computers attached to network
- Peruse data packets as they pass by
- Examine each packet for specific information
- Particularly problematic in wireless networks

### Spoofing

- Assailant fakes IP address of Internet server
	- Changes address recorded in packets sent over Internet
- Unauthorized users disguise themselves as friendly sites

## Password management

- Basic techniques protect hardware/software
	- Good passwords
	- Careful user training

### Password construction

- Good password
	- Unusual
	- Memorable
	- Changed often
- Password files
	- Stored in encrypted form
- Password length
	- Directly affects ability of passwords to survive brute force attempts

![figure 11.8](http://snag.gy/BkPfl.jpg)

![table 11.6](http://snag.gy/MnJyL.jpg)

#### Good password techniques

- Use minimum 14 chars
	- Include
		- Numbers
		- Non alphanumeric chars
- Create variations of memorable sentences
- Use upper/lower if allowed

### Dictionary attack

- Method of breaking encrypted passwords
- Requirements
	- Copy of encrypted password file
	- Algorithm used to encrypt passwords
- Prevention
	- Salt
		- User passwords with extra random bits
	- Makes them less vulnerable to dictionary attacks

### Password alternatives

#### Smart cards

- Requires
	- Something you have
	- Something you know
- Displays constantly changing multidigit number
	- Synchronized with identical number generator in system
- User must enter number appearing on smarkt card
	- Added protection
		- User enters secret code
- User admitted to system if both number/code validated

#### Biometrics

- Science/tech of identifying individuals
	- Based on each person's unique biological characteristics
- Current research focus
	- Human face
	- Fingerprints
	- Hand measurements
	- Iris/retina
	- Voice prints
- Positively identifies person being scanned
- Critical factor
	- Reducing margin of error
- Expensive

#### Graphics/pattern clicks

- Evolving subject
- Establishes sequence of clicks on photo/illustration
	- Repeat sequence to gain access
- Advantages
	- Eliminates keyboard entries
		- Resistant to dictionary attack
- Disadvantages
	- Predictable input

![figure 11.9]()

## Social engineering

- Technique
- Intruder gains access to information about legitimate user
- Learn active passwords
	- Look in/around user's desk for written reminder
	- Try logon ID as password
	- Searching logon scripts
	- Telephoning friends/coworkers to learn information
		- Family member names
		- Pet names
		- Vacation destinations
		- Hobbies
		- Car model

### Phishing

- Intruder pretends to be legitimate entity
	- Asks unwary user to reconfirm information
		- Personal
		- Financial
- Example
	- 2003 Ebay customers

### Default passwords

- Pose unique vulnerabilities
	- Widely known
- Routinely shipped with hardware/software
- Routinely passed from one hacker to next
- Change immediately

## Ethics

### Ethical behavior

- Be good, do good
- IEEE and ACM issued standard of ethics in 1992
- Apparent lack of computing ethics
	- Significant departure from other professions

### Consequences of ethical lapses

- Illegally copied software
	- Lawsuits
	- Fines
- Plagiarism
	- Illegal
	- Punishable by law
- Eavesdropping communications
	- Sometimes illegal
	- Usually unwarranted
- Cracking
	- Malicious hacking
		- Owner/users question validity of system data
- Unethical use of technology
	- Clearly the wrong thing to do

### Activities to teach ethics

- Public policies clearly stating actions tolerated
- Teach regular seminar including real life case histories
- Conduct open discussion of ethical questions

## Summary

- Emphasize importance of secure system
- System only as good as integrity of stored data
	- Single security breach damages integrity
		- Catastrophic or not
		- Accidental or not
	- Damaged integrity threatens viability of
		- Best designed system
		- Managers
		- Designers
		- Users
- Vigilant security precautions are essential
