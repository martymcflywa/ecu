# Fault tolerance

## Overview

- Basic issues with fault tolerance
- Process group and failure masking
- Reliable group communication

# Introduction

- Failures may occur at any stage
  - During data communication
  - Process execution
  - Concurrency control
  - Data replication
- Fault tolerance
  - Distinguishable characteristic of distributed system
  - Can continue to operate in presence of partial failure

## Redundancy

- Key technique to achieve fault tolerance
- Process group
  - Realise redundancy
- Reliable communication
  - Needed to achieve redundancy
  - Provides support for communications in process group

# Basic issues in fault tolerance

## Terminology

- Fail
  - A system fails if it cannot meet promises
  - ie. Component not living up to specifications
- Error
  - A part of system's state that may lead to a failure
- Fault
  - Cause of an error
- Failure
  - State/action of not functioning
  - Omission of expected/required action
  - Result of error/s
- Fault prevention
  - Prevent occurrence of fault
- Fault tolerance
  - Build component in a way that can meet specifications in presence of fault
  - Mask presence of faults
- Fault removal
  - Reduce presence, number, seriousness of fault
- Fault forecasting
  - Estimate present number, future incidence, and consequences of faults
- Dependability
  - To provide services, a component may require services from other components
- Dependable systems
  - Being fault tolerant

## Four properties of dependability

### Availability

- Readiness for usage
- Where `availability = ((T_total - T_down) / T_total) * 100%`
- `T_total` = total time in a given period of system running
- `T_down` = sum of down time of system in given period

### Reliability

- Continuity of service delivery
- Capability that a system can run continuously without failure

### Safety

- Very low probability of catastrophes
- When a system temporarily fails to operate correctly, no catastrophe happens

### Maintainability

- How easily a failed system can be repaired
- Higher maintainability means higher degree of availability of a system

## Difference between availability and reliability

