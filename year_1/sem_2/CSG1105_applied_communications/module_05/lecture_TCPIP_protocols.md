# The TCP/IP protocols

## Introduction

- TCP/IP network model contains five layers

![tcp/ip layers](http://snag.gy/Z0qQM.jpg)

- Data packet transmitted from source computer
	- Contains an informational header for each layer

![tcp/ip layer stack](http://snag.gy/ZNtfr.jpg)

- TCP/IP supports many protocols

![tcp/ip protocol suite](http://snag.gy/JH5uA.jpg)

## RFCs

- Describe TCP/IP protocols in detail
- Official Internet standards
	- Published as electronic documents

![tcp/ip rfcs](http://snag.gy/MtAaC.jpg)

## IP

- TCP/IP protocol suite base layer
	- Used at the TCP/IP stack Internet layer
- Datagram
	- Unit of packaged TCP/IP data
		- Encapsulates all TCP/IP protocols
		- Exception
			- Address resolution protocols
	- Eventually encapsulated inside a hardware frame

![ip datagram encapsulated in ethernet frame](http://snag.gy/4bCkn.jpg)

### IP transmission

- Basic IP datagram transmission
	- Source computer sends packets via local LAN
		- Forwarded to destination
		- Router forwards packet to another router or local LAN computer
	- IP datagram pieces treated as independent entities
		- May take different routes
		- Destination computer may receive packets out of order
- IP is unreliable
	- Offers best effort delivery
		- No guarantees of data delivery

### IP congestion

- Congested network
	- Datagrams discarded
	- ICMP contains error message
		- May/not be returned
- IP datagram encapsulated in hardware frame
	- Uses local network maximum transmission unit (MTU)
		- Typically 1500 bytes
	- Fragmentation occurs when different MTUs encountered

![icmp encapsulated in an ip datagram](http://snag.gy/Tolgy.jpg)

## IP addresses

- Routes IP datagram across network
	- Uses dotted decimal notation
- Assigned by software
	- Static or dynamic
	- Must be unique
	- Differs from MAC address
		- Fixed 48-bit addresses encoded into Ethernet controller

![class-c network ip address](http://snag.gy/OBdop.jpg)

### IP address classification

- Five Internet address classifications
	- Each contains
		- Network ID
		- Host ID

![ip address classes](http://snag.gy/qc0bv.jpg)

### Reserved IP addresses

- Some IP addresses reserved
- IPv4 addressing scheme shortcoming
	- Unused hosts in
		- Class A
		- Class B
	- Shortage of all Internet addresses

![special ip addresses](http://snag.gy/p6heg.jpg)

## TCP

- Allows two computers to communicate together over interconnected networks
	- Connections established through predefined ports/sockets
		- Reliable
		- Error checking
		- Packet received acknowledgement
		- Packet sequencing
- Provides communication link between application and IP
	- Uses a set of function calls
		- Provides application process different options
- Reliable and connection oriented

### TCP header

- TCP header and associated data
	- Encapsulated into IP datagram and hardware frame

![tcp datagram format](http://snag.gy/43W2t.jpg)

### TCP purpose

- Primary purpose of TCP
	- Provide guaranteed delivery on top of IP
	- Areas requiring attention to guarantee delivery
		- Data transfer
		- Reliability
		- Flow control
		- Multiplexing
		- Connections
		- Message precedence
		- Security

### TCP ports

- Data communicated between two TCP applications utilize specific ports
- Port
	- Associated with network socket
	- Used by the application
- Pairs of sockets uniquely identify network connection

## UDP

- Connectionless and unreliable
	- Many applications do not require TCP handshaking overhead and complexity, for example:
		- Domain Name Service (DNS)
		- Dynamic Host Configuration Protocol (DHCP)
		- Network games

![udp datagram format](http://snag.gy/xrquF.jpg)

## ARP and RARP

- **Address Resolution Protocol (ARP)**
	- Uses a directed broadcast message
		- Obtains MAC address for a given IP address
	- ARP messages
		- Not encapsulated within an IP datagram
		- Encapsulated directly into an Ethernet frame
	- Not routable
		- Locates machines on local network
		- Internet traffic forwarded to the default gateway
- **Reverse Address Resolution Protocol (RARP)**
	- Provides IP address for a specific MAC address
	- RARP message format
		- Is the same as ARP message
- ARP application program runs from DOS prompt
	- Displays/manages IP/MAC address table

![arp messages in ethernet frame](http://snag.gy/dQgP1.jpg)

![using arp and rarp](http://snag.gy/iQjXV.jpg)

## TCP/IP support protocols

- **Domain Name Service (DNS)**
	- Converts host name to IP address
		- And vice versa
	- Makes it easier to remember an address
- **Bootstrap Protocol (BOOTP)**
	- Routable UDP protocol
	- Allows diskless workstations to
		- Discover its own IP address
		- Discover IP address of a BOOTP server
		- Specify file to be downloaded via TFTP and executed
			- **Trivial FTP (TFTP)**
				- Simple file transfer protocol
				- Used when user authentication not necessary
- **DHCP**
	- Dynamically assigns IP addresses to network devices during bootstrap process
		- Simplifies network administration
- **ICMP**
	- Contains error message for IP datagram error
- **SMTP**
	- Routes electronic mail on the Internet using TCP/IP
- **SNMP**
	- Defines format and meaning of messages exchanged by manager and agents
- **HTTP**
	- Transfers multimedia information over the Internet
- **HTPS**
	- Exchanges encrypted Web pages between a client/server connection
- **NTP**
	- Synchronizes the time of multiple network computers

## TCP/IP applications

![comparison of different network utilities](http://snag.gy/bhzjE.jpg)

- FTP
	- Allows users to
		- Log in to a remote computer
		- Transfer files back and forth through simple commands
- Telnet
	- Allows users to
		- Establish remote computer terminal emulation connection

## IP version 6 (IPv6)

- Next generation Internet
	- Resolves many problems in IPv4
- Changes from IPv4
	- 128-bit addressing
		- Accommodates foreseeable network growth
	- Different header formats
		- New extension headers
		- Support for audio/video
	- All possible protocol features not specified
		- Allows for adding new features
		- No need to update the protocol

### IPv6 addresses

- 128-bits long
	- Written using colons `:`
- Uses 4-digit groups of hexadecimal numbers
	- Hexadecimal group represents 16 bits of binary addressing information
- Shorthand technique eliminate groups of 0000 patterns
	- With double-colons `::`
- Composed of network, host addressing bits
	- Subnet mask determines network associated with a specific IP address
	- Can attach subnet mask IP addresses

## Protocol analyzers

- Hardware or software devices
	- Listens to network traffic
	- Captures packets for examination
- Doubles as cable testers

## Troubleshooting techniques

- Config utilities
	- Windows `ipconfig`
	- Linux `ifconfig`
	- Displays various IP address information
- Network utilities
	- Handy for many reasons
	- On the spot troubleshooting
	- Can be combined to resolve issues
