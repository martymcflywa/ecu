# What is a computer network?

## Computer network topology

- It is how individual computers (devices, nodes) connect
- Common logical topologies
	- Fully connected (mesh)
	- Star
	- Bus
	- Hub
- Consider
	- Costs
	- Advantages
	- Disadvantages

![topology examples](http://snag.gy/5Rkys.jpg)


## Wired networks vs. wireless networks

- Disadvantage of wired networks
	- Unsafe, expensive pulling wire, fiber through building
- Wireless network
	- Base station
		- Broadcasts data into air
		- High frequency RF signal
		- Line of sight infrared laser
	- Remote (mobile) stations
		- Stay within base station range
		- Allowed to move about

![wireless examples](http://snag.gy/ltWi2.jpg)

## Representing digital data

- Computer information exchanged in digital form
	- Digital representations vary
- Analog medium transmitting digital data
	- Carrier modulated signal represents data
		- Amplitude modulation
		- Frequency shifting keying
- Digital medium transmitting digital data
	- Digital waveform represents data
		- Frequency shift keying
		- Nonreturn to zero (NRZ) technique
		- Manchester encoding

![digital data representation](http://snag.gy/RTipn.jpg)

## Working with digital data

- Applications use network transmitted digital data
	- Commonly exchange large data amounts
- Secure connections
	- Encrypt data in transit
- Data compression 
	- Reduces storage requirements, downloading time
- Compression and encryption
	- Handled by software
	- Supported by communication rules, protocols
	- Represent data logically

## Communication protocols

- Establish coherent communication between two network nodes
	- Requires advance agreement
		- Information format
		- How to exchange information

### Open Systems Interconnection (OSI) reference model standard

![OSI reference model](http://snag.gy/iiURt.jpg)

- Governs protocol use in computer networks
- Defines seven layers
	- Requires to establish reliable communication
- First and second layers define type of physical signals
- Different protocols used between layers
	- Handle error recovery, information routing
- To remember OSI layer names:
	- All
	- Packets
	- Should
	- Take
	- Network
	- Data
	- Paths

#### Layer 1: Physical layer

- Responsible for transmitting, receiving bits

#### Layer 2: Data-link layer
	
- Frames data, error detection
- Maintains flow control over physical connection
- Works with MAC (Media Access Control) addresses
- Two sublayers
	- LLC (Logical Link Control)
	- MAC (Media Access Control)

#### Layer 3: Network layer

- Routes protocol-specific packets to proper destination

#### Layer 4: Transport layer

- Assumes error-free physical data
- Provides correct communication between applications
	- From logical perspective

#### Layer 5: Session layer

- Handles communication
	- Processes running on two different nodes

#### Layer 6: Presentation layer

- Text compression, conversion, encryption

#### Layer 7: Application layer

- Where actual user program executes
- Makes use of lower layers
- Application Programming Interface (API)
	- Interfaces directly with operation system to perform all network related activities

## Ethernet LANs

- Brief history
	- 1973 - 1975: Developed by Xerox Palo Alto Research Corporation (PARC)
	- 1980: Ethernet promoted as networking standard
- Baseband system
	- Single digital signal transmitted
- Transmission speeds
	- 10 Mbps (10base2, 10base5, 10baseFL)
		- Use different media types (coaxial cable, fiber)
		- Encode data in the same way (Manchester)
	- 100 Mbps, 1000 Mbps, 10,000 Mbps
- 10base2 ethernet device transceiver
	- Provides electronic connection
		- Between device, coaxial cable
	- Converts digital data to signals usable over cable
- Segments
	- Groups devices
		- Tap for each device
	- Important to correctly terminate both ends of cable in each segment
	- Segments connected with repeaters

![11-node ethernet lan](http://snag.gy/9iMe3.jpg)

- Ethernet device has own unique binary address
- Broadcasting
	- Every device on ethernet LAN receives data when one device transmits data
		- Each device waits to see its own address on the network cable before acting on data
- Collision
	- Two or more devices transmit data at the same time
	- Carrier Sense Multiple Access with Collision Detection (CSMA/CD)
		- Transmitting devices stop, wait random time period

![ethernet frame format](http://snag.gy/ySF50.jpg)

- Frame 
	- Format ethernet transmits data

## Token-ring LANs

- Not as popular as ethernet systems
- Advantage
	- Eliminates high ethernet system collision rate
- Basic operation
	- Token circulates between ring nodes
	- Two options when node receives token
		- Passes token on
		- Hold token and transmits its own data frame
	- Data frame examined at each node for ownership
- Disadvantage
	- One node's frame can circulate at any one time

## Network operating systems

- Software
	- Controls communication protocols
	- Provides all networking functions
- Examples
	- Windows (95 and newer)
	- UNIX
	- Linux
	- Mac OS
	- NetWare
- Services provided
	- DHCP
	- Email
	- Authentication
	- Web server
	- FTP server
	- Telnet server
	- Windows provides great control over network operation

![LAN properties in Win XP](http://snag.gy/cAs0V.jpg)

## IEEE 802 standards

- Institute of Elecrical and Electronics Engineers, Inc.
	- Website: [http://www.ieee.org](http://www.ieee.org)
	- Committees dedicated to defining computer networking standards
	- Companies entering networking marketplace
		- Must manufacture networking hardware complying with published standards

![IEEE 802 standard](http://snag.gy/sXBJ1.jpg)

## Troubleshooting techniques

- Troubleshooting can take many forms
	- Hardware, software, both
	- Application failure
- Trial and error required
- Requires organized, systematic approach

### Troubleshooting steps

1. Establish symptoms
2. Identify affected area
3. Establish what has changed
4. Select most probable cause
5. Implement a solution
6. Test the result
7. Recognise solution's potential effects
8. Document the solution

Develop set of procedures for each step

# Network topology

## Physical topology vs. logical topology

- Topology
	- Structure of connections between network computers
- Cloud 
	- Graphic symbol describing network
		- Does not specify nature of connections
- Physical topology
	- Intermediate network nodes, machines, and connection between intermediate nodes
- Logical topology
	- Data packet network path

![network cloud connecting 3 machines](http://snag.gy/Pndq4.jpg)

![physical network topology](http://snag.gy/hcSOh.jpg)

- Network software protocols
	- Properly reassemble packets into correct sequence
	- Eliminate duplicated information
- Virtual circuit between machines
	- Used for large amounts of data
	- Prearranged network path all packets travel
		- Used for particular session between machines
- Virtual private network (VPN)
	- Uses public network connections to establish private communication
		- Encrypts data

![grouping of 20 pcs into 3 virtual lans](http://snag.gy/RAWH4.jpg)

- Special switches allow virtual LANs (VLANs)
- Example for Table 2.1
	- 20 computers connected to three VLAN capable switches
	- Grouped into two or more VLANs

## Fully connected networks

![fully connected](http://snag.gy/DgkEH.jpg)

![number of links in a fully connected network](http://snag.gy/pC7XJ.jpg)

- Most expensive to build
- Number of links (L) required in a fully connected network of nodes (N):

![formula](http://snag.gy/bUlw6.jpg)

- Number of connections at each node
	- Equals total number of nodes minus 1

## Star networks

![star network](http://snag.gy/Y26Ub.jpg)

- All nodes connect to central communications hub (concentrator)
- Small networks
	- Require single hub
		- 4, 8, 16, 32, or more connections available
- Large networks
	- Require multiple hubs
		- Increase in hardware, cabling costs
- Advantage
	- Can isolate failing nodes
- Hub characteristic
	- Broadcasts data received on one port to all other ports
		- Each network node has opportunity to see each packet
- Switch
	- Learns where to send data
		- Eliminates data broadcast traffic
	- Provides star topology

## Bus networks

![bus network](http://snag.gy/0SXSo.jpg)

- All nodes on common bus (cable) compete for possession
	- Broadcast data when an idle bus is detected
- Collision
	- Two or more nodes transmit data at the same time
	- Handled by Carrier Sense Multiple Access with Collision Detection (CSMA/CD)
		- Nodes stop, wait before transmission
- Bus wiring not difficult
	- Daisy chained via T-connectors into one long segment
	- Issues causing intermittent, excessive collisions
		- Bad crimps on BNC connectors
		- Poor connections in T-connectors
		- Improperly terminated cable segment
	- Time domain reflectometer (TDR) used in troubleshooting
- Bus network is easy to set up and cost efficient

## Ring networks

![ring network](http://snag.gy/wRZrE.jpg)

- Each node connected to exactly two other nodes
	- Data circulates in ring
	- Number of links
		- Same as number of nodes (similar to star network)
		- No central hub (differece from star)
- Link failure worst-case scenario
	- Message travels completely around ring (takes time)
- Central multistation access units (MAU)
	- Physical star connection outside
	- Physical ring connection inside

## Hybrid networks

- Combines two or more network topology component
- Requires careful planning
	- Various rules dictate how individual components are connected and used
- Logical viewpoint and overall organization must be planned

![hybrid network](http://snag.gy/9N5ET.jpg)

## Network hierarchy

- Hierarchy
	- Layered organisation
- Switches act like hubs
	- Differ by forwarding data selectively
- Switches enforce hierarchy
	- Learn where data packets should be forwarded
		- Based on destination addresses

![hybrid network hierarchy](http://snag.gy/uy441.jpg)

## Subnets

- IP addresses
	- Unique for each network node
	- 32 bit number
		- Locates, identifies internet nodes
- Subnetting: logical activity
	- Accomplished using special subnet mask
		- Logically `AND`ed with IP address to determine network address
- Subnet mask separates IP address
	- Network portion and host portion
- Nodes on different logical subnets require router

## Network access points

- Provides access to nationa, global traffic network
- Companies can install independent communication networks
	- Connect to one or more NAPs
	- Act as NAPs themselves
- Companies connected to a NAP
	- Enter into peering agreements with each other
		- Allows traffic exchange
	- If traffic is internet based
		- Connection called a point-of-presence (POP)

![RWA software national backbone](http://snag.gy/prgUx.jpg)

## Public networks vs. private networks

- Two most pervasive public networks
	- Public switched telephone network (PSTN)
	- Broadband cable
- Public access requires limitations
	- User bandwidth
	- Legal matters
	- User location
- Private networks
	- Bandwidth limitations dependent on monetary network infrastructure investment
	- Higher maintenance costs per user
- Ways to keep network private
	- Keep all components inside locked building
		- No internet connection
	- Allow internet acces through managed firewall
	- Encrypt all information needing to remain private

## Troubleshooting techniques

- Intentional harm to network
	- Know what is required to partition network
		- Prevents communication
		- Disrupts normal network operation
		- Negatively affects security, reliability
- Network troubleshooting requirements
	- Knowledge of topology
		- Both physical and logical
	- Understanding of how network is partitioned
		- Testing and reparing can proceed smoothly

![partitioning a network](http://snag.gy/skMEN.jpg)

# Networking hardware

## Ethernet cabling

- Three main varieties
	- RG-58 coaxial cable (thin wire): 10base2 operation
	- RG-11 coaxial cable (thick wire): 10base5 operation
	- Unshielded twisted pair (UTP): 10baseT, 100baseT, 1000baseT operation
- Specialized cables
	- Fibre optic cable: 10baseFL

![coaxial cable construction](http://snag.gy/jmKej.jpg)

![ethernet cabling](http://snag.gy/yv6z5.jpg)

![10base2 ethernet wiring](http://snag.gy/4VutI.jpg)

Figure above demonstrates how to connect machines using daisy-chain approach

- RG-11 coaxial cable
	- Backbone cable
- UTP cable
	- Used with hubs, switches and other 10/100baseT equipment
- Twisted pair wires
	- Reduces noise and crosstalk
	- Allows higher speed data rates

### RG-11

![rj-45 (10baseT) connector](http://snag.gy/loX4f.jpg)

![rj-45 pin assignments (568B standard)](http://snag.gy/xG3lK.jpg)

![rj-45 cabling](http://snag.gy/gjLNf.jpg)

### UTP Wiring

Straight-through or crossover cables.

![10baseT ethernet wiring](http://snag.gy/FoPcF.jpg)

### Fibre optic cable

- Light pulses carry information
- Construction
	- Plastic or glass with different physical properties
		- Light beams reflect off boundary between core and cladding
- Single mode or multi-mode allowed
- Advantage
	- Eliminates problems found in copper wires
- Disadvantage
	- Fragile

![fiber optic](http://snag.gy/iYlG4.jpg)

## The NIC

- Interface between networked device and physical network connection
	- Connects to coaxial, UTP, fibre segment
	- Operates in OSI model Physical layer

![nic](http://snag.gy/4gWID.jpg)

### Windows XP and Vista

Identify installed NIC in Local Area Network properties.

![nic in windows 1](http://snag.gy/1zoO3.jpg)

To examine NIC properties in Windows XP or Vista, click configure button.

![nic in windows 2](http://snag.gy/IBN0U.jpg)

### Interface and protocols

- NDIS/ODI interface decouples protocols from NIC
	- Protocols use NDIS/ODI drivers to perform network operations
	- Drivers responsible for specific hardware
- Unique 48-bit MAC address
	- First six digits
		- Manufacturer, vendor
	- Last six digits
		- NIC serial number
- NIC utilizes two addresses
	- MAC address
		- Assigned by manufacturer, unique
	- IP address
		- Assigned by operating system, may change

![ipconfig](http://snag.gy/qIh4d.jpg)

## Token Ring

- Mid 1980s: 4 Mbps (16 Mbps available)
- Multistation access unit (MAU)
	- Establishes ring connection
- Connections made using STP cables

![token ring network](http://snag.gy/bb4LA.jpg)

## Repeaters

- Connets two network segments
	- Broadcasts packets between the segments
	- Amplifies signal, extends usable length
- Common ethernet rule
	- Four repeaters can join up to 5 segments maximum
	- Physical limitations
		- Designed to keep collision detection (CSMA/CD) working properly
- Operates at OSI model layer 1 (physical layer)

## Transceivers

- Convert transmissions from one media type to another
	- Common to use more than one media type in an installation
		- Many different transceivers available
- Operates at OSI model layer 1
- Important when upgrading a network

## Hubs

- Expands one ethernet connection into many
- Similar to repeater
	- Difference
		- Hub broadcasts data received by any port to all other ports on hub
- Contains small amount of intelligence
	- Examples received packets, checks for integrity
- Operates at physical level
- There is a limit to number of hubs connected in series

![connecting 5 10baseT segments with hubs](http://snag.gy/JFsct.jpg)

## Bridges / switches

- Bridge
	- Partition large network into smaller groups
	- Learns which packets cross segments
- Switch
	- Enhancements over bridge
		- Multiple ports for directing packets
		- Store-and-forward
		- Auto-sensing
		- Simple network management protocol (SNMP) support
- Operates at OSI model layer 2 (Data-link)

![operation of a bridge](http://snag.gy/iaVwj.jpg)

## Routers and firewalls

- Router
	- Basic internet building block
	- Connects two or more networks together
	- Examines each packet
	- Connects networks using
		- Different technologies
		- Addressing methods
		- Media types
		- Frame formats
		- Speeds
	- Special purpose device
		- Interconnects networks
	- Maintains routing tables
		- Stores information about network physical connections

![routers](http://snag.gy/Gtj3G.jpg)

![packet routing](http://snag.gy/Yfezi.jpg)

- Firewall
	- Hardware device or software
		- Inspects network traffic
		- Allows or denies traffic according to rule set
	- Purpose
		- Protects a network and computer from outside access

## Cable modems

- High speed network device
	- Connected to local cable television provider
- Data transmission
	- Uses pair of channels (transmit, receive) on cable system
- Internet service provider service
	- At head-end of network
		- Cable supplier office
		- Uses traditional telecommunications devices
- Subscribers to cable modem service
	- Use a splitter to create two cable wires

![cable modems](http://snag.gy/cjZWI.jpg)

## Satellite network system

- HughesNet Internet satellite networking system
	- Download: 500Kbps to 800Kbps
	- Upload: 128Kbps

![satellite internet](http://snag.gy/053YM.jpg)

## Exotic hardware and software

- Replace multiple 16-port switches
	- Use single industrial switch
		- 64 ports or more with port management
- Networks distributed over large geographic area
	- Use line-of-sight infrared lasers
	- Use fiber repeaters
- Wireless ethernet hardware
- Security purposes
	- Use network ready cameras
- Advanced network management software

## Troubleshooting techniques

- Expensive to buy finished cables
- Test equipment available for custom-made cables
	- Cable tester
		- Used in preparing and testing custom-made cables
	- Fluke LANMeter, other sophisticated test equipment
		- Capture and diagnose network packets
		- Gather statistics
		- Perform standard network operations
		- Transmit packets for troubleshooting purposes
- Approach troubleshooting with a fresh mind