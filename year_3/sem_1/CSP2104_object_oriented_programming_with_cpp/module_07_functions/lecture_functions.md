# Functions

## Overview

- Procedural abstraction
- Functions
- Function scope
- Returning from functions
- Objects as parameters or return types
- Address and reference as parameters
- Common errors when using functions
- Arrays as parameters
- Default parameters
- Overloading functions
- Pitfalls when using functions

# Procedural abstraction

## Code reuse

- Functions written once, used by many
- When reusing a tested function
    - Just call it
    - Don't need to worry about how it works

## Code organisation and modularity

- Condense related actions into a single function call

## Code maintenance

- Changes in function are automatically applied in all programs that use the function

# Functions

- Functions can be defined as modules that perform a set of tasks
- Function prototype gives basic structural information
    - What the function will return
    - What the function will be called
    - What arguments the function requires
- Function definition provides implementation of function
- Every function must have return type
    - Includes `void`

# Function syntax

- Return type
- Identifier (name)
    - `lowerCamelCase()`
- Parameters (if any)
    - Defined inside the parenthesis `()`

``` cpp
void displayLogo()
{
    // do stuff
}
```

# Function location

- When writing `main()`, functions can be placed in one of three locations
    1. The same file
        - Before `main()`
        - After `main()`
    2. In its own file
    3. Inline

## Function in same file as `main()`

### Before `main()`

``` cpp
void formLetter()
{
    // do stuff
}

int main()
{
    formLetter();
    return 0;
}
```

### After `main()`

``` cpp
void formLetter(); // declare prototype function

int main()
{
    formLetter();
    return 0;
}

void formLetter()
{
    // do stuff
}
```

## Function in its own file

``` cpp
// FormLetter.h
void formLetter(); // prototype declared
```

``` cpp
// FormLetter.cpp
void formLetter() // implementation
{
    // do stuff
}
```

``` cpp
// main.cpp
#include "FormLetter.h" // include header

int main()
{
    formLetter(); // call function
    return 0;
}
```

## Inline

- Overhead is involved in calling standard functions
- Inline functions can speed up program
    - Compiler will replace the function with a copy of function body
- Program control never transfers to function
- Copy is placed into the compiled calling program

``` cpp
inline void formLetter() // inline keyword
{
    // do stuff
}

int main()
{
    formLetter();
    return 0;
}
```

### When to use inline

- When you want to group statements together
    - Call single function instead of multiple calls
- When number of statements are small
- When function is called on few occassions
    - Can increase size of program

# Function scope

- Some variables can be accessed throughout an entire program
    - Others can be accessed only in a limited part of the program
- Scope of a variable defines where it can be accessed
- To avoid conflicts between local and global variables with same name
    - Use scope resolution operator

## Global vs. local variables

- Global variables are known to all functions
- Local variables are known only in a limited scope
    - Created when they are declared within a block
    - Known only to that block
    - Cease to exist when that block ends
- Overriding means taking precedence over

``` cpp
int a = 0; // a is global

int main()
{
    int b = 2; // b is local to main
    cout << b;

    if (b < 2)
    {
        int c = 1; // c is local to if statement
        cout << c;
    } // c is out of scope
    return 0;
} // b is out of scope
```

## Scope resolution operator `::`

- Allows you to reference a global variable when a local one has taken precedence
- Encapsulation / data hiding is principle of containing variables locally in their functions
- Global vs. local variable warning
    - When using functions defined in their own files, global variables have to be redeclared in a new program
    - As global variables are accessible by any function, this can lead to difficult trace errors

``` cpp
int age = 30;

int main()
{
    int age = 45;
    cout << age; // prints 45
    cout << ::age; // prints 30, the global variable value
    return 0;
}
```

# Returning from functions

``` cpp
char getInitial();

int main()
{
    char userInitial = getInitial();
    return 0;
}

char getInitial() // return type == char
{
    char initial;
    cout << "What is your initial? ";
    cin << initial;
    return initial;
}
```

# Passing arguments to functions

- Two ways to pass arguments to function

## By value

- Argument passed to function by value
- Is default behavior
- Cannot get information out of the function with a value parameter

### By value example

``` cpp
double divide(double a, double b)
{
    return a / b;
}
```

## By pointer or by reference

- Argument passed to function by pointer or reference to value

