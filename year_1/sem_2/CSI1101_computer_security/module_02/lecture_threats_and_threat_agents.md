# Threats and agents

## What is a threat?

- A possible danger
- Any possibility which if to eventuate would cause some degree of harm
- An act designed to obtain a negative response

## What is a vulnerability?

- A flaw or weakness in the design, implementation, or operation of a system
- How open something is to an attack
- Threats act on or exploit vulnerabilities
- The possibility of being attacked or harmed

## What is risk?

- Risk is the potential harm that may arise from some current process or from some future event
- Risk management is the process of understanding and responding to factors that may lead to a breach of confidentiality, integrity or availability

### Risk assessment

- Risk is the **likelihood** of the occurrence of a vulnerability
- **Multiplied** by
- The value of the asset
- **Minus**
- The percentage of risk mitigated by current controls
- **Plus**
- The **uncertainty** of current knowledge of the vulnerability

### Risk control strategies

- Defence
  - Apply safeguard to eliminate/reduce risk
- Mitigation
  - Plan/prepare thus control the risk
- Acceptance
  - Accept outcome of an exploitation
- Transferal
  - Shift risk to other assets, processes or organisations (insurance)
- Termination
  - Remove an asset from the environment thus removing the risk

### Instinctive risk assessment

- Every day we perform a basic form of risk analysis **instinctively**
- We automatically attempt to assess the risk involved with the things that we do
- We we cross a busy road, we automatically perform an instinctive risk assessment

### Real vs. perceived risk

- During the period of the Washington Sniper, many parents elected to drive their children to school believing this to be the safest course of action
- Bruce Schneier argued that the probability of everyone in the car dying in a traffic accident was greater than any one of them being killed by the Washington Sniper
- Shoppers will worry about E.coli bacteria on spinach leaves but fill their shopping cart with fatty foods
- People worry about the plane they are in crashing, yet on a global level, more people die in car accidents

### Risk perception

>I don't earn over $40,000 a year

- So I will not be a victim to internet crime
- So I do not need to use security software

>You have to use the internet everyday to be attacked online

## Generic threats

- In terms of computer security, there are generally considered to be four generic threats
	1. Interception
	2. Modification
	3. Fabrication
	4. Interruption

### Interception

- An unauthorised entity gains access to an asset
- Could be a person, a program or a computer system resulting in a breach of **confidentiality**
- Copying of data/files, wiretapping etc.

