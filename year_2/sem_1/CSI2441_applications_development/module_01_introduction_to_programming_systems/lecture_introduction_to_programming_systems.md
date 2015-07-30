# Introduction to programming systems

## Objectives

- Describe the steps involved in the programming process
- Describe the data hierarchy
- Use and name variables
- Use a sentinel, or dummy value to end a program
- Use a connector symbol
- Assign values to variables
- Recognize the proper format of assignment statements
- Describe data types
- Understand the evolution of programming techniques

## Understanding computer components and operations

- Hardware and software
	- Two major components of any computer system
- Hardware
	- Equipment or device/s
- Software
	- Program that contains instructions for the computer
- Four major operations in a computer
	- Input
	- Processing
	- Output
	- Storage
- In this unit, we are mainly concerned with input into web applications
	- Processing of that input within the application
	- Output to screen of the results of that processing
	- Storage and retrieval of processed data from databases

![processing model](http://snag.gy/2UhFf.jpg)

- Input
	- Allow data to enter the application
		- Typically from
			- A user
			- Another application
			- Database
- Processing
	- Working on data
		- Organising data
		- Checking data for accuracy
			- Validation
		- Mathematical or other manipulations on data
- Output devices
	- Typically the web browser
- Programming languages
	- Any number of web based or specialised languages including
		- VB.Net
		- Java
		- C#
		- PHP
		- Perl
- Syntax
	- The rules governing word usage and punctuation in language
- Machine language
	- The language that controls the computer's on/off circuitry
- Compiler / interpreter
	- Software that translates programming languages to machine language
- Some web based languages are interpreted, where an external program reads a script on-the-fly and executes as machine code on the fly
- Other languages and environments allow for compiled code which allow for faster and more efficient performance
	- ie. Binary executables

### Syntax and errors

- A program must be free of syntax errors to be run, or executed on a computer
- To function properly, the logic must be correct
- What's wrong with this logic for making a cake?

```
Stir
Add two eggs
Add a gallon of gasoline
Bake at 350 degrees for 45 minutes
Add three cups of flour
```

- Logic errors, or semantic errors are more difficult to locate than syntax errors
- Most errors in large applications are due to logic errors
- Logic for multiplying a number by 2:
	- Includes input, processing and output statements

```
Get inputNumber
Compute calculatedAnswer as inputNumber times 2
Print calculatedAnswer
```

### Business rules

- Business rules or business logic is how an organisation or business operates
- When an application is commissioned, the business rules for how the business works needs to be translated into programmatic logic
- This is the make or break of any large application and where most errors occur
- If the original system analysis is not done correctly, business rules and processes can be missed or misinterpreted
- Fixing or adding business logic, especially where large numbers of dependencies exist, can be hugely problematic

### Storage

- For most applications we use two storage categories
	- Internal and external
- Internal storage
	- Variables
	- Constants
		- Non changing variables
	- Sessions
		- Storing data between web pages
- External storage
	- Basic text files
	- XML files
	- Relational Database Management System
		- RDBMS

## Understanding the programming process

1. Understand the problem
2. Plan the logic
3. Code the program
4. Use software to translate the program to machine language
5. Test the program
6. Deploy the program into production

### Understand the problem

- May be the most difficult phase
- Users may not be able to articulate their needs well
	- ie. Represent their company's business logic
- User needs may be changing frequently
- Programmers may have to learn the user's functional job tasks
- Failure to understand the problem is the major cause of most project failures
- Imagine a large international company or large university
	- Understanding and coding all processes, relationships between processes and dependencies between processes
	- ie. What needs to happen and in what order

### Plan the logic

- Plan the steps that the program will take
- Use tools such as flowcharts and pseudocode
- Flowchart
	- A pictorial representation of the logic steps
- Pseudocode
	- English-like representation of the logic
- Walk through the logic before coding by **desk checking** the logic
- Do screen mockups
- Perhaps even do form-driven analysis
	- Taking forms / documents that a business uses and then code requirements and interfaces based on them

### Code the program

- Select the programming language
- Write instructions
- Using software to translate the program into machine language
	- Programmers write instructions in English-like, high level languages
	- Compilers or interpreters change the programs into low level machine language that can be executed
	- In some environments, you will have a choice, and in others you will not
	- Syntax errors are identified by the compiler / interpreter
	- Logic errors are not, and must be identified through extensive testing

### Test the program

![testing model](http://i.imgur.com/UlKCg3S.png?1)

- Execute it with sample data and check results
- Identify logic errors and correct them
- Choose test data carefully to exercise all branches of the logic
- Always ensure end-users get to play with the system before deployment
	- No one will find errors quicker

### Deploy the program into production

- Do this after testing is complete and all known errors have been corrected
- May require coordination with other related activities or software
- Depending upon the contract, you might also be required to develop and implement a training program

## Understanding data hierarchy

- Data hierarchy
	- Ordering of data types by size
- Char
	- Single symbol
		- Letter
		- Number
		- Special symbol
	- `'A'`, `'7'`, `'$'`
- Field
	- Group of characters forming a single data item
	- `"Smith"`
- Record
	- A group of related fields
	- Customer record containing name and address fields
- Table
	- A group of related records
	- Customer file containing all customer records
- Database
	- Collection of related tables
	- Serves information needs of the organisation

## Using flowchart symbols and pseudocode

- Flowchart
	- Pictorial representation of logic
	- This helps development teams understand the logic and flow of a program
	- Useful in multi-team development
	- Can also help illustrate to clients what is going on
- Pseudocode
	- English-like representation of the logic

```
start
	get inputNumber
	compute CalculatedAnswer as inputNumber * 2
	print calculatedAnswer
stop
```

### Flowcharts

#### Input symbol

![input symbol](http://i.imgur.com/I9VOWzj.png?1)

#### Processing symbol

![processing symbol](http://i.imgur.com/p9IuiWB.png?1)

#### Output symbol

![output symbol](http://i.imgur.com/Kl1zfoF.png?1)

#### Flowlines

- Connect the steps
- Show the sequence of statements
- Have arrows to show direction

#### Terminal symbol

- Start / stop symbol
- Shows the start and end points of the statements
- Lozenge shape

#### Flowchart of pseudocode

![flowchart of pseudocode](http://i.imgur.com/Mapn4sX.png?1)

#### Backpoint arrows

- Backpointing arrows indicate a loop / statements repeated

![backpoint arrows](http://i.imgur.com/EKTdcvC.png)

## Using and naming variables

- Variable
	- A memory location whose contents can vary
- Each programming language has its own rules for naming variables, including
	- Legal char
	- Max length
	- Use of upper / lower case
- Variable name must be a single word, but can be formed from several words
	- `rate`
	- `interestRate`
	- `interest_rate`
- In some languages, you can define and use a variable in a single line of code
	- In others, you need to define the variable before you can store data in it

### Choosing meaningful names for variables

- Improves the readability and maintainability of code

| Suggested variable name           | Comment                                                 |
|-----------------------------------|---------------------------------------------------------|
| `employeeLastName`                | Good                                                    |
| `employeeLast`                    | Good: Most people would interpret `Last` as "last name" |
| `empLast`                         | Good: `emp` short for employee                          |
| `emlstnam`                        | Legal: But cryptic                                      |
| `lastNameOfTheEmployeeInQuestion` | Legal: But awkward                                      |
| `last name`                       | Not legal: embedded space                               |
| `employeelastname`                | Legal: But hard to read without camelCasing             |

## Using and naming sessions

- Session
	- Like a variable, but is physically stored on a server environment
- Each web programming environment has its own way of dealing with sessions
- Because a client might be on the other side of the world from a server, they have no shared memory space
- Thus, client-dependent data is stored in a session and read/updated between the client and server whenever the client moves from one page to another
- Naming conventions for sessions are similar to those for variables

## Ending a program by using sentinel values

- Infinite loop
	- A sequence of statements that repeats forever with no escape
- Avoid infinite loops by testing for a predetermined value that means **stop processing**
	- In well designed programs, this should not be necessary
	- However, it is easy to implement and gives piece of mind
- Decision
	- Testing a value
- Flowchart decision symbol
	- Diamond shape
	- Two flowlines
		- One for **Yes**
		- One for **No**

### Flowchart decision symbol

![flowchart decision symbol](http://i.imgur.com/ejiEKen.png)

### Sentinel value types

- Sentinel value
	- Dummy value
	- Does not represent real data
	- Signal to stop
	- Can be used with input from databases or from users
- End-of-file (EOF) marker
	- Signal from database recordset that marks the end of the data to be outputted
	- Usually used instead of a sentinel value for data input

### Flowchart end-of-file marker

![flowchart eof marker](http://i.imgur.com/shU7ua2.png)

## Using the flowchart connector

- Flowchart connector symbol
	- Marks a logic transfer to another location in the flowchart
	- Transfer logic can be on the same page or on another page
- On page symbol
	- A circle with a number or letter to identify the matching transfer location
	- This is either accomplished by multiple "steps" on a single page for each step
- Off page symbol
	- A square with a pointed bottom
	- Containing page number and a number / letter to identify the matching transfer location
- In terms of web development, off page symbol typically means **loading another page within a site**

![flowchart connector](http://i.imgur.com/kCt5or1.png)

## Assigning values to variables

- Assignment statement
	- Assigns a value to a variable
	- Variables must appear on the left side
	- Value on the right side of the assignment operator
	- Right side may be an expression that will be evaluated before storing the value in the variable
- Assignment operator
	- `=` in most languages
- Variable
	- Memory location
		- Has an address and value
	- Value is used for various operations
	- Most languages
		- Assign variables with `=`
		- Evaluate variables with `==`

## Understanding data types

- Three basic data types
	- Text
	- Numeric
	- Datetime
- Numeric data
	- Stored by numeric variables
- Text
	- Stored by string, text or char variables
- Datetime
	- While conceptually the same, are typically implemented in different formatting approaches across various languages and database systems
- Constants
	- Values that do not change while the program is running
	- Have identifiers, and can be used like variables for calculations, but cannot be assigned new values

### Data types in use

- Some programming languages implement several numeric data types, such as
	- Integer
		- Whole numbers only
	- Floating point
		- Fractional numeric values with decimal points
	- Boolean
		- `0` / `false`
		- `1` / `true`
- Char or string data is represented as characters enclosed in quotation marks
	- `"x"` or `'x'`
	- `"string"`
- Data types must be used appropriately
- Some languages are relatively forgiving and will deal with numeric data automatically
	- Other languages are extremely specific and will throw errors if incompatible data types are combined

### Variable assignments and data types

![variable assignments and data types](http://i.imgur.com/ect9rQl.png)

## Evolution of programming techniques

- Programming began in the 1940s, using memory addresses and machine code directly
- Higher level languages were developed to allow English-like instructions
- Older programs were **monolithic**, and ran from beginning to end
- Newer programs contain modules that can be combined for form programs
- Two major programming techniques
	- Procedural
	- Object-oriented
- Procedural
	- Focuses on the procedures that programmers create
- Object-oriented
	- Focuses on objects that represent real-world things and their attributes and behaviours
- Both techniques employ reusable program modules

## Reading

- Daniel Nations: [How Web Applications are Revealing Our Future Through the Past](http://webtrends.about.com/od/webapplications/a/future_webapps.htm)
- Caesar Fernandes: [Web Applications - A Guide to Success](http://articles.sitepoint.com/article/development-guide-success)
