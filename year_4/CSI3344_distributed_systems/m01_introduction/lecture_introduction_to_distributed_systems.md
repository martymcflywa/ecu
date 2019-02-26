# Introduction to distributed systems

## Objectives

- Be aware of arguments on definitions of distributed systems
- Give examples of distributed systems
- Discuss benefits
- Discuss challenges in design and construction
- Be familiar with general system models
- Be familiar with middleware position and services

# Definition and examples

## Definition

Tanenbaum & van Steen (2007)

> A distributed system is a collection of independent computers that appear to its users as a single coherent system

- This definition addresses that
  - Machines are autonomous
  - Users think they are dealing with a single system
    - Transparency
- Issues with this definition
  - How does the system work  
    - Concurrency
  - What is the purpose of using a distributed system
    - Communications

Coulouris et al (2001)

> A distributed system is a system in which hardware and software components located at networked computers communicate and coordinate their actions only by passing messages

- This definition addresses that
  - A network is for passing messages
    - Communications
  - The system coordinates all the actions
    - Concurrency

Both previous definitions only focus on computers. An alternative definition, which is a combination of both:

> A distributed system is a collection of independent devices tht appear to its users as a single coherent system, in which networked components communicate and coordinate their actions only by passing messages

- This definition covers the four important issues of any distributed system
  - Networked communications
  - Concurrency
  - Transparency
  - Independent failure

## Examples

### Typical portion of Internet

![internet](https://snag.gy/qICyph.jpg)

### Portable and handheld devices in a distributed system

![devices](https://snag.gy/dk8Fhu.jpg)

### Distributed services in software systems

- Email
  - Simple Mail Transport Protocols SMTP
- News
  - Network News Transport Protocols NNTP
- File transfer
  - File Transfer Protocols FTP
- World Wide Web
  - HyperText Transfer Protocols HTTP
- Electronic payment
- Distributed transaction processing
- Distributed real-time processing

# Benefits and challenges

## Benefits

### Share-ability

- Ability of comprising systems to use each others resources
  - Sharing resources is main motivation
    - Hardware
    - Software
    - Information
- Resources may be managed by servers and accessed by clients
  - Or encapsulated as objects
  - Accessed by other client objects

### Expandability

- Permits new systems to be added as members of overall system
- Allows more users to share new and existing resources

### Local autonomy

- Responsible for managing its resources
- Can apply the following to its resources and services
  - Local policies
  - Settings
  - Access controls

### Improved performance

- Allows resources to be distributed in different machines
- Requests for resources are sent to different machines
  - Making processing more efficient

### Improved reliability and availability

- Resources are spread or replicated across multiple computers
- A disruption might cause only minimum impact on system

### Potential cost reduction

- Not always obvious

## Challenges

### Heterogeneity

- Should allow users to access services and run applications over a heterogeneous collection of computers and networks
- Applies to
  - Networks
  - Hardware
  - OS
  - Programming languages
  - Implementation by different developers

### Openness

- Should allow the system to be extended and reimplemented in various ways
- Measured by degree to which new resource sharing services can be added without disruption or duplication of existing services
- Be made available for use by a variety of client programs
- Two perspectives
  - Hardware extensibility
  - Software extensibility

### Security

- Protect resources against unauthorized activities
- CIA
  - Confidentiality
    - Against disclosure to unauthorised individuals
  - Integrity
    - Against alteration or corruption
  - Availability
    - Against interference with means to access the resources

### Scalability

- Characteristic where system remains effective when there is significant increase in number of resources and/or number of users

### Fault handling

- Failures should be partial
  - Some components fail while others continue to function
- High degree of availability in face of hardware faults
  - Availability is measure of proportion of time that is available for use
- Techniques for handling failures
  - Detecting failures
  - Masking failures
  - Tolerating failures
  - Recovery from failures
  - Redundancy

### Concurrency

- Ability to process multiple tasks at the same time

### Transparency

- Concealment of separation of components
  - System presents itself to users/applications as a single system
- Measured by different types of transparencies

#### Mobility

- Allows movement of resources and clients within a system without affecting operation of users or programs

#### Performance

- Allows system to be reconfigured to improve performance as loads vary

#### Scaling transparency

- Allows system and applications to expand in scale without change to the system structure or application algorithms

## General system model

- Organised as layered structure

![structure](https://snag.gy/w9f6Sj.jpg)

### Platform

- Lowest layer
- Provides services to layers above
- Each local OS should provide local resource management and communication means to other computers
- Examples
  - x86/x64 Windows
  - x86/x64 Linux
  - x86/x64 Solaris
  - SPARC SunOS
  - PowerPC/x86/x64 MacOS

## Middleware

- Software that connects different kinds of applications
- Provides distributed transparency to connected applications
- Does not manage individual nodes
- Mask heterogeneity
- Provide convenient programming model to application developers
- Examples
  - Sun RPC
    - Remote Procedure Calls
  - OMG CORBA
    - Common Object Request Broker Architecture
  - Microsoft D-COM
    - Distributed Components Object Model
  - Sun Java RMI
  - Manjrasoft Aneka
  - IBM Websphere
  - Microsoft .NET
  - Sun J2EE
  - Google AppEngine

### Middleware position

![middleware position](https://snag.gy/qzIkrK.jpg)

### Middleware models

- Make development and integration of distributed applications as simple as possible
- Based on certain model for describing distribution and communication

#### Early models

##### Unix file system

- Everything treated as a file
  - Local or remote
- Application opens file, reads/writes bytes, closes it
- Communication efficiency is reduced when file is accessed by several processes at the same time

##### Remote procedure calls RPC

- Emphasis on hiding network communication
- Allow a process to call a procedure being executed on a remote machine
- Calling process remains unaware of fact that the network communication took place

![rpc](https://snag.gy/mnhyLl.jpg)

#### Recent models

##### Distributed objects

- Should be able to hide network communication over RPC but also invoke objects residing in remote machines in transparent fashion
- Each object implements an interface that hides all the internal details of object from user
- Only thing that a process sees of object is interface

##### Distributed documents (www)

- Information organised into documents
- Each document residing at a machine transparently at remote or local location
- Documents contain links that refer to other documents
- By following link, another document is fetched from location and displayed on screen


### Middleware services

#### Communication services

- Offers high level communication services that hide low level message passing through computer networks

#### Naming

- Name services allow entities to be shared and looked up
  - As in directories
  - Similar to phone books

#### Persistence

- Special facilities for storage

#### Distributed transactions

- Special facilities for distributed transactions
- Distributed transaction services allow multiple read/writes to occur atomically
  - Either success so all write operations are performed
  - Or fails leaving all referenced data unaffected

#### Security

- See m10

## Read

- Textbook
  - 1.1
  - 1.2
  - 1.4.3
- Reference
  - All chapter 1
  - 2.2.1