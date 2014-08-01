# Java Fundamentals

## Parts of a Java Program

- A Java source code file contains one or more Java classes
- If more than one class is in a source code file, only one of them may be public
- The public class and the file name of the source code file must match
	- For example, a public class named `Simple` must be in a file named `Simple.java`
- Each Java class can be separated into parts

**See example: `Simple.java`**

To compile the example:

``` bash
$ javac Simple.java
```

- The .`java` file extension is required
- This will result in a file named `Simple.class` being created

To run the example:

``` bash
$ java Simple
```

- Note that the file extension is not required
- The `java` command assumes the extension is `.class`

## Analyzing the Example

``` java
// This is a simple Java program. <-- This is a comment

public class Simple // <-- This is the class header for 'Simple' { 
	// <-- this is the body of class 'Simple'
	// <-- All the data and methods for this class will be inbetween the curly braces

	public static void main(String[] args) // <-- This is the method header for the 'main' method, {  
	// where a Java application begins.
		// <-- This area is the body of 'main' method. All the actions to be completed during
		// the main method will be between the curly braces.

		System.out.println("Programming is great fun!");
		// The statement above is executed when the program runs
	}
}
```

### Comments

- The line is ignored by the compiler
- The comments in the example are single-line comments

``` java
// This is a single-line comment

/*
This is a comment block
and can consist of
multiple lines
*/
```

### Class Header

- The class header tells the compiler things about the class such as what other classes can use it, ie. `public` and that it is a Java class, ie. `class`, and the name of that class, ie. `Simple`.

``` java
public class Simple {}
```

### Curly Braces

- When associated with the class header, they define the scope of the class
- When associated with a method, they define the scope of the method

``` java
public class Simple{
	// scope of class 'Simple'
		public static void main(String[] args) {
			// scope of method 'main'
	}
}
```

### The `main` Method

- This line must be exactly as shown in the example
- The `args` variable name can be programmer defined
- This is the line of code that the `java` command will run first
- This method starts the Java program
- Every Java application must have a `main` method

``` java
public static void main(String[] args) {}
```

### Java Statements

- When the program runs, the statements within `main` method will be executed
- Can you see what the line in the example will do?
	- It will print the string to console: Programming is great fun!
- `Simple.java` example shows that there is only one line that ends with a semi-colon.
	- `System.out.println("Programming is great fun!");
- This is because it is the only statement in the program
- The rest of the code is either a comment, or other Java framework code
- Comments are ignored by the compiler so do not need semi-colons
- Other Java code elements that do not need semi-colons include:
	- Class headers, which are terminated by `{}`
	- Method headers, which are terminated by `{}`
	- Curly braces, part of framework code that does not need semi-colon terminatoion

## Review

- Java is case-sensitive
- All Java source code must be stored in files with `.java` extension
- Comments are ignored by the compiler
- A `.java` file may contain many classes but may only have **one** public class
- If a `.java` file has a public class, the class must have the same name as the file
- Java applications **must** have a `main` method.
- For every left (or opening) brace, there must be a corresponding right (or closing) brace
- Statements are terminated with semi-colons
	- Comments, class headers, method headers and braces are not considered Java statements

## Special Characters

| Char   |  Name                   | Function                                             |
|--------|-------------------------|------------------------------------------------------|
| `//`   | double slash            | marks the beginning of a single line comment         |
| `()`   | open/close parenthesis  | used in a method header to mark the *parameter* list |
| `{}`   | open/close curly braces | encloses a group of statements, or code block        |
| `" "`  | quotation marks         | encloses strings                                     |
| `;`    | semi-colon              | marks the end of a complete programming statement    |

## Console Output

