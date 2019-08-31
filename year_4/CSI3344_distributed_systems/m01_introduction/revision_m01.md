# Workshop

## Q1

>An alternative definition for a distributed system is that of a collection of independent computers providing the view of being a single system, that is, it is completely hidden from users that there are even multiple computers. Give an example where this view would come in very handy.

Distribution transparency is used in the implementation of peer-to-peer bittorrent filesharing. To the user, it may appear that the source of the downloaded file is from a single location, however parts of the file is hosted between different seeders from any location in the world.

## Q2

>What is the role of middleware in a distributed system?

To provide a single system view of a distributed system across heterogeneous computers and networks. It facilitates communication between distributed components, as well as different applications. It hides the fact that the distributed system is implemented across different hardware, and operating systems. 

## Q3

>Explain what is meant by (distribution) transparency, and give
examples of different types of transparency.

Distribution transparency is hiding the fact that a system is distributed, across different machines in different locations, implemented with different technologies.

Examples of distribution transparency are:

- Access
  - Hide differences in machine architectures
  - Hide differences in data representation and how an object is accessed
- Location
  - Hide where the object is located
- Relocation
  - Hide that an object may be moved to another location while in use
- Migration
  - Hide that an object may move to another location
- Replication
  - Hide that a resource is replicated
- Concurrency
  - Hide that a resource may be shared by several competitive users
- Failure
  - Hide the failure and recovery of a resource

## Q4

>What is an open distributed system and what benefits does openness provide?

A system that offers services according to standard rules. These rules describe the syntax and semantics of services. This allows components to be easily used and integrated into other systems.

Benefits of open distributed systems:

- Interoperability
  - Two implementations of systems can coexist and work together via common standard
  - ie. A Linux server and a Windows server can talk to each other via some common protocol
- Portability
  - Application can be executed on different systems without modification
  - ie. Java application running on Windows, Linux or MacOS JVM
- Extensibility
  - Easy to add/replace components or even entire systems
- Composability
  - Define services with interface design language IDL

## Q5

>Describe precisely what is meant by a scalable system. What techniques can be used to achieve scalability?

A scalable system is able to expand and grow across the following three dimensions, without unacceptable loss in performance:

- Size
  - Number of resources and/or users
- Geographical
  - Physical location of resources and/or users
- Administration
  - Managed by a number of different and/or independent organisations

The techniques used to achieve scalability are:

- Scaling up
  - Upgrading hardware in existing machines
- Scaling out
  - Deploying more machines
- Hiding communication latencies
  - Async communication
  - Reduce communication
    - Move computation from server to client
- Distribution
  - Split components into smaller parts and spread across distributed system
  - Divide and conquer
  - Deploy multiple machines to do same tasks
    - Concurrency
  - ie. DNS system
- Replication
  - Deploy data store replicas closer to client physical locations
  - ie. Content delivery network CDN

# Review

## Q1

>Heterogeneity applies to

- Networks
- Hardware
- Software
- Programming languages
- Different implementations by programmers

## Q2

>What are the two perspectives of openness?

- Hardware extensibility
- Software extensibility


## Q3

>What are the security components for information resources?

- Confidentiality
  - Authorised communication
- Integrity
  - Safety against tampering of data
- Availability
  - Ensure services are available for use at any given time

## Q4

>Techniques for handling failures include

- Detecting failures
- Masking failures
- Tolerating failures
- Recovery from failures
- Redundancy

## Q5

>What is referred to as network transparency?

## Q6

>What services does middleware provide?

- Communication
- Transactions
- Service composition
- Reliability

## Q7

>True or false? In distributed systems, all applications are distributed over the network.

False. Not everything has to be distributed.

## Q8

>Is it efficient to combine the OS layer and middleware together?

No. Combining OS and middleware would imply that a very common use case for a computer is to host distributed components, which for home use would not be common.

Combining OS and middleware is against the goal of being open. Tying the middleware to a specific OS could mean that any distributed system that depends on a particular middleware, is immediately dependent on a particular OS.