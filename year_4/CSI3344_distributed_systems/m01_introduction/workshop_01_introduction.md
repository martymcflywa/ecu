# Workshop 01: Introduction

Martin Ponce 10371381

## Question 1

A distributed system viewed as a single system would come in handy in peer to peer networks, such as bit torrent file sharing. As a user, it can appear that a file is downloaded from a single source, although parts of the file are actually retrieved from multiple seeders in the network. This allows the different parts of the file to be downloaded concurrently from multiple sources, improving download throughput.

## Question 2

The role of middleware is to facilitate transparency, masking heterogeneity to a distributed system by connecting different types of applications. It also provides a convenient programming model to the developers of the distributed system.

## Question 3

Transparency is the concealment of separate components which make up a distributed system and is presented as a single system. There are several categories of transparency:

- Mobility
  - Movement of resources and clients without affecting operation
- Performance
  - Allow reconfiguration of system to improve performance as loads vary
- Scaling
  - Allows system and applications to expand in scale without change to system structure or application algorithms

## Question 4

An open distributed system is a system that offers components that can easily be used by or integrated into other systems, by adhering to standard rules that describe the syntax and semantics of what those components offer. For example, a REST API service should respond with appropriate HTTP response codes. Some advantages of an open distributed system are interoperability, composability and extensibility.

## Question 5

A scalable system is a system that can adapt to load placed upon it by users and/or other systems by expanding the number of resources available to it, without change to system structure or application algorithms. Some techniques that can be used to achieve scalability are:

- Hiding communication latencies
  - With asynchronous communication between components
  - Example
    - .NET `async await`
- Partitioning and distribution
  - Split a component into smaller parts
  - Spread partitioned components across system
  - Example
    - DNS hierarchy system
    - Serverless
      - AWS Lambda
- Replication
  - Components are replicated in the system 
  - Increases availability and performance
  - Can strategically place components in geographic locations based on user location
  - Example
    - CDN
    - Microservices