# Arrays and strings

## Outline

- Arrays including `string` class
- Common errors with arrays

# Array

- Composite data type
- Consists of
    - Type specifier
    - Identifier
    - Dimension (subscript)
- Example
    - `double moneyCollected[5]`
    - Type `double`
    - Named `moneyCollected`
    - Of `5` elements
- Arrays define an ordered, homogenous sequence of data of constant length
- Subscript is an `int` or `int` expression
- Compiler reserves the required amount of space when program is compiled

# Declaring an array

``` cpp
// init array
int rent[4];
// populate elements in array, zero base
rent[0] = 250;
rent[1] = 375;
rent[2] = 460;
rent[3] = 600;

// alteratively
int rent[4] = {250, 375, 460, 600};
int rent[] = {250, 375, 460, 600};
int rent[4] = {250, 375} // rent[2] and rent[3] are null
int rent[1] = {250, 375} // overflow error
int rent[4] = {0}; // all elements are 0
```

# Accessing values within an array

``` cpp
rent[0] = 250;
cout << rent[0];
```

# Parallel arrays

- Multiple corresponding arrays which values are mapped to the same location within their respective array and are logically related

``` cpp
int partSize[] = {10, 20, 30, 40};
double partPrice[] = {1.29, 2.45, 5.99, 10.42};
// partSize[0] corresponds to partPrice[0] and so on...
```

# Array of `struct`

``` cpp
struct Person
{
    // Person fields...
}

Person people[5];
```

# 2D array

- One dimensional like single row with multiple columns
- Two dimensional like multiple rows with multiple columns
- Often called matrix or table

``` cpp
int values[3][4]; // 3 rows, 4 columns
int values[3][4] = {
    {1, 2, 3, 4},
    {5, 6, 7, 8},
    {9, 10, 11, 12}
}
// values[0][0] = 1
// values[0][1] = 2
// values[2][3] = 12
```

# Common pitfalls

- Forgetting arrays are zero based
- Accessing locations beyond array bounds
    - Exceed array bounds

# Strings

- String value expressed within `""`
- Can type two characters within single quote when they represent a single character
    - `'\n'`
- `"Hello"` is a `string` constant
- To store a value like `"Hello"` you must create a `string` variable by either
    - Creating a string as an array of `char`
    - Creating `string` using the `string` class defined in C++ standard library

# String as `char[]`

``` cpp
char firstName[] = "Mary";
char firstName[] = {"Mary"};
char firstName[5] = "Mary";
char firstName[5] = {"Mary"};
char firstName[5] = {'M', 'a', 'r', 'y', '\0'}; // '\0' == null

cout << firstName; // == Mary
cout << &firstName[1]; // == ary
```

## Pitfalls with String as `char[]`

- Trying to input a string with whitespace
- Trying to assign one string to another using assignment operator `=`
- Trying to compare strings using comparison operator
- Exceed array bounds

## Issues with strings as `char[]`

- Cumbersome process
- Must be aware of `null` `char`
- Needs special functions to assign/compare values
- Its possible/easy to overflow array

``` cpp
int main()
{
    const int SIZE = 10;
    char name[SIZE];

    cout << "Enter a name: ";
    cin >> name;
    cout << "You entered: " << name << endl;

    return 0;
}
// Entering name "Mary Ann"
// will result in printing "Mary" as result
// the "Ann" and newline are left in input buffer

// This can be fixed by using cin.getline()
int main()
{
    const int SIZE = 10;
    char name[SIZE];

    cout << "Enter a name: ";
    cin.getline(name, SIZE); // get entire line
    cout << "You entered: " << name << endl;

    return 0;
}
```

## `strcpy()`

``` cpp
char president[] = "Eric";
char vicePresident[] = "Ann";

president = vicePresident; // won't work

// alternative is to assign each element
president[0] = vicePresident[0];
president[1] = vicePresident[1];

// nope... just use strcpy
strcpy(president, vicePresident);
// needs #include <string>
```

## `strcmp()`

- Strings and `==` operator does not work
- Use `strcmp()` instead

``` cpp
if(strcmp(president, vicePresident) == 0) // equals
if(strcp(president, vicePresident) < 0) // president < vicePresident
```

# `string` class

- Built in C++ class simplifies string handling
- `#include <string>`
- `=` and `==` operators work as expected
- More memory locations are assigned as needed for longer values
    - Avoids array overflow

``` cpp
#include <iostream>
#include <string>

using namespace std;

int main()
{
    string firstPersonName = "Mary";
    string secondPersonName = "Diane";

    // can do comparisons without strcmp()
    if(firstPersonName != secondPersonName)
        doSomeAction();
    
    // can assign without strcpy()
    firstPersonName = "Joanne";

    return 0;
}
```

## `getline()`

- Shouldn't use `cin` to read an entire line of text
- `cin >> someVar;` uses stream extractor operator `>>`
    - Reads `char` until first whitespace found
    - Won't work if whitespace provided in input
- Use `getline()` when using `#include <string>`

``` cpp
string string1;
getline(cin, someVar, '\n');

string string1 = "this is";
string string2 = "what a string class";
string string3 = string1 + string2;
string3 += "can do.";
```

## `string` comparisons

- Act like you'd expect
- Use `==` operator

``` cpp
string password;
getline(cin, password, '\n');

if(password == "xyzzy")
    cout << "Password correct" << endl;
else
    cout << "Password incorrect" << endl;
```

## `string` length

- `length()` or `size()`
- Members of `string` class
- Returns number of `char` in `string`

``` cpp
string someString = "ten chars.";
int length = someString.length() // or .size()

for(int i = 0; i < length; i++)
{
    cout << someString[i];
}
```

## `string` methods

### `find(string pattern, int index)`

``` cpp
int find(string pattern, int index)
{
    // pattern = the target to find
    // index = the index to start searching
    // returns index of first occurrence of pattern
        // if pattern not found, returns string::npos -1
}
```

### `rfind(string pattern, int index)`

- Same as `find()` but starts and `r`ight end
- Search backwards from right

### `substr(int start, int end)`

- Returns substring starting from first index through to second

``` cpp
string someString = "012345";
string subString = someString.substr(0, 2);
// subString == "012"
```

### `erase(int start, int end)`

- Erases substring

``` cpp
string someString = "Hello World";
someString.erase(0, 6); // someString == "World"
```

### `insert(int index, string word)`

- Inserts `word` starting at `index`

``` cpp
string someString = "World";
someString.insert(0, "Hello "); // someString == "Hello World"
```