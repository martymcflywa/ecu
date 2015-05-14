# Tutorial 10: Queues and lists

## Task 1

Test the Java implementation of a `Queue` class given in ArrayQueue.java using the class tester in `WS1001`.

1. Explain the structure of this program
2. Observe the behaviours of this program by running it a few times

### 1.1

``` java
class WS1001 {
	public static void main(String[] args) {
		ArrayQueue q = new ArrayQueue(10);
		Integer j = null;
		int i;
		System.out.println("starting...");
		for (i = 0; i < 10; i++) {
			j = new Integer((int) (Math.random() * 100));
			q.insert(j);
			System.out.println("insert: " + j);
		}
		while (!q.isEmpty()) {
			System.out.println("remove: " + ((Integer) q.remove()));
		}
		System.out.println("Done ;-)\n\n");
	}
}
```

- Create new `ArrayQueue` called `q`
- Loop to insert random values into `q`
- While `q` is not empty, remove each element

### 1.2

Console:

```
starting...
insert: 90
insert: 18
insert: 73
insert: 93
insert: 94
insert: 52
insert: 63
insert: 69
insert: 35
insert: 63
remove: 90
remove: 18
remove: 73
remove: 93
remove: 94
remove: 52
remove: 63
remove: 69
remove: 35
remove: 63
Done ;-)
```

## Task 2

Test the Java implementation of the `ArrayList` class given in `WS1002`. Uses `Cities.txt` as input.

1. Notice the invocation of `add()` and `remove()` methods provided by the `ArrayList` class
2. Execute this program and analyse the results corresponding to individual method invocations in the program

### 2.1

``` java
import java.io.*;
import java.util.*;

public class WS1002 {
	private static ArrayList list = new ArrayList();

	public static void main(String[] args) {
		load("Cities.txt");
		System.out.println(list);
		list.remove(list.indexOf("Seoul"));
		list.remove(list.indexOf("Osaka"));
		list.add(5, "Shanghai");
		list.add(6, "Los Angeles");
		System.out.println(list);
	}

	private static void load(String filename) {
		try {
			File file = new File(filename);
			FileReader reader = new FileReader(file);
			BufferedReader in = new BufferedReader(reader);
			String city = in.readLine();
			while (city != null) {
				list.add(city);
				city = in.readLine();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
```

- `ArrayList list` uses
	- `list.add(city);` to add elements to ArrayList
	- `list.remove(list.indexOf("Seoul"));` to remove elements from ArrayList
- `indexOf()` is used to determine index of element and passed to `remove()`

### 2.2

Console:

```
[Tokyo, Mexico City, Sao Paulo, Seoul, New York, Osaka, Bombay, Calcutta, Buenos Aires]
[Tokyo, Mexico City, Sao Paulo, New York, Bombay, Shanghai, Los Angeles, Calcutta, Buenos Aires]
```

## Task 3

Test the Java program `WS1003` to observe the behaviors of the `listIterator`.

1. Analyse the potential behaviours of running this program
2. Execute this program and compare your analysis with the executed results

### 3.1

``` java
import java.io.*;
import java.util.*;

public class WS1003 {
	private static ArrayList list = new ArrayList();

	public static void main(String[] args) {
		load("Cities.txt");
		System.out.println(list);
		list.remove(list.indexOf("Seoul"));
		list.remove(list.indexOf("Osaka"));
		ListIterator it = list.listIterator();
		System.out.println("it.next() = " + it.next());
		System.out.println("it.next() = " + it.next());
		System.out.println("it.next() = " + it.next());
		System.out.println("it.next() = " + it.next());
	}

	private static void load(String filename) {
		try {
			File file = new File(filename);
			FileReader reader = new FileReader(file);
			BufferedReader in = new BufferedReader(reader);
			String city = in.readLine();
			while (city != null) {
				list.add(city);
				city = in.readLine();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
```

- `it.next()` begins at index 0 and steps through each item in list consecutively

### 3.2

Console:

```
[Tokyo, Mexico City, Sao Paulo, Seoul, New York, Osaka, Bombay, Calcutta, Buenos Aires]
it.next() = Tokyo
it.next() = Mexico City
it.next() = Sao Paulo
it.next() = New York
```

## Task 4

Devise an alternative Java implementation of `WS1004` using the `LinkedList` class.

1. Execute your program
2. Discuss the results obtained from running these two programs

### 4.1

``` java
import java.io.*;
import java.util.*;

public class WS1004 {
	private static LinkedList list = new LinkedList();

	public static void main(String[] args) {
		load("Cities.txt");
		System.out.println(list);
		list.remove(list.indexOf("Seoul"));
		list.remove(list.indexOf("Osaka"));
		list.add(5, "Shanghai");
		list.add(6, "Los Angeles");
		System.out.println(list);
	}

	private static void load(String filename) {
		try {
			File file = new File(filename);
			FileReader reader = new FileReader(file);
			BufferedReader in = new BufferedReader(reader);
			String city = in.readLine();
			while (city != null) {
				list.add(city);
				city = in.readLine();
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}
```

### 4.2

Console:

```
[Tokyo, Mexico City, Sao Paulo, Seoul, New York, Osaka, Bombay, Calcutta, Buenos Aires]
[Tokyo, Mexico City, Sao Paulo, New York, Bombay, Shanghai, Los Angeles, Calcutta, Buenos Aires]
```
