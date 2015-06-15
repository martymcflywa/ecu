# CSG1105 151 Sample Exam Questions

1.	**Describe how data is represented when a digital medium is used.**
	- ![modulation](http://electronicdesign.com/site-files/electronicdesign.com/files/archive/electronicdesign.com/content/content/64598/64598_fig01.gif)
	- See notebook
	- See pg. 4 textbook
2.	**Describe a hub.**
	- Also called concentrators
	- Expands one Ethernet connection into many
		- ie. 4-port hub provides a star connection for 4 devices to a single Ethernet connection
	- One port designed to operate in either straight through or crossover mode
		- Hubs can be daisychained in crossover mode
		- Generally there is a switch on a hub to select preferred mode
	- Hubs broadcast data received by a port to all other ports on the hub
	- Operating at OSI Layer 1 Physical
3.	**Describe a satellite network system.**
	- Internet connection via satellite
	- Speeds
		- Up 128Kbps
			- Telstra currently offering up to 1Mbps
		- Down 500 - 800Kbps
			- Telstra currently offering up to 6Mbps
	- Requires a satellite dish to be installed, which is then connected to a modem
	- Useful for remote locations where phone lines / cable or mobile network is not available
4.	**List three properties that 10base5, 10base2 and 10baseT have in common.**
	- Ethernet technologies
	- Max transfer rate 10Mbps
	- Baseband signalling
5.	**Discuss the names that Microsoft has used for the local network with different versions of Windows.**
	- Windows 9x: Network Neighborhood
	- Windows XP: My Network Places
	- Windows Vista/7/8: Network
6.	**What happens when a hardware frame is sent out to a network?**
7.	**List five disaster recovery safeguards that can be used to help guarantee a relatively quick and painless recovery in the event that a disaster occurs.**
	- Maintain up-to-date offsite backups
	- Use Uninterruptable Power Supply (USP) on critical systems
	- Maintain inventory of spare components
	- Keep up to date on all software updates
	- Secure and monitor all equipment adequately
	- Use fiber for external building-to-building connections instead of copper wire
	- Convince those in admin or purchasing that there are no corners that can be cut when planning for recovery disaster
8.	**Describe the Java programming language.**
	- Inspired by Objective-C, syntax based on C++
	- Compiles to own bytecode and programs executed within Java Virtual Machine
	- Cross platform
		- Java programs do not have to be compiled for different operating systems
		- Program compiled once will run on any platform that is able to run the Java VM
	- Can be used to create web based applications: Java applets
9.	**List and describe what a typical AUP contains.**
	- Statement outlining the expected use of computers and network
	- Code of conduct describing the prohibited behaviours deemed unacceptable
	- Description of consequences for violating the code of conduct
10.	**List UNIX/Linux systems files that are of particular interest to the forensic examiner.**
	- Binary log files: `/var/adm` or `/var/log`
		- `utmp`
		- `wtmp`
		- `lastlog`
	- ASCII log files
		- Web / FTP access
	- `/etc/syslog.conf`
		- Config file defines where other log files are stored
	- `/etc/passwd`
		- Contains all user accounts and passwords
	- `/etc/groups`
	- `/etc/hosts`
		- Contains static DNS entries
	- `/etc/rc`
	- `/var/cron/log`
		- Look for scheduled cron jobs
	- `/etc/inetd.conf` and `/etc/xinetd.conf`
	- Shell history files
		- Contains all commands entered on particular shell
11.	**Describe how data is represented when an analog medium is used.**
	- See notebook
	- See pg. 4 textbook
	- Amplitude modulation
		- Low / no amplitude: 0
		- High amplitude: 1
	- Frequency shift keying
		- Low frequency: 0
		- High frequency: 1
12.	**Describe a mesh network.**
	- Mesh == fully connected network
	- Every connected node must be connected to every other node in the same network
	- Advantages
		- Data only needs to traverse a single link, directly to the other node it is transmitting to
		- Very reliable, many links must fail before communication between nodes is interrupted
	- Disadvantages
		- Very expensive to build
13.	**Describe a hybrid network.**
	- Combines components of two or more network topologies
		- ie. Two star networks connected by a bus network
14.	**Discuss subnetting.**
	- Subnetting is the strategy used to partition a single physical network into more than one smaller, logical sub-networks (subnets)
	- Subnetting allows an organisation to add sub networks without the need to acquire a new network number from the ISP
	- Subnetting helps to reduce the network traffic and conceals network complexity
	- Each IP address consists of a subnet mask
	- Can be classed
		- Class A: 255.0.0.0
		- Class B: 255.255.0.0
		- Class C: 255.255.255.0
	- Or classless, using CIDR notation
		- 192.161.1.0/8: Class A equivalent
		- 192.161.1.0/16: Class B equivalent
		- 192.161.1.0/24: Class C equivalent
	- CIDR is more flexible than classed subnets
15.	**Describe what happens at each specific layer in the TCP/IP protocol after you click on a link to a Web site.**
	- Browser looks up IP address for domain name locally then remotely
		- Lookup occurs in the following order
			- Browser cache: Browser may have DNS record cached
			- OS cache: If DNS record not found in browser cache, OS cache is searched
			- Router cache: Request continues to router, if router has cache
			- DNS server: If DNS record not found locally, query sent to DNS server previously configured in TCP/IP settings of interface
		- DNS records returned either locally or by DNS server, contains IP address of domain name
	- Browser sents HTTP request to web server
		- `GET` request: Names the URL to fetch
		- `User-Agent`: Identifies the browser making the request
		- `Accept` / `Accept-Encoding`: States what type of responses the browser will accept
		- `Connection`: Asks server to keep TCP connection open for further requests
		- Request also contains cookies that browser may have for that domain
	- Web server may respond with permanent redirect
		- `HTTP / 1.1 301 Moved Permanently...`
		- ie. If user typed in `www.facebook.com`, may be redirected to `facebook.com`
	- Browser follows redirect
		- Sends another `GET` request to redirected URL
	- Server sends back HTML response
		- `HTTP / 1.1 200 OK...`
	- Browser begins rendering HTML
	- Browser sends additional `GET` responses for objects embedded in HTML
		- ie. images, CSS, Javascript
16.	**List four benefits of either replacing the campus or corporate routers with layer 3 switches or adding layer 3 switching to a router-less network.**
	- Less expensive than routers
	- Fewer network components to manage (via SNMP)
	- Faster forwarding
		- Close to wire speed
		- The speed of frames on the wire
	- Helps provide QoS to the LAN environment
		- Quality of Service
	- Compatible with existing routing protocols
		- RIP, OSPF
	- Easier to configure than routers
	- Performs traditional router functions
17.	**Discuss handwriting authentication.**
	- Authenticates user by analysing a user's handwriting
	- Speed, pen pressure, stroke of letters analysed via graphics tablet / stylus which captures three-dimensional characteristics of handwriting
		- Pen pressure
		- Acceleration used in the movements
		- User's handwriting rhythm
18.	**How do you prevent booting from a USB thumb drive?**
	- Configure BIOS to prevent removable disk booting
	- Use a boot password
	- Set BIOS password
		- Prevent BIOS config from being tampered with
19.	**List and describe what a typical AUP contains.**
	- See Q9
20.	**What is the pre-incident preparation that must take place for a CSIRT?**
	- Proper security policies / procedures in place
	- Network / computers protected by
		- IDS
		- Anti-virus software
		- Encrypted communications
	- Employees / users trained in basics of safe / secure computing
	- CSIRT members must have
		- Hardware / software required to do job
		- Appropriate authorisation and documentation
21.	**Describe how data is represented when an analog medium is used.**
	- Amplitude modulation
		- Low / no amplitude: 0
		- High amplitude: 1
	- Frequency shift keying
		- Low frequency: 0
		- High frequency: 1
22.	**Discuss subnetting.**
	- See Q14
23.	**List the three varieties of Ethernet cables.**
	- RG-58 coax
		- 10base2
		- Thinwire, Cheapernet
	- RG-11
		- 10base5
		- Thickwire
	- UTP
		- 10baseT
		- 100baseT
		- 1000baseT
	- Fiber optic cable
		- 10baseFL
24.	Describe a router.
	- Operates at Layer 3: Network
	- Connects two or more networks together by providing an interface for each network to which it is connected
	- Examines each packet to determine if the packet must be translated from one network to another
		- Packets compared to routing table which is maintained by router
		- Every router in path between source and destination performs similar process
	- Can connect networks that use different
		- Technologies
		- Addressing methods
		- Media types
		- Frame formats
		- Speeds
	- Routers do not maintain any state information about packets
		- Only moves them along network
25.	**Describe the destination address of an Ethernet frame.**
	- Contains destination MAC address of an Ethernet frame
		- MAC address
			- 48 bits / 6 bytes, represented as hex
				- 00-C0-F0-27-64-E2
			- First 24 bits: Manufacturer ID
			- Last 24 bits: Chosen by manufacturer
26.	**List three properties that 10base5, 10base2 and 10baseT have in common.**
	- See Q4
27.	**List the chores that the control logic must perform.**
	- Control logic: Switch component
	- Updating and searching MAC address table
	- Configuring the switching fabric
	- Maintaining proper flow control through the switch fabric
28.	**Describe asymmetric encryption.**
	- Uses two keys to perform encryption / decryption
	- Mathematical makeup of key pair allows for each key to decrypt whatever has been encrypted by the other key
	- Provides for several important capabilities not available with symmetric encryption
		- Digital certificates
		- Digital signatures
29.	What is a frequency analysis?
	- Technique to help crack substitution encryption
	- Counts the number of times each symbol appears in the encrypted message
	- Compares the counts with well known symbol frequencies
		- ie. How many times does 'T' appear in a sentence
30.	**List the skills that you need to become proficient at analyzing malware.**
	- In depth knowledge of operating systems
	- Ability to write and interpret code in several different programming languages
	- Knowledge of how the Internet operates
	- Ability to work with HTML
	- Ability to use debugging utilities to reverse engineer 	machine code or step through a program on an instruction-by-instruction level
	- Creativity, problem solving skills, determination
31.	**Describe a hybrid network.**
	- See Q13
32.	**Describe a private network.**
	- Owned / managed by a private organisation / company
	- May have larger bandwidth capability than a public network
		- Depends on parent company's investment in infrastructure
			- Installs own media between sites
			- Leasing dedicated communication lines from communication company
	- May have higher maintenance costs per user
	- Have capability of restricting access to sensitive data
	- Methods to keep network private
		- Keep all components of network inside locked secure building without Internet access
		- Allow Internet access through a firewall, preventing outside access to internal network on a selective basis
		- Encrypt all information that needs to remain private
33.	**Discuss why the use of coax in Ethernet networking is obsolete.**
	- Slow network speeds
	- Less reliable than 10/100baseT networking
34.	**Discuss the functionality of PING.**
	- PING is a TCP/IP application that sends datagrams once every second in the hope of an echo response from the receiver
	- If the receiver is connected and running a TCP/IP protocol stack, it should respond to the datagram with a datagram of its own
		- Therefore, PING can be used for troubleshooting, to confirm if a host is connected
	- If PING encounters an error condition, and ICMP message is returned
	- PING displays the time of return response in milliseconds, or one of several error messages
		- Request time out
		- Destination host unreachable
	- PING can also be used for
		- Determining IP address of a known URL
			- ie. `ping google.com` will trigger a DNS query and return the IP address of google.com with the results
		- Determine the MTU value between two networks
			- By using the `-f` switch and specifying buffer size
			- ie. `ping -f -l 1472 google.com`
35.	**List the chores that the control logic must perform.**
	- See Q27
36.	**Describe the Exterior Gateway Protocol.**
	- Used between different Autonomous Systems (AS)
	- Defines the way that all networks within the AS are advertised outside the AS
	- Each EGP advertises its reachability to the networks it can connect to
	- Is independent of the IGPs used within an AS
	- EGPs can facilitate the exchange routes between AS that wmay use different IGPs
	- Each AS contains two EGP routers for redundancy
		- If one EGP is down, the second must temporarily handle the additional load
		- In practice, the internal and external router may be located within the same box, performing internal and external routing decisions simultaneously
	- The following protocols are used for EGPs in IP networks
		- Exterior Gateway Protocol (EGP)
			- RFC based protocol developed for use between ASs on the Internet
			- No longer in use due to lack of support for complex multipath environments and CIDR
		- Border Gateway Protocol (BGP)
			- RFC based protocol currently in use between ASs on the Internet
			- Overcomes weaknesses of EGP
				- ie. Better at detecting routing loops
		- Open Shortest Path First (OSPF)
			- Link-state IP protocol
			- Includes authentication
			- Has become the IP routing protocol of choice in large environments
			- OSPF also used as an IGP
37.	**List five disaster recovery safeguards that can be used to help guarantee a relatively quick and painless recovery in the event that a disaster occurs.**
	- See Q7
38.	**What is a firewall?**
	- A network hardware device or software application that examines packets to determine whether or not to allow the communication exchange to occur
		- Often configured with rules which determine which packets are / are not allowed
	- Three types
		- Packet filtering firewall
			- Like a router, has ability to block a packet based on IP address, protocol or port number
			- Operates at Layer 3: Network
		- Proxy service firewall
			- Either a circuit level gateway
				- Layer 5: Session
			- Or application level gateway
				- Layer 7: Application
			- Performs deeper inspection of the packet
			- Requires more time to process a packet before forwarding / blocking it
		- Stateful inspection firewall
			- Provides a combination of packet filtering and proxy service in one unit
			- Requires the most amount of inspection time per packet
	- Firewalls must be placed in a strategic location to prevent access to the private information
		- Must also allow for public access if required
39.	**Discuss the encryption strength of symmetric and aymmetric encryption.**
	- See Q56
40.	**List the steps in the incident response process.**
	- Pre-incident preparation
	- Detection of incidents
	- Initial response to incident
	- Formulate a response strategy
	- Investigate the incident
	- Report the findings
	- Resolve the incident
41.	**Describe how data is represented when an analog medium is used.**
	- See Q11
42.	**Describe what happens when a collision on an Ethernet LAN occurs.**
	- Collisions occur when two hosts attached on to the same Ethernet connection simultaneously transmit an Ethernet frame to each other, and both frames meet each other at some point betweeen the two hosts
	- Collisions cause signal and energy distortions sensed by the Ethernet transceivers of each host
	- Affected hosts then output a jam sequence and begin a random wait time before retransmitting the same frame
		- Random wait time prevents the same hosts from colliding frames again
		- Wait time increases exponentially after each successive collision of the same frame
	- Collisions can only be detected while a host is transmitting
		- Which is why each Ethernet media / technology has a maximum network diameter
			- Ensures that a transmission's round trip time is within the limits of a host's transmit time
43.	**Describe a hybrid network.**
	- See Q13
44.	**Describe UTP cable.**
	- Used for 10/100/1000baseT operation
		- Can be used to connect
			- NICs
			- Hubs
			- Switches
			- Routers etc.
	- Uses twisted pairs of wires to reduce noise and crosstalk
		- Gains higher speed data rates
		- Twists cancel small magnetic fields generated by currents in the wire
			- Reducing noise on the signals
	- Uses RJ-45 connectors to terminate each end
	- Limitations
		- Wire length
			- 100m
		- Network diameter
			- 10baseT
				- 500m
			- 100/1000baseT
				- 200m
					- 1000baseT needs Cat5 or better, uses four twisted pairs
	- Can be wired as straight through or crossover
		- Straight through
			- NIC to switch
			- NIC to router etc.
		- Crossover
			- NIC to NIC
			- Switch to switch et.
			- Used when no crossover port is available
			- Crossover UTP may not be required if port is auto-sensing and can switch to appropriate mode automatically
45.	**What is the interframe gap?**
	-  A self imposed quiet time appended to the end of every frame
	- Idle time gives
		- The network media a chance to stabilize
		- Other network components time to process the frame
	- Standard minimum interframe gap: 96 bit times
		- Time = bit time / speed
			- 10Mbps: 9.6ms
			- 100Mbps: 0.96ms
			- 1000Mbps: 0.096ms
		- To calculate % of bandwidth loss caused by interframe gap
			- Let interframe gap be i and Ethernet frame length be f in bits
				- f + i = x
			- Let speed be s in bits per second
				- s / x = y
			- Let l be bits lost per second
				- y * i = l
			- Let a be answer
				- (l / s) * 100 = a
46.	**Describe CSMA/CA.**
	- Carrier Sense Multiple Access with Collision Avoidance
	- Used for wireless Ethernet networks
		- Since wireless transceivers cannot listen to the network for other transmissions while it is transmitting
		- Transmitter simply drowns out any other signal that may be present
	- Instead, hosts attempt to avoid collisions by using random backoff delays to delay transmission when the network is busy
		- ie. Some other host is transmitting
	- Handshaking sequence is used between communicating hosts to help maintain reliable delivery of messages over the air
		- Ready and ACK packets
47.	**Discuss how to use test equipment to detect hardware problems.**
	- May be necessary to use sophisticated test equipment for difficult hardware problems
		- ie. Intermittent connection
		- Test equipment such as
			- UTP: Cable tester
			- Coax: Time domain reflectometer (TDR)
			- Fiber: Optical TDR
			- Network analyser
	- Trust results of test equipment even though it seems hardware being tested is configured correctly
		- ie. UTP cable appears to be wired correctly to RJ-45 connector correctly but test equipment says otherwise
48.	**Describe asymmetric encryption.**
	- See Q28
49.	**How is data hidden inside a WAV?**
	- Through steganography
	- ie. Every 16 samples, the LSB of the sample is set either to 0 or 1, according to data being inserted into the host WAV file
		- To insert a byte (8 bits) of information into a WAV, the LSB of 8 samples out of a 128 bit block of samples is adjusted
	- Changes made are spread out to reduce chance that the audio will be affected
	- Only the LSB is changed so that the smallest possible effect is made to the sample
	- Size of host WAV file determines how much data can be hidden inside
		- ie. 128 byte block method, max hidden file size is determined by
			- f = host filesize, b = 128
			- f / b = capacity
50.	**List the steps in the incident response process.**
	- See Q40
51.	**Describe the Transport Layer of the OSI model..**
	- First layer not concerned with how data actually gets from node to node
	- Assumes physical data is error free
	- Focuses on providing correct communication between applications from a logical perspective
		- ie. Guarantees that a large block of data transmitted in smaller chunks is reassembled in the proper order when received
	- Some functions of Transport layer
		- Creates virtual circuits before transmission
		- Flow control
		- Windowing
		- Sequencing
		- Logical ports
		- TCP/UDP
52.	**Discuss the functionality of PING.**
	- See Q34
53.	**Describe protocol analyzers.**
	- Reports traffic type and usage on a computer network
		- ie. Wireshark
	- Used to identify network problems
	- Can either be
		- Hardware, connects to network
		- Software, installed on host connected to network
	- Collects statistical info about the network performance
		- Usually converted to graphical real-time views
	- RMON / RMON2 standards provide for support of packet capturing and protocol decoding
		- RMON
			- Allows for traffic capturing at the MAC layer
		- RMON2
			- Provides access to information at higher layers in the protocol stack
				- Segment
				- Network address
				- Application layer for a network address
				- Application layer for exchanges between different network addresses
54.	**Describe the Exterior Gateway Protocol.**
	- See Q36
55.	**What is a Java applet?**
	- A program written in Java programming language
	- Specifically written to be executed from a website server, inside a web browser
		- Java Virtual Machine must be built in or available to the browser in order to execute a Java applet
56.	**Discuss the encryption strength of symmetric and asymmetric encryption.**
	- Symmetric encryption
		- One key for encryption/decryption
		- This key must be kept secret but must also be shared if receiver of an encrypted message wishes to decrypt
		- Key must be distributed securely
	- Asymmetric encryption
		- Public/private key pair
			- One key for encryption
			- The other for encryption
			- Or vice versa
		- Private key must be kept secret
		- Public key can be distributed over unsecure channels without compromising private key
	- Strength
		- Asymmetric encryption is more secure since public key can be shared to anyone without risking any secrets
		- On the other hand, if the symmetric key is disclosed to an unauthorised actor, the encryption system is compromised
57.	**Discuss handwriting authentication.**
	- See Q17
58.	**Describe a physical security plan.**
	- Physical security plan is for the premise
	- Should cover methods used to protect the premise
	- Describe procedures required for
		- Maintenance
		- Evacuation due to emergency
		- Shutdown during holidays
		- Planned down times
59.	**Discuss the process of guessing a password.**
	- Can be a random approach
		- Typing in words, combinations of letters / numbers / symbols
	- Can search for password in plaintext
		- ie. Written down on sticky note stuck on monitor
	- Can use personal information about user
		- May have used them as a weak password
			- Birthday
			- Children or pet names
			- Favourite colour
			- Nickname
			- Other personally relevant information
60.	**List and describe what a typical AUP contains**
	- See Q9
