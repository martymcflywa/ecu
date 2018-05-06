# Friends and overloading operators

## Overview

- Friend functions
    - Declaring friend functions
    - Friends and forward declaration
- Polymorphism and overloading
- Overloading operators
- Learn the general rules and usage of operator overloading

# Friend functions

- What is a friend function
    - Only member functions of a given class can access its private data members (variables)
- A friend function declaration enables a non-member function to access a private data member of a class as if they were public
    - If class B is designated as friend of class A
        - B can access A's non public members
        - Not vice versa
    - The status of a friend can only be given by a class
        - Cannot be inherited

## Declaring friend functions

``` cpp
class Customer
{
    friend void displayAsAFriend(Customer); // friend here

private:
    int _id;
    double _balance;
public:
    Customer(int = 0, double = 0.0);
    void display();
}
```

- A non member function can be declared in
    - First in the class
    - `public` section
    - `private` section
- Keyword `friend` not required in name of function
- Overloaded functions can be friends
    - But each must be explicitly designated as `friend` function
- Limit use of `friend` functions
    - Necessary when you overload input and output operators for a class

## Friends and forward declaration

- Code without friends force classes to use public getters/setters to access/mutate private members
- Use of friends allows shortcuts
- In order to create method as friend on another class, we need to have a forward declaration of the other class
    - Prototyping a class
- We can then declare the friend method in our classes
    - Must be done in both classes that our method is a friend of

``` cpp
#include <iostream>
using namespace std;

class Customer; // forward declaration

class Transaction
{
    friend void applyTransaction(Customer customer, Transaction transaction);
private:
    int _id;
    double _amount;
public
    Transaction(int id, double amount);
};

class Customer
{
    friend void applyTransaction(Customer customer, Transaction transaction);
private:
    int _id;
    double _balance;
public:
    Customer(int id, double balance);
};

void applyTransaction(Customer customer, Transaction transaction)
{
    // have direct access to:
        // transaction._id;
        // transaction._amount;
        // customer._id;
        // customer._balance;
}
```

# Polymorphism and overloading

- Polymorphism allows the same operation to be carried out differently depending on the object passed into it
- When you overload a function, the function name is polymorphic
- Many distinguish between overloading and polymorphism
    - Pure polymorphism
        - Some reserve this term for situations in which one function body is used with a variety of arguments
    - Parameteric overloading
        - Use of functions that are distinguished by their number/types of arguments

## Operators

- Operators like `+` are overloaded in C++
    - Example `+7` vs. `2 + 5.5`
    - In addition to overloading, compilers often need to perform coercion or casting when the `+` symbol is used with mixed arithmetic
- To use arithmetic symbols with your own objects, you must overload the symbols
    - Example `bankAccountA + bankAccountB`

# Overloading operators

- Allows you to apply standard C++ operators to your own abstract data types
- If an operator is normally defined to be unary only, then you cannot overload it to binary
- Cannot change precedence of operators
- Syntax
    - `operator@(arguments)`
        - Operator is a function
        - `@` is one of the C++ symbols
            `+`, `-`, `*`, `/` etc.
    - Example `operator+`

## How to overload operators

- Two ways
    - Implemented as a member function
    - Implemented as a non member or friends function
        - The operator function may need to be declared as a friend if it requires access to protected/private data
- Expression `obj1@obj2` translates to a function call
    - `obj1.operator@(obj2)`
        - If this function is defined within `obj1`
    - `operator@(obj1, obj2)`
        - If this function is defined outside `obj1`

## Operators

### Unary

