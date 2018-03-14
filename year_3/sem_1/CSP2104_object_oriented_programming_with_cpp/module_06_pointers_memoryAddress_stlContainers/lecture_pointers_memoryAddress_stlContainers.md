# Pointers, references and standard template library containers

## Overview

- Limitation of C++ arrays
- Understanding memory addresses
- Understanding pointers
- Dynamic containers using pointers
- Standard Template Library containers

# Limitation of C++ arrays

- Arrays store a container of data elements of the same type
- Arrays are simple to use and understand
    - `int x[4] = {1, 2, 3, 4};`
- Limitations
    - Static size
        - Can't change once created
    - Allocated at compile time
        - Can't create array where size is unknown until runtime

## Static size limitation

``` cpp
struct Word
{
    // fields
}

Word dictionary[45]; // what happens when we need more than 45 words?
```

- Could create a really large array
    - But not best use of memory

## Allocated at compile time

``` cpp
int numberOfWords = 0;
cout << "How many number of words in your vocabulary? ";
cin >> numberOfWords;
Word dictionary[numberOfWords]; // compile error
```

- Compile error:
    - `Expression must have a constant value`
    - Number of elements to allocate must be known when program is compiled, rather than set at runtime

## Options

- Arrays are not suitable for applications that need containers that grow / shrink
- Learn about C++ dynamic memory management
    - Create own dynamic container data structure
- Use a dynamic container structure that is already implemented
    - There are some in C++ Standard Template Library

# Understanding memory addresses

- Each location where a piece of data can be stored is identified by a variable name and its memory address
- The location can be accessed using the `&` operator
    - The **addressof** operator

``` cpp
int age = 98;
cout << age << endl; // output: 98
cout << &age << endl; // output: hex address of 'age'
```

## The *addressof* operator

- Useful for passing things *by reference*
    - Calling a function where the input is the address of the data we want it to operate on
        - We examine this when we deal h lith functions
    - Useful for implementing container classes where we store the *address* of each element
        - Rather than making a copy of the element to store

# Understanding pointers

- Pointers are an alternative to *address of*

``` cpp
int *year; // does not allocated memory, can't be used yet
```

- The `*` is used
    - **Pointer to**
        - When talking about the address
    - **Star**
        - When talking about the value

## Safe pointer initialization

- Pointer variables **can't** be directly initialized with literal values
    - No memory has been allocated yet

``` cpp
int *year = 1999; // compile error
```

- A safe way to initialize is to pass it a value already in memory

``` cpp
int yearValue = 1999;
int *year = &someValue;
```

- This is safe because when `yearValue` goes out of scope, the memory is freed

## Equivalence of pointer and addressof notation

``` cpp
int yearValue = 1999;
int *year = &yearValue;

cout << year << endl; // 1999
cout << *year << endl; // 1999
cout << &yearValue endl; // 0040F974
cout << year << endl; // 0040F974
```

## Single instance of value

- Note there is only one instance of the value in memory
    - `&yearValue` and `year` are the same address
    - So changing value changes it for both variables

``` cpp
int yearValue = 1999;
int *year = &yearValue;

// change the value
yearValue = 2017;
cout << *year << endl; // 2017
// change the pointer
*year = 1975;
cout << yearValue << endl; // 1975
```

## `new` keyword

- Pointer without assigning existing value

``` cpp
int *y = new int; // allocates memory for *y
*y = 6;
```

## `delete` keyword

- When the pointer goes out of scope, the value becomes inaccessible
- But memory is not released
    - Creates a memory leak
- Release it using `delete`

``` cpp
delete y; // free memory for *y
```

# Example application

## Without pointer `*` and reference `&`

- Consider code below
- Some employees can be
    - Managers
    - Fire wardens
- Tracked with an array
- Then John changes his email address

``` cpp
struct Employee
{
    string email;
};

int main()
{
    Employee jim, john, jane;
    jim.email = "jim@email.com";
    john.email = "john@email.com";
    jane.email = "jane@email.com";

    // some are managers, some are fire wardens
    Employee managers[] = { john, jane };
    Employee fireWardens[] = { john, jim };

    // John changes email address
    john.email = "hacker@hack.com";
}
```

- `john`'s email update is not reflected in `managers` or `fireWardens` arrays

## With pointer `*` and reference `&`

