# The Internet

## Organisation of the Internet

- Several top-level domain categories
	- Internet host name
		- Shows assigned category
- Domains registered on appropriate root servers
	- Locally administered Domain Name Server (DNS) allows host configuration
- Domain name associated with an IP address
	- Resolved via DNS
- Growing Internet popularity
	- Shortage of available networks

![common top level domains](http://snag.gy/udsEz.jpg)

### Network address translation (NAT)

- Multiple network devices on a local network
	- Mapped to IP addresses on an external network
- Internal IP addresses mapped on a rotating basis
- NAT table
	- Contains known mappings
	- Initialized with a set of translations
- Advantages
	- Reduces number of outside IP addresses required
	- Enhances security
	- Hides internal IP addresses

### Internet connection sharing (ICS)

- One computer
	- Contains one connection to the ISP
	- Second connection to the local network
	- Acts as a gateway to the ISP
- Alternatively, multiple computers share a single Internet connection
	- Requires cable modem/DSL router
	- One port connects to the single ISP connection
	- Other ports provide access for local network connections
	- Web based interface typically provided

## Operating systems on the Internet

### Windows

- Windows NT/200X server operating system services
	- DHCP
	- DNS
	- RAS
	- Windows Internet Naming Service (WINS)
		- Translates Windows computer names to IP addresses
		- Name-to-IP mappings dynamic database
		- Automatically adjusts entries as IP addresses reassigned
	- Windows computer may utilize own mapping table before relying on WINS
		- LMHOSTS file

### Other operating systems

- Variety of operating systems available
	- Linux
	- Unix
	- Mac OS
	- OpenVMS
	- MVS
	- NetWare
- Necessary for vendors to provide a TCP/IP stack
- All seamlessly participate on the Internet

## World Wide Web

- WWW or web
- Referred to as a collection of web servers
	- Provides access to host computer files
- Hypertext Transfer Protocol (HTTP) in use on the internet
	- May products enhance HTML

### Web browser

- Client program to access web server files
	- Web pages
- Three elements
	1. Content
	2. Organisation
	3. Layout
- Uses Uniform Resource Locator (URL) to point to specific page of information
- When processing HTML source
	- Browser ignores white space

### HTML

- Hypertext Markup Language (HTML)
- Core component web page information
- HTML source code has an overall syntax, structure
	- Consists of may different tags
	- Instructs browser when preparing graphical web page

![html tags](http://snag.gy/95827.jpg)

#### HTML editors

- Create and maintain web pages
- What you see is what you get (WYSIWYG) option
- Provide samples, image editing, conversion tools

#### Web page categories

- Static
- Dynamic
- Active

#### XHTML

- Extensible HTML (XHTML)
- Based on XML
	- Standard Generalized Markup Language (SGML) subset
- Open standard recommended by World Wide Web Consortium
- Fully compatible with HTML
- Advantages over HTML
	- XML compliant
	- HTML 4 reformulated into XHTML 1.0
	- New browsers support XHTML
- Validation services provided

### CSS

- Cascading style sheets
- Method to incorporate style, layout elements into web pages
	- Improved page appearance
		- Level of control
- Many elements
	- Background
	- Text
	- Font
	- Border
	- Outline
	- Margin
	- Padding
	- List
	- Table
	- Dimension
	- Classification

## Web programming

### CGI

- Common Gateway Interface (CGI)
- Mechanism designed to provide dynamic web environment
	- Incorporates a client server processing model
- Environment variables
	- Contain client and server environment information available to the CGI application
- CGI application development languages
	- C/C++/C#
	- Visual BASIC
	- Java
	- Perl
	- Many others

### Java

- Programming language used to create
	- Traditional computer programs
	- Active web pages using Java applets
		- Specified by the Java applet when web page displayed
			- Not HTML coding process
- Java applet program
	- Transferred from an Internet host to web browser
	- Executed by browser on a Java virtual machine
- Java consists of
	- Programming language
	- Run-time environment
	- Class library

![java class library categories](http://snag.gy/KDvwT.jpg)

### JavaScript

- Programming language
- Performs web client side processing
	- Relieves server processing requirements
- Included on modern browsers
- Performs may common activities
	- Scripts downloadable from the web
		- Can be included on web page with little effort
- Performs custom activities as required

## Virtual private networks

- Allows private LAN secure communication
	- Through an untrusted public network
		- ie. Internet
- Only authorized network members can access data
- Uses IP tunneling protocol and security services
	- Transparent to private network users
- Private LAN connected to the internet
	- Can connect to other LANs by combining
		- Tunneling
		- Encryption
		- Authentication

![raw software vpn (logical)](http://snag.gy/JLtAa.jpg)

![rwa software vpn (physical)](http://snag.gy/2UHGl.jpg)

### Tunneling

- Data transferred through the public network in an encapsulated form
	- All data including
		- Sender
		- Destination addresses
		- Enclosed within a packet

### Security

- Complete security accomplished when data communication also encrypted and authenticated
- IP security (IPSec) standards provide:
	- Tunneling
	- Data privacy
	- Integrity
	- Authentication
	- Adds additional TCP/IP networking security solutions
- Point-to-Point Tunneling Protocol (PPTP) and Layer 2 Tunneling Protocol (L2TP) only support tunneling
	- Capabilities include
		- User authentication
		- Address management
		- Data encryption
		- Encryption key management
		- Support for multiple protocols to be delivered

## Instant messaging

- Application provided capability for user to send and receive instant messages
	- Delivered to recipient instantly
		- Faster than electronic mail
- Popular instant messaging applications
	- Installed as client application program
		- AOL's Instant Messenger
		- Microsoft's Windows Live Messenger
	- Without installing client
		- AIM Express

![aim express](http://snag.gy/gAEla.jpg)

## Web server

- Typically installed on large computer systems
	- Running UNIX or Windows Server
- Commonplace on personal computers
- Apache Server
	- Free and fully featured
	- Most popular web server program
		- Business and personal use
	- 50% of server market
- Microsoft Internet Information Services (IIS) web server
	- Popular with Windows users

![apache documentation](http://snag.gy/uzkJl.jpg)

![apache root directory](http://snag.gy/8ITxk.jpg)

## Related links

- [www.yahoo.com](http://www.yahoo.com)
	- Search engine and entertainment website
- [www.internic.net](http://www.internic.net)
	- Internet authority
- [www.ietf.org](http://www.ietf.org)
	- The Internet Engineering Task Force
- [www.w3.org](http://www.w3.org)
	- World Wide Web Consortium
- [www.w3schools.com](http://www.w3schools.com)
	- Web Developer Resource site
- [www.javascript.com](http://www.javascript.com)
	- JavaScript resources
- [hoohoo.ncsa.uiuc.edu/cgi](http://hoohoo.ncsa.uiuc.edu/cgi)
	- CGI specifications

## Troubleshooting techniques

- The Internet
	- Physical collection of networked computers
- WWW
	- Logical collection of information
	- Contained on computers comprising the Internet
- Web page file download considerations
	- Communication channel noise forcing packet retransmission
	- Internet path introducing delay
	- Server sending data at a limited rate
	- ISP providing limited bandwidth
