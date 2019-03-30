# Communication 2

## Overview

- Remote procedure call RPC
- Remote method invocation RMI
- Communication systems
- Major points
- Reading guide

## Objectives

- Be familiar with principles of RPC
- Describe procedure of making an RPC
- Be familiar with various RPC models and their characteristics
- Be familiar with the general structure of RMI
- Describe the procedure of making an RMI
- Be aware of classification of message queuing systems

# Remote procedure call RPC

## Conventional procedure call in C

![rpc in c](https://snag.gy/l7dsIG.jpg)

- a) Parameter passing in a local procedure call
  - The stack before the call to read
- b) The stack while the called procedure is active

## What is RPC

- When a process on client machine A calls a procedure on server machine B
  - The calling process on A is suspended
  - The execution of the called procedure takes place on B
- Info can be transported from the caller to the callee in the parameters
  - Can come back in the procedure result
- Programmers cannot see message passing at all
  - Transparency
- RPC is supported by middleware communication services
- RPC was initially implemented using C

## RPC principle

![rpc between client and server](https://snag.gy/qQouyJ.jpg)

## Terms

- Stub
  - Small chunk of C code that is compiled and linked into the client and server programs
- Client stub
  - Converts parameters into a message
    - String of bits
  - Sends message over the network
- Server stub
  - Takes the message
  - Converts it back to parameters
  - Calls the local server side procedure
- Parameter marshalling
  - Packing parameters into a message

## General structure

![general structure](https://snag.gy/ds3HqA.jpg)

## Synchronous RPC steps

1. Client procedure calls client stub in normal way
2. Client stub builds a message and calls the local OS
3. Client OS sends the message to the remote OS
4. Remote OS gives message to server stub
5. Server stub unpacks parameters and calls the server
6. Server does the work and returns the result to the server stub
7. Server OS sends the message back to the client OS
8. Client OS gives message to client stub
9. Client stub unpacks the result and returns to the client

## Asynchronous RPC steps

![async rpc](https://snag.gy/4x2AH1.jpg)

1. Client sends request to server
2. Server sends back acknowledgement immediately after receiving request and starts the process
3. Client starts doing new work without further blocking after receiving the server's reply

- Async RPC is useful when there is no result to return from the server
  - Example
    - Transferring money from one account to another
    - Adding new entries to db
- When does server send result to client?
  - Never by the looks of things but it still should!
  - Java and C++ has `futures`
  - C# has `async/await`

## Deferred synchronous RPC

![deferred synchronous rpc](https://snag.gy/iNdtgh.jpg)

- Combination of two async RPCs
- Useful when result is to be returned from server but client is not prepared to wait for it and starts doing something else
  - ie. Remote computing

## One way RPC

- Client does not wait for an acknowledgement from server
- Starts doing something else immediately after sending the request

# Remote (object) method invocation RMI

## Why use objects

- Objects hide its internals from outside world with a well defined interface
  - Allows objects to be easily replaced/adapted while keeping interface the same
    - Partial modification
- An object encapsulates
  - Its data
    - State
  - Operations on those data
    - Methods
- Methods made available through an interface
- Data or state of object can only be accessed by invoking methods through interface
  - Simple and unique access
- An object may have many interfaces
- Likewise, an interface definition may be implemented by several objects
  - Multiple implementations
- Separation between interfaces and object implementations allows
  - Interfaced to be placed on one machine
  - Object itself resides on another machine
  - Distributed objects

## What is RMI

- Uses same principles as RPC
- Distributed objects implemented using object oriented programming language
  - Rather than just C
- Uses method invocation to perform processes
  - Instead of procedure call
- RMI application development supported by many distributed object based middleware
  - CORBA
  - DCOM

## General structure

![rmi structure](https://snag.gy/ptowns.jpg)

## Terms

- Proxy
  - Client stub
  - Implemented interface of distributed object
  - Marshals method invocations into messages
  - Unmarshals responses to return invocated results to the client
  - Remote object also has same interface
- Skeleton
  - Server stub
  - Unmarshals incoming invocation requests to proper method invocations at the object's interface
  - Also marshals and forwards responses to client proxy

## RMI operation

![rmi operation](https://snag.gy/YEr8x5.jpg)

## One way RMI steps

1. Client invokes method via interface that is the same as remote object
  - Via client proxy
2. Client proxy marshals invocation into messages and passes them to server via network
3. Skeleton unmarshals incoming messages back to invocation then passes it to the object via interface
4. Object processes invocation by calling the right method to work on the input data

# Issues with RPC and RMI

- Always assume server is executing at the time a client request is issued
  - Interprocess will not happen if server is down
- In any cases, after a request is issued, the client will be blocked until the result or an ack from server is received
  - Not efficient

# Solution: message queuing system MQS or message oriented middleware MOM

- MQS allow processes to exchange info
  - Even if the other party is not executing at the time communication is initiated
- Applications communicate by inserting messages in specific queues
- Each application has its own private queue to which other applications can send messages
- A sender is generally given only the guarantees that its message will be added to the queue eventually
  - But no guarantees when or if the message will actually be read
- Once a message has been added to a queue it will remain there until it is removed
  - Irrespective of whether its sender or receiver is executing
- MQS provide extensive support for persistent asynchronous communication
  - By offering intermediate term storage capacity for messages

## MQS structure

![mqs structure](https://snag.gy/4lKP1M.jpg)

## Terms

- Persistent communication
  - A message is stored in the communication server as long as the server delivers it to the receiver
- Transient communication
  - A message is stored in the communication server only as long as the sending and receiving applications are executing
  - In other words
    - The message is discarded by the communication server as soon as it cannot be delivered at the next server or receiver
- Asynchronous communication
  - Sender continues immediately after issuing its message for transmission
- Synchronous communication
  - Sender is blocked until its message is stored in the receiving host or actually delivered to the receiver
  - Generally client/server computing is based on a model of transient synchronous communication
    - Client and servers have to be active at the time of communication
    - Client issues requests and blocks itself until it receives reply
    - Server essentially waits only for incoming requests and subsequently processes them

## Classification of MQS

![persistent vs. transient](https://snag.gy/3pr7dB.jpg)

- Places for synchronization
  - At request submission
  - At request delivery
  - After request is processed

![transient async vs. receipt based transient](https://snag.gy/dVi0ZY.jpg)

- c) Transient asynchronous communication
- d) Receipt based transient synchronous communication

![delivery based vs. response based](https://snag.gy/xXWvGg.jpg)

- e) Delivery based transient synchronous communication
- f) Response based transient synchronous communication

## MQS models

![mqs models](https://snag.gy/oyxgMq.jpg)

- a) Both sender and receiver execute during entire transmission of message
- b) Only sender is executing while receiver is passive
  - ie. Message delivery impossible
- c) Receiver can read messages but sender was not necessarily executing
- d) System is storing (possibly transmitting) messages even while sender and receiver are passive

# Reading guide

- DSPP
  - Chapter 4
  - Sections
    - 4.2
    - 4.3