![unary](https://snag.gy/2ifcBO.jpg)

### Binary

![binary1](https://snag.gy/sHJX3f.jpg)
![binary2](https://snag.gy/H37JcP.jpg)
![binary3](https://snag.gy/LH4NvA.jpg)

### Precedence

![precedence1](https://snag.gy/vktfO7.jpg)
![precedence2](https://snag.gy/wkTxJN.jpg)
![precedence3](https://snag.gy/LYD0wo.jpg)

## Operators that can't be overloaded

- There are five operators that cannot be overloaded
- You cannot overload operators that you have invented
- Operators cannot be overloaded for built in data types

![nooverload](https://snag.gy/rJNT8e.jpg)

## Overloading an arithmetic operator

``` cpp
// without operator overload
double Employee::addTwo(Employee emp)
{
    return this->salary + emp.salary;
}

// with operator overload
double Employee::operator+(Employee emp)
{
    return this->salary + emp.salary;
}

int main()
{
    sum = clerk.addTwo(driver);
    sum = clerk + driver;
}
```

## Order of operands

- Just like normal operands, the order can affect the outcome

``` cpp
double Employee::operator-(Employee emp)
{
    return this->salary - emp.salary;
}

// has a different result than above
double Employee::operator-(Employee emp)
{
    return emp.salary - this->salary;
}
```

## Overloaded operator with object and primitive type

- In order to work with an object and a primitive, you must remember associativity
- In the example below, the double needs to be on the right hand side of the `+`
- If we have an existing `Employee` object called A, the following will work
    - `Employee B = A + 100`
- The example below won't work
    - `Employee B = 100 + A`
- This issue can be avoided by overloading the operator outside the class

``` cpp
Employee Employee::operator+(double raise)
{
    Employee temp;
    temp.idNum = this->idNum;
    temp.salary = this->salary + raise;
    return temp;
}
```

### Defining operator outside class to work with object and primitive

``` cpp
class Employee
{
    friend double operator+(double raise, Employee employee);
    // define rest of class
};

double operator+(double raise, Employee employee)
{
    return raise + employee.salary;
}
```

## Multiple operations in an expression

- Most languages allow you to chain operators
    - Allow several operators within the same statement
- When you write a statement using primitives
    - `int total = a + b + c;`
        - `a` and `b` are added first, creating a temporary value
        - Then `c` is added to the temporary value
        - Final result is stored in `total`
- The same rules of operation apply when you want to create objects that can use operation in a statement

## Overloading output

- In C++, `<<` is both a bitwise left-shift operator and an output operator
    - Insertion
- The `<<` operator acts as an output operator when `cout` appears on the left side
    - Or another output stream object
    - `cout` becomes the driving object and the `this` object in the overloaded `operator<<()` function `ostream& operator<<(ostream&, int);`
- To overload the `<<` operator to work with a `Sale` object, you must add the overloaded `operator<<()` prototye to the `Sale` class

``` cpp
class Sale
{
    friend ostream& operator<<(ostream&, const Sale&);
    // other class members
};

// implemented outside Sale class
ostream& operator<<(ostream& out, const Sale& sale)
{
    out << "Sale #" << sale.receiptNum << " for $" << sale.amount << endl;
    return out;
}
```

## Overloading input

``` cpp
class Sale
{
    friend instream& operator>>(istream&, Sale&);
};

istream& operator>>(istream& in, Sale& sale)
{
    cout << endl; // clear buffer
    cout << "Enter receipt number ";
    in >> sale.receiptNum;
    cout << "Enter the price ";
    in >> sale.price;
    cout << endl << "Thank you!" << endl;
    return in;
}

int main()
{
    Sale shirt(0, 0);
    cin >> shirt;
    return 0;
}
```

## Overloading `++` and `--` operators

- The increment and decrement operators can be used in two ways
    - Prefix
    - Postfix
- Need to overload both
- Prefix is simpler than postix

### Prefix overload

``` cpp
class Inventory
{
public:
    Inventory& operator++();
    Inventory& operator--();
};

// increment value then return the object passed in, which is *this
Inventory& Inventory::operator++()
{
    ++numSold;
    return *this;
}

Inventory& Inventory::operator--()
{
    --numSold;
    return *this;
}
```

### Postfix overload

``` cpp
class Inventory
{
public:
    // prefix
    Inventory& operator++();
    Inventory& operator--();
    // postfix
    Inventory& operator++(int);
    Inventory& operator--(int);
};

// prefix implementation here

// create a temporary state for the current object to live in
// then increment as normal with *this ptr, which calls the prefix overload
// then return the temp state
Inventory& Inventory::operator++(int)
{
    Inventory state = *this;
    ++(*this);
    return state;
}

Inventory& Inventory::operator--(int)
{
    Inventory state = *this;
    --(*this);
    return state;
}
```

## Overloading the `==` operator

``` cpp
int Inventory::operator==(const Inventory& item)
{
    if(stockNum == item.stockNum)
        return 1;
    
    return 0;
}

bool Inventory::operator==(const Inventory& item)
{
    if(stockNum == item.stockNum)
        return true;

    return false;
}
```

## Overloading the `=` operator

- If you want the `=` operator to do something other than assign each member
    - Then you must create a custom `operator=()` function
- If a class contains a pointer and you create two objects from the class and assign one object to the other
    - Then the two objects will contain pointers to the same memory
- If one of the objects is deleted or goes out of scope
    - The memory to which that object points to is released
- Now the second object contains a pointer to deallocated memory
    - Memory that is no longer assigned to anything in the application
- When you declare any data field
    - You allocate memory for that field
- Most memory allocation is accomplished when you compile a program
- When you allocate memory later during execution
    - You dynamically allocate memory
- `new` operator dynamically allocates memory
- `delete` operator frees previously allocated memory

``` cpp
class Classroom
{
    string* students;
    int numberOfStudents;
    int year;
public:
    Classroom();
    ~Classroom();
    void display();
};

Classroom::Classroom()
{
    // define rest of constructor
    students = new string[numberOfStudents];
    // add student names to array
}

Classroom::~Classroom()
{
    // used new keyword in ctr,
    // so use delete when cleaning up
    delete[] students;
}

void Classroom::display()
{
    // implement display
}

// expecting exception thrown here
int main()
{
    Classroom firstClass;
    {
        Classroom secondClass;
        firstClass.display();
        firstClass = secondClass;
        firstClass.display();
    }
    // exception is thrown here, since secondClass is now out of scope
    firstClass.display();
    return 0;
}
```

### Deep copy for `Classroom`

``` cpp
Classroom& operator=(Classroom& from)
{
    auto year = from.year;
    auto numberOfStudents = from.numberOfStudents;

    delete[] students;
    students = new string[from.numStudents];
    for (int i = 0; i < numberOfStudents; ++i)
        students[i] = from.students[i];

    return *this;
}
```