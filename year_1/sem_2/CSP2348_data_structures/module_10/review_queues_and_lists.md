# Review questions 10: Queues and lists

## 1

Would it make sense to call a queue a LILO (last-in-last-out) structure?

- Yes, LILO == FIFO

## 2

Attempt Exercise 7.4 on page 167 in the textbook.

>Would you implement the queue ADT using a doubly linked list? Explain.

Doubly linked list is not necessary in a queue since no operations require access to a nodes previous.

## 3

Trace the following code, showing the contents of the queue q after each call.

Note:  
`enqueue() == addLast()`  
`dequeue() == removeFirst()`

``` java
ArrayQueue q;
q.enqueue(“A”);
q.enqueue(“B”);
q.enqueue(“C”);
q.dequeue();
q.dequeue();
q.enqueue(“D”);
q.enqueue(“E”);
q.enqueue(“F”);
q.dequeue();
q.enqueue(“G”);
q.dequeue();
q.dequeue();
q.dequeue();
```

```
A > AB > ABC > BC > C > CD > CDE > CDEF > DEF > DEFG > EFG > FG > G
```

## 4

Explain whether the expression is true or false:

Feeling = «I, want, to, pass, this, exam, but, I, do, not, know, if, I, can, pass, it»

- True, a list allows repetition of values

## 5

In deciding whether to use an `ArrayList` or a `LinkedList` in an application, what factors make one choice better than the other?

- `ArrayList` should be used when existing data is accessed more frequently
- `LinkedList` should be used when data is to be added/removed more frequently
	- Also not bounded

## 6

Attempt Exercise 8.3 on page 199 in the textbook.

>Using the `List` ADT of Program 8.2, write the following method:

``` java
static List reorder(List persons) {
	// Assume that persons is a list of Person objects, ordered by name.
	// Return a similar list of Persons objects, ordered such that all
	// children aged under 18 come before all adults aged 18 or over
	// but otherwise preserving the ordering by name
}
```

``` java
static List reorder(List persons) {

	// create new lists to store children and adults
	List children = new LinkedList();
	List adults = new LinkedList();

	// create iterator attached to persons arg
	Iterator iter = persons.iterator();

	// while iter has a next value,
	while(iter.hasNext()) {

		// set p to iter's next (cast as Person)
		Person p = (Person) iter.next();

		// if p's age is <= 18,
		if(p.age <= 18) {

			// add to children list
			children.add(p);

		// else age is > 18
		} else {

			// add to adult list
			adults.add(p);
		}
	}

	// create new list called result, set it to children list
	List result = children;
	// concat adults to result list
	result.addAll(adults);
	// return result
	return result;
}
```
