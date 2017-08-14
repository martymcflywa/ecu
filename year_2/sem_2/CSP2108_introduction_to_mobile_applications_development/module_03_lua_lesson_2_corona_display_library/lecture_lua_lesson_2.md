# Lua lesson 2

## Overview

- Tables
- Functions
- Objects and methods

# Tables

- Tables store/retrieve values associated with a key

``` lua
frequency = {}; -- creates a new table
-- add values for keys "red", "orange" etc.
frequency["red"] = 428;
frequency["orange"] = 484;
frequency["yellow"] = 517;
frequency["green"] = 566;
frequency["blue"] = 638;
frequency["indigo"] = 676;
```

## Table constructors

- No quotes used for keys

``` lua
frequency = {
    red = 428,
    orange = 484,
    yellow = 517,
    -- ...
    indigo = 676
}
```

- Can also use **one-based** array reference

``` lua
rainbow = {
    "red",
    "orange",
    "yellow",
    -- ...
    "indigo"
}

print(rainbow[1]) -- red
print(rainbow[2]) -- orange
```

- Can use 
    - `;` instead of `,`
    - Trailing `,`

``` lua
-- this is ok
rainbow = {
    "red",
    "orange",
    "yellow",
    -- ...
    "indigo",
}
```

## Table quiz

- What does the following print?

``` lua
print("Approximate frequencies for colours")
print(rainbow[1] .. " = " .. frequency[rainbow[1]])
print(rainbow[2] .. " = " .. frequency[rainbow[2]])
print(rainbow[3] .. " = " .. frequency[rainbow[3]])
print(rainbow[4] .. " = " .. frequency[rainbow[4]])
print(rainbow[5] .. " = " .. frequency[rainbow[5]])
print(rainbow[6] .. " = " .. frequency[rainbow[6]])
print(rainbow[7] .. " = " .. frequency[rainbow[7]])
```

```
// output
Approximate frequencies for colours
red = 428
orange = 484
yellow = 517
green = 566
blue = 638
indigo = 676
violet = 714
```

## Length `#` operator

- Tables with integer keys behave like arrays
- The `#` operator returns the length of the array
    - Table **must**
        - Start at index `1`
        - Have no holes
- `#` also returns length of a string

# Objects are tables

- Tables are different from other variables
    - Like booleans and numbers
- Variables are used to **point to** or **refer to** tables

## Object as table example

``` lua
a = {};
a["x"] = 10;
b = a -- b refers to the same table as a
print(b["x"]) -- output: 10
b["x"] = 20;
print(a["x"]) -- output: 20
a = nil -- only b still refers to the table
b = nil -- now no variables reference the table
```

# Functions

- Are used to group together useful, reusable sequences of statements
- `print()` is an example of a function
- May be called **procedures** or **subroutines** in other languages
- Functions are **first-class** entities in Lua
    - Makes them useful and flexible
- They can be
    - Assigned to variables
    - Passed as parameters
    - Returned as results

## Simple function example

``` lua
function sum(a, b, c)
    return a + b + c;
end

-- calling sum()
x = sum(5, 10, 15); -- x = 30
```

- `a`, `b` and `c` are the function's **formal** parameters
- Supply values for the parameters to call the function
- `5`, `10` and `15` are **actual** parameters
    - Matches up with `a`, `b` and `c`.

## Function return values

- Actual parameters used in the calculations **inside** the function
    - Function body
- The result of the calculation is specified using the **return** statement

## Local variables

- Another way to write the function

``` lua
function sum(a, b, c)
    local total = a + b;
    total = total + c;
    return total
end
```

- Function bodies can have more than one statement
- `total` is a **local** variable
    - Scope of `total` is only inside the function `sum()`
- Other variables are **global**

## Function syntax

``` lua
function sum(a, b, c)
    return a + b + c;
end

-- same as
sum = function(a, b, c)
    return a + b + c;
end
```

## Function as table entry

- Functions can be used the same way as table values

``` lua
account = {};
account.owner = "fred";
account.balance = 100;
account.interestOn = function(amount)
        return amount * 0.0025;
    end

print(account.interestOn(40)) -- output: 0.1
```

## Libraries are tables of functions

- In Corona SDK, `display` is a library
- `display.contentCenterX` is a table entry
    - Key: `contentCenterX`
    - Value: numeric value
- These are called properties
- `display.newText` is a table entry
    - Key: `newText`
    - Value: a function

# Objects

- Objects are tables with properties and special functions
- Lua can support object oriented programming
- An **object** is an entity with attributes and methods
    - Attributes
    - Behaviours
- You can simulate objects using tables
    - Properties/attributes
        - Numbers
        - Strings
        - Booleans
        - Tables
    - Special functions that act like methods

## Object example

- In Corona SDK, `display.newText()` returns an object to the caller

``` lua
-- create a text object
helloText = display.newText("Hello World", 100, 200, "Arial", 16);
-- method call to change colour of text to green/blue
helloText:setFillColor(0, 1, 1)
-- move text 10 units to the left
helloText:translate(helloText, -10, 0)
print(helloText.x) -- output: 90
```

- Using `:` instead of `.` is the same as passing the object itself as an extra initial parameter
    - This kind of function is called a **method**
- `helloText` is an object
    - A `TextObject`
    - It has
        - Properties (attributes)
        - Functions (methods)

## Object quiz

``` lua
START_SIZE = 20
END_SIZE = 100

animatedHello = display.newText(
    "Hi hi hi",
    display.contentCenterX, 
    display.contentCenterY, 
    "Arial", 
    START_SIZE)

allDone = function()
    animatedHello.rotation = 0
    animatedHello:setFillColor(0, 1.0, 1.0)
end

rotate = function()
    transition.to(animatedHello, 
    {time = 1500, rotation = 359, onComplete = allDone})
end

transition.to(
    animatedHello, 
    {time = 1500, delay = 500, size = END_SIZE, onComplete = rotate})
```

1. What are the global variables
    - `START_SIZE`
    - `END_SIZE`
    - `animatedHello`
    - `allDone`
    - `rotate`
2. What functions are defined
    - `allDone`
    - `rotate`
3. What objects are created
    - `animatedHello`
4. What methods are called
    - `animatedHello:setFillColor()`
5. What is `{time = 1500, delay = 500, size = END_SIZE, onComplete = rotate}`
    - A table
6. What is `transition`
    - A Corona SDK library
    - https://docs.coronalabs.com/api/library/transition/index.html