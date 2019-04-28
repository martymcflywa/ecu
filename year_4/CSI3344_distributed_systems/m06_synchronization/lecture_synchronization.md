# Synchronization

## Overview

- Logical clocks
- Distributed transactions

# Introduction

- Synchronization ensures that multiple processes do not simultaneously access a shared resource
- Strongly related to communications between processes
  - How processes in distributed systems cooperate and synchronize
- Cooperation is partly supported by means of naming services
  - Allows processes to share entities or resources in distributed systems
- Distributed systems have no global clock
  - No single global notion of correct time
  - Processes on different machines have their own idea of what time it is
  - A machine uses its own clock to time the events that have occurred on it
- In many cases, it is more important to know that related events at different processes happen in the correct order
  - Rather than absolute time when each event happens

# Clock synchronization

- C compiler and Make program in unix
- Large applications split into multiple C source files
- Make requires re-compile only modified sources
  - Not all
- Easy control in single computer
  - But not in distributed system

![c make](https://snag.gy/PDinsE.jpg)

# Logical clocks

- **Happened before relation** or **casual ordering**
- Invented by Lamport in 1978
- A simple mechanism in order to some events that occur at different processes
  - Rather than to exactly time on them
  - We cannot synchronize clocks perfectly across distributed systems
- Partial ordering

## Casual ordering

- Based on two simple rules
  - `a before b` or `a -> b`
- If `a` and `b` are events in the same process
  - And `a` occurs before `b`
  - Then the order `a -> b` is true
- Whenever a message is sent between processes
  - Then the event of sending the message `a` occurred before the event of receiving message `b`
  - This the order `a -> b` is true

![fig 6.9a](https://snag.gy/oLz4vl.jpg)

- Event of sending a message is always before the event of receiving the message

![fig 6.9b](https://snag.gy/vOflSI.jpg)

![fig 6.10](https://snag.gy/Wzh7Gw.jpg)

## Lamport algorithm: Update counter `C_i` for process `P_i`

1. Before executing an event `P_i` executes
  - `C_i <- C_i + 1`
2. When process `P_i` sends a message `m` to `P_j`
  - It sets `m`s timestamp `ts(m)` equal to `C_i` after having executed the previous step
3. Upon the receipt of a message `m`
  - Process `P_j` adjusts its own local counter as
    - `C_j <- max{C_j, ts(m)}`
  - It then executes the first step and delivers the message to the application

## Happened before / casual ordering expression

1. If `a` and `b` are events in the same process
  - And `a` occurs before `b`
  - Then order `a -> b` is true
2. Whenever a message is sent between processes
  - The event of sending message `a` occurred before event of receiving message `b`
  - Then order `a -> b` is also true
3. If `a -> b` and `b -> c` are true
  - Then order `a -> c` is also true
  - ie. Transitive relation
4. If `a` and `e` occur at different processes
  - And there is no link between them
  - Then events `a` and `e` are considered to be concurrent
  - Written as `a || e `
  - Neither `a -> e` or `e -> a` is true

## Example: Events occurring at three processes

![example 6.2](https://snag.gy/QIjUXM.jpg)

## Logical time and logical clock

- The happened before relationships can be captured numerically by assigning a logical time value `L(e)` to an event `e` on which all processes agree
- Logical time
  - The time value `L(e)` assigned to the event `e`
- Logical clock
  - The mechanism to assign such time value

## Lamport timestamp

- A method to assign logical time value `L(e)` to a particular event `e` that follows the happened before relation
- This method piggybacks timestamps on all events in a distributed system, subject to the following conditions:
  1. If `a` happens before `b` in the same process
    - `L(a) < L(b)`, or `L(b) = L(a) + a positive number`
  2. If `a` and `b` represent sending and receiving a message respectively
    - `L(a) < L(b)`
  3. For all distinctive events `a` and `b` that do not belong to the above cases
    - `L(a) != L(b)`
  4. The logical clock time `L` must always go forward
    - Increasing

![lamport timestamp example](https://snag.gy/5OGcsa.jpg)

### How lamport timestamps order events

![how lamport timestamps order events](https://snag.gy/czUXIq.jpg)

- Example above requires totally-ordered multicast
  - The two updates at the two replicas of the database must be performed in the same order
    - No matter which operation is processed first

## Totally ordered multicast

- Messages delivered in the same order to each receiver
- Sender
  - Each message is timestamped with the local time
  - When multicast, message is also sent to the sender
- Receiver
  - When receiving a message
    - It puts the message into the local queue
    - Ordered according the message's adjusted timestamp
      - Using Lamport algorithm
  - The receiver then multicast acknowledgement to all other processes
- Result
  - All processes have the same copy of the local queue
    - ie. All messages are delivered in the same order everywhere
- Assumptions
  - Messages from the same sender are received in the same order
  - No Messages are lost

### Totally ordered multicast example

![example 6.5a](https://snag.gy/nK2eOZ.jpg)
![example 6.5b](https://snag.gy/VCI9hi.jpg)

## Lamport timestamp weakness

- If `a -> b`
  - Then `L(a) < L(b)`
- If `L(a) < L(b)`
  - It could be either
    - `a -> b`
    - `a || b`

## Vector clock and timestamps

- A vector clock for a system of `N` processes is an array of `N` integers
- Each process keeps its own vector clock `V_i` to timestamp local events
- All processes piggyback vector timestamps on the messages they send to one another
- To determine the order of two events
  - All components of a vector timestamp need to be compared with those of the other

```
a -> b if for all i (1 ≤ i ≤ N, L(Va(i)) ≤ L(Vb(i))) and 
                    Ǝ j (1 ≤ j ≤ N, L(Va(j)) < L(Vb(j)))
```

### Vector timestamp example

![example 6.6](https://snag.gy/rVnjcC.jpg)

![example 6.7a](https://snag.gy/rzfke3.jpg)

![example 6.7b](https://snag.gy/OKDzik.jpg)

# Distributed transactions

1. Protect a shared resource against simultaneous access by several concurrent processes
2. Protect the integrity of shared data
  - All or nothing

## All or nothing

- ie. Transfer money between two accounts online
- A bank customer transfers money from savings to cheque accounts
- Transaction consists of three operations
  - Decrease savings accounts
  - Increase cheque accounts
  - Record transaction in log
- System must guarantee that all three operations were performed to maintain accounts in proper balance
- When something prevents one of the operations in the transaction from executing
  - All other operations from transaction must be undone

## Transaction classification

- Flat transaction
  - Properties of ACID
- Nested transaction
- Distributed transaction

## Flat transaction (ACID)

- Atomic
  - To the outside world, the transaction happens indivisibly
  - All or nothing
- Consistent
  - The transaction does not violate system invariants
  - Data integrity
- Isolated
  - Or serializable
  - Concurrent transactions do not interfere with each other
  - Transaction ordering
- Durable
  - Once a transaction commits, the changes are permanent
  - Non-reversible

### Flat transaction example

![example 6.9a](https://snag.gy/7v9b2M.jpg)

![example 6.9b](https://snag.gy/sESPJx.jpg)

### Flat transaction disadvantage

- Do not allow partial results to be committed

## Nested transactions

- Constructed from a number of sub transactions
- The higher level transaction is called a parent transaction of the next level
- All sub transactions are called child transactions

![nested transactions](https://snag.gy/cs1Xiv.jpg)

### Nested transactions advantages

- Sub transactions at one level may run concurrently with other sub transactions at the same level in the hierarchy
- Sub transactions can commit or abort independently
  - A parent can decide on different actions according to whether a sub transaction has aborted or not

### Nested transactions operation rules

- If top level transaction commits, then all sub transactions that have provisionally committed can commit too
  - Condition
    - Each sub transaction works on a separate database

#### Parent transaction

1. May commit or abort only after its child transactions have completed
  - Fully or partially
2. When a parent transaction aborts, all sub transactions abort

#### Sub transaction

1. When completed, it makes an independent decision to either commit provisionally or abort finally
2. When aborted, the parent transaction can decide whether or not to abort

## Distributed transactions example

![distributed transactions example](https://snag.gy/AL7oWR.jpg)

# Reading

- DSPP
  - 6.1.1
  - 6.2
  - 6.3.1
  - 6.3.2
  - 1.3.1
  - 1.3.2
- DSCD
  - 10.4
  - 10.5
