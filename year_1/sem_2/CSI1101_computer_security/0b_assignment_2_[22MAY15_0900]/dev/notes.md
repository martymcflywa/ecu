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
	- Blue Ink is a large enterprise
		- Since it has Board of Directors

### Introduction

- We found security issues with
	- The operating system
	- Third party applications
	- User practices
- This presentation will recommend solutions to those issues
	- Outline advantages/disadvantages where possible
	- Introduce alternatives where possible
	- Briefly discuss process where possible

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
		- When a security vulnerability in a program has been found or disclosed, the developer may release an update for the program to resolve the known vulnerability in order to stop it from being exploited by attackers
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
					- Windows 8.1 ships with Internet Explorer 11 [MicrosoftIE11Requirements](http://windows.microsoft.com/en-au/internet-explorer/ie-system-requirements#ie=ie-11)
			- Disadvantages
				- Cost
					- A new license for each copy of operating system must be purchased
					- Current hardware may also need upgrade in order to run Windows 8.1
				- Deployment of new operating system may take time/money
				- A company/user may depend on software which may not be compatible with Windows 8.1
				- Staff may require training in use of operating system
					- User interface has evolved since Vista
				- Computer/s will then become susceptible to unresolved known/unknown vulnerabilities associated with Windows 8.1
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
						- Internet Explorer 9 is latest compatible version of Internet Explorer with Vista [MicrosoftIE9Requirements](http://windows.microsoft.com/en-au/internet-explorer/ie-system-requirements#ie=ie-9)
						- **Note:** Show excerpt of table here [OzkanIECVEList](http://www.cvedetails.com/version-list/26/9900/1/Microsoft-Internet-Explorer.html)
					- ie. CVE-2013-3918 Active-X Control vulnerability allows an attacker to remotely execute code on a victim's computer through a malicious website [Microsoft2013, Ozkan2013]
						- Vulnerability was exploited in a "watering hole" attack on a US based website which subjected its viewers to a "drive by download" attack to propagate malware [Chen2013, Moran2013, Wilson2013]
			- Windows Defender also affected by lack of updates
				- Has left the anti-malware program with a severely obsolete virus/malware signatures list
					- No updates to signatures list since version 1.0.0.0 on 14 July 2006
						- **Note:** Show screenshot
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
				- ie. Auto-run vulnerability mitigated
				- Computer will still be susceptible to later vulnerabilities until Microsoft release security updates to resolve them
			- Internet Explorer will be updated to version 9
				- Active-X Control vulnerability mitigated
			- Windows Defender will be updated with latest malware/virus signatures
				- Will be effective in detecting/protecting against current threats
			- Staff will not need training in its use
				- No changes to user interface
		- Disadvantages
			- Internet data
				- Downloading all updates will cost considerable amount of data usage
			- Time
				- May take time downloading updates
			- Internet Explorer 9 is still susceptible to various vulnerabilities
				- **Note:** Add CVE for IE9 here?
			- Security updates will no longer be received after 11 April 2017
				- Any vulnerabilities found/disclosed after the last security update will not be resolved
	- Any alternatives?
		- Do nothing
			- Operating system/included applications remain unsecure

### User applications

#### Fake anti-virus

- We found a desktop shortcut to a fake anti-virus application
	- **Note:** Show screenshot of shortcut
- Shortcut links to a html file stored in the "My Documents" folder
- File attempts to present itself as a legitimate anti-virus software
	- **Note:** Show UI
- Origin unknown
	- May have been installed as a result of malware propagation
- How to fix it?
	- Delete desktop shortcut
	- Delete supporting files in "My Documents" folder
		- **Note:** Show screenshot
	- Install a real anti-virus application
		- Suggestions
			- [Avast enterprise](https://www.avast.com/en-au/enterprise)
			- [Bitdefender enterprise](http://enterprise.bitdefender.com/au/)
			- [Kaspersky business](http://www.kaspersky.com/au/business-security)
	- Advantages
		- Will stop creating a false sense of security to user
		- Installing a real anti-virus application will provide real protection
	- Disadvantages
		- Cost
		- May require staff training in use of application
- Any alternatives?
	- Fake anti-virus **must** be deleted
	- Can stick with Windows Defender
		- Free

#### Firefox 8.0

- Legacy version of the Firefox Internet browser
- **Note:** Include total number of vulnerabilities between Firefox 8 - 36.xx See [this](http://www.cvedetails.com/version-list/452/3264/1/Mozilla-Firefox.html)
	- ie. CVE-2014-1522 heap memory corruption vulnerability which allows a remote attacker to either execute arbitrary code or cause Denial of Service conditions [MITRE2014b]
- How to fix it?
	- Enable automatic updates?
	- Update Firefox to latest version 37
		- Still compatible with Vista
	- Advantages
		- Firefox will no longer be susceptible to vulnerabilities in versions 8 through to 36
		- Free
	- Disadvantages
		- Firefox will be susceptible to vulnerabilities identified in version 37 until resolved by vendor Mozilla

#### Adobe Reader 6.0.1

### User practices

#### Passwords

- Include effective passwords
	- Snowden on passwords [Last Week Tonight with John Oliver](https://youtu.be/yzGzB-yYKcc)
- Storage of passwords in plaintext
	- See [TV presenter in front of desk with handwritten password sticky notes](http://arstechnica.com/security/2015/04/hacked-french-network-exposed-its-own-passwords-during-tv-interview/)
	- See [another example](https://twitter.com/pent0thal/status/586284074223984642)
