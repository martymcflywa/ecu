# Workshop

## Q1

>In a hierarchical location service with a depth of k, how many location records need to be updated at most when a mobile entity changes its location?

Worst case 2k + 1. Insert operation requires k + 1 records changed. Delete operation requires k + 1 records changed. Total is 2k + 1.

## Q2

>In this problem you are to compare reading a file using a single- threaded file server and a multi-threaded server. It takes 15 ms to get a request for work, dispatch it, and do the rest of the necessary processing, assuming that the data needed are in a cache in main memory. If a disk operation is needed, as in the case one-third of the time, an additional 75 ms is required, during which time the thread sleeps. How many requests/sec can the server handle if it is single threaded? If it is multi-threaded? (Note: 1 sec = 1000 ms)

>A: In the single-threaded case, the cache hits take 15 ms and cache misses take 90 ms. The weighted average is 2/3 × 15 + 1/3 × 90 = 40 ms. Thus the mean request takes 40 ms and the server can do 25 (=1000 ÷ 40) per second.

>For a multi-threaded server, all the waiting for the disk is overlapped, so every request takes 15 ms, and the server can handle 66 2/3 (=1000 ÷ 15) requests per second.

## Q3

>Give some examples of true identifiers.

- MAC address
- Software licence key
- Credit card number
- Vehicle number plate
- Tax file number
- Passport number

## Q4

>Is an identifier allowed to contain information on the entity it refers to?

It can, but it can't change. For example, using someone's mobile number as an identifier would be bad practice as it could change (they might lose it), or worse yet, the phone number is assigned to another sim card and ends up with someone else.

# Review

## Q1

>What is the difference between a process and a thread?

A process is a program in execution, a program being executed by OS virtual processor. The OS takes great care so that processes do not affect each other maliciously or affect the correctness of their behaviours. Processes run in independent memory space.

A thread executes its own piece of code, but only maintains the minimum info required to allow a CPU to be shared by several threads. Threads run in shared memory space.

## Q2

>What do the client and server processes generally implement, respectively?

Clients implement the user interface. Hides the fact that it has to communicate to the server to process user requests.

Server generally implements the business logic, and processing of user input. It usually waits for a request from the client, processes the request, and returns the result to the client, then waits for the next request.

## Q3

>How to classify servers?

- Iterative
- Concurrent
- Stateless
- Stateful

## Q4

>Describe relationships among entity, name and address.

- Entity may be referred by more than one name
- Name may be used by more than one entity
- An address is also a name
- An entity may be referred by more than one address
- An entity may change its address or name over time

## Q5

>What are absolute and relative path names?

- Absolute path names start from the root node
- Relative path names start from the current node

## Q6

>How many types of node are used in a naming graph?

- Root
- Directory
- Leaf

## Q7

>How to express a naming graph using two different ways?

- Relative path name
  - `n: <label_1, label_2, ..., label_k>`
- Absolute path name
  - `/label_1/label_2/.../label_k`

## Q8

>Two approaches to implement an alias

1. Allow multiple absolute path names to refer to same node in graph
2. Represent an entity by a leaf node