# Introduction Continued

## `String` Methods

### `.length();`

``` java
String name = "Marty"
stringSize = name.length();
```

`stringSize = 5`

Returns a `String`'s length as an `int`.

### `.charAt(index);`

``` java
String name = "Marty";
char letter = name.charAt(2)
```

`letter = "r"`

Returns `char` at that particular index of a `String`. Index begins at zero.

### `.toLowerCase();`

``` java
String bigName = "MARTY";
String littleName = bigName.toLowerCase();
```

`littleName = "marty"`

Returns a new string that is the lower case equivalent of the caller.

### `.toUpperCase();`

``` java
String littleName = "marty";
String bigName = littleName.toUpperCase();
```

`bigName = "MARTY"`

Returns a new string that is the upper case equivalent of the caller.

## Scope

- Refers to the part of a program that has access to a `variable`'s contents
- Variables declared inside a method, like `main()` are called *local variables*
- Local variables' scope begins at its declaration, and ends at the end of the method where it was declared
- Order of declaration is important
	- Do not use a variable before it is declared, it will produce error

``` java
// This program can't find its variable

public class Scope {
	public static void main(String[] args) {
		System.out.println(value); // error
		int value = 100;
	}
}
```

- Local variables cannot have two with the same name inside the same scope
	- It will not change the value of the variable
	- It will create another one and produce error

``` java
public static void main(String[] args) {
	// number is declared first time
	int number = 7;
	System.out.println(number);
	// number declared again
	int number = 100; // error
	System.out.println(number); // error
}
```

## `Scanner` Class

- Must be imported from `java.util`
- Imports happen before the `Class` is declared

``` java
// importing here
import java.util.Scanner;

public class UserInput {
	public static void main(String[] args) {
		// creating new Scanner object
		Scanner sc = new Scanner(System.in);
		// returns user input as string
		System.out.print("What's your name?");
		String name = sc.nextLine();
		// returns user input as int
		System.out.print("How many hours did you work this week?");
		int hours = sc.nextInt();
		// returns user input as double
		System.out.print("What is your hourly rate?");
		double payRate = sc.nextDouble();
	}
}
```

### `Scanner` methods

``` java
sc.nextByte(); 		// returns input as byte
sc.nextDouble(); 	// returns input as double
sc.nextFloat();		// returns input as float
sc.nextInt();		// returns input as int
sc.nextLine();		// returns input as String
sc.nextLong();		// returns input as long
sc.nextShort();		// returns input as short
sc.close();			// closes Scanner object
```

### Reading a Single Character

``` java
System.out.print("Are you sure you want to delete file? (Y = yes, N = no)");
String input = sc.nextLine();
// gets the first char
char answer = input.charAt(0);
```

### Mixing Calls to `.nextLine()` with Calls to Other `Scanner` Methods

`.nextline()` method behaves differently to other `Scanner` methods. If mixing with other methods, do the following:

``` java
import java.util.Scanner;

public class CorrectedInputProblem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// get users age
		System.out.print("What is your age?");
		int age = sc.nextInt();

		// get users income
		System.out.print("What is your annual income?");
		double income = sc.nextDouble();

		// consumes remaining newline
		sc.nextLine();

		// get users name
		System.out.print("What is your name?");
		String name = sc.nextLine();
	}
}
```

Use an extra instance of `.nextLine()` between a different `Scanner` method and the actual `.nextLine()` to use up the extra `newLine` character that is created by the previous method. If not, the proper `.nextLine()` input will be ignored.

## Dialog Boxes

`JOptionPane` class can quickly display dialog boxes. This section shows two different types:

- Message dialog
	- Displays message
	- OK button
- Input dialog
	- Prompts user for input
	- Has text field where input is typed
	- OK button
	- Cancel button

Things to note:

- Must be imported
- Input is stored as `String` but can be converted to other types

### Import statement

``` java
import javax.swing.JOptionPane;
```

### Displaying Message Dialogs

``` java
JOptionPane.showMessageDialog(null, "Hello World");
```

`null` argument is important if the program displays other graphical windows. More on that later.

### Displaying Input Dialogs

``` java
String name = JOptionPane.showInputDialog("Enter your name:");
```

The argument passed into the method is the message that we want to display in the dialog box.

### Dialog Example

``` java
import javax.swing.JOptionPane;

public class NamesDialog {
	public static void main(String[] args) {
		// get user first name
		String firstName = JOptionPane.showInputDialog("What is your first name?");

		// get user middle name
		String middleName = JOptionPane.showInputDialog("What is your middle name?");

		// get user last name
		String lastName = JOptionPane.showInputDialog("What is your last name?");

		// display greeting
		JOptionPane.showMessageDialog(null, "Hello " + firstName + " " + middleName + " " + lastName);

		// close JOptionPane
		System.exit(0);
	}
}
```

`System.exit(0);` must be used to close `JOptionPane`, otherwise it's thread will continue to run in the background even after `main()` has finished. This is because `JOptionPane` causes an additional thread to run in the `JVM`.

## Parsing `String` as Numbers

`JOptionPane` does not have different methods to read input values as different data types. `showInputDialog()` always returns user input as `String`, even if numbers are entered. This will be an issue if we need to perform math operations with user input. In these cases, we need to convert user input to a numeric value, and can use the following methods.

``` java
Byte.parseByte(str);		// converts to byte
Double.parseDouble(str);	// converts to double
Float.parseFloat(str);		// converts to float
Integer.parseInt(str);		// converts to int
Long.parseLong(str);		// converts to long
Short.parseShort(str);		// converts to short
```

### Parse Example

``` java
String str = JOptionPane.showInputDialog("Enter a number:");
int number = Integer.parseInt(str);

String priceInput = JOptionPane.showInputDialog("Enter the price:");
double price = Double.parseDouble(priceInput);
```

## Common Errors to Avoid

- Mismatched braces, quotation marks or parenthesis
- Misspelling key words
- Using capitals in key words
- Using key word as a variable name
- Using inconsistent spelling of variable names
- Using inconsistent casing of variable names
- Inserting spaces in variable names
- Forgetting the semi-colon at the end of a statement
- Assigning `double` literal to a `float` variable
- Using commas or other currency symbols in numeric literals
- Unintentionally performing integer division
	- When both operands of a division statement are integers, the returning result will be an integer
	- Remainders will be discarded
- Forgetting to group parts of mathematical expressions
- Inserting a space in a combined assignment operator
	- A space cannot appear between the two operators that make a combined assignment operator
	- `++` right
	- `+ +` wrong
- Using a variable to receive the result of a calculation when the variable's data type is incompatible with the data type of the result
- Incorrectly terminating a multi-line comment or documentation comment
- Forgetting to use the correct `import` statement in a program
- Not converting the `showInputDialog()` value to a number when using an input dialog to read numeric input