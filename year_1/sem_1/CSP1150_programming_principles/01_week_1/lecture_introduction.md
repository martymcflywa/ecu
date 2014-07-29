# Introduction to Computers and Java

*Gaddis, T. (2013). Starting Out With Java - From Control Structures through Objects (5th ed.). New Jersey: Pearson Education.*

## Java History

- 1991 Green Team started by Sun Microsystems
- *7 Handheld controller for multiple entertainment systems
- There was a need for programming language that would run on various devices
- Java (first named Oak) was developed for this purpose

## Introduction

- Java enabled web browser **HotJava** demonstrated at '95 Sun World conference
- Java is **cross platform**, meaning that it can run on various computer operating systems

## Java Applications and Applets

- Java programs can be of two types
	- Applications
		- Stand-alone programs that run without the aid of a web browser
		- Relaxed security model since user runs the program locally
	- Applets
		- Small applications that require the use of a Java enabled browser to run
		- Enhanced security model since the user merely goes to a web page and the applet runs itself

## Why Program?

- Computers are tools that can be programmed to perform many functions like:
	- Spreadsheets
	- Databases
	- Word processing
	- Games
- Computers are versatile because they can be programmed
- Computer Programmers implement programs that perform these functions

Aspects of a computer program that must be designed:
- The logical flow of the instructions
- The mathematical procedures
- The layout of the programming statements
- The appearance of the screens
- The way information is presented to the user
- The program's *user friendliness*
- Manuals, help systems, and/or other forms of written documentation

## Other Programming Facts

- Programs must be analytically correct as well
- Programs rarely work the first time they are programmed
- Programmers must perform the following on a continual basis:
	- Analyze
	- Experiment
	- Correct
	- Redesign
- Programming languages have strict rules, known as *syntax* and must be carefully followed

## Computer Systems: Hardware

- Computer hardware components are the physical pieces of the computer
- The major hardware components of a computer are:
	- Central Processing Unit (CPU)
	- Main memorr (RAM)
	- Secondary storage devices (HDD)
	- Input and Output devices (Keyboard, Monitor)

### Central Processing Unit

*See diagram on* `pp. 6`

`instruction (input) -> CPU -> result (output)`

The CPU performs the fetch, decode, execute cycle in order to process program information.

*See diagram* on `pp. 6`

`fetch -> decode -> execute -> loop` 

The CPU's control unit fetches, from main memory, the next instruction in the sequence of program instructions. 

The instruction is coded in the form of a number. The control unit decodes the instruction and generates an electric signal.

The signal is routed to the appropriate component of the computer (such as the ALU, a disk drive, or some other device). The signal causes the component to perform an operation.

### Main Memory

- Commonly known as *random-access memory* (RAM)
- RAM contains:
	- currently running programs
	- data used by those programs
- RAM is divided into units called *bytes*
- A byte consists of eight *bits*
- A bit is either on or off
	- 1 = on
	- 0 = off
- The bits form a pattern that represents a unique number known as an *address*
- RAM is *volatile*, which means that when the computer is turned off, the contents of RAM are erased

*See diagram on* `pp. 8`

Main memory can be visualized as a column or row of cells.

| Address | Byte       |
|---------|------------|
| `0x000` |            |
| `0x001` | `10101010` |
| `0x002` |            |
| `0x003` |            |
| `0x004` |            |
| `0x005` |            |
| `0x006` |            |
| `0x007` |            |

- A section of memory is called a *byte*
- A byte is made up of 8 *bits*
- A secton of two or four bytes is often called a *word*

### Secondary Storage Devices

- Secondary storage devices are capable of storing information for longer periods of time (*non-volatile*)
- Common secondary storage devices:
	- Hard drive
	- Floppy drive
	- CD RW drive
	- CD ROM
	- DVD RAM drive
	- Compact flash

### Input Devices

- Input is any data the computer collects from the outside world
- That data comes from devices known as *input devices*
- Common input devices:
	- Keyboard
	- Mouse
	- Scanner
	- Digital Camera

### Output devices

- Output is any data the computer sends to the outside world
- That data is displayed on devices known as *output devices*
- Common output devices:
	- Monitors
	- Printers
- Some devices such as disk drives perform input and output and are called *I/O devices* (input/output)

### Software

- Software refers to the programs that run on a computer
- There are two classifications of software
	- Operating systems
	- Application software

