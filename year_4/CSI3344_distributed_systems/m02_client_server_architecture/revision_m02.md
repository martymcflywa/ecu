# Workshop

## Q1

>If a client and a server are placed far apart, we may see network latency dominating overall performance. How can we tackle this problem?

We can hide latency with asynchronous communication, reducing the size or number of messages between client and server, or by deploying replica server/s closer to the client's location.

Asynchronous communication allows the client to continue with other work while waiting for the server to respond.

Reducing the size or number of messages between the client and server can be achieved by offloading computation normally performed by the server to the client where possible.

Deploying replica servers closer to the client's physical location will decrease the distance between client and server, reducing latency.

## Q2

>What is a three-tiered client-server architecture?

A three tiered client server architecture is where an application is implemented into three layers. The first layer at the top is responsible for user interaction, ie. the view. The second layer is responsible for processing, where business rules are implemented. The third layer at the bottom is responsible for handling data, where it may persist data to some store, like a database or filesystem.

## Q3

>What is the difference between a vertical distribution and a horizontal distribution?

Vertical distribution is a distributed system designed with layered or tiered architecture. It is a centralised approach, with clear roles between clients and servers.

Horizontal distribution is decentralised, where all processes play similar roles. There is no distinction between clients and servers.

## Q4

>Consider a chain of processes P1, P2, ..., Pn implementing a multi-tiered client-server architecture. Process Pi is client of process Pi+1, and Pi will return a reply to Pi-1 only after receiving a reply from Pi+1 . What are the main problems with this organization when taking a look at the request- reply performance at process P1?

If the latency between each request or reply is denoted by c, then P1 will have to wait 2(n - 1) * c, because the requests will have to synchronously be passed down all the layers, then the reply will be waited on as it travels back up to P1.

>A: Performance can be expected to be bad for large n. The problem is that each communication between two successive layers is, in principle, between two different machines. Consequently, the performance between P1 and P2 may also be determined by n - 2 request-reply interactions between the other layers. Another problem is that if one machine in the chain performs badly or is even temporarily unreachable, then this will immediately degrade the performance at the highest level.

# Review

## Q1

>True or false. The boundary between client and server can be clearly defined.

False. No clear distinction as servers can also be clients of other services.

## Q2

>True or false. A client refers to a computer.

False. A client can also be an application, or process running on a computer.

## Q3

>Communication between clients and servers is implemented by means of

Communication is implemented by protocols. For example, over TCP.

## Q4

>What are the three layers in application layering?

1. User interface
2. Processing
3. Data

## Q5

>The client-server interaction is known as

Request-reply.

## Q6

>How the vertical distribution is achieved?

By placing logically different components on different machines.

## Q7

>What are the three categories of vertical distribution?

- Two tiered
  - Client
  - Server
- Three tiered
  - User interface
  - Processing
  - Data
- Multi tiered
  - Client
  - Server, Client
  - Server, Client
  - etc.

## Q8

>Horizontal distribution is called

Peer-to-peer, decentralised.