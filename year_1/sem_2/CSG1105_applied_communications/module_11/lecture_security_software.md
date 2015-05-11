# Security software

## Packet sniffing

- Requires network adapter in promiscuous mode
	- All received packets passed into TCP/IP stack
	- No guarantee all network traffic on LAN will be captured
		- Only captures packets existing on the network cable
	- Switch based limitations
		- Switch forwards traffic to specific ports
		- Resolved by mirroring port
- Reasons to capture traffic
	- Educational purposes
	- Diagnostics
	- Network baseline measurements
	- Security
- Can lead to invasion of privacy

![hub LAN traffic](http://snag.gy/0UD7E.jpg)

![switch LAN traffic](http://snag.gy/CmCmG.jpg)

## Port scanning

- Many ports to track
	- UDP
		- 65
		- 536
	TCP
		- 65
		- 536
	- Small subset typically in use
- `netstat -a`
	- Displays a list of ports in use
- `netstat -a -n`
	- Translates certain names into associated IP addresses or port numbers
- `netstat -a -b -n`
	- Displays processes associated with open ports

![netstat active ports](http://snag.gy/5Js0n.jpg)

![netstat active ports with ip addresses](http://snag.gy/k2kIY.jpg)

### Additional vulnerabilities

- Expand scanning process beyond open ports
	- Unapplied patches
	- Missing hotfixes
	- Security updates
	- Questionable services
	- Default admin accounts
- GFI LANguard vulnerability scanner tool
	- Scans host system and all computers on local network or Internet

![GFI LANguard results](http://snag.gy/iBw8L.jpg)

## Passwords

### Guessing a password

- Completely random approach
- Username and password written out clearly on sticky note
- Weak passwords
	- Composed of information commonly known about an individual

### Brute-force cracking

- Most time consuming
- Try all letter, number, and symbol combinations
	- Eventually correct password discovered

### Dictionary attack

- Use list of common passwords typically employed by many users
- Can download password dictionaries from the Internet
	- Contain hundreds of thousands of words
	- Specialized topics

### Preventing a password attack

- Choose strong passwords
	- At least eight letters, numbers and symbols
- Do not write passwords down
	- Use tricks to remember passwords
- Do not allow shoulder surfing
- Change passwords frequently
	- Do not reuse passwords

### IT department

- Force strong passwords
	- Maintain password history
- Lock out user's account after a certain number of failed attempts

## Intrusion detection

- Examine traffic entering a network
	- Determine if malicious
		- Denial of Service attack (DoS)
		- Distributed Denial of Service attack (DDoS)

### Detection

- Look for characteristics signature of SYN flood attack
	- Unique characteristics that can be recognised
- Upon entry into network
- Upon entry into computer

### Host based intrusion detection

- Network host responsible for examining its network traffic and recognising signatures
	- Denial of Service attacks
	- Buffer overflow attacks
	- Malicious code
- Uses software firewall and anti-virus application
- Must also verify system integrity
	- Signatures not available
	- Examines critical system files for changes
- Expensive to implement
- Decentralized approach

### Network based intrusion detection

- Centralized approach
- Less expensive than host based intrusion detection

![network based intrusion detection](http://snag.gy/RQLMN.jpg)

- Attack detection
	- Only as good as the rule/s written for its detection
- False positive alert
	- Given when normal, non-malicious traffic matches one or more malicious traffic rules
- Passive IDS
	- Examines traffic
	- Notes suspicious behaviour in log
	- May also notify network manager
- Active IDS
	- Takes action on its own to handle problem
	- No user intervention

## Secure remote access

- Many ways to access computer network remotely
	- Eavesdropper may capture
		- Username
		- Password
		- Entire sessions
	- Secure access with encryption
	- Secure dial-up connections with callbacks or access limitations

![remote access vulnerabilities](http://snag.gy/sYojU.jpg)

## Security policies and procedures

- Concerns proper use of hardware, software, and services provided by a network and the network computers

![areas of concern in a network](http://snag.gy/rr94V.jpg)

### Storage media

- USB thumb drives
	- Popular way of transporting digital media
- Pose multiple security threats
	- Smuggling confidential information out of a networked environment
	- Introducing malicious code into networked computers
	- Configuring with bootable operating systems
- Solution
	- Configure BIOS to prevent removable disk booting
	- Use a boot password

### Portable devices

- Gain wireless access to business servers
- Solution
	- Put all wireless devices on separate VLAN
	- No access to business servers or network traffic

### Software

- Employer **free** Internet access
	- Represents loss in productivity
	- Security risk
- Issues
	- Downloading trojans and other malicious code
	- User installing their own software creating unstable system

### Services

- Company email not private
- Reasons to view
	- Verify suspicions
	- Employee performing illegal or banned activity
	- Employee stealing company secrets
	- Employee harassing another employee

### Acceptable use policy (AUP)

- Sets rules for how computers and network may be used
- Lists prohibited activities
- Describes consequences of non-compliance with the stated rules
- Required component of an overall security program
	- May help limit legal liability from users who break rules
- Contains
	- Statement outlining expected computer and network use
	- Code of conduct describing prohibited behaviours deemed unacceptable
	- Description of consequences for violating the code of conduct
- Best written and comprehensive AUP
	- Only as good as the level to which enforced

### Security procedures

- Security policy
	- Provides rules, expectations and consequences of not following rules
- Security procedure
	- Describes steps needed to execute policy
- Developed by a group of individuals
	- Group represents all organisational areas
- Goals
	- Achieve protection deemed necessary
	- Stay compliant with local, state, federal guidelines and laws

## Troubleshooting techniques

- Discovering illegal or malicious network activity
	- Firewall identifies banned website access
	- IDS identifies known attack signature pattern
- Discovering packet sniffing
	- Use special applications
		- Search for promiscuous mode computer network adapter
		- Use known traffic patterns, certain MAC addresses
		- Look for reverse DNS evidence
