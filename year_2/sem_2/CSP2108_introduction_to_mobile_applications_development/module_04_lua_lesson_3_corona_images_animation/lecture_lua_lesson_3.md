# Lua lesson 3

## Overview

- Control structures
- Blocks
- More about functions

# Control structures

- So far all programs have been sequence of commands
    - Statements
- More complicated programs need ways to control which statements are executed
    - And how many times
- Lua has
    - `if`,`then`,`else`
    - `while`
    - `repeat`
    - `for`

## `if`, `then`, `else`

- Provides a way to decide whether to execute a statement or not
    - Selection

### `if`

``` lua
a = 9 - math.pow(100, 0.5);

if a < 0 then
    a = 0;
end

print(a); -- result: 0
```

- Syntax:
    - `if` condition `then` statement `end`
- The **condition** is evaluated
    - If the value is anything other than `false` or `nil`, then the **statement** is executed

### `if` `then` `else`

``` lua
a = 9;
b = math.pow(100, 0.5);

if a < b then
    print(a);
else
    print(b);
end -- output: 9
```

- Syntax:
    - `if` condition `then` statement1 `else` statement2 `end`
- The **condition** is evaluated
    - If the value is `true`, **statement1** is executed
    - Otherwise **statement2** is executed
- Can nest `if` within other `if` blocks

### `elseif`

``` lua
op = "/";

if op == "+" then
    r = a + b;
elseif op == "-" then
    r = a - b;
elseif op == "/" then
    r = a / b;
end

print(r); -- output: 0.9
```

# Blocks

- Can have more than one statement inside `if` block

``` lua
if r < 1 then
    print("r < 1"); -- output: r < 1
    print("because " .. a .. " is less than " .. b); -- output: because 9 is less than 10
end
```

- The two statements between `then` and `end` for a block
- If the condition is `true`
    - All statements in the block are executed

## More blocks

- We will see more blocks
    - Function bodies
    - `repeat`
    - `while`
    - `for`
- Variables declared as local inside a block are scoped inside the block
- Can **jump out** of a block using `break`

## Block example

``` lua
i = 1;
x = 10;

if i < 20 then
    local x = 20;
    print(x); -- output: 20
else
    print(x); -- output: 10
end
print(x); -- output: 10
```

## `break` example

``` lua
local i = 0;

while a[i] do
    if a[i] == v then
        break;
    end
    i = i + 1;
end
```

- `if a[i] == v` is `true`, program *jumps out* of the `while` loop
- What does this code snippet do?
    - Iterates over array `a` until array element `== v`

## `repeat`

- This is one way to have a sequence of steps repeated over and over
    - As many times as needed
- Syntax:
    - `repeat` statements `until` condition
- The statements are executed
    - Then the condition is evaluated
- If the value is `false` or `nil`
    - The statements are executed again
    - The condition is evaluated again
- Repeat

### `repeat` example

``` lua
-- get input from file
local path = system.pathForFile("main.lua", system.ResourceDirectory);

-- system.ResourceDirectory is where app assets like images/sound are located.
-- Also where source files are in the simulator.
-- Won't work on device as main.lua won't be copied to it.
-- system.pathForFile() creates an absolute path to file

io.input(path);
-- io.input changes where input comes from. Usually this would be the console, STDIN,
-- but this doesn't make sense on a mobile device, so the simulator doesn't provide console input.

-- keep reading lines until a non-empty line is input
local line;
repeat
    line = io.read("*line");
    -- io.read("*line") reads the next line from the input file.
until line ~= ""

print(line); -- prints first non-empty line
```

## `while`

- Also repeats steps
- Syntax:
    - `while` condition `do` statements `end`
- The condition is evaluated. If `true`, statements are executed
- Condition is evaluated again
- Repeat

### `while` example

``` lua
local primes = { 2, 3, 5, 7, 11, 13 };
local i = 1;

while primes[i] do
    print(primes[i]);
    i = i + 1;
end
```

## Numeric `for` loop

``` lua
-- prints numbers from 10 to 1
-- counts backwards with -1
for i = 10, 1, -1 do
    print(i);
end
```

- Prints numbers from 10 to 1
    - Counts backwards `-1`
- Syntax:
    - `for` var = exp1, exp2, exp3 `do` statements `end`
- **var** is a local variable
    - **exp1** sets starting point for **var**
    - After each iteration, **var** is dec/incremented by **exp3**
        - Until **var** equals **exp2**
- **exp3** can be omitted
    - Defaults to `1`

### Numeric `for` example

``` lua
local a = { 12, -1, 67, 2 };
print("The elements of a are ")
for i = 1, #a do
    print(a[i]);
end

print("The first interesting number is ")
for i = 1, math.huge do
    if (0.3 * i ^ 3 - 20 * i ^ 2 - 500 >= 0) then
        print(i); -- output: 68
        break;
    end
end
```

# More about functions

- First class objects in Lua
- Have some unusual and useful features

## Multiple returns

- Functions can return more than one result

``` lua
local s, e = string.find("we are learning about mobile apps", "mobile")
-- string.find() returns start and end point of "mobile" in string
print(s, e); -- output: 23 28
```

``` lua
local function arraymax(a)
    local maxi = 1;
    local max = a[maxi];
    for i = 2, #a do
        if a[i] > max then
            maxi = i;
            max = a[i];
        end
    end
    return max, maxi
end

print(arraymax({ 10, 30, 20 })); -- output: 30 2
```

## Quick quiz

``` lua
local function depack(t, i)
    i = i or 1; -- default to 1 if i nil
    if t[i] then
        return t[i], depack(t, i + 1); -- recursive
    end
end

print(depack({ 10, 20, 30 })) -- what does this print?
-- Answer: 10 20 30
-- function already defined in lua lib, called unpack()
```

## Variable number of parameters

- Functions can have variable number of parameters
- `print(1)` or `print(a, b)`
- Will look at how to write functions with variable number of arguments in next lecture