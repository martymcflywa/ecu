# Chapter 9: Network organization concepts

## Objectives

- Network topologies
	- Star
	- Ring
	- Bus
	- Tree
	- Hybrid
- Network types
	- LAN
	- MAN
	- WAN
	- WLAN
- Difference between
	- Circuit switching
	- Packet switching
- Conflict resolution procedures
	- Allow network to share common transmission hard/software
- Transport protocol models
	- OSI
	- TCP/IP

## Terminology

- Network
	- Collection of loosely coupled processors interconnected by communication links using
		- Cables
		- Wireless tech
		- Both
- Goal
	- Provide convenient way to share resources
		- Hardware
			- CPU
			- Memory
			- Printers
			- USB ports
			- Hard drives
		- Software
			- Programs
			- Data files
	- Control user access
- Two network OS configurations
	- Network OS (NOS)
		- Add network capability to single user OS
		- Users aware of specific assortment of computers/resources in network
		- Can access them by logging on to appropriate remote host
		- Transferring data from remote host to own computer
	- Distributed OS (D/OS)
		- Users don't need to know where/how each machine is connected to system
		- Can access remote resources as if they were local resources
		- Provides good control for distributed computing systems
		- Allows resources to be accessed in unified way
		- Represents total view across multiple computers for controlling/managing resources without local dependencies
		- Management is cooperative process
			- Encompasses every resources
			- Involves every site
- Distributed OS (D/OS) scope
	- Same managers as normal OS
		- Wider scope
	- Must provide following components
		- Figure 9.1
		- Process/object management
		- Memory management
		- File management
		- Device management
		- Network management
	- Advantages
		- Easy/reliable resource sharing
		- Faster computation
		- Adequate load balancing
		- Good reliability
		- Dependable electronic communications
			- Among network users

