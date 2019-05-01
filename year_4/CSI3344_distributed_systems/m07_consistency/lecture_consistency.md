# Consistency

## Overview

- Data replication
  - Purpose and problems
- Data centric consistency models
- Client centric consistency models
  - Advanced reading

## Objectives

- Outline purpose of data replication
- Be aware of origin of data inconsistency
- Describe principles of different consistency models

# Consistency models summary

## Without sync operations

![without sync operations](https://snag.gy/SOJ6qm.jpg)

## With sync operations (grouping)

![with sync operations](https://snag.gy/xBEp5w.jpg)

# Introduction

## Data replication

- Aims at improving distributed system
  - Scalability
  - Performance
  
## Data inconsistency

- It is a problem introduced by data replication

## Consistency models

- Controls temporary inconsistencies to keep replicas consistent

# Data replication

## Purposes

- Data is replicated to
  - Increase reliability and performance of a system
  - Scale the system in number of servers/users and geographical areas

## Problems

- Copies of replicated data may be inconsistent when one copy is modified
- The modification has to be carried out on all copies to ensure consistency
- When and how to carry out the modification determines the cost of replication

## Data store

- A distributed collection of storage accessible by clients
- A broader term representing any one of the following traditional entities
  - Shared data
  - Shared memory
  - Shared database
  - Shared file system
- Data store may be distributed across multiple machines

## Data centric consistency models

![fig 7.1](https://snag.gy/ULPvoX.jpg)

### Process on data

- A process acts on data in data store by means of two operations
  - Read
  - Write
- Assumption
  - Each process usually accesses a local copy of a data item in the nearest data store
  - A write operation on a local copy is then propagated from the local data store to the entire data store

### Data operations

#### Read

- Returns a copy of the data item/s
- Data remains the same after operation
- Theoretically, a process that performs a read operation on a data item expects the operation to return a value that indicates the information of the last write operation on the data item


#### Write

- Changes the data after operation
- Cannot guarantee without synchronization

### Notations

- `R_i(x)v`
  - READ operation by process `p_i`
  - From data item `x`
  - With a previous write operation result `v`
- `W_i(x)v`
  - WRITE operation by process `p_i`
  - To data item `x`
  - With a (operation finishing) value (or indicator) `v`
  - If no confusion occurs, use `W(x)v` for `W_i(x)v`

# Consistency models

- An agreement or contract between processes and the data store
- Restricts processes to follow certain rules that make the data store work correctly
- Restrictions on returning a write operation value `v` to a read operation on a data item determine different consistency models
- Models with minor restrictions are easy to use/implement
- Models with major restrictions are difficult to use/implement

## Classification of data centric consistency models

### Without sync operations (for individual operations)

1. Strict consistency
  - Absolute time ordering
  - Impossible if distributed
2. Sequential consistency
  - Not ordered in time
3. Casual consistency
  - In casual order
4. FIFO consistency
  - First in first out

### With sync operations (grouping operations)

1. Weak consistency
  - Sync done first
2. Release consistency
  - Lock-release a region
3. Entry consistency
  - Entered into a region first

## Strict consistency

### Condition

- Any read on a data item `x` returns a value corresponding to the result of the most recent write on `x`
- Rely on absolute global time
- Practically impossible for distributed systems

### Consistent example

![strictly consistent store](https://snag.gy/eTMbZB.jpg)

### Inconsistent example

![strictly inconsistent store](https://snag.gy/TjltfC.jpg)

## Sequential consistency

- Condition
  - The result of any execution is the same as if the read/write operations by all processes on that data store were executed in the same sequential order

### Consistent example

![sequentially consistent](https://snag.gy/S54IbD.jpg)

### Inconsistent example

![sequentially inconsistent](https://snag.gy/9e3Zkz.jpg)

### Sequential example

- Three independent processes
- Not all possible reading sequences are valid
- Assignment is the write operation
- Print is the read operation
- `x`, `y` and `z` init to `0`

![fig 7.6](https://snag.gy/A6RJIv.jpg)

#### Valid execution sequences

- Print
  - Concat output in execution order
- Signature
  - Concat output in order of P1, P2, P3
- How many valid execution sequences and signature sequences?
- Signature `000000` and `001001` are invalid
  - Why?
  - Because there should be at least 3 writes

![valid execution sequences](https://snag.gy/TZw36A.jpg)

## Causal consistency

### Condition

- Writes that are potentially causally related must be seen by all processes in the same order
- Concurrent writes may be seen in different orders on different machines

### Consistent example

![causally consistent](https://snag.gy/BH6Rhk.jpg)

### Inconsistent example

![causally inconsistent](https://snag.gy/nD4GmE.jpg)

## FIFO consistency

### Condition

- Writes done by a single process are seen by all other processes in the order in which they were issued
- Writes from different processes may be seen in a different order by different processes
- All writes generated by different processes are concurrent
- Single FWIFRO

### Consistent example

![fifo consistent](https://snag.gy/L54nSc.jpg)

### Inconsistent example

![fifo inconsistent](https://snag.gy/YhCx1g.jpg)

## Grouping operations

- An acquire access of a synchronization variable is not allowed to perform until all updates to guarded shared data have been performed with respect to that process
- Before an exclusive mode access to a synchronization variable by a process is allowed to perform with respect to that process
  - No other process may hold synchronization variable
  - Not even in non-exclusive mode
- After exclusive mode access to synchronization variable has been performed
  - Any other processes' next non-exclusive mode access to that synchronization variable may not be performed until it has performed with respect to that variable's owner

## Weak consistency

### Condition

- Shared data can be counted on to be consistent after a synchronization is done
- Synchronized sequential consistency

### Consistent example

![weak consistent](https://snag.gy/Kh4L50.jpg)

### Inconsistent example

![weak inconsistent](https://snag.gy/vDxpPU.jpg)

## Release consistency

### Condition

- Shared data are made consistent when a critical region is exited
- Released sequential consistency

### Consistent example

![release consistent](https://snag.gy/PEoz3Z.jpg)

## Entry consistency

### Condition

- Shared data pertaining to a critical region are made consistent when a critical region is entered
- Entered sequential consistency

### Consistent example

![entry consistent](https://snag.gy/3sFGtM.jpg)

# Reading

- DSPP
  - 7.1 Introduction
  - 7.2 Data centric consistency model
  - 7.3 Client centric consistency model