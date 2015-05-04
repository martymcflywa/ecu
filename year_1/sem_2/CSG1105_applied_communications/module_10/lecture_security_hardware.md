# Security hardware

## Network media vulnerabilities

- Communication vulnerabilities
	- Interference with uninterrupted communication
	- Third-party eavesdropping

![communication media and vulnerabilities](http://snag.gy/ia3pM.jpg)

- Vulnerabilities differ by media type
- All media allow eavesdropping
	- Process enabling eavesdropping differs
- Fiber optic cable
	- Most difficult to tap into
- Wireless media
	- Easiest media to tap into
		- War driving technique possible

## Managed switches

- Allow control over device connections
	- VLANs manage bandwidth
	- Broadcast traffic contained within each VLAN
	- Control over port parameters
		- Speed
		- Half/full duplex
		- Quality of service (QoS)
		- Port enabled
- Maintains port statistics
	- Bytes transmitted and received
	- Link status
	- Errors

![managed switch controlling 14 computers](http://snag.gy/oAwis.jpg)

### Security vulnerabilities in a switch

- Switch operation
	- Switch learns MAC addresses associated with ports
	- Forwards received frame to specific port
	- Generally more secure than hub
- Enabling switch broadcast trafffic
	- Sends lots of frames containing bogus MAC addresses
	- Send broadcast protocol
		- Send series of ARP frames with different IP addresses

![switch arp](http://snag.gy/IW644.jpg)

![computer arp](http://snag.gy/C1X8u.jpg)

## Firewalls

- Hardware or software
- Limit network traffic
	- Coming into a network or computer
	- Leaving a network or computer
- Hardware firewall protects entire network
- Demilitarized zone (DMZ)
	- Unsecure network
		- Between public Internet and private LAN
	- Hardening
		- Process of making a server more secure

![protecting a network with a firewall](http://snag.gy/JJA4J.jpg)

### Firewall types

- Packet filtering
	- Filter traffic based on IP address, port number or protocol
- Proxy service
	- Monitor Session Layer or Application Layer for proper sequencing or protocols
- Stateful inspection
	- Combination of packet filtering and proxy service operation

![firewall types and function](http://snag.gy/2KDiH.jpg)

## IDS hardware

- Hardware and software combination
	- Detects malicious network traffic
- Two parts
	1. Network tap
	2. IDS analysis software

![basic operation of network tap](http://snag.gy/qimey.jpg)

## Authentication

- Process of identifying a user to a computer
	- Any other third party
- Three ways computer user is authenticated
	1. Something you know
	2. Something you have
	3. Something you are
- Multi-factor authentication
	- Using more than one authentication method

## Biometric devices

- Use physical feature of one's body
	- Assist in authentication
	- Individual biometric measurements make up biometric signature
- Wide variety of biometric devices available
	- Least expensive
		- Devices recognising fingerprints
	- Most expensive
		- Iris or retinal scanners

### Fingerprint readers

- Most common biometric device

![fingerprint readers](http://snag.gy/41wzt.jpg)

- Make two-dimensional fingerprint plot
	- Use actual image or two-dimensional plot of the distances between fingerprint sensor and skin
	- Fingerprint recognised based on unique characteristics in the plot
	- Capacitive fingerprint sensor *sees* different capacitances
- Once fingerprint is registered
	- Can be used for authentication purposes

### Voice authentication

- Voice recognition
	- Understanding what a person is saying
- Voice authentication
	- Understand who is talking

### Hand geometry readers

- Captures unique characteristics of a human hand

### Handwriting authentication

- Factors building biometric template
	- Varying speed
	- Pen pressure
	- Stroke of letters
- Digital graphics tablet
	- Captures three-dimensional signature characteristics

### Facial recognition

- Facial recognition software
	- Analyses camera image
	- Extracts facial characteristics
		- Distance between eyes
		- Nose
		- Mouth

### Iris and retinal scanners

- Iris scanning uses patterns in the iris
- Retinal scanning uses patterns in blood vessels of the retina at the back of the eye

![iris recognition parameters](http://snag.gy/KGOsw.jpg)

## Fault tolerance

- Ability of computer or network to keep operating in a hardware failure event
- Many types of hardware failures
	- Fatal if system is not fault tolerant

![hardware failures](http://snag.gy/r4kHa.jpg)

### Adding fault tolerance to a computer system

#### Avoiding power loss

- Use an Uninterruptable Power Source (UPS)
- Use dual power supplies

#### Avoiding hard disk failure

- RAID1 disk mirroring
- RAID5 stripe sets with parity

![RAID](http://snag.gy/uvZLm.jpg)

#### Protecting whole network

- Provide reliable connections from user computers to LAN servers
- Provide fault tolerance in LAN to Internet connection

#### Fault tolerance for user computers

- Use multi-homed computers connecting to different switches

![fault tolerance on LAN](http://snag.gy/e9Eq6.jpg)

## Physical security

- Site location
	- First line of defense against intruders
- Moat
	- Prevents all but most serious individuals from attempting access
		- Wide and deep enough to prevent vehicle crossing
- Lighting
	- Provide well lit facilities inside and outside
- Fences
	- Prevent most individuals from approaching the building
- Mantrap
	- Secure entryway area containing two doors
- Cameras
	- Use motion detecting cameras
	- Night vision cameras
	- Cameras designed for operation in bright sunlight
		- Available for use over wired/wireless networks
- Motion and/or heat sensors
	- Deters intruders
- Doors and locks
	- Use strongly built doors blocking secure area access
	- Use numerical combination lock
		- Swipe card lock
		- Biometric device
- Windows
	- Keep closed
		- Monitor with alarm system
	- Frosted to obscure view through them
		- Still allows monitoring
- Physical security plan
	- Describes procedures required for maintenance
		- Evacuation due to emergency
		- Shutdowns

## Troubleshooting techniques

- Patience
	- May need to work on a problem for hours, days or weeks before finally solving it
- Reward for sticking with it
	- Satisfaction of a job well done
	- Valuable experience