``` cpp
double computeTax(double);
double computeTax(double&);

int main()
{
    double cost = 1.0;
    double withTax = computeTax(cost);
    double withTax = computeTax(*cost);
}

double computeTax(double cost)
{
    // cost passed by value
}

double computeTax(double& cost)
{
    // cost passed by reference
}
```

### Advantages

- Function can alter actual variable
    - Not a copy of it
- Don't need to return any values
- Can alter multiple values
- Does not need to make a copy of the variable
    - Better performance

### Disadvantages

- Syntax of `*` and `&` is awkward
- It could alter a variable even if intention is not to
    - Because function has access to variable's address

### By pointer

``` cpp
double divide(double* a, double* b)
{
    return *a / *b; // * dereferences ptr to value
}

int main()
{
    double a = 5.5;
    double b = 7.7;
    double result = divide(&a, &b); // pass by reference
    return 0;
}
```

### By reference

- A way of using a variable through an alias
    - An alternative name
- Benefits
    - Contains address of variable
        - Like pointer
    - No need to be dereferenced
        - Unlike pointer

``` cpp
double divide(double& a, double& b)
{
    return a / b; // no need to dereference
}

int main()
{
    double a = 5.5;
    double b = 7.7;
    double result = divide(a, b); // passes reference of a and b
    return 0;
}
```

``` cpp
// const double& price: can't modify this
// double& result: this is modified in place
void getDiscount(const double& price, double& result)
{
    const double max = 100.0;
    const double highRate = 0.8;
    const double lowRate = 0.9;

    if (price > max)
    {
        result = price * highRate;
        return;
    }

    result = price * lowRate;
}

int main()
{
    double originalPrice = 50.0;
    double discountPrice;

    getDiscount(originalPrice, discountPrice);

    cout << "Original price: $" << originalPrice << endl;
    cout << "Discount price: $" << discountPrice << endl;

    return 0;
}
```

## Array as function arguments

- Can pass an array to function
- Modified in place

``` cpp
void incrementArrayValues(int values[], const int size)
{
    for (auto i = 0; i < size; i++)
    {
        ++values[i];
    }
}

int main()
{
    const int size = 4;
    int values[] = {1, 2, 3, 4};
    incrementArrayValues(values, size); // values modified in place
}
```

# Common errors when using functions

- Neglecting to make sure the function declaration, header and call agree
- Indicating a parameter type when calling a function
- Ignoring the order of parameters
- Assuming that an unused return value has an effect

# Objects as parameters or return types

- Functions may receive any number of variables as parameters
- Functions can only return one value at most
- When you use classes or structs in functions you get at least two benefits
    - Grouping fields as class/struct makes it easier to pass them into a function as a single unit
    - Returning class/struct from function allows returning a group of values

``` cpp
struct Customer
{
    int id;
    string name;
};

Customer getCustomerData()
{
    Customer customer;
    cout << "What is customer id?" << endl;
    cin >> cust.id;
    cout << "What is customer name?" << endl;
    cin >> cust.name;
    return customer;
}

void printCustomerData(Customer customer)
{
    cout << customer.id << " " << customer.name << endl;
}

int main()
{
    Customer customer = getCustomerData();
    printCustomerData(customer);
    return 0;
}
```

# Default parameters

- Automatically assigns value if one is not provided

``` cpp
int compute(int, int, int = 1); // set default in declaration

int main()
{
    compute(12, 7); // third arg defaults to 1
    compute(12, 7, 40); // third arg == 40
    return 0;
}

int compute(int length, int width, int height)
{
    return length * width * height;
}
```

## Default parameter syntax

``` cpp
// declarations
void withDefaults(int, int = 1, int = 2); // correct
void defaultFirst(int = 1, int); // error: default must be last arg
void withDefaults(); // error: no params, nothing set as default

// calls
int main()
{
    withDefaults(4); // b defaults to 1, c defaults to 2
    withDefaults(5, 6); // c defaults to 2
    withDefaults(7, 8, 9); // no defaults required
    return 0;
} 

// implementation
void withDefaults(int a, int b, int c)
{
    // do stuff
}
```

# Function overloads

- Functions with same name but different signatures

``` cpp
void square(int x);
void square(float x);
void square(double x);
```

## Function overload ambiguity

- Function overload ambiguity can occur when using default values
    - Compiler cannot tell which version of a function to use
- This happens when function has default args and are called without passing a parameter
    - Which signature does the compiler look for?
