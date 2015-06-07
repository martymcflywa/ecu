# Exam information

- The following information is designed to help you in identifying the key areas that were covered throughout the semester
- The comments in **bold** are designed to further assist you with your revision and what you could potentially expect to see in the exam

## CSI1101 exam

- Must make at least 50% to pass unit
- Not allowed
	- Textbook
	- Notes
	- Calculator

### Section A

- Worth 10 marks
- 20 True/False questions
	- Half mark each
- Clearly write true or false in answer booklet

### Section B

- Worth 40 marks
- 8 short answer questions
	- Worth 4 marks
	- Half page max for each question
- 1 attack tree question
	- Worth 8 marks

### Answering questions

- Can be answered by
	- Sentences / paragraphs
- Diagrams
- Bullet points / list of key points
- Tables
	- Good for comparing two or more concepts
- Do not waffle
	- Get to the point

## Study notes

- Read all lecture notes
- Complete all tutorial activities
	- Some exam questions come directly from the tutorial activities
	- Should know ins and outs of the software used throughout the semester
- Read appropriate chapters in textbook
- Read additional readings found on Blackboard

## Module 1: Introduction and aims of security

- Examples of computer security breaches

- **Provide examples of significant historic and contemporary computer security breaches/attacks**
- **What happened?**
- **What was exploited?**
- **What was the outcome?**
- **What where the resultant consequences?**
- Aims of security
	- Confidentiality
	- Availability
	- Integrity
	- Authenticity
	- Non-repudiation / accountability
- **Definition of each aim**
- **Provide real world examples**
	- **How to ensure it**
	- **How it can be breached**

### Answers

- **Provide examples of significant historic and contemporary computer security breaches/attacks**

#### Sony Pictures Entertainment (Nov, 2014)

- **What happened?**
	- SOE hacked by #GoP
	- Confidentiality attacked
	- Leaked
		- Employee personal details, ie.
			- Social security numbers
			- Emails
		- Unreleased movies
		- Server IP, passwords
- **What was exploited?**
	- 0-day vulnerability
		- Reports do not specify vulnerable software targetted in attack
	- Reports indicate that malware used is commercially available through tor site/s
- **What was the outcome / resultant consequences**
	- Caused Sony loss in revenue via leaked unreleased movies
		- Even canceled theatrical release of a movie due to threats of physical harm by hacking group
	- Embarrassment via leaked emails
		- Discussing actors/actresses in negative manner
		- Racism towards Barack Obama
		- Exposing behind the scenes politics
	- Exposure of security flaws
		- ie. Leaked passwords demonstrate weakness in security enforcement
			- ie. sony12345
	- General accusation against North Korea, although unproven
		- Other theories suggest that attack was inside job

#### iCloud celebrity photo hack (Aug, 2014)

- **What happened?**
	- Nude photos of mostly female celebrities leaked online
	- Obtained through hacking of iCloud
		- Via online backup, or photostream
- **What was exploited?**
	- Apple claim that attacks used account information rather than vulnerability in their service
		- Reports believe that account passwords may have been bruteforce attacked
			- Apple also believes this method was used, although only admitted this between the lines of their report
			- Unlimited login attempts would then be a vulnerability of their service
- **What was the outcome?**
	- Embarrassment of victims
	- Distrust of Apple services
- **What where the resultant consequences?**
	- Apple limited number of unsuccessful login attempts to iCloud after hack
	- Apple increased notifications:
		- Notifies users when
			- Password changed
			- Data restored to device not already associated with account
			- Login to account through unrecognized device
	- Increased use of two-factor authentication

#### Aims of security

- Confidentiality
	- Definition
		- Ensures information / systems should only be read / accessed by authorised people
		- Information kept private, secret and out of hands of authorised people
	- How to ensure it
		- Encryption
		- Access control
			- Rules / policies that limit access to people / systems on need to know basis
	- How it can be breached
		- Medical records disclosed to public
		- Nude photos leaked
- Integrity
	- Definition
		- Ensures information / systems have not been altered in an unauthorised way
		- Ensure information / systems not tampered
	- How to ensure it
		- Regular backups
		- Checksums
		- Data correcting codes
	- How it can be breached
		- Corrupted hard disk
		- Employee makes unauthorised changes to values in database
		- Untrustworthy / unreliable backups
