# Network security

## General security issues

- Not all networks are the same
- Can be different in terms of
	- Size / complexity
	- Topology
	- Protocols
	- Number of links to other networks
	- Wired / wireless / combinations
	- Devices used
		- Hubs
		- Switches
		- Routers
	- Security requirements

## TCP/IP

- Transmission control protocol / Internet protocol
- A set of protocols to allow hosts to communicate and transmit data over the Internet
	- ie. A web browser may use TCP/IP to communicate with a server
	- The server may use TCP/IP to transmit HTML data

### Lack of security in TCP/IP

- TCP/IP was not created with security in mind
- No strong authentication of packets
	- Vulnerable to packet
		- Spoofing
		- Modification
		- Fabrication
- No encryption of packets
	- Vulnerable to interception
- Other aspects can also be exploited
	- TCP handshake sometimes exploited in DoS attacks

### IPv6

- IP version 6 has been suggested as a solution to a number of problems
	- IP address space exhaustion
		- 128 bit address as opposed to 32 bit address
	- Encryption of packet data
	- Cryptographic authentication of headers
	- IPv6 seen by many as the answer to many of inherent problems of IPv4

# Network security concerns

## Scanning, probing and discovery

- Often a pre-cursor to an attack
- An attacker might perform some reconnaissance before committing to a full attack
	- Tip: If you have logged an attack and cannot determine its source due to IP spoofing
		- Or the attack being launched from compromised machines
		- Check logs for prior recon attempts
- Tools can be used to map the structure of a network
	- To identify systems and devices on the network
	- To automatically locate exploitable vulnerabilities

## Scanning tools

