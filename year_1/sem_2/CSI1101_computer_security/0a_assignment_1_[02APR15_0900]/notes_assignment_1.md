# Assignment 1: Contemporary Issue Report

## Details

- Title: Security Issue Identification
- Value: 20%
- Length: Max 1500 words excluding references

### Background

Board of directors at **Blue Ink** have recently become aware of the lack of computer security awareness and best practices amongst employees. As a result, you have been hired by Blue Ink to perform an analysis and convey your findings regarding the state of computer security to the Managing Director. You have been provided with one VM image which mimics a typical computer in the organisation. The Managing Director has little knowledge and expertise in IT and as such has requested you to convey your findings in a simple, professional and elegant manner.

### Task

Utilising the above background information, you are to analyse the VM image supplied and identify the security issues. You may make as many assumptions as you like regarding any external elements, but these must be stated as bullet points at the beginning of your assignment. Subsequently, the Managing Director will present your findings to the Board of Directors. The Managing Director has specifically asked that you address the following:

1. What are the computer security issues in the VM supplied?
2. Describe why the issues identified are of concern

### Submission

Single Word document and submitted through Blackboard. Do not need ECU assignment cover sheet.

### Report Requirements

The report must contain:

- Title page
	- Unit code and title
	- Assignment title
	- Name
	- Student ID
	- Campus
	- Tutor's name
- Table of contents
	- Must accurately reflect the content of report and should be generated automatically
- Introduction
	- A succinct overview of the report
		- What were you asked to do?
		- Did you do it successfully?
	- Assumptions listed in point form
- Main content
	- Contains analysis, results and methodology
- Conclusion/summary
	- Briefly draw together main points raised in the report
	- Do not introduce or discuss new information
- Glossary
	- A list of uncommon technical terminology that appears in your report
		- Brief explanations and references
- Reference list
	- A list references formatted using APA

# Draft

## Assumptions

- Firewall is present on network
- Firewall allows irc traffic

## Issues

### Operating system

- Windows Vista Business x86 SP0
	- Service packs / updates not installed
		- Numerous security vulnerabilities [Ozkan2015a]
		- SP0 support ended April 13, 2010 [Windows2015]
	- Vista Extended support due to end on April 11, 2017 [Windows2014]
		- "Microsoft no longer provides automatic fixes, updates or online technical assistance"
		- "No longer receive security updates that can help protect your PC from harmful viruses, spyware, and other malicious software that can steal your personal information"
- IE 7.0.6000.16386
	- Outdated browser
	- Numerous security vulnerabilities [Ozkan2015b]
- Windows Defender
	- Virus definitions not updated since version 1.0.0.0 (7/14/2006)
	- System is not protected from any current threats

### Applications

- Anti-virus
	- Symantec AV Scanner shortcut on desktop is fake
		- Only links to html file with fake scan status
		- System is not protected from any threats
- Adobe Reader 6.0.1 11/3/2003
	- Legacy version of application
	- Numerous security vulnerabilities [Ozkan2011]
	- Requires updating to latest supported version
- OpenOffice 1.1.5
	- Legacy version of application
	- Numerous security vulnerabilities [Ozkan2009]
	- Requires updating to latest supported version
- mIRC 6.0
	- IRC file transfer capabilities
	- Can be used to unknowingly download malicious software

### Files

- C:\Users\green\Documents
	- Contains Keepass master password in plaintext master.txt
		- Used to access other stored passwords in password manager
	- Master password should either be stored in encrypted file, or not stored on the computer at all