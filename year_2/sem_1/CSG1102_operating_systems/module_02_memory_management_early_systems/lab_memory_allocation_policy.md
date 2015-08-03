# Workshop 02: Memory allocation policy

## Background

During this week’s lecture we talked about memory allocation policies. The following pseudo code shows how we might go about developing a first fit allocation policy.

```
// create memory map
// first  we create a data structure to represent a memory partition
memoryPartition = (id, size, active, job)
// now we create our memory space
memorySpace = []
// lets create some partitions to go in the space
m1 = memoryPartition(0, 100, False, 0)
m2 = memoryPartition(1, 123, False, 0)
m3 = memoryPartition(2, 5433, False, 0)
...
// add the memory paritions to the memory space
memorySpace.append(m1)
memorySpace.append(m2)
memorySpace.append(m3)

// create jobs
// this could be done the same way as in the previous week, but instead
// of cpu requirements, we have memory requirements
job = (id, memoryReq, status)

// create the job queue
...

// create jobs

// add jobs to queue

// here we begin the scheduler, lets try first fit...
for each job in queue
	for each space in memorySpace and memorySpace.active = False
		if job.memoryReq < space.size
			job.state = active
			space.state = in_use
			space.job = job.id
	// maybe there was nowhere to put it?
	if job.state = inactive
		job.state = no_space

// print out the memory table
...

// print out the job states
...
```

## Task

It is your task during this workshop to convert the provided pseudo code to actual programming code and experiment with the first fit allocation scheme. Once you have first-fit working try to adapt the code for best fit and worst fit algorithms.

Remember, you can use the code provided last week as an example, many elements are re-usable.
