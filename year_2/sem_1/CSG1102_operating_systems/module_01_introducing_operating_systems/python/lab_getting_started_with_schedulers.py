__author__ = 'marty'

import collections
import time

# Define our job type
# We start with just memory & job state to worry about
Job = collections.namedtuple("Job", ["id", "cpuReq", "jobState"])

# Define acceptable states for a job
JState = {'Inactive': 1, 'Running': 2, 'Complete': 3}

def main():

    # Create our jobs
    j1 = Job(1, 14, JState['Inactive'])
    j2 = Job(2, 7, JState['Inactive'])
    j3 = Job(3, 19, JState['Inactive'])

    # Create run queue
    runQueue = list()

    # Add our jobs to the run queue
    runQueue.append(j1)
    runQueue.append(j2)
    runQueue.append(j3)

    # Call our scheduler
    SJF(runQueue)

    # Program is complete
    print("Program Complete")

def SJF(runQueue):

    # start at CPU cycle 0
    cycle = 0

    while len(runQueue) > 0:
        # Set an initial shortest job length
        shortestTime = runQueue[0].cpuReq

        # Set an initial shortest job
        shortestJob = 0

        # Find shortest job in the run queue
        for job in runQueue:
            if (shortestTime > job.cpuReq) and (job.jobState != JState['Complete']):
                shortestJob = runQueue.index(job)
                shortestTime = job.cpuReq

        # Set shortest job as running
        runQueue[shortestJob] = runQueue[shortestJob]._replace(jobState = JState['Running'])

        # Run active job
        for x in range(cycle, cycle + runQueue[shortestJob].cpuReq):
            # Print current cycle
            print("CPU Cycle #{}".format(x))

            # Show current run queue
            printJobs(runQueue)

            # Remove one cycle from required cycles
            runQueue[shortestJob] = runQueue[shortestJob]._replace(cpuReq = runQueue[shortestJob].cpuReq-1)

            # Increment cycle
            cycle = cycle + 1
            time.sleep(1)

        # Mark job as complete
        runQueue[shortestJob] = runQueue[shortestJob]._replace(jobState = JState['Complete'])
        print("Job {} complete at CPU Cycle #{}".format(runQueue[shortestJob].id,cycle))
        printJobs(runQueue)

        # Remove job from run queue
        runQueue.pop(shortestJob)



def printJobs(runQueue):
    for job in runQueue:
        print("Job #{} CPU Required: {} State: {}".format(job.id, job.cpuReq, list(JState.keys())[list(JState.values()).index(job.jobState)]))
    print()

if __name__ == '__main__':
    main()
