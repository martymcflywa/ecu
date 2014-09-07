# Files

## File input and output

- Re-entering data all the time could get tedious for the user
- The data can be saved to a file
	- Files can be *input* or *output*
- Files
	- Files have to be opened
	- Data is then written to the file
	- The file must be closed prior to program termination
- In general, there are two types of files:
	- Binary
	- Text

## The `PrintWriter` Class

- To use the `PrintWriter` class: `import java.io.*;`
	- See `FileWriteDemo.java`
- The `PrintWriter` class allows you to write data to a file using the `print` and `println` methods, as you have been using to display data on the screen
- Just as with the `System.out` object, the `println` method of the `PrintWriter` class will place a newline character after the written data
- The `print` method writes data without writing the newline character

``` java
PrintWriter outputFile = new PrintWriter("Names.txt");
// println() method to write data to file
outputFile.println("Chris");
outputFile.println("Kathryn");
outputFile.println("Jean");
// close the file (same as .close() for Scanner)
outputFile.close();
```

## Writing text to a file

To open a file for text output you can create an instance of the `PrintWriter` class.

``` java
PrintWriter outputFile = new PrintWriter("StudentData.txt");
// Pass the filename to be opened/created as the argument to the PrintWriter constructor
// If the file already exists, it will be erased and replaced with a new file
// outputFile is the new PrintWriter object to be instantiated
```

## Appending text to a file

To avoid erasing a file that already exists, create a `FileWriter` object in this manner:

``` java
FileWriter fw = new FileWriter("names.txt", true);
```

Then create a `PrintWriter` object in this manner:

``` java
PrintWriter fw = new PrintWriter(fw);
```

## Exceptions

- When something unexpected happens in a Java program, an *exception* is thrown
- The method that is executing when the exception is thrown must either handle the exception or pass it up the line
- Handling the exception will be discussed later
- To pass it up the line, the method needs a `throws` clause in the method header
- To insert a `throws` clause in a method header, simply add the word `throws` and the name of the expected exception
- `PrintWriter` objects can thrown an `IOException`, so we write the `throws` clause like this:

``` java
public static void main(String[] args) throws IOException
```

- The `Scanner` class can throw an `IOException` when a `File` object is passed to its constructor
- So we put a `throws IOException` clause in the header of the method that instantiates the `Scanner` class

See `ReadFirstLine.java`

## Specifying a file location

- On a Windows computer, paths contain backslash `\` characters
- Remember, if a blackslash is used in a `String` literal, it is the escape character so you must use two of them:

``` java
PrintWriter outputFile = new PrintWriter("A:\\PriceList.txt");
```

- This is only necessary if the backslash is in a `String` literal
- If the backslash is in a `String` object then it will be handled properly
- Fortunately, Java allows Unix style filenames using the forward slash `/` to separate directories

``` java
PrintWriter outFile = new PrintWriter("/home/marty/names.txt");
```

## Reading data from file

You use the `File` class and the `Scanner` class to read data from a file:

``` java
// pass the name of the file as an arg to the File class constructor
File myFile = new File("Customers.txt");
// pass the File object as an arg to the Scanner class constructor
Scanner inputFile = new Scanner(myFile);
```

``` java
// create instance of Scanner class to read from keyboard
Scanner keyboard = new Scanner(System.in);
// prompt use for filename
System.out.print("Enter the filename: ");
// get filename from user
String filename = keyboard.nextLine();
// create an instance of the File class to represent the file
File file = new File(filename);
// create an instance of the Scanner class that reads from the file
Scanner inputFile = new Scanner(file);
```

Once an instance of `Scanner` is created, data can be read using the same methods that you have used to read keyboard input: `nextLine`, `nextInt`, `nextDouble`, etc.

``` java
// open file
File file = new File("Names.txt");
Scanner inputFile = new Scanner(file);
// read a line from the file
String str = inputFile.nextLine();
// close the file
inputFile.close();
```

## Detecting the end of a file

The `Scanner` class' `hasNext()` method will return true if another item can be read from the file. Use a `while` loop that uses `hasNext()` has a condition.

``` java
// open the file
File file = new File(filename);
Scanner inputFile = new Scanner(file);
// read until the end of the file
while (inputFile.hasNext()) {
	String str = inputFile.nextLine();
	System.out.println(str);
}
// close the file
inputFile.close();
```

See `FileReadDemo.java`

## The `Random` class

- Some applications like games and simulations require the use of randomly generated numbers
- The Java API has a class, `Random`, for this purpose
- To use the `Random` class, use the following `import` statement and create an instance of the class

``` java
import java.util.Random;
Random randomNumbers = new Random();
```

### Some `Random` class methods

| Method           | Return type | Range                           |
|------------------|-------------|---------------------------------|
| `nextDouble()`   | `double`    | 0.0 - 1.0                       |
| `nextFloat()`    | `float`     | 0.0 - 1.0                       |
| `nextInt()`      | `int`       | –2,147,483,648 - +2,147,483,648 |
| `nextInt(int n)` | `int`       | 0 - `n`                         |

See `MathTutor.java`