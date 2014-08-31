# Repetition

>Gaddis, T. (2010), Decision Structures. In *Starting Out with Java: From Control Structures through Objects (5th Ed.).* (pp. 193-271). Pearson Education.

Java provides three different looping structures:

1. `while` loop
2. `do-while` loop
3. `for` loop

## The Increment and Decrement Operators

- There are numerous times where a variable must simply be incremented or decremented:

``` java
number = number + 1;
number = number - 1;
```

- Java provide shorted ways to increment and decrement a variable's value
- Using the `++` or `--` unary operators, this task can be completed quickly

``` java
number++;
++number;
number--;
--number;
```

See `IncrementDecrement.java`

### Difference Between Prefix and Postfix

- When an increment or decrement are the only operations in a statement, there is no difference between prefix and postifx notation
- When used in an expression
	- Prefix notation indicates that the variable will be incremented or decremented prior to the rest of the equation being evaluated
	- Postfix notation indicates that the variable will be incremented or decremented after the rest of the equation has been evaluated

See `Prefix.java`

## The `while` Loop

``` java
while(condition) {
	statements;
}
```

- While the condition is true, all statements will execute repeatedly
- The `while` loop is a *pre-test* loop
	- It will test the value of the condition prior to executing the loop
- Care must be taken to set the condition to false somewhere in the loop so the loop will end
- Loops that do not end are called *infinite loops*
- A `while` loop executes 0 or more times
	- If the condition is false, the loop will not execute

See `WhileLoop.java`

### `while` Loop Flow

![whileflow](http://i.imgur.com/4VLFGzV.png)

### Infinite Loops

- In order for a `while` loop to end, the condition must become false
- The following loop will not end:

``` java
int x = 20;
while(x > 20) {
	System.out.println("x is greater than 0");
}
```

- The variable `x` never gets decremented so it will always be greater than `0`
- Adding `x--` above fixes the problem
- This version of the loop decrements `x` during each iteration:

``` java
int x = 20;
while(x > 20) {
	System.out.println("x is greater than 0");
	x--;
}
```

### Block Statements in Loops

- Curly braces are required to enclose block statement `while` loops
	- Which behave like block `if` statements

``` java
while(condition) {
	statement;
	statement;
	statement;
}
```

### The `while` Loop for Input Validation

*Input validation* is the process of ensuring that user input is valid

``` java
System.out.print("Enter a number in the range of 1 through 100: ");
number = keyboard.nextInt();

// validate the input
while(number < 1 || number > 100) {
	System.out.println("That number is invalid.");
	System.out.print("Enter a number in the range of 1 through 100");
	number = keyboard.nextInt();
}
```

See `SoccerTeams.java`

## The `do-while` Loop

``` java
do {
	statement(s);
} while(condition);
```

- The `do-while` loop is a *post-test* loop
	- It will execute the loop prior to testing the condition
- The `do-while` loop is sometimes called a `do` loop

See `TestAverage1.java`

### `do-while` Loop Flow

![do-while flow](http://i.imgur.com/hU9zPkF.png)

## The `for` Loop

``` java
for(initialization; test; update) {
	statement(s);
}
```

- The `for` loop is a *pre-test* loop
- The `for` loop, in one line of code, allows the programmer to:
	- Initialize a control variable
	- Test a condition
	- Modify the control variable

See `Squares.java`

### `for` Loop Flow

![for flow](http://i.imgur.com/MpvSDCk.png)

### The Sections of the `for` Loop

- The *initialization* section of the `for` loop allows the loop to initialize its own control variable
- The *test* section of the `for` statement acts in the same manner as the condition section of a `while` loop
- The *update* section of the `for` loop is the last thing to execute at the end of each loop

See `UserSquares.java`

#### The `for` Loop Initialization

- The initialization section of a `for` loop is optional
	- However, it is usually provided
- Typically, `for` loops initializa a counter variable that will be tested by the test section of the loop and updated by the update section
- The initialization section can initialize multiple variables
- Variables declared in this section have scope only for the `for` loop

#### The Update Expression

- The update expression is usally used to increment or decrement the counter variable/s declared in the initialization section of the `for` loop
- The update section of the loop executes last in the loop
- The update section may update multiple variables
- Each variable updated is executed as if it were on a line by itself

#### Modifying the Control Variable

- You should avoid updating the control variable of a `for` loop within the body of the loop
- The update section should be used to update the control variable
- Updating the control variable in the `for` loop body leads to hard to maintain code and difficult debugging

#### Multiple Initializations and Updates

The `for` loop may initialize and update multiple variables.

``` java
for(int i = 5, int j = 0; i < 10 || j < 20; i ++, j += 2) {
	statement(s);
}
```

Note that the only parts of a `for` loop that are mandatory are the semicolons.

``` java
for(;;;) {
	statement(s);
} // infinite loop
```

If left out, the test section defaults to true.

## Running Totals

- Loops allow the program to keep running totals while evaluation data
- Imagine needing to keep a running total of user input

See `TotalSales.java`

### Logic for Calculating a Running Total

![running total flow](http://i.imgur.com/l9oI75z.png)

## Sentinel Values

- Sometimes the end point of input data is unknown
- A *sentinal value* can be used to notify the program to stop acquiring input
- If it is a user input, the user could be prompted to input data that is not normally in the input data range
	- For example, `-1` where normal input would be positive
- Programs that get file input typically use the end-of-file marker to stop acquiring input data

See `SoccerPoints.java`

## Nested Loops

- Like `if` statements, loops can be nested
- If a loop is nested, the inner loop will execute all of its iterations for each time the outer loop executes once

``` java
for(int i = 0; i < 10; i++) {
	for(int j = 0; j < 10; j++) {
		loop statements;
	}
}
```

The loop statements in the example above will execute 100 times.

See `Clock.java`

## The `break` Statement

- The `break` statement can be used to abnormally terminate a loop
- The use of the `break` statement in loops bypasses the normal mechanisms and makes the code hard to read and maintain
- It is considered bad form to use `break` statements in this manner

## The `continue` Statement

- The `continue` statement will cause the currently executing iteration of a loop to terminate and the next iteration will begin
- The `continue` statement will cause the evaluation of the condition in `while` and `for` loops
- Like the `break` statement, the `continue` statement should be avoided because it makes the code hard to read and debug

## Deciding Which Loops to Use

- The `while` loop
	- Pre-test loop
	- Use it where you do not want the statements to execute if the condition is false in the beginning
- The `do-while` loop
	- Post-test loop
	- Use it where you want the statements to execute at least once
- The `for` loop
	- Pre-test loop
	- Use if where there is some type of counting variable that can be evaluated