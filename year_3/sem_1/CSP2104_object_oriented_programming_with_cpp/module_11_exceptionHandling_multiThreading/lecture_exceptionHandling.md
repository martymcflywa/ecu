# Exception handling and multi threading

## Overview

- Error handling mechanisms
- Exception handling methods
- Try block statements
- Throwing exceptions
- Catching exceptions
- Multiple throw and multiple catch
- Determine order of catch blocks
- Example of automatically thrown `logic_error`
- Derive own exceptions
- Exception specifications
- Memory allocation exceptions

# Error handling mechanisms

``` cpp
int getUserNumber()
{
    int userEntry;
    cout << "Enter a positive number: ";
    cin >> userEntry;

    if(userEntry < 0)
        exit(1);
    
    return userEntry;
}
```

- The `exit()` function forces the program to end
- A `0` argument indicates the program exited normally
- A non-zero argument indicates an error
- Errors that occur during execution of programs are called exceptions
    - If not handled, the program crashes and falls into an unknown state
- Error detection code clutters the program

# Exception handling methods

- Exception handling is a programming technique to catch and manage errors
- Typically implemented as exception handlers
    - Code that gets executed when an exception occurs
    - This involves a set of actions
        - Try a function
        - If it throws an exception, catch and handle it

``` cpp
void theFunction()
{
    try
    {
        tryMe();
    } 
    catch(someException)
    {

    }
}

void tryMe()
{
    if(someError)
        throw someException();
}
```

- `Exception`
    - An object that contains information that is passed from the place where a problem occurs to another place that will handle the problem
- Can be of any type, scalar or class type
- A variety of exception object types can be thrown from a function
    - Regardless of return type
- You can create your own exception types that inherit from built in `exception` class

## Exception syntax

- Handle with `try catch` statements

``` cpp
try
{
    // call function that throws
}
catch(anException& e)
{
    // handle exception here
}
```

# Try block statements

- Are statements that a program attempts to execute
    - But might result in thrown exceptions
- Whenever a try block is used
    - A catch block must follow
- If a function throws an uncaught exception
    - The program terminates
- You handle a thrown exception by catching it

# Throwing exceptions

- A function should check for errors
    - But should not be required to handle an error if one is found
- `throw`
    - Send an error object to the calling function

``` cpp
void tryMe()
{
    // do stuff

    if(someError)
        throw someException();
}
```

# Catching exceptions

- A catch block is not required to use in any way what is thrown
    - Calling functions from within catch blocks can be dangerous
    - Especially if you call the function that caused the thrown exception in the first place
- Catch is the name of all handlers
    - It is an overloaded name
    - The formal parameter of each catch must be unique
    - The formal parameter doesn't need a variable
        - Can be a type name to distinguish between handlers
    - Can be an ellipsis `(...)` in which case it handles all exceptions not yet handled
- An unhandled exception is propagated to the caller of the function in which it was raised
- This propagation continues to the main function
- If no handler is found, default handler is called

# Multiple throw and multiple catch

``` cpp
int tryMe()
{
    // do stuff

    if(userEntry < 0)
        throw TooLowException();

    if(userEntry > 10)
        throw TooHighException();
    
    return output;
}

int main()
{
    try
    {
        tryMe();
    }
    catch(TooLowException& e)
    {
        // handle when too low
    }
    catch(TooHighException& e)
    {
        // handle when too high
    }
}
```

# Determine order of catch blocks

- When any exception object is thrown, a subsequent catch block has a usable match if
    - The type of the thrown object and type of the catch parameter are identical
    - The type of the thrown object and type of the catch paramater are the same, except the catch contains the `const` qualifier, a reference qualifier or both
    - The `catch` parameter type is a parent class of the thrown argument
    - If you throw an exception and no `catch` block exists with an acceptable parameter type, the program terminates
- To avoid termination, include a default exception handler
    - Create a `catch` block with an ellipsis `(...)` as its parameter
    - Must be the **last** catch block listed after a try
- When you include multiple catch blocks in a program, the first catch block that can accept a thrown object is the one that will execute
- To throw a base class object and an object that is a member of its derived class from the same function, and be able to carry out different operations when they are caught, catch the derived object first

# Example of automatically thrown `logic_error`

``` cpp
int main()
{
    string phoneNumber;
    cout << "Enter your 10 digit phone number without spaces: ";
    cin >> phoneNumber;

    try
    {
        string first = phoneNumber.substr(0, 4);
        string middle = phoneNumber.substr(4, 3);
        string last = phoneNumber.substr(7, 3);
        cout << "Formatted number is: " << first << '-' << middle << '-' << last << endl;
    }
    catch(out_of_range& e)
    {
        cout << "Exception caught" << endl;
        cout << "Invalid phone number" << endl;
    }
    return 0;
}
```

# Derive own exceptions

- C++ allows you to create your own subclass of exceptions for more specific results
- This allows code to be more relevant in terminology used in the program

``` cpp
class RangeException : public runtime_error
{
    int user;
public:
    RangeException(int);
    int getUser();
};

RangeException::RangeException(int user) : runtime_error("Value is out of range")
{
    this->user = user;
}

int RangeException::getUser()
{
    return user;
}
```

# Exception specifications

- You can indicate the exceptions that a function can throw by writing an exception specification
    - A declaration of a function's possible throw types
    - Also called a throw list
- Provides documentation for later users of the function
- If a function throws an error whose type was not listed in its exception specification, an error will occur and the program may stop prematurely

## Exception specification example

``` cpp
int dataEntry() throw(char, double, Employee)
{
    // throws char, double or Employee
}

int dataEntry() throw()
{
    // does not throw any exceptions
}

int dataEntry()
{
    // throws any exception
}
```

# Memory allocation exceptions

- When you allocate memory, enough memory may not be available
    - If `new` operator fails, program ends abruptly
- `set_new_handler()` is an out of memory exception handler
- Use `#include <new>` to use it
- Create a function to handle the error
- Pass the error handling function's name (pointer to func) as paramater

``` cpp
void handleMemoryDepletion()
{
    cout << "Out of memory!" << endl;
    exit(1);
}

int main()
{
    int number = 100000000;
    set_new_handler(handleMemoryDepletion);

    const int LIMIT = 30;

    for(int x = 0; x < LIMIT; ++x)
    {
        double *a = new double[number];
        cout << "x is " << x << endl;
    }

    return 0;
}
```