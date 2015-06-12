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
	- Non-returning to zero encoding
	- Manchester encoding
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
16.	List four benefits of either replacing the campus or corporate routers with layer 3 switches or adding layer 3 switching to a router-less network.
17.	Discuss handwriting authentication.
18.	How do you prevent booting from a USB thumb drive?
19.	List and describe what a typical AUP contains.
20.	What is the pre-incident preparation that must take place for a CSIRT?
21.	Describe how data is represented when an analog medium is used.
22.	Discuss subnetting.
23.	List the three varieties of Ethernet cables.
24.	Describe a router.
25.	Describe the destination address of an Ethernet frame.
26.	List three properties that 10base5, 10base2 and 10baseT have in common.
27.	List the chores that the control logic must perform.
28.	Describe asymmetric encryption.
29.	What is a frequency analysis?
30.	List the skills that you need to become proficient at analyzing malware.
31.	Describe a hybrid network.
32.	Describe a private network.
33.	Discuss why the use of coax in Ethernet networking is obsolete.
34.	Discuss the functionality of PING.
35.	List the chores that the control logic must perform.
36.	Describe the Exterior Gateway Protocol.
37.	List five disaster recovery safeguards that can be used to help guarantee a relatively quick and painless recovery in the event that a disaster occurs.
38.	What is a firewall?
39.	Discuss the encryption strength of symmetric and asymmetric encryption.
40.	List the steps in the incident response process.
41.	Describe how data is represented when an analog medium is used.
42.	Describe what happens when a collision on an Ethernet LAN occurs.
43.	Describe a hybrid network.
44.	Describe UTP cable.
45.	What is the interframe gap?
46.	Describe CSMA/CA.
47.	Discuss how to use test equipment to detect hardware problems.
48.	Describe asymmetric encryption.
49.	How is data hidden inside a WAV?
50.	List the steps in the incident response process.
51.	Describe the Transport Layer of the OSI model..
52.	Discuss the functionality of PING.
53.	Describe protocol analyzers.
54.	Describe the Exterior Gateway Protocol.
55.	What is a Java applet?
56.	Discuss the encryption strength of symmetric and asymmetric encryption.
57.	Discuss handwriting authentication.
58.	Describe a physical security plan.
59.	Discuss the process of guessing a password.
60.	List and describe what a typical AUP contains
