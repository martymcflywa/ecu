# Chapter 4: Linked-list data structures

## 1:

Devise an algorithm to access the kth element of an SLL. What is your algorithm's time complexity?

>To access the kth element of an SLL:

>1. Set curr to first
2. Repeat k times:
	1. If curr is null, terminate with answer none
	2. Set curr to node curr's successor
3. Terminate with answer curr

``` java
public static SLL getSLLElement(int index) {

	// To access the kth element of an SLL:

	// 1. Set curr to first
	SLLNode curr = this.first;

	// 2. Repeat k times:
	for(i = 0; i < index; i++) {

		// 2.1 If curr is null, terminate with answer none
		if(curr == null) {
			return null;

		// 2.2 Set curr to node curr's successor
		} else {
			curr = curr.next;
		}
	}

	// 3. Terminate with answer curr
	return curr.element;
}
```

- The algorithm follows between 1 and n links, ie. (n + 1) / 2 on average
- Its time complexity is O(n)

## 2:

Devise an algorithm to access the kth element of a DLL.

>To access the kth element of a DLL headed by (first, last):

>1. Let n be the length of the DLL headed by (first, last)
2. If 2k < n:
	1. Set curr to first
	2. Repeat k times:
		1. If curr is null, terminate with answer none
		2. Set curr to node curr's successor
3. If 2k ≥ n:
	1. Set curr to last
	2. Repeat n-1-k times:
		1. If curr is null, terminate with answer non
		2. Set curr to node curr's predecessor
4. Terminate with answer curr

``` java
public static DLL getDLLElement(int index) {

	// To access the kth element of a DLL headed by (first, last):

	// 1. Let n be the length of the DLL headed by (first, last)
	// getLength() defined in DLL class
	int n = this.getLength();

	// 2. If 2k < n:
	if(index * 2 < n) {

		// 2.1 Set curr to first
		DLLNode curr = this.first;

		// 2.2 Repeat k times
		for(int i = 0; i < index; i++) {

			// 2.2.1 If curr is null, terminate with answer none
			if(curr == null) {
				return null;

			// 2.2.2 Set curr to node curr's successor
			} else {
				curr = curr.next;
			}
		}
	}

	// 3. If 2k ≥ n:
	if(index * 2 => n) {

		// 3.1 Set curr to last
		DLLNode curr = this.last;

		// 3.2 Repeat n-1-k times:
		for(int i = 0; i < n - 1 - index; i++) {

			// 3.2.1 If curr is null, terminate with answer none
			if(curr == null) {
				return null;

			// 3.2.2 Set curr to node curr's predecessor
			} else {
				curr = curr.last;
			}
		}
	}
}
```

- If DLL length is immediately available, Step 1 follows 0 links
	- Either Step 2 or Step 3 follows between 0 and (n - 1) / 2 links
		- ie. (n - 1) / 4 links on average
	- This algorithm's time complexity is O(n)
- If DLL length is not immediately available, Step 1 would have to follow n links
	- So it would be better to mimic SLL algorithm

## 3:

Devise an algorithm to reverse the elements of an SLL. What is your algorithm's time complexity and space complexity?

>To reverse the elements of the SLL headed by first:

>1. Set curr to first and set pred to null
2. While curr is not null, repeat:
	1. Let succ be node curr's successor
	2. Set node curr's successor to pred
	3. Set pred to curr
	4. Set curr to succ
3. Set first to pred
4. Terminate

``` java
public static void reverseSLLElements() {

	// To reverse the elements of the SLL headed by first:

	// 1. Set curr to first and set pred to null
	SLL curr = this.first
	SLL pred = null;

	// 2. While curr is not null, repeat
	while(curr != null) {

		// 2.1 Let succ be node curr's successor
		SLL succ = curr.next;

		// 2.2 Set node curr's successor to pred
		curr.next = pred;

		// 2.3 Set pred to curr
		pred = curr;

		// 2.4 Set curr to succ
		curr = succ;
	}

	// 3. Set first to pred
	this.first = pred;
}
```

- This algorithm follows n links, so its time complexity is O(n)
- Its space complexity is O(1)

## 4:

Devise an algorithm to reverse the elements of a DLL. What is your algorithm's time complexity and space complexity.

>To reverse the elements of the DLL headed by (first, last):

>1.
