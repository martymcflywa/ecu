# Queues and lists

# Queues

## Queue concepts

- A queue is a first-in-first-out (FIFO) sequence of elements
	- Elements can be added only at one end
		- ie. At **rear** of the queue
	- Elemenets can only be removed at the other end
		- ie. At **front** of the queue
	- Can only manipulate one element at a time
- The **length** of a queue is the number of elements it containts
	- An **empty** queue has length zero

![queue model](http://snag.gy/CYXO7.jpg)

## Queue applications

- Print server
	- Maintains a queue of printing jobs
- Disk driver
	- Maintains a queue of disk/input output requests
- Scheduler (in operating system)
	- Maintains a queue of processes awaiting a slice of machine time

## Queue requirements

1. It must be possible to make a queue empty
2. It must be possible to test whether a queue is empty
3. It must be possible to obtain the length of a queue
4. It must be possible to
	- Add an element at the rear of a queue
	- Remove the front element from a queue
5. It must be possible to access the front element in a queue without removing it

## Queue contract as `interface`

``` java
/**
 * Each Queue object is a queue whose elements are objects.
 */
public interface Queue {

	/*************
	 * ACCESSORS *
	 *************/

	/**
	 * Return true if queue is empty.
	 *
	 * @return boolean.
	 */
	public boolean isEmpty();

	/**
	 * Return queue's length.
	 *
	 * @return int.
	 */
	public int size();

	/**
	 * Return the element at the front of this queue.
	 * getFirst() == first().
	 *
	 * @return Object.
	 */
	public Object getFirst();

	/****************
	 * TRANSFORMERS *
	 ****************/

	/**
	 * Make queue empty.
	 */
	public void clear();

	/**
	 * Add element as the rear element of this queue.
	 * addLast() == enqueue().
	 *
	 * @param elem Object - The object to add.
	 */
	public void addLast(Object elem);

	/**
	 * Remove and return the front element of this queue.
	 * removeFirst() == dequeue().
	 *
	 * @return Object.
	 */
	public Object removeFirst();
}
```

### Queue `interface` as UML

![Queue interface UML](http://snag.gy/LoZX5.jpg)

## Queue implementation using arrays

- Consider representing a **bounded** queue `(length <= maxlen)` by:
	- A variable `length`
		- Contains current length
	- A variable `front` and `rear`
	- An array `elems` of length `maxlen`
		- Contains queued elements in array `elem[front...rear-1]`

### `ArrayQueue` invariant

![ArrayQueue invariant](http://snag.gy/ncmOZ.jpg)

### `ArrayQueue` animation

`maxlen = 6`

![ArrayQueue animation](http://i.imgur.com/nO6sH6M.gif)

### Avoid shifting elements in array

- Avoid shifting elements along the array
	- If we must shift elements along the array
		- `removeFirst()` or `addLast()` will be O(n)
- We can avoid this by using a **cyclic** array

## Cyclic arrays

- In a **cyclic** array `a` of length `n`, every component has both a successor and a predecessor
- In particular
	- The successor of `a[n-1]` is `a[0]`
	- The predecessor of `a[0]` is `a[n-1]`

![cyclic array model 1](http://snag.gy/Jrvgy.jpg)

![cyclic array model 2](http://snag.gy/vjLFn.jpg)

## Queue implementation using cyclic arrays

- Representing a **bounded** queue `(length <= maxlen)` by:
	- A variable `length`
		- Contains the current length
	- A variable `front` and `rear`
	- A **cyclic** array `elems` of length `maxlen`
		- Contains the queued elements either in
			- `elems[front...rear-1]`
			- Or `elems[front...maxlen-1]` and `elems[o...rear-1]`

### `CycArrayQueue` invariant

![CycArrayQueue invariant](http://snag.gy/KHkVv.jpg)

### `CycArrayQueue` animation

`maxlen = 6`

![CycArrayQueue animation](http://i.imgur.com/NVO3dsl.gif)

### `CycArrayQueue` Java class

``` java
/**
 * Each ArrayQueue object is a bounded queue whose elements are objects.
 *
 * This queue is represented as follows:
 * Its length is held in length.
 * Its elements occupy either elems[front...rear-1] or elems[front...maxlength-1]
 * wrapped to elems[0...rear-1].
 */
public class CycArrayQueue implements Queue {

	private Object[] elems;
	private int front;
	private int rear;
	private int length;

	/**
	 * Constructor.
	 *
	 * @param maxLength int - The length of the array.
	 */
	public CycArrayQueue(int maxLength) {

		elems = new Object[maxLength];

		// empty condition: front = rear, length = 0
		// full condition: front = rear, length != 0
		front = rear = 0;
		length = 0;
	}

	/**
	 * Implement Queue interface.
	 */

	/*************
	 * ACCESSORS *
	 *************/

	/**
	 * Return true if queue is empty.
	 *
	 * @return boolean.
	 */
	public boolean isEmpty() {
		return (length == 0);
	}

	/**
	 * Return queue's length.
	 *
	 * @return int.
	 */
	public int size() {
		return length;
	}

	/**
	 * Return the element at the front of this queue.
	 * getFirst() == first().
	 * Throw NoSuchElementException if queue is empty.
	 *
	 * @return Object.
	 */
	public Object getFirst() {

		if(isEmpty()) {
			throw new NoSuchElementException();
		}

		return elems[front];
	}

	/****************
	 * TRANSFORMERS *
	 ****************/

	/**
	 * Make queue empty.
	 */
	public void clear() {

		for(int i = 0; i < elems.length; i++) {
			elems[i] = null;
		}

		front = rear = 0;
		length = 0;
	}

	/**
	 * Add element as the rear element of this queue.
	 * addLast() == enqueue().
	 *
	 * @param elem Object - The object to add.
	 * @return Object.
	 */
	public void addLast(Object elem) {

		if(length == elems.length) {
			expand();
		}

		elems[rear++] = elem;

		// if rear == elems.lenghth,
		// rear needs to wrap back around to index 0
		if(rear == elems.length) {
			rear 0;
		}

		length++;
	}

	/**
	 * Remove and return the front element of this queue.
	 * removeFirst() == dequeue().
	 * Throw NoSuchElementException if queue is empty.
	 *
	 * @return Object.
	 */
	public Object removeFirst() {

		if(isEmpty()) {
			throw new NoSuchElementException();
		}

		Object frontElem = elems[front];
		elems[front++] = null;

		// if front == elems.length,
		// front needs to wrap back around to index 0
		if(front == elems.length) {
			front = 0;
		}

		length++;
		return frontElem;
	}

	/***********
	 * HELPERS *
	 ***********/

	/**
	 * Make the elems array longer.
	 */
	private void expand() {
		Object[] newElems = new Object[2 * elems.length];

		for(int i = 0; i < depth; i++) {
			newElems[i] = elems[i];
		}
		elems = newElems;
	}
}
```

### Alternative `addLast()`

`addLast()` may also be implemented as:

``` java
public void addLast(Object elem) {

	if(length == elems.length) {
		thrown new NoSuchElementException();
	}

	elems[rear] = elem;
	rear == (rear + 1) % elems.length;
	length++;
}
```

### `CycArrayQueue` analysis

- Most operations have time complexity O(1)
- `clear()` has time complexity O(maxlen)

### `CycArrayQueue` UML

![CycArrayQueue UML](http://snag.gy/zYJXA.jpg)

## Queue implementation using linked lists

- Represent an **unbounded** queue by an SLL
	- The 1st SLL node contains the front element of the queue
	- The SLL header contains links to the first node `front` and last node `rear` of the queue
	- A variable `length` (optional)

### `LinkedQueue` invariant

![LinkedQueue invariant](http://snag.gy/8BD7j.jpg)

### `LinkedQueue` model

![LinkedQueue model](http://snag.gy/53Vjw.jpg)

### `LinkedQueue` Java class

``` java
/**
 * Each LinkedQueue object is a queue whose elements are objects.
 *
 * This queue is represented as follows:
 * Its length is held in length.
 * front and rear are links to the first and
 * last nodes of the SLL containing its elements.
 */
public class LinkedQueue implements Queue {

	private SLLNode front;
	private SLLNode rear;
	private int length;

	/**
	 * Constructor.
	 * Construct a queue, initially empty.
	 */
	public LinkedQueue() {
		front = rear = null;
		length = 0;
	}

	/**
	 * Implement Queue interface.
	 */

	/*************
	 * ACCESSORS *
	 *************/

	/**
	 * Return true if queue is empty.
	 *
	 * @return boolean.
	 */
	public boolean isEmpty() {
		return (length == 0);
	}

	/**
	 * Return queue's length.
	 *
	 * @return int.
	 */
	public int size() {
		return length;
	}

	/**
	 * Return the element at the front of this queue.
	 * getFirst() == first().
	 * Throw NoSuchElementException if queue is empty.
	 *
	 * @return Object.
	 */
	public Object getFirst() {

		if(isEmpty()) {
			throw new NoSuchElementException();
		}

		return front.element;
	}

	/****************
	 * TRANSFORMERS *
	 ****************/

	/**
	 * Make queue empty.
	 */
	public void clear() {
		front = rear = null;
		length = 0;
	}

	/**
	 * Add element as the rear element of this queue.
	 * addLast() == enqueue().
	 *
	 * @param elem Object - The object to add.
	 */
	public void addLast(Object elem) {

		SLLNode newest = new SLLNode(elem, null);

		if(rear != null) {
			rear.succ = newest;
		} else {
			front = newest;
		}

		rear = newest;
		length++;
	}

	/**
	 * Remove and return the front element of this queue.
	 * removeFirst() == dequeue().
	 * Throw NoSuchElementException if queue is empty.
	 *
	 * @return Object.
	 */
	public Object removeFirst() {

		if(isEmpty()) {
			throw new NoSuchElementException();
		}

		Object frontElem = front.element;
		front = front.succ;

		if(front == null) {
			rear = null;
		}

		length--;
		return frontElem;
	}
}
```

### `LinkedQueue` analysis

- Most operations have time complexity O(1)
- `size()` is O(1)
	- But if `length` was not a variable, `size()` would be O(n)

#### `size()` of O(n) method

- If `length` was not a variable:

``` java
public int size() {

	int length = 0;

	for(SLLNode curr = front; curr != null; curr = curr.succ) {
		length++;
	}

	return length;
}
```

### `LinkedQueue` UML

![LinkedQueue UML](http://snag.gy/P2jyA.jpg)

## Queues in the Java class library

- In Java JDK 1.5.0, a `Queue` interface is provided

### `Queue interface` Java class library UML

![Queue interface UML](http://snag.gy/ZBmq2.jpg)

### `java.util.LinkedList` Java class library `Queue interface`

![java.util.LinkedList Queue interface UML](http://snag.gy/5hyM5.jpg)

### `Queue interface` Java class library example

``` java
import java.util.*;

Queue simpsos = new LinkedList();
simpsons.offer("Homer");
simpsons.offer("Marge");
simpons.poll();
simpsons.offer("Bart");
simpsons.offer("Lisa");
simpsons.remove();
```

# Lists

## List concepts

- A **list** is a sequence of elements **whose order is significant**
- Elements can be added and removed **anywhere in the list**
- The **length** of a list is the number of elements it contains
	- An **empty** list has length zero
- The **concatenation** of lists l<sub>1</sub> and l<sub>2</sub> is a list containing all the elements of l<sub>1</sub> followed by all the elements of l<sub>2</sub>
- **Traversal** of a list means visiting each of the list's elements in turn, in some desired order
	- Traversal also known as **iterating**

## List notation

- Notation for lists
	- List with elements: «a, b, ..., z»
	- Empty list: « »
- List notation is used here but **not** supported by Java
- Examples of lists:
	- simpsons = «Homer, Marge, Bart, Lisa, Maggie»
	- tour = = «Perth, Sydney, Brisbane, Perth»
	- hamlet1 = «'to', 'be', 'or', 'not', 'to', 'be'»
	- hamlet2 = «'that', 'is', 'the', 'question'»
- Concatenation of hamlet1 and hamlet2
	- «'to', 'be', 'or', 'not', 'to', 'be', 'that', 'is', 'the', 'question'»

## Lists vs. linked lists

- Do not confuse the **list** ADT with **linked list** data structure
	- A list ADT can be implemented using different data structures, such as
		- Array
		- Linked list
		- etc.
	- Linked list data structures can be used to implement many ADTs
		- Stacks
		- Queues
		- Lists
		- Sets

## List applications

- A sentence is a list of words
	- The order of words is significant
	- The same word can occur more than once in a sentence
- An itinerary is a list of places visited on a tour
	- The order of places is significant
	- The same place can occur more than once in an itinerary
- A log is a list of event records
	- The event records are in time order

## List requirements

1. It must be possible to make a list empty
2. It must be possible to test whether a list is empty
3. It must be possible to obtain the length of a list
4. It must be possible to add an element anywhere in a list
5. It must be possible to remove an element anywhere in a list
6. It must be possible to inspect or update an element anywhere in a list
7. It must be possible to concatenate lists
8. It must be possible to test lists for equality
9. It must be possible to traverse a list

## List contract as `interface`

``` java
/**
 * Each list object is an indexed list whose elements are objects..
 */
public interface List {

	/*************
	 * ACCESSORS *
	 *************/

	/**
	 * Return true if list is empty.
	 *
	 * @return boolean.
	 */
	public boolean isEmpty();

	/**
	 * Return lists's length.
	 *
	 * @return int.
	 */
	public int size();

	/**
	 * Return the element with index i in this list.
	 * Throw IndexOutOfBoundsException if i is out of range.
	 *
	 * @param i int - Index.
	 * @return Object.
	 */
	public Object get(int i);

	/**
	 * Return true if this and that list have:
	 * Same length, and each element of this list == corresponding element of that list.
	 *
	 * @param that List - List to compare.
	 * @return boolean.
	 */
	public boolean equals(List that);

	/****************
	 * TRANSFORMERS *
	 ****************/

	/**
	 * Make list empty.
	 */
	public void clear();

	/**
	 * Replace by elem the element at index i in this list.
	 * Throw IndexOutOfBoundsException if i is out of range.
	 *
	 * @param int i - Index.
	 * @param Object - The Object to insert.
	 */
	public void set(int i, Object elem);

	/**
	 * Add elem as the element with index i in this list.
	 * Throw IndexOutOfBoundsException if i is out of range.
	 *
	 * @param int - Index.
	 * @param Object - The Object to add.
	 */
	public void add(int i, Object elem);

	/**
	 * Overloading method.
	 * Add elem after the last element of this list.
	 *
	 * @param Object - The Object to add.
	 */
	public void add(Object elem);

	/**
	 * Add all the elements of that list after the last elements of this list.
	 *
	 * @param List - That list.
	 */
	public void addAll(List that);

	/**
	 * Remove and return the element with index i in this list.
	 * Throw IndexOutOfBoundsException if i is out of range.
	 *
	 * @param int i - Index.
	 * @return Object - The Object to remove.
	 */
	public Object remove(int i);

	/************
	 * ITERATOR *
	 ************/

	/**
	 * Return an iterator that will visit all elements of this list,
	 * in left-to-right order.
	 */
	public Iterator iterator();
}
```

## Iterator contract as `interface`

``` java
/**
 * Each Iterator object represents an iterator over some collection.
 */
public interface Iterator {

	/**
	 * Return true if this iterator has a next element.
	 *
	 * @return boolean.
	 */
	public boolean hasNext();

	/**
	 * Return the next element in this iterator.
	 * Throw NoSuchElementException if there is no such element.
	 *
	 * @return Object.
	 */
	public Object next();

	// ... remove method here.
}
```

### List iterator

- `List` interfaces `iterator()`

``` java
// construct an iterator over the elements of list
Iterator elems = list.iterator();

// tests whether that iterator has any more elements
while(elems.hasNext()) {

	// accesses the next element in that iterator
	Object elem = elems.next();
	// ... elem ...
}
```

- Traversal above has time complexity O(n)

### Iterators example

- Visualize an iterator as a chain to which elements are attached in the required order
- Examples of iterators over the list «'to', 'be', 'or', 'not', 'to', 'be'»

![iterators chain](http://snag.gy/hGwh2.jpg)

## List implementation using arrays

- Represents a **bounded** list `(length <= maxlen)` by:
	- A variable `length`, containing the current length
	- An array `elems` of length `maxlen`, containing the listed elements in `elems[0...length-1]`

### `ArrayList` invariant

![ArrayList invariant](http://snag.gy/kJpbE.jpg)

### `ArrayList` model

![ArrayList model](http://snag.gy/aIvb0.jpg)

### `ArrayList` Java class

``` java
/**
 * Each ArrayList object is an indexed list (sequence)
 * whose elements are objects.
 *
 * This list is represented as follows:
 * Its elements occupy elems[0...length-1].
 */
public class ArrayList implements List {

	private Object[] elems;
	private int length;

	/**
	 * Constructor.
	 * Construct a list, initially empty.
	 * Length is bounded by maxLength.
	 *
	 * @param maxLength int - Max length of array.
	 */
	public ArrayList(int maxLength) {
		elems = new Object[maxLength];
		length = 0;
	}

	/**
	 * Implement List interface.
	 */

	/*************
	 * ACCESSORS *
	 *************/

	/**
	 * Return true if list is empty.
	 *
	 * @return boolean.
	 */
	public boolean isEmpty() {
		return (length == 0);
	}

	/**
	 * Return lists's length.
	 *
	 * @return int.
	 */
	public int size() {
		return length;
	}

	/**
	 * Return the element with index i in this list.
	 * Throw IndexOutOfBoundsException if i is out of range.
	 *
	 * @param i int - Index.
	 * @return Object.
	 */
	public Object get(int i) {

		if(i < 0 || i >= length) {
			throw new IndexOutOfBoundsException();
		}

		return elems[i];
	}

	/**
	 * Return true if this and that list have:
	 * Same length, and each element of this list == corresponding element of that list.
	 *
	 * @param that List - List to compare.
	 * @return boolean.
	 */
	public boolean equals(List that) {

		ArrayList ohter = (ArrayList) that;

		if(length != other.length) {
			return false;
		}

		for(int i = 0; i < length; i++) {

			if(! elems[i].equals(other.elems[i])) {
				return false;
			}
		}

		return true;
	}

	/****************
	 * TRANSFORMERS *
	 ****************/

	/**
	 * Make list empty.
	 */
	public void clear() {

		for(int i = 0; i < length; i++) {
			elems[i] = null;
		}

		length = 0;
	}

	/**
	 * Replace by elem the element at index i in this list.
	 * Throw IndexOutOfBoundsException if i is out of range.
	 *
	 * @param int i - Index.
	 * @param Object - The Object to insert.
	 */
	public void set(int i, Object elem) {

		if(i < 0 || i >= length) {
			throw new IndexOutOfBoundsException();
		}

		elems[i] = elem;
	}

	/**
	 * Add elem as the element with index i in this list.
	 * Throw IndexOutOfBoundsException if i is out of range.
	 *
	 * @param int - Index.
	 * @param Object - The Object to add.
	 */
	public void add(int i, Object elem) {

		if(i < 0 || i > length) {
			throw new IndexOutOfBoundsException();
		}

		if(length == elems.length) {
			expand();
		}

		for(int j = length; j > i; j--) {
			elems[j] = elems[j - 1];
		}

		elems[i] = elem;
		length++;
	}

	/**
	 * Overloading method.
	 * Add elem after the last element of this list.
	 *
	 * @param Object - The Object to add.
	 */
	public void add(Object elem) {

		if(length == elems.length) {
			expand();
		}

		elems[length++] = elem;
	}

	/**
	 * Add all the elements of that list after the last elements of this list.
	 *
	 * @param List - That list.
	 */
	public void addAll(List that) {

		ArrayList other = (ArrayList) that;

		for(int i = 0; i < other.length; i++) {
			add(other.elems[i]);
		}
	}

	/**
	 * Remove and return the element with index i in this list.
	 * Throw IndexOutOfBoundsException if i is out of range.
	 *
	 * @param int i - Index.
	 * @return Object - The Object to remove.
	 */
	public Object remove(int i) {

		if(i < 0 || i >= length) {
			throw new IndexOutOfBoundsException();
		}

		Object oldElem = elems[i];

		for(int j = i + 1; j < length; j++) {
			elems[j - 1] = elems[j];
		}

		length--;
		elems[length] = null;
		return oldElem;
	}

	/************
	 * ITERATOR *
	 ************/

	/**
	 * Return an iterator that will visit all elements of this list,
	 * in left-to-right order.
	 */
	public Iterator iterator() {
		return new ArrayList.LRIterator();
	}

	/***********
	 * HELPERS *
	 ***********/

	/**
	 * Make the elems array longer.
	 */
	private void expand() {
		Object[] newElems = new Object[2 * elems.length];

		for(int i = 0; i < depth; i++) {
			newElems[i] = elems[i];
		}
		elems = newElems;
	}

	/************************
	 * INNER ITERATOR CLASS *
	 ************************/

	/**
	 * An ArrayList.LRIterator object is a left-to-right iterator over a
	 * list represented by an ArrayList object.
	 * This iterator is represented by the array index of the next
	 * element to be visited, place.
	 */
	private class LRIterator implements Iterator {

		private int place;

		/**
		 * Constructor.
		 */
		private LRIterator() {
			place = 0;
		}

		/**
		 * Implement Iterator interface.
		 */

		/**
		 * Tests whether the iterator has any more elements.
		 *
		 * @return boolean.
		 */
		public boolean hasNext() {
			return (place < length);
		}

		/**
		 * Return the next element in this iterator.
		 * Throw NoSuchElementException if there is no such element.
		 *
		 * @return Object.
		 */
		public Object next() {

			if(place >= length) {
				throw new NoSuchElementException();
			}

			return elems[place++];
		}

		// ... remove method here
	}
}
```

### `LIRIterator` array model

- Since `LRIterator` is an inner class of `Arraylist`, its instance methods can access `ArrayList` instance variables

![LRIterator](http://snag.gy/TIBwD.jpg)

## List implementation as linked list

- Represent an unbounded list by:
	- A variable `length`
	- An SLL
		- Links `first` to start of list
		- Links `last` to end of list

### `LinkedList` invariant

![LinkedList invariant](http://snag.gy/1x0jK.jpg)

### `LinkedList` model

![LinkedList model](http://snag.gy/vOSmE.jpg)

### `LinkedList` Java class

``` java
/**
 * Each LinkedList object is an unbounded list whose elements are objects.
 *
 * The list is represented as follows:
 * first and last are links to the first and last nodes of ann SLL containing its elements.
 * length is the number of elements.
 */
public class LinkedList implements List {

	private SLLNode first;
	private SLLNode last;
	private int length;

	/**
	 * Constructor.
	 * Construct a list, initially empty.
	 */
	public LinkedList() {
		first = last = null;
		length = 0;
	}

	/*************
	 * ACCESSORS *
	 *************/

	/**
	 * Return true if list is empty.
	 *
	 * @return boolean.
	 */
	public boolean isEmpty() {
		return (first == null);
	}

	/**
	 * Return lists's length.
	 *
	 * @return int.
	 */
	public int size() {
		return length;
	}

	/**
	 * Return the element with index i in this list.
	 * Throw IndexOutOfBoundsException if i is out of range.
	 *
	 * @param i int - Index.
	 * @return Object.
	 */
	public Object get(int i) {

		if(i < 0 || i >= length) {
			throw new IndexOutOfBoundsException();
		}

		SLLNode curr = node(i);
		return curr.element;
	}

	/**
	 * Return true if this and that list have:
	 * Same length, and each element of this list == corresponding element of that list.
	 *
	 * @param that List - List to compare.
	 * @return boolean.
	 */
	public boolean equals(List that) {

		LinkedList other = (LinkedList) that;

		if(length != other.length) {
			return false;
		}

		for(SLLNode curr1 = first curr2 = other.first;
			curr1 != null; curr1 = curr1.succ, curr2 = curr2.succ) {

			if(! curr1.element.equals(curr2.element)) {
				return false;
			}

			return true;
		}
	}

	/****************
	 * TRANSFORMERS *
	 ****************/

	/**
	 * Make list empty.
	 */
	public void clear() {
		first = last = null;
		length = 0;
	}

	/**
	 * Replace by elem the element at index i in this list.
	 * Throw IndexOutOfBoundsException if i is out of range.
	 *
	 * @param int i - Index.
	 * @param Object - The Object to insert.
	 */
	public void set(int i, Object elem) {

		if(i < 0 || i >= length) {
			throw new IndexOutOfBoundsException();
		}

		SLLNode curr = node(i);
		curr.element = elem;
	}

	/**
	 * Add elem as the element with index i in this list.
	 * Throw IndexOutOfBoundsException if i is out of range.
	 *
	 * @param int - Index.
	 * @param Object - The Object to add.
	 */
	public void add(int i, Object elem) {

		if(i < 0 || i > length) {
			throw new IndexOutOfBoundsException();
		}

		SLLNode newest = new SLLNode(elem, null);

		if(i == 0) {
			newest.succ = first;
			first = newest;
		} else {
			SLLNode pred = node(i - 1)l
			newest.succ = pred.succ;
			pred.succ = newest;
		}

		if(newest.succ == null) {
			last = newest;
		}

		length++;
	}

	/**
	 * Overloading method.
	 * Add elem after the last element of this list.
	 *
	 * @param Object - The Object to add.
	 */
	public void add(Object elem) {

		SLLNode newest = new SLLNode(elem, null);

		if(isEmpty()) {
			first = newest;
		} else {
			last.succ = newest;
		}

		last = newest;
		length++;
	}

	/**
	 * Add all the elements of that list after the last elements of this list.
	 *
	 * @param List - That list.
	 */
	public void addAll(List that) {

		LinkedList other = (LinkedList) that;

		for(SLLNode curr = other.first; curr != null; curr = curr.succ) {

			add(curr.element);
		}
	}

	/**
	 * Remove and return the element with index i in this list.
	 * Throw IndexOutOfBoundsException if i is out of range.
	 *
	 * @param int i - Index.
	 * @return Object - The Object to remove.
	 */
	public Object remove(int i) {

		if(i < 0 || i >= length) {
			throw new IndexOutOfBoundsException();
		}

		Object oldElem;

		if(i == 0) {

			oldElem = first.element;

			if(first == last) {
				last = null;
			}

			first = first.succ;
		} else {

			SLLNode pred = node(i - 1);
			SLLNode old = pred.succ;
			oldElem = old.element;
			pred.succ = old.succ;

			if(old == last) {
				last = pred;
			}
		}

		length--;
		return oldElem;
	}

	/************
	 * ITERATOR *
	 ************/

	/**
	 * Return an iterator that will visit all elements of this list,
	 * in left-to-right order.
	 */
	public Iterator iterator() {
		return new LinkedList.LRIterator();
	}

	/***********
	 * HELPERS *
	 ***********/

	/**
	 * Return a link to the node containing the element with index i in list.
	 *
	 * @param i int - Index.
	 * @return SLLNode.
	 */
	private SLLNode node(int i) {

		SLLNode curr = first;

		for(int j = 0; j < i; j++) {
			curr = curr.succ;
		}
		return curr;
	}

	/************************
	 * INNER ITERATOR CLASS *
	 ************************/

	/**
	 * An ArrayList.LRIterator object is a left-to-right iterator over a
	 * list represented by an ArrayList object.
	 * This iterator is represented by the array index of the next
	 * element to be visited, place.
	 */
	private class LRIterator implements Iterator {

		private SLLNode place;

		private LRIterator() {
			return (place != null);
		}

		public Object next() {

			if(place == null) {
				throw new NoSuchElementException();
			}

			Object nextElem = place.element;
			place.place.succ;

			return nextElem;
		}

		// ... remove method here
	}
}
```

### `LRIterator` linked list model

- Since `LRIterator` is an inner class of `LinkedList`, its instance methods can access `LinkedList` instance variables

![LRIterator linked list model](http://snag.gy/zjeW5.jpg)

## Summary of list implementations

- Time complexities of main operations
- n<sub>2</sub> is the length of the 2nd list

![array vs. linked list list implementation](http://snag.gy/xbcxo.jpg)

## Lists in Java class library

- Java provides the interface `java.util.List`
	- Similar to the `List` interface above
- Java provides the class `java.util.ArrayList`
	- Implements the `java.util.List` interface
	- Represents each list with an array
- Java provides the class `java.util.LinkedList`
	- Implements the `java.util.List` interface
	- Represents each list with a doubly linked list

### Simplified List Java class UML

![simplified List java class UML](http://snag.gy/VBMHw.jpg)

# Study guide

- Java collections
	- Chapter 7
	- Chapter 8
- Data structures
	- Section 5.3
	- Section 5.4
	- Section 6.1 - 6.3
