# Writing instantiable classes

## Object-oriented programming

- Object-oriented programming is centered on creating objects rather than procedures
- Objects are a melding of data and procedures that manipulate that data
- Data in an object are known as fields
- Procedures in an object are known as methods

![object model 1](http://snag.gy/viM4c.jpg)

- Object-oriented programming combines data and behaviour via *encapsulation*
- *Data hiding* is the ability of an object to hide data from other objects in the program
- Only an object's methods should be able to directly manipulate its data
- Other objects are allowed to manipulate an object's data via the object's methods

![object model 2](http://snag.gy/Jr9Dz.jpg)

### Data hiding

- Data hiding is important for several reasons
	- It protects the data from accidental corruption by outside objects
	- It hides the details of how an object works, so the programmer can concentrate on using it
	- It allows the maintainer of the object to have the ability to modify the internal functioning of the object without *breaking* someone else's code

### Code reusability

- Object-oriented programming has encouraged object reusability
- A software object contains data and methods that represents a specific concept or service
- An object is not a stand-alone program
- Objects can be used by programs that need the object's service
- Reuse of code promotes the rapid development of larger software projects

## An everyday example of an object: An alarm clock

- Fields define the state that the alarm is currently in
	- The current second: a value between 0 - 59
	- The current minute: a value between 0 - 59
	- The current hour: a value between 1 - 12
	- The time the alarm is set for: a valid hour and minute
	- Whether the alarm is on or off: on or off
- Methods are used to change a field's value
	- Public methods: accessed by users outside the object
		- Set time
		- Set alarm
		- Turn alarm on
		- Turn alarm off
	- Private methods: part of the object's internal design
		- Increment the current second
		- Increment the current minute
		- Increment the current hour
		- Sound alarm

## Classes and objects

- The programmer determines the fields and methods needed, and then creates a class
- A class can specify the fields and methods that a particular type of object may have
- A class is a *blueprint* that objects may be created from
- A class is not an object, but it can be a description of an object
- An object created from a class is called an *instance* of the class

![incorrect class & object](http://snag.gy/9cVIV.jpg)

![correct class & object](http://snag.gy/5PINr.jpg)

## Classes

From chapter 2, we learned that a reference variable contains the address of an object.

``` java
String cityName = "Charleston";
```

![String charleston](http://snag.gy/NKgMO.jpg)

The `length()` method of the `String` class returns an integer value that is equal to the length of the string

``` java
int stringLength = cityName.length();
```

Class objects normally have methods that perform useful operations on their data.

Primitive variables can only store data and have no methods.

## Classes and instances

Many objects can be created from class.

Each object is independent of the others.

``` java
String person = "Jenny";
String pet = "Fido";
String favouriteColor = "Blue";
```

![class instance](http://snag.gy/xsIBB.jpg)

- Each instance of the `String` class contains different data
- The instances all share the same design
- Each instance has all of the attributes and methods that were defined in the `String` class
- Classes are defined to represent a single concept or service

## Building a `Rectangle` class

- A `Rectangle` class will have the following fields
	- `length`: will hold the rectangle's length
	- `width`: will hold the rectangle's width
- A `Rectangle` class will also have the following methods
	- `setLength`: will store a value in an object's `length` field
	- `setWidth`: will store a value in an object's `width` field
	- `getLength`: will return the value in an object's `length` field
	- `getWidth`: will return the value in an object's `width` field
	- `getArea`: will return the area of the rectangle, which is the result of the object's `length` multiplied by its `width`

## UML diagram

Unified Modelling Language (UML) provides a set of standard diagrams for graphically depicting object-oriented systems.

![uml](http://snag.gy/mCEGL.jpg)

### UML for `Rectangle` class

![uml rectangle](http://snag.gy/IsbMu.jpg)

## Writing code for the class fields

``` java
public class Rectangle {
	
	private double length;
	private double width;
}
```

## Access specifiers

- An access specifier is a Java keyword that indicates how a field or method can be accessed
- `public`
	- When the `public` access specifier is applied to a class member, the member can be accessed by code inside or outside the class
- `private`
	- When the `private` access specifier is applied to a class member, the member cannot be accessed by code outside the class
	- The member can be accessed only by methods that are members of the same class

## Header for the `setLength` method

![setLength](http://snag.gy/uZXYx.jpg)

## Writing and demonstrating the `setLength` method

``` java
/**
 * The setLength method stores a value in the length field.
 * 
 * @param len The value to store in length.
 */

public void setLength(double len) {

	length = len;
}
```

See `Rectangle.java` and `LengthDemo.java`

## Creating a `Rectangle` object

``` java
Rectangle box = new Rectangle();
```

![new rectangle object](http://snag.gy/g1eVd.jpg)

## Calling the `setLength` method

``` java
box.setLength(10.0);
```

![call setLength](http://snag.gy/UG2NI.jpg)

This is the state of the box object after `setLength` method executes.

## Writing the `getLength` method

``` java
/**
 * The getLength method returns a Rectangle object's length.
 * 
 * @return double getLength()
 */
public double getLength() {
	
	return length;
}
```

Similarly, the `setWidth` and `getWidth` methods can be created.

See `Rectangle.java` and `LengthWidthDemo.java`

## Writing and demonstrating the `getArea` method

``` java
/**
 * The getArea method returns a Rectangle object's area.
 * 
 * @return double getArea()
 */
 public double getArea() {

 return length * width;
 }
```

See `Rectangle.java` and `RectangleDemo.java`

## Accessor and mutator methods

- Because of the concept of data hiding, fields in a class are private
- The methods that retrieve the data of fields are called *accessors*
- The methods that modify the data of fields are called *mutators*
- Each field that the programmer wishes to be viewed by other classes needs an accessor
- Each field that the programmer wishes to be modified by other classes needs a mutator
- Also known as *getters* and *setters*

### `Rectangle` accessors and mutators

- Mutators / setters
	- `setLength`
	- `setWidth`
- Accessors / getters
	- `getLength`
	- `getWidth`

## Stale data

- Some data is the result of a calculation
- Consider the area of a rectangle
	- *length* * *width*
- It would be impractical to use an `area` variable here
- Data that requires the calculation of various factors has the potential to be come *stale*
- To avoid stale data, it is best to calculate the data within a method, rather than store it in a variable

Rather than use an `area` variable in a `Rectangle` class,

``` java
public double getArea() {
	return length * width;
}
```

This dynamically calculates the value of the rectangle's area when the method is called.

Any change to the `length` or `width` variables will not leave the area of the rectangle stale.

## UML data type and parameter notation

UML diagrams are language independent.

UML diagrams use an independent notation to show return types, access modifiers etc.

![uml notation 1](http://snag.gy/fw8MB.jpg)

![uml notation 2](http://snag.gy/EUEmd.jpg)

![uml notation 3](http://snag.gy/ktSRz.jpg)

![uml notation 4](http://snag.gy/DinHa.jpg)

## Converting the UML diagram to code

Putting all of this information together, a Java class file can be built easily using the UML diagram.

The UML diagram parts match the Java class file structure.

``` java
class header {
	fields
	methods
}
```

![uml structure simple](http://snag.gy/d7V5X.jpg)

The structure of the class can be compiled and tested without having bodies for the methods. Just be sure to put dummy return values for methods that have a return type other than void.

![uml structure complex](http://snag.gy/8eEWN.jpg)

``` java
// per the UML diagram

public class Rectangle {
	
	private double width;
	private double length;

	public void setWidth(double w) {

	}

	public void setLength(double len) {

	}

	public double getWidth() {
		return 0.0;
	}

	publci double getLength() {
		return 0.0;
	}

	public double getArea() {
		return 0.0;
	}
}
```

## Class layout conventions

- The layout of a source code file can vary by employer or instructor
- A common layout is:
	- Fields listed first
	- Methods listed second
		- Accessors and mutators are typically grouped together
- There are tools that can help in formatting layout to specific standards

## Instance fields and methods

- Fields and methods that are declared as previously shown are called *instance fields* and *instance methods*
- Objects created from a class each have their own copy of instance fields
- Instance methods are methdos that are *not* declared with a keyword `static`
- Instance fields and methods require an object to be created in order to be used
	- See `RoomAreas.java`
- Note that each room represented in this example have different dimensions

``` java
Rectangle kitchen = new Rectangle();
Rectangle bedroom = new Rectangle();
Rectangle den = new Rectangle();
```

## States of three different `Rectangle` objects

The `kitchen` variable holds the address of a `Rectangle` object.

![kitchen](http://snag.gy/cvcHe.jpg)

The `bedroom` variable holds the address of a `Rectangle` object.

![bedroom](http://snag.gy/X1zAw.jpg)

The `den` variable holds the address of a `Rectangle` object.

![den](http://snag.gy/1vgnB.jpg)

## Constructors

- Classes have special methods called *constructors*
- A constructor is a method that is *automatically* called when an object is created
- Constructors are used to perform operations at the time an object is created
- Constructors typically initialize instance fields and perform other object initialization tasks
- Constructors have a few specia properties that set them apart from normal methods
	- They have the same name as the class
	- They have no return type
		- Not even `void`
	- They may not return any values
	- They are typically public

### Constructor for `Rectangle` class

``` java
/**
 * Constructor.
 * 
 * @param len The length of the rectangle.
 * @param w The width of the rectangle.
 */
public Rectangle(double lne, double w) {
	length = len;
	width = w;
}
```

See `Rectangle.java` and `ConstructorDemo.java`

## Constructors in UML

In UML, the most common way constructors are defined is:

![uml constructor](http://snag.gy/kXgr5.jpg)

## Uninitialized local reference variables

- Reference variables can be declared without being initialized
	- `Rectangle box;`
- This statement does not create a `Rectangle` object, so it is an uninitialized local reference variable
- A local reference variable must reference an object before it can be used, otherwise a compile error will occur
	- `box = new Rectangle(7.0, 14.0);`
- `box` will now reference a `Rectangle` object of length 7.0 and width 14.0

## The default constructor

- When an object is created, its constructor is **always** called
- If you do not write a constructor, Java provides one when the class is compiled
- The constructor that Java provides is known as the *default constructor*
	- It sets all of the object's numeric fields to 0
	- It sets all of the object's `boolean` fields to `false`
	- It sets all of the object's reference variables to the special value `null`
- The default constructor with no parameters, used to initialize an object in a default configuration
- The only time that Java provides a default constructor is when you do not write **any** constructor for the class
	- See first version of `Rectangle.java`
- A default constructor is **not** provided by Java if a constructor is already written
	- See `Rectangle.java` with constructor

## Writing your own no-arg constructor

- A constructor that does not accept arguments is known as a *no-arg constructor*
- The default constructor provided by Java is a no-arg constructor
- We can write our own no-arg constructor

``` java
public Rectangle() {
	length = 1.0;
	width = 1.0;
}
```

## The `String` class constructor

- One of the `String` class constructors accepts a string literal as an argument
- This string literal is used to initialize a `String` object
- For instance:

``` java
String name = new String("Michael Jordan");
```

- This creates a new reference variable `name` that points to a `String` object that represents the name "Michael Jordan"
- Because they are used so often, `String` objects can be created with a shorthand:

``` java
String name = "Michael Jordan";
```

## Overloading methods and constructors

- Two or more methods in a class may have the same name as long as their parameter lists are different
- When this occurs, it is called *method overloading* and also applies to constructors
- Method overloading is important because sometimes you need several different ways to perform the same operation

### Overloading method `add`

``` java
public int add(int num1, int num2) {
	int sum = num1 + num2;
	return sum;
}

public String add(String str1, String str2) {
	String combined = str1 + str2;
	return combined;
}
```

## Method signature and binding

- A method signature consists of the method's name and the data types of the method's parameters, in the order that they appear
	- The return type is not part of the signature

``` java
// signatures of the add() methods from previous code chunk
add(int, int)
add(String, String)
```

- The process of matching a method call with the correct method is known as *binding*
- The compiler uses the method signature to determine which version of the overloaded method to bind the call to

### `Rectangle` class constructor overload

If we were to add the no-arg constructor we wrote previously to our `Rectangle` class in addition to the orignal constructor we wrote, what would happen when we execute the following calls?

``` java
Rectangle box1 = new Rectangle();
Rectangle box2 = new Rectangle(5.0, 10.0);
```

The first call would use the no-arg constructor and `box` would have a length of 1.0 and width of 1.0.

The second call would use the original constructor and `box2` would have a length of 5.0 and a width of 10.0.

## The `BankAccount` example

See `BankAccount.java` and `AccountTest.java`

![bankAccount](http://snag.gy/uPAOC.jpg)

## Scope of instance fields

- Variables declared as instance fields in a class can be accessed by an instance method in the same class as a field
- If an instance field is declared with th `public` access specifier, it can also be accessed by code outside the class, as long as an instance of the class exists

## Shadowing

- A parameter variable is, in effect a local variable
- Within a method, variable names must be unique
- A method may have a local variable with the same name as an instance field
- This is called *shadowing*
- The local variable will hide the value of the instance field
- Shadowing is discouraged and local variable names should not be the same as instance field names

## Packages and `import` statements

- Classes in the Java API are organised into *packages*
- Explicit and wildcard `import` statements
	- Explicit imports name a specific class
		 - `import java.util.Scanner;`
	- Wildcard imports name a package, followed by `*`
		- `import java.util.*;`
- The `java.lang` package is automatically made available to any Java class

## Some Java standard packages

![standard packages](http://snag.gy/dvhEn.jpg)

## Finding classes and their responsibilities

- Finding the classes
	- Get written description of the problem domain
	- Identify all nouns, each is a potential class
	- Refine list to include only classes relevant to the problem
- Identify responsibilities
	- Things a class is responsible for knowing
	- Things a class is responsible for doing
	- Refine list to include only classes relevant to the problem