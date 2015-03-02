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