![interception](http://snag.gy/pAVSR.jpg)

### Interruption

- An asset is lost, unavailable or unusable
- A breach of **availability**
- Physically destroying hardware
- Erasing a program or files
- Disconnecting a power or network cable

![interruption](http://snag.gy/FnWbu.jpg)

### Modification

- An unauthorised party alters an asset
- A breach of **integrity**
- Changing values in a database
- Modify data transmitted electronically
- Modify programs so they perform additional tasks

![modification](http://snag.gy/AE7tu.jpg)

### Fabrication

- Falsely creating objects on a system
- A breach of **integrity**
- Creation of false records in a database
- Creation of additional processes to consume system resources

![fabrication](http://snag.gy/ps0ZO.jpg)

## Specific threats

- The previous sections indicated four generic types of threats
- Lets move on and discuss more specific examples
- You should be able to relate these specific threats back to the generic threats already covered

### Examples of specific threats

- Intrusion
- Hacking
- Espionage
- Destruction of hardware
- Destruction of software
- Destruction of data
- Hardware theft
- Software theft
- Data theft
- Injection of traffic/data
- Corruption of data
- Eavesdropping
- Surveillance
- Social engineering
- Malware
- Information warfare

This is by no means an exhaustive list.

### Hacking

- Hacking is one of the most abused terms in the computer security field
- A catchy term often ab/used by the media
	1. An individual who maliciously breaks into a computer system
	2. An individual with advanced skills who tests and identifies system vulnerabilities

### Information warfare

- The utilisation of information to gain an advantage
- Information warfare can be used to describe a wide variety of activities
	- Cyber-war
	- Net-war
	- Psychological operations
	- Information operations
- Information could be the target, the weapon, an enabler or force multiplier
- IW may entail information denial, disinformation, deception (in many forms)

### Malware

- A catch-all, umbrella term to describe a range of **mal**icious soft**ware**
	- The term virus is also often abused, particularly by the mainstream media
	- We will discuss malware in a later module

### Espionage

- Obtaining information in a secretive manner
- Could occur between nations, corporations or any non-state actors
- Could involve theft of information
	- Via network or system intrusions
	- Dumpster diving
	- Social engineering

### Eavesdropping / surveillance

- Monitoring / listening to an entity without consent
- Could be done for any number of reasons or in any number of ways
	- Electronic
	- Optical
	- Profiling of web browsing habits, credit card purchases
		- Data mining

### Social engineering

- Manipulating people through social interaction
	- Over the telephone
		- "Hi, it's Fred from IT. We're having some problems with your account, if you could just give me your username and password..."
	- In person
	- Via email
- You'd be surprised how much information you can get out of someone just by asking for it

## Threat agents / attackers

- The source of these threats
	- Human
	- Natural
	- Animal
- Examples might include
	- Malware writers
	- Hackers
	- Fraudsters
	- White collar criminals
	- Organised criminals
	- Disgruntled employees
	- An opposing team
	- Governments

### Motivation of attackers

- Financial
- Emotional
	- Revenge etc.
- Ideological
	- Activists
	- Hacktivists
- Opportunity
- Compulsion / addiction
- Social acceptance
- Challenge

This is by no means an exhaustive list.

### Capabilities of attackers

- Is your attacker an
	- Individual?
	- A group?
	- An organisation?
- What are the capabilities of the threat agents?
- How well resourced are they?
	- The NSA might have the resources to brute force an encryption algorithm
	- The average individual probably would not

### Risk aversion

- How risk averse is the attacker?
- Does the attacker fear repercussions of being caught?
	- A white collar criminal committing fraud might be highly risk averse
	- Someone with nothing to lose might not be so risk averse
- What risks will the attacker be prepared to take?

## Threat modelling

How do we identify and analyse threats?

### Modelling threats

- We often tend to identify threats in an adhoc manner
	- We address threats in the order that we think of them
	- What about the threats we don't think of?
	- Is there a more structured way?
		- A methodology?
- Schneier advocates a technique known as attack trees or threat trees

### Attack trees

- A more formalised way of identifying threats
- We put ourselves in the position of the attacker
- We first decide on our overall goal
- We then decide on a number of ways to acheive this
- Then each of these becomes a goal
	- And we think of how to acheive these

#### Attack trees example

- Suppose that our ultimate aim is to steal a diamond from a store that is kept in a safe
- We could represent many different approaches in the form of an attack tree
- Sometimes these diagrams are referred to as **threat trees**

##### Steal diamond

- The person looking at the diagram could be management who may not always want to read a detailed (lengthy) report
- The first node is our main goal
- It should be specific
	- ie. A goal of just 'diamond' does not tell the reader anything
- So lets start with the first node **Steal Diamond**

![end goal](http://snag.gy/BEYnN.jpg)

- Next we need to consider perhaps through *research*, the ways in which the diamond could be stolen from the safe
- In this scenario, four ways have been identified
- However, we could have identified any number of ways
- The four identified ways on the second row now become our new goals

![row 2](http://snag.gy/fYceH.jpg)

- Again we have researched and identified four ways as to how we could determine the combination of the safe

![row 3.1](http://snag.gy/ZEaCs.jpg)

- Next we look at the ways we could force the safe open

![row 3.2](http://snag.gy/dES3f.jpg)

- The process continues until sufficient information is provided on the diagram so that an individual who has little expertise in the area could understand and interpret the attack approach that is being described

![full tree](http://snag.gy/x0m0W.jpg)

## Determining possible attack avenues?

- Journal papers, conference papers
- Blackhat conferences, Defcon, Kiwicon
- News media, magazines
- What attacks have occured in the past?
- Variations of old attacks?
- Common vulnerabilities and exposures
	- [cve.mitre.org](http://cve.mitre.org)

## Controls, safeguards and countermeasures

How do we determine appropriate controls to reduce risk?

### Controls and safeguards

Controls can be:

![controls](http://snag.gy/LPRtS.jpg)

### Determining effective controls

- What controls are available?
	- Need to identify possible controls
- How effective will the control be in mitigating threats and reducing risk?
	- This is often difficult to estimate
- How feasible are these controls?
	- In terms of economic, technical and practical feasibility
- What trade-offs are involved?
	- Controls almost always involve some trade-off
		- Money
		- Privacy
		- Convenience
		- etc.

### Trade-offs

- Security control almost always involve trade-offs
- Money
	- Purchase price
	- Training
	- Maintenance
- Privacy / liberty
	- ie. CCTV cameras, passenger screening lists
- Convenience
	- If controls are overly restrictive, users may try to circumvent them

#### Evaluating trade-offs

- How much security do we gain from the trade-off?
- What does it cost us?
- Is it worth the cost?
- Sometimes security measures are simply meant to re-assure people and make them feel better
	- ie. Does providing a plastic knife with an airline meal instead of a metal knife make us any more secure?

### Determining appropriate controls

- Appropriateness of controls might also depend on your point of view
	- ie. If you are a home owner, you might install an alarm system
		- This might cause a burglar to bypass your house and rob your neighbours house instead
		- This measure might be appropriate for you as a home owner
	- But the same countermeasure might not be appropriate for the local police, who want to reduce burglaries in general

### Defence in depth

- Defence in depth (DiD) is an important concept when considering countermeasures
	- Layering security measures
- It is much more difficult to defeat several countermeasures than just one
	- Of course it is important that these countermeasures are independent and the breaching one does not automatically breach them all
- The principle applies in both physical and a logical sense
