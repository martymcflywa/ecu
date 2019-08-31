# Workshop

## Q1

>What are the permissible delivery orderings for the combination of FIFO and total-ordered multicasting in the following figure (also see Figure. 8-15 on page 352 in the Textbook)?

![q1](https://snag.gy/oCJMFn.jpg)

1. m1, m2, m3, m4
2. m1, m3, m2, m4
3. m1, m3, m4, m2
4. m3, m4, m1, m2
5. m3, m1, m4, m2
6. m3, m1, m2, m4

## Q2

>The printers of the same brand may produce random errors in some exceptional conditions. If such printers are used to build up a local printer server that should guarantee that at any time there are at least two printers are running in correct status, how many such printers are required to make up this printer server?

Random errors are byzantine. To have k fault tolerance, we require 2k + 1 resources, so we will need 5 printers.

## Q3

![q3a](https://snag.gy/4K7wl9.jpg)

Unordered.

![q3b](https://snag.gy/2tIrXP.jpg)

FIFO and causal.

![q3c](https://snag.gy/uLhxv8.jpg)

Total ordered.

Is also a combination of FIFO and causal order, since potential causality between messages is preserved.

# Review

## Q1

>What is failure masking?

Hide failures from other components in a distributed system, to allow the system to continue operating.

## Q2

>What are the main features of process group?

- It is dynamic
  - Processes can join/leave
- Manageable
  - Group membership can be managed
- Multicast communication

## Q3

>What are the advantages and disadvantages of flat and hierarchical groups, respectively?

- Flat
  - Advantages
    - No single point of failure
    - If one process crashes, group only gets smaller
      - Can continue to operate
  - Disadvantages
    - Decision making is more complex
    - Vote needs to be made before doing anything
- Hierarchical
  - Advantages
    - Less overhead for decision making
    - Easier to implement
  - Disadvantages
    - Single point of failure

## Q4

>What are the four aspects of dependability for distributed systems?

- Availability
- Reliability
- Safety
- Maintainability

## Q5

>Explain whether high availability also means high reliability for a distributed system.

High availability does not equal high reliability. A server may become unavailable due to planned maintenance, however could be highly reliable and be very resistent to faults and errors.

## Q6

>How is redundancy classified?

- Information redundancy
- Time redundancy
- Physical redundancy

## Q7

>How many replicas are needed to achieve a certain degree of fault tolerance?

- Arbitrary errors require 2k + 1 replicas to be k fault tolerant
- Non arbitrary errors require k + 1

## Q8

>Describe the commonly used reliable multicasts.

- Unordered
  - No guarantees in order of messages received
- FIFO
  - Forced to deliver messages from same process in same order
  - Messages can be interleaved if received from other processes
- Causal
  - Order between potentially causal messages are preserved
    - ie. Messages from the same process
  - If m1 causally preceeds m2 from any process, m1 has to be delivered first
- Totally ordered
  - Regardless of classification, messages must be delivered in same order to all processes