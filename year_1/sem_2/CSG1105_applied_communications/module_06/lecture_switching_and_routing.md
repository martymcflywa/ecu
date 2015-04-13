# Switching and routing

## Hubs vs. switches

- Hubs broadcast received frames to all other ports
- Switches forward received frames to a specific port
- Fully switched network
	- LAN stations connect to a switched port
	- Partitions network into separate collision domains
		- Stations have unrestricted access to dedicated bandwidth
			- Operate at switched port speed
		- Maximum Ethernet network size
			- 1024 nodes
	- Switches learn associated port MAC address

![hub vs. switch](http://snag.gy/ExyA4.jpg)

### Inside a switch

![block diagram switch](http://snag.gy/tT7FB.jpg)

- Switch components
	- Input port logic contains:
		- Ethernet receiving logic
		- Buffer for received frames
	- Output port logic contains:
		- Ethernet transmitter
		- Output frame buffer
	- Switching fabric
		- Directs input port frames to the output port
		- Handles broadcasts to all output ports
		- Crossbar switch:
			- Two dimensional set of data buses
		- Multiplexed bus:
			- Makes one input-output connection at a time
	- Control logic chores
		- Updating, searching MAC address table
		- Configuring switching fabric
		- Maintaining proper flow control through switch fabric
	- Content addressable memory (CAM)
		- Stores MAC address
		- Stores port numbers

## Store-and-forward vs. Cut-through switching

### Store-and-forward switching

- Entire frame stored when received
	- No immediate routing decisions made
	- Latency
		- Delay between frame receive time and transmission start time
		- Dependent on frame length
		- Minimum latency obtained with minimum size frame
		- Applications may be sensitive to latency
			- Streaming video
			- Streaming audio

### Cut-through switching

- Forwarding process begins immediately
	- When incoming frame destination MAC address received
- Advantages of cut-through switching
	- 10-Mbps Ethernet latency reduced to 11.2 microseconds
		- Plus any additional time for internal switch operations
	- Fixed latency
- Disadvantages
	- Error propagation

### Spanning trees

- Compatible switch uses a Spanning Tree algorithm
	- Spanning Tree Protocol (STP)
		- Prevents looping
		- Prevents network flooding from duplicated data frames
- Dynamic filtering
	- Redundant links causing loops held in reserve
- Rapid Spanning Tree Algorithm and Protocol (RSTP)
	- Replaced Spanning Tree Protocol
	- Multiple Spanning Tree Protocol (MSTP)
		- Supports multiple trees in the network

## Switch vs. router

- Switches:
	- Layer 2 (Data-link) devices
	- Use MAC addresses to forward frames
	- Used within networks to forward local traffic
- Routers:
	- Layer 3 Hardware device
	- More complex than a switch
		- Microprocessor-based circuitry
	- Higher latency than a switch
		- Additional packet processing required
- Non-routable protocols pass through switches
	- Not routers

>**NOTE:** The higher the layer, the higher the latency. Use the lowest layer technology where possible when implementing a network.

## Routing protocols

- Perform different type of packet forwarding
- Operate at Network layer
	- Layer 3
	- Logical network formed by routers
		- ie. Internet
- Router
	- Moves data between source and destination computers
		- Can be different network types
	- Follows general ground rules
- Windows NETSTAT program
	- Shows currently active routes

### Routing tables

- Routing table creating and maintenance methods
- Static routing
	- A number of predefined routes created
	- Router lacks ability to discover new routes
	- Network admin involvement required
	- Not fault tolerant
- Dynamic routing
	- New routes discovered
		- Old routes updated as required
	- Routing tables maintained automatically
	- Fault tolerant
	- Uses distance-vector or link-state routing algorithm

## Interior vs. exterior routing protocols

### Autonomous systems

- Individual networks
	- Grouped together by region
	- Controlled by a single administrative authority
- Autonomous system (AS) number
	- Associated with each autonomous system
- Have single, clearly defined external routing policy
- Interior Gateway Protocol (IGP)
	- Used inside of autonomous systems
- Exterior Gateway Protocol (EGP)
	- Exchange information between different systems

### Interior Gateway protocols

- Communication inside autonomous systems
	- Many protocols used as IGPs for IP networks
		- Gateway-to-Gateway Protocol (GGP)
		- Routing Information Protocol (RIP)
		- Routing Information Protocol 2 (RIP-2)
		- Interior Gateway Routing Protocol (IGRP)
		- Extended Interior Gateway Routing Protocol (EIGRP)
		- Open Shortest Path First (OSPF)
		- Intermediate System to Intermediate System (IS-IS)

### Exterior Gateway protocols

- Used between different autonomous systems
	- Define how networks within an AS advertise outside the AS
		- AS advertises "reachability" to connectable networks
	- Use Exterior Gateway Protocols (EGP) messages
		- Independent of IGPs used within AS
		- Facilitates exchange of routes between AS using different IGPs
	- Protocols used for EGPs in IP networks
		- Exterior Gateway Protocol (EGP)
		- Border Gateway Protocol (BGP)
		- Open Shortest Path First (OSPF)

## Classless inter-domain routing (CIDR)

- Developed to recover unused class A and class B network addresses
- Supported by interior and exterior gateway protocols
- Based on route aggregation
- Known as **supernetting**
- Eliminates class concept
	- IP addresses and their subnet masks:
		- Written as
			- Four octets
			- Separated by periods
		- Followed by
			- Forward slash
			- Two-digit number that represents subnet mask length

### CIDR Example

- Class B network 178.217.0.0
	- Class C supernet address in CIDR notation
		- 178.217.0.0/24
		- /24 indicates a 24bit subnet mask

### Route aggregation

- Using several routes so that a single route can be advertised
	- Minimizes routing table size

## Distance-vector, link-state and policy routing algorithms

### Distance-vector routing algorithm

- Also called Bellman-Ford algorithm
- Based on number of hops in a route
	- Between source and destination computers
- Distance-vector routing algorithm
	- Each router sends entire routing table to its neighbor
		- Every 30 seconds
	- Distributed between network routers
- Metric based on number of hops to take to reach destination
	- Number of hops from any router to itself
		- = 0
	- Connection to a neighbor
		- = 1

>**NOTE:** This algorithm does not take into account throughput/speed, latency, congestion level, cost. Will always choose route with least number of hops/routers.

#### Routing Information Protocol (RIP)

- Uses User Datagram Protocol (UDP) transport
	- Router hops specified in 4-bit field
		- Max 15 hops
	- Field value of 16 (all 1s) represents infinity
- Disadvantages
	- Bandwidth usage can become excessive
	- Difficult to debug
	- No security
- Benefits
	- Runs on every router platform
	- Little effort to configure RIP protocol
	- No computation/storage requirements
- RIP-2 provides additional features

#### Inter-Gateway Routing Protocol (IGRP)

- Cisco-proprietary solution to RIP issues
- Regarded as an Interior Gateway Protocol (IGP)
	- Used as Exterior Gateway Protocol (EGP) for inter-domain routing
- Hold down feature prevents premature use of unstable route
- Poison-reverse update to eliminate routing loops
- Split horizon prevents information from being sent back on a source direction link
- Offers several new timer variables

#### Enhanced Inter-Gateway Routing Protocol (EIGRP)

- Cisco-proprietary solution
- Improves IGRP operating efficiency by using:
	- Distributed update algorithm
	- MD5 authentication
	- Protocol Independent Routing
	- Metric changes
		- Exchanged every 90 seconds
		- Replaces exchanging entire routing tables
	- CIDR support

### Link-State routing algorithm

- Broadcasts cost of reaching each neighbor
	- To all network routers
	- Creates consistent network view at routers
- Method to computer shortest distance
	- Based on **Dijkstra's algorithmm**
		- Open shortest path algorithm
- Difference between distance-vector and link-state routing
	- Path with least hops may not be chosen as the least-cost route
- Many routing protocols based on link-state algorithm
	- End System to Intermediate System
	- Intermediate System to Intermediate System
	- NetWare Link Services Protocol
	- Interior-Domain Routing Protocol
	- Exterior Gateway Protocol
	- Border Gateway Protocol

### Policy routing algorithm

- Routing based on factors other than **shortest path**
- Primary use
	- Accommodates interconnected networks acceptable use policies
- Other considerations
	- Contract obligations
	- Quality of service
		- Resource reservation
	- Service provider selection
	- Border Gateway Protocol (BGP) supports policy-based routing
	- Complex set up and management
	- Great rewards

## Multi-protocol label switching

- Allows faster, cheaper IP routers
	- Based on Asynchronous Transfer Mode (ATM) technology
- Labels:
	- Shorted than IP addresses
	- Packets forward faster
	- IP address independent allowing for policies
- Layer 2 network link information integerated into Layer 3 (IP)
	- Occurs within a particular AS
		- Simplifies, improves IP datagram exchange
- Great flexibility to divert and route traffic

## Private network-network interface

- ATM forum specification
	- For protocols between switches in private ATM network
- Two main features
	- Routing protocol
		- Reliably distributes network topology information
		- Paths to any addressed destination computed
	- Signaling protocol
		- Establishment and takedown of point-to-point and point-to-multipoint connections

## Layer 3 switching

- Switch and router combined into one package
- Reason for popularity
	- Ever-increasing demand for bandwidth and services
- Utilizes Application Specific Integrated Circuit (ASIC) technology
	- Implements routing functions in hardware
	- Switch performs router duties
		- Forwarding frames significantly faster
- Layer 3 switch has many benefits

## Inside an ISP

![isp building layout](http://snag.gy/4GsB6.jpg)

![isp network topo](http://snag.gy/ZOb9Z.jpg)

## Troubleshooting techniques

- Look at the big picture
- Use [internettrafficreport.com](http://www.internettrafficreport.com)
	- Check router status across the Internet
	- Check traffic characteristics
- Use [internetpulse.net](http://www.internetpulse.net)
	- Provides information for
		- Latency
		- Network utilization
		- Packet loss
	- For major Internet backbone Tier One providers
- Use [caida.org](http://www.caida.org)
	- Underlying Internet network topology information
