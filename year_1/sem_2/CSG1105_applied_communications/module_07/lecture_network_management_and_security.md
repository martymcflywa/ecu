# Network management and security

## Network management

- Important task in a networked computer environment
- Function performed by
	- Sys admin
	- Network manager
	- Engineer
- Maintain current network view (status) through:
	- Planning essential network elements and categories
	- Record keeping
- Review and select new network tech
- Perform research and invest time for success
	- Read trade magazines
	- Attend conferences
	- Networking with other IT professionals

## Disaster recovery

- Computer lab or network operations center
	- Have many potential disasters
- Disaster recovery
	- Planning and methodologies
		- Reduce or eliminate threats
			- Recover from disaster
	- Identify critical systems first
	- Implement safeguards for quick, painless recovery
	- Get business running again after disaster
	- Include Service Level Agreements (SLAs)
		- Specific service level guarantees in the event of a disaster

### Business continuity plan

- Looks at long-term business operations
- Specifies alternate site use in the event of disaster
	- Cold site
		- Electricity
		- Space for equipment
		- Bathrooms
	- Warm site
		- Minimal networking hardware
		- No data
	- Hot site
		- All equipment required
		- Current data
- Downtime affects accessibility over time
- Operating systems include backup tools
	- Full backup
	- Incremental backup
	- Differential backup

