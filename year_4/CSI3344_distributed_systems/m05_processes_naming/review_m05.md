# Review questions: Processes and naming

1. What is the difference between a process and a thread
  - Both are independent sequences of execution
  - Threads
    - Run in shared memory space
  - Processes
    - Run in separate memory spaces
2. What do the client and server processes generally implement
  - Client
    - User interfaces
    - Hides communication details between client and server
  - Server
    - Specific service on behalf of collection of clients
    - Basic functions
      - Wait for incoming request from client
      - Ensure request is processed properly
      - Wait for next incoming request after finishing last service
3. How to classify servers
  - Iterative
    - Server main thread handles request
    - Responds to client if necessary
  - Concurrent
    - Server passes request to separate worker process/thread
    - Immediately waits for next incoming request
    - Worker process/thread responsible for sending response to client
4. Describe relationships among entity, name and address
  - An entity may be referred by more than one name
    - ie. Web page bookmarks
  - A name may be used by more than one entity
    - ie. Same name used by printer and a file
  - An address is also a name
    - Of an access point of an entity
  - An entity may be referred by more than one access point or address
    - ie. Access a document by either FTP or HTTP
  - An entity may change its address and/or name over the course of time
    - ie. A file server is moved or renamed
5. What are absolute and relative path names
  - Absolute
    - Starts at root node
    - `/label_1/label_2/.../label_k`
  - Relative
    - Does not start at root node
    - Starts at "current" node
    - `n: <label_1, label_2, ..., label_k>`
6. How many types of node are used in a naming graph
  - Leaf node
  - Directory node
    - Root node
7. How to express a naming graph using two different ways
  - Relative path name
    - `n: <label_1, label_2, ..., label_k>`
  - Absolute path name
    - `/label_1/label_2/.../label_k`
8. Two approaches to implement an alias
  - Allow multiple path names to refer to the same node
  - Create a leaf node in which only its absolute path name is stored
    - ie. Symlink, shortcut

![approach 1](https://snag.gy/KFow4m.jpg)

![approach 2](https://snag.gy/HW2iJq.jpg)
