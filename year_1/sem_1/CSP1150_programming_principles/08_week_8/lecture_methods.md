# Methods

## Why write methods?

- Methods are commonly used to break a problem down into small manageable pieces
	- This is called *divide and conquer*
- Methods simplify programs
	- If a specific task is performed in several places in the program, a method can be written once to perform that task, and then be executed any time it is needed
	- This is known as *code reuse*

## `void` methods and value-returning methods

- A `void` method is one that simply performs a task and then terminates
	- `System.out.println("Hi!");`
- A value-returning method not only performs a task, but also sends a value back to the code that called it
	- `int number = Integer.parseInt("700");`

## Defining a `void` method

- To create a method, you must write a definition, which consists of a *header* and a *body*
- The method header, which appears at the beginning of a method definition, lists several important things about the method, including the method's name
- The method body is a collection of statements that are performed when the method is executed

## Two parts of a method declaration

``` java
public static void displayMessage() // header
{
	System.out.println("Hello"); // body
}
```

``` java
public static void displayMessage()
// public static = method modifiers
// void = return type
// displayMessage  = method name
// () = parenthesis
```

- Method modifiers
	- `public`: the method is publicly available to code outside the class
	- `static`: method belongs to a class, not a specific object
- Return type
	- `void`: does not return anything
	- Can also be `int`, and the method must return an int etc.
- Method name
	- A name that is descriptive of what the method does
- Parenthesis
	- Contains nothing, or a list of one or more variable declarations if the method is capable of receiving arguments

## Calling a method

- A method executes when it is called
- The `main` method is automatically called when a program starts, but other methods are executed by method call statements
	- `displayMessage();`
- Notice that the method modifiers and the `void` return type are not written in the method call statement
	- Those are only written in the method header
- See `SimpleMethod.java`, `LoopCall.java`, `CreditCard.java` and `DeepAndDeeper.java`

## Documenting methods

- A method should always be documented by writing comments that appear just before the method's definition
- The comments should provide a brief explanation of the method's purpose
- The documentation comments begin with `/**` and end with `*/`

## Passing arguments to a method

Values that are sent into a method are called arguments

``` java
System.out.println("Hello");
number = Integer.parseInt(str);
```

- The data type of an argument in a method call must correspond to the variable declaration in the parenthesis of the method declaration
	- The parameter is the variable that holds the value being passed into a method
- By using parameter variables in your method declarations, you can design your own methods that accept data this way
- See `PassArg.java`

## Passing 5 to the `displayValue` method

``` java
displayValue(5);

public static void displayValue(int num) {
	System.out.println("The value is " + num);
}
```

The method above will display `The value is 5`

## Argument and parameter data type compatibility

- When you pass an argument to a method, be sure that the argument's data type is compatible with the parameter variable's data type
- Java will automatically perform widening conversations, but narrowing conversations will cause a compiler error

``` java
double d = 1.0;
displayValue(d); // error, can't conver double to int
```

## Passing multiple arguments

``` java
showSum(5, 10);

public static void showSum(double num1, double num2) {
	double sum;
	sum = num1 + num2;
	System.out.println("The sum is " + sum);
}
```

## Arguments are passed by value

- In Java, all arguments of the primitive data types are *passed by value*, which means that only a copy of an argument's value is passed into a parameter variable
- A method's parameter variables are separate and distinct from the arguments that are listed inside the parenthesis of a method call
- If a parameter variable is changed inside the method, it has no affect on the original argument
- See `PassByValue.java`

## Passing object references to a method

- Recall that a class type variable does not hold the actual data item that is associated with it, but holds the memory address of the object
	- A variable associated with an object is called a reference variable
- When an object such as `String` is passed as an argument, is actually a reference to the object that is passed

``` java
showLength(name);

public static void showLength(str) {
	System.out.println(str + " is " + str.length() + " characters long.");
	str = "Joe"; 
}

// name = address
// both variables reference the same object
// "Warren"
```

## `String`s are immutable objects

- `String`s are immutable objects, which means that they cannot be changed
	- When the line `str = "Joe";` is executed, it cannot change an immutable object, so creates a new object
- The `name` variable holds the address of a `String` object "Warren"
- The `str` variable holds the address of a different `String` object "Joe"
- See `PassString.java`

## `@param` tag in documentation comments

- You can provide a description of each parameter in your documentation comments by using the `@param` tag
- General format:
	- `@param parameterName Description`
- See `TwoArgs2.java`
- All `@param` tags in a method's documentation comment must appear after the general description
	- The description can span several lines

## More about local variables

- A local variable is declared inside a method and is not accessible to statements outside the method
- Different methods can have local variables with the same names because the methods cannot see each other's local variables
- A method's local variables exist only while the method is executing
	- When the method ends, the local variables and parameter variables are destroyed and any values stored are lost
- Local variables are not automatically initialized with a default value and must be given a value before they can be used
- See `LocalVars.java`

## Returning a value from a method

- Data can be passed into a method by way of the parameter variables
	- Data may also be returned from a method, back to the statement that called it
- `int num = Integer.parseInt("700");
- The `String` `"700"` is passed into the `parseInt` method
- The `int` value `700` is returned from the method and assigned to the `num` variable

## Defining a value-returning method

``` java
public static int sum(int num1, int num2) {
	int result;
	result = num1 + num2;
	return result;
}
```

- `int` is the return type of this method, the expression must return the same data type
- The return statement causes the method to end execution and it returns a value back to the statement that called the method

## `@return` tag in documetation comments

- You can provide a description of the return value in your documentation comments by using the `@return` tag
- General format:
	- `@return Description`
- The `@return` tag in a method's documentation comment must appear after the general description which can span several lines

## Returning a `boolean` value

Sometimes we need to write methods to test arguments for validity and return true or false

``` java
public static boolean isValid(int number) {
	boolean status;
	if(number >= 1 && number <= 100) {
		status = true;
	} else {
		status = false;
	}
	return status;
}

// then calling the method

int value = 20;
if(isValid(value)) {
	System.out.println("The value is within range");
} else {
	System.out.println("The value is out of range");
}
```

## Returning a reference to a `String` object

``` java
customerName = fullName("John", "Martin");

public static String fullName(String first, String last) {
	String name;
	name = first + " " + last;
	return name;
}
```

- Local variable `name` holds the reference to the object
- The statement sends a copy of the reference back to the call statement and it is stored in `customerName`
- See `ReturnString.java`

## Problem solving with methods

- A large, complex problem can be solved a piece at a time by methods
- The process of breaking a problem down into smaller pieces is called *functional decomposition*
- See `SalesReport.java`

## Calling methods that throw exceptions

- Note that the `main` and `getTotalSales` methods in `SalesReport.java` have a `throws IOException` clause
- All methods that use a `Sanner` object to open a file must throw or handle `IOException`
- You will learn how to handle exceptions in Chapter 12
- For now, understand that Java required any method that interacts with an external entitity, such as the file system to either throw an exception to be handled elsewhere in your application, or to handle the exception locally
