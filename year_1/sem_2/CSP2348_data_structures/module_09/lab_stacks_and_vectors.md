# Tutorial 09: Stacks and vectors

## Task 1

The following is a simplified algorithm that tests whether a programming phrase is well-bracketed.

>1. Make bracket-stack empty
2. For each symbol sym in phrase (scanning from left to right), repeat:
	1. If sym is a left bracket
		1. Add sym to the top of bracket-stack
	2. If sym is a right bracket
		1. If bracket-stack is empty, terminate with answer false
		2. Remove a bracket from the top of bracket-stack into left
		3. If left and sym are not matched brackets, terminate with answer false
3. Terminate with answer true if bracket-stack is empty, or false if not empty

Hand-test this algorithm with the following phrases:

### 1.1

``` java
main(String[] args) {
	System.out.print(arg[0];
}
```

```
STACK:	LEFT:
		()
		[]
		(}
{
```

- Phrase 1 != well-bracketed

### 2.2

``` java
[(a + b) - (c - d)
```

```
STACK:	LEFT:
		()
		()
[
```

- Phrase 2 != well-bracketed

## Task 2

Test the `push()` and `pop()` methods of the `Stack` class implemented using Java `Vector` class in `WS0901.java`.

``` java
// WS0901.java
import java.util.Stack;

public class WS0901 {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("Brazil");
		stack.push("Canada");
		stack.push("France");
		stack.push("Mexico");
		stack.push("Russia");
		stack.push("Sweden");
		stack.push("Brazil");
		stack.push("Turkey");
		print(stack);

		System.out.println("stack.search(\"Brazil\") = "
					  + stack.search("Brazil"));
		System.out.println("stack.pop() = " + stack.pop());
		System.out.println("stack.pop() = " + stack.pop());
		print(stack);
		System.out.println("stack.search(\"Brazil\") = "
					  + stack.search("Brazil"));
	}

	private static void print(Stack stack) {
		System.out.println(stack);
		System.out.println("stack.size() = " + stack.size());

		try {
			System.out.println("stack.peek() = " + stack.peek());
		} catch(java.util.EmptyStackException e) {
			System.out.println(e + ": The stack is empty.");
		}
	}
}
```

### 2.1

Explain what will be resulted from each of the statements in the code.

- `push()` adds elements to the end (top) of stack
- `search()` starts search from end (top) of stack
	- ie. Last/top element == index 1
- `peek()` returns last/top element of stack

### 2.2

Check with your explanation by running the Java program.

```
// console output:
[Brazil, Canada, France, Mexico, Russia, Sweden, Brazil, Turkey]
stack.size() = 8
stack.peek() = Turkey
stack.search("Brazil") = 2
stack.pop() = Turkey
stack.pop() = Brazil
[Brazil, Canada, France, Mexico, Russia, Sweden]
stack.size() = 6
stack.peek() = Sweden
stack.search("Brazil") = 6
```

## Task 3

Test the `Vector` class using `WS0902.java`.

``` java
//  Testing the java.util.Vector class
import java.util.*;
public class WS0902 {

	private static Vector v = new Vector();
	private static Vector w = new Vector();

	public static void main(String[] args) {

		System.out.println("v = " + v);

		v.add("Perth");
		v.add("Sydney");
		v.add("Melbourne");
		v.add("Brisbane");
		v.add("Adelaide");
		System.out.println("v = " + v);

		w = (Vector)v.clone();
		System.out.println("w = " + w);
		System.out.println("w.equals(v) = " + w.equals(v));

		v.set(3,"Canberra");
		System.out.println("v = " + v);
		System.out.println("w = " + w);
		System.out.println("w.equals(v) = " + w.equals(v));

		v.insertElementAt("Hobart",3);
		System.out.println("v = " + v);
		System.out.println("w = " + w);
		System.out.println("w.equals(v) = " + w.equals(v));

		w.removeElementAt(1);
		w.removeElementAt(3);
		w.remove("Canberra");
		System.out.println("w = " + w);

		v.addAll(5,w);
		System.out.println("v = " + v);
		System.out.println("v.indexOf(\"Perth\") = "
					  + v.indexOf("Perth"));
		System.out.println("v.indexOf(\"Perth\",2) = "
					  + v.indexOf("Perth",2));
		System.out.println("v.indexOf(\"Canberra\") = "
					  + v.indexOf("Canberra"));
	}
}
```

### 3.1

Note how to construct vector objects:

``` java
private static Vector v = new Vector();
private static Vector w = new Vector();
```

### 3.2

Observe the operation of some vector methods by analyzing the executed results.

- Index begins at end/bottom of vector
	- ie. Like array

```
// console output
v = []
v = [Perth, Sydney, Melbourne, Brisbane, Adelaide]
w = [Perth, Sydney, Melbourne, Brisbane, Adelaide]
w.equals(v) = true
v = [Perth, Sydney, Melbourne, Canberra, Adelaide]
w = [Perth, Sydney, Melbourne, Brisbane, Adelaide]
w.equals(v) = false
v = [Perth, Sydney, Melbourne, Hobart, Canberra, Adelaide]
w = [Perth, Sydney, Melbourne, Brisbane, Adelaide]
w.equals(v) = false
w = [Perth, Melbourne, Brisbane]
v = [Perth, Sydney, Melbourne, Hobart, Canberra, Perth, Melbourne, Brisbane, Adelaide]
v.indexOf("Perth") = 0
v.indexOf("Perth",2) = 5
v.indexOf("Canberra") = 4
```
