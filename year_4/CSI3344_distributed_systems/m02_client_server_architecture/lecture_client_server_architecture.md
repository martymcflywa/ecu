# Client-server architecture

## Overview

- Architectural styles
- General client-server model
- Client-server interaction
- Client-server organisations
  - Major points
  - Reading guide

## Objectives

- Be familiar with general client-server architectures
- Describe interactions between clients and servers
- Give examples of client-server interactions in distributed systems
- Be familiar with features and functionalities of client-server organisations

# Architectural styles

## Software architecture

- How various software components are organised and how they interact

## System architecture

- The final instantiation of a software architecture
  - Of many choices

## Styles of distributed system architectures

- Client-server
- Layered
- Object-based
- Data-centred
- Event-based
- Shared data-space

### Layered

- Usually used for client-server system
- Control generally flows from layer to layer
- Requests go down the hierarchy
- Responses flow upward

![layered](https://snag.gy/eGoUdz.jpg)

### Object-based

- Each object corresponds to a component
- Components connected through a remote procedure call

![object based](https://snag.gy/LZBkvx.jpg)

### Data-centred

- Processes communicate through common data repository
- Rely on shared distributed file system
- Virtually all communication takes place through files
- Example
  - Web based distributed system
  - Processes communicate through use of shared web-based data services

### Event-based

- Publish/subscribe system
- Processes publish events
- Middleware ensures subscribers will receive them

![event based](https://snag.gy/moN8Cd.jpg)

### Shared data-space

- Combination of event-based and data-centred
- Used in distributed
  - File systems
  - Web based systems
- Processes communicate through use of shared web-based data services

![shared data-space](https://snag.gy/q543Yb.jpg)

# General client-server model

- Nothing agreed but a loose structure
- Clients require services from servers
- Servers provide services to clients who require them

![general client-server model](https://snag.gy/BlqeOw.jpg)

## Environment

- Clients and servers are networked for passing messages

![environment](https://snag.gy/WuoEe4.jpg)

## Client

- A process that requests a service from server
  - Sends request
  - Waits for server's reply
- Generally single user PCs or workstations
  - Highly user friendly interface to end user
- Client and server may have different platforms or OS
  - Share the same communication protocols
  - Support same applications

## Server

- A process implementing a specific service
  - Examples
    - File system
    - Database
- May enable many clients to share access to same database
  - Enable use of high performance system to manage database
- Communication between clients and servers is implemented by means of communications protocols
  - TCP/IP

## Client-server boundary

- No clear distinction between client and server

![boundary](https://snag.gy/qNI8bF.jpg)

## Service provided by multiple servers

- Services may be implemented as several server processes in separate host computers
- Example
  - Cluster based web servers and apps
  - Google
  - Parallel databases

![multiple servers](https://snag.gy/n207Hk.jpg)

## Proxy servers

- Replication transparency and caches
- Web proxy server
- Cache recently used data

![proxy servers](https://snag.gy/HOB39M.jpg)

# Application layering in client-server model

![web search](https://snag.gy/PcyGT2.jpg)

## User interface

- Contains all that is necessary to directly interface the user
- Implement in clients

## Processing

- A part interacting with users
- A part operating on database or file systems
- A middle part containing the core functionality of application

## Data

- Contains actual data and programs that maintain the data
- On which the applications operate

# Client-server interactions

## Request-reply

![request-reply](https://snag.gy/DMCdLT.jpg)

## Email

![email](https://snag.gy/6547gE.jpg)

## www

![www](https://snag.gy/JW2zuE.jpg)

## Instant messaging

![instant messaging](https://snag.gy/rCJ9h0.jpg)

## Database

- System functionality
- Server is database
- Interaction between client and server in form of transactions
- Client makes database requests
- Client receives database response
- Server responsible for maintaining database

![database](https://snag.gy/eQuvMc.jpg)

# Client-server organisations

## Vertical distribution

- Logically different components on different machines
- Classified into three categories
  - Two-tiered
    - Client -> Server
  - Three-tiered
    - Client -> Server -> Client
  - Multi-tiered
    - Cascade model
    - Client -> Server -> Client -> Server -> Client x2

## Two tiered

- Client server directly communicate with each other

![two tiered](https://snag.gy/3XY0bc.jpg)

- Summary

![summary](https://snag.gy/EATU80.jpg)

## Three tiered

- Each layer on separate machine
- Application software distributed among three types of machines
  - User client
  - Middle tier server
    - Gateway
    - Convert protocols
    - Merge/integrate results from different data sources
  - Backend server

![three tiered](https://snag.gy/gxTu0Q.jpg)

- Interaction

![interaction](https://snag.gy/ng80rt.jpg)

## Multi tiered

- More than three sets of computers are used

![multi tiered](https://snag.gy/5zCmP7.jpg)

## Horizontal distribution

- A client or server may be split up into logically equivalent parts
- Each operates on its own share of the complete data set
- Balances the load
- Aka modern architecture

![horizontal distribution](https://snag.gy/7pxEhG.jpg)

## Other architectures

- Peer to peer
  - Computers of same standard
    - Neither server or client
  - Structured P2P
  - Unstructured P2P
  - Hybrid P2P
- Super peers
- Edge server systems
- Collaborative distributed systems

# Major points

- Important styles of distributed system architectures
- Application layering
- Client server interaction procedure
- Classes of two tiered approach
- Features and interaction of three tiered architecture

# Reading

- Distributed systems
  - 2.1
  - 2.2
  - 3.3
  - 3.4