- Many of the programs that you write will run in a console window
- The console window that starts a Java application is typically known as the *standard output* device
- The *standard input* device is typically the keyboard
- Java sends information to the standard output device by using a Java class stored in the standard Java library
- Java classes in the standard Java library are accessed using the Java Applications Programming Interface (**API**)
- The standard Java library is referred to as the *Java API*
- `Simple.java` uses the following line
	- `System.out.println("Programming is great fun!");
- This line uses the `System` class from the standard Java library
- The `System` class contains methods and objects that perform system level tasks
- The `out` object, a member of the `System` class, contains the methods `print` and `println`
- The `print` and `println` methods actually perform the task of sending characters to the output device
- The line is pronounced *System dot out dot println*
- The value inside the parenthesis will be sent to the output device (in this case, a string)
- The `println` method places a newline character at the end of whatever is being printed out

``` java
System.out.println("This is being printed out");
System.out.println("on two separate lines.");
```

- The example above would be printed on seperate lines since the first statement sends a newline command to the screen
- The `print` statement works similary to the `println` statement
- However, `print` does not put a newline character at the end of the output

``` java
System.out.print("These lines will be");
System.out.print("printed on");
System.out.print("the same line.");
```

**Output**
```
This lines will beprinted onthe same line.
```

- Notice the odd spacing? Why are some words run together?
	- Because there were no spaces provided at the end of each string
- For all the previous examples, we have been printing out strings of characters
- Later, we will see that much more can be printed
- There are some special characters that can be put into the output

``` java
System.out.print("This line will have a newline at the end.\n");
```

- The `\n` in the string is an escape sequence that represents the newline character
- Escape sequences allow the programmer to print characters that otherwise would not be printable

## Java Escape Sequences

| Char  | Name            | Function                                             |
|-------|-----------------|------------------------------------------------------|
| `\n`  | newline         | advances the cursor to the next line for print       |
| `\t`  | tab             | causes cursor to skip over to the next tab stop      |
| `\b`  | backspace       | causes cursor to back up, or move left, one position |
| `\r`  | carriage return | causes cursor to go to the beginning of current line |
| `\\`  | backslash       | causes backslash to be printed                       |
| `\'`  | single quote    | causes single quote to be printed                    |
| `\"`  | double quote    | causes double quote to be printed                    |

Even though escape sequences are comprised of two characters, they are treated by the compiler as a single character

``` java
System.out.print("These are our top sellers:\n");
System.out.print("\tComputer games\n\tCoffee\n ");
System.out.println("\tAspirin");
```

**Output**
```
These are our top sellers:
	Computer games
	Coffee
	Aspirin
```

With these escape sequences, complex text output can be achieved

## Variables and Literals

- A variable is a named storage location in the computer's memory
- A literal is a value that is written into the code of a program - *hardcoded*
- Programmers determine the number and type of variables a program will need

``` java
int value; // this line is called a 'variable declaration'
value = 5; // this line is known as an 'assignment statement'

System.out.print("The value is "); // this is a string 'literal', it will be printed as is
System.out.println(value); // the integer 5 will be printed here, no quotation marks
```

## The `+` Operator

- The `+` operator can be used in two ways
	1. As a concatenation operator
	2. As an addition operator
- If either side of the `+` operator is a string, the result will be a string

``` java
System.out.println("Hello " + "World");
System.out.println("The value is: " + 5);
System.out.println("The value is: " + value);
System.out.println("The value is: " + ‘\n’ + 5);
```

## String Concatenation

- Java commands that have string literals must be treated with care
- A string literal value cannot span lines in a Java source code file

``` java
System.out.println("This line is too long and now it 
has spanned more than one line, which will cause a 
syntax error to be generated by the compiler. ");
```

The String concatenation operator can be used to fix this problem

``` java
System.out.println("These lines are " +
					"now ok and will not " +
					"cause the error as before.");
```

String concatenation can join various data types

``` java
System.out.println("We can join a string to " +
					"a number line this: " + 5);
```

The concatenation operator can be used to format complex String objects

``` java
System.out.println("The following will be printed " +
					"in a tabbed format: " +
					"\n\tFirst = " + 5 * 6 + ", " +
					"\n\tSecond = " + (6 + 4) + "," +
					"\n\tThird = " + 16.7 + ".");
```

