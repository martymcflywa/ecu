# Linked-list data structures

## Introduction

### Array vs. linked-list

![array vs. linked-list](http://snag.gy/67f1L.jpg)

### Why linked-list?

- Dynamic data structure
	- Natural choice when you cannot control the total number of objects
	- Or don't know when and where you may need more objects to the next
	- Allocate and free memory in O(1) time
- Low insertion and deletion costs
	- Suits cases with frequent insert/delete operations and searching is relatively infrequent
		- Insert/delete in O(1) time
		- ie. Garbage collections

### Linked-list properties

- A linked list consists of a **header** **and** zero or more **link**-connected **nodes**.

![linked list header and nodes](http://snag.gy/h2WX5.jpg)

- A singly-linked list (SLL) **header** has one reference
	- Which may be null or a link
- A doubly-linked list (DLL) **header** has two references
	- Which may be both null or both links
- Each node contains a single **element** (object or value)
- Each SLL/DLL node contains a **successor** reference
	- Which may be null or a link
- Furthermore, each DLL node contains a **predecessor** reference
	- Which may be null or a link

**Two SLL examples:**

![sll header and nodes](http://snag.gy/CqzHX.jpg)

**One DLL example:**

![dll header and nodes](http://snag.gy/xw9uk.jpg)

- The **length** of a linked list is the number of nodes
	- An **empty** linked list has 0 nodes
- In a linked list, we can manipulate
	- The individual elements
		- Accessed by link
	- The **links**, thus changing the linked list's very structure!
		- This is impossible in an array

## Singly-linked list (SLL)

- The singly-linked list consists of a sequence of nodes, connected by links in **one direction** only
	- Each SLL node contains a single element
		- Plus link to node's successor
		- Or null link if node has no successor
	- An SLL header contains a link to the SLL's first node
		- Or a null link of the SLL is empty

![sll node link demo](http://snag.gy/5BLYI.jpg)

### SLL Java implementation

#### SLL nodes

- Java class implementing SLL nodes:

``` java
class SLLNode {
	private Object element;
	private SLLNode successor;
	SLLNode(Object elem, SLLNode succ) {
		this.element = elem;
		this.successor = succ;
	}
}
```

![java node demo](http://snag.gy/Ae5ZP.jpg)

#### SLL headers

- Java class implementing SLL headers:

``` java
class SLL {
	private SLLNode first;
	SLL() {
		// construct an empty SLL
		this.first = null;
	}
	// ... SLL methods to follow
}
```

#### SLL traversal

- Instance method (in class `SLL`) to traverse an SLL

``` java
void PrintFirstToLast() {
	// print all elements in this SLL, first-to-last order
	for(SLLNode curr = this.first; curr != null; curr = curr.successor) {
		System.out.println(curr.element);
	}
}
```

![anim sll traversal](http://i.imgur.com/WvErkch.gif)

#### SLL manipulation

##### Delete first node

- Instance method (in class `SLL`) to delete an SLLs first node

``` java
void deleteFirst() {
	// delete this SLLs first node, assuming length > 0
	this.first = this.first.successor;
}
```

![anim delete first](http://i.imgur.com/b9PB9cG.gif)

##### Delete second node

- Instance method (in class `SLL`) to delete an SLLs second node

``` java
public void deleteSecond() {
	// delete this SLLs second node, assuming length > 1
	SLLNode second = this.first.successor;
	this.first.successor = second.successor;
}
```
![anim sll delete second](http://i.imgur.com/iq5z3Jw.gif)

##### Swap first and second nodes

- Instance method (in class `SLL`) to swap an SLLs first and second nodes

``` java
public void swapFirstTwo() {
	// swap this SLLs first and second nodes, assuming length > 1
	SLLNode second = this.first.successor;
	this.first.successor = second.successor;
	second.successory = this.first;
	this.first = second;
}
```

![anim sll swap first second](http://i.imgur.com/zQQakd0.gif)

## Doubly-linked list (DLL)

- A doubly-linked list consists of a sequence of nodes, connected by links **in both directions**
- Each DLL node contains a single element, plus links to the node's successor and predecessor
	- Or null links
- The DLL **header** contains links to the DLLs first and last nodes
	- Or null links if the DLL is empty

![dll demo](http://snag.gy/Nhhh2.jpg)

### DLL Java implementation

#### DLL nodes

- Java class implementing DLL nodes

``` java
public class DLLNode {
	protected Object element;
	protected DLLNode pred, succ;
	public DLLNode(Object elem, DLLNode pred, DLLNode succ) {
		this.element = elem;
		this.pred = pred;
		this.succ = succ;
	}
}
```

![dll node demo](http://snag.gy/H4R7b.jpg)

#### DLL headers

- Java class implementing DLL headers

``` java
public class DLL {
	private DLLNode first, last;
	public DLL() {
		// construct empty DLL
		this.first = null;
		this.last = null;
	}
	// ... DLL methods to follow
}
```

#### DLL traversal

- Instance method (in class `DLL`) to traverse a DLL, from last node to first

``` java
public void printLastToFirst() {
	// print all elements in this DLL, in last-to-first order
	for(DLLNode curr = this.last; curr != null; curre = curr.pred) {
		System.out.println(curr.element);
	}
}
```

![anim dll traversal](http://i.imgur.com/H9qNVdc.gif)

#### DLL manipulation

##### Delete first node

- Instance method (in class `DLL`) to delete a DLLs first node

``` java
public void deleteFirst() {
	// delete this DLLs first node, assuming length > 0
	DLLNode second = this.first.succ;
	second.pred = null;
	this.first = second;
}
```

![anim dll delete first node](http://i.imgur.com/HDaHE9p.gif)

##### Delete last node

- Instance method (in class `DLL`) to delete a DLLs last node

``` java
public void deleteLast() {
	// delete this DLLs last node, assuming length > 0
	DLLNode penult = this.last.pred;
	penult.succ = null;
	this.last = penult;
}
```

![anim dll delete last node](http://i.imgur.com/35SbhLV.gif)

### DLL is forward/backward SLL

- View a DLL as a **backward** SLL superimposed on a **forward** SLL

![dll = forward/backward sll](http://snag.gy/Ed8zJ.jpg)

# Algorithms

## Insertion

- **Problem:** Insert a new element at a given point in a linked list
- Four cases to consider
	1. Insertion in an empty linked list
	2. Insertion before the first node of a non-empty linked list
	3. Insertion after the last node of a non-empty linked list
		- This case is actually a special case of 4, below
	4. Insertion between nodes of a non-empty linked list
		- General case
- The insertion algorithm needs links to the new node's successor and predecessor

### SLL insertion

#### SLL insertion algorithm

>To insert elem at a given point in the SLL headed by first:

>1. Make ins a link to the newly-created node with element elem and successor null
2. If the insertion point is before the first node:
	1. Set node ins's successor to first
	2. Set first to ins
3. If the insertion point is after the node pred:
	1. Set node ins's successor to node pred's successor
	2. Set node pred's successor to ins
4. Terminate

##### SLL insertion before first node

![anim algorithm insertion before first node](http://i.imgur.com/fJm5gsv.gif)

##### SLL insertion after intermediate node

![anim algorithm insertion after intermediate node](http://i.imgur.com/1GSUFRO.gif)

#### SLL insertion implementation in Java

``` java
public void insert(Object elem, SSLnode pred) {
	// insert elem at a given point in this SSL, either after the
	// node pred, or before the first node if pred is null
	SSLNode ins = new SSLNode(elem, null);
	if(pred == null) {
		ins.succ = this.first;
		this.first = ins;
	} else {
		ins.succ = pred.succ;
		pred.succ = ins;
	}
}
```

### DLL insertion

#### DLL insertion algorithm

>To insert elem at a given point in the DLL headed by (first, last):

>1. Make ins a link to a newly-created node with element elem, predecessor null, and successor null
2. Insert ins at the insertion point of the forward SSL headed by first
	- **Note:** Similar to SLL insertion
3. Let succ be ins's successor (or null if ins has no successor)
4. Insert ins after node succ in the backwards SLL headed by last
	- **Note:** Not yet implemented so far
5. Terminate

##### Auxiliary forward SLL insertion algorithm

>To insert node ins at a given point in the forward SLL headed by first:

>1. If the insertion point is before the first node:
	1. Set node ins's successor to first
	2. Set first to ins
2. If the insertion point ins after the node pred:
	1. Set node ins's successor to node pred's successor
	2. Set node pred's successor to ins
		- **Note:** Similar to SLL insertion
3. Terminate

##### Auxiliary backward SLL insertion algorithm

>To insert node ins after node succ in the backward SLL headed by last:

>1. If succ is null:
	1. Set node ins's predecessor to first
	2. Set last to ins
2. If succ is not null:
	1. Set node ins's predecessor to succ
	2. Seet node succ's predecessor to ins
3. Terminate

##### DLL insertion before first node

![anim dll insert before first node](http://i.imgur.com/iTumrq4.gif)

##### DLL insertion after last node

![anim dll insert after last node](http://i.imgur.com/uZDZGDU.gif)

##### DLL insertion between nodes

![anim dll insert between nodes](http://i.imgur.com/n8AI7AL.gif)

## Deletion

- **Problem:** Delete a given node from a linked list
- Four cases to consider
	1. Deletion of a singleton node
	2. Deletion of the first (but not last) node
	3. Deletion of the last (but not first) node
	4. Deletion of an intermediate node
- The deletion algorithm needs links to the deleted node's successor and predecessor

### SLL deletion

#### SLL deletion algorithm

>To delete node del from the SLL headed by first:

>1. Let succ be node del's successor
2. If del = first:
	1. Set first to succ
3. Otherwise:
	1. Let pred be node del's predecessor
	2. Set node pred's successor to succ
4. Terminate

- But there is no link from node del to its predecessor, so Step 3.1 can access del's predecessor only by following links from first!

##### SLL deleting the first node

![anim sll delete first](http://i.imgur.com/OElG7vl.gif)

##### SLL delete intermediate or last node

![anim sll delete intermediate or last](http://i.imgur.com/cHkxgn3.gif)

#### Analysis

- Let n be the SLL's length
- Step 3.1 must visit all nodes from the first node to the deleted node's predecessor
- There are between 0 and n-1 such nodes
- Average no. of nodes visited = (n - 1) / 2
- Time complexity is O(n)

#### SLL deletion implementation in Java

``` java
public void delete(SLLNode del) {
	// delete node del from this SLL
	SLLNode succ = del.succ;
	if(del == this.first) {
		this.first = succ;
	} else {
		SLLNode pred = this.first;
		while(pred.succ != del) {
			pred = pred.succ;
		}
		pred.succ = succ;
	}
}
```

### DLL deletion

#### DLL deletion algorithm

>To delete node del from the DLL headed by (first, last):

>1. Let pred and succ be node del's predecessor and successor
2. Delete node del, whose predecessor is pred, from the forward SLL headed by first
3. Delete node del, whose successor is succ, from the backward SLL headed by last
4. Terminate

##### DLL deleting the first (but not last) node

![anim dll delete first but not last](http://i.imgur.com/wsOX5Zn.gif)

##### DLL deleting an intermediate node

![anim dll delete intermediate](http://i.imgur.com/gcAwzJW.gif)

## Comparison of insertion and deletion algorithms

![sll vs. dll insert/delete](http://snag.gy/StGlq.jpg)

## Searching

- **Problem:** Search for a given target value in a linked list

### Unsorted linear search algorithm

>To find which (if any) node of the SLL headed by first contains an element equal to target:

>1. For each node curr in the SLL headed by first, repeat:
	1. If target is equal to node curr's element, terminate with answer curr
2. Terminate with answer non

- DLL linear search is similar, except that we can search from last to first if preferred

### Analysis

- Let n be the linked-list's length
- If the search is **successful:**
	- Average number of comparisons = (n + 1) / 2
- If the search is **unsuccessful:**
	- Number of comparisons = n
- In either case, time complexity is O(n)

### Java implementation

``` java
SLLNode search(Object target) {
	// find which, if any, node of this SLL contains an element equal to target
	// return a link to the matching node or null
	for(SLLNode curr = this.first; curr != null; curr = curr.succ) {
		if(target.equals(curr.element)) {
			return curr;
		}
	}
	return null;
}
```

## Merging

### SLL merging

- Merging two sorted SLLs into a new sorted SLL using an algorithm similar to array algorithm to merge two sorted arrays

![sll merge demo](http://snag.gy/dZdwf.jpg)

## Guide

- Reading
	- Chapter 4: Java Collections
