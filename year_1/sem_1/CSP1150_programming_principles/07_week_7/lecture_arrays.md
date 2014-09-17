# Arrays

>Gaddis, T. (2010), Decision Structures. In *Starting Out with Java: From Control Structures through Objects (5th Ed.).* Pearson Education.

## Introduction

- Primitive values are designed to hold only one value at a time
- Arrays allow us to create a collection of like values that are indexed
- An array can store any type of data but only one type of data at a time
- An array is a list of data elements

## Creating arrays

An array is an object so it needs an object reference.

``` java
// declare a reference to an array that will hold integers
int[] numbers;
```

The next step creates the array and assigns its address to the numbers variable.

``` java
// create new array that will hold 6 integers
numbers = new int[6];
```

| 0       | 0       | 0       | 0       | 0       | 0       |
|:-------:|:-------:|:-------:|:-------:|:-------:|:-------:|
| index 0 | Index 1 | Index 2 | Index 3 | Index 4 | Index 5 |

Array indexes always start at 0. The values have been initialized to 0.

It is possible to declare an array reference and create it in the same statement.

``` java
int[] numbers = new int[6];
```

Arrays may be of any type.

``` java
float[] temperatures = new float[100];
char[] letters = new char[41];
long[] units = new long[50];
double[] sizes = new double[1200];
```

The array size must be a non-negative number.

It may be a literal value, a constant, or variable.

```java
final int ARRAY_SIZE = 6;
int[] numbers = new int[ARRAY_SIZE];
```

Once created, an array size is fixed and cannot be changed.

## Accessing elements of an array

| 0          | 0          | 0          | 0          | 0          | 0          |
|:----------:|:----------:|:----------:|:----------:|:----------:|:----------:|
| numbers[0] | numbers[1] | numbers[2] | numbers[3] | numbers[4] | numbers[5] |

- An array is accessed by:
	- The reference name
	- A subscript that identifies which element in the array to access

``` java
numbers[0] = 20; // pronounced "numbers sub zero"
```

## Inputting and outputting array elements

- Array elements can be treated as any other variable
- They are simply accessed by the same name and a subscript
	- See `ArrayDemo1.java`
- Array subscripts can be accessed using variables, like loop iterators
	- See `ArrayDemo2.java`

## Bounds checking

Array indexes always start at zero and continue to `arrayLength - 1`

``` java
int[] values = new int[10];
```

- This array would have indexes 0 through 9
	- See `InvalidSubscript.java`
- In `for` loops, it is typical to use `i`, `j` and `k` as counting variables
	- It might help to think of `i` as representing the word `index`

## Off-by-one errors

It is very easy to be off-by-one when accessing arrays

``` java
// this code has an off-by-one error
int[] numbers = new int[100]
for(int i = 1; i <= 100; i++) {
	numbers[i] = 99
}
```

- Here the equal sign allows the loop to continue on to index 100, where 99 is the last index in the array
- This code would throw an `ArrayIndexOutOfBoundsException`

## Array initialization

When relatively few items need to be initialized, an initialization list can be used to init the array

``` java
int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
```

- The numbers in the list are stored in the array in order:
	- `days[0]` is assigned 31
	- `days[1]` is assigned 28
	- `days[2]` is assigned 31
	- `days[3]` is assigned 30
	- etc

See `ArrayInitialization.java`

## Alternate array declaration

The first method shown was:

``` java
int[] numbers;
```

Arrays can also be declared like:

``` java
int numbers[];
```

However, the first style is more typical.

Multiple arrays can be decalred on the same line.

``` java
int[] numbers, codes, scores;
```

With the alternate method, each variable must have brackets.

``` java
int numbers[], codes[], scores;
```

In the example above, scores would simply be an `int` variable since it does not have `[]`.

## Processing array contents

Processing data in an array is the same as any other variable.

``` java
grossPay = hours[3] * payRate;
```

Pre and post increment works the same.

``` java
int[] score = {7, 8, 9, 10, 11};
++score[2]; // pre increment operation
score[4]++; // post increment operation
```

