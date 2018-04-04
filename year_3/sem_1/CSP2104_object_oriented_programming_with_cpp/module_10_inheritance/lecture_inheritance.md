# Inheritance

## Overview

- Terminology
- When subclass member functions are called
- Syntax
- Creating a derived class
- Inheritance restrictions
- Class access specifier
- Override / overload base class functions
- Base constructors / destructors
- Object slicing
- Preserving derived behaviour
- Multiple inheritance
- Virtual inheritance
- Avoiding multiple inheritance

# Terminology

- When Class B inherits data/function members from Class A
    - Class A is called a parent, base or super class
    - Class B is called a child, derived or subclass

# When subclass member functions are called

- Compiler looks for matching function in the subclass
- If no match is found, compiler looks for a matching function in parent class
- If no match is found in parent class, compiler continues up the inheritance hierarchy until the base class is reached
- If no match is found, exception is thrown

# Syntax

``` cpp
class SubClass : access_modifier SuperClass
{
    // define stuff
};
```

- `SubClass` inherits `SuperClass`
- `access_modifier` can be either
    - `public`
    - `protected`
    - `private`
    - `virtual`

# Creating a derived class

``` cpp
// base class
class Person
{
    int _id;
    string _firstname;
    string _lastname;
public:
    void setProperties(int id, string firstname, string lastname);
    void printPerson();
};

// sub class
class Customer : public Person
{
    double _balance;
public:
    void setBalance(double balance);
    void printBalance();
};

int main()
{
    Customer customer;
    // functions inherited from Person
    customer.setProperties(1, "Linda", "Santini");
    customer.printPerson();
    // functions defined in Customer
    customer.setBalance(100.50);
    customer.printBalance();
}
```

# Inheritance restrictions

## `private` members

- Can only be accessed within a base class
- Can't be accessed from derived class

## `protected` members

- Can only be accessed by
    - Base class functions
    - Derived class functions

## `public` members

- Can be accessed anywhere

## Give access to `private` members with `public` getters

``` cpp
// base class
class Person
{
    int _id;
    string _firstname;
    string _lastname;
public:
    void setProperties(int id, string firstname, string lastname);
    void printPerson();
    // public getter giving access to _id from derived classes
    int getId();
};

// sub class
class Customer : public Person
{
    double _balance;
public:
    void setBalance(double balance);
    void printBalance();
};

void Customer::printBalance()
{
    cout << getId() << " balance = " << _balance << endl;
}
```

# Class access specifier

- Determines visibility from outside the derived class

``` cpp
class Customer : public Person
class Customer : protected Person
class Customer : private Person // default
```

## `public` inheritance

- `public`, `protected` and `private` base class members remain as they are

## `protected` inheritance

- `public` base class members become `protected`
- `protected` and `private` base class members remain as they are

## `private` inheritance (default)

- `public` and `protected` base class members become `private`
- `private` base class members remain `private`

# Override / overload base class functions

``` cpp
class Person
{
    int _id;
    string _firstname;
    string _lastname;
public:
    void setProperties(int id, string firstname, string lastname);
    void outputData();
    int getId();
};

class Employee : public Person
{
    int _dept;
    double _rate;
public:
    // overloads base class function
    void setProperties(int id, string firstname, string lastname, int dept, double rate);
    // overrides base class function
    void outputData();
};

void Employee::outputData()
{
    Person::outputData(); // calls base class function
    cout << "Department #" << _dept << ", rate $" << _rate << endl;
}
```

# Base constructors / destructors

## Constructors

- Constructors of a derived class call the constructor for the base class immediately before doing anything else

## Destructors

- Derived destructors called first followed by base class destructor

## Example

- When `PetStoreAnimal` constructor is called, it automatically calls `PetStoreItem` constructor
- Requires arguments for `stockId` and `price`

``` cpp
class PetStoreItem
{
protected:
    int _id;
    double _price;
public:
    PetStoreItem(int id, double price);
};

class PetStoreAnimal : public PetStoreItem
{
protected:
    int _age;
public:
    PetStoreAnimal(int id, double price, int age);
};

PetStoreAnimal::PetStoreAnimal(int id, double price, int age) :
        PetStoreItem(id, price);
{
    _age = age;
}
```

# Object slicing

``` cpp
Worker worker;
Person person = worker;
```

- Causes data members to be copied from `worker` to `person`
- Leaves behind data that the base class doesn't have
    - Object slicing
- When calling a member function on `person`, the `Person` function will be called
- The reverse assignment cannot take place without overloading `operator=`
    - `derived = base;`
- To prevent object slicing, data members need to be present in the base class

