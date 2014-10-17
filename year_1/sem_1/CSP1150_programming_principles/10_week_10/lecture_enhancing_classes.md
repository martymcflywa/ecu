# Enhancing classes

## Review of instance fields and methods

- Each instance of a class has its own copy of instance variables, for example
	- The `Rectangle` class defines a `length` and a `width` field
	- Each instance of the `Rectangle` class can have different values stored in its `length` and `width` fields
- Instance methods require that an instance of a class be created in order to be used
- Instance methods typically interact with instance fields or calculate values based on those fields

## Static class members

- *Static fields* and *static methods* do not belong to a single instance of a class
- To invoke a static method or use a static field, the class name, rather than the instance name is used, for example:

``` java
double val = Math.sqrt(25.0);
// Math = class name
// sqrt() = static method
```

## Static fields

Class fields are declared using the `static` keyword between the access specifier and the field type.

``` java
private static int instanceCount = 0;
```

- The field is initialized to 0 only once, regardless of the number of times the class is instantiated
	- Primitive static fields are initialized to 0 if no initialization is performed
- See `Countable.java` and `StaticDemo.java`

![instanceCount field](http://snag.gy/yMYEs.jpg)

## Static methods

Methods can also be declared static by placing the `static` keyword between the access modifier and the return type of the method.

``` java
public static double milesToKilometers(double miles) {
	
}
```

When a class contains a static method, it is not necessary to create an instance of the class in order to use the method.

``` java
kilosPerMile = Metric.milesToKilometers(1.0);
```

See `Metric.java` and `MetricDemo.java`

- Static methods are convenient because they may be called at the class level
- They are typically used to create utility classes, such as the `Math` class in the Java Standard Library
- Static methods may not communicate with instance fields, only static fields

## Passing objects as arguments

- Objects can be passed to methods as arguments
- Java passes all arguments by *value*
- When an object is passed as an agument, the value of the reference variable is passed
- A *copy* of the object is *not passed*, just a pointer to the object
- When a method receives a reference variable as an argument, it is possible for the method to modify the contents of the object referenced by the variable

![pass object](http://snag.gy/kj4bf.jpg)

## Returning objects from methods

- Methods are not limited to returning the primitive data types
- Methods can return references to objects as well
- Just as with passing arguments, a copy of the object is **not** returned, only its address
- See `ReturnObject.java`

``` java
public static BankAccount getAccount() {
	return new BankAccount(balance);
}
```

![return object](http://snag.gy/irIRz.jpg)

## The `toString` method

The `toString` method of a class can be called explicitly.

``` java
Stock xyzCompany = new Stock ("XYZ", 9.62);
System.out.println(xyzCompany.toString());
```

However, the `toString` method does not have to be called explicitly but is called implicitly whenever you pass an object of the class to `println` or `print`.

``` java
Stock xyzCompany = new Stock ("XYZ", 9.62);
System.out.println(xyzCompany);
```

The `toString` method is also called implicitly whenever you concatenate an object of the class with a string.

``` java
Stock xyzCompany = new Stock ("XYZ", 9.62);
System.out.println("The stock data is:\n" +
	xyzCompany);
```

- All objects have a `toString` method that returns the class name and a has of the memory address of the object
- We can override the default method with our own to print out more useful information
- See `Stock.java` and `StockDemo1.java`

## The `equals` method

- When the `==` operator is used with reference variables, the memory address of the objects are compared
- The contents of the objects are not compared
- All object have an `equals` method
- The default operation of the `equals` method is to compare memory addresses of the objects, just like the `==` operator


The `Stock` class has an `equals` method. If we try the following:

``` java
Stock stock1 = new Stock("GMX", 55.3);
Stock stock2 = new Stock("GMX", 55.3);

if(stock1 == stock2) { // error in condition
	System.out.println("The objects are the same.");
} else {
	System.out.println("The objects are not the same.")
}
```

Only the addresses of the objects are compared.

Instead of using the `==` operator to compare two `Stock` objects, we should use the `equals` method.

``` java
public boolean equals(Stock object2) {
	boolean status;

	if(symbol.equals(Object2.symbol && sharePrice == Object2.sharePrice)) {
		status = true;
	} else {
		status = false;
	}
	return status;
}
```

Now, objects can be compared by their contents rather than by their memory address.

See `StockCompare.java`

## Methods that copy objects

- There are two ways to copy an object
	- You cannot use the assignment operator to copy reference types
	- Reference only copy
		- This is simply copying the address of an object into another reference variable
	- Deep copy (correct)
		- This involves creating a new instance of the class and copying the values from on object into the new object
- See `ObjectCopy.java`

## Copy constructors

A copy constructor accepts an existing object of the same class and clones it.

``` java
public Stock(Stock object2) {
	symbol = object2.symbol;
	sharePrice = object2.sharePrice;
}

// Create a stock object
Stock company1 = new Stock("XYZ", 9.62);

// Create company2, a copy of company1
Stock company2 = new Stock(company1);
```

## Aggregation

- Creating an instance of one class as a reference in another class is called *object aggregation*
- Aggregation creates a *has a* relationship between objects
- See `Instructor.java`, `Textbook.java`, `Course.java` and `CourseDemo.java`

![aggregation uml](http://snag.gy/24u8d.jpg)

## Returning references to private fields

- Avoid returning references to private data elements
- Returning references to private variables will allow any object that receives the references to modify the variable

## Null references

- A *null reference* is a references variable that points to nothing
- If a reference is null, then no operations can be performed on it
- References can be tested to see if they point to null prior to being used

``` java
if(name != null) {
	System.out.println("Name is: " + name.toUpperCase());
}
```

See `FullName.java` and `NameTester.java`

## The `this` reference

- The `this` reference is simply a name that an object can use to refer to itself
- The `this` reference can be used to overcome shadowing and allow a parameter to have the same name as an instance field

``` java
public void setFeet(int feet) {
	this.feet = feet;
	// sets the this instance's feet field
	// equal to the parameter feet
}
```

The `this` reference can be used to call a constructor from another constructor.

``` java
public Stock(String sym) {
	this(sym, 0.0);
}
```

- This constructor would allow an instance of the `Stock` class to be created only the symbol name as a parameter
- It calls the constructor that takes the symbol and the price, using `sym` as the symbol argument and 0 as the price argument
- Elaborate constructor chaining can be created using this technique
- If `this` is used in a constructor, it must be ther first statement in the constructor

## Enumerated types

Known as the `enum`, requires declaration and definition like a class.

``` java
enum typeName {one or more enum constants}
```

Definition:

``` java
enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY}
```

Declaration:

``` java
Day WorkDay; // creates a Day enum
```

Assignment:

``` java
Day WorkDay = Day.WEDNESDAY;
```

An `enum` is a specialized class.

![enum model](http://snag.gy/nJngl.jpg)

## Enumerated types - methods

- `toString` returns name of the calling constant
- `ordinal` returns the zero-based position of the constant in the `enum
	- For example, the ordinal for `Day.THURSDAY` is 4
- `equals` accepts an object as an argument and returns true if the argument is equal to the calling `enum` constant
- `compareTo` accepts an object as an argument and returns a negative integer if the calling constant's ordinal is < than the argument's ordinal, a positive integer if the calling constant's ordinal is > than the argument's ordinal, and zero if the calling constant's ordinal `==` the argument's ordinal
- See `EnumDemo.java`, `CarType.java`, `SportsCar.java` and `SportsCarDemo.java`

## Enumerated types - switching

Java allows you to test an enum constant with a `switch` statement.

See `SportsCarDemo2.java`

## Garbage collection

- When objects are no longer needed they should be destroyed
- This frees up the memory that they consumed
- Java handles all of the memory operations for you
- Simply set the reference to `null` and Java will reclaim the memory
- The Java Virtual Machine has a process that runs in the background that reclaims memory from released objects
- The *garbage collector* will reclaim memory from any object that no longer has a valid reference pointing to it

``` java
BankAccount account1 = new BankAccount(500.0);
BankAccount account2 = account1;
```

This sets `account1` and `account2` to point to the same object.

![garbage collector 1](http://snag.gy/pT3Aa.jpg)

Here, both `account1` and `account2` point to the same instance of the `BankAccount` class

![garbage collector 2](http://snag.gy/PqUNc.jpg)

However, by running the statement `account1 = null;` only `account2` will be pointing to the object.

![garbage collector 3](http://snag.gy/ppCy5.jpg)

If we now run the statement `account2 = null;` neither `account1` or `account2` will be pointing to the object.

![garbage collector 4](http://snag.gy/fw8fD.jpg)

## The `finalize` method

- If a method with the signature: `public void finalize(){...}` is included in a class, it will run just prior to the garbage collector reclaiming its memory
- The garbage collector is a background thread that runs periodically
- It cannot be determined when the `finalize` method will actually be run

## Class collaboration

- Collaboration is when two classes interact with each other
- If an object is to collaborate with another object, it must know something about the second object's methods and how to call them
- If we design a class `StockPurchase` that collaborates with the `Stock` class, we define it to create and manipulate a `Stock` object
- See `StockPurchase.java` and `StockTrader.java`

## CRC Cards

- Class, Responsibilities and Collaborations (CRC) cards are useful for determining and documenting a class's responsibilities
	- The things a class is responsible for knowing
	- The actions a class is responsible for doing
- CRC card layout example

![crc](http://snag.gy/Vz7lQ.jpg)