#### Operating Systems

- An operating system has two functions:
	- Control the system resources
	- Provide the user with a means of interaction with the computer
- Operating systems can either be single tasking or multitasking
- A single tasking operating system is capable of running only one program
	- DOS
	- iOS
- A multitasking operating system is capable of running multiple programs at once
	- Windows
	- Unix
	- OSX
- Operating systems can also be categorized as single user or multi-user
	- A single user operating system allows only one user to operate the computer at a time
	- Multi-user systems allow several users to run programs and operate the computer at once
- Examples of single user systems:
	- DOS
	- Windows 95/98/ME
- Examples of multi-user systems:
	- Unix
	- BSD
	- Windows NT/2000/XP/Vista
	- OSX

#### Application Software

- Application software refers to programs that make the computer useful to the user
- Application software provides a more specialized type of environment for the user to work in
- Common application software:
	- Spreadsheets
	- Word processors
	- Accounting software
	- Tax software
	- Games

## Programming Languages

- A program is a set of instructions a computer follows in order to perform a task
- A programming language is a special language used to write computer programs
- A computer program is a set of instructions that enable the computer to solve a problem or perform a task
- Collectively, these instructions form an *algorithm*
- An algorithm is a set of well defined steps for completing a task
- The steps in an algorithm are performed sequentially

### Machine Language

- A computer needs the algorithm to be written in *machine language*
- Machine language is written using *binary numbers*
- The binary numbering system (base 2) has only two digits, 0 and 1
- The binary numbers are encoded as a machine language
- Each CPU has its own machine language
	- Motorola 6800 series processors
	- Intel x86 series processors
	- DEC Alpha processors
- Example of a machine language instruction:
	- `1011010000000101`

### Types of Languages

- In the distant past, programmers wrote programs in machine language
- Programmers developed higher level programming languages to make things easier
- The first of these was *assembler*
- Assembler made things easier but was also processor dependent
- High level programming languages followed that were not processor dependent
- Some common programming languages:
	- Java
	- BASIC
	- COBOL
	- Pascal
	- C
	- C++
	- C#
	- PHP
	- Visual Basic
	- Python
	- Ruby
	- Javascript

### Common Language Elements

- There are some concepts that are common to virtually all programming languages
- Common concepts:
	- Key words
	- Operators
	- Punctuation
	- Programmer-defined identifiers
	- Strict syntactic rules

#### Sample Java Program

``` java
public class HelloWorld {
	public static void main(String[] args) {
		String message = "Hello World";
		System.out.println(message);
	}
}
```

#### Key words

- Key words in the sample program are:
	- `class`
	- `public`
	- `static`
	- `void`
- Key words are lower case (Java is case sensitive)
- Key words cannot be used as programmer-defined identifiers

#### Punctuation

- Semi-colons are used to end Java statements`;`
- Not all lines of a Java program end a statement
- Part of learning Java is to learn where to properly use punctuation

#### Lines vs. Statements

- There are differences between lines and statements when discussing source code

``` java
System.out.println(
	message);
```

- The example above is a Java statement written using two lines, see the difference?
- A statement is a complete Java instruction that causes the computer to perform an action

#### Variables

- Data in a Java program is stored in memory
- Variable names represent a location in memory
- Variables in Java are sometimes called *fields*
- Variables are created by the programmer who assigns it a programmer-defined identifier
- For example
	- `int hours = 40;`
- In this example, the variable `hours` is created as an integer and assigned the value of `40`
- Variables are simply a name given to represent a place in memory

| Address | Byte       |
|---------|------------|
| `0x000` |            |
| `0x001` |            |
| `0x002` |            |
| `0x003` |            |
| `0x004` |            |
| `0x005` |            |
| `0x006` | `72`       |
| `0x007` |            |

- In the example above, assume the following declaration has been made
	- `int length = 72`
- The Java Virtual Machine (JVM) actually decides where the value will be placed in memory
- The variable `length` is a symbolic name for the memory location `0x006`

## The Compiler and the Java Virtual Machine

- A programmer writes Java programming statements for a program
- These statements are known as *source code*
- A *text editor* is used to edit and save a Java source code file
- Source code files have a `.java` file extension
- A *compiler* is a program that translates source code into an executable form

### The Compiler

