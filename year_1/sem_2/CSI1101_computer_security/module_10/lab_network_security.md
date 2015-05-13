# Tutorial 10: Network security

## 1 Open source vs. commercial

For each of the following network security tool categories, locate a real world example, determine if the tool is open source or commercial, and write a brief description / purpose of the tool.

1. Packet sniffer / Protocol analyser
2. Network fingerprint tool
3. Vulnerability scanner
4. Network intrusion detection system
5. Honeypot / honeynet
6. Personal firewall

Should you wish to test or play around with any of the tools you find and download, it is recommended that you do so in an isolated environment or virtual machine, and scan the downloaded files for malware.

### 1.1

Packet sniffer: [Wireshark](https://www.wireshark.org/)

- Open source
- Protocol analyzer
	- Lets you see whats happening on your network at a microscopic level
	- Live capture and offline analysis of packets
	- Multi platform
	- Decryption support for many protocols
		- IPSec
		- ISAKMP
		- Kerberos
		- SNMPv3
		- SSL/TLS
		- WEP
		- WPA/WPA2

### 1.2

Network fingerprint tool: [p0f3](http://lcamtuf.coredump.cx/p0f3/) [GitHub](https://github.com/p0f/p0f)

- Open source
- Passive network fingerprint tool, similar to Nmap
	- Identifies hosts behind any incedental TCP/IP communications
	- Fast identification of operating systems and software on both endpoints of TCP connection
	- Can bypass settings where [Nmap](http://nmap.org/) probes are blocked
	- Measures system uptime and network hookup
		- Distance and topology behind NAT or packet filters
		- User language preferecnes
	- Detection of connection sharing / NAT, load balancing and application level proxying setups
	- Detection of clients and servers that forge declarative statements such as X-Mailer or User-Agent
	- Can operate in foreground or as daemon
- Common uses for p0f include
	- Recon during penetration tests
	- Routine network monitoring
	- Detection of unauthorized network interconnects in corporate environments
	- Provides signals for abuse prevention tools
	- Miscellaneous forensics
	- Used in OpenBSD firewall

### 1.3

Vulnerability scanner: [OpenVAS](http://www.openvas.org/)

- Open source
- Forked from last open source version of [Nessus](http://www.tenable.com/products/nessus-vulnerability-scanner)
- Collection of tools to scan for vulnerabilities in a system
	- Performs Network Vulnerability Tests (NVTs)
	- Scans specific IP addresses for vulnerabilities
		- Performs port scan to find open services
		- Listening ports tested for known vulnerabilities/mis-configurations
			- Based on DB of 28,000+ NVT checks
	- Can also be used to test response of Intrusion Detection systems

### 1.4

Intrusion detection system: [Snort](https://www.snort.org/)

- Open source
- Can be used as
	- Packet sniffer / protocol analyzer
	- Packet logger
	- Network-based intrusion detection system
- Monitors traffic on network to look for suspicious traffic
- Capable of performing real time traffic analysis and packet logging on IP networks
- Protocol analysis, content searching/matching
- Detects a variety of attacks and probes
	- Buffer overflows
	- Stealth port scans
	- CGI attacks
	- SMB probes
	- OS fingerprinting attempts

### 1.5

Honeypot / honeynet: [Specter](http://www.specter.com/default50.htm)

- Closed source
- Honeypot based intrusion detection system
- Simulates a vulnerable computer
	- Provides an interesting target to lure attackers away from production machines
- Includes common Internet services
	- SMTP
	- FTP
	- POP3
	- HTTP
	- TELNET
- Appears normal to attackers but are traps
	- Unknown to attackers that it is decoy system
	- Logs everything
	- Ability to send notifications to admins
- Automatically investigates attackers while attempting to break in
	- Provides massive amount of decoy items
		- MP3
		- Images
		- Emails
		- Password files
		- Documents
		- Software
- Dynamically generates decoy items that will leave hidden marks on attackers computer
- Automated updates of system's content and vulnerability database allow the honeypot to constantly change without user interaction
- Includes WATCHER module which detects
	- Every ICMP packet
	- Every TCP connection
	- Every UDP datagram
	- On every port
- Can be installed on dedicated PC
	- Connects to network where attacks are expected
- Or install on production machine

### 1.6

Personal firewall: [ZoneAlarm Free Firewall 2015](http://www.zonealarm.com.au/security/en-us/zonealarm-pc-security-free-firewall.htm)

- PC security
	- Two way firewall
		- Inbound/outbound
	- DefenseNet
		- Uses realtime threat data from other ZoneAlarm users
	- Advanced firewall
		- Monitors behavours to stop new attacks that bypass traditional antivirus and security suites
- Web security / privacy
	- Do not track mode
	- Facebook privacy scan
	- Private browsing
	- Download protection
		- Analyzes downloads to determine if they are safe or malicious
		- Provides sandbox environment to test downloads
- Identity / data protection
	- Identity protection services
		- Help keep credit card and financial data safe
- Privacy / security toolbnar
	- Blocks
		- Spyware distribution sites
		- Phishing websites

## 2 Home network security

Home networks connected via an ADSL router/modem are notoriously poorly protected. Research and brainstorm the factors which make securing a home network difficult. Do some research on protecting a home network and compare this to the existing safeguards you have implemented on your own network.

- Can include many devices that are
	- Poorly configured
	- Not updated with latest security patch/es
- Poorly configured
	- Routers
		- Still use default adminusername/passwords
		- Use default subnet 192.168.x.x
		- May include remote access features
			- ie. FTP / file sharing services
				- Means open ports
		- UPnP enabled
		- Old firmware
	- Devices
		- Opened ports
			- ie. NAS device
		- Old firmware
- Wireless
	- All wireless traffic can be intercepted
	- Encrypted password can be dictionary attacked
		- WEP, WPA, WPA2 etc. not 100% safe
	- See [How to Hack Wi-Fi: Cracking WPA2-PSK passwords using Aircrack-Ng](http://null-byte.wonderhowto.com/how-to/hack-wi-fi-cracking-wpa2-psk-passwords-using-aircrack-ng-0148366/)
	- Wireless traffic to configure wireless router may be intercepted

### How to protect home network

- See [Keep your network secure](http://www.cnet.com/au/how-to/home-networking-explained-part-6-keep-your-network-secure/)
- Router settings
	- Encrypt wifi network
		- Use strong password
		- Use WPA2 (even though this can be cracked, see above)
	- Change important default settings on router
		- Change admin password
		- Change subnet
	- Disable remote access features
		- ie. Filesharing / FTP, Telnet
	- Update router firmware

## 3 Advanced question

Suppose you want to use an Internet cafe to login to your personal account on a bank web site, but you suspect that other computers in this cafe are infected with software keyloggers.

Assuming that you can have both a web browser window and a text editing window open at the same time, describe a scheme that allows you to type in your userID and password so that a keylogger, used in isolation of any screen captures or mouse event captures, would not be able to discover your userID and password.

### Answer

- Switch to text editor, mash keyboard
- Enter first char of password into browser
- Switch to text editor, mash keyboard
- Enter next char of password into browser
- Rinse, repeat
