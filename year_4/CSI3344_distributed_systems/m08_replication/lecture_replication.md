# Replication

## Outline

- Replica distribution
- Update propagation
- Consistency protocols

## Objectives

- Be aware of replica classification
- Be familiar with approaches in propagating updates in distributed and replicated data stores
- Be aware of the features of consistency protocols

# Introduction

- Reason for replication
  - Increase reliability
  - Increase performance
    - Scaling in numbers
    - Scaling in geographical area
  - Balance
    - Gain in performance
    - Cost of increased bandwidth for maintaining replication and consistency
- To keep replicas consistent
  - Need to propagate updates in away that temporary inconsistencies are not noticed
- Leads to introduction of replica distribution and update propagation
- Consistency protocols
  - Describe implementations of consistency models

# Replica distribution

- A major issue for replication in distributed data stores is to decide when/where/who copies of the data store are to be placed
- Replicas in a data store can be classified into three types
  - Permanent
  - Server initiated
  - Client initiated
- Organised into three concentric rings in a data store

![replica classification](https://snag.gy/wc25y8.jpg)

## Permanent replicas

- Initial set of replicas that constitute a distributed data store
- Placed in a few core servers only

### Permanent replicas distribution

1. On a single LAN
   - A limited number of servers holding the permanent replicas forward a copy to another server that does not have the permanent replicas but it requested for the providing the save services
   - ie. A website, blackboard at ECU
2. The permanent replicas are copied to a number of servers which are distributed in a WAN
   - ie. Distributed database, a mirror website

## Server initiated replicas

- Keep track of access counts per file
  - Aggregated by considering server closest to requesting clients
- Number accesses exceed threshold R => replicate file
- Number access between D and R => migrate file
- Number of access drops below threshold D => drop file

![server initiated replicas](https://snag.gy/uP3Aeq.jpg)

## Client initiated replicas aka cache

- A cache is a local storage facility that is used by a client to temporarily store a copy of the data it has just requested
- Client caches are used only to improve access time to data
- A client cache is normally placed on the same machine as its client
  - Or on a machine shared by clients on the same LAN
    - ie. Proxy cache
- Data are generally kept in a cache for a limited time to prevent extremely stale data from being used
  - Or simply removed to make room for other data

# Update propagation

- Update operations on a distributed and replicated data store are generally initiated by a client and subsequently forwarded to one of the copies
- From there the update should be propagated to other copies
  - While at the same time ensuring consistency
- When propagating an update we must consider
  - What can be propagated
  - By whom should a propagation be initiated
  - How to propagate an update

## What can be propagated

- No single approach is best
- But depends highly on available bandwidth and read-to-write ratio at replicas

### Propagate only a notification of an update

- Often used for caches
- Notify changes of the copies
- Also called invalidation protocol
- When an update has taken place in a server
- A notification of that update is delivered to other servers
- This informs them that their copies or parts of copies by a specified notification are invalid
- Invalidation protocol
- Advantage
  - Use little network bandwidth
- Disadvantage
  - No actual update taking place on replicas
- Useful when read-to-write ratio is low

### Propagate updated data from one copy to others

- Distributed databases
- Transfer the updated data in a server to other server
  - Also log the changes and transfer the logs to other servers
- Pack multiple modifications into a single message and transfer the package once to other servers
- Advantage
  - Actual update takes place on replicas
- Disadvantage
  - Use more network bandwidth
- Useful when read-to-write ratio is high

### Propagate update operations to others

- So local server executes the operations
- Also called active replication
- When an update has taken place in a server
- The operation that performs the update is transferred to other servers for doing update on their own copies in individual machines
- Advantage
  - Uses minimal network bandwidth
  - Update takes place on all replicas
- Disadvantage
  - Individual machines need more processing power
- Always useful

## By whom should a propagation be initiated

### Server based protocol

- Push based approach
- A server pushes its update to other servers and/or client caches
  - Without requests from servers/clients
- Advantage
  - Replicas keep high degree of consistency
- Disadvantage
  - Use more network bandwidth
  - Potential communication waste
- Useful
  - When read-to-write ratio is high
  - When propagate permanent replicas

### Client based protocol

- Pull based approach
- A client or server requests another server to send any new update to the requesting server or client (cache)
  - Pre-fetch technique
- Advantage
  - Potentially save communication costs
- Disadvantage
  - Some degree of inconsistency
- Useful when read-to-write ratio is low

### Client-server lease approach

- A lease is a promise by the server that it will push updates to the client for a specified period of time
- Advantage
  - Save communication costs
- Disadvantage
  - Some degree of inconsistency
  - Requires stateful servers to keep client information
    - Server overhead
- Useful when read-to-write ratio is relatively low in the specific period

## How to propagate an update

### Unicasting

- A server that is part of the data store pushes its update to N (not all) other servers by sending N separate messages to those individual servers
- More suitable to pull based approach
  - Or client based protocols
  - In such cases, only a single client or server requests its copy to be updated
  - May be the most efficient solution

### Multicasting or broadcasting

- Underlying network takes care of sending updates efficiently to multiple receivers
- Can be combined with push based approach for propagating server initiated updates to a number of other servers

# Consistency protocols

- Describes an implementation of a specific consistency model

## Classification of consistency protocols

- Primary based protocols
- Replicated write protocols

## Primary based protocols

- Each data item `x` in the data store has an associated primary server for coordinating write operation on `x` on **only one copy**

### Remote write protocols

#### Basic protocol

- No replica
- Only one copy in a remote single server

![remote write basic protocol](https://snag.gy/GWCDQy.jpg)

#### Backup protocol

- With replicas
  - Increase fault tolerance
- Read is allowed on local copy
- But write should be forwarded to other copies
- Process
   1. Client writes
   2. Client database sends write to primary server
   3. Primary server tells backups to update
   4. All servers ack update
   5. Client ack write complete

![remote write backup protocol](https://snag.gy/stZekJ.jpg)

### Local write protocols

#### Basic protocol

- No replica
- Only one copy that can be migrated between multiple remote servers

![local write basic protocol](https://snag.gy/Nvl58E.jpg)

#### Backup protocol

- With replicas
- Read free
- But write will not start until primary copy of data item is migrated to **local server**
- Client gets ack immediately without having to wait for writes on all replicas
- Assumes that if client writes once, will write again

![local write backup protocol](https://snag.gy/n765oe.jpg)

## Replicated write protocols

- Problem with replicated invocations

![problem with replicated invocations](https://snag.gy/VaDkzJ.jpg)

- Solution to problem with replicated invocations
  - Achieve total ordering of operations
  - Use a coordinator (or sequencer) to replicas of objects

![solution for replicated invocations](https://snag.gy/e6n5CY.jpg)

## Quorum based protocols

- A client must request and obtain permission from multiple servers before reading or writing replicated data item

### Client update process

1. Contact majority `N / 2 + 1` of servers
2. Get them to agree to do the update
3. Then change the file and assign a new version number to the new file
   - Which is the same for all the newly updated files with the `N / 2 + 1` servers

### Client read process

1. Contact majority `N / 2 + 1` of servers
2. Get them to send version numbers associated with the file
3. If version numbers are all same
   - Means the file is most recent version
   - Client reads file
4. If version numbers different
   - Read the file with newest version number

### Gifford's quorum scheme

- To read a file of `N` replicas
  - A client needs to obtain a read quorum
    - An arbitrary collection of any `N_r` servers or more
- To modify a file of `N` replicas
  - A client needs to obtain a write quorum
    - Of at least `N_w` servers
- Legal schemes follow all the constraints below:

```
N_r + N_w   // prevent read-write conflicts
N_w > N / 2 // prevent write-write conflicts
// Guarantees at least one new copy is read/written
```

#### Legal quorum

![legal quorum](https://snag.gy/y1fQ6q.jpg)

#### Illegal quorum

- May have write-write conflicts
- Does not follow `N_w > N / 2` constraint

![write-write conflict](https://snag.gy/rxeq87.jpg)

#### Read one write all ROWA

![rowa](https://snag.gy/QJYih5.jpg)