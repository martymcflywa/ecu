# Stacks and vectors

## Stacks

### Stack concept

- A **stack** is a last-in-first-out (LIFO) sequence of elements
- Elements can be added and removed **only** at one end
	- ie. The **top** of the stack
	- Can only manipulate **one element** at a time
- The **depth** of a stack is the number of elements it contains
	- Can be fixed or dynamic
	- An **empty** stack has depth 0

![stack LIFO simple model](http://snag.gy/DNQoG.jpg)

#### Stack of books example

![stack of books](http://snag.gy/s5v11.jpg)

### Stack applications

#### Interpreter

- The Java Virtual Machine
- Maintains a stack containing intermediate results during evaluation of complicated expressions
- The stack also contains arguments and return addresses for method calls and returns
- Example
	- Calculate expression
		- `x = 1 + 6 * (3 + 4 * 5^2) - 7`

#### Binary tree traversal

- Uses stack to keep nodes
	- Instead of recursion
- Pre-order
- In-order
- Post-order

![bst model](http://snag.gy/dz3mt.jpg)

#### Parser

- A component of the Java compiler
- Maintains a stack containing symbols encountered during parsing

#### Runtime

- Contains arguments and return addresses for method calls and returns

#### Word processor

- Undo

#### Powerpoint

- Backward show
	- etc.

### Stack requirements

1. It must be possible to make a stack empty
2. It must be possible to add an element to the top of the stack
	- **Push**
3. It must be able to remove the topmost element from a stack
	- **Pop**
4. It must be possible to test whether a stack is empty
5. It should be possible to access the topmost element in a stack without removing it
	- **Peek**

### Stack contract as `interface`

``` java
public interface Stack {

	// each stack object is a stack whose elements are objects

	/*************
	 * ACCESSORS *
	 *************/

	/**
	 * Return true if stack is empty
	 */
	public boolean isEmpty();

	/**
	 * Return the element at top of stack
	 * getLast() == peek()
	 */
	public Object getLast();

	/****************
	 * TRANSFORMERS *
	 ****************/

	/**
	 * Make stack empty
	 */
	public void clear();

	/**
	 * Add element as the top element of this stack
	 * addLast() == push()
	 */
	public void addLast();

	/**
	 * Remove and return the element at the top of this stack
	 * removeLast() == pop()
	 */
	public Object removeLast();
}
```

#### Stack `interface` UML

![Stack interface UML](http://snag.gy/e7VVY.jpg)

### Stack class using arrays: `ArrayStack`

- Represent a **bounded** stack (depth &le; maxdepth) by:
	- Variable depth, containing the current depth
	- Array elems of length maxdepth, containing the stack elements in elems[0...depth-1]

![ArrayStack model](http://snag.gy/P0x5s.jpg)

#### `ArrayStack` Java implementation

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

#### `ArrayStack` time complexity

- `isEmpty()`: O(1)
- `getLast()`: O(1)
- `addLast()`: O(1)
- `removeLast()`: O(1)
- `clear()`: O(n)
- `expand()`: O(n)
	- Space complexity = O(n)
	- Since it has to copy elems into new array

#### `ArrayStack` UML

![ArrayStack class UML](http://snag.gy/55kPK.jpg)

### Stack class using linked lists: `LinkedStack`

- Represent an **unbounded** stack by an SLL, such that the first node contains the topmost element

![LinkedStack model](http://snag.gy/89QfQ.jpg)

#### `LinkedStack` Java implementation

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

#### `LinkedStack` UML

![LinkedStack class UML](http://snag.gy/n8G60.jpg)

## Vectors

### Java `Vector` class

- An object of class `Vector` is similar to an array which stores multiple values
- However, a `Vector`
	- Only stores `Object`s
	- **Does not** have an indexing syntax like arrays
- A `Vector` has general data structure of a stack
	- Can
		- Insert
		- Delete
		- Peek
	- One element at any point of the `Vector`
	- With or without use of an index
- The methods of `Vector` class are used to interact with the elements of a `Vector`
- **Difference** between array and vector
	- A vector can be thought of as dynamic
		- Able to change size as needed
	- Each vector initially has certain amount of memory space reserved for storing elements
	- If an element is added to a vector that doesn't fit in the existing space
		- More room is automatically acquired
- The `Vector` class is part of the `java.util` package
- The `Vector` class is implemented using arrays
	- Whenever new space is required
		- A new, larger array is creaetd
		- Values are copied from the original to the new array
	- To insert an element
		- Existing elements are first copied one by one to another position in the array
			- Therefore the implementation of `Vector` is not very efficient for inserting elements

![Vector insert model](http://snag.gy/kqdnV.jpg)

### Java `Vector` class methods

``` java
// constructor
Vector();

// adds the given object into the end of this vector
void addElement(Object object);

// insert the given object into this vector at the given index
void insertElementAt(Object object, int index);

// remove the object at the given index from this vector
Object remove(int index);

// remove the given object from this vector
void removeElement(Object object);

// returns the index of a specific object, or -1 if object not found
int indexOf(Object object);

// returns the number of elements in this vector
int size();

// ...
```

### Java `Vector` class example

``` java
// create new vector called units
Vector units = new Vector();

// insert elements to units
units.addElement("CSP1150");
units.addElement("CSP2348");
units.addElement("CSP2343");
units.addElement("CSP3241");

// print units
System.out.println(units);

// remove a unit and print result
units.removeElement("CSP2343");
System.out.println(units);

// print unit at a specific index
System.out.println("At index 1: " + units.elementAt(1));

// insert new element at specific index and print result
units.insertElementAt("CSP2347", 2);
System.out.println(units);

// print size of units
System.out.println("Size of units: " + units.size());
```

## Stacks in Java class library

- Java provides no `Stack` interface as such
- However, the `java.util.Stack` class provides all the above `Stack` operations
- The `Stack` class is a subclass of the `Vector` class

### `java.util.Stack` UML

![java.util.Stack UML](http://snag.gy/lea1Z.jpg)

### Stacks in Java class library `Test` class

``` java
import java.util.Stack;

public class Test {

	public static void main(String[] args) {

		Stack stack = new Stack();

		stack.push("Alice");
		stack.push("Bob");
		stack.pop();
		stack.push("Colin");
		stack.pop();
		stack.size();

		// ...
	}
}
```

### `Test` class UML

![Test class UML](http://snag.gy/LqRlk.jpg)

### Using the `Stack` class

#### Reversing an array with `Stack`

- Reversing an array could be simple by using a stack

``` java
private static void reverseArray(int[] array) {
	Stack stack = new Stack();
	for(i = 0; i < a.length; i++) {
		stack.push(array[i]);
	}
	for(int i = 0; i < a.length; i++) {
		array[i] = stack.pop();
	}
}
```

![anim reverse array with Stack](http://i.imgur.com/kn4B7tv.gif)

#### Reverse stack with stacks only

- To reverse the contents of a stack using stacks only
	- You need two stacks

``` java
private static void reverseStack(Stack stack) {

	Stack stack1 = new Stack();

	while(!stack.isEmpty()) {
		stack1.push(stack.pop());
	}

	Stack stack2 = new Stack();

	while(!stack1.isEmpty()) {
		stack2.push(stack1.pop());
	}

	while(!stack2.isEmpty()) {
		stack.push(stack2.pop());
	}
}
```

![reverseStack model](http://snag.gy/20MoJ.jpg)

## Study guide

- Java Collections
	- Chapter 6
- Data Structures & Algorithms
	- Section 5.1
