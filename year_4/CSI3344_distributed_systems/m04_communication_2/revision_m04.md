# Workshop

## Q1

>Assume a client calls an asynchronous RPC to a server, and subsequently waits until the server returns a result using another asynchronous RPC. Is this approach the same as letting the client execute a normal RPC?

If the client is waiting for a response even though an asynchronous call is made, then yes, its the same as making a normal synchronous call to the server.

>A: No, this is not the same. An asynchronous RPC returns an acknowledgement to the caller, meaning that after the first call by the client, an additional message is sent across the network. Likewise, the server is acknowledged that its response has been delivered to the client. Two asynchronous RPCs may be the same, provided reliable communication is guaranteed. However the approach of executing two asynchronous RPCs is different from an execution of a normal RPC.

## Q2

>With persistent communication, a receiver generally has its own local buffer where messages can be stored when the receiver is not executing. To create such a buffer, we may need to specify its size. Give an argument why this is preferable, as well as one against specification of the size.

A fixed buffer size is easier to implement. But if the buffer is full, then messages will be lost. The buffer could be implemented in a way that it grows or shrinks depending on the number of incoming messages, but it is more complex to implement, and would require more processing/memory overhead. On the other hand, if memory/storage is a constraint, then setting a max buffer size may be required to ensure that the queue is not capable of grinding the entire system to a halt, by growing so large that the host runs out of memory space.

## Q3

>Explain why transient synchronous communication has inherent scalability problems, and how these could be solved.

Synchronous communication causes caller to be blocked until reply is received. If client and server are physically located far apart, or if the server operation takes a long time, then the client is left with nothing to do until the response is returned. This could be solved with asynchronous communication, allowing the client to continue with other tasks while the server processes and finally responds to the request.

# Review

## Q1

>True or false: RPC was initially implemented using Java.

False. First implementation was Sun's RPC, 1978.

## Q2

>What is parameter marshalling?

When the client stub converts the method invocation into a message, to be sent over the network to the remote stub.

## Q3

>What is the main deference between a traditional RPC and an asynchronous RPC?

Traditional RPC is a blocking call. The client calls the remote method, and waits until the server responds with the return value. Asynchronous RPC is not a blocking call. The client calls the remote method, the server immediately responds with an acknowledgement, and then the client can continue with other tasks.

## Q4

>Asynchronous RPC is useful when

There is no result to return from the server. Void methods.

## Q5

>What is a deferred asynchronous RPC?

Deferred asynchronous RPC is where a client calls the remote method, the server responds with an acknowledgement, unblocking the client. The client can continue with other tasks, while the server processes the request. The server will then eventually return the result to the client.

## Q6

>Deferred asynchronous RPC is useful when

A result from the server is expected, but the client does not have to wait for the result, and can continue without it.

## Q7

>Give some reasons why RMI is preferred over RPC?

- Can use object oriented programming techniques while developing distributed systems
  - Objects
  - Classes
  - Inheritance
- Parameters and return objects can be passed around by reference, rather than just by value, a limitation in RPC

## Q8

>What is shared by both RMI and RPC?

- Programming with interfaces
- Use request-reply protocols for communication
- Similar transparency
  - Local and remote calls use same syntax
  - Remote interfaces expose distributed nature
    - ie. Supporting remote exceptions

## Q9

>True or false: Message-Queuing Systems belong to middleware.

True.

## Q10

>True or false: Message-Queuing Systems provide extensive support for persistent asynchronous communication, by offering permanent storage capacity for messages.

False. Storage is not always permanent. Intermediate term is a better way to describe it. However, the system I maintain at work persists message queues to a database, so it is possible for a more permanent storage solution if its critical that no existing messages are lost in the event of an outage.

## Q11

>What is the difference between persistent and transient communication?

Persistent communication is where messages are sent between the sender and receiver even if they are both offline, facilitated by a queueing system. Transient communication on the other hand is where communication is only possible when the sender and receiver are both available.

## Q12

>What is the difference between asynchronous communication and synchronous communication?

Synchronous communication is where the sender waits for a response after it sends a message to the receiver. It does not perform any action until the reply is received.

Asynchronous communication allows the sender to continue with other tasks after it sends a message to the receiver. The sender does not wait for a reply.

## Q13

>How to classify the message-queuing systems?

- Persistent asynchronous
- Persistent synchronous
- Transient asynchronous
- Recipient based transient synchronous
- Delivery based transient synchronous
- Response based transient synchronous