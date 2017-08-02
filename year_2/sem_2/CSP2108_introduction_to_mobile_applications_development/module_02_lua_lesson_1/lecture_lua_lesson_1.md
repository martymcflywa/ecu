# Lua lesson 1

## Lua

- Easy to learn
- Scripting language
- Used for many purposes
- Widely used for video games
- Used by Corona SDK
- Designed in 1993
- Aimed to be very extensible
    - Using libraries

## Summary

- Program structure
- Statements and lines
- Variables
- Data types
- Expressions
- Strings
- Comments

## Program structure

- Lua programs are a sequence of commands
    - Statements
- When program executes, commands are carried out in the specified sequence
- Programs can include comments
    - Do not do anything but meant for human reader
    - Helps understand the program

``` lua
-- this is a lua comment
print("Hello World") -- statement
```

## Statements and lines

- You can have zero or more statements on a single line
- Can be separated by `;`

``` lua
print("Hello") print("World")
print("It's"); print("me!")
```

Output:

```
Hello
World
It's
me!
```

## Variables

- Data can be stored in variables
- Example below stores the value `10` in the variable `myVariable`

``` lua
myVariable = 10
```

- Can be used in other statements
- Example

``` lua
print(myVariable) -- prints "10"
```

### Naming variables

- Can use own variable names
- Choose meaningful names
- Cannot be a reserved word

``` lua
-- lua reserved words
and
break
do
else
elseif
end
false
for
function
if
in
local
nil
not
or
repeat
return
then
true
until
while
```

- Variable names can be any string of letters, digits and underscores
    - Must not start with a digit

``` lua
-- example variable names
x5 = "x5"
temperature = 15
totalCost = 400
_INPUT = "test"
```

## Data types

- Lua has 8 data types
    - `nil`
    - Boolean
    - Number
        - All numbers are float
    - String
    - Userdata
    - Function
    - Thread
    - Table
        - Associative array

### `nil`

- Special type
- Only one possible value
    - `nil`
    - Like `null`
    - Non value
- Until variables have been assigned, they have value `nil`

### Boolean

- Has two possible values
    - `true`
    - `false`
- Used for control statements

### Number

- Any real number
    - Double precision float
- Example values
    - `4`
    - `-0.4`
    - `4.47e-3`
        - 4.57 * 10^-3
        - 0.00457

### String

- Sequence of characters
- Example values
    - `"two words"`
    - `"125"`
    - `"three words!"`

### Function

- Group statements together to create new commands

### Table

- Associative arrays
- Values stored are retrieved by its key
- Created by using a table constructor

``` lua
-- create empty table
table = {}

-- table example
k = "x"
-- adds new entry to table, key = "x", value = 10
table[k] = 10
-- add new entry to table, key = 20 (index), value = "great"
table[20] = "great"

print(table["x"]) -- output: 10
k = 20;
print(table[table(k)]) -- output: "great"
```

### Dot notation

- Instead of `[]`, elements can be accessed with `.`

``` lua
-- dot notation example
table.x = 10 -- same as table["x"] = 10
print(table.x) -- same as print(table["x"])

-- a.x is same as a["x"]
-- but not same as a[x]
```

### Using table as arrays

- Some languages use `[]` for arrays
- In lua, arrays can be created by using intgers as keys
- Index starts at `1`
- Can leave holes in array
    - Store values for keys `1`, `2` and `4`
        - But not for `3`
    - Can cause confusion
    - Should be avoided

## Expressions

- Used to describe calculations
- New data values are calculated by applying operators to old data values

### Arithmetic operators

- `+` addition
- `-` subtraction or negation
- `*` multiplication
- `/` division
- `%` mod
- `^` exponentation

#### Addition example

``` lua
breakfastCalories = 400
lunchCalories = 350
dinnerCalories = 750
totalCalories = breakfastCalories + lunchCalories + dinnerCalories

print(totalCalories) -- output = 1500
```

- `+` is the operator
- Values on either side are called **operands**
- Can be
    - Variables
    - Literal values
    - Expressions
- `+` is a binary operator
    - Uses two operands

#### Subtraction example

``` lua
foodCalories = 1500
exerciseCalories = 250
netCalories = foodCalories - exerciseCalories

print(netCalories) -- output = 1250
```

#### Multiplication example

``` lua
costPerLitre = 1.23
litres = 52.5
totalCost = costPerLitre * litres

print(totalCost) -- output = 64.575
```