- Availability
	- Definition
		- Ensures information / systems are accessible / modifiable in timely fashion by actors authorised to do so
	- How to ensure it
		- Access control
		- Computational redundancies
			- RAID
		- Physical protection mechanisms
	- How it can be breached
		- Website flooded by fake requests, unable to provide services to legitimate users
		- Employee turns off / unplugs critical server
		- Disk malfunction
		- Ethernet cable disconnected
- Authenticity
	- Definition
		- Ensures that an actor is able to prove / verify identity
	- How to ensure it
		- Digital signatures
		- Checksum
	- How it can be breached
		- Spear phishing
		- URL obfuscation
- Non-repudiation / accountability
	- Definition
		- Ensures actors cannot falsely deny actions
	- How to ensure it
		- Digital signatures
		- Digital certificates
	- How it can be breached
		- Spoof email address
		- Spoof IP

## Module 2: Risks, threats and threat agents

- **How would you convince someone to purchase, apply and use security?**
- **What is a threat?**
- **What is a vulnerability?**
- **What is a risk?**
- **What is risk a measure of?**
- **What is the link between a threat and vulnerability?**
- Types of risks: real vs. perceived
- **Generic threats: definitions and examples**
	- Interception/disclosure
	- Modification
	- Fabrication
	- Interruption
- Define/examples of specific threats
	- Social engineering
	- Information warfare
	- etc.
- How can we model attacks?

### Answers

- **How would you convince someone to purchase, apply and use security?**
	- Determine which assets are vulnerable
	- Explain
		- Threats that can exploit vulnerabilities in assets
		- Methods to mitigate vulnerabilities
- **What is a threat?**
	- A possible danger
	- Any possibility which if eventuates, will cause some degree of harm
	- An act designed to obtain a negative response
- **What is a vulnerability?**
	- Flaw / weakness of a system in
		- Design
		- Implementation
		- Operation
	- How open something is to an attack
	- Possibility of being attacked or harmed
- **What is a risk?**
	- Potential harm that may arise from current process or future event
- **What is risk a measure of?**
	- Likelihood of occurrence of vulnerability `*` value of asset `-` % of risk mitigated by current controls `+` uncertainty of current knowledge of vulnerability
- **What is the link between a threat and vulnerability?**
	- Threats act on or exploit vulnerabilities

## Module 3: Malware

- What is malware?
- Types
	- Virus
	- Trojan horse
	- Worm
	- Rootkit
	- Botnet
	- Logic bomb
	- Spyware
	- Adware
	- Scareware
	- Ransomware
- Differences between the types
- Potential problems of each type of malware
- Future of malware...
- **3 characteristics of each malware types**
- **Key differences between each malware type**

### Answers

#### Malware types

- Virus
	- 3 characteristics
		- Software that can infect other programs by modifying them
		- Attaches itself to another program and secretly executes when host program is executed
		- Requires user assistance
	- Key differences
		-
- Trojan horse
	- 3 characteristics
		- Appears to perform useful task, but also performs negative task
		- Can be resultant payload, or own program
			- Payload can open backdoor
	- Key differences
- Worm
	- 3 characteristics
		- Spreads without needing to attach itself into other files or human intervention
		- Can contain malicious payloads like
			- Delete file/s
			- Create backdoor
		- Spread by exploiting vulnerabilities / poorly configured systems
	- Key differences
		- Propagates by scanning targets on network
			- Locate target with vulnerability that worm can exploit
		- Once established on new host, repeats process
- Rootkit
	- 3 characteristics
		- Stealth program designed to hide the fact that an operating system has been compromised
		- Typically encompasses
			- Concealment
			- Command and control
			- Surveillance
	- Key differences
- Botnet
	- 3 characteristics
		- Collection of compromised computers
			- Installed malware
		- Master controls each of compromised computers over Internet
			- Zombies
	- Key differences
		- System of botnets being commercially sold to
			- Send spam / phishing emails
			- Launch DDoS
			- Break crypto
			- Launch additional malware
			- Mine bitcoin