![availability vs. reliability](https://snag.gy/369IwE.jpg)

## Fault classification

### Transient faults

- Occur once then disappear
- Transient microwave interruption

### Intermittent faults

- Occur, vanish, reappear and so on
- Loose contact on connector

### Permanent faults

- Continue to exist until faulty part is repaired/replaced
- Software bugs
- Damaged hardware
- Power switched off

## Failure modes

- Crash failure least severe
- Arbitrary failure most severe

### Crash failure

- Server halts but was working correctly until it halts

### Omission failure

- Receive omission
- Send omission
- A server fails to respond to incoming requests
- A server fails to receive incoming messages
- A server fails to send messages

### Timing failure

- A server's response lies outside the specified time interval

### Response failure

- Value failure
- State transition failure
- A server's response is incorrect
- The value of the response is wrong
- The server deviates from the correct flow of control

### Arbitrary failure or byzantine failure

- A server may produce arbitrary responses at arbitrary times

## Problems

- Clients cannot distinguish between a crashed system/component and one that is just a bit slow
- Example
  - Consider a server from which a client is expecting/waiting output
  - Is the server exhibiting timing or omission failure
  - Is the channel between client and server faulty
    - Crashed or exhibiting timing or omission failures
  - Anything else?

# Failure masking

- When a failure occurs the system should be able to hide that failure from other processes so that the system can continue to operate
- Redundancy is a way of masking failure
- Examples
  - Backup server
  - Replicated databases
  - Replicated name table in DNS server

## Redundancy example

- At least two routes between any two routers in network

![redundancy example](https://snag.gy/0XhoEn.jpg)

## Redundancy classification

### Information redundancy

- Add extra bits into transferred data so some garbled bits can be restored
- Noise filtering of digital signals

### Time redundancy

- Performing an action again and again when required
- Email resend
- Retry

### Physical redundancy

- Add extra hardware and/or software to make system tolerate failures from both hardware components and application programs

#### Trip modular redundancy (TMR) circuit

![tmr circuit](https://snag.gy/n6Tl1E.jpg)

![tmr analysis](https://snag.gy/9VhNvj.jpg)

- Suppose there are two failures
- Suppose the initial input is T to A1, A2 and A3
- Due to failure, A2 feeds an F (instead of T), to B1 and B2, and B3
- Then the voters V1, V2, and V3 will still vote to T into gate B which gets correct results, T
- Similarly, if both Vote V6 and C3 fails to produce correct input, the final results are still correct.


# Progress group

- Several identical processes can be organised into one group to protect a system against process failures

## Basic function of process group

- When a message is sent to a group, all members of the group receive it
- If one process in a group fails, some other processes can take over for it

## Features of process group

- Dynamic
  - A process can join/leave group
- Manageable
  - Group membership can be managed
- Multicast communication

## Process group structure

![process group structure](https://snag.gy/Cfapjv.jpg)

### Flat groups

- All processes are equal
- All decisions made collectively by all members
- Good
  - No single point of failure
- Bad
  - Decision making involves all members
  - May lead to delay or overhead

![flat groups](https://snag.gy/jdYNAh.jpg)

### Hierarchical groups

- One process is the coordinator
  - Solely makes all decisions in group
  - All others are workers
- Good
  - Quick decision making
  - Efficient
- Bad
  - Single point of failure
    - Coordinator

![hierarchical groups](https://snag.gy/bKWSjV.jpg)

## Managing group membership

### Group server

- Handled by separate server
- Good
  - Efficient
  - Easy to implement
- Bad
  - Single point of failure

### Distributed group membership

- Members distributed in a system
- Communicate with each other by message multicast
- Good
  - No single point of failure
- Bad
  - Slow decision making
  - Hard to distinguish crashed process from a left process

## How to replicate processes in group

### Primary based replication -> Hierarchical groups

- Replication is made using primary backup protocols
- Fixed primary acts as coordinator for all write operations
- When primary crashes, backups elect new primary

![primary based replication](https://snag.gy/kvPWI1.jpg)

### Replicated write protocols -> Flat groups

- Replication is made using active replication protocols
- Replicated processes are distributed in a system
- All processes make decision collectively

![replicated write protocols](https://snag.gy/NEoxV7.jpg)

# Fault tolerance

- How many replicas are needed to achieve a certain degree of fault tolerance
- A system has **k degrees of fault tolerance**
  - If it can survive faults in `k` identical processes/components and still provide service correctly
- For non arbitrary failures, `k + 1` replicas are needed to achieve **k degrees of fault tolerance**

## Non arbitrary failures

- Halting failures
  - Crash/omission/timing failures
- Need `k + 1` members
- No member will produce an incorrect result
- Result of one member is good enough

| process/component | degree of fault tolerance | replicas needed |
| ----------------- | ------------------------- | --------------- |
|                   | k                         | k + 1           |
| server            | 1                         | 2               |
| database          | 2                         | 3               |
| program           | 3                         | 4               |
| printer           | 4                         | 5               |

## Arbitrary (byzantine) failures

- Need `2k + 1` members
- Vote needed to decide majority
- The correct result can be obtained only through majority vote
- Always need double the processes + 1 to get a majority vote
- T = true
- F = false (fault)

| process/component | degree of fault tolerance | replicas needed | comparison |
| ----------------- | ------------------------- | --------------- |------------|
|                   | k                         | 2k + 1          | < (2k + 1) |
| server            | 1                         | 3 (2T:1F)       | 2 (1T:1F)? |
| database          | 2                         | 5 (3T:2F)       | 3 (1T:2F)? |
|                   |                           |                 | 4 (2T:2F)? |
| program           | 3                         | 7 (4T:3F)       | 5 (2T:3F)? |
|                   |                           |                 | 6 (3T:3F)? |
| printer           | 4                         | 9 (5T:4F)       | 7 (3T:4F)? |
|                   |                           |                 | 8 (4T:4F)? |

# Group communication

## Atomic multicast for group communication

- Communication in a dynamic group should ensure that
  - All active members receive the same message at a specific moment
    - All
  - Receive nothing if any membership change occurs during tramsit/receive
    - Nothing
- Two issues
  - Dynamic membership control
    - Group view
  - Atomic multicast
    - All or nothing

## Dynamic membership control

- Group view is a delivery list distributed to each group member (process) in the group
- Control point
  - Each member should have the same group view for a message to be accepted

## Procedure of atomic multicast

1. `P_i` checks group view before sending message
2. `P_i` sends the message to other group members
3. All members acknowledge sender
4. If one member acks improperly (just crashed or left), all members will notice it and the action aborts
   1. Update group view
   2. Repeat steps 1 to 3
5. If acks from all members are normal, all members commit message

## Principle of atomic multicast

![principle atomic multicast](https://snag.gy/o9KsXx.jpg)

## Unordered multicast

- Messages may be received by different processes in different order

![unordered multicast](https://snag.gy/LkR8og.jpg)

## FIFO ordered multicast

- Communication layer is forced to deliver incoming messages from the same process in the same order they have been sent

![fifo ordered multicast](https://snag.gy/hRfG9P.jpg)

## Causal ordered multicast

- Deliver messages so that potential causality between different messages is preserved
- If `m1` causally precedes another message `m2`, regardless of whether they were multicast by the same sender
- The communication layer at each receiver always delivers `m2` after it has received and delivered `m1`

![causal ordered multicast](https://snag.gy/mFZIvp.jpg)

## Total ordered multicast

- Messages are delivered in the same order to all group members
- Can be unordered, FIFO or causally ordered

![total ordered multicast](https://snag.gy/cfdn8y.jpg)