# Functional and Non Functional Requirements

## Background

Finding or eliciting functional and non functional requirements of a system is a critical thinking skill for a systems analyst. Decide if each statment is a functional or non functional requirement by determining if it confirms to the definitions provided in the lecture.

- **Functional** requirement is what a system is supposed to do
- **Non functional** requirement is how the system does it, or a constraint

## Tasks:

1. Decide if following items are functional requirements, non functional requirements or something else.
2. Decide if requirements are well specified or not
3. Re-write as necessary using format
	- User
	- Capability
	- Object
	- Qualifier

### A: The system shall allow users to see all of their invoices for the past 30 days

1. Functional
2. Well specified
3. Re-write not necessary

### B: The system must authenticate users

1. Non functional
2. Not specific enough
	- Which users
	- When does authentication occur
	- How does authentication occur
3. Re-written as functional requirement
	- The user must enter password when logging into the system

### C: The system must have an easy to use interface

1. Something else
2. Not specific enough
	- "Easy to use" too personal
	- Unable to test / validate "easy to use"
3. Re-write not necessary

### D: The database will be MySQL

1. Non functional
2. Well specified
3. Re-write not necessary

### E: All code must be stored in an SVN repo

1. Non functional
2. Well specified
3. Re-write not necessary

### F: The system shall charge users credit cards for purchase

1. Functional
2. Not specific enough
	- What type of credit cards
	- Is there surcharge
3. Re-write required
	- User will be charged via credit card when making a purchase

### G: The system shall store user information, specifically name, DOB and address in an Oracle database

1. Could be split into functional and non functional requirement
2. Well specified
3. Re-write required
	- **Functional:** User name, DOB and address must be stored in the database
	- **Non functional:** The system must use Oracle database

### H: The system shall process all mouse clicks very fast to ensure that users do not have to wait

1. Something else
2. Not specific enough
	- What is "very fast"
	- How long is "wait"
	- Is technology dependent
3. Re-write as non functional
	- The system must respond to user input within 500ms

### I: The system must encode all transactions with 1024 bit RSA keys

1. Non functional
2. Well specified
3. Re-write not necessary

### J: The system shall debit a user's account upon withdrawal of funds

1. Functional
2. Well specified
3. Re-write required
	- User's account must be debited when withdrawing funds

# Finding Requirements in a Document

## Background

Finding functional or non functional requirements is more difficult when the requirements are not explicity, but hidden inside other documents such as interview records and statement of business needs.

## Tasks:

1. Read the text and find the requirements
	- What did you need to find out in order to understand the requirements?
2. Decide if requirements are well specified or not
3. Re-write as necessary using format
	- User
	- Capability
	- Object
	- Qualifier
4. Usually an Analyst will go back to the customer to discuss any items that are not clear. Since this is not possible, list any assumptions you make in order to determine the requirements.

>The system to be developed is a GUI that allows a user to control valves in a plant that makes Ammonia by the Haber process. The software will be responsive to the end user. Ammonia is important in the production of fertilisers, which are important to improve crop yields. The valves will have wireless sensors that communicate via the ZigBee and 802.15.4 protocols. Australia produces 16M tonnes of wheat each year. The sensors send pressure values via wireless. The frames must be encrypted with AES-128 bit encryption. The system must display pressure readings continuously for the preceding 24 hours or since the reactor started the process, whichever is the lesser. When a valve reports a pressure above 220 atmospheres, the system must alert the user. As the users are not programmers, the GUI must be intuitive. If the temperature in the main reactor rises above 500°C, the system must alert the user who must immediately cool the reaction chamber. It is extremely important to note that the reaction is exothermic with a `ΔH of -92 kJmol^-1`. Pressure readings are reported every ten seconds. There are four valves, one for each gas input, a return, and one emergency release.

1. Things I need to find out:
	- What is Haber process
		- [Wikipedia: Haber](http://en.wikipedia.org/wiki/Haber_process)
		- The industrial implementation of the reaction of nitrogen gas and hydrogen gas
	- What is ZigBee protocol
		- [Wikipedia: ZigBee](http://en.wikipedia.org/wiki/ZigBee)
		- Low cost, low power wireless mesh network standard
		- Built from small, low power digital radios
		- Based on 802.15
		- Defined rate of 250kB/s
	- What is 802.15.4 protocol
		- [Wikipedia: 802.15.4](http://en.wikipedia.org/wiki/IEEE_802.15.4)
		- Specificies physical layer and media access control for low rate wireless PAN
	- What does exothermic mean
		- [Wikipedia: Exothermic](http://en.wikipedia.org/wiki/Exothermic)
		- Reaction that releases energy from the system
		- Could be heat or light
	- What does `ΔH of -92 kJmol^-1` mean
		- [Wikipedia: Enthalpy](http://en.wikipedia.org/wiki/%CE%94H)
		- `ΔH`: Delta of internal energy + product of pressure
		- [Wikipedia: Joule per mole](http://en.wikipedia.org/wiki/Joule_per_mole)
		- `kJmol`: unit of energy per amount of material
2. Requirements are well specified, although there is some noise
3. See re-write below
4. Assumptions
	- Sensor can sense temperature and pressure
	- One sensor per valve
	- Mesh network is always able to reach wireless sensor and user
	- Data transfer is within ZigBee limit of 250kB/s
	- Automatic safety precausions exist if reaction chamber is not cooled by user per requirements
	- Disaster recovery, backup strategy in place if sensors are faulty or stop working
	- Control of valve opening and cooling of reaction chamber is in place

### Requirement Re-write

#### Functional

- The user must be able to control valve openings and cool the reactor from the system
- The system must receive data from valve sensors wirelessly
- The system must display pressure readings that are updated every ten seconds continuously for the preceeding 24 hours or since the reactor started the process, whichever is the lesser
- The system must alert the user for immediate action when a valve sensor reports a pressure above 220 atmospheres
- The system must alert the user for immediate action when a valve sensor reports temperature above 500°C

#### Non functional

- Valve sensors will operate wirelessly via ZigBee and 802.15.4 protocol
- Temperatures are to be reported in °C
- Pressures are to be reported in atmospheres
- Data sent wirelessly must be encrypted with AES-128 bit encryption
- There will be four valves, four sensors