[uptime/backup](http://snag.gy/JWh0g.jpg)

### Fault tolerance

- System ability to withstand hardware or software fault
	- Keep functioning
- Increase fault tolerance by
	- Having backup archives
	- Using RAID drives
	- Using redundant hardware
	- Utilizing multiple, different Internet connections
- Money spent on fault tolerance
	- Worth the expense on networks requiring high reliability

![fault tolerant network topology](http://snag.gy/BWMw3.jpg)

### Protocol analyzers

- Report computer network traffic type and usage
- Quickly identify network problems
- Proactively monitor and plan future network growth
- Standalone hardware unit
	- Connects to network or software program running on a network host
	- Collects statistical network performance information
	- Statistics converted into graphical real-time views
- RMON and RMON2 standards
	- Provide packet capturing and protocol decoding support

![wireshark](http://snag.gy/cJ789.jpg)

### Simple network management protocol (SNMP)

- Gathers statistics on a device-by-device basis
	- Network devices categorized as managed
	- Includes hubs, switches, routers and other network devices
- Agents gather network statistics
- Management stations report on data
- Popular due to its power, ease of use
	- Four operations
		- GET
		- SET
		- GET-NEXT
		- TRAP
- Three SNMP information categories define scope
	- SNMP protocol
	- Structure of management information rules
	- Management information base

## Network security

- Two categories
	- Methods to secure data
	- Methods to regulate data transmission
- Threats
	- Many types
		- Interruptions
		- Interceptions
		- Modifications
		- Fabrications
- Controlled by security measures

![network security models](http://snag.gy/RJTfC.jpg)

### Viruses

- Software
	- Enters computer system
	- Corrupts hard drive files
- Exhibit various behaviours
- Important to have system, user file backup archives
	- Stored appropriately
- Four main category types
	- Boot sector
	- File or program
	- Macro
	- Multipartite viruses
- Latest virus types
	- Stealth
	- Polymorphic
	- Armored
- Also have
	- Worms
	- Trojan horses
	- Rootkits

### Network sniffers

- Similar to protocol analyzer
- Capture and decode network traffic
	- Passwords
	- Trade secrets
	- Other proprietary information
- Operates in passive mode
	- Device attached to the network
	- Silently collects information
- One of the worst security breach types
	- No one knows network security is comprised

### Encryption

- Plaintext encryption
	- First line of defense in protecting network data
		- Prevent plaintext password exchange on network
- Prevents sensitive information disclosure
- NetBIOS plaintext encryption
	- Not difficult to crack
	- Provides easy, small measure of security to networked resources

![encryption glossary](http://snag.gy/BoQJd.jpg)

#### Kerberos

- Uses secret-key ciphers for encryptionn, authentication
- Authenticates requests for network resources
	- Does not authenticate document ownership

#### SSL

- Facilitates secure Internet communication
- Uses public key encryption
	- Encrypts data before transmission
- Supported by most browsers
- Enabled when URL specifies HTTPS protocol

#### Public key encryption

- Public key encrypts transmission
- Private key decrypts data
- Eliminates problem when same key used to encrypt and decrypt data
- More secure data encryption and decryption method
	- Public key posted for public access
	- Private key guarded very carefully

#### Certificates

- Guarantee email sender's identity
- Available for enterprise, small business and home use
- Provides opportunities
	- Manage web site domain names, server certificates
	- Safeguard network resources using public key encryption
	- Secure network applications
		- Email, messaging
	- Enable e-commerce applications supporting online payments, purchases

#### PGP

- Pretty good privacy
- Provides confidentiality and authentication services
	- Use with electronic message, file storage applications
- Important elements:
	- Uses best cryptographic algorithms
	- Unlimited source code, documentation distribution
	- Not controlled by government, standards organisation
- Support mechanisms
	- Digital signatures, message encryption, compression
	- Transparent compatibility with many application programs

#### Masquerading

- Spoofing attacks
- IP masquerading
	- IP spoofing
- One computer forwards information from one or more other computers
	- Using IP addresses not officially assigned

#### Firewalls

- Hardware device or software program
	- Examines information packets
	- Determines if communication exchange occurs
- Packet filtering, proxy service, stateful inspection

#### Virtual LANs

- Partitioning VLAN capable switch ports into LAN groups
	- Isolates traffic

#### Intrusion detection systems

- Combines traffic sniffing with analysis techniques
- Network based intrusion detection (NIDS)
	- Centralised approach
- Host based intrusion detection (HIDS)
	- Decentralised approach

#### Proxy server

- Server-type application program
	- Sits between a user workstation and Internet
	- Montors, logs network activity
- Used with a gateway to isolate LAN from the Internet
- Used with a firewall to protect networks from intruders

#### IP security (IPSec)

- Secures communications across a LAN
	- Between public/private networks
	- Across the Internet
- Incorporated into TCP/IP protocol stack
	- Below UDP, TCP transport controls

#### Tunneling

- Uses public network infrastructure
	- As part of a Virtual Private Network (VPN)
- Data encapsulated
	- Encrypts
		- Original source address
		- Destination address
		- Payload data

##### Layer 2 tunneling protocol

- Combination of protocols
	- Point-to-point protocol (Microsoft)
	- Layer 2 forwarding protocol (Cisco)
- Standard tunneling protocol for VPNs

#### Denial of Service attacks (DoS)

- Prevents legitimate users from using a service
	- Essentially disables a computer or network
- Three basic attack types
	- Consumption of limited resources
	- Destruction or alteration of configuration files
	- Physical destruction or modification of network components
- Hardening
	- System
		- Process vulnerabilities reduced or eliminated
	- Network
		- Operating systems and application hardening

## Storage management

### Network attached storage (NAS)

- High capacity file storage directly connected to the network
- NAS device characteristics
	- May use hard drives or writable CD-DVDs to store data
	- Fault tolerance possible using RAID
	- Communication via TCP/IP and IPX/SPX
- Storage area network (SAN)
	- Uses a special switch to connect servers, storage devices on their own physical network
	- One server acts as a gateway to the SAN

### User management

- Areas to consider
	- Acceptable use policy
	- Logon policy
	- Password policy
	- Access control
	- Security awareness training
	- Auditing policy
	- User termination policy
- All areas require enforcement

## Troubleshooting techniques

- Network management
	- Requires patience and determination
	- Several different possible troubleshooting choices
		- Each choice may provide a workable solution
		- No one choice better than another
- Network security
	- May involve significant research
	- Requires a good normal system activity baseline
	- Most important tool
		- System activity log