- A compiler is run using a source code file as input
- *Syntax errors* that may be in the program will be discovered during compilation
- Syntax errors are mistakes that the programmer has made that violate the rules of the programming language
- The compiler creates another file that holds the translated instructions

### The Java Virtual Machine (JVM)

- Most compilers translate source code into *executable* files containing *machine code*
- The Java compiler translates a Java source file into a file that contains *byte code* instructions
- Byte code instructions are the machine language of the *Java Virtual Machine (JVM)* and cannot be directly executed by the CPU
- Byte code files end with the `.class` file extension
- The JVM is a program that *emulates* a micro-processor
- The JVM executes instructions as they are read
- JVM is oftem called an *interpreter*
- Java is often referred to as an *interpreted language*

## Program Development Process

*See diagram on* `pp. 22`

`text editor -> saves java statements -> source code (.java) -> is read by -> java compiler -> produces -> byte code (.class) -> is interpreted by -> java virtual machine -> results in -> program execution`

## Portability

- *Portability* means that a program may be written on one type of computer and then run on a wide variety of computers, with little or no function
- Java byte code runs on the JVM and not on any particular CPU; therefore, compiled Java programs are highly portable
- JVMs exist on many platforms:
	- Windows
	- Mac
	- Linux
	- Unix
	- BSD
- With most programming languages, portability is achieved by compiling a program for each CPU it will run on
- Java provides a JVM for each platform so that programmers do not have to recompile for different platforms

*See diagram on* `pp. 23`

## Java Versions

- The software you use to write Java pograms is called the Java Development Kit, or JDK
- There are different editions of the JDK
	- Java SE: Java2 *Standard Edition*
	- Java EE: Java2 *Enterprise Edition*
	- Jave ME: Java2 *Micro Edition*
- Available for download [here](http://www.oracle.com/technetwork/java/javase/).

## Compiling a Java Program

- The Java compiler is a *command line* utility
- The command to compile a program is:
	- `javac filename.java`
- `javac` is the Java compiler
- The `.java` file extension must be used

For example, to compile a java source code file named `payroll.java` you would use the following command:

``` bash
$ javac Payroll.java
```

## The Programming Process

1. Clearly define what the program is to do
2. Visualize the program running on the computer
3. Use design tools to create a model of the program
4. Check the model for logical errors
5. Enter the code and compile it
6. Correct any errors found during compilation
	- Repeat steps 5 to 6 until no errors are found at compilation
7. Run the program with test data for input
8. Correct any runtime errors found while running the program
	- Repeat steps 5 to 8 until no errors are found at runtime
9. Validate the results of the program

## Software Engineering

- Encompasses the whole process of crafting computer software
- Software engineers perform several tasks in the development of complex software projects:
	- Designing
	- Writing
	- Testing
	- Debugging
	- Documenting
	- Modifying
	- Maintenace
- Software engineers develop:
	- Program specifications
	- Diagrams of screen output
	- Diagrams representing the program components and the flow of data
	- Pseudocode
	- Examples of expected input and desired output
- Software engineers also use special software designed for testing programs
- Most commercial software applications are large and complex
- Usually a team of programmers, not a single individual, develops them
- Program requirements are thoroughly analyzed and divided into sub-tasks that are handled by:
	- Individual teams
	- Individuals within a team

## Procedural Programming

- Older programming languages were procedural
- A *procedure* is a set of programming language statements that, together, perform a specific task
- Procedures typically operate on data items that are seperate from the procedures
- In a procedural program, the data items are commonly passed from one procedure to another

*See diagram on* `pp. 28`

`procedure A -> data element -> procedure B`

- In procedural programming, procedures are developed to operate on the program's data
- Data in the program tends to in global scope
- Data formats might change and thus, the procedures that operate on that data must change

## Object-Oriented Programming

- Object-oriented programming is centered on creating objects rather than procedures
- Objects are a melding of data and procedures that manipulate data
- Data in an object are known as *attributes*
- Procedures in an object are known as *methods*

*See diagram on* `pp. 29`

- Object-oriented programming combined data and behaviour via *encapsulation*
- *Data-hiding* is the ability of an object to hide data from other objects in the program
- Only an object's methods should be able to directly manipulate its attributes
- Other objects are allowed to manipulate an object's attributes via the object's methods
- This indirect access is known as a *programming interace*.

*See diagram on* `pp. 30`




