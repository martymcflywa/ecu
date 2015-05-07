# Review questions 09: Stacks and vectors

## 1

Would it make sense to call a stack a FILO (first-in-last-out) structure?

Yes, FILO == LIFO (last-in-first-out).

## 2

What is the difference between a SLL and a stack?

- SLL
	- Can insert/remove a node in any position
- Stack
	- Can only insert/remove nodes at top of stack

## 3

Trace the following code, showing the contents of the `stack` after each invocation.

- Note:
	- `push() == addLast()`
	- `pop() == removeLast()`

``` java
Stack stack = new Stack();
stack.push("A");
stack.push("B");
stack.push("C");

stack.pop();
stack.pop();

stack.push("D");
stack.push("E");
stack.push("F");

stack.pop();

stack.push("G");

stack.pop();
stack.pop();
stack.pop();
```

![q3](http://snag.gy/NPzEp.jpg)

## 4

The following lists two implementations of the stack ADT. The first one is an array based implementation and the second is an SSL based implementation.

In the first implementation, the method `addLast()` is implemented by calling another method called `expand()`, while in the second implementation the method `addLast()` is implemented without calling any other methods. Explain what causes this difference in the implementation of the same ADT, and then analyse the performances of these two implementations in terms of big-O notation.

- Array data structure is static
	- When capacity is reached, a new larger array must be created
	- New array hosts existing values by being copied to it
	- Then new values added
- SLL data structure is dynamic
	- Size dynamically changes as values are added to it
- `ArrayStack` analysis
	- To add new element
		- O(1) if capacity not reached
		- If capacity reached
			- `expand()` performs n copies to transfer existing n number of values
			- `addLast()` takes O(1)
			- Therefore, without considering effort to make new array
				- `addLast()` is of O(n)
					- ie. O(n) + O(1) = O(n)
- `LinkedStack` analysis
	- Since it is dynamic data structure
	- `addLast()` performs like inserting new value into front end of an SLL
	- Is of O(1)

### `ArrayStack`

``` java
/**
 * Each ArrayStack object is a **bounded** stack whose elements are objects.
 * This stack is represented as follows: its depth is held in depth,
 * and its elements occupy the subarray elems[0...depth].
 */
public class ArrayStack implements Stack {

	private Object[] elems;
	private int depth;

	/**
	 * Constructor.
	 * @param maxDepth int.
	 */
	public ArrayStack(int maxDepth) {
		// construct a stack, initially empty, whose depth will be bounded by maxDepth
		elems = new Object[maxDepth];
		// all components of elems are initially null
		depth = 0;
	}

	/*************
	 * ACCESSORS *
	 *************/

	/**
	 * Return true if stack is empty.
	 */
	public boolean isEmpty() {
		return (depth == 0);
	}

	/**
	 * Return the element at top of stack.
	 * getLast() == peek()
	 * Throw NoSuchElementException if stack is empty.
	 */
	public Object getLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return elems[depth - 1];
	}

	/****************
	 * TRANSFORMERS *
	 ****************/

	/**
	 * Make stack empty.
	 */
	public void clear() {
		for(i = 0; i < depth; i++) {
			elems[i] = null;
		}
		depth = 0;
	}

	/**
	 * Add element as the top element of this stack.
	 * addLast() == push()
	 */
	public void addLast(Object elem) {
		if(depth == elems.length) {
			expand();
		}
		elems[depth++] = elem;
	}

	/**
	 * Remove and return the element at the top of this stack.
	 * removeLast() == pop()
	 * Throw NoSuchElementException if stack is empty.
	 */
	public Object removeLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		Object topElem = elems[--depth];
		elems[depth] = null;
		return topElem;
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

### `LinkedStack`

``` java
/**
 * Each LinkedStack object is an **unbounded** stack whose elements are objects.
 * This stack is represented as follows: top is a link to the first node of an
 * SLL containing the stack's elements, top-to-bottom order.
 */
public class LinkedStack implements Stack {

	private SLLNode top;

	/**
	 * Constructor.
	 * Construct a stack, initially empty.
	 */
	public LinkedStack() {
		top = null;
	}

	/*************
	 * ACCESSORS *
	 *************/

	/**
	 * Return true if stack is empty.
	 */
	public boolean isEmpty() {
		return (top == null);
	}

	/**
	 * Return the element at top of stack.
	 * getLast() == peek()
	 * Throw NoSuchElementException if stack is empty.
	 */
	public Object getLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		return top.element;
	}

	/****************
	 * TRANSFORMERS *
	 ****************/

	/**
	 * Make stack empty.
	 */
	public void clear() {
		top = null;
	}

	/**
	 * Add element as the top element of this stack.
	 * addLast() == push()
	 */
	public void addLast() {
		top = new SLLNode(elem, top);
	}

	/**
	 * Remove and return the element at the top of this stack.
	 * removeLast() == pop()
	 * Throw NoSuchElementException if stack is empty.
	 */
	public Object removeLast() {
		if(isEmpty()) {
			throw new NoSuchElementException();
		}
		Object topElem = top.element;
		top = top.next;
		return topElem;
	}
}
```
