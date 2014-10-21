# Inheritance

## What is inheritance

Generalisation vs. specialisation.

- Real life objects are typically specialized versions of other more general objects
- The term *insect* describes a very general type of creature with numerous characteristics
- Grasshoppers and bumblebees are insects
	- They share the general chaacteristics of an insect
	- However, they have special characteristics of their own
		- Grasshoppers have a jumping ability
		- Bumblebees have a stinger
- Grasshoppers and bumblebees are specialized versions of an insect

![insects](http://snag.gy/lFozx.jpg)

## The "is a" relationship

- The relationship between a superclass and an inherited class is called an "is a" relationship
	- A grasshopper "is an" insect
	- A poodle "is a" dog
	- A car "is a" vehicle
- A specialized object has:
	- All of the characteristics of the general object, plus
	- Additional characteristics that make it special
- In object oriented programming, *inheritance* is used to create an "is a" relationship among classes
- We can *extend* the capabilities of a class
- Inheritance involves a superclass and a subclass
	- The superclass is the general class
	- The subclass is the specialized class
- The subclass is based on, or extended from, the superclass
	- Superclasses are also called base classes, and
	- Subclasses are also called derived classes
- The relationship of classes can be thought of as parent classes and child classes

## Inheritance

- The subclass inherits fields and methods from the superclass without any of them being rewritten
- New fields and methods may be added to the subclass
- The Java keyword `extends` is used on the class header to define the subclass

``` java
public class FinalExam extends GradedActivity {
	
}
```

### The `GradedActivity` example

![GradedActivity](http://snag.gy/TQ0iN.jpg)

- See:
	- `GradedActivity.java`
	- `GradeDemo.java`
	- `FinalExam.java`
	- `FinalExamDemo.java`

## Inheritance, fields and methods

- Members of the superclass that are marked private:
	- Are not inherited by the subclass
	- Exist in memory when the object of the subclass is created
	- May only be accessed from the subclass by public methods of the superclass
- Members of the superclass that are marked public:
	- Are inherited by the subclass, and
	- May be directly accessed from the subclass
- When an instance of the subclass is created, the non-private methods of the superclass are available through the subclass object

``` java
FinalExam exam = new FinalExam();
exam.setScore(85.0);
System.out.println("Score = " + exam.getScore());
```

Non-private methods and fields of the superclass are available.

``` java
setScore(newScore);
```

## Inheritance and constructors

- Constructors are not inherited
- When a subclass is instantiated, the superclass default constructor is executed first
- See:
	- `SuperClass1.java`
	- `SubClass1.java`
	- `ConstructorDemo1.java`

## The Superclass constructor

- The `super` keyword refers to an object's superclass
- The superclass constructor can be explicityly called from the subclass using the `super` keyword
- See:
	- `SuperClass2.java`
	- `SubClass2.java`
	- `ConstructorDemo2.java`
	– `Rectangle.java`
	- `Cube.java`
	- `CubeDemo.java`

## Calling the superclass constructor

- If a parameterized constructor is defined in the superclass:
	- The superclass must provide a no-arg constructor, or
		- Subclasses must provide a constructor, and
		- Subclasses must call a superclass constructor
- Calls to a superclass constructor must be the first java statement in the subclass constructors

## Overriding superclass methods

- A subclass may have a method with the same signature as a superclass method
- The subclass method overrides the superclass method
- This is known as *method overriding*
- See:
	- `GradedActivity.java`
	- `CurvedActivity.java`
	- `CurvedActivityDemo.java`

![override](http://snag.gy/yyi4E.jpg)

- Recall that a method's *signature* consists of:
	- The method's name
	- The data types method's parameters in the order that they appear
- A subclass method that overrides a superclass method must have the same signature as the superclass method
- An object of the subclass invokes the subclass's version of the method, not the superclass's
- A subclass method can call the overriden superclass method via the super keyword

``` java
super.setScore(rawScore * percentage);
```

- There is a distinction between overloading a method and overriding a method
- Overloading is when a method has the same name as one or more other methods, but with a different siganture
- When a method overrides another method, however, they both have the same signature
- Both overloading and overriding can take place in an inheritance relationship
- Overriding can only take place in an inheritance relationship
- See:
	- `Superclass3.java`
	- `SubClass3.java`
	- `ShowValueDemo.java`

## Preventing a method from being overriden

The `final` modifier will prevent the overriding of a superclass method in a subclass.

``` java
public final void message() {
	
}
```

- If a subclass attempts to override a final method, the compiler generates an error.
- This ensures that a particular superclass method is used by subclasses rather than a modified version of it

## Protected members

- Protected members of class
	- May be accessed by methods in a subclass, and
	- By methods in the same package as the class
- Java provides a third access specification `protected`
- A protected member's access is somewhere between private and public
- See:
	- `GradedActivity2.java`
	- `FinalExam2.java`
	- `ProtectedDemo.java`
- Using `protected` instead of `private makes some tasks easier
- However, any class that is derived from the class, or is in the same package, has unrestricted access to the protected member
- It is always better to make all fields `private` and then provide `public` methods for accessing those fields
- If no access specifier for a class member is provided, the class member is given package access by default
- Any method in the same package may access the member

## Access specifiers

![access specifiers](http://snag.gy/adfpk.jpg)

## Chain of inheritance

A superclas can also be derived from another class.

![chain of inheritance](http://snag.gy/jgbw3.jpg)

- Classes often are depicted graphically in a class hierarchy
- A class hierarchy shows the inheritance relationships between classes

![class hierarchy](http://snag.gy/eV57x.jpg)

## The `Object` class

- All Java classes are directly or indirectly derived from a class named `Object`
- `Object` is in the `java.lang` package
- Any subclass that does not specify the `extends` keyword is automatically derived from the `Object` class

``` java
public class MyClass {
	// this class is derived from Object
}
```

- Ultimately, every class is derived from `Object` class
- Because every class is directly, or indirectly derived from the `Object` class
	- Every class inherits the `Object` class's members
		- ie. `toString` and `equals`
- In the `Object` class, the `toString` method returns a string containing the object's class name and a hash of its memory address
- The `equals` method accepts the address of an object as its argument and returns true if it is the same as the calling object's address
- See `ObjectMethods.java`

## Polymorphism

- A reference variable can reference objects of classes that are derived from the variable's class
	- `GradedActivity exam;`
- We can use the exam variable to reference a `GradedActivity` object
	- `exam = new GradedActivity();`
- The `GradedActivity` class is also used as the superclass for `FinalExam` class
- An object of the `FinalExam` class is a `GradedActivity` object
- A `GradedActivity` variable can be used to reference a `FinalExam` object
	- `GradedActivity exam = new FinalExam(50, 7);`
- This statement creates a `FinalExam` object and stores the object's address in the exam variable
- This is an example of polymorphism
- The term polymorphism means the ability to take many forms
- In Java, a reference variable is polymorphic because it can reference objects of types different from its own, as long as those types are subclasses of its type

### Other legal polymorphic references

``` java
GradedActivity exam1 = new FinalExam(50, 7);
GradedActivity exam2 = new PassFailActivity(70);
GradedActivity exam3 = new PassFailExam(100, 10, 70);
```

- The `GradedActivity` class has three methods:
	- `setScore`, `getScore` and `getGrade`
- A `GradedActivity` variable can be used to call only those three methods

``` java
GradedActivity exam = new PassFailExam(100, 10, 70);
System.out.println(exam.getScore()); // works
System.out.println(exam.getGrade()); // works
System.out.println(exam.getPointsEach()); // error!
```

### Polymorphism and dynamic binding

- If the object of the subclass has overriden a method in the superclass
	- If the variable makes a call to that method, the subclass's version of the method will be run

``` java
GradedActivity exam = new PassFailActivity(60);
exam.setScore(70);
System.out.println(exam.getGrade());
```

- Java performs dynamic binding or late binding when a variable contains a polymorphic reference
- The Java Virtual Machine determines at runtime which method to call, depending on the type of object that the variable references

### Polymorphism

- It is the object's type, rather than the reference type, that determines which method is called
	- See `Polymorphic.java`
- You cannot assign a superclass object to a subclass reference variable

## Abstract classes

- An abstract class cannot be instantiated, but other classes are derived from it
- An abstract class serves as a superclass for other classes
- The abstract class represents the generic or abstract form of all the classes that are derived from it
- A class becomes abstract when you place the abstract keyword in the class definition

``` java
public abstract class ClassName {
	
}
```

## Abstract methods

- An abstract method has no body and must be overriden in a subclass
- An abstract method is a method that appears in a superclass, but expects to be overriden in a subclass
- An abstract method has only a header and no body

``` java
AccessSpecifier abstract ReturnType MethodName(ParameterList);
```

See `Student.java`, `CompSciStudent.java`, `CompSciStudentDemo.java`

Notice that the keyword `abstract` appears in the header, and that the header ends with a semicolon.

``` java
public abstract void setValue(int value);
```

- Any class that contains an abstract method is automatically abstract
- If a subclass fails to override an abstract method, a compiler error will result
- Abstract methods are used to ensure that a subclass implements the method

## Interfaces

- An interface is similar to an abstract class that has all abstract methods
	- It cannot be instantiated, and
	- All of the methods listed in an interface must be written elsewhere
- The purpose of an interface is to specify behaviour for other classes
- An interface looks similar to class except
	- The keyword `interface` is used instead of the keyword `class`
	- The methods that are specified in an interface have no bodies, only headers that are terminated by semicolons
- The general format of an interface definiton:

``` java
public interface InterfaceName {
	(Method headers...)
}
```

- All methods specified by an interface are public by default
- A class can implement one or more interfaces
- If a class implements an interface, it uses the `implements` keyword in the class header

``` java
public class FinalExam3 extends GradedActivity implements Relatable {
	
}
```

See `GradedActivity.java`, `Relatable.java`, `FinalExam3.java`, `InterfaceDemo.java`

## Fields in interfaces

- An interface can contain field declarations
	- All fields in an interface are treated as `final` and `static`
- Because they automatically become `final`, you must provide an initialization value

``` java
public interface Doable {
	int FIELD1 = 1;
	int FIELD2 = 2;
	(method headers...)
}
```

- In this interface, `FIELD1` and `FIELD2` are `final static int` variables
- Any class that implements this interface has access to these variables

## Implementing multiple interfaces

- A class can be derived from only one superclass
- Java allows a class to implement multiple interfaces
- When a class implements multiple interfaces, it must provide the methods specified by all of them
- To specify multiple interfaces in a class definition, simply list the names of the interfaces, separated by commans, after the `implements` keyword

``` java
public class MyClass implements Interface1, Interface2, Interface3 {
	
}
```

## Interfaces in UML

![interface uml](http://snag.gy/1sArL.jpg)

## Polymorphism with interfaces

- Java allows you to create reference variables of an interface type
- An interface reference variable can reference any object that implements that interface, regardless of its class type
- This is another example of polymorphism
- See:
	- `RetailItem.java`
	- `CompactDisc.java`
	- `DvdMovie.java`
	- `PolymorphicInterfaceDemo.java`
- In the example code, two `RetailItem` reference variables, `item1` and `item2` are declared
- The `item1` variable references `CompactDisc` object and the `item2` varaible references a `DvdMovie` object
- When a class implements an interface, an inheritance relationship known as interface inheritance is established
	- A `CompactDisc` object is a `RetailItem`, and
	- A `DvdMovie` object is a `RetailItem`
- A reference to an interface can point to any class that implements that interface
- You cannot create an instance of an interface

``` java
RetalItem item = new RetailItem(); // error
```

- When an interface variable references an object
	- Only the methods decalred in teh interface are available
	- Explicit type casting is required to access the other methods of an object referenced by an interface reference