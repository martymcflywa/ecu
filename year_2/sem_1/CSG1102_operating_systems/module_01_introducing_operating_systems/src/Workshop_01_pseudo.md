# Schedulers algorithm

```
// create job type
job type = [id, cpuReq, jobState]

// create jobs
job1 = 1,14,Inactive
job2 = 2,7,Inactive
job3 = 3,19,Inactive

// create our run queue
create runQueue

// add jobs to run queue
add job1 to runQueue
add job2 to runQueue
add job3 to runQueue

// Start Scheduler
while job remain:

	shortestJob = find shortest remaining job
	shortestJob.jobState = active

	// run job while it still needs time
	while shortestJob.cpuReq > 0:
		print time
		print runQueue
		shortestJob.cpuReq = shortestJob.cpuReq - 1

	// remove job from run queue
	runQueue.remove(shortestJob)

print "programs done"
```