Note that if an addition operation is also required, it must be placed inside parenthesis

## Identifiers

- Identifiers are programmer-defined names for:
	- Classes
	- Variables
	- Methods
- Identifiers may not be any of the Java reserved keywords
- Identifiers must follow certain rules:
	- An identifier may only contain
		- letters a-z or A-Z
		- digits 0-9
		- underscores `_`
		- the dollar sign `$`
	- The first character must not be a digit
	- Identifiers are case sensitive
		- `ItemsOrdered` is not the same as `itemsordered`
	- Identifiers cannot include spaces

Check out this [list](http://docs.oracle.com/javase/tutorial/java/nutsandbolts/_keywords.html) of Java reserved keywords

## Variable Names

- Variable names should be descriptive
- Descriptive names allow the code to be more readable and easier to maintain
- Which of the following is more descriptive?
	- `double tr = 0.0725;`
	- `double salesTaxRate = 0.0725;`
- Java programs should be *self-documenting*

## Java Naming Conventions

- Variable names should begin with a lower case letter then switch to title case after
	- Also known as `camelCasing`
	- `int numberOfPeople`
- Class names should all be title case
	- `public class BigBear`
- More Java naming conventions can be found [here](http://java.sun.com/docs/codeconv/html/CodeConventions.doc8.html
)
- General rule of thumb, names for variables and classes tend to be nouns or noun phrases

## Primitive Data Types

- Primitive data types are built into the Java language
- There are 8 Java primitive data types
	- byte
	- short
	- int
	- long
	- float
	- double
	- boolean
	- char

### Numeric Data Types

| Type   | Byte Size | Data Type      | Range                                           |
|--------|-----------|----------------|-------------------------------------------------|
| byte   | 1 byte    | integer        | -128 to +127                                    |
| short  | 2 bytes   | integer        | -32768 to +32767                                |
| int    | 4 bytes   | integer        | -2147483648 to + 2147483647                     |
| long   | 8 bytes   | integer        | -9223372036854775808 to + 9223327036854775807   |
| float  | 4 bytes   | floating point | ±3.410-38 to ±3.410+38, 7 digits of accuracy    |
| double | 8 bytes   | floating point | ±1.710-308 to ±1.710+308, 15 digits of accuracy |

### Variable Declarations

- Variable declarations take the following form
	- `datatype variableName;`
		- `byte inches;`
		- `short month;`
		- `int speed;`
		- `long timeStamp;`
		- `float salesCommission;`
		- `double distance;`

### Integer Data Types

- `byte`, `short`, `int` and `long` are all integer data types
- They can hold whole numbers, ie. 5, 10, 23 etc.
- Integer data types cannot hold numbers that have a decimal point
- Integer embedded into Java source code are called *integer literals*
- See `IntegerVariables.java`

### Floating Point Data Types

- Data types that allow fractional values are called *floating point* numbers
	- 1.7 and -45.316 are floating point numbers
- In Java there are two data types that can represent floating point numbers
	- `float`, also called *single precision*, 7 decimal points
	- `double`, also called *double precision*, 15 decimal points

#### Floating Point Literals

- When floating point numbers are embedded into Java source code, they are called *floating point literals*
- The default type for floating point literals is `double`
	- 29..75, 1.76 and 31.51 are `double` data types
- Java is a *strongly-typed* language
- See `Sale.java`
- Literals cannot contain embedded currency symbols or commas
	- `grossPay = $1,257.00; // error`
	- `grossPay = 1257.00; // correct`
- Floating point literals can be represented in *scientific notation*
	- 47,281.97 == 4.728197 x 10^4
- Java uses *E notation* to represent values in scientific notation
	- 4.728197 x 10^4 == 4.728197E4

#### Scientific and E Notation

| Decimal Notation | Scientific Notation | E Notation |
|------------------|---------------------|------------|
| 247.91           | 2.4791 x 10^2       | 2.4791E2   |
| 0.00072          | 7.2 x 10^-4         | 7.2E-4     |
| 2,900,000        | 2.9 x 10^6          | 2.9E6      |

See `SunFacts.java`

### The `boolean` Data Type

- The Java `boolean` data type can have two possible values
	- `true`
	- `false`
- The value of a `boolean` variable may only be copied into another `boolean` variable

See `TrueFalse.java`

### The `char` Data Type

- The Java `char` data type provides access to single characters
- `char` literals are enclosed in single quote marks
	- `'a'`, `'Z'`, `'\n', `'1'`
- Don't confuse `char` literals with string literals
	- `char` literals are enclosed with single quotes
	- String literals are enclosed with double quotes

See `Letters.java`

### Unicode

- Internally, characters are stored as numbers
- Character data in Java is stored as Unicode characters
- The Unicode character set can consist of 65536 (2^16) individual characters
- This means that each character takes up 2 bytes in memory
- The first 256 characters in the Unicode character set are compatible with the ASCII character set
	- American Standard Code for Information Interchange

See diagrams on `pp. 25, 26` showing conversion of binary to unicode

## Variable Assignment and Initialization

- In order to store a value in a variable, an *assignment statement* must be used
- The *assignment operator* is the `=` symbol
- The operand on the left side of the assignment operator must be a variable name
- The operand on the right side must either be a literal or expression that evaluates to a type that is compatible with the type of the variable

``` java
// This program shows variable assignment

public class Initialize {
	public static void main(String[] args) {
		int month, 
			days;

		month = 2;
		days = 28;

		System.out.println("Month " + month + " has " +
							days + " Days.");
	}
}
```

- The variables must be declared before they can be used.
- Once declared they can receive a value (initialization) however the value must be compatible with the variable's declared type
- After receiving a value, the variables can then be used in output statements or in other calculations
- Local variables can be declared and initialized on the same line, see example below

``` java
int month = 2,
	days = 28;
```

- Variables can only hold one value at a time
- Local variables do not receive a default value
- Local variables must have a valid type in order to be used

``` java
int month, days; // no value given

System.out.println("Month " + month + " has " +
					days + " Days.");
```

Trying to use uninitialized variables will generate `syntax error` when code is compiled.

## Arithmetic Operators

| Operator | Meaning        | Type   | Example                     |
|----------|----------------|--------|-----------------------------|
| `+`      | addition       | binary | `total = cost + tax;`       |
| `-`      | subtraction    | binary | `cost = total - tax;`       |
| `*`      | multiplication | binary | `tax = cost * rate;`        |
| `/`      | division       | binary | `salePrice = original / 2;` |
| `%`      | modulus        | binary | `remainder = value % 5;`    |

- The operators are called binary operators because they must have two operands
- Each operator must have a left and right operand
- The arithmetic operators work as one would expect
- It is an error to try to divide any number by 0
- When working with two integer operands, the division operator requires special attention

### Integer Division

- Division can be tricky
	- In a Java program, what is the value of 1/2?
- 0.5 is wrong
- The answer is 0
- Integer division will truncate any decimal remainder

### Operator Precedence

- Mathematical expressions can be very complex
- There is a set order in which arithmetic operations will be carried out

| Priority | Operator              | Associativity | Example                    | Result |
|----------|-----------------------|---------------|----------------------------|--------|
| higher   | `-`  (unary negation) | right to left | `x = -4 + 3;`              | -1     |
|          | `*` `/` `%`           | left to right | `x = -4 + 4 % 3 * 13 + 2;` | 11     |
| lower    | `+` `-`               | left to right | `x = 6 + 3 - 4 + 6 * 3;`   | 23     |

### Grouping with Parenthesis

- When parenthesis are used in an expression, the inner most parenthesis are processed first
- If two sets of parenthesis are at the same level, they are processed left to right

``` java
x = ((4 * 5) / (5 - 2)) - 25; // result = -19
// 1. 4 * 5 = 20
// 2. 5 - 2 = 3
// 3. 20 / 3 = 6
// 4. 6 - 25 = -19
```

### Combined Assignment Operators

- Java has some combined assignment operators
- These operators allow the programmer to perform an arithmetic operation and assignment with a single operator
- Although not required, these operators are popular since they shorten simple equations

| Operator | Example    | Equivalent    | Value of Variable After Operation            |
|----------|------------|---------------|----------------------------------------------|
| `+=`     | `x += 5;`  | `x = x + 5;`  | old value of `x` + 5                         |
| `-=`     | `y -= 2;`  | `y = y - 2;`  | old value of `y` - 2                         |
| `*=`     | `z *= 10;` | `z = z * 10;` | old value of `z` * 10                        |
| `/=`     | `a /= b;`  | `a = a / b;`  | old value of `a` / `b`                       |
| `%=`     | `c %= 3;`  | `c = c % 3;`  | remainder of divison of old value of `c` / 3 |

## Creating Constants

- Once initialized with a value, constants cannot be change programmatically
- By convention, constants are named with upper case and words seperated by underscore

``` java
final double CAL_SALES_TAX = 0.725;
```

See `Gaddis 2.1 - 2.8`
See `Gaddis 2.9 - 2.15`

## The `String` Class

- Java has no primitive data type that holds a series of characters
- The `String` class from Java standard library is used for this purpose
- In order to be useful, the `a` variable must be created to reference a `String` object
- Notice the `S` in `String` is upper case
- By convention, class names should always begin with an upper case character

### Primitive vs. Reference Variables

- Primitive variables actually contain the value that they have been assigned
	- `number = 25;`
- The value `25` will be stored in the memory location associated with the variable `number`
- Objects are not stored in variables, however objects are *referenced* by variables
- When a variable references an object, it contains the memory address of the object's location
- The it is said that the variable *references* the object

``` java
String cityName = "Charleston";
```

![Reference Variables](http://i.imgur.com/Lp608jP.png)

### `String` Objects

- A variable can be assigned a `String` literal

``` java
String value = "Hello";
```

- `Strings` are the only objects that can be created in this way
- A variable can be created using the `new` keyword

``` java
String value = new String("Hello");
```

- This is the method that all other objects must use when they are created

See `StringDemo.java`

### The `String` Methods

- Since `String` is a class, objects that are instances of it have methods
- One of those methods is the `length` method

``` java
stringSize = value.length();
```

This statement runs the `length` method on the object pointed to by the variable `value`

See `StringLength.java`

- The `String` class contains many methods that help with the manipulation of `String` objects
- `String` objects are *immutable*, meaning that they cannot be changed
- Many of the methods of a `String` object can create new versions of the object

See `StringMethods.java`

## Scope

- Scope refers to the part of a program that has access to a variable's contents
- Variables declared inside a method (like the `main` method) are called *local variables*
- Local variables' scope begins at the declaration of the variable and ends at the end of the method in which it was declared

See `Scope.java`

## Commenting Code

Java provides three methods for commenting code.

``` java
// This is a single line comment.

/*
This is a comment block.
They cannot be nested
*/

/**
This is a Javadoc comment
which is a special version of comment blocks
that allow comments to  be documented by javadoc.
They cannot be nested
*/
```

- Javadoc comments can be built into `html` documentation
	- See `Comment3.java`
- To create the documentation, do the following

``` bash
$ javadoc file.java
```

The `javadoc` program will create `index.html` and several other documentation files in the same directory as the input file.

![Example javadoc output](http://www.designinginterfaces.com/firstedition/Patterns/Titled_Sections/javadoc.gif)

## Programming Style

- Although Java has strict syntax, whitespace characters are ignored by the compiler
- The Java whitespace characters are
	- `space`
	- `tab`
	- `newline`
	- `carriage return`
	- `form feed`

See `Compact.java`

## Indentation

- Programs should use proper indentation
- Each block of code should be indented a few spaces from its surrounding block
- Two to four spaces are sufficient
- Tab characters should be avoided
	- Tabs can vary in size between applications and devices
	- Most programming text editors allow the user to replace tabs with spaces

See `Readable.java`

## The `Scanner` Class

- To read input from the keyboard we can use the `Scanner` class
- The `Scanner` class is defined in `java.util` so we will use the following statement at the top of our program

``` java
import java.util.Scanner;
```

- `Scanner` objects work with `System.in`
- To create a `Scanner` object:

``` java
Scanner keyboard = new Scanner(System.in);
```

`Scanner` class methods are listed in `table 2 - 18` in the text

See `Payroll.java`

## Dialog Boxes

- A *dialog box* is a small graphical window that displays a message to the user or requests input
- A variety of dialog boxes can be displayed using the `JOptionPane` class
- Two of the dialog boxes are:
	- **Message Dialog:** a dialog box that displays a message
	- **Input Dialog:**  a dialog box that prompts the user for input

### The `JOptionPane` Class

- The `JOptionPane` class is not automatically available to your Java programs
- They must be imported with:

``` java
import javax.swing.JOptionPane;
```

- This statement tells the compiler where to find the `JOptionPane` class.
- The `JOptionPane` class provides methods to display each type of the dialog box

![Dialog Box Example](http://i.stack.imgur.com/GFJPS.png)

`JOptionPane.showMessageDialog` method is used to display a message dialog.

``` java
JOptionPane.showMessageDialog(null, "Hello World");
```

- The first argument will be discussed in later modules
- The second argument is the message that is to be displayed in the dialog box

### Input Dialogs

- An input dialog is a quick and simple way to ask the user to enter data
- The dialog displays a text field, an `OK` button and a `Cancel` button
- If `OK` is pressed, the dialog returns the user's input
- If `Cancel` is pressed, the dialog returns null

``` java
String name;
name = JOptionPane.showInputDialog("Enter your name.");
```

- The argument passed to the method is the message to display
- If the user clicks `OK`, `name` references the string entered by the user
- If the user clicks `Cancel`, `name` references `null`

### The `System.exit` Method

- A program that uses `JOptionPane` does not automatically stop executing when the end of the `main` method is reached
- Java generates a *thread*, which is a process running in the computer, when `JOptionPane` is created
- If the `System.exit` method is not called, this thread continues to execute
- The `System.exit` method requires an integer argument

``` java
System.exit(0);
```

- This argument is an *exit code* that is passed back to the operating system
- This code is usually ignored, however, it can be used outside the program
	- Testing for bugs, indicates whether the program ended gracefully or as a result of failure
	- The value 0 traditionally indicates that the program ended gracefully

### Converting a String to a Number - Typecasting

- The `JOptionPane`'s `showInputDialog` method always returns input as a `String`
- A `String` containing a number can be converted to a numeric data type

#### The Parse Methods

- Each of the numeric wrapper classes has a method that converts a string to a number
	- The `Integer` class has a method that converts a string to an `int`
	- The `Double` class has a method that converts a string to a `double`
	- etc..
- These methods are known as *parse methods* because their names begin with the word 'parse'

``` java
// Store 1 in bVar
byte bVar = Byte.parseByte("1");

// Store 2599 in iVar
int iVar = Integer.parseInt("2599");

// Store 10 in sVar
short sVar = Short.parseShort("10");

// Store 15908 in lVar
long lVar = Long.parseLong("15908");

// Store 12.3 in fVar
float fVar = Float.parseFloat("12.3");

// Store 7945.6 in dVar
double dVar = Double.parseDouble("7945.6");
```

#### Reading an `int` with Input Dialog

``` java
int number;
String str;

str = JOptionPane.showInputDialog("Enter a number.");
number = Integer.parseInt(str);
```

#### Reading a `double` with Input Dialog

``` java
double price;
String str;

str = JOptionPane.showInputDialog("Enter the retail price.");
price = Double.parseDouble(str);
```