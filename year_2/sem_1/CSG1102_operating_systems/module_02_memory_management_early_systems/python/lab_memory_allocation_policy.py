__author__ = 'marty'

import collections

# create memory map
# first we create a data structure to represent a memory partition
memoryPartition = collections.namedtuple("memoryPartition", ["id", "size", "active", "job"])

# create jobs
# this could be done the same way as in last week,
# but instead of cpu requirements, we have memory requirements
job = collections.namedtuple("job", ["id", "memoryReq", "state"])

# job state dict
jobState = {'Inactive': 1, 'Running': 2, 'Complete': 3, 'No Space': 4}

def main():

    # now we create our memory space
    memorySpace = list()

    # lets create some partitions to go in the space
    m1 = memoryPartition(0, 100, False, 0)
    m2 = memoryPartition(1, 123, False, 0)
    m3 = memoryPartition(2, 5433, False, 0)

    # add the memory partitions to the memory space
    memorySpace.append(m1)
    memorySpace.append(m2)
    memorySpace.append(m3)

    # create job queue
    jobQueue = list()

    # create jobs
    j1 = job(1, 100, jobState['Inactive'])
    j2 = job(2, 123, jobState['Inactive'])
    j3 = job(3, 5433, jobState['Inactive'])

    # add jobs to queue
    jobQueue.append(j1)
    jobQueue.append(j2)
    jobQueue.append(j3)

    # call scheduler
    scheduler(jobQueue, memorySpace)

def scheduler0(jobQueue, memorySpace):

    # for each job in queue
    for i in range(len(jobQueue)):
        # for each space in memorySpace and memorySpace.active = false
        for j in range(len(memorySpace)):
            # if job.memoryReq <= space.size and space.active = false
            if jobQueue[j].memoryReq <= memorySpace[i].size and memorySpace[i].active == False:

                currentJob = jobQueue[j].id

                # job.state = active
                jobQueue[j] = jobQueue[j]._replace(state = jobState['Running'])
                # space.state = in_use
                memorySpace[j] = memorySpace[j]._replace(active = True)
                # space.job = job.id
                memorySpace[j] = memorySpace[j]._replace(job = currentJob)

        # maybe there was nowhere to put it?
        # if job.state = inactive
        if jobQueue[i].state == jobState['Inactive']:
            # job.state = no_space
            jobQueue[i] = jobQueue[i]._replace(state = jobState['No Space'])

    # print memory table
    printMemTable(memorySpace)
    # print out job states
    printJobStates(jobQueue)


def scheduler(jobQueue, memorySpace):
    for job in range(len(jobQueue)):
        for space in range(len(memorySpace)):
            if (memorySpace[space].active == False) and (jobQueue[job].memoryReq < memorySpace[space]):

                currentJob = jobQueue[job].id

                jobQueue[job] = jobQueue[job]._replace(state = jobState['Running'])
                memorySpace[space] = memorySpace[space]._replace(active = True)
                memorySpace[space] = memorySpace[space]._replace(job = currentJob)

        if jobQueue[job].state == jobState['Inactive']:
            jobQueue[job] = jobQueue[job]._replace(state = jobState['No Space'])

    printMemTable(memorySpace)
    printJobStates(jobQueue)


def scheduler1(jobQueue, memorySpace):

    currentJob = 0

    while len(jobQueue) > 0:

        for space in range(len(memorySpace)):
            if(memorySpace[space].active == False) and (jobQueue[currentJob].memoryReq < memorySpace[space]):
                jobQueue[currentJob] = jobQueue[currentJob]._replace(state = jobState['Running'])
                memorySpace[space] = memorySpace[space]._replace(active = True)
                memorySpace[space] = memorySpace[space]._replace(job = currentJob)

        if jobQueue[currentJob].state == jobState['Inactive']:
            jobQueue[currentJob] = jobQueue[currentJob]._replace(state = jobState['No Space'])

        print jobQueue[currentJob].state
        jobQueue.pop(currentJob)
        currentJob = currentJob + 1

    printMemTable(memorySpace)
    printJobStates(jobQueue)

def printMemTable(memorySpace):

    for i in range(len(memorySpace)):
        print(memorySpace[i])


def printJobStates(jobQueue):

    for i in range(len(jobQueue)):
        print(jobQueue[i])

if __name__ == '__main__':
    main()