See `PayArray.java`

Array elements can be used in relational operations.

``` java
if(cost[20] < cost[0]) {
	// statements
}
```

The can be used as loop conditions.

``` java
while(value[count] != 0) {
	// statements
}
```

## Array length

Arrays are objects and provide a public field named `length` that is a constant that can be tested.

``` java
double[] temperatures = new double[25];
```

The length of the array is 25.

The length of an array can be obtained via its `length` constant.

``` java
int size = temperatures.length;
```

The variable `size` will contain 25.

## The enhanced `for` loop

- Simplifies array processing
	- Read only
- Always goes through all elements
- General format:

``` java
for(datatype elementVariable : array) {
	statement;
}
```

### Example

``` java
int[] numbers = {3, 6, 9};
for(int val : numbers) {
	System.out.println("The next value is " + val);
}
```

## Array size

The `length` constant can be used in a loop to provide automatic bounding.

``` java
for(int i = 0; i < temperatures.length; i++) {
	System.out.println("Temperature " + i ": " + temperatures[i]);
}
```

You can let the user specify the size of an array.

``` java
int numTests;
int[] tests;
Scanner keyboard = new Scanner(System.in);
System.out.print("How many tests do you have? ");
numTests = keyboard.nextInt();
tests = new int[numTests];
```

See `DisplayTestScores.java`

## Reassigning array references

An array reference can be assigned to another array of the same type.

``` java
// create an array referenced by the numbers variable
int[] numbers = new int[10];
// reassign numbers to a new array
numbers = new int[5];
```

If the first 10 element array no longer has a reference to it, it will be garbage collected.

