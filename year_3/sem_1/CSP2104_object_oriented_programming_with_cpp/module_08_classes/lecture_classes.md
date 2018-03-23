# Classes

## Overview
- Object oriented principles
- Creating classes
- Encapsulating class components
- Data encapsulation
- Implement functions in a class

# Object oriented principles

## Class
- Describes characteristics common to its instances
- Blueprint from which individual objects are created
- Data encapsulation
    - Combination of data and related operations

## Inheritance
- Used to derive new classes from existing ones by modifying or extending the inherited classes

## Encapsulation
- OO mechanism to provide data/function hiding and data type access
- By default
    - Instance variables have private visibility
    - Member functions have public visibility

## Polymorphism
- OO mechanism which allows the same operation to be carried out differently depending on the object
- Apply the same function name to different objects
    - Program becomes easier to read
    - Makes more sense

# Creating classes
- C++ class is a category of objects
- Provides a description of all objects that are members of that class
- Provides a convenient way to group related data
    - And functions that use that data
- When object is instantiated, related fields are automatically created
- You think about them and manipulate them as real life classes and objects

## Simple example

``` cpp
class Vector3
{
public:
    int x;
    int y;
    int z;
};

int main()
{
    Vector3 vector3;
    vector3.x = 7;
    vector3.y = 16;
    vector3.z = 21;
    auto range = vector3.y * vector3.z;
    return 0;
}
```

## Example with implementation

``` cpp
// class declaration
class Date
{
    int _day;
    int _month;
    int _year; // private members
public:
    Date(int day, int month, int year); // ctr
    void print(); // public instance method
};

// class implementation
Date::Date(int day, int month, int year)
{
    _day = day;
    _month = month;
    _year = year;
}

void Date::print()
{
    cout << _day << "/" << _month << "/" << _year;
}

int main()
{
    auto firstDate = Date(1, 1, 2018);
    firstDate.print();
    return 0;
}
```

# Access modifiers

## `public`
- Can be accessed anywhere
- Including outside of the class itself

## `protected`
- Can be accessed within the class
- Can be accessed within derived classes
- Can be accessed from friends

## `private`
- Can be accessed within the class
- Can be accessed from friends

# `static` fields
- A class can have static variables or function members
- Static fields must include a formal definition outside of the class
    - In global scope to initialise it
- Cannot use the keyword `this` on a static field
- Only one memory location is allocated
    - All members of the class share a single storage location for a static data member of that same class

``` cpp
class Letter
{
    string _title;
    string _recipient;
    static int _count;
public:
    void setRecipient(string title, string recipient);
    void displayGreeting();
    static void displayCount();
};

int Letter::count = 0; // init in global scope

void Letter::setRecipient(string title, string recipient)
{
    this->_title = title;
    this->_recipient = recipient;
    ++count;
}

void Letter::displayGreeting()
{
    cout << "Dear " << _title << ". " << _recipient << "," << endl;
}

void Letter::displayCount()
{
    cout << "Current count is " << _count << endl;
}
```

## Don't confuse `static` with `const`
- A `const lvalue` cannot change
    - It is assigned a value at declaration
    - Never changes
- A `static lvalue` cannot movie
    - It is assigned a memory location
    - Not destroyed when leaving scope
- Can combine `static` and `const` on same `lvalue`
    - `static const int MY_CONST = 5;`

# Designing classes
- Decide on
    - Class name
    - Data members
    - Function members
- Data members declared using a data type and identifier
    - Variables
- Function members declared by writing its prototype
    - Serves as the interface to the function
- When you construct a class you create two parts
    1. Declaration
        - Contains
            - Class name
            - Variables
            - Function prototypes
    2. Implementation
        - Contains functions
        - Use both the classname and scope resolution operator `::` to implement a member function

``` cpp
// declaration
class Student
{
    int _id; // private data members
    string _name;
    double _gpa;
public:
    void display(); // public function prototype
    void setId(int id);
}

// implementation
void Student::display()
{
    // do stuff
}

void Student::setId(int id)
{
    _id = id;
}
```

# `public` functions to alter `private` data
- When working with classes you should always maintain the variables as private data
- Create setter/getter methods to modify/access data

``` cpp
class Student
{
    int _id; // private member
public:
    void setId(int id); // setter
    int getId(); // getter
};
```

# Using `private` functions/data
``` cpp
class Carpet
{
    int _length;
    int _width;
    double _price;
public:
    int getLength();
    int getWidth();
    void setLength(int length);
    void setWidth(int width);
    double getPrice();
private:
    void setPrice(); // can only be called from within Carpet
};

int Carpet::setLength(int length)
{
    _length = length;
    setPrice();
}

int Carpet::setWidth(int width)
{
    _width = width;
    setPrice();
}

void Carpet::setPrice()
{
    const int small = 12;
    const double smallPrice = 29.99;
    const double largePrice = 59.99;
    int area = _length * _width;
    _price = area < small ? smallPrice : largePrice;
}
```

# Member scope
- Can specify scope of variable or function by using the scope resolution operator `::`
    - `Name::Object`
- Used commonly when creating a new class

``` cpp
// Without scope operator
void Customer::setBalance(double balance)
{
    balance = balance;
}

// With scope operator
void Customer::setBalance(double balance)
{
    Customer::balance = balance;
}
```

- Can be more descriptive with parameter names
- Removes ambiguity

# `static` variables
``` cpp
class Student
{
    int _id;
    bool _isDiscounted;
    static double _athleticFee;
public:
    void setId(int id);
    void setIsDiscounted(bool isDiscounted);
    int getId();
    bool isDiscounted();
    double getAthleticFee();
};

double Student::athleticFee = 45.25;

void Student::setId(int id)
{
    _id = id;
}

int Student::getId()
{
    return _id;
}

double Student::getAthleticFee()
{
    if (_isDiscounted)
        return _athleticFee *= 0.8;
    
    return _athleticFee;
}
``` 

- `static` initialized globally
    - Outside of any function
- Accessing `_athleticFee` in two different ways
    - Directly
    - Through getter
    - Either method has potential to show different information
- Getter determines whether fee will be discounted
    - When we call the getter on an object, it will return a potentially lower fee
    - When we access static member directly, it shows the initialised value
- Be careful
    - Unless it is `const`, it can accidentally be modified

# `static` functions
- Can be used with a declared object
- Non static functions can access static variables
    - Caller object must be instatiated
- Static functions cannot access non static variables

# `this` pointer
- Holds memory address of the current object that is using the function
- Automatically supplied when you call a non static member function of a class
    - `student.getId();`
- It is a `const` pointer
- Allows you to have the variable in a class and a method parameter to have the same name

``` cpp
void Employee::setId(int id)
{
    (*this).id = id;
}

// preferred method
void Employee::setId(int id)
{
    this->id = id;
}
```