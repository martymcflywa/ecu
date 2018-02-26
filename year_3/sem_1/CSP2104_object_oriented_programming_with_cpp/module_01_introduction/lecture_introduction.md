# Introduction to object oriented programming in C++

## Overview

- Explore procedural programming
- Intro to object oriented programming
    - Objects
    - Basic terminology
    - C++
- Getting started with C++
    - Variables and constants
    - Comment code
    - Difference between
        - ANSI/ISO C++
        - Standard C++
    - Produce output
    - Provide input
    - Work on data structures and classes

# Procedural programming

- Writing instructions that enable a computer to carry out tasks
- Procedural programming consists of a series of steps/procedures that take place one after another
- Example languages
    - COBOL
    - BASIC
    - FORTRAN
    - C/C++
- OO languages are the result of PP

## Procedural pseudo code

```
declare variables quantityOrdered, customerName, customerAddress and balanceDue
Read in quantityOrdered, customerName and customerAddress from disk
print "From:"
print "ABC Company"
print "Stevens Point, WI"
print "Send To:"
print customerName
print customerAddress
multiply quantityOrdered by 7.99 giving balanceDue
print balanceDue
```

# Basic terminology

## Modules

- Often called
    - Functions
    - Procedures
    - Methods
    - Subprograms
    - Subroutines
    - Routines
- Groups of statements that can be executed when called

### Example module

``` c
module printReturnAddress()
    print "From:"
    print "ABC Company"
    print "Stevens Point, WI"
endModule
```

### Example module call

```
repeat until there are no more input records on the disk
read in variables
printReturnAddress()
```

## Abstraction

- Pay attention to key info
- Ignore fine details

## Encapsulation

- Variables and instructions within a module are packed away
- Can be reused easily
- Reduces coupling
- Interact with encapsulated modules by using an interface
    - Knowledge of inner working not required
- To call a module you need to know some of the details

## Object

> An individual, identifiable item, unit or entity, either real or abstract with a well defined role in the problem domain...

- Objects communicate with each other by message passing
- Messages are received by the methods of an object

## What object orientation provides

### Modularity

- Large software projects split into smaller pieces

### Reusability

- Programs can be assembled from pre written software components

### Extensibility

- New software components can be written/developed from existing ones

## Example object in C++

``` cpp
#include <string>
#include <iostream>

class Person
{
    private:
        char name[20];
        int birthYear;
    
    public
        void displayDetails()
        {
            cout << name << " born in " << birthYear << endl;
        }
}
```

# History of C++

- Derived from C
    - Bjarne Stroustrup
- First version released in 1980 named 'C with Classes'
    - 1983: C++ name was assigned
    - 1990: ANSI ISO 9899 defines standard for C
    - 1998: ISO/IEC 14882 specifies standard for C++
    - 2011: C++ 11
        - Threading
        - Auto
        - Range based for loop
- C is a subset of C++
    - C++ can be used for both low and high level
    - C++ is a hybrid language
        - OO and PP

# C++ Lifecycle

- Edit
    - Create program in editor
    - Stored on disk
- Pre-process
    - Pre-processor program processes the code
- Compile
    - Compiler creates object code
    - Stored on disk
- Link
    - Linker links the object code with the libraries
    - Creates executable file
    - Stored on disk
- Load
    - Loader puts program in memory
- Execute
    - CPU takes each instruction and executes it
    - May store no data values as the program executes

# Getting started

- Use an IDE to type source code
- Compile program to transform it to machine language
- Errors/warnings may appear
    - Pay attention to them
- Functions have two parts
    - Header
        - Return type
        - Name of function
        - Parameters
    - Body
        - Local variables
        - Instructions

``` cpp
int main() // header
{
    return 0; // body
}
```

# Data types

## Identifiers

- The name of a variable when it is declare
- Can include letters, numbers, underscores
- Cannot start with a number
- Examples:
    - `customerId`
    - `lastName`
    - `salary`

### Convention

- Variables named with camel casing
    - `customerId`
    - `lastName`
- Constants uppercase
    - `SALARY`
    - `CURRENTYEAR`
    - `BUSINESSNAME`

## Integer

- `int`
- Can also be `short int` or `long int`
- Example
    - `int currentYear = 2018`

## Character

- `char`
- Characters are always expressed in single quotes `''`
- Example
    - `char firstLetter = 'a'`

## Boolean

- `bool`
- `true` or `false`
- Example
    - `bool isDriverInsured = true; // returns 1`
    - `bool isPremiumPaid = false; // returns 0`

## Floating point

- Decimal numbers
- `float`
    - Single precision
- `double` / `long double`
    - Double precision
- Best practice
    - Always use `double`
    - Unless dealing with high counts of decimal numbers where decrease in accuracy is acceptable

## Variables

- Can be declared anywhere
- Cannot be used until after declared

``` cpp
int main()
{
    int myAge, yourAge;
    char myMiddleInitial = 'B';
    double myMoney, yourMoney;
    // other stuff
    return 0;
}
```

- C++ refers to locations where values may be stored as `lvalues`
    - Located on the left side of assignment statements
    - A variable is always an `lvalue` but the number `76` is not

## Constants

- `const`
- An `lvalue` that cannot change in a program
- Example
    - `const double MINIMUM_WAGE = 10.5;`

## Comments

- Ignored by compiler

``` cpp
// single line comment

/* 
    multiline
    comment
*/
```

# `main()` function

- The first function to be run
- Can take one of four forms
    1. `int main()`
        - Returns `int`
    2. `int main(void)`
    3. `void main()`
        - No return
    4. `void main(void)`

# C++ output

## `cout`

- Console output
- Requires `iostream.h`

``` cpp
#include <iostream>
using namespace std;

int main()
{
    cout << "Hi there" << endl;
    cout << "My name is\nJohn";
    return 0;
}
```

# C++ input

## `cin`

- Console input
- Requires `iostream.h`

``` cpp
#include <iostream>
using namespace std;

int main()
{
    int age;
    cout << "What is your age?\n";
    cin >> age;
    return age;
}
```

# Data structures and classes

- Primitives
    - `int`
    - `char`
    - `double`
- Use structures and classes to create complex types
- Example
    - `Person` struct or class with attributes
        - `firstName`
        - `lastName`
        - `birthDate`
    - Relationship between attributes of `Person` is a **has-a** relationship
- Structures are declared with `struct`
    - Fields are public by default
- Classes are declared with `class`
    - Fields are private by default

``` cpp
#include <iostream>
using namespace std;

struct Person
{
    int citizenId;
    int dateOfBirth;
};

int main()
{
    Person person;
    person.citizenId = 1234;
    person.dateOfBirth = 19801031;
    cout << "Citizen ID: << person.citizenId << endl;
    cout << "Date of birth: << person.dateOfBirth << endl;
    return 0;
}
```

# Interactive program

``` cpp
#include <iostream.h>
using namespace std;

struct Person
{
    int citizenId;
    int dateOfBirth;
}

int main()
{
    Person person;
    cout << "What is your citizen id? ";
    cin >> person.citizenId;
    cout << "What is your date of birth? ";
    cin >> person.dateOfBirth;
    cout << "\nCitizenId: " << person.citizenId << endl;
    cout << "Date of birth: " << person.dateOfBirth << endl;
    return 0;
}
```