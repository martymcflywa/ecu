# Review questions: Replication

1. How to classify replicas
   - Permanent
   - Server initiated
   - Client initiated
2. What can be propagated
   - Notification of update
   - Updated data
   - Update operations
3. By whom should propagation be initiated
   - Server
   - Client
   - Client-server lease
4. How to propagate an update
   - Unicast
   - Multicast / broadcast
5. What is the major difference between primary-based and replicated-write protocols
   - Primary-based
     - Each data item have a primary copy (or home) on which all writes are performed
   - Replicated-write
     - Writes are performed on multiple replicas simultaneously
   - https://pdfs.semanticscholar.org/fff1/a1b396615f91862e684cf9634298386038dd.pdf
6. What is the basic problem with the replicated write protocol
   - Operations need to be carried out everywhere
7. In what circumstances unicasting may be the most efficient solution
   - Pull based approach
8. Explain how to protect read-write and write-write conflicts using examples of Gifford quorum

```
N_r + N_w   // prevent read-write conflicts
N_w > N / 2 // prevent write-write conflicts
// Guarantees at least one new copy is read/written
```