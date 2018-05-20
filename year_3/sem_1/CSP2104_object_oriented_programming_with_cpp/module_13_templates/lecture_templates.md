# Templates

## Overview

- Function template use case
- Function templates
- Function template syntax
- Creating function templates
- Overloading function templates
- Function template with multiple types
- Function template with multiple parameterize types
- Explicitly specifying type in function template
- Explicitly specifying multiple types in function template
- Using class templates
- Creating class templates
- Creating a complete class template
- Container classes

# Function template use cases

- Instead of writing 3 overloaded versions of a given function
- You could just create one function with a variable name standing in for the type

# Function templates

- Is an outline for a group of functions that differ in the types of parameters they use
- You can find other definitions, including
    - Template functions are functions that use variable types
    - A template function is a function that can process a value whose type is known only when the variable is accessed
- A group of functions that generates from the same template is often called a family of functions

``` cpp
// T is any data type
template<class T>
T reverse (T x)
{
    return -x;
}
```

# Function template syntax

``` cpp
template<class ParametricType>
ReturnType FunctionName(Argument(s))
{
    // do stuff
}
```

# Creating function templates

- The keyword `class` in the template definition does not necessarily mean that `T` stands for a programmer created class type
    - Many C++ compilers allow you to replace `class` with `typename` in the template definition
- When you call a function template, the compiler determines the type of the actual argument passed
- The designation of the parameterized type is implicit
    - The compiler generates code for different functions as it needs, depending on the function calls

``` cpp
template<class T> // defines template, T is formal template param
T findLargest(T x, T y, T z) // returns T, accepts 3 T params
{
    T big;
    if (x > y)
        big = x;
    else
        big = y;
    
    if (z > big)
        return z;
    
    return big;
}
```

# Overloading function templates

``` cpp
template<class T>
void invert(T& x, T& y)
{
    auto temp = x;
    x = y;
    y = temp;
}

// overloaded with different signature
template<class T>
void invert(T& x)
{
    x = -x;
}
```

# Function template with multiple types

``` cpp
template<class T>
void repeatValue(T val, int times)
{
    // do stuff
}
```

# Function template with multiple parameterize types

``` cpp
template<class T, class U>
void displayAndCompare(T val1, U val2)
{
    // do stuff
}
```

# Explicitly specifying type in function template

- When you call a templated function
    - The arguments to the function dictate the types to be used
- Example below to override deduced type
- Useful when at least one of the types you need to generate in the function is not an argument

``` cpp
template<class T>
T doubleVal(T val)
{
    return val *= 2;
}

int main()
{
    // cast to int
    return doubleVal<int>(20);
}
```

# Explicitly specifying multiple types in function template

``` cpp
template<class T, class U>
T tripleVal(U val)
{
    return val * 3;
}

int main()
{
    outInt = tripleVal<int>(5);
    outIntInDouble = tripleVal<int, double>(10);
}
```

# Using class templates

- If you need to create several similar classes, consider developing a class template to generate a class where at least one type is generic or parameterized
- Programmers often use the terms class template and template class interchangeably
    - Technically you write a class template, and it generates a template class

# Creating class templates

- Class template `Number`
- Takes type parameter `T`
- Parameter type `T` must be specified
    - In the class template as a parameter
    - Where it's used in the class
- When an instance is declared
    - Type `T` must be explicitly specified as a concrete type parameter

``` cpp
template<class T>
class Number
{
    T _number;
public:
    Number(T);
    void display();
};

// Implementation here

int main()
{
    auto anInt = Number<int>(10);
    auto aDouble = Number<double>(5.1);
}
```

# Creating a complete class template

``` cpp
template<class T>
class Number
{
    T _number;
public:
    Number(T);
    void display();
};

template<class T>
Number<T>::Number(T number)
{
    _number = number;
}

template<class T>
void Number<T>::display()
{
    // do stuff
}

int main()
{
    auto anInt = Number<int>(5);
    auto aDouble = Number<double>(5.1);
    auto aChar = Number<char>('a');
}
```

# Container classes

- Programmers commonly use template classes for even more generic classes called container classes
- Queue
    - FIFO data structure
- Stack
    - FILO data structure
- Linked list
    - Logically ordered data structure

## Understanding container classes

- Many C++ compilers come with class libraries called container classes
- A container class is a template class that has been written to perform common class tasks
    - Manages groups of other classes
- A linked list is a chain of objects, containing at least two parts
    - The usual components of the object itself
    - A pointer to another object
- Many linked lists provide more than a pointer to the next logical object
    - May contain a pointer to the previous object
        - Enables reverse traversal
- Procedures must be developed to establish and manage links appropriately in the linked list
    - Insert
    - Remove
    - Reorder
    - Get
     