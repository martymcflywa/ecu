# Review questions: Communications 2

1. RPC was initially implemented using Java
  - False
2. What is parameter marshalling
  - Packing RPC parameters into a message
3. What is the main difference between traditional RPC and asynchronous RPC
  - Traditional RPC
    - Client blocks until server completes operation and server response is received and processed by client
  - Async RPC
    - Client blocks until server sends ack that request is received, does not wait until server completes request
4. What is deferred _a_sync RPC
  - Client sends request
  - Server sends ack
  - Client continues
  - Server sends response after completing operation
  - Response leads to callback at client
5. What is deferred _a_sync RPC
  - Client sends request to server
  - Client blocks while waiting for ack
  - Server sends ack
  - Client unblocks
  - Server continues to process request
  - Server sends response to client
  - Client interrupted with callback
6. Deferred _a_sync RPC is useful when
  - A function (callback) needs to be called on the client to handle an event sent from the server
7. Reasons why RMI is preferred over RPC
  - Programmer can use object-oriented programming to develop distributed system software
    - Objects
    - Classes
    - Inheritance
  - All objects have unique object references
    - Local or remote
  - Objects can be passed as parameters
    - By value or reference
  - Richer parameter passing semantics than RPC
8. What is shared by both RMI and RPC
  - Programming with interfaces
  - Request-reply protocols
    - At least once
    - At most once
  - Transparent
    - Local and remote calls use same syntax
9. Message queuing system belongs to middleware
  - True
10. MQS provide extensive support for persistent async communication by offering permanent storage capacity for messages
  - False
  - Intermediate term storage capacity not permanent
11. What is the difference between persistent and transient communication
  - Transient communication
    - Message stored by system as long as sending and receiving application are executing
  - Persistent communication
    - Message is stored by middleware as long as it takes to deliver message to receiver
12. What is the difference between async and sync communication
  - Asynchronous communication
    - Sender does not block
    - Continues immediately after message is sent
    - Message temporarily stored by middleware
  - Synchronous communication
    - Sender blocks until request is known to be accepted
    - May be blocked until
      - Middleware notifies that it will take over transmission of request
      - Request has been delivered to recipient
      - Request is fully processed
13. How to classify MQS
  - c) Transient asynchronous communication
  - d) Receipt based transient synchronous communication
  - e) Delivery based transient synchronous communication
  - f) Response based transient synchronous communication

![transient async vs. receipt based transient](https://snag.gy/dVi0ZY.jpg)

![delivery based vs. response based](https://snag.gy/xXWvGg.jpg)