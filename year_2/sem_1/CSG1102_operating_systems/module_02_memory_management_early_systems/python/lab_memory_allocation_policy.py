__author__ = 'marty'

import collections

# create memory map
# first we create a data structure to represent a memory partition
memoryPartition = collections.namedtuple("memoryPartition", ["id", "size", "active", "job"])

# create jobs
# this could be done the same way as in last week,
# but instead of cpu requirements, we have memory requirements
job = collections.namedtuple("job", ["id", "memoryReq", "state"])

# job state enum
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

# define scheduler()
def scheduler(jobQueue, memorySpace):

    # for each job in queue
    for i in range(len(jobQueue)):
        # for each space in memorySpace and memorySpace.active = false
        for j in range(len(memorySpace)):
            # if memorySpace.active = false
            if memorySpace[j].active == False:
                # if job.memoryReq < space.size
                if jobQueue[i].memoryReq < memorySpace[j].size:

                    currentJob = jobQueue[j].id

                    # job.state = active
                    jobQueue[i] = jobQueue[i]._replace(state = jobState['Running'])
                    # space.state = in_use
                    memorySpace[j] = memorySpace[j]._replace(active = True)
                    # space.job = job.id
                    memorySpace[j] = memorySpace[j]._replace(job = currentJob)
            # maybe there was nowhere to put it?
            # if job.state = inactive
            if jobQueue[i].state == ['Inactive']:
                # job.state = no_space
                jobQueue[i].state = jobState['No Space']

    # print memory table
    printMemTable(memorySpace)
    # ...
    # print out job states
    printJobStates(jobQueue)


def printMemTable(memorySpace):

    for i in range(len(memorySpace)):
        print(memorySpace[i])


def printJobStates(jobQueue):

    for i in range(len(jobQueue)):
        print(jobQueue[i])

if __name__ == '__main__':
    main()