![reassign array 1](http://i.imgur.com/bdmJngG.png)

![reassign array 2](http://i.imgur.com/u9x7FXx.png)


## Copying arrays

This is **not** the way to copy an array.

``` java
int[] array1 = {2, 4, 6, 8, 10};
int[] array2 = array1; // this does not copy array1
```

![copy array 1](http://i.imgur.com/YpsXEQ8.png)

See `SameArray.java`

You cannot copy an array by merely assigning one reference variable to another.

You need to copy the individual elements of one array to another.

``` java
int[] firstArray = {5, 10, 15, 20, 25};
int[] secondArray = new int[5];
for(int i = 0; i < firstArray.length; i++) {
	secondArray[i] = firstArray[i];
}
```

This code copies each element of `firstArray` to the corresponding element of `secondArray`.

Or use `System.arraycopy()`

## Passing array elements to a method

- When a single element of an array is passed to a method, it is handled like any other variable
	- See `PassElements.java`
- More often you will want to write methods to process array data by passing the entire array, not just one element at a time

## Passing arrays as arguments

- Arrays are objects
- Their references can be passed to methods like any other object reference variable

``` java
public static void showArray(int[] array) {
	for(int i = 0; i < array.length; i++) {
		System.out.print(array[i] + " ");
	}
}
```

![array as arg](http://i.imgur.com/4coXeW3.png)

## Comparing arrays

The `==` operator determines only whether array references point to the same array object.

``` java
int[] firstArray = {5, 10, 15, 20, 25};
int[] secondArray = {5, 10, 15, 20, 25};

if (firstArray == secondArray) { // This is a mistake.
	System.out.println("The arrays are the same.");
} else {
	System.out.println("The arrays are not the same.");
}
```

### Example

``` java
int[] firstArray = {2, 4, 6, 8, 10};
int[] secondArray = {2, 4, 6, 8, 10};
boolean arraysEqual = true;
int i = 0;

// first determine whether the arrays are the same size
if(firstArray.length != secondArray.length) {
	arraysEqual = false;
}

// next determine whether the elements contain the same data
while(arraysEqual && i < firstArray.length) {
	if(firstArray[i] != secondArray[i]) {
		arraysEqual = false;
	}
	i++;
}

if(arraysEqual) {
	System.out.println("The arrays are equal.");
} else {
	System.out.println("The arrays are not equal.");
}
```

## Useful array operations

### Find the highest value

``` java
int[] numbers = new int[50];
// change array values here
int highest = numbers[0];
for(int i = 1; i < numbers.length; i++) {
	if(numbers[i] > highest) {
		highest = numbers[i];
	}
}
```

### Find the lowest value

``` java
int[] numbers = new int[50];
// change array values here
int lowest = numbers[0];
for(int i = 1; i < numbers.length; i++) {
	if(numbers[i] < lowest) {
		lowest = numbers[i];
	}
}
```

### Summing array elements

``` java
int[] numbers = new int[50];
// change array values here
// init accumulator
int arraySum = 0;
for(int i = 0; i < numbers.length; i++) {
	total += units[i];
}
```

### Averaging array elements

``` java
int[] numbers = new int[50];
// change array values here
// init accumulator
double total = 0.0;
// will hold the average
double average;
for(int i = 0; i < numbers.length; i++) {
	total += scores[i];
	average = total / scores.length;
}
```

## Partially filled arrays

- Typically, if the amount of data that an array must hold is unknown:
	- Size the array to the largest expected number of elements
	- Use a counting variable to keep track of how much valid data is in the array

``` java
int[] array = new int[100];
int count = 0;

System.out.print("Enter a number or -1 to quit: ");
number = keyboard.nextInt();
while(number != -1 && count <= 99) {
	array[count] = number;
	count++;
	System.out.print("Enter a number or -1 to quit: ");
	number = keyboard.nextInt();
}
```

In the example above, `number` and `keyboard` were previously declared and `keboard` references a `Scanner` object.

## Arrays and files

### Save contents of array to file

``` java
PrintWriter outputFile = new PrintWriter("Values.txt");
for(int i = 0; i < numbers.length; i++) {
	outputFile.println(numbers[i]);
}
outputFile.close();
```

### Read contents of file into array

``` java
// assuming we know the size
final int SIZE = 5;
int[] numbers = new int[SIZE];
int i = 0;
File file = new File("Values.txt");
Scanner inputFile = new Scanner(file);
while(inputFile.hasNext() && i < numbers.length) {
	numbers[i] = inputFile.nextInt();
}
inputFile.close();
```

## Returning an array reference

A method can return a reference to an array.

The return type of a method must be declared as an array of the right type.

``` java
public static double[] getArray() {
	double[] array = {1.2, 2.3, 4.5, 6.7, 8.9};
	return array;
}
```

The `getArray` method is a public static method that returns an array of doubles.

See `ReturnArray.java`

## `String` arrays

Arrays are not limited to primitive data

An array of `String` objects can be created.

``` java
String[] names = {"Bill", "Susan", "Steven", "Jean"};
```

![String array](http://i.imgur.com/lUOjtcK.png)

If an initialization list is not provided, the `new` keyword must be used to create the array.

``` java
String[] names = new String[4];
```

![String array null](http://i.imgur.com/k1Rghko.png)

When an array is created in this manner, each element of the array **must** be initialized.

``` java
names[0] = "Bill";
names[1] = "Susan";
names[2] = "Steven";
names[3] = "Jean";
```

![String array init](http://i.imgur.com/S1bGtHd.png)

## Calling `String` methods on array elements

- `String` objects have several methods, including:
	- `toUpperCase`
	- `compareTo`
	- `equals`
	- `charAt`
- Each element of a `String` array is a `String` object
- Methods can be used by using the array name and index as before

``` java
System.out.println(names[0].toUpperCase());
char letter = names[3].charAt(0);
```

## The `length` field and the `length` method

- Arrays have a `final` field named `length`
- `String` objects have a method named `length`
- To display the length of each string held in a `String` array:

``` java
for(int i = 0; i < names.length; i++) {
	System.out.println(names[i].length());
}
```

- An array's `length` is a field
	- You **do not** write a set of parenthesis after its name
- A `String`'s length is a method
	- You **do** write the parenthesis after the name of the `String` class's `length` method

## Array of objects

Because `String`s are objects, we know that arrays can contain objects.

``` java
BankAccount[] accounts = new BankAccount[5];
```

The array is an array of references to `BankAccount` objects.

![object array 1](http://i.imgur.com/u9m7CqQ.png)

Each element needs to be initialized.

``` java
for(int i = 0; i < accounts.length; i++) {
	accounts[i] = new BankAccount();
}
```

See `ObjectsArray.java`

![objects array 2](http://i.imgur.com/mc6DiMg.png)

## The sequential search algorithm

- A search algorithm is a method of locating a specific item in a larger collection of data
- The *sequential search algorithm* uses a loop to:
	- Sequentially step through an array
	- Compare each element with the search value
	- Stop when
		- The value is found
		- The end of the array is encountered

See `SearchArray.java`

## Two-dimensional arrays

- A two-dimensional array is an array of arrays
- It can be thought of as having rows and columns

![2d array](http://i.imgur.com/b2xcYDh.png)

- Declaring a two-dimensional array requires two sets of brackets and two size declarators
	- The first one is for the number of rows
	- The second one is for the number of columns

``` java
double[][] scores = new double[3][4];
```

- The two seets of brackets in the data type indicate that the `scores` variable will reference a two-dimensional array
- Notice that each size declarator is enclosed in its own set of brackets

## Accessing two-dimensional arrays

- When processing the data in a two-dimensional array, each element has two subscripts:
	- One for its row
	- Another for its column

![access 2d array 1](http://i.imgur.com/3ocmsyw.png)

Accessing one of the two elements in a two-dimensional array requires the use of both subscripts.

``` java
scores[2][1] = 95;
```

![access 2d array 2](http://i.imgur.com/Sbvt1JW.png)

Programs that process two-dimensional arrays can do so with nested loops.

### Inputting data into two-dimensional array

``` java
for(int row = 0; row < 3; row++) {
	for(int col = 0; col < 4; col++) {
		System.out.println("Enter a score: ");
		scores[row][col] = kb.nextDouble();
	}
}
```

### Outputting data from two-dimensional array

``` java
for(int row = 0; row < 3; row++) {
	for(int col = 0; col < 4; col ++) {
		System.out.println(scores[row][col]);
	}
}
```

See `CorpSales.java`

## Initializing a two-dimensional array

Initializing a two-dimensional array requires enclosing each row's initialization list in its own set of braces.

``` java
int[][] numbers = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
```

Java automatically creates the array and fills its elements with the init values

- row 0 = {1, 2, 3}
- row 1 = {4, 5, 6}
- row 2 = {7, 8, 9}

Declares an array with three rows and three columns.

``` java
int[][] numbers = {{ 1, 2, 3},
					{4, 5, 6},
					{7, 8, 9}};
```

The code above produces:

![init 2d array](http://i.imgur.com/JQrS6mK.png)

## Two-dimensional array `length` field

- Two-dimensional arrays are arrays of one-dimensional arrays
- The length field of the array gives the number of rows in the array
- Each row has a length constant which tells how many columns in that row
- Each row can have a different number of columns
- To access the `length` fields of the array:

``` java
int[][] numbers = {{ 1, 2, 3, 4},
					{5, 6, 7},
					{8, 9, 10, 11}};

// iterate number of rows
for(int row = 0; row < numbers.length; row++) {
	// iterate number of columns within the row
	for(int col = 0; col < numbers[row].length; col++) {
		System.out.println(numbers[row][col]);
	}
}
```

Note that arrays can be "ragged" and have variable length rows.

See `Lengths.java`

## Useful two-dimensional array operations

### Sum elements of a two-dimensional array

``` java
int[][] numbers = {{ 1, 2, 3, 4},
					{5, 6, 7},
					{8, 9, 10, 11}};

int total = 0;

for(int row = 0; row < numbers.length; row++) {
	for(int col = 0; col < numbers[row].length; col++) {
		total += numbers[row][col];
	}
}

System.out.println("The total is " + total);
```

### Sum rows of a two-dimensional array

``` java
int[][] numbers = {{ 1, 2, 3, 4},
					{5, 6, 7},
					{8, 9, 10, 11}};

int total;

for(int row = 0; row < numbers.length; row++) {
	total = 0;
	for(int col = 0; col < numbers[row].length; col++) {
		total += numbers[row][col];
	}
	System.out.println("Total of row " + row + " is " + total);
}
```

### Sum columns of a two-dimensional array

``` java
int[][] numbers = {{ 1, 2, 3, 4},
					{5, 6, 7},
					{8, 9, 10, 11}};

int total;

for(int col = 0; col < numbers[0].length; col++) {
	total = 0;
	for(int row = 0; row < numbers.length; row++) {
		total += numbers[row][col];
	}
	System.out.println("Total of column " + col + " is " + total);
}
```

## Passing and returning two-dimensional array references

- There is no difference between passing a single or two-dimensional array as an argument to a method
- The method must accept a two-dimensional array as a parameter

See `Pass2Darray.java`

## Ragged arrays

- When the rows of a two-dimensional array are of different lengths, the array is known as a *ragged* array
- You can create a ragged array by creating a two-dimensional array with a specific number of rows, but no columns

``` java
int[][] ragged = new int[4][]
```

Then create the individual rows.

``` java
ragged[0] = new int[3];
ragged[1] = new int[4];
ragged[2] = new int[5];
ragged[3] = new int[6];
```

## More than two-dimensions

- Java does not limit the number of dimensions that an array may be
- More than three dimensions is hard to visualize, but can be useful in some programming problems

![multi dimensional array](http://i.imgur.com/zp6I9Vn.png)

## The `ArrayList` class

- Similar to an array, an `ArrayList` allows object storage
- Unlike an array, an `ArrayList` object
	- Automatically expands when a new item is added
	- Automatically shrinks when items are removed
- Requires an import:

``` java
import java.util.ArrayList;
```

### Creating an `ArrayList` class

``` java
ArrayList<String> nameList = new ArrayList<String>();
```

Notice the word `String` written inside angled `<>` brackets.

This specifies that the `ArrayList` can hold `String` objects.

If we try to store any other type of object in this `ArrayList`, an error will occur.

### Using an `ArrayList`

### Populating an `ArrayList`

``` java
nameList.add("James");
nameList.add("Catherine");
```

### Get current size

``` java
nameList.size();
```

### Access items in an `ArrayList`

Use the `get` method.

``` java
nameList.get(1);
```

In the statement above, 1 is the index of the item to get.

See `ArrayListDemo1.java`

### Return a `String`

The `ArrayList` `toString` method returns a string representing all the items in the `ArrayList`.

``` java
System.out.println(nameList);
```

### Remove item in `ArrayList`

``` java
nameList.remove(1);
```

The statement above removes the item at index 1.

### Add item to `ArrayList`

#### Add item to the end of the `ArrayList`

``` java
nameList.add("Mary");
```

#### Add item to an index of the `ArrayList`

``` java
nameList.add(1, "Mary");
```

The statement above will add an item at index 1.

### Replace an existing item in the `ArrayList`

``` java
nameList.set(1, "Becky");
```

The statement above replaces the item at index 1 with `"Becky"`.

See `ArrayListDemo5.java`

### `ArrayList` capacity

- An `ArrayList` has a capacity, which is the number of items it can hold without increasing its size
- The default capacity of an `ArrayList` is 10 items
- To designate a different capacity, use an argument in the constructor

``` java
ArrayList<String> list = new ArrayList<String>(100);
```

### `ArrayList` and objects

You can store any type of object in an `ArrayList`.

``` java
ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();
```

This creates an `ArrayList` that can hold `BankAccount` objects.

``` java
// create an ArrayList to hold BankAccount objects
ArrayList<BankAccount> accountList = new ArrayList<BankAccount>();

// add three BankAccount objects to the ArrayList
list.add(new BankAccount(100.0));
list.add(new BankAccount(500.0));
list.add(new BankAccount(1500.0));

// display each item
for(int index = 0; index < list.size(); index++) {
	BankAccount account = list.get(index);
	System.out.println("Account at index " + index + "\nBalance: " + account.getBalance());
}
```

See `ArrayListDemo6.java`