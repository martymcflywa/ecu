# Network organization concepts

## Objectives

- Network topologies
	- Star
	- Ring
	- Bus
	- Tree
	- Hybrid
	- How they connect numerous hosts to the network
- Types of networks
	- LAN
	- MAN
	- WAN
	- WLAN
- Circuit switching and packet switching
	- Examples of use that favor each
- Conflict resolution procedures that allow a network to share common transmission hardware and software effectively
- Two transport protocol models
	- OSI
	- TCP/IP
	- How layers of each compare

## Basic terminology

### Network

- Collection of loosely coupled processors
- Interconnected by communication links
	- Cables
	- Wireless
	- Both
- Common goal
	- Provide convenient resource sharing
	- Control access
- General network configurations
	- Network operating system (NOS)
	- Distributed operating system (D/OS)

### Network operating system

- Network capability
	- Added to single-user OS
- Users aware of specific computers and resources in network
- Access resources
	- Log on to remote host
	- Data transfer from remote host

### Distributed operating system (D/OS)

- Users not aware of specific computers and resources in network
	- Access remote resources as if local
- Good control
	- Allows unified resource access
- Total view across multiple computer systems
	- No local dependencies for controlling and managing resources
- Cooperative management

![figure 9.1](http://snag.gy/0bI4G.jpg)

- Advantages over traditional systems
	- Easy/reliable resource sharing
	- Faster computation
	- Adequate load balancing
	- Good reliability
	- Dependable communications among network users

### Remote

- Other processors and resources

### Local

- Processor's own resources

### Site

- Specific location in network
	- One or more computers

### Host

- Specific computer system at site
	- Services and resources used from remote locations

### Node

- Name assigned to computer system
	- Provides identification

![figure 9.2](http://snag.gy/5qx6a.jpg)

## Network topologies

- Physically or logically connected sites
- Topologies
	- Star
	- Ring
	- Bus
	- Tree
	- Hybrid
- Topology trade-offs
	- Need for fast communication among all sites
	- Tolerance for failure at a site or communication link
	- Cost of long communication lines
	- Difficulty connecting one site to large number of other sites

### Criteria

- Basic cost
	- Expense required to link various sites in a system
- Communications cost
	- Time required to send message from one site to another
- Reliability
	- Assurance of site communication if link or site fails
- User environment
	- Critical parameters for successful business investment

### Star

- Transmitted data from sender to receiver
	- Passes through central controller
- Hub or centralized topology
- Advantages
	- Permits easy routing
	- Easy access control to network
- Disadvantages
	- Requires extremely reliable central site
	- Requires ability to handle all network traffic
		- No matter how heavy

![figure 9.3](http://snag.gy/gp5se.jpg)

### Ring

- Sites connected in closed loop
- May connect to other networks
	- Using bridge
		- Same protocols
	- Using gateway
		- Different protocols
- Data transmitted in packets
	- Source and destination address fields
- Packets passed from node to node
	- One direction only
- Every node must be functional
	- Bypass failed node needed for proper operation

![figure 9.4](http://snag.gy/Zxhez.jpg)

![figure 9.5](http://snag.gy/v7rd0.jpg)

![figure 9.6](http://snag.gy/njxHI.jpg)

### Bus

- Sites connected to single communication line
- Messages circulate in both directions
- One site sends messages at a time successfully
- Need control mechanism
	- Prevent collision
- Data passes directly from one device to another
	- Data may be routed to end point controller at end of the line

![figure 9.7](http://snag.gy/LxlzW.jpg)

### Tree

- Collection of buses connected by branching cable
	- No closed loops
- Designers create networks using bridges
- Message from any site
	- Received by all other sites until reaching end point
- Reaches end point controller without acceptance
	- Host absorbs message
- Advantage
	- Message traffic still flows even if single node fails

![figure 9.8](http://snag.gy/10piE.jpg)

### Hybrid

- Strong points of each topology in combination
	- Effectively meet system communication requirements

![figure 9.9](http://snag.gy/LPNuX.jpg)

![figure 9.10](http://snag.gy/i6LZ6.jpg)

## Network types

- Grouping
	- According to physical distances covered
- Characteristics blurring
- Network types
	- Local area networks (LAN)
	- Metropolitan area networks (MAN)
	- Wide area networks (WAN)

### Local area network (LAN)

- Single, similarly enclosed environment
	- Office building
	- Campus
	- Single organization owns/operates
- Communication through common communication line
- Communications not limited to local area only
	- Component of larger communication network
	- Easy access to outside
		- Through bridge or gateway

#### Bridge

- Connects two or more geographically distant LANs
- Same protocols
	- Bridge connecting two LANs using Ethernet

#### Gateway

- Connects two or more LANs or systems
- Different protocols
	- Translates one network protocol into another
	- Resolves hardware and software incompatibilities
	- SNA gateway connecting microcomputing network to mainframe host

#### Properties

- Data rates
	- 100Mbps to 40Gbps+
- Close physical proximity
	- Very high speed transmission
- Topologies
	- Star
	- Ring
	- Bus
	- Tree
	- Hybrid
- Transmission medium
	- Varies
- Factors determining transmission medium
	- Cost
	- Data rate
	- Reliability
	- Number of devices supported
	- Distance between units

### Metropolitan area network (MAN)

- Configuration spanning area larger than LAN
	- Several blocks of buildings to entire city
		- Not exceeding 100km circumference
- Owned/operated by single organization
	- Used by many individuals and organizations
	- May be owned and operated as public utilities
		- Means for internetworking several LANs
- High speed network often configured as a logical ring

### Wide area network (WAN)

- Interconnects communication facilities in different parts of a country or world
	- Operated as part of public utility
- Uses common carriers' communication lines
- Uses broad range of communication media
	- Satellite
	- Microwaves
- WANs generally slower than LANs
	- Examples
		- ARPAnet
			- First WAN
		- Internet
			- Most widely recognized WAN

### Wireless Local Area Network (WLAN)

- LAN using wireless technology to connect computers or workstations
	- Located within range of network
- Security vulnerabilities
	- Open architecture
	- Difficult keeping intruders out

![table 9.1](http://snag.gy/7JQUi.jpg)

- WiMAX standard 802.16
	- High bandwidth
	- Long distances

![figure 9.11](http://snag.gy/WWgLf.jpg)

## Software design issues

- How do sites use addresses to locate other sites
- How are messages routed and how are they sent
- How do processes communicate with each other
- How are conflicting demands for resources resolved

## Addressing conventions

### Addressing protocols

- Fulfill need to uniquely identify users
- Closely related to site network topology and geographic location

### Local vs. global

- Local name within its own system
- Global name outside its own system
	- Must follow standard naming conventions
		- Length
		- Format

### Example

- someone@icarus.lis.pitt.edu
- Uses Domain Name Service (DNS) protocol
	- General purpose data query service
	- Hierarchical
- Domain names read left to right
	- Logical user to host machine
	- Host machine to net machine
	- Net machine to cluster
	- Cluster to network
- Periods separate components

## Routing strategies

### Router

- Internetworking device
	- Primarily software driven
- Directs traffic
	- Between two different types of LANs
	- Between two network segments
		- Different protocol addresses
- Network layer operation
- Role changes
	- Network design changes
- Connects sites
	- To other sites and Internet

### Router functions

- Securing information
	- Generated in predefined areas
- Choosing fastest route
	- From one point to another
- Providing redundant network connections

### Routing considerations

- Addressing
- Address resolution
- Message format
- Error reporting

#### Address resolution

- Maps hardware address

#### Message format

- Allow performance of protocol functions
	- Finding new network nodes
	- Determine whether they work
		- Testing
	- Reporting error conditions
	- Exchanging routing information
	- Establishing connections
		- Transmit data

#### Common Internet routing protocols

- Routing information protocol (RIP)
- Open shortest path first (OSPF)

### Routing information protocol

- Path selection based on node and hop number
	- Between source/destination
- Path with smallest number of hops chosen
	- Always
- Advantage
	- Easy to implement
- Disadvantages
	- No consideration
		- Bandwidth
		- Data priority
		- Network type
	- Update and reissue routing table
		- Changes or not
	- Tables propagate
		- Router to router

### Open shortest path first

- Network state determined first
- Transmission path selected
- Update messages sent when changes in routing environment occur
	- Reduces number of messages in internetwork
	- Reduces message size
		- Not sending entire table
- Disadvantages
	- Increased memory usage
	- Bandwidth savings offset by higher CPU usage
	- Shortest path calculation

## Communication models

- Communication network concerns
	- Moving data from one point to another
	- Minimizing transmission costs
	- Providing full connectivity

### Circuit switching

- Dedicated communication path
	- Established between two hosts before transmission begins
- Example
	- Telephone system
- Disadvantage
	- Delay before signal transfer begins

### Packet switching

- Store and forward technique
	- Before sending message
		- Divide into multiple equal sized units
			- Packets
	- At destination
		- Packets reassembled into original long format
		- Header contains pertinent packet information
- Advantages
	- More flexible/reliable
	- Greater line efficiency
	- Users allocate message priority

![figure 9.12](http://snag.gy/ZDweA.jpg)

![table 9.2](http://snag.gy/r2wGL.jpg)

### Datagrams

- Packet destination and sequence number added to information
	- Uniquely identifying message to owning packet
- Each packet handled independently
- Route selected as each packet accepted
- At destination
	- All packets of same message reassembled
- Message not delivered until all packets accounted for
- Receiving node requests retransmission
	- Lost or damage packets
- Advantages
	- Diminishes congestion
	- Sends incoming packets through less heavily used paths
	- Improves reliability
	- Alternate paths set up upon node failure

### Virtual circuit

- Complete path sender to receiver
	- Establishes before transmission starts
- All message packets use same route
- Several virtual circuits to any other node
- Advantages
	- Routing decision made once
	- Speeds up transmission
- Disadvantages
	- All virtual circuits fail upon one failure
	- Difficult to resolve congestion
		- In heavy traffic

## Conflict resolution

- Device sharing requires access control methods
	- Facilitates equal and fair network access

### Access control techniques

- Round robin
- Reservation
- Contention

#### Round robin

- Node given certain time to complete transmission
- Efficient
	- If many nodes transmitting over long time periods
- Substantial overhead
	- If few nodes transmit over long time periods

#### Reservation

- Good if lengthy and continuous traffic
- Access time on medium divided into slots
- Node reserves future time slots
- Good configuration
	- Several terminals connected to host through single I/O port

#### Contention

- No attempt to determine transmission turn
- Nodes compete for medium access
- Advantages
	- Easy implementation
		- Works well under light to moderate traffic
	- Better for short and intermittent traffic
- Disadvantages
	- Performance breaks down under heavy loads

### Medium access control protocols

- Carrier sense multiple access (CMSA)
- Carrier sense multiple access with collision detection (CSMA/CD)
- Token passing
	- Token bus
	- Token ring
- Distributed queue, dual bus (DQDB)

#### Carrier sense multiple access (CMSA)

- Contention based protocol
- Easy implementation (Ethernet)
- **Carrier sense**
	- Node listens to or tests communication medium before transmitting messages
	- Prevents collision with node currently transmitting
- **Multiple access**
	- Several nodes connected to same communication line as peers
	- Same level and equal privileges
- Disadvantages
	- Collision
		- Two or more nodes transmit at same time
	- Probability of collision increases
		- As nodes get further apart
	- For large or complex network
		- Less appealing access protocol

#### Carrier sense multiple access with collision detection (CSMA/CD)

- Modification of CSMA
- Includes collision detection (Ethernet)
- Reduces wasted transmission capacity
- Prevents multiple nodes from colliding
	- Collisions not completely eliminated
	- Only reduced
- Implemented in Apple's cabling system
	- LocalTalk
- Collision occurrence involves small packet
	- Not actual data
		- In case of Apple CSMA/CA
- No guarantee data will reach destination
	- Ensures error free data delivery

#### Token passing

- Special electronic message
	- Token
	- Generated and passed node to node
- Only node with token allowed to transmit
	- Then passes token
- Fast access
- No collisions
- Typical topologies
	- Bus
	- Ring

##### Token bus

- Token passed to node in turn
	- Data attached
	- Sent to destination
- Receiving node
	- Copies data
	- Adds acknowledgement
	- Returns packet to sending node
- Sending node passes token to next node in sequence
- Initial node order determination
	- Cooperative decentralized algorithm
	- Then determined by priority based on node activity
- Higher overhead at each node
	- Than CMSA/CD
- Nodes have long waits before receiving them

##### Token ring

- Token moves between nodes in turn
	- One direction only
- To send message
	- Node must wait for free token
- Receiving node copies packet message
	- Sets copied bit indicating successful receipt

#### Distributed queue, dual bus (DQDB)

- Dual bus configuration
	- Each bus transports data one direction only
	- Steady stream of fixed sized slots
- Slots generated at end of each bus
	- Marked as free and sent downstream
		- Marked as busy and written to
		- Written by nodes ready to transmit
	- Nodes read and copy data from slots
	- Continue travel towards end of bus
		- Dissipate

![figure 9.13](http://snag.gy/qf6JZ.jpg)

- DQDB advantages
	- Negligible delays under light loads
	- Predictable queuing under heavy loads
	- Suitable for MANs managing large file transfers
	- Satisfy interactive users' needs

## Transport protocol standards

- Network usage grew quickly
	- 1980s
- Need to integrate dissimilar network devices
	- Different vendors
- Creation of single universally adopted architecture
	- OSI reference model
	- TCP/IP

### OSI reference model

- Basis for connecting open systems
	- Distributed applications processing
- Open
	- Connect any two systems conforming to reference model and related standards
		- Vendor independent
- Similar functions collected together
	- Seven logical clusters
		- Layers

#### Layer 1: Physical

- Describes mechanical, electrical, functional specifications
- Transmits bits over media
	- 100-BaseT
	- RS449
	- CCITT V.35

#### Layer 2: Data link

- Establishes/controls physical communications path before data sent
- Transmission error checking
- Problem resolution (on other side)
	- HDLC
	- SDLC

#### Layer 3: Network

- Addressing and routing services moving data through network to destination

#### Layer 4: Transport

- Maintains reliable data transmission between end users
- Example
	- Transmission control protocol (TCP)

#### Layer 5: Session

- Provides user oriented connection service
- Transfers data over communication lines
- Example
	- TCP/IP

#### Layer 6: Presentation

- Data manipulation functions common to many applications
	- Formatting
	- Compression
	- Encryption

#### Layer 7: Application

- Application programs, terminals, computers
	- Access network
- Provides user interface
- Formats user data before passing to lower layers

### Transmission control protocol/Internet protocol (TCP/IP)

- Oldest transport protocol standard
- Internet communications basis
- File transport protocol (FTP)
	- Send large files error free
- TCP/IP
	- Emphasizes internetworking
	- Provides connectionless services
- Organizes communication system
- Three components
	- Processes
	- Hosts
	- Networks
- Four layers

![figure 9.15](http://snag.gy/VgvCG.jpg)

#### Network access layer

- Protocols provide access to communication network
- Performs
	- Flow control
	- Error control between hosts
	- Security
	- Priority implementation

#### Internet layer

- Equivalent to OSI model network layer performing routing functions
- Implemented within gateways and hosts
- Example
	- Internet protocol (IP)

#### Host to host layer

- Transfer data between two processes
	- Different host computers
- Performs
	- Error checking
	- Flow control
	- Manipulate connection control signals
- Example
	- Transmission control protocol (TCP)

#### Process/application layer

- Protocols for
	- Computer to computer resource sharing
	- Terminal to computer remote access
- Examples
	- FTP
	- SMTP
	- Telnet

## Summary

- Network operating systems coordinate functions
	- Memory manager
	- Processor manager
	- Device manager
	- File manager
- Must meet owner reliability requirements
	- Detect node failure
	- Change routing instructions to bypass
	- Retransmit lost messages successfully
- Basic network organization concepts
	- Terminology
	- Network topologies/types
	- Software design issues
	- Transport protocol standards
