# CSI1101 A2

## Security Issue Mitigation

Format: Max 30 presentation slides

## Task

1. For each issue you identified in the initial (assignment 1) report
	- What is the security strategy you would recommend to mitigate and control the issue?
2. Explain how the mitigation strategy will be effective in controlling the issue.

### Additional information

- Only developing slides
- May include images or screenshots to emphasize points in presentation
	- Any found images must be referenced
- Avoid filling slides with walls of text
- When recommending a solution, name specific products/versions/configurations and justify recommendation
	- This may require research and analysis of existing literature

## Issues found in A1

- Assumptions
	- Computers connected to WAN and LAN
	- Firewall protects network
	- User "green" is a standard employee
	- Backup strategy in place

### Operating system

- Windows Vista Business x86 SP0
- Its getting old: Superseded by two versions of Microsoft Windows
	- Will eventually become obsolete
		- Extended support ends 11 April 2017
	- Third party application used by Blue Ink may potentially also end support for Vista
	- What does this mean?
		- Microsoft will no longer provide security updates for Vista Business after 11 April 2017
			- Only ~2 years left
		- Software used by Blue Ink may no longer receive security updates if/when the vendor/s decide to stop supporting Vista
			- Footnote: New software the company may wish to utilize in the future may not be available for Windows Vista
	- What are security updates anyway?
		- When a security vulnerability in a program has been found or disclosed, the developer may release an update for the program to close the known vulnerability in order to stop it from being exploited by attackers
	- How to fix it?
	- Upgrade vs. update
		- Upgrade to a modern version of Microsoft Windows
			- ie. Windows 8.1
			- Advantages
				- Computer/s will no longer be vulnerable to all known/unknown exploits associated with Windows Vista
				- Microsoft's support will be extended [Microsoft2014](http://windows.microsoft.com/en-au/windows/lifecycle)
					- ie. Microsoft Windows 8.1 mainstream support ends 9 January 2018
						- Extended support ends 10 January 2023
				- Software included with operating system such as Internet Explorer or Windows Defender will be also be upgraded
					- Vista is limited to Internet Explorer 9
						- Has its own vulnerabilities to be discussed later
			- Disadvantages
				- Cost
				- Current hardware may also need upgrade in order to run Windows 8.1
				- Deployment of new operating system may take time/money
				- A company/user may depend on software which may not be compatible with Windows 8.1
				- Computer/s will then become vulnerable to known/unknown exploits associated with Windows 8.1
- What's the alternative to upgrading?
	- Blue Ink's computers need their operating system updated to the latest service packs and security updates
		- Currently, no Service Packs or security updates have been applied
			- There are currently 524 known vulnerabilities for all versions of Windows Vista [Ozkan2015](http://www.cvedetails.com/vulnerability-list/vendor_id-26/product_id-9591)
				- From SP0 through to SP2
				- ie. CVE-2008-0951 Auto-run vulnerability [SecurityFocus2008](http://www.securityfocus.com/bid/28360)
					- Allows an attacker to include malicious code on removable media such as a CD-ROM or USB drive which would be executed once the removable media has been inserted into the computer
			- Without any updates, Blue Ink's computers are vulnerable to all of them
			- Lack of updates have also kept included software such as Internet Explorer severely outdated
				- Blue Ink computers currently have Internet Explorer 7 installed
					- Internet Explorer 7 has 206 currently known vulnerabilities
					- Internet Explorer 8 has 249 currently known vulnerabilities
					- Internet Explorer 9 has 292 currently known vulnerabilities
						- Internet Explorer 9 is latest compatible version of Internet Explorer with Vista
						- **Note:** Show excerpt of table here [OzkanIECVEList](http://www.cvedetails.com/version-list/26/9900/1/Microsoft-Internet-Explorer.html)
					- ie. CVE-2013-3918 Active-X Control vulnerability allows an attacker to remotely execute code on a victim's computer through a malicious website [Microsoft2013, Ozkan2013]
						- Vulnerability was exploited in a "watering hole" attack on a US based website which subjected its viewers to a "drive by download" attack to propagate malware [Chen2013, Moran2013, Wilson2013]
			- Windows Defender also affected by lack of updates
				- Has left the anti-malware program with a severely obsolete virus/malware signatures list
					- No updates to signatures list since version 1.0.0.0 on 14 July 2006
				- Any anti-malware/virus application must have its signatures list regularly updated
					- So that it can protect the computer from current known threats [Goodrich2011]
				- Windows Defender in its current state failed to detect all eicar test files
	- How to fix it?
		- Enable automatic updates which will allow the system to download and install required updates on its own at regular intervals
			- **Note:** Show screenshot of how to enable
		- Advantages
			- Free
				- Installation of service packs and security updates are free of charge
			- Most known vulnerabilities for Vista will be secured
				- Auto-run vulnerability mitigated
				- Later vulnerabilities may still be applicable until Microsoft release security updates to resolve them
			- Internet Explorer will be updated to version 9
				- Active-X Control vulnerability mitigated
			- Windows Defender will be updated with latest malware/virus signatures
				- Will be effective in detecting/protecting against current threats
		- Disadvantages
			- Internet data
				- Downloading all updates will cost considerable amount of data usage
			- Time
				- May take time downloading updates
			- Internet Explorer 9 is still vulnerable
				- **Note:** Add CVE for IE9 here?
	- Any alternatives?
		- Do nothing
			- Operating system remains unsecured

### User applications