- Logic bomb
	- 3 characteristics
		- Performs malicious action once logic condition is satisfied
		- ie. Programmer adds code to payroll software that makes the program crash if the program ever processes two consecutive payrolls without paying programmer
		- ie. Trial software ends after x amount of days
	- Key differences
- Spyware
	- 3 characteristics
		- Can collect keystrokes, passwords, screen caps
		- Can send collected data periodically back to attacker
	- Key differences
- Adware
	- 3 characteristics
		- Infects victim with sole purpose to deliver ads to target computer
		- Adware developer may develop contracts with advertisers
			- Pay per click
		- Browser toolbars
		- Can redirect URLs to advertising
	- Key differences
- Scareware
	- 3 characteristics
		- Uses scare tactics to prompt user into purchasing product or malicious software
		- Also known as fake anti virus
	- Key differences
- Ransomware
	- 3 characteristics
		- Kidnaps computer by encrypting drives or files
		- Demands payment to decrypt / release
	- Key differences

## Module 4: Crypto 1

- Cryptography, cryptanalysis, cryptology
- Codes vs. ciphers
- The process of encryption
- **Graphically represent the process of encryption**
- Symmetric vs. asymmetric encryption
	- **Strengths / weaknesses of each**
- Types of symmetric and asymmetric ciphers
- Cipher attack types

### Answers

- What is cipher
	- Algorithm to encrypt/decrypt data
- Cipher text
	- Output of encrypted plaintext message
- **Graphically represent the process of encryption**
	- See notebook
- Symmetric encryption
	- Strengths
		- Simple mathematics operation
		- Faster encryption/decryption
		- Suited to basic computer systems
	- Weaknesses
		- Only one common key for encryption and decryption
		- Key needs to be distributed securely
		- If key disclosed to unauthorised actors, data is compromised
- Asymmetric encryption
	- Strengths
		- One key for encryption
		- Another for decryption
		- Either one can be private key, the other will be public key
		- Public key can be
			- Given to anyone
			- Distributed through unsecure channels
		- No secret information will be distributed
	- Weaknesses
		- Complex mathematics operations
		- Slower encryption/decryption
		- Not suited to basic computer systems
		- If private key disclosed, encryption no longer secure
