# Module 6: Concurrent processes

## Semaphores

See https://youtu.be/KZU4ANBoLTY

### Why use semaphores

- Manages threads
- Alternative is locks
	- Only provides mutual exclusion
- Semaphores provide ordering on scheduling
	- Producers and consumers
		- Ordering problem
		- Don't want this to operate using locks
			- `ps | grep "gcc" | wc`
				- Line for line context switching
		- There is fixed sized buffer between producer and consumer
			- Ordering problem
			- Threads need to wait for each other before running
			- If buffer full
				- Producer waits
			- If buffer empty
				- Consumer waits

### What is a semaphore

- Higher level synchronization primitive lock
	- Higher than locks
	- Built using locks
- It is a counter that is manipulated through two operations
	- SIGNAL
		- `P()`
	- WAIT
		- `V()`

### Semaphore operations

#### `P()`

- `wait(semaphore)`
	- Decrement counter
	- If counter = 0
		- Block until semaphore is signaled
- Proberen
	- Dutch
	- To test

#### `V()`

- `signal(semaphore)`
	- Increment counter
		- Wake up one waiter if any exist
- Verhogen
	- Dutch
	- To increment

#### `sem_init(semaphore, counter)`

- Set first counter value

### Semaphore pseudo-code

```
struct semaphore {
	int value;
	queue L; // list of processes
}
wait(S) {
	if(s.value > 0) {
		s.value = s.value - 1;
	} else {
		add this process to s.L;
		block;
	}
}
signal(S) {
	if(s.L != EMPTY) {
		remove a process P from s.L;
		wakeup(P);
	} else {
		s.value = s.value + 1;
	}
}
```

### Semaphore blocking operations

- Each semaphore has an associated queue of processes/threads
- When `wait()` / `P()` is called by a thread
	- If semaphore is available
		- `count > 0`
		- Thread continues
	- If semaphore is unavailable
		- `count == 0`
		- Thread blocks
		- Waits on queue
- `signal()` / `V()` opens the semaphore
	- If thread/s are waiting on a queue
		- One thread is unblocked
		- Put on READY queue
	- If no threads are on the queue
		- The signal is remembered for the next time a `wait()` is called

### Semaphore initialization

- Semaphore initialized to `1`
	- First call to `wait()` goes through
		- Value changes from `1` to `0`
	- Second call to `wait()` blocks
		- Semaphore value stays at 0
		- Thread goes on queue
	- If first thread calls `signal()`
		- Semaphore value stays at `0`
		- Wakes up second thread
	- If second thread calls `signal()`
		- Semaphore value changes from `0` to `1`
		- Next caller to `wait()` won't have to wait
		- Value `1` already stored

### Initialized value of semaphore

- Determines how many threads can hold semaphore at once
	- Example below
		- 2 threads holding semaphore at once
- Determines how many threads can call `wait()` without having to wait
- Example
	- Semaphore initialized to 2
		- Thread 1 calls `wait()`
			- Decrements 2
			- Semaphore = 1
			- Continues processing
		- Thread 2 calls `wait()`
			- Decrements 1
			- Semaphore = 0
			- Continues processing
		- Thread 3 calls `wait()`
			- Semaphore already 0
			- Semaphore = 0
			- Thread has to wait

### Semaphore uses

- Allocating a number of resources
	- Shared buffers
	- Devices

#### Shared buffer example

- Number of shared buffers that different threads can use
- Every time a thread allocates a shared buffer
	- Calls `wait()` to wait until shared buffer available
		- Decrements counter
			- Decrements number of available buffers
	- Calls `signal()` when a thread is finished and releases buffer
		- Increments counter
			- A waiting thread can now use buffer

### Semaphore types

#### Mutex

- Binary semaphore
- Guarantees mutually exclusive access to resource
- Only one thread/process allowed entry at one time
- Counter is initialized to `1`
	- Cannot go above `1`
- Useful for locks

#### Counting semaphore

- See above examples
- Represents a resource with many units available
- Allows threads/processes to enter as long as more units are available
- Counter is initialized to `N`
	- `N` = number of units available
- Useful for conditional synchronization

### Semaphores for producer/consumer

- Bounded buffer
	- Finite size N space
- Producer inserts an entry
- Consumer removes an entry
- Processes are concurrent
	- Must use synchronization mechanism
		- Controls access to shared variables describing buffer state

#### Single buffer

- Single producer thread
- Single consumer thread
- Single shared buffer between producer and consumer

#### Requirements

- Producer must wait for consumer to empty buffer
	- If filled
- Consumer must wait for producer to fill buffer
- Needs 3 semaphores
	- `mutex`
		- Protects access to shared states
			- ie. The buffer
		- Initialized to `1`
	- `fullBuffer`
		- Indicates buffer is full
		- Counting semaphore
		- Initialized to `0`
	- `emptyBuffer`
		- Indicates buffer is empty
		- Counting semaphore
		- Initialized to `number of buffers`

#### Producer pseudo-code

```
while(1) {
	wait(emptyBuffer);
	wait(mutex);

	fill(buffer);

	signal(mutex);
	signal(fullBuffer);
}
```

#### Consumer pseudo-code

```
while(1) {
	wait(fullBuffer);
	wait(mutex);

	use(buffer);

	signal(mutex);
	signal(emptyBuffer);
}
```
