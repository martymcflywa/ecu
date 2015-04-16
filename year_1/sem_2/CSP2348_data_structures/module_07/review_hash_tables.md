# Review questions 07: Hash tables

## 1

What is a hash table?

### Answer:

A hash table is an array of buckets, together with a hash function which translate keys to bucket indices.

## 2

What is the difference between CBHT and OBHT?

### Answer:

#### CBHT

CBHT have buckets which are completely separate from one another. Every entry occupies its home bucket. When hash collisions occur, a bucket will be occupied by several entries, whose keys are different but are translated by the hash function to the same bucket index.

#### OBHT

OBHT buckets can only be occupied by at most, one entry. When a collision occurs, the hash table is probed for a free bucket, and placed there when found. This probing can occur linearly (step = 1), or with another separate hash function (double hashing).

## 3

True or false: Clustering is associated with CBHTs.

### Answer:

False

## 4

Suppose the following CBHT represents student exam results. More than 50% students would fail this unit based on this list. The coordinator decides to use a non-linear function to scale up the scores so that the 100 stays the same whereas the 25 and higher should pass 50. Please devise a suitable and uniformed hash function to realize this non-linear scale-up, and use it to redistribute the list.

### TODO:

Will write Java implementation.
