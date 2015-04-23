# Abstract data types

## Data types

- We classify all data into **data types**, such as:
	- Booleans
	- Integers
	- Objects of various classes
- Each data type is characterized by:
	- A set of **values**
	- A **data representation**
		- Which is common to all these values
	- A set of **operations** which can be applied uniformly to all these values

### Java built-in data types

![java built-in data types](http://snag.gy/J7D9e.jpg)

### Introducing new data types

- To introduce a new data type, we must define its values, data representation, and operations
- In Java, use a class **declaration:**
	- The class's **instance variables** determine the values and data representation
	- The class's **constructors** and **methods** are the operations
	- Each object of the class
		- Has those instance variables
		- Is created by one of those constructors
		- May be inspected and/or updated by any of those methods

### Example: `Date` type

#### Class declaration

``` java
public class Date {

	// Each Date value is a past, present or future date.
	// This date is represented by a year number y,
	// a month number m(1...12),
	// and a day-in-month number d(1...31):
	public int y;
	public int m;
	public int d;

	// Construct a date with year y, month m, and day-in-month d:
	public Date(int y, int m, int d) {

		// Throw an exception if constructing improper date:
		if(m < 1 || m > 12 || d < 1 || d > length(m, y)) {
			throw new IllegalArgumentException("Improper date!");
		}

		this.y = y;
		this.m = m;
		this.d = d;
	}

	// Advance this date by n days (where n >= 0):
	public void advance(int n) {

		int y = this.y;
		int m = this.m;
		int d = this.d + n;

		// no. of days in m/y
		int last;

		while(d > (last = length(m, y))) {
			d -= last;

			if(m < 12) {
				m++;
			} else {
				m = 1;
				y++;
			}
		}
		this.y = y;
		this.m = m;
		this.d = d;
	}

	/********************
	* Auxiliary methods *
	*********************/

	// Return the number of days in months m in year y
	private static int length(int m, int y) {
		switch(m) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				return(isLeap(y)? 29:28);
		}
	}

	// Return true if and only if y is a leap year.
	private static boolean isLeap(int y) {
		return(y % 4 == 0 && (y % 100 != 0 || y % 400 == 0));
	}
}
```

#### Possible application code

``` java
Date today = new Date(2015, 4, 15);
today.advance(32);
System.out.println(today.y + "-" + today.m + "-" + today.d);

// The execution should print 2014-05-17
```

#### Problem

- This data representation admits **improper** values
	- ie. m = 0
	- Or m = 2 && d = 30
- Constructors and methods can and should be coded to avoid improper values
	- **Note:** Code above already throws exception
	- `Date today = new Date(2014, 2, 30);`
		- Only 28 days in Feb, 29 if leap year
- But what if the data representation is accessed directly?

``` java
Date today = new Date(2015, 2, 14);
today.d += 16;
```

- A different data representation is possible:

##### Day-in-epoch

``` java
public class Date {

	// Each Date value is a past, present, or future date.
	// This date is represented by a day-in-epoch number e,
	// Where 0 represents 1 January 2000

	// The only field in class
	public int e;

	public Date(int y, int m, int d) {
		// ... Constructor here
	}

	public void advance(int n) {
		// ... advance() method here
	}
}
```

- This makes `advance` faster, but `Date()` slower
- Recall existing application code:

``` java
Date today = new Date(2015, 2, 14);
today.advance(16);
System.out.println(today.y + "-" + today.m + "-" + today.d);

// today.y fails to compine since there is no y instance variable in the epoch example above
// today.m fails to compine since there is no m instance variable in the epoch example above
// today.d would yield wrong value
```

### Public vs. private data representation

- If the data representation is **public:**
	- Application code might make improper values
	- Existing application code might be invalidated by change of representation
		- Tightly coupled
- If the data representation is **private:**
	- Application code cannot make improper values
	- Existing application code cannot be invalidated by change of representation
		- Loosely coupled

## Abstract data type (ADT)

- An abstract data type is characterised by:
	- A set of values
	- A set of operations
- It is not characterised by its data representation
- The data representation is **private** in this case, so application code cannot access it
	- Only the operations can
- The data representation is **changeable**, with no effect on application code
	- Only the operations must be recoded

### ADT specification

- Each ADT should have a **contract** that
	- Specifies the set of values of the ADT
	- Specifies each operation of the ADT
		- ie. The operation's name
		- Parameter type/s
		- Result type
		- Observable behaviour
- The contract **does not** specify the data representation
	- Nor the algorithms used to implement the operations
- The **observable behavior** of an operation is its effect as **observed** by the application code
	- Example of observable behaviour
		- Search an array
	- Examples of algorithms with that behavior
		- Linear search
		- Binary search

### ADT specification overview

- The **contract** specifies the set of values of the ADT, and describes the name/s, parameter type/s, result type/s, and observable behavior of operation/s
- The **ADT designer** works on providing a contract (or Java interface) of an ADT
- The **ADT programmer** works on providing an implementation (a Java class) of the ADT, according to the contract
- The **Application programmer** works on writing a program using the operations in an implemented ADT (a Java class) to process values of the ADT specified in the contract

#### Separation of concerns

- The **ADT designer** is not concerned with how the ADT will be implemented
- The **ADT programmer** is not concerned with what applications the ADT is used for
- The **Application programmer** is not concerned with how the ADT class is implemented
- Separation of concerns is essential for designing and implementing large systems
	- Portability and reusability

### Example: Contract for `Date` ADT

- Assumed application requirements:
	1. The values must be all past, present, and future dates
	2. It must be possible to construct a date from year number y, month number m, and day-in-month number d
	3. It must be possible to compare dates
	4. It must be possible to render a date in ISO formate "y-m-d"
	5. It must be possible to advance a date by n days

#### Possible contract as outline class declaration

``` java
public class Date {

	// 1. The values must be all past, present, and future dates
	private int y;
	private int d;
	private int m;

	// 2. It must be possible to construct a date from year number y, month number m, and day-in-month number d
	public Date(int y, int m, int d) {
		// ... constructor
	}

	// 3. It must be possible to compare dates
	public int compareTo(Date that) {
		// Return -1 if this date is earlier than that
		// Or 0 if this date is equal to that
		// Or +1 if this date is later than that
	};

	// 4. It must be possible to render a date in ISO formate "y-m-d"
	@Override
	public String toString() {
		// Return this date rendered in ISO format
	}

	// 5. It must be possible to advance a date by n days
	public void advance(int n) {
		// Advance this date by n days (where n >= 0)
	}
}
```

### ADT implementation

- An implementation of an ADT entails
	- Choosing a data representation
	- Choosing an algorithm for each operation
- The data representation
	- Must be private
	- Must cover all possible values
- The algorithms must be consistent with the data representation

#### Example: First implementation of `Date` ADT

##### Class declaration

``` java
public class Date {

	// 1. The values must be all past, present, and future dates

	// This date is represented by a year number y,
	// A month number m,
	// And a day-in-month number d

	private int y;
	private int m;
	private int d;

	// 2. It must be possible to construct a date from year number y, month number m, and day-in-month number d
	public Date(int y, int m, int d) {
		this.y = y;
		this.m = m;
		this.d = d;
	}

	// 3. It must be possible to compare dates
	public int compareTo(Date that) {
		// Return -1 if this date is earlier than that
		// Or 0 if this date is equal to that
		// Or +1 if this date is later than that

		return (
			this.y < that.y ? -1 :
			this.y > that.y ? +1 :
			this.m < that.m ? -1 :
			this.m > that.m ? +1 :
			this.d < that.d ? -1 :
			this.d > that.d ? +1 : 0
		);
	}

	// 4. It must be possible to render a date in ISO formate "y-m-d"
	@Override
	public String toString() {
		// Return this date rendered in ISO format

		return (this.y + "-" + this.m + "-" + this.d);
	}

	// 5. It must be possible to advance a date by n days
	public void advance(int n) {
		// Advance this date by n days (where n >= 0)

		int y = this.y;
		int m = this.m;
		int d = this.d + n;

		// no. of days in m/y
		int last;

		while(d > (last = length(m, y))) {
			d -= last;

			if(m < 12) {
				m++;
			} else {
				m = 1;
				y++;
			}
		}
		this.y = y;
		this.m = m;
		this.d = d;
	}
}
```

#### Example: Second implementation of `Date` ADT

##### Class declaration

``` java
public class Date {

	// 1. The values must be all past, present, and future dates

	// ** DAY IN EPOCH **
	// This date is represented by a day-in-epoch number e,
	// where 0 represents 1 January 2000, negative for earlier dates,
	// and positive for later date

	private int e;

	// 2. It must be possible to construct a date from year number y, month number m, and day-in-month number d
	public Date(int y, int m, int d) {

		// Construct a date with year y, month m, day-in-month d
		// Throw an exception if they constitute an improper date
		if(m < 1 || m > 12 || d < 1 || d > length(m, y)) {
			throw new IllegalArgumentException("Improper date!");
		}

		int e = d - 1;

		// Add lengths of months 1 through m - 1 in year y
		for(int k = 1; k < m; k++) {
			e += length(k, y);
		}

		// Add lengths of years 2000 through y - 1
		e += 365 * (y - 2000);

		// Adjust for leap years...
		if(y > 2000) {
			e += (y - 2001) / 4 - (y - 2001) / 100 + (y - 2001) / 400 + 1;
		} else {
			e += (y - 2000) / 4 - (y - 2000) / 100 + (y - 2000) / 400;
		}

		this.e = e;
	}

	// 3. It must be possible to compare dates
	public int compareTo(Date that) {
		// Return -1 if this date is earlier than that
		// Or 0 if this date is equal to that
		// Or +1 if this date is later than that

		return(
			this.e < that.e ? -1 :
			this.e > that.e ? +1 : 0
		);
	}

	// 4. It must be possible to render a date in ISO formate "y-m-d"
	@Override
	public String toString() {
		// Return this date rendered in ISO format

		int y = 2000;
		int m = 1;
		int d = this.e + 1;
		int last;

		if(d > 0) {
			while(d > (last = (isLeap(y) ? 366 : 365))) {
				y++;
				d -= last;
			}
		} else {
			do {
				y--;
				d += (isLeap(y) ? 366 : 365);
			} while(d <= 0);
		}
		while(d > (last = length(m, y))) {
			m++;
			d-= last;
		}
		return (y + "-" + m + "-" + d);
	}

	// 5. It must be possible to advance a date by n days
	public void advance(int n) {
		// Advance this date by n days (where n >= 0)
		this.e += n;
	}

	/********************
	* Auxiliary methods *
	*********************/

	// Return the number of days in months m in year y
	private static int length(int m, int y) {
		switch(m) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				return 31;
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2:
				return(isLeap(y)? 29:28);
		}
	}

	// Return true if and only if y is a leap year.
	private static boolean isLeap(int y) {
		return(y % 4 == 0 && (y % 100 != 0 || y % 400 == 0));
	}
}
```

### ADT design

- Operations are **sufficient** if together they meet all the ADTs requirements
	- **Question to ask:** Can the application be written entirely in terms of calls to these operations?
- An operation is **necessary** if it is not surplus to the ADTs requirements
	- **Question to ask:** Could the operation be safely omitted?
- A well-designed ADT provides operations that are necessary and sufficient for its requirements
- A **constructor** is an operation that creates a value of the ADT
- An **accessor** is an operation that uses a value of the ADT to compute a value of some other type
- A **transformer** is an operation that computes a new value of the same ADT
- A well designed ADT
	- Provides
		- At least one constructor
		- At least one accessor
		- At least one transformer
	- The constructors and transformers together can generate all values of the ADT

#### Example: Design of `Date` ADT

- Recall the `Date` contract of the previous examples:

``` java
public class Date {

	// ... instance variables

	public Date(int y, int m, int d) {
		// Constructor
	}

	public int compareTo(Date that) {
		// Accessor
	}

	public String toString() {
		// Accessor
	}

	public void advance(int n) {
		// Transformer
	}
}
```

- These operations are sufficient
- All these operations are necessary
- Consider another possible `Date` contract:

``` java
public class Date {

	// ... instance variables

	public Date(int y, int m, int d) {
		// Constructor
	}

	public int compareTo(Date that) {
		// Accessor
	}

	public String toString() {
		// Accessor
	}

	public void advance(int n) {
		// Transformer
	}

	public void advance1Day() {
		// Unnecessary
		// Already implemented by advance()
	}
}
```

### Example contract: Polynomial class

``` java
class Polynomial {

	// instance variables
	final static private int mantissa = 52;
	final static private double epsilon = Math.pow(2.0,-mantissa);
	private double coefficient = 0.0;
	private int power = 0;
	private Polynomial successor = null;

	// constructor
	public Polynomial(double coefficient, int power);

	// methods
	private void add(Polynomial p, double coefficient, int power);

	public int cardinality();

	public Polynomial clone();

	public double coefficient(int power);

	public Polynomial composite(Polynomial that);

	public int degree();

	public Polynomial differentiate();

	public Polynomial[] dividedBy(Polynomial that);

	public boolean equals(Polynomial that);

	public double evaluate(double variable);

	public Polynomial integrate();

	public Polynomial minus(Polynomial that);

	public Polynomial plus(Polynomial that);

	public int powerMax();

	public int powerMin();

	public Polynomial times(Polynomial that);

	public String toString();
}
```

## ADTs in the Java class library

- Java Collection framework (simplified)

![java collection framework](http://snag.gy/FiYdV.jpg)

## Study guide

- Reading
	- Chapter 5: Java Collections
	- Chapter 2 & 5: Data Structures and Algorithms
