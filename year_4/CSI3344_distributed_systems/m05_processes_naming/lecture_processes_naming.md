# Processes and naming services

## Overview

- Processes and threads
- Client and server processes
- Names, addresses and identifiers
- Name resolution
- Major points
- Reading guide

# Introduction

- To achieve communication in distributed systems, we need
  - Communication protocols
    - Format
    - Contents
    - Meaning of messages
  - Processes
    - Actions to carry out interactive activities
  - Naming service
    - Mechanism to distinguish servers from one another
- For a message to be delivered from a client to a specific server
  - The client needs to know the target server's attributes
    - Name
    - Address

# Processes and threads

- Processes and threads belong to the regime of distributed operating systems
- System layers
  - Positions of processes and threads

![system layers](https://snag.gy/8svu1B.jpg)

## Processes

### What is a process

- The procedure of a program execution
- OS creates a number of virtual processors
  - Each processor runs a specific program
- OS has a process table to keep track of these virtual processors
- A process is often defined as a program in execution
  - A program that is currently being executed on one of the OS virtual processors

![win task manager](https://snag.gy/ZCXr8k.jpg)

### Process creation

- When a process is created, a memory address space is allocated to it

![process creation](https://snag.gy/jMhtP2.jpg)


### Process items in memory

- Address space
- Global variables
- Open files
- Child processes
- Pending alarms
- Signals and signal handlers
- Accounting information

## Threads

### What is a thread

- Similar to process
  - Can also be seen as the execution of a program on a virtual processor
- Generally only maintains the minimum information to allow a CPU to be shared by several threads
  - CPU context

### Thread items in CPU

- Program counter
- Registers
- Stack
- Stage

### Thread model

![thread model](https://snag.gy/167pbI.jpg)

- Example: word processor with three threads

![word processor with three threads](https://snag.gy/f74gxS.jpg)

## Threads in distributed systems

### Multithread clients

- A multi threaded client machine can use several threads
- In series
  - To separately fetch data of a particular document from the same server one after another
    - ie. Web browser
- In parallel
  - To fetch data of a particular document simultaneously from several servers/sources
    - ie. Replicated databases

### Multithread servers

- Can provide processing for parallel requests
- Partial system call blocking

#### Example: Multithread file server

![multithread file server](https://snag.gy/EXYza0.jpg)

# Client and server processes

## Client processes

- Client processes generally implement user interfaces
- All user actions with PCs/workstations are performed with user interfaces on the client side
  - Drag and drop
  - In place editing
- All user requests to remote servers are sent through actions on user interfaces on the client side
  - Web search
  - Send/receive email
- Client software provides support for achieving distribution transparency
  - Hides communication details between client and server

## Server processes

- Server processes generally implement a specific service on behalf of a collection of clients
- Basic functions
  - Wait for incoming request from client
  - Ensure request is processed properly
  - Wait for next incoming request
    - After finishing last service

## Server classification

### Iterative server

- Server main thread handles request
- Responds to client
  - If necessary

### Concurrent server

- Server does not handle request
- Passes it to a separate worker process/thread
- Immediately waits for next incoming request
- Worker process/thread responsible for sending response to client

### Stateless server

- Server does not keep information on the state of its client
- ie. Web server

### Stateful server

- Server keeps client state information
- ie. Server for online survey

## Server design issues

- A mechanism to interrupt server after request has been sent
- Addressing services
  - Where does a request from client to server go?
    - Port
    - Endpoint
  - Example
    - FTP on port 21
    - WWW TCP on port 80

# Names, addresses and identifiers

## What is a name

- A string of bits
  - Mostly for naming an internal entity
- A string of characters
  - For naming a visible entity to users

![name](https://snag.gy/bmXi8c.jpg)

## What is an entity

- Can be anything associated with the system
  - Client machines
  - Servers
  - Printers
  - Files
  - Disks
  - Users
  - Web pages
  - Com ports

![entity](https://snag.gy/QFLgy0.jpg)

## What is an address

- To operate on an entity, we need an access point to access it
  - A special kind of entity
- The name of an access point of an entity is the address of that entity

![address](https://snag.gy/DO5Gni.jpg)

## Relationship between name, entity and address

- An entity may be referred by more than one name
  - ie. Web page bookmarks
- A name may be used by more than one entity
  - ie. Same name used by printer and a file
- An address is also a name
  - Of an access point of an entity
- An entity may be referred by more than one access point or address
  - ie. Access a document by either FTP or HTTP
- An entity may change its address and/or name over the course of time
  - ie. A file server is moved or renamed

## What is an identifier

- Identifier is a name that has the following three properties
  - An identifier refers to at most, only one entity
  - Each entity is referred to by at most one identifier
  - An identifier always refers to the same entity
    - Never reused
- Example
  - Network card
  - FTP port
  - HTTP port
- Addresses and identifiers are two important names
  - Often expressed in form of bit string

## Why dynamic naming service DNS

- The internet, as of 1996

![1996 internet](https://snag.gy/lPk6id.jpg)

# Name space / naming graphs

- Names in a distributed system are organised as a name space
- Can be illustrated as
  - Labelled and directed graph
  - Types of nodes
    - Leaf node
    - Directory node
      - Can be a root node
      - Contains directory tables

![general naming graph with single root node](https://snag.gy/eSTf45.jpg)

## Leaf nodes

- Is a named entity
- Has no outgoing edges
- Stores info on entity it represents

![leaf node](https://snag.gy/h16lLH.jpg)

## Directory nodes

- Is a named entity with an identifier
- Has a number of named outgoing edges
- Stores information about outgoing edges

![directory node](https://snag.gy/ASCh3w.jpg)

## Directory tables

- Directory tables exist within a directory node
- Stores information about outgoing edges
- Each outgoing edge is represented as a pair of
  - Node identifier
  - Edge label
  
![directory table](https://snag.gy/iXUBJu.jpg)

## Root nodes

- A directory node
- Only has outgoing edges
- Does not have incoming edges
- Naming graphs usually only have one root node

![root node](https://snag.gy/mdOwhY.jpg)

## Path names

- Path name is a sequence of edge labels and nodes that lead to a referred node in a naming graph
- Absolute path names start at root node
- Relative path name does not start at root node
- Two popular forms to express a path name
  - Relative path name
    - `n: <label_1, label_2, ..., label_k>`
  - Absolute path name
    - `/label_1/label_2/.../label_k`

![path name expression](https://snag.gy/cvRmz9.jpg)

# Name resolution

- Given a path name, it should be able to look up any information stored in the node referred to by that name
- The process of looking up a name is called name resolution

## How is name resolution carried out

- Given a path name, resolution of the name starts from an initial node
- Next node is tracked down by consulting directory table stored in each node

## Name resolution example

`n0: <home, steen, mbox>` or `/home/steen/mbox`

![name resolution example](https://snag.gy/aCjRXW.jpg)

## Aliases

- Another name for the same entity
- Two approaches

### Approach 1

- Allow multiple path names to refer to the same node
  - ie. n5

![approach 1](https://snag.gy/KFow4m.jpg)

### Approach 2

- Create a leaf node in which only its absolute path name is stored
  - Instead of its address or state
  - Like a shortcut
  - ie. n6

![approach 2](https://snag.gy/HW2iJq.jpg)

## Name space distribution

- An example partitioning of the DNS name space
  - Includes internet accessible files
  - Three layers

![dns name space](https://snag.gy/rkmlI7.jpg)

# Reading guide

- DSPP
  - Chapter 3
    - 3.1
    - 3.2
    - 3.3
  - Chapter 5
    - 5.1
    - 5.2
    - 5.3
    - 5.4