![figure 9.1](http://snag.gy/a4YXM.jpg)

- Distributed OS (D/OS) local/remote resources
	- Local resources
		- Own resources in local machine
	- Remote resources
		- Resources of remote machines
	- Processors
		- Referred to as
			- Sites
				- Specific location in a network containing multiple computers
			- Hosts
				- Specific computer found at a site
			- Nodes
				- Name assigned to computer connected to identify it to other computers in network
				- Figure 9.2

![figure 9.2](http://snag.gy/wVwTI.jpg)

- Client/server
	- Alternates between different hosts
	- Depends on requirements

## Network topologies

- The geometric arrangement of connections
	- Cables
	- Wireless
	- Both
- Most common topologies
	- Star
	- Ring
	- Bus
	- Tree
	- Hybrid
- There are tradeoffs for each topology between
	- Fast communication
	- Difficulty of connecting one site to a large number of other sites
- Physical vs. logical
	- Physical topology may not reflect local topology
	- Example
		- Network wired as star can be logically arranged to operate as ring
		- It can be made to manipulate a token in a ring like fashion even though its cables are connected in star topology
- Four criteria when deciding topology
	- Basic cost
		- Expense required to link each site in system
	- Communication cost
		- Time required to send a message from one site to another
	- Reliability
		- Assurance that many sites can still communicate with each other
			- Even if a link or site fails
	- User environment
		- Critical parameter the network must meet to be successful business investment
- There may be several solutions for each customer
	- Best choice would be to consider all four criteria
	- Example
		- Data retrieval company considers fast communication and flexible hardware configuration to be a cost effective investment
		- But a neighborhood charity might put emphasis on having low cost network solution

### Star

- Also called
	- Hub
	- Centralized
- Traditional approach
- All transmitted data must pass through central controller
	- Figure 9.3

![figure 9.3](http://snag.gy/SmR1R.jpg)

- Advantages
	- Easy routing
		- Central station knows path to all other sits
	- Access to network can be controlled easily
	- Priority status can be given to selected sites
- Disadvantages
	- Central site must be
		- Reliable
		- Able to handle all network traffic

### Ring

- All sites connected in closed loop
	- Figure 9.4
	- First site connected to the last

![figure 9.4](http://snag.gy/fzz5d.jpg)

- Can connect to other networks via bridge/gateway
	- Depends on protocol
		- Specific set of rules used to control flow of messages through network
	- Bridge used
		- If other network uses same protocol
	- Gateway used
		- If other network uses different protocol
- Data transmitted
	- In packets
	- Contain source/destination address fields
- Packets
	- Passed from node to node in one direction only
	- Destination copies data into local buffer
	- Continues to circulate until it returns to source node
		- Packet then exits ring
- Multiple rings
	- Double ring
		- Figure 9.5
	- Multiple rings
		- Figure 9.6
	- Provide more flexibility
		- At a cost

![figure 9.5](http://snag.gy/GECg6.jpg)

![figure 9.6](http://snag.gy/P03FK.jpg)

- Advantage
	- Can be designed to allow failed nodes to be bypassed

### Bus

- All sites connected to single communication line
	- Runs length of network
	- Figure 9.7

![figure 9.7](http://snag.gy/Rc4DH.jpg)

- Physically connected by cables
	- Cables don't pass through centralized controller
- Messages from any site circulate in both directions through entire communication line
	- Can be received by all other sites
- Disadvantage
	- Only one node can transmit at one time
	- Control mechanism is needed to prevent collisions
- Data may
	- Pass directly from one device to another
	- Routed to an end point controller at the end of the line
- If data reaches an end point controller without being accepted by a host
	- End point controller turns it around and sends it back so the message can be accepted by appropriate node
- Some bus networks
	- Each message must always travel to the end of the line before going back through the communication line to the destination
	- Allow messages to be sent directly to target
- Advantage
	- If single node fails
	- Message can still flow through network

### Tree

- Collection of busses
	- Communication line is a branching cable
	- No closed loops
	- Figure 9.8

![figure 9.8](http://snag.gy/35OwL.jpg)

- Begins at the head end
	- Where more cables start
- Each cable may have branches that may have additional branches
	- May result in complex arrangements
- Message from any site circulates through the communication line
	- Can be received by all other sites
	- Until it reaches end point
- If message received by end point
	- It is absorbed
	- Not turned around like bus topology
- Advantage
	- If single node fails
	- Message can still flow through network

### Hybrid

- Combination of any four topologies
- Example
	- Replace a single host in star with a ring
		- Figure 9.9
	- Star could have bus topology as one of the communication lines feeding the hub
		- Figure 9.10

![figure 9.9/9.10](http://snag.gy/jx2E9.jpg)

- Objective
	- Select strong points of each topology
	- Combine them to meet communication requirements

## Network types

### Local area network (LAN)

- Configuration found within single building/campus
- Generally owned/used/operated by single organization
- Allows computers to communicate directly through common communication line
- Cluster of computers located in same general area
- LAN can be a component of larger network
- Can provide easy access to other networks through
	- Bridge
	- Gateway

#### Bridge

- Connects two or more geographically distant LANs that use same protocol
- Example
	- Bridge connects two LANs that use Ethernet

#### Gateway

- More complex than bridge
- Connects two or more networks using different protocols
- Will translate one protocol to another
- Resolves hardware/software incompatibilities

#### LAN speed

- 100 megabits per second to 40 gigabits per second
- Due to close distances
	- Bandwidths can support high speed transmission

#### LAN topologies

- Star
- Ring
- Bus
- Tree
- Hybrid

#### LAN medium

- May vary from one topology to another
- Factors selecting medium
	- Cost
	- Data rate
	- Reliability
	- Number of devices
	- Distance
	- Technical limitations

### Metropolitan area network (MAN)

- Spans area larger than LAN
	- Several blocks of buildings
	- Entire city
	- Does not exceed circumference of 100km
- May be owned/operated as public utility
	- Connecting several LANs
- High speed network
- Often configured as logical ring
- Depending on protocol
	- Messages are either transmitted
		- In one direction
			- Single ring
		- In both directions
			- Double ring
				- One ring carries messages in one direction
				- Other ring carries messages in opposite direction

### Wide area network (WAN)

- Connects communication facilities in different parts of the world
- Or operated as part of public utility
- Use communication lines of common carriers
	- Government regulated private companies
		- Communication companies
- Use broad range of media
	- Satellite
	- Microwave
- Speed
	- Limited by capabilities of media used
	- Generally slower than LANs

### Wireless local area network (WLAN)

- Uses wireless tech to connect nodes located within range of network
- Table 9.1
	- IEEE specified several standards for wireless networking
	- Each have different ranges

![table 9.1](http://snag.gy/ZvANn.jpg)

- Provides easy access to Internet for mobile devices
	- Figure 9.11
- Disadvantage
	- Security threat
		- Open architecture
		- Messages in the air

![figure 9.11](http://snag.gy/T6tjr.jpg)

- WiMAX
	- 802.16
	- Deliver high bandwidth data over longer distances
		- 10 miles

## Software design issues

- Four issues must be addressed by network designers
	- How do sites use addresses to locate other sites
	- How are messages routed
		- How are they sent
	- How do processes communicate with each other
	- How are conflicting demands for resources resolved

### Addressing conventions

- Need to determine how to uniquely identify users
	- To communicate with each other and each other's resources
- Require
	- Addresses
	- Names
	- Routes
- Because sites are only connected via point to point links
- Addressing protocols are closely related to
	- Network topology
	- Geographic location of sites
- Distinction is made between
	- Local name
		- Name known within own network
	- Global name
		- Name known outside network
	- Allows freedom to identify units within site own naming/address standards
		- Without imposing uniform naming rules
			- Difficult to implement at local level
	- Global name must follow standard
		- Name length
		- Format
		- Global conventions

#### Email address

- Follows hierarchical convention
	- Logical user to host machine
	- Host machine to net machine
	- Net machine to cluster
	- Cluster to network
- Example
	- `user@ecu.edu.au`
	- Periods separate each component
- Addresses must be translated/resolved by DNS

#### Domain name service (DNS)

- Distributed data query service
- Resolve Internet addresses
- Components of `someone@icarus.lis.pitt.edu`
	- `someone`
		- Logical user
	- `icarus`
		- Host for user called `someone`
	- `lis`
		- Machine for `icarus`
	- `pitt`
		- Cluster for `lis`
	- `edu`
		- Network for university
- Not all components need to be present in all Internet addresses
	- DNS is able to resolve them by examining each one in reverse order

### Routing strategies

- Router
	- Internetworking device
	- Software driven
	- Directs traffic between different types of
		- LANs
		- Network segments
		- Connects different protocols
	- Operates at network layer
- Routing
	- Allows data to get from one point on network to another
	- Each destination must be uniquely identified
	- Once data is at proper network
		- Router makes sure that correct node in network receives message
- Other roles of routers
	- Securing information that is generated in predefined areas
	- Selecting fastest route from one point to another
	- Provide redundant network connections
- Routing protocols
	- Must consider
		- Addressing
		- Address resolution
		- Message format
		- Error reporting
	- Based on addressing format
		- Uses network and node number to identify each node
- When network is powered on
	- Each router records a table of addresses of networks that are directly connected
- Because routing protocols permit interaction between routers
	- Sharing network destinations that each router may have acquired becomes easy
- At specified intervals
	- Each router in internetwork broadcasts copy of its entire routing table
	- Eventually all routers know how to get to each of the different destination networks
- Address resolution
	- Allows router to map original address to a hardware address
	- Store the mapping in a table to be used for future transmission
- Message formats
	- Defined by routing protocols
	- Messages are used to allow protocol to perform its functions
		- Finding new nodes on network
		- Testing to determine whether they're working
		- Reporting error conditions
		- Exchanging routing information
		- Establishing connections
		- Transmitting data
- Data transmission problems
	- Conditions cause
		- Inability to reach destination
			- Due to failed node/network
	- Routers and routing protocols would report error condition
		- But won't attempt to correct error
	- Error correction is up to protocols at other levels in network architecture
- Most widely used routing protocols
	- Routing information protocol (RIP)
	- Open shortest path first (OSPF)

#### Routing information protocol (RIP)

- Selection of a path to transfer data from one network to another based on
	- Distance vector algorithm
		- Number of intermediate nodes/hops between source and destination
		- Path with smallest number of hops is always chosen
- Advantages
	- Easy to implement
- Disadvantages
	- Does not consider other factors
		- Bandwidth
		- Data priority
		- Type of network
		- It can exclude faster more reliable paths from being selected
			- Because they have more hops
	- Entire routing table is updated/reissued every 30 seconds
		- Even if no changes have been made
		- Increases network traffic
		- Negatively affects message delivery
	- Not all routers have the same information
		- A failure at one hop could create unstable network

#### Open shortest path first (OSPF)

- State of network determined first before selecting path
	- If failed hop exists
		- Eliminated immediately until services restored
- Routing update messages sent only when changes in routing environment occur
	- Reducing
		- Traffic
		- Size of messages
			- Not sending entire routing table
- Disadvantage
	- Memory usage increased
		- OSPF tracks more information than RIP
	- Savings in bandwidth consumption are offset by higher CPU usage needed for calculating shortest path
		- Based on Dijkstra's algorithm
- Using Dijkstra's algorithm
	- Computes different paths to get to each destination
		- Creates topological database
	- Data structure is maintained by OSPF
		- Updated whenever failures occur
	- Router checks topological database to determine whether a path is available
	- Then uses Dijkstra's algorithm to generate a shortest path tree to get around failed link

### Connection models

- Data entering network at one point is routed to destination
	- By being switched from node to node
		- Either
			- Circuit switching
			- Packet switching

#### Circuit switching

- Dedicated communication path is established between two hosts
- Path is a connected sequence of links
- Connection between two points exists until one is disconnected
- Connection path must be set up before transmission begins
- If entire path becomes unavailable
	- Messages can't be transmitted
	- Because circuit is not complete
- Example
	- Telephone
- Performance
	- There is delay before signal transfers begin while connection is set up
	- Once circuit is complete
		- Network is transparent to users
		- Information is transmitted at fixed rate
		- Insignificant delays at intermediate nodes

#### Packet switching

- Store and forward technique
- Messages are divided into equal sized units
	- Packets
- Packets sent through network to destination
	- Reassembled into original form
		- Figure 9.12

![figure 9.12](http://snag.gy/QZVHv.jpg)

- Advantages
	- Effective for long distance data transmission
	- Provides more flexibility than circuit switching
		- Permits data transmission between devices that receive/transmit at different rates
- Disadvantage
	- No guarantee that
		- All packets will travel along same path to destination
		- All packets will arrive in correct order
- Packets from one message may be interspersed with packets from another message as they travel to destinations
	- Header containing information about packet is attached to each packet before transmission
	- Information in packet header varies according to routing method used
- Packet vs. circuit switching
	- Table 9.2
	- Packet switching
		- Greater line efficiency
			- Single node to node circuit can be shared by several packets
			- Does not sit idle over long periods of time
			- Delivery may be delayed as traffic increases
				- But packets can still be accepted/transmitted
		- Can allocate priorities to messages
			- Router will send higher priority messages first
		- More reliable
			- Most nodes are connected by more than one link
				- If one circuit fails
				- A different path can be used
	- Circuit switching
		- Overloaded networks refuse to accept new connection until load decreases