- [Block cipher](http://research.cyber.ee/~peeter/teaching/kryptoi05s/streamkil.pdf)
	- Partition plaintext into relatively large (ie. 128 bits) blocks and encode each block separately
	- Encoding of each block generally depends on at most one of the previous blocks
	- Same key is used for each block
	- Examples
		- DES
		- AES
		- ECB
		- CBC
	- Advantages
		- High diffusion
			- Information from plaintext diffused into several ciphertext symbols
			- One ciphertext block may depend on several plaintext letters
		- Immunity to insertion of symbols
			- Because blocks of symbols are enciphered, it is impossible to insert a single symbol into one block
			- The length of the block would then be incorrect, and decipherment would quickly reveal the
	- Disadvantages
		- Speed
			- Slow encryption, must wait until entire block of plaintext symbols has been received before starting encryption process
		- Error propagation
			- An error will affect the transformation of all other characters in the same block
	- Use when
		- Bound is known
			- ie. File
- [Stream cipher](http://research.cyber.ee/~peeter/teaching/kryptoi05s/streamkil.pdf)
	- Partition plaintext into small (ie. 1 bit) blocks and let the encoding of each block depend on may previous blocks
	- For each block, a different key is generated
	- Examples
		- RC4
		- CFB
		- OFB
	- Advantages
		- Speed
			- Encrypted as soon as it is read
			- Time depends on encryption algorithm, not time it takes to receive more plaintext
		- Low error
			- Because each symbol is separately encoded, error in encryption only affects only that character
	- Disadvantages
		- Low diffusion
			- Each symbol is separately enciphered
			- All information of that symbol is contained in one symbol on the ciphertext
		- Susceptible to malicious insertions and modifications
			- Because each symbol is separately enciphered, an active interceptor who has broken the code can splice together pieces of previous messages and transmit a new message that may look authentic
	- Use when
		- Bound is unknown or continuous
			- ie. Wireless network transmission

## Module 5: Crypto 2

- How does a hash function work
	- **Know 5 real world uses of hashing functions**
- Digital signatures
	- **Graphically represent the digital signature process**
- Certifying authorities
- Digital signatures vs. digital certificates

### Answers

- How does a hash function work
	- Takes object as input for a mathematical algorithm and outputs a hash
	- Aim is to have unique hashes for any input
		- Although collisions can occur
- **Know 5 real world uses of hashing functions**
	- Storage of passwords
		- Hash of password stored, not actual password
		- Hash of input compared with stored hash
	- Git version control
		- Stores SHA1 hash of compressed objects
	- Files available for download sometimes provide hash
		- ie. Linux distro download
		- So user can confirm download is not corrupted
	- HMACs
		- Use hash function and secret key to provide integrity and authenticity
	- Submitting assignments to ECU
		- Provide hash to confirm integrity of downloaded file

## Module 6: Identification and authentication

- Identification vs. authentication vs. authorisation
	- **Definitions and examples**
- Authentication: Examples and explanations
	- **Something you know**
		- x3 examples
	- **Something you have**
		- x3 examples
	- **Something you are**
		- x3 examples
- Cracking/obtaining passwords
	- **Describe non/technical proceduress to do this**
- Biometrics
	- Physiological vs. behavioural
	- False acceptance vs. false rejection
	- Types of biometric scanners
		- Benefit and problems of each
- How to convince someone to implement biometrics?
	- **Factors inhibiting the adoption of biometric technologies**

### Answers

#### Identification, authentication and authorisation

- Identification
	- Definition
		- Establish who or what the actor claims to be
	- Examples
		- Type in a username
- Authentication
	- Definition
		- Establish that the actor really is what it claims to be
	- Examples
		- Type in a password
- Authorisation
	- Definition
		- Establish what the actor is allowed to do
	- Examples
		- Allowed to access home directory
		- Allowed to read/write to shared directory
- Authentication examples
	- Something you know
		- Password
		- Secret question to reset password
		- Secret handshake / symbols
	- Something you have
		- ID card
		- Token
		- Private key
	- Something you are
		- Iris
		- Retina
		- Fingerprint

#### Cracking passwords

- Describe non-technical process
	- Could be guessed
		- Brute force
		- May lock account after x failed attempts
	- Retrieve password file from computer
		- Use password cracking program
		- Offline attack
- Describe technical process
	- Offline attacks
		- Dictionary attacks
			- Take word from dictionary
			- Hash word using one way function
			- Compare hash result with obtained password hash
			- If hash match
				- Success, password cracked
			- Else use more words in dictionary
				- Repeat process
			- Else if no more words in dictionary
				- Attack failed
		- Brute force
			- Init test string
			- Hash test string using one way function
			- Compare hash result with obtained password hash
			- If hash match
				- Success, password cracked
			- Else increment test string
				- Repeat process
		- Hybrid
			- Combination of dictionary and brute force
			- Uses dictionary word and adds chars at start/end of word
			- Designed to crack passwords such as `pass123`
		- Rainbow tables
			- Replaces brute force or dictionary attack
			- Looks up a collection of precalculated hashes against password hash
			- Much faster but need large disk space to store rainbow table
- Requirements
	- Password hash
	- Knowledge of hash algorithm
	- Ability to test matches
	- Lots of processing power
- Tools
	- [Hashcat](http://hashcat.net/oclhashcat/)
		- GPU
		- Modes
			- Straight
			- Combination
			- Hybrid dict + mask
			- Hybrid mask + dict
	- [JohnTheRipper](http://www.openwall.com/john/)
		- Dict
		- Brute force

#### Biometrics

- Physiological
	- Iris
		- Benefits
			- Accurate
		- Problems
			- Some early versions could be tricked by photo
	- Retina
		- Benefits
			- Can't be reproduced by photo
			- Accurate
		- Problems
			- Requires cooperative subject
			- Expensive
	- Fingerprints
		- Benefits
			- Accurate
			- Easy to use
		- Problems
			- Can be replicated with playdoh
	- Hand geometry
		- Benefits
			- Easy to use
		- Problems
			- Not as accurate
			- Only useful for authentication
			- Not good for identification
	- Face recognition
		- Benefits
			- Does not require subject to be cooperative
				- Capture images as people walk down hallway
			- Can be used for authentication and identification
		- Problems
			- Not good at dealing with completely uncooperative subjects
				- Hiding faces
- Behavioural
	- Keystroke analysis
		- Benefits
			- Ongoing authentication
			- Can re-authenticate user as system is being used
		- Problems
			- Not as accurate
	- Signature analysis
		- Benefits
			- Easy to use
		- Problems
			- Attacker can mimick signature
	- Voice analysis
		- Benefits
			- Can be easy to use
		- Problems
			- Expensive
			- Conditions cause problems
				- Stress
				- Cold / flu
			- Can take time
				- Must record different answers to questions
- False acceptance
	- Type I error
	- Scan falls within confidence limits
		- Even though actor is not authentic person
	- Adjust False Acceptance Rate
- False rejection
	- Type II error
	- Scan falls outside confidence limits
		- Even though actor is authentic person
	- Adjust False Rejection Rate
- How to convince someone to implement biometrics?
	- **Factors inhibiting the adoption of biometric technologies**
	- Ensure confidentiality of data
	- Ensure integrity of data

## Module 7: Hardware and data security

- Methods to protect your hardware and data on your hardware
	- Theft
		- Label / tag equipment
		- Access cards
			- Monitor / restrict access to hardware
		- Locking hardware to desk or floor
			- ie. Kensington lock anchor point
		- CCTV
		- Proximity alarms
		- Hard drive encryption
	- Environmental
		- Uninterruptible Power Supply (UPS)
		- Air conditioner
			- Air filters
			- Alarms when AC fails
		- RAID
			- Redundant Array of Inexpensive Disks
	- Hardware threats
		- Faraday cages, bags, rooms
- Slack space
	- **Define with examples**
	- Slack space is the unused space in a hard drive cluster
		- ie. 4kb cluster, file only takes up 2kb, 2kb of slack space
		- Can be used for forensic investigation
			- Deleted files then overwritten by new files
			- If new files only filled portion of previously written cluster, portion deleted files may be recovered from slack space
- Secure deletion tools
	- **How does a secure file deletion tool work**
		- Overwrite data over numerous passes
	- **Example of open source / commercial tools**
		- Eraser, DBAN boot, NukeCD
	- **Know the standards**
		- DoD 5220.22-M
			- Software based data sanitation method
			- Pass 1: Write 0, verify write
			- Pass 2: Write 1, verify write
			- Pass 3: Write random char, verify write
		- Degaussing
			- Erasing data by modifying magnetic alignment
			- Make alignment random, no data can be recovered
			- AC erasure
				- Apply alternating magnetic field
				- Reduced in amplitude over time from initial high value
			- DC erasure
				- Apply unidirectional magnetic field
				- ie. Permanent magnet
- Backup issues
	- What will be backed up
		- Identify critical information
	- How often
		- Trade-off between more recent backups available vs. resources consumed by backups
	- Will rotation strategy be used
		- Media prone to wear and tear
	- What type of media
		- Cost
		- Longevity
		- Reliability
	- Where will backups be stored
		- Onsite
			- Easy access
			- Will also be destroyed if property destroyed
		- Offsite
			- May be difficult to access
			- Ensures redundancy if property destroyed
		- Use both
	- How will backups be protected
		- Protect like primary source
		- Plaintext or encrypted
	- Verify and log backups
		- Confirm backups are being performed
		- Confirm backups can be used to restore
		- Confirm integrity of backups
		- Ensure backup software / hardware will be available in the future
			- Archive software
			- Archive hardware
			- Archive machine
			- Archive media

## Module 8: Operating system security

- What is an operating system
	- What does it do
- Access control lists
- Windows NT logon process
	- **Graphically show Windows NT logon process**
- NTFS vs. FAT
	- Security features of each
		- If any
- Windows auditing
	- **Benefites and issues**
		- **What can be audited**

### Answers

- What is an operating system / what does it do
	- Interface between user and hardware
	- Manages how applications access resources
		- Disk
		- CPU
		- RAM
		- Input / output devices
		- Network interfaces
- Access control lists
	- For every user there is a list of objects
	- For every object, the OS maintains a list of users and permissions
- Windows NT logon process
	- **Graphically show Windows NT logon process**
		- See notebook
- NTFS vs. FAT
	- NTFS
		- Can use file permissions
			- Each file has security descriptor
				- Contains security token of owner
			- Each file also has Access Control List
			- All file access must go through Security Reference Monitor (SRM)
			- SRM compares tokens of users to the file's Access Control List
				- Determines if access is allowed
		- Increased stability
			- All filesystem interactions occur as transactions
				- Either fully complete or do not complete at all
				- Like SQL transactions
			- Logs transactions
				- Can be used to revert changes in event of crash, power failure etc.
		- Increased robustness
		- Fault tolerance
		- Supports encryption
			- Encrypted File System (EFS) exists as a layer on top of NTFS
			- Files encrypted/decrypted on the fly

## Module 9: Application security

- Vulnerabilities within applications
- Code integration pros/cons
- Buffer overflow
	- With examples
- What is shell code
	- What can it do?
- Memory leaks, conversion errors, off-by-one
	- Security impacts of these flaws
- Issues with patching software
- **Open source vs. closed source software**

### Answers

- Vulnerabilities within applications
	- Flaws introduce vulnerabilities
		- Design
		- Implementation
- Application and OS integration
	- Advantages
		- Less overall code
			- Less bugs
		- Secure code = secure application
	- Disadvantages
		- A bug in the shared component can be accessed across many applications
		- Vulnerabilities can be shared
		- Developer may purposefully implement vulnerabilities to be exploited at a later date

#### Buffer overflow

- Buffer
	- A section of memory used to temporarily store data
- Buffer overflow
	- Input of data placed into a buffer which exceeds its allocated capacity
	- Programming error when a process attempts to store data beyond the limits of a fixed-size buffer
		- Overflow overwrites adjacent memory locations
			- Which could hold
				- Program variables
				- Parameters
				- Program control flow data

#### Buffer overflow example

```
char a[8];
int b = 1979;
```

```
var: A                                       | B
val: null string                             |  19   79
hex: [00] [00] [00] [00] [00] [00] [00] [00] | [07] [BB]
```

- User enters `excessive`, stored in var `a`
- `excessive` is 9 char long
- Last char of `excessive` `e` spills into var `b`
	- Modifies value of var `b`
	- `e` = 6500<sub>16</sub>
	- 6500<sub>16</sub> = 25856<sub>10</sub>

```
var: A                                       | B
val:  e    x    c    e    s    s    i    v   |  25856
hex: [00] [00] [00] [00] [00] [00] [00] [00] | [65] [00]
```

#### Shellcode

- Series of machine code instructions
	- Hex opcodes
	- Designed to be fed into an overflowed buffer
- Usually written as small, compact and efficient as possible
- Written in few different ways
	- Write hex opcodes directly
	- Write assembly code to retrieve opcodes
- What can shellcode do
	- Can perform other actions but initial aim was to open a shell command prompt
	- Used as a way into the system

#### Other implementation issues

- Memory leak
	- Memory is allocated and never freed when no longer required
	- Can be used by attacker to
		- Cause DoS conditions
		- Take advantage of unexpected program behaviour resulting from low memory conditions
- Conversion errors
	- Data converted to incorrect type or incorrect properties
		- Signed/unsigned conversions
			- Negative number turns into positive number in error
			- Cause DoS conditions due to undefined behaviour, and crashes
			- Cause buffer overflow conditions
	- Can be used by attacker to
		- Cause buffer overflow conditions
		- DoS conditions
- Off-by-one
	- Iterative loop iterates one too many times, or one too few
	- Can be used by attacker to
		- Cause buffer overflow

#### Issues with patching software

- If vulnerability found and patch released
	- Creates window of opportunity for an attacker to exploit vulnerability in time between patch is released and patch is deployed on system
	- Important to minimize window of opportunity by minimizing time of patch deployment
- Patches should be tested before deployed
	- May introduce bugs
- Patches must be evaluated and tested
	- Does patch fix what it is designed to fix
	- Does patch introduce bugs elsewhere
	- Does patch introduce new vulnerabilities
	- Does patch degrade performance

#### Open source vs. closed source

- Open source
	- Advantages
		- Code reviewed by more people
		- Bugs detected faster
		- Patches released faster
		- Release schedule not tied to corporate requirements / politics
	- Disadvantages
		- Less control
		- Less focused
		- Malicious developer might include backdoors
			- Although would quickly be reported by community
		- Source available to view for vulnerabilities
- Closed source
	- Advantages
		- Focused development
		- Code hidden from attackers
			- Although may still be reverse engineered
		- Attacker not able to insert backdoor / malicious code into source
	- Disadvantages
		- Code reviewed by less people
		- Less developers to fix code
		- Release tied to corporate requirements / politics

## Module 10: Network security

- Differences between IPv4 and IPv6
- Network scanning/reconnaissance tools
	- **What can these tools potentially detect?**
	- **What are the benefits of having this information?**
- Wired vs. Wireless networking
	- **Pros / cons of each?**
	- **What techniques can be utilised to secure and protect a home network?**
- Firewall types
	- **Features / limitations and context of use**
- Intrusion detection system vs. honeypots
	- **What they can / can't do**
	- **What are the legal / ethical issues**
- Signature vs. anomaly based rule sets
- Virtual private network (VPN)
	- **Advantages / disadvantages**

### Answers

#### Network scanning / recon tools

- **What can these tools potentially detect?**
	- Nmap
		- Open source
		- Discovers hosts and services on network by sending specially crafted packets and analyses responses
		- Network / host discovery
		- OS detection
		- Vulnerability scan
		- Backdoor detection
		- Vulnerability exploitation
	- Nessus
		- Closed source
		- Network / host discovery
		- OS detection
		- Botnet audit
		- Malicious process audit
		- Anti-virus audit
- **What are the benefits of having this information?**
	- Determine OS of all hosts in network
	- Identify vulnerabilities for OS / applications
		- Determine which patches need to be applied
	- Identify any running backdoors / botnets in network / system
	- Identify which hosts are not secure

#### Wired and wireless networking

- Wired
	- Pros
		- More secure than wireless
			- Can't intercept over the air transmissions
		- Faster
	- Cons
		- Need to run cable through building
- Wireless
	- Pros
		- Don't need to run cables
	- Cons
		- Transmissions can be easily intercepted
- Techniques to secure / protect home network
	- Configure hardware
		- Change default router accounts
		- Change default subnet
		- Disable remote access features
			- ie. Filesharing / FTP services
		- Update router firmware
		- Encrypt wifi with WPA2

#### Firewall types

- Stateless firewall
	- Features
		- Matches individual flows of traffic to rules to permit / deny traffic
	- Limitations
		- Lacks ability to track full sessions to and from original host
- Stateful firewall
	- Features
		- Groups packet flows into sessions
		- Filters traffic on per-session basis
		- Maintains table of each active connection
			- IP addresses
			- Ports
			- Sequence number of packets
	- Limitations
		- More expensive than stateless firewall
		- Can be flooded with traffic
			- Amount of traffic exceeds hardware capability of firewall
- Application firewall
	- Features
		- Controls input/output and/or access to/from or by an application or service
		- Host or network based
	- Limitations
- Circuit level firewall
	- Features
		- Examines IP address and port information
		- Once connection is verified, packets are passed through
		- Used by DSL routers
			- Network address translation (NAT)
	- Limitations
- Personal/software firewall
	- Features
		- Software runs directly on host being protected
		- Filters
			- Inbound connections
			- Outbound communication
		 - Verifying applications
			- Hashing executables
	- Limitations
		- Traffic has already entered local network
		- Only stops/filters traffic at the host

## Module 11: Web security

- What is privacy
	- Does it still exist
- Are we safer by having no privacy
- Privacy issues with proxy logs
- How is your online privacy being affected
- Online profiling
	- Pros / cons
- Government surveillance
- Methods of monitoring
