# Workshop 01: Getting started with schedulers

## Background

During the semester we will be experimenting with different schedulers. In order to accomplish this task it will be your job to translate pseudo code examples into actual programming code that simulates various scheduling algorithms. During this first workshop the task will be guided and all code provided. You should step through the task and ensure you are able to complete it.

The first step is to examine the provided pseudocode. The code provided below is for a shortest job first CPU scheduler.

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

## Task

It is your task during this workshop to take the provided code and experiment with it in order to test the functionality of the shortest job first scheduler and ensure you have the environment working correctly.

1. Download the Portable Python installer for your operating system from [portablepython.com](http://portablepython.com/)
2. Install Portable Python, if you are using a lab computer then your desktop is a good location to install to
3. Open `PyScripter-Portable.exe`
4. Open the module1.py” file in this week’s materials
5. Press run to begin the program execution
6. Experiment by adding additional jobs to the run queue
7. Compare the provided code to the pseudocode and think about how you might implement other algorithms
