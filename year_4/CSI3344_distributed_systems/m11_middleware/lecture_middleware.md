# Middleware

## Overview

- CORBA
- DCOM
- Compare CORBA vs. DCOM

# Introduction

- Middleware in form of platforms provides tools for distributed systems
  - Implementation
  - Management
  - Performance improvements
- Examples
  - CORBA
  - DCOM
- Middleware services
  - Communication
  - Process and naming services
  - Synchronization
  - Consistency
  - Fault tolerance
  - Security

# CORBA

- Common Object Request Broker Architecture
- By Object Management Group (OMG), 1990s
  - 800 members from industry
- CORBA global architecture is specified by OMG reference model
  - CORBA 1
    - Interface definition language
  - CORBA 2
    - Interoperability
  - CORBA 3
    - Internet integration
    - Service control
    - Component architecture

## CORBA global architecture

![corba global architecture](https://snag.gy/4bOdiX.jpg)

### Object Request Broker (ORB)

- Forms core of an CORBA system
- Responsible for enabling communication between objects and clients
- ORB implemented as libraries

### Horizontal facilities

- Containing general purpose high level services that are independent of application domain
  - User interfaces
  - System management

### Vertical facilities

- Consisting of high level services that are offered to a specific application domain
  - Banking
  - E-commerce

### Organisation of CORBA systems

![organisation of corba systems](https://snag.gy/jlK05m.jpg)

## What is an ORB

### Communication

- Locates the remote object on the network
- Communicates the request to the object
- Waits for the results
- When available, communicates results back to the client

### Location transparency

- Implements location transparency
- Same request mechanism is used by the client and CORBA object
- Regardless of where the object is located

### Programming language independence

- Implements programming language independence for the request
- Client issuing the request can be written in a different language from implementation of CORBA object
- ORB does the necessary translation between languages

### Language bindings

- Language bindings are defined for all popular programming languages
- There are ORBs available for many combinations of OS and development environments
- ie. ORB for Java on Unix
- ie. ORB for C++ on Windows NT

![language bindings](https://snag.gy/lS1L9a.jpg)

## Why use CORBA

- Provides high degree of interoperability
  - Tries to ensure that distributed objects built on top of different CORBA compliant products can communicate
- Supports many existing languages
  - Supports mixing of languages within a single distributed system
- Industry standard
  - Provides developers with degree of portability between implementations
- Compliant applications can be used by all companies with CORBA compliant programs or systems
  - May need tweaking

## How to develop CORBA

1. Write object oriented program as usual
2. Get it working on one computer
3. Write a CORBA wrapper for the object to become remote
4. Replace references to local object with references to remote object

## CORBA services

![corba services](https://snag.gy/fHV4mO.jpg)

# DCOM

- Microsoft
  - Introduced in Win 95
- Distributed Component Object Model
  - Offers primarily access transparency
  - COM and DCOM are the same
- No CORBA like committee governing architecture and technical regulations

## Organisation of COM, OLE and ActiveX

![activex, ole and com](https://snag.gy/9K56D1.jpg)

### COM

- An OS like system to support the development of components
- Can be dynamically activated
- Can interact with each other
  - Text
  - Image
  - Table

### OLE

- Object Linking and Embedding
- Offers support for connectivity of various components

### ActiveX

- Functionally similar to OLE
- Provides more powerful and flexible capabilities for supporting activities of components in different processes

## Organisation of DCOM

![organisation of dcom](https://snag.gy/AwIFtS.jpg)

- Registry + COM == ORB in CORBA

### Type library and registry

- DCOM interface repository is called type library
- A list of all type libraries is kept in registry
- Registry directs incoming invocations to the requested type library (interface)
- Then the associated object is executed

### Service control manager (SCM)

- Process responsible for activating remote objects
  - Similar to implementation repository in CORBA
- Client contact's the host's SCM to execute object on remote host
- Then looks in own local registry to find file and start it

## DCOM services

| CORBA service   | DCOM/COM+ service               | Windows 2000 service |
| --------------- | ------------------------------- | -------------------- |
| Collection      | ActiveX data objects            | -                    |
| Query           | None                            | -                    |
| Concurrency     | Thread concurrency              | -                    |
| Transaction     | COM+ automatic transactions     | -                    |
| Event           | COM+ events                     | -                    |
| Notification    | COM+ events                     | -                    |
| Externalization | Marshalling utilities           | -                    |
| Life cycle      | Class factories, JIT activation | -                    |
| Licensing       | Special class factories         | -                    |
| Naming          | Monikers                        | Active directory     |
| Property        | None                            | Active directory     |
| Trading         | None                            | Active directory     |
| Persistence     | Structured storage              | Database access      |
| Relationship    | None                            | Database access      |
| Security        | Authorization                   | Database access      |
| Time            | None                            | None                 |

# CORBA vs. DCOM comparison

| Issue                      | CORBA              | DCOM               |
| -------------------------- | ------------------ | ------------------ |
| Design goals               | Interoperability   | Functionality      |
| Object model               | Remote objects     | Remote objects     |
| Services                   | Many of its own    | From environment   |
| Interfaces                 | IDL based          | Binary             |
| Synchronous communication  | Yes                | Yes                |
| Asynchronous communication | Yes                | Yes                |
| Callbacks                  | Yes                | Yes                |
| Events                     | Yes                | Yes                |
| Messaging                  | Yes                | Yes                |
| Object server              | Flexible           | Hardcoded          |
| Directory service          | Yes                | Yes                |
| Trading service            | Yes                | No                 |
| Naming service             | Yes                | Yes                |
| Location service           | No                 | No                 |
| Object reference           | Object's location  | Interface pointer  |
| Synchronization            | Transactions       | Transactions       |
| Replication support        | Separate server    | None               |
| Transactions               | Yes                | Yes                |
| Fault tolerance            | By replication     | By transaction     |
| Recovery support           | Yes                | Yes                |
| Security                   | Various mechanisms | Various mechanisms |

## Difference between language defined and binary interfaces

![language defined vs binary interfaces](https://snag.gy/O05K2X.jpg)

### CORBA IDL

- CORBA follows language based interface approach
- Provides standard IDL in which specifications are mapped to various languages
- Good
  - Independent of compilers
  - Interoperability at level of programming languages

### DCOM Binary

- DCOM follows binary interface approach
- Interfaces to objects are defined independent of programming languages
- Good
  - Achieve maximum portability and interoperability
- Bad
  - Clients may need to learn Microsoft DL

# Inter-networking between CORBA and DCOM

- Often need to network between CORBA and DCOM
- Done by providing a bridge between DCOM and CORBA
  - Many vendors provide this functionality to expand their market
- Four possible scenarios below

![inter-networking](https://snag.gy/vnP6uL.jpg)