#### Division example

``` lua
chocolatePieces = 35
familyMembers = 3
piecesPerPerson = chocolatePieces / familyMembers

print(piecesPerPerson) -- output = 11.6666666667
```

#### Mod example

``` lua
chocolatePieces = 35
familyMembers = 3
piecesLeftOver = chocolatePieces % familyMembers

print(piecesLeftOver) -- output = 2
```

#### Exponentiation example

``` lua
areaOfSquare = 100
lengthOfSide = areaOfSquare ^ 0.5 -- square root

print(lengthOfSide) -- output = 10
```

#### Negation example

``` lua
youOweMe = 20
IOweYou = -youOweMe

print(IOweYou) -- output = -20
```

#### Complex expressions

``` lua
x = 5
y = 5 + x ^ 2 * 8
print(y) -- output = 205

-- same as y = 5 + ((x ^ 2) * 8)
-- 5 ^ 2 = 25
-- 25 * 8 = 200
-- 5 + 200 = 205
```

#### Arithmetic operator precedence

1. `^`
2. `-` negation
3. `*`, `/`, `%` in left to right order
4. `+`, `-` in left to right order
5. Precedence modified with `()`

### Relational operators

- Compares two values
- `<` less than
- `>` greater than
- `<=` less than or equal to
- `>=` greater than or equal to
- `==` equal to
- `~=` not equal to

#### Relational operator examples

``` lua
x = 5
y = 5
z = 6

b = x < y -- false
b = x == y -- true
b = x <= y -- true
b = x < z -- true
b = x == z -- false
b = x ~= z -- true
```

### Logical operators

- Used for evaluating boolean values
- `and`
- `or`
- `not`
- Can also be used on other data types
- `nil`, `false` considered false
- Everything else is `true`

#### `and`

- Returns first operand if `false`
- Else returns second operand

``` lua
b = false and true -- false
b = true and true -- true
b = 5 and true -- true
b = 5 and 4 -- 4
b = nil and 4 -- nil
```

#### `or`

- Returns first operand if `not false`
- Else returns second operand

``` lua
x = 3
y = 2
max = (x > y) and x or y -- finds max
```

#### `not`

- Returns either `true` or `false`

``` lua
print(not nil) -- true
print(not false) -- true
print(not 0) -- false
```

### Concatenation operator

- Join strings together
- `..`

``` lua
print("Hello " .. "World") -- Hello World
print(0 .. 1) -- 01
```

### Operator precedence

- Expressions can use all above operators together
    - Uses precedence order
- When precedence is equal
    - Calculate left to right
    - Except for `^`

1. `^`
2. `not`, `-(unary)`
3. `*`, `/`, `%`
4. `+`, `-`
5. `..`
6. `<`, `>`, `<=`, `>=`, `~=`, `==`
7. `and`
8. `or`

### Expression examples

``` lua
a + i < b / 2 + 1 -- == (a + i) < ((b / 2) + 1)
a < y and y <= z -- == (a < y) and (y <= z)
-x ^ 2 -- == -(x ^ 2)
x ^ y ^ z -- == x ^ (y ^ z)
```

## Strings

- Can be delimited using
    - `" "`
    - `' '`
    - `[[ ]]`

``` lua
string = "A string"
string = 'Another string'
string = 'She said "hello"'
string = [[is it "this" or 'that'?]]

multilineString = [[
    this
    is a
    multiline
    string
]]
```

### Coercion

- Converts as needed
    - Numbers to strings
    - Strings to numbers

``` lua
print("10" + 1) -- 11
print("hello" + 1) -- error
print(10 .. 20) -- 1020
print("hello" .. 1) -- hello1
```

### Special characters

``` lua
"\a" -- bell
"\b" -- backspace
"\f" -- formfeed
"\n" -- newline
"\r" -- carriage return
"\t" -- tab
"\v" -- vertical tab
"\\" -- backslash
"\"" -- double quote
"\'" -- single quote

print("first line\nsecond line\n\"third line in quotes\")
```

### Length operator

- Returns length of
    - String
    - Table
- `#`

``` lua
a = "hello"
print(#a) -- 5
```

## Comments

``` lua
-- single line comment

--[[
    multi
    line
    comment
]]

---[[
print(10) -- not commented
--]]

--[[
print(10) -- commented/deactivated
]]
```