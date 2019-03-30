# Workshop 04: Communications 2

Martin Ponce 10371381

## Question 1:

Having a client make an asynchronous RPC call the a server but wait until the server returns the result using another asynchronous RPC is exactly the same as having the client execute a normal RPC call. The purpose of asynchronous communication is to allow the caller to make non-blocking calls. Having the client wait for an asynchronous call defeats the purpose.

## Question 2:

A bounded buffer size may be suitable when the message size is fixed or known, and the maximum number of messages the buffer is expected to hold is known. In comparison, an unbounded buffer size would be suited to scenarios where the message size is unknown, and the maximum number of messages the buffer is expected to hold is unknown.

## Question 3:

Transient synchronous communication over sockets has inherent scalability problems due to the nature of one-to-one communication. In other words, every message sent from the client to the server requires its own socket to be created. This solution would not scale well when there are more clients than sockets available to the server.

The solution is to use advanced transient messaging, and take advantage of the ability of sockets to be bound to multiple addresses, providing one-to-many communication by using a communication pattern such as request-reply, publish-subscribe or pipeline.

The request-reply pattern is similar to the RPC implementation, although sockets are reserved specifically for sending replies, avoiding the need for calling the listen and accept operation.

The publish-subscribe pattern involves clients subscribing to messages published by servers. Only messages that have subscribers will be sent by a server. If a server has a message with no subscribers, this will result in a no operation.

The pipeline pattern involves processes pushing its results, assuming that other processes want to pull in the results. The pushing process does not care which process pulls in the results, the first one will do. Similarly, the inverse is true, where the pulling process does not care which process is pushing the result, the first one will do.