``` cpp
struct Employee
{
    string email;
};

int main()
{
    Employee jim, john, jane;
    jim.email = "jim@email.com";
    john.email = "john@email.com";
    jane.email = "jane@email.com";

    // some are managers, some are fire wardens
    Employee *managers[] = { &john, &jane };
    Employee *fireWardens[] = { &john, &jim };
    // not using new, don't need to delete

    // John changes email address
    john.email = "hacker@hack.com";
}
```

- Arrays now hold references `&` to Employees
    - No copy is made
    - The array holds memory address of original variables
- `john`'s email address is updated in `managers` and `fireWarden` arrays

# Example using pointer instead of array name

``` cpp
int main()
{
    const int DAYS = 7;
    int sales[DAYS] = {500, 300, 450, 200, 525, 800, 1000};
    int *p = sales;
    int x;

    for(x = 0; x < DAYS; ++x)
        cout << "$" << sales[x] << " ";
    cout << endl;

    for(x = 0; x < DAYS; ++x)
        cout << "$" << p[x] << " ";
    cout << endl;

    for(x = 0; x < DAYS; ++x)
        cout << "$" << *(sales + x) << " ";
    cout << endl;

    for(x = 0; x < DAYS; ++x)
        cout << "$" << *(p + x) << " ";
    cout << endl;

    for(x = 0; x < DAYS; ++x)
        cout << "$" << *p << " ";
    cout << endl;

    return 0;
}
```

# Dynamic containers using pointers

- Limitation of array
    - Static size must be known at compile time
- Solution
    - Linked list
    - Each element has a pointer to the next
    - Use `new` and `delete` to grow and shrink list

``` cpp
struct Element
{
    int data;
    Element *next;
}
```

## Linked list example

- Don't forget to `.delete()` everything created using `new` when no longer needed

``` cpp
struct Node
{
    int data;
    Node *next;
};

int main()
{
    Node linkedList;

    // head
    linkedList.data = 1;
    // head.next
    linkedList.next = new Node();
    (*linkedList.next).data = 2;
    // head.next.next
    (*linkedList.next).next = new Node();
    (*(*linkedList.next).next).data = 3;
}
```

## Pointer notation for `struct` and `class`

- Writing `(*structInstance).structMember` is tedious
- Shortcut syntax
    - `structInstance->structMember`

``` cpp
int main()
{
    Node linkedList;

    // head
    linkedList.data = 1;
    // head.next
    linkedList.next = new Element();
    linkedList.next->data = 2;
    // head.next.next
    linkedList.next->next = new Element();
    linkedList.next->next->data = 3;
}
```

# Standard template library containers

- STL
- Defines template based reusable components
- Provides containers, iterators and algorithms
- Example `vector`

## `vector`

- Sequence container
- Similar to an array
- No need to declare number of elements
- Automatically increases size as needed
- Simpler syntax to retrieve number of elements
- Useful methods
    - `at(int)`
    - `push_back(value)`
    - `pop_back()`
    - `size()`
    - `clear()`
    - `empty()`

## `vector` in use

``` cpp
vector<Employee> employees;

Employee jim, john, jane;
jim.email = "jim@email.com";
john.email = "john@email.com";
jane.email = "jane@email.com";

// add them to vector
employees.push_back(jim);
employees.push_back(john);
employees.push_back(jane);

// print emails with for loop
for(auto employee : employees)
{
    cout << employee.email << endl;
}

// does not update jim's email in employees vector
john.email = "another@email.com";
```

## `vector` with pointers

``` cpp
vector<Employee*> employees;

Employee jim, john, jane;
jim.email = "jim@email.com";
john.email = "john@email.com";
jane.email = "jane@email.com";

// add them to vector
employees.push_back(&jim);
employees.push_back(&john);
employees.push_back(&jane);

// print emails with for loop
for(auto employee : employees)
{
    cout << employee.email << endl;
}

// jim's email is updated in employees vector
john.email = "another@email.com";
```

## Example usage


### Insert

- Inserting element into vector
    - `insert(position, value)`
    - `push_back()`
- Iterators
    - `begin()`
    - `end()`

``` cpp
insert(vector.begin(), 15);
```

### Sort

- `sort()`
    - Arranges vector in ascending order
    - Must have `#include <algorithm>`
    - Elements sorted in order depending on how the `<` is defined for the data type

``` cpp
sort(vector.begin(), vector.end());
```
- `reverse()`
    - Reverses order