# Preserving derived behaviour

``` cpp
class Animal
{
public:
    void makeSound()
    {
        cout << "...\n";   
    }
};

class Cat : public Animal
{
public:
    void makeSound()
    {
        cout << "meow\n";
    }
};

class Dog : public Animal
{
public:
    void makeSound()
    {
        cout << "woof\n";
    }
}
```

- Now if we create a collection of `Animal`s

``` cpp
auto animals = vector<Animal> { Dog(), Cat() };
animals[0].makeSound(); // output = "...\n";
animals[1].makeSound(); // output = "...\n";
// Base class function (Animal) is called
```

- The problem is that `Dog` and `Cat` are being casted to `Animal`
    - Loses derived overrides
- Could be solved by using `*` pointers instead?

``` cpp
auto dog = Dog();
auto cat = Cat();
auto animals = vector<Animal*> { &dog, &cat };
animals[0].makeSound(); // output = "...\n";
animals[1].makeSound(); // output = "...\n";
// still has same problem
```

## Early binding

- The wrong function is still called above
    - Even though in memory we are storing `Dog` and `Cat` objects
    - This is because the calls functions are not stored with the object
- By default, C++ employes *early* or *static* binding of functions
    - This means that the version of the function being called is decided at compile time
    - Since `animals` is a `vector` of `Animal` pointers, the `Animal` version of functions will be called on whatever is stored in the `vector`

## Late binding with `virtual`

- Means that the function being called is decided at runtime
    - Based on actual object class that the object belongs to
- Use `virtual` keyword

``` cpp
class Animal
{
public:
    virtual void makeSound()
    {
        cout << "...\n";   
    }
};

// Cat inheritance here
// Dog inheritance here
```

- With `virtual void makeSound()`, the correct function will be called at runtime

``` cpp
auto dog = Dog();
auto cat = Cat();
auto animals = vector<Animal*> { &dog, &cat };
animals[0].makeSound(); // output = "meow\n";
animals[1].makeSound(); // output = "woof\n";
```

- Member functions should be declared virtual when you won't know until runtime which override should be called
    - For example, if you are going to load a dictionary of noun and verb objects into a vector and don't know which of the objects will be nounds and verbs until you read them in
    - Or if you want to use the derived functions that take a reference to the base type

``` cpp
void makeItSpeak(Animal& animal)
{
    animal.makeSound();
}
```

# Multiple inheritance

- Single inheritance
    - When a child class derives from a single base class
- Multiple inheritance
    - When a derived class inherits from multiple base classes

``` cpp
class Vehicle
{
protected:
    int _id;
    string _make;
    double _mileage;
public:
    Vehicle(int id, string make, double mileage);
    void display();
};

class Dwelling
{
protected:
    int _rooms;
    int _sqFt;
public:
    Dwelling(int rooms, int sqFt);
    void display();
};

class Winnebago : public Vehicle, public Dwelling
{
public:
    Winnebago(int id, string make, double mileage, int rooms, int sqFt) :
        Vehicle(id, make, mileage),
        Dwelling(rooms, sqFt);
};
```

## Multiple inheritance disadvantages

- If two parent classes contain members with the same name, must use the `::` operator when working with them
- Diamond inheritance problem

# Virtual base classes

- Diamond inheritance problem
    - When derived class has two parents where they both share the same parent
    - Base class is inherited twice
- Use `virtual` class access specifier to avoid duplicate inheritance

``` cpp
class Student : virtual public Person
class Employee : virtual public Person
class StudentEmployee : public Student, public Employee

// alternatively
class Student : public Person
class Employee : public Person
class StudentEmployee : virtual public Student, virtual public Employee
```

- Constructors with multiple inheritance can be complicated if all involved classes have their own data members
- Example
    - `Person` requires values for `int id`, `string name`
    - `Student` requires values for `double gpa`
    - `Employee` requires `double rate`
    - `StudentEmployee` requires `int maxHours`

``` cpp
StudentEmployee::StudentEmployee(
        int id, 
        string name, 
        double gpa, 
        double rate, 
        int maxHours) :
    Person(id, name),
    Student(gpa),
    Employee(rate)
{
    _maxHours = maxHours;
}
```

# Avoiding multiple inheritance

- A derived class that inherits from a single class is easier to
    - Understand
    - Test
    - Less prone to error

``` cpp
// instead of
class Winnebago : public Vehicle, public Dwelling {};

// do this instead
class Winnebago : public Vehicle
{
    Dwelling _dwelling;
};

// or composition over inheritance!
class Winnebago
{
    Vehicle _vehicle;
    Dwelling _dwelling;
}
```