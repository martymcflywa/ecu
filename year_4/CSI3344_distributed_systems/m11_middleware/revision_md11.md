# Workshop

## Q1

>What is the difference between remote objects and distributed objects?

- Remote object
  - Hosted by a single server
  - Methods can be invoked by remote clients
- Distributed object
  - State may be physically distributed across different servers

## Q2

>Why is it useful to define the interfaces of an object in an Interface Definition Language?

- Precise interface definitions
- Generate stubs
- Client side proxy can be automatically constructed at runtime from an IDL

## Q3

>Some implementations of distributed-object middleware systems are entirely based on dynamic method invocations. Even static invocations are compiled to dynamic ones. What is the benefit of this approach?

Realizing that an implementation of dynamic invocations can handle all invocations, static ones become just a special case. The advantage is that only a single mechanism needs to be implemented. A possible disadvantage is that performance is not always as optimal as it could be had we analyzed the static invocation.

## Q4

>What is ORB in CORBA? What is the functionality of ORB?

- Object request broker
- Communication
  - Locates objects on network
  - Communicates request to object
  - Waits for results
  - Returns results to client
- Location transparency
  - Same request mechanism used by client and CORBA object regardless of where object is located
- Programming language independent
  - Client and server can be written in different languages
  - ORB translates between languages
- Language bindings
  - Defined for popular languages
  - Available for different
    - OS
    - Dev environments