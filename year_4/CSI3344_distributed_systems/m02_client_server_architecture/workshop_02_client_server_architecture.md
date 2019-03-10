# Workshop 02: Client server architecture

Martin Ponce 10371381

## Question 1:

We can tackle latency issues by using any of the following techniques: Use asynchronous communication, so that the user interface is not blocked while waiting for server responses. Replicate services to locations geographically closed to user locations. We can also cache data for the client.

## Question 2:

A three tiered client-server architecture is software distributed across three different types of machines:

- Client
- Middle tier server
  - Application server
- Back end server
  - Data server

For example, a web app which has its middle tier server hosted on Azure, responsible for handling business logic, and back-end servers hosted on AWS responsible for persisting data.

## Question 3:

- Vertical distribution
  - Multi tiered
  - Logically different components hosted on different machines
- Horizontal distribution
  - Modern distribution
  - Client or server split up into logically equivalent parts
  - But each part operates on own share of the complete data set
  - Balances load

## Question 4:

- Problems of request-reply
  - Need to consider latency between each request and response
  - Must communicate with predefined protocol
  - Exceptions, errors, outage of any of the processes will cause system outage if no service continuity strategies or error handling in place