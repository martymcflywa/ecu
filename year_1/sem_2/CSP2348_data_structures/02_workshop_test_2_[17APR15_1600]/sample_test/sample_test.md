# CSP2348 Data Structures

## Workshop Test 2: 17APR15 1600-1800

#### Martin Ponce: Student 10371381

### 1

Consider the development of software using either arrays or linked-lists. What factors will determine an implementation using arrays vs. linked-lists?

#### Answer

- Array
	- Static structure
		- Fixed length
		- Cannot be changed once declared
	- Access
		- Uses an index
		- Contagious allocated memory
		- Suitable to random access
	- Operations
		- Search operation can be efficient for sorted array
		- Delete/insert algorithms are inefficient
- Linked list
	- Dynamic data structure
		- Size of a linked list can vary
		- Can be changed
	- Access
		- Uses links
		- Unable to quickly access elements
			- Must traverse
	- Operations
		- Efficient in data insertion/deletion
			- Suitable for storing a data set that is frequently inserted/deleted and infrequent value based searching
- Therefore
	- If data set is dynamic, and insert/delete operations occur frequently, use linked list
	- Else array data structure is more suitable

### 2

Consider the following figure.

What is the purpose of the SLL "Before" and "After" manipulation shown in the following diagrams? If we traverse the "After" SLL, what is the outcome of the visitations?

![q2](http://snag.gy/cLKVm.jpg)

### 3

What is the minimum possible depth of a binary tree with 357 nodes?

#### Answer

d = floor(log<sub>2</sub>357)  
log<sub>2</sub>256 = 8, log<sub>2</sub>512 = 9  
floor(log<sub>2</sub>357) = 8

### 4

Insert the following cities into an empty BST:

>Hobart, Sydney, Perth, Canberra, Adelaide, Brisbane, Melbourne, Darwin.

After all the insertions, show the results of pre-order, in-order and post-order visitations of the BST.

#### Answer:

![q4](http://snag.gy/i0j2b.jpg)

- Pre-order (VLR)
	- Hobart
	- Canberra
	- Adelaide
	- Brisbane
	- Darwin
	- Sydney
	- Perth
	- Melbourne
- In-order (LVR)
	- Adelaide
	- Brisbane
	- Canberra
	- Darwin
	- Hobart
	- Melbourne
	- Perth
	- Sydney
- Post-order (LRV)
	- Brisbane
	- Adelaide
	- Darwin
	- Canberra
	- Melbourne
	- Perth
	- Sydney
	- Hobart

### 5

The family names of the most recent Prime Ministers of Australia are used as the keys of their data entries (see below). Use the hash functions given below to construct a CBHT and an OBHT to represent these entries respectively.

>Whitlam, Fraser, Hawke, Keating, Howard, Rudd, Gillard  
hash(key) = key's initial letter - 'A'  
table-size m = 26

#### Answer

``` java
private final int TABLESIZE = 26;

private int hash(char c) {
	return getIntForChar(c) % TABLESIZE;
}

private int getIntForChar(char c) {
	int n = 0;
	// ... method to convert char to int
	return n;
}
```

```
Whitlam: hash(w) = 23 % 26 = 23
Fraser: hash(f) = 6 % 26 = 6
Hawke: hash(h) = 8 % 26 = 8
Keating: hash(k) = 11 % 26 = 11
Howard: hash(h) = 8 % 26 = 8
Rudd: hash(r) = 18 % 26 = 18
Gillard: hash(g) = 7 % 26 = 7
```

##### CBHT

```
HASH:	ID:
00
01
..		...
06		Fraser
07		Gillard
08		Howard => Hawk
10
11		Keating
..		...
18		Rudd
..
23		Whitlam
```

##### OBHT

- Assuming step() = 1

```
HASH:	ID:
00
01
..		...
06		Fraser
07		Gillard
08		Hawk
09		Howard
10
11		Keating
..
18		Rudd
..
23		Whitlam
```
