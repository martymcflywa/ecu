# Network design and troubleshooting scenarios

## Network design

### Two computers

- Several ways to connect computers
	- Direct cable
		- Least expensive
		- Win 9x or Windows XP uses serial, parallel cable

![two computers](http://snag.gy/MAXrP.jpg)

- Host computer provides resources
- Guest computer wants access over the connection
- Switch between Guest mode and Host mode
	- Left-click the Change tab

![win 9x direct cable connection](http://snag.gy/GSZDy.jpg)

- Windows XP requires username and password
- Properties button
	- Access config options

![xp direct cable connection](http://snag.gy/5Uhmu.jpg)

- Windows Vista
	- No support for direct cable connection option
	- Uses wireless networking and USB connectivity
- Network interface cards
	- Less expensive than modems
	- No hub required to connect two computers
		- Uses crossover cable (10/100baseT)
- Modems offer slowest connection speed
	- Useful for connection over a large distance
	- Uses PSTN
		- Public switched telephone network

### Small lab

- Requirements for networking small laboratory
	- Two possibilities
		- Uses one or more hubs or switches (10/100baseT)
		- Use coax (10base2)
- Hubs and switches
	- More expensive than coax
	- Advantages over coax
		- Better speed, connections
	- Switches
		- Establish a network hierarchy
		- Guarantees bandwidth

![small lab](http://snag.gy/kbQWy.jpg)

- Coaxial cable
	- Used in the early days of Ethernet
	- Saved on hardware costs
	- Required more installation time
- IBM mainframe environment
	- Token-ring network
		- Required one or more MAUs, STP cables
	- See figures 6-3(b) through 6-3(d)
- Network software must be configured
	- Windows machines with built-in networking support
		- Automatically communicate over the networking using TCP/IP
		- Static address assignment:
			- Class C address range of 192.168.xxx.xxx
		- Default dynamic assignment:
			- Class B address range starting with 169.254.x.x
	- Linux environment, other environments
		- Both static and dynamic TCP/IP addressing used

### Small business

- Requires hybrid network
	- Hubs and/or switches group bunches of PCs together
	- UTP or fiber optic cable connect hubs or switches
	- Switches
		- Relieve traffic congestion
		- Allows repartitioning

![small business](http://snag.gy/dmXWP.jpg)

- Reasons coax is not used to wire entire building
	- Requires segments connected with repeaters
	- 95 pairs of crimps necessary to daisy chain link all machines
		- Disaster if one crimp fails
	- Speed
		- 106,000 bits/second per machine
			- Or less
- Switch-based topologies
	- Could guarantee 10/100 Mbps to each machine
- Heavily data dependent business
	- Connect each floor via fiber
		- Utilize Fast or Gigabit Ethernet technology
		- Fiber switch or fiber ring topology

![sample office building topologies](http://snag.gy/Nfots.jpg)

### College campus

- Example: 14 laboratories
	- 16 machines
		- Standalone network printer each
	- Number of labs circled
	- Faculty and staff also connected

![computer center](http://snag.gy/iruiZ.jpg)

- Computer center
	- Each building connects to a central communications rack
	- Pair of fibers from each building plug into a 100 Mbps fiber switch
		- Duplex cable

![typical campus building](http://snag.gy/wjKbW.jpg)

- Typical campus building
	- Fiber transceivers
		- Convert between fiber and 10base5 coaxial backbone
	- Switch on each floor isolates traffic
- Central communications rack switch
	- Provides hierarchy between adminsitration and faculty/student mainframes
	- Router connected to switch performs gateway duties
	- Connects to a modem bank
- Results
	- Few IP addresses for future expansion
	- Network speed limited to 10 Mbps
- Proposed solution
	- Replace fiber-to-10base5 transceiver with a fiber-to-100baseT switch
		- Feed each floor with its own 100baseT cable
	- Replace all hubs with 10/100baseT switches
	- Install new 10/100baseT NICs in selected machines
- Accepted solution
	- Fiber to each floor
	- Gigabit backbone
	- Additional T1 line

### Remote access methods

![remote access](http://snag.gy/olBRo.jpg)

- Provide access to public/private networks and the Internet
- DSL
	- Digital Subscriber Line
		- Increasingly popular for individuals
		- Dedicated connection "always on" feature
			- Fraction of cost of a T1 line
			- Reasonable speed
- ADSL
	- Asymmetric DSL
		- Upstream bandwidth lower than downstream bandwidth
- DSLAM
	- DSL Access Multiplexer
		- Key component int Central Office
		- Manages voice and data traffic
			- Between residential user, PSTN switch, ISP

![dsl architechture](http://snag.gy/6cIoh.jpg)

### Wirless

- Wireless networking example (see Figure 6-10)
	- Seminar room wireless access point (WAP)
		- Connected to campus network
		- Provides up to ten simultaneous wireless connections
		- 150 ft indoor range
		- 400 ft outdoor range
	- 30 ft wide rooms
	- 10 ft wide hallway
	- Four laptops configured same way
- Wireless laptops C and D cannot establish connection to WAP
	- Cause: nature of environment

![wireless network](http://snag.gy/dUhO5.jpg)

## Troubleshooting techniques

- Monitor network baseline utilization
	- Provides a feel for "normal" operation
	- Helps identify problem source
- Checking the hardware
	- Check System Properties window
	- Review list of installed hardware
	- Never assume everything is connected properly
- Using test equipment
	- Helpful for really difficult hardware problems
	- Cable tester UTP
	- Time domain reflectometer TDR for:
		- Coax
		- Optical TDR (fiber)
		- Network Analyzer
- What's my IP
	- Check network connection status to determine IP address
		- Use Network Connection Details window
			- Windows XP

![network connection details](http://snag.gy/FKF3d.jpg)

- Check the network neighborhood
	- Verify machine properly networked
	- Open My Network Places
		- Show network hosts sharing resources
- Can you PING
	- Successfully pinging network host
		- Proves successful hardware and software operating correctly
	- Successful PING of host using its IP address but not its domain name
		- Possible problem with DNS server
