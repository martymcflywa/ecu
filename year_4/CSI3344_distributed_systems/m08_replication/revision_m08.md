# Workshop

## Q1

>A file is replicated on 9 servers. List all the combinations of read quorum and write quorum that are permitted by the voting algorithm (Gifford’s Quorum Scheme). Explain your answer.

```
N = 9

{(5,5), (5,6), (5,7), (5,8), (5,9)}
{(6,4), (6,5), (6,6), (6,7), (6,8, (6,9)}
{(7,3), (7,4), (7,5), (7,6), (7,7), (7,8), (7,9)}
{(8,2), (8,3), (8,4), (8,5), (8,6), (8,7), (8,8), (8,9)}
{(9,1), (9,2), (9,3), (9,4), (9,5), (9,6), (9,7), (9,8), (9,9)}
```

- Read requirements
  - Quorum of arbitrary number of Nr servers, up to N
- Write requirements
  - Quorum of at least Nw servers, up to N
- Constraints
  - Nr + Nw > N
    - Prevents read conflicts
  - Nw > N /  2
    - Prevents write conflicts

>List the best combination/s of legal read quorum and write quorum, that is, (NR, Nw) that makes NR + NW minimum.

Best combinations are those that sum to minimum number of servers

- 9,1
- 8,2
- 7,3
- 6,4
- 5,5

# Review

## Q1

>How to classify of replicas?

- Without sync operations
  - Strict
  - Sequential
  - Causal
  - FIFO
- With sync operations
  - Weak consistency
  - Release consistency
  - Entry consistency

## Q2

>What can be propagated?

- Only a notification of an update
- Transfer data from one copy to another
- Propagate the update operations to other copies

## Q3

>By whom should propagation be initiated?

- Server based protocols
- Client based protocols
- Client server lease

## Q4

>How to propagate an update?

- Unicast
- Multicast

## Q5

>What is the major difference between primary-based protocols and replicated-write protocols?

- Primary based
  - Each data item has an associated primary server for coordinating write operations only one copy of the data item
- Replicated write
  - Write operations can be carried out at multiple replicas instead of only one copy

## Q6

>What is the basic problem with the replicated write protocol?

- Replicated writes by three replicas could be duplicated to a single client

## Q7

>In what circumstances unicasting may be the most efficient solution?

Unicasting may be most efficient when using client based protocols, ie. pull based.

## Q8

>Explain how to protect Read-Write and Write-Write conflicts using examples of Gifford Quorum.

- Read write conflicts are protected by restriction `Nr + Nw > N`
- Write write conflicts are protected by restriction `Nw > N / 2`