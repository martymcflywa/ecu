# Loops

## Overview

- `while` loop
- Common loop usage
- Accumulate totals
- Loop pitfalls
- `for` loop
- Range based `for` loop (C++ 11)
- Pre/post test loops
- Nest loops
- `struct`s in loops

# `while` loop

``` cpp
// while (bool expression)
//      { action while expression is true; }

const auto NUM_LOOPS = 5;

while(count < NUM_LOOPS)
{
    cout << "Hello!" << endl;
    ++count;
}
```

# Common loop usage

- Commonly used for
    - Input validation
    - Reading input records

## Input validation

- Instead of the standard input validation

``` cpp
cin >> response;
if(response != 'T' && response != 'F')
{
    cout << "Invalid response" << endl;
}
if (response == 'T')
    cout << "True" << endl;
else
    cout << "False" << endl;
```

- Use a `while` loop to repeat until correct response is provided

``` cpp
cin >> response;
while(response != 'T' && response != 'F')
{
    cout << "Invalid response" << endl;
    cin >> response;
}
if (response == 'T')
    cout << "True" << endl;
else
    cout << "False" << endl;
```

## Reading input records

``` cpp
int itemNumber;
double price;
double discountAmount;
double newPrice;
const double RATE = 0.2;

cout << "Enter item number or 0 to quit: ";
cin >> itemNumber;

while(itemNumber != 0) // exit point for user if they enter 0
{
    cout << "Enter price for item " << itemNumber << " ";
    cin >> price;
    // ... 
}
```

# Accumulating totals

- Through each iteration, total is calculated as current value plus new purchase cost

``` cpp
const int QUIT = 0;
double purchase, total = 0;

cout << "Enter amount of first purcashe $";
cin >> purchase;

while(purchase != QUIT)
{
    total += purchase;
    cout << endl << "Enter amount of next purchase or " <<
    QUIT << " to quit";
    cin >> purchase;
}

cout << endl << "Your total is $" << total;
```

# Loop pitfalls

- Adding unwanted semicolon `;`
    - Can lead to an empty loop body
    - Infinite loop
    - `ctrl + c` to close program
- Forgetting curly braces `{}`
- Failing to alter a loop control variable
- Failing to initialize a loop control variable
- Making the same mistakes as with selections

## Adding unwanted semicolon `;`

``` cpp
int number = 1;
while(number <= 10); // <- semicolon here ends the expression
// stuff in curly braces ignored, will infinite loop
{
    cout << number << endl;
    ++number;
}
```

## Forgetting curly braces `{}` or alter loop control variable

``` cpp
int number = 1;
while(number <= 10) // <- no curly braces
    cout << number << endl; // only this line will be evaluated as part of the loop
    ++number; // altering the loop control variable won't be executed part of the loop
    // infinite loop
```

## Failing to initialize a loop control variable

``` cpp
int number; // <- probably a compile error?
while(number <= 10)
{
    cout << number << endl;
    ++number;
}
```

# `for` loop

``` cpp
// for (intialize; evaluate; alter)
    // { statement that executes when evaluation is true; }

// while example
int count = 1;
while (count < 4)
{
    cout << count << " ";
    ++count;
}

// for example
for(int count = 1; count < 4; ++count)
{
    cout << count << " ";
}
```

## `for` loop searching and substring example

``` cpp
string input, pattern = "hello";
int appearances = 0;

for(int i = input.find(patter, 0); i != string::npos; i = input.find(pattern, i))
{
    appearances++;
    i++;
}

cout << "Your string " << pattern << " appeared " << appearances << " times" << endl;
```

## `for` loop through arrays

``` cpp
const int NUM_PRICES = 10;
double price[NUM_PRICES];

for(int sub = NUM_PRICES - 1; sub >= 0; --sub)
    cout << price[sub]; << " ";
```

### Using part of an array

- When you want to access a single array element
    - Use a subscript `[i]`
- When you want to access all of the elements in array
    - Use a `for` loop
- When you want to access some elements
    - Use a `while` loop

# Range based `for` loop (C++ 11)

- Used to loop through collections, accessing each element once

``` cpp
// for(for-range-declaration : expression)

double numbers[10]; // initialise with values

for (double number : numbers)
{
    cout << number << endl;
}
```

# Loop types

## Count controlled

- Controlled by counting number of iterations

``` cpp
for(int i = 0; i < length; i++)
``

## Pre test

- Control variable tested before loop body
- `for`
- `while`

## Post test

- Control variable tested after loop body
- `do-while`

# Pre vs. post test loop

``` cpp
// pre test
int count = 1;
while(count < 1)
{
    cout << count << endl;
    ++count;
}

// post test
int count = 1;
do 
{
    cout << count << endl;
    ++count;
}
while(count < 1);
```

# Nested loops

- A loop inside a loop
- Outer loop contains another
- Inner loop contained inside outer loop
    - Within each iteration through outer loop, inner loop executes to completion

``` cpp
for(int i = 0; i < word.length(); i++)
{
    for(int j = 0; j < word.length(); j++)
    {
        // for every i iteration, j iterates to word.length
    }
}
```