- [www.nmap.org](http://nmap.org/)
	- Powerful and free security scanner
	- Can discover hosts and services on a network
- [Nessus](http://www.tenable.com/products/nessus-vulnerability-scanner)
	- Powerful network vulnerability scanner
	- 60000+ plugins are currently available
		- Small programs designed to discover a specific flaw

## Packet spoofing

- Spoofing refers to the act of faking the source IP address of a packet or email
	- To conceal the identity of the sender
- Packet spoofing is a major network security issue
- Often source addresses are used to authenticate packets
- Do not assume that the source address is a true indication of the real origins of a packet

## Address resolution protocol (ARP) spoofing

- ARP links a MAC address with an IP address
- When one host using IP on a LAN is trying to contact another, it needs the MAC address
- When a host on a LAN asks
	- `Who has IP address x.x.x.x?`
- The attacker can reply with
	- `x.x.x.x is at 00:16:53...`
- Traffic intended for the right recipient will be forwarded to the attacker

## Denial of Service

- Send a large number of packets to a host
- Slows down or crashes the host
- Typically associated with botnets

## Wireshark: Packet sniffer

- Free and open source packet analyser
- Can be used to breach confidentiality of data
- Typically used for
	- Network troubleshooting
	- Network analysis
	- Network forensics

![wireshark screenshot]()

## Port knocking

- Port knocking is a method to grant remote access to a host without leasving a port constantly open
- Server must have a firewall with the knock-daemon listening for a specific TCP/UDP knock sequence
- A client will **knock** at particular ports in a particular order to dynamically alter the firewall rule sets
	- Granting remote access
- Fairly secure against brute-force attacks since there are 65536<sup>k</sup> combinations
	- k is the number of ports knocked
- If port knocking daemon dies, the system may have limited or non-existent remote access
- Process monitoring daemon can ensure that port knocking daemon is always up

## Wired vs. wireless networks

- Wireless networking
	- 802.11a/b/g/n
	- Bluetooth
	- WiMax
	- Convenient
	- Introduces additional network threats
	- Traffic interception/injection
	- Theft of bandwidth
	- Network intrusion
	- DoS
- You automatically give your attackers 'access to the wire' because there is no wire
- Puts you at a security disadvantage to start with

### Wireless legal issues

- Assuming you have no wireless security
- If someone uses your wireless network to access and download illegal or inappropriate material, should you be held responsible?
- Did you encourage someone to misues your wireless network?
- These issues are increasingly prevalent in the legal / security / network community

### Wardriving and warchalking

- Process of driving around searching for and pinpointing wireless networks
- GPS devices log locations to post online
- Software such as NetStumbler (Windows)
- Use antennas to increase range
- Warchalking involves leaving chalk marks

### Wardriving tools

- Netstumbler
- Antenna for db gain
- Wireless card with monitor mode enabled
- GPS

# Network security countermeasures

## Firewalls

- A collection of security measures designed to prevent unauthorized access to a networked computer
- A network firewall is similar to firewalls in building construction
	- In both cases, they are intended to isolate one network or compartment from another

### Firewall policies

- A firewall can be used to filter incoming or outgoing traffic based on a predefined set of rules called firewall policies

![firewall policies](http://snag.gy/8JoLM.jpg)

### Firewall policy actions

- A firewall can determine how to handle packets based on 1 of 3 rules
	- **Accept**
		- Allowed through firewall to destination
	- **Drop**
		- Not allowed through firewall with no notification sent to source
	- **Reject**
		- Not allowed through firewall with notification sent to source
		- Informs source that the packet was rejected

### Firewall blacklist vs. whitelist

- Blacklist approach
	- All packets are allowed through except those that fit the rules defined specifically in a blacklist
	- More flexible in ensuring that service to the internal network is not disrupted by firewall
	- But is naive from a security perspective
		- It assumes the network admin can enumerate all of the properties of malicious traffic
- Whitelist approach
	- A safer approach
	- Default-deny policy
	- Packets are dropped or rejected unless they are specifically allowed by firewall

## Firewall types

- Stateless firewall
- Stateful firewall
- Application firewall
- Circuit level gateway
- Personal/software firewall

### Stateless firewall

- A stateless firewall doesn't maintain any state with respect to the packets it is processing

![stateless firewall](http://snag.gy/4tzgr.jpg)

### Stateful firewall

- Stateful firewalls maintain tables containing information on each active connection
	- IP addresses
	- Ports
	- Sequence numbers of packets
- Reduces the required computational processing power to handle rulesets

### Stateless vs. stateful firewall

![stateless vs. stateful](http://snag.gy/N8HkD.jpg)

### Application firewall

- Controls inputs, outputs and access to or from an application or service
- Network based or host based
- Popular application firewalls include
	- WinGate
	- ModSecurity
- Allows logging and monitor of traffic

### Circuit level gateway

- Examines IP addresses and port information
- Once connections are verified they simply pass bytes through
- Used by DSL routers
	- Network Address Translation
- Gateway communicates directly with 3rd party hosts on behalf of internal LAN hosts

### Personal/software firewall

- The defining characteristics of this type of firewall is that they are software that runs directly on the system that is being protected
- As opposed to network firewalls that typically act as a form of perimeter defence
- Most personal firewalls
	- Control incoming connections
		- Ingress filtering
	- Control outward communication
		- Egress filtering
	- Verifying applications
		- Hashing executables

### Personal firewalls

- Some personal firewalls also integrate anti-virus and content filtering features
- Examples include
	- Comodo Internet Security
	- Bitdefender Internet Security
	- Zonealarm Firewall
	- Norton Internet Security
- Are commonly packaged with
	- Anti-virus
	- Phishing detection
	- Ad blocking
	- etc.

## Intrusion detection system (IDS)

- Detect and react to attacks on a network
- Intrusion detection
	- The identification through intrusion signatures and report of intrusion activities
- Intrusion prevention
	- The process of both detecting intrusion activities and managing automatic responsive actions throughout the network

### Rule based IDS

- Rules identify the types of actions that match certain known profiles for an intrusion attack
- Signatures must be kept up-to-date
	- Similar to anti-virus software
- Susceptable to new un-documented attacks
- Attacker could also disguise or conceal attack by varying it slightly so that it does not match a known signature

### Anomaly (statistical) based IDS

- A profile is built based on a statistical representation of the typical ways that a user acts or a host is used for **what is considered normal**
- Thresholds are set to determine what is abnormal
- A careful attacker might be able to draw out an attack so that the thresholds are not reached
- What if an attacker can slowly change the IDS' view of **what is normal?**

## Honeypot / honeynet

- Countermeasure based on deception
- Honetpot / honeynet simulates a system or an entire network
- Attacker is lured into the honeypot thinking that it is a computer system or network
	- Honeypot provides the responses that the attacker would expect to see if they were attacking a real system
	- Success depends on deceptive capabilities

## Virtual Private Network (VPN)

- Allows a host to communicate with other hosts as if it were directly part of the network
- Used to provide a secure connection over an un-trusted network
	- The Internet
- Cheaper alternative to leased lines, dedicated lines etc
- Provides confidentiality and authentication

### Some VPN uses

![vpn uses](http://snag.gy/ziteY.jpg)

### VPN tunnelling

- Common VPN protocols include
	- IPSEC
	- PPTP
		- Point to point tunnelling protocol
	- L2TP
		- Layer 2 tunnelling protocol
- VPNs work by establishing encrypted, authenticated tunnels between end points
	- PPTP authenticates by the use of passwords
	- IPSEC can authenticate using shared secrets
		- ie. Passwords/secret keys
		- But is mainly geared towards the use of certificates on clients

### SSL/TLS

- Protocols such as Secure Sockets Layer (SSL) and Transport Layer Security (TLS) also allow the creation of encrypted tunnels
	- SSL 2.0, SSL 3.0, TLS 1.0
	- Confidentiality is achieved through the use of encryption
	- Authenticity through the use of certificates
	- Message integrity through the use of HMACs

### Uses of TLS

- Secure channel between web browser and web client
	- Internet banking
	- Transfer of online credit card payments
	- Other sensitive information
- Secure channel between mail clients are servers
	- Prevents snooping and eavesdropping
		- Between mail server and client
- Also used in some VPN products

# Internet security issues

## Usage logging and auditing

- Many organisations have an interest in using logging and auditing to detect misuse of the Internet
- Aside from improving performance and reducing costs through caching, proxy servers are in a good position to log Internet usage

## Proxy servers

- Do do something by proxy means to have someone do something on your behalf
- A web proxy fetches web pages on behalf of a web client and returns those pages to the client
- Such proxies can cache frequently used pages in order to improve performance and reduce network traffic costs
- Proxy servers are also in good position to filter web content or log web access

## Content filtering

- Could be done for a number of reasons
	- To filter out objectionable content
	- To enforce organisational policies
	- To filter out advertisments, web bugs, cookies etc.
	- Can save bandwidth and help preserve privacy
- Can be done by proxy servers
- Several approaches
	- By IP address
		- A site may share IP addresses with legitimate sites
	- By keyword
		- May lead to unintentional blocking
		- Blocking the word "sex" may block "Essex Cricket Club" site
	- By URL
		- Websites can often change their URL

## Proxy logs

- Proxy servers can keep detailed logs of accesses to websites
- These logs can be very useful for detecting cases of misuse of the Internet
- Often log file analysis tools are required due to the large number of records stored in log files

## Interception

- Emails are very vulnerable to interception
- In transit
	- Most emails are sent in plaintext
- From the mail server
	- Email servers could be compromised
	- Individual passwords and accounts could be compromised
	- Server backups could also be targeted
- From a local machine
	- Cached copies of mails
