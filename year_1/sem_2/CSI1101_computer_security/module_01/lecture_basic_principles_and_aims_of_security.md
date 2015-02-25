# Basic principles and aims of security

## Sun Tzu: The Art Of War

- If you know the enemy and know yourself, you need not fear the result of a hundred battles
- If you know yourself but not the enemy, for every victory gained you will also suffer a defeat
- If you know neither the enemy nor yourself, you will succumb in every battle

## Is the internet dangerous?

- Let's start by looking at some examples of dangers that exist in today's online world

### Heartland payment system

- Provides debit, credit card, payroll processing
- Attack occured in March 2008
- Approximately 134 million credit cards exposed
- Attackers used spyware to capture data
- Financial losses exceeded $140 million
- See [link](http://www.csoonline.com/article/499527/heartland-ceo-on-data-breach-qsas-let-us-down)

### Epsilon

- Provides marketing and email services for the largest companies in the world
- Criminals captured and exposed names and emails of millions of customers
- Could be used for clever phishing scams
- Breach is estimated to have cost $4 billion
- See [link](http://blogs.csoonline.com/1457/epsilon_hack_notification_letters)

### Stuxnet

- A computer worm predominantly targeting Siemens Industrial hardware/software
- Payload targets Supervisory Control and Data Acquisition (SCADA) systems
- SCADA systems control and monitor industrial infrastructure and processes
	- Includes power stations

### Sony PlayStation Network

- Considered the worst gaming data breach of all time
- Occured April 20th 2011
- 77 million accounts affected
- 12 million unencrypted credit cards captured
- Sony never officially announced losses
- Combination of malware and DoS attacks
- See [link](http://www.csoonline.com/article/681136/sony-apologizes-details-playstation-network-attack)

### VeriSign

- Operates network infrastructure and naming services
- During 2010
- Attackers gained access to privileged systems and data
- The attack vector is unknown
- VeriSign did not publicise the attack until they were legally obliged
- See [link](http://blogs.csoonline.com/data-protection/2013/verisign-hit-hackers)

### Dept. of Veterans Affairs

- May 2006
- An unencrypted database containing 26.5 million names, SSNs, DOB was stored on a laptop and an external hard disk
- The laptop and hard disk were stolen during a random, untargeted burglary
- Costs estimated at ~$500 million
- See [link](http://www.csoonline.com/article/215541/va-chief-information-security-officer-resigns)

### Relevance of examples

- These preceding slides describe breaches of computer and information security
- There are some generally accepted aims of security
- Exactly how many aims there are depend a little on which books/journals you read

## Aims of security

- Generally the following are considered to be the aims of computer and information security
	1. Confidentiality
	2. Integrity
	3. Availability
	4. Authenticity
	5. Non-repudiation / Accountability
- Some consider all five to be the aims of security
- Others consider only the first three

### Confidentiality

- Confidentiality ensures that information or systems should only be read and accessed by authorised people
- Information should be kept private, secret and out of the hands of unauthorised people

#### Hypothetical breach of confidentiality

- Organisations that store medical records may have a legal, moral and ethical obligation to keep the information private
- If sensitive medical records were accidentally disclosed to the public

#### Importance of confidentiality

- Breaching confidentiality may result in 
	- Loss of revenue
	- Loss of reputation
	- Loss of clients/customers
	- Embarrassment
	- You may be in breach of legal/moral/ethical obligations to keep information confidential

#### Ensuring confidentiality

- Encryption
	- The transformation of data using a secret, so that the transformed data can only be read using another secret
- Access control
	- Rules and policies that limit access to those people and/or systems with a *need to know*

### Integrity

- Integrity ensures that information and systems have not been altered in an unauthorised way
- This is to ensure that information or systems are not tampered with

#### Hypothetical breach of integrity

- A hard disk in a computer malfunctions and corrupts the data
- An employee make unauthorised changes to values in a database
- Malware modifies files on a server

#### Importance of integrity

- Breaching integrity may result in
	- Important decisions being made on information that is no longer trustworthy, correct and free of corruption
	- Corrupted information being difficult to detect
	- Untrustworthy/unreliable backups

#### Ensuring integrity

- Regular backups
- Checksums
- Data correcting codes

### Availability

- Availability ensures that information or systems are accessible and modifiable in a timely fashion by those authorised to do so
- A lack of availablity is often referred to as a denial of service

#### Hypothetical breach of availability

- A website is overwhelmed by fake requests and cannot provide services to clients
- An employee switches off a critical server
- A hard disk malfunctions
- An ethernet cable is removed from a switch

#### Importance of availability

- An organisation may have a committed service level agreement for its clients
- Customers who are unable to make purchases may take their business elsewhere
- Critical decisions may need to be made, based on certain information being readily available

#### Ensuring availability

- Access control
- Computational redundancies
- Physical protection mechanisms

### Authenticity

- Authenticity ensures that an entity is able to prove or verify that it is who or what it claims to be
- Examples
	- Is this person really who they say they are
	- Is this document really what it purports to be
	- Is this really my bank's web server

### Non-repudiation / accountability

- Ensuring that people can't falsely deny their actions
- Examples
	- Alice sends an email and then denies sending it
	- Bob denies receiving an email when in fact he did receive it
	- Frank refuses to pay the bill for an online purchase saying that the goods were not received when in fact they were

### Three or five aims?

- Some people consider confidentiality, integrity and availability to be the major aims of security
- Some consider authenticity and non-repudiation to be aspect of first three aims
- Others consider authenticity and non-repudiation to be aims in their own right
- Ite depends a little on what books you read

## Statistics on computer abuse

- Often difficult to get accurate statistics
	- Attacks may never be detected
	- Attacks that are detected may not be reported
	- Difficulties in quantifying losses
		- How much was that data actually worth?
		- How much will it cost to retrieve/recover the data?
	- If you were a large prominent business, would you want to publicise that you were attacked?

## Security is difficult to sell

- Management may ask
	- What does it cost?
	- What do we get?
	- How much will it cost to maintain?
	- Will we need to train our staff?
	- Imagine attempting to sell your friend *something* that they cannot see or touch and trying to prove to them that they need it

# Ethics and legal issues

## Warning

- In this unit we will discuss a number of threats
- It is very difficult to discuss computer security without discussing such threats
- However students must be sure to use this knowledge responsibly, ethically and legally

## Use of the World Wide Web

- Some security related sites may be somewhat less than reputable
	- Some sites contain material that people might find offensive
	- We have made an effort not to link directly to such sites in this unit
		- However some sites might link to sites, which link to other sites, which links to other sites etc.
	- Students are encouraged to explore the resources offered on the internet, but are also urged to exercise caution and judgement when looking for security related issues
	- If you do go off on tangents when looking for security related information, please be sure to adhere to any relevant laws, policies and guidelines

## Use of security tools

- The legality of security tools will vary in certain jurisdictions
	- For example, encryption tools are illegal in some countries
- Some tools might be legal for use in some ways but not others
	- For example, use or possession of tools without just cause such as packet sniffers will put you in breach of laws

## Ethical behaviour

- In this unit, students will be expected to behave in accordance to
	- Federal and State laws
	- University policies
	- An ethical manner
- See Australian Computer Society [code of ethics](http://www.acs.org.au/index.cfm?action=show&conID=coe)

## Final comments

- Backup your work for ALL units regularly
- You should at the very least use a personal firewall and anti-virus scanner
- If it sounds too good to be true, it usually is
	- Do not download and install unknown software
	- Each semester we get students who have *accidentally* downloaded software resulting in data loss and/or corruption of the operating system