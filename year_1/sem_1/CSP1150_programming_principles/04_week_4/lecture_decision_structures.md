# Decision Structures

>Gaddis, T. (2010), Decision Structures. In *Starting Out with Java: From Control Structures through Objects (5th Ed.).** (pp. 110-191). Pearson Education.

## The `if` Statement

- The `if` statement decides whether a section of code executes or not
- The `if` statement uses a `boolean` to decide whether the next statement or block of statements executes

**Pseudo:**

```
if(boolean expression is true)
	execute next statement
```

### `if` Flow

`if` statements can be modeled as a flow chart.

``` java
if(coldOutside)
	wearCoat;
```

![ifFlow1](http://i.imgur.com/xzBEmEH.png)

A block `if` statement may be modeled as:

``` java
if (coldOutside) {
	wearCoat();
	wearHat();
	wearGloves();
}
```

**Note** the use of curly braces to block several statements together.

![ifFlow2](http://i.imgur.com/qkVjARJ.png)

### Relational Operators

In most cases, the `boolean` expression, used by the `if` statement, uses *relational operators*.

| Relational Operator | Meaning                     |
|---------------------|-----------------------------|
| `>`                 | is greater than             |
| `<`                 | is less than                |
| `>=`                | is greater than or equal to |
| `<=`                | is less than or equal to    |
| `==`                | is equal to                 |
| `!=`                | is not equal to             |

### Boolean Expressions

A `boolean` expression is any variable or calculation that results in a `true` or `false` condition.

| Expression | Meaning                              |
|------------|--------------------------------------|
| `x > y`    | is `x` greater than `y`?             |
| `x < y`    | is `x` less than `y`?                |
| `x >= y`   | is `x` greater than or equal to `y`? |
| `x <= y`   | is `x` less than or equal to `y`?    |
| `x == y`   | is `x` equal to `y`?                 |
| `x != y`   | is `x` not equal to `y`?             |

### `if` Statements and `boolean` Expressions

``` java
if(x > y)
	System.out.println("x is greater than y");

if(x == y)
	System.out.println("x is equal to y");

if(x != y) {
	System.out.println("x is not equal to y");
	x = y;
	System.out.println("However, now it is.");
}
```

### Programming Style and `if` Statements

An `if` statement can span more than one line, however it is still one statement.

``` java
if(average > 95)
	grade = 'A';
```

is functionally equivalent to

``` java
if(average > 95) grade = 'A';
```

Rules of thumb:

- The conditionally executed statement should be on the line after the `if` condition
- The conditionally executed statement should be indented one level from the `if` condition
- An `if` statement does not have the block curly braces, it is ended by the first semicolon encoutered after the `if` condition

``` java
if(expression) // no semicolon here
	statement; // semicolon ends statement here
```

### Block `if` Statements

Conditionally executed statements can be grouped into a block by using `{}` to enclose them.

If curly braces are used to group conditionally executed statements, the `if` statement is ended by the closing curly brace.

``` java
if(expression) {
	statement1;
	statement2;
} // curly brace ends the statement
```

Remember that when the curly braces are not used, then only the next statement after the `if` condition will be executed conditionally.

``` java
if(expression)
	statement1; // only this statement is conditionally executed
	statement2;
	statement3;
```

### Flags

- A *flag* is a `boolean` variable that monitors some condition in a program.
- When a condition is `true`, the flag is set to `true`.
- The flag can be tested to see if the condition has changed

``` java
if(average > 95) 
	highScore = true;
if(highScore) // testing the condition
	System.out.println("That's a high score!")
```

### Comparing Characters

- Characters can be tested with relational operators.
- Characters are stored in memory using the *Unicode* character format.
- Unicode is stored as a sixteen bit number.
- Characters are *ordinal*, meaning they have an order in the Unicode character set.
- Since characters are ordinal, they can be compared to each other.

``` java
char c = 'A';
if(c < 'Z')
	System.out.println("A is less than Z");
```

## `if`-`else` Statements

The `if`-`else` statement adds the ability to conditionally execute code when the `if` condition is false.

``` java
if(expression)
	statementOrBlockIfTrue;
else
	statementOrBlockIfFalse;
```

See `division.java`

### `if`-`else` Flow

![ifElseFLow](http://i.imgur.com/rYLXsc7.png)

## Nested `if` Statements

- When `if` statements appear inside another `if` statement, it is called a *nested* `if` statement.
- The nested `if` is executed only if the outer `if` statement results in a `true` condition.

See `LoanQualifier.java`

### Nested `if` Flow

![ifNestedFlow](http://i.imgur.com/oqqAAfB.png)

``` java
if(coldOutside) {
	if(snowing) {
		wearParka();
	}
	else {
		wearJacket();
	}
}
else {
	wearShorts();
}
```

### `if`-`else` Matching

- Curly brace use is not required if there is only one statement to be conditionally executed.
- But curly braces can help make the program more readable.
- Additionaly, proper indentation makes it much easier to match up `else` statements with their corresponding `if` statement.

``` java
if(coldOutside) { // coldOutside condition
	if(snowing) { // snowing condition
		wearParka();
	}
	else { // this else matches with snowing condition
		wearJacket();
	}
}
else { // this else matches with coldOutside condition
	wearShorts();
}
```

### `if`-`else`-`if` Statements

``` java
if(expression_1) {
	statement; // if expression_1 is true, these statements are executed and the rest of the structure is ignored
	statement;
}
else if(expression_2) {
	statement; // otherwise if expression_2 is true, these statements are executed and the rest are ignored
	statement;
}
// can insert as many else if statements as necessary
else {
	statement; // these statements are executed if none of the expressions above are true
	statement;
}
```

- Nested `if` statements can become very complex.
- The `if`-`else`-`if` statement makes certain types of nested decision logic simpler to write.
- Care must be used since `else` statements mathc up with the immediate preceding unmatched `if` statement

See `TestResults.java`

### `if`-`else`-`if` Flow

![ifElseIfFlow](http://i.imgur.com/tm858Xl.png)

## Logical Operators

- Java provides two binary *logical operators* `&&` and `||` that are used to combine `boolean` expressions.
- Java also provides one *unary* logical operator to reverse the truth of a `boolean` expression.

- `&&` `AND`
	- Connects two `boolean` expressions into one. 
	- Both Expressions must be `true` for the overall expression to be `true`.
- `||` `OR`
	- Connects two `boolean` expressions into one.
	- One or both expressions must be `true` for the overall expression to be `true`.
	- It is only necessary for one to be `true`, it does not matter which one.
- `!` `NOT`
	- The `!` operator reserves the truth of a `boolean` expression.
	- If it is applied to an expression that is `true`, the operator returns `false`.
	- If it is applied to an expression that is `false`, the operator returns `true`.

### The `&&` Operator

- The logical `&&` `AND` operator takes two operands that must be both `boolean` expressions.
- The resulting combined expression is `true` if and *only if* both operands are true.

#### `&&` Truth Table

| `expression1` | `expression2` | `expression1 && expression2` |
|:-------------:|:-------------:|:----------------------------:|
| `true`        | `false`       | `false`                      |
| `false`       | `true`        | `false`                      |
| `false`       | `false`       | `false`                      |
| `true`        | `true`        | `true`                       |

### The `||` Operator

- The logical `||` `OR` operator takes two operands that must be both `boolean` expressions.
- The resulting combined expression is `false` if and *only if* both operands are `false`.

#### `||` Truth Table

| `expression1` | `expression2` | `expression1 OR expression2` |
|:-------------:|:-------------:|:----------------------------:|
| `true`        | `false`       | `true`                       |
| `false`       | `true`        | `true`                       |
| `false`       | `false`       | `false`                      |
| `true`        | `true`        | `true`                       |

**Note:** Markdown cannot render `||` inside a table, so replace `OR` with `||`. 

### The `!` Operator

- The `!` `NOT` operator performs a logical `NOT` operation.
- If an `expression` is `true`, `!expression` will be false.

``` java
if(!temperature > 100)
	System.out.println("Below the maximum temperature.");
```

#### `!` Truth Table

| `expression1` | `!expression1` |
|:-------------:|:--------------:|
| `true`        | `false`        |
| `false`       | `true`         |

## Short Circuiting

- Logical `AND` and logical `OR` operations perform *short-circuit evaluation* of expressions.
- Logical `AND` will evaluate to `false` as soon as it sees that one of its operands is a `false` expression.
- Logical `OR` will evaluate to `true` as soon as it sees that one of its operands is a `true` expression.

## Order of Precedence

- The `!` operator has a higher order of precedence than `&&` and `||` operators.
- The `&&` and `||` operators have a lower precedence than relational operators like `<` and `>`.
- Parenthesis can be used to force the precedence to be changed.

| Order | Operator                     | Description                                                              |
|:-----:|------------------------------|--------------------------------------------------------------------------|
| 1     | `!`                          | Unary negation, logical `NOT`                                            |
| 2     | `*` `/` `%`                  | Multiplication, Division, Modulus                                        |
| 3     | `+` `-`                      | Addition, Subtraction                                                    |
| 4     | `<` `>` `<=` `>=`            | Less-than, Greater-than, Less-than or equal to, Greater-than or equal to |
| 5     | `==` `!=`                    | Is equal to, Is not equal to                                             |
| 6     | `&&`                         | Logical `AND`                                                            |
| 7     | `OR`                         | Logical `OR`                                                             |
| 8     | `=` `+=` `-=` `*=` `/=` `%=` | Assignment and combined assignment operators                             |

## Comparing `String` Objects

- In most cases, you cannot use the relational operators to compare two `String` objects.
- Reference variables contain the address of the object they represent.
- Unless the references point to the same object, the relational operators will not return `true`.

See `StringCompare.java` and `StringCompareTo.java`

### Ignoring Case in `String` Comparisons

- The `String` class, the `.equals()` and `.compareTo()` methods are case sensitive.
- In order to compare two `String` objects that might have different case, use
	- `.equalsIgnoreCase()`
	- `.compareToIgnoreCase()`

See `SecretWord.java`

## Variable Scope

- In Java, a local variable does not have to be declared at the beginning of the method.
- The scope of a local variable begins at the point it is declared and terminates at the end of the block.
- When a program enters a section of code where a variable has scope, that variable has *come into scope*, which means the variable is visible to the program.

See `VariableScope.java`

## The Conditional Operator

- The *conditional operator* is a ternary (three operand) operator.
- You can use the conditional operator to write a simple statement that works like an `if`-`else` statement.
- The format of the operators is
	- `booleanExpression ? value1 : value2`
- This forms a conditional expression.
- If `booleanExpression` is true, the value of the conditional expression is `value1`.
- If `booleanExpression` is false, the value of the conditional expression is `value2`.

For example:

``` java
z = x > y ? 10 : 5;
```

Which is functionally equivalent to:

``` java
if(x > y)
	z = 10;
else
	z = 5;
```

Usually, the conditional operator is used to supply a value.

``` java
number = x > y ? 10 : 5;
```

Which is functionally equivalent to:

``` java
if(x > y)
	number = 10;
else
	number = 5;
```

## The `switch` Statement

The `if`-`else` statement allows you to make `true` / `false` branches. The `switch` statement allows you to use an ordinal value to determine how a program will branch.

The `switch` statement can evaluate an `integer` type or *character* (`char`) type variable and make decisions based on the value.

The `switch` statement takes the form:

``` java
switch(switchExpression) {
	case caseExpression:
		// insert statements here
		break;
	case caseExpression:
		// insert other statements here
		break;
	// case statements can be repeated as many times as necessary
	default:
		// include default statements here
}
```

The `switch` statement takes an ordinal value, `byte` `short` `int` `long` or `char` as the `switchExpression`

``` java
switch(switchExpression) {
	...
}
```

The `switch` statement will evauate the expression. If there is an associated `case` statement that matches that value, program execution will be transferred to that `case` statement.

Each `case` statement will have a corresponding `caseExpression` that must be unique.

``` java
switch(switchExpression) {
	case caseExpression:
		// insert statements here
		break;
}
```

If the `switchExpression` matches the `caseExpression`, the statements between `:` and `break;` will be executed.

## The `case` Statement

- The `break` statement ends the `case` statement.
- The `break` statement is optional.
- If a `case` does not contain `break`, then program execution continues into the next `case`.
	- See `NoBreaks.java`
	- See `PetFood.java`
- The `default` section is optional and will be executed if no `caseExpression` matches the `switchExpression`.

See `SwitchDemo.java`

## The `DecimalFormat` Class

When printing out `double` and `float` values, the full fractional value will be printed. The `DecimalFormat` class can be used to format these values.

In order to use the `DecimalFormat` class, the following `import` statement must be used at the top of the program:

``` java
import java.text.DecimalFormat;
```

See `Format1.java`, `Format2.java`, `Format3.java` and `Format4.java`

## The `printf()` Method

You can use `System.out.printf()` method to perform formatted console output. The general format of the method is:

``` java
System.out.printf(FormatString, ArgList);
```

- `FormatString` is a string that contains text and/or special formatting specifiers.
- `ArgList` is optional. It is a list of additional arguments that will be formatted according to the format specifiers listed in the `FormatString`.

A simple example:

``` java
System.out.printf("Hello World\n");
```

Another example:

``` java
int hours = 40;;
System.out.printf("I worked %d hours.\n", hours);
```

- The `%d` format specifier indicates that a decimal integer will be printed.
- The contents of `hours` variable will be printed in the location of the `%d` format specifier.

``` java
int dogs = 2,
	cats = 4;
System.out.printf("We have %d dogs and %d cats.\n", dogs, cats);

double grossPay = 874.12;
System.out.printf("Your pay is %f.\n", grossPay);
```

- The `%f` format specifier indicates that a `float` value will be printed.
- The contents of `grossPay` variable will be printed in the location of the `%f` format specifier.

``` java
double grossPay = 874.12;
System.out.printf("Your pay is %.2f.\n", grossPay);
```

- The `%.2f` format specifier indicates that a `float` value rounded to two decimal places will be printed.

``` java
String name = "Ringo";
System.out.printf("Your name is %s.\n", name);
```

- The `%s` format specifier indicates that a string will be printed.

``` java
int number = 9;
System.out.printf("The value is %6d\n", number);
```

- The `%6d` format specifier indicates the integer will appear in a field that is six spaces wide.

``` java
double number = 9.76891;
System.out.printf("The value is %6.2f\n", number);
```

- The `%6.2f` format specifier indicates the number will appear in a field that is six spaces wide and rounded to two decimal places.