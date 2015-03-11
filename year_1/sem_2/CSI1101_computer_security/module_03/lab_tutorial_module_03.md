# Tutorial 3

## 1: Test your AV software

1. Go to http://www.eicar.org/anti_virus_test_file.htm and read
	- The file is not an actual virus but designed to appear as a virus to av software
2. Click [eicar.com](http://www.eicar.org/download/eicar.com)
	- A dialog box opens to ask if you want to download the file
		- See what happens
		- What does av software do?
		- Close the message and click cancel to stop download
3. Click [eicar_com.zip](http://www.eicar.org/download/eicar_com.zip)
	- Note what happens when clicking the file
4. If av software did not prevent you from downloading the file, save it to desktop
5. How is the av program detecting this file as malicious?
6. Thinking back to a few weeks ago, how is it that a fake virus can be detected by your av scanner, yet not be malicious?
	- A fake virus is given a signature that matches a signature of a known virus

## 2: Questions

The following questions are designed to test your knowledge of what you have learned so far and to allow you to apply your analytical skills to a given problem. Similar questions may be present in exam.

### 2.1

>John is a software developer, and designed an online banking system. John included a feature that would email him the bank account information for any account where the total balance exceeds $1000.

>What kind of malware attack is this and why?

A logic bomb. Code is executed when a condition is met.

### 2.2

>Suppose that you are a malware developer. Hence you know that you need to store a copy of the code for your virus inside the virus itself. Moreover, suppose you know that a security administrator is also aware of this fact and will be using it to detect the presence of your malware in operating system files.

>Explain how you (the malware developer) can hide the embedded copy of your malware so that it is difficult for the security admin to find

- Encrypt code
	- Include encrypt/decrypt engine
- Hide from AV
	- Copy data from uninfected files to malware
- Polymorphism
	- Change appearance
	- Mutate every infection
	- Change crypto keys
	- Data append/prepend
- Metamorphism
	- Mutate and rewrite malware with every iteration
	- Add useless instructions and loops

### 2.3

>Based on a true story: Suppose a network malware specimen is designed so that as soon as it is copied onto computer X, it copies itself to six of X's neighbouring computers. Each time it copies itself it uses a random filename to avoid detection.

>The malware itself does no other harm, in that it doesn't read, delete or modify any files. What harm would be done by such malware and how would it be detected?

- Metamorphic
- Harm
	- Uses up hard drive space
- Detection
	- Random files appear on drive
	- Through signature
		- If a known virus/malware in AV database

### 2.4

>In a salami-slicing attack, a program performs a large number of small, hardly noticeable malicious actions, which add up to a large aggregate malicious action. As an example, a programmer for a bank has 1 cent of the monthly interest calculation on each bank customer's account transferred into his account.

>Thus, if the bank has 1,000,000 customers, the developer would get $10,000 each month from the salami slicing attack. What type of malware is such a program based on?

- Logic bomb

### 2.5

>Viruses that perform no explicit malicious behaviours are called bacteria or rabbits. Explain how such seemingly benign viruses can still have negative impacts on a computer system.

- Can still use up disk space, memory, cpu cycles
- If virus is daemon, could be used by other attacks to gain access

### 2.6

>Bart told his teacher that the reason he is unable to submit his Microsoft Word assignment is that malware ate his homework. What type of malware would be the most likely culprit?

- Macro virus

### 2.7

>Explain why it is often beneficial for an adware author to include spyware in his adware.

- To better target the victims with advertising

### 2.8

>Laura installed spyware software on 100 USB flash drives and designed this software to load automatically from these drives along with some nude photos. She then painted the logo of a well-known adult magazine on each one and randomly scattered these flash-drives in the parking lots of several of the big defence companies in her town.

>What type of malware attack is this and what vulnerability is she trying to exploit in order to get her malware code past the network firewalls of these computers.

- Social engineering
- Human assisted
	- Inside attack
- Trojan

### 2.9

>What would be the financial advantage for a malware designer to create lots of different malicious code instances that all exploit the same vulnerability yet have different malware signatures?

- Chance that not all instances will be detected by AV

### 2.10

>Describe the process of a malware attack that would cause a victim to receive physical advertisements.

- Obtain location data of victim
	- IP geolocation
	- Wifi geolocation
- Send location back to attacker
- Match with google maps for address
- Send advertising
- Profit
