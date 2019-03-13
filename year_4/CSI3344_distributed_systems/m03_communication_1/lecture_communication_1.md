# Communication 1

## Overview

- Open systems interconnection model
- Internet communication model
- Data communications standards
- Major points
- Reading guide

## Objectives

- Be familiar with OSI protocols
- Describe roles of each layer in OSI protocols
- Be familiar with internet communication model
- Correlations between each OSI model and internet communication model
- Be aware of communication standards

# Open systems interconnection (OSI) model

- Inter process communication is at heart of all distributed systems
- Communication is always based on low level message passing as offered by underlying network

## What are communication protocols

- Protocols are the rules that communication processes must adhere to
- Protocols are often constructed in the form of layers

# OSI model

![osi model overview](https://snag.gy/ztxqjT.jpg)

## ISO OSI model

![iso osi protocols](https://snag.gy/JGh52D.jpg)

- ISO
  - International Standards Organisation
- OSI
  - Open Systems Interconnection reference model
- The layered (ISO) OSI protocols set standard rules that govern messages sent and received
  - Format
  - Contents
  - Meanings
- Each of the seven layers deals with the one specific aspect of the communication

# OSI layer groups

- Seven layers of OSI protocols can be viewed as three groups
  - Application
  - Internetwork
  - Hardware

![osi layer groups](https://snag.gy/idt9M0.jpg)

## Application

### 7: Application layer

- Set of utilities used by application programs

### 6: Presentation layer

- Formats data for presentation to user
- Provides
  - Data interfaces
  - Data compression
  - Translation between different data formats

### 5: Session layer

- Responsible for managing logical session between sender and receiver
  - Initiation
  - Maintaining
  - Terminating

## Internetwork

- Connect applications to the network
- Determine best route for sending messages between sender and receiver

### 4: Transport layer

- Deals with end to end issues
  - Segmenting the message for network transport
  - Maintain logical connections between sender and receiver

### 3: Network layer

- Responsible for making routing decisions

#### Routing tables

![routing](https://snag.gy/sUCFuY.jpg)

- Routing tables are held at each of the routers
- Routing decision is made on hop by hop basis
  - Using locally held information to determine next hop to be taken by each incoming packet
- Link
  - Outgoing link for packets addressed to the destination
- Cost
  - The number of hops to the given destination

![routing table](https://snag.gy/zm9UTi.jpg)

## Hardware

- Move messages from one computer/device to another

### 2: Data link layer

- Deals with
  - Message delineation
    - Indicating the exact position of a border or boundary
  - Error control
  - Network medium access control

![data link example](https://snag.gy/9QOSvp.jpg)

### 1: Physical layer

- Defines how individual bits are formatted then transmitted through the network

# Glossary

## Frames

- Bits sent from physical layer are grouped in the data link layer into units **frames**
- A special bit pattern is added to the start of each frame
- A checksum counting up all the bytes in the frame is added to the frame in a certain way

![frame](https://snag.gy/SwgJA7.jpg)

## Packet

- The technical term for a message in the network layer is called **packet**

## Routing

- How to choose the best path from the sender to receiver is called routing
- Only needed for WAN

# Middleware layer

- The OSI application layer should only contain a collection of standard network applications
- Now it contains all applications
  - Should be in
- Application specific protocols not fit into any underlying layers
  - Should be out
- There are also many general purpose protocols that are useful to many applications
  - But cannot be qualified as transport protocols
- All these protocols fall into category of middleware protocols
  - Form middleware layer

# Internet communication model

- Internet communication model has 4 layers

![internet layers](https://snag.gy/1PAN7a.jpg)

- How layers fit into practice

![internet layers 2](https://snag.gy/T23Cyz.jpg)

## How a message is transmitted by layers

- Outgoing messages travel down all network layers
- Before sending a message to next layer, each layer places it in an envelope of overhead information related to that layer
  - Encapsulation
- At the receiving end, messages travel up through the network layers
- Each layer removing the envelopes added at the outgoing side

## Example web page request

![web page request](https://snag.gy/8nZA3f.jpg)

## What happens when clicking a hyperlink

- Starts http request response cycle
  - Browser sends http request
- Http request is handed to transport layer's tcp protocol
  - Placed in a tcp segment
- Tcp segment is placed in an ip packet
- Ip packet placed in a data link layer (usually ethernet) frame
- Frame sent out over physical layer (network medium) as bit stream
  - Binary
- On the web server
  - Process occurs in reverse
- Each layer removing the overhead information added by each layer
- Until the http request is finally produced for the server to read
- The server then sends a http response back to the client
  - Sent back to the user's web browser

## Http message

![http messages 1](https://snag.gy/EbiYdU.jpg)

### Http message example

![http messages 2](https://snag.gy/jtS4He.jpg)

##  Http response message

![http response 1](https://snag.gy/iyqPpK.jpg)

### Http response example

![http response 2](https://snag.gy/4DUzpa.jpg)

# Data communication standards

## Why standards

- Provide a fixed way for hardware and/or software systems to communicate
  - ie. USB enables two pieces of equipment to interface
  - Even though they are manufactured by different companies
- By allowing hardware and software from different companies to interconnect
- Standards help achieve heterogeneity

## Types of standards

### Formal

- Developed by an industry or government standards making body

### De facto

- Standards that emerge in the marketplace and are widely used
- But lack official backing by standards making body

## Major standards making bodies

- [ISO](https://iso.org)
  - International organisation for standardisation
- [ITU-T](https://www.itu.int/en/Pages/default.aspx)
  - International telecommunications union - Telecom group
- [ANSI](https://www.ansi.org/)
  - American national standards institute
- [IEEE](https://standards.ieee.org)
  - Institute of electrical and electronic engineers
- [IETF](https://www.ietf.org/)
  - Internet engineering task force

## Common data communication standards

![common standards](https://snag.gy/zcZGHU.jpg)

# Major points

- Layered (ISO) OSI protocols
- Specific aspect of each of seven layers
- Internet communication model
- Relationships between OSI and internet models
- Message transmission through layers
- Why standards

# Reading

- DSPP
  - 4.1
- DSCD
  - 3.3.4
  - 3.3.5