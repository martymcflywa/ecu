# Workshop

## Q1

![q1](https://snag.gy/P3vKfM.jpg)

>Add a new message to the figure that is concurrent with message m1, that is, it happens neither before m1 nor after m1.

- P3 sends m5 at t0
- P2 receives m5 at t8

>Add a new message to the figure that is after m1 but before m4

- P1 sends m6 at t24
- P2 receives m6 at t40

## Q2

>The following diagram (Figure 2) shows that two updates on the same bank account at two replicated databases in different places take place at the same physical time, leaving it in an inconsistent state. Suppose that the account balance is $5000 before the updates take place. One update is to deposit $2000 to the account. The other update is to increase the interest by 1%.

![q2](https://snag.gy/7I4n2f.jpg)

- P1 sends deposit m1
  - 1, 0
- P2 receives deposit m1
  - 1, 1
- P2 sends interest m2
  - 1, 2
- P1 receives interest m2
  - 2, 2

# Review

## Q1

>Why a single global clock cannot be used to note the correct time for the events occurred in distributed systems?

Because clocks across distributed systems are not consistent. There are no guarantees that a clock on one computer is running at the exact same speed as another, and that they are perfectly synchronised, due to the way crystal oscillators run at different rates on each computer.

## Q2

>Which two simple points on which the causal ordering is based?

1. If a and b occurred on the same process, and a occurs before b
   - Then a -> b is true
2. If a was sent before receiving b
   - Then a -> is true

## Q3

>What is the full expression of happened-before relation?

- If a and b occurred on the same process, and a occurs before b
  - Then a -> b is true
- If a was sent before receiving b on the same process
  - Then a -> is true
- If a -> b and b -> c is true
  - Then a -> c is true
  - Transitive
- If a and b occur at different processes, and there is no link between them
  - Then a || b
  - Concurrent

## Q4

>How do Lamport timestamps order events in distributed systems?

Each processor has its own logical clock. When process P1 sends a message, it includes a timestamp. When process P2 receives the message, it compares the message timestamp with its own logical clock. If its logical clock has a value less than the timestamp, P2 updates its logical clock to the value of the timestamp + 1. If its logical clock has a value greater than the timestamp, nothing is changed.

## Q5

>How do vector timestamps order events in distributed systems?

Each process Pi maintains its i'th element in a vector clock. When a process sends a message it increments its own element in the vector timestamp, and includes the vector timestamp in the message. When a process receives a message, it increments its own i'th element in the vector, and takes on the max value of each element in the vector between its own vector clock and the incoming timestamp from the message.

Each message carries its own vector timestamp, and can be compared with other messages to determine order. If each element in message m1's vector timestamp is less than m2's timestamp, then m1 happened before m2. If there are elements greater than as well as less than, then m1 and m2 is considered concurrent.

## Q6

>How do vector timestamps order events?

Duplicate of Q5.

## Q7

>How to identify concurrent events using vector timestamps?

When comparing each element of m1 and m2's vector timestamps, if there are elements that are greater than, as well as less than, then m1 and m2 are considered concurrent.

## Q8

>What are three types of distributed transactions?

- Flat transactions
- Nested transactions
- Distributed transactions

## Q9

>What is ACID?

- Atomicity
  - Indivisible
  - All or nothing
- Consistency
  - Transform from one consistent state to another
- Isolation
  - Concurrent transactions do not interfere with each other
  - Transactions are ordered
- Durability
  - Changes are permanent
  - Non reversible

## Q10

>What is the major difference between nested and distributed transactions?

- Distributed transactions work like flat transactions
  - But work on distributed data
  - Must be completed in full, no partial commits
- Nested transactions
  - Parent transactions calling sub transactions
  - Sub transactions can commit independently of each other
  - Supports partial commits
