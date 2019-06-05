# Workshop 11: Middleware

Martin Ponce 10371381

## Question 1

What is the difference between remote objects and distributed objects?

### Answer

Remote objects provide a way to call functions from objects as if they were local, even if they are distributed. They are tightly coupled with their hosting languages, ie. Java RMI.

Distributed objects serve as middleware platforms for distributed systems and provide tools to facilitate implementation, management and performance improvements of distributed systems. They are language independent, ie. CORBA and DCOM.

## Question 2

Why is it useful to define the interfaces of an object in an Interface Definition Language?

### Answer

IDL maps specifications to various languages. It makes the interface independent of compilers and improves interoperability between languages. It is also required for languages that are statically typed, as the IDL is used for stub generation and linked to the clients that use the remote objects.

## Question 3

Some implementations of distributed object middleware systems are entirely based on dynamic method invocations. Even static invocations are compiled to dynamic ones. What is the benefit of this approach?

### Answer

Static invocations are the special case when an implementation of dynamic invocations can handle all invocations. The benefit is only a single implementation is required.

## Question 4

What is ORB in CORBA? What is the functionality of ORB?

### Answer

- Forms core of an CORBA system
- Responsible for enabling communication between objects and clients
- Provides an interface for:
  - Operations enabling the system to be started and stopped
  - Operations to convert between remote object references and strings
  - Operations to provide argument lists for requests using dynamic invocation