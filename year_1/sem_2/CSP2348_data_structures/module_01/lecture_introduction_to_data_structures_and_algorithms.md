# Introduction to data structures and algorithms

## Introduction to algorithm

### What is an algorithm

- An algorithm is a step-by-step procedure for solving a stated problem in a finite amount of time
- For example, consider the problem of multiplying two numbers
	- There are many possible algorithms for solving this problem
		- Multiplication using a table
			- Suitable only for small numbers
		- Multiplication manually using pen and paper
		- Multiplication using logarithms
		- Multiplication using a slide rule
		- Binary fixed-point or floating point multiplication
			- In a computer or calculator

### Examples of algorithm

#### Finding a midpoint 1

To find the midpoint of a given straight-line segment AB:

![midpoint 1](http://snag.gy/NFSzQ.jpg)

1. Drawn intersecting circles of equal radius, centered at A and B respectively
2. Let C and D be the points where the circles intersect
3. Draw a straight line between C and D
4. Let E be the point where line CD intersects with line AB
5. Terminate with answer E

Could be performed by a human equipped with drawing instruments

![midpoint 2](http://snag.gy/IPNe7.jpg)

#### GDCs

- The **greatest common divisor** (GDC) of two positive integers is the largest integer that exactly divides both
	- ie. The GDC of 77 and 21 is 7
- Euclid's GDC algorithm
	- To compute the GDC of positive integers *m* and *n*:
		1. Set *p* to *m*, and set *q* to *n*
		2. Until *q* exactly divides *p*, repeat
			- Set *r* to (*p* mod *q*), *p* to *q*, and set *q* to *r*
		3. Terminate with answer *q*
	- Could be performed by a human, perhaps equiped with an abacus or calculator

![gdc 1](http://snag.gy/1gZ9P.jpg)

##### Algorithm implemented in Java

``` java
int gdc (int m, int n) {
	
	// find greatest common divisor of m > 0, n > 0

	if (m < 1 || n < 1) return 0;
	
	int p = m;
	int q = n,

	while ((p % q) != 0) {

		int r = p % q;
		p = q;
		q = r;
	}

	return q;
}
```

#### Tower of Hanoi

THe object of the game is to move all the disks over to tower 3 with your mouse. But you cannot place a larger disk onto a smaller disk.

![tower of hanoi](http://upload.wikimedia.org/wikipedia/commons/6/60/Tower_of_Hanoi_4.gif)

### Algorithms vs. programs

- An algorithm is a procedure that
	- Can be performed by humans or machines
	- Can be expressed in any suitable language
	- May be as abstract as we like
- A program is an algorithm that
	- Must be performed by machines
	- Must be expressed in a programming language
	- Must be detailed and specific
- If we wish to use an algorithm on a computer, we must first code it in a programmming language
- There may be many ways of coding the algorithm, and there is a wide choice of programming languages
	- But all the resulting programs are implementations of the same underlying algorithm
- Here we express our implementations in **Java**
	- Alternatives would be C, Pascal Ada etc.

## Data structures

- A **data structure** is a systematic way of 
	- Organising a collection of data elements in **memory**
	- Define a set of operations to add, remove and access elements in the collection
		- The design and implementation of these operations is achieved via the design/implementation of algorithms
- Example
	- Say we require an application to read from the input stream a user typed `String` and then display to the output stream the string in reverse ordere

`String` "Java" array:

![string array](http://snag.gy/coWF0.jpg)

- As the choice of data structure affects the performance of a given program, a data structure is normally selected based on a given application's data and data processing requirements
- There are different types of data structures (DS)
	- Static data structure
		- One whose capacity is fixed at creation time, such as an array
	- Dynamic data structure
		- One whose capacity is variable, so it can expand or contract during life time
			- ie. Linked list, binary tree

### Commonly used data structures

- Commonly used DS include
	- Arrays
	- Lists
		- ArrayList
		- Linked list
	- Maps
	- Sets
	- Stacks
	- Queues
	- Heaps
	- Trees
	- Graphs

#### Array

- Stores data collection using an index
	- Allows access anywhere via index
	- Has fixed length specified at array declaration time

![array](http://snag.gy/iC7tD.jpg)

#### ArrayList

- Ability to grow dynamically to meet the runtime needs of a program

#### Linked list

- Insertion and deletion of data elements by position (at anywhere)
	- By breaking and creating new links between data elements

![linked list](http://snag.gy/y3xXr.jpg)

#### Map 

- Stores data as a key-value pair
	- Key can be compared to an index like in arrays
	- Example: in the "Java" example, we can associate key "first" with value 'J'

``` java
map.put("first", 'J');
letter = map.get("first");
```

#### Set

- Stores data collection with **no duplicates**

#### Stack

- Allows insertion and deletion only at top of stack (LIFO)

#### Queue

- Allows insertion at the back and deletion from the front (FIFO)

#### Tree

For example, data structures to represent the set of words {bat, cat, mat, rat, sat}

![tree](http://snag.gy/Bwi3c.jpg)

## Data types

- We classify all data into **data types**, such as
	- Booleans
	- Integers
	- Objects of various classes
- Each data type is characterized by
	- A set of values
	- A data representation
		- Which is common to all these values
	- A set of operations
		- Which can be applied uniformly to all these values

Java built in data types:

![data types](http://snag.gy/LL29y.jpg)

### Abstract data types

- When we write application code, we don't care how stirngs are represented
	- We just declare variables of type `String`, and manipulate them using `String` operations
- Similarly, we don't care how sets are represented
	- We just delcare variables of type `Set`, and manipulate them using `Set` operations
- An **abstract data type (ADT)** is a data type whose representation is hidden from, and of no concern to, the application code
	- Examples: `String`, `Set`
- ADTs provide an excellent way to design large programs

#### ADTs in the Java class library

- Class `java.lang.String` is similar to `String`
- Class `java.lang.StringBuffer` is similar to `MutableString`
- Interface `java.util.List` supports lists
- Interface `java.util.Set` supports sets
- Interface `java.util.Map` supports maps (tables)
- Packages `java.awt`, `java.io`, `java.util` etc support many other ADTs

### Java collection framework (simplified)

![java collection framework](http://snag.gy/d8mU7.jpg)

## Reading

> Watt, D. A. & Brown, D. F. (2001). Java Collections: An Introduction to Abstract Data Types, Data Structures and Algorithms

- Module 1 read:
	- Chapter 1
	- Appendix C
- Module 2 read:
	- Chapter 2
